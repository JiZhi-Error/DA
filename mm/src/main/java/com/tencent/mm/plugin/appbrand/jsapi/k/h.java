package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.k.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class h extends b {
    public static final int CTRL_INDEX = 133;
    public static final String NAME = "addMapMarkers";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(final f fVar, final JSONObject jSONObject, int i2) {
        JSONArray jSONArray;
        JSONObject jSONObject2;
        AppMethodBeat.i(143661);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddMapMarkers", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143661);
            return;
        }
        Log.i("MicroMsg.JsApiAddMapMarkers", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiAddMapMarkers", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143661);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("clear", true);
        Log.i("MicroMsg.JsApiAddMapMarkers", "clear:%b", Boolean.valueOf(optBoolean));
        if (optBoolean) {
            h2.bHc();
        }
        if (jSONObject.has("markers")) {
            try {
                jSONArray = new JSONArray(jSONObject.optString("markers"));
            } catch (JSONException e2) {
                jSONArray = null;
            }
            if (jSONArray == null) {
                Log.e("MicroMsg.JsApiAddMapMarkers", "markersArray is null, return");
                fVar.i(i2, h("fail:internal error", (JSONObject) null));
                AppMethodBeat.o(143661);
                return;
            }
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    jSONObject2 = (JSONObject) jSONArray.get(i3);
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.JsApiAddMapMarkers", e3, "", new Object[0]);
                    jSONObject2 = null;
                }
                if (jSONObject2 != null) {
                    b.v a2 = a(fVar, jSONObject, jSONObject2);
                    String optString = jSONObject2.optString("id");
                    if (a2.maN && !h2.bHg() && !h2.bHh()) {
                        h2.a(true, true, 2, 60, (b.q) new b.q() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.k.h.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.q
                            public final void p(JSONArray jSONArray) {
                                AppMethodBeat.i(234542);
                                s.b bVar = new s.b();
                                HashMap hashMap = new HashMap();
                                hashMap.put("clusters", jSONArray);
                                hashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject)));
                                bVar.L(hashMap);
                                Log.i("MicroMsg.JsApiAddMapMarkers", "create clusterInfo:%s", jSONArray);
                                com.tencent.mm.plugin.appbrand.jsapi.h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
                                if (c2 != null) {
                                    c2.a(bVar, (int[]) null);
                                    AppMethodBeat.o(234542);
                                    return;
                                }
                                fVar.a(bVar);
                                AppMethodBeat.o(234542);
                            }

                            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.q
                            public final void aa(JSONObject jSONObject) {
                                AppMethodBeat.i(234543);
                                s.a aVar = new s.a();
                                HashMap hashMap = new HashMap();
                                hashMap.put("cluster", jSONObject);
                                hashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject)));
                                aVar.L(hashMap);
                                Log.i("MicroMsg.JsApiAddMapMarkers", "click clusterInfo:%s", jSONObject);
                                com.tencent.mm.plugin.appbrand.jsapi.h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
                                if (c2 != null) {
                                    c2.a(aVar, (int[]) null);
                                    AppMethodBeat.o(234543);
                                    return;
                                }
                                fVar.a(aVar);
                                AppMethodBeat.o(234543);
                            }
                        });
                    }
                    h2.a(optString, a2, (a) fVar.M(a.class));
                }
            }
        }
        a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
        AppMethodBeat.o(143661);
    }
}
