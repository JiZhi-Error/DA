package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class r extends d<s> {
    public static final int CTRL_INDEX = 211;
    public static final String NAME = "updateShareMenuDynamic";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147218);
        s sVar2 = sVar;
        ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView != null) {
            t yK = currentPageView.yK(u.ShareAppMsg.ordinal());
            if (yK == null) {
                sVar2.i(i2, h("fail:menu item do not exist", null));
                AppMethodBeat.o(147218);
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("isDynamic", false);
            yK.lEi.l("enable_share_dynamic", Boolean.valueOf(optBoolean));
            sVar2.i(i2, h("ok", null));
            Log.i("MicroMsg.JsApiUpdateShareMenuDynamic", "update share menu dynamic(%s)", Boolean.valueOf(optBoolean));
            AppMethodBeat.o(147218);
            return;
        }
        sVar2.i(i2, h("fail", null));
        AppMethodBeat.o(147218);
    }
}
