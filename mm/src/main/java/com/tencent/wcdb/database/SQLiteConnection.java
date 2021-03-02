package com.tencent.wcdb.database;

import android.annotation.SuppressLint;
import android.os.Process;
import android.util.Pair;
import android.util.Printer;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.database.SQLiteTrace;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.LruCache;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SQLiteConnection implements CancellationSignal.OnCancelListener {
    private static final boolean DEBUG = false;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final String[] HMAC_ALGO_MAPPING = {"HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512"};
    private static final String[] PBKDF2_ALGO_MAPPING = {"PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512"};
    private static final String TAG = "WCDB.SQLiteConnection";
    private static final Pattern TRIM_SQL_PATTERN = Pattern.compile("[\\s]*\\n+[\\s]*");
    private StackTraceElement[] mAcquiredStack;
    private Thread mAcquiredThread;
    private int mAcquiredTid;
    private long mAcquiredTimestamp;
    private int mCancellationSignalAttachCount;
    private SQLiteCipherSpec mCipher;
    private final SQLiteDatabaseConfiguration mConfiguration;
    private final int mConnectionId;
    private long mConnectionPtr;
    private final boolean mIsPrimaryConnection;
    private final boolean mIsReadOnlyConnection;
    private int mNativeHandleCount;
    private Operation mNativeOperation;
    private boolean mOnlyAllowReadOnlyOperations;
    private byte[] mPassword;
    private final SQLiteConnectionPool mPool;
    private final PreparedStatementCache mPreparedStatementCache;
    private PreparedStatement mPreparedStatementPool;
    private final OperationLog mRecentOperations = new OperationLog();

    private static native void nativeBindBlob(long j2, long j3, int i2, byte[] bArr);

    private static native void nativeBindDouble(long j2, long j3, int i2, double d2);

    private static native void nativeBindLong(long j2, long j3, int i2, long j4);

    private static native void nativeBindNull(long j2, long j3, int i2);

    private static native void nativeBindString(long j2, long j3, int i2, String str);

    private static native void nativeCancel(long j2);

    private static native void nativeClose(long j2);

    private static native void nativeExecute(long j2, long j3);

    private static native int nativeExecuteForChangedRowCount(long j2, long j3);

    private static native long nativeExecuteForCursorWindow(long j2, long j3, long j4, int i2, int i3, boolean z);

    private static native long nativeExecuteForLastInsertedRowId(long j2, long j3);

    private static native long nativeExecuteForLong(long j2, long j3);

    private static native String nativeExecuteForString(long j2, long j3);

    private static native void nativeFinalizeStatement(long j2, long j3);

    private static native int nativeGetColumnCount(long j2, long j3);

    private static native String nativeGetColumnName(long j2, long j3, int i2);

    private static native int nativeGetDbLookaside(long j2);

    private static native int nativeGetParameterCount(long j2, long j3);

    private static native boolean nativeIsReadOnly(long j2, long j3);

    private native long nativeOpen(String str, int i2, String str2);

    private static native long nativePrepareStatement(long j2, String str);

    private static native void nativeRegisterCustomFunction(long j2, SQLiteCustomFunction sQLiteCustomFunction);

    private static native void nativeRegisterLocalizedCollators(long j2, String str);

    private static native void nativeResetCancel(long j2, boolean z);

    private static native void nativeResetStatement(long j2, long j3, boolean z);

    private static native long nativeSQLiteHandle(long j2, boolean z);

    private static native void nativeSetKey(long j2, byte[] bArr);

    private static native void nativeSetUpdateNotification(long j2, boolean z, boolean z2);

    private static native void nativeSetWalHook(long j2);

    private static native long nativeWalCheckpoint(long j2, String str);

    static /* synthetic */ void access$1000(SQLiteConnection sQLiteConnection, PreparedStatement preparedStatement, boolean z) {
        AppMethodBeat.i(3034);
        sQLiteConnection.resetStatement(preparedStatement, z);
        AppMethodBeat.o(3034);
    }

    static /* synthetic */ void access$1100(SQLiteConnection sQLiteConnection, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3035);
        sQLiteConnection.attachCancellationSignal(cancellationSignal);
        AppMethodBeat.o(3035);
    }

    static /* synthetic */ void access$1200(SQLiteConnection sQLiteConnection, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3036);
        sQLiteConnection.detachCancellationSignal(cancellationSignal);
        AppMethodBeat.o(3036);
    }

    static /* synthetic */ void access$1400(SQLiteConnection sQLiteConnection, PreparedStatement preparedStatement) {
        AppMethodBeat.i(3037);
        sQLiteConnection.finalizePreparedStatement(preparedStatement);
        AppMethodBeat.o(3037);
    }

    static /* synthetic */ String access$1500(String str) {
        AppMethodBeat.i(3038);
        String trimSqlForDisplay = trimSqlForDisplay(str);
        AppMethodBeat.o(3038);
        return trimSqlForDisplay;
    }

    static /* synthetic */ void access$900(SQLiteConnection sQLiteConnection, PreparedStatement preparedStatement, Object[] objArr) {
        AppMethodBeat.i(3033);
        sQLiteConnection.bindArguments(preparedStatement, objArr);
        AppMethodBeat.o(3033);
    }

    static {
        AppMethodBeat.i(3039);
        AppMethodBeat.o(3039);
    }

    private SQLiteConnection(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2, boolean z, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        SQLiteCipherSpec sQLiteCipherSpec2 = null;
        AppMethodBeat.i(2980);
        this.mPassword = bArr;
        this.mCipher = sQLiteCipherSpec != null ? new SQLiteCipherSpec(sQLiteCipherSpec) : sQLiteCipherSpec2;
        this.mPool = sQLiteConnectionPool;
        this.mConfiguration = new SQLiteDatabaseConfiguration(sQLiteDatabaseConfiguration);
        this.mConnectionId = i2;
        this.mIsPrimaryConnection = z;
        this.mIsReadOnlyConnection = (sQLiteDatabaseConfiguration.openFlags & 1) != 0;
        this.mPreparedStatementCache = new PreparedStatementCache(this.mConfiguration.maxSqlCacheSize);
        AppMethodBeat.o(2980);
    }

    /* access modifiers changed from: package-private */
    public final long getNativeHandle(String str) {
        AppMethodBeat.i(2981);
        if (this.mConnectionPtr == 0) {
            AppMethodBeat.o(2981);
            return 0;
        }
        if (str != null && this.mNativeOperation == null) {
            this.mNativeOperation = this.mRecentOperations.beginOperation(str, null, null);
            this.mNativeOperation.mType = 99;
        }
        this.mNativeHandleCount++;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.mConnectionPtr, true);
        AppMethodBeat.o(2981);
        return nativeSQLiteHandle;
    }

    /* access modifiers changed from: package-private */
    public final void endNativeHandle(Exception exc) {
        AppMethodBeat.i(2982);
        int i2 = this.mNativeHandleCount - 1;
        this.mNativeHandleCount = i2;
        if (i2 == 0 && this.mNativeOperation != null) {
            nativeSQLiteHandle(this.mConnectionPtr, false);
            if (exc == null) {
                this.mRecentOperations.endOperationDeferLog(this.mNativeOperation.mCookie);
            } else {
                this.mRecentOperations.failOperation(this.mNativeOperation.mCookie, exc);
            }
            this.mNativeOperation = null;
        }
        AppMethodBeat.o(2982);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(2983);
        try {
            if (!(this.mPool == null || this.mConnectionPtr == 0)) {
                this.mPool.onConnectionLeaked();
            }
            dispose(true);
        } finally {
            super.finalize();
            AppMethodBeat.o(2983);
        }
    }

    static SQLiteConnection open(SQLiteConnectionPool sQLiteConnectionPool, SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration, int i2, boolean z, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec) {
        AppMethodBeat.i(2984);
        SQLiteConnection sQLiteConnection = new SQLiteConnection(sQLiteConnectionPool, sQLiteDatabaseConfiguration, i2, z, bArr, sQLiteCipherSpec);
        try {
            sQLiteConnection.open();
            AppMethodBeat.o(2984);
            return sQLiteConnection;
        } catch (SQLiteException e2) {
            SQLiteDebug.collectLastIOTraceStats(sQLiteConnection);
            sQLiteConnection.dispose(false);
            AppMethodBeat.o(2984);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public final void close() {
        AppMethodBeat.i(2985);
        dispose(false);
        AppMethodBeat.o(2985);
    }

    private void open() {
        AppMethodBeat.i(2986);
        this.mConnectionPtr = nativeOpen(this.mConfiguration.path, this.mConfiguration.openFlags, this.mConfiguration.vfsName);
        if (this.mPassword != null && this.mPassword.length == 0) {
            this.mPassword = null;
        }
        if (this.mPassword != null) {
            nativeSetKey(this.mConnectionPtr, this.mPassword);
            setCipherSpec();
        }
        setPageSize();
        setReadOnlyFromConfiguration();
        setForeignKeyModeFromConfiguration();
        setWalModeFromConfiguration();
        setSyncModeFromConfiguration();
        setJournalSizeLimit();
        setCheckpointStrategy();
        setLocaleFromConfiguration();
        long j2 = WCDBInitializationProbe.apiEnv;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.mConnectionPtr, true);
        try {
            Iterator<SQLiteExtension> it = this.mConfiguration.extensions.iterator();
            while (it.hasNext()) {
                it.next().initialize(nativeSQLiteHandle, j2);
            }
            nativeSQLiteHandle(this.mConnectionPtr, false);
            setUpdateNotificationFromConfiguration();
            AppMethodBeat.o(2986);
        } catch (Throwable th) {
            nativeSQLiteHandle(this.mConnectionPtr, false);
            AppMethodBeat.o(2986);
            throw th;
        }
    }

    private void dispose(boolean z) {
        AppMethodBeat.i(2987);
        if (this.mConnectionPtr != 0) {
            int i2 = this.mRecentOperations.beginOperation("close", null, null).mCookie;
            try {
                this.mPreparedStatementCache.evictAll();
                nativeClose(this.mConnectionPtr);
                this.mConnectionPtr = 0;
            } finally {
                this.mRecentOperations.endOperation(i2);
                AppMethodBeat.o(2987);
            }
        } else {
            AppMethodBeat.o(2987);
        }
    }

    private void setPageSize() {
        String str;
        long j2;
        AppMethodBeat.i(2988);
        if (!this.mConfiguration.isInMemoryDb()) {
            if (this.mPassword != null) {
                str = "PRAGMA cipher_page_size";
                j2 = (this.mCipher == null || this.mCipher.pageSize <= 0) ? (long) SQLiteGlobal.defaultPageSize : (long) this.mCipher.pageSize;
            } else {
                str = "PRAGMA page_size";
                j2 = (long) SQLiteGlobal.defaultPageSize;
            }
            if (executeForLong(str, null, null) != j2) {
                execute(str + "=" + j2, null, null);
            }
        }
        AppMethodBeat.o(2988);
    }

    private void setCipherSpec() {
        AppMethodBeat.i(2989);
        if (this.mCipher != null) {
            if (this.mCipher.kdfIteration != 0) {
                execute("PRAGMA kdf_iter=" + this.mCipher.kdfIteration, null, null);
            }
            execute("PRAGMA cipher_use_hmac=" + this.mCipher.hmacEnabled, null, null);
            if (this.mCipher.hmacAlgorithm != -1) {
                execute("PRAGMA cipher_hmac_algorithm=" + HMAC_ALGO_MAPPING[this.mCipher.hmacAlgorithm], null, null);
            }
            if (this.mCipher.kdfAlgorithm != -1) {
                execute("PRAGMA cipher_kdf_algorithm=" + PBKDF2_ALGO_MAPPING[this.mCipher.kdfAlgorithm], null, null);
            }
        }
        AppMethodBeat.o(2989);
    }

    private void notifyCheckpoint(String str, int i2) {
        AppMethodBeat.i(2990);
        this.mPool.notifyCheckpoint(str, i2);
        AppMethodBeat.o(2990);
    }

    private void setCheckpointStrategy() {
        AppMethodBeat.i(2991);
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            if (this.mConfiguration.customWALHookEnabled) {
                nativeSetWalHook(this.mConnectionPtr);
                AppMethodBeat.o(2991);
                return;
            } else if (executeForLong("PRAGMA wal_autocheckpoint", null, null) != 100) {
                executeForLong("PRAGMA wal_autocheckpoint=100", null, null);
            }
        }
        AppMethodBeat.o(2991);
    }

    private void setJournalSizeLimit() {
        AppMethodBeat.i(2992);
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection && executeForLong("PRAGMA journal_size_limit", null, null) != g.ACTION_MINI_PROGRAM_LAUNCH) {
            executeForLong("PRAGMA journal_size_limit=524288", null, null);
        }
        AppMethodBeat.o(2992);
    }

    private void setForeignKeyModeFromConfiguration() {
        AppMethodBeat.i(2993);
        if (!this.mIsReadOnlyConnection) {
            long j2 = this.mConfiguration.foreignKeyConstraintsEnabled ? 1 : 0;
            if (executeForLong("PRAGMA foreign_keys", null, null) != j2) {
                execute("PRAGMA foreign_keys=".concat(String.valueOf(j2)), null, null);
            }
        }
        AppMethodBeat.o(2993);
    }

    private void setWalModeFromConfiguration() {
        String str;
        AppMethodBeat.i(2994);
        if (!this.mConfiguration.isInMemoryDb() && !this.mIsReadOnlyConnection) {
            if ((this.mConfiguration.openFlags & 536870912) != 0) {
                str = "WAL";
            } else {
                str = SQLiteGlobal.defaultJournalMode;
            }
            setJournalMode(str);
        }
        AppMethodBeat.o(2994);
    }

    private void setSyncModeFromConfiguration() {
        AppMethodBeat.i(2995);
        execute("PRAGMA synchronous=".concat(String.valueOf(this.mConfiguration.synchronousMode)), null, null);
        AppMethodBeat.o(2995);
    }

    private void setJournalMode(String str) {
        AppMethodBeat.i(2996);
        String executeForString = executeForString("PRAGMA journal_mode", null, null);
        if (!executeForString.equalsIgnoreCase(str)) {
            try {
                if (executeForString("PRAGMA journal_mode=".concat(String.valueOf(str)), null, null).equalsIgnoreCase(str)) {
                    AppMethodBeat.o(2996);
                    return;
                }
            } catch (SQLiteDatabaseLockedException e2) {
            }
            Log.w(TAG, "Could not change the database journal mode of '" + this.mConfiguration.label + "' from '" + executeForString + "' to '" + str + "' because the database is locked.  This usually means that there are other open connections to the database which prevents the database from enabling or disabling write-ahead logging mode.  Proceeding without changing the journal mode.");
        }
        AppMethodBeat.o(2996);
    }

    private void setLocaleFromConfiguration() {
        AppMethodBeat.i(2997);
        this.mConfiguration.openFlags |= 16;
        if ((this.mConfiguration.openFlags & 16) != 0) {
            AppMethodBeat.o(2997);
            return;
        }
        String locale = this.mConfiguration.locale.toString();
        nativeRegisterLocalizedCollators(this.mConnectionPtr, locale);
        if (this.mIsReadOnlyConnection) {
            AppMethodBeat.o(2997);
            return;
        }
        try {
            execute("CREATE TABLE IF NOT EXISTS android_metadata (locale TEXT)", null, null);
            String executeForString = executeForString("SELECT locale FROM android_metadata UNION SELECT NULL ORDER BY locale DESC LIMIT 1", null, null);
            if (executeForString == null || !executeForString.equals(locale)) {
                execute("BEGIN", null, null);
                try {
                    execute("DELETE FROM android_metadata", null, null);
                    execute("INSERT INTO android_metadata (locale) VALUES(?)", new Object[]{locale}, null);
                    execute("REINDEX LOCALIZED", null, null);
                    execute("COMMIT", null, null);
                    AppMethodBeat.o(2997);
                } catch (Throwable th) {
                    execute("ROLLBACK", null, null);
                    AppMethodBeat.o(2997);
                    throw th;
                }
            } else {
                AppMethodBeat.o(2997);
            }
        } catch (RuntimeException e2) {
            SQLiteException sQLiteException = new SQLiteException("Failed to change locale for db '" + this.mConfiguration.label + "' to '" + locale + "'.", e2);
            AppMethodBeat.o(2997);
            throw sQLiteException;
        }
    }

    private void setReadOnlyFromConfiguration() {
        AppMethodBeat.i(2998);
        if (this.mIsReadOnlyConnection) {
            execute("PRAGMA query_only = 1", null, null);
        }
        AppMethodBeat.o(2998);
    }

    private void notifyChange(String str, String str2, long[] jArr, long[] jArr2, long[] jArr3) {
        AppMethodBeat.i(2999);
        this.mPool.notifyChanges(str, str2, jArr, jArr2, jArr3);
        AppMethodBeat.o(2999);
    }

    private void setUpdateNotificationFromConfiguration() {
        AppMethodBeat.i(3000);
        nativeSetUpdateNotification(this.mConnectionPtr, this.mConfiguration.updateNotificationEnabled, this.mConfiguration.updateNotificationRowID);
        AppMethodBeat.o(3000);
    }

    /* access modifiers changed from: package-private */
    public final void reconfigure(SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        AppMethodBeat.i(3001);
        this.mOnlyAllowReadOnlyOperations = false;
        long j2 = WCDBInitializationProbe.apiEnv;
        long nativeSQLiteHandle = nativeSQLiteHandle(this.mConnectionPtr, true);
        try {
            Iterator<SQLiteExtension> it = sQLiteDatabaseConfiguration.extensions.iterator();
            while (it.hasNext()) {
                SQLiteExtension next = it.next();
                if (!this.mConfiguration.extensions.contains(next)) {
                    next.initialize(nativeSQLiteHandle, j2);
                }
            }
            nativeSQLiteHandle(this.mConnectionPtr, false);
            boolean z6 = ((sQLiteDatabaseConfiguration.openFlags ^ this.mConfiguration.openFlags) & 536870912) != 0;
            if (sQLiteDatabaseConfiguration.foreignKeyConstraintsEnabled != this.mConfiguration.foreignKeyConstraintsEnabled) {
                z = true;
            } else {
                z = false;
            }
            if (!sQLiteDatabaseConfiguration.locale.equals(this.mConfiguration.locale)) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (sQLiteDatabaseConfiguration.customWALHookEnabled != this.mConfiguration.customWALHookEnabled) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (sQLiteDatabaseConfiguration.synchronousMode != this.mConfiguration.synchronousMode) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (!(sQLiteDatabaseConfiguration.updateNotificationEnabled == this.mConfiguration.updateNotificationEnabled && sQLiteDatabaseConfiguration.updateNotificationRowID == this.mConfiguration.updateNotificationRowID)) {
                z5 = true;
            }
            this.mConfiguration.updateParametersFrom(sQLiteDatabaseConfiguration);
            this.mPreparedStatementCache.resize(sQLiteDatabaseConfiguration.maxSqlCacheSize);
            if (z) {
                setForeignKeyModeFromConfiguration();
            }
            if (z6) {
                setWalModeFromConfiguration();
            }
            if (z4) {
                setSyncModeFromConfiguration();
            }
            if (z3) {
                setCheckpointStrategy();
            }
            if (z2) {
                setLocaleFromConfiguration();
            }
            if (z5) {
                setUpdateNotificationFromConfiguration();
            }
            AppMethodBeat.o(3001);
        } catch (Throwable th) {
            nativeSQLiteHandle(this.mConnectionPtr, false);
            AppMethodBeat.o(3001);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void setOnlyAllowReadOnlyOperations(boolean z) {
        this.mOnlyAllowReadOnlyOperations = z;
    }

    /* access modifiers changed from: package-private */
    public final void setAcquisitionState(boolean z, boolean z2) {
        AppMethodBeat.i(3002);
        if (z) {
            this.mAcquiredThread = Thread.currentThread();
            this.mAcquiredTid = Process.myTid();
            if (z2) {
                this.mAcquiredStack = this.mAcquiredThread.getStackTrace();
                this.mAcquiredTimestamp = System.currentTimeMillis();
                AppMethodBeat.o(3002);
                return;
            }
            this.mAcquiredStack = null;
            this.mAcquiredTimestamp = 0;
            AppMethodBeat.o(3002);
            return;
        }
        this.mAcquiredThread = null;
        this.mAcquiredTid = 0;
        this.mAcquiredStack = null;
        this.mAcquiredTimestamp = 0;
        AppMethodBeat.o(3002);
    }

    /* access modifiers changed from: package-private */
    public final boolean isPreparedStatementInCache(String str) {
        AppMethodBeat.i(3003);
        if (this.mPreparedStatementCache.get(str) != null) {
            AppMethodBeat.o(3003);
            return true;
        }
        AppMethodBeat.o(3003);
        return false;
    }

    public final int getConnectionId() {
        return this.mConnectionId;
    }

    public final boolean isPrimaryConnection() {
        return this.mIsPrimaryConnection;
    }

    public final void prepare(String str, SQLiteStatementInfo sQLiteStatementInfo) {
        AppMethodBeat.i(3004);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3004);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("prepare", str, null);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            if (sQLiteStatementInfo != null) {
                try {
                    sQLiteStatementInfo.numParameters = acquirePreparedStatement.mNumParameters;
                    sQLiteStatementInfo.readOnly = acquirePreparedStatement.mReadOnly;
                    int nativeGetColumnCount = nativeGetColumnCount(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                    if (nativeGetColumnCount == 0) {
                        sQLiteStatementInfo.columnNames = EMPTY_STRING_ARRAY;
                    } else {
                        sQLiteStatementInfo.columnNames = new String[nativeGetColumnCount];
                        for (int i3 = 0; i3 < nativeGetColumnCount; i3++) {
                            sQLiteStatementInfo.columnNames[i3] = nativeGetColumnName(this.mConnectionPtr, acquirePreparedStatement.getPtr(), i3);
                        }
                    }
                } catch (Throwable th) {
                    releasePreparedStatement(acquirePreparedStatement);
                    AppMethodBeat.o(3004);
                    throw th;
                }
            }
            releasePreparedStatement(acquirePreparedStatement);
            this.mRecentOperations.endOperation(i2);
            AppMethodBeat.o(3004);
        } catch (RuntimeException e2) {
            this.mRecentOperations.failOperation(i2, e2);
            AppMethodBeat.o(3004);
            throw e2;
        } catch (Throwable th2) {
            this.mRecentOperations.endOperation(i2);
            AppMethodBeat.o(3004);
            throw th2;
        }
    }

    public final void execute(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3005);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3005);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("execute", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                try {
                    nativeExecute(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(i2);
                    AppMethodBeat.o(3005);
                } catch (Throwable th) {
                    detachCancellationSignal(cancellationSignal);
                    AppMethodBeat.o(3005);
                    throw th;
                }
            } catch (Throwable th2) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(3005);
                throw th2;
            }
        } catch (RuntimeException e2) {
            this.mRecentOperations.failOperation(i2, e2);
            AppMethodBeat.o(3005);
            throw e2;
        } catch (Throwable th3) {
            this.mRecentOperations.endOperation(i2);
            AppMethodBeat.o(3005);
            throw th3;
        }
    }

    public final long executeForLong(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3006);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3006);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLong", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                try {
                    long nativeExecuteForLong = nativeExecuteForLong(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(i2);
                    AppMethodBeat.o(3006);
                    return nativeExecuteForLong;
                } catch (Throwable th) {
                    detachCancellationSignal(cancellationSignal);
                    AppMethodBeat.o(3006);
                    throw th;
                }
            } catch (Throwable th2) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(3006);
                throw th2;
            }
        } catch (RuntimeException e2) {
            this.mRecentOperations.failOperation(i2, e2);
            AppMethodBeat.o(3006);
            throw e2;
        } catch (Throwable th3) {
            this.mRecentOperations.endOperation(i2);
            AppMethodBeat.o(3006);
            throw th3;
        }
    }

    public final String executeForString(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForString", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                try {
                    String nativeExecuteForString = nativeExecuteForString(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(i2);
                    AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
                    return nativeExecuteForString;
                } catch (Throwable th) {
                    detachCancellationSignal(cancellationSignal);
                    AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
                    throw th;
                }
            } catch (Throwable th2) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
                throw th2;
            }
        } catch (RuntimeException e2) {
            this.mRecentOperations.failOperation(i2, e2);
            AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
            throw e2;
        } catch (Throwable th3) {
            this.mRecentOperations.endOperation(i2);
            AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_READ_FAIL);
            throw th3;
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(TXLiteAVCode.WARNING_RTMP_NO_DATA);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_NO_DATA);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForChangedRowCount", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                try {
                    int nativeExecuteForChangedRowCount = nativeExecuteForChangedRowCount(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    if (this.mRecentOperations.endOperationDeferLog(i2)) {
                        this.mRecentOperations.logOperation(i2, "changedRows=".concat(String.valueOf(nativeExecuteForChangedRowCount)));
                    }
                    AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_NO_DATA);
                    return nativeExecuteForChangedRowCount;
                } catch (Throwable th) {
                    detachCancellationSignal(cancellationSignal);
                    AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_NO_DATA);
                    throw th;
                }
            } catch (Throwable th2) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_NO_DATA);
                throw th2;
            }
        } catch (RuntimeException e2) {
            this.mRecentOperations.failOperation(i2, e2);
            AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_NO_DATA);
            throw e2;
        } catch (Throwable th3) {
            if (this.mRecentOperations.endOperationDeferLog(i2)) {
                this.mRecentOperations.logOperation(i2, "changedRows=".concat(String.valueOf(0)));
            }
            AppMethodBeat.o(TXLiteAVCode.WARNING_RTMP_NO_DATA);
            throw th3;
        }
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
            throw illegalArgumentException;
        }
        Operation beginOperation = this.mRecentOperations.beginOperation("executeForLastInsertedRowId", str, objArr);
        int i2 = beginOperation.mCookie;
        try {
            PreparedStatement acquirePreparedStatement = acquirePreparedStatement(str);
            beginOperation.mType = acquirePreparedStatement.mType;
            try {
                throwIfStatementForbidden(acquirePreparedStatement);
                bindArguments(acquirePreparedStatement, objArr);
                applyBlockGuardPolicy(acquirePreparedStatement);
                attachCancellationSignal(cancellationSignal);
                try {
                    long nativeExecuteForLastInsertedRowId = nativeExecuteForLastInsertedRowId(this.mConnectionPtr, acquirePreparedStatement.getPtr());
                    detachCancellationSignal(cancellationSignal);
                    releasePreparedStatement(acquirePreparedStatement);
                    this.mRecentOperations.endOperation(i2);
                    AppMethodBeat.o(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
                    return nativeExecuteForLastInsertedRowId;
                } catch (Throwable th) {
                    detachCancellationSignal(cancellationSignal);
                    AppMethodBeat.o(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
                    throw th;
                }
            } catch (Throwable th2) {
                releasePreparedStatement(acquirePreparedStatement);
                AppMethodBeat.o(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
                throw th2;
            }
        } catch (RuntimeException e2) {
            this.mRecentOperations.failOperation(i2, e2);
            AppMethodBeat.o(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
            throw e2;
        } catch (Throwable th3) {
            this.mRecentOperations.endOperation(i2);
            AppMethodBeat.o(TXLiteAVCode.WARNING_PLAY_LIVE_STREAM_INFO_CONNECT_FAIL);
            throw th3;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int executeForCursorWindow(java.lang.String r17, java.lang.Object[] r18, com.tencent.wcdb.CursorWindow r19, int r20, int r21, boolean r22, com.tencent.wcdb.support.CancellationSignal r23) {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.database.SQLiteConnection.executeForCursorWindow(java.lang.String, java.lang.Object[], com.tencent.wcdb.CursorWindow, int, int, boolean, com.tencent.wcdb.support.CancellationSignal):int");
    }

    public final Pair<Integer, Integer> walCheckpoint(String str) {
        AppMethodBeat.i(3011);
        if (str == null || str.isEmpty()) {
            str = "main";
        }
        long nativeWalCheckpoint = nativeWalCheckpoint(this.mConnectionPtr, str);
        Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf((int) (nativeWalCheckpoint >> 32)), Integer.valueOf((int) (nativeWalCheckpoint & Util.MAX_32BIT_VALUE)));
        AppMethodBeat.o(3011);
        return pair;
    }

    /* access modifiers changed from: package-private */
    public final PreparedStatement acquirePreparedStatement(String str) {
        boolean z;
        long nativePrepareStatement;
        AppMethodBeat.i(3012);
        PreparedStatement preparedStatement = (PreparedStatement) this.mPreparedStatementCache.get(str);
        if (preparedStatement == null) {
            z = false;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            int nativeGetParameterCount = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
            int sqlStatementType = DatabaseUtils.getSqlStatementType(str);
            preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount, sqlStatementType, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
            this.mPreparedStatementCache.put(str, preparedStatement);
            preparedStatement.mInCache = true;
            preparedStatement.mInUse = true;
            AppMethodBeat.o(3012);
        } else if (!preparedStatement.mInUse) {
            preparedStatement.mInUse = true;
            AppMethodBeat.o(3012);
        } else {
            z = true;
            nativePrepareStatement = nativePrepareStatement(this.mConnectionPtr, str);
            try {
                int nativeGetParameterCount2 = nativeGetParameterCount(this.mConnectionPtr, nativePrepareStatement);
                int sqlStatementType2 = DatabaseUtils.getSqlStatementType(str);
                preparedStatement = obtainPreparedStatement(str, nativePrepareStatement, nativeGetParameterCount2, sqlStatementType2, nativeIsReadOnly(this.mConnectionPtr, nativePrepareStatement));
                if (!z && isCacheable(sqlStatementType2)) {
                    this.mPreparedStatementCache.put(str, preparedStatement);
                    preparedStatement.mInCache = true;
                }
                preparedStatement.mInUse = true;
                AppMethodBeat.o(3012);
            } catch (RuntimeException e2) {
                if (preparedStatement == null || !preparedStatement.mInCache) {
                    nativeFinalizeStatement(this.mConnectionPtr, nativePrepareStatement);
                }
                AppMethodBeat.o(3012);
                throw e2;
            }
        }
        return preparedStatement;
    }

    /* access modifiers changed from: package-private */
    public final void releasePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.i(3013);
        preparedStatement.mInUse = false;
        if (preparedStatement.mInCache) {
            try {
                resetStatement(preparedStatement, true);
                AppMethodBeat.o(3013);
            } catch (SQLiteException e2) {
                this.mPreparedStatementCache.remove(preparedStatement.mSql);
                AppMethodBeat.o(3013);
            }
        } else {
            finalizePreparedStatement(preparedStatement);
            AppMethodBeat.o(3013);
        }
    }

    private void finalizePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.i(3014);
        nativeFinalizeStatement(this.mConnectionPtr, preparedStatement.getPtr());
        recyclePreparedStatement(preparedStatement);
        AppMethodBeat.o(3014);
    }

    private void attachCancellationSignal(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3015);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
            this.mCancellationSignalAttachCount++;
            if (this.mCancellationSignalAttachCount == 1) {
                nativeResetCancel(this.mConnectionPtr, true);
                cancellationSignal.setOnCancelListener(this);
            }
        }
        AppMethodBeat.o(3015);
    }

    private void detachCancellationSignal(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3016);
        if (cancellationSignal != null) {
            this.mCancellationSignalAttachCount--;
            if (this.mCancellationSignalAttachCount == 0) {
                cancellationSignal.setOnCancelListener(null);
                nativeResetCancel(this.mConnectionPtr, false);
            }
        }
        AppMethodBeat.o(3016);
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public final void onCancel() {
        AppMethodBeat.i(3017);
        nativeCancel(this.mConnectionPtr);
        AppMethodBeat.o(3017);
    }

    private void bindArguments(PreparedStatement preparedStatement, Object[] objArr) {
        AppMethodBeat.i(3018);
        int length = objArr != null ? objArr.length : 0;
        if (length != preparedStatement.mNumParameters) {
            SQLiteBindOrColumnIndexOutOfRangeException sQLiteBindOrColumnIndexOutOfRangeException = new SQLiteBindOrColumnIndexOutOfRangeException("Expected " + preparedStatement.mNumParameters + " bind arguments but " + length + " were provided.");
            AppMethodBeat.o(3018);
            throw sQLiteBindOrColumnIndexOutOfRangeException;
        } else if (length == 0) {
            AppMethodBeat.o(3018);
        } else {
            long ptr = preparedStatement.getPtr();
            for (int i2 = 0; i2 < length; i2++) {
                Object obj = objArr[i2];
                switch (DatabaseUtils.getTypeOfObject(obj)) {
                    case 0:
                        nativeBindNull(this.mConnectionPtr, ptr, i2 + 1);
                        break;
                    case 1:
                        nativeBindLong(this.mConnectionPtr, ptr, i2 + 1, ((Number) obj).longValue());
                        break;
                    case 2:
                        nativeBindDouble(this.mConnectionPtr, ptr, i2 + 1, ((Number) obj).doubleValue());
                        break;
                    case 3:
                    default:
                        if (obj instanceof Boolean) {
                            nativeBindLong(this.mConnectionPtr, ptr, i2 + 1, ((Boolean) obj).booleanValue() ? 1 : 0);
                            break;
                        } else {
                            nativeBindString(this.mConnectionPtr, ptr, i2 + 1, obj.toString());
                            break;
                        }
                    case 4:
                        nativeBindBlob(this.mConnectionPtr, ptr, i2 + 1, (byte[]) obj);
                        break;
                }
            }
            AppMethodBeat.o(3018);
        }
    }

    private void resetStatement(PreparedStatement preparedStatement, boolean z) {
        AppMethodBeat.i(3019);
        nativeResetStatement(this.mConnectionPtr, preparedStatement.getPtr(), z);
        AppMethodBeat.o(3019);
    }

    private void throwIfStatementForbidden(PreparedStatement preparedStatement) {
        AppMethodBeat.i(3020);
        if (!this.mOnlyAllowReadOnlyOperations || preparedStatement.mReadOnly) {
            AppMethodBeat.o(3020);
            return;
        }
        SQLiteException sQLiteException = new SQLiteException("Cannot execute this statement because it might modify the database but the connection is read-only.");
        AppMethodBeat.o(3020);
        throw sQLiteException;
    }

    private static boolean isCacheable(int i2) {
        if (i2 == 2 || i2 == 1) {
            return true;
        }
        return false;
    }

    private void applyBlockGuardPolicy(PreparedStatement preparedStatement) {
    }

    /* access modifiers changed from: package-private */
    public final void dump(Printer printer, boolean z) {
        AppMethodBeat.i(3021);
        printer.println("Connection #" + this.mConnectionId + ":");
        if (z) {
            printer.println("  connectionPtr: 0x" + Long.toHexString(this.mConnectionPtr));
        }
        printer.println("  isPrimaryConnection: " + this.mIsPrimaryConnection);
        printer.println("  onlyAllowReadOnlyOperations: " + this.mOnlyAllowReadOnlyOperations);
        if (this.mAcquiredThread != null) {
            printer.println("  acquiredThread: " + this.mAcquiredThread + " (tid: " + this.mAcquiredTid + ")");
        }
        this.mRecentOperations.dump(printer, z);
        if (z) {
            this.mPreparedStatementCache.dump(printer);
        }
        AppMethodBeat.o(3021);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject dumpJSON(boolean z) {
        Integer num = null;
        AppMethodBeat.i(3022);
        JSONObject putOpt = new JSONObject().put("id", this.mConnectionId).put("ptr", Long.toHexString(this.mConnectionPtr)).put("primary", this.mIsPrimaryConnection).put("readOnly", this.mOnlyAllowReadOnlyOperations).putOpt("thread", this.mAcquiredThread != null ? this.mAcquiredThread.toString() : null);
        if (this.mAcquiredTid > 0) {
            num = Integer.valueOf(this.mAcquiredTid);
        }
        JSONObject put = putOpt.putOpt("tid", num).put("operations", this.mRecentOperations.dumpJSON(z));
        AppMethodBeat.o(3022);
        return put;
    }

    /* access modifiers changed from: package-private */
    public final String describeCurrentOperationUnsafe() {
        AppMethodBeat.i(3023);
        String describeCurrentOperation = this.mRecentOperations.describeCurrentOperation();
        AppMethodBeat.o(3023);
        return describeCurrentOperation;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteTrace.TraceInfo<String> traceCurrentOperationUnsafe() {
        AppMethodBeat.i(3024);
        SQLiteTrace.TraceInfo<String> traceCurrentOperation = this.mRecentOperations.traceCurrentOperation();
        AppMethodBeat.o(3024);
        return traceCurrentOperation;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteTrace.TraceInfo<StackTraceElement[]> tracePersistAcquisitionUnsafe() {
        AppMethodBeat.i(3025);
        StackTraceElement[] stackTraceElementArr = this.mAcquiredStack;
        if (stackTraceElementArr == null) {
            AppMethodBeat.o(3025);
            return null;
        }
        SQLiteTrace.TraceInfo<StackTraceElement[]> traceInfo = new SQLiteTrace.TraceInfo<>(stackTraceElementArr, this.mAcquiredTimestamp, this.mAcquiredTid);
        AppMethodBeat.o(3025);
        return traceInfo;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c9, code lost:
        r6 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00df, code lost:
        r3.close();
        com.tencent.matrix.trace.core.AppMethodBeat.o(3026);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00e7, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00de A[ExcHandler:  FINALLY, Splitter:B:4:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void collectDbStats(java.util.ArrayList<com.tencent.wcdb.database.SQLiteDebug.DbStats> r15) {
        /*
        // Method dump skipped, instructions count: 235
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.database.SQLiteConnection.collectDbStats(java.util.ArrayList):void");
    }

    /* access modifiers changed from: package-private */
    public final void collectDbStatsUnsafe(ArrayList<SQLiteDebug.DbStats> arrayList) {
        AppMethodBeat.i(3027);
        arrayList.add(getMainDbStatsUnsafe(0, 0, 0));
        AppMethodBeat.o(3027);
    }

    private SQLiteDebug.DbStats getMainDbStatsUnsafe(int i2, long j2, long j3) {
        AppMethodBeat.i(3028);
        String str = this.mConfiguration.path;
        if (!this.mIsPrimaryConnection) {
            str = str + " (" + this.mConnectionId + ")";
        }
        SQLiteDebug.DbStats dbStats = new SQLiteDebug.DbStats(str, j2, j3, i2, this.mPreparedStatementCache.hitCount(), this.mPreparedStatementCache.missCount(), this.mPreparedStatementCache.size());
        AppMethodBeat.o(3028);
        return dbStats;
    }

    public final String toString() {
        AppMethodBeat.i(3029);
        String str = "SQLiteConnection: " + this.mConfiguration.path + " (" + this.mConnectionId + ")";
        AppMethodBeat.o(3029);
        return str;
    }

    private PreparedStatement obtainPreparedStatement(String str, long j2, int i2, int i3, boolean z) {
        AppMethodBeat.i(3030);
        PreparedStatement preparedStatement = this.mPreparedStatementPool;
        if (preparedStatement != null) {
            this.mPreparedStatementPool = preparedStatement.mPoolNext;
            preparedStatement.mPoolNext = null;
            preparedStatement.mInCache = false;
        } else {
            preparedStatement = new PreparedStatement(this);
        }
        preparedStatement.mSql = str;
        preparedStatement.mStatementPtr = j2;
        preparedStatement.mNumParameters = i2;
        preparedStatement.mType = i3;
        preparedStatement.mReadOnly = z;
        AppMethodBeat.o(3030);
        return preparedStatement;
    }

    private void recyclePreparedStatement(PreparedStatement preparedStatement) {
        AppMethodBeat.i(3031);
        preparedStatement.mSql = null;
        preparedStatement.mPoolNext = this.mPreparedStatementPool;
        this.mPreparedStatementPool = preparedStatement;
        AppMethodBeat.o(3031);
    }

    private static String trimSqlForDisplay(String str) {
        AppMethodBeat.i(3032);
        String replaceAll = TRIM_SQL_PATTERN.matcher(str).replaceAll(" ");
        AppMethodBeat.o(3032);
        return replaceAll;
    }

    /* access modifiers changed from: package-private */
    public static final class PreparedStatement {
        private WeakReference<SQLiteConnection> mConnection;
        private boolean mInCache;
        private boolean mInUse;
        private int mNumParameters;
        private Operation mOperation;
        private PreparedStatement mPoolNext;
        private boolean mReadOnly;
        private String mSql;
        private long mStatementPtr;
        private int mType;

        PreparedStatement(SQLiteConnection sQLiteConnection) {
            AppMethodBeat.i(2969);
            this.mConnection = new WeakReference<>(sQLiteConnection);
            AppMethodBeat.o(2969);
        }

        public final void bindArguments(Object[] objArr) {
            AppMethodBeat.i(2970);
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2970);
                return;
            }
            SQLiteConnection.access$900(sQLiteConnection, this, objArr);
            AppMethodBeat.o(2970);
        }

        public final void reset(boolean z) {
            AppMethodBeat.i(2971);
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2971);
                return;
            }
            SQLiteConnection.access$1000(sQLiteConnection, this, z);
            AppMethodBeat.o(2971);
        }

        public final long getPtr() {
            return this.mStatementPtr;
        }

        public final String getSQL() {
            return this.mSql;
        }

        public final boolean isReadOnly() {
            return this.mReadOnly;
        }

        public final int getType() {
            return this.mType;
        }

        public final void attachCancellationSignal(CancellationSignal cancellationSignal) {
            AppMethodBeat.i(2972);
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2972);
                return;
            }
            SQLiteConnection.access$1100(sQLiteConnection, cancellationSignal);
            AppMethodBeat.o(2972);
        }

        public final void detachCancellationSignal(CancellationSignal cancellationSignal) {
            AppMethodBeat.i(2973);
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2973);
                return;
            }
            SQLiteConnection.access$1200(sQLiteConnection, cancellationSignal);
            AppMethodBeat.o(2973);
        }

        public final void beginOperation(String str, Object[] objArr) {
            AppMethodBeat.i(2974);
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2974);
                return;
            }
            this.mOperation = sQLiteConnection.mRecentOperations.beginOperation(str, this.mSql, objArr);
            this.mOperation.mType = this.mType;
            AppMethodBeat.o(2974);
        }

        public final void failOperation(Exception exc) {
            AppMethodBeat.i(2975);
            if (this.mOperation == null) {
                AppMethodBeat.o(2975);
                return;
            }
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2975);
                return;
            }
            sQLiteConnection.mRecentOperations.failOperation(this.mOperation.mCookie, exc);
            AppMethodBeat.o(2975);
        }

        public final void endOperation(String str) {
            AppMethodBeat.i(2976);
            if (this.mOperation == null) {
                AppMethodBeat.o(2976);
                return;
            }
            SQLiteConnection sQLiteConnection = this.mConnection.get();
            if (sQLiteConnection == null) {
                AppMethodBeat.o(2976);
                return;
            }
            if (sQLiteConnection.mRecentOperations.endOperationDeferLog(this.mOperation.mCookie)) {
                sQLiteConnection.mRecentOperations.logOperation(this.mOperation.mCookie, str);
            }
            this.mOperation = null;
            AppMethodBeat.o(2976);
        }
    }

    /* access modifiers changed from: package-private */
    public final class PreparedStatementCache extends LruCache<String, PreparedStatement> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.wcdb.support.LruCache
        public final /* bridge */ /* synthetic */ void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            AppMethodBeat.i(2979);
            entryRemoved(z, str, preparedStatement, preparedStatement2);
            AppMethodBeat.o(2979);
        }

        public PreparedStatementCache(int i2) {
            super(i2);
        }

        /* access modifiers changed from: protected */
        public final void entryRemoved(boolean z, String str, PreparedStatement preparedStatement, PreparedStatement preparedStatement2) {
            AppMethodBeat.i(2977);
            preparedStatement.mInCache = false;
            if (!preparedStatement.mInUse) {
                SQLiteConnection.access$1400(SQLiteConnection.this, preparedStatement);
            }
            AppMethodBeat.o(2977);
        }

        public final void dump(Printer printer) {
            AppMethodBeat.i(2978);
            printer.println("  Prepared statement cache:");
            Map snapshot = snapshot();
            if (!snapshot.isEmpty()) {
                int i2 = 0;
                for (Map.Entry entry : snapshot.entrySet()) {
                    PreparedStatement preparedStatement = (PreparedStatement) entry.getValue();
                    if (preparedStatement.mInCache) {
                        printer.println("    " + i2 + ": statementPtr=0x" + Long.toHexString(preparedStatement.getPtr()) + ", numParameters=" + preparedStatement.mNumParameters + ", type=" + preparedStatement.mType + ", readOnly=" + preparedStatement.mReadOnly + ", sql=\"" + SQLiteConnection.access$1500((String) entry.getKey()) + "\"");
                    }
                    i2++;
                }
                AppMethodBeat.o(2978);
                return;
            }
            printer.println("    <none>");
            AppMethodBeat.o(2978);
        }
    }

    /* access modifiers changed from: package-private */
    public final class OperationLog {
        private static final int COOKIE_GENERATION_SHIFT = 8;
        private static final int COOKIE_INDEX_MASK = 255;
        private static final int MAX_RECENT_OPERATIONS = 20;
        private int mGeneration;
        private int mIndex;
        private final Operation[] mOperations;

        private OperationLog() {
            AppMethodBeat.i(2957);
            this.mOperations = new Operation[20];
            AppMethodBeat.o(2957);
        }

        /* access modifiers changed from: package-private */
        public final Operation beginOperation(String str, String str2, Object[] objArr) {
            Operation operation;
            AppMethodBeat.i(2958);
            synchronized (this.mOperations) {
                try {
                    int i2 = (this.mIndex + 1) % 20;
                    operation = this.mOperations[i2];
                    if (operation == null) {
                        operation = new Operation();
                        this.mOperations[i2] = operation;
                    } else {
                        operation.mFinished = false;
                        operation.mException = null;
                        if (operation.mBindArgs != null) {
                            operation.mBindArgs.clear();
                        }
                    }
                    operation.mStartTime = System.currentTimeMillis();
                    operation.mKind = str;
                    operation.mSql = str2;
                    if (objArr != null) {
                        if (operation.mBindArgs == null) {
                            operation.mBindArgs = new ArrayList<>();
                        } else {
                            operation.mBindArgs.clear();
                        }
                        for (Object obj : objArr) {
                            if (obj == null || !(obj instanceof byte[])) {
                                operation.mBindArgs.add(obj);
                            } else {
                                operation.mBindArgs.add(SQLiteConnection.EMPTY_BYTE_ARRAY);
                            }
                        }
                    }
                    operation.mCookie = newOperationCookieLocked(i2);
                    operation.mTid = SQLiteConnection.this.mAcquiredTid;
                    this.mIndex = i2;
                } finally {
                    AppMethodBeat.o(2958);
                }
            }
            return operation;
        }

        /* access modifiers changed from: package-private */
        public final void failOperation(int i2, Exception exc) {
            AppMethodBeat.i(2959);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i2);
                    if (operationLocked != null) {
                        operationLocked.mException = exc;
                    }
                } finally {
                    AppMethodBeat.o(2959);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void endOperation(int i2) {
            String str;
            String str2;
            int i3;
            long j2;
            AppMethodBeat.i(2960);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i2);
                    if (endOperationDeferLogLocked(operationLocked)) {
                        logOperationLocked(operationLocked, null);
                    }
                    str = operationLocked.mSql;
                    str2 = operationLocked.mKind;
                    i3 = operationLocked.mType;
                    j2 = operationLocked.mEndTime - operationLocked.mStartTime;
                } finally {
                    AppMethodBeat.o(2960);
                }
            }
            if (!"prepare".equals(str2)) {
                SQLiteConnection.this.mPool.traceExecute(str, i3, j2);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean endOperationDeferLog(int i2) {
            boolean endOperationDeferLogLocked;
            AppMethodBeat.i(2961);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i2);
                    if (operationLocked == null) {
                        endOperationDeferLogLocked = false;
                    } else {
                        endOperationDeferLogLocked = endOperationDeferLogLocked(operationLocked);
                        String str = operationLocked.mSql;
                        String str2 = operationLocked.mKind;
                        int i3 = operationLocked.mType;
                        long j2 = operationLocked.mEndTime - operationLocked.mStartTime;
                        if (!"prepare".equals(str2)) {
                            SQLiteConnection.this.mPool.traceExecute(str, i3, j2);
                        }
                        AppMethodBeat.o(2961);
                    }
                } finally {
                    AppMethodBeat.o(2961);
                }
            }
            return endOperationDeferLogLocked;
        }

        /* access modifiers changed from: package-private */
        public final void logOperation(int i2, String str) {
            AppMethodBeat.i(2962);
            synchronized (this.mOperations) {
                try {
                    Operation operationLocked = getOperationLocked(i2);
                    if (operationLocked != null) {
                        logOperationLocked(operationLocked, str);
                    }
                } finally {
                    AppMethodBeat.o(2962);
                }
            }
        }

        private boolean endOperationDeferLogLocked(Operation operation) {
            AppMethodBeat.i(2963);
            if (operation != null) {
                operation.mEndTime = System.currentTimeMillis();
                operation.mFinished = true;
                if (operation.mException == null || operation.mException.getMessage() == null) {
                    boolean shouldLogSlowQuery = SQLiteDebug.shouldLogSlowQuery(operation.mEndTime - operation.mStartTime);
                    AppMethodBeat.o(2963);
                    return shouldLogSlowQuery;
                }
                AppMethodBeat.o(2963);
                return true;
            }
            AppMethodBeat.o(2963);
            return false;
        }

        private void logOperationLocked(Operation operation, String str) {
            AppMethodBeat.i(2964);
            StringBuilder sb = new StringBuilder();
            operation.describe(sb, false);
            if (str != null) {
                sb.append(", ").append(str);
            }
            Log.i(SQLiteConnection.TAG, sb.toString());
            AppMethodBeat.o(2964);
        }

        private int newOperationCookieLocked(int i2) {
            int i3 = this.mGeneration;
            this.mGeneration = i3 + 1;
            return (i3 << 8) | i2;
        }

        private Operation getOperationLocked(int i2) {
            Operation operation = this.mOperations[i2 & 255];
            if (operation.mCookie == i2) {
                return operation;
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public final String describeCurrentOperation() {
            String str;
            AppMethodBeat.i(2965);
            synchronized (this.mOperations) {
                try {
                    Operation operation = this.mOperations[this.mIndex];
                    if (operation == null || operation.mFinished) {
                        str = null;
                        AppMethodBeat.o(2965);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        operation.describe(sb, false);
                        str = sb.toString();
                    }
                } finally {
                    AppMethodBeat.o(2965);
                }
            }
            return str;
        }

        /* access modifiers changed from: package-private */
        public final SQLiteTrace.TraceInfo<String> traceCurrentOperation() {
            SQLiteTrace.TraceInfo<String> traceInfo;
            AppMethodBeat.i(2966);
            synchronized (this.mOperations) {
                try {
                    Operation operation = this.mOperations[this.mIndex];
                    if (operation == null || operation.mFinished) {
                        traceInfo = null;
                        AppMethodBeat.o(2966);
                    } else {
                        traceInfo = new SQLiteTrace.TraceInfo<>(operation.mSql, operation.mStartTime, operation.mTid);
                    }
                } finally {
                    AppMethodBeat.o(2966);
                }
            }
            return traceInfo;
        }

        /* access modifiers changed from: package-private */
        public final void dump(Printer printer, boolean z) {
            int i2;
            AppMethodBeat.i(2967);
            synchronized (this.mOperations) {
                try {
                    printer.println("  Most recently executed operations:");
                    int i3 = this.mIndex;
                    Operation operation = this.mOperations[i3];
                    if (operation != null) {
                        int i4 = 0;
                        while (true) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("    ").append(i4).append(": [");
                            sb.append(Operation.access$2000(operation));
                            sb.append("] ");
                            operation.describe(sb, z);
                            printer.println(sb.toString());
                            if (i3 > 0) {
                                i2 = i3 - 1;
                            } else {
                                i2 = 19;
                            }
                            i4++;
                            operation = this.mOperations[i2];
                            if (operation == null || i4 >= 20) {
                                break;
                            }
                            i3 = i2;
                        }
                    } else {
                        printer.println("    <none>");
                    }
                } finally {
                    AppMethodBeat.o(2967);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final JSONArray dumpJSON(boolean z) {
            AppMethodBeat.i(2968);
            JSONArray jSONArray = new JSONArray();
            synchronized (this.mOperations) {
                try {
                    int i2 = 0;
                    int i3 = this.mIndex;
                    while (true) {
                        Operation operation = this.mOperations[i3];
                        if (operation == null) {
                            break;
                        }
                        int i4 = i2 + 1;
                        if (i2 >= 20) {
                            break;
                        }
                        jSONArray.put(operation.dumpJSON(z));
                        i2 = i4;
                        i3 = i3 > 0 ? i3 - 1 : 19;
                    }
                } finally {
                    AppMethodBeat.o(2968);
                }
            }
            return jSONArray;
        }
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"SimpleDateFormat"})
    public static final class Operation {
        private static final SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        ArrayList<Object> mBindArgs;
        int mCookie;
        long mEndTime;
        Exception mException;
        boolean mFinished;
        String mKind;
        String mSql;
        long mStartTime;
        int mTid;
        int mType;

        private Operation() {
        }

        static /* synthetic */ String access$2000(Operation operation) {
            AppMethodBeat.i(2955);
            String formattedStartTime = operation.getFormattedStartTime();
            AppMethodBeat.o(2955);
            return formattedStartTime;
        }

        static {
            AppMethodBeat.i(2956);
            AppMethodBeat.o(2956);
        }

        public final void describe(StringBuilder sb, boolean z) {
            AppMethodBeat.i(2952);
            sb.append(this.mKind);
            if (this.mFinished) {
                sb.append(" took ").append(this.mEndTime - this.mStartTime).append(LocaleUtil.MALAY);
            } else {
                sb.append(" started ").append(System.currentTimeMillis() - this.mStartTime).append("ms ago");
            }
            sb.append(" - ").append(getStatus());
            if (this.mSql != null) {
                sb.append(", sql=\"").append(SQLiteConnection.access$1500(this.mSql)).append("\"");
            }
            if (this.mTid > 0) {
                sb.append(", tid=").append(this.mTid);
            }
            if (!(!z || this.mBindArgs == null || this.mBindArgs.size() == 0)) {
                sb.append(", bindArgs=[");
                int size = this.mBindArgs.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Object obj = this.mBindArgs.get(i2);
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    if (obj == null) {
                        sb.append(BuildConfig.COMMAND);
                    } else if (obj instanceof byte[]) {
                        sb.append("<byte[]>");
                    } else if (obj instanceof String) {
                        sb.append("\"").append((String) obj).append("\"");
                    } else {
                        sb.append(obj);
                    }
                }
                sb.append("]");
            }
            if (!(this.mException == null || this.mException.getMessage() == null)) {
                sb.append(", exception=\"").append(this.mException.getMessage()).append("\"");
            }
            AppMethodBeat.o(2952);
        }

        /* access modifiers changed from: package-private */
        public final JSONObject dumpJSON(boolean z) {
            long currentTimeMillis;
            AppMethodBeat.i(2953);
            JSONObject put = new JSONObject().put("start", this.mStartTime).put("kind", this.mKind);
            if (this.mFinished) {
                currentTimeMillis = this.mEndTime;
            } else {
                currentTimeMillis = System.currentTimeMillis();
            }
            JSONObject putOpt = put.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, currentTimeMillis - this.mStartTime).put("status", getStatus()).putOpt(SharePluginInfo.ISSUE_KEY_SQL, this.mSql).putOpt("tid", this.mTid > 0 ? Integer.valueOf(this.mTid) : null).putOpt("exception", this.mException);
            AppMethodBeat.o(2953);
            return putOpt;
        }

        private String getStatus() {
            if (!this.mFinished) {
                return "running";
            }
            return this.mException != null ? StateEvent.ProcessResult.FAILED : AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
        }

        private String getFormattedStartTime() {
            AppMethodBeat.i(2954);
            String format = sDateFormat.format(new Date(this.mStartTime));
            AppMethodBeat.o(2954);
            return format;
        }
    }
}
