package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class ae extends b {
    public static final int CTRL_INDEX = 892;
    public static final String NAME = "toScreenLocation";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234560);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiToScreenLocation", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(234560);
            return;
        }
        Log.i("MicroMsg.JsApiToScreenLocation", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiToScreenLocation", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(234560);
            return;
        }
        try {
            Point a2 = h2.a(new b.i(jSONObject.getDouble("latitude"), jSONObject.getDouble("longitude")));
            if (a2 != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("x", Integer.valueOf(g.zC(a2.x)));
                hashMap.put("y", Integer.valueOf(g.zC(a2.y)));
                Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation ok values:%s", hashMap.toString());
                fVar.i(i2, n("ok", hashMap));
                AppMethodBeat.o(234560);
                return;
            }
            Log.i("MicroMsg.JsApiToScreenLocation", "toScreenLocation fail");
            fVar.i(i2, h("fail:point is empty", (JSONObject) null));
            AppMethodBeat.o(234560);
        } catch (JSONException e2) {
            Log.i("MicroMsg.JsApiToScreenLocation", "");
            Log.e("MicroMsg.JsApiToScreenLocation", "parse toScreenLocation error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(234560);
        }
    }
}
