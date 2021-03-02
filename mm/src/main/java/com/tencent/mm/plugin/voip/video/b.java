package com.tencent.mm.plugin.voip.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.GLTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* access modifiers changed from: package-private */
public final class b implements GLTextureView.f {
    private static int EGL_CONTEXT_CLIENT_VERSION = 12440;

    b() {
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView.f
    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        AppMethodBeat.i(115573);
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, 2, 12344});
        AppMethodBeat.o(115573);
        return eglCreateContext;
    }

    @Override // com.tencent.mm.plugin.voip.video.GLTextureView.f
    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        AppMethodBeat.i(115574);
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
        AppMethodBeat.o(115574);
    }
}
