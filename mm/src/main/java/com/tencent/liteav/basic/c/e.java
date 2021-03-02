package com.tencent.liteav.basic.c;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLES20;
import android.os.HandlerThread;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.liteav.basic.c.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGLContext;

public class e implements g.a {

    /* renamed from: a  reason: collision with root package name */
    private volatile HandlerThread f244a = null;

    /* renamed from: b  reason: collision with root package name */
    private volatile g f245b = null;

    /* renamed from: c  reason: collision with root package name */
    private h f246c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f247d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f248e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f249f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f250g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    private int f251h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f252i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f253j = 0;
    private int k = 0;
    private boolean l = false;
    private o m = null;
    private boolean n = false;

    static /* synthetic */ void a(e eVar, int i2, boolean z, int i3, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        AppMethodBeat.i(222244);
        eVar.b(i2, z, i3, i4, i5, i6, i7, z2, z3);
        AppMethodBeat.o(222244);
    }

    public void a(Object obj, Surface surface) {
        AppMethodBeat.i(222230);
        TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render start " + surface + ", " + this);
        b(obj, surface);
        AppMethodBeat.o(222230);
    }

    public void a() {
        AppMethodBeat.i(222231);
        TXCLog.i("TXGLSurfaceRenderThread", "surface-render: surface render stop ".concat(String.valueOf(this)));
        f();
        AppMethodBeat.o(222231);
    }

    public Surface b() {
        Surface b2;
        AppMethodBeat.i(222232);
        synchronized (this) {
            try {
                b2 = this.f245b != null ? this.f245b.b() : null;
            } finally {
                AppMethodBeat.o(222232);
            }
        }
        return b2;
    }

    public void a(final int i2) {
        AppMethodBeat.i(222233);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.e.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(222311);
                e.this.f251h = i2;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                AppMethodBeat.o(222311);
            }
        });
        AppMethodBeat.o(222233);
    }

    public void b(final int i2) {
        AppMethodBeat.i(222234);
        a(new Runnable() {
            /* class com.tencent.liteav.basic.c.e.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(222204);
                e.this.f252i = i2;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                AppMethodBeat.o(222204);
            }
        });
        AppMethodBeat.o(222234);
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(222235);
        synchronized (this) {
            try {
                if (this.f245b != null) {
                    this.f245b.post(runnable);
                }
            } finally {
                AppMethodBeat.o(222235);
            }
        }
    }

    public void a(final int i2, final boolean z, final int i3, final int i4, final int i5, final int i6, final int i7, final boolean z2, final boolean z3) {
        AppMethodBeat.i(222236);
        GLES20.glFinish();
        synchronized (this) {
            try {
                if (this.f245b != null) {
                    this.f245b.post(new Runnable() {
                        /* class com.tencent.liteav.basic.c.e.AnonymousClass3 */

                        public void run() {
                            AppMethodBeat.i(222186);
                            try {
                                e.a(e.this, i2, z, i3, i4, i5, i6, i7, z2, z3);
                                AppMethodBeat.o(222186);
                            } catch (Exception e2) {
                                TXCLog.e("TXGLSurfaceRenderThread", "surface-render: render texture error occurred!" + e2.getMessage());
                                AppMethodBeat.o(222186);
                            }
                        }
                    });
                }
            } finally {
                AppMethodBeat.o(222236);
            }
        }
    }

    public void a(o oVar) {
        this.m = oVar;
        this.l = true;
    }

    @Override // com.tencent.liteav.basic.c.g.a
    public void c() {
        AppMethodBeat.i(222237);
        this.f246c = new h();
        if (!this.f246c.a()) {
            AppMethodBeat.o(222237);
            return;
        }
        this.f246c.a(l.f344e, l.a(k.NORMAL, false, false));
        AppMethodBeat.o(222237);
    }

    @Override // com.tencent.liteav.basic.c.g.a
    public void d() {
    }

    @Override // com.tencent.liteav.basic.c.g.a
    public void e() {
        AppMethodBeat.i(222238);
        if (this.f246c != null) {
            this.f246c.d();
            this.f246c = null;
        }
        AppMethodBeat.o(222238);
    }

    private void b(Object obj, Surface surface) {
        AppMethodBeat.i(222239);
        f();
        synchronized (this) {
            try {
                this.f244a = new HandlerThread("TXGLSurfaceRenderThread");
                this.f244a.start();
                this.f245b = new g(this.f244a.getLooper());
                this.f245b.a(this);
                if (obj == null || (obj instanceof EGLContext)) {
                    this.f245b.f291d = false;
                    this.f245b.f295h = (EGLContext) obj;
                } else {
                    this.f245b.f291d = true;
                    this.f245b.f293f = (android.opengl.EGLContext) obj;
                }
                this.f245b.f290c = surface;
                TXCLog.w("TXGLSurfaceRenderThread", "surface-render: create gl thread " + this.f244a.getName());
            } catch (Throwable th) {
                AppMethodBeat.o(222239);
                throw th;
            }
        }
        c(100);
        AppMethodBeat.o(222239);
    }

    private void f() {
        AppMethodBeat.i(222240);
        synchronized (this) {
            try {
                if (this.f245b != null) {
                    g.a(this.f245b, this.f244a);
                    TXCLog.w("TXGLSurfaceRenderThread", "surface-render: destroy gl thread");
                }
                this.f245b = null;
                this.f244a = null;
            } finally {
                AppMethodBeat.o(222240);
            }
        }
    }

    private void c(int i2) {
        AppMethodBeat.i(222241);
        synchronized (this) {
            try {
                if (this.f245b != null) {
                    this.f245b.sendEmptyMessage(i2);
                }
            } finally {
                AppMethodBeat.o(222241);
            }
        }
    }

    private void b(int i2, boolean z, int i3, int i4, int i5, int i6, int i7, boolean z2, boolean z3) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        AppMethodBeat.i(222242);
        if (i6 == 0 || i7 == 0 || this.f246c == null) {
            AppMethodBeat.o(222242);
        } else if (this.n) {
            this.n = false;
            AppMethodBeat.o(222242);
        } else {
            if (z2) {
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                GLES20.glBindFramebuffer(36160, 0);
                if (this.f245b != null) {
                    this.f245b.c();
                }
                this.n = true;
            }
            int i13 = i4 != 0 ? i4 : i6;
            if (i5 == 0) {
                i5 = i7;
            }
            if (this.f251h == 0) {
                i8 = 0;
                i9 = 0;
            } else if (this.f251h == 1) {
                int i14 = (720 - this.f247d) % v2helper.VOIP_ENC_HEIGHT_LV1;
                boolean z4 = i14 == 90 || i14 == 270;
                if (z4) {
                    i10 = i7;
                } else {
                    i10 = i6;
                }
                if (z4) {
                    i11 = i6;
                } else {
                    i11 = i7;
                }
                int[] a2 = a(i13, i5, i10, i11);
                i13 = a2[0];
                i5 = a2[1];
                int i15 = a2[2];
                i8 = a2[3];
                i9 = i15;
            } else {
                i8 = 0;
                i9 = 0;
            }
            this.f253j = i13;
            this.k = i5;
            GLES20.glViewport(i9, i8, i13, i5);
            if (this.f252i == 1) {
                if (!z3) {
                    z = !z;
                }
            } else if (this.f252i == 2 && z3) {
                z = !z;
            }
            float f2 = i5 != 0 ? ((float) i13) / ((float) i5) : 1.0f;
            float f3 = i7 != 0 ? ((float) i6) / ((float) i7) : 1.0f;
            if (!(this.f248e == z && this.f247d == i3 && this.f249f == f2 && this.f250g == f3)) {
                this.f248e = z;
                this.f247d = i3;
                this.f249f = f2;
                this.f250g = f3;
                int i16 = (720 - this.f247d) % v2helper.VOIP_ENC_HEIGHT_LV1;
                boolean z5 = i16 == 90 || i16 == 270;
                if (z5) {
                    i12 = i5;
                } else {
                    i12 = i13;
                }
                if (!z5) {
                    i13 = i5;
                }
                this.f246c.a(i6, i7, i16, l.a(k.NORMAL, false, true), ((float) i12) / ((float) i13), z5 ? false : this.f248e, z5 ? this.f248e : false);
                if (z5) {
                    this.f246c.g();
                } else {
                    this.f246c.h();
                }
            }
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            GLES20.glBindFramebuffer(36160, 0);
            this.f246c.a(i2);
            a(i9, i8);
            if (this.f245b != null) {
                this.f245b.c();
            }
            AppMethodBeat.o(222242);
        }
    }

    private int[] a(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] iArr = new int[4];
        float f2 = ((float) i5) / ((float) i4);
        if (((float) i3) / ((float) i2) > f2) {
            int i8 = (int) (((float) i2) * f2);
            i7 = (i3 - i8) / 2;
            i6 = 0;
            i3 = i8;
        } else {
            int i9 = (int) (((float) i3) / f2);
            i6 = (i2 - i9) / 2;
            i7 = 0;
            i2 = i9;
        }
        iArr[0] = i2;
        iArr[1] = i3;
        iArr[2] = i6;
        iArr[3] = i7;
        return iArr;
    }

    private void a(int i2, int i3) {
        final int i4;
        final int i5;
        AppMethodBeat.i(222243);
        if (this.l) {
            if (!(this.f253j == 0 || this.k == 0)) {
                boolean z = this.f253j <= this.k;
                int i6 = this.k >= this.f253j ? this.k : this.f253j;
                int i7 = this.k >= this.f253j ? this.f253j : this.k;
                if (z) {
                    i4 = i6;
                    i5 = i7;
                } else {
                    i4 = i7;
                    i5 = i6;
                }
                final ByteBuffer allocate = ByteBuffer.allocate(i5 * i4 * 4);
                final Bitmap createBitmap = Bitmap.createBitmap(i5, i4, Bitmap.Config.ARGB_8888);
                allocate.position(0);
                GLES20.glReadPixels(i2, i3, i5, i4, NativeBitmapStruct.GLFormat.GL_RGBA, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, allocate);
                final o oVar = this.m;
                if (oVar != null) {
                    new Thread(new Runnable() {
                        /* class com.tencent.liteav.basic.c.e.AnonymousClass4 */

                        public void run() {
                            AppMethodBeat.i(222210);
                            allocate.position(0);
                            createBitmap.copyPixelsFromBuffer(allocate);
                            Matrix matrix = new Matrix();
                            matrix.setScale(1.0f, -1.0f);
                            oVar.onTakePhotoComplete(Bitmap.createBitmap(createBitmap, 0, 0, i5, i4, matrix, false));
                            createBitmap.recycle();
                            AppMethodBeat.o(222210);
                        }
                    }).start();
                }
            }
            this.m = null;
            this.l = false;
        }
        AppMethodBeat.o(222243);
    }
}
