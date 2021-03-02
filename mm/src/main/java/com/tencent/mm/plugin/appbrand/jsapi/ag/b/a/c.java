package com.tencent.mm.plugin.appbrand.jsapi.ag.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import org.json.JSONObject;

public final class c extends d {
    private static final int CTRL_INDEX = 674;
    public static final String NAME = "updateXWebCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(139455);
        int optInt = jSONObject.optInt("viewId");
        AppMethodBeat.o(139455);
        return optInt;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.d
    public final boolean bEW() {
        return true;
    }
}
