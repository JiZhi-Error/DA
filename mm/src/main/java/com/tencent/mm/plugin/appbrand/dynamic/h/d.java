package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.collector.CollectSession;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.jsapi.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private static Set<String> lpg = new HashSet();

    static {
        AppMethodBeat.i(121439);
        if (!TextUtils.isEmpty(f.NAME)) {
            lpg.add(f.NAME);
        }
        AppMethodBeat.o(121439);
    }

    public static boolean WP(String str) {
        AppMethodBeat.i(121436);
        boolean contains = lpg.contains(str);
        AppMethodBeat.o(121436);
        return contains;
    }

    public static void a(String str, String str2, JSONObject jSONObject) {
        AppMethodBeat.i(121437);
        try {
            jSONObject.put("__session_id", str);
            jSONObject.put("__invoke_jsapi_timestamp", System.nanoTime());
            CollectSession WJ = c.WJ(str);
            if (WJ != null) {
                WJ.dNV.putInt("__invoke_jsapi_data_size", str2.length());
            }
            AppMethodBeat.o(121437);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiCostTimeStrategy", "%s", android.util.Log.getStackTraceString(e2));
            AppMethodBeat.o(121437);
        }
    }

    public static String G(JSONObject jSONObject) {
        AppMethodBeat.i(121438);
        String optString = jSONObject.optString("__session_id");
        AppMethodBeat.o(121438);
        return optString;
    }
}
