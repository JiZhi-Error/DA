package com.tencent.luggage.sdk.b.a.c;

import android.webkit.ValueCallback;
import com.tencent.luggage.sdk.b.a.b;
import com.tencent.luggage.sdk.b.a.c;
import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.luggage.sdk.b.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ag.a;
import com.tencent.mm.plugin.appbrand.bc;
import com.tencent.mm.plugin.appbrand.jsapi.cx;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.m.v;
import com.tencent.mm.plugin.appbrand.p.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.utils.ai;
import com.tencent.mm.plugin.appbrand.x;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class d extends s implements com.tencent.luggage.sdk.b.a.d, f {
    public f cBj;

    @Override // com.tencent.mm.plugin.appbrand.s
    public /* synthetic */ x Ox() {
        AppMethodBeat.i(146849);
        a Ov = Ov();
        AppMethodBeat.o(146849);
        return Ov;
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public /* synthetic */ ac getCurrentPageView() {
        AppMethodBeat.i(146848);
        c Oq = Oq();
        AppMethodBeat.o(146848);
        return Oq;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.mm.plugin.appbrand.jsapi.k
    public /* synthetic */ AppBrandRuntime getRuntime() {
        AppMethodBeat.i(146847);
        com.tencent.luggage.sdk.d.d NP = NP();
        AppMethodBeat.o(146847);
        return NP;
    }

    public final f Ol() {
        return this.cBj;
    }

    /* access modifiers changed from: package-private */
    public final void Om() {
        AppMethodBeat.i(169441);
        super.bta();
        AppMethodBeat.o(169441);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void On() {
        AppMethodBeat.i(146823);
        this.cBj.Ml();
        AppMethodBeat.o(146823);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.s
    public i Oo() {
        AppMethodBeat.i(146824);
        i Mk = this.cBj.Mk();
        if (Mk == null) {
            Mk = super.Oo();
        }
        AppMethodBeat.o(146824);
        return Mk;
    }

    public final <T> T S(Class<T> cls) {
        AppMethodBeat.i(146825);
        if (cls.isInstance(this)) {
            T cast = cls.cast(this);
            AppMethodBeat.o(146825);
            return cast;
        } else if (cls.isInstance(this.cBj)) {
            T cast2 = cls.cast(this.cBj);
            AppMethodBeat.o(146825);
            return cast2;
        } else {
            T cast3 = cls.cast(this.cBj.S(cls));
            AppMethodBeat.o(146825);
            return cast3;
        }
    }

    public d() {
        this(new c.a());
        AppMethodBeat.i(146826);
        AppMethodBeat.o(146826);
    }

    public d(b.a aVar) {
        AppMethodBeat.i(146827);
        String simpleName = aVar.getClass().getSimpleName();
        Log.d("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", simpleName);
        this.cBj = (f) e.Oy().a(aVar, this);
        if (this.cBj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No logic corresponding implement found with type: ".concat(String.valueOf(simpleName)));
            AppMethodBeat.o(146827);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(146827);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.s
    public final Map<String, p> Op() {
        AppMethodBeat.i(146828);
        Map<String, p> Nf = this.cBj.Nf();
        AppMethodBeat.o(146828);
        return Nf;
    }

    public com.tencent.luggage.sdk.b.a.c Oq() {
        AppMethodBeat.i(146829);
        com.tencent.luggage.sdk.b.a.c cVar = (com.tencent.luggage.sdk.b.a.c) super.ax(com.tencent.luggage.sdk.b.a.c.class);
        AppMethodBeat.o(146829);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public void d(AppBrandRuntime appBrandRuntime) {
        AppMethodBeat.i(146830);
        super.d(appBrandRuntime);
        this.lxr = Ow();
        this.cBj.c(appBrandRuntime);
        AppMethodBeat.o(146830);
    }

    public com.tencent.luggage.sdk.d.d NP() {
        AppMethodBeat.i(146831);
        com.tencent.luggage.sdk.d.d dVar = (com.tencent.luggage.sdk.d.d) super.getRuntime();
        AppMethodBeat.o(146831);
        return dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.mm.plugin.appbrand.jsapi.l
    public void d(JSONObject jSONObject) {
        AppMethodBeat.i(146832);
        super.d(jSONObject);
        this.cBj.d(jSONObject);
        c(jSONObject, "isIsolateContext", Boolean.valueOf(this.cBj.Mj()));
        c(jSONObject, "version", ChannelUtil.formatVersion(null, BuildInfo.CLIENT_VERSION_INT));
        c(jSONObject, FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, LocaleUtil.getCurrentLanguage(getContext()));
        AppMethodBeat.o(146832);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public JSONObject Or() {
        AppMethodBeat.i(146833);
        JSONObject Or = super.Or();
        c(Or, "appType", Integer.valueOf(NP().ON().cyo));
        c(Or, "debug", Boolean.valueOf(NP().OM().cyC));
        e(Or);
        int[] f2 = ai.f(this);
        c(Or, "screenWidth", Integer.valueOf(g.zB(f2[0])));
        c(Or, "screenHeight", Integer.valueOf(g.zB(f2[1])));
        c(Or, "supportAsyncGetSystemInfo", Boolean.TRUE);
        c(Or, "prerender", Boolean.valueOf(NP().ON().cyz == com.tencent.luggage.sdk.launching.b.PRE_RENDER));
        c(Or, "instanceId", NP().ON().cyn);
        Or.remove("permission");
        Or.remove("navigateToMiniProgramAppIdList");
        Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "generateWxConfig(%s): %s", getAppId(), Or.toString());
        AppMethodBeat.o(146833);
        return Or;
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final String dG(String str) {
        AppMethodBeat.i(146835);
        String dH = this.cBj.dH(str);
        if (Util.isNullOrNil(dH)) {
            String dG = super.dG(str);
            AppMethodBeat.o(146835);
            return dG;
        }
        AppMethodBeat.o(146835);
        return dH;
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final void Os() {
        AppMethodBeat.i(146836);
        super.Os();
        this.cBj.MB();
        Log.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", Integer.valueOf(getComponentId()));
        String format = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", cx.z("onWxConfigReady", "", 0));
        if (getJsRuntime().R(v.class) != null) {
            ((v) getJsRuntime().R(v.class)).a(null, null, null, 0, format, new m.b() {
                /* class com.tencent.mm.plugin.appbrand.s.AnonymousClass4 */

                @Override // com.tencent.mm.appbrand.v8.m.b
                public final void a(String str, m.c cVar) {
                    AppMethodBeat.i(219266);
                    boolean parseBoolean = Boolean.parseBoolean(str);
                    if (parseBoolean) {
                        s.this.kEh.kEn = cVar.dqk;
                        s.this.kEh.kEo = cVar.dql;
                        s.this.kEh.iMa = cVar;
                    }
                    Log.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by AddonV8, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", Boolean.valueOf(parseBoolean), Integer.valueOf(s.this.getComponentId()), Long.valueOf(s.this.kEh.kEo - s.this.kEh.kEn));
                    s.this.a(s.this.kEh.kEm, s.this.kEh.kEn, s.this.kEh.kEo, s.this.kEh.iMa);
                    AppMethodBeat.o(219266);
                }
            });
            AppMethodBeat.o(146836);
            return;
        }
        getJsRuntime().evaluateJavascript(format, new ValueCallback<String>(Util.nowMilliSecond()) {
            /* class com.tencent.mm.plugin.appbrand.s.AnonymousClass5 */
            final /* synthetic */ long kEl;

            {
                this.kEl = r2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(219267);
                boolean parseBoolean = Boolean.parseBoolean(str);
                if (parseBoolean) {
                    s.this.kEh.kEn = this.kEl;
                    s.this.kEh.kEo = Util.nowMilliSecond();
                    s.this.kEh.iMa = null;
                }
                Log.i("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed end by evaluateJavascript, applied=%b, hash=%d, reportWxConfigInjectEnd cost=%dms", Boolean.valueOf(parseBoolean), Integer.valueOf(s.this.getComponentId()), Long.valueOf(s.this.kEh.kEo - s.this.kEh.kEn));
                s.this.a(s.this.kEh.kEm, s.this.kEh.kEn, s.this.kEh.kEo, s.this.kEh.iMa);
                AppMethodBeat.o(219267);
            }
        });
        AppMethodBeat.o(146836);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g, com.tencent.mm.plugin.appbrand.s
    public final void cleanup() {
        AppMethodBeat.i(146837);
        this.cBj.Mm();
        super.cleanup();
        this.cBj.Mn();
        AppMethodBeat.o(146837);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public void MC() {
        AppMethodBeat.i(146838);
        if (bsX()) {
            bc.a(this, getJsRuntime());
        }
        this.cBj.MC();
        AppMethodBeat.o(146838);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final void bX(boolean z) {
        AppMethodBeat.i(146839);
        super.bX(z);
        this.cBj.Mw();
        AppMethodBeat.o(146839);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public void Mx() {
        AppMethodBeat.i(146840);
        super.Mx();
        this.cBj.Mx();
        AppMethodBeat.o(146840);
    }

    @Override // com.tencent.mm.plugin.appbrand.p.f
    public boolean dt(String str) {
        AppMethodBeat.i(229852);
        boolean dt = this.cBj.dt(str);
        AppMethodBeat.o(229852);
        return dt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g, com.tencent.mm.plugin.appbrand.s
    public final void c(String str, String str2, int i2) {
        AppMethodBeat.i(146842);
        if (this.cBj.d(str, str2, i2)) {
            AppMethodBeat.o(146842);
            return;
        }
        super.c(str, str2, i2);
        AppMethodBeat.o(146842);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.g
    public final void a(String str, String str2, int i2, o oVar) {
        AppMethodBeat.i(229853);
        if (com.tencent.mm.plugin.appbrand.page.o.NAME.equals(str) || n.NAME.equals(str)) {
            Log.i("MicroMsg.AppBrand.AppBrandServiceLU", "dispatch %s, appId:%s, instanceId:%s, sessionId:%s, data:%s", str, getAppId(), NP().ON().cyn, NP().ON().cym, str2);
        }
        if ((oVar == null || oVar == getJsRuntime()) && this.cBj.d(str, str2, i2)) {
            AppMethodBeat.o(229853);
            return;
        }
        super.a(str, str2, i2, oVar);
        AppMethodBeat.o(229853);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final void MD() {
        AppMethodBeat.i(146843);
        this.cBj.MD();
        AppMethodBeat.o(146843);
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final String Ot() {
        return "https://usr/";
    }

    @Override // com.tencent.mm.plugin.appbrand.s
    public final String Ou() {
        return "https://lib/";
    }

    /* access modifiers changed from: protected */
    public a Ov() {
        AppMethodBeat.i(146844);
        a aVar = new a(this);
        AppMethodBeat.o(146844);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public f.b Ow() {
        AppMethodBeat.i(146845);
        com.tencent.mm.plugin.appbrand.c cVar = new com.tencent.mm.plugin.appbrand.c(NP(), this, NP().cCn);
        AppMethodBeat.o(146845);
        return cVar;
    }

    public void a(d.a aVar, boolean z, long j2, long j3, Object obj) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public void i(int i2, String str) {
        AppMethodBeat.i(146846);
        if (this.cBj.j(i2, str)) {
            AppMethodBeat.o(146846);
            return;
        }
        super.i(i2, str);
        AppMethodBeat.o(146846);
    }

    /* access modifiers changed from: protected */
    public void e(JSONObject jSONObject) {
        AppMethodBeat.i(146834);
        this.cBj.c(jSONObject);
        AppMethodBeat.o(146834);
    }
}
