package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class g extends e<s> {
    private static final int CTRL_INDEX = 587;
    private static final String NAME = "disableLocationUpdate";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.i.e
    public /* bridge */ /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138193);
        a(sVar, jSONObject, i2);
        AppMethodBeat.o(138193);
    }

    public void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(138192);
        super.a((f) sVar, jSONObject, i2);
        if (!(this.lXb instanceof t)) {
            Log.w("MicroMsg.AppBrand.JsApiDisableLocationUpdateWxa", "state manager not RuntimeLocationUpdateStateManagerWxa");
            sVar.i(i2, h("fail:system error", null));
            AppMethodBeat.o(138192);
            return;
        }
        ((t) this.lXb).X(sVar.getRuntime());
        AppMethodBeat.o(138192);
    }
}
