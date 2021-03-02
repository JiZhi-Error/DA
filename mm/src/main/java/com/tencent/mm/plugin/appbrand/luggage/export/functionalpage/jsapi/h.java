package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.MiniProgramNavigationBackResult;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram;", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/JsApiNavigateToMiniProgramWC;", "()V", "createNavigatorCallback", "Lcom/tencent/mm/plugin/appbrand/jsapi/miniprogram_navigator/IMiniProgramNavigator$NavigatorCallback;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class h extends i {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "sdk_navigateToMiniProgram";
    public static final a nbx = new a((byte) 0);

    static {
        AppMethodBeat.i(228911);
        AppMethodBeat.o(228911);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionalJsApiNavigateToMiniProgram$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "thatConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfig;", "kotlin.jvm.PlatformType", "data", "", "onRuntimeReceiveReturnData"})
    static final class b implements l.a {
        final /* synthetic */ d lGr;
        final /* synthetic */ int lyo;
        final /* synthetic */ h nby;

        b(h hVar, d dVar, int i2) {
            this.nby = hVar;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l.a
        public final void c(AppBrandInitConfig appBrandInitConfig, Object obj) {
            Object obj2;
            JSONObject jSONObject = null;
            AppMethodBeat.i(228908);
            if (!(obj instanceof MiniProgramNavigationBackResult)) {
                obj2 = null;
            } else {
                obj2 = obj;
            }
            MiniProgramNavigationBackResult miniProgramNavigationBackResult = (MiniProgramNavigationBackResult) obj2;
            Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onReceiveReturnData navigateToAppId:" + appBrandInitConfig.appId + " result:" + miniProgramNavigationBackResult);
            HashMap hashMap = new HashMap();
            if ((miniProgramNavigationBackResult != null ? miniProgramNavigationBackResult.kFg : null) != null) {
                hashMap.put("extraData", miniProgramNavigationBackResult.kFg);
            }
            if (miniProgramNavigationBackResult != null) {
                jSONObject = miniProgramNavigationBackResult.kFh;
            }
            if (jSONObject != null) {
                hashMap.put("privateExtraData", miniProgramNavigationBackResult.kFh);
            }
            this.lGr.i(this.lyo, this.nby.n("ok", hashMap));
            AppMethodBeat.o(228908);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.h
    public final c.AbstractC0681c b(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228910);
        p.h(dVar, "service");
        p.h(jSONObject, "data");
        AppBrandRuntime runtime = dVar.getRuntime();
        if (runtime == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.FunctionalRuntime");
            AppMethodBeat.o(228910);
            throw tVar;
        }
        ((com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.l) runtime).a(new b(this, dVar, i2));
        c cVar = new c(this, jSONObject, dVar, i2);
        AppMethodBeat.o(228910);
        return cVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "ok", "", "reason", "", "kotlin.jvm.PlatformType", "onNavigateResult"})
    static final class c implements c.AbstractC0681c {
        final /* synthetic */ JSONObject lFq;
        final /* synthetic */ d lGr;
        final /* synthetic */ int lyo;
        final /* synthetic */ h nby;

        c(h hVar, JSONObject jSONObject, d dVar, int i2) {
            this.nby = hVar;
            this.lFq = jSONObject;
            this.lGr = dVar;
            this.lyo = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.c.AbstractC0681c
        public final void o(boolean z, String str) {
            AppMethodBeat.i(228909);
            Log.i("MicroMsg.AppBrand.FunctionalJsApiNavigateToMiniProgram", "onNavigateResult, navigateToAppId:" + this.lFq.optString("appId") + " ok:" + z + ", reason:" + str);
            if (!z) {
                d dVar = this.lGr;
                int i2 = this.lyo;
                h hVar = this.nby;
                StringBuilder sb = new StringBuilder("fail: navigate error ");
                if (str == null) {
                    str = "";
                }
                dVar.i(i2, hVar.Zf(sb.append(str).toString()));
            }
            AppMethodBeat.o(228909);
        }
    }
}
