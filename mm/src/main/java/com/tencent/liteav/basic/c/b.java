package com.tencent.liteav.basic.c;

import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f224a = b.class.getSimpleName();
    private static int[] l = {12339, 1, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12344};
    private static int[] m = {12339, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12352, 4, 12610, 1, 12344};

    /* renamed from: b  reason: collision with root package name */
    private EGL10 f225b;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f226c;

    /* renamed from: d  reason: collision with root package name */
    private EGLConfig f227d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f228e;

    /* renamed from: f  reason: collision with root package name */
    private EGLContext f229f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f230g;

    /* renamed from: h  reason: collision with root package name */
    private EGLSurface f231h;

    /* renamed from: i  reason: collision with root package name */
    private int f232i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f233j = 0;
    private int[] k = new int[2];

    static {
        AppMethodBeat.i(222308);
        AppMethodBeat.o(222308);
    }

    private b() {
        AppMethodBeat.i(222299);
        AppMethodBeat.o(222299);
    }

    public static b a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i2, int i3) {
        AppMethodBeat.i(222300);
        b bVar = new b();
        bVar.f232i = i2;
        bVar.f233j = i3;
        if (bVar.a(eGLConfig, eGLContext, surface)) {
            AppMethodBeat.o(222300);
            return bVar;
        }
        AppMethodBeat.o(222300);
        return null;
    }

    public boolean a() {
        AppMethodBeat.i(222301);
        boolean eglSwapBuffers = this.f225b.eglSwapBuffers(this.f226c, this.f231h);
        e();
        AppMethodBeat.o(222301);
        return eglSwapBuffers;
    }

    public void b() {
        AppMethodBeat.i(222302);
        this.f225b.eglMakeCurrent(this.f226c, this.f231h, this.f231h, this.f229f);
        e();
        AppMethodBeat.o(222302);
    }

    public void c() {
        AppMethodBeat.i(222303);
        EGL10 egl10 = this.f225b;
        EGLDisplay eGLDisplay = this.f226c;
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        if (this.f231h != null) {
            this.f225b.eglDestroySurface(this.f226c, this.f231h);
        }
        if (this.f229f != null) {
            this.f225b.eglDestroyContext(this.f226c, this.f229f);
        }
        this.f225b.eglTerminate(this.f226c);
        e();
        this.f226c = null;
        this.f231h = null;
        this.f226c = null;
        AppMethodBeat.o(222303);
    }

    private boolean a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        AppMethodBeat.i(222304);
        this.f225b = (EGL10) EGLContext.getEGL();
        this.f226c = this.f225b.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f225b.eglInitialize(this.f226c, this.k);
        if (eGLConfig == null) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            this.f225b.eglChooseConfig(this.f226c, surface == null ? l : m, eGLConfigArr, 1, new int[1]);
            this.f227d = eGLConfigArr[0];
            this.f228e = true;
        } else {
            this.f227d = eGLConfig;
        }
        if (eGLContext != null) {
            this.f230g = true;
        }
        try {
            this.f229f = a(this.f226c, this.f227d, 2, eGLContext);
        } catch (d e2) {
            TXCLog.i(f224a, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
            try {
                this.f229f = a(this.f226c, this.f227d, 3, eGLContext);
            } catch (d e3) {
                TXCLog.e(f224a, "failed to create EGLContext of 3.0. ".concat(String.valueOf(e3)));
                AppMethodBeat.o(222304);
                return false;
            }
        }
        int[] iArr = {12375, this.f232i, 12374, this.f233j, 12344};
        if (surface == null) {
            this.f231h = this.f225b.eglCreatePbufferSurface(this.f226c, this.f227d, iArr);
        } else {
            this.f231h = this.f225b.eglCreateWindowSurface(this.f226c, this.f227d, surface, null);
        }
        if (this.f231h == EGL10.EGL_NO_SURFACE) {
            e();
            AppMethodBeat.o(222304);
            return false;
        } else if (!this.f225b.eglMakeCurrent(this.f226c, this.f231h, this.f231h, this.f229f)) {
            e();
            AppMethodBeat.o(222304);
            return false;
        } else {
            AppMethodBeat.o(222304);
            return true;
        }
    }

    public EGLContext d() {
        return this.f229f;
    }

    public void e() {
        AppMethodBeat.i(222305);
        int eglGetError = this.f225b.eglGetError();
        if (eglGetError != 12288) {
            TXCLog.e(f224a, "EGL error: 0x" + Integer.toHexString(eglGetError));
        }
        AppMethodBeat.o(222305);
    }

    private EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, EGLContext eGLContext) {
        AppMethodBeat.i(222306);
        int[] iArr = {12440, i2, 12344};
        if (eGLContext == null) {
            eGLContext = EGL10.EGL_NO_CONTEXT;
        }
        EGLContext eglCreateContext = this.f225b.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        f();
        AppMethodBeat.o(222306);
        return eglCreateContext;
    }

    private void f() {
        AppMethodBeat.i(222307);
        int eglGetError = this.f225b.eglGetError();
        if (eglGetError != 12288) {
            d dVar = new d(eglGetError);
            AppMethodBeat.o(222307);
            throw dVar;
        }
        AppMethodBeat.o(222307);
    }
}
