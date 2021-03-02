package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class w extends d<s> {
    public static final int CTRL_INDEX = 388;
    public static final String NAME = "setMenuStyle";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138228);
        s sVar2 = sVar;
        Log.d("MicroMsg.JsApiSetMenuStyle", "JsApiSetMenuStyle!");
        if (jSONObject == null) {
            sVar2.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiSetMenuStyle", "data is null");
            AppMethodBeat.o(138228);
            return;
        }
        String optString = jSONObject.optString(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        ac pageView = sVar2.getRuntime().brh().getPageView();
        if (pageView == null) {
            sVar2.i(i2, h("fail view is null", null));
            AppMethodBeat.o(138228);
            return;
        }
        if (optString.equalsIgnoreCase("dark")) {
            pageView.adN("dark");
        } else if (optString.equalsIgnoreCase("light")) {
            pageView.adN("light");
        } else {
            sVar2.i(i2, h("fail invalid style ".concat(String.valueOf(optString)), null));
            Log.e("MicroMsg.JsApiSetMenuStyle", "fail invalid style %s", optString);
            AppMethodBeat.o(138228);
            return;
        }
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(138228);
    }
}
