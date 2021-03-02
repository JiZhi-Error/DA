package com.tencent.sqlitelint.behaviour.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;

public enum SQLiteLintDbHelper {
    INSTANCE;
    
    private static final String DB_NAME = "SQLiteLintInternal.db";
    private static final String TAG = "SQLiteLint.SQLiteLintOwnDatabase";
    private static final int VERSION_1 = 1;
    private volatile InternalDbHelper mHelper;

    public static SQLiteLintDbHelper valueOf(String str) {
        AppMethodBeat.i(52925);
        SQLiteLintDbHelper sQLiteLintDbHelper = (SQLiteLintDbHelper) Enum.valueOf(SQLiteLintDbHelper.class, str);
        AppMethodBeat.o(52925);
        return sQLiteLintDbHelper;
    }

    static {
        AppMethodBeat.i(52928);
        AppMethodBeat.o(52928);
    }

    public final SQLiteDatabase getDatabase() {
        AppMethodBeat.i(52926);
        if (this.mHelper == null) {
            IllegalStateException illegalStateException = new IllegalStateException("getIssueStorage db not ready");
            AppMethodBeat.o(52926);
            throw illegalStateException;
        }
        SQLiteDatabase writableDatabase = this.mHelper.getWritableDatabase();
        AppMethodBeat.o(52926);
        return writableDatabase;
    }

    public final void initialize(Context context) {
        AppMethodBeat.i(52927);
        if (this.mHelper == null) {
            synchronized (this) {
                try {
                    if (this.mHelper == null) {
                        this.mHelper = new InternalDbHelper(context);
                    }
                } finally {
                    AppMethodBeat.o(52927);
                }
            }
            return;
        }
        AppMethodBeat.o(52927);
    }

    /* access modifiers changed from: package-private */
    public static final class InternalDbHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "SQLiteLintInternal.db";
        private static final int VERSION_1 = 1;

        InternalDbHelper(Context context) {
            super(context, DB_NAME, (SQLiteDatabase.CursorFactory) null, 1);
        }

        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            AppMethodBeat.i(52923);
            SLog.i(SQLiteLintDbHelper.TAG, "onCreate", new Object[0]);
            sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_SQL);
            for (int i2 = 0; i2 < IssueStorage.DB_VERSION_1_CREATE_INDEX.length; i2++) {
                sQLiteDatabase.execSQL(IssueStorage.DB_VERSION_1_CREATE_INDEX[i2]);
            }
            AppMethodBeat.o(52923);
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        }
    }
}
