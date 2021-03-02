package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends b {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(final f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143659);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiAddMapControls", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143659);
            return;
        }
        Log.d("MicroMsg.JsApiAddMapControls", "data:%s", jSONObject.toString());
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiAddMapControls", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143659);
            return;
        }
        try {
            if (jSONObject.has("controls")) {
                h2.bHa();
                JSONArray jSONArray = new JSONArray(jSONObject.optString("controls"));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject2 = (JSONObject) jSONArray.get(i3);
                    b.c cVar = new b.c();
                    cVar.mav = ((com.tencent.mm.plugin.appbrand.f.b) fVar.M(com.tencent.mm.plugin.appbrand.f.b.class)).b(fVar, jSONObject2.optString("iconPath"));
                    cVar.maw = jSONObject2.optBoolean("clickable");
                    cVar.data = jSONObject2.optString("data");
                    JSONObject jSONObject3 = jSONObject2.getJSONObject("position");
                    int a2 = g.a(jSONObject3, "left", 0);
                    int a3 = g.a(jSONObject3, "top", 0);
                    cVar.left = a2;
                    cVar.top = a3;
                    if (jSONObject3.has("width")) {
                        cVar.width = g.a(jSONObject3, "width", 0);
                    }
                    if (jSONObject3.has("height")) {
                        cVar.height = g.a(jSONObject3, "height", 0);
                    }
                    if (jSONObject2.optBoolean("clickable")) {
                        final int ab = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject);
                        h2.a(cVar, new b.n() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.k.d.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.n
                            public final void ZQ(String str) {
                                AppMethodBeat.i(143658);
                                a aVar = new a((byte) 0);
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("mapId", ab);
                                    jSONObject.put("data", str);
                                } catch (JSONException e2) {
                                    Log.e("MicroMsg.JsApiAddMapControls", "put JSON data error : %s", e2);
                                }
                                aVar.Zh(jSONObject.toString());
                                fVar.a(aVar, (int[]) null);
                                AppMethodBeat.o(143658);
                            }
                        }, (com.tencent.mm.plugin.appbrand.f.a) fVar.M(com.tencent.mm.plugin.appbrand.f.a.class));
                    } else {
                        h2.a(cVar, (b.n) null, (com.tencent.mm.plugin.appbrand.f.a) fVar.M(com.tencent.mm.plugin.appbrand.f.a.class));
                    }
                }
            }
            a(fVar, i2, h("ok", (JSONObject) null), true, h2.bGX());
            AppMethodBeat.o(143659);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiAddMapControls", "parse controls error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(143659);
        }
    }

    static class a extends bc {
        private static final int CTRL_INDEX = 143;
        private static final String NAME = "onMapControlClick";

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }
}
