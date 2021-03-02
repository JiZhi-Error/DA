package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class m extends b {
    public static final int CTRL_INDEX = 525;
    public static final String NAME = "getMapIndoorFloor";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143665);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetMapActiveIndoorInfo", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143665);
            return;
        }
        Log.i("MicroMsg.JsApiGetMapActiveIndoorInfo", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiGetMapActiveIndoorInfo", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143665);
            return;
        }
        b.f bGW = h2.bGW();
        HashMap hashMap = new HashMap();
        if (bGW != null) {
            try {
                hashMap.put("buildingId", bGW.buildingId);
                hashMap.put("buildingName", bGW.buildingName);
                if (bGW.maA != null && bGW.maA.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (b.g gVar : bGW.maA) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("name", gVar.floorName);
                        jSONArray.put(jSONObject2);
                    }
                    hashMap.put("floorList", jSONArray);
                }
                hashMap.put("floorIndex", Integer.valueOf(bGW.maB));
            } catch (JSONException e2) {
                Log.e("MicroMsg.JsApiGetMapActiveIndoorInfo", "put JSON data error : %s", e2);
            }
        }
        Log.i("MicroMsg.JsApiGetMapActiveIndoorInfo", "getMapActiveIndoorInfo ok, values:%s", hashMap.toString());
        a(fVar, i2, n("ok", hashMap), true, h2.bGX());
        AppMethodBeat.o(143665);
    }
}
