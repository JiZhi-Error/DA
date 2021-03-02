package com.tencent.liteav.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.c.k;
import com.tencent.liteav.basic.c.l;
import com.tencent.liteav.basic.c.m;
import com.tencent.liteav.basic.c.n;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceView extends TXCGLSurfaceViewBase implements SurfaceTexture.OnFrameAvailableListener, GLSurfaceView.Renderer, m {
    private o A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private n F;
    private long G;
    private byte[] H;
    private long I;
    private int J;
    private int K;
    private final Queue<Runnable> L;

    /* renamed from: a  reason: collision with root package name */
    WeakReference<b> f1013a;

    /* renamed from: g  reason: collision with root package name */
    private SurfaceTexture f1014g;

    /* renamed from: h  reason: collision with root package name */
    private EGLContext f1015h;

    /* renamed from: i  reason: collision with root package name */
    private h f1016i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f1017j;
    private float[] k;
    private int l;
    private boolean m;
    private float n;
    private float o;
    private int p;
    private long q;
    private long r;
    private int s;
    private boolean t;
    private boolean u;
    private Object v;
    private Handler w;
    private int x;
    private int y;
    private boolean z;

    public TXCGLSurfaceView(Context context) {
        super(context);
        AppMethodBeat.i(16757);
        this.k = new float[16];
        this.l = 0;
        this.m = false;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 20;
        this.q = 0;
        this.r = 0;
        this.s = 12288;
        this.t = true;
        this.u = false;
        this.v = new Object();
        this.x = 0;
        this.y = 0;
        this.z = true;
        this.A = null;
        this.B = 0;
        this.C = 0;
        this.D = true;
        this.E = true;
        this.H = null;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = new LinkedList();
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        AppMethodBeat.o(16757);
    }

    public TXCGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(16758);
        this.k = new float[16];
        this.l = 0;
        this.m = false;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = 20;
        this.q = 0;
        this.r = 0;
        this.s = 12288;
        this.t = true;
        this.u = false;
        this.v = new Object();
        this.x = 0;
        this.y = 0;
        this.z = true;
        this.A = null;
        this.B = 0;
        this.C = 0;
        this.D = true;
        this.E = true;
        this.H = null;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = new LinkedList();
        setEGLContextClientVersion(2);
        a(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        AppMethodBeat.o(16758);
    }

    public void setFPS(final int i2) {
        AppMethodBeat.i(16759);
        b(new Runnable() {
            /* class com.tencent.liteav.renderer.TXCGLSurfaceView.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(16782);
                TXCGLSurfaceView.this.p = i2;
                if (TXCGLSurfaceView.this.p <= 0) {
                    TXCGLSurfaceView.this.p = 1;
                } else if (TXCGLSurfaceView.this.p > 60) {
                    TXCGLSurfaceView.this.p = 60;
                }
                TXCGLSurfaceView.this.r = 0;
                TXCGLSurfaceView.this.q = 0;
                AppMethodBeat.o(16782);
            }
        });
        AppMethodBeat.o(16759);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void setRendMode(final int i2) {
        AppMethodBeat.i(16760);
        b(new Runnable() {
            /* class com.tencent.liteav.renderer.TXCGLSurfaceView.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(16822);
                TXCGLSurfaceView.this.B = i2;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                AppMethodBeat.o(16822);
            }
        });
        AppMethodBeat.o(16760);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void setRendMirror(final int i2) {
        AppMethodBeat.i(16761);
        b(new Runnable() {
            /* class com.tencent.liteav.renderer.TXCGLSurfaceView.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(16841);
                TXCGLSurfaceView.this.C = i2;
                GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                GLES20.glClear(16640);
                AppMethodBeat.o(16841);
            }
        });
        AppMethodBeat.o(16761);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase
    public void b() {
        AppMethodBeat.i(16762);
        TXCLog.i("TXCGLSurfaceView", "surfaceDestroyed-->enter with mSurfaceTextureListener:" + this.F);
        if (this.F != null) {
            this.F.b(this.f1014g);
        }
        if (this.f1014g != null) {
            this.f1014g.release();
            this.f1014g = null;
        }
        AppMethodBeat.o(16762);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase
    public void setRunInBackground(boolean z2) {
        AppMethodBeat.i(16763);
        if (z2) {
            synchronized (this) {
                try {
                    TXCLog.i("TXCGLSurfaceView", "background capture enter background");
                    this.f1033c = true;
                } finally {
                    AppMethodBeat.o(16763);
                }
            }
            return;
        }
        b(new Runnable() {
            /* class com.tencent.liteav.renderer.TXCGLSurfaceView.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(16839);
                synchronized (this) {
                    try {
                        TXCLog.i("TXCGLSurfaceView", "background capture exit background");
                        TXCGLSurfaceView.this.f1033c = false;
                    } finally {
                        AppMethodBeat.o(16839);
                    }
                }
            }
        });
        AppMethodBeat.o(16763);
    }

    public void setNotifyListener(b bVar) {
        AppMethodBeat.i(222339);
        this.f1013a = new WeakReference<>(bVar);
        AppMethodBeat.o(222339);
    }

    public void a(o oVar) {
        this.A = oVar;
        this.z = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        android.opengl.GLES20.glClear(16640);
        r3 = getWidth();
        r2 = getHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002d, code lost:
        if (r12.B != 0) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r1 = r2;
        r9 = 0;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r12.x = r3;
        r12.y = r1;
        android.opengl.GLES20.glViewport(r10, r9, r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003e, code lost:
        if (r12.C != 1) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (r18 != false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        if (r14 != false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0046, code lost:
        if (r1 == 0) goto L_0x0127;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r4 = ((float) r3) / ((float) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r17 == 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r2 = ((float) r16) / ((float) r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0057, code lost:
        if (r12.m != r14) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005b, code lost:
        if (r12.l != r15) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0061, code lost:
        if (r12.n != r4) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0067, code lost:
        if (r12.o != r2) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006d, code lost:
        if (r12.D == r18) goto L_0x00b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x006f, code lost:
        r12.m = r14;
        r12.l = r15;
        r12.n = r4;
        r12.o = r2;
        r12.D = r18;
        r4 = (720 - r12.l) % com.tencent.wxmm.v2helper.VOIP_ENC_HEIGHT_LV1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0083, code lost:
        if (r4 == 90) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
        if (r4 != 270) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        r11 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x008b, code lost:
        if (r11 == false) goto L_0x0134;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x008d, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x008e, code lost:
        if (r11 == false) goto L_0x0137;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0090, code lost:
        r1 = r12.f1016i;
        r5 = com.tencent.liteav.basic.c.l.a(com.tencent.liteav.basic.c.k.NORMAL, false, true);
        r6 = ((float) r2) / ((float) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        if (r11 == false) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a0, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a1, code lost:
        if (r11 == false) goto L_0x013e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a3, code lost:
        r8 = r12.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a5, code lost:
        r1.a(r16, r17, r4, r5, r6, r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ac, code lost:
        if (r11 == false) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ae, code lost:
        r12.f1016i.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b3, code lost:
        android.opengl.GLES20.glBindFramebuffer(36160, 0);
        android.opengl.GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        android.opengl.GLES20.glClear(16640);
        r12.f1016i.a(r13);
        a(r10, r9);
        com.tencent.matrix.trace.core.AppMethodBeat.o(16765);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e1, code lost:
        if (r12.B != 1) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e3, code lost:
        r1 = (720 - r15) % com.tencent.wxmm.v2helper.VOIP_ENC_HEIGHT_LV1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00e9, code lost:
        if (r1 == 90) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ed, code lost:
        if (r1 != 270) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ef, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f0, code lost:
        if (r1 == false) goto L_0x010f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00f2, code lost:
        r4 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f4, code lost:
        if (r1 == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f6, code lost:
        r1 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f8, code lost:
        r3 = a(r3, r2, r4, r1);
        r2 = r3[0];
        r1 = r3[1];
        r5 = r3[2];
        r4 = r3[3];
        r3 = r2;
        r9 = r4;
        r10 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x010d, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x010f, code lost:
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0112, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0115, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x011b, code lost:
        if (r12.C != 2) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x011d, code lost:
        if (r18 == false) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x011f, code lost:
        if (r14 != false) goto L_0x0125;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0121, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0122, code lost:
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0125, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0127, code lost:
        r4 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x012c, code lost:
        r2 = 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0130, code lost:
        r11 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0134, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0137, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x013a, code lost:
        r7 = r12.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x013e, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0141, code lost:
        r12.f1016i.h();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0148, code lost:
        r1 = r2;
        r9 = 0;
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    @Override // com.tencent.liteav.basic.c.m
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r13, boolean r14, int r15, int r16, int r17, boolean r18) {
        /*
        // Method dump skipped, instructions count: 333
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceView.a(int, boolean, int, int, int, boolean):void");
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(byte[] bArr) {
        synchronized (this) {
            this.H = bArr;
            this.t = false;
            this.u = true;
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

    @Override // com.tencent.liteav.basic.c.m
    public SurfaceTexture getSurfaceTexture() {
        return this.f1014g;
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(int i2, boolean z2) {
        AppMethodBeat.i(16766);
        this.p = i2;
        if (this.p <= 0) {
            this.p = 1;
        } else if (this.p > 60) {
            this.p = 60;
        }
        this.A = null;
        this.z = false;
        this.J = 0;
        this.I = 0;
        this.K = 0;
        b(true);
        this.E = z2;
        this.G = 0;
        g();
        AppMethodBeat.o(16766);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a() {
        AppMethodBeat.i(16767);
        b(false);
        AppMethodBeat.o(16767);
    }

    @Override // com.tencent.liteav.basic.c.m
    public void setSurfaceTextureListener(n nVar) {
        this.F = nVar;
    }

    @Override // com.tencent.liteav.basic.c.m
    public EGLContext getGLContext() {
        return this.f1015h;
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(Runnable runnable) {
        AppMethodBeat.i(16768);
        synchronized (this.L) {
            try {
                this.L.add(runnable);
            } finally {
                AppMethodBeat.o(16768);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase
    public int c() {
        AppMethodBeat.i(16769);
        if (this.s != 12288) {
            TXCLog.e("TXCGLSurfaceView", "background capture swapbuffer error : " + this.s);
        }
        int i2 = this.s;
        AppMethodBeat.o(16769);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.liteav.renderer.TXCGLSurfaceViewBase
    public void onDetachedFromWindow() {
        AppMethodBeat.i(16770);
        super.onDetachedFromWindow();
        if (Build.VERSION.SDK_INT >= 21 && this.w != null) {
            this.w.getLooper().quitSafely();
            this.w = null;
        }
        AppMethodBeat.o(16770);
    }

    public void b(Runnable runnable) {
        AppMethodBeat.i(16771);
        synchronized (this.L) {
            try {
                this.L.add(runnable);
            } finally {
                AppMethodBeat.o(16771);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(16772);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        r0.run();
        com.tencent.matrix.trace.core.AppMethodBeat.o(16772);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        if (r0 != null) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(java.util.Queue<java.lang.Runnable> r4) {
        /*
            r3 = this;
            r1 = 0
            r2 = 16772(0x4184, float:2.3503E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
            monitor-enter(r4)
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0021 }
            if (r0 == 0) goto L_0x0013
            monitor-exit(r4)     // Catch:{ all -> 0x0021 }
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
        L_0x0012:
            return r0
        L_0x0013:
            java.lang.Object r0 = r4.poll()
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            monitor-exit(r4)
            if (r0 != 0) goto L_0x0027
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            r0 = r1
            goto L_0x0012
        L_0x0021:
            r0 = move-exception
            monitor-exit(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0027:
            r0.run()
            r0 = 1
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.renderer.TXCGLSurfaceView.a(java.util.Queue):boolean");
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        AppMethodBeat.i(16773);
        this.f1015h = ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
        this.f1017j = new int[1];
        this.f1017j[0] = j.b();
        if (this.f1017j[0] <= 0) {
            this.f1017j = null;
            TXCLog.e("TXCGLSurfaceView", "create oes texture error!! at glsurfaceview");
            AppMethodBeat.o(16773);
            return;
        }
        this.f1014g = new SurfaceTexture(this.f1017j[0]);
        g();
        this.f1016i = new h();
        if (!this.f1016i.a()) {
            AppMethodBeat.o(16773);
            return;
        }
        this.f1016i.a(l.f344e, l.a(k.NORMAL, false, false));
        if (this.F != null) {
            this.F.a(this.f1014g);
        }
        AppMethodBeat.o(16773);
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
    }

    public void onDrawFrame(GL10 gl10) {
        long currentTimeMillis;
        boolean z2;
        byte[] bArr;
        boolean z3;
        boolean z4;
        int e2;
        AppMethodBeat.i(16774);
        a(this.L);
        boolean z5 = false;
        boolean z6 = true;
        while (true) {
            currentTimeMillis = System.currentTimeMillis();
            if (this.r == 0 || currentTimeMillis < this.r) {
                this.r = currentTimeMillis;
            }
            if (currentTimeMillis - this.r >= (this.q * 1000) / ((long) this.p)) {
                break;
            }
            a(15);
            z6 = false;
        }
        if (currentTimeMillis - this.r > 1000) {
            this.q = 1;
            z5 = true;
            this.r = System.currentTimeMillis();
        }
        if (this.t) {
            AppMethodBeat.o(16774);
            return;
        }
        byte[] bArr2 = null;
        try {
            synchronized (this) {
                try {
                    if (!this.u) {
                        z3 = true;
                        z2 = z6;
                    } else {
                        z2 = false;
                        if (this.H != null) {
                            byte[] bArr3 = this.H;
                            this.H = null;
                            if (this.f1014g != null) {
                                this.f1014g.updateTexImage();
                                this.f1014g.getTransformMatrix(this.k);
                                bArr = bArr3;
                            } else {
                                bArr = bArr3;
                            }
                        } else {
                            if (this.f1014g != null) {
                                this.f1014g.updateTexImage();
                                this.f1014g.getTransformMatrix(this.k);
                            }
                            bArr = null;
                        }
                        if (!z5) {
                            this.q++;
                        } else {
                            this.q = 1;
                        }
                        this.u = false;
                        z3 = false;
                        bArr2 = bArr;
                    }
                } finally {
                    AppMethodBeat.o(16774);
                }
            }
            if (true == z3) {
                if (true == z2) {
                    a(5);
                }
                return;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (((double) currentTimeMillis2) > ((double) this.I) + 1000.0d) {
                this.J = ((int) ((((double) this.K) * 1000.0d) / ((double) (currentTimeMillis2 - this.I)))) + 1;
                this.I = currentTimeMillis2;
                this.K = 0;
            }
            this.K++;
            if (this.F != null) {
                if (bArr2 != null) {
                    this.F.a(bArr2, this.k);
                } else {
                    this.F.a(this.f1017j[0], this.k);
                }
            }
            synchronized (this) {
                try {
                    z4 = !this.f1033c;
                } finally {
                    AppMethodBeat.o(16774);
                }
            }
            if (z4 && (e2 = e()) != 12288 && System.currentTimeMillis() - this.G > 2000) {
                TXCLog.w("TXCGLSurfaceView", "background capture swapBuffer error : ".concat(String.valueOf(e2)));
                this.G = System.currentTimeMillis();
                Bundle bundle = new Bundle();
                bundle.putInt("EVT_PARAM1", e2);
                bundle.putInt("EVT_ID", 2110);
                bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Failed to render video");
                f.a(this.f1013a, 2110, bundle);
            }
        } catch (Exception e3) {
            TXCLog.e("TXCGLSurfaceView", "onDrawFrame failed", e3);
            AppMethodBeat.o(16774);
        }
    }

    private void a(int i2, int i3) {
        final int i4;
        final int i5;
        AppMethodBeat.i(182254);
        if (this.z) {
            if (!(this.x == 0 || this.y == 0)) {
                boolean z2 = this.x <= this.y;
                int i6 = this.y >= this.x ? this.y : this.x;
                int i7 = this.y >= this.x ? this.x : this.y;
                if (z2) {
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
                final o oVar = this.A;
                if (oVar != null) {
                    new Thread(new Runnable() {
                        /* class com.tencent.liteav.renderer.TXCGLSurfaceView.AnonymousClass5 */

                        public void run() {
                            Bitmap bitmap;
                            AppMethodBeat.i(16823);
                            try {
                                allocate.position(0);
                                createBitmap.copyPixelsFromBuffer(allocate);
                                Matrix matrix = new Matrix();
                                matrix.setScale(1.0f, -1.0f);
                                bitmap = Bitmap.createBitmap(createBitmap, 0, 0, i5, i4, matrix, false);
                            } catch (Exception e2) {
                                TXCLog.w("TXCGLSurfaceView", "takePhoto error ".concat(String.valueOf(e2)));
                                bitmap = null;
                            } catch (Error e3) {
                                TXCLog.w("TXCGLSurfaceView", "takePhoto error ".concat(String.valueOf(e3)));
                                bitmap = null;
                            }
                            oVar.onTakePhotoComplete(bitmap);
                            createBitmap.recycle();
                            AppMethodBeat.o(16823);
                        }
                    }).start();
                }
            }
            this.A = null;
            this.z = false;
        }
        AppMethodBeat.o(182254);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.t = false;
        synchronized (this) {
            this.u = true;
        }
    }

    @Override // com.tencent.liteav.basic.c.m
    public void a(boolean z2) {
        AppMethodBeat.i(16776);
        this.t = true;
        if (z2) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
            this.s = e();
        }
        synchronized (this) {
            try {
                if (this.u) {
                    this.u = false;
                    if (this.f1014g != null) {
                        this.f1014g.updateTexImage();
                    }
                }
            } finally {
                AppMethodBeat.o(16776);
            }
        }
    }

    private void a(long j2) {
        AppMethodBeat.i(16777);
        try {
            Thread.sleep(j2);
            AppMethodBeat.o(16777);
        } catch (Exception e2) {
            AppMethodBeat.o(16777);
        }
    }

    private void g() {
        AppMethodBeat.i(16778);
        if (this.E) {
            if (this.f1014g != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    if (this.w == null) {
                        HandlerThread handlerThread = new HandlerThread("VideoCaptureThread");
                        handlerThread.start();
                        this.w = new Handler(handlerThread.getLooper());
                    }
                    this.f1014g.setOnFrameAvailableListener(this, this.w);
                    AppMethodBeat.o(16778);
                    return;
                }
                this.f1014g.setOnFrameAvailableListener(this);
                AppMethodBeat.o(16778);
                return;
            }
        } else if (this.f1014g != null) {
            this.f1014g.setOnFrameAvailableListener(null);
        }
        AppMethodBeat.o(16778);
    }
}
