package com.tencent.mm.plugin.appbrand.jsapi.ag.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class f extends d {
    private static final int CTRL_INDEX = 539;
    public static final String NAME = "operateXWebVideo";

    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final boolean b(com.tencent.mm.plugin.appbrand.jsapi.f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(177247);
        boolean a2 = com.tencent.luggage.xweb_ext.extendplugin.component.f.a(this, fVar, jSONObject, i2);
        AppMethodBeat.o(177247);
        return a2;
    }
}
