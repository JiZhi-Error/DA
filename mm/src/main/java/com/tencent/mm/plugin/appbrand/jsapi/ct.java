package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.plugin.appbrand.performance.c;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ct extends d<d> {
    public static final int CTRL_INDEX = 283;
    public static final String NAME = "traceEvent";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(d dVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(147145);
        d dVar2 = dVar;
        JSONArray optJSONArray = jSONObject.optJSONArray("events");
        if (!AppBrandPerformanceManager.e((com.tencent.luggage.sdk.d.d) dVar2.getRuntime()) || optJSONArray == null) {
            dVar2.i(i2, h("fail", null));
            AppMethodBeat.o(147145);
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("category");
                String optString2 = optJSONObject.optString("name");
                long optLong = optJSONObject.optLong("start");
                long optLong2 = optJSONObject.optLong("end");
                String optString3 = optJSONObject.optString("phase");
                String optString4 = optJSONObject.optString("args");
                if (!Util.isNullOrNil(optString2)) {
                    c.a(dVar2.getAppId(), optString, optString2, optString3, optLong, optLong2, optString4);
                }
            }
        }
        dVar2.i(i2, h("ok", null));
        AppMethodBeat.o(147145);
    }
}
