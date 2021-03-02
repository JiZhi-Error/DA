package com.tencent.wcdb.database;

import android.content.ContentValues;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Printer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.DefaultDatabaseErrorHandler;
import com.tencent.wcdb.SQLException;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.extension.SQLiteExtension;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class SQLiteDatabase extends SQLiteClosable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteDatabase.class.desiredAssertionStatus());
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
    public static final int CREATE_IF_NECESSARY = 268435456;
    public static final int ENABLE_IO_TRACE = 256;
    public static final int ENABLE_WRITE_AHEAD_LOGGING = 536870912;
    public static final int MAX_SQL_CACHE_SIZE = 100;
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    public static final int SYNCHRONOUS_EXTRA = 3;
    public static final int SYNCHRONOUS_FULL = 2;
    public static final int SYNCHRONOUS_NORMAL = 1;
    public static final int SYNCHRONOUS_OFF = 0;
    private static final String TAG = "WCDB.SQLiteDatabase";
    private static final WeakHashMap<SQLiteDatabase, Object> sActiveDatabases = new WeakHashMap<>();
    private final SQLiteDatabaseConfiguration mConfigurationLocked;
    private SQLiteConnectionPool mConnectionPoolLocked;
    private final CursorFactory mCursorFactory;
    private final DatabaseErrorHandler mErrorHandler;
    private boolean mHasAttachedDbsLocked;
    private final Object mLock = new Object();
    private final ThreadLocal<SQLiteSession> mThreadSession = new ThreadLocal<SQLiteSession>() {
        /* class com.tencent.wcdb.database.SQLiteDatabase.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SQLiteSession initialValue() {
            AppMethodBeat.i(3106);
            SQLiteSession createSession = SQLiteDatabase.this.createSession();
            AppMethodBeat.o(3106);
            return createSession;
        }
    };

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteProgram sQLiteProgram);

        SQLiteProgram newQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal);
    }

    public interface CustomFunction {
        void callback(String[] strArr);
    }

    static {
        AppMethodBeat.i(3225);
        SQLiteGlobal.loadLib();
        AppMethodBeat.o(3225);
    }

    private SQLiteDatabase(String str, int i2, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3109);
        this.mCursorFactory = cursorFactory;
        this.mErrorHandler = databaseErrorHandler == null ? new DefaultDatabaseErrorHandler(true) : databaseErrorHandler;
        this.mConfigurationLocked = new SQLiteDatabaseConfiguration(str, i2);
        AppMethodBeat.o(3109);
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(3110);
        try {
            dispose(true);
        } finally {
            super.finalize();
            AppMethodBeat.o(3110);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.wcdb.database.SQLiteClosable
    public final void onAllReferencesReleased() {
        AppMethodBeat.i(3111);
        dispose(false);
        AppMethodBeat.o(3111);
    }

    private void dispose(boolean z) {
        SQLiteConnectionPool sQLiteConnectionPool;
        AppMethodBeat.i(3112);
        synchronized (this.mLock) {
            try {
                sQLiteConnectionPool = this.mConnectionPoolLocked;
                this.mConnectionPoolLocked = null;
            } finally {
                AppMethodBeat.o(3112);
            }
        }
        if (!z) {
            synchronized (sActiveDatabases) {
                try {
                    sActiveDatabases.remove(this);
                } finally {
                    AppMethodBeat.o(3112);
                }
            }
            if (sQLiteConnectionPool != null) {
                sQLiteConnectionPool.close();
            }
        }
    }

    public static int releaseMemory() {
        AppMethodBeat.i(3113);
        int releaseMemory = SQLiteGlobal.releaseMemory();
        AppMethodBeat.o(3113);
        return releaseMemory;
    }

    @Deprecated
    public final void setLockingEnabled(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public final String getLabel() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.label;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    public final void onCorruption() {
        AppMethodBeat.i(3114);
        this.mErrorHandler.onCorruption(this);
        AppMethodBeat.o(3114);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteSession getThreadSession() {
        AppMethodBeat.i(3115);
        SQLiteSession sQLiteSession = this.mThreadSession.get();
        AppMethodBeat.o(3115);
        return sQLiteSession;
    }

    /* access modifiers changed from: package-private */
    public final SQLiteSession createSession() {
        SQLiteConnectionPool sQLiteConnectionPool;
        AppMethodBeat.i(3116);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                sQLiteConnectionPool = this.mConnectionPoolLocked;
            } catch (Throwable th) {
                AppMethodBeat.o(3116);
                throw th;
            }
        }
        SQLiteSession sQLiteSession = new SQLiteSession(sQLiteConnectionPool);
        AppMethodBeat.o(3116);
        return sQLiteSession;
    }

    /* access modifiers changed from: package-private */
    public final int getThreadDefaultConnectionFlags(boolean z) {
        AppMethodBeat.i(3117);
        int i2 = z ? 1 : 2;
        if (isMainThread()) {
            i2 |= 4;
        }
        AppMethodBeat.o(3117);
        return i2;
    }

    private static boolean isMainThread() {
        AppMethodBeat.i(3118);
        Looper myLooper = Looper.myLooper();
        if (myLooper == null || myLooper != Looper.getMainLooper()) {
            AppMethodBeat.o(3118);
            return false;
        }
        AppMethodBeat.o(3118);
        return true;
    }

    public final void beginTransaction() {
        AppMethodBeat.i(3119);
        beginTransaction(null, true);
        AppMethodBeat.o(3119);
    }

    public final void beginTransactionNonExclusive() {
        AppMethodBeat.i(3120);
        beginTransaction(null, false);
        AppMethodBeat.o(3120);
    }

    public final void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
        AppMethodBeat.i(3121);
        beginTransaction(sQLiteTransactionListener, true);
        AppMethodBeat.o(3121);
    }

    public final void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
        AppMethodBeat.i(3122);
        beginTransaction(sQLiteTransactionListener, false);
        AppMethodBeat.o(3122);
    }

    private void beginTransaction(SQLiteTransactionListener sQLiteTransactionListener, boolean z) {
        AppMethodBeat.i(3123);
        acquireReference();
        try {
            getThreadSession().beginTransaction(z ? 2 : 1, sQLiteTransactionListener, getThreadDefaultConnectionFlags(false), null);
        } finally {
            releaseReference();
            AppMethodBeat.o(3123);
        }
    }

    public final void endTransaction() {
        AppMethodBeat.i(3124);
        acquireReference();
        try {
            getThreadSession().endTransaction(null);
        } finally {
            releaseReference();
            AppMethodBeat.o(3124);
        }
    }

    public final void setTransactionSuccessful() {
        AppMethodBeat.i(3125);
        acquireReference();
        try {
            getThreadSession().setTransactionSuccessful();
        } finally {
            releaseReference();
            AppMethodBeat.o(3125);
        }
    }

    public final boolean inTransaction() {
        AppMethodBeat.i(3126);
        acquireReference();
        try {
            return getThreadSession().hasTransaction();
        } finally {
            releaseReference();
            AppMethodBeat.o(3126);
        }
    }

    public final boolean isDbLockedByCurrentThread() {
        AppMethodBeat.i(3127);
        acquireReference();
        try {
            return getThreadSession().hasConnection();
        } finally {
            releaseReference();
            AppMethodBeat.o(3127);
        }
    }

    @Deprecated
    public final boolean isDbLockedByOtherThreads() {
        return false;
    }

    @Deprecated
    public final boolean yieldIfContended() {
        AppMethodBeat.i(3128);
        boolean yieldIfContendedHelper = yieldIfContendedHelper(false, -1);
        AppMethodBeat.o(3128);
        return yieldIfContendedHelper;
    }

    public final boolean yieldIfContendedSafely() {
        AppMethodBeat.i(3129);
        boolean yieldIfContendedHelper = yieldIfContendedHelper(true, -1);
        AppMethodBeat.o(3129);
        return yieldIfContendedHelper;
    }

    public final boolean yieldIfContendedSafely(long j2) {
        AppMethodBeat.i(3130);
        boolean yieldIfContendedHelper = yieldIfContendedHelper(true, j2);
        AppMethodBeat.o(3130);
        return yieldIfContendedHelper;
    }

    private boolean yieldIfContendedHelper(boolean z, long j2) {
        AppMethodBeat.i(3131);
        acquireReference();
        try {
            return getThreadSession().yieldTransaction(j2, z, null);
        } finally {
            releaseReference();
            AppMethodBeat.o(3131);
        }
    }

    @Deprecated
    public final Map<String, String> getSyncedTables() {
        AppMethodBeat.i(3132);
        HashMap hashMap = new HashMap(0);
        AppMethodBeat.o(3132);
        return hashMap;
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2) {
        AppMethodBeat.i(3133);
        SQLiteDatabase openDatabase = openDatabase(str, cursorFactory, i2, null);
        AppMethodBeat.o(3133);
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler, int i3) {
        AppMethodBeat.i(3134);
        SQLiteDatabase sQLiteDatabase = new SQLiteDatabase(str, i2, cursorFactory, databaseErrorHandler);
        sQLiteDatabase.open(bArr, sQLiteCipherSpec, i3);
        AppMethodBeat.o(3134);
        return sQLiteDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3135);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, i2, databaseErrorHandler, 0);
        AppMethodBeat.o(3135);
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3136);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, i2, databaseErrorHandler, 0);
        AppMethodBeat.o(3136);
        return openDatabase;
    }

    public static SQLiteDatabase openDatabase(String str, CursorFactory cursorFactory, int i2, DatabaseErrorHandler databaseErrorHandler, int i3) {
        AppMethodBeat.i(3137);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, i2, databaseErrorHandler, i3);
        AppMethodBeat.o(3137);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, CursorFactory cursorFactory) {
        AppMethodBeat.i(3138);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), cursorFactory);
        AppMethodBeat.o(3138);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3139);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, sQLiteCipherSpec, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(3139);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(3140);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, sQLiteCipherSpec, cursorFactory, databaseErrorHandler, i2);
        AppMethodBeat.o(3140);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3141);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, (SQLiteCipherSpec) null, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(3141);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(File file, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(3142);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(file.getPath(), bArr, (SQLiteCipherSpec) null, cursorFactory, databaseErrorHandler, i2);
        AppMethodBeat.o(3142);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, int i2) {
        AppMethodBeat.i(3143);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 268435456, null, i2);
        AppMethodBeat.o(3143);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, CursorFactory cursorFactory) {
        AppMethodBeat.i(3144);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 805306368, null, 0);
        AppMethodBeat.o(3144);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, CursorFactory cursorFactory, int i2) {
        AppMethodBeat.i(3145);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 805306368, null, i2);
        AppMethodBeat.o(3145);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory) {
        AppMethodBeat.i(3146);
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, 268435456, null, 0);
        AppMethodBeat.o(3146);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, boolean z) {
        AppMethodBeat.i(3147);
        int i2 = 268435456;
        if (z) {
            i2 = 805306368;
        }
        SQLiteDatabase openDatabase = openDatabase(str, null, null, cursorFactory, i2, null, 0);
        AppMethodBeat.o(3147);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(3148);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 268435456, databaseErrorHandler, i2);
        AppMethodBeat.o(3148);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(3149);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 805306368, databaseErrorHandler, i2);
        AppMethodBeat.o(3149);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabaseInWalMode(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, CursorFactory cursorFactory) {
        AppMethodBeat.i(3150);
        SQLiteDatabase openDatabase = openDatabase(str, bArr, sQLiteCipherSpec, cursorFactory, 805306368, null, 0);
        AppMethodBeat.o(3150);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateMemoryDatabaseInWalMode(CursorFactory cursorFactory) {
        AppMethodBeat.i(3151);
        SQLiteDatabase openDatabase = openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, null, null, cursorFactory, 805306368, null, 0);
        AppMethodBeat.o(3151);
        return openDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler, int i2) {
        AppMethodBeat.i(3152);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(str, bArr, (SQLiteCipherSpec) null, cursorFactory, databaseErrorHandler, i2);
        AppMethodBeat.o(3152);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, byte[] bArr, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3153);
        SQLiteDatabase openOrCreateDatabase = openOrCreateDatabase(str, bArr, (SQLiteCipherSpec) null, cursorFactory, databaseErrorHandler, 0);
        AppMethodBeat.o(3153);
        return openOrCreateDatabase;
    }

    public static SQLiteDatabase openOrCreateDatabase(String str, CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        AppMethodBeat.i(3154);
        SQLiteDatabase openDatabase = openDatabase(str, cursorFactory, 268435456, databaseErrorHandler);
        AppMethodBeat.o(3154);
        return openDatabase;
    }

    public static boolean deleteDatabase(File file) {
        AppMethodBeat.i(3155);
        if (file == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("file must not be null");
            AppMethodBeat.o(3155);
            throw illegalArgumentException;
        }
        boolean delete = file.delete() | new File(file.getPath() + "-journal").delete() | new File(file.getPath() + "-shm").delete() | new File(file.getPath() + "-wal").delete();
        File parentFile = file.getParentFile();
        if (parentFile != null) {
            final String str = file.getName() + "-mj";
            File[] listFiles = parentFile.listFiles(new FileFilter() {
                /* class com.tencent.wcdb.database.SQLiteDatabase.AnonymousClass2 */

                public final boolean accept(File file) {
                    AppMethodBeat.i(3108);
                    boolean startsWith = file.getName().startsWith(str);
                    AppMethodBeat.o(3108);
                    return startsWith;
                }
            });
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    delete |= file2.delete();
                }
            }
        }
        AppMethodBeat.o(3155);
        return delete;
    }

    public final void reopenReadWrite() {
        AppMethodBeat.i(3156);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (isReadOnlyLocked()) {
                    int i2 = this.mConfigurationLocked.openFlags;
                    this.mConfigurationLocked.openFlags = (this.mConfigurationLocked.openFlags & -2) | 0;
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                        AppMethodBeat.o(3156);
                    } catch (RuntimeException e2) {
                        this.mConfigurationLocked.openFlags = i2;
                        AppMethodBeat.o(3156);
                        throw e2;
                    }
                }
            } finally {
                AppMethodBeat.o(3156);
            }
        }
    }

    private void open(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2) {
        AppMethodBeat.i(3157);
        try {
            openInner(bArr, sQLiteCipherSpec, i2);
            try {
                AppMethodBeat.o(3157);
            } catch (SQLiteException e2) {
                Log.e(TAG, "Failed to open database '" + getLabel() + "'.", e2);
                close();
                AppMethodBeat.o(3157);
                throw e2;
            }
        } catch (SQLiteDatabaseCorruptException e3) {
            onCorruption();
            openInner(bArr, sQLiteCipherSpec, i2);
            AppMethodBeat.o(3157);
        }
    }

    private void openInner(byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, int i2) {
        AppMethodBeat.i(3158);
        synchronized (this.mLock) {
            try {
                if ($assertionsDisabled || this.mConnectionPoolLocked == null) {
                    this.mConnectionPoolLocked = SQLiteConnectionPool.open(this, this.mConfigurationLocked, bArr, sQLiteCipherSpec, i2);
                } else {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(3158);
                    throw assertionError;
                }
            } finally {
                AppMethodBeat.o(3158);
            }
        }
        synchronized (sActiveDatabases) {
            try {
                sActiveDatabases.put(this, null);
            } finally {
                AppMethodBeat.o(3158);
            }
        }
    }

    public static SQLiteDatabase create(CursorFactory cursorFactory) {
        AppMethodBeat.i(3159);
        SQLiteDatabase openDatabase = openDatabase(SQLiteDatabaseConfiguration.MEMORY_DB_PATH, cursorFactory, 268435456);
        AppMethodBeat.o(3159);
        return openDatabase;
    }

    public final void addExtension(SQLiteExtension sQLiteExtension) {
        AppMethodBeat.i(3160);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (this.mConfigurationLocked.extensions.add(sQLiteExtension)) {
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                    } catch (RuntimeException e2) {
                        this.mConfigurationLocked.extensions.remove(sQLiteExtension);
                        AppMethodBeat.o(3160);
                        throw e2;
                    }
                }
            } finally {
                AppMethodBeat.o(3160);
            }
        }
    }

    public final int getVersion() {
        AppMethodBeat.i(3161);
        int intValue = Long.valueOf(DatabaseUtils.longForQuery(this, "PRAGMA user_version;", null)).intValue();
        AppMethodBeat.o(3161);
        return intValue;
    }

    public final void setVersion(int i2) {
        AppMethodBeat.i(3162);
        execSQL("PRAGMA user_version = ".concat(String.valueOf(i2)));
        AppMethodBeat.o(3162);
    }

    public final long getMaximumSize() {
        AppMethodBeat.i(3163);
        long longForQuery = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count;", null) * getPageSize();
        AppMethodBeat.o(3163);
        return longForQuery;
    }

    public final long setMaximumSize(long j2) {
        AppMethodBeat.i(3164);
        long pageSize = getPageSize();
        long j3 = j2 / pageSize;
        if (j2 % pageSize != 0) {
            j3++;
        }
        long longForQuery = DatabaseUtils.longForQuery(this, "PRAGMA max_page_count = ".concat(String.valueOf(j3)), null) * pageSize;
        AppMethodBeat.o(3164);
        return longForQuery;
    }

    public final long getPageSize() {
        AppMethodBeat.i(3165);
        long longForQuery = DatabaseUtils.longForQuery(this, "PRAGMA page_size;", null);
        AppMethodBeat.o(3165);
        return longForQuery;
    }

    public final void setPageSize(long j2) {
        AppMethodBeat.i(3166);
        execSQL("PRAGMA page_size = ".concat(String.valueOf(j2)));
        AppMethodBeat.o(3166);
    }

    @Deprecated
    public final void markTableSyncable(String str, String str2) {
    }

    @Deprecated
    public final void markTableSyncable(String str, String str2, String str3) {
    }

    public static String findEditTable(String str) {
        AppMethodBeat.i(3167);
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf(32);
            int indexOf2 = str.indexOf(44);
            if (indexOf > 0 && (indexOf < indexOf2 || indexOf2 < 0)) {
                String substring = str.substring(0, indexOf);
                AppMethodBeat.o(3167);
                return substring;
            } else if (indexOf2 <= 0 || (indexOf2 >= indexOf && indexOf >= 0)) {
                AppMethodBeat.o(3167);
                return str;
            } else {
                String substring2 = str.substring(0, indexOf2);
                AppMethodBeat.o(3167);
                return substring2;
            }
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid tables");
            AppMethodBeat.o(3167);
            throw illegalStateException;
        }
    }

    public final SQLiteStatement compileStatement(String str) {
        AppMethodBeat.i(3168);
        acquireReference();
        try {
            return new SQLiteStatement(this, str, null);
        } finally {
            releaseReference();
            AppMethodBeat.o(3168);
        }
    }

    public final Cursor query(boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(3169);
        Cursor queryWithFactory = queryWithFactory(null, z, str, strArr, str2, objArr, str3, str4, str5, str6, null);
        AppMethodBeat.o(3169);
        return queryWithFactory;
    }

    public final Cursor query(boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3170);
        Cursor queryWithFactory = queryWithFactory(null, z, str, strArr, str2, objArr, str3, str4, str5, str6, cancellationSignal);
        AppMethodBeat.o(3170);
        return queryWithFactory;
    }

    public final Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(3171);
        Cursor queryWithFactory = queryWithFactory(cursorFactory, z, str, strArr, str2, objArr, str3, str4, str5, str6, null);
        AppMethodBeat.o(3171);
        return queryWithFactory;
    }

    public final Cursor queryWithFactory(CursorFactory cursorFactory, boolean z, String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3172);
        acquireReference();
        try {
            return rawQueryWithFactory(cursorFactory, SQLiteQueryBuilder.buildQueryString(z, str, strArr, str2, str3, str4, str5, str6), objArr, findEditTable(str), cancellationSignal);
        } finally {
            releaseReference();
            AppMethodBeat.o(3172);
        }
    }

    public final Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5) {
        AppMethodBeat.i(3173);
        Cursor query = query(false, str, strArr, str2, objArr, str3, str4, str5, null);
        AppMethodBeat.o(3173);
        return query;
    }

    public final Cursor query(String str, String[] strArr, String str2, Object[] objArr, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(3174);
        Cursor query = query(false, str, strArr, str2, objArr, str3, str4, str5, str6);
        AppMethodBeat.o(3174);
        return query;
    }

    public final Cursor rawQuery(String str, Object[] objArr) {
        AppMethodBeat.i(3175);
        Cursor rawQueryWithFactory = rawQueryWithFactory(null, str, objArr, null, null);
        AppMethodBeat.o(3175);
        return rawQueryWithFactory;
    }

    public final Cursor rawQuery(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3176);
        Cursor rawQueryWithFactory = rawQueryWithFactory(null, str, objArr, null, cancellationSignal);
        AppMethodBeat.o(3176);
        return rawQueryWithFactory;
    }

    public final Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2) {
        AppMethodBeat.i(3177);
        Cursor rawQueryWithFactory = rawQueryWithFactory(cursorFactory, str, objArr, str2, null);
        AppMethodBeat.o(3177);
        return rawQueryWithFactory;
    }

    public final Cursor rawQueryWithFactory(CursorFactory cursorFactory, String str, Object[] objArr, String str2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3178);
        acquireReference();
        try {
            SQLiteDirectCursorDriver sQLiteDirectCursorDriver = new SQLiteDirectCursorDriver(this, str, str2, cancellationSignal);
            if (cursorFactory == null) {
                cursorFactory = this.mCursorFactory;
            }
            return sQLiteDirectCursorDriver.query(cursorFactory, objArr);
        } finally {
            releaseReference();
            AppMethodBeat.o(3178);
        }
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(3179);
        try {
            long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 0);
            AppMethodBeat.o(3179);
            return insertWithOnConflict;
        } catch (SQLiteDatabaseCorruptException e2) {
            AppMethodBeat.o(3179);
            throw e2;
        } catch (SQLException e3) {
            Log.e(TAG, "Error inserting %s: %s", contentValues, e3);
            AppMethodBeat.o(3179);
            return -1;
        }
    }

    public final long insertOrThrow(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(3180);
        long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 0);
        AppMethodBeat.o(3180);
        return insertWithOnConflict;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(3181);
        try {
            long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 5);
            AppMethodBeat.o(3181);
            return insertWithOnConflict;
        } catch (SQLiteDatabaseCorruptException e2) {
            AppMethodBeat.o(3181);
            throw e2;
        } catch (SQLException e3) {
            Log.e(TAG, "Error inserting ".concat(String.valueOf(contentValues)), e3);
            AppMethodBeat.o(3181);
            return -1;
        }
    }

    public final long replaceOrThrow(String str, String str2, ContentValues contentValues) {
        AppMethodBeat.i(3182);
        long insertWithOnConflict = insertWithOnConflict(str, str2, contentValues, 5);
        AppMethodBeat.o(3182);
        return insertWithOnConflict;
    }

    private Set<String> keySet(ContentValues contentValues) {
        AppMethodBeat.i(3183);
        if (Build.VERSION.SDK_INT < 11) {
            try {
                Field declaredField = Class.forName("android.content.ContentValues").getDeclaredField("mValues");
                declaredField.setAccessible(true);
                Set<String> keySet = ((HashMap) declaredField.get(contentValues)).keySet();
                AppMethodBeat.o(3183);
                return keySet;
            } catch (Exception e2) {
                RuntimeException runtimeException = new RuntimeException(e2);
                AppMethodBeat.o(3183);
                throw runtimeException;
            }
        } else {
            Set<String> keySet2 = contentValues.keySet();
            AppMethodBeat.o(3183);
            return keySet2;
        }
    }

    public final long insertWithOnConflict(String str, String str2, ContentValues contentValues, int i2) {
        int i3 = 0;
        AppMethodBeat.i(3184);
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT");
            sb.append(CONFLICT_VALUES[i2]);
            sb.append(" INTO ");
            sb.append(str);
            sb.append('(');
            Object[] objArr = null;
            int size = (contentValues == null || contentValues.size() <= 0) ? 0 : contentValues.size();
            if (size > 0) {
                Object[] objArr2 = new Object[size];
                int i4 = 0;
                for (String str3 : keySet(contentValues)) {
                    sb.append(i4 > 0 ? "," : "");
                    sb.append(str3);
                    objArr2[i4] = contentValues.get(str3);
                    i4++;
                }
                sb.append(')');
                sb.append(" VALUES (");
                while (i3 < size) {
                    sb.append(i3 > 0 ? ",?" : "?");
                    i3++;
                }
                objArr = objArr2;
            } else {
                sb.append(str2 + ") VALUES (NULL");
            }
            sb.append(')');
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr);
            try {
                long executeInsert = sQLiteStatement.executeInsert();
                sQLiteStatement.close();
                return executeInsert;
            } catch (Throwable th) {
                sQLiteStatement.close();
                AppMethodBeat.o(3184);
                throw th;
            }
        } finally {
            releaseReference();
            AppMethodBeat.o(3184);
        }
    }

    public final int delete(String str, String str2, String[] strArr) {
        AppMethodBeat.i(3185);
        acquireReference();
        try {
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, "DELETE FROM " + str + (!TextUtils.isEmpty(str2) ? " WHERE ".concat(String.valueOf(str2)) : ""), strArr);
            try {
                int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
                sQLiteStatement.close();
                return executeUpdateDelete;
            } catch (Throwable th) {
                sQLiteStatement.close();
                AppMethodBeat.o(3185);
                throw th;
            }
        } finally {
            releaseReference();
            AppMethodBeat.o(3185);
        }
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        AppMethodBeat.i(3186);
        int updateWithOnConflict = updateWithOnConflict(str, contentValues, str2, strArr, 0);
        AppMethodBeat.o(3186);
        return updateWithOnConflict;
    }

    public final int updateWithOnConflict(String str, ContentValues contentValues, String str2, String[] strArr, int i2) {
        AppMethodBeat.i(3187);
        if (contentValues == null || contentValues.size() == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Empty values");
            AppMethodBeat.o(3187);
            throw illegalArgumentException;
        }
        acquireReference();
        try {
            StringBuilder sb = new StringBuilder(120);
            sb.append("UPDATE ");
            sb.append(CONFLICT_VALUES[i2]);
            sb.append(str);
            sb.append(" SET ");
            int size = contentValues.size();
            int length = strArr == null ? size : strArr.length + size;
            Object[] objArr = new Object[length];
            int i3 = 0;
            for (String str3 : keySet(contentValues)) {
                sb.append(i3 > 0 ? "," : "");
                sb.append(str3);
                objArr[i3] = contentValues.get(str3);
                sb.append("=?");
                i3++;
            }
            if (strArr != null) {
                for (int i4 = size; i4 < length; i4++) {
                    objArr[i4] = strArr[i4 - size];
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append(" WHERE ");
                sb.append(str2);
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, sb.toString(), objArr);
            try {
                int executeUpdateDelete = sQLiteStatement.executeUpdateDelete();
                sQLiteStatement.close();
                return executeUpdateDelete;
            } catch (Throwable th) {
                sQLiteStatement.close();
                AppMethodBeat.o(3187);
                throw th;
            }
        } finally {
            releaseReference();
            AppMethodBeat.o(3187);
        }
    }

    public final void execSQL(String str) {
        AppMethodBeat.i(3188);
        executeSql(str, null, null);
        AppMethodBeat.o(3188);
    }

    public final void execSQL(String str, Object[] objArr) {
        AppMethodBeat.i(3189);
        executeSql(str, objArr, null);
        AppMethodBeat.o(3189);
    }

    public final void execSQL(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3190);
        executeSql(str, objArr, cancellationSignal);
        AppMethodBeat.o(3190);
    }

    private int executeSql(String str, Object[] objArr, CancellationSignal cancellationSignal) {
        boolean z = true;
        AppMethodBeat.i(3191);
        acquireReference();
        try {
            if (DatabaseUtils.getSqlStatementType(str) == 3) {
                synchronized (this.mLock) {
                    try {
                        if (!this.mHasAttachedDbsLocked) {
                            this.mHasAttachedDbsLocked = true;
                        } else {
                            z = false;
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(3191);
                        throw th;
                    }
                }
                if (z) {
                    disableWriteAheadLogging();
                }
            }
            SQLiteStatement sQLiteStatement = new SQLiteStatement(this, str, objArr);
            try {
                int executeUpdateDelete = sQLiteStatement.executeUpdateDelete(cancellationSignal);
                sQLiteStatement.close();
                return executeUpdateDelete;
            } catch (Throwable th2) {
                sQLiteStatement.close();
                AppMethodBeat.o(3191);
                throw th2;
            }
        } finally {
            releaseReference();
            AppMethodBeat.o(3191);
        }
    }

    public final Pair<Integer, Integer> walCheckpoint(String str, boolean z) {
        AppMethodBeat.i(3192);
        acquireReference();
        try {
            return getThreadSession().walCheckpoint(str, z ? 2 : 0);
        } finally {
            releaseReference();
            AppMethodBeat.o(3192);
        }
    }

    public final boolean isReadOnly() {
        boolean isReadOnlyLocked;
        AppMethodBeat.i(3193);
        synchronized (this.mLock) {
            try {
                isReadOnlyLocked = isReadOnlyLocked();
            } finally {
                AppMethodBeat.o(3193);
            }
        }
        return isReadOnlyLocked;
    }

    private boolean isReadOnlyLocked() {
        return (this.mConfigurationLocked.openFlags & 1) == 1;
    }

    public final boolean isInMemoryDatabase() {
        boolean isInMemoryDb;
        AppMethodBeat.i(3194);
        synchronized (this.mLock) {
            try {
                isInMemoryDb = this.mConfigurationLocked.isInMemoryDb();
            } finally {
                AppMethodBeat.o(3194);
            }
        }
        return isInMemoryDb;
    }

    public final boolean isOpen() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mConnectionPoolLocked != null;
        }
        return z;
    }

    public final boolean needUpgrade(int i2) {
        AppMethodBeat.i(3195);
        if (i2 > getVersion()) {
            AppMethodBeat.o(3195);
            return true;
        }
        AppMethodBeat.o(3195);
        return false;
    }

    public final String getPath() {
        String str;
        synchronized (this.mLock) {
            str = this.mConfigurationLocked.path;
        }
        return str;
    }

    public final void setLocale(Locale locale) {
        AppMethodBeat.i(3196);
        if (locale == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("locale must not be null.");
            AppMethodBeat.o(3196);
            throw illegalArgumentException;
        }
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                Locale locale2 = this.mConfigurationLocked.locale;
                this.mConfigurationLocked.locale = locale;
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                } catch (RuntimeException e2) {
                    this.mConfigurationLocked.locale = locale2;
                    AppMethodBeat.o(3196);
                    throw e2;
                }
            } finally {
                AppMethodBeat.o(3196);
            }
        }
    }

    public final void setMaxSqlCacheSize(int i2) {
        AppMethodBeat.i(3197);
        if (i2 > 100 || i2 < 0) {
            IllegalStateException illegalStateException = new IllegalStateException("expected value between 0 and 100");
            AppMethodBeat.o(3197);
            throw illegalStateException;
        }
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                int i3 = this.mConfigurationLocked.maxSqlCacheSize;
                this.mConfigurationLocked.maxSqlCacheSize = i2;
                try {
                    this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                } catch (RuntimeException e2) {
                    this.mConfigurationLocked.maxSqlCacheSize = i3;
                    AppMethodBeat.o(3197);
                    throw e2;
                }
            } finally {
                AppMethodBeat.o(3197);
            }
        }
    }

    public final void setForeignKeyConstraintsEnabled(boolean z) {
        AppMethodBeat.i(3198);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (this.mConfigurationLocked.foreignKeyConstraintsEnabled != z) {
                    this.mConfigurationLocked.foreignKeyConstraintsEnabled = z;
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                        AppMethodBeat.o(3198);
                    } catch (RuntimeException e2) {
                        this.mConfigurationLocked.foreignKeyConstraintsEnabled = !z;
                        AppMethodBeat.o(3198);
                        throw e2;
                    }
                }
            } finally {
                AppMethodBeat.o(3198);
            }
        }
    }

    public final SQLiteCheckpointListener getCheckpointCallback() {
        SQLiteCheckpointListener checkpointListener;
        AppMethodBeat.i(3199);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (!this.mConfigurationLocked.customWALHookEnabled) {
                    checkpointListener = null;
                } else {
                    checkpointListener = this.mConnectionPoolLocked.getCheckpointListener();
                    AppMethodBeat.o(3199);
                }
            } finally {
                AppMethodBeat.o(3199);
            }
        }
        return checkpointListener;
    }

    public final void setCheckpointCallback(SQLiteCheckpointListener sQLiteCheckpointListener) {
        boolean z = true;
        AppMethodBeat.i(3200);
        boolean z2 = sQLiteCheckpointListener != null;
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if (this.mConfigurationLocked.customWALHookEnabled != z2) {
                    this.mConfigurationLocked.customWALHookEnabled = z2;
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                    } catch (RuntimeException e2) {
                        SQLiteDatabaseConfiguration sQLiteDatabaseConfiguration = this.mConfigurationLocked;
                        if (z2) {
                            z = false;
                        }
                        sQLiteDatabaseConfiguration.customWALHookEnabled = z;
                        AppMethodBeat.o(3200);
                        throw e2;
                    }
                }
                this.mConnectionPoolLocked.setCheckpointListener(sQLiteCheckpointListener);
            } finally {
                AppMethodBeat.o(3200);
            }
        }
    }

    public final boolean getAsyncCheckpointEnabled() {
        AppMethodBeat.i(3201);
        SQLiteCheckpointListener checkpointCallback = getCheckpointCallback();
        if (checkpointCallback == null || !(checkpointCallback instanceof SQLiteAsyncCheckpointer)) {
            AppMethodBeat.o(3201);
            return false;
        }
        AppMethodBeat.o(3201);
        return true;
    }

    public final void setAsyncCheckpointEnabled(boolean z) {
        AppMethodBeat.i(3202);
        setCheckpointCallback(z ? new SQLiteAsyncCheckpointer() : null);
        AppMethodBeat.o(3202);
    }

    public final boolean enableWriteAheadLogging() {
        AppMethodBeat.i(3203);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if ((this.mConfigurationLocked.openFlags & 536870912) != 0) {
                    return true;
                }
                if (isReadOnlyLocked()) {
                    AppMethodBeat.o(3203);
                    return false;
                } else if (this.mConfigurationLocked.isInMemoryDb()) {
                    Log.i(TAG, "can't enable WAL for memory databases.");
                    AppMethodBeat.o(3203);
                    return false;
                } else if (this.mHasAttachedDbsLocked) {
                    Log.i(TAG, "this database: " + this.mConfigurationLocked.label + " has attached databases. can't  enable WAL.");
                    AppMethodBeat.o(3203);
                    return false;
                } else {
                    this.mConfigurationLocked.openFlags |= 536870912;
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                        AppMethodBeat.o(3203);
                        return true;
                    } catch (RuntimeException e2) {
                        this.mConfigurationLocked.openFlags &= -536870913;
                        AppMethodBeat.o(3203);
                        throw e2;
                    }
                }
            } finally {
                AppMethodBeat.o(3203);
            }
        }
    }

    public final void disableWriteAheadLogging() {
        AppMethodBeat.i(3204);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                if ((this.mConfigurationLocked.openFlags & 536870912) != 0) {
                    this.mConfigurationLocked.openFlags &= -536870913;
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                        AppMethodBeat.o(3204);
                    } catch (RuntimeException e2) {
                        this.mConfigurationLocked.openFlags |= 536870912;
                        AppMethodBeat.o(3204);
                        throw e2;
                    }
                }
            } finally {
                AppMethodBeat.o(3204);
            }
        }
    }

    public final boolean isWriteAheadLoggingEnabled() {
        boolean z;
        AppMethodBeat.i(3205);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                z = (this.mConfigurationLocked.openFlags & 536870912) != 0;
            } finally {
                AppMethodBeat.o(3205);
            }
        }
        return z;
    }

    public final int getSynchronousMode() {
        int i2;
        AppMethodBeat.i(3206);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                i2 = this.mConfigurationLocked.synchronousMode;
            } finally {
                AppMethodBeat.o(3206);
            }
        }
        return i2;
    }

    public final void setSynchronousMode(int i2) {
        AppMethodBeat.i(3207);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                int i3 = this.mConfigurationLocked.synchronousMode;
                if (i3 != i2) {
                    this.mConfigurationLocked.synchronousMode = i2;
                    try {
                        this.mConnectionPoolLocked.reconfigure(this.mConfigurationLocked);
                    } catch (RuntimeException e2) {
                        this.mConfigurationLocked.synchronousMode = i3;
                        AppMethodBeat.o(3207);
                        throw e2;
                    }
                }
            } finally {
                AppMethodBeat.o(3207);
            }
        }
    }

    public final SQLiteChangeListener getChangeListener() {
        SQLiteChangeListener changeListener;
        AppMethodBeat.i(3208);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                changeListener = this.mConnectionPoolLocked.getChangeListener();
            } finally {
                AppMethodBeat.o(3208);
            }
        }
        return changeListener;
    }

    public final void setChangeListener(SQLiteChangeListener sQLiteChangeListener, boolean z) {
        AppMethodBeat.i(3209);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConnectionPoolLocked.setChangeListener(sQLiteChangeListener, z);
            } finally {
                AppMethodBeat.o(3209);
            }
        }
    }

    public final SQLiteTrace getTraceCallback() {
        SQLiteTrace traceCallback;
        AppMethodBeat.i(3210);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                traceCallback = this.mConnectionPoolLocked.getTraceCallback();
            } finally {
                AppMethodBeat.o(3210);
            }
        }
        return traceCallback;
    }

    public final void setTraceCallback(SQLiteTrace sQLiteTrace) {
        AppMethodBeat.i(3211);
        synchronized (this.mLock) {
            try {
                throwIfNotOpenLocked();
                this.mConnectionPoolLocked.setTraceCallback(sQLiteTrace);
            } finally {
                AppMethodBeat.o(3211);
            }
        }
    }

    static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        AppMethodBeat.i(3212);
        ArrayList<SQLiteDebug.DbStats> arrayList = new ArrayList<>();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            it.next().collectDbStats(arrayList);
        }
        AppMethodBeat.o(3212);
        return arrayList;
    }

    private void collectDbStats(ArrayList<SQLiteDebug.DbStats> arrayList) {
        AppMethodBeat.i(3213);
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    this.mConnectionPoolLocked.collectDbStats(arrayList);
                }
            } finally {
                AppMethodBeat.o(3213);
            }
        }
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        AppMethodBeat.i(3214);
        ArrayList<SQLiteDatabase> arrayList = new ArrayList<>();
        synchronized (sActiveDatabases) {
            try {
                arrayList.addAll(sActiveDatabases.keySet());
            } finally {
                AppMethodBeat.o(3214);
            }
        }
        return arrayList;
    }

    public static void dumpAll(Printer printer, boolean z) {
        AppMethodBeat.i(3215);
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            it.next().dump(printer, z);
        }
        AppMethodBeat.o(3215);
    }

    public static JSONArray dumpAllJSON(boolean z) {
        AppMethodBeat.i(3216);
        JSONArray jSONArray = new JSONArray();
        Iterator<SQLiteDatabase> it = getActiveDatabases().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().dumpJSON(z));
        }
        AppMethodBeat.o(3216);
        return jSONArray;
    }

    public final void dump(Printer printer, boolean z) {
        AppMethodBeat.i(3217);
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    this.mConnectionPoolLocked.dump(printer, z);
                }
            } finally {
                AppMethodBeat.o(3217);
            }
        }
    }

    public final JSONObject dumpJSON(boolean z) {
        JSONObject jSONObject;
        AppMethodBeat.i(3218);
        synchronized (this.mLock) {
            try {
                if (this.mConnectionPoolLocked != null) {
                    jSONObject = this.mConnectionPoolLocked.dumpJSON(z);
                } else {
                    jSONObject = new JSONObject();
                    AppMethodBeat.o(3218);
                }
            } finally {
                AppMethodBeat.o(3218);
            }
        }
        return jSONObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2 = rawQuery("pragma database_list;", null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        if (r2.moveToNext() == false) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0042, code lost:
        r1.add(new android.util.Pair(r2.getString(1), r2.getString(2)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r2 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(3219);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0061, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0063, code lost:
        releaseReference();
        com.tencent.matrix.trace.core.AppMethodBeat.o(3219);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0069, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        if (r2 == null) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0072, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0075, code lost:
        releaseReference();
        com.tencent.matrix.trace.core.AppMethodBeat.o(3219);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x007e, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[SYNTHETIC, Splitter:B:24:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<java.lang.String, java.lang.String>> getAttachedDbs() {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.database.SQLiteDatabase.getAttachedDbs():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isDatabaseIntegrityOk() {
        /*
        // Method dump skipped, instructions count: 225
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wcdb.database.SQLiteDatabase.isDatabaseIntegrityOk():boolean");
    }

    public final long acquireNativeConnectionHandle(String str, boolean z, boolean z2) {
        AppMethodBeat.i(3221);
        if (str == null) {
            str = "unnamedNative";
        }
        int i2 = z ? 1 : 2;
        if (z2) {
            i2 |= 4;
        }
        long nativeHandle = getThreadSession().acquireConnectionForNativeHandle(i2).getNativeHandle(str);
        if (nativeHandle == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("SQLiteConnection native handle not initialized.");
            AppMethodBeat.o(3221);
            throw illegalStateException;
        }
        AppMethodBeat.o(3221);
        return nativeHandle;
    }

    public final void releaseNativeConnection(long j2, Exception exc) {
        AppMethodBeat.i(3222);
        getThreadSession().releaseConnectionForNativeHandle(exc);
        AppMethodBeat.o(3222);
    }

    public final String toString() {
        AppMethodBeat.i(3223);
        String str = "SQLiteDatabase: " + getPath();
        AppMethodBeat.o(3223);
        return str;
    }

    private void throwIfNotOpenLocked() {
        AppMethodBeat.i(3224);
        if (this.mConnectionPoolLocked == null) {
            IllegalStateException illegalStateException = new IllegalStateException("The database '" + this.mConfigurationLocked.label + "' is not open.");
            AppMethodBeat.o(3224);
            throw illegalStateException;
        }
        AppMethodBeat.o(3224);
    }
}
