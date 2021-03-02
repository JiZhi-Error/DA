package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.luggage.sdk.g.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mj;
import com.tencent.mm.g.b.a.ml;
import com.tencent.mm.g.b.a.mm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.af.d;
import com.tencent.mm.plugin.appbrand.an;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.jsapi.file.w;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.t;
import com.tencent.mm.plugin.appbrand.m.aa;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.page.a.h;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.b;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.g.a.a;
import kotlin.x;

public class af extends bn<ag> implements w.b {
    private long nrk;
    private long nrl;
    private long nrm;
    private final Set<String> nrn = new HashSet();
    private av nro = null;

    public af(ag agVar) {
        super(agVar);
        AppMethodBeat.i(47844);
        AppMethodBeat.o(47844);
    }

    public final ICommLibReader bqZ() {
        AppMethodBeat.i(47845);
        ICommLibReader bqZ = ((ag) NN()).bqZ();
        AppMethodBeat.o(47845);
        return bqZ;
    }

    @Override // com.tencent.luggage.sdk.b.a.a.AbstractC0178a, com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    public final <T> T S(Class<T> cls) {
        AppMethodBeat.i(47847);
        if (e.class == cls) {
            e eVar = (e) super.S(e.class);
            if (eVar == null) {
                AppMethodBeat.o(47847);
                return null;
            }
            if (this.nro == null) {
                this.nro = new av(eVar);
            }
            this.nro.m(((ag) NN()).bRM());
            T cast = cls.cast(this.nro);
            AppMethodBeat.o(47847);
            return cast;
        }
        T t = (T) super.S(cls);
        AppMethodBeat.o(47847);
        return t;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.a
    public final boolean bQr() {
        AppMethodBeat.i(47848);
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(getAppId())) {
            AppMethodBeat.o(47848);
            return false;
        } else if (bb.r(((ag) NN()).getRuntime())) {
            AppMethodBeat.o(47848);
            return false;
        } else if (((ag) NN()).getRuntime().bsC().kHL.isEnable()) {
            AppMethodBeat.o(47848);
            return false;
        } else if (((ag) NN()).getRuntime().OS()) {
            AppMethodBeat.o(47848);
            return false;
        } else {
            boolean bQr = super.bQr();
            AppMethodBeat.o(47848);
            return bQr;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void cb(View view) {
        i iVar;
        AppMethodBeat.i(47849);
        super.cb(view);
        if (((bq) this.nmX) instanceof at) {
            iVar = ((at) ((bq) this.nmX)).nsV;
        } else {
            iVar = (bq) this.nmX;
        }
        if (iVar instanceof MMWebView) {
            ((MMWebView) iVar).getIsX5Kernel();
        }
        ((ag) NN()).getFullscreenImpl().a(new b() {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.platform.window.b
            public final void bDq() {
                AppMethodBeat.i(47837);
                f.e(true, true, false);
                AppMethodBeat.o(47837);
            }

            @Override // com.tencent.mm.plugin.appbrand.platform.window.b
            public final void Na() {
                AppMethodBeat.i(47838);
                f.e(false, true, false);
                AppMethodBeat.o(47838);
            }
        });
        AppMethodBeat.o(47849);
    }

    public final q getRuntime() {
        AppMethodBeat.i(261634);
        q qVar = (q) super.NP();
        AppMethodBeat.o(261634);
        return qVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.c, com.tencent.mm.plugin.appbrand.page.a
    public final Map<String, p> Nf() {
        AppMethodBeat.i(47851);
        Map<String, p> map = (Map) c.a("AppBrandPageViewRendererWC.onCreateJsApiPool()", new a<Map<String, p>>() {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Map<String, p> invoke() {
                AppMethodBeat.i(47839);
                Map<String, p> bEl = t.bEl();
                AppMethodBeat.o(47839);
                return bEl;
            }
        });
        AppMethodBeat.o(47851);
        return map;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bn
    public final bc ej(final Context context) {
        AppMethodBeat.i(47852);
        this.nrk = Util.currentTicks();
        bc bcVar = (bc) c.a("onCreateRealWebView", new a<am>() {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass3 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ am invoke() {
                AppMethodBeat.i(47840);
                am amVar = new am(context, (byte) 0);
                AppMethodBeat.o(47840);
                return amVar;
            }
        }, new kotlin.g.a.q<am, Long, Long, x>() {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(am amVar, Long l, Long l2) {
                AppMethodBeat.i(227281);
                am amVar2 = amVar;
                Long l3 = l;
                Long l4 = l2;
                if (!TextUtils.isEmpty(af.this.getAppId())) {
                    com.tencent.mm.plugin.appbrand.keylogger.c.a(af.this.getAppId(), KSProcessWeAppLaunch.stepCreateWebViewInstance, amVar2.getVersionInfo(), l3.longValue(), l4.longValue());
                }
                x xVar = x.SXb;
                AppMethodBeat.o(227281);
                return xVar;
            }
        });
        AppMethodBeat.o(47852);
        return bcVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a
    public be bQu() {
        AppMethodBeat.i(47853);
        if (!bRI().supportFeature(2002) || !bRI().supportFeature(2004) || !((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_webview_script_codecache, true)) {
            be bQu = super.bQu();
            AppMethodBeat.o(47853);
            return bQu;
        }
        AnonymousClass5 r0 = new bj(this) {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.appbrand.page.bj
            public final void adR(String str) {
                AppMethodBeat.i(227282);
                af.this.nrn.add(str);
                AppMethodBeat.o(227282);
            }
        };
        AppMethodBeat.o(47853);
        return r0;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a, com.tencent.luggage.sdk.b.a.b.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void dispatchStart() {
        AppMethodBeat.i(47854);
        if (aa.f((ac) NN())) {
            Log.i("MicroMsg.AppBrandPageViewRendererWC", "page initNativeTransServiceId");
            aa.a(((ag) NN()).getJsRuntime(), ((ag) NN()).bsE().getComponentId(), ((ag) NN()).getComponentId(), getAppId());
        }
        super.dispatchStart();
        S(e.class);
        ((bq) this.nmX).ag(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(47843);
                af.this.getRuntime().kDk.I(3, Util.ticksToNow(af.this.nrk));
                com.tencent.mm.plugin.appbrand.performance.c.a(af.this.getAppId(), "Native", "WebViewInit+PageFrameLoad", af.this.nrk, System.currentTimeMillis(), "");
                AppMethodBeat.o(47843);
            }
        });
        if (com.tencent.mm.plugin.appbrand.af.g.an(((ag) NN()).getRuntime())) {
            super.b(h.class, new d((ac) NN()));
        }
        HalfScreenConfig halfScreenConfig = ((q) super.NP()).bsC().kHL;
        if (halfScreenConfig.isEnable() && halfScreenConfig.kuZ) {
            this.nmX.setBackgroundColor(-1);
        }
        AppMethodBeat.o(47854);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    public final boolean dy(String str) {
        AccessibilityManager accessibilityManager;
        AppMethodBeat.i(47855);
        this.nrm = System.currentTimeMillis();
        ((bq) this.nmX).ag(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.af.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(227283);
                af.this.nrl = Util.currentTicks();
                AppMethodBeat.o(227283);
            }
        });
        try {
            if (q.kDg && (accessibilityManager = (AccessibilityManager) android.support.v4.content.b.a(getContext(), AccessibilityManager.class)) != null && !accessibilityManager.isTouchExplorationEnabled()) {
                ((ag) NN()).getContentView().setContentDescription(l.dM(str));
            }
        } catch (Exception e2) {
        }
        ((bq) this.nmX).aG(((ag) NN()).getContext());
        boolean dy = super.dy(str);
        com.tencent.mm.plugin.appbrand.e.a((ag) NN());
        AppMethodBeat.o(47855);
        return dy;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a
    public final void adt(String str) {
        AppMethodBeat.i(47856);
        super.adt(str);
        com.tencent.mm.plugin.appbrand.report.i.cf(getAppId(), 27);
        AppMethodBeat.o(47856);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a, com.tencent.mm.plugin.appbrand.page.ae
    public final void Ng() {
        AppMethodBeat.i(47857);
        super.Ng();
        ((q) super.NP()).kDk.I(4, Util.ticksToNow(this.nrl));
        AppBrandPerformanceManager.a((q) super.NP(), 203, System.currentTimeMillis() - this.nrm);
        com.tencent.mm.plugin.appbrand.performance.c.a(getAppId(), "Native", "PageLoad", this.nrm, System.currentTimeMillis(), "");
        AppMethodBeat.o(47857);
    }

    private boolean bRJ() {
        AppMethodBeat.i(47858);
        com.tencent.mm.plugin.appbrand.service.c bsE = ((ag) NN()).bsE();
        if (bsE == null) {
            AppMethodBeat.o(47858);
            return false;
        }
        boolean Mj = bsE.cBj.Mj();
        if (!Mj) {
            an.btp();
            Mj = true;
        }
        AppMethodBeat.o(47858);
        return Mj;
    }

    private void a(String str, String str2, long j2, long j3) {
        long j4;
        long j5 = 1;
        AppMethodBeat.i(47859);
        mj zy = com.tencent.mm.plugin.appbrand.report.quality.b.bUZ().l((com.tencent.mm.plugin.appbrand.d) NN()).zy(str);
        zy.fbD = (long) str2.length();
        if (!str2.startsWith("//XWEB_SCRIPT:") || !this.nrn.contains(str)) {
            j4 = 0;
        } else {
            j4 = 1;
        }
        zy.fbG = j4;
        if (!bRJ()) {
            j5 = 0;
        }
        zy.fbH = j5;
        zy.vX(j2);
        zy.vY(j3);
        zy.vW(zy.fae - zy.fad);
        zy.bfK();
        AppMethodBeat.o(47859);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.bn
    public final void q(String str, long j2, long j3) {
        AppMethodBeat.i(227285);
        if (NN() == null) {
            AppMethodBeat.o(227285);
            return;
        }
        if (isRunning()) {
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            com.tencent.mm.plugin.appbrand.report.quality.c.a((com.tencent.mm.plugin.appbrand.d) NN(), str, j2, j3, bRJ(), 0);
        }
        AppMethodBeat.o(227285);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bn, com.tencent.mm.plugin.appbrand.page.a
    public final void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
        int i2;
        long j4;
        AppMethodBeat.i(227286);
        super.a(aVar, z, j2, j3, obj);
        if (NN() == null) {
            AppMethodBeat.o(227286);
            return;
        }
        String str = aVar.scriptName;
        String str2 = aVar.czz;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(227286);
            return;
        }
        if (!z) {
            Log.e("MicroMsg.AppBrandPageViewRendererWC", "[!]reportBootstrapScriptEvaluateResult !succeed appID[%s] name[%s] url[%s] hash[%d]", getAppId(), str, this.lBI, Integer.valueOf(hashCode()));
        } else {
            Log.i("MicroMsg.AppBrandPageViewRendererWC", "[+]reportBootstrapScriptEvaluateResult succeed appId[%s] name[%s] url[%s] hash[%d]", getAppId(), str, this.lBI, Integer.valueOf(hashCode()));
        }
        if (org.apache.commons.b.a.contains(czx, str)) {
            AppMethodBeat.o(227286);
        } else if (((q) super.NP()) == null || org.apache.commons.b.a.contains(czy, str) || !((aa) ((ag) NN()).av(aa.class)).bRa()) {
            char c2 = 65535;
            switch (str.hashCode()) {
                case -827637304:
                    if (str.equals("WAWebview.js")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -710717014:
                    if (str.equals("app-wxss.js")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -30302838:
                    if (str.equals("page-frame.html")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 1779653932:
                    if (str.equals("WAVConsole.js")) {
                        c2 = 1;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(370, 1, 1, false);
                    if (((q) super.NP()) != null) {
                        if (z) {
                            com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, str, j2, j3);
                        } else {
                            com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSWAWebview, "", str, j2, j3);
                        }
                    }
                    if (z) {
                        if (bSg() || isRunning()) {
                            a(str, str2, j2, j3);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(370, 3, 1, false);
                        AppMethodBeat.o(227286);
                        return;
                    }
                    Log.e("MicroMsg.AppBrandPageViewRendererWC", "Inject SDK Page Script Failed   appId = %s", getAppId());
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(370, 2, 1, false);
                    com.tencent.mm.plugin.appbrand.report.i.cf(getAppId(), 24);
                    int i3 = 0;
                    q runtime = ((ag) NN()).getRuntime();
                    if (runtime != null) {
                        int i4 = runtime.bsB().leE.pkgVersion;
                        i2 = runtime.bsB().leE.kNW;
                        i3 = i4;
                    } else {
                        i2 = -1;
                    }
                    com.tencent.mm.plugin.appbrand.report.i.b(getAppId(), i3, i2, 370, 2);
                    AppMethodBeat.o(227286);
                    return;
                case 1:
                    if (bSg() || isRunning()) {
                        a(str, str2, j2, j3);
                        AppMethodBeat.o(227286);
                        return;
                    }
                case 2:
                case 3:
                    a(ModulePkgInfo.MAIN_MODULE_NAME, str, str2, z, j2, j3);
                    AppMethodBeat.o(227286);
                    return;
                default:
                    if (!str.endsWith("page-frame.js")) {
                        if (str.equals(this.lBI)) {
                            if (isRunning()) {
                                QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
                                if (aeU != null) {
                                    ml mlVar = new ml();
                                    mlVar.eWb = mlVar.x("InstanceId", aeU.kEY, true);
                                    mlVar.eJx = mlVar.x("AppId", getAppId(), true);
                                    mlVar.eXc = (long) aeU.nLk;
                                    mlVar.fcp = ml.a.mx(aeU.nJE);
                                    mlVar.eYW = (long) aeU.apptype;
                                    mlVar.wn(j3 - j2);
                                    mlVar.erW = (long) aeU.scene;
                                    mlVar.wo(j2);
                                    mlVar.wp(j3);
                                    mlVar.fbD = (long) str2.length();
                                    mlVar.fbm = mlVar.x("path", com.tencent.mm.compatible.util.q.encode(str), true);
                                    try {
                                        t k = ((ag) NN()).getRuntime().bsD().k(((ag) NN()).nqU);
                                        if (k != null) {
                                            mlVar.fcq = mlVar.x("referrer", k.getCurrentPageView().lBI, true);
                                        }
                                    } catch (NullPointerException e2) {
                                    }
                                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                                    mlVar.fbF = com.tencent.mm.plugin.appbrand.report.quality.c.z((ag) NN());
                                    if (!str2.startsWith("//XWEB_SCRIPT:") || !this.nrn.contains(str)) {
                                        j4 = 0;
                                    } else {
                                        j4 = 1;
                                    }
                                    mlVar.fbG = j4;
                                    StringBuilder sb = new StringBuilder();
                                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                                    mlVar.faI = mlVar.x("engineVersion", sb.append(com.tencent.mm.plugin.appbrand.report.quality.c.bVa()).toString(), true);
                                    mlVar.bfK();
                                    break;
                                }
                            } else {
                                AppMethodBeat.o(227286);
                                return;
                            }
                        }
                    } else {
                        a(str.substring(0, str.length() - 13), str, str2, z, j2, j3);
                        AppMethodBeat.o(227286);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(227286);
        } else {
            if (z) {
                a(aVar.scriptName, new d.a[]{aVar}, new boolean[]{z}, new Object[]{obj}, j2, j3);
            }
            AppMethodBeat.o(227286);
        }
    }

    private void a(String str, String str2, String str3, boolean z, long j2, long j3) {
        long j4;
        AppMethodBeat.i(227287);
        if (!isRunning()) {
            AppMethodBeat.o(227287);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, str2, j2, j3);
        } else {
            com.tencent.mm.plugin.appbrand.keylogger.c.a(getAppId(), KSProcessWeAppLaunch.stepInjectJSPageScript, "", str2, j2, j3);
        }
        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
        if (aeU != null) {
            mm mmVar = new mm();
            mmVar.zK(aeU.kEY);
            mmVar.zL(getAppId());
            mmVar.eXc = (long) aeU.nLk;
            mmVar.fcv = mm.a.my(aeU.nJE);
            mmVar.eYW = (long) aeU.apptype;
            mmVar.wq(j3 - j2);
            mmVar.erW = (long) aeU.scene;
            mmVar.wr(j2);
            mmVar.ws(j3);
            mmVar.zM(str);
            mmVar.fbD = (long) Util.nullAsNil(Integer.valueOf(str3.length()));
            if (!str3.startsWith("//XWEB_SCRIPT:") || !this.nrn.contains(str2)) {
                j4 = 0;
            } else {
                j4 = 1;
            }
            mmVar.fbG = j4;
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            mmVar.fbF = com.tencent.mm.plugin.appbrand.report.quality.c.z((ag) NN());
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            mmVar.zN(sb.append(com.tencent.mm.plugin.appbrand.report.quality.c.bVa()).toString());
            mmVar.bfK();
        }
        AppMethodBeat.o(227287);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.page.a
    public final com.tencent.mm.plugin.appbrand.performance.g bQs() {
        AppMethodBeat.i(175035);
        com.tencent.mm.plugin.appbrand.performance.i iVar = new com.tencent.mm.plugin.appbrand.performance.i((ag) NN());
        AppMethodBeat.o(175035);
        return iVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.file.w.b
    public final void a(String str, d.a[] aVarArr, boolean[] zArr, Object[] objArr, long j2, long j3) {
        AppMethodBeat.i(227288);
        if (TextUtils.isEmpty(str) && BuildInfo.DEBUG) {
            str = UUID.randomUUID().toString();
        }
        if (TextUtils.isEmpty(str) || aVarArr.length == 0 || zArr.length == 0) {
            AppMethodBeat.o(227288);
            return;
        }
        boolean z = true;
        int length = aVarArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (aVarArr[i2] != null) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            AppMethodBeat.o(227288);
            return;
        }
        long j4 = 0;
        for (d.a aVar : aVarArr) {
            if (aVar != null) {
                j4 += (long) aVar.czA;
            }
        }
        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
        if (aeU != null) {
            mm mmVar = new mm();
            mmVar.zK(aeU.kEY);
            mmVar.zL(getAppId());
            mmVar.eXc = (long) aeU.nLk;
            mmVar.fcv = mm.a.my(aeU.nJE);
            mmVar.eYW = (long) aeU.apptype;
            mmVar.wq(j3 - j2);
            mmVar.erW = (long) aeU.scene;
            mmVar.wr(j2);
            mmVar.ws(j3);
            mmVar.fbD = j4;
            mmVar.fbG = 0;
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            mmVar.fbF = com.tencent.mm.plugin.appbrand.report.quality.c.z((ag) NN());
            StringBuilder sb = new StringBuilder();
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            mmVar.zN(sb.append(com.tencent.mm.plugin.appbrand.report.quality.c.bVa()).toString());
            mmVar.zO(str);
            mmVar.bfK();
        }
        AppMethodBeat.o(227288);
    }

    public final int OJ() {
        AppMethodBeat.i(47846);
        int i2 = ((q) super.NP()).bsC().appVersion;
        AppMethodBeat.o(47846);
        return i2;
    }

    public final am bRI() {
        if (this.nmX instanceof am) {
            return (am) this.nmX;
        }
        if (this.nmX instanceof at) {
            bb bbVar = ((at) this.nmX).nsV;
            if (bbVar instanceof am) {
                return (am) bbVar;
            }
        }
        return null;
    }

    @Override // com.tencent.luggage.sdk.b.a.b.a
    public final /* bridge */ /* synthetic */ com.tencent.luggage.sdk.d.d NP() {
        AppMethodBeat.i(47863);
        q qVar = (q) super.NP();
        AppMethodBeat.o(47863);
        return qVar;
    }
}
