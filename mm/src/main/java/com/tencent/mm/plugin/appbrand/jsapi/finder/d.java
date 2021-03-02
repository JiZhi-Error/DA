package com.tencent.mm.plugin.appbrand.jsapi.finder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.d<f> {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "kvReport";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(163955);
        Log.i("MicroMsg.Finder.JsApiKvReport", NAME);
        if (jSONObject == null) {
            fVar.i(i2, "fail:data is null");
            AppMethodBeat.o(163955);
            return;
        }
        int optInt = jSONObject.optInt("logId");
        String optString = jSONObject.optString("logStr");
        if (optInt > 0 && !Util.isNullOrNil(optString)) {
            Log.i("MicroMsg.Finder.JsApiKvReport", "%s %s", Integer.valueOf(optInt), optString);
            e.INSTANCE.kvStat(optInt, optString);
        }
        AppMethodBeat.o(163955);
    }
}
