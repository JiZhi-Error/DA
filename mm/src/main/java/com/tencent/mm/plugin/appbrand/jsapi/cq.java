package com.tencent.mm.plugin.appbrand.jsapi;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class cq extends d {
    public static final int CTRL_INDEX = 731;
    public static final String NAME = "saveWaid";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45633);
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            fVar.i(i2, n("ok", hashMap));
            Log.i("MicroMsg.JsApiSaveWaid", "appBrand JsApiSaveWaid, data=" + jSONObject + ", waidNum=0");
            AppMethodBeat.o(45633);
        } catch (Exception e2) {
            hashMap.put("result", AppEventsConstants.EVENT_PARAM_VALUE_NO);
            fVar.i(i2, n("fail", hashMap));
            Log.e("MicroMsg.JsApiSaveWaid", "appBrand JsApiSaveWaid, exp=" + e2.toString());
            AppMethodBeat.o(45633);
        }
    }
}
