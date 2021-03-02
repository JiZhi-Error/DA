package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public final class SQLiteQuery extends SQLiteProgram {
    private static final String TAG = "WCDB.SQLiteQuery";
    private final CancellationSignal mCancellationSignal;

    SQLiteQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    /* access modifiers changed from: package-private */
    public final int fillWindow(CursorWindow cursorWindow, int i2, int i3, boolean z) {
        AppMethodBeat.i(3269);
        acquireReference();
        try {
            cursorWindow.acquireReference();
            try {
                int executeForCursorWindow = getSession().executeForCursorWindow(getSql(), getBindArgs(), cursorWindow, i2, i3, z, getConnectionFlags(), this.mCancellationSignal);
                cursorWindow.releaseReference();
                return executeForCursorWindow;
            } catch (SQLiteException e2) {
                Log.e(TAG, "exception: " + e2.getMessage() + "; query: " + getSql());
                checkCorruption(e2);
                AppMethodBeat.o(3269);
                throw e2;
            } catch (Throwable th) {
                cursorWindow.releaseReference();
                AppMethodBeat.o(3269);
                throw th;
            }
        } finally {
            releaseReference();
            AppMethodBeat.o(3269);
        }
    }

    public final String toString() {
        AppMethodBeat.i(3270);
        String str = "SQLiteQuery: " + getSql();
        AppMethodBeat.o(3270);
        return str;
    }
}
