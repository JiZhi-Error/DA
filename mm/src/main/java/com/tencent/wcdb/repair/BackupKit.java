package com.tencent.wcdb.repair;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.support.CancellationSignal;
import java.util.Arrays;

public class BackupKit implements CancellationSignal.OnCancelListener {
    public static final int FLAG_FIX_CORRUPTION = 4;
    public static final int FLAG_INCREMENTAL = 16;
    public static final int FLAG_NO_CIPHER = 1;
    public static final int FLAG_NO_COMPRESS = 2;
    public static final int FLAG_NO_CREATE_TABLE = 8;
    public static final int RESULT_CANCELED = 1;
    public static final int RESULT_FAILED = -1;
    public static final int RESULT_OK = 0;
    static final String TAG = "WCDB.DBBackup";
    private SQLiteDatabase mDB;
    private String mLastError = null;
    private long mNativePtr;
    private int mStatementCount;
    private String[] mTableDesc;

    private static native void nativeCancel(long j2);

    private static native void nativeFinish(long j2);

    private static native long nativeInit(String str, byte[] bArr, int i2);

    private static native String nativeLastError(long j2);

    private static native int nativeRun(long j2, long j3, String[] strArr);

    private static native int nativeStatementCount(long j2);

    public BackupKit(SQLiteDatabase sQLiteDatabase, String str, byte[] bArr, int i2, String[] strArr) {
        String[] strArr2 = null;
        AppMethodBeat.i(3328);
        this.mDB = sQLiteDatabase;
        this.mTableDesc = strArr != null ? (String[]) Arrays.copyOf(strArr, strArr.length) : strArr2;
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
            AppMethodBeat.o(3328);
            throw illegalArgumentException;
        }
        this.mNativePtr = nativeInit(str, bArr, i2);
        if (this.mNativePtr == 0) {
            SQLiteException sQLiteException = new SQLiteException("Failed initialize backup context.");
            AppMethodBeat.o(3328);
            throw sQLiteException;
        }
        AppMethodBeat.o(3328);
    }

    public int run() {
        AppMethodBeat.i(3329);
        if (this.mNativePtr == 0) {
            IllegalStateException illegalStateException = new IllegalStateException("BackupKit not initialized.");
            AppMethodBeat.o(3329);
            throw illegalStateException;
        }
        long acquireNativeConnectionHandle = this.mDB.acquireNativeConnectionHandle("backup", false, false);
        int nativeRun = nativeRun(this.mNativePtr, acquireNativeConnectionHandle, this.mTableDesc);
        this.mDB.releaseNativeConnection(acquireNativeConnectionHandle, null);
        this.mStatementCount = nativeStatementCount(this.mNativePtr);
        this.mLastError = nativeLastError(this.mNativePtr);
        nativeFinish(this.mNativePtr);
        this.mNativePtr = 0;
        AppMethodBeat.o(3329);
        return nativeRun;
    }

    public int run(CancellationSignal cancellationSignal) {
        AppMethodBeat.i(3330);
        if (cancellationSignal.isCanceled()) {
            AppMethodBeat.o(3330);
            return 1;
        }
        cancellationSignal.setOnCancelListener(this);
        int run = run();
        cancellationSignal.setOnCancelListener(null);
        AppMethodBeat.o(3330);
        return run;
    }

    public int statementCount() {
        return this.mStatementCount;
    }

    @Override // com.tencent.wcdb.support.CancellationSignal.OnCancelListener
    public void onCancel() {
        AppMethodBeat.i(3331);
        if (this.mNativePtr != 0) {
            nativeCancel(this.mNativePtr);
        }
        AppMethodBeat.o(3331);
    }

    public String lastError() {
        return this.mLastError;
    }

    public void release() {
        AppMethodBeat.i(3332);
        if (this.mNativePtr != 0) {
            nativeFinish(this.mNativePtr);
            this.mNativePtr = 0;
        }
        AppMethodBeat.o(3332);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(3333);
        release();
        super.finalize();
        AppMethodBeat.o(3333);
    }
}
