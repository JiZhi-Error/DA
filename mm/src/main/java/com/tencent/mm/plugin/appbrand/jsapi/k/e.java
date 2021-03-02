package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e extends b {
    public static final int CTRL_INDEX = 785;
    public static final String NAME = "addMapCustomLayer";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(183551);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddMapCustomLayer", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(183551);
            return;
        }
        Log.i("MicroMsg.JsApiAddMapCustomLayer", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiAddMapCustomLayer", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(183551);
            return;
        }
        h2.ZR(jSONObject.optString("layerId", ""));
        a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
        AppMethodBeat.o(183551);
    }
}
