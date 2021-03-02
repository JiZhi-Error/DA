package com.tencent.mm.plugin.appbrand.jsapi.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import org.json.JSONObject;

public final class l extends d {
    public static final int CTRL_INDEX = 83;
    public static final String NAME = "updateCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145543);
        int optInt = jSONObject.optInt("canvasId");
        AppMethodBeat.o(145543);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEW() {
        return true;
    }
}
