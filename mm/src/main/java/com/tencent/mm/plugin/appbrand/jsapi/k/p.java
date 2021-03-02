package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends b {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "getMapScale";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143668);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiGetMapScale", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(143668);
            return;
        }
        Log.i("MicroMsg.JsApiGetMapScale", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiGetMapScale", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(143668);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("scale", Float.valueOf(h2.getZoom()));
        Log.i("MicroMsg.JsApiGetMapScale", "getMapScale ok, values:%s", hashMap.toString());
        a(fVar, i2, n("ok", hashMap), true, h2.bGX());
        AppMethodBeat.o(143668);
    }
}
