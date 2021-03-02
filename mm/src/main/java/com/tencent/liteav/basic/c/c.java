package com.tencent.liteav.basic.c;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(17)
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static int f234a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final String f235b = c.class.getSimpleName();
    private static int[] k;
    private static int[] l;

    /* renamed from: c  reason: collision with root package name */
    private EGLDisplay f236c = EGL14.EGL_NO_DISPLAY;

    /* renamed from: d  reason: collision with root package name */
    private EGLContext f237d = EGL14.EGL_NO_CONTEXT;

    /* renamed from: e  reason: collision with root package name */
    private EGLConfig f238e = null;

    /* renamed from: f  reason: collision with root package name */
    private int f239f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f240g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f241h;

    /* renamed from: i  reason: collision with root package name */
    private EGLSurface f242i;

    /* renamed from: j  reason: collision with root package name */
    private int f243j = -1;

    public static c a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface, int i2, int i3) {
        AppMethodBeat.i(222285);
        c cVar = new c();
        cVar.f239f = i2;
        cVar.f240g = i3;
        if (cVar.a(eGLConfig, eGLContext, surface)) {
            AppMethodBeat.o(222285);
            return cVar;
        }
        AppMethodBeat.o(222285);
        return null;
    }

    public void a() {
        AppMethodBeat.i(222286);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            TXCLog.e(f235b, "EGL error:".concat(String.valueOf(eglGetError)));
        }
        AppMethodBeat.o(222286);
    }

    public void b() {
        AppMethodBeat.i(222287);
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        if (!EGL14.eglMakeCurrent(this.f236c, this.f242i, this.f242i, this.f237d)) {
            TXCLog.e(f235b, "eglMakeCurrent failed");
        }
        AppMethodBeat.o(222287);
    }

    public void c() {
        AppMethodBeat.i(222288);
        if (this.f236c != EGL14.EGL_NO_DISPLAY) {
            EGLDisplay eGLDisplay = this.f236c;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.f236c, this.f242i);
            EGL14.eglDestroyContext(this.f236c, this.f237d);
            this.f237d = EGL14.EGL_NO_CONTEXT;
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.f236c);
        }
        this.f236c = EGL14.EGL_NO_DISPLAY;
        AppMethodBeat.o(222288);
    }

    public boolean d() {
        AppMethodBeat.i(222289);
        boolean eglSwapBuffers = EGL14.eglSwapBuffers(this.f236c, this.f242i);
        AppMethodBeat.o(222289);
        return eglSwapBuffers;
    }

    private boolean a(EGLConfig eGLConfig, EGLContext eGLContext, Surface surface) {
        AppMethodBeat.i(222290);
        this.f236c = EGL14.eglGetDisplay(0);
        if (this.f236c == EGL14.EGL_NO_DISPLAY) {
            TXCLog.e(f235b, "unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.f236c, iArr, 0, iArr, 1)) {
            this.f236c = null;
            TXCLog.e(f235b, "unable to initialize EGL14");
        }
        if (eGLConfig != null) {
            this.f238e = eGLConfig;
        } else {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (!EGL14.eglChooseConfig(this.f236c, surface == null ? l : k, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                AppMethodBeat.o(222290);
                return false;
            }
            this.f238e = eGLConfigArr[0];
        }
        if (eGLContext != null) {
            this.f241h = true;
        } else {
            eGLContext = EGL14.EGL_NO_CONTEXT;
        }
        try {
            this.f237d = a(this.f236c, this.f238e, 2, eGLContext);
        } catch (d e2) {
            TXCLog.i(f235b, "failed to create EGLContext of OpenGL ES 2.0, try 3.0");
            try {
                this.f237d = a(this.f236c, this.f238e, 3, eGLContext);
            } catch (d e3) {
                TXCLog.e(f235b, "failed to create EGLContext of 3.0. ".concat(String.valueOf(e3)));
                AppMethodBeat.o(222290);
                return false;
            }
        }
        int[] iArr2 = {12344};
        if (surface == null) {
            this.f242i = EGL14.eglCreatePbufferSurface(this.f236c, this.f238e, new int[]{12375, this.f239f, 12374, this.f240g, 12344}, 0);
        } else {
            this.f242i = EGL14.eglCreateWindowSurface(this.f236c, this.f238e, surface, iArr2, 0);
        }
        a();
        if (!EGL14.eglMakeCurrent(this.f236c, this.f242i, this.f242i, this.f237d)) {
            a();
            AppMethodBeat.o(222290);
            return false;
        }
        AppMethodBeat.o(222290);
        return true;
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2, EGLContext eGLContext) {
        AppMethodBeat.i(222291);
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, i2, 12344}, 0);
        f();
        AppMethodBeat.o(222291);
        return eglCreateContext;
    }

    private static void f() {
        AppMethodBeat.i(222292);
        int eglGetError = EGL14.eglGetError();
        if (eglGetError != 12288) {
            d dVar = new d(eglGetError);
            AppMethodBeat.o(222292);
            throw dVar;
        }
        AppMethodBeat.o(222292);
    }

    public void a(long j2) {
        AppMethodBeat.i(222293);
        EGLExt.eglPresentationTimeANDROID(this.f236c, this.f242i, j2);
        AppMethodBeat.o(222293);
    }

    public EGLContext e() {
        return this.f237d;
    }

    static {
        int i2;
        int i3 = 4;
        AppMethodBeat.i(222294);
        int[] iArr = new int[17];
        iArr[0] = 12324;
        iArr[1] = 8;
        iArr[2] = 12323;
        iArr[3] = 8;
        iArr[4] = 12322;
        iArr[5] = 8;
        iArr[6] = 12321;
        iArr[7] = 8;
        iArr[8] = 12325;
        iArr[9] = 0;
        iArr[10] = 12326;
        iArr[11] = 0;
        iArr[12] = 12352;
        if (f234a == 2) {
            i2 = 4;
        } else {
            i2 = 68;
        }
        iArr[13] = i2;
        iArr[14] = 12610;
        iArr[15] = 1;
        iArr[16] = 12344;
        k = iArr;
        int[] iArr2 = new int[19];
        iArr2[0] = 12339;
        iArr2[1] = 1;
        iArr2[2] = 12324;
        iArr2[3] = 8;
        iArr2[4] = 12323;
        iArr2[5] = 8;
        iArr2[6] = 12322;
        iArr2[7] = 8;
        iArr2[8] = 12321;
        iArr2[9] = 8;
        iArr2[10] = 12325;
        iArr2[11] = 0;
        iArr2[12] = 12326;
        iArr2[13] = 0;
        iArr2[14] = 12352;
        if (f234a != 2) {
            i3 = 68;
        }
        iArr2[15] = i3;
        iArr2[16] = 12610;
        iArr2[17] = 1;
        iArr2[18] = 12344;
        l = iArr2;
        AppMethodBeat.o(222294);
    }
}
