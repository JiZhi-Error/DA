package com.tencent.liteav.basic.module;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;

public class StatusBucket {
    private static final String TAG = StatusBucket.class.getName();
    private long mBucketObj;

    private static native long nativeCreateStatusBucket();

    private static native void nativeDestroyStatusBucket(long j2);

    private static native boolean nativeGetBooleanStatus(long j2, String str, int i2);

    private static native int nativeGetIntStatus(long j2, String str, int i2);

    private static native long nativeGetLongStatus(long j2, String str, int i2);

    private static native void nativeMerge(long j2, long j3);

    private static native void nativeSetBooleanStatus(long j2, String str, int i2, boolean z);

    private static native void nativeSetIntStatus(long j2, String str, int i2, int i3);

    private static native void nativeSetLongStatus(long j2, String str, int i2, long j3);

    static {
        AppMethodBeat.i(222034);
        AppMethodBeat.o(222034);
    }

    public StatusBucket() {
        AppMethodBeat.i(222024);
        this.mBucketObj = 0;
        this.mBucketObj = nativeCreateStatusBucket();
        AppMethodBeat.o(222024);
    }

    public StatusBucket(long j2) {
        this.mBucketObj = 0;
        this.mBucketObj = j2;
    }

    public void setBooleanStatus(String str, int i2, boolean z) {
        AppMethodBeat.i(222025);
        nativeSetBooleanStatus(this.mBucketObj, str, i2, z);
        AppMethodBeat.o(222025);
    }

    public void setIntStatus(String str, int i2, int i3) {
        AppMethodBeat.i(222026);
        nativeSetIntStatus(this.mBucketObj, str, i2, i3);
        AppMethodBeat.o(222026);
    }

    public void setLongStatus(String str, int i2, long j2) {
        AppMethodBeat.i(222027);
        nativeSetLongStatus(this.mBucketObj, str, i2, j2);
        AppMethodBeat.o(222027);
    }

    public boolean getBooleanStatus(String str, int i2) {
        AppMethodBeat.i(222028);
        boolean nativeGetBooleanStatus = nativeGetBooleanStatus(this.mBucketObj, str, i2);
        AppMethodBeat.o(222028);
        return nativeGetBooleanStatus;
    }

    public int getIntStatus(String str, int i2) {
        AppMethodBeat.i(222029);
        int nativeGetIntStatus = nativeGetIntStatus(this.mBucketObj, str, i2);
        AppMethodBeat.o(222029);
        return nativeGetIntStatus;
    }

    public long getLongStatus(String str, int i2) {
        AppMethodBeat.i(222030);
        long nativeGetLongStatus = nativeGetLongStatus(this.mBucketObj, str, i2);
        AppMethodBeat.o(222030);
        return nativeGetLongStatus;
    }

    public void merge(StatusBucket statusBucket) {
        AppMethodBeat.i(222031);
        nativeMerge(this.mBucketObj, statusBucket.mBucketObj);
        AppMethodBeat.o(222031);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(222032);
        super.finalize();
        long j2 = this.mBucketObj;
        this.mBucketObj = 0;
        nativeDestroyStatusBucket(j2);
        AppMethodBeat.o(222032);
    }

    public static void testStatusBucket() {
        AppMethodBeat.i(222033);
        StatusBucket statusBucket = new StatusBucket();
        StatusBucket statusBucket2 = new StatusBucket();
        statusBucket.setBooleanStatus("1", 1, true);
        statusBucket.setIntStatus("2", 2, 2);
        statusBucket.setLongStatus(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, 3, 3);
        statusBucket2.setIntStatus("1", 4, 4);
        statusBucket2.setBooleanStatus("5", 5, true);
        statusBucket2.setLongStatus("6", 6, 6);
        statusBucket.merge(statusBucket2);
        TXCLog.e(TAG, "test_status_bucket: id:1, key:1, value:" + statusBucket.getBooleanStatus("1", 1));
        TXCLog.e(TAG, "test_status_bucket: id:1, key:4, value:" + statusBucket.getIntStatus("1", 4));
        TXCLog.e(TAG, "test_status_bucket: id:2, key:2, value:" + statusBucket.getIntStatus("2", 2));
        TXCLog.e(TAG, "test_status_bucket: id:3, key:3, value:" + statusBucket.getLongStatus(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, 3));
        TXCLog.e(TAG, "test_status_bucket: id:5, key:5, value:" + statusBucket.getBooleanStatus("5", 5));
        TXCLog.e(TAG, "test_status_bucket: id:6, key:6, value:" + statusBucket.getLongStatus("6", 6));
        AppMethodBeat.o(222033);
    }
}
