package com.tencent.mm.plugin.flash.d;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static boolean a(HashMap<String, Object> hashMap, String str, int i2) {
        AppMethodBeat.i(186692);
        if (!hashMap.containsKey(str) || ((Integer) hashMap.get(str)).intValue() != i2) {
            AppMethodBeat.o(186692);
            return false;
        }
        AppMethodBeat.o(186692);
        return true;
    }

    public static JSONObject al(Bundle bundle) {
        AppMethodBeat.i(186693);
        JSONObject jSONObject = new JSONObject();
        for (String str : bundle.keySet()) {
            try {
                jSONObject.put(str, bundle.get(str));
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(186693);
        return jSONObject;
    }

    public static Bundle aP(JSONObject jSONObject) {
        AppMethodBeat.i(186694);
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            Object opt = jSONObject.opt(obj);
            if (opt instanceof Integer) {
                bundle.putInt(obj, ((Integer) opt).intValue());
            } else if (opt instanceof String) {
                bundle.putString(obj, (String) opt);
            } else if (opt instanceof Long) {
                bundle.putLong(obj, ((Long) opt).longValue());
            }
        }
        AppMethodBeat.o(186694);
        return bundle;
    }

    public static String aH(Context context, String str) {
        AppMethodBeat.i(186695);
        String string = context.getResources().getString(context.getResources().getIdentifier(str, "string", MMApplicationContext.getPackageName()));
        AppMethodBeat.o(186695);
        return string;
    }

    public static void a(Context context, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(186697);
        try {
            if (hashMap.containsKey("message")) {
                JSONObject jSONObject = new JSONObject(String.valueOf(hashMap.get("message")));
                String string = jSONObject.getString("errormsg");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("errormsg", aH(context, string));
                    hashMap.put("message", jSONObject.toString());
                }
            }
            AppMethodBeat.o(186697);
        } catch (Exception e2) {
            AppMethodBeat.o(186697);
        }
    }
}
