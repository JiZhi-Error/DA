package com.tencent.liteav.beauty;

import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.j;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.b.i;
import com.tencent.liteav.beauty.b.j;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.l;
import com.tencent.liteav.beauty.b.m;
import com.tencent.liteav.beauty.b.n;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.b.x;
import com.tencent.liteav.beauty.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* access modifiers changed from: package-private */
public class c extends HandlerThread {
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 0;
    private Context E = null;
    private boolean F = true;
    private boolean G = false;
    private d.e H = new d.e();
    private d.f I = null;
    private int J = -1;
    private int K = -1;
    private int L = -1;
    private int M = -1;
    private int N = -1;
    private int O = -1;
    private float P = 1.0f;
    private int Q = -1;
    private int R = -1;
    private int S = 1;
    private boolean T = false;
    private float[] U = null;
    private boolean V = false;
    private int W = 0;
    private int X = 0;
    private com.tencent.liteav.basic.c.a Y = null;
    private Bitmap Z = null;

    /* renamed from: a  reason: collision with root package name */
    boolean f552a = false;
    private a aA;
    private float aB = 0.5f;
    private int aC = 0;
    private int aD = 0;
    private int aE = 0;
    private int aF = 0;
    private int aG = 0;
    private boolean aH = false;
    private com.tencent.liteav.beauty.a.a.c aI = null;
    private com.tencent.liteav.beauty.a.a.a aJ = null;
    private Bitmap aK = null;
    private List<d.f> aL = null;
    private long aM = 0;
    private int aN = 0;
    private final int aO = 100;
    private final float aP = 1000.0f;
    private byte[] aQ = null;
    private int[] aR = null;
    private boolean aS = false;
    private byte[] aT = null;
    private int aU = -1;
    private int aV = 0;
    private int aW = 1;
    private int aX = this.aU;
    private e aY = null;
    private WeakReference<b> aZ = new WeakReference<>(null);
    private k aa = null;
    private o ab = null;
    private com.tencent.liteav.beauty.b.b ac = null;
    private com.tencent.liteav.beauty.b.a.a ad = null;
    private com.tencent.liteav.beauty.b.b.a ae = null;
    private com.tencent.liteav.beauty.b.c af = null;
    private com.tencent.liteav.beauty.b.c.a ag = null;
    private Bitmap ah;
    private Bitmap ai;
    private float aj;
    private float ak;
    private float al;
    private m am;
    private n an = null;
    private x ao = null;
    private j ap = null;
    private i aq = null;
    private h ar = null;
    private l as = null;
    private com.tencent.liteav.basic.c.i at = null;
    private h au = null;
    private final Queue<Runnable> av = new LinkedList();
    private boolean aw;
    private Object ax = new Object();
    private Object ay = new Object();
    private Handler az;

    /* renamed from: b  reason: collision with root package name */
    protected int[] f553b = null;
    private j.a ba = new j.a() {
        /* class com.tencent.liteav.beauty.c.AnonymousClass12 */
    };

    /* renamed from: c  reason: collision with root package name */
    protected int[] f554c = null;

    /* renamed from: d  reason: collision with root package name */
    com.tencent.liteav.beauty.b.a f555d = new com.tencent.liteav.beauty.b.a();

    /* renamed from: e  reason: collision with root package name */
    com.tencent.liteav.beauty.b.a f556e = new com.tencent.liteav.beauty.b.a();

    /* renamed from: f  reason: collision with root package name */
    com.tencent.liteav.beauty.b.a f557f = new com.tencent.liteav.beauty.b.a();

    /* renamed from: g  reason: collision with root package name */
    private int f558g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f559h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f560i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f561j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int o = 0;
    private int p = 0;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x = 0;
    private int y = 0;
    private int z = 0;

    static /* synthetic */ void a(c cVar, int i2, int i3, float f2, Bitmap bitmap, float f3, Bitmap bitmap2, float f4) {
        AppMethodBeat.i(221587);
        cVar.a(i2, i3, f2, bitmap, f3, bitmap2, f4);
        AppMethodBeat.o(221587);
    }

    static /* synthetic */ void a(c cVar, int i2, int i3, int i4) {
        AppMethodBeat.i(221586);
        cVar.a(i2, i3, i4);
        AppMethodBeat.o(221586);
    }

    static /* synthetic */ void a(c cVar, byte[] bArr) {
        AppMethodBeat.i(221590);
        cVar.b(bArr);
        AppMethodBeat.o(221590);
    }

    static /* synthetic */ boolean a(c cVar, d.b bVar) {
        AppMethodBeat.i(221588);
        boolean c2 = cVar.c(bVar);
        AppMethodBeat.o(221588);
        return c2;
    }

    static /* synthetic */ int b(c cVar, int i2) {
        AppMethodBeat.i(221591);
        int A2 = cVar.A(i2);
        AppMethodBeat.o(221591);
        return A2;
    }

    static /* synthetic */ boolean b(c cVar, d.b bVar) {
        AppMethodBeat.i(221592);
        boolean d2 = cVar.d(bVar);
        AppMethodBeat.o(221592);
        return d2;
    }

    static /* synthetic */ void p(c cVar) {
        AppMethodBeat.i(221589);
        cVar.b();
        AppMethodBeat.o(221589);
    }

    c(Context context, boolean z2) {
        super("TXCFilterDrawer");
        AppMethodBeat.i(15215);
        this.E = context;
        this.az = new Handler(this.E.getMainLooper());
        this.aw = z2;
        AppMethodBeat.o(15215);
    }

    public synchronized boolean a(d.b bVar) {
        boolean z2;
        AppMethodBeat.i(221564);
        z2 = true;
        if (!bVar.f619j) {
            if (this.aA == null) {
                start();
                this.aA = new a(getLooper(), this.E);
            }
            this.aA.obtainMessage(0, bVar).sendToTarget();
            this.aA.b();
        } else {
            z2 = c(bVar);
        }
        AppMethodBeat.o(221564);
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int r8, int r9, long r10) {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.beauty.c.a(int, int, long):int");
    }

    public int a(byte[] bArr, int i2) {
        int A2;
        AppMethodBeat.i(221566);
        a(bArr);
        if (!this.aw) {
            byte[] bArr2 = (byte[]) bArr.clone();
            this.aA.obtainMessage(2, bArr2).sendToTarget();
            if (!this.aS) {
                TXCLog.i("TXCFilterDrawer", "First Frame, clear queue");
                NativeLoad.getInstance();
                NativeLoad.nativeClearQueue();
            }
            this.aA.obtainMessage(3, i2, 0).sendToTarget();
            a(bArr2, this.aS);
            this.aS = true;
            A2 = -1;
        } else {
            b(bArr);
            A2 = A(i2);
        }
        AppMethodBeat.o(221566);
        return A2;
    }

    public void a(final float f2) {
        AppMethodBeat.i(15255);
        this.aB = f2;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(221466);
                if (c.this.am != null) {
                    c.this.am.a(f2);
                }
                AppMethodBeat.o(221466);
            }
        });
        AppMethodBeat.o(15255);
    }

    public void a(final float[] fArr) {
        AppMethodBeat.i(15216);
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass7 */

            public void run() {
                AppMethodBeat.i(221595);
                c.this.U = fArr;
                AppMethodBeat.o(221595);
            }
        });
        AppMethodBeat.o(15216);
    }

    public void a(final boolean z2) {
        AppMethodBeat.i(15217);
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass9 */

            public void run() {
                AppMethodBeat.i(221471);
                c.this.V = z2;
                AppMethodBeat.o(221471);
            }
        });
        AppMethodBeat.o(15217);
    }

    public void a(int i2) {
    }

    private void a(com.tencent.liteav.basic.c.a aVar, int i2, int i3, int i4, int i5, boolean z2, int i6, int i7) {
        int i8;
        AppMethodBeat.i(221567);
        if (this.as == null) {
            TXCLog.i("TXCFilterDrawer", "Create CropFilter");
            if (4 == i7) {
                this.as = new l("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", true);
            } else {
                this.as = new l();
            }
            if (true == this.as.a()) {
                this.as.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mInputCropFilter init failed!");
            }
        }
        this.as.a(i4, i5);
        float[] a2 = this.as.a(this.J, this.K, null, aVar, i7);
        int i9 = (720 - i6) % v2helper.VOIP_ENC_HEIGHT_LV1;
        if (i9 == 90 || i9 == 270) {
            i8 = i5;
        } else {
            i8 = i4;
        }
        if (i9 == 90 || i9 == 270) {
            i5 = i4;
        }
        this.as.a(i2, i3, i9, a2, ((float) i8) / ((float) i5), z2, false);
        AppMethodBeat.o(221567);
    }

    private void a(int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(221568);
        synchronized (this.ay) {
            try {
                int i7 = (i6 + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
                TXCLog.i("TXCFilterDrawer", "real outputAngle ".concat(String.valueOf(i7)));
                if (this.ar == null) {
                    if (i2 == i4 && i3 == i5 && i7 == 0) {
                        TXCLog.i("TXCFilterDrawer", "Don't need change output Image, don't create out filter!");
                        return;
                    }
                    this.ar = new h();
                    if (true == this.ar.a()) {
                        this.ar.a(true);
                    } else {
                        TXCLog.e("TXCFilterDrawer", "mOutputZoomFilter init failed!");
                    }
                }
                this.ar.a(i4, i5);
                this.ar.a((720 - i7) % v2helper.VOIP_ENC_HEIGHT_LV1, (FloatBuffer) null);
                AppMethodBeat.o(221568);
            } finally {
                AppMethodBeat.o(221568);
            }
        }
    }

    public void a(final Bitmap bitmap, final float f2, final float f3, final float f4) {
        AppMethodBeat.i(15221);
        if (this.I == null) {
            this.I = new d.f();
        }
        if (TXCCommonUtil.equals(this.I.f636a, bitmap) && f2 == this.I.f637b && f3 == this.I.f638c && f4 == this.I.f639d && this.ao != null) {
            AppMethodBeat.o(15221);
            return;
        }
        this.I.f636a = bitmap;
        this.I.f637b = f2;
        this.I.f638c = f3;
        this.I.f639d = f4;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass10 */

            public void run() {
                AppMethodBeat.i(221593);
                if (bitmap != null) {
                    a.a().g();
                }
                if (bitmap == null) {
                    if (c.this.ao != null) {
                        c.this.ao.d();
                        c.this.ao = null;
                    }
                    AppMethodBeat.o(221593);
                    return;
                }
                if (c.this.ao == null) {
                    if (c.this.L <= 0 || c.this.M <= 0) {
                        TXCLog.e("TXCFilterDrawer", "output Width and Height is error!");
                        AppMethodBeat.o(221593);
                        return;
                    }
                    c.this.ao = new x();
                    c.this.ao.a(true);
                    if (!c.this.ao.a()) {
                        TXCLog.e("TXCFilterDrawer", "mWatermarkFilter.init failed!");
                        c.this.ao.d();
                        c.this.ao = null;
                        AppMethodBeat.o(221593);
                        return;
                    }
                    c.this.ao.a(c.this.L, c.this.M);
                }
                c.this.ao.c(true);
                c.this.ao.a(bitmap, f2, f3, f4);
                AppMethodBeat.o(221593);
            }
        });
        AppMethodBeat.o(15221);
    }

    /* access modifiers changed from: package-private */
    public void a(e eVar) {
        AppMethodBeat.i(15222);
        TXCLog.i("TXCFilterDrawer", "set listener");
        this.aY = eVar;
        AppMethodBeat.o(15222);
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        AppMethodBeat.i(221569);
        TXCLog.i("TXCFilterDrawer", "set notify");
        this.aZ = new WeakReference<>(bVar);
        if (this.ap != null) {
            this.ap.a(this.aZ.get());
        }
        AppMethodBeat.o(221569);
    }

    private int a(int i2, long j2) {
        long j3;
        AppMethodBeat.i(221570);
        if (this.X == 0) {
            if (this.aY != null) {
                if (j2 == 0) {
                    j3 = TXCTimeUtil.generatePtsMS();
                } else {
                    j3 = j2;
                }
                this.aY.a(i2, this.Q, this.R, j3);
            }
            AppMethodBeat.o(221570);
            return i2;
        } else if (1 == this.X || 3 == this.X || 2 == this.X) {
            GLES20.glViewport(0, 0, this.Q, this.R);
            if (this.ab == null) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter is null!");
                AppMethodBeat.o(221570);
                return i2;
            }
            GLES20.glBindFramebuffer(36160, this.f553b[0]);
            this.ab.a(i2);
            if (2 == this.X) {
                a(this.Q, this.R);
            } else {
                a(this.Q, (this.R * 3) / 8);
            }
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.o(221570);
            return i2;
        } else {
            TXCLog.e("TXCFilterDrawer", "Don't support format!");
            AppMethodBeat.o(221570);
            return -1;
        }
    }

    private int a(int i2, int i3) {
        AppMethodBeat.i(221571);
        if (true == this.aw) {
            if (this.aY != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i2, i3, this.aQ);
                this.aY.a(this.aQ, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
            } else if (this.aT != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlReadPixs(i2, i3, this.aT);
            }
        } else if (3 == com.tencent.liteav.basic.c.j.a()) {
            if (0 == this.aM) {
                this.aM = TXCTimeUtil.getTimeTick();
            }
            int i4 = this.aN + 1;
            this.aN = i4;
            if (i4 >= 100) {
                TXCLog.i("TXCFilterDrawer", "Real fps ".concat(String.valueOf(100.0f / (((float) (TXCTimeUtil.getTimeTick() - this.aM)) / 1000.0f))));
                this.aN = 0;
                this.aM = TXCTimeUtil.getTimeTick();
            }
            GLES30.glPixelStorei(3333, 1);
            if (Build.VERSION.SDK_INT >= 18) {
                GLES30.glReadBuffer(TXLiteAVCode.EVT_LOCAL_RECORD_RESULT);
            }
            GLES30.glBindBuffer(35051, this.aR[0]);
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixs(i2, i3, null);
            ByteBuffer byteBuffer = null;
            if (Build.VERSION.SDK_INT < 18 || (byteBuffer = (ByteBuffer) GLES30.glMapBufferRange(35051, 0, i2 * i3 * 4, 1)) != null) {
                NativeLoad.getInstance();
                NativeLoad.nativeGlMapBufferToQueue(i2, i3, byteBuffer);
                if (Build.VERSION.SDK_INT >= 18) {
                    GLES30.glUnmapBuffer(35051);
                }
                GLES30.glBindBuffer(35051, 0);
            } else {
                TXCLog.e("TXCFilterDrawer", "glMapBufferRange is null");
                AppMethodBeat.o(221571);
                return -1;
            }
        } else {
            NativeLoad.getInstance();
            NativeLoad.nativeGlReadPixsToQueue(i2, i3);
        }
        AppMethodBeat.o(221571);
        return 0;
    }

    public void b(final int i2) {
        AppMethodBeat.i(15226);
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass11 */

            public void run() {
                AppMethodBeat.i(221563);
                c.this.X = i2;
                AppMethodBeat.o(221563);
            }
        });
        AppMethodBeat.o(15226);
    }

    private void a(byte[] bArr, boolean z2) {
        AppMethodBeat.i(221572);
        if (z2) {
            int i2 = (this.R * 3) / 8;
            if (2 == this.X) {
                i2 = this.R;
            }
            if (this.aY != null) {
                NativeLoad.getInstance();
                if (true == NativeLoad.nativeGlReadPixsFromQueue(this.Q, i2, this.aQ)) {
                    this.aY.a(this.aQ, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
                    AppMethodBeat.o(221572);
                    return;
                }
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
                this.aY.a(bArr, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
                AppMethodBeat.o(221572);
                return;
            }
            NativeLoad.getInstance();
            if (!NativeLoad.nativeGlReadPixsFromQueue(this.Q, i2, this.aT)) {
                TXCLog.d("TXCFilterDrawer", "nativeGlReadPixsFromQueue Failed");
            }
            AppMethodBeat.o(221572);
        } else if (this.aY != null) {
            this.aY.a(bArr, this.Q, this.R, this.X, TXCTimeUtil.generatePtsMS());
            AppMethodBeat.o(221572);
        } else {
            TXCLog.i("TXCFilterDrawer", "First Frame, don't process!");
            AppMethodBeat.o(221572);
        }
    }

    private int A(int i2) {
        AppMethodBeat.i(221573);
        GLES20.glViewport(0, 0, this.J, this.K);
        int a2 = a(this.aa.q(), i2, 0L);
        AppMethodBeat.o(221573);
        return a2;
    }

    public void a(byte[] bArr) {
        this.aT = bArr;
    }

    private void b(byte[] bArr) {
        AppMethodBeat.i(221574);
        if (this.aa == null) {
            TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter is null!");
            AppMethodBeat.o(221574);
            return;
        }
        this.aa.a(bArr);
        AppMethodBeat.o(221574);
    }

    public void a() {
        AppMethodBeat.i(221575);
        if (this.aw) {
            b();
        } else if (this.aA != null) {
            this.aA.obtainMessage(1).sendToTarget();
            try {
                this.f555d.b();
                AppMethodBeat.o(221575);
                return;
            } catch (InterruptedException e2) {
                AppMethodBeat.o(221575);
                return;
            }
        }
        AppMethodBeat.o(221575);
    }

    private void b() {
        AppMethodBeat.i(15227);
        TXCLog.i("TXCFilterDrawer", "come into releaseInternal");
        this.aS = false;
        if (this.aa != null) {
            this.aa.d();
            this.aa = null;
        }
        if (this.ab != null) {
            this.ab.d();
            this.ab = null;
        }
        c();
        if (this.am != null) {
            this.am.d();
            this.am = null;
        }
        if (this.an != null) {
            this.an.a();
            this.an = null;
        }
        if (this.at != null) {
            this.at.d();
            this.at = null;
        }
        if (this.as != null) {
            this.as.d();
            this.as = null;
        }
        if (this.ar != null) {
            this.ar.d();
            this.ar = null;
        }
        if (this.ao != null) {
            this.ao.d();
            this.ao = null;
        }
        if (this.ap != null) {
            this.ap.a();
            this.ap = null;
        }
        if (this.aq != null) {
            this.aq.d();
            this.aq = null;
        }
        if (this.au != null) {
            this.au.d();
            this.au = null;
        }
        if (this.f553b != null) {
            GLES20.glDeleteFramebuffers(1, this.f553b, 0);
            this.f553b = null;
        }
        if (this.f554c != null) {
            GLES20.glDeleteTextures(1, this.f554c, 0);
            this.f554c = null;
        }
        TXCLog.i("TXCFilterDrawer", "come out releaseInternal");
        AppMethodBeat.o(15227);
    }

    private boolean c(d.b bVar) {
        AppMethodBeat.i(221576);
        TXCLog.i("TXCFilterDrawer", "come into initInternal");
        b();
        this.aw = bVar.f619j;
        this.J = bVar.f613d;
        this.K = bVar.f614e;
        this.Y = bVar.m;
        int i2 = bVar.f616g;
        int i3 = bVar.f615f;
        int i4 = bVar.f617h;
        this.T = bVar.f618i;
        this.Q = bVar.f611b;
        this.R = bVar.f612c;
        int i5 = bVar.f610a;
        this.L = bVar.f616g;
        this.M = bVar.f615f;
        if (i4 == 90 || i4 == 270) {
            this.L = bVar.f615f;
            this.M = bVar.f616g;
        }
        this.X = bVar.l;
        this.W = bVar.k;
        this.aQ = new byte[(this.Q * this.R * 4)];
        TXCLog.i("TXCFilterDrawer", "processWidth mPituScaleRatio is %f, process size: %d x %d", Float.valueOf(this.P), Integer.valueOf(this.L), Integer.valueOf(this.M));
        if (this.P != 1.0f) {
            int i6 = this.L < this.M ? this.L : this.M;
            if (i6 > 368) {
                this.P = 432.0f / ((float) i6);
            }
            if (this.P > 1.0f) {
                this.P = 1.0f;
            }
        }
        this.N = (int) (((float) this.L) * this.P);
        this.O = (int) (((float) this.M) * this.P);
        a(this.N, this.O, this.aC);
        if (!(this.I == null || this.I.f636a == null || this.ao != null)) {
            TXCLog.i("TXCFilterDrawer", "reset water mark!");
            a(this.I.f636a, this.I.f637b, this.I.f638c, this.I.f639d);
        }
        if (!(this.ah == null && this.ai == null) && this.am == null) {
            a(this.N, this.O, this.aj, this.ah, this.ak, this.ai, this.al);
        }
        a(this.Y, i2, i3, this.N, this.O, this.T, i4, this.W);
        a(this.L, this.M, this.Q, this.R, i5);
        if (this.f553b == null) {
            this.f553b = new int[1];
        } else {
            GLES20.glDeleteFramebuffers(1, this.f553b, 0);
        }
        if (this.f554c == null) {
            this.f554c = new int[1];
        } else {
            GLES20.glDeleteTextures(1, this.f554c, 0);
        }
        a(this.f553b, this.f554c, this.Q, this.R);
        if (3 == com.tencent.liteav.basic.c.j.a()) {
            if (this.aR == null) {
                this.aR = new int[1];
            } else {
                TXCLog.i("TXCFilterDrawer", "m_pbo0 is not null, delete Buffers, and recreate");
                GLES30.glDeleteBuffers(1, this.aR, 0);
            }
            TXCLog.i("TXCFilterDrawer", "opengl es 3.0, use PBO");
            com.tencent.liteav.basic.c.j.a(i2, i3, this.aR);
        }
        TXCLog.i("TXCFilterDrawer", "come out initInternal");
        AppMethodBeat.o(221576);
        return true;
    }

    public boolean b(d.b bVar) {
        AppMethodBeat.i(221577);
        if (this.aw) {
            d(bVar);
        } else if (this.aA == null) {
            TXCLog.e("TXCFilterDrawer", "mThreadHandler is null!");
            AppMethodBeat.o(221577);
            return false;
        } else {
            this.aA.obtainMessage(5, 0, 0, bVar).sendToTarget();
        }
        AppMethodBeat.o(221577);
        return true;
    }

    private void a(int[] iArr, int[] iArr2, int i2, int i3) {
        AppMethodBeat.i(221578);
        GLES20.glGenFramebuffers(1, iArr, 0);
        iArr2[0] = com.tencent.liteav.basic.c.j.a(i2, i3, (int) NativeBitmapStruct.GLFormat.GL_RGBA, (int) NativeBitmapStruct.GLFormat.GL_RGBA, iArr2);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr2[0], 0);
        GLES20.glBindFramebuffer(36160, 0);
        AppMethodBeat.o(221578);
    }

    private boolean d(d.b bVar) {
        AppMethodBeat.i(221579);
        if ((1 == bVar.k || 3 == bVar.k || 2 == bVar.k) && this.aa == null) {
            this.aa = new k(bVar.k);
            this.aa.a(true);
            if (!this.aa.a()) {
                TXCLog.e("TXCFilterDrawer", "mI4202RGBAFilter init failed!!, break init");
                AppMethodBeat.o(221579);
                return false;
            }
            this.aa.a(bVar.f613d, bVar.f614e);
        }
        if ((1 == bVar.l || 3 == bVar.l || 2 == bVar.l) && this.ab == null) {
            this.ab = new o(bVar.l);
            if (!this.ab.a()) {
                TXCLog.e("TXCFilterDrawer", "mRGBA2I420Filter init failed!!, break init");
                AppMethodBeat.o(221579);
                return false;
            }
            this.ab.a(bVar.f611b, bVar.f612c);
        }
        AppMethodBeat.o(221579);
        return true;
    }

    public void c(final int i2) {
        AppMethodBeat.i(15228);
        this.aD = i2;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass13 */

            public void run() {
                AppMethodBeat.i(221512);
                if (i2 > 0) {
                    a.a().b();
                }
                if (c.this.ac != null && i2 >= 0) {
                    c.this.ac.c(i2);
                }
                AppMethodBeat.o(221512);
            }
        });
        AppMethodBeat.o(15228);
    }

    public void d(final int i2) {
        AppMethodBeat.i(15229);
        if (this.aC == i2 || i2 > 3 || i2 < 0) {
            AppMethodBeat.o(15229);
            return;
        }
        this.aC = i2;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(221511);
                c.a(c.this, c.this.N, c.this.O, i2);
                AppMethodBeat.o(221511);
            }
        });
        AppMethodBeat.o(15229);
    }

    public void e(final int i2) {
        AppMethodBeat.i(15230);
        this.aE = i2;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(221513);
                if (i2 > 0) {
                    a.a().c();
                }
                if (c.this.ac != null && i2 >= 0) {
                    c.this.ac.d(i2);
                }
                AppMethodBeat.o(221513);
            }
        });
        AppMethodBeat.o(15230);
    }

    public void f(final int i2) {
        AppMethodBeat.i(15231);
        this.aF = i2;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass4 */

            public void run() {
                AppMethodBeat.i(221596);
                if (i2 > 0) {
                    a.a().f();
                }
                if (c.this.ac != null && i2 >= 0) {
                    c.this.ac.f(i2);
                }
                AppMethodBeat.o(221596);
            }
        });
        AppMethodBeat.o(15231);
    }

    public void g(final int i2) {
        AppMethodBeat.i(15232);
        this.aG = i2;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass5 */

            public void run() {
                AppMethodBeat.i(221507);
                if (i2 > 0) {
                    a.a().d();
                }
                if (c.this.ac != null && i2 >= 0) {
                    c.this.ac.e(i2);
                }
                AppMethodBeat.o(221507);
            }
        });
        AppMethodBeat.o(15232);
    }

    public void a(String str) {
        AppMethodBeat.i(15233);
        AppMethodBeat.o(15233);
    }

    public void b(boolean z2) {
    }

    public void a(String str, boolean z2) {
    }

    public void a(Bitmap bitmap) {
        AppMethodBeat.i(15256);
        a(1.0f, bitmap, this.aB, (Bitmap) null, 0.0f);
        AppMethodBeat.o(15256);
    }

    public void a(final float f2, final Bitmap bitmap, final float f3, final Bitmap bitmap2, final float f4) {
        AppMethodBeat.i(221580);
        if (this.ah == bitmap && this.ai == bitmap2) {
            if (!(this.am == null || (this.aj == f2 && this.ak == f3 && this.al == f4))) {
                this.aj = f2;
                this.ak = f3;
                this.al = f4;
                a(new Runnable() {
                    /* class com.tencent.liteav.beauty.c.AnonymousClass8 */

                    public void run() {
                        AppMethodBeat.i(221467);
                        c.this.am.a(f2, f3, f4);
                        AppMethodBeat.o(221467);
                    }
                });
            }
            AppMethodBeat.o(221580);
            return;
        }
        this.ah = bitmap;
        this.ai = bitmap2;
        this.aj = f2;
        this.ak = f3;
        this.al = f4;
        a(new Runnable() {
            /* class com.tencent.liteav.beauty.c.AnonymousClass6 */

            public void run() {
                AppMethodBeat.i(221594);
                if (c.this.am != null) {
                    a.a().e();
                }
                if (c.this.ah == null && c.this.ai == null) {
                    if (c.this.am != null) {
                        c.this.am.d();
                        c.this.am = null;
                        AppMethodBeat.o(221594);
                        return;
                    }
                } else if (c.this.am == null) {
                    c.a(c.this, c.this.N, c.this.O, c.this.aj, c.this.ah, c.this.ak, c.this.ai, c.this.al);
                    AppMethodBeat.o(221594);
                    return;
                } else {
                    c.this.am.a(f2, bitmap, f3, bitmap2, f4);
                }
                AppMethodBeat.o(221594);
            }
        });
        AppMethodBeat.o(221580);
    }

    public void h(int i2) {
        AppMethodBeat.i(15236);
        AppMethodBeat.o(15236);
    }

    public void i(int i2) {
        AppMethodBeat.i(15237);
        AppMethodBeat.o(15237);
    }

    public void j(int i2) {
        AppMethodBeat.i(15238);
        AppMethodBeat.o(15238);
    }

    public void k(int i2) {
        AppMethodBeat.i(15239);
        AppMethodBeat.o(15239);
    }

    public void l(int i2) {
        AppMethodBeat.i(15240);
        AppMethodBeat.o(15240);
    }

    public void m(int i2) {
        AppMethodBeat.i(15241);
        AppMethodBeat.o(15241);
    }

    public void n(int i2) {
        AppMethodBeat.i(15242);
        AppMethodBeat.o(15242);
    }

    public void o(int i2) {
        AppMethodBeat.i(15243);
        AppMethodBeat.o(15243);
    }

    public void p(int i2) {
        AppMethodBeat.i(15244);
        AppMethodBeat.o(15244);
    }

    public void q(int i2) {
        AppMethodBeat.i(15245);
        AppMethodBeat.o(15245);
    }

    public void r(int i2) {
        AppMethodBeat.i(15246);
        AppMethodBeat.o(15246);
    }

    public void s(int i2) {
        AppMethodBeat.i(15247);
        AppMethodBeat.o(15247);
    }

    public void t(int i2) {
        AppMethodBeat.i(15248);
        AppMethodBeat.o(15248);
    }

    public void u(int i2) {
        AppMethodBeat.i(15249);
        AppMethodBeat.o(15249);
    }

    public void v(int i2) {
        AppMethodBeat.i(15250);
        AppMethodBeat.o(15250);
    }

    public void w(int i2) {
        AppMethodBeat.i(15251);
        AppMethodBeat.o(15251);
    }

    public void x(int i2) {
        AppMethodBeat.i(15252);
        AppMethodBeat.o(15252);
    }

    public void y(int i2) {
        AppMethodBeat.i(15253);
        AppMethodBeat.o(15253);
    }

    public void z(int i2) {
        AppMethodBeat.i(15254);
        AppMethodBeat.o(15254);
    }

    private void a(int i2, int i3, int i4) {
        AppMethodBeat.i(221581);
        TXCLog.i("TXCFilterDrawer", "create Beauty Filter!");
        if (i4 == 0) {
            if (this.ad == null) {
                this.ad = new com.tencent.liteav.beauty.b.a.a();
            }
            this.ac = this.ad;
        } else if (1 == i4) {
            if (this.ae == null) {
                this.ae = new com.tencent.liteav.beauty.b.b.a();
            }
            this.ac = this.ae;
        } else if (2 == i4) {
            if (this.ag == null) {
                this.ag = new com.tencent.liteav.beauty.b.c.a();
            }
            this.ac = this.ag;
        } else if (3 == i4) {
            if (this.af == null) {
                this.af = new com.tencent.liteav.beauty.b.c();
            }
            this.ac = this.af;
        }
        if (this.ac == null) {
            TXCLog.e("TXCFilterDrawer", "mBeautyFilter set error!");
            AppMethodBeat.o(221581);
            return;
        }
        this.ac.a(true);
        if (true == this.ac.c(i2, i3)) {
            if (this.aD > 0) {
                this.ac.c(this.aD);
            }
            if (this.aE > 0) {
                this.ac.d(this.aE);
            }
            if (this.aG > 0) {
                this.ac.e(this.aG);
            }
            if (this.aF > 0) {
                this.ac.f(this.aF);
                AppMethodBeat.o(221581);
                return;
            }
        } else {
            TXCLog.e("TXCFilterDrawer", "mBeautyFilter init failed!");
        }
        AppMethodBeat.o(221581);
    }

    private void c() {
        AppMethodBeat.i(15214);
        if (this.ad != null) {
            this.ad.d();
            this.ad = null;
        }
        if (this.ae != null) {
            this.ae.d();
            this.ae = null;
        }
        if (this.af != null) {
            this.af.d();
            this.af = null;
        }
        if (this.ag != null) {
            this.ag.d();
            this.ag = null;
        }
        this.ac = null;
        AppMethodBeat.o(15214);
    }

    private void a(int i2, int i3, float f2, Bitmap bitmap, float f3, Bitmap bitmap2, float f4) {
        AppMethodBeat.i(221582);
        if (this.am == null) {
            TXCLog.i("TXCFilterDrawer", "createComLooKupFilter");
            this.am = new m(f2, bitmap, f3, bitmap2, f4);
            if (true == this.am.a()) {
                this.am.a(true);
                this.am.a(i2, i3);
                AppMethodBeat.o(221582);
                return;
            }
            TXCLog.e("TXCFilterDrawer", "mLookupFilterGroup init failed!");
        }
        AppMethodBeat.o(221582);
    }

    private void b(int i2, int i3) {
        AppMethodBeat.i(221583);
        if (this.au == null) {
            TXCLog.i("TXCFilterDrawer", "createRecoverScaleFilter");
            this.au = new h();
            if (true == this.au.a()) {
                this.au.a(true);
            } else {
                TXCLog.e("TXCFilterDrawer", "mRecoverScaleFilter init failed!");
            }
        }
        if (this.au != null) {
            this.au.a(i2, i3);
        }
        AppMethodBeat.o(221583);
    }

    private void a(Runnable runnable) {
        AppMethodBeat.i(221584);
        synchronized (this.av) {
            try {
                this.av.add(runnable);
            } finally {
                AppMethodBeat.o(221584);
            }
        }
    }

    private void a(Queue<Runnable> queue) {
        AppMethodBeat.i(221585);
        while (true) {
            Runnable runnable = null;
            synchronized (queue) {
                try {
                    if (!queue.isEmpty()) {
                        runnable = queue.poll();
                    }
                } finally {
                    AppMethodBeat.o(221585);
                }
            }
            if (runnable != null) {
                runnable.run();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class a extends Handler {

        /* renamed from: b  reason: collision with root package name */
        private String f597b = "EGLDrawThreadHandler";

        a(Looper looper, Context context) {
            super(looper);
        }

        private void a(Object obj) {
            AppMethodBeat.i(221462);
            TXCLog.i(this.f597b, "come into InitEGL");
            d.b bVar = (d.b) obj;
            a();
            c.this.aJ = new com.tencent.liteav.beauty.a.a.a();
            c.this.aI = new com.tencent.liteav.beauty.a.a.c(c.this.aJ, bVar.f616g, bVar.f615f, false);
            c.this.aI.b();
            if (!c.a(c.this, bVar)) {
                TXCLog.e(this.f597b, "initInternal failed!");
                AppMethodBeat.o(221462);
                return;
            }
            TXCLog.i(this.f597b, "come out InitEGL");
            AppMethodBeat.o(221462);
        }

        public void a() {
            AppMethodBeat.i(221463);
            TXCLog.i(this.f597b, "come into releaseEGL");
            if (c.this.aR != null && c.this.aR[0] > 0) {
                GLES20.glDeleteBuffers(1, c.this.aR, 0);
                c.this.aR = null;
            }
            c.p(c.this);
            if (c.this.aI != null) {
                c.this.aI.c();
                c.this.aI = null;
            }
            if (c.this.aJ != null) {
                c.this.aJ.a();
                c.this.aJ = null;
            }
            c.this.aH = false;
            NativeLoad.getInstance();
            NativeLoad.nativeDeleteYuv2Yuv();
            TXCLog.i(this.f597b, "come out releaseEGL");
            AppMethodBeat.o(221463);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public void handleMessage(Message message) {
            boolean z;
            AppMethodBeat.i(221464);
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    a(message.obj);
                    c.this.aH = true;
                    z = true;
                    break;
                case 1:
                    a();
                    c.this.f555d.a();
                    z = false;
                    break;
                case 2:
                    c.a(c.this, (byte[]) message.obj);
                    z = false;
                    break;
                case 3:
                    c.b(c.this, message.arg1);
                    z = true;
                    break;
                case 4:
                    c.this.aB = (float) (((double) message.arg1) / 100.0d);
                    if (c.this.am != null) {
                        c.this.am.a(c.this.aB);
                        z = false;
                        break;
                    }
                    z = false;
                    break;
                case 5:
                    c.b(c.this, (d.b) message.obj);
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            synchronized (this) {
                if (true == z) {
                    try {
                        notify();
                    } catch (Throwable th) {
                        AppMethodBeat.o(221464);
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(221464);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            AppMethodBeat.i(221465);
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e2) {
                }
                try {
                } catch (Throwable th) {
                    AppMethodBeat.o(221465);
                    throw th;
                }
            }
            AppMethodBeat.o(221465);
        }
    }
}
