package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class j extends b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "eraseMapLines";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143663);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiEraseMapLines", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143663);
            return;
        }
        Log.i("MicroMsg.JsApiEraseMapLines", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiEraseMapLines", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143663);
        } else if (jSONObject.has("lines")) {
            try {
                JSONArray jSONArray = new JSONArray(jSONObject.optString("lines"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    String optString = jSONObject2.optString("id");
                    if (!Util.isNullOrNil(optString)) {
                        b.i iVar = null;
                        JSONObject optJSONObject = jSONObject2.optJSONObject("point");
                        if (optJSONObject != null) {
                            iVar = new b.i(Util.getDouble(optJSONObject.optString("latitude"), 0.0d), Util.getDouble(optJSONObject.optString("longitude"), 0.0d));
                        }
                        if (iVar != null) {
                            h2.a(optString, jSONObject2.optInt(FirebaseAnalytics.b.INDEX, 0), iVar, jSONObject2.optBoolean("clear", true));
                        }
                    }
                }
                a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
                AppMethodBeat.o(143663);
            } catch (JSONException e2) {
                Log.printInfoStack("MicroMsg.JsApiEraseMapLines", "", e2);
                a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
                AppMethodBeat.o(143663);
            }
        } else {
            Log.e("MicroMsg.JsApiEraseMapLines", "data has not lines info");
            a(fVar, i2, h("fail:invalid data", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(143663);
        }
    }
}
