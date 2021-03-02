package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class w extends b {
    public static final int CTRL_INDEX = 890;
    public static final String NAME = "removeMapGroundOverlay";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.k.b
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(234558);
        super.a(fVar, jSONObject, i2);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiRemoveGroundOverlay", "data is null");
            fVar.i(i2, h("fail:invalid data", (JSONObject) null));
            AppMethodBeat.o(234558);
            return;
        }
        Log.i("MicroMsg.JsApiRemoveGroundOverlay", "data:%s", jSONObject);
        b h2 = h(fVar, jSONObject);
        if (h2 == null) {
            Log.e("MicroMsg.JsApiRemoveGroundOverlay", "mapView is null, return");
            fVar.i(i2, h("fail:mapview is null", (JSONObject) null));
            AppMethodBeat.o(234558);
            return;
        }
        try {
            if (h2.xf(jSONObject.getInt("id"))) {
                Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay success");
                fVar.i(i2, h("ok", (JSONObject) null));
                AppMethodBeat.o(234558);
                return;
            }
            Log.i("MicroMsg.JsApiRemoveGroundOverlay", "removeGroundOverlay fail");
            fVar.i(i2, h("fail", (JSONObject) null));
            AppMethodBeat.o(234558);
        } catch (JSONException e2) {
            Log.i("MicroMsg.JsApiRemoveGroundOverlay", "");
            Log.e("MicroMsg.JsApiRemoveGroundOverlay", "parse remove groundOverlay error, exception : %s", e2);
            a(fVar, i2, h("fail:internal error", (JSONObject) null), false, h2.bGX());
            AppMethodBeat.o(234558);
        }
    }
}
