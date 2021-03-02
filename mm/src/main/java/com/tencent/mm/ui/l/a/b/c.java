package com.tencent.mm.ui.l.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class c extends d<f> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "systemLog";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234431);
        String optString = jSONObject.optString("level");
        String optString2 = jSONObject.optString("content");
        if (!Util.isNullOrNil(optString) && !Util.isNullOrNil(optString2)) {
            if ("info".equalsIgnoreCase(optString)) {
                Log.i("MicroMsg.JsApiSystemLogME", optString2);
            } else if ("warn".equalsIgnoreCase(optString)) {
                Log.w("MicroMsg.JsApiSystemLogME", optString2);
            } else {
                Log.e("MicroMsg.JsApiSystemLogME", optString2);
            }
        }
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(234431);
    }
}
