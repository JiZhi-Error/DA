package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class n extends b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapRegion";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143666);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetMapRegion", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143666);
            return;
        }
        Log.i("MicroMsg.JsApiGetMapRegion", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiGetMapRegion", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143666);
            return;
        }
        b.ad adVar = h2.bGU().mbe;
        if (adVar == null) {
            Log.e("MicroMsg.JsApiGetMapRegion", "visibleRegion is  null");
            fVar.i(i2, h("fail:visibleRegion is null", (JSONObject) null));
            AppMethodBeat.o(143666);
            return;
        }
        b.j jVar = adVar.mbf;
        if (jVar == null) {
            Log.e("MicroMsg.JsApiGetMapRegion", "latLngBounds is  null");
            fVar.i(i2, h("fail:latLngBounds is null", (JSONObject) null));
            AppMethodBeat.o(143666);
            return;
        }
        b.i iVar = jVar.maE;
        b.i iVar2 = jVar.maF;
        HashMap hashMap = new HashMap();
        if (iVar != null) {
            hashMap.put("latitude", Double.valueOf(iVar.latitude));
            hashMap.put("longitude", Double.valueOf(iVar.longitude));
        }
        HashMap hashMap2 = new HashMap();
        if (iVar2 != null) {
            hashMap2.put("latitude", Double.valueOf(iVar2.latitude));
            hashMap2.put("longitude", Double.valueOf(iVar2.longitude));
        }
        HashMap hashMap3 = new HashMap();
        hashMap3.put("southwest", hashMap);
        hashMap3.put("northeast", hashMap2);
        Log.i("MicroMsg.JsApiGetMapRegion", "getMapRegion ok, values:%s", hashMap3.toString());
        a(fVar, i2, n("ok", hashMap3), true, h2.bGX());
        AppMethodBeat.o(143666);
    }
}
