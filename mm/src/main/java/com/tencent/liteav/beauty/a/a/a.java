package com.tencent.liteav.beauty.a.a;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private EGL10 f496a;

    /* renamed from: b  reason: collision with root package name */
    private final EGLContext f497b;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f498c;

    /* renamed from: d  reason: collision with root package name */
    private EGLConfig f499d;

    /* renamed from: e  reason: collision with root package name */
    private EGLSurface f500e;

    public a() {
        this(null);
    }

    public a(EGLConfig eGLConfig) {
        AppMethodBeat.i(15273);
        this.f496a = (EGL10) EGLContext.getEGL();
        this.f498c = this.f496a.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.f498c == EGL10.EGL_NO_DISPLAY) {
            RuntimeException runtimeException = new RuntimeException("unable to get EGL10 display");
            AppMethodBeat.o(15273);
            throw runtimeException;
        }
        if (!this.f496a.eglInitialize(this.f498c, new int[2])) {
            this.f498c = null;
            RuntimeException runtimeException2 = new RuntimeException("unable to initialize EGL10");
            AppMethodBeat.o(15273);
            throw runtimeException2;
        }
        if (eGLConfig != null) {
            this.f499d = eGLConfig;
        } else {
            this.f499d = b();
        }
        this.f497b = this.f496a.eglCreateContext(this.f498c, this.f499d, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        AppMethodBeat.o(15273);
    }

    private EGLConfig b() {
        AppMethodBeat.i(15274);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!this.f496a.eglChooseConfig(this.f498c, new int[]{12339, 1, 12325, 16, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344}, eGLConfigArr, 1, new int[1])) {
            TXCLog.w("ImageEglSurface", "unable to find RGB8888  EGLConfig");
            AppMethodBeat.o(15274);
            return null;
        }
        EGLConfig eGLConfig = eGLConfigArr[0];
        AppMethodBeat.o(15274);
        return eGLConfig;
    }

    public void a() {
        AppMethodBeat.i(15275);
        EGL10 egl10 = this.f496a;
        EGLDisplay eGLDisplay = this.f498c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        this.f496a.eglDestroyContext(this.f498c, this.f497b);
        this.f496a.eglTerminate(this.f498c);
        AppMethodBeat.o(15275);
    }

    public void a(EGLSurface eGLSurface) {
        AppMethodBeat.i(15276);
        this.f496a.eglDestroySurface(this.f498c, eGLSurface);
        AppMethodBeat.o(15276);
    }

    public EGLSurface a(int i2, int i3) {
        AppMethodBeat.i(15277);
        this.f500e = this.f496a.eglCreatePbufferSurface(this.f498c, this.f499d, new int[]{12375, i2, 12374, i3, 12344});
        a("eglCreatePbufferSurface");
        if (this.f500e == null) {
            RuntimeException runtimeException = new RuntimeException("surface was null");
            AppMethodBeat.o(15277);
            throw runtimeException;
        }
        EGLSurface eGLSurface = this.f500e;
        AppMethodBeat.o(15277);
        return eGLSurface;
    }

    public void b(EGLSurface eGLSurface) {
        AppMethodBeat.i(15278);
        EGLDisplay eGLDisplay = this.f498c;
        if (eGLDisplay == EGL11.EGL_NO_DISPLAY) {
            TXCLog.i("EglCore", "NOTE: makeCurrent w/o display");
        }
        if (!this.f496a.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f497b)) {
            RuntimeException runtimeException = new RuntimeException("eglMakeCurrent failed");
            AppMethodBeat.o(15278);
            throw runtimeException;
        }
        AppMethodBeat.o(15278);
    }

    private void a(String str) {
        AppMethodBeat.i(15279);
        int eglGetError = this.f496a.eglGetError();
        if (eglGetError != 12288) {
            RuntimeException runtimeException = new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            AppMethodBeat.o(15279);
            throw runtimeException;
        }
        AppMethodBeat.o(15279);
    }
}
