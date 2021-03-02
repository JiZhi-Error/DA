package com.tencent.wcdb.database;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectQuery extends SQLiteProgram {
    private static final int[] SQLITE_TYPE_MAPPING = {3, 1, 2, 3, 4, 0};
    private static final String TAG = "WCDB.SQLiteDirectQuery";
    private final CancellationSignal mCancellationSignal;

    private static native byte[] nativeGetBlob(long j2, int i2);

    private static native double nativeGetDouble(long j2, int i2);

    private static native long nativeGetLong(long j2, int i2);

    private static native String nativeGetString(long j2, int i2);

    private static native int nativeGetType(long j2, int i2);

    private static native int nativeStep(long j2, int i2);

    public SQLiteDirectQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, CancellationSignal cancellationSignal) {
        super(sQLiteDatabase, str, objArr, cancellationSignal);
        this.mCancellationSignal = cancellationSignal;
    }

    public long getLong(int i2) {
        AppMethodBeat.i(3259);
        long nativeGetLong = nativeGetLong(this.mPreparedStatement.getPtr(), i2);
        AppMethodBeat.o(3259);
        return nativeGetLong;
    }

    public double getDouble(int i2) {
        AppMethodBeat.i(3260);
        double nativeGetDouble = nativeGetDouble(this.mPreparedStatement.getPtr(), i2);
        AppMethodBeat.o(3260);
        return nativeGetDouble;
    }

    public String getString(int i2) {
        AppMethodBeat.i(3261);
        String nativeGetString = nativeGetString(this.mPreparedStatement.getPtr(), i2);
        AppMethodBeat.o(3261);
        return nativeGetString;
    }

    public byte[] getBlob(int i2) {
        AppMethodBeat.i(3262);
        byte[] nativeGetBlob = nativeGetBlob(this.mPreparedStatement.getPtr(), i2);
        AppMethodBeat.o(3262);
        return nativeGetBlob;
    }

    public int getType(int i2) {
        AppMethodBeat.i(3263);
        int i3 = SQLITE_TYPE_MAPPING[nativeGetType(this.mPreparedStatement.getPtr(), i2)];
        AppMethodBeat.o(3263);
        return i3;
    }

    public int step(int i2) {
        AppMethodBeat.i(3264);
        try {
            if (acquirePreparedStatement(false)) {
                this.mPreparedStatement.beginOperation("directQuery", getBindArgs());
                this.mPreparedStatement.attachCancellationSignal(this.mCancellationSignal);
            }
            int nativeStep = nativeStep(this.mPreparedStatement.getPtr(), i2);
            AppMethodBeat.o(3264);
            return nativeStep;
        } catch (RuntimeException e2) {
            if (e2 instanceof SQLiteException) {
                Log.e(TAG, "Got exception on stepping: " + e2.getMessage() + ", SQL: " + getSql());
                checkCorruption((SQLiteException) e2);
            }
            if (this.mPreparedStatement != null) {
                this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
                this.mPreparedStatement.failOperation(e2);
            }
            releasePreparedStatement();
            AppMethodBeat.o(3264);
            throw e2;
        }
    }

    public synchronized void reset(boolean z) {
        AppMethodBeat.i(3265);
        if (this.mPreparedStatement != null) {
            this.mPreparedStatement.reset(false);
            if (z) {
                this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
                this.mPreparedStatement.endOperation(null);
                releasePreparedStatement();
            }
        }
        AppMethodBeat.o(3265);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.wcdb.database.SQLiteProgram, com.tencent.wcdb.database.SQLiteClosable
    public void onAllReferencesReleased() {
        AppMethodBeat.i(3266);
        synchronized (this) {
            try {
                if (this.mPreparedStatement != null) {
                    this.mPreparedStatement.detachCancellationSignal(this.mCancellationSignal);
                    this.mPreparedStatement.endOperation(null);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(3266);
                throw th;
            }
        }
        super.onAllReferencesReleased();
        AppMethodBeat.o(3266);
    }
}
