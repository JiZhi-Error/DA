package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import org.json.JSONObject;

public final class j extends c<h> {
    public static final int CTRL_INDEX = 68;
    public static final String NAME = "removeCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145542);
        int optInt = jSONObject.optInt("canvasId");
        AppMethodBeat.o(145542);
        return optInt;
    }
}
