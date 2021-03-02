package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.b.c;
import org.json.JSONObject;

public final class cr extends d<d> {
    public static final int CTRL_INDEX = 249;
    public static final String NAME = "setEnableDebug";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147144);
        d dVar2 = dVar;
        boolean optBoolean = jSONObject.optBoolean("enableDebug", false);
        if (dVar2.NP().OM().cyC == optBoolean) {
            dVar2.i(i2, h("ok", null));
            AppMethodBeat.o(147144);
            return;
        }
        c.a(dVar2, dVar2.getAppId(), optBoolean);
        dVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147144);
    }
}
