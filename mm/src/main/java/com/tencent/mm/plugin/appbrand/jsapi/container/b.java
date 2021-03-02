package com.tencent.mm.plugin.appbrand.jsapi.container;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class b extends c {
    public static final int CTRL_INDEX = 512;
    public static final String NAME = "removePositioningContainer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(137508);
        int i2 = jSONObject.getInt("containerId");
        AppMethodBeat.o(137508);
        return i2;
    }
}
