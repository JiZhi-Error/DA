package com.tencent.mm.plugin.appbrand.service;

import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.magicbrush.f;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.appbrand.an;
import com.tencent.mm.plugin.appbrand.game.a.m;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.jsapi.b.a;
import com.tencent.mm.plugin.appbrand.m.aa;
import com.tencent.mm.plugin.appbrand.m.ad;
import com.tencent.mm.plugin.appbrand.m.af;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.p;
import com.tencent.mm.plugin.appbrand.m.t;
import com.tencent.mm.plugin.appbrand.m.w;
import com.tencent.mm.plugin.appbrand.m.x;
import com.tencent.mm.plugin.appbrand.report.e;
import com.tencent.mm.plugin.appbrand.report.k;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b extends c<c> implements com.tencent.luggage.game.d.a.a.c {
    private com.tencent.mm.plugin.appbrand.u.b.a nMl = null;
    private com.tencent.luggage.game.a.c nMm = null;

    public b(c cVar) {
        super(cVar);
        AppMethodBeat.i(227420);
        b(com.tencent.luggage.game.d.a.a.c.class, this);
        AppMethodBeat.o(227420);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final i Mk() {
        String str;
        byte[] bArr;
        boolean z;
        g gVar = null;
        AppMethodBeat.i(48257);
        final long currentTimeMillis = System.currentTimeMillis();
        if (((c) NN()).getContext() == null) {
            MMApplicationContext.getContext();
        }
        if (!((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_j2v8_disable_codecache, false)) {
            str = ad.bDt();
        } else {
            str = null;
        }
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_j2v8_disable_snapshot, false)) {
            bArr = null;
        } else if (q.is64BitRuntime()) {
            bArr = d.afB("wxa_library/v8_snapshot64.bin");
        } else {
            bArr = d.afB("wxa_library/v8_snapshot.bin");
        }
        int bvd = ((c) NN()).bqZ().bvd();
        an.btp();
        boolean booleanValue = ((Boolean) o.lrP.aLT()).booleanValue();
        if (!((Boolean) m.lrN.aLT()).booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        final i a2 = w.a(bvd, str, bArr, booleanValue, z, aa.q((s) NN()), (com.tencent.mm.plugin.appbrand.jsapi.g) NN());
        if (a2 instanceof x) {
            this.nMl = new com.tencent.mm.plugin.appbrand.u.a();
            this.nMl.a((s) NN(), a2);
        }
        p pVar = (p) a2.R(p.class);
        if (pVar != null) {
            final boolean bsW = ((c) NN()).bsW();
            final String appId = ((c) NN()).getAppId();
            pVar.a(new p.a() {
                /* class com.tencent.mm.plugin.appbrand.service.b.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.m.p.a
                public final void onInitialized() {
                    AppMethodBeat.i(48248);
                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                    com.tencent.mm.plugin.appbrand.report.quality.c.a(bsW ? g.WASERVICE : null, appId, currentTimeMillis, e.d(a2));
                    AppMethodBeat.o(48248);
                }
            });
        } else {
            com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
            if (((c) NN()).bsW()) {
                gVar = g.WASERVICE;
            }
            com.tencent.mm.plugin.appbrand.report.quality.c.a(gVar, ((c) NN()).getAppId(), currentTimeMillis, e.d(a2));
        }
        AppMethodBeat.o(48257);
        return a2;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean d(String str, JSONObject jSONObject) {
        AppMethodBeat.i(227421);
        if ("MediaToolKit".equals(str)) {
            aeW(null);
            AppMethodBeat.o(227421);
            return true;
        } else if ("Image".equals(str)) {
            aeW(null);
            AppMethodBeat.o(227421);
            return true;
        } else if ("OffscreenCanvas".equals(str)) {
            aeW(null);
            AppMethodBeat.o(227421);
            return true;
        } else if ("CpuProfiler".equals(str)) {
            aeW(null);
            AppMethodBeat.o(227421);
            return true;
        } else if ("HeapProfiler".equals(str)) {
            aeW(null);
            AppMethodBeat.o(227421);
            return true;
        } else if ("Box2D".equals(str)) {
            aeW("mmbox2d");
            AppMethodBeat.o(227421);
            return true;
        } else if ("Phys3D".equals(str)) {
            aeW("mmphysx");
            AppMethodBeat.o(227421);
            return true;
        } else {
            boolean d2 = super.d(str, jSONObject);
            AppMethodBeat.o(227421);
            return d2;
        }
    }

    private void aeW(String str) {
        AppMethodBeat.i(227422);
        bVp();
        if (!Util.isNullOrNil(str)) {
            if (getMagicBrush() != null) {
                getMagicBrush().dX(str);
                AppMethodBeat.o(227422);
                return;
            }
            Log.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: create magicbrush failed! %s", str);
        }
        AppMethodBeat.o(227422);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final void MC() {
        AppMethodBeat.i(227423);
        super.MC();
        AppMethodBeat.o(227423);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final void MD() {
        AppMethodBeat.i(227424);
        super.MD();
        AppMethodBeat.o(227424);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.c
    public final void z(String str, String str2) {
        AppMethodBeat.i(48258);
        super.z(str, str2);
        try {
            k.b((c) NN(), str, str2);
            AppMethodBeat.o(48258);
        } catch (Throwable th) {
            AppMethodBeat.o(48258);
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.c
    public final com.tencent.luggage.sdk.b.a.c.b a(t tVar) {
        AppMethodBeat.i(160614);
        an.btp();
        a aVar = new a((c) NN(), tVar);
        AppMethodBeat.o(160614);
        return aVar;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final String OB() {
        AppMethodBeat.i(227425);
        String bDt = af.bDt();
        AppMethodBeat.o(227425);
        return bDt;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.c
    public final String My() {
        AppMethodBeat.i(48260);
        String str = "" + super.My();
        if (this.nMl != null) {
            str = str + this.nMl.bPX();
        }
        AppMethodBeat.o(48260);
        return str;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> Nf() {
        AppMethodBeat.i(48261);
        if (NN() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e) {
            Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> bOL = com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.k.bOL();
            AppMethodBeat.o(48261);
            return bOL;
        }
        Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> map = (Map) com.tencent.luggage.sdk.g.c.a("AppBrandMiniProgramServiceLogicImpWC.onCreateJsApiPool()", new kotlin.g.a.a<Map<String, com.tencent.mm.plugin.appbrand.jsapi.p>>() {
            /* class com.tencent.mm.plugin.appbrand.service.b.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> invoke() {
                AppMethodBeat.i(48249);
                Map<String, com.tencent.mm.plugin.appbrand.jsapi.p> bEk = com.tencent.mm.plugin.appbrand.jsapi.t.bEk();
                AppMethodBeat.o(48249);
                return bEk;
            }
        });
        AppMethodBeat.o(48261);
        return map;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void d(JSONObject jSONObject) {
        AppMethodBeat.i(227426);
        super.d(jSONObject);
        try {
            jSONObject.put("clientVersion", com.tencent.mm.protocal.d.KyO);
            jSONObject.put("JSEngineName", w.c(((c) NN()).getJsRuntime()));
            com.tencent.mm.plugin.appbrand.h.a.a(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdk(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.e(com.tencent.mm.plugin.appbrand.xweb_ext.c.cds(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.b(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdo(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.c(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdr(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.d(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdq(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.f(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdz(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.h(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdu(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.g(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdv(), jSONObject);
            com.tencent.mm.plugin.appbrand.h.a.i(com.tencent.mm.plugin.appbrand.xweb_ext.c.cdx(), jSONObject);
            jSONObject.put("useXWebWebGLCanvas", com.tencent.mm.plugin.appbrand.xweb_ext.c.cdw());
            jSONObject.put("useSkiaCanvasRaf", com.tencent.mm.plugin.appbrand.xweb_ext.c.cdm());
            jSONObject.put("useNewXWebCanvasToTFP", com.tencent.mm.plugin.appbrand.xweb_ext.c.cdn());
            AppMethodBeat.o(227426);
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", e2, "attachCommonConfig error", new Object[0]);
            AppMethodBeat.o(227426);
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final void Mm() {
        AppMethodBeat.i(48262);
        super.Mm();
        if (this.nMm != null) {
            this.nMm.destroy();
        }
        AppMethodBeat.o(48262);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final void Mn() {
        AppMethodBeat.i(48263);
        super.Mn();
        if (this.nMl != null) {
            this.nMl.bPW();
        }
        AppMethodBeat.o(48263);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final void Ml() {
        AppMethodBeat.i(48264);
        super.Ml();
        if (aa.q((s) NN())) {
            Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "service initNativeTransLogic");
            aa.a(((c) NN()).getJsRuntime(), ((c) NN()).getComponentId(), getAppId());
            aa.a(((c) NN()).getJsRuntime(), ((c) NN()).getComponentId(), ((c) NN()).getComponentId(), getAppId());
        }
        AppMethodBeat.o(48264);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final void c(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(48265);
        super.c(appBrandRuntime);
        if (this.nMm != null) {
            this.nMm.b(appBrandRuntime);
        }
        AppMethodBeat.o(48265);
    }

    @Override // com.tencent.luggage.game.d.a.a.c
    public final com.tencent.magicbrush.e getMagicBrush() {
        AppMethodBeat.i(227427);
        bVp();
        if (this.nMm != null) {
            com.tencent.magicbrush.e magicBrush = this.nMm.getMagicBrush();
            AppMethodBeat.o(227427);
            return magicBrush;
        }
        AppMethodBeat.o(227427);
        return null;
    }

    private void bVp() {
        boolean z = true;
        AppMethodBeat.i(227428);
        Log.printInfoStack("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: start create magicbrush", new Object[0]);
        Object[] objArr = new Object[1];
        if (this.nMm == null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "setup magicbrush. loaded?[%b]", objArr);
        if (this.nMm != null) {
            AppMethodBeat.o(227428);
        } else if (NN() != null) {
            i jsRuntime = ((c) NN()).getJsRuntime();
            com.tencent.magicbrush.a.b.loadLibraries();
            com.tencent.magicbrush.a.b.loadLibrary("gamelog_delegate");
            this.nMm = new com.tencent.luggage.game.a.c(((c) NN()).getContext(), jsRuntime) {
                /* class com.tencent.mm.plugin.appbrand.service.b.AnonymousClass3 */

                @Override // com.tencent.luggage.game.a.d, com.tencent.luggage.game.a.c
                public final void a(f fVar) {
                    boolean z;
                    boolean z2 = true;
                    AppMethodBeat.i(227415);
                    super.a(fVar);
                    fVar.af(com.tencent.mm.plugin.appbrand.game.a.e.lry.dJ(((c) b.this.NN()).getContext()));
                    fVar.cp(false);
                    fVar.ct(((Boolean) m.lrN.aLT()).booleanValue());
                    if ((this.cum instanceof x) && ((Boolean) com.tencent.mm.plugin.appbrand.game.a.t.lrU.aLT()).booleanValue()) {
                        fVar.b(a.b.NativeLocker);
                    }
                    boolean booleanValue = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.f.lrC.aLT()).booleanValue();
                    boolean booleanValue2 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.p.lrQ.aLT()).booleanValue();
                    boolean booleanValue3 = ((Boolean) com.tencent.mm.plugin.appbrand.game.a.q.lrR.aLT()).booleanValue();
                    Object[] objArr = new Object[3];
                    objArr[0] = booleanValue ? "yes" : "no";
                    objArr[1] = booleanValue2 ? "yes" : "no";
                    objArr[2] = booleanValue3 ? "yes" : "no";
                    Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "[hilive] supportHardCodec: %s useHardDecode: %s useHardEncode: %s", objArr);
                    if (!booleanValue || !booleanValue2) {
                        z = false;
                    } else {
                        z = true;
                    }
                    fVar.cw(z);
                    if (!booleanValue || !booleanValue3) {
                        z2 = false;
                    }
                    fVar.cv(z2);
                    fVar.cx(((Boolean) com.tencent.mm.plugin.appbrand.game.a.d.lrs.aLT()).booleanValue());
                    AppMethodBeat.o(227415);
                }

                @Override // com.tencent.luggage.game.a.d
                public final void a(com.tencent.magicbrush.e eVar, long j2) {
                    AppMethodBeat.i(227416);
                    com.tencent.mm.plugin.appbrand.report.quality.b.bUZ();
                    com.tencent.mm.plugin.appbrand.report.quality.c.a(((c) b.this.NN()).bsW(), ((c) b.this.NN()).getAppId(), j2);
                    AppMethodBeat.o(227416);
                }
            };
            this.nMm.LQ();
            if (((c) NN()).isRunning()) {
                this.nMm.b(((c) NN()).getRuntime());
            }
            jsRuntime.addJavascriptInterface(new a(this, (byte) 0), "MagicBrushViewIdTransfer");
            jsRuntime.evaluateJavascript(d.afA("wxa_library/NativeGlobal-WAService.js"), new ValueCallback<String>() {
                /* class com.tencent.mm.plugin.appbrand.service.b.AnonymousClass4 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(String str) {
                    AppMethodBeat.i(227417);
                    Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: eval WAService.js result %s", str);
                    AppMethodBeat.o(227417);
                }
            });
            AppMethodBeat.o(227428);
        } else {
            Log.w("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "hy: component lost");
            AppMethodBeat.o(227428);
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        @JavascriptInterface
        public final int exec(int i2) {
            int i3;
            AppMethodBeat.i(48256);
            try {
                a.b bVar = com.tencent.mm.plugin.appbrand.jsapi.b.a.ZJ(((c) b.this.NN()).getAppId()).cCB.get(Integer.valueOf(i2));
                if (bVar == null) {
                    kotlin.g.b.p.hyc();
                }
                i3 = bVar.lQQ.getVirtualElementId();
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", e2, "MagicBrushViewIdTransfer failed. [%d] [%s]", Integer.valueOf(i2), ((c) b.this.NN()).getAppId());
                i3 = -1;
            }
            AppMethodBeat.o(48256);
            return i3;
        }
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f, com.tencent.luggage.sdk.b.a.c.c
    public final void c(JSONObject jSONObject) {
        AppMethodBeat.i(48266);
        super.c(jSONObject);
        aa aaVar = aa.nMY;
        boolean f2 = aa.f((c) NN());
        try {
            jSONObject.put("exportBaseMethods", f2);
            jSONObject.put("supressOffscreenPatch", true);
        } catch (JSONException e2) {
            Log.e("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods e:%s", e2);
        }
        Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "exportBaseMethods:%b", Boolean.valueOf(f2));
        AppMethodBeat.o(48266);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.c
    public final void Ok() {
        AppMethodBeat.i(48267);
        aa aaVar = aa.nMY;
        if (aa.f((c) NN())) {
            final long currentTimeMillis = System.currentTimeMillis();
            aa aaVar2 = aa.nMY;
            String bVu = aa.bVu();
            aa aaVar3 = aa.nMY;
            String bVv = aa.bVv();
            aa aaVar4 = aa.nMY;
            String bVw = aa.bVw();
            Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript name:%s", bVu);
            Log.v("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "afterExecInternalInitScript jsSource:%s", bVv);
            final d.a aVar = new d.a();
            aVar.scriptName = bVu;
            aVar.czz = bVv;
            aVar.czA = bVv.length();
            com.tencent.mm.plugin.appbrand.utils.s.a(((c) NN()).getJsRuntime(), "https://lib/" + bVu, "", "", 0, bVv, bVw, new s.a() {
                /* class com.tencent.mm.plugin.appbrand.service.b.AnonymousClass5 */

                @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                public final void onSuccess(String str) {
                    AppMethodBeat.i(227418);
                    ((c) b.this.NN()).a(aVar, true, currentTimeMillis, System.currentTimeMillis(), (Object) null);
                    Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onSuccess ret:%s", str);
                    AppMethodBeat.o(227418);
                }

                @Override // com.tencent.mm.plugin.appbrand.utils.s.a
                public final void du(String str) {
                    AppMethodBeat.i(227419);
                    ((c) b.this.NN()).a(aVar, false, currentTimeMillis, System.currentTimeMillis(), (Object) null);
                    Log.i("MicroMsg.AppBrandMiniProgramServiceLogicImpWC", "beforeEvaluateScriptFile onFailure ret:%s", str);
                    AppMethodBeat.o(227419);
                }
            });
        }
        AppMethodBeat.o(48267);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.c
    public final int Mz() {
        AppMethodBeat.i(48268);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_common_lib_code_cache_type, 0);
        AppMethodBeat.o(48268);
        return a2;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean d(String str, String str2, int i2) {
        AppMethodBeat.i(227429);
        if (NN() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e) {
            AppMethodBeat.o(227429);
            return true;
        }
        boolean d2 = super.d(str, str2, i2);
        AppMethodBeat.o(227429);
        return d2;
    }

    @Override // com.tencent.luggage.sdk.b.a.c.f
    public final boolean j(int i2, String str) {
        AppMethodBeat.i(227430);
        if (NN() instanceof com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.e) {
            AppMethodBeat.o(227430);
            return true;
        }
        boolean j2 = super.j(i2, str);
        AppMethodBeat.o(227430);
        return j2;
    }
}
