package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class i extends d<c> {
    public static final int CTRL_INDEX = 758;
    public static final String NAME = "splashAdAllViewLayoutStateChange";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(160555);
        c cVar2 = cVar;
        int optInt = jSONObject.optInt("state", -1);
        if (optInt == 0 || optInt == 1) {
            long nowMilliSecond = Util.nowMilliSecond();
            if (optInt == 0) {
                Log.i("MicroMsg.AppBrand.JsApiSplashAdAllViewLayoutChange[AppBrandSplashAd]", "splashAdAllView, startTime:%s", Long.valueOf(nowMilliSecond));
                p.Un(cVar2.getAppId()).kCO.kGz = nowMilliSecond;
            } else {
                Log.i("MicroMsg.AppBrand.JsApiSplashAdAllViewLayoutChange[AppBrandSplashAd]", "splashAdAllView, endTime:%s", Long.valueOf(nowMilliSecond));
                p.Un(cVar2.getAppId()).kCO.kGA = nowMilliSecond;
                Log.i("MicroMsg.AppBrand.JsApiSplashAdAllViewLayoutChange[AppBrandSplashAd]", "splashAdAllView, costTime:%s", Long.valueOf(p.Un(cVar2.getAppId()).kCO.kGA - p.Un(cVar2.getAppId()).kCO.kGz));
            }
            cVar2.i(i2, h("ok", null));
            AppMethodBeat.o(160555);
            return;
        }
        cVar2.i(i2, h("fail:invalid data", null));
        AppMethodBeat.o(160555);
    }
}
