package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import org.json.JSONObject;

public final class an extends ab {
    private static final int CTRL_INDEX = 396;
    private static final String NAME = "saveFileSync";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(128901);
        p.a f2 = am.f(fVar, jSONObject);
        String n = n(f2.errMsg, f2.values);
        AppMethodBeat.o(128901);
        return n;
    }
}
