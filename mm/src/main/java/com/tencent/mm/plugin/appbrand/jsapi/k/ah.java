package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class ah extends b {
    public static final int CTRL_INDEX = 891;
    public static final String NAME = "updateMapGroundOverlay";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234561);
        super.a(fVar, jSONObject, i2);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(234561);
            return;
        }
        Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(234561);
            return;
        }
        try {
            b.e eVar = new b.e();
            int i3 = jSONObject.getInt("id");
            String string = jSONObject.getString("src");
            if (jSONObject.has("bounds")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("bounds");
                if (jSONObject2.has("southwest")) {
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("southwest");
                    eVar.may = new b.i(jSONObject3.optDouble("latitude", 0.0d), jSONObject3.optDouble("longitude", 0.0d));
                }
                if (jSONObject2.has("northeast")) {
                    JSONObject jSONObject4 = jSONObject2.getJSONObject("northeast");
                    eVar.maz = new b.i(jSONObject4.optDouble("latitude", 0.0d), jSONObject4.optDouble("longitude", 0.0d));
                }
            }
            boolean optBoolean = jSONObject.optBoolean("visible", true);
            int optInt = jSONObject.optInt("zIndex", 1);
            double optDouble = jSONObject.optDouble("opacity", 1.0d);
            eVar.mav = string;
            eVar.visible = optBoolean;
            eVar.zIndex = optInt;
            eVar.alpha = (float) optDouble;
            if (h2.b(i3, eVar, (a) fVar.M(a.class))) {
                Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay ok");
                fVar.i(i2, h("ok", (JSONObject) null));
                AppMethodBeat.o(234561);
                return;
            }
            Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "updateGroundOverlay fail");
            fVar.i(i2, h("fail", (JSONObject) null));
            AppMethodBeat.o(234561);
        } catch (JSONException e2) {
            Log.i("MicroMsg.JsApiUpdateMapGroundOverlay", "");
            Log.e("MicroMsg.JsApiUpdateMapGroundOverlay", "parse update groundOverlay error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(234561);
        }
    }
}
