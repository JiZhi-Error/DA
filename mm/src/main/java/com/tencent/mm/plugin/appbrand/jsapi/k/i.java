package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class i extends b {
    public static final int CTRL_INDEX = 492;
    public static final String NAME = "addMapPolygons";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143662);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddMapPolygons", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143662);
            return;
        }
        Log.i("MicroMsg.JsApiAddMapPolygons", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiAddMapPolygons", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143662);
            return;
        }
        try {
            if (jSONObject.has("polygons")) {
                h2.bHe();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("polygons"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    ArrayList arrayList = new ArrayList();
                    JSONArray jSONArray2 = new JSONArray(jSONObject2.optString("points"));
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        JSONObject jSONObject3 = jSONArray2.getJSONObject(i4);
                        arrayList.add(new b.i(Util.getDouble(jSONObject3.optString("latitude"), 0.0d), Util.getDouble(jSONObject3.optString("longitude"), 0.0d)) {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.k.i.AnonymousClass1 */
                        });
                    }
                    int cu = g.cu(jSONObject2.optString("fillColor", ""), Color.parseColor("#000000"));
                    int cu2 = g.cu(jSONObject2.optString("strokeColor", ""), Color.parseColor("#000000"));
                    int a2 = g.a(jSONObject2, "strokeWidth", 0);
                    int optInt = jSONObject2.optInt("zIndex", 0);
                    b.ab abVar = new b.ab();
                    abVar.maG = new ArrayList();
                    abVar.maG.addAll(arrayList);
                    abVar.fillColor = cu;
                    abVar.strokeWidth = a2;
                    abVar.strokeColor = cu2;
                    abVar.zIndex = optInt;
                    abVar.mau = jSONObject2.optString("level");
                    h2.a(abVar);
                }
            } else {
                Log.e("MicroMsg.JsApiAddMapPolygons", "data has not lines info");
            }
            a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
            AppMethodBeat.o(143662);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiAddMapPolygons", "parse lines error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(143662);
        }
    }
}
