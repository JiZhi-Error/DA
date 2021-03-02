package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    public static JSONObject a(Map map) {
        AppMethodBeat.i(173893);
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Object obj : map.keySet()) {
                a(jSONObject, obj.toString(), map.get(obj));
            }
        }
        AppMethodBeat.o(173893);
        return jSONObject;
    }

    public static <T> void a(JSONObject jSONObject, String str, T t) {
        AppMethodBeat.i(173892);
        try {
            jSONObject.put(str, t);
            AppMethodBeat.o(173892);
        } catch (JSONException e2) {
            AppMethodBeat.o(173892);
        }
    }
}
