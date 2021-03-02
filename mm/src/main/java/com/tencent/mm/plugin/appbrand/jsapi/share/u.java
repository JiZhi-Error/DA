package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class u extends d<s> {
    public static final int CTRL_INDEX = 464;
    public static final String NAME = "updateShareMenuUpdatable";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147220);
        s sVar2 = sVar;
        ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView != null) {
            t yK = currentPageView.yK(com.tencent.mm.plugin.appbrand.menu.u.ShareAppMsg.ordinal());
            if (yK == null) {
                sVar2.i(i2, h("fail:menu item do not exist", null));
                AppMethodBeat.o(147220);
                return;
            }
            boolean optBoolean = jSONObject.optBoolean("updatable", false);
            String optString = jSONObject.optString("templateId", "");
            boolean optBoolean2 = jSONObject.optBoolean("isPrivateMessage", false);
            yK.lEi.l("enable_share_with_updateable_msg", Boolean.valueOf(optBoolean));
            yK.lEi.l("enable_share_with_updateable_msg_template_id", optString);
            yK.lEi.l("enable_share_with_private_msg", Boolean.valueOf(optBoolean2));
            sVar2.i(i2, h("ok", null));
            Log.i("MicroMsg.JsApiUpdateShareMenuUpdatable", "update share menu updatable(%s) isPrivateMessage(%s)", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2));
            AppMethodBeat.o(147220);
            return;
        }
        sVar2.i(i2, h("fail", null));
        AppMethodBeat.o(147220);
    }
}
