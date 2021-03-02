package com.tencent.mm.media.j.a;

import android.opengl.GLSurfaceView;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/media/render/config/RenderContextFactory;", "Landroid/opengl/GLSurfaceView$EGLContextFactory;", "()V", "EGL_CONTEXT_CLIENT_VERSION", "", "TAG", "", "createContext", "Ljavax/microedition/khronos/egl/EGLContext;", "egl", "Ljavax/microedition/khronos/egl/EGL10;", ServerProtocol.DIALOG_PARAM_DISPLAY, "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "destroyContext", "", "context", "plugin-mediaeditor_release"})
public final class b implements GLSurfaceView.EGLContextFactory {
    private final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private final String TAG = "MicroMsg.RenderContextFactory";

    public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        AppMethodBeat.i(93851);
        p.h(egl10, "egl");
        p.h(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        p.h(eGLConfig, "eglConfig");
        Log.w(this.TAG, "creating OpenGL ES 2.0 context");
        EGLContext eglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{this.EGL_CONTEXT_CLIENT_VERSION, MultiProcessMMKV.getMMKV("mmkv_gl_key").decodeInt("support_egl_context_client_version", 3), 12344});
        p.g(eglCreateContext, "egl.eglCreateContext(dis…_NO_CONTEXT, attrib_list)");
        AppMethodBeat.o(93851);
        return eglCreateContext;
    }

    public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
        AppMethodBeat.i(93852);
        p.h(egl10, "egl");
        p.h(eGLDisplay, ServerProtocol.DIALOG_PARAM_DISPLAY);
        p.h(eGLContext, "context");
        Log.w(this.TAG, "destroyContext OpenGL ES 2.0 Context");
        egl10.eglDestroyContext(eGLDisplay, eGLContext);
        AppMethodBeat.o(93852);
    }
}
