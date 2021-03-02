package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class s extends d<com.tencent.mm.plugin.appbrand.s> {
    public static final int CTRL_INDEX = 210;
    public static final String NAME = "updateShareMenuShareTicket";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147219);
        com.tencent.mm.plugin.appbrand.s sVar2 = sVar;
        Log.i("MicroMsg.JsApiUpdateShareMenuShareTicket", "invoke");
        ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView != null) {
            t yK = currentPageView.yK(u.ShareAppMsg.ordinal());
            if (yK == null) {
                sVar2.i(i2, h("fail:menu item do not exist", null));
                AppMethodBeat.o(147219);
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("withShareTicket", false);
            yK.lEi.l("enable_share_with_share_ticket", Boolean.valueOf(optBoolean));
            sVar2.i(i2, h("ok", null));
            Log.i("MicroMsg.JsApiUpdateShareMenuShareTicket", "update share menu withShareTicket(%s)", Boolean.valueOf(optBoolean));
            AppMethodBeat.o(147219);
            return;
        }
        sVar2.i(i2, h("fail", null));
        AppMethodBeat.o(147219);
    }
}
