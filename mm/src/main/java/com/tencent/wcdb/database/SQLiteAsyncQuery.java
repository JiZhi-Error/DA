package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteAsyncQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteAsyncQuery";
    private final int mResultColumns = getColumnNames().length;

    private static native int nativeCount(long j2);

    private static native int nativeFillRows(long j2, long j3, int i2, int i3);

    public SQLiteAsyncQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
        AppMethodBeat.i(2945);
        AppMethodBeat.o(2945);
    }

    /* access modifiers changed from: package-private */
    public void acquire() {
        AppMethodBeat.i(2946);
        if (this.mPreparedStatement == null) {
            acquirePreparedStatement(true);
            this.mPreparedStatement.bindArguments(getBindArgs());
        }
        AppMethodBeat.o(2946);
    }

    /* access modifiers changed from: package-private */
    public void release() {
        AppMethodBeat.i(2947);
        releasePreparedStatement();
        AppMethodBeat.o(2947);
    }

    /* access modifiers changed from: package-private */
    public int fillRows(ChunkedCursorWindow chunkedCursorWindow, int i2, int i3) {
        AppMethodBeat.i(2948);
        acquire();
        if (chunkedCursorWindow.getNumColumns() != this.mResultColumns) {
            chunkedCursorWindow.setNumColumns(this.mResultColumns);
        }
        try {
            int nativeFillRows = nativeFillRows(this.mPreparedStatement.getPtr(), chunkedCursorWindow.mWindowPtr, i2, i3);
            AppMethodBeat.o(2948);
            return nativeFillRows;
        } catch (SQLiteException e2) {
            Log.e(TAG, "Got exception on fillRows: " + e2.getMessage() + ", SQL: " + getSql());
            checkCorruption(e2);
            AppMethodBeat.o(2948);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getCount() {
        AppMethodBeat.i(2949);
        acquire();
        try {
            int nativeCount = nativeCount(this.mPreparedStatement.getPtr());
            AppMethodBeat.o(2949);
            return nativeCount;
        } catch (SQLiteException e2) {
            Log.e(TAG, "Got exception on getCount: " + e2.getMessage() + ", SQL: " + getSql());
            checkCorruption(e2);
            AppMethodBeat.o(2949);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        AppMethodBeat.i(2950);
        if (this.mPreparedStatement != null) {
            this.mPreparedStatement.reset(false);
        }
        AppMethodBeat.o(2950);
    }
}
