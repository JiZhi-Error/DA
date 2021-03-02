package com.tencent.mm.plugin.appbrand.jsapi.share;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.menu.u;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class o extends d<s> {
    public static final int CTRL_INDEX = 146;
    public static final String NAME = "showShareMenu";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147216);
        s sVar2 = sVar;
        ac currentPageView = sVar2.getCurrentPageView();
        if (currentPageView != null) {
            currentPageView.P(u.ShareAppMsg.ordinal(), false);
        }
        sVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147216);
    }
}
