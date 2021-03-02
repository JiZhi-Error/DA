package com.tencent.mm.plugin.appbrand.jsapi.ag.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class f extends a {
    private static final int CTRL_INDEX = 567;
    public static final String NAME = "operateXWebLivePlayer";

    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(177219);
        boolean a2 = com.tencent.luggage.xweb_ext.extendplugin.component.f.a(this, fVar, jSONObject, i2);
        AppMethodBeat.o(177219);
        return a2;
    }
}
