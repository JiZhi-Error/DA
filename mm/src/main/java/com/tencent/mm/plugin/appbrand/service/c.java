package com.tencent.mm.plugin.appbrand.service;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.h.l;
import com.tencent.luggage.sdk.b.a.a.d;
import com.tencent.luggage.sdk.b.a.b;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.ag.a;
import com.tencent.mm.plugin.appbrand.bb;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.i;
import com.tencent.mm.plugin.appbrand.jsapi.o.j;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.platform.window.a.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends d implements f {
    protected q kBw;
    private JSONObject nMo;
    private final o nrx;

    @Override // com.tencent.luggage.sdk.b.a.c.d
    public /* synthetic */ com.tencent.luggage.sdk.d.d NP() {
        AppMethodBeat.i(48304);
        q runtime = getRuntime();
        AppMethodBeat.o(48304);
        return runtime;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.d
    public final /* synthetic */ com.tencent.luggage.sdk.b.a.c Oq() {
        AppMethodBeat.i(48305);
        ag bsz = bsz();
        AppMethodBeat.o(48305);
        return bsz;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public final /* synthetic */ x Ox() {
        AppMethodBeat.i(48308);
        a Ov = Ov();
        AppMethodBeat.o(48308);
        return Ov;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public final /* synthetic */ ac getCurrentPageView() {
        AppMethodBeat.i(48307);
        ag bsz = bsz();
        AppMethodBeat.o(48307);
        return bsz;
    }

    static {
        AppMethodBeat.i(48309);
        w.bMH();
        AppMethodBeat.o(48309);
    }

    public c() {
        this(new c.a());
        AppMethodBeat.i(48285);
        AppMethodBeat.o(48285);
    }

    public c(b.a aVar) {
        super(aVar);
        boolean z;
        AppMethodBeat.i(48286);
        this.nMo = null;
        this.nrx = new o();
        if (WeChatEnvironment.hasDebugger() || BuildInfo.IS_FLAVOR_RED) {
            z = true;
        } else {
            z = false;
        }
        this.kAU = z;
        a(d.b.class, new j());
        a(com.tencent.luggage.sdk.b.a.a.b.class, new i());
        AppMethodBeat.o(48286);
    }

    public final ag bsz() {
        AppMethodBeat.i(48288);
        ag agVar = (ag) super.ax(ag.class);
        AppMethodBeat.o(48288);
        return agVar;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.d
    public final a Ov() {
        AppMethodBeat.i(48289);
        AnonymousClass1 r0 = new a(this) {
            /* class com.tencent.mm.plugin.appbrand.service.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.ag.a, com.tencent.mm.plugin.appbrand.x
            public final v bti() {
                AppMethodBeat.i(48278);
                com.tencent.mm.plugin.appbrand.ag.d dVar = new com.tencent.mm.plugin.appbrand.ag.d(this.dra);
                AppMethodBeat.o(48278);
                return dVar;
            }
        };
        AppMethodBeat.o(48289);
        return r0;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public void d(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(48290);
        this.kBw = (q) appBrandRuntime;
        if (bqZ() == null) {
            a(((q) appBrandRuntime).bqZ());
        }
        bEb();
        super.d(appBrandRuntime);
        AppMethodBeat.o(48290);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.d
    public final f.b Ow() {
        AppMethodBeat.i(48291);
        com.tencent.mm.plugin.appbrand.permission.a aVar = new com.tencent.mm.plugin.appbrand.permission.a(getRuntime(), this);
        AppMethodBeat.o(48291);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public final void Mx() {
        AppMethodBeat.i(48292);
        Log.i("MicroMsg.AppBrandServiceWC", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent ");
        new n() {
            /* class com.tencent.mm.plugin.appbrand.service.c.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.s, com.tencent.mm.plugin.appbrand.jsapi.bc
            public final /* synthetic */ bc L(Map map) {
                AppMethodBeat.i(48280);
                s K = K(map);
                AppMethodBeat.o(48280);
                return K;
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.s
            public final s K(Map<String, Object> map) {
                AppMethodBeat.i(48279);
                JSONObject jSONObject = new JSONObject(map);
                q runtime = c.this.getRuntime();
                try {
                    Pair<Integer, String> t = com.tencent.mm.plugin.appbrand.report.model.d.t((ag) runtime.brh().getCurrentPage().getCurrentPageView());
                    jSONObject.put("targetAction", ((Integer) t.first).intValue());
                    jSONObject.put("targetPagePath", (String) t.second);
                    jSONObject.put("usedState", runtime.ON().cyA.nHt);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", e2);
                }
                super.Zg(jSONObject.toString());
                AppMethodBeat.o(48279);
                return this;
            }
        }.ae(getRuntime());
        this.cBj.Mx();
        AppMethodBeat.o(48292);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final com.tencent.mm.plugin.appbrand.page.o bsY() {
        AppMethodBeat.i(175076);
        AnonymousClass3 r0 = new com.tencent.mm.plugin.appbrand.page.o() {
            /* class com.tencent.mm.plugin.appbrand.service.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.page.o
            public final void a(AppBrandRuntime appBrandRuntime, boolean z, JSONObject jSONObject) {
                AppMethodBeat.i(175075);
                super.a(appBrandRuntime, z, jSONObject);
                try {
                    jSONObject.put("scene", c.this.getRuntime().ON().cyA.scene);
                } catch (JSONException e2) {
                }
                try {
                    JSONObject ND = c.this.getRuntime().bsC().ND();
                    if (ND != null) {
                        jSONObject.put("shareInfo", ND);
                    }
                } catch (JSONException e3) {
                }
                q runtime = c.this.getRuntime();
                if (z) {
                    com.tencent.mm.plugin.appbrand.report.model.d.b(runtime, jSONObject);
                    com.tencent.mm.plugin.appbrand.report.model.d.a(runtime, jSONObject);
                    AppMethodBeat.o(175075);
                    return;
                }
                try {
                    com.tencent.mm.plugin.appbrand.report.model.d.c(runtime, jSONObject);
                    com.tencent.mm.plugin.appbrand.report.model.d.a(runtime, jSONObject);
                    h.b bVar = runtime.bsD().getReporter().bOz().bUH().nII;
                    jSONObject.put("referpagepath", bVar == null ? null : bVar.path);
                    jSONObject.put("clickTimestamp", runtime.bsC().startTime);
                    AppMethodBeat.o(175075);
                } catch (Exception e4) {
                    Log.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterForeground ex = %s", e4);
                    AppMethodBeat.o(175075);
                }
            }
        };
        AppMethodBeat.o(175076);
        return r0;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.jsapi.l
    public final void d(JSONObject jSONObject) {
        AppMethodBeat.i(48294);
        super.d(jSONObject);
        c(jSONObject, "useClipboardWithPermissionNotify", Boolean.valueOf(MMEditText.gYE()));
        JSONObject jSONObject2 = new JSONObject();
        c(jSONObject2, "env", "WeChat");
        c(jSONObject2, "version", Integer.valueOf(com.tencent.mm.protocal.d.KyO));
        c(jSONObject, "host", jSONObject2);
        AppMethodBeat.o(48294);
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public final JSONObject Or() {
        AppMethodBeat.i(48295);
        if (this.nMo != null) {
            JSONObject f2 = com.tencent.luggage.sdk.g.b.f(this.nMo);
            AppMethodBeat.o(48295);
            return f2;
        }
        JSONObject Or = super.Or();
        if (getRuntime().getAppConfig().lbR.booleanValue()) {
            this.nMo = com.tencent.luggage.sdk.g.b.f(Or);
        }
        AppMethodBeat.o(48295);
        return Or;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.d
    public final void e(JSONObject jSONObject) {
        boolean z;
        JSONObject jSONObject2;
        int i2;
        AppMethodBeat.i(48296);
        c(jSONObject, "debug", Boolean.valueOf(this.kBw.bsB().cyC));
        if (com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId()) != null) {
            c(jSONObject, "preloadType", Long.valueOf(com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId()).bVg()));
        }
        JSONObject jSONObject3 = new JSONObject();
        String brs = this.kBw.brs();
        c(jSONObject3, "path", l.dM(brs));
        c(jSONObject3, SearchIntents.EXTRA_QUERY, new JSONObject(l.dN(brs)));
        c(jSONObject3, "referrerInfo", this.kBw.bsC().NF());
        c(jSONObject3, "shareInfo", this.kBw.bsC().ND());
        String str = this.kBw.bsC().kHQ;
        if (!TextUtils.isEmpty(str)) {
            c(jSONObject3, "shortLink", str);
        }
        com.tencent.mm.plugin.appbrand.report.model.d.b(this.kBw, jSONObject3);
        com.tencent.mm.plugin.appbrand.report.model.d.a(this.kBw, jSONObject);
        AppBrandSysConfigWC bsB = this.kBw.bsB();
        JSONObject jSONObject4 = new JSONObject();
        c(jSONObject4, "maxRequestConcurrent", Integer.valueOf(bsB.cyK));
        c(jSONObject4, "maxUploadConcurrent", Integer.valueOf(bsB.cyL));
        c(jSONObject4, "maxDownloadConcurrent", Integer.valueOf(bsB.cyM));
        c(jSONObject4, "maxWebsocketConnect", Integer.valueOf(bsB.cyN));
        c(jSONObject4, "maxWorkerConcurrent", Integer.valueOf(bsB.cyO));
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("env");
            if (optJSONObject == null) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject.put("env", jSONObject5);
                jSONObject2 = jSONObject5;
            } else {
                jSONObject2 = optJSONObject;
            }
            jSONObject2.put("USER_DATA_PATH", bb.r(this.kBw) ? "wxfile://singlepage" : "wxfile://usr");
            jSONObject2.put("OPEN_DATA_PATH", "wxfile://opendata");
            jSONObject2.put("CLIENT_DATA_PATH", "wxfile://clientdata");
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_game_splashscreen, false)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            jSONObject2.put("HAS_SPLASHSCREEN", i2);
        } catch (Exception e2) {
        }
        c(jSONObject, "appLaunchInfo", jSONObject3);
        c(jSONObject, "wxAppInfo", jSONObject4);
        c(jSONObject, "isPluginMiniProgram", Boolean.valueOf(getRuntime().bsr()));
        c(jSONObject, "envVersion", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b.xj(this.kBw.bsC().eix).name().toLowerCase());
        JSONObject jSONObject6 = new JSONObject();
        try {
            jSONObject6 = new JSONObject(this.kBw.bsC().cyv.lgZ);
        } catch (Exception e3) {
        }
        try {
            if (!Util.isNullOrNil(bsB.cyI)) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("jsonInfo", new JSONObject(bsB.cyI));
                c(jSONObject6, "operationInfo", jSONObject7);
            }
        } catch (Exception e4) {
            Log.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put operationInfo to appContactInfo fail", e4);
        }
        if (!TextUtils.isEmpty(getRuntime().bsC().cyw)) {
            try {
                jSONObject6.put("passThroughInfo", new JSONObject(getRuntime().bsC().cyw));
            } catch (JSONException e5) {
                Log.e("MicroMsg.AppBrandServiceWC", "postProcessConfig, put passThroughInfo get exception:%s", e5);
            }
        }
        c(jSONObject, "appContactInfo", jSONObject6);
        c(jSONObject, "accountInfo", this.kBw.bsC().NE());
        c(jSONObject, "supportAsyncAudio", Boolean.TRUE);
        if (this.kBw.bsC().cyz == com.tencent.luggage.sdk.launching.b.PRE_RENDER) {
            z = true;
        } else {
            z = false;
        }
        c(jSONObject, "prerender", Boolean.valueOf(z));
        super.e(jSONObject);
        AppMethodBeat.o(48296);
    }

    private String bVq() {
        AppMethodBeat.i(48297);
        String str = null;
        if (AppBrandPerformanceManager.e(getRuntime())) {
            str = bqZ().UM("WAPerf.js");
        }
        AppMethodBeat.o(48297);
        return str;
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final void a(String str, long j2, long j3, Object obj) {
        long j4;
        long j5;
        AppMethodBeat.i(227431);
        if (!isRunning()) {
            AppMethodBeat.o(227431);
            return;
        }
        long j6 = 0;
        if (obj instanceof m.c) {
            m.c cVar = (m.c) obj;
            if (cVar.dqk > 0 && cVar.dql > 0) {
                j2 = cVar.dqk;
                j3 = cVar.dql;
            }
            j6 = cVar.flatJSCompileCost;
            j4 = j3;
            j5 = j2;
        } else {
            j4 = j3;
            j5 = j2;
        }
        com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
        com.tencent.mm.plugin.appbrand.report.quality.c.a(this, str, j5, j4, this.cBj.Mj(), j6);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig, "wxConfig", j5, j4);
        com.tencent.mm.plugin.appbrand.keylogger.c.a(getRuntime().mAppId, KSProcessWeAppLaunch.stepInjectWxConfig_Game, "wxConfig", j5, j4);
        AppMethodBeat.o(227431);
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public void MC() {
        AppMethodBeat.i(48299);
        QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(getAppId());
        if (aeU != null) {
            aeU.nLD = Util.nowMilliSecond();
        }
        super.MC();
        AppMethodBeat.o(48299);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.d
    public final void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
        AppMethodBeat.i(175077);
        String str = aVar.scriptName;
        Log.d("MicroMsg.AppBrandServiceWC", "reportBootstrapScriptEvaluateResult appId[%s] name[%s] succeed[%b]", getAppId(), str, Boolean.valueOf(z));
        k kVar = k.nHq;
        k.a(this, aVar, z, j2, j3, obj);
        if ("WAService.js".equals(str)) {
            String bVq = isRunning() ? bVq() : null;
            if (!Util.isNullOrNil(bVq)) {
                com.tencent.mm.plugin.appbrand.utils.s.a(getJsRuntime(), bVq, new s.a() {
                    /* class com.tencent.mm.plugin.appbrand.service.c.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                    public final void onSuccess(String str) {
                        AppMethodBeat.i(48283);
                        Log.i("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Success");
                        AppMethodBeat.o(48283);
                    }

                    @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                    public final void du(String str) {
                        AppMethodBeat.i(48284);
                        Log.e("MicroMsg.AppBrandServiceWC", "Inject performanceJs Script Failed");
                        AppMethodBeat.o(48284);
                    }
                });
            }
        }
        AppMethodBeat.o(175077);
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.jsapi.k
    public q getRuntime() {
        AppMethodBeat.i(48302);
        q qVar = (q) super.NP();
        AppMethodBeat.o(48302);
        return qVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g, com.tencent.mm.plugin.appbrand.d
    public com.tencent.mm.plugin.appbrand.appstorage.q getFileSystem() {
        AppMethodBeat.i(48303);
        if (!isRunning()) {
            com.tencent.mm.plugin.appbrand.appstorage.q btJ = e.btJ();
            AppMethodBeat.o(48303);
            return btJ;
        }
        com.tencent.mm.plugin.appbrand.appstorage.q fileSystem = super.getFileSystem();
        AppMethodBeat.o(48303);
        return fileSystem;
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final void b(com.tencent.mm.plugin.appbrand.platform.window.c cVar) {
        AppMethodBeat.i(175079);
        if (cVar == null) {
            Log.w("MicroMsg.AppBrandServiceWC", "setWindowAndroid, impl==null, appId:%s", getAppId());
            this.nrx.aG(g.aAe().azG().ca);
            super.b(this.nrx);
            AppMethodBeat.o(175079);
            return;
        }
        if (cVar.compareTo(this.kEb) != 0) {
            Log.i("MicroMsg.AppBrandServiceWC", "setWindowAndroid changed, old:%s, new:%s, appId:%s, stack:%s", this.kEb, cVar, getAppId(), android.util.Log.getStackTraceString(new Throwable()));
            super.b(cVar);
        }
        AppMethodBeat.o(175079);
    }

    public final boolean Mj() {
        AppMethodBeat.i(261636);
        boolean Mj = this.cBj.Mj();
        AppMethodBeat.o(261636);
        return Mj;
    }
}
