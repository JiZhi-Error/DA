package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Paint;
import android.webkit.ValueCallback;
import com.github.henryye.nativeiv.BaseImageDecodeService;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.b.b;
import com.tencent.luggage.game.b.b;
import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.aj;
import com.tencent.magicbrush.g;
import com.tencent.magicbrush.handler.glfont.IMBFontHandler;
import com.tencent.magicbrush.ui.MBViewManager;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.ab.f;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.x;

public class k extends com.tencent.mm.plugin.ac.c {
    private final kotlin.f IAm = kotlin.g.ah(new h(this));
    final ConcurrentHashMap<String, a> IAn;
    private boolean IAo;
    final ConcurrentSkipListSet<String> IAp;
    private final c IAq;
    private final p IAr;
    final p IAs;
    private final com.tencent.mm.plugin.ac.g IzE = new com.tencent.mm.plugin.ac.g();
    private final com.tencent.mm.plugin.ac.b IzG;
    final String TAG = "MicroMsg.WebCanvasRenderJsEngine";
    private final int cuv = 2048;
    private final int cuw = 2048;
    boolean isPaused;
    final com.tencent.magicbrush.e pqH;

    @Override // com.tencent.mm.plugin.ac.c
    public final i fWB() {
        AppMethodBeat.i(224675);
        i iVar = (i) this.IAm.getValue();
        AppMethodBeat.o(224675);
        return iVar;
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.b<g.b, x> {
        final /* synthetic */ k IAt;
        final /* synthetic */ com.tencent.magicbrush.e IAu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(com.tencent.magicbrush.e eVar, k kVar) {
            super(1);
            this.IAu = eVar;
            this.IAt = kVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(g.b bVar) {
            AppMethodBeat.i(224663);
            g.b bVar2 = bVar;
            kotlin.g.b.p.h(bVar2, "$receiver");
            bVar2.cMt = true;
            bVar2.cMv = new b.C0168b();
            bVar2.cMw = null;
            com.tencent.magicbrush.b.a aVar = new com.tencent.magicbrush.b.a();
            aVar.aW(this.IAt.cuv, this.IAt.cuw);
            BaseImageDecodeService baseImageDecodeService = bVar2.cMx;
            if (baseImageDecodeService != null) {
                baseImageDecodeService.setBitmapDecodeSlave(aVar);
            }
            Log.d(this.IAt.TAG, "hy: start prepare image handler");
            BaseImageDecodeService baseImageDecodeService2 = bVar2.cMx;
            if (baseImageDecodeService2 != null) {
                baseImageDecodeService2.addImageStreamFetcher(new b(), false);
            }
            BaseImageDecodeService baseImageDecodeService3 = bVar2.cMx;
            if (baseImageDecodeService3 != null) {
                baseImageDecodeService3.addImageStreamFetcher(new com.github.henryye.nativeiv.b.b(this) {
                    /* class com.tencent.mm.plugin.webcanvas.k.c.AnonymousClass1 */
                    final /* synthetic */ c IAv;
                    private final String SOURCE_TYPE = "appbrand_file";

                    {
                        this.IAv = r2;
                    }

                    @Override // com.github.henryye.nativeiv.b.b
                    public final b.a a(Object obj, ImageDecodeConfig imageDecodeConfig) {
                        AppMethodBeat.i(224660);
                        kotlin.g.b.p.h(obj, "path");
                        b.a aVar = new b.a();
                        if (!(obj instanceof String)) {
                            Log.i(this.IAv.IAt.TAG, "fetch path %s not string", obj);
                            AppMethodBeat.o(224660);
                            return aVar;
                        } else if (n.J((String) obj, "data:image", false)) {
                            Log.e(this.IAv.IAt.TAG, "fetch fail not my path");
                            AppMethodBeat.o(224660);
                            return aVar;
                        } else {
                            Log.i(this.IAv.IAt.TAG, "fetch path %s", obj);
                            aVar.inputStream = this.IAv.IAt.IAr.UR((String) obj);
                            if (aVar.inputStream == null) {
                                aVar.inputStream = this.IAv.IAt.IAs.UR((String) obj);
                            }
                            if (aVar.inputStream == null) {
                                Log.e(this.IAv.IAt.TAG, "fetch fail %s", obj);
                                aVar.errorMsg = "read fail";
                            }
                            AppMethodBeat.o(224660);
                            return aVar;
                        }
                    }

                    @Override // com.github.henryye.nativeiv.b.b
                    public final boolean accept(Object obj) {
                        AppMethodBeat.i(224661);
                        kotlin.g.b.p.h(obj, "obj");
                        AppMethodBeat.o(224661);
                        return true;
                    }

                    @Override // com.github.henryye.nativeiv.b.b
                    public final String sS() {
                        return this.SOURCE_TYPE;
                    }
                }, true);
            }
            IMBFontHandler Rh = this.IAu.Rh();
            if (!(Rh instanceof com.tencent.magicbrush.handler.glfont.i)) {
                Rh = null;
            }
            com.tencent.magicbrush.handler.glfont.i iVar = (com.tencent.magicbrush.handler.glfont.i) Rh;
            if (iVar != null) {
                iVar.a(new com.tencent.magicbrush.handler.glfont.c(this) {
                    /* class com.tencent.mm.plugin.webcanvas.k.c.AnonymousClass2 */
                    final /* synthetic */ c IAv;

                    {
                        this.IAv = r1;
                    }

                    @Override // com.tencent.magicbrush.handler.glfont.c
                    public final void a(Paint paint, String str, float f2) {
                        AppMethodBeat.i(224662);
                        if (kotlin.g.b.p.j(str, "500")) {
                            Log.d(this.IAv.IAt.TAG, "PaintConfigCallback fontWeight=" + str + ", fontSize=" + f2);
                            kotlin.g.b.p.g(paint, "paint");
                            paint.setStyle(Paint.Style.FILL_AND_STROKE);
                            paint.setStrokeWidth(0.8f);
                        }
                        AppMethodBeat.o(224662);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(224663);
            return xVar;
        }
    }

    public k(c cVar, p pVar, p pVar2, com.tencent.mm.plugin.ac.b bVar) {
        kotlin.g.b.p.h(cVar, "canvasJsEngine");
        kotlin.g.b.p.h(pVar, "bizPkg");
        kotlin.g.b.p.h(pVar2, "wxaPkg");
        kotlin.g.b.p.h(bVar, "performanceReporter");
        AppMethodBeat.i(224693);
        this.IAq = cVar;
        this.IAr = pVar;
        this.IAs = pVar2;
        this.IzG = bVar;
        com.tencent.magicbrush.f fVar = new com.tencent.magicbrush.f();
        this.IzG.IBG = System.currentTimeMillis();
        fVar.context = MMApplicationContext.getContext();
        f.a aVar = com.tencent.mm.plugin.ab.f.IBd;
        fVar.ae(f.a.getDevicePixelRatio());
        fVar.cLK = new a(this);
        fVar.cLJ = new b(this);
        fVar.b(a.b.NativeLocker);
        String aKJ = com.tencent.mm.loader.j.b.aKJ();
        kotlin.g.b.p.g(aKJ, "CConstants.DATAROOT_SDCARD_PATH()");
        fVar.dY(aKJ);
        fVar.ct(false);
        float dJ = ((com.tencent.mm.plugin.appbrand.service.p) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.p.class)).dJ(fVar.context);
        double d2 = (double) dJ;
        if (d2 >= 0.0d && d2 <= 1.0d) {
            fVar.af(dJ);
        }
        fVar.co(false);
        com.tencent.magicbrush.e Rm = fVar.Rm();
        if (Rm == null) {
            kotlin.g.b.p.hyc();
        }
        Rm.cLw.a(new c(Rm, this));
        if (BuildInfo.DEBUG) {
            Rm.cLz.addListener(new d(Rm, this));
        }
        com.tencent.mm.plugin.ac.b bVar2 = this.IzG;
        bVar2.Q(0, 1);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - bVar2.IBG;
        bVar2.Q(1, j2);
        long j3 = currentTimeMillis - bVar2.hpW;
        bVar2.Q(3, j3);
        Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [magicBrush]:timeCost=" + j2 + ", " + j3 + LocaleUtil.MALAY);
        bVar2.IBH = j2;
        if (50 <= j2 && 100 >= j2) {
            bVar2.Q(5, 1);
        } else if (101 <= j2 && 300 >= j2) {
            bVar2.Q(6, 1);
        } else if (301 <= j2 && 500 >= j2) {
            bVar2.Q(7, 1);
        } else if (j2 > 500) {
            bVar2.Q(8, 1);
        }
        this.pqH = Rm;
        com.tencent.magicbrush.a.b.a(new b.a() {
            /* class com.tencent.mm.plugin.webcanvas.k.AnonymousClass1 */

            @Override // com.tencent.magicbrush.a.b.a
            public final void loadLibrary(String str) {
                AppMethodBeat.i(224668);
                if (str == null) {
                    kotlin.g.b.p.hyc();
                }
                j.load(str);
                AppMethodBeat.o(224668);
            }

            @Override // com.tencent.magicbrush.a.b.a
            public final String dZ(String str) {
                AppMethodBeat.i(224669);
                if (str == null) {
                    kotlin.g.b.p.hyc();
                }
                String dZ = j.dZ(str);
                kotlin.g.b.p.g(dZ, "LoadLibrary.find(libName!!)");
                AppMethodBeat.o(224669);
                return dZ;
            }
        });
        new e().LW();
        com.tencent.mm.plugin.ab.i iVar = new com.tencent.mm.plugin.ab.i(this);
        com.tencent.mm.plugin.appbrand.m.g bMD = bMD();
        kotlin.g.b.p.g(bMD, "mainJsContext");
        iVar.f(bMD);
        this.IzG.fXb();
        P(new kotlin.g.a.b<String, x>(this) {
            /* class com.tencent.mm.plugin.webcanvas.k.AnonymousClass2 */
            final /* synthetic */ k IAt;

            {
                this.IAt = r2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(String str) {
                AppMethodBeat.i(224670);
                kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
                this.IAt.IzG.fXd();
                x xVar = x.SXb;
                AppMethodBeat.o(224670);
                return xVar;
            }
        });
        this.IzG.fXc();
        this.IAn = new ConcurrentHashMap<>();
        this.IAp = new ConcurrentSkipListSet<>();
        AppMethodBeat.o(224693);
    }

    public static final /* synthetic */ i a(k kVar) {
        AppMethodBeat.i(224694);
        i fXe = kVar.fXe();
        AppMethodBeat.o(224694);
        return fXe;
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final p fWz() {
        return this.IAs;
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final com.tencent.mm.plugin.ac.g fWy() {
        return this.IzE;
    }

    public static final class b implements com.tencent.magicbrush.handler.a {
        final /* synthetic */ k IAt;

        b(k kVar) {
            this.IAt = kVar;
        }

        @Override // com.tencent.magicbrush.handler.a
        public final String LP() {
            AppMethodBeat.i(224655);
            String LP = this.IAt.LP();
            AppMethodBeat.o(224655);
            return LP;
        }

        @Override // com.tencent.magicbrush.handler.a
        public final void resumeLoopTasks() {
            AppMethodBeat.i(224656);
            this.IAt.bMz().resumeLoopTasks();
            AppMethodBeat.o(224656);
        }

        @Override // com.tencent.magicbrush.handler.a
        public final boolean doInnerLoopTask() {
            AppMethodBeat.i(224657);
            boolean doInnerLoopTask = this.IAt.bMz().doInnerLoopTask();
            AppMethodBeat.o(224657);
            return doInnerLoopTask;
        }

        @Override // com.tencent.magicbrush.handler.a
        public final void a(Runnable runnable, boolean z) {
            AppMethodBeat.i(224658);
            kotlin.g.b.p.h(runnable, "p0");
            this.IAt.a(runnable, z);
            AppMethodBeat.o(224658);
        }

        @Override // com.tencent.magicbrush.handler.a
        public final boolean LO() {
            AppMethodBeat.i(224659);
            IJSRuntime bMz = this.IAt.bMz();
            kotlin.g.b.p.g(bMz, "this@WebCanvasRenderJsEngine.jsRuntime");
            boolean Xw = bMz.Xw();
            AppMethodBeat.o(224659);
            return Xw;
        }
    }

    public static final class d implements MBViewManager.a {
        final /* synthetic */ k IAt;
        final /* synthetic */ com.tencent.magicbrush.e IAu;

        d(com.tencent.magicbrush.e eVar, k kVar) {
            this.IAu = eVar;
            this.IAt = kVar;
        }

        private final String fWF() {
            AppMethodBeat.i(224665);
            final LinkedList linkedList = new LinkedList();
            this.IAu.cLz.forEach(new kotlin.g.a.b<MagicBrushView, x>() {
                /* class com.tencent.mm.plugin.webcanvas.k.d.AnonymousClass1 */

                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(MagicBrushView magicBrushView) {
                    AppMethodBeat.i(224664);
                    MagicBrushView magicBrushView2 = magicBrushView;
                    kotlin.g.b.p.h(magicBrushView2, LocaleUtil.ITALIAN);
                    linkedList.add(Integer.valueOf(magicBrushView2.getVirtualElementId()));
                    x xVar = x.SXb;
                    AppMethodBeat.o(224664);
                    return xVar;
                }
            });
            String a2 = kotlin.a.j.a(linkedList, ",", "[", "]", 0, (CharSequence) null, (kotlin.g.a.b) null, 56);
            AppMethodBeat.o(224665);
            return a2;
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public final void b(MagicBrushView magicBrushView) {
            AppMethodBeat.i(224666);
            kotlin.g.b.p.h(magicBrushView, "v");
            Log.d(this.IAt.TAG, "magicBrush onViewAdd " + magicBrushView.getVirtualElementId() + " remains:" + fWF());
            AppMethodBeat.o(224666);
        }

        @Override // com.tencent.magicbrush.ui.MBViewManager.a
        public final void a(MagicBrushView magicBrushView) {
            AppMethodBeat.i(224667);
            kotlin.g.b.p.h(magicBrushView, "v");
            Log.d(this.IAt.TAG, "magicBrush onViewRemove " + magicBrushView.getVirtualElementId() + " remains:" + fWF());
            AppMethodBeat.o(224667);
        }
    }

    public static final class e extends com.tencent.luggage.game.b.d {
        e() {
        }

        @Override // com.tencent.luggage.game.b.d
        public final void LX() {
            AppMethodBeat.i(224671);
            super.LX();
            com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
            AppMethodBeat.o(224671);
        }
    }

    public static /* synthetic */ void a(k kVar, String str, String str2) {
        AppMethodBeat.i(263530);
        kVar.c(str, str2, null);
        AppMethodBeat.o(263530);
    }

    public final void c(String str, String str2, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(224676);
        kotlin.g.b.p.h(str, "event");
        kotlin.g.b.p.h(str2, "canvasId");
        b(str, "{target:'" + str2 + "'}", null);
        AppMethodBeat.o(224676);
    }

    public final void a(long j2, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(224678);
        kotlin.g.b.p.h(str, "canvasId");
        b("repaint", "{ target: '" + str + "', start: " + j2 + " }", valueCallback);
        AppMethodBeat.o(224678);
    }

    public final void fWC() {
        AppMethodBeat.i(224679);
        synchronized (this) {
            try {
                if (this.isPaused) {
                    this.isPaused = false;
                    resume();
                    fWD();
                    Log.i(this.TAG, "renderJsEngine resume");
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(224679);
            }
        }
    }

    public final void fWD() {
        AppMethodBeat.i(224680);
        if (!this.IAo) {
            this.IAo = true;
            com.tencent.mm.ac.d.h(new g(this));
        }
        AppMethodBeat.o(224680);
    }

    public final void fWE() {
        AppMethodBeat.i(224681);
        if (this.IAo) {
            this.IAo = false;
            com.tencent.mm.ac.d.h(new f(this));
        }
        AppMethodBeat.o(224681);
    }

    public static /* synthetic */ void a(k kVar, String str) {
        AppMethodBeat.i(263531);
        kVar.aWz(str);
        AppMethodBeat.o(263531);
    }

    public final void aWz(String str) {
        AppMethodBeat.i(224682);
        kotlin.g.b.p.h(str, "canvasId");
        c("pause", str, null);
        AppMethodBeat.o(224682);
    }

    public final void aWA(String str) {
        AppMethodBeat.i(224684);
        kotlin.g.b.p.h(str, "canvasId");
        c("resume", str, null);
        AppMethodBeat.o(224684);
    }

    public final void aWB(String str) {
        AppMethodBeat.i(224685);
        kotlin.g.b.p.h(str, "canvasId");
        this.IAq.bw(str, -1);
        AppMethodBeat.o(224685);
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final void a(com.tencent.mm.plugin.appbrand.m.g gVar, String str, String str2, kotlin.g.a.b<? super String, x> bVar, c.a aVar) {
        AppMethodBeat.i(224686);
        kotlin.g.b.p.h(gVar, "context");
        kotlin.g.b.p.h(str, "name");
        kotlin.g.b.p.h(str2, "type");
        bMD().b(gVar, "NativeGlobal");
        super.a(gVar, str, str2, bVar, aVar);
        AppMethodBeat.o(224686);
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final c.a aWx(String str) {
        AppMethodBeat.i(224687);
        kotlin.g.b.p.h(str, "type");
        c.a aVar = new c.a("wxfedb0854e2b1820d", fWB().FK("client").optLong("idKey", 0));
        AppMethodBeat.o(224687);
        return aVar;
    }

    public a a(String str, MutableContextWrapper mutableContextWrapper, boolean z, boolean z2) {
        AppMethodBeat.i(224688);
        kotlin.g.b.p.h(str, "canvasId");
        kotlin.g.b.p.h(mutableContextWrapper, "contextWrapper");
        a aVar = new a(str, z, new WeakReference(this.IAq), new WeakReference(this), z2);
        this.IAn.put(str, aVar);
        AppMethodBeat.o(224688);
        return aVar;
    }

    public final a aWC(String str) {
        a aVar;
        AppMethodBeat.i(224689);
        kotlin.g.b.p.h(str, "canvasId");
        synchronized (this) {
            try {
                aVar = this.IAn.get(str);
            } finally {
                AppMethodBeat.o(224689);
            }
        }
        return aVar;
    }

    public static /* synthetic */ a a(k kVar, Context context, String str) {
        AppMethodBeat.i(224691);
        a a2 = kVar.a(context, str, true, true);
        AppMethodBeat.o(224691);
        return a2;
    }

    public final a a(Context context, String str, boolean z, boolean z2) {
        a aVar;
        AppMethodBeat.i(224690);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "canvasId");
        synchronized (this) {
            try {
                aVar = this.IAn.get(str);
                if (aVar == null) {
                    aVar = a(str, new MutableContextWrapper(context), z, z2);
                }
            } finally {
                AppMethodBeat.o(224690);
            }
        }
        return aVar;
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final void ly(String str, String str2) {
        AppMethodBeat.i(224692);
        kotlin.g.b.p.h(str, "message");
        kotlin.g.b.p.h(str2, "targetOrigin");
        this.IAq.lC(str, str2);
        AppMethodBeat.o(224692);
    }

    /* access modifiers changed from: package-private */
    public static final class h extends q implements kotlin.g.a.a<i> {
        final /* synthetic */ k IAt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(k kVar) {
            super(0);
            this.IAt = kVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ i invoke() {
            AppMethodBeat.i(224674);
            i FJ = k.a(this.IAt).FJ("render");
            AppMethodBeat.o(224674);
            return FJ;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ k IAt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(k kVar) {
            super(0);
            this.IAt = kVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(224654);
            aj ajVar = new aj(this.IAt.getIsolatePtr(), this.IAt.XK(), this.IAt.getUVLoopPtr());
            AppMethodBeat.o(224654);
            return ajVar;
        }
    }

    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k IAt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(k kVar) {
            super(0);
            this.IAt = kVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(224673);
            this.IAt.pqH.Rc();
            x xVar = x.SXb;
            AppMethodBeat.o(224673);
            return xVar;
        }
    }

    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ k IAt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(k kVar) {
            super(0);
            this.IAt = kVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(224672);
            this.IAt.pqH.Rd();
            x xVar = x.SXb;
            AppMethodBeat.o(224672);
            return xVar;
        }
    }
}
