package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r extends b {
    public static final int CTRL_INDEX = 136;
    public static final String NAME = "includeMapPoints";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143670);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiIncludeMapPoints", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143670);
            return;
        }
        Log.i("MicroMsg.JsApiIncludeMapPoints", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiIncludeMapPoints", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143670);
            return;
        }
        try {
            if (jSONObject.has("points")) {
                ArrayList arrayList = new ArrayList();
                String optString = jSONObject.optString("points");
                if (!Util.isNullOrNil(optString)) {
                    JSONArray jSONArray = new JSONArray(optString);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                        arrayList.add(new b.i(Util.getDouble(jSONObject2.optString("latitude"), 0.0d), Util.getDouble(jSONObject2.optString("longitude"), 0.0d)) {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.k.r.AnonymousClass1 */
                        });
                    }
                }
                int i4 = 0;
                String optString2 = jSONObject.optString("padding");
                if (!Util.isNullOrNil(optString2)) {
                    i4 = g.c(new JSONArray(optString2), 0);
                }
                if (arrayList.size() > 0) {
                    h2.h(arrayList, i4);
                }
            }
            a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
            AppMethodBeat.o(143670);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiIncludeMapPoints", "parse points error, exception : %s", e2);
            fVar.i(i2, h("fail:internal error", (JSONObject) null));
            AppMethodBeat.o(143670);
        }
    }
}
