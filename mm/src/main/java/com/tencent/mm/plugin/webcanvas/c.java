package com.tencent.mm.plugin.webcanvas;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ValueCallback;
import com.tencent.magicbrush.aj;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.app.o;
import com.tencent.mm.appbrand.v8.IJSRuntime;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.ab.c;
import com.tencent.mm.plugin.ab.k;
import com.tencent.mm.plugin.ab.n;
import com.tencent.mm.plugin.ac.b;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.ac.f;
import com.tencent.mm.plugin.appbrand.appcache.p;
import com.tencent.mm.plugin.webcanvas.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMKVSlotManager;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.q;
import kotlin.x;

public abstract class c extends com.tencent.mm.plugin.ac.c implements k {
    public static final a IzL = new a((byte) 0);
    private static final kotlin.f Izi = kotlin.g.ah(b.IzM);
    private final kotlin.f IzD = kotlin.g.ah(new e(this));
    private final com.tencent.mm.plugin.ac.g IzE = new com.tencent.mm.plugin.ac.g();
    public final HashMap<String, Integer> IzF = new HashMap<>();
    protected final com.tencent.mm.plugin.ac.b IzG;
    private final kotlin.f IzH;
    private final kotlin.f IzI;
    private String IzJ;
    private String IzK;
    public final String TAG = "MicroMsg.WebCanvasJsEngine";
    private final long hpW;

    public abstract String bje();

    /* access modifiers changed from: protected */
    public abstract k cnb();

    public final p fWA() {
        return (p) this.IzI.getValue();
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final p fWz() {
        return (p) this.IzH.getValue();
    }

    public static final class d extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ c IzN;
        final /* synthetic */ String IzQ;
        final /* synthetic */ String IzR;
        final /* synthetic */ String pwJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(c cVar, Context context, String str, String str2, String str3) {
            super(1);
            this.IzN = cVar;
            this.$context$inlined = context;
            this.pwJ = str;
            this.IzQ = str2;
            this.IzR = str3;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(224627);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.ac.b bVar = this.IzN.IzG;
            String str2 = this.pwJ;
            kotlin.g.b.p.h(str2, "id");
            b.c cVar = bVar.IBD.get(str2);
            if (cVar != null) {
                cVar.IBM = true;
                long currentTimeMillis = System.currentTimeMillis() - cVar.createTime;
                if (!cVar.IBB) {
                    bVar.Q(28, currentTimeMillis);
                    if (50 <= currentTimeMillis && 100 >= currentTimeMillis) {
                        bVar.Q(30, 1);
                    } else if (101 <= currentTimeMillis && 300 >= currentTimeMillis) {
                        bVar.Q(31, 1);
                    } else if (301 <= currentTimeMillis && 500 >= currentTimeMillis) {
                        bVar.Q(32, 1);
                    } else if (currentTimeMillis > 500) {
                        bVar.Q(33, 1);
                    }
                } else {
                    bVar.Q(39, currentTimeMillis);
                    if (50 <= currentTimeMillis && 100 >= currentTimeMillis) {
                        bVar.Q(41, 1);
                    } else if (101 <= currentTimeMillis && 300 >= currentTimeMillis) {
                        bVar.Q(42, 1);
                    } else if (301 <= currentTimeMillis && 500 >= currentTimeMillis) {
                        bVar.Q(43, 1);
                    } else if (currentTimeMillis > 500) {
                        bVar.Q(44, 1);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(bVar.appId);
                sb.append(",");
                sb.append(str2);
                sb.append(",");
                sb.append(cVar.IBN);
                sb.append(",");
                sb.append(currentTimeMillis);
                sb.append(",");
                sb.append(cVar.IBB ? 1 : 0);
                String sb2 = sb.toString();
                kotlin.g.b.p.g(sb2, "StringBuilder().apply {\n…\n            }.toString()");
                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(20920, sb2);
                Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ClientContextReady]:" + currentTimeMillis + "ms isMainContextStarted:" + cVar.IBB);
            }
            a aWC = this.IzN.cnb().aWC(this.pwJ);
            if (aWC != null) {
                aWC.fWm();
            }
            c.a(this.IzN, "create", this.pwJ);
            x xVar = x.SXb;
            AppMethodBeat.o(224627);
            return xVar;
        }
    }

    public static final class h extends q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ c IzN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar) {
            super(1);
            this.IzN = cVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(224635);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            this.IzN.IzG.fXd();
            x xVar = x.SXb;
            AppMethodBeat.o(224635);
            return xVar;
        }
    }

    public c() {
        long now = MMSlotKt.now();
        Log.d(this.TAG, "performance: initStartTime");
        this.hpW = now;
        this.IzG = new com.tencent.mm.plugin.ac.b(this.hpW);
        this.IzH = kotlin.g.ah(new j(this));
        this.IzI = kotlin.g.ah(new C1935c(this));
        cnc();
        this.IzJ = "none";
        this.IzK = "";
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final com.tencent.mm.plugin.ac.g fWy() {
        return this.IzE;
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final int getBizPkgVersion() {
        return fWA().version();
    }

    @Override // com.tencent.mm.plugin.ab.k
    public final int getBasePkgVersion() {
        return fWz().version();
    }

    public void cnc() {
        Log.i(this.TAG, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED) {
            com.tencent.magicbrush.f fVar = new com.tencent.magicbrush.f();
            fVar.context = MMApplicationContext.getContext();
            fVar.cLK = new f(this);
            fVar.cLJ = new g(this);
            fVar.Rm();
        }
        com.tencent.mm.plugin.ab.i iVar = new com.tencent.mm.plugin.ab.i(this);
        com.tencent.mm.plugin.appbrand.m.g bMD = bMD();
        kotlin.g.b.p.g(bMD, "mainJsContext");
        iVar.f(bMD);
        this.IzG.fXb();
        P(new h(this));
        this.IzG.fXc();
        new i(this).alive();
    }

    public static final class g implements com.tencent.magicbrush.handler.a {
        final /* synthetic */ c IzN;

        g(c cVar) {
            this.IzN = cVar;
        }

        @Override // com.tencent.magicbrush.handler.a
        public final String LP() {
            AppMethodBeat.i(224630);
            String LP = this.IzN.LP();
            AppMethodBeat.o(224630);
            return LP;
        }

        @Override // com.tencent.magicbrush.handler.a
        public final void resumeLoopTasks() {
            AppMethodBeat.i(224631);
            this.IzN.bMz().resumeLoopTasks();
            AppMethodBeat.o(224631);
        }

        @Override // com.tencent.magicbrush.handler.a
        public final boolean doInnerLoopTask() {
            AppMethodBeat.i(224632);
            boolean doInnerLoopTask = this.IzN.bMz().doInnerLoopTask();
            AppMethodBeat.o(224632);
            return doInnerLoopTask;
        }

        @Override // com.tencent.magicbrush.handler.a
        public final void a(Runnable runnable, boolean z) {
            AppMethodBeat.i(224633);
            kotlin.g.b.p.h(runnable, "p0");
            this.IzN.a(runnable, z);
            AppMethodBeat.o(224633);
        }

        @Override // com.tencent.magicbrush.handler.a
        public final boolean LO() {
            AppMethodBeat.i(224634);
            IJSRuntime bMz = this.IzN.bMz();
            kotlin.g.b.p.g(bMz, "this@WebCanvasJsEngine.jsRuntime");
            boolean Xw = bMz.Xw();
            AppMethodBeat.o(224634);
            return Xw;
        }
    }

    public static final class i extends o.a {
        final /* synthetic */ c IzN;

        i(c cVar) {
            this.IzN = cVar;
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(224637);
            kotlin.g.b.p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            Log.i(this.IzN.TAG, "logicJsEngine and renderJsEngine resume");
            this.IzN.cnb().fWC();
            this.IzN.resume();
            c.a.a(this.IzN, "foreground", null, null, 6);
            AppMethodBeat.o(224637);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(224638);
            kotlin.g.b.p.h(str, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            c.a.a(this.IzN, "background", null, new a(this), 2);
            k cnb = this.IzN.cnb();
            synchronized (cnb) {
                try {
                    if (!cnb.isPaused) {
                        cnb.isPaused = true;
                        cnb.fWE();
                        cnb.pause();
                        Log.i(cnb.TAG, "renderJsEngine pause");
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(224638);
                }
            }
        }

        static final class a<T> implements ValueCallback<String> {
            final /* synthetic */ i IzS;

            a(i iVar) {
                this.IzS = iVar;
            }

            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(224636);
                this.IzS.IzN.pause();
                Log.i(this.IzS.IzN.TAG, "logicJsEngine pause");
                AppMethodBeat.o(224636);
            }
        }
    }

    public final float[] aWv(String str) {
        kotlin.g.b.p.h(str, "canvasId");
        a aWC = cnb().aWC(str);
        if (aWC != null) {
            return aWC.IyY;
        }
        return null;
    }

    public static /* synthetic */ void a(c cVar, String str, String str2) {
        kotlin.g.b.p.h(str, "event");
        kotlin.g.b.p.h(str2, "canvasId");
        cVar.b(str, "{target:'" + str2 + "'}", null);
    }

    public final void aWw(String str) {
        kotlin.g.b.p.h(str, "<set-?>");
        this.IzJ = str;
    }

    public final void hd(String str) {
        kotlin.g.b.p.h(str, "canvasId");
        Log.i(this.TAG, "pause #".concat(String.valueOf(str)));
        a(this, "pause", str);
        cnb().aWz(str);
        cnb();
        kotlin.g.b.p.h(str, "canvasId");
        if (!kotlin.g.b.p.j(this.IzK, "pause")) {
            this.IzK = "pause";
            cnb().aWz(this.IzJ);
            cnb();
            kotlin.g.b.p.h(this.IzJ, "canvasId");
        }
    }

    public final void hc(String str) {
        boolean z;
        b.a aVar;
        boolean z2 = false;
        kotlin.g.b.p.h(str, "canvasId");
        long now = MMSlotKt.now();
        Log.i(this.TAG, "resume #" + str + ", " + now);
        com.tencent.mm.plugin.ac.b bVar = this.IzG;
        int hashCode = str.hashCode();
        kotlin.g.b.p.h(str, "canvasId");
        if (!bVar.IBE.containsKey(Integer.valueOf(hashCode))) {
            ConcurrentHashMap<Integer, b.a> concurrentHashMap = bVar.IBE;
            Integer valueOf = Integer.valueOf(hashCode);
            b.a aVar2 = new b.a(System.currentTimeMillis(), hashCode, str);
            b.c cVar = bVar.IBD.get(str);
            if (cVar != null) {
                z = cVar.IBM;
                aVar = aVar2;
            } else {
                z = false;
                aVar = aVar2;
            }
            aVar.IBM = z;
            concurrentHashMap.put(valueOf, aVar2);
        }
        b.a aVar3 = bVar.IBE.get(Integer.valueOf(hashCode));
        if (aVar3 != null) {
            if (aVar3.IBL) {
                aVar3.createTime = System.currentTimeMillis();
            }
            b.c cVar2 = bVar.IBD.get(str);
            if (cVar2 != null) {
                z2 = cVar2.IBM;
            }
            aVar3.IBM = z2;
        }
        a(this, "resume", str);
        cnb().fWC();
        cnb().a(now, str, (ValueCallback<String>) null);
        cnb().aWA(str);
        if (!kotlin.g.b.p.j(this.IzK, "resume")) {
            this.IzK = "resume";
            cnb().a(now, this.IzJ, (ValueCallback<String>) null);
            cnb().aWA(this.IzJ);
        }
    }

    public final void bw(String str, long j2) {
        kotlin.g.b.p.h(str, "canvasId");
        Log.i(this.TAG, "reflow #".concat(String.valueOf(str)));
        a aWC = cnb().aWC(str);
        if (aWC != null) {
            aWC.fWm();
        }
        c.a.a(this, "reflow", "{target:'" + str + "', start:" + j2 + '}', null, 4);
    }

    public void a(Context context, String str, String str2, com.tencent.mm.plugin.appbrand.m.i iVar) {
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(str, "canvasId");
        kotlin.g.b.p.h(str2, "data");
        kotlin.g.b.p.h(iVar, "jsRuntime");
        new com.tencent.mm.plugin.ab.j(this).f(iVar);
        a a2 = k.a(cnb(), context, str);
        new com.tencent.mm.plugin.ab.f(a2).f(iVar);
        new n(new i(a2, this, cnb())).f(iVar);
    }

    public static /* synthetic */ a a(c cVar, String str, String str2, String str3) {
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        return cVar.a(str, str2, str3, context);
    }

    public final synchronized a a(String str, String str2, String str3, Context context) {
        a a2;
        kotlin.g.b.p.h(str, "type");
        kotlin.g.b.p.h(str2, "canvasId");
        kotlin.g.b.p.h(str3, "data");
        kotlin.g.b.p.h(context, "context");
        if (this.IzF.containsKey(str2)) {
            a2 = k.a(cnb(), context, str2);
        } else {
            long now = MMSlotKt.now();
            Log.i(this.TAG, "create #".concat(String.valueOf(str2)));
            HashMap<String, Integer> hashMap = this.IzF;
            com.tencent.mm.plugin.appbrand.m.g bME = bME();
            kotlin.g.b.p.g(bME, "this");
            a(context, str2, str3, bME);
            com.tencent.mm.plugin.ac.c.a(this, bME, "CanvasContext#".concat(String.valueOf(str2)), str, new d(this, context, str2, str3, str), (c.a) null, 16);
            com.tencent.mm.plugin.ac.b bVar = this.IzG;
            kotlin.g.b.p.h(str2, "id");
            b.c cVar = bVar.IBD.get(str2);
            if (cVar != null) {
                long currentTimeMillis = System.currentTimeMillis() - cVar.createTime;
                bVar.Q(25, 1);
                bVar.Q(26, currentTimeMillis);
                cVar.IBN = (int) currentTimeMillis;
                Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [ConfigClient]:" + currentTimeMillis + "ms isMainContextStarted:" + cVar.IBB);
            }
            hashMap.put(str2, Integer.valueOf(bME.bMC()));
            com.tencent.mm.plugin.ac.b bVar2 = this.IzG;
            kotlin.g.b.p.h(str2, "id");
            bVar2.IBF = now;
            bVar2.IBD.put(str2, new b.c(bVar2.IBF, bVar2.IBB));
            a2 = k.a(cnb(), context, str2);
        }
        return a2;
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final c.a aWx(String str) {
        kotlin.g.b.p.h(str, "type");
        String bje = bje();
        com.tencent.mm.ab.i FK = c.b.b(fWA()).FK("client").FK(str);
        return new c.a(bje, FK != null ? FK.optLong("idKey") : 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: kotlin.g.a.b<? super java.lang.String, kotlin.x> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.plugin.ac.c
    public final void a(String str, String str2, com.tencent.mm.plugin.appbrand.m.g gVar, com.tencent.mm.plugin.ac.f fVar, kotlin.g.a.b<? super String, x> bVar) {
        e eVar;
        e eVar2;
        kotlin.g.b.p.h(str, "name");
        kotlin.g.b.p.h(str2, "type");
        kotlin.g.b.p.h(gVar, "context");
        kotlin.g.b.p.h(fVar, "contextReporter");
        try {
            String string = c.b.b(fWA()).FJ("client").FJ(str2).getString("path");
            p fWA = fWA();
            kotlin.g.b.p.g(string, "path");
            String a2 = c.b.a(fWA, string);
            if (BuildInfo.DEBUG) {
                if (bVar != 0) {
                    eVar2 = new e(bVar);
                } else {
                    eVar2 = bVar;
                }
                gVar.evaluateJavascript(a2, eVar2);
            } else {
                URL url = new URL("https://ws/usr/" + bje() + string);
                String lB = lB(bje(), string);
                String valueOf = String.valueOf(c.b.a(fWA()));
                if (bVar != 0) {
                    eVar = new e(bVar);
                } else {
                    eVar = bVar;
                }
                gVar.a(url, lB, valueOf, 0, a2, eVar);
            }
            Log.d(this.TAG, "biz loaded:" + string + " to " + str);
        } catch (Exception e2) {
            fVar.a(new f.C0516f());
            l lVar = l.IAx;
            l.ba(bje(), str, e2.getMessage());
            Log.printErrStackTrace(this.TAG, e2, "read client context script", new Object[0]);
            throw e2;
        }
    }

    public final void clear() {
        cna().eQ(MMApplicationContext.getContext());
        k cnb = cnb();
        for (T t : cnb.IAp) {
            Log.i(cnb.TAG, "canvasContext#" + ((String) t) + " should be destroyed");
            a aVar = cnb.IAn.get(t);
            if (aVar != null) {
                n nVar = aVar.IyU;
                if (nVar != null) {
                    aVar.fWk().xY(nVar.IAR);
                    aVar.fWk().b("destroy", "{target:'" + aVar.lAN + "'}", new a.i(nVar));
                    ViewParent parent = nVar.MQ().getParent();
                    if (!(parent instanceof ViewGroup)) {
                        parent = null;
                    }
                    ViewGroup viewGroup = (ViewGroup) parent;
                    if (viewGroup != null) {
                        viewGroup.removeView(nVar.MQ());
                    }
                    Context context = nVar.MQ().getContext();
                    if (!(context instanceof MutableContextWrapper)) {
                        context = null;
                    }
                    MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) context;
                    if (mutableContextWrapper != null) {
                        mutableContextWrapper.setBaseContext(MMApplicationContext.getContext());
                    }
                    Log.i(a.TAG, "canvas#" + aVar.lAN + ':' + nVar.IAR + '@' + nVar.MQ().getVirtualElementId() + " has been destroyed");
                }
                aVar.IyU = null;
            }
        }
        cnb.IAp.clear();
    }

    @Override // com.tencent.mm.plugin.ac.c
    public final void ly(String str, String str2) {
        kotlin.g.b.p.h(str, "message");
        kotlin.g.b.p.h(str2, "targetOrigin");
        cnb().lC(str, str2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class e extends q implements kotlin.g.a.a<m> {
        final /* synthetic */ c IzN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(c cVar) {
            super(0);
            this.IzN = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ m invoke() {
            AppMethodBeat.i(224628);
            m bMA = this.IzN.bMA();
            AppMethodBeat.o(224628);
            return bMA;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class j extends q implements kotlin.g.a.a<p> {
        final /* synthetic */ c IzN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(c cVar) {
            super(0);
            this.IzN = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ p invoke() {
            String aWH;
            AppMethodBeat.i(224644);
            long now = MMSlotKt.now();
            c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
            m mVar = m.IAG;
            boolean z = m.fWJ() == 1;
            m mVar2 = m.IAG;
            if (m.fWJ() == 1) {
                m mVar3 = m.IAG;
                aWH = m.aWI("wxfedb0854e2b1820d");
            } else {
                aWH = m.IAG.aWH("wxfedb0854e2b1820d");
            }
            p a2 = c.b.a(c.b.a("webtimeline.wspkg", z, aWH, "wxfedb0854e2b1820d"), (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) AnonymousClass1.IzT, (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) AnonymousClass2.IzU, true);
            com.tencent.mm.plugin.ac.b bVar2 = this.IzN.IzG;
            long now2 = MMSlotKt.now() - now;
            bVar2.Q(120, 1);
            bVar2.Q(121, now2);
            Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [basePkg]:" + now2 + " ms");
            AppMethodBeat.o(224644);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.webcanvas.c$c */
    public static final class C1935c extends q implements kotlin.g.a.a<p> {
        final /* synthetic */ c IzN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1935c(c cVar) {
            super(0);
            this.IzN = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ p invoke() {
            String aWH;
            AppMethodBeat.i(224626);
            long now = MMSlotKt.now();
            c.b bVar = com.tencent.mm.plugin.ac.c.IBU;
            m mVar = m.IAG;
            boolean z = m.fWJ() == 1;
            m mVar2 = m.IAG;
            if (m.fWJ() == 1) {
                m mVar3 = m.IAG;
                aWH = m.aWI("wxf337cbaa27790d8e");
            } else {
                aWH = m.IAG.aWH("wxf337cbaa27790d8e");
            }
            p a2 = c.b.a(c.b.a("index.wspkg", z, aWH, "wxf337cbaa27790d8e"), (kotlin.g.a.q<? super Integer, ? super Integer, ? super p, Boolean>) new kotlin.g.a.q<Integer, Integer, p, Boolean>(this) {
                /* class com.tencent.mm.plugin.webcanvas.c.C1935c.AnonymousClass1 */
                final /* synthetic */ C1935c IzO;

                {
                    this.IzO = r2;
                }

                @Override // kotlin.g.a.q
                public final /* synthetic */ Boolean d(Integer num, Integer num2, p pVar) {
                    boolean z;
                    AppMethodBeat.i(224623);
                    int intValue = num.intValue();
                    int intValue2 = num2.intValue();
                    p pVar2 = pVar;
                    kotlin.g.b.p.h(pVar2, "resPkg");
                    if (intValue2 > intValue) {
                        m mVar = m.IAG;
                        if (m.a(pVar2, this.IzO.IzN.fWz())) {
                            z = true;
                            Boolean valueOf = Boolean.valueOf(z);
                            AppMethodBeat.o(224623);
                            return valueOf;
                        }
                    }
                    z = false;
                    Boolean valueOf2 = Boolean.valueOf(z);
                    AppMethodBeat.o(224623);
                    return valueOf2;
                }
            }, (kotlin.g.a.q<? super c.EnumC0515c, ? super Integer, ? super String, x>) AnonymousClass2.IzP, true);
            com.tencent.mm.plugin.ac.b bVar2 = this.IzN.IzG;
            long now2 = MMSlotKt.now() - now;
            bVar2.Q(123, 1);
            bVar2.Q(124, now2);
            Log.i("MicroMsg.WebCanvasPerformanceReporter", "performance: [bizPkg]:" + now2 + " ms");
            AppMethodBeat.o(224626);
            return a2;
        }
    }

    public static final class f extends q implements kotlin.g.a.a<aj> {
        final /* synthetic */ c IzN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar) {
            super(0);
            this.IzN = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ aj invoke() {
            AppMethodBeat.i(224629);
            aj ajVar = new aj(this.IzN.getIsolatePtr(), this.IzN.XK(), this.IzN.getUVLoopPtr());
            AppMethodBeat.o(224629);
            return ajVar;
        }
    }

    static final class b extends q implements kotlin.g.a.a<MMKVSlotManager> {
        public static final b IzM = new b();

        static {
            AppMethodBeat.i(224621);
            AppMethodBeat.o(224621);
        }

        b() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ MMKVSlotManager invoke() {
            AppMethodBeat.i(224620);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("__webcanvans__");
            kotlin.g.b.p.g(mmkv, "MultiProcessMMKV.getMMKV(\"__webcanvans__\")");
            MMKVSlotManager mMKVSlotManager = new MMKVSlotManager(mmkv, 259200);
            AppMethodBeat.o(224620);
            return mMKVSlotManager;
        }
    }
}
