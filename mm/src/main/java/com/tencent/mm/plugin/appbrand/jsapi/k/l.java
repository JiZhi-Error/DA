package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class l extends b {
    public static final int CTRL_INDEX = 144;
    public static final String NAME = "getMapCenterLocation";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143664);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetMapCenterLocation", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143664);
            return;
        }
        Log.i("MicroMsg.JsApiGetMapCenterLocation", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiGetMapCenterLocation", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143664);
            return;
        }
        HashMap hashMap = new HashMap();
        b.i bGY = h2.bGY();
        hashMap.put("latitude", Double.valueOf(bGY.latitude));
        hashMap.put("longitude", Double.valueOf(bGY.longitude));
        Log.i("MicroMsg.JsApiGetMapCenterLocation", "ok, values:%s", hashMap.toString());
        a(fVar, i2, n("ok", hashMap), true, h2.bGX());
        AppMethodBeat.o(143664);
    }
}
