package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class bh extends d {
    public static final int CTRL_INDEX = 711;
    public static final String NAME = "getOAID";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45492);
        String aoK = q.aoK();
        Log.i("MicroMsg.JsApiGetOAID", "getOAID, oaid=".concat(String.valueOf(aoK)));
        if (Util.isNullOrNil(aoK)) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(45492);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("result", aoK);
        fVar.i(i2, n("ok", hashMap));
        AppMethodBeat.o(45492);
    }
}
