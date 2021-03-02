package com.tencent.mm.plugin.expt.hellhound.a.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static JSONObject ac(String str, String str2, String str3) {
        AppMethodBeat.i(122089);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("businessId", str3);
            jSONObject.put("dataPath", str);
            jSONObject.put("value", str2);
            AppMethodBeat.o(122089);
            return jSONObject;
        } catch (JSONException e2) {
            Log.printErrStackTrace("HABBYGE-MALI.AsyncBizCollector", e2, "AsyncBizCollector, generateParamJSONOBject, %s", e2.getMessage());
            AppMethodBeat.o(122089);
            return null;
        }
    }
}
