package com.tencent.liteav.beauty.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.microedition.khronos.egl.EGL11;
import javax.microedition.khronos.egl.EGLSurface;

public class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f501a;

    /* renamed from: b  reason: collision with root package name */
    private EGLSurface f502b = EGL11.EGL_NO_SURFACE;

    /* renamed from: c  reason: collision with root package name */
    private int f503c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f504d = -1;

    protected b(a aVar) {
        this.f501a = aVar;
    }

    public void a(int i2, int i3) {
        AppMethodBeat.i(15282);
        if (this.f502b != EGL11.EGL_NO_SURFACE) {
            IllegalStateException illegalStateException = new IllegalStateException("surface already created");
            AppMethodBeat.o(15282);
            throw illegalStateException;
        }
        this.f502b = this.f501a.a(i2, i3);
        this.f503c = i2;
        this.f504d = i3;
        AppMethodBeat.o(15282);
    }

    public void a() {
        AppMethodBeat.i(15283);
        this.f501a.a(this.f502b);
        this.f502b = EGL11.EGL_NO_SURFACE;
        this.f504d = -1;
        this.f503c = -1;
        AppMethodBeat.o(15283);
    }

    public void b() {
        AppMethodBeat.i(15284);
        this.f501a.b(this.f502b);
        AppMethodBeat.o(15284);
    }
}
