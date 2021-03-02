package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ai extends b {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "updateMapMarkers";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        AppMethodBeat.i(183553);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiUpdateMapMarkers", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(183553);
            return;
        }
        Log.i("MicroMsg.JsApiUpdateMapMarkers", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiUpdateMapMarkers", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(183553);
            return;
        }
        if (jSONObject.has("markers")) {
            try {
                jSONArray = new JSONArray(jSONObject.optString("markers"));
            } catch (JSONException e2) {
                jSONArray = null;
            }
            if (jSONArray == null) {
                Log.e("MicroMsg.JsApiUpdateMapMarkers", "markersArray is null, return");
                fVar.i(i2, h("fail:internal error", (JSONObject) null));
                AppMethodBeat.o(183553);
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    jSONObject2 = (JSONObject) jSONArray.get(i3);
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.JsApiUpdateMapMarkers", e3, "", new Object[0]);
                    jSONObject2 = null;
                }
                if (jSONObject2 != null) {
                    b.v a2 = a(fVar, jSONObject, jSONObject2);
                    String optString = jSONObject2.optString("id");
                    fVar.M(a.class);
                    h2.a(optString, a2);
                }
            }
        }
        a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
        AppMethodBeat.o(183553);
    }
}
