package com.tencent.liteav.renderer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.internal.ServerProtocol;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;

public class e extends com.tencent.liteav.basic.module.a implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f1117a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
    private long A = 0;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private a F = new a();

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f1118b;

    /* renamed from: c  reason: collision with root package name */
    private int f1119c = 800;

    /* renamed from: d  reason: collision with root package name */
    protected TextureView f1120d;

    /* renamed from: e  reason: collision with root package name */
    protected d f1121e;

    /* renamed from: f  reason: collision with root package name */
    protected int f1122f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected int f1123g = 0;

    /* renamed from: h  reason: collision with root package name */
    protected int f1124h = 0;

    /* renamed from: i  reason: collision with root package name */
    protected int f1125i = 0;

    /* renamed from: j  reason: collision with root package name */
    protected int f1126j = 0;
    protected int k = 0;
    protected volatile int l = -1;
    protected int m = 0;
    protected int n = 0;
    protected f o;
    WeakReference<b> p;
    private com.tencent.liteav.basic.c.e q;
    private h r;
    private Surface s;
    private int t = 0;
    private int u;
    private int[] v = new int[5];
    private int w = 500;
    private long x = 0;
    private long y = 0;
    private long z = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f1137a;

        /* renamed from: b  reason: collision with root package name */
        public long f1138b;

        /* renamed from: c  reason: collision with root package name */
        public long f1139c;

        /* renamed from: d  reason: collision with root package name */
        public long f1140d;

        /* renamed from: e  reason: collision with root package name */
        public long f1141e;

        /* renamed from: f  reason: collision with root package name */
        public long f1142f;

        /* renamed from: g  reason: collision with root package name */
        public long f1143g;

        /* renamed from: h  reason: collision with root package name */
        public long f1144h;

        /* renamed from: i  reason: collision with root package name */
        public long f1145i;

        /* renamed from: j  reason: collision with root package name */
        public long f1146j;
        public int k;
        public int l;
    }

    static /* synthetic */ Bitmap a(e eVar, Matrix matrix, Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(182263);
        Bitmap a2 = eVar.a(matrix, bitmap, i2, i3);
        AppMethodBeat.o(182263);
        return a2;
    }

    public void a(int i2) {
        this.f1126j = i2;
    }

    private Bitmap a(Bitmap bitmap, int i2, int i3) {
        float height;
        AppMethodBeat.i(182261);
        if (((float) i3) / ((float) i2) > ((float) bitmap.getHeight()) / ((float) bitmap.getWidth())) {
            height = ((float) i2) / ((float) bitmap.getWidth());
        } else {
            height = ((float) i3) / ((float) bitmap.getHeight());
        }
        Matrix matrix = new Matrix();
        matrix.preScale(height, height);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        bitmap.recycle();
        AppMethodBeat.o(182261);
        return createBitmap;
    }

    private Bitmap a(Matrix matrix, Bitmap bitmap, int i2, int i3) {
        AppMethodBeat.i(182262);
        int i4 = 360 - ((this.t + this.k) % v2helper.VOIP_ENC_HEIGHT_LV1);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        bitmap.recycle();
        if (i4 != 0) {
            Matrix matrix2 = new Matrix();
            matrix2.setRotate((float) i4);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix2, false);
            createBitmap.recycle();
            createBitmap = createBitmap2;
        }
        if (this.u == 0) {
            int width = createBitmap.getWidth();
            int height = createBitmap.getHeight();
            boolean z2 = i2 < i3;
            if (z2 != (width < height)) {
                if (z2) {
                    float f2 = (((float) height) * ((float) i2)) / ((float) i3);
                    Matrix matrix3 = new Matrix();
                    matrix3.preScale(((float) i2) / f2, ((float) i2) / f2);
                    Bitmap createBitmap3 = Bitmap.createBitmap(createBitmap, (int) (0.5f * (((float) width) - f2)), 0, (int) f2, height, matrix3, false);
                    createBitmap.recycle();
                    createBitmap = createBitmap3;
                } else {
                    float f3 = (((float) width) / ((float) i2)) * ((float) i3);
                    Matrix matrix4 = new Matrix();
                    matrix4.preScale(((float) i3) / f3, ((float) i3) / f3);
                    Bitmap createBitmap4 = Bitmap.createBitmap(createBitmap, 0, (int) ((((float) height) - f3) * 0.5f), width, (int) f3, (Matrix) null, false);
                    Bitmap createBitmap5 = Bitmap.createBitmap(createBitmap4, 0, 0, createBitmap4.getWidth(), createBitmap4.getHeight(), matrix4, false);
                    createBitmap4.recycle();
                    createBitmap = createBitmap5;
                }
            } else if (!(i2 == createBitmap.getWidth() || i3 == createBitmap.getHeight())) {
                createBitmap = a(createBitmap, i2, i3);
            }
        } else if (!(i2 == createBitmap.getWidth() || i3 == createBitmap.getHeight())) {
            createBitmap = a(createBitmap, i2, i3);
        }
        AppMethodBeat.o(182262);
        return createBitmap;
    }

    public void a(final o oVar) {
        final Bitmap bitmap;
        AppMethodBeat.i(222333);
        final TextureView textureView = this.f1120d;
        if (textureView != null) {
            try {
                bitmap = textureView.getBitmap();
            } catch (OutOfMemoryError e2) {
                bitmap = null;
            }
            if (bitmap != null) {
                final Matrix transform = textureView.getTransform(null);
                AsyncTask.execute(new Runnable() {
                    /* class com.tencent.liteav.renderer.e.AnonymousClass1 */

                    public void run() {
                        Bitmap bitmap = null;
                        AppMethodBeat.i(16755);
                        try {
                            bitmap = e.a(e.this, transform, bitmap, textureView.getWidth(), textureView.getHeight());
                        } catch (Exception e2) {
                            TXCLog.w("TXCVideoRender", "takePhoto error ".concat(String.valueOf(e2)));
                        } catch (Error e3) {
                            TXCLog.w("TXCVideoRender", "takePhoto error ".concat(String.valueOf(e3)));
                        }
                        if (oVar != null) {
                            oVar.onTakePhotoComplete(bitmap);
                        }
                        AppMethodBeat.o(16755);
                    }
                });
            }
            AppMethodBeat.o(222333);
        } else if (this.q != null) {
            this.q.a(new Runnable() {
                /* class com.tencent.liteav.renderer.e.AnonymousClass2 */

                public void run() {
                    AppMethodBeat.i(16920);
                    if (e.this.q != null) {
                        e.this.q.a(oVar);
                    }
                    AppMethodBeat.o(16920);
                }
            });
            AppMethodBeat.o(222333);
        } else {
            if (oVar != null) {
                oVar.onTakePhotoComplete(null);
            }
            AppMethodBeat.o(222333);
        }
    }

    public void b(int i2) {
        if (i2 > 0) {
            this.f1119c = i2;
        }
    }

    public e() {
        AppMethodBeat.i(16795);
        AppMethodBeat.o(16795);
    }

    public void a(f fVar) {
        this.o = fVar;
    }

    public void a(b bVar) {
        AppMethodBeat.i(222334);
        this.p = new WeakReference<>(bVar);
        AppMethodBeat.o(222334);
    }

    public void a(TextureView textureView) {
        AppMethodBeat.i(16797);
        b(textureView);
        AppMethodBeat.o(16797);
    }

    public void a(Surface surface) {
        AppMethodBeat.i(16798);
        b(surface);
        AppMethodBeat.o(16798);
    }

    public void a(TXSVideoFrame tXSVideoFrame, int i2, int i3, int i4) {
        AppMethodBeat.i(16799);
        if (i4 != this.k) {
            this.k = i4;
            d(this.t);
        }
        a(i2, i3);
        b();
        AppMethodBeat.o(16799);
    }

    public void a(int i2, int i3, int i4, boolean z2, int i5) {
        AppMethodBeat.i(16800);
        a(i3, i4);
        AppMethodBeat.o(16800);
    }

    public void f() {
        AppMethodBeat.i(222335);
        Monitor.a(2, String.format("Remote-VideoRender[%d]: Start [tinyID:%s] [streamType:%d]", Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.f1126j)), "streamType: 2-big, 3-small, 7-sub", 0);
        this.C = true;
        if (Build.VERSION.SDK_INT >= 21) {
            this.E = true;
        } else {
            this.E = false;
        }
        this.D = false;
        m();
        AppMethodBeat.o(222335);
    }

    public void a(boolean z2) {
        AppMethodBeat.i(16802);
        if (this.C) {
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(hashCode());
            objArr[1] = getID();
            objArr[2] = Integer.valueOf(this.f1126j);
            objArr[3] = z2 ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
            Monitor.a(2, String.format("Remote-VideoRender[%d]: Stop [tinyID:%s][streamType:%d][stopRendThread:%s]", objArr), "streamType: 2-big, 3-small, 7-sub", 0);
        }
        this.C = false;
        this.D = false;
        this.E = false;
        if (!z2 || this.l != 1) {
            AppMethodBeat.o(16802);
            return;
        }
        this.l = -1;
        TXCLog.w("TXCVideoRender", "play:vrender: quit render thread when stop");
        e();
        synchronized (this) {
            try {
                if (this.q != null) {
                    TXCLog.i("TXCVideoRender", "surface-render:stop render thread " + this.q);
                    this.q.a();
                    this.q = null;
                }
            } finally {
                AppMethodBeat.o(16802);
            }
        }
    }

    public void b(int i2, int i3) {
        AppMethodBeat.i(16803);
        a(i2, i3);
        AppMethodBeat.o(16803);
    }

    public void c(int i2) {
        AppMethodBeat.i(16804);
        this.u = i2;
        if (this.f1121e != null) {
            this.f1121e.a(i2);
        }
        AppMethodBeat.o(16804);
    }

    public void d(int i2) {
        AppMethodBeat.i(16805);
        this.t = i2;
        if (this.f1121e != null) {
            this.f1121e.c((this.k + i2) % v2helper.VOIP_ENC_HEIGHT_LV1);
        }
        AppMethodBeat.o(16805);
    }

    public SurfaceTexture a() {
        return null;
    }

    public int g() {
        AppMethodBeat.i(222336);
        if (this.f1120d != null) {
            int width = this.f1120d.getWidth();
            AppMethodBeat.o(222336);
            return width;
        } else if (this.s != null) {
            int i2 = this.m;
            AppMethodBeat.o(222336);
            return i2;
        } else {
            AppMethodBeat.o(222336);
            return 0;
        }
    }

    public int h() {
        AppMethodBeat.i(16806);
        if (this.f1120d != null) {
            int height = this.f1120d.getHeight();
            AppMethodBeat.o(16806);
            return height;
        } else if (this.s != null) {
            int i2 = this.n;
            AppMethodBeat.o(16806);
            return i2;
        } else {
            AppMethodBeat.o(16806);
            return 0;
        }
    }

    public int i() {
        AppMethodBeat.i(16807);
        int i2 = this.f1124h;
        AppMethodBeat.o(16807);
        return i2;
    }

    public int j() {
        return this.f1125i;
    }

    /* access modifiers changed from: protected */
    public void a(SurfaceTexture surfaceTexture) {
        this.B = true;
    }

    /* access modifiers changed from: protected */
    public void b(SurfaceTexture surfaceTexture) {
        this.B = false;
    }

    public void c(Object obj) {
    }

    public void e() {
    }

    public void e(int i2) {
        this.w = i2;
    }

    private void b(TextureView textureView) {
        boolean z2 = false;
        AppMethodBeat.i(16808);
        if (textureView != null) {
            this.l = 0;
        }
        if ((this.f1120d == null && textureView != null) || (this.f1120d != null && !this.f1120d.equals(textureView))) {
            z2 = true;
        }
        TXCLog.w("TXCVideoRender", "play:vrender: set video view @old=" + this.f1120d + ",new=" + textureView + "id " + getID() + "_" + this.f1126j);
        if (z2) {
            if (this.f1120d != null && this.f1118b == null) {
                b(this.f1120d.getSurfaceTexture());
                this.f1120d.setSurfaceTextureListener(null);
            }
            this.f1120d = textureView;
            if (this.f1120d != null) {
                if (this.f1120d.getWidth() != 0) {
                    this.f1122f = this.f1120d.getWidth();
                }
                if (this.f1120d.getHeight() != 0) {
                    this.f1123g = this.f1120d.getHeight();
                }
                this.f1121e = new d(this.f1120d);
                this.f1121e.b(this.f1124h, this.f1125i);
                this.f1121e.a(this.f1122f, this.f1123g);
                this.f1121e.a(this.u);
                this.f1121e.c((this.t + this.k) % v2helper.VOIP_ENC_HEIGHT_LV1);
                this.f1120d.setSurfaceTextureListener(this);
                if (this.f1118b != null) {
                    if (Build.VERSION.SDK_INT < 16 || this.f1120d.getSurfaceTexture() == this.f1118b) {
                        TXCLog.w("TXCVideoRender", "play:vrender: not setSurfaceTexture old surfaceTexture " + this.f1120d.getSurfaceTexture() + ", new surfaceTexture " + this.f1118b);
                        AppMethodBeat.o(16808);
                        return;
                    }
                    TXCLog.w("TXCVideoRender", "play:vrender: setSurfaceTexture " + this.f1120d + ", surfaceTexture " + this.f1118b);
                    this.f1120d.setSurfaceTexture(this.f1118b);
                    AppMethodBeat.o(16808);
                    return;
                } else if (this.f1120d.isAvailable()) {
                    a(this.f1120d.getSurfaceTexture());
                }
            }
        }
        AppMethodBeat.o(16808);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3) {
        AppMethodBeat.i(16809);
        if (!((this.f1124h == i2 && this.f1125i == i3) || (this.f1124h == i2 && this.f1125i == i3))) {
            this.f1124h = i2;
            this.f1125i = i3;
            if (this.f1121e != null) {
                this.f1121e.b(this.f1124h, this.f1125i);
            }
        }
        AppMethodBeat.o(16809);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(16810);
        TXCLog.w("TXCVideoRender", "play:vrender: texture available @" + surfaceTexture + "id " + getID() + "_" + this.f1126j);
        this.f1122f = i2;
        this.f1123g = i3;
        if (this.f1121e != null) {
            this.f1121e.a(this.f1122f, this.f1123g);
        }
        if (this.f1118b != null) {
            if (Build.VERSION.SDK_INT >= 16 && this.f1120d.getSurfaceTexture() != this.f1118b) {
                this.f1120d.setSurfaceTexture(this.f1118b);
            }
            this.f1118b = null;
        } else {
            a(surfaceTexture);
        }
        this.B = true;
        AppMethodBeat.o(16810);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(16811);
        TXCLog.w("TXCVideoRender", "play:vrender: texture size change new:" + i2 + "," + i3 + " old:" + this.f1122f + "," + this.f1123g);
        if (!this.B) {
            TXCLog.w("TXCVideoRender", "play:vrender: onSurfaceCreate on onSurfaceTextureSizeChanged when onSurfaceTextureAvailable is not trigger");
            this.B = true;
            a(surfaceTexture);
        }
        this.f1122f = i2;
        this.f1123g = i3;
        if (this.f1121e != null) {
            this.f1121e.a(this.f1122f, this.f1123g);
        }
        AppMethodBeat.o(16811);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(16812);
        try {
            this.B = false;
            TXCLog.w("TXCVideoRender", "play:vrender:  onSurfaceTextureDestroyed when need save texture : " + this.E + "id " + getID() + "_" + this.f1126j);
            if (this.E) {
                this.f1118b = surfaceTexture;
            } else {
                this.F.f1137a = 0;
                b(surfaceTexture);
                if (surfaceTexture == this.f1118b) {
                    this.f1118b = null;
                }
            }
        } catch (Exception e2) {
            TXCLog.e("TXCVideoRender", "onSurfaceTextureDestroyed failed.", e2);
        }
        if (this.f1118b == null) {
            AppMethodBeat.o(16812);
            return true;
        }
        AppMethodBeat.o(16812);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    private void b(Surface surface) {
        AppMethodBeat.i(16813);
        TXCLog.i("TXCVideoRender", "surface-render: set surface ".concat(String.valueOf(surface)));
        if (this.s == surface) {
            TXCLog.i("TXCVideoRender", "surface-render: set the same surface, ignore ");
            AppMethodBeat.o(16813);
            return;
        }
        this.s = surface;
        this.l = 1;
        if (surface != null) {
            TXCLog.i("TXCVideoRender", "surface-render: set surface start render thread ".concat(String.valueOf(surface)));
            c((Object) null);
            AppMethodBeat.o(16813);
            return;
        }
        synchronized (this) {
            try {
                if (this.q != null) {
                    TXCLog.i("TXCVideoRender", "surface-render: set surface stop render thread " + this.q);
                    this.q.a();
                    this.q = null;
                }
            } finally {
                AppMethodBeat.o(16813);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
    }

    /* access modifiers changed from: protected */
    public void l() {
        AppMethodBeat.i(222337);
        synchronized (this) {
            try {
                if (this.q != null) {
                    TXCLog.i("TXCVideoRender", "surface-render: onRenderThreadEGLDestroy stop render thread " + this.q);
                    this.q.a();
                    this.q = null;
                }
            } finally {
                AppMethodBeat.o(222337);
            }
        }
        if (this.r != null) {
            this.r.c();
            this.r = null;
        }
    }

    /* access modifiers changed from: protected */
    public void a(Object obj, int i2, float[] fArr, boolean z2) {
        Surface b2;
        AppMethodBeat.i(222338);
        if (this.l == 1) {
            int[] a2 = a(i2, this.f1124h, this.f1125i, fArr, z2);
            int i3 = a2[0];
            int i4 = a2[1];
            int i5 = a2[2];
            System.arraycopy(a2, 0, this.v, 0, 3);
            if (z2) {
                this.v[3] = 1;
                this.v[4] = 180;
            } else {
                this.v[3] = 0;
                this.v[4] = 0;
            }
            synchronized (this) {
                try {
                    Surface surface = this.s;
                    if (surface != null) {
                        if (this.q != null && ((b2 = this.q.b()) != surface || (b2 != null && !b2.isValid()))) {
                            TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface surface change stop render thread " + this.q + ", " + b2 + ", " + surface);
                            this.q.a();
                            this.q = null;
                        }
                        if (this.q == null && this.l == 1 && surface.isValid()) {
                            this.q = new com.tencent.liteav.basic.c.e();
                            TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface start render thread " + this.q + "," + surface);
                            this.q.a(obj, surface);
                        }
                        if (this.q != null && this.l == 1) {
                            if (z2) {
                                this.q.a(i3, true, TXLiveConstants.RENDER_ROTATION_180, this.m, this.n, i4, i5, false, false);
                            } else {
                                this.q.a(i3, false, 0, this.m, this.n, i4, i5, false, false);
                            }
                        }
                    } else if (this.q != null) {
                        TXCLog.i("TXCVideoRender", "surface-render: onDrawTextureToSurface stop render thread " + this.q);
                        this.q.a();
                        this.q = null;
                    }
                } finally {
                    AppMethodBeat.o(222338);
                }
            }
            return;
        }
        AppMethodBeat.o(222338);
    }

    private int[] a(int i2, int i3, int i4, float[] fArr, boolean z2) {
        AppMethodBeat.i(16816);
        if (!(this.r == null || this.r.a() == z2)) {
            this.r.c();
            this.r = null;
        }
        if (this.r == null) {
            this.r = new h(Boolean.valueOf(z2));
            this.r.b();
        }
        if (fArr != null) {
            this.r.a(fArr);
        } else {
            this.r.a(f1117a);
        }
        int i5 = this.m;
        int i6 = this.n;
        if (this.u == 0) {
            this.r.a(h.f1147a);
        } else {
            this.r.a(h.f1148b);
        }
        int i7 = (this.t + this.k) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if (z2 && (this.t == 90 || this.t == 270)) {
            i7 = ((this.t + this.k) + TXLiveConstants.RENDER_ROTATION_180) % v2helper.VOIP_ENC_HEIGHT_LV1;
        }
        this.r.b(i7);
        this.r.b(i3, i4);
        this.r.a(i5, i6);
        int[] iArr = {this.r.d(i2), i5, i6};
        AppMethodBeat.o(16816);
        return iArr;
    }

    public void c(final int i2, final int i3) {
        AppMethodBeat.i(16817);
        TXCLog.i("TXCVideoRender", "surface-render: set setSurfaceSize " + i2 + "*" + i3);
        if (!(i2 == this.m && i3 == this.n)) {
            if (this.q == null || this.l != 1 || this.v == null) {
                this.m = i2;
                this.n = i3;
            } else {
                this.q.a(new Runnable() {
                    /* class com.tencent.liteav.renderer.e.AnonymousClass3 */

                    public void run() {
                        boolean z;
                        AppMethodBeat.i(182260);
                        e.this.m = i2;
                        e.this.n = i3;
                        if (e.this.q != null) {
                            com.tencent.liteav.basic.c.e eVar = e.this.q;
                            int i2 = e.this.v[0];
                            if (e.this.v[3] == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            eVar.a(i2, z, e.this.v[4], e.this.m, e.this.n, e.this.v[1], e.this.v[2], true, false);
                        }
                        AppMethodBeat.o(182260);
                    }
                });
                AppMethodBeat.o(16817);
                return;
            }
        }
        AppMethodBeat.o(16817);
    }

    public void m() {
        AppMethodBeat.i(16814);
        this.F.f1137a = 0;
        this.F.f1138b = 0;
        this.F.f1139c = 0;
        this.F.f1140d = 0;
        this.F.f1141e = 0;
        this.F.f1142f = 0;
        this.F.f1143g = 0;
        this.F.f1144h = 0;
        this.F.f1145i = 0;
        this.F.f1146j = 0;
        this.F.k = 0;
        this.F.l = 0;
        setStatusValue(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, this.f1126j, 0L);
        setStatusValue(6002, this.f1126j, Double.valueOf(0.0d));
        setStatusValue(6003, this.f1126j, 0L);
        setStatusValue(6005, this.f1126j, 0L);
        setStatusValue(6006, this.f1126j, 0L);
        setStatusValue(6004, this.f1126j, 0L);
        AppMethodBeat.o(16814);
    }

    private long a(long j2) {
        AppMethodBeat.i(16819);
        long timeTick = TXCTimeUtil.getTimeTick();
        if (j2 > timeTick) {
            AppMethodBeat.o(16819);
            return 0;
        }
        long j3 = timeTick - j2;
        AppMethodBeat.o(16819);
        return j3;
    }

    public void n() {
        AppMethodBeat.i(16818);
        if (this.F.f1137a == 0) {
            this.F.f1137a = TXCTimeUtil.getTimeTick();
            AppMethodBeat.o(16818);
            return;
        }
        long timeTick = TXCTimeUtil.getTimeTick() - this.F.f1137a;
        if (timeTick >= 1000) {
            double d2 = (((double) (this.F.f1139c - this.F.f1138b)) * 1000.0d) / ((double) timeTick);
            setStatusValue(6002, this.f1126j, Double.valueOf(d2));
            TXCKeyPointReportProxy.a(getID(), CdnLogic.kMediaTypeStoryAudio, (long) ((int) d2), this.f1126j);
            this.F.f1138b = this.F.f1139c;
            a aVar = this.F;
            aVar.f1137a = timeTick + aVar.f1137a;
        }
        AppMethodBeat.o(16818);
    }

    private void b() {
        AppMethodBeat.i(16821);
        if (!this.D) {
            Bundle bundle = new Bundle();
            bundle.putString("EVT_USERID", getID());
            bundle.putInt("EVT_ID", 2003);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Render the first video frame(IDR)");
            bundle.putInt("EVT_PARAM1", this.f1124h);
            bundle.putInt("EVT_PARAM2", this.f1125i);
            f.a(this.p, 2003, bundle);
            setStatusValue(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE, this.f1126j, Long.valueOf(TXCTimeUtil.getTimeTick()));
            setStatusValue(6015, this.f1126j, Integer.valueOf(this.f1124h));
            setStatusValue(6016, this.f1126j, Integer.valueOf(this.f1125i));
            TXCLog.i("TXCVideoRender", "[FirstFramePath][Video][Render] TXCVideoRender: render first video frame. instance:" + hashCode() + " id:" + getID() + " type:" + this.f1126j);
            this.D = true;
            Monitor.a(2, String.format("Remote-VideoRender[%d]: Render first frame [tinyID:%s][streamType:%d]", Integer.valueOf(hashCode()), getID(), Integer.valueOf(this.f1126j)), "streamType: 2-big, 3-small, 7-sub", 0);
            TXCKeyPointReportProxy.a(getID(), 40022, 0, this.f1126j);
        }
        this.F.f1139c++;
        n();
        if (this.F.f1140d != 0) {
            this.F.f1146j = a(this.F.f1140d);
            if (this.F.f1146j > 200) {
                this.F.f1141e++;
                setStatusValue(6021, this.f1126j, Long.valueOf(this.F.f1141e));
            }
            if (this.F.f1146j > ((long) this.w)) {
                this.F.f1142f++;
                setStatusValue(6003, this.f1126j, Long.valueOf(this.F.f1142f));
                if (this.F.f1146j > this.F.f1145i) {
                    this.F.f1145i = this.F.f1146j;
                    setStatusValue(6005, this.f1126j, Long.valueOf(this.F.f1145i));
                }
                this.F.f1144h += this.F.f1146j;
                setStatusValue(6006, this.f1126j, Long.valueOf(this.F.f1144h));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.F.f1139c + " block time:" + this.F.f1146j + "> 500");
            }
            if (this.F.f1146j > ((long) this.f1119c)) {
                this.x++;
                this.z += this.F.f1146j;
                TXCLog.w("TXCVideoRender", "render frame count:" + this.F.f1139c + " block time:" + this.F.f1146j + "> " + this.f1119c);
                f.a(this.p, getID(), 2105, "Current video block for " + this.F.f1146j + LocaleUtil.MALAY);
            }
            if (this.F.f1146j > 1000) {
                this.F.f1143g++;
                setStatusValue(6004, this.f1126j, Long.valueOf(this.F.f1143g));
                TXCLog.w("TXCVideoRender", "render frame count:" + this.F.f1139c + " block time:" + this.F.f1146j + "> 1000");
            }
        }
        long timeTick = TXCTimeUtil.getTimeTick();
        if (this.y == 0) {
            this.y = timeTick;
        } else if (timeTick - this.y >= 2000) {
            setStatusValue(17015, this.f1126j, Long.valueOf(this.x));
            setStatusValue(17016, this.f1126j, Long.valueOf(this.z));
            if (this.A != 0) {
                TXCKeyPointReportProxy.a(getID(), 40005, (long) ((int) this.z), this.f1126j);
                TXCKeyPointReportProxy.a(getID(), 40006, (long) ((int) (timeTick - this.y)), this.f1126j);
            }
            this.x = 0;
            this.y = timeTick;
            this.z = 0;
        }
        this.F.f1140d = TXCTimeUtil.getTimeTick();
        if (this.A == 0) {
            this.A = this.F.f1140d;
        }
        this.F.l = this.f1125i;
        this.F.k = this.f1124h;
        AppMethodBeat.o(16821);
    }
}
