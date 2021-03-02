package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class d extends ab<s> {
    static final int CTRL_INDEX = 191;
    public static final String NAME = "exitMiniProgram";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(s sVar, JSONObject jSONObject) {
        AppMethodBeat.i(147179);
        String p = p(sVar);
        AppMethodBeat.o(147179);
        return p;
    }

    public final String p(s sVar) {
        AppMethodBeat.i(147178);
        sVar.getRuntime().finish();
        String h2 = h("ok", null);
        AppMethodBeat.o(147178);
        return h2;
    }
}
