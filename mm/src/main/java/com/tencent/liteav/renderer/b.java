package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGLContext;

/* access modifiers changed from: package-private */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f1084a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f1085b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f1086c = TAVExporter.VIDEO_EXPORT_HEIGHT;

    /* renamed from: d  reason: collision with root package name */
    private int f1087d = TAVExporter.VIDEO_EXPORT_WIDTH;

    /* renamed from: e  reason: collision with root package name */
    private Object f1088e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private c f1089f = null;

    /* renamed from: g  reason: collision with root package name */
    private com.tencent.liteav.basic.c.b f1090g = null;

    /* renamed from: h  reason: collision with root package name */
    private Object f1091h = null;

    b(WeakReference<a> weakReference) {
        AppMethodBeat.i(16890);
        this.f1084a = weakReference;
        AppMethodBeat.o(16890);
    }

    public void run() {
        a aVar;
        int i2 = 16891;
        AppMethodBeat.i(i2);
        setName("VRender-" + getId());
        try {
            this.f1085b = true;
            k();
            f();
            i();
            while (this.f1085b) {
                if (h()) {
                    if (this.f1084a == null) {
                        aVar = null;
                    } else {
                        aVar = this.f1084a.get();
                    }
                    if (!(aVar == null || aVar.d() == null)) {
                        d();
                    }
                }
                synchronized (this.f1088e) {
                    try {
                        this.f1088e.wait();
                    } catch (InterruptedException e2) {
                    }
                    try {
                    } catch (Throwable th) {
                        i2 = 16891;
                        throw th;
                    }
                }
            }
            j();
            g();
            l();
            AppMethodBeat.o(i2);
        } catch (Exception e3) {
            TXCLog.e("TXCVideoRenderThread", "render failed.", e3);
        } finally {
            AppMethodBeat.o(i2);
        }
    }

    public void a(Object obj) {
        this.f1091h = obj;
    }

    public Object a() {
        AppMethodBeat.i(222340);
        if (this.f1090g != null) {
            EGLContext d2 = this.f1090g.d();
            AppMethodBeat.o(222340);
            return d2;
        } else if (this.f1089f != null) {
            android.opengl.EGLContext e2 = this.f1089f.e();
            AppMethodBeat.o(222340);
            return e2;
        } else {
            AppMethodBeat.o(222340);
            return null;
        }
    }

    public void b() {
        AppMethodBeat.i(16892);
        this.f1085b = false;
        c();
        AppMethodBeat.o(16892);
    }

    public void c() {
        AppMethodBeat.i(16893);
        synchronized (this.f1088e) {
            try {
                this.f1088e.notifyAll();
            } finally {
                AppMethodBeat.o(16893);
            }
        }
    }

    public void d() {
        AppMethodBeat.i(16894);
        if (this.f1090g != null) {
            this.f1090g.a();
        }
        if (this.f1089f != null) {
            this.f1089f.d();
        }
        AppMethodBeat.o(16894);
    }

    public void e() {
        AppMethodBeat.i(16895);
        if (this.f1090g != null) {
            this.f1090g.b();
        }
        if (this.f1089f != null) {
            this.f1089f.b();
        }
        AppMethodBeat.o(16895);
    }

    private void f() {
        AppMethodBeat.i(222341);
        try {
            a aVar = this.f1084a.get();
            if (aVar != null) {
                aVar.a(this);
            }
            AppMethodBeat.o(222341);
        } catch (Exception e2) {
            TXCLog.e("TXCVideoRenderThread", "init texture render failed.", e2);
            AppMethodBeat.o(222341);
        }
    }

    private void g() {
        AppMethodBeat.i(16897);
        try {
            a aVar = this.f1084a.get();
            if (aVar != null) {
                aVar.b(this);
            }
            AppMethodBeat.o(16897);
        } catch (Exception e2) {
            TXCLog.e("TXCVideoRenderThread", "destroy texture render failed", e2);
            AppMethodBeat.o(16897);
        }
    }

    private boolean h() {
        a aVar;
        AppMethodBeat.i(222342);
        try {
            if (!(this.f1084a == null || (aVar = this.f1084a.get()) == null)) {
                boolean c2 = aVar.c();
                AppMethodBeat.o(222342);
                return c2;
            }
        } catch (Exception e2) {
            TXCLog.e("TXCVideoRenderThread", "drawFrame failed." + e2.getMessage());
        }
        AppMethodBeat.o(222342);
        return false;
    }

    private void i() {
        a aVar;
        AppMethodBeat.i(16899);
        if (!(this.f1084a == null || (aVar = this.f1084a.get()) == null)) {
            aVar.k();
        }
        AppMethodBeat.o(16899);
    }

    private void j() {
        a aVar;
        AppMethodBeat.i(16900);
        if (!(this.f1084a == null || (aVar = this.f1084a.get()) == null)) {
            aVar.l();
        }
        AppMethodBeat.o(16900);
    }

    private void k() {
        Surface surface;
        AppMethodBeat.i(222343);
        a aVar = this.f1084a.get();
        if (aVar == null) {
            AppMethodBeat.o(222343);
            return;
        }
        SurfaceTexture d2 = aVar.d();
        if (d2 != null) {
            surface = new Surface(d2);
        } else {
            surface = null;
        }
        if (this.f1091h == null || (this.f1091h instanceof EGLContext)) {
            this.f1090g = com.tencent.liteav.basic.c.b.a(null, (EGLContext) this.f1091h, surface, this.f1086c, this.f1087d);
        } else {
            this.f1089f = c.a(null, (android.opengl.EGLContext) this.f1091h, surface, this.f1086c, this.f1087d);
        }
        TXCLog.w("TXCVideoRenderThread", "vrender: init egl share context " + this.f1091h + ", create context" + a());
        e();
        AppMethodBeat.o(222343);
    }

    private void l() {
        AppMethodBeat.i(222344);
        TXCLog.w("TXCVideoRenderThread", "vrender: uninit egl " + a());
        if (this.f1090g != null) {
            this.f1090g.c();
            this.f1090g = null;
        }
        if (this.f1089f != null) {
            this.f1089f.c();
            this.f1089f = null;
        }
        AppMethodBeat.o(222344);
    }
}
