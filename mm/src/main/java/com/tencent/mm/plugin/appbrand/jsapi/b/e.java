package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

public final class e extends ab {
    public static final int CTRL_INDEX = 401;
    public static final String NAME = "canvasToTempFilePathSync";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final String a(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(145534);
        String h2 = h("fail:not supported", null);
        AppMethodBeat.o(145534);
        return h2;
    }
}
