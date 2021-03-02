package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import org.json.JSONObject;

public final class bx {
    public static bx iFz = new bx();
    private SharedPreferences iFA = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_register_history", 0);

    static {
        AppMethodBeat.i(132261);
        AppMethodBeat.o(132261);
    }

    private bx() {
        AppMethodBeat.i(132258);
        AppMethodBeat.o(132258);
    }

    public final void h(String str, Map<String, String> map) {
        JSONObject jSONObject;
        AppMethodBeat.i(132259);
        try {
            if (map.isEmpty()) {
                Log.i("MicroMsg.RegisterAccountInfo", "kv map is null or empty!");
                AppMethodBeat.o(132259);
                return;
            }
            if (this.iFA.contains(str)) {
                String string = this.iFA.getString(str, "");
                if (!Util.isNullOrNil(string)) {
                    jSONObject = new JSONObject(new String(Base64.decode(string, 0)));
                } else {
                    jSONObject = new JSONObject();
                }
            } else {
                jSONObject = new JSONObject();
            }
            for (String str2 : map.keySet()) {
                jSONObject.put(str2, map.get(str2));
            }
            Log.i("MicroMsg.RegisterAccountInfo", "put json str %s", jSONObject.toString());
            this.iFA.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            AppMethodBeat.o(132259);
        } catch (Exception e2) {
            Log.e("MicroMsg.RegisterAccountInfo", "save account info about %s failed, error: %s", str, e2.getMessage());
            AppMethodBeat.o(132259);
        }
    }

    public final String getString(String str, String str2) {
        AppMethodBeat.i(132260);
        try {
            Log.i("MicroMsg.RegisterAccountInfo", "get %s, %s", str, str2);
            if (this.iFA.contains(str)) {
                String str3 = new String(Base64.decode(this.iFA.getString(str, ""), 0));
                if (!Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.RegisterAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        String string = jSONObject.getString(str2);
                        AppMethodBeat.o(132260);
                        return string;
                    }
                }
            } else {
                Log.w("MicroMsg.RegisterAccountInfo", "register info about %s is not found!", str);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.RegisterAccountInfo", "get register info %s about %s failed, error: %s", str2, str, e2.getMessage());
        }
        AppMethodBeat.o(132260);
        return "";
    }
}
