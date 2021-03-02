package com.tencent.mm.plugin.appbrand.ad.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.e;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g extends d<s> {
    public static final int CTRL_INDEX = 756;
    public static final String NAME = "showSplashAdMenu";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(44051);
        s sVar2 = sVar;
        boolean optBoolean = jSONObject.optBoolean("showMenu", false);
        String optString = jSONObject.optString("title", "");
        String optString2 = jSONObject.optString("icon", "");
        e.af(sVar2.getAppId(), optBoolean);
        e.cm(sVar2.getAppId(), optString);
        e.cn(sVar2.getAppId(), optString2);
        Log.i("MicroMsg.AppBrand.JsApiShowMenuAd[AppBrandSplashAd]", "showSplashAdMenu, showMenuAd:%s, title:%s, icon:%s", Boolean.valueOf(optBoolean), optString, optString2);
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(44051);
    }
}
