package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteDirectCursorDriver implements SQLiteCursorDriver {
    private static SQLiteDatabase.CursorFactory DEFAULT_FACTORY = SQLiteCursor.FACTORY;
    private final CancellationSignal mCancellationSignal;
    private final SQLiteDatabase mDatabase;
    private final String mEditTable;
    private SQLiteProgram mQuery;
    private final String mSql;

    public SQLiteDirectCursorDriver(SQLiteDatabase sQLiteDatabase, String str, String str2, CancellationSignal cancellationSignal) {
        this.mDatabase = sQLiteDatabase;
        this.mEditTable = str2;
        this.mSql = str;
        this.mCancellationSignal = cancellationSignal;
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public final Cursor query(SQLiteDatabase.CursorFactory cursorFactory, Object[] objArr) {
        AppMethodBeat.i(3256);
        if (cursorFactory == null) {
            cursorFactory = DEFAULT_FACTORY;
        }
        SQLiteProgram sQLiteProgram = null;
        try {
            sQLiteProgram = cursorFactory.newQuery(this.mDatabase, this.mSql, objArr, this.mCancellationSignal);
            Cursor newCursor = cursorFactory.newCursor(this.mDatabase, this, this.mEditTable, sQLiteProgram);
            this.mQuery = sQLiteProgram;
            AppMethodBeat.o(3256);
            return newCursor;
        } catch (RuntimeException e2) {
            if (sQLiteProgram != null) {
                sQLiteProgram.close();
            }
            AppMethodBeat.o(3256);
            throw e2;
        }
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public final void cursorClosed() {
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public final void setBindArguments(String[] strArr) {
        AppMethodBeat.i(3257);
        this.mQuery.bindAllArgsAsStrings(strArr);
        AppMethodBeat.o(3257);
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public final void cursorDeactivated() {
    }

    @Override // com.tencent.wcdb.database.SQLiteCursorDriver
    public final void cursorRequeried(Cursor cursor) {
    }

    public final String toString() {
        AppMethodBeat.i(3258);
        String str = "SQLiteDirectCursorDriver: " + this.mSql;
        AppMethodBeat.o(3258);
        return str;
    }
}
