package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class v extends b {
    public static final int CTRL_INDEX = 141;
    public static final String NAME = "moveToMapLocation";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143686);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiMoveToMapLocation", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143686);
            return;
        }
        Log.i("MicroMsg.JsApiMoveToMapLocation", "moveToMapLocation data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiMoveToMapLocation", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143686);
            return;
        }
        if (jSONObject.has("latitude") || jSONObject.has("longitude")) {
            h2.f(Util.getDouble(jSONObject.optString("latitude"), 0.0d), Util.getDouble(jSONObject.optString("longitude"), 0.0d));
        } else {
            h2.bGV();
        }
        a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
        AppMethodBeat.o(143686);
    }
}
