package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class h extends d<c> {
    public static final int CTRL_INDEX = 748;
    public static final String NAME = "showSplashAd";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(44052);
        c cVar2 = cVar;
        boolean optBoolean = jSONObject.optBoolean("show", false);
        int optInt = jSONObject.optInt("errCode", 0);
        Log.i("MicroMsg.AppBrand.JsApiShowSplashAd[AppBrandSplashAd]", "showSplashAd, appId:%s, showSplashAd:%s, errCode:%s", cVar2.getAppId(), Boolean.valueOf(optBoolean), Integer.valueOf(optInt));
        long optLong = jSONObject.optLong("adCallTime", 0);
        long optLong2 = jSONObject.optLong("eventReceivedTime", 0);
        long optLong3 = jSONObject.optLong("cgiFetchStart", 0);
        long optLong4 = jSONObject.optLong("cgiFetchCallBack", 0);
        long nowMilliSecond = Util.nowMilliSecond();
        long j2 = p.Um(cVar2.getAppId()).kCO.kGs;
        p.Un(cVar2.getAppId()).kCO.kGt = optLong2;
        p.Un(cVar2.getAppId()).kCO.kGv = nowMilliSecond;
        p.Un(cVar2.getAppId()).kCO.kGu = optLong;
        long j3 = p.Um(cVar2.getAppId()).kCO.kGE;
        long j4 = p.Um(cVar2.getAppId()).kCO.kGF;
        p.Un(cVar2.getAppId()).kCO.kGD = optLong3;
        p.Un(cVar2.getAppId()).kCO.kGG = optLong4;
        Log.i("MicroMsg.AppBrand.JsApiShowSplashAd[AppBrandSplashAd]", "showSplashAd, adOperateCallCostTime:%s, callbackTime:%s, startTime:%s", Long.valueOf(optLong4 - optLong3), Long.valueOf(optLong4), Long.valueOf(optLong3));
        Log.e("MicroMsg.AppBrand.JsApiShowSplashAd[AppBrandSplashAd]", "showSplashAd(%s):%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s\t%s", cVar2.getAppId(), Long.valueOf(nowMilliSecond - j2), Long.valueOf(j2), Long.valueOf(optLong2 - j2), Long.valueOf(optLong2), Long.valueOf(optLong3 - optLong2), Long.valueOf(optLong3), Long.valueOf(j3 - optLong3), Long.valueOf(j3), Long.valueOf(j4 - j3), Long.valueOf(j4), Long.valueOf(optLong4 - j4), Long.valueOf(optLong4), Long.valueOf(optLong - optLong4), Long.valueOf(optLong), Long.valueOf(nowMilliSecond - optLong), Long.valueOf(nowMilliSecond));
        boolean z = false;
        if (cVar2.getRuntime() != null) {
            p.Un(cVar2.getAppId()).kCO.kGq = optBoolean;
            p.Un(cVar2.getAppId()).kCO.kGw = optInt;
            if (cVar2.getRuntime().kDu != null) {
                com.tencent.mm.plugin.appbrand.ad.h hVar = cVar2.getRuntime().kDu;
                Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "showSplashAd, startTimerToShow costTime:%s", Long.valueOf(Util.nowMilliSecond() - hVar.kHc));
                if (hVar.kGZ != null && hVar.kGZ.stopped()) {
                    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "showSplashAd, check ad time out");
                    hVar.kGY = 3;
                    hVar.btU();
                    b.K(hVar.kGW);
                } else if (optBoolean) {
                    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "showSplashAd, show splash ad");
                    hVar.kGY = 1;
                    e eVar = new e();
                    eVar.source = "launch";
                    eVar.d(hVar.btQ());
                    hVar.UD("showSplashAd(true)");
                    z = true;
                } else {
                    Log.i("MicroMsg.AppBrandSplashAdLogic[AppBrandSplashAd]", "showSplashAd, not show splash ad");
                    hVar.kGY = 2;
                    hVar.btU();
                    hVar.btW();
                    hVar.UD("showSplashAd(false)");
                    b.K(hVar.kGW);
                }
                z = false;
            }
        }
        Log.i("MicroMsg.AppBrand.JsApiShowSplashAd[AppBrandSplashAd]", "showSplashAd, appId:%s, ad showed:%s", cVar2.getAppId(), Boolean.valueOf(z));
        if (z) {
            cVar2.i(i2, h("ok", null));
            AppMethodBeat.o(44052);
            return;
        }
        cVar2.i(i2, h("fail:cannot show splash ad after loading pushed", null));
        AppMethodBeat.o(44052);
    }
}
