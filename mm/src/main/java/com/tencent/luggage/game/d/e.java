package com.tencent.luggage.game.d;

import com.tencent.luggage.game.page.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.file.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class e extends ab<s> {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(s sVar, JSONObject jSONObject) {
        AppMethodBeat.i(130539);
        ac currentPageView = sVar.getCurrentPageView();
        if (((d) currentPageView.S(d.class)) == null) {
            String h2 = h("fail", null);
            AppMethodBeat.o(130539);
            return h2;
        }
        i.a a2 = d.a(currentPageView, jSONObject, true);
        String n = n(a2.errMsg, a2.values);
        AppMethodBeat.o(130539);
        return n;
    }
}
