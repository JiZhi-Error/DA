package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.df;
import com.tencent.mm.plugin.appbrand.s;
import org.json.JSONObject;

public final class f extends ab<d> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "remoteDebugInfo";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(d dVar, JSONObject jSONObject) {
        j jVar;
        AppMethodBeat.i(147008);
        s j2 = df.j(dVar);
        if (j2 instanceof com.tencent.luggage.sdk.b.a.c.d) {
            jVar = (j) ((com.tencent.luggage.sdk.b.a.c.d) j2).S(j.class);
        } else {
            jVar = null;
        }
        if (jVar == null) {
            String h2 = h("fail:not debug", null);
            AppMethodBeat.o(147008);
            return h2;
        }
        jVar.ds(jSONObject.toString());
        String h3 = h("ok", null);
        AppMethodBeat.o(147008);
        return h3;
    }
}
