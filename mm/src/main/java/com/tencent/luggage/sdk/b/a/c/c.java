package com.tencent.luggage.sdk.b.a.c;

import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.b;
import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaRuntimeModulePluginListMap;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.q;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.skia_canvas.external_texture.SkiaCanvasExternalTextureManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c<Service extends d> extends f<Service> {
    volatile boolean cAU = false;
    private volatile boolean cAV = false;
    private volatile boolean cAW = false;
    private final LinkedList<Runnable> cAX = new LinkedList<>();
    private final Map<String, Boolean> cAY = new HashMap();
    private com.tencent.luggage.sdk.b.a.a.c cwb;
    private com.tencent.luggage.sdk.b.a.a.d cwd;

    public static class a implements b.a {
    }

    public static final class b {
        public String cBe;
        public String cBf;
        public String name;
        public String source;
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(182986);
        cVar.Oi();
        AppMethodBeat.o(182986);
    }

    public c(Service service) {
        super(service);
        AppMethodBeat.i(146798);
        AppMethodBeat.o(146798);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public i Mk() {
        AppMethodBeat.i(146799);
        com.tencent.mm.plugin.appbrand.m.c cVar = new com.tencent.mm.plugin.appbrand.m.c((byte) 0);
        AppMethodBeat.o(146799);
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void Ml() {
        AppMethodBeat.i(146800);
        super.Ml();
        final i jsRuntime = ((d) NN()).getJsRuntime();
        t tVar = (t) jsRuntime.R(t.class);
        if (tVar != null) {
            b a2 = a(tVar);
            jsRuntime.addJavascriptInterface(a2, "WeixinJSContext");
            jsRuntime.evaluateJavascript(h.cBq, null);
            a2.MJ();
            this.cAU = true;
        } else {
            this.cAU = false;
        }
        jsRuntime.setJsExceptionHandler(new h() {
            /* class com.tencent.luggage.sdk.b.a.c.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.m.h
            public final void u(String str, String str2) {
                AppMethodBeat.i(146789);
                Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "hy: wxa main context exception %s %s", str, str2);
                String format = String.format("{'message':'%s', 'stack': '%s'}", r.afJ(str), r.afJ(str2));
                cx.a(jsRuntime, "onError", format, 0);
                c.this.z(str, str2);
                Log.e("MicroMsg.AppBrand.JsRuntimeException", format);
                AppMethodBeat.o(146789);
            }
        });
        this.cwb = new com.tencent.luggage.sdk.b.a.a.c();
        this.cwb.a(jsRuntime, NN());
        this.cwd = new com.tencent.luggage.sdk.b.a.a.d();
        this.cwd.a(((d) NN()).getJsRuntime(), NN(), 0);
        com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.a(jsRuntime, (s) NN());
        AppMethodBeat.o(146800);
    }

    /* access modifiers changed from: protected */
    public void z(String str, String str2) {
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean Mj() {
        return this.cAU;
    }

    /* access modifiers changed from: protected */
    public String My() {
        AppMethodBeat.i(146801);
        String str = ((("" + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js")) + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/shared_buffer.js")) + com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/lazy_load.js")) + com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.bMc();
        AppMethodBeat.o(146801);
        return str;
    }

    /* access modifiers changed from: protected */
    public b a(t tVar) {
        AppMethodBeat.i(160992);
        i iVar = new i((d) NN(), tVar);
        AppMethodBeat.o(160992);
        return iVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void c(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(146803);
        super.c(appBrandRuntime);
        Objects.requireNonNull(NN());
        if (this.cwd != null) {
            this.cwd.a(((d) NN()).getJsRuntime(), (k) NN());
        }
        Mq();
        appBrandRuntime.b(ag.class, new al(appBrandRuntime));
        com.tencent.mm.plugin.appbrand.jsapi.ag.b.d.a((com.tencent.mm.plugin.appbrand.f.b) ((d) NN()).M(com.tencent.mm.plugin.appbrand.f.b.class), (com.tencent.mm.plugin.appbrand.f.a) ((d) NN()).M(com.tencent.mm.plugin.appbrand.f.a.class), (s) NN());
        Log.i("MicroMsg.AppBrand.VideoCanvas.XWebVideoCanvasLogic", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        SkiaCanvasExternalTextureManager.getInstance().registerPlugin(com.tencent.mm.plugin.appbrand.i.a.bCz());
        AppMethodBeat.o(146803);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void Mw() {
        AppMethodBeat.i(146804);
        super.Mw();
        Mq();
        AppMethodBeat.o(146804);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void Mx() {
        AppMethodBeat.i(146805);
        super.Mx();
        try {
            i jsRuntime = ((d) NN()).getJsRuntime();
            if (jsRuntime == null) {
                AppMethodBeat.o(146805);
                return;
            }
            q qVar = (q) jsRuntime.R(q.class);
            if (qVar != null) {
                qVar.setThreadPriority(10);
            }
            AppMethodBeat.o(146805);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", th, "[CAPTURED CRASH]", new Object[0]);
            AppMethodBeat.o(146805);
        }
    }

    private void Mq() {
        AppMethodBeat.i(146806);
        try {
            i jsRuntime = ((d) NN()).getJsRuntime();
            if (jsRuntime == null) {
                AppMethodBeat.o(146806);
                return;
            }
            q qVar = (q) jsRuntime.R(q.class);
            if (qVar != null) {
                qVar.setThreadPriority(-2);
            }
            AppMethodBeat.o(146806);
        } catch (Throwable th) {
            Log.printErrStackTrace("Luggage.AppBrandMiniProgramServiceLogicImp", th, "[CAPTURED CRASH]", new Object[0]);
            AppMethodBeat.o(146806);
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void c(JSONObject jSONObject) {
        AppMethodBeat.i(146807);
        super.c(jSONObject);
        ((d) NN()).c(jSONObject, "isLazyLoad", Boolean.valueOf(((aa) ((d) NN()).NP().av(aa.class)).bRa()));
        AppMethodBeat.o(146807);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void Mm() {
        AppMethodBeat.i(146809);
        super.Mm();
        if (this.cwb != null) {
            this.cwb.a(((d) NN()).getJsRuntime());
        }
        if (this.cwd != null) {
            this.cwd.b(((d) NN()).getJsRuntime());
        }
        AppMethodBeat.o(146809);
    }

    /* access modifiers changed from: protected */
    public int Mz() {
        return 0;
    }

    private void bW(final boolean z) {
        AppMethodBeat.i(146812);
        if (!this.cAV) {
            bc.a((com.tencent.mm.plugin.appbrand.d) NN(), ((d) NN()).getJsRuntime());
            String My = My();
            final long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.plugin.appbrand.utils.s.a(((d) NN()).getJsRuntime(), My, new s.a() {
                /* class com.tencent.luggage.sdk.b.a.c.c.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                public final void onSuccess(String str) {
                    int i2;
                    AppMethodBeat.i(146790);
                    Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Success");
                    long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    if (z) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    x.a(3, currentTimeMillis, i2, ((d) c.this.NN()).getAppId(), -1, 0, ((d) c.this.NN()).bqZ().bvd());
                    AppMethodBeat.o(146790);
                }

                @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                public final void du(String str) {
                    AppMethodBeat.i(146791);
                    Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "Inject EnvBootstrapScript Script Failed");
                    AppMethodBeat.o(146791);
                }
            });
            b Oj = Oj();
            String str = Oj.name;
            String str2 = Oj.source;
            com.tencent.mm.plugin.appbrand.utils.t.a((com.tencent.mm.plugin.appbrand.s) NN(), ((d) NN()).getJsRuntime(), str, TextUtils.isEmpty(Oj.cBe) ? str : Oj.cBe, TextUtils.isEmpty(Oj.cBf) ? "v" + ((d) NN()).bqZ().bvd() : Oj.cBf, Mz(), str2, t.a.LIB, new C0182c(str, str2, (d) NN(), z, (byte) 0));
            this.cAV = true;
        }
        AppMethodBeat.o(146812);
    }

    /* access modifiers changed from: protected */
    public void Ok() {
    }

    @Override // com.tencent.mm.plugin.appbrand.p.f
    public final boolean dt(final String str) {
        boolean z;
        AppMethodBeat.i(229851);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(229851);
            return false;
        }
        synchronized (this.cAY) {
            try {
                Boolean bool = this.cAY.get(str);
                if (bool == null || !bool.booleanValue()) {
                    this.cAY.put(str, Boolean.TRUE);
                    Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", getAppId(), str);
                    AnonymousClass3 r1 = new Runnable() {
                        /* class com.tencent.luggage.sdk.b.a.c.c.AnonymousClass3 */

                        public final void run() {
                            List<WxaPluginPkgInfo> Vz;
                            AppMethodBeat.i(146792);
                            if (c.this.cAU) {
                                try {
                                    g gVar = new g(str);
                                    com.tencent.mm.plugin.appbrand.s sVar = (com.tencent.mm.plugin.appbrand.s) Objects.requireNonNull(c.this.NN());
                                    p.h(sVar, "service");
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put("moduleName", gVar.cBp);
                                        AppBrandSysConfigLU appBrandSysConfigLU = (AppBrandSysConfigLU) sVar.av(AppBrandSysConfigLU.class);
                                        WxaRuntimeModulePluginListMap wxaRuntimeModulePluginListMap = (appBrandSysConfigLU != null ? appBrandSysConfigLU.leE : null).kOb;
                                        if (!(wxaRuntimeModulePluginListMap == null || (Vz = wxaRuntimeModulePluginListMap.Vz(gVar.cBp)) == null)) {
                                            JSONArray jSONArray = new JSONArray();
                                            for (T t : Vz) {
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put("plugin_id", t.provider);
                                                jSONObject2.put("custom_version", t.stringVersion);
                                                jSONObject2.put("prefix_path", t.prefixPath);
                                                jSONObject2.put("inner_version", t.version);
                                                jSONArray.put(jSONObject2);
                                            }
                                            jSONObject.put("separatedPlugins", jSONArray);
                                        }
                                        String jSONObject3 = jSONObject.toString();
                                        p.g(jSONObject3, "try {\n            JSONOb…         return\n        }");
                                        Log.i(gVar.TAG, "dispatch appId(" + sVar.getAppId() + ") onSubPackageReady(" + jSONObject3 + ')');
                                        sVar.ck("onSubPackageReady", jSONObject3);
                                        AppMethodBeat.o(146792);
                                    } catch (JSONException e2) {
                                        Log.e(gVar.TAG, "dispatch with service(" + sVar.getAppId() + "), create data failed");
                                        AppMethodBeat.o(146792);
                                    }
                                } catch (Exception e3) {
                                    Log.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
                                    AppMethodBeat.o(146792);
                                }
                            } else if (ModulePkgInfo.MAIN_MODULE_NAME.equals(str)) {
                                c.a(c.this);
                                AppMethodBeat.o(146792);
                            } else {
                                String str = str + (str.endsWith(FilePathGenerator.ANDROID_DIR_SEP) ? "" : FilePathGenerator.ANDROID_DIR_SEP) + "app-service.js";
                                com.tencent.mm.plugin.appbrand.utils.t.a(((d) c.this.NN()).NP(), ((d) c.this.NN()).getJsRuntime(), com.tencent.mm.vfs.aa.z(bg.M(((d) c.this.NN()).NP()).UT(str).mFile.her()), str, "", "", t.a.USR, new d(str, (d) c.this.NN(), (byte) 0));
                                AppMethodBeat.o(146792);
                            }
                        }
                    };
                    if (NN() == null) {
                        Log.w("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
                    } else if (((d) NN()).isRunning()) {
                        r1.run();
                    } else {
                        synchronized (this.cAX) {
                            try {
                                this.cAX.add(r1);
                            } catch (Throwable th) {
                                AppMethodBeat.o(229851);
                                throw th;
                            }
                        }
                    }
                    z = true;
                } else {
                    Log.i("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", getAppId(), str);
                    z = false;
                }
            } finally {
                AppMethodBeat.o(229851);
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void MD() {
        AppMethodBeat.i(146814);
        bW(true);
        ((d) NN()).bEc();
        AppMethodBeat.o(146814);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.luggage.sdk.b.a.c.c$c  reason: collision with other inner class name */
    public static class C0182c implements s.b {
        private final d cBg;
        private final boolean cBh;
        private final String cwh;
        private final String cwi;
        private final long cwj;
        private boolean cwk;
        private m.c cwl;
        private final AtomicInteger cwm;

        /* synthetic */ C0182c(String str, String str2, d dVar, boolean z, byte b2) {
            this(str, str2, dVar, z);
        }

        private C0182c(String str, String str2, d dVar, boolean z) {
            AppMethodBeat.i(146793);
            this.cwk = false;
            this.cwl = null;
            this.cwm = new AtomicInteger(2);
            this.cwh = str;
            this.cwi = str2;
            this.cBg = dVar;
            this.cBh = z;
            this.cwj = System.currentTimeMillis();
            AppMethodBeat.o(146793);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.b
        public final void a(m.c cVar) {
            AppMethodBeat.i(146794);
            this.cwl = cVar;
            MG();
            AppMethodBeat.o(146794);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.a
        public final void onSuccess(String str) {
            int i2 = 1;
            AppMethodBeat.i(146795);
            this.cwk = true;
            MG();
            if (this.cwh.equals("WAService.js")) {
                long currentTimeMillis = System.currentTimeMillis() - this.cwj;
                if (!this.cBh) {
                    i2 = 0;
                }
                x.a(2, currentTimeMillis, i2, this.cBg.getAppId(), -1, 0, this.cBg.bqZ().bvd());
            }
            AppMethodBeat.o(146795);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.a
        public final void du(String str) {
            AppMethodBeat.i(146796);
            this.cwk = false;
            MG();
            AppMethodBeat.o(146796);
        }

        private void MG() {
            AppMethodBeat.i(146797);
            if (this.cwm.decrementAndGet() == 0) {
                long j2 = this.cwl == null ? this.cwj : this.cwl.dqk;
                long currentTimeMillis = this.cwl == null ? System.currentTimeMillis() : this.cwl.dql;
                d.a aVar = new d.a();
                aVar.scriptName = this.cwh;
                aVar.czz = this.cwi;
                aVar.czA = Util.nullAsNil(this.cwi).length();
                this.cBg.a(aVar, this.cwk, j2, currentTimeMillis, this.cwl);
            }
            AppMethodBeat.o(146797);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d implements s.b {
        private final d cBg;
        private int cBi;
        private final String cwh;
        private final long cwj;
        private boolean cwk;
        private m.c cwl;
        private final AtomicInteger cwm;

        /* synthetic */ d(String str, d dVar, byte b2) {
            this(str, dVar);
        }

        private d(String str, d dVar) {
            AppMethodBeat.i(169433);
            this.cBi = 0;
            this.cwk = false;
            this.cwl = null;
            this.cwm = new AtomicInteger(2);
            this.cwh = str;
            this.cBg = dVar;
            this.cwj = System.currentTimeMillis();
            AppMethodBeat.o(169433);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.b
        public final void a(m.c cVar) {
            AppMethodBeat.i(169434);
            this.cwl = cVar;
            this.cBi = cVar.sourceLength;
            MG();
            AppMethodBeat.o(169434);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.a
        public final void onSuccess(String str) {
            AppMethodBeat.i(169435);
            this.cwk = true;
            MG();
            AppMethodBeat.o(169435);
        }

        @Override // com.tencent.mm.plugin.appbrand.utils.s.a
        public final void du(String str) {
            AppMethodBeat.i(169436);
            this.cwk = false;
            MG();
            AppMethodBeat.o(169436);
        }

        private void MG() {
            AppMethodBeat.i(169437);
            if (this.cwm.decrementAndGet() == 0) {
                long j2 = this.cwl == null ? this.cwj : this.cwl.dqk;
                long currentTimeMillis = this.cwl == null ? System.currentTimeMillis() : this.cwl.dql;
                d.a aVar = new d.a();
                aVar.scriptName = this.cwh;
                aVar.czA = this.cBi;
                this.cBg.a(aVar, this.cwk, j2, currentTimeMillis, this.cwl);
            }
            AppMethodBeat.o(169437);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.luggage.sdk.b.a.c.f
    public void MC() {
        AppMethodBeat.i(146808);
        if (!this.cAV) {
            ((d) NN()).getJsRuntime().evaluateJavascript(com.tencent.mm.plugin.appbrand.ac.d.afA("wxa_library/android.js"), null);
        }
        ((d) NN()).Os();
        bW(false);
        Oi();
        LinkedList linkedList = new LinkedList();
        synchronized (this.cAX) {
            try {
                linkedList.addAll(this.cAX);
            } catch (Throwable th) {
                AppMethodBeat.o(146808);
                throw th;
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        Om();
        AppMethodBeat.o(146808);
    }

    private void Oi() {
        AppMethodBeat.i(146810);
        if (this.cAU) {
            AppMethodBeat.o(146810);
        } else if (this.cAW) {
            AppMethodBeat.o(146810);
        } else {
            Ok();
            String str = ((d) NN()).NP().OM().leE.pkgPath;
            if (TextUtils.isEmpty(str)) {
                AppMethodBeat.o(146810);
                return;
            }
            com.tencent.mm.plugin.appbrand.utils.t.a(((d) NN()).NP(), ((d) NN()).getJsRuntime(), str, "app-service.js", "", "", t.a.USR, new d("app-service.js", (d) NN(), (byte) 0));
            this.cAW = true;
            AppMethodBeat.o(146810);
        }
    }

    private b Oj() {
        String str;
        String str2;
        AppMethodBeat.i(146811);
        if (this.cAU) {
            str = ((d) NN()).bqZ().UM("WAServiceMainContext.js");
            str2 = "WAServiceMainContext.js";
        } else {
            str = null;
            str2 = null;
        }
        if (TextUtils.isEmpty(str)) {
            str2 = "WAService.js";
            str = ((d) NN()).bqZ().UM(str2);
        }
        b bVar = new b();
        bVar.name = str2;
        bVar.source = str;
        AppMethodBeat.o(146811);
        return bVar;
    }
}
