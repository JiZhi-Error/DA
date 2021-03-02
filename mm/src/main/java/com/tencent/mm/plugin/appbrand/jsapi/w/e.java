package com.tencent.mm.plugin.appbrand.jsapi.w;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends d {
    private static final int CTRL_INDEX = 64;
    private static final String NAME = "reportIDKey";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(107802);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            fVar.i(i2, h("fail", null));
            AppMethodBeat.o(107802);
            return;
        }
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                h.INSTANCE.idkeyStat((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiReportIDKey", "parse json failed : %s", e2.getMessage());
            }
        }
        fVar.i(i2, h("ok", null));
        AppMethodBeat.o(107802);
    }
}
