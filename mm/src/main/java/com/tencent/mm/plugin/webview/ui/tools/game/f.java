package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class f {
    public static void P(String str, Map<Integer, Object> map) {
        AppMethodBeat.i(80874);
        if (MMApplicationContext.isToolsProcess() || MMApplicationContext.isToolsMpProcess()) {
            d.S(str, map);
            AppMethodBeat.o(80874);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("report_data", bQ(map).toString());
        bundle.putString("page_key", str);
        ToolsProcessIPCService.a(bundle, a.class, null);
        AppMethodBeat.o(80874);
    }

    private static JSONObject bQ(Map<Integer, Object> map) {
        AppMethodBeat.i(80875);
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            AppMethodBeat.o(80875);
            return jSONObject;
        }
        try {
            for (Integer num : map.keySet()) {
                jSONObject.put(String.valueOf(num), map.get(num));
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(80875);
        return jSONObject;
    }

    public static Map<Integer, Object> cc(JSONObject jSONObject) {
        AppMethodBeat.i(80876);
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            AppMethodBeat.o(80876);
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            int i2 = Util.getInt(next, -1);
            if (i2 == -1) {
                Log.i("MicroMsg.GameWebReportUtil", "reportData key error");
            } else {
                hashMap.put(Integer.valueOf(i2), jSONObject.opt(next));
            }
        }
        AppMethodBeat.o(80876);
        return hashMap;
    }

    public static class a implements b<Bundle, Bundle> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(Bundle bundle, d<Bundle> dVar) {
            AppMethodBeat.i(80873);
            Bundle bundle2 = bundle;
            String string = bundle2.getString("report_data");
            String string2 = bundle2.getString("page_key");
            if (!Util.isNullOrNil(string)) {
                try {
                    f.P(string2, f.cc(new JSONObject(string)));
                    AppMethodBeat.o(80873);
                    return;
                } catch (JSONException e2) {
                }
            }
            AppMethodBeat.o(80873);
        }
    }
}
