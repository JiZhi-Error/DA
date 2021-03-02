package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Color;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class ad extends b {
    public static final int CTRL_INDEX = 860;
    public static final String NAME = "setMapIndoorMaskColor";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234559);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiSetMapIndoorMaskColor", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(234559);
            return;
        }
        Log.i("MicroMsg.JsApiSetMapIndoorMaskColor", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiSetMapIndoorMaskColor", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(234559);
            return;
        }
        h2.setIndoorMaskColor(g.cu(jSONObject.optString("maskColor", "#000000"), Color.parseColor("#000000")));
        fVar.i(i2, h("ok", (JSONObject) null));
        AppMethodBeat.o(234559);
    }
}
