package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.liteav.b;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.c.o;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.d;
import com.tencent.liteav.beauty.f;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Locale;

public class d extends com.tencent.liteav.basic.module.a implements b.AbstractC0155b, com.tencent.liteav.basic.b.b, f, l, e {
    private int A = 0;
    private int B = 0;
    private com.tencent.liteav.basic.c.e C = null;
    private com.tencent.liteav.basic.structs.b D;
    private int E = 0;
    private boolean F = false;
    private boolean G = false;
    private volatile boolean H = false;
    private long I = 0;
    private long J = 0;
    private int K = 2;
    private WeakReference<o> L;
    private boolean M = false;
    private WeakReference<a> N = null;
    private h O = null;
    private h P;
    private h Q;
    private k R;
    private byte[] S;
    private boolean T = false;
    private boolean U = false;
    private boolean V = false;
    private final com.tencent.liteav.beauty.b W;
    private WeakReference<com.tencent.liteav.basic.b.b> X;
    private WeakReference<m> Y;
    private int Z = 0;

    /* renamed from: a  reason: collision with root package name */
    b f678a;
    private int aa = 0;

    /* renamed from: b  reason: collision with root package name */
    b f679b;

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.liteav.basic.util.e f680c = new com.tencent.liteav.basic.util.e(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private k f681d = null;

    /* renamed from: e  reason: collision with root package name */
    private com.tencent.liteav.beauty.d f682e = null;

    /* renamed from: f  reason: collision with root package name */
    private boolean f683f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f684g = false;

    /* renamed from: h  reason: collision with root package name */
    private TXSVideoEncoderParam f685h = null;

    /* renamed from: i  reason: collision with root package name */
    private com.tencent.liteav.videoencoder.b f686i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f687j = 15;
    private boolean k = false;
    private TXSVideoEncoderParam l = null;
    private com.tencent.liteav.videoencoder.b m = null;
    private final Object n = new Object();
    private Context o = null;
    private g p = null;
    private int q = 0;
    private int r = 0;
    private int s = 0;
    private boolean t = false;
    private int u = 0;
    private int v = 0;
    private boolean w = false;
    private TXCloudVideoView x = null;
    private final Object y = new Object();
    private Surface z = null;

    public interface a {
        void onBackgroudPushStop();

        void onEncVideo(TXSNALPacket tXSNALPacket);

        void onEncVideoFormat(MediaFormat mediaFormat);
    }

    static /* synthetic */ void a(d dVar, int i2, int i3) {
        AppMethodBeat.i(221698);
        dVar.c(i2, i3);
        AppMethodBeat.o(221698);
    }

    static /* synthetic */ void a(d dVar, int i2, int i3, int i4, Object obj, int i5, boolean z2) {
        AppMethodBeat.i(221700);
        dVar.a(i2, i3, i4, obj, i5, z2);
        AppMethodBeat.o(221700);
    }

    static /* synthetic */ void a(d dVar, com.tencent.liteav.basic.structs.b bVar, boolean z2) {
        AppMethodBeat.i(221699);
        dVar.a(bVar, z2);
        AppMethodBeat.o(221699);
    }

    static /* synthetic */ void a(d dVar, Object obj, int i2, boolean z2) {
        AppMethodBeat.i(221701);
        dVar.a(obj, i2, z2);
        AppMethodBeat.o(221701);
    }

    static /* synthetic */ void g(d dVar) {
        AppMethodBeat.i(259856);
        dVar.z();
        AppMethodBeat.o(259856);
    }

    static /* synthetic */ void i(d dVar) {
        AppMethodBeat.i(259857);
        dVar.y();
        AppMethodBeat.o(259857);
    }

    public d(Context context) {
        AppMethodBeat.i(14385);
        this.o = context.getApplicationContext();
        this.p = new g();
        this.f682e = new com.tencent.liteav.beauty.d(this.o, true);
        this.f682e.a((f) this);
        this.f682e.a((com.tencent.liteav.basic.b.b) this);
        if (this.p.U) {
            this.f682e.a(d.EnumC0157d.MODE_SAME_AS_OUTPUT);
        } else if (this.p.T) {
            this.f682e.a(d.EnumC0157d.MODE_SAME_AS_INPUT);
        } else {
            this.f682e.a(d.EnumC0157d.MODE_THRESHOLD);
        }
        this.f685h = new TXSVideoEncoderParam();
        this.f685h.encoderMode = 1;
        this.f686i = null;
        this.l = new TXSVideoEncoderParam();
        this.l.encoderMode = 1;
        this.f678a = new b(this);
        this.W = new com.tencent.liteav.beauty.b(new g(this.o));
        this.W.setPreprocessor(this.f682e);
        c.a().a(this.o);
        AppMethodBeat.o(14385);
    }

    public TXBeautyManager b() {
        return this.W;
    }

    public void a(a aVar) {
        AppMethodBeat.i(221616);
        this.N = new WeakReference<>(aVar);
        AppMethodBeat.o(221616);
    }

    public void a(o oVar, int i2) {
        AppMethodBeat.i(221617);
        this.K = i2;
        if (oVar != null) {
            this.L = new WeakReference<>(oVar);
            AppMethodBeat.o(221617);
            return;
        }
        this.L = null;
        AppMethodBeat.o(221617);
    }

    public void a(boolean z2) {
        this.M = z2;
    }

    public void a(g gVar) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(221618);
        boolean z4 = (gVar == null || (this.p.E == gVar.E && this.p.F == gVar.F && this.p.G == gVar.G && this.p.J == gVar.J && this.p.H == gVar.H && this.p.I == gVar.I)) ? false : true;
        if (gVar == null || (this.p.f777a == gVar.f777a && this.p.f778b == gVar.f778b)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (gVar != null) {
            try {
                this.p = (g) gVar.clone();
            } catch (CloneNotSupportedException e2) {
                this.p = new g();
            }
        } else {
            this.p = new g();
        }
        TXCLog.i("TXCCaptureAndEnc", String.format("vsize setConfig w*h:%d*%d orientation:%d", Integer.valueOf(this.p.f777a), Integer.valueOf(this.p.f778b), Integer.valueOf(this.p.l)));
        if (this.f681d != null) {
            this.f681d.e(this.p.l);
        }
        if (!z2 || this.p.T) {
            z3 = false;
        } else {
            z3 = true;
        }
        l(z3);
        if (j()) {
            B();
            if (z4) {
                A();
            }
        }
        AppMethodBeat.o(221618);
    }

    public void a(com.tencent.liteav.basic.b.b bVar) {
        AppMethodBeat.i(221619);
        this.X = new WeakReference<>(bVar);
        AppMethodBeat.o(221619);
    }

    public void a(m mVar) {
        AppMethodBeat.i(221620);
        this.Y = new WeakReference<>(mVar);
        AppMethodBeat.o(221620);
    }

    public int c() {
        return this.f685h.width;
    }

    public int d() {
        return this.f685h.height;
    }

    @Override // com.tencent.liteav.basic.module.a
    public void setID(String str) {
        AppMethodBeat.i(221621);
        super.setID(str);
        if (this.f686i != null) {
            this.f686i.setID(str);
        }
        if (this.m != null) {
            this.m.setID(str);
        }
        if (this.f682e != null) {
            this.f682e.setID(str);
        }
        if (this.f681d != null) {
            this.f681d.a(getID());
        }
        TXCLog.w("TXCCaptureAndEnc", "setID:".concat(String.valueOf(str)));
        AppMethodBeat.o(221621);
    }

    public void a(final int i2) {
        AppMethodBeat.i(221622);
        TXCLog.i("TXCCaptureAndEnc", "vrotation setVideoEncRotation ".concat(String.valueOf(i2)));
        this.Z = i2;
        if (this.f681d != null) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass1 */

                public void run() {
                    AppMethodBeat.i(14380);
                    if (d.this.f686i != null) {
                        d.this.f686i.a(i2);
                    }
                    if (d.this.m != null) {
                        d.this.m.a(i2);
                    }
                    AppMethodBeat.o(14380);
                }
            });
            AppMethodBeat.o(221622);
            return;
        }
        com.tencent.liteav.videoencoder.b bVar = this.f686i;
        if (bVar != null) {
            bVar.a(i2);
        }
        com.tencent.liteav.videoencoder.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.a(i2);
        }
        AppMethodBeat.o(221622);
    }

    public void b(int i2) {
        AppMethodBeat.i(221623);
        TXCLog.i("TXCCaptureAndEnc", "setLocalViewMirror ".concat(String.valueOf(i2)));
        this.aa = i2;
        if (this.f681d != null) {
            this.f681d.d(this.aa);
        }
        if (this.C != null) {
            this.C.b(this.aa);
        }
        AppMethodBeat.o(221623);
    }

    public int e() {
        AppMethodBeat.i(221624);
        if (j()) {
            TXCLog.w("TXCCaptureAndEnc", "ignore startPush when pushing, status:" + this.s);
            AppMethodBeat.o(221624);
            return -2;
        }
        TXCDRApi.initCrashReport(this.o);
        this.s = 1;
        TXCLog.i("TXCCaptureAndEnc", "startWithoutAudio");
        B();
        TXCDRApi.txReportDAU(this.o, com.tencent.liteav.basic.datareport.a.bu);
        AppMethodBeat.o(221624);
        return 0;
    }

    public void f() {
        AppMethodBeat.i(14393);
        if (!j()) {
            TXCLog.w("TXCCaptureAndEnc", "ignore stopPush when not pushing, status:" + this.s);
            AppMethodBeat.o(14393);
            return;
        }
        TXCLog.i("TXCCaptureAndEnc", "stop");
        this.s = 0;
        t();
        this.p.P = false;
        if (this.f678a != null) {
            this.f678a.b();
        }
        b(false);
        this.D = null;
        AppMethodBeat.o(14393);
    }

    public void g() {
        AppMethodBeat.i(221625);
        if (this.s != 1) {
            TXCLog.w("TXCCaptureAndEnc", "ignore pause push when is not pushing, status:" + this.s);
            AppMethodBeat.o(221625);
            return;
        }
        this.s = 2;
        TXCLog.i("TXCCaptureAndEnc", "pausePusher");
        if ((this.p.D & 1) == 1) {
            t();
            if (this.f678a != null && !this.p.M) {
                this.f678a.a(this.p.C, this.p.B, this.p.A, this.f685h.width, this.f685h.height);
            }
            if (this.f681d != null) {
                this.f681d.c();
            }
        }
        AppMethodBeat.o(221625);
    }

    public void h() {
        AppMethodBeat.i(221626);
        if (this.s != 2) {
            TXCLog.w("TXCCaptureAndEnc", "ignore resume push when is not pause, status:" + this.s);
            AppMethodBeat.o(221626);
            return;
        }
        this.s = 1;
        TXCLog.i("TXCCaptureAndEnc", "resumePusher");
        if ((this.p.D & 1) == 1) {
            if (this.f678a != null && !this.p.M) {
                this.f678a.b();
            }
            t();
            if (this.f681d != null) {
                this.f681d.b();
            }
            A();
        }
        AppMethodBeat.o(221626);
    }

    public boolean i() {
        return this.t;
    }

    public void b(boolean z2) {
        AppMethodBeat.i(14405);
        TXCLog.i("TXCCaptureAndEnc", "enableBlackStream ".concat(String.valueOf(z2)));
        this.t = z2;
        if (!this.t) {
            x();
        } else if (this.f681d == null) {
            w();
            AppMethodBeat.o(14405);
            return;
        }
        AppMethodBeat.o(14405);
    }

    private void w() {
        AppMethodBeat.i(221627);
        TXCLog.i("TXCCaptureAndEnc", " startBlackStream");
        if (this.f679b == null) {
            this.f679b = new b(this);
        }
        this.f679b.a(10, -1, null, 64, 64);
        AppMethodBeat.o(221627);
    }

    private void x() {
        AppMethodBeat.i(221628);
        TXCLog.i("TXCCaptureAndEnc", " stopBlackStream when enableBlackStream " + this.t);
        if (this.f679b != null) {
            this.f679b.b();
        }
        AppMethodBeat.o(221628);
    }

    public void a(int i2, final int i3, final int i4, final int i5, final int i6, int i7, int i8, final boolean z2) {
        AppMethodBeat.i(259854);
        if (i2 == 2) {
            if (this.H != z2) {
                TXCLog.i("TXCCaptureAndEnc", "codecability setVideoQosParam enableHevcEncode= ".concat(String.valueOf(z2)));
            }
            if (this.f685h.width == 0 || this.f685h.height == 0 || (i3 == this.f685h.width && i4 == this.f685h.height && i5 <= this.f685h.fps && z2)) {
                com.tencent.liteav.videoencoder.b bVar = this.f686i;
                if (bVar != null) {
                    bVar.b(i6, i7);
                    bVar.b(i5);
                }
            } else if (this.f681d != null) {
                this.f681d.a(new Runnable() {
                    /* class com.tencent.liteav.d.AnonymousClass12 */

                    public void run() {
                        AppMethodBeat.i(222382);
                        if (!(i3 == d.this.f685h.width && i4 == d.this.f685h.height && i5 <= d.this.f685h.fps && z2 == d.this.H)) {
                            if (i3 > i4) {
                                d.this.p.l = 0;
                            } else if (i3 < i4) {
                                d.this.p.l = 1;
                            }
                            d.this.p.f777a = i3 > i4 ? i4 : i3;
                            d.this.p.f778b = i3 > i4 ? i3 : i4;
                            k kVar = d.this.f681d;
                            if (kVar != null) {
                                kVar.a(com.tencent.liteav.basic.a.c.RESOLUTION_TYPE_INVALID);
                                kVar.b(d.this.p.f777a, d.this.p.f778b);
                                kVar.e(d.this.p.l);
                            }
                            d.this.p.f779c = i6;
                            d.this.p.f784h = i5;
                            if (!z2) {
                                d.this.H = false;
                            }
                            d.g(d.this);
                            TXCLog.e("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", Integer.valueOf(d.this.f685h.width), Integer.valueOf(d.this.f685h.height), Integer.valueOf(d.this.f685h.fps), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
                        }
                        AppMethodBeat.o(222382);
                    }
                });
            }
            d(i8);
            AppMethodBeat.o(259854);
            return;
        }
        if (!(this.l == null || ((i3 == this.l.width && i4 == this.l.height) || this.f681d == null))) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass20 */

                public void run() {
                    AppMethodBeat.i(222588);
                    TXCLog.w("TXCCaptureAndEnc", String.format("QOS restart big encoder old resolution %dx%d fps %d, new resolution %dx%d fps %d", Integer.valueOf(d.this.l.width), Integer.valueOf(d.this.l.height), Integer.valueOf(d.this.l.fps), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
                    d.this.l.width = i3;
                    d.this.l.height = i4;
                    d.i(d.this);
                    AppMethodBeat.o(222588);
                }
            });
        }
        com.tencent.liteav.videoencoder.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.b(i6, i7);
            bVar2.b(i5);
        }
        AppMethodBeat.o(259854);
    }

    public void c(final int i2) {
        AppMethodBeat.i(221630);
        if (this.f681d == null) {
            AppMethodBeat.o(221630);
            return;
        }
        this.f681d.a(new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass21 */

            public void run() {
                AppMethodBeat.i(221429);
                if (d.this.f686i != null) {
                    d.this.f686i.d(i2);
                }
                d.this.f687j = i2;
                AppMethodBeat.o(221429);
            }
        });
        AppMethodBeat.o(221630);
    }

    public void a(final int i2, final int i3, final int i4) {
        AppMethodBeat.i(221631);
        if (this.f681d == null) {
            AppMethodBeat.o(221631);
            return;
        }
        this.f681d.a(new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass22 */

            public void run() {
                AppMethodBeat.i(222383);
                if (!(i3 == 0 || i4 == 0)) {
                    d.this.p.f777a = i3;
                    d.this.p.f778b = i4;
                    if (d.this.f681d != null) {
                        d.this.f681d.a(com.tencent.liteav.basic.a.c.RESOLUTION_TYPE_INVALID);
                        d.this.f681d.b(i3, i4);
                    }
                }
                if (!(i2 == 0 || d.this.f686i == null)) {
                    d.this.p.f779c = i2;
                    d.this.f686i.c(i2);
                }
                AppMethodBeat.o(222383);
            }
        });
        AppMethodBeat.o(221631);
    }

    public void d(final int i2) {
        AppMethodBeat.i(221632);
        if (this.f681d == null) {
            AppMethodBeat.o(221632);
            return;
        }
        this.f681d.a(new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass23 */

            public void run() {
                AppMethodBeat.i(221383);
                if (d.this.f686i != null) {
                    d.this.f686i.e(i2);
                }
                AppMethodBeat.o(221383);
            }
        });
        AppMethodBeat.o(221632);
    }

    public boolean j() {
        return this.s != 0;
    }

    public void k() {
        AppMethodBeat.i(14396);
        if (this.f681d == null) {
            AppMethodBeat.o(14396);
            return;
        }
        this.f681d.a(new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass24 */

            public void run() {
                AppMethodBeat.i(259876);
                if (d.this.f681d != null) {
                    d.this.f681d.b(true);
                }
                d.a(d.this, d.this.f685h.width, d.this.f685h.height);
                d.this.a(d.this.Z);
                AppMethodBeat.o(259876);
            }
        });
        AppMethodBeat.o(14396);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.tencent.liteav.renderer.TXCGLSurfaceView[]] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.liteav.renderer.TXCGLSurfaceView] */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(final com.tencent.rtmp.ui.TXCloudVideoView r8) {
        /*
        // Method dump skipped, instructions count: 176
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.d.a(com.tencent.rtmp.ui.TXCloudVideoView):void");
    }

    public void c(boolean z2) {
        AppMethodBeat.i(221634);
        k(z2);
        AppMethodBeat.o(221634);
    }

    public int a(boolean z2, int i2, int i3, int i4, int i5, int i6) {
        AppMethodBeat.i(221635);
        boolean z3 = (this.l.width == i2 && this.l.height == i3) ? false : true;
        this.l.width = i2;
        this.l.height = i3;
        this.l.fps = i4;
        this.l.gop = i6;
        this.l.encoderProfile = 1;
        this.l.realTime = this.p.P;
        this.l.streamType = 3;
        this.l.bitrate = i5;
        this.l.annexb = true;
        this.l.bMultiRef = false;
        if (this.m != null && (z3 || (this.k && !z2))) {
            if (this.f681d != null) {
                this.f681d.a(new Runnable() {
                    /* class com.tencent.liteav.d.AnonymousClass3 */

                    public void run() {
                        AppMethodBeat.i(221428);
                        d.i(d.this);
                        AppMethodBeat.o(221428);
                    }
                });
            } else {
                y();
            }
        }
        this.k = z2;
        AppMethodBeat.o(221635);
        return 0;
    }

    public void e(int i2) {
        AppMethodBeat.i(221636);
        if (this.p.f784h == i2) {
            AppMethodBeat.o(221636);
            return;
        }
        this.p.f784h = i2;
        if (this.f681d != null && this.f681d.g() < i2) {
            switch (this.q) {
                case 0:
                    l(true);
                    t();
                    AppMethodBeat.o(221636);
                    return;
                case 1:
                    this.f681d.f(i2);
                    break;
            }
        }
        AppMethodBeat.o(221636);
    }

    public void a(Surface surface) {
        AppMethodBeat.i(221637);
        if (this.x != null) {
            TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
            AppMethodBeat.o(221637);
            return;
        }
        synchronized (this.y) {
            try {
                if (this.z != surface) {
                    TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface ".concat(String.valueOf(surface)));
                    this.z = surface;
                    if (this.C != null) {
                        this.C.a();
                        this.C = null;
                    }
                } else {
                    TXCLog.i("TXCCaptureAndEnc", "surface-render: set surface the same".concat(String.valueOf(surface)));
                }
            } finally {
                AppMethodBeat.o(221637);
            }
        }
    }

    public void a(final int i2, final int i3) {
        AppMethodBeat.i(221638);
        synchronized (this.y) {
            try {
                if (this.C != null) {
                    this.C.a(new Runnable() {
                        /* class com.tencent.liteav.d.AnonymousClass4 */

                        public void run() {
                            AppMethodBeat.i(222015);
                            d.this.A = i2;
                            d.this.B = i3;
                            if (!(d.this.D == null || d.this.C == null)) {
                                d.a(d.this, d.this.D, true);
                            }
                            AppMethodBeat.o(222015);
                        }
                    });
                } else {
                    this.A = i2;
                    this.B = i3;
                }
            } finally {
                AppMethodBeat.o(221638);
            }
        }
    }

    public void a(final o oVar) {
        AppMethodBeat.i(221639);
        if (this.x != null) {
            TXCGLSurfaceView gLSurfaceView = this.x.getGLSurfaceView();
            if (gLSurfaceView != null) {
                gLSurfaceView.a(new o() {
                    /* class com.tencent.liteav.d.AnonymousClass5 */

                    @Override // com.tencent.liteav.basic.c.o
                    public void onTakePhotoComplete(Bitmap bitmap) {
                        AppMethodBeat.i(221599);
                        if (oVar != null) {
                            oVar.onTakePhotoComplete(bitmap);
                        }
                        AppMethodBeat.o(221599);
                    }
                });
                AppMethodBeat.o(221639);
                return;
            }
            if (oVar != null) {
                oVar.onTakePhotoComplete(null);
            }
            AppMethodBeat.o(221639);
        } else if (this.C != null) {
            this.C.a(new o() {
                /* class com.tencent.liteav.d.AnonymousClass6 */

                @Override // com.tencent.liteav.basic.c.o
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.i(222591);
                    if (oVar != null) {
                        oVar.onTakePhotoComplete(bitmap);
                    }
                    AppMethodBeat.o(222591);
                }
            });
            AppMethodBeat.o(221639);
        } else {
            if (oVar != null) {
                oVar.onTakePhotoComplete(null);
            }
            AppMethodBeat.o(221639);
        }
    }

    public void a(a.AbstractC0160a aVar) {
        AppMethodBeat.i(221640);
        if (Build.VERSION.SDK_INT < 21) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "Screen recording failed, unsupported Android system version. system version should above 5.0");
            onNotifyEvent(-1309, bundle);
            TXLog.e("TXCCaptureAndEnc", "Screen capture need running on Android Lollipop or higher version, current:" + Build.VERSION.SDK_INT);
            AppMethodBeat.o(221640);
            return;
        }
        this.q = 1;
        if (this.f681d == null) {
            this.f681d = new i(this.o, this.p, aVar);
            TXCLog.i("TXCCaptureAndEnc", "create TXCScreenCaptureSource");
        }
        this.W.a(false);
        j(this.E);
        this.f681d.a((com.tencent.liteav.basic.b.b) this);
        this.f681d.a((l) this);
        this.f681d.a();
        this.f681d.a(getID());
        TXCDRApi.txReportDAU(this.o, com.tencent.liteav.basic.datareport.a.aG);
        AppMethodBeat.o(221640);
    }

    public void l() {
        AppMethodBeat.i(14397);
        if (this.f681d == null) {
            AppMethodBeat.o(14397);
            return;
        }
        this.W.a(true);
        k(true);
        AppMethodBeat.o(14397);
    }

    private void k(final boolean z2) {
        AppMethodBeat.i(221684);
        if (this.f681d == null) {
            AppMethodBeat.o(221684);
            return;
        }
        this.f681d.a(new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass7 */

            public void run() {
                AppMethodBeat.i(221368);
                if (d.this.f682e != null) {
                    d.this.f682e.b();
                }
                AppMethodBeat.o(221368);
            }
        });
        t();
        this.f681d.a(z2);
        this.f681d = null;
        TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
        final TXCloudVideoView tXCloudVideoView = this.x;
        this.f680c.post(new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass8 */

            public void run() {
                AppMethodBeat.i(222645);
                if (tXCloudVideoView != null) {
                    tXCloudVideoView.stop(z2);
                }
                AppMethodBeat.o(222645);
            }
        });
        this.x = null;
        synchronized (this.y) {
            try {
                this.z = null;
                if (this.C != null) {
                    this.C.a();
                    this.C = null;
                }
            } finally {
                AppMethodBeat.o(221684);
            }
        }
        if (this.f678a.a()) {
            this.f678a.b();
        }
        if (this.t) {
            w();
        }
    }

    public void f(int i2) {
        AppMethodBeat.i(221642);
        TXCLog.i("TXCCaptureAndEnc", "setRenderMode ".concat(String.valueOf(i2)));
        this.v = i2;
        if (this.f681d != null) {
            this.f681d.c(i2);
        }
        if (this.C != null) {
            this.C.a(this.v);
        }
        AppMethodBeat.o(221642);
    }

    public void d(boolean z2) {
        this.V = z2;
    }

    public void g(int i2) {
        AppMethodBeat.i(221643);
        if (this.u != i2) {
            TXCLog.i("TXCCaptureAndEnc", "vrotation setRenderRotation ".concat(String.valueOf(i2)));
        }
        this.u = i2;
        if (this.f681d == null) {
            AppMethodBeat.o(221643);
            return;
        }
        this.f681d.b(i2);
        AppMethodBeat.o(221643);
    }

    public boolean e(boolean z2) {
        AppMethodBeat.i(221644);
        if (this.f681d == null) {
            AppMethodBeat.o(221644);
            return false;
        }
        boolean d2 = this.f681d.d(z2);
        AppMethodBeat.o(221644);
        return d2;
    }

    public void b(int i2, int i3, int i4) {
        AppMethodBeat.i(221645);
        this.W.setBeautyLevel(i2);
        this.W.setWhitenessLevel(i3);
        this.W.setRuddyLevel(i4);
        AppMethodBeat.o(221645);
    }

    public void h(int i2) {
        AppMethodBeat.i(221646);
        this.W.setBeautyStyle(i2);
        AppMethodBeat.o(221646);
    }

    public void a(Bitmap bitmap, float f2, float f3, float f4) {
        AppMethodBeat.i(221647);
        this.p.E = bitmap;
        this.p.H = f2;
        this.p.I = f3;
        this.p.J = f4;
        A();
        AppMethodBeat.o(221647);
    }

    public boolean m() {
        AppMethodBeat.i(221648);
        if (this.f681d != null) {
            boolean h2 = this.f681d.h();
            AppMethodBeat.o(221648);
            return h2;
        }
        AppMethodBeat.o(221648);
        return false;
    }

    public boolean n() {
        AppMethodBeat.i(221649);
        if (this.f681d != null) {
            boolean i2 = this.f681d.i();
            AppMethodBeat.o(221649);
            return i2;
        }
        AppMethodBeat.o(221649);
        return false;
    }

    public boolean o() {
        AppMethodBeat.i(221650);
        if (this.f681d != null) {
            boolean j2 = this.f681d.j();
            AppMethodBeat.o(221650);
            return j2;
        }
        AppMethodBeat.o(221650);
        return false;
    }

    public boolean p() {
        AppMethodBeat.i(221651);
        if (this.f681d != null) {
            boolean k2 = this.f681d.k();
            AppMethodBeat.o(221651);
            return k2;
        }
        AppMethodBeat.o(221651);
        return false;
    }

    public int q() {
        AppMethodBeat.i(221652);
        if (this.f681d == null) {
            AppMethodBeat.o(221652);
            return 0;
        }
        int e2 = this.f681d.e();
        AppMethodBeat.o(221652);
        return e2;
    }

    public boolean i(int i2) {
        AppMethodBeat.i(221653);
        if (this.f681d == null) {
            AppMethodBeat.o(221653);
            return false;
        }
        boolean a2 = this.f681d.a(i2);
        AppMethodBeat.o(221653);
        return a2;
    }

    public void b(int i2, int i3) {
        AppMethodBeat.i(221654);
        if (this.f681d == null) {
            AppMethodBeat.o(221654);
            return;
        }
        this.f681d.a(i2, i3);
        AppMethodBeat.o(221654);
    }

    public boolean f(boolean z2) {
        AppMethodBeat.i(221655);
        this.p.S = z2;
        if (this.f681d == null) {
            AppMethodBeat.o(221655);
            return false;
        }
        this.f681d.c(z2);
        AppMethodBeat.o(221655);
        return true;
    }

    public void a(float f2) {
        AppMethodBeat.i(221656);
        if (this.f681d == null) {
            AppMethodBeat.o(221656);
            return;
        }
        this.f681d.a(f2);
        AppMethodBeat.o(221656);
    }

    public void j(int i2) {
        AppMethodBeat.i(221657);
        this.E = i2;
        if (this.f681d != null) {
            this.f681d.g(this.E);
        }
        AppMethodBeat.o(221657);
    }

    public void g(boolean z2) {
        AppMethodBeat.i(221658);
        if (this.H && z2) {
            TXCLog.i("TXCCaptureAndEnc", "enableRPS when mEnableHEVCEncode = true");
            AppMethodBeat.o(221658);
        } else if (this.F == z2) {
            AppMethodBeat.o(221658);
        } else {
            this.F = z2;
            TXCLog.i("TXCCaptureAndEnc", "trtc_api onVideoConfigChanged enableRps " + this.F);
            if (this.F) {
                this.p.f786j = 0;
            }
            t();
            AppMethodBeat.o(221658);
        }
    }

    public void h(boolean z2) {
        this.f684g = z2;
    }

    public void i(boolean z2) {
        this.G = z2;
    }

    public void k(int i2) {
        AppMethodBeat.i(221659);
        com.tencent.liteav.videoencoder.b bVar = null;
        if (i2 == 2) {
            bVar = this.f686i;
        } else if (i2 == 3) {
            bVar = this.m;
        }
        if (bVar != null) {
            bVar.b();
        }
        AppMethodBeat.o(221659);
    }

    public void j(final boolean z2) {
        AppMethodBeat.i(221641);
        TXCLog.i("TXCCaptureAndEnc", "mEnableHEVCEncode = ".concat(String.valueOf(z2)));
        if (this.f681d != null) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass9 */

                public void run() {
                    AppMethodBeat.i(222388);
                    d.this.H = z2;
                    AppMethodBeat.o(222388);
                }
            });
            AppMethodBeat.o(221641);
            return;
        }
        synchronized (this.n) {
            try {
                this.H = z2;
            } finally {
                AppMethodBeat.o(221641);
            }
        }
    }

    private void a(int i2, String str) {
        String id;
        long j2;
        int i3 = 2002;
        AppMethodBeat.i(221660);
        Bundle bundle = new Bundle();
        bundle.putString("EVT_USERID", getID());
        bundle.putInt("EVT_ID", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        com.tencent.liteav.basic.util.f.a(this.X, i2, bundle);
        if (i2 == -1317) {
            id = getID();
            j2 = 4;
        } else if (i2 == -1314) {
            id = getID();
            j2 = 5;
        } else {
            if (i2 == 1003 && this.f681d != null) {
                id = getID();
                i3 = 4001;
                j2 = this.f681d.l() ? 0 : 1;
            }
            if (i2 != -1302 || i2 == -1317 || i2 == -1318 || i2 == -1319) {
                TXCKeyPointReportProxy.b(30002, i2);
                AppMethodBeat.o(221660);
            }
            if (i2 == -1301 || i2 == -1314 || i2 == -1315 || i2 == -1316) {
                TXCKeyPointReportProxy.b(30003, i2);
                if (this.f681d != null) {
                    TXCEventRecorderProxy.a(getID(), 4002, this.f681d.l() ? 0 : 1, (long) i2, "", this.E);
                }
            }
            AppMethodBeat.o(221660);
            return;
        }
        TXCEventRecorderProxy.a(id, i3, j2, -1, "", this.E);
        if (i2 != -1302) {
        }
        TXCKeyPointReportProxy.b(30002, i2);
        AppMethodBeat.o(221660);
    }

    public int a(byte[] bArr, int i2, int i3, int i4, long j2) {
        long j3;
        AppMethodBeat.i(221661);
        synchronized (this.n) {
            try {
                if (this.s == 2) {
                    return 0;
                }
                int a2 = a(i3, i4, (Object) null);
                if (a2 != 0) {
                    AppMethodBeat.o(221661);
                    return a2;
                }
                com.tencent.liteav.videoencoder.b bVar = this.f686i;
                if (bVar != null) {
                    if (j2 == 0) {
                        j3 = TXCTimeUtil.generatePtsMS();
                    } else {
                        j3 = j2;
                    }
                    bVar.a(bArr, i2, i3, i4, j3);
                }
                AppMethodBeat.o(221661);
                return 0;
            } finally {
                AppMethodBeat.o(221661);
            }
        }
    }

    public int a(byte[] bArr, int i2, int i3, int i4, Object obj, long j2, int i5) {
        AppMethodBeat.i(221662);
        com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
        bVar.m = bArr;
        bVar.f429b = i2;
        bVar.f431d = true;
        a(bVar, i3, i4, obj, j2);
        AppMethodBeat.o(221662);
        return 0;
    }

    public void r() {
        AppMethodBeat.i(14404);
        try {
            if (this.f682e != null) {
                this.f682e.b();
            }
            if (this.O != null) {
                this.O.d();
                this.O = null;
            }
            if (this.Q != null) {
                this.Q.d();
                this.Q = null;
            }
            if (this.P != null) {
                this.P.d();
                this.P = null;
            }
            z();
            y();
            AppMethodBeat.o(14404);
        } catch (Exception e2) {
            TXCLog.e("TXCCaptureAndEnc", "stop preprocessor and encoder failed.", e2);
            AppMethodBeat.o(14404);
        }
    }

    public int a(int i2, int i3, int i4, Object obj, long j2) {
        long j3;
        AppMethodBeat.i(221663);
        synchronized (this.n) {
            try {
                if (this.s == 2) {
                    return 0;
                }
                int a2 = a(i3, i4, obj);
                if (a2 != 0) {
                    AppMethodBeat.o(221663);
                    return a2;
                }
                if (j2 == 0) {
                    j3 = TXCTimeUtil.generatePtsMS();
                } else {
                    j3 = j2;
                }
                com.tencent.liteav.videoencoder.b bVar = this.f686i;
                if (bVar != null) {
                    bVar.a(this.p.S);
                    bVar.a(i2, i3, i4, j3);
                }
                com.tencent.liteav.videoencoder.b bVar2 = this.m;
                if (bVar2 != null) {
                    bVar2.a(this.p.S);
                    bVar2.a(i2, i3, i4, j3);
                }
                AppMethodBeat.o(221663);
                return 0;
            } finally {
                AppMethodBeat.o(221663);
            }
        }
    }

    public int a(int i2, int i3, int i4, Object obj, long j2, int i5) {
        AppMethodBeat.i(221664);
        com.tencent.liteav.basic.structs.b bVar = new com.tencent.liteav.basic.structs.b();
        bVar.f428a = i2;
        bVar.f429b = 0;
        a(bVar, i3, i4, obj, j2);
        AppMethodBeat.o(221664);
        return 0;
    }

    private void a(com.tencent.liteav.basic.structs.b bVar, int i2, int i3, Object obj, long j2) {
        AppMethodBeat.i(221665);
        synchronized (this.n) {
            try {
                if (this.s != 2) {
                    bVar.f432e = i2;
                    bVar.f433f = i3;
                    bVar.f436i = this.p.S;
                    if (this.p.l == 0) {
                        bVar.f434g = this.p.f778b;
                        bVar.f435h = this.p.f777a;
                    } else {
                        bVar.f434g = this.p.f777a;
                        bVar.f435h = this.p.f778b;
                    }
                    bVar.l = com.tencent.liteav.basic.util.f.a(bVar.f432e, bVar.f433f, bVar.f434g, bVar.f435h);
                    try {
                        this.f682e.a(this.p.l);
                        this.f682e.a(obj);
                        this.f682e.a(bVar, bVar.f429b, 0, j2);
                    } catch (Exception e2) {
                        TXCLog.e("TXCCaptureAndEnc", "send custom video frame failed." + e2.getMessage());
                    }
                    AppMethodBeat.o(221665);
                }
            } finally {
                AppMethodBeat.o(221665);
            }
        }
    }

    @Override // com.tencent.liteav.beauty.f
    public int a(com.tencent.liteav.basic.structs.b bVar) {
        m mVar;
        AppMethodBeat.i(221666);
        if (!(this.Y == null || (mVar = this.Y.get()) == null)) {
            bVar.f428a = mVar.a(bVar.f428a, bVar.f432e, bVar.f433f);
        }
        d(bVar);
        a(bVar, false);
        int i2 = bVar.f428a;
        AppMethodBeat.o(221666);
        return i2;
    }

    @Override // com.tencent.liteav.beauty.f
    public void a(com.tencent.liteav.basic.structs.b bVar, long j2) {
        AppMethodBeat.i(221667);
        a(bVar.f428a, bVar.f432e, bVar.f433f, j2);
        AppMethodBeat.o(221667);
    }

    @Override // com.tencent.liteav.beauty.f
    public void b(byte[] bArr, int i2, int i3, int i4, long j2) {
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void a(TXSNALPacket tXSNALPacket, int i2) {
        int i3 = 1;
        AppMethodBeat.i(221668);
        if (i2 == 0) {
            if (tXSNALPacket.streamType == 2) {
                this.J = tXSNALPacket.gopIndex;
                this.I = tXSNALPacket.frameIndex;
            }
            if (this.N == null) {
                AppMethodBeat.o(221668);
                return;
            }
            a aVar = this.N.get();
            if (aVar != null) {
                aVar.onEncVideo(tXSNALPacket);
            }
            AppMethodBeat.o(221668);
            return;
        }
        if ((i2 == 10000004 || i2 == 10000005 || i2 == 10000006) && this.f685h.encodeType == 1) {
            TXCLog.i("TXCCaptureAndEnc", "onEncodeNal mEnableHEVCEncode " + this.H + " errCode= " + i2);
            if (this.H) {
                Locale locale = Locale.getDefault();
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(i2);
                objArr[1] = TXCCommonUtil.getDeviceInfo();
                if (!com.tencent.liteav.videoencoder.c.a(1920, 1080, 20)) {
                    i3 = 0;
                }
                objArr[2] = Integer.valueOf(i3);
                String format = String.format(locale, "VideoEncoder: hevc hardware encoder error %d, switch to 264 encoder. %s, %d", objArr);
                Monitor.a(2, format, "", 0);
                TXCLog.i("TXCCaptureAndEnc", format);
                k kVar = this.f681d;
                if (kVar != null) {
                    kVar.a(new Runnable() {
                        /* class com.tencent.liteav.d.AnonymousClass10 */

                        public void run() {
                            AppMethodBeat.i(222381);
                            d.this.H = false;
                            d.g(d.this);
                            d.i(d.this);
                            AppMethodBeat.o(222381);
                        }
                    });
                } else {
                    synchronized (this.n) {
                        try {
                            this.H = false;
                            z();
                            y();
                        } catch (Throwable th) {
                            AppMethodBeat.o(221668);
                            throw th;
                        }
                    }
                }
                com.tencent.liteav.basic.util.f.a(this.X, (int) TXLiteAVCode.ERR_HEVC_ENCODE_FAIL, getID());
                AppMethodBeat.o(221668);
                return;
            }
            Monitor.a(2, String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", Integer.valueOf(i2)), "", 0);
            t();
            this.r++;
            this.p.f786j = 0;
            a(1103, "Failed to enable hardware encoder, use software encoder");
        }
        AppMethodBeat.o(221668);
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(221669);
        if (this.N == null) {
            AppMethodBeat.o(221669);
            return;
        }
        a aVar = this.N.get();
        if (aVar != null) {
            aVar.onEncVideoFormat(mediaFormat);
        }
        AppMethodBeat.o(221669);
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void a(int i2, long j2, long j3) {
        if (i2 == 2) {
            this.J = j2;
            this.I = j3;
        }
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void l(int i2) {
        AppMethodBeat.i(221670);
        if (!this.H) {
            if (this.f685h.width * this.f685h.height < 518400) {
                this.p.f786j = 0;
            } else if (this.f685h.width * this.f685h.height < 921600 && this.f683f) {
                this.p.f786j = 0;
            }
        }
        if (i2 == 3) {
            v();
            AppMethodBeat.o(221670);
            return;
        }
        j(false);
        com.tencent.liteav.basic.util.f.a(this.X, (int) TXLiteAVCode.ERR_HEVC_ENCODE_FAIL, getID());
        this.f683f = true;
        u();
        AppMethodBeat.o(221670);
    }

    @Override // com.tencent.liteav.videoencoder.e
    public void m(int i2) {
    }

    @Override // com.tencent.liteav.basic.b.b
    public void onNotifyEvent(int i2, Bundle bundle) {
        AppMethodBeat.i(221671);
        if (bundle != null) {
            bundle.putString("EVT_USERID", getID());
        }
        if (i2 == -2311) {
            j(false);
        }
        com.tencent.liteav.basic.util.f.a(this.X, i2, bundle);
        if (i2 == -1317) {
            TXCEventRecorderProxy.a(getID(), 2002, 4, -1, "", this.E);
        } else if (i2 == -1314) {
            TXCEventRecorderProxy.a(getID(), 2002, 5, -1, "", this.E);
        } else if (i2 == 1003) {
            if (this.f681d != null) {
                TXCEventRecorderProxy.a(getID(), 4001, this.f681d.l() ? 0 : 1, -1, "", this.E);
            }
        } else if (i2 == -1308) {
            l();
        }
        if (i2 == -1302 || i2 == -1317 || i2 == -1318 || i2 == -1319) {
            TXCKeyPointReportProxy.b(30002, i2);
            AppMethodBeat.o(221671);
            return;
        }
        if (i2 == -1301 || i2 == -1314 || i2 == -1315 || i2 == -1316) {
            TXCKeyPointReportProxy.b(30003, i2);
            if (this.f681d != null) {
                TXCEventRecorderProxy.a(getID(), 4002, this.f681d.l() ? 0 : 1, (long) i2, "", this.E);
            }
        }
        AppMethodBeat.o(221671);
    }

    @Override // com.tencent.liteav.b.AbstractC0155b
    public void a(final Bitmap bitmap, final ByteBuffer byteBuffer, final int i2, final int i3) {
        AppMethodBeat.i(221672);
        AnonymousClass11 r0 = new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass11 */

            public void run() {
                AppMethodBeat.i(222651);
                try {
                    if ((d.this.s != 2 && !d.this.t) || bitmap == null || byteBuffer == null) {
                        AppMethodBeat.o(222651);
                        return;
                    }
                    if (!(d.this.f686i != null && !d.this.U && d.this.f685h.width == i2 && d.this.f685h.height == i3 && d.this.f685h.encodeType == 2 && d.this.f685h.gop == d.this.p.f785i)) {
                        d.a(d.this, i2, i3, 2, (Object) null, d.this.p.C, true);
                    }
                    if ((d.this.m == null || d.this.l.encodeType != 2) && d.this.k) {
                        d.a(d.this, (Object) null, 2, true);
                    }
                    int width = bitmap.getWidth();
                    int height = bitmap.getHeight();
                    com.tencent.liteav.videoencoder.b bVar = d.this.f686i;
                    if (bVar != null) {
                        bVar.a(byteBuffer.array(), 2, width, height, TXCTimeUtil.generatePtsMS());
                    }
                    com.tencent.liteav.videoencoder.b bVar2 = d.this.m;
                    if (bVar2 != null) {
                        bVar2.a(byteBuffer.array(), 2, width, height, TXCTimeUtil.generatePtsMS());
                    }
                    AppMethodBeat.o(222651);
                } catch (Exception e2) {
                    TXCLog.e("TXCCaptureAndEnc", "onPushBitmap failed." + e2.getMessage());
                    AppMethodBeat.o(222651);
                }
            }
        };
        k kVar = this.f681d;
        if (kVar != null) {
            kVar.a(r0);
            AppMethodBeat.o(221672);
            return;
        }
        r0.run();
        AppMethodBeat.o(221672);
    }

    @Override // com.tencent.liteav.b.AbstractC0155b
    public void a() {
        AppMethodBeat.i(14386);
        TXCLog.i("TXCCaptureAndEnc", "onPushEnd");
        if (this.N == null) {
            AppMethodBeat.o(14386);
            return;
        }
        a aVar = this.N.get();
        if (aVar == null) {
            AppMethodBeat.o(14386);
            return;
        }
        aVar.onBackgroudPushStop();
        AppMethodBeat.o(14386);
    }

    @Override // com.tencent.liteav.l
    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(221673);
        if (this.f682e != null) {
            this.f682e.b();
        }
        AppMethodBeat.o(221673);
    }

    @Override // com.tencent.liteav.l
    public void b(com.tencent.liteav.basic.structs.b bVar) {
        AppMethodBeat.i(221674);
        if (!this.T) {
            this.T = true;
            TXCKeyPointReportProxy.b(30003, 0);
        }
        if (this.s == 2) {
            AppMethodBeat.o(221674);
            return;
        }
        k kVar = this.f681d;
        if (!(this.f682e == null || this.p.M || kVar == null)) {
            if (!(this.f685h.height == bVar.f435h && this.f685h.width == bVar.f434g)) {
                d(bVar.f434g, bVar.f435h);
            }
            this.f682e.a(kVar.f());
            this.f682e.a(this.p.l);
            this.f682e.a(bVar, bVar.f429b, 0, 0);
        }
        AppMethodBeat.o(221674);
    }

    @Override // com.tencent.liteav.l
    public void s() {
        m mVar;
        AppMethodBeat.i(14406);
        TXCLog.i("TXCCaptureAndEnc", "onCaptureDestroy->enter ");
        if (this.f682e != null) {
            this.f682e.b();
        }
        if (this.O != null) {
            this.O.d();
            this.O = null;
        }
        if (this.Q != null) {
            this.Q.d();
            this.Q = null;
        }
        if (this.P != null) {
            this.P.d();
            this.P = null;
        }
        if (this.R != null) {
            this.R.d();
            this.R = null;
        }
        z();
        y();
        if (!(this.Y == null || (mVar = this.Y.get()) == null)) {
            mVar.a();
        }
        AppMethodBeat.o(14406);
    }

    private void a(int i2, int i3, int i4, Object obj, int i5, boolean z2) {
        AppMethodBeat.i(221675);
        TXCLog.i("TXCCaptureAndEnc", "New encode size width = " + i2 + " height = " + i3 + " encType = " + i4 + " eglContext: " + obj);
        z();
        com.tencent.liteav.videoencoder.b bVar = new com.tencent.liteav.videoencoder.b(i4);
        TXCStatus.a(getID(), WearableStatusCodes.ASSET_UNAVAILABLE, this.E, Integer.valueOf(i4));
        if (i4 == 1) {
            TXCEventRecorderProxy.a(getID(), WearableStatusCodes.INVALID_TARGET_NODE, 1, -1, "", this.E);
        } else {
            TXCEventRecorderProxy.a(getID(), WearableStatusCodes.INVALID_TARGET_NODE, 0, -1, "", this.E);
        }
        this.U = false;
        this.f685h.encodeType = i4;
        this.f685h.width = i2;
        this.f685h.height = i3;
        this.f685h.fps = i5;
        this.f685h.gop = this.p.f785i;
        this.f685h.encoderProfile = this.p.n;
        TXSVideoEncoderParam tXSVideoEncoderParam = this.f685h;
        if (obj == null) {
            obj = bVar.a(i2, i3);
        }
        tXSVideoEncoderParam.glContext = obj;
        this.f685h.realTime = z2;
        this.f685h.streamType = this.E;
        this.f685h.annexb = this.G;
        this.f685h.bMultiRef = this.F;
        this.f685h.baseFrameIndex = this.I + 20;
        this.f685h.baseGopIndex = ((this.J + 1) % 255) + 1;
        this.f685h.bLimitFps = this.f684g;
        this.f685h.record = this.V;
        this.f685h.encFmt = this.p.Y;
        this.f685h.isHEVCEncoderEnabled = this.H;
        this.f685h.bitrate = this.p.f779c;
        bVar.a((e) this);
        bVar.a((com.tencent.liteav.basic.b.b) this);
        bVar.a(this.f685h);
        bVar.c(this.p.f779c);
        bVar.d(this.f687j);
        bVar.setID(getID());
        bVar.a(this.Z);
        this.f686i = bVar;
        TXCStatus.a(getID(), WearableStatusCodes.DATA_ITEM_TOO_LARGE, this.E, Integer.valueOf((this.f685h.width << 16) | this.f685h.height));
        TXCStatus.a(getID(), 13003, this.E, Integer.valueOf(this.f685h.gop * 1000));
        TXCEventRecorderProxy.a(getID(), WearableStatusCodes.DATA_ITEM_TOO_LARGE, (long) this.f685h.width, (long) this.f685h.height, "", this.E);
        TXCKeyPointReportProxy.a(40036, this.f685h.encodeType, this.E);
        TXCKeyPointReportProxy.a(40037, (this.f685h.width << 16) | this.f685h.height, this.E);
        AppMethodBeat.o(221675);
    }

    private void a(Object obj, int i2, boolean z2) {
        AppMethodBeat.i(221676);
        y();
        com.tencent.liteav.videoencoder.b bVar = new com.tencent.liteav.videoencoder.b(i2);
        TXCStatus.a(getID(), WearableStatusCodes.ASSET_UNAVAILABLE, 3, Integer.valueOf(i2));
        if (i2 == 1) {
            TXCEventRecorderProxy.a(getID(), WearableStatusCodes.INVALID_TARGET_NODE, 1, -1, "", 3);
        } else {
            TXCEventRecorderProxy.a(getID(), WearableStatusCodes.INVALID_TARGET_NODE, 0, -1, "", 3);
        }
        TXSVideoEncoderParam tXSVideoEncoderParam = this.l;
        if (obj == null) {
            obj = bVar.a(this.l.width, this.l.height);
        }
        tXSVideoEncoderParam.glContext = obj;
        this.l.encodeType = i2;
        this.l.realTime = z2;
        this.l.isHEVCEncoderEnabled = false;
        TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
        bVar.a((e) this);
        bVar.a((com.tencent.liteav.basic.b.b) this);
        bVar.a(this.l);
        bVar.c(this.l.bitrate);
        bVar.setID(getID());
        bVar.a(this.Z);
        this.m = bVar;
        TXCStatus.a(getID(), WearableStatusCodes.DATA_ITEM_TOO_LARGE, 3, Integer.valueOf((this.l.width << 16) | this.l.height));
        TXCStatus.a(getID(), 13003, 3, Integer.valueOf(this.l.gop * 1000));
        AppMethodBeat.o(221676);
    }

    private void a(int i2, int i3, int i4, long j2) {
        long j3;
        AppMethodBeat.i(221677);
        if (j2 == 0) {
            j3 = TXCTimeUtil.generatePtsMS();
        } else {
            j3 = j2;
        }
        b(i3, i4, this.f682e.a());
        com.tencent.liteav.videoencoder.b bVar = this.f686i;
        if (bVar != null) {
            bVar.a(i2, i3, i4, j3);
        }
        com.tencent.liteav.videoencoder.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.a(i2, i3, i4, j3);
        }
        AppMethodBeat.o(221677);
    }

    private int a(int i2, int i3, Object obj) {
        AppMethodBeat.i(221678);
        int i4 = this.p.f777a;
        int i5 = this.p.f778b;
        if (this.p.l == 0 || this.p.l == 2) {
            i4 = this.p.f778b;
            i5 = this.p.f777a;
        }
        if (i4 <= 0 || i5 <= 0) {
            TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
            AppMethodBeat.o(221678);
            return -1;
        } else if (this.p.M) {
            z();
            AppMethodBeat.o(221678);
            return -1000;
        } else {
            b(i4, i5, obj);
            AppMethodBeat.o(221678);
            return 0;
        }
    }

    private void b(int i2, int i3, Object obj) {
        int i4;
        int i5 = 2;
        AppMethodBeat.i(221679);
        switch (this.p.f786j) {
            case 1:
                i5 = 1;
                break;
            case 2:
                i5 = 3;
                break;
        }
        if (this.q == 1 && this.r == 0) {
            i4 = 1;
        } else {
            i4 = i5;
        }
        int i6 = this.p.f785i;
        if (!(this.f686i != null && !this.U && this.f685h.width == i2 && this.f685h.height == i3 && this.f685h.encodeType == i4 && this.f685h.gop == i6 && this.H == this.f685h.isHEVCEncoderEnabled)) {
            a(i2, i3, i4, obj, this.p.f784h, this.p.P);
        }
        if ((this.m == null || this.l.encodeType != i4) && this.k) {
            a(obj, i4, this.p.P);
        }
        AppMethodBeat.o(221679);
    }

    public void t() {
        AppMethodBeat.i(14407);
        AnonymousClass13 r0 = new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass13 */

            public void run() {
                AppMethodBeat.i(222650);
                d.g(d.this);
                d.i(d.this);
                AppMethodBeat.o(222650);
            }
        };
        k kVar = this.f681d;
        if (kVar != null) {
            kVar.a(r0);
            AppMethodBeat.o(14407);
            return;
        }
        synchronized (this.n) {
            try {
                r0.run();
            } finally {
                AppMethodBeat.o(14407);
            }
        }
    }

    public void u() {
        AppMethodBeat.i(221680);
        if (this.f686i == null) {
            AppMethodBeat.o(221680);
        } else if (this.f681d != null) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass14 */

                public void run() {
                    AppMethodBeat.i(222352);
                    d.g(d.this);
                    AppMethodBeat.o(222352);
                }
            });
            AppMethodBeat.o(221680);
        } else {
            z();
            AppMethodBeat.o(221680);
        }
    }

    public void v() {
        AppMethodBeat.i(221681);
        if (this.m == null) {
            AppMethodBeat.o(221681);
        } else if (this.f681d != null) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass15 */

                public void run() {
                    AppMethodBeat.i(221598);
                    d.i(d.this);
                    AppMethodBeat.o(221598);
                }
            });
            AppMethodBeat.o(221681);
        } else {
            y();
            AppMethodBeat.o(221681);
        }
    }

    private void y() {
        AppMethodBeat.i(221682);
        try {
            com.tencent.liteav.videoencoder.b bVar = this.m;
            this.m = null;
            if (bVar != null) {
                bVar.a();
                bVar.a((e) null);
            }
            AppMethodBeat.o(221682);
        } catch (Exception e2) {
            TXCLog.e("TXCCaptureAndEnc", "stop video encoder failed.", e2);
            AppMethodBeat.o(221682);
        }
    }

    private void z() {
        AppMethodBeat.i(221683);
        try {
            TXCLog.i("TXCCaptureAndEnc", "stopBigVideoEncoderInGLThread");
            com.tencent.liteav.videoencoder.b bVar = this.f686i;
            this.f686i = null;
            if (bVar != null) {
                bVar.a();
                bVar.a((e) null);
            }
            this.U = true;
            AppMethodBeat.o(221683);
        } catch (Exception e2) {
            TXCLog.e("TXCCaptureAndEnc", "stopBigVideoEncoder failed.", e2);
            AppMethodBeat.o(221683);
        }
    }

    private void l(final boolean z2) {
        AppMethodBeat.i(259855);
        if (this.f681d != null) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass16 */

                public void run() {
                    AppMethodBeat.i(259853);
                    k kVar = d.this.f681d;
                    if (kVar == null) {
                        AppMethodBeat.o(259853);
                        return;
                    }
                    kVar.f(d.this.p.f784h);
                    kVar.e(d.this.p.l);
                    kVar.a(d.this.p.k);
                    kVar.b(d.this.p.f777a, d.this.p.f778b);
                    kVar.e(d.this.p.U);
                    if (z2 && kVar.d()) {
                        kVar.b(false);
                    }
                    AppMethodBeat.o(259853);
                }
            });
        }
        AppMethodBeat.o(259855);
    }

    private void A() {
        AppMethodBeat.i(221685);
        if (this.f681d != null) {
            this.f681d.a(new Runnable() {
                /* class com.tencent.liteav.d.AnonymousClass17 */

                public void run() {
                    AppMethodBeat.i(222016);
                    d.a(d.this, d.this.f685h.width, d.this.f685h.height);
                    AppMethodBeat.o(222016);
                }
            });
        }
        AppMethodBeat.o(221685);
    }

    private void c(int i2, int i3) {
        com.tencent.liteav.beauty.d dVar;
        Bitmap bitmap;
        float f2;
        float f3;
        float width;
        AppMethodBeat.i(221686);
        if (this.p.J != -1.0f) {
            if (this.f682e != null) {
                dVar = this.f682e;
                bitmap = this.p.E;
                f2 = this.p.H;
                f3 = this.p.I;
                width = this.p.J;
            }
            AppMethodBeat.o(221686);
        }
        if (!(this.f682e == null || i2 == 0 || i3 == 0)) {
            dVar = this.f682e;
            bitmap = this.p.E;
            f2 = ((float) this.p.F) / ((float) i2);
            f3 = ((float) this.p.G) / ((float) i3);
            width = this.p.E == null ? 0.0f : ((float) this.p.E.getWidth()) / ((float) i2);
        }
        AppMethodBeat.o(221686);
        dVar.a(bitmap, f2, f3, width);
        AppMethodBeat.o(221686);
    }

    private void B() {
        AppMethodBeat.i(221687);
        if (this.f682e != null) {
            if (this.p.U) {
                this.f682e.a(d.EnumC0157d.MODE_SAME_AS_OUTPUT);
                AppMethodBeat.o(221687);
                return;
            } else if (this.p.T) {
                this.f682e.a(d.EnumC0157d.MODE_SAME_AS_INPUT);
                AppMethodBeat.o(221687);
                return;
            } else {
                this.f682e.a(d.EnumC0157d.MODE_THRESHOLD);
            }
        }
        AppMethodBeat.o(221687);
    }

    private void d(int i2, int i3) {
        AppMethodBeat.i(221688);
        c(i2, i3);
        AppMethodBeat.o(221688);
    }

    private void e(int i2, int i3) {
        AppMethodBeat.i(221689);
        if (!this.w) {
            Bundle bundle = new Bundle();
            bundle.putString("EVT_USERID", getID());
            bundle.putInt("EVT_ID", 2003);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "Renders the first video frame");
            bundle.putInt("EVT_PARAM1", i2);
            bundle.putInt("EVT_PARAM2", i3);
            com.tencent.liteav.basic.util.f.a(this.X, 2003, bundle);
            TXCLog.i("TXCCaptureAndEnc", "trtc_render render first frame " + getID() + ", " + this.E);
            this.w = true;
        }
        AppMethodBeat.o(221689);
    }

    private void a(com.tencent.liteav.basic.structs.b bVar, boolean z2) {
        AppMethodBeat.i(221690);
        e(bVar.f432e, bVar.f433f);
        this.D = bVar;
        if (this.x == null) {
            synchronized (this.y) {
                try {
                    if (!(this.z == null || this.C != null || this.f681d == null || this.f681d.f() == null)) {
                        this.C = new com.tencent.liteav.basic.c.e();
                        this.C.a(this.f681d.f(), this.z);
                        this.C.a(this.v);
                        this.C.b(this.aa);
                    }
                    if (!(this.C == null || this.f681d == null)) {
                        this.C.a(bVar.f428a, bVar.f436i, this.u, this.A, this.B, bVar.f432e, bVar.f433f, z2, this.f681d.l());
                    }
                } finally {
                    AppMethodBeat.o(221690);
                }
            }
        } else if (this.f681d != null) {
            this.f681d.a(bVar);
            AppMethodBeat.o(221690);
        } else {
            AppMethodBeat.o(221690);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int c(com.tencent.liteav.basic.structs.b r10) {
        /*
        // Method dump skipped, instructions count: 211
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.d.c(com.tencent.liteav.basic.structs.b):int");
    }

    private void d(com.tencent.liteav.basic.structs.b bVar) {
        int i2;
        com.tencent.liteav.beauty.b.o oVar;
        TXCGLSurfaceView gLSurfaceView;
        AppMethodBeat.i(221692);
        final WeakReference<o> weakReference = this.L;
        if (weakReference == null) {
            AppMethodBeat.o(221692);
            return;
        }
        int c2 = c(bVar);
        if (this.K == 2) {
            o oVar2 = weakReference.get();
            if (oVar2 != null) {
                TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                tXSVideoFrame.width = bVar.f432e;
                tXSVideoFrame.height = bVar.f433f;
                tXSVideoFrame.textureId = c2;
                tXSVideoFrame.eglContext = this.f682e.a();
                tXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
                oVar2.onRenderVideoFrame(getID(), this.E, tXSVideoFrame);
                if (this.M) {
                    bVar.f428a = tXSVideoFrame.textureId;
                }
            }
        } else if (this.K == 1 || this.K == 4) {
            if (this.O == null) {
                if (this.K == 1) {
                    oVar = new com.tencent.liteav.beauty.b.o(1);
                } else {
                    oVar = new com.tencent.liteav.beauty.b.o(3);
                }
                oVar.a(true);
                if (oVar.a()) {
                    oVar.a(bVar.f432e, bVar.f433f);
                    oVar.a(new h.a() {
                        /* class com.tencent.liteav.d.AnonymousClass18 */

                        @Override // com.tencent.liteav.basic.c.h.a
                        public void a(int i2) {
                            AppMethodBeat.i(259858);
                            h hVar = d.this.O;
                            o oVar = (o) weakReference.get();
                            if (!(hVar == null || oVar == null)) {
                                TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
                                tXSVideoFrame.width = hVar.n();
                                tXSVideoFrame.height = hVar.o();
                                tXSVideoFrame.pts = TXCTimeUtil.generatePtsMS();
                                oVar.onRenderVideoFrame(d.this.getID(), d.this.E, tXSVideoFrame);
                                d.this.S = tXSVideoFrame.data;
                            }
                            AppMethodBeat.o(259858);
                        }
                    });
                    this.O = oVar;
                } else {
                    TXCLog.i("TXCCaptureAndEnc", "init filter error ");
                    this.O = null;
                }
            }
            h hVar = this.O;
            if (hVar != null) {
                GLES20.glViewport(0, 0, bVar.f432e, bVar.f433f);
                hVar.a(bVar.f432e, bVar.f433f);
                hVar.b(c2);
            }
            if (this.M && this.S != null) {
                if (this.K == 1) {
                    i2 = 1;
                } else if (this.K == 4) {
                    i2 = 3;
                } else {
                    i2 = 1;
                }
                if (this.R == null) {
                    k kVar = new k(i2);
                    kVar.a(true);
                    if (!kVar.a()) {
                        TXCLog.w("TXCCaptureAndEnc", " init i420ToRGBA filter failed");
                    }
                    kVar.a(bVar.f432e, bVar.f433f);
                    this.R = kVar;
                }
                k kVar2 = this.R;
                if (kVar2 != null) {
                    GLES20.glViewport(0, 0, bVar.f432e, bVar.f433f);
                    kVar2.a(bVar.f432e, bVar.f433f);
                    kVar2.a(this.S);
                    bVar.f428a = kVar2.q();
                }
                this.S = null;
            }
        }
        if (!(!this.M || this.x == null || (gLSurfaceView = this.x.getGLSurfaceView()) == null)) {
            gLSurfaceView.d();
        }
        AppMethodBeat.o(221692);
    }

    public void a(float f2, float f3) {
        AppMethodBeat.i(221693);
        if (this.f681d != null && this.p.K) {
            this.f681d.a(f2, f3);
        }
        AppMethodBeat.o(221693);
    }

    public void n(int i2) {
        int i3;
        final int i4 = 2;
        AppMethodBeat.i(221694);
        if (i2 <= 0) {
            i3 = 1;
        } else {
            i3 = i2;
        }
        if (i3 <= 2) {
            i4 = i3;
        }
        AnonymousClass19 r1 = new Runnable() {
            /* class com.tencent.liteav.d.AnonymousClass19 */

            public void run() {
                AppMethodBeat.i(222389);
                if (d.this.f685h.encoderMode == i4) {
                    AppMethodBeat.o(222389);
                    return;
                }
                d.this.f685h.encoderMode = i4;
                d.this.l.encoderMode = i4;
                d.g(d.this);
                d.i(d.this);
                AppMethodBeat.o(222389);
            }
        };
        if (this.f681d == null) {
            r1.run();
            AppMethodBeat.o(221694);
            return;
        }
        this.f681d.a(r1);
        AppMethodBeat.o(221694);
    }

    private void a(Runnable runnable) {
        AppMethodBeat.i(221695);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f680c.a(runnable);
            AppMethodBeat.o(221695);
            return;
        }
        runnable.run();
        AppMethodBeat.o(221695);
    }
}
