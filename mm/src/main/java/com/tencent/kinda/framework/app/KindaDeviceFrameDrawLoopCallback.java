package com.tencent.kinda.framework.app;

import android.view.Choreographer;
import com.tencent.kinda.gen.IDeviceFrameDrawLoopCallback;
import com.tencent.kinda.gen.VoidI64Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TimeUtil;

public class KindaDeviceFrameDrawLoopCallback implements IDeviceFrameDrawLoopCallback {
    private Choreographer choreographer = Choreographer.getInstance();
    private Choreographer.FrameCallback frameCallback = new Choreographer.FrameCallback() {
        /* class com.tencent.kinda.framework.app.KindaDeviceFrameDrawLoopCallback.AnonymousClass1 */

        public void doFrame(long j2) {
            AppMethodBeat.i(18411);
            KindaDeviceFrameDrawLoopCallback.this.onDoFrame(j2);
            AppMethodBeat.o(18411);
        }
    };
    private VoidI64Callback frameDrawCallback;
    private volatile boolean isStart = false;

    public KindaDeviceFrameDrawLoopCallback() {
        AppMethodBeat.i(18412);
        AppMethodBeat.o(18412);
    }

    @Override // com.tencent.kinda.gen.IDeviceFrameDrawLoopCallback
    public void startListenerImpl(VoidI64Callback voidI64Callback) {
        AppMethodBeat.i(18413);
        this.isStart = true;
        this.frameDrawCallback = voidI64Callback;
        this.choreographer.removeFrameCallback(this.frameCallback);
        this.choreographer.postFrameCallback(this.frameCallback);
        AppMethodBeat.o(18413);
    }

    @Override // com.tencent.kinda.gen.IDeviceFrameDrawLoopCallback
    public void stopListener() {
        AppMethodBeat.i(18414);
        this.isStart = false;
        this.choreographer.removeFrameCallback(this.frameCallback);
        AppMethodBeat.o(18414);
    }

    public void onDoFrame(long j2) {
        AppMethodBeat.i(18415);
        this.frameDrawCallback.call(j2 / TimeUtil.SECOND_TO_US);
        if (this.isStart) {
            this.choreographer.postFrameCallback(this.frameCallback);
        }
        AppMethodBeat.o(18415);
    }
}
