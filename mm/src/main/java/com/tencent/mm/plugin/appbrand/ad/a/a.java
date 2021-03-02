package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.ui.b;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class a extends d<c> {
    public static final int CTRL_INDEX = 749;
    public static final String NAME = "closeSplashAd";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(44046);
        c cVar2 = cVar;
        String optString = jSONObject.optString("source", "");
        boolean optBoolean = jSONObject.optBoolean("animated", true);
        Log.i("MicroMsg.AppBrand.JsApiCloseSplashAd[AppBrandSplashAd]", "closeSplashAd, source:%s, animated:%s", optString, Boolean.valueOf(optBoolean));
        if ("launch".equalsIgnoreCase(optString)) {
            if (cVar2.getRuntime().kDu != null) {
                cVar2.getRuntime().kDu.m(optBoolean, optString);
            }
        } else if ("menu".equalsIgnoreCase(optString)) {
            b bVar = new b();
            bVar.kHp.appId = cVar2.getAppId();
            EventCenter.instance.publish(bVar);
        }
        cVar2.i(i2, h("ok", null));
        AppMethodBeat.o(44046);
    }
}
