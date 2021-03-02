package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class j extends d<c> {
    public static final int CTRL_INDEX = 757;
    public static final String NAME = "splashAdFirstStepViewLayoutStateChange";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(160556);
        c cVar2 = cVar;
        int optInt = jSONObject.optInt("state", -1);
        if (optInt == 0 || optInt == 1) {
            long nowMilliSecond = Util.nowMilliSecond();
            if (optInt == 0) {
                Log.i("MicroMsg.AppBrand.JsApiSplashAdFirstStepLayoutChange[AppBrandSplashAd]", "splashAdFirstStep, startTime:%s", Long.valueOf(nowMilliSecond));
                p.Un(cVar2.getAppId()).kCO.kGx = nowMilliSecond;
            } else {
                Log.i("MicroMsg.AppBrand.JsApiSplashAdFirstStepLayoutChange[AppBrandSplashAd]", "splashAdFirstStep, endTime:%s", Long.valueOf(nowMilliSecond));
                p.Un(cVar2.getAppId()).kCO.kGy = nowMilliSecond;
                Log.i("MicroMsg.AppBrand.JsApiSplashAdFirstStepLayoutChange[AppBrandSplashAd]", "splashAdFirstStep, costTime:%s", Long.valueOf(p.Un(cVar2.getAppId()).kCO.kGy - p.Un(cVar2.getAppId()).kCO.kGx));
            }
            cVar2.i(i2, h("ok", null));
            AppMethodBeat.o(160556);
            return;
        }
        cVar2.i(i2, h("fail:invalid data", null));
        AppMethodBeat.o(160556);
    }
}
