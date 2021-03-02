package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class e<CONTEXT extends f> extends d<CONTEXT> {
    private static final int CTRL_INDEX = 587;
    private static final String NAME = "disableLocationUpdate";
    protected s lXb;

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public void a(CONTEXT context, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(143627);
        Log.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "disableLocationUpdate invoke");
        this.lXb = (s) context.aw(s.class);
        if (this.lXb == null) {
            Log.i("MicroMsg.AppBrand.JsApiDisableLocationUpdate", "fail:location update not enabled");
            context.i(i2, h("fail:location update not enabled", null));
            AppMethodBeat.o(143627);
            return;
        }
        this.lXb.bGK();
        context.i(i2, h("ok", null));
        AppMethodBeat.o(143627);
    }
}
