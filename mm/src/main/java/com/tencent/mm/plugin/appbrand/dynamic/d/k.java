package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetContext;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class k extends a {
    public k(int i2) {
        super(f.NAME, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121332);
        WxaWidgetContext Ys = com.tencent.mm.plugin.appbrand.dynamic.k.Ys(aVar.ayQ().getString("__page_view_id", null));
        if (Ys == null) {
            aVar2.bt(a(false, "JsApi Framework Context is null", (Map<String, ? extends Object>) null));
            AppMethodBeat.o(121332);
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("dataArray");
        if (optJSONArray == null) {
            aVar2.bt(a(false, "dataArray is null", (Map<String, ? extends Object>) null));
            AppMethodBeat.o(121332);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key");
                String optString = jSONObject2.optString("value");
                if (optInt > 0 && !Util.isNullOrNil(optString)) {
                    h.INSTANCE.a(optInt, Ys.getAppId(), Integer.valueOf(Ys.bBQ()), Integer.valueOf(com.tencent.mm.plugin.appbrand.dynamic.k.b.wq(Ys.bvh()) + 1), optString);
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiFunc_ReportKeyValue", "parse report value failed : %s", e2);
            }
        }
        aVar2.bt(a(true, "", (Map<String, ? extends Object>) null));
        AppMethodBeat.o(121332);
    }
}
