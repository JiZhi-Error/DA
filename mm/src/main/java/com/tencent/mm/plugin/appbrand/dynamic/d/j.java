package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j extends a {
    public j(int i2) {
        super("reportIDKey", i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121331);
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.bt(a(false, "dataArray is null", (Map<String, ? extends Object>) null));
            AppMethodBeat.o(121331);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                h.INSTANCE.idkeyStat((long) jSONObject2.optInt("id"), (long) jSONObject2.optInt("key"), (long) jSONObject2.optInt("value"), false);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiFunc_ReportIDKey", "parse json failed : %s", e2.getMessage());
            }
        }
        aVar2.bt(a(true, "", (Map<String, ? extends Object>) null));
        AppMethodBeat.o(121331);
    }
}
