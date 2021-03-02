package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.x.a;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class bs extends d {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "opNativeRedDot";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45560);
        String optString = jSONObject.optString("op");
        int optInt = jSONObject.optInt("redDotType", 0);
        Log.i("MicroMsg.JsApiOpNativeRedDot", "op:%s redDotType:%d", optString, Integer.valueOf(optInt));
        char c2 = 65535;
        switch (optString.hashCode()) {
            case 94746189:
                if (optString.equals("clear")) {
                    c2 = 0;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                a.zc(optInt);
                fVar.i(i2, h("ok", null));
                AppMethodBeat.o(45560);
                return;
            default:
                Log.w("MicroMsg.JsApiOpNativeRedDot", "unknown op:%s", optString);
                fVar.i(i2, h("fail unknown op", null));
                AppMethodBeat.o(45560);
                return;
        }
    }
}
