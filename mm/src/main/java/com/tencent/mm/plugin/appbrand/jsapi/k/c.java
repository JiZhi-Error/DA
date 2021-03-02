package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c extends b {
    public static final int CTRL_INDEX = 135;
    public static final String NAME = "addMapCircles";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143657);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddMapCircles", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143657);
            return;
        }
        Log.i("MicroMsg.JsApiAddMapCircles", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiAddMapCircles", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143657);
            return;
        }
        try {
            if (jSONObject.has("circles")) {
                h2.bGZ();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("circles"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    double d2 = Util.getDouble(jSONObject2.optString("latitude"), 0.0d);
                    double d3 = Util.getDouble(jSONObject2.optString("longitude"), 0.0d);
                    int cu = g.cu(jSONObject2.optString("color", ""), Color.parseColor("#000000"));
                    int cu2 = g.cu(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int optInt = jSONObject2.optInt("radius");
                    float a2 = g.a(jSONObject2, "strokeWidth", 0.0f);
                    b.C0670b bVar = new b.C0670b();
                    bVar.latitude = d2;
                    bVar.longitude = d3;
                    bVar.radius = optInt;
                    bVar.strokeColor = cu;
                    bVar.strokeWidth = (int) a2;
                    bVar.fillColor = cu2;
                    bVar.mau = jSONObject2.optString("level");
                    h2.a(bVar);
                }
            }
            a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
            AppMethodBeat.o(143657);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiAddMapCircles", "parse circles error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(143657);
        }
    }
}
