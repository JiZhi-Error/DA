package com.tencent.mm.plugin.thumbplayer.c;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.k.c;
import com.tencent.mm.plugin.xlabeffect.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.xeffect.VLogDirector;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.ad;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

public final class a {
    private static final int Ghk = Color.parseColor("#4c4c4c");
    public static final C1834a Ghl = new C1834a((byte) 0);
    private VLogDirector AsI = new VLogDirector();
    private boolean AsJ;
    public b GgO;
    private com.tencent.mm.media.g.d GgP;
    private SurfaceTexture GgQ;
    private com.tencent.mm.media.j.b.e GgR;
    private com.tencent.mm.media.g.d GgS;
    private boolean GgT;
    private int GgU;
    private int GgV;
    private com.tencent.mm.xeffect.effect.l GgW;
    private com.tencent.mm.xeffect.effect.b GgX;
    private ArrayList<com.tencent.mm.plugin.thumbplayer.d.a> GgY = new ArrayList<>();
    public com.tencent.mm.plugin.thumbplayer.d.a GgZ;
    private int Gha = -1;
    public long Ghb = -1;
    private long Ghc = -1;
    private long Ghd = -1;
    private boolean Ghe;
    private float Ghf = -1.0f;
    private kotlin.g.a.b<? super Long, x> Ghg;
    private volatile boolean Ghh;
    private volatile boolean Ghi;
    private kotlin.g.a.b<? super Bitmap, x> Ghj;
    public final String TAG = ("MicroMsg.TPPlayerEffector@" + hashCode());
    public com.tencent.mm.plugin.thumbplayer.d.c Vfv = new com.tencent.mm.plugin.thumbplayer.d.c();
    private MMHandler handler;
    private HandlerThread handlerThread;
    private volatile int height;
    private c.b ilw;
    public int scaleType = 1;
    public volatile int videoHeight;
    public volatile int videoWidth;
    public EffectManager wet;
    private volatile int width;
    private SurfaceTexture zCV;

    public interface b {
        long fwR();
    }

    public static final class j extends q implements kotlin.g.a.b<com.tencent.mm.plugin.thumbplayer.e.b, x> {
        final /* synthetic */ a Ghm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar) {
            super(1);
            this.Ghm = aVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.thumbplayer.e.b bVar) {
            long j2;
            int i2;
            int i3;
            boolean z = false;
            AppMethodBeat.i(259990);
            com.tencent.mm.plugin.thumbplayer.e.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.thumbplayer.e.a aVar = bVar2.wdC;
            if (aVar != null) {
                j2 = aVar.getPropertyLong(205);
            } else {
                j2 = 0;
            }
            com.tencent.mm.plugin.thumbplayer.e.a aVar2 = bVar2.wdC;
            if (aVar2 != null) {
                i2 = aVar2.getVideoWidth();
            } else {
                i2 = 0;
            }
            com.tencent.mm.plugin.thumbplayer.e.a aVar3 = bVar2.wdC;
            if (aVar3 != null) {
                i3 = aVar3.getVideoHeight();
            } else {
                i3 = 0;
            }
            this.Ghm.GgZ = bVar2.Ghy;
            com.tencent.mm.plugin.thumbplayer.d.a aVar4 = this.Ghm.GgZ;
            if (aVar4 != null) {
                aVar4.width = i2;
            }
            com.tencent.mm.plugin.thumbplayer.d.a aVar5 = this.Ghm.GgZ;
            if (aVar5 != null) {
                aVar5.height = i3;
            }
            this.Ghm.videoWidth = i2;
            this.Ghm.videoHeight = i3;
            com.tencent.mm.plugin.thumbplayer.d.a aVar6 = this.Ghm.GgZ;
            if (aVar6 != null) {
                aVar6.dYT = (int) j2;
            }
            if (!this.Ghm.GgY.isEmpty()) {
                z = true;
            }
            if (z) {
                this.Ghm.Gha = kotlin.a.j.a((List) this.Ghm.GgY, (Object) this.Ghm.GgZ);
            }
            Log.i(this.Ghm.TAG, "onPlayStarted player width:" + i2 + ", height:" + i3 + ", rotate: " + j2 + ", currentMediaInfoIndex:" + this.Ghm.Gha + ", playerPosition:" + bVar2.getCurrentPositionMs());
            x xVar = x.SXb;
            AppMethodBeat.o(259990);
            return xVar;
        }
    }

    public a() {
        AppMethodBeat.i(238669);
        AppMethodBeat.o(238669);
    }

    /* renamed from: com.tencent.mm.plugin.thumbplayer.c.a$a */
    public static final class C1834a {
        private C1834a() {
        }

        public /* synthetic */ C1834a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(238670);
        b.a aVar = com.tencent.mm.plugin.xlabeffect.b.JRv;
        b.a.tryLoadLibrary();
        AppMethodBeat.o(238670);
    }

    public static final class i<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            AppMethodBeat.i(238653);
            int a2 = kotlin.b.a.a(Long.valueOf(t.Ghu), Long.valueOf(t2.Ghu));
            AppMethodBeat.o(238653);
            return a2;
        }
    }

    public final void aq(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(258222);
        Log.i(this.TAG, "init without surfaceTexture");
        if (this.ilw == null) {
            Log.i(this.TAG, "createEGLThread");
            HandlerThread hz = com.tencent.f.c.d.hz("TPPlayerEffector", -4);
            hz.start();
            this.handler = new MMHandler(hz.getLooper());
            this.handlerThread = hz;
            k(new d(this));
            k(new f(this, aVar));
        }
        this.Ghc = -1;
        AppMethodBeat.o(258222);
    }

    public final void m(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(238655);
        p.h(surfaceTexture, "surface");
        Log.i(this.TAG, "attachSurface:" + surfaceTexture.hashCode());
        c.b bVar = this.ilw;
        if (bVar != null) {
            k(new c(bVar, this, surfaceTexture));
            AppMethodBeat.o(238655);
            return;
        }
        a aVar = this;
        Log.i(aVar.TAG, "attach surface current not create GLEnvironment now");
        aVar.zCV = surfaceTexture;
        AppMethodBeat.o(238655);
    }

    public final void M(kotlin.g.a.b<? super Long, x> bVar) {
        AppMethodBeat.i(238656);
        p.h(bVar, "callback");
        this.Ghg = bVar;
        AppMethodBeat.o(238656);
    }

    public final void fwM() {
        AppMethodBeat.i(238658);
        fwO();
        EffectManager effectManager = this.wet;
        if (effectManager != null) {
            effectManager.hiv();
        }
        EffectManager effectManager2 = this.wet;
        ad a2 = effectManager2 != null ? effectManager2.a(com.tencent.mm.xeffect.effect.j.BlurEffect) : null;
        if (a2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.BlurEffect");
            AppMethodBeat.o(238658);
            throw tVar;
        }
        this.GgX = (com.tencent.mm.xeffect.effect.b) a2;
        com.tencent.mm.xeffect.effect.b bVar = this.GgX;
        if (bVar != null) {
            bVar.setRadius(3.5f);
        }
        this.Ghe = false;
        EffectManager effectManager3 = this.wet;
        if (effectManager3 != null) {
            effectManager3.a(this.GgX);
            AppMethodBeat.o(238658);
            return;
        }
        AppMethodBeat.o(238658);
    }

    public final void fwN() {
        AppMethodBeat.i(238659);
        fwO();
        EffectManager effectManager = this.wet;
        if (effectManager != null) {
            effectManager.hiv();
            AppMethodBeat.o(238659);
            return;
        }
        AppMethodBeat.o(238659);
    }

    private final void fwO() {
        AppMethodBeat.i(238660);
        if (this.wet == null) {
            this.wet = new EffectManager();
        }
        AppMethodBeat.o(238660);
    }

    public final void hI(List<com.tencent.mm.plugin.thumbplayer.d.a> list) {
        int i2 = 0;
        AppMethodBeat.i(238661);
        p.h(list, "mediaInfoList");
        this.GgY.clear();
        this.GgY.addAll(list);
        this.Ghb = 0;
        for (T t : this.GgY) {
            if (t.Ghw > t.pLQ) {
                t.Ghw = 0;
            }
            this.Ghb += t.Ghv;
        }
        ArrayList<com.tencent.mm.plugin.thumbplayer.d.a> arrayList = this.GgY;
        if (arrayList.size() > 1) {
            kotlin.a.j.a((List) arrayList, (Comparator) new i());
        }
        this.GgZ = this.GgY.get(0);
        this.Gha = 0;
        com.tencent.mm.plugin.thumbplayer.d.a aVar = this.GgZ;
        this.videoWidth = aVar != null ? aVar.width : 0;
        com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.GgZ;
        if (aVar2 != null) {
            i2 = aVar2.height;
        }
        this.videoHeight = i2;
        Log.i(this.TAG, "setEffectByMediaList, totalDurationMs:" + this.Ghb);
        this.Ghf = 0.42f;
        kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new l(this, null), 2);
        AppMethodBeat.o(238661);
    }

    public final void L(kotlin.g.a.b<? super SurfaceTexture, x> bVar) {
        AppMethodBeat.i(258223);
        k(new e(this, bVar));
        AppMethodBeat.o(258223);
    }

    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Ghm;
        final /* synthetic */ kotlin.g.a.b Gho;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(a aVar, kotlin.g.a.b bVar) {
            super(0);
            this.Ghm = aVar;
            this.Gho = bVar;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.thumbplayer.c.a$e$a */
        public static final class C1835a implements SurfaceTexture.OnFrameAvailableListener {
            final /* synthetic */ e Ghp;

            C1835a(e eVar) {
                this.Ghp = eVar;
            }

            public final void onFrameAvailable(final SurfaceTexture surfaceTexture) {
                AppMethodBeat.i(238646);
                Looper myLooper = Looper.myLooper();
                MMHandler mMHandler = this.Ghp.Ghm.handler;
                if (p.j(myLooper, mMHandler != null ? mMHandler.getLooper() : null)) {
                    try {
                        surfaceTexture.updateTexImage();
                    } catch (Exception e2) {
                        Log.printErrStackTrace(this.Ghp.Ghm.TAG, e2, "updateTexImage error", new Object[0]);
                    }
                    a aVar = this.Ghp.Ghm;
                    p.g(surfaceTexture, "surface");
                    a.a(aVar, surfaceTexture.getTimestamp());
                    AppMethodBeat.o(238646);
                    return;
                }
                this.Ghp.Ghm.k(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.thumbplayer.c.a.e.C1835a.AnonymousClass1 */
                    final /* synthetic */ C1835a Ghq;

                    {
                        this.Ghq = r2;
                    }

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(238645);
                        try {
                            surfaceTexture.updateTexImage();
                        } catch (Exception e2) {
                            Log.printErrStackTrace(this.Ghq.Ghp.Ghm.TAG, e2, "updateTexImage error", new Object[0]);
                        }
                        a aVar = this.Ghq.Ghp.Ghm;
                        SurfaceTexture surfaceTexture = surfaceTexture;
                        p.g(surfaceTexture, "surface");
                        a.a(aVar, surfaceTexture.getTimestamp());
                        x xVar = x.SXb;
                        AppMethodBeat.o(238645);
                        return xVar;
                    }
                });
                AppMethodBeat.o(238646);
            }
        }

        static final class b implements Runnable {
            final /* synthetic */ e Ghp;

            b(e eVar) {
                this.Ghp = eVar;
            }

            public final void run() {
                AppMethodBeat.i(238647);
                kotlin.g.a.b bVar = this.Ghp.Gho;
                if (bVar != null) {
                    bVar.invoke(this.Ghp.Ghm.GgQ);
                    AppMethodBeat.o(238647);
                    return;
                }
                AppMethodBeat.o(238647);
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238648);
            Log.i(this.Ghm.TAG, "createVideoTexture");
            com.tencent.mm.media.g.d dVar = this.Ghm.GgP;
            if (dVar != null) {
                dVar.close();
            }
            this.Ghm.GgP = new com.tencent.mm.media.g.d(false, 15);
            com.tencent.mm.media.g.d dVar2 = this.Ghm.GgP;
            if (dVar2 != null) {
                if (dVar2.igv > 0) {
                    this.Ghm.GgQ = new SurfaceTexture(dVar2.igv);
                    SurfaceTexture surfaceTexture = this.Ghm.GgQ;
                    if (surfaceTexture != null) {
                        surfaceTexture.setOnFrameAvailableListener(new C1835a(this));
                    }
                    com.tencent.f.h.RTc.aV(new b(this));
                } else {
                    Log.e(this.Ghm.TAG, "create videoPlayTexture error texID:" + dVar2.igv);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238648);
            return xVar;
        }
    }

    private final long KF(long j2) {
        long j3 = 0;
        AppMethodBeat.i(238663);
        if (this.GgY.size() > 0) {
            com.tencent.mm.plugin.thumbplayer.d.a aVar = this.GgZ;
            if (aVar != null) {
                j3 = 0 + (j2 - aVar.Ghw);
                com.tencent.mm.plugin.thumbplayer.d.a aVar2 = this.GgZ;
                this.videoWidth = aVar2 != null ? aVar2.width : 0;
                com.tencent.mm.plugin.thumbplayer.d.a aVar3 = this.GgZ;
                this.videoHeight = aVar3 != null ? aVar3.height : 0;
            }
            int i2 = this.Gha;
            long j4 = j3;
            for (int i3 = 0; i3 < i2; i3++) {
                j4 += this.GgY.get(i3).Ghv;
            }
            if (j4 > this.Ghb) {
                b bVar = this.GgO;
                Log.i(this.TAG, "accumulateTimestamp exceed totalDuration, accumulateTimestamp:" + j4 + ", totalDurationMs:" + this.Ghb + ", timestampMs:" + j2 + ", index:" + this.Gha + ", mediaInfo:" + this.GgY.get(this.Gha) + ", playPositionMs:" + (bVar != null ? bVar.fwR() : -1));
            }
            AppMethodBeat.o(238663);
            return j4;
        }
        AppMethodBeat.o(238663);
        return j2;
    }

    public static final class g implements Runnable {
        final /* synthetic */ a Ghm;
        final /* synthetic */ Bitmap cKG;

        g(a aVar, Bitmap bitmap) {
            this.Ghm = aVar;
            this.cKG = bitmap;
        }

        public final void run() {
            AppMethodBeat.i(238650);
            kotlin.g.a.b bVar = this.Ghm.Ghj;
            if (bVar != null) {
                bVar.invoke(this.cKG);
                AppMethodBeat.o(238650);
                return;
            }
            AppMethodBeat.o(238650);
        }
    }

    public final void j(com.tencent.mm.plugin.thumbplayer.e.b bVar) {
        AppMethodBeat.i(259995);
        p.h(bVar, "player");
        bVar.VfN = new j(this);
        AppMethodBeat.o(259995);
    }

    public final void jj(int i2, int i3) {
        AppMethodBeat.i(238665);
        if (!(i2 == this.width && i3 == this.height)) {
            this.AsJ = true;
        }
        this.width = i2;
        this.height = i3;
        Log.i(this.TAG, "updateSize:[" + i2 + ',' + i3 + "], outputSizeChanged:" + this.AsJ + ", surface:" + this.zCV);
        if (this.AsJ) {
            if (this.width > this.height && this.width > 1080) {
                this.GgU = 1080;
                this.GgV = (int) (((float) this.GgU) * ((((float) this.height) * 1.0f) / ((float) this.width)));
            } else if (this.height <= this.width || this.height <= 1920) {
                this.GgU = this.width;
                this.GgV = this.height;
            } else {
                this.GgV = 1920;
                this.GgU = (int) (((float) this.GgV) * ((((float) this.width) * 1.0f) / ((float) this.height)));
            }
            Log.i(this.TAG, "calcOutputTexSize:[" + this.GgU + ',' + this.GgV + ']');
        }
        AppMethodBeat.o(238665);
    }

    public final void k(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(238666);
        p.h(aVar, "r");
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.post(new b(aVar));
            AppMethodBeat.o(238666);
            return;
        }
        AppMethodBeat.o(238666);
    }

    public final void ac(kotlin.g.a.b<? super Bitmap, x> bVar) {
        AppMethodBeat.i(259997);
        p.h(bVar, "callback");
        this.Ghj = bVar;
        this.Ghi = true;
        Log.i(this.TAG, "request snapshot");
        AppMethodBeat.o(259997);
    }

    public final void hXB() {
        AppMethodBeat.i(259998);
        this.Ghj = null;
        this.Ghi = false;
        Log.i(this.TAG, "reset snapshot");
        AppMethodBeat.o(259998);
    }

    private final void fwQ() {
        AppMethodBeat.i(238667);
        MMHandler mMHandler = this.handler;
        if (mMHandler != null) {
            mMHandler.removeCallbacksAndMessages(null);
            AppMethodBeat.o(238667);
            return;
        }
        AppMethodBeat.o(238667);
    }

    public final void release() {
        AppMethodBeat.i(238668);
        fwQ();
        k(new h(this));
        AppMethodBeat.o(238668);
    }

    public static final class l extends kotlin.d.b.a.j implements m<ai, kotlin.d.d<? super x>, Object> {
        final /* synthetic */ a Ghm;
        int label;
        private ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(a aVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.Ghm = aVar;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(259993);
            p.h(dVar, "completion");
            l lVar = new l(this.Ghm, dVar);
            lVar.p$ = (ai) obj;
            AppMethodBeat.o(259993);
            return lVar;
        }

        @Override // kotlin.g.a.m
        public final Object invoke(ai aiVar, kotlin.d.d<? super x> dVar) {
            AppMethodBeat.i(259994);
            Object invokeSuspend = ((l) create(aiVar, dVar)).invokeSuspend(x.SXb);
            AppMethodBeat.o(259994);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(259992);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    a.v(this.Ghm);
                    x xVar = x.SXb;
                    AppMethodBeat.o(259992);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(259992);
                    throw illegalStateException;
            }
        }
    }

    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Ghm;
        final /* synthetic */ kotlin.g.a.a JRN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar, kotlin.g.a.a aVar2) {
            super(0);
            this.Ghm = aVar;
            this.JRN = aVar2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238649);
            a.m(this.Ghm);
            this.Ghm.AsI = new VLogDirector();
            this.Ghm.AsI.init();
            String str = this.Ghm.TAG;
            StringBuilder sb = new StringBuilder("finished init and set effectManager, effectManager.nPtr:");
            EffectManager effectManager = this.Ghm.wet;
            Log.i(str, sb.append(effectManager != null ? Long.valueOf(effectManager.Rxd) : null).toString());
            this.Ghm.Ghh = true;
            SurfaceTexture surfaceTexture = this.Ghm.zCV;
            if (surfaceTexture != null) {
                this.Ghm.m(surfaceTexture);
            }
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.thumbplayer.c.a.f.AnonymousClass1 */
                final /* synthetic */ f JRO;

                {
                    this.JRO = r1;
                }

                public final void run() {
                    AppMethodBeat.i(258221);
                    kotlin.g.a.a aVar = this.JRO.JRN;
                    if (aVar != null) {
                        aVar.invoke();
                        AppMethodBeat.o(258221);
                        return;
                    }
                    AppMethodBeat.o(258221);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(238649);
            return xVar;
        }
    }

    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Ghm;
        final /* synthetic */ SurfaceTexture Ghn;
        final /* synthetic */ c.b ifZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(c.b bVar, a aVar, SurfaceTexture surfaceTexture) {
            super(0);
            this.ifZ = bVar;
            this.Ghm = aVar;
            this.Ghn = surfaceTexture;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238643);
            if (this.Ghm.zCV != null) {
                a.g(this.Ghm);
            }
            Log.i(this.Ghm.TAG, "do attachSurface:" + this.Ghn.hashCode());
            this.Ghm.zCV = this.Ghn;
            a aVar = this.Ghm;
            c.a aVar2 = com.tencent.mm.media.k.c.ilt;
            aVar.ilw = c.a.a(this.ifZ.ilv, this.ifZ.ilu, new Surface(this.Ghn));
            x xVar = x.SXb;
            AppMethodBeat.o(238643);
            return xVar;
        }
    }

    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Ghm;
        final /* synthetic */ SurfaceTexture wpW = null;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar) {
            super(0);
            this.Ghm = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238644);
            if (this.wpW != null) {
                this.Ghm.ilw = c.a.a(com.tencent.mm.media.k.c.ilt, new Surface(this.wpW), 0, 0, null, 28);
            } else {
                a aVar = this.Ghm;
                c.a aVar2 = com.tencent.mm.media.k.c.ilt;
                aVar.ilw = c.a.aNa();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(238644);
            return xVar;
        }
    }

    public static final class k extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Ghm;
        final /* synthetic */ long Vfw = -1;
        final /* synthetic */ SurfaceTexture wpW;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(SurfaceTexture surfaceTexture, a aVar) {
            super(0);
            this.wpW = surfaceTexture;
            this.Ghm = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            long timestamp;
            AppMethodBeat.i(259991);
            Log.i(this.Ghm.TAG, "do refreshFrame, timestamp:" + this.wpW.getTimestamp() + ' ' + this.Vfw);
            a aVar = this.Ghm;
            if (this.Vfw >= 0) {
                timestamp = this.Vfw;
            } else {
                timestamp = this.wpW.getTimestamp();
            }
            a.a(aVar, timestamp);
            x xVar = x.SXb;
            AppMethodBeat.o(259991);
            return xVar;
        }
    }

    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ a Ghm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(a aVar) {
            super(0);
            this.Ghm = aVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(238651);
            Log.i(this.Ghm.TAG, "release");
            this.Ghm.GgT = false;
            com.tencent.mm.media.g.d dVar = this.Ghm.GgP;
            if (dVar != null) {
                dVar.close();
            }
            this.Ghm.GgP = null;
            EffectManager effectManager = this.Ghm.wet;
            if (effectManager != null) {
                effectManager.hiv();
            }
            this.Ghm.AsI.destroy();
            com.tencent.mm.media.g.d dVar2 = this.Ghm.GgS;
            if (dVar2 != null) {
                dVar2.close();
            }
            com.tencent.mm.media.j.b.e eVar = this.Ghm.GgR;
            if (eVar != null) {
                eVar.release();
            }
            c.b bVar = this.Ghm.ilw;
            if (bVar != null) {
                c.a aVar = com.tencent.mm.media.k.c.ilt;
                c.a.a(bVar);
            }
            this.Ghm.ilw = null;
            HandlerThread handlerThread = this.Ghm.handlerThread;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
            this.Ghm.handlerThread = null;
            this.Ghm.handler = null;
            SurfaceTexture surfaceTexture = this.Ghm.zCV;
            if (surfaceTexture != null) {
                surfaceTexture.release();
            }
            this.Ghm.Ghh = false;
            this.Ghm.Ghc = -1;
            this.Ghm.Ghd = -1;
            EffectManager effectManager2 = this.Ghm.wet;
            if (effectManager2 != null) {
                effectManager2.destroy();
            }
            this.Ghm.wet = null;
            x xVar = x.SXb;
            AppMethodBeat.o(238651);
            return xVar;
        }
    }

    public static /* synthetic */ void a(a aVar) {
        com.tencent.mm.xeffect.effect.i iVar;
        com.tencent.mm.xeffect.effect.i iVar2;
        Long l2 = null;
        AppMethodBeat.i(238657);
        aVar.fwO();
        EffectManager effectManager = aVar.wet;
        if (effectManager != null) {
            effectManager.hiv();
        }
        EffectManager effectManager2 = aVar.wet;
        ad a2 = effectManager2 != null ? effectManager2.a(com.tencent.mm.xeffect.effect.j.GradientBlurEffect) : null;
        if (a2 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.GradientBlurEffect");
            AppMethodBeat.o(238657);
            throw tVar;
        }
        aVar.GgW = (com.tencent.mm.xeffect.effect.l) a2;
        com.tencent.mm.xeffect.effect.l lVar = aVar.GgW;
        if (lVar != null) {
            lVar.setRadius(20.0f);
        }
        com.tencent.mm.xeffect.effect.l lVar2 = aVar.GgW;
        if (lVar2 != null) {
            lVar2.aH(0, aVar.Ghb);
        }
        com.tencent.mm.xeffect.effect.l lVar3 = aVar.GgW;
        if (lVar3 != null) {
            lVar3.hix();
        }
        EffectManager effectManager3 = aVar.wet;
        if (effectManager3 != null) {
            effectManager3.a(aVar.GgW);
        }
        aVar.Ghf = -1.0f;
        aVar.Ghe = true;
        String str = aVar.TAG;
        StringBuilder sb = new StringBuilder("setGradientBlurEffect, timeRange:[");
        com.tencent.mm.xeffect.effect.l lVar4 = aVar.GgW;
        StringBuilder append = sb.append((lVar4 == null || (iVar2 = lVar4.RyZ) == null) ? null : Long.valueOf(iVar2.start)).append(", ");
        com.tencent.mm.xeffect.effect.l lVar5 = aVar.GgW;
        if (!(lVar5 == null || (iVar = lVar5.RyZ) == null)) {
            l2 = Long.valueOf(iVar.boX);
        }
        Log.i(str, append.append(l2).append(", contentOffsetPercent:-1.0]").toString());
        AppMethodBeat.o(238657);
    }

    public static /* synthetic */ void u(a aVar) {
        AppMethodBeat.i(259996);
        SurfaceTexture surfaceTexture = aVar.zCV;
        if (surfaceTexture != null) {
            aVar.k(new k(surfaceTexture, aVar));
            AppMethodBeat.o(259996);
            return;
        }
        AppMethodBeat.o(259996);
    }

    public static final /* synthetic */ void m(a aVar) {
        AppMethodBeat.i(238673);
        aVar.GgS = new com.tencent.mm.media.g.d(true, 15);
        aVar.GgR = new com.tencent.mm.media.j.b.e(0, 0, 0, 0, 1, 1, 12);
        AppMethodBeat.o(238673);
    }

    public static final /* synthetic */ void g(a aVar) {
        AppMethodBeat.i(238671);
        c.b bVar = aVar.ilw;
        if (bVar != null) {
            Log.i(aVar.TAG, "do detachSurface");
            c.a aVar2 = com.tencent.mm.media.k.c.ilt;
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            p.g(eGLSurface, "EGL14.EGL_NO_SURFACE");
            c.a.a(bVar, eGLSurface);
            bVar.eglSurface = EGL14.EGL_NO_SURFACE;
            AppMethodBeat.o(238671);
            return;
        }
        AppMethodBeat.o(238671);
    }

    public static final /* synthetic */ void v(a aVar) {
        com.tencent.mm.xeffect.effect.i iVar;
        com.tencent.mm.xeffect.effect.i iVar2;
        com.tencent.mm.xeffect.effect.i iVar3;
        com.tencent.mm.xeffect.effect.i iVar4;
        AppMethodBeat.i(259999);
        Log.i(aVar.TAG, "setBlurFadeEffectChain");
        long currentTicks = Util.currentTicks();
        aVar.fwO();
        Log.i(aVar.TAG, "checkCreateEffectManager cost:" + Util.ticksToNow(currentTicks));
        EffectManager effectManager = aVar.wet;
        if (effectManager != null) {
            effectManager.hiv();
        }
        Log.i(aVar.TAG, "clearEffect cost:" + Util.ticksToNow(currentTicks));
        EffectManager effectManager2 = aVar.wet;
        ad a2 = effectManager2 != null ? effectManager2.a(com.tencent.mm.xeffect.effect.j.GradientBlurEffect) : null;
        if (!(a2 instanceof com.tencent.mm.xeffect.effect.l)) {
            a2 = null;
        }
        aVar.GgW = (com.tencent.mm.xeffect.effect.l) a2;
        com.tencent.mm.xeffect.effect.l lVar = aVar.GgW;
        if (lVar != null) {
            lVar.setRadius(20.0f);
        }
        com.tencent.mm.xeffect.effect.l lVar2 = aVar.GgW;
        if (lVar2 != null) {
            lVar2.aH(0, aVar.Ghb);
        }
        com.tencent.mm.xeffect.effect.l lVar3 = aVar.GgW;
        if (lVar3 != null) {
            lVar3.hix();
        }
        EffectManager effectManager3 = aVar.wet;
        if (effectManager3 != null) {
            effectManager3.a(aVar.GgW);
        }
        Log.i(aVar.TAG, "gradientBlurContentOffsetPercent:" + aVar.Ghf + ", cost:" + Util.ticksToNow(currentTicks));
        int size = aVar.GgY.size() - 1;
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.mm.plugin.thumbplayer.d.a aVar2 = aVar.GgY.get(i2);
            p.g(aVar2, "mediaInfoList[i]");
            com.tencent.mm.plugin.thumbplayer.d.a aVar3 = aVar2;
            com.tencent.mm.plugin.thumbplayer.d.a aVar4 = aVar.GgY.get(i2 + 1);
            p.g(aVar4, "mediaInfoList[i + 1]");
            com.tencent.mm.plugin.thumbplayer.d.a aVar5 = aVar4;
            if (!aVar3.Ght) {
                EffectManager effectManager4 = aVar.wet;
                ad a3 = effectManager4 != null ? effectManager4.a(com.tencent.mm.xeffect.effect.j.FadeEffect) : null;
                if (!(a3 instanceof com.tencent.mm.xeffect.effect.k)) {
                    a3 = null;
                }
                com.tencent.mm.xeffect.effect.k kVar = (com.tencent.mm.xeffect.effect.k) a3;
                if (kVar != null) {
                    kVar.aE(1.0f, 0.1f);
                }
                if (kVar != null) {
                    kVar.aH(Math.max(0L, (aVar3.Ghu + aVar3.Ghv) - 1000), Math.max(0L, aVar3.Ghu + aVar3.Ghv));
                }
                if (kVar != null) {
                    kVar.aqr(Ghk);
                }
                Log.i(aVar.TAG, "set FadeOut time:[" + ((kVar == null || (iVar4 = kVar.RyZ) == null) ? null : Long.valueOf(iVar4.start)) + ',' + ((kVar == null || (iVar3 = kVar.RyZ) == null) ? null : Long.valueOf(iVar3.boX)) + ']');
                EffectManager effectManager5 = aVar.wet;
                if (effectManager5 != null) {
                    effectManager5.a(kVar);
                }
            }
            if (!aVar5.Ght) {
                EffectManager effectManager6 = aVar.wet;
                ad a4 = effectManager6 != null ? effectManager6.a(com.tencent.mm.xeffect.effect.j.FadeEffect) : null;
                if (!(a4 instanceof com.tencent.mm.xeffect.effect.k)) {
                    a4 = null;
                }
                com.tencent.mm.xeffect.effect.k kVar2 = (com.tencent.mm.xeffect.effect.k) a4;
                if (kVar2 != null) {
                    kVar2.aE(0.1f, 1.0f);
                }
                if (kVar2 != null) {
                    kVar2.aH(Math.max(0L, aVar5.Ghu), Math.max(0L, aVar5.Ghu + 1000));
                }
                if (kVar2 != null) {
                    kVar2.aqr(Ghk);
                }
                Log.i(aVar.TAG, "set FadeIn time:[" + ((kVar2 == null || (iVar2 = kVar2.RyZ) == null) ? null : Long.valueOf(iVar2.start)) + ',' + ((kVar2 == null || (iVar = kVar2.RyZ) == null) ? null : Long.valueOf(iVar.boX)) + ']');
                EffectManager effectManager7 = aVar.wet;
                if (effectManager7 != null) {
                    effectManager7.a(kVar2);
                }
            }
        }
        aVar.Ghe = true;
        Log.i(aVar.TAG, "finished setBlurFadeEffectChain cost:" + Util.ticksToNow(currentTicks));
        AppMethodBeat.o(259999);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0377  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0481  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x015b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.thumbplayer.c.a r21, long r22) {
        /*
        // Method dump skipped, instructions count: 1171
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.thumbplayer.c.a.a(com.tencent.mm.plugin.thumbplayer.c.a, long):void");
    }
}
