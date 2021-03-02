package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapSkew";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143669);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetMapSkew", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143669);
            return;
        }
        Log.i("MicroMsg.JsApiGetMapSkew", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiGetMapSkew", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143669);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("skew", Float.valueOf(h2.getSkew()));
        Log.i("MicroMsg.JsApiGetMapSkew", "getMapSkew ok, values:%s", hashMap.toString());
        a(fVar, i2, n("ok", hashMap), true, h2.bGX());
        AppMethodBeat.o(143669);
    }
}
