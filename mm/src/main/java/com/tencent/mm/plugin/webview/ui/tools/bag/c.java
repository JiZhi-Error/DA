package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    private static final HashSet<String> JkU;

    public static JSONObject be(Bundle bundle) {
        AppMethodBeat.i(80436);
        JSONObject jSONObject = new JSONObject();
        if (bundle == null) {
            AppMethodBeat.o(80436);
            return jSONObject;
        }
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, new a(bundle.get(str)));
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.WebViewBagIntentLogic", "save exp:%s", e2);
        }
        AppMethodBeat.o(80436);
        return jSONObject;
    }

    public static void a(Intent intent, JSONObject jSONObject) {
        AppMethodBeat.i(80437);
        if (jSONObject == null) {
            AppMethodBeat.o(80437);
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        if (keys == null) {
            AppMethodBeat.o(80437);
            return;
        }
        Bundle bundle = new Bundle();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                a.b(bundle, next, jSONObject.getJSONObject(next));
            } catch (JSONException e2) {
            }
        }
        intent.putExtras(bundle);
        AppMethodBeat.o(80437);
    }

    /* access modifiers changed from: package-private */
    public static final class a extends JSONObject {
        public a(Object obj) {
            AppMethodBeat.i(80434);
            if (obj instanceof String) {
                put("type", 1);
                put("val", obj);
                AppMethodBeat.o(80434);
            } else if (obj instanceof Integer) {
                put("type", 2);
                put("val", obj);
                AppMethodBeat.o(80434);
            } else if (obj instanceof Long) {
                put("type", 3);
                put("val", obj);
                AppMethodBeat.o(80434);
            } else if (obj instanceof Boolean) {
                put("type", 4);
                put("val", obj);
                AppMethodBeat.o(80434);
            } else {
                Log.w("MicroMsg.WebViewBagIntentLogic", "put not support type;class:%s", obj.getClass());
                put("type", 0);
                put("val", obj);
                AppMethodBeat.o(80434);
            }
        }

        static void b(Bundle bundle, String str, JSONObject jSONObject) {
            AppMethodBeat.i(80435);
            try {
                int i2 = jSONObject.getInt("type");
                Log.i("MicroMsg.WebViewBagIntentLogic", "restoreToBundle key:%s type：%d", str, Integer.valueOf(i2));
                switch (i2) {
                    case 1:
                        bundle.putString(str, jSONObject.getString("val"));
                        AppMethodBeat.o(80435);
                        return;
                    case 2:
                        bundle.putInt(str, jSONObject.getInt("val"));
                        AppMethodBeat.o(80435);
                        return;
                    case 3:
                        bundle.putLong(str, jSONObject.getLong("val"));
                        AppMethodBeat.o(80435);
                        return;
                    case 4:
                        bundle.putBoolean(str, jSONObject.getBoolean("val"));
                        AppMethodBeat.o(80435);
                        return;
                    default:
                        Log.w("MicroMsg.WebViewBagIntentLogic", "not support type");
                        AppMethodBeat.o(80435);
                        return;
                }
            } catch (JSONException e2) {
                Log.e("MicroMsg.WebViewBagIntentLogic", "restoreToBundle e:%s", e2);
                AppMethodBeat.o(80435);
            }
        }
    }

    static {
        AppMethodBeat.i(80438);
        HashSet<String> hashSet = new HashSet<>();
        JkU = hashSet;
        hashSet.add("title");
        JkU.add("webpageTitle");
        JkU.add("srcUsername");
        JkU.add("srcDisplayname");
        JkU.add("mode");
        JkU.add("KTemplateId");
        JkU.add("KPublisherId");
        AppMethodBeat.o(80438);
    }
}
