package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteStatement extends SQLiteProgram {
    SQLiteStatement(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr) {
        super(sQLiteDatabase, str, objArr, null);
    }

    public final void execute() {
        AppMethodBeat.i(3315);
        execute(null);
        AppMethodBeat.o(3315);
    }

    public final void execute(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3316);
        acquireReference();
        try {
            getSession().execute(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(3316);
        } catch (SQLiteException e2) {
            checkCorruption(e2);
            AppMethodBeat.o(3316);
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(3316);
            throw th;
        }
    }

    public final int executeUpdateDelete() {
        AppMethodBeat.i(3317);
        int executeUpdateDelete = executeUpdateDelete(null);
        AppMethodBeat.o(3317);
        return executeUpdateDelete;
    }

    public final int executeUpdateDelete(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3318);
        acquireReference();
        try {
            int executeForChangedRowCount = getSession().executeForChangedRowCount(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(3318);
            return executeForChangedRowCount;
        } catch (SQLiteDatabaseCorruptException e2) {
            checkCorruption(e2);
            AppMethodBeat.o(3318);
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(3318);
            throw th;
        }
    }

    public final long executeInsert() {
        AppMethodBeat.i(3319);
        long executeInsert = executeInsert(null);
        AppMethodBeat.o(3319);
        return executeInsert;
    }

    public final long executeInsert(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3320);
        acquireReference();
        try {
            long executeForLastInsertedRowId = getSession().executeForLastInsertedRowId(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(3320);
            return executeForLastInsertedRowId;
        } catch (SQLiteDatabaseCorruptException e2) {
            checkCorruption(e2);
            AppMethodBeat.o(3320);
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(3320);
            throw th;
        }
    }

    public final long simpleQueryForLong() {
        AppMethodBeat.i(3321);
        long simpleQueryForLong = simpleQueryForLong(null);
        AppMethodBeat.o(3321);
        return simpleQueryForLong;
    }

    public final long simpleQueryForLong(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3322);
        acquireReference();
        try {
            long executeForLong = getSession().executeForLong(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(3322);
            return executeForLong;
        } catch (SQLiteDatabaseCorruptException e2) {
            checkCorruption(e2);
            AppMethodBeat.o(3322);
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(3322);
            throw th;
        }
    }

    public final String simpleQueryForString() {
        AppMethodBeat.i(3323);
        String simpleQueryForString = simpleQueryForString(null);
        AppMethodBeat.o(3323);
        return simpleQueryForString;
    }

    public final String simpleQueryForString(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3324);
        acquireReference();
        try {
            String executeForString = getSession().executeForString(getSql(), getBindArgs(), getConnectionFlags(), cancellationSignal);
            releaseReference();
            AppMethodBeat.o(3324);
            return executeForString;
        } catch (SQLiteDatabaseCorruptException e2) {
            checkCorruption(e2);
            AppMethodBeat.o(3324);
            throw e2;
        } catch (Throwable th) {
            releaseReference();
            AppMethodBeat.o(3324);
            throw th;
        }
    }

    public final String toString() {
        AppMethodBeat.i(3325);
        String str = "SQLiteProgram: " + getSql();
        AppMethodBeat.o(3325);
        return str;
    }
}
