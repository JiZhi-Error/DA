package com.tencent.mm.plugin.appbrand.jsapi.ag.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.c;
import org.json.JSONObject;

public class a extends c {
    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(215802);
        int optInt = jSONObject.optInt("cameraId");
        AppMethodBeat.o(215802);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.h.c
    public final String bCy() {
        return "camera";
    }
}
