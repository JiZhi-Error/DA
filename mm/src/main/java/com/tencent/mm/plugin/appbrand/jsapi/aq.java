package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class aq extends JsApiUploadWeRunData {
    public static final int CTRL_INDEX = 324;
    public static final String NAME = "addWeRunData";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadWeRunData, com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45450);
        Log.d("MicroMsg.JsApiAddWeRunData", "JsApiAddWeRunData!");
        if (jSONObject == null) {
            fVar.i(i2, h("fail:data is null", null));
            Log.e("MicroMsg.JsApiAddWeRunData", "data is null");
            AppMethodBeat.o(45450);
            return;
        }
        a(this, fVar, i2, jSONObject.optInt("step"), true);
        AppMethodBeat.o(45450);
    }
}
