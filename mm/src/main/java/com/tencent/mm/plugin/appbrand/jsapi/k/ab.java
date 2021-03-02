package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ab extends b {
    public static final int CTRL_INDEX = 690;
    public static final String NAME = "setMapCenterOffset";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143691);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetMapCenterOffset", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143691);
            return;
        }
        Log.i("MicroMsg.JsApiSetMapCenterOffset", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiSetMapCenterOffset", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143691);
            return;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("offset");
            h2.c((float) jSONArray.optDouble(0, 0.5d), (float) jSONArray.optDouble(1, 0.5d), jSONObject.optBoolean("animated", false));
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiSetMapCenterOffset", "parse offset err:%s", e2);
        }
        a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
        AppMethodBeat.o(143691);
    }
}
