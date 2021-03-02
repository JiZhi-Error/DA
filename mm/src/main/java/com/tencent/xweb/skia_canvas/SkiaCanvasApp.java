package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class SkiaCanvasApp {
    private final long mNativePeer;
    private final IXWebWorkingHandler mWorkingHandler;

    private native long nativeInit(long j2, long j3);

    private native void nativeOnJSContextDestroying(long j2);

    public SkiaCanvasApp(long j2, long j3, IXWebWorkingHandler iXWebWorkingHandler) {
        AppMethodBeat.i(217571);
        this.mWorkingHandler = iXWebWorkingHandler;
        if (!this.mWorkingHandler.isRunOnWorkingThread()) {
            IllegalStateException illegalStateException = new IllegalStateException("SkiaCanvasApp must be created and used on working thread.");
            AppMethodBeat.o(217571);
            throw illegalStateException;
        }
        this.mNativePeer = init(j2, j3);
        VSyncRenderer.initRenderer(this.mWorkingHandler);
        AppMethodBeat.o(217571);
    }

    private long init(long j2, long j3) {
        AppMethodBeat.i(217572);
        long nativeInit = nativeInit(j2, j3);
        AppMethodBeat.o(217572);
        return nativeInit;
    }

    public void onJSContextDestroying() {
        AppMethodBeat.i(217573);
        if (!this.mWorkingHandler.isRunOnWorkingThread()) {
            IllegalStateException illegalStateException = new IllegalStateException("Thread during destroy is not matched with init.");
            AppMethodBeat.o(217573);
            throw illegalStateException;
        }
        nativeOnJSContextDestroying(this.mNativePeer);
        AppMethodBeat.o(217573);
    }

    /* access modifiers changed from: package-private */
    public void checkAndPostOnWorkingThread(Runnable runnable) {
        AppMethodBeat.i(217574);
        if (this.mWorkingHandler.isRunOnWorkingThread()) {
            runnable.run();
            AppMethodBeat.o(217574);
            return;
        }
        this.mWorkingHandler.post(runnable);
        AppMethodBeat.o(217574);
    }

    /* access modifiers changed from: package-private */
    public boolean isRunOnWorkingThread() {
        AppMethodBeat.i(217575);
        boolean isRunOnWorkingThread = this.mWorkingHandler.isRunOnWorkingThread();
        AppMethodBeat.o(217575);
        return isRunOnWorkingThread;
    }

    static {
        AppMethodBeat.i(217576);
        SkiaCanvasLogic.init();
        AppMethodBeat.o(217576);
    }
}
