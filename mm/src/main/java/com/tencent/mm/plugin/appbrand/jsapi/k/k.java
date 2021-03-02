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

public final class k extends b {
    public static final int CTRL_INDEX = 893;
    public static final String NAME = "fromScreenLocation";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234544);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiFromScreenLocation", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(234544);
            return;
        }
        Log.i("MicroMsg.JsApiFromScreenLocation", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiFromScreenLocation", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(234544);
            return;
        }
        try {
            int i3 = jSONObject.getInt("x");
            int i4 = jSONObject.getInt("y");
            Point point = new Point();
            point.x = g.zD(i3);
            point.y = g.zD(i4);
            Log.i("MicroMsg.JsApiFromScreenLocation", "x:%d, y:%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
            b.i e2 = h2.e(point);
            HashMap hashMap = new HashMap();
            hashMap.put("latitude", Double.valueOf(e2.latitude));
            hashMap.put("longitude", Double.valueOf(e2.longitude));
            Log.i("MicroMsg.JsApiFromScreenLocation", "fromScreenLocation ok values:%s", hashMap.toString());
            fVar.i(i2, n("ok", hashMap));
            AppMethodBeat.o(234544);
        } catch (JSONException e3) {
            Log.i("MicroMsg.JsApiFromScreenLocation", "");
            Log.e("MicroMsg.JsApiFromScreenLocation", "parse fromScreenLocation error, exception : %s", e3);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(234544);
        }
    }
}
