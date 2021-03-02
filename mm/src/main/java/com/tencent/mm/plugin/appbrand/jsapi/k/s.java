package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class s extends b {
    public static final int CTRL_INDEX = 857;
    public static final String NAME = "initMapMarkerCluster";

    public static class a extends bc {
        private static final int CTRL_INDEX = 859;
        private static final String NAME = "onMapMarkerClusterClick";
    }

    public static class b extends bc {
        private static final int CTRL_INDEX = 858;
        private static final String NAME = "onMapMarkerClusterCreate";
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(final f fVar, final JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234548);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiInitMapMarkerCluster", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(234548);
            return;
        }
        Log.i("MicroMsg.JsApiInitMapMarkerCluster", "data:%s", jSONObject);
        com.tencent.mm.plugin.appbrand.jsapi.k.a.b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiInitMapMarkerCluster", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(234548);
            return;
        }
        boolean optBoolean = jSONObject.optBoolean("enableDefaultStyle", true);
        boolean optBoolean2 = jSONObject.optBoolean("zoomOnClick", true);
        int optInt = jSONObject.optInt("minimumClusterSize", 2);
        int optInt2 = jSONObject.optInt("gridSize", 60);
        Log.i("MicroMsg.JsApiInitMapMarkerCluster", "enableDefaultStyle:%b, zoomOnClick:%b, minimumClusterSize:%d, gridSize:%d", Boolean.valueOf(optBoolean), Boolean.valueOf(optBoolean2), Integer.valueOf(optInt), Integer.valueOf(optInt2));
        h2.a(optBoolean, optBoolean2, optInt, optInt2, new b.q() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.k.s.AnonymousClass1 */
            JSONObject jsonObject = new JSONObject();

            {
                AppMethodBeat.i(234545);
                AppMethodBeat.o(234545);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.q
            public final void p(JSONArray jSONArray) {
                AppMethodBeat.i(234546);
                b bVar = new b();
                HashMap hashMap = new HashMap();
                hashMap.put("clusters", jSONArray);
                hashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject)));
                try {
                    this.jsonObject.remove("clusters");
                    this.jsonObject.put("clusters", jSONArray);
                    this.jsonObject.remove("mapId");
                    this.jsonObject.put("mapId", com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject));
                } catch (JSONException e2) {
                }
                bVar.L(hashMap);
                Log.i("MicroMsg.JsApiInitMapMarkerCluster", "create clusterInfo:%s", jSONArray);
                h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
                if (c2 != null) {
                    c2.a(bVar, (int[]) null);
                    AppMethodBeat.o(234546);
                    return;
                }
                fVar.a(bVar);
                AppMethodBeat.o(234546);
            }

            @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.b.q
            public final void aa(JSONObject jSONObject) {
                AppMethodBeat.i(234547);
                a aVar = new a();
                HashMap hashMap = new HashMap();
                hashMap.put("cluster", jSONObject);
                hashMap.put("mapId", Integer.valueOf(com.tencent.mm.plugin.appbrand.jsapi.k.a.f.ab(jSONObject)));
                aVar.L(hashMap);
                Log.i("MicroMsg.JsApiInitMapMarkerCluster", "click clusterInfo:%s", jSONObject);
                h c2 = ((g) fVar.M(g.class)).c(fVar, jSONObject);
                if (c2 != null) {
                    c2.a(aVar, (int[]) null);
                    AppMethodBeat.o(234547);
                    return;
                }
                fVar.a(aVar);
                AppMethodBeat.o(234547);
            }
        });
        fVar.i(i2, h("ok", (JSONObject) null));
        AppMethodBeat.o(234548);
    }
}
