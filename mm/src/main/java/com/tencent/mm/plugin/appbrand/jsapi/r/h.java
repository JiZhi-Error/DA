package com.tencent.mm.plugin.appbrand.jsapi.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class h extends a {
    private static final int CTRL_INDEX = 96;
    private static final String NAME = "showPickerView";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a, com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137594);
        b(hVar, jSONObject, i2);
        AppMethodBeat.o(137594);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.r.a
    public final void b(com.tencent.mm.plugin.appbrand.jsapi.h hVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(137593);
        new j().a(this, hVar, jSONObject, i2, this.mmD);
        AppMethodBeat.o(137593);
    }
}
