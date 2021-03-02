package com.tencent.sqlitelint.behaviour.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;

public enum SQLiteLintOwnDatabase {
    INSTANCE;
    
    private static final String DATABASE_DIRECTORY = "database";
    private static final String DATABASE_NAME = "own.db";
    private static final int NEW_VERSION = 1;
    private static final String ROOT_PATH = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
    private static final String TAG = "SQLiteLint.SQLiteLintOwnDatabase";
    private static final int VERSION_1 = 1;
    private static String sOwnDbDirectory = "";
    private volatile SQLiteDatabase mDatabase;
    private boolean mIsInitializing;

    public static SQLiteLintOwnDatabase valueOf(String str) {
        AppMethodBeat.i(52930);
        SQLiteLintOwnDatabase sQLiteLintOwnDatabase = (SQLiteLintOwnDatabase) Enum.valueOf(SQLiteLintOwnDatabase.class, str);
        AppMethodBeat.o(52930);
        return sQLiteLintOwnDatabase;
    }

    static {
        AppMethodBeat.i(52937);
        AppMethodBeat.o(52937);
    }

    public final SQLiteDatabase getDatabase() {
        AppMethodBeat.i(52931);
        if (this.mDatabase == null || !this.mDatabase.isOpen()) {
            synchronized (this) {
                try {
                    if (this.mDatabase == null || !this.mDatabase.isOpen()) {
                        this.mDatabase = openOrCreateDatabase();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(52931);
                    throw th;
                }
            }
        }
        SQLiteDatabase sQLiteDatabase = this.mDatabase;
        AppMethodBeat.o(52931);
        return sQLiteDatabase;
    }

    public final synchronized void closeDatabase() {
        AppMethodBeat.i(52932);
        if (this.mIsInitializing) {
            IllegalStateException illegalStateException = new IllegalStateException("Closed during initialization");
            AppMethodBeat.o(52932);
            throw illegalStateException;
        }
        if (this.mDatabase != null && this.mDatabase.isOpen()) {
            this.mDatabase.close();
            this.mDatabase = null;
        }
        AppMethodBeat.o(52932);
    }

    private void onCreate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(52933);
        SLog.i(TAG, "onCreate", new Object[0]);
        sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_SQL);
        for (int i2 = 0; i2 < IssueStorage.DB_VERSION_1_CREATE_INDEX.length; i2++) {
            sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_INDEX[i2]);
        }
        AppMethodBeat.o(52933);
    }

    private void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2) {
        AppMethodBeat.i(52934);
        SLog.i(TAG, "onUpgrade oldVersion=%d, newVersion=%d", Integer.valueOf(i2), 1);
        AppMethodBeat.o(52934);
    }

    private SQLiteDatabase openOrCreateDatabase() {
        AppMethodBeat.i(52935);
        if (this.mIsInitializing) {
            IllegalStateException illegalStateException = new IllegalStateException("getDatabase called recursively");
            AppMethodBeat.o(52935);
            throw illegalStateException;
        } else if (SQLiteLintUtil.isNullOrNil(sOwnDbDirectory)) {
            IllegalStateException illegalStateException2 = new IllegalStateException("OwnDbDirectory not init");
            AppMethodBeat.o(52935);
            throw illegalStateException2;
        } else {
            try {
                this.mIsInitializing = true;
                String format = String.format("%s/%s", sOwnDbDirectory, DATABASE_NAME);
                SLog.i(TAG, "openOrCreateDatabase path=%s", format);
                SQLiteLintUtil.mkdirs(format);
                SQLiteDatabase openDatabase = SQLiteDatabase.openDatabase(format, null, 268435456, null);
                int version = openDatabase.getVersion();
                if (version != 1) {
                    openDatabase.beginTransaction();
                    if (version == 0) {
                        try {
                            onCreate(openDatabase);
                        } catch (Throwable th) {
                            openDatabase.endTransaction();
                            AppMethodBeat.o(52935);
                            throw th;
                        }
                    } else if (version != 1) {
                        onUpgrade(openDatabase, version);
                    }
                    openDatabase.setVersion(1);
                    openDatabase.setTransactionSuccessful();
                    openDatabase.endTransaction();
                }
                return openDatabase;
            } finally {
                this.mIsInitializing = false;
                AppMethodBeat.o(52935);
            }
        }
    }

    public static void setOwnDbDirectory(Context context) {
        AppMethodBeat.i(52936);
        if (!SQLiteLintUtil.isNullOrNil(sOwnDbDirectory)) {
            AppMethodBeat.o(52936);
            return;
        }
        sOwnDbDirectory = String.format("%s/SQLiteLint-%s/%s/", ROOT_PATH, context.getPackageManager(), DATABASE_DIRECTORY);
        AppMethodBeat.o(52936);
    }
}
