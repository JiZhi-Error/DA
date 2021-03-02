package com.tencent.mm.plugin.appbrand.dynamic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.recovery.util.Util;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class f extends a {
    public f(int i2) {
        super("log", i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121312);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("dataArray");
            ArrayList arrayList = new ArrayList(jSONArray.length());
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                if (jSONObject2 != null) {
                    LogInfo logInfo = new LogInfo();
                    logInfo.ts = jSONObject2.optLong("ts");
                    logInfo.level = jSONObject2.optInt("level") + 1;
                    logInfo.message = jSONObject2.optString("msg");
                    arrayList.add(logInfo);
                    Log.d("MicroMsg.JsApiFunc_Log", "ts : %s, level : %d, msg : %s", Util.getTimeFormat(logInfo.ts), Integer.valueOf(logInfo.level), logInfo.message);
                }
            }
            com.tencent.mm.plugin.appbrand.dynamic.debugger.a.d(aVar.ayQ().getString("__page_view_id", null), arrayList);
            aVar2.bt(a(true, "", (Map<String, ? extends Object>) null));
            AppMethodBeat.o(121312);
        } catch (JSONException e2) {
            aVar2.bt(a(false, "dataArray is null", (Map<String, ? extends Object>) null));
            AppMethodBeat.o(121312);
        }
    }
}
