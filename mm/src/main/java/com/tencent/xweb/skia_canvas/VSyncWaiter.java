package com.tencent.xweb.skia_canvas;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class VSyncWaiter {
    private static final String TAG = "VSyncWaiter";
    private volatile Handler mWorkingHandler;

    /* access modifiers changed from: package-private */
    public interface VSyncWaiterCallback {
        void doFrame(long j2);
    }

    static /* synthetic */ void access$000(VSyncWaiter vSyncWaiter, VSyncWaiterCallback vSyncWaiterCallback) {
        AppMethodBeat.i(217612);
        vSyncWaiter.runVSyncCallback(vSyncWaiterCallback);
        AppMethodBeat.o(217612);
    }

    public static VSyncWaiter getInstance() {
        return Holder.INSTANCE;
    }

    public void asyncWaitForVSync(final VSyncWaiterCallback vSyncWaiterCallback) {
        AppMethodBeat.i(217609);
        if (Looper.myLooper() != null) {
            runVSyncCallback(vSyncWaiterCallback);
            AppMethodBeat.o(217609);
            return;
        }
        initWorkingThread();
        this.mWorkingHandler.post(new Runnable() {
            /* class com.tencent.xweb.skia_canvas.VSyncWaiter.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(217606);
                VSyncWaiter.access$000(VSyncWaiter.this, vSyncWaiterCallback);
                AppMethodBeat.o(217606);
            }
        });
        AppMethodBeat.o(217609);
    }

    private void runVSyncCallback(final VSyncWaiterCallback vSyncWaiterCallback) {
        AppMethodBeat.i(217610);
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            /* class com.tencent.xweb.skia_canvas.VSyncWaiter.AnonymousClass2 */

            public void doFrame(long j2) {
                AppMethodBeat.i(217607);
                vSyncWaiterCallback.doFrame(j2);
                AppMethodBeat.o(217607);
            }
        });
        AppMethodBeat.o(217610);
    }

    private void initWorkingThread() {
        AppMethodBeat.i(217611);
        if (this.mWorkingHandler == null) {
            HandlerThread handlerThread = new HandlerThread("SkiaCanvasVSyncWaiterThread", -2);
            handlerThread.start();
            this.mWorkingHandler = new Handler(handlerThread.getLooper());
        }
        AppMethodBeat.o(217611);
    }

    private VSyncWaiter() {
    }

    /* access modifiers changed from: package-private */
    public static final class Holder {
        static final VSyncWaiter INSTANCE = new VSyncWaiter();

        private Holder() {
        }

        static {
            AppMethodBeat.i(217608);
            AppMethodBeat.o(217608);
        }
    }
}
