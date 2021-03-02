package com.tencent.sqlitelint;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;

public final class SimpleSQLiteExecutionDelegate implements ISQLiteExecutionDelegate {
    static final /* synthetic */ boolean $assertionsDisabled = (!SimpleSQLiteExecutionDelegate.class.desiredAssertionStatus());
    private static final String TAG = "SQLiteLint.SimpleSQLiteExecutionDelegate";
    private final SQLiteDatabase mDb;

    static {
        AppMethodBeat.i(52879);
        AppMethodBeat.o(52879);
    }

    public SimpleSQLiteExecutionDelegate(SQLiteDatabase sQLiteDatabase) {
        AppMethodBeat.i(52876);
        if ($assertionsDisabled || sQLiteDatabase != null) {
            this.mDb = sQLiteDatabase;
            AppMethodBeat.o(52876);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52876);
        throw assertionError;
    }

    @Override // com.tencent.sqlitelint.ISQLiteExecutionDelegate
    public final Cursor rawQuery(String str, String... strArr) {
        AppMethodBeat.i(52877);
        if (!this.mDb.isOpen()) {
            SLog.w(TAG, "rawQuery db close", new Object[0]);
            AppMethodBeat.o(52877);
            return null;
        }
        Cursor rawQuery = this.mDb.rawQuery(str, strArr);
        AppMethodBeat.o(52877);
        return rawQuery;
    }

    @Override // com.tencent.sqlitelint.ISQLiteExecutionDelegate
    public final void execSQL(String str) {
        AppMethodBeat.i(52878);
        if (!this.mDb.isOpen()) {
            SLog.w(TAG, "rawQuery db close", new Object[0]);
            AppMethodBeat.o(52878);
            return;
        }
        this.mDb.execSQL(str);
        AppMethodBeat.o(52878);
    }
}
