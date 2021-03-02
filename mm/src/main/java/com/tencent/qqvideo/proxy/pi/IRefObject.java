package com.tencent.qqvideo.proxy.pi;

public class IRefObject {
    private long mNativePtr;

    private static native void freeNativePtr(long j2);

    public native void finalize();

    public native synchronized void release();

    public native synchronized void retain();

    public IRefObject(long j2) {
        this.mNativePtr = j2;
    }

    private synchronized long getNativePtr() {
        return this.mNativePtr;
    }
}
