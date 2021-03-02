package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aa extends b {
    public static final int CTRL_INDEX = 343;
    public static final String NAME = "removeMapMarkers";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143690);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiRemoveMapMarkers", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143690);
            return;
        }
        Log.i("MicroMsg.JsApiRemoveMapMarkers", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiRemoveMapMarkers", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143690);
            return;
        }
        if (jSONObject.has("markers")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("markers"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    h2.ZV(jSONArray.getString(i3));
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.JsApiRemoveMapMarkers", e2, "", new Object[0]);
                fVar.i(i2, h("fail:internal error", (JSONObject) null));
                AppMethodBeat.o(143690);
                return;
            }
        }
        a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
        AppMethodBeat.o(143690);
    }
}
