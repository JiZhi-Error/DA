package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;

public class RecoverKit implements CancellationSignal.OnCancelListener {
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private int mFailedCount;
    private String mLastError = null;
    private long mNativePtr;
    private int mSuccessCount;

    private static native void nativeCancel(long j2);

    private static native int nativeFailureCount(long j2);

    private static native void nativeFinish(long j2);

    private static native long nativeInit(String str, byte[] bArr);

    private static native String nativeLastError(long j2);

    private static native int nativeRun(long j2, long j3, boolean z);

    private static native int nativeSuccessCount(long j2);

    public RecoverKit(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr) {
        AppMethodBeat.i(3340);
        this.mDB = sQLiteDatabase;
        this.mNativePtr = nativeInit(str, bArr);
        if (this.mNativePtr == 0) {
            SQLiteException sQLiteException = new SQLiteException("Failed initialize recover context.");
            AppMethodBeat.o(3340);
            throw sQLiteException;
        }
        AppMethodBeat.o(3340);
    }

    public int run(boolean z) {
        AppMethodBeat.i(3341);
        if (this.mNativePtr == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("RecoverKit not initialized.");
            AppMethodBeat.o(3341);
            throw illegalStateException;
        }
        long acquireNativeConnectionHandle = this.mDB.acquireNativeConnectionHandle("recover", false, false);
        int nativeRun = nativeRun(this.mNativePtr, acquireNativeConnectionHandle, z);
        this.mDB.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mSuccessCount = nativeSuccessCount(this.mNativePtr);
        this.mFailedCount = nativeFailureCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.o(3341);
        return nativeRun;
    }

    public int run(boolean z, CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3342);
        if (cancellationSignal.isCanceled()) {
            AppMethodBeat.o(3342);
            return 1;
        }
        cancellationSignal.setOnCancelListener(this);
        int run = run(z);
        cancellationSignal.setOnCancelListener(null);
        AppMethodBeat.o(3342);
        return run;
    }

    public int successCount() {
        return this.mSuccessCount;
    }

    public int failureCount() {
        return this.mFailedCount;
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public void onCancel() {
        AppMethodBeat.i(3343);
        if (this.mNativePtr != 0) {
            nativeCancel(this.mNativePtr);
        }
        AppMethodBeat.o(3343);
    }

    public String lastError() {
        return this.mLastError;
    }

    public void release() {
        AppMethodBeat.i(3344);
        if (this.mNativePtr != 0) {
            nativeFinish(this.mNativePtr);
            this.mNativePtr = 0;
        }
        AppMethodBeat.o(3344);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(3345);
        release();
        super.finalize();
        AppMethodBeat.o(3345);
    }
}
