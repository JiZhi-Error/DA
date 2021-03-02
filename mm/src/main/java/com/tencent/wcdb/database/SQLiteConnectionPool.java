package com.tencent.wcdb.database;

import android.os.SystemClock;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.OperationCanceledException;
import com.tencent.wcdb.support.PrefixPrinter;
import java.io.Closeable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SQLiteConnectionPool implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteConnectionPool.class.desiredAssertionStatus());
    public static final int CONNECTION_FLAG_INTERACTIVE = 4;
    public static final int CONNECTION_FLAG_PRIMARY_CONNECTION_AFFINITY = 2;
    public static final int CONNECTION_FLAG_READ_ONLY = 1;
    private static final long CONNECTION_POOL_BUSY_MILLIS = 3000;
    private static final int OPEN_FLAG_REOPEN_MASK = 268435473;
    private static final String TAG = "WCDB.SQLiteConnectionPool";
    private final WeakHashMap<SQLiteConnection, AcquiredConnectionStatus> mAcquiredConnections = new WeakHashMap<>();
    private final ArrayList<SQLiteConnection> mAvailableNonPrimaryConnections = new ArrayList<>();
    private SQLiteConnection mAvailablePrimaryConnection;
    private volatile SQLiteChangeListener mChangeListener;
    private volatile SQLiteCheckpointListener mCheckpointListener;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final AtomicBoolean mConnectionLeaked = new AtomicBoolean();
    private ConnectionWaiter mConnectionWaiterPool;
    private ConnectionWaiter mConnectionWaiterQueue;
    private final WeakReference<SQLiteDatabase> mDB;
    private boolean mIsOpen;
    private final Object mLock = new Object();
    private int mMaxConnectionPoolSize;
    private int mNextConnectionId;
    private byte[] mPassword;
    private volatile SQLiteTrace mTraceCallback;

    static {
        AppMethodBeat.i(3088);
        AppMethodBeat.o(3088);
    }

    static /* synthetic */ void access$100(SQLiteConnectionPool sQLiteConnectionPool, ConnectionWaiter connectionWaiter) {
        AppMethodBeat.i(3087);
        sQLiteConnectionPool.cancelConnectionWaiterLocked(connectionWaiter);
        AppMethodBeat.o(3087);
    }

    /* access modifiers changed from: package-private */
    public enum AcquiredConnectionStatus {
        NORMAL,
        RECONFIGURE,
        DISCARD;

        public static AcquiredConnectionStatus valueOf(String str) {
            AppMethodBeat.i(3042);
            AcquiredConnectionStatus acquiredConnectionStatus = (AcquiredConnectionStatus) Enum.valueOf(AcquiredConnectionStatus.class, str);
            AppMethodBeat.o(3042);
            return acquiredConnectionStatus;
        }

        static {
            AppMethodBeat.i(3043);
            AppMethodBeat.o(3043);
        }
    }

    private SQLiteConnectionPool(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2) {
        AppMethodBeat.i(3045);
        this.mDB = new WeakReference<>(sQLiteDatabase);
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        setMaxConnectionPoolSizeLocked(i2);
        AppMethodBeat.o(3045);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(3046);
        try {
            dispose(true);
        } finally {
            super.finalize();
            AppMethodBeat.o(3046);
        }
    }

    public static SQLiteConnectionPool open(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        AppMethodBeat.i(3047);
        SQLiteConnectionPool open = open(sQLiteDatabase, sQLiteDatabaseConfiguration, bArr, sQLiteCipherSpec, 1);
        AppMethodBeat.o(3047);
        return open;
    }

    public static SQLiteConnectionPool open(SQLiteDatabase sQLiteDatabase, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2) {
        AppMethodBeat.i(3048);
        if (sQLiteDatabaseConfiguration == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("configuration must not be null.");
            AppMethodBeat.o(3048);
            throw illegalArgumentException;
        }
        SQLiteConnectionPool sQLiteConnectionPool = new SQLiteConnectionPool(sQLiteDatabase, sQLiteDatabaseConfiguration, i2);
        sQLiteConnectionPool.mPassword = bArr;
        sQLiteConnectionPool.mCipher = sQLiteCipherSpec == null ? null : new SQLiteCipherSpec(sQLiteCipherSpec);
        sQLiteConnectionPool.open();
        AppMethodBeat.o(3048);
        return sQLiteConnectionPool;
    }

    private void open() {
        AppMethodBeat.i(3049);
        this.mAvailablePrimaryConnection = openConnectionLocked(this.mConfiguration, true);
        this.mIsOpen = true;
        AppMethodBeat.o(3049);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        AppMethodBeat.i(3050);
        dispose(false);
        AppMethodBeat.o(3050);
    }

    private void dispose(boolean z) {
        AppMethodBeat.i(3051);
        if (!z) {
            synchronized (this.mLock) {
                try {
                    throwIfClosedLocked();
                    this.mIsOpen = false;
                    closeAvailableConnectionsAndLogExceptionsLocked();
                    int size = this.mAcquiredConnections.size();
                    if (size != 0) {
                        Log.i(TAG, "The connection pool for " + this.mConfiguration.label + " has been closed but there are still " + size + " connections in use.  They will be closed as they are released back to the pool.");
                    }
                    wakeConnectionWaitersLocked();
                } finally {
                    AppMethodBeat.o(3051);
                }
            }
            return;
        }
        AppMethodBeat.o(3051);
    }

    public final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z = true;
        AppMethodBeat.i(3052);
        if (sQLiteDatabaseConfiguration == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("configuration must not be null.");
            AppMethodBeat.o(3052);
            throw illegalArgumentException;
        }
        synchronized (this.mLock) {
            try {
                throwIfClosedLocked();
                boolean z2 = ((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 536870912) != 0;
                if (z2) {
                    if (!this.mAcquiredConnections.isEmpty()) {
                        IllegalStateException illegalStateException = new IllegalStateException("Write Ahead Logging (WAL) mode cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                        AppMethodBeat.o(3052);
                        throw illegalStateException;
                    }
                    closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
                }
                if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled == this.mConfiguration.foreignKeyConstraintsEnabled) {
                    z = false;
                }
                if (!z || this.mAcquiredConnections.isEmpty()) {
                    if (((this.mConfiguration.openFlags ^ sQLiteDatabaseConfiguration.openFlags) & OPEN_FLAG_REOPEN_MASK) != 0 || !DatabaseUtils.objectEquals(this.mConfiguration.vfsName, sQLiteDatabaseConfiguration.vfsName) || !sQLiteDatabaseConfiguration.extensions.containsAll(this.mConfiguration.extensions)) {
                        if (z2) {
                            closeAvailableConnectionsAndLogExceptionsLocked();
                        }
                        SQLiteConnection openConnectionLocked = openConnectionLocked(sQLiteDatabaseConfiguration, true);
                        closeAvailableConnectionsAndLogExceptionsLocked();
                        discardAcquiredConnectionsLocked();
                        this.mAvailablePrimaryConnection = openConnectionLocked;
                        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                        setMaxConnectionPoolSizeLocked(0);
                    } else {
                        this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
                        setMaxConnectionPoolSizeLocked(0);
                        closeExcessConnectionsAndLogExceptionsLocked();
                        reconfigureAllConnectionsLocked();
                    }
                    wakeConnectionWaitersLocked();
                } else {
                    IllegalStateException illegalStateException2 = new IllegalStateException("Foreign Key Constraints cannot be enabled or disabled while there are transactions in progress.  Finish all transactions and release all active database connections first.");
                    AppMethodBeat.o(3052);
                    throw illegalStateException2;
                }
            } finally {
                AppMethodBeat.o(3052);
            }
        }
    }

    public final SQLiteConnection acquireConnection(String str, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3053);
        long uptimeMillis = SystemClock.uptimeMillis();
        SQLiteConnection waitForConnection = waitForConnection(str, i2, cancellationSignal);
        SQLiteTrace sQLiteTrace = this.mTraceCallback;
        if (sQLiteTrace != null) {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            SQLiteDatabase sQLiteDatabase = this.mDB.get();
            if (sQLiteDatabase != null) {
                sQLiteTrace.onConnectionObtained(sQLiteDatabase, str, uptimeMillis2, (i2 & 2) != 0);
            }
        }
        AppMethodBeat.o(3053);
        return waitForConnection;
    }

    public final void releaseConnection(SQLiteConnection sQLiteConnection) {
        AppMethodBeat.i(3054);
        synchronized (this.mLock) {
            try {
                AcquiredConnectionStatus remove = this.mAcquiredConnections.remove(sQLiteConnection);
                if (remove == null) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                    AppMethodBeat.o(3054);
                    throw illegalStateException;
                } else if (!this.mIsOpen) {
                    closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                } else if (sQLiteConnection.isPrimaryConnection()) {
                    if (recycleConnectionLocked(sQLiteConnection, remove)) {
                        if ($assertionsDisabled || this.mAvailablePrimaryConnection == null) {
                            this.mAvailablePrimaryConnection = sQLiteConnection;
                        } else {
                            AssertionError assertionError = new AssertionError();
                            AppMethodBeat.o(3054);
                            throw assertionError;
                        }
                    }
                    wakeConnectionWaitersLocked();
                } else if (this.mAvailableNonPrimaryConnections.size() >= this.mMaxConnectionPoolSize - 1) {
                    closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                } else {
                    if (recycleConnectionLocked(sQLiteConnection, remove)) {
                        this.mAvailableNonPrimaryConnections.add(sQLiteConnection);
                    }
                    wakeConnectionWaitersLocked();
                }
            } finally {
                AppMethodBeat.o(3054);
            }
        }
    }

    private boolean recycleConnectionLocked(SQLiteConnection sQLiteConnection, AcquiredConnectionStatus acquiredConnectionStatus) {
        AppMethodBeat.i(3055);
        if (acquiredConnectionStatus == AcquiredConnectionStatus.RECONFIGURE) {
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e2) {
                Log.e(TAG, "Failed to reconfigure released connection, closing it: ".concat(String.valueOf(sQLiteConnection)), e2);
                acquiredConnectionStatus = AcquiredConnectionStatus.DISCARD;
            }
        }
        if (acquiredConnectionStatus == AcquiredConnectionStatus.DISCARD) {
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            AppMethodBeat.o(3055);
            return false;
        }
        AppMethodBeat.o(3055);
        return true;
    }

    public final boolean shouldYieldConnection(SQLiteConnection sQLiteConnection, int i2) {
        boolean isSessionBlockingImportantConnectionWaitersLocked;
        AppMethodBeat.i(3056);
        synchronized (this.mLock) {
            try {
                if (!this.mAcquiredConnections.containsKey(sQLiteConnection)) {
                    IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because the specified connection was not acquired from this pool or has already been released.");
                    AppMethodBeat.o(3056);
                    throw illegalStateException;
                } else if (!this.mIsOpen) {
                    isSessionBlockingImportantConnectionWaitersLocked = false;
                } else {
                    isSessionBlockingImportantConnectionWaitersLocked = isSessionBlockingImportantConnectionWaitersLocked(sQLiteConnection.isPrimaryConnection(), i2);
                    AppMethodBeat.o(3056);
                }
            } finally {
                AppMethodBeat.o(3056);
            }
        }
        return isSessionBlockingImportantConnectionWaitersLocked;
    }

    public final void collectDbStats(ArrayList<SQLiteDebug.DbStats> arrayList) {
        AppMethodBeat.i(3057);
        synchronized (this.mLock) {
            try {
                if (this.mAvailablePrimaryConnection != null) {
                    this.mAvailablePrimaryConnection.collectDbStats(arrayList);
                }
                Iterator<SQLiteConnection> it = this.mAvailableNonPrimaryConnections.iterator();
                while (it.hasNext()) {
                    it.next().collectDbStats(arrayList);
                }
                for (SQLiteConnection sQLiteConnection : this.mAcquiredConnections.keySet()) {
                    sQLiteConnection.collectDbStatsUnsafe(arrayList);
                }
            } finally {
                AppMethodBeat.o(3057);
            }
        }
    }

    private SQLiteConnection openConnectionLocked(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, boolean z) {
        AppMethodBeat.i(3058);
        int i2 = this.mNextConnectionId;
        this.mNextConnectionId = i2 + 1;
        SQLiteConnection open = SQLiteConnection.open(this, sQLiteDatabaseConfiguration, i2, z, this.mPassword, this.mCipher);
        AppMethodBeat.o(3058);
        return open;
    }

    /* access modifiers changed from: package-private */
    public final void onConnectionLeaked() {
        AppMethodBeat.i(3059);
        Log.w(TAG, "A SQLiteConnection object for database '" + this.mConfiguration.label + "' was leaked!  Please fix your application to end transactions in progress properly and to close the database when it is no longer needed.");
        this.mConnectionLeaked.set(true);
        AppMethodBeat.o(3059);
    }

    private void closeAvailableConnectionsAndLogExceptionsLocked() {
        AppMethodBeat.i(3060);
        closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked();
        if (this.mAvailablePrimaryConnection != null) {
            closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
            this.mAvailablePrimaryConnection = null;
        }
        AppMethodBeat.o(3060);
    }

    private void closeAvailableNonPrimaryConnectionsAndLogExceptionsLocked() {
        AppMethodBeat.i(3061);
        int size = this.mAvailableNonPrimaryConnections.size();
        for (int i2 = 0; i2 < size; i2++) {
            closeConnectionAndLogExceptionsLocked(this.mAvailableNonPrimaryConnections.get(i2));
        }
        this.mAvailableNonPrimaryConnections.clear();
        AppMethodBeat.o(3061);
    }

    private void closeExcessConnectionsAndLogExceptionsLocked() {
        AppMethodBeat.i(3062);
        int size = this.mAvailableNonPrimaryConnections.size();
        while (true) {
            int i2 = size - 1;
            if (size > this.mMaxConnectionPoolSize - 1) {
                closeConnectionAndLogExceptionsLocked(this.mAvailableNonPrimaryConnections.remove(i2));
                size = i2;
            } else {
                AppMethodBeat.o(3062);
                return;
            }
        }
    }

    private void closeConnectionAndLogExceptionsLocked(SQLiteConnection sQLiteConnection) {
        AppMethodBeat.i(3063);
        try {
            sQLiteConnection.close();
            AppMethodBeat.o(3063);
        } catch (RuntimeException e2) {
            Log.e(TAG, "Failed to close connection, its fate is now in the hands of the merciful GC: " + sQLiteConnection + e2.getMessage());
            AppMethodBeat.o(3063);
        }
    }

    private void discardAcquiredConnectionsLocked() {
        AppMethodBeat.i(3064);
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.DISCARD);
        AppMethodBeat.o(3064);
    }

    private void reconfigureAllConnectionsLocked() {
        int i2;
        AppMethodBeat.i(3065);
        if (this.mAvailablePrimaryConnection != null) {
            try {
                this.mAvailablePrimaryConnection.reconfigure(this.mConfiguration);
            } catch (RuntimeException e2) {
                Log.e(TAG, "Failed to reconfigure available primary connection, closing it: " + this.mAvailablePrimaryConnection, e2);
                closeConnectionAndLogExceptionsLocked(this.mAvailablePrimaryConnection);
                this.mAvailablePrimaryConnection = null;
            }
        }
        int size = this.mAvailableNonPrimaryConnections.size();
        int i3 = 0;
        while (i3 < size) {
            SQLiteConnection sQLiteConnection = this.mAvailableNonPrimaryConnections.get(i3);
            try {
                sQLiteConnection.reconfigure(this.mConfiguration);
                i2 = i3;
            } catch (RuntimeException e3) {
                Log.e(TAG, "Failed to reconfigure available non-primary connection, closing it: ".concat(String.valueOf(sQLiteConnection)), e3);
                closeConnectionAndLogExceptionsLocked(sQLiteConnection);
                i2 = i3 - 1;
                this.mAvailableNonPrimaryConnections.remove(i3);
                size--;
            }
            i3 = i2 + 1;
        }
        markAcquiredConnectionsLocked(AcquiredConnectionStatus.RECONFIGURE);
        AppMethodBeat.o(3065);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.util.WeakHashMap<com.tencent.wcdb.database.SQLiteConnection, com.tencent.wcdb.database.SQLiteConnectionPool$AcquiredConnectionStatus> */
    /* JADX WARN: Multi-variable type inference failed */
    private void markAcquiredConnectionsLocked(AcquiredConnectionStatus acquiredConnectionStatus) {
        AppMethodBeat.i(3066);
        if (!this.mAcquiredConnections.isEmpty()) {
            ArrayList arrayList = new ArrayList(this.mAcquiredConnections.size());
            for (Map.Entry<SQLiteConnection, AcquiredConnectionStatus> entry : this.mAcquiredConnections.entrySet()) {
                AcquiredConnectionStatus value = entry.getValue();
                if (!(acquiredConnectionStatus == value || value == AcquiredConnectionStatus.DISCARD)) {
                    arrayList.add(entry.getKey());
                }
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mAcquiredConnections.put(arrayList.get(i2), acquiredConnectionStatus);
            }
        }
        AppMethodBeat.o(3066);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x00ff, code lost:
        if (r4 == null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0101, code lost:
        r5 = r16 - r14.mStartTime;
        logConnectionPoolBusy(r4, r5, r20);
        r3 = r18.mDB.get();
        r2 = r18.mTraceCallback;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x011a, code lost:
        if (r3 == null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x011c, code lost:
        if (r2 == null) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x011e, code lost:
        r2.onConnectionPoolBusy(r3, r19, r5, r7, r4.activeSql, r4.activeTransactions);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.wcdb.database.SQLiteConnection waitForConnection(java.lang.String r19, int r20, com.tencent.wcdb.support.CancellationSignal r21) {
        /*
        // Method dump skipped, instructions count: 311
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.database.SQLiteConnectionPool.waitForConnection(java.lang.String, int, com.tencent.wcdb.support.CancellationSignal):com.tencent.wcdb.database.SQLiteConnection");
    }

    private void cancelConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        AppMethodBeat.i(3068);
        if (connectionWaiter.mAssignedConnection == null && connectionWaiter.mException == null) {
            ConnectionWaiter connectionWaiter2 = null;
            for (ConnectionWaiter connectionWaiter3 = this.mConnectionWaiterQueue; connectionWaiter3 != connectionWaiter; connectionWaiter3 = connectionWaiter3.mNext) {
                if ($assertionsDisabled || connectionWaiter3 != null) {
                    connectionWaiter2 = connectionWaiter3;
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(3068);
                    throw assertionError;
                }
            }
            if (connectionWaiter2 != null) {
                connectionWaiter2.mNext = connectionWaiter.mNext;
            } else {
                this.mConnectionWaiterQueue = connectionWaiter.mNext;
            }
            connectionWaiter.mException = new OperationCanceledException();
            LockSupport.unpark(connectionWaiter.mThread);
            wakeConnectionWaitersLocked();
            AppMethodBeat.o(3068);
            return;
        }
        AppMethodBeat.o(3068);
    }

    /* access modifiers changed from: package-private */
    public static class ConnectionPoolBusyInfo {
        int activeConnections;
        ArrayList<String> activeOperationDescriptions;
        ArrayList<SQLiteTrace.TraceInfo<String>> activeSql;
        ArrayList<SQLiteTrace.TraceInfo<StackTraceElement[]>> activeTransactions;
        int availableConnections;
        int idleConnections;
        String label;

        private ConnectionPoolBusyInfo() {
            AppMethodBeat.i(3044);
            this.activeOperationDescriptions = new ArrayList<>();
            this.activeSql = new ArrayList<>();
            this.activeTransactions = new ArrayList<>();
            AppMethodBeat.o(3044);
        }
    }

    private void logConnectionPoolBusy(ConnectionPoolBusyInfo connectionPoolBusyInfo, long j2, int i2) {
        AppMethodBeat.i(3069);
        StringBuilder sb = new StringBuilder();
        if (j2 != 0) {
            Thread currentThread = Thread.currentThread();
            sb.append("The connection pool for database '").append(connectionPoolBusyInfo.label);
            sb.append("' has been unable to grant a connection to thread ");
            sb.append(currentThread.getId()).append(" (").append(currentThread.getName()).append(") ");
            sb.append("with flags 0x").append(Integer.toHexString(i2));
            sb.append(" for ").append(((float) j2) * 0.001f).append(" seconds.\n");
        }
        sb.append("Connections: ").append(connectionPoolBusyInfo.activeConnections).append(" active, ");
        sb.append(connectionPoolBusyInfo.idleConnections).append(" idle, ");
        sb.append(connectionPoolBusyInfo.availableConnections).append(" available.\n");
        if (!connectionPoolBusyInfo.activeOperationDescriptions.isEmpty()) {
            sb.append("\nRequests in progress:\n");
            Iterator<String> it = connectionPoolBusyInfo.activeOperationDescriptions.iterator();
            while (it.hasNext()) {
                sb.append("  ").append(it.next()).append("\n");
            }
        }
        Log.w(TAG, sb.toString());
        AppMethodBeat.o(3069);
    }

    private ConnectionPoolBusyInfo gatherConnectionPoolBusyInfoLocked() {
        AppMethodBeat.i(3070);
        ConnectionPoolBusyInfo connectionPoolBusyInfo = new ConnectionPoolBusyInfo();
        connectionPoolBusyInfo.activeConnections = 0;
        connectionPoolBusyInfo.idleConnections = 0;
        if (!this.mAcquiredConnections.isEmpty()) {
            for (SQLiteConnection sQLiteConnection : this.mAcquiredConnections.keySet()) {
                SQLiteTrace.TraceInfo<StackTraceElement[]> tracePersistAcquisitionUnsafe = sQLiteConnection.tracePersistAcquisitionUnsafe();
                if (tracePersistAcquisitionUnsafe != null) {
                    connectionPoolBusyInfo.activeTransactions.add(tracePersistAcquisitionUnsafe);
                }
                SQLiteTrace.TraceInfo<String> traceCurrentOperationUnsafe = sQLiteConnection.traceCurrentOperationUnsafe();
                if (traceCurrentOperationUnsafe != null) {
                    connectionPoolBusyInfo.activeSql.add(traceCurrentOperationUnsafe);
                    String describeCurrentOperationUnsafe = sQLiteConnection.describeCurrentOperationUnsafe();
                    if (describeCurrentOperationUnsafe != null) {
                        connectionPoolBusyInfo.activeOperationDescriptions.add(describeCurrentOperationUnsafe);
                    }
                    connectionPoolBusyInfo.activeConnections++;
                } else {
                    connectionPoolBusyInfo.idleConnections++;
                }
            }
        }
        connectionPoolBusyInfo.availableConnections = this.mAvailableNonPrimaryConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            connectionPoolBusyInfo.availableConnections++;
        }
        AppMethodBeat.o(3070);
        return connectionPoolBusyInfo;
    }

    private void wakeConnectionWaitersLocked() {
        boolean z;
        SQLiteConnection sQLiteConnection;
        AppMethodBeat.i(3071);
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        boolean z2 = false;
        boolean z3 = false;
        ConnectionWaiter connectionWaiter2 = null;
        while (connectionWaiter != null) {
            if (!this.mIsOpen) {
                z = true;
            } else {
                try {
                    if (connectionWaiter.mWantPrimaryConnection || z2) {
                        sQLiteConnection = null;
                    } else {
                        sQLiteConnection = tryAcquireNonPrimaryConnectionLocked(connectionWaiter.mSql, connectionWaiter.mConnectionFlags);
                        if (sQLiteConnection == null) {
                            z2 = true;
                        }
                    }
                    if (sQLiteConnection == null && !z3 && (sQLiteConnection = tryAcquirePrimaryConnectionLocked(connectionWaiter.mConnectionFlags)) == null) {
                        z3 = true;
                    }
                    if (sQLiteConnection != null) {
                        connectionWaiter.mAssignedConnection = sQLiteConnection;
                        z = true;
                    } else if (!z2 || !z3) {
                        z = false;
                    } else {
                        AppMethodBeat.o(3071);
                        return;
                    }
                } catch (RuntimeException e2) {
                    connectionWaiter.mException = e2;
                    z = true;
                }
            }
            ConnectionWaiter connectionWaiter3 = connectionWaiter.mNext;
            if (z) {
                if (connectionWaiter2 != null) {
                    connectionWaiter2.mNext = connectionWaiter3;
                } else {
                    this.mConnectionWaiterQueue = connectionWaiter3;
                }
                connectionWaiter.mNext = null;
                LockSupport.unpark(connectionWaiter.mThread);
            } else {
                connectionWaiter2 = connectionWaiter;
            }
            connectionWaiter = connectionWaiter3;
        }
        AppMethodBeat.o(3071);
    }

    private SQLiteConnection tryAcquirePrimaryConnectionLocked(int i2) {
        AppMethodBeat.i(LVBuffer.MAX_STRING_LENGTH);
        SQLiteConnection sQLiteConnection = this.mAvailablePrimaryConnection;
        if (sQLiteConnection != null) {
            this.mAvailablePrimaryConnection = null;
            finishAcquireConnectionLocked(sQLiteConnection, i2);
            AppMethodBeat.o(LVBuffer.MAX_STRING_LENGTH);
            return sQLiteConnection;
        }
        for (SQLiteConnection sQLiteConnection2 : this.mAcquiredConnections.keySet()) {
            if (sQLiteConnection2.isPrimaryConnection()) {
                AppMethodBeat.o(LVBuffer.MAX_STRING_LENGTH);
                return null;
            }
        }
        SQLiteConnection openConnectionLocked = openConnectionLocked(this.mConfiguration, true);
        finishAcquireConnectionLocked(openConnectionLocked, i2);
        AppMethodBeat.o(LVBuffer.MAX_STRING_LENGTH);
        return openConnectionLocked;
    }

    private SQLiteConnection tryAcquireNonPrimaryConnectionLocked(String str, int i2) {
        AppMethodBeat.i(3073);
        int size = this.mAvailableNonPrimaryConnections.size();
        if (size > 1 && str != null) {
            for (int i3 = 0; i3 < size; i3++) {
                SQLiteConnection sQLiteConnection = this.mAvailableNonPrimaryConnections.get(i3);
                if (sQLiteConnection.isPreparedStatementInCache(str)) {
                    this.mAvailableNonPrimaryConnections.remove(i3);
                    finishAcquireConnectionLocked(sQLiteConnection, i2);
                    AppMethodBeat.o(3073);
                    return sQLiteConnection;
                }
            }
        }
        if (size > 0) {
            SQLiteConnection remove = this.mAvailableNonPrimaryConnections.remove(size - 1);
            finishAcquireConnectionLocked(remove, i2);
            AppMethodBeat.o(3073);
            return remove;
        }
        int size2 = this.mAcquiredConnections.size();
        if (this.mAvailablePrimaryConnection != null) {
            size2++;
        }
        if (size2 >= this.mMaxConnectionPoolSize) {
            AppMethodBeat.o(3073);
            return null;
        }
        SQLiteConnection openConnectionLocked = openConnectionLocked(this.mConfiguration, false);
        finishAcquireConnectionLocked(openConnectionLocked, i2);
        AppMethodBeat.o(3073);
        return openConnectionLocked;
    }

    private void finishAcquireConnectionLocked(SQLiteConnection sQLiteConnection, int i2) {
        AppMethodBeat.i(3074);
        try {
            sQLiteConnection.setOnlyAllowReadOnlyOperations((i2 & 1) != 0);
            this.mAcquiredConnections.put(sQLiteConnection, AcquiredConnectionStatus.NORMAL);
            AppMethodBeat.o(3074);
        } catch (RuntimeException e2) {
            Log.e(TAG, "Failed to prepare acquired connection for session, closing it: " + sQLiteConnection + ", connectionFlags=" + i2);
            closeConnectionAndLogExceptionsLocked(sQLiteConnection);
            AppMethodBeat.o(3074);
            throw e2;
        }
    }

    private boolean isSessionBlockingImportantConnectionWaitersLocked(boolean z, int i2) {
        AppMethodBeat.i(3075);
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
        if (connectionWaiter != null) {
            int priority = getPriority(i2);
            while (priority <= connectionWaiter.mPriority) {
                if (!z && connectionWaiter.mWantPrimaryConnection) {
                    connectionWaiter = connectionWaiter.mNext;
                    if (connectionWaiter == null) {
                        break;
                    }
                } else {
                    AppMethodBeat.o(3075);
                    return true;
                }
            }
        }
        AppMethodBeat.o(3075);
        return false;
    }

    private static int getPriority(int i2) {
        return (i2 & 4) != 0 ? 1 : 0;
    }

    private void setMaxConnectionPoolSizeLocked(int i2) {
        AppMethodBeat.i(3076);
        if (i2 <= 0) {
            if ((this.mConfiguration.openFlags & 536870912) != 0) {
                i2 = 4;
            } else {
                i2 = 1;
            }
        }
        this.mMaxConnectionPoolSize = i2;
        Log.i(TAG, "Max connection pool size is %d.", Integer.valueOf(this.mMaxConnectionPoolSize));
        AppMethodBeat.o(3076);
    }

    private void throwIfClosedLocked() {
        AppMethodBeat.i(3077);
        if (!this.mIsOpen) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because the connection pool has been closed.");
            AppMethodBeat.o(3077);
            throw illegalStateException;
        }
        AppMethodBeat.o(3077);
    }

    private ConnectionWaiter obtainConnectionWaiterLocked(Thread thread, long j2, int i2, boolean z, String str, int i3) {
        AppMethodBeat.i(3078);
        ConnectionWaiter connectionWaiter = this.mConnectionWaiterPool;
        if (connectionWaiter != null) {
            this.mConnectionWaiterPool = connectionWaiter.mNext;
            connectionWaiter.mNext = null;
        } else {
            connectionWaiter = new ConnectionWaiter();
        }
        connectionWaiter.mThread = thread;
        connectionWaiter.mStartTime = j2;
        connectionWaiter.mPriority = i2;
        connectionWaiter.mWantPrimaryConnection = z;
        connectionWaiter.mSql = str;
        connectionWaiter.mConnectionFlags = i3;
        AppMethodBeat.o(3078);
        return connectionWaiter;
    }

    private void recycleConnectionWaiterLocked(ConnectionWaiter connectionWaiter) {
        connectionWaiter.mNext = this.mConnectionWaiterPool;
        connectionWaiter.mThread = null;
        connectionWaiter.mSql = null;
        connectionWaiter.mAssignedConnection = null;
        connectionWaiter.mException = null;
        connectionWaiter.mNonce++;
        this.mConnectionWaiterPool = connectionWaiter;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteChangeListener getChangeListener() {
        return this.mChangeListener;
    }

    /* access modifiers changed from: package-private */
    public final void setChangeListener(SQLiteChangeListener sQLiteChangeListener, boolean z) {
        AppMethodBeat.i(3079);
        boolean z2 = sQLiteChangeListener != null;
        if (!z2) {
            z = false;
        }
        synchronized (this.mLock) {
            try {
                if (!(this.mConfiguration.updateNotificationEnabled == z2 && this.mConfiguration.updateNotificationRowID == z)) {
                    this.mConfiguration.updateNotificationEnabled = z2;
                    this.mConfiguration.updateNotificationRowID = z;
                    closeExcessConnectionsAndLogExceptionsLocked();
                    reconfigureAllConnectionsLocked();
                }
                this.mChangeListener = sQLiteChangeListener;
            } finally {
                AppMethodBeat.o(3079);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void notifyChanges(String str, String str2, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.i(3080);
        SQLiteDatabase sQLiteDatabase = this.mDB.get();
        SQLiteChangeListener sQLiteChangeListener = this.mChangeListener;
        if (sQLiteChangeListener == null || sQLiteDatabase == null) {
            AppMethodBeat.o(3080);
            return;
        }
        sQLiteChangeListener.onChange(sQLiteDatabase, str, str2, jArr, jArr2, jArr3);
        AppMethodBeat.o(3080);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteTrace getTraceCallback() {
        return this.mTraceCallback;
    }

    /* access modifiers changed from: package-private */
    public final void setTraceCallback(SQLiteTrace sQLiteTrace) {
        this.mTraceCallback = sQLiteTrace;
    }

    /* access modifiers changed from: package-private */
    public final void traceExecute(String str, int i2, long j2) {
        AppMethodBeat.i(3081);
        SQLiteDatabase sQLiteDatabase = this.mDB.get();
        SQLiteTrace sQLiteTrace = this.mTraceCallback;
        if (sQLiteTrace == null || sQLiteDatabase == null) {
            AppMethodBeat.o(3081);
            return;
        }
        sQLiteTrace.onSQLExecuted(sQLiteDatabase, str, i2, j2);
        AppMethodBeat.o(3081);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteCheckpointListener getCheckpointListener() {
        return this.mCheckpointListener;
    }

    /* access modifiers changed from: package-private */
    public final void setCheckpointListener(SQLiteCheckpointListener sQLiteCheckpointListener) {
        AppMethodBeat.i(3082);
        SQLiteDatabase sQLiteDatabase = this.mDB.get();
        if (this.mCheckpointListener != null) {
            this.mCheckpointListener.onDetach(sQLiteDatabase);
        }
        this.mCheckpointListener = sQLiteCheckpointListener;
        if (this.mCheckpointListener != null) {
            this.mCheckpointListener.onAttach(sQLiteDatabase);
        }
        AppMethodBeat.o(3082);
    }

    /* access modifiers changed from: package-private */
    public final void notifyCheckpoint(String str, int i2) {
        AppMethodBeat.i(3083);
        SQLiteDatabase sQLiteDatabase = this.mDB.get();
        SQLiteCheckpointListener sQLiteCheckpointListener = this.mCheckpointListener;
        if (sQLiteCheckpointListener == null || sQLiteDatabase == null) {
            AppMethodBeat.o(3083);
            return;
        }
        sQLiteCheckpointListener.onWALCommit(sQLiteDatabase, str, i2);
        AppMethodBeat.o(3083);
    }

    /* access modifiers changed from: package-private */
    public final void dump(Printer printer, boolean z) {
        AppMethodBeat.i(3084);
        Printer create = PrefixPrinter.create(printer, "    ");
        synchronized (this.mLock) {
            try {
                printer.println("Connection pool for " + this.mConfiguration.path + ":");
                printer.println("  Open: " + this.mIsOpen);
                printer.println("  Max connections: " + this.mMaxConnectionPoolSize);
                printer.println("  Available primary connection:");
                if (this.mAvailablePrimaryConnection != null) {
                    this.mAvailablePrimaryConnection.dump(create, z);
                } else {
                    create.println("<none>");
                }
                printer.println("  Available non-primary connections:");
                if (!this.mAvailableNonPrimaryConnections.isEmpty()) {
                    int size = this.mAvailableNonPrimaryConnections.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.mAvailableNonPrimaryConnections.get(i2).dump(create, z);
                    }
                } else {
                    create.println("<none>");
                }
                printer.println("  Acquired connections:");
                if (!this.mAcquiredConnections.isEmpty()) {
                    for (Map.Entry<SQLiteConnection, AcquiredConnectionStatus> entry : this.mAcquiredConnections.entrySet()) {
                        entry.getKey().dump(create, z);
                        create.println("  Status: " + entry.getValue());
                    }
                } else {
                    create.println("<none>");
                }
                printer.println("  Connection waiters:");
                if (this.mConnectionWaiterQueue != null) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue;
                    int i3 = 0;
                    while (connectionWaiter != null) {
                        create.println(i3 + ": waited for " + (uptimeMillis - connectionWaiter.mStartTime) + " ms - thread=" + connectionWaiter.mThread + ", priority=" + connectionWaiter.mPriority + ", sql='" + connectionWaiter.mSql + "'");
                        connectionWaiter = connectionWaiter.mNext;
                        i3++;
                    }
                } else {
                    create.println("<none>");
                }
            } finally {
                AppMethodBeat.o(3084);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final JSONObject dumpJSON(boolean z) {
        JSONObject put;
        AppMethodBeat.i(3085);
        synchronized (this.mLock) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                put = new JSONObject().put("path", this.mConfiguration.path).put(WeChatBrands.Business.GROUP_OPEN, this.mIsOpen).put("maxConn", this.mMaxConnectionPoolSize).put("availablePrimary", (Object) null).put("availableNonPrimary", jSONArray).put("acquired", jSONArray2).put("waiters", jSONArray3);
                Iterator<SQLiteConnection> it = this.mAvailableNonPrimaryConnections.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().dumpJSON(z));
                }
                for (Map.Entry<SQLiteConnection, AcquiredConnectionStatus> entry : this.mAcquiredConnections.entrySet()) {
                    jSONArray2.put(entry.getKey().dumpJSON(z).put("status", entry.getValue().toString()));
                }
                for (ConnectionWaiter connectionWaiter = this.mConnectionWaiterQueue; connectionWaiter != null; connectionWaiter = connectionWaiter.mNext) {
                    jSONArray3.put(new JSONObject().put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, SystemClock.uptimeMillis() - connectionWaiter.mStartTime).put("thread", connectionWaiter.mThread.toString()).put(DownloadInfo.PRIORITY, connectionWaiter.mPriority).put(SharePluginInfo.ISSUE_KEY_SQL, connectionWaiter.mSql));
                }
            } finally {
                AppMethodBeat.o(3085);
            }
        }
        return put;
    }

    public final String toString() {
        AppMethodBeat.i(3086);
        String str = "SQLiteConnectionPool: " + this.mConfiguration.path;
        AppMethodBeat.o(3086);
        return str;
    }

    /* access modifiers changed from: package-private */
    public static final class ConnectionWaiter {
        public SQLiteConnection mAssignedConnection;
        public int mConnectionFlags;
        public RuntimeException mException;
        public ConnectionWaiter mNext;
        public int mNonce;
        public int mPriority;
        public String mSql;
        public long mStartTime;
        public Thread mThread;
        public boolean mWantPrimaryConnection;

        private ConnectionWaiter() {
        }
    }
}
