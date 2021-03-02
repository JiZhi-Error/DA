package com.tencent.xweb.skia_canvas;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.skia_canvas.VSyncRenderer;

class VSyncRenderJNI {
    private static native void nativeOnAnimation(long j2, long j3);

    VSyncRenderJNI() {
    }

    static /* synthetic */ void access$000(long j2, long j3) {
        AppMethodBeat.i(217592);
        nativeOnAnimation(j2, j3);
        AppMethodBeat.o(217592);
    }

    private static long addAnimationCallback(final long j2) {
        AppMethodBeat.i(217590);
        VSyncRenderer instance = VSyncRenderer.getInstance();
        if (instance == null) {
            IllegalStateException illegalStateException = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
            AppMethodBeat.o(217590);
            throw illegalStateException;
        }
        long addAnimationCallback = instance.addAnimationCallback(new VSyncRenderer.AnimationCallback() {
            /* class com.tencent.xweb.skia_canvas.VSyncRenderJNI.AnonymousClass1 */

            @Override // com.tencent.xweb.skia_canvas.VSyncRenderer.AnimationCallback
            public final void doAnimation(long j2) {
                AppMethodBeat.i(217589);
                VSyncRenderJNI.access$000(j2, j2);
                AppMethodBeat.o(217589);
            }
        });
        AppMethodBeat.o(217590);
        return addAnimationCallback;
    }

    private static void removeAnimationCallback(long j2) {
        AppMethodBeat.i(217591);
        VSyncRenderer instance = VSyncRenderer.getInstance();
        if (instance == null) {
            IllegalStateException illegalStateException = new IllegalStateException("VSyncRendererCallback is not init in current thread.");
            AppMethodBeat.o(217591);
            throw illegalStateException;
        }
        instance.removeAnimationCallback(j2);
        AppMethodBeat.o(217591);
    }
}
