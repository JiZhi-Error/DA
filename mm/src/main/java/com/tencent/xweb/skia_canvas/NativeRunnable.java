package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

class NativeRunnable implements Runnable {
    private boolean mHasRun;
    private final long mNativePeer;

    private native void releaseNative(long j2);

    private native void runNative(long j2);

    static NativeRunnable Create(long j2) {
        AppMethodBeat.i(217568);
        NativeRunnable nativeRunnable = new NativeRunnable(j2);
        AppMethodBeat.o(217568);
        return nativeRunnable;
    }

    public void run() {
        AppMethodBeat.i(217569);
        if (!this.mHasRun) {
            runNative(this.mNativePeer);
            releaseNative(this.mNativePeer);
            this.mHasRun = true;
        }
        AppMethodBeat.o(217569);
    }

    private NativeRunnable(long j2) {
        this.mNativePeer = j2;
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public void finalize() {
        AppMethodBeat.i(217570);
        super.finalize();
        if (!this.mHasRun) {
            releaseNative(this.mNativePeer);
        }
        AppMethodBeat.o(217570);
    }
}
