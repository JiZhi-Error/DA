package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteConnection;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteSession {
    static final /* synthetic */ boolean $assertionsDisabled = (!SQLiteSession.class.desiredAssertionStatus());
    public static final int TRANSACTION_MODE_DEFERRED = 0;
    public static final int TRANSACTION_MODE_EXCLUSIVE = 2;
    public static final int TRANSACTION_MODE_IMMEDIATE = 1;
    private SQLiteConnection mConnection;
    private int mConnectionFlags;
    private final SQLiteConnectionPool mConnectionPool;
    private int mConnectionUseCount;
    private Transaction mTransactionPool;
    private Transaction mTransactionStack;

    static {
        AppMethodBeat.i(3314);
        AppMethodBeat.o(3314);
    }

    public SQLiteSession(SQLiteConnectionPool sQLiteConnectionPool) {
        AppMethodBeat.i(3287);
        if (sQLiteConnectionPool == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("connectionPool must not be null");
            AppMethodBeat.o(3287);
            throw illegalArgumentException;
        }
        this.mConnectionPool = sQLiteConnectionPool;
        AppMethodBeat.o(3287);
    }

    public final boolean hasTransaction() {
        return this.mTransactionStack != null;
    }

    public final boolean hasNestedTransaction() {
        return (this.mTransactionStack == null || this.mTransactionStack.mParent == null) ? false : true;
    }

    public final boolean hasConnection() {
        return this.mConnection != null;
    }

    public final void beginTransaction(int i2, SQLiteTransactionListener sQLiteTransactionListener, int i3, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3288);
        throwIfTransactionMarkedSuccessful();
        beginTransactionUnchecked(i2, sQLiteTransactionListener, i3, cancellationSignal);
        AppMethodBeat.o(3288);
    }

    private void beginTransactionUnchecked(int i2, SQLiteTransactionListener sQLiteTransactionListener, int i3, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3289);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (this.mTransactionStack == null) {
            acquireConnection(null, i3, true, cancellationSignal);
        }
        try {
            if (this.mTransactionStack == null) {
                switch (i2) {
                    case 1:
                        this.mConnection.execute("BEGIN IMMEDIATE;", null, cancellationSignal);
                        break;
                    case 2:
                        this.mConnection.execute("BEGIN EXCLUSIVE;", null, cancellationSignal);
                        break;
                    default:
                        this.mConnection.execute("BEGIN;", null, cancellationSignal);
                        break;
                }
            }
            if (sQLiteTransactionListener != null) {
                try {
                    sQLiteTransactionListener.onBegin();
                } catch (RuntimeException e2) {
                    if (this.mTransactionStack == null) {
                        this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
                    }
                    AppMethodBeat.o(3289);
                    throw e2;
                }
            }
            Transaction obtainTransaction = obtainTransaction(i2, sQLiteTransactionListener);
            obtainTransaction.mParent = this.mTransactionStack;
            this.mTransactionStack = obtainTransaction;
            if (this.mTransactionStack == null) {
                releaseConnection();
                AppMethodBeat.o(3289);
                return;
            }
            AppMethodBeat.o(3289);
        } catch (Throwable th) {
            if (this.mTransactionStack == null) {
                releaseConnection();
            }
            AppMethodBeat.o(3289);
            throw th;
        }
    }

    public final void setTransactionSuccessful() {
        AppMethodBeat.i(3290);
        throwIfNoTransaction();
        throwIfTransactionMarkedSuccessful();
        this.mTransactionStack.mMarkedSuccessful = true;
        AppMethodBeat.o(3290);
    }

    public final void endTransaction(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3291);
        throwIfNoTransaction();
        if ($assertionsDisabled || this.mConnection != null) {
            endTransactionUnchecked(cancellationSignal, false);
            AppMethodBeat.o(3291);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(3291);
        throw assertionError;
    }

    private void endTransactionUnchecked(CancellationSignal cancellationSignal, boolean z) {
        boolean z2 = false;
        RuntimeException runtimeException = null;
        AppMethodBeat.i(3292);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        Transaction transaction = this.mTransactionStack;
        boolean z3 = (transaction.mMarkedSuccessful || z) && !transaction.mChildFailed;
        SQLiteTransactionListener sQLiteTransactionListener = transaction.mListener;
        if (sQLiteTransactionListener == null) {
            z2 = z3;
        } else if (z3) {
            try {
                sQLiteTransactionListener.onCommit();
                z2 = z3;
            } catch (RuntimeException e2) {
                runtimeException = e2;
            }
        } else {
            sQLiteTransactionListener.onRollback();
            z2 = z3;
        }
        this.mTransactionStack = transaction.mParent;
        recycleTransaction(transaction);
        if (this.mTransactionStack == null) {
            if (z2) {
                try {
                    this.mConnection.execute("COMMIT;", null, cancellationSignal);
                } catch (Throwable th) {
                    releaseConnection();
                    AppMethodBeat.o(3292);
                    throw th;
                }
            } else {
                this.mConnection.execute("ROLLBACK;", null, cancellationSignal);
            }
            releaseConnection();
        } else if (!z2) {
            this.mTransactionStack.mChildFailed = true;
        }
        if (runtimeException != null) {
            AppMethodBeat.o(3292);
            throw runtimeException;
        } else {
            AppMethodBeat.o(3292);
        }
    }

    public final boolean yieldTransaction(long j2, boolean z, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3293);
        if (z) {
            throwIfNoTransaction();
            throwIfTransactionMarkedSuccessful();
            throwIfNestedTransaction();
        } else if (this.mTransactionStack == null || this.mTransactionStack.mMarkedSuccessful || this.mTransactionStack.mParent != null) {
            AppMethodBeat.o(3293);
            return false;
        }
        if (!$assertionsDisabled && this.mConnection == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(3293);
            throw assertionError;
        } else if (this.mTransactionStack.mChildFailed) {
            AppMethodBeat.o(3293);
            return false;
        } else {
            boolean yieldTransactionUnchecked = yieldTransactionUnchecked(j2, cancellationSignal);
            AppMethodBeat.o(3293);
            return yieldTransactionUnchecked;
        }
    }

    private boolean yieldTransactionUnchecked(long j2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3294);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        if (!this.mConnectionPool.shouldYieldConnection(this.mConnection, this.mConnectionFlags)) {
            AppMethodBeat.o(3294);
            return false;
        }
        int i2 = this.mTransactionStack.mMode;
        SQLiteTransactionListener sQLiteTransactionListener = this.mTransactionStack.mListener;
        int i3 = this.mConnectionFlags;
        endTransactionUnchecked(cancellationSignal, true);
        if (j2 > 0) {
            try {
                Thread.sleep(j2);
            } catch (InterruptedException e2) {
            }
        }
        beginTransactionUnchecked(i2, sQLiteTransactionListener, i3, cancellationSignal);
        AppMethodBeat.o(3294);
        return true;
    }

    public final void prepare(String str, int i2, CancellationSignal cancellationSignal, SQLiteStatementInfo sQLiteStatementInfo) {
        AppMethodBeat.i(3295);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3295);
            throw illegalArgumentException;
        }
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        acquireConnection(str, i2, false, cancellationSignal);
        try {
            this.mConnection.prepare(str, sQLiteStatementInfo);
        } finally {
            releaseConnection();
            AppMethodBeat.o(3295);
        }
    }

    public final void execute(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3296);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3296);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            AppMethodBeat.o(3296);
        } else {
            acquireConnection(str, i2, false, cancellationSignal);
            try {
                this.mConnection.execute(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.o(3296);
            }
        }
    }

    public final long executeForLong(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3297);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3297);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            AppMethodBeat.o(3297);
            return 0;
        } else {
            acquireConnection(str, i2, false, cancellationSignal);
            try {
                return this.mConnection.executeForLong(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.o(3297);
            }
        }
    }

    public final String executeForString(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3298);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3298);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            AppMethodBeat.o(3298);
            return null;
        } else {
            acquireConnection(str, i2, false, cancellationSignal);
            try {
                return this.mConnection.executeForString(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.o(3298);
            }
        }
    }

    public final int executeForChangedRowCount(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        int i3 = 0;
        AppMethodBeat.i(3299);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3299);
            throw illegalArgumentException;
        }
        if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            AppMethodBeat.o(3299);
        } else {
            acquireConnection(str, i2, false, cancellationSignal);
            try {
                i3 = this.mConnection.executeForChangedRowCount(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.o(3299);
            }
        }
        return i3;
    }

    public final long executeForLastInsertedRowId(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3300);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3300);
            throw illegalArgumentException;
        } else if (executeSpecial(str, objArr, i2, cancellationSignal)) {
            AppMethodBeat.o(3300);
            return 0;
        } else {
            acquireConnection(str, i2, false, cancellationSignal);
            try {
                return this.mConnection.executeForLastInsertedRowId(str, objArr, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.o(3300);
            }
        }
    }

    public final int executeForCursorWindow(String str, Object[] objArr, CursorWindow cursorWindow, int i2, int i3, boolean z, int i4, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3301);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sql must not be null.");
            AppMethodBeat.o(3301);
            throw illegalArgumentException;
        } else if (cursorWindow == null) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("window must not be null.");
            AppMethodBeat.o(3301);
            throw illegalArgumentException2;
        } else if (executeSpecial(str, objArr, i4, cancellationSignal)) {
            cursorWindow.clear();
            AppMethodBeat.o(3301);
            return 0;
        } else {
            acquireConnection(str, i4, false, cancellationSignal);
            try {
                return this.mConnection.executeForCursorWindow(str, objArr, cursorWindow, i2, i3, z, cancellationSignal);
            } finally {
                releaseConnection();
                AppMethodBeat.o(3301);
            }
        }
    }

    public final Pair<Integer, Integer> walCheckpoint(String str, int i2) {
        AppMethodBeat.i(3302);
        acquireConnection(null, i2, false, null);
        try {
            return this.mConnection.walCheckpoint(str);
        } finally {
            releaseConnection();
            AppMethodBeat.o(3302);
        }
    }

    private boolean executeSpecial(String str, Object[] objArr, int i2, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3303);
        if (cancellationSignal != null) {
            cancellationSignal.throwIfCanceled();
        }
        switch (DatabaseUtils.getSqlStatementType(str)) {
            case 4:
                beginTransaction(2, null, i2, cancellationSignal);
                AppMethodBeat.o(3303);
                return true;
            case 5:
                setTransactionSuccessful();
                endTransaction(cancellationSignal);
                AppMethodBeat.o(3303);
                return true;
            case 6:
                endTransaction(cancellationSignal);
                AppMethodBeat.o(3303);
                return true;
            default:
                AppMethodBeat.o(3303);
                return false;
        }
    }

    private void acquireConnection(String str, int i2, boolean z, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3304);
        if (this.mConnection == null) {
            this.mConnection = this.mConnectionPool.acquireConnection(str, i2, cancellationSignal);
            this.mConnectionFlags = i2;
            this.mConnection.setAcquisitionState(true, z);
        }
        this.mConnectionUseCount++;
        AppMethodBeat.o(3304);
    }

    private void releaseConnection() {
        AppMethodBeat.i(3305);
        int i2 = this.mConnectionUseCount - 1;
        this.mConnectionUseCount = i2;
        if (i2 == 0) {
            try {
                this.mConnection.setAcquisitionState(false, false);
                this.mConnectionPool.releaseConnection(this.mConnection);
            } finally {
                this.mConnection = null;
                AppMethodBeat.o(3305);
            }
        } else {
            AppMethodBeat.o(3305);
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteConnection acquireConnectionForNativeHandle(int i2) {
        AppMethodBeat.i(3306);
        acquireConnection(null, i2, true, null);
        SQLiteConnection sQLiteConnection = this.mConnection;
        AppMethodBeat.o(3306);
        return sQLiteConnection;
    }

    /* access modifiers changed from: package-private */
    public final void releaseConnectionForNativeHandle(Exception exc) {
        AppMethodBeat.i(3307);
        if (this.mConnection != null) {
            this.mConnection.endNativeHandle(exc);
        }
        releaseConnection();
        AppMethodBeat.o(3307);
    }

    /* access modifiers changed from: package-private */
    public final SQLiteConnection.PreparedStatement acquirePreparedStatement(String str, int i2, boolean z) {
        AppMethodBeat.i(3308);
        acquireConnection(str, i2, z, null);
        SQLiteConnection.PreparedStatement acquirePreparedStatement = this.mConnection.acquirePreparedStatement(str);
        AppMethodBeat.o(3308);
        return acquirePreparedStatement;
    }

    /* access modifiers changed from: package-private */
    public final void releasePreparedStatement(SQLiteConnection.PreparedStatement preparedStatement) {
        AppMethodBeat.i(3309);
        if (this.mConnection != null) {
            this.mConnection.releasePreparedStatement(preparedStatement);
            releaseConnection();
        }
        AppMethodBeat.o(3309);
    }

    private void throwIfNoTransaction() {
        AppMethodBeat.i(3310);
        if (this.mTransactionStack == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because there is no current transaction.");
            AppMethodBeat.o(3310);
            throw illegalStateException;
        }
        AppMethodBeat.o(3310);
    }

    private void throwIfTransactionMarkedSuccessful() {
        AppMethodBeat.i(3311);
        if (this.mTransactionStack == null || !this.mTransactionStack.mMarkedSuccessful) {
            AppMethodBeat.o(3311);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        AppMethodBeat.o(3311);
        throw illegalStateException;
    }

    private void throwIfNestedTransaction() {
        AppMethodBeat.i(3312);
        if (hasNestedTransaction()) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot perform this operation because a nested transaction is in progress.");
            AppMethodBeat.o(3312);
            throw illegalStateException;
        }
        AppMethodBeat.o(3312);
    }

    private Transaction obtainTransaction(int i2, SQLiteTransactionListener sQLiteTransactionListener) {
        AppMethodBeat.i(3313);
        Transaction transaction = this.mTransactionPool;
        if (transaction != null) {
            this.mTransactionPool = transaction.mParent;
            transaction.mParent = null;
            transaction.mMarkedSuccessful = false;
            transaction.mChildFailed = false;
        } else {
            transaction = new Transaction();
        }
        transaction.mMode = i2;
        transaction.mListener = sQLiteTransactionListener;
        AppMethodBeat.o(3313);
        return transaction;
    }

    private void recycleTransaction(Transaction transaction) {
        transaction.mParent = this.mTransactionPool;
        transaction.mListener = null;
        this.mTransactionPool = transaction;
    }

    /* access modifiers changed from: package-private */
    public static final class Transaction {
        public boolean mChildFailed;
        public SQLiteTransactionListener mListener;
        public boolean mMarkedSuccessful;
        public int mMode;
        public Transaction mParent;

        private Transaction() {
        }
    }
}
