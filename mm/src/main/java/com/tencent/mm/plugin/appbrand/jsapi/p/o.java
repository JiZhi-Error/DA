package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiPageInitReadyWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/page/JsApiInitReady;", "()V", "invoke", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "data", "Lorg/json/JSONObject;", "plugin-appbrand-integration_release"})
public final class o extends h {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.h, com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* bridge */ /* synthetic */ String a(ac acVar, JSONObject jSONObject) {
        AppMethodBeat.i(50634);
        String a2 = a(acVar, jSONObject);
        AppMethodBeat.o(50634);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.p.h
    public final String a(ac acVar, JSONObject jSONObject) {
        QualitySessionRuntime aeU;
        boolean z = false;
        AppMethodBeat.i(50633);
        p.h(acVar, "page");
        String a2 = super.a(acVar, jSONObject);
        if (jSONObject != null) {
            z = jSONObject.optBoolean("renderingCacheAccepted", false);
        }
        Log.i("MicroMsg.AppBrand.JsApiPageInitReadyWC", "invoke renderingCacheAccepted[" + z + "] appId[" + acVar.getAppId() + "] url[" + acVar.getURL() + ']');
        if ((acVar instanceof ag) && z && (aeU = b.aeU(((ag) acVar).getAppId())) != null) {
            aeU.bVi();
        }
        p.g(a2, "super.invoke(page, data)…)\n            }\n        }");
        AppMethodBeat.o(50633);
        return a2;
    }
}
