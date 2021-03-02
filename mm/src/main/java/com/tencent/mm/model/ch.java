package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class ch {
    public static ch iFO = new ch();
    private SharedPreferences iFA = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_account_history", 0);
    private SharedPreferences iFP = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath() + "_account_switch", 0);

    static {
        AppMethodBeat.i(132273);
        AppMethodBeat.o(132273);
    }

    private ch() {
        AppMethodBeat.i(132262);
        AppMethodBeat.o(132262);
    }

    public final void l(String str, String str2, String str3) {
        JSONObject jSONObject;
        AppMethodBeat.i(132263);
        try {
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
            if (!Util.isNullOrNil(str2, str3)) {
                jSONObject.put(str2, str3);
                Log.i("MicroMsg.SwitchAccountInfo", "put key %s, jsonStr %s", str2, jSONObject.toString());
                this.iFA.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
            }
            AppMethodBeat.o(132263);
        } catch (Exception e2) {
            Log.e("MicroMsg.SwitchAccountInfo", "save account info %s about %s failed, error: %s", str2, str, e2.getMessage());
            AppMethodBeat.o(132263);
        }
    }

    public final void h(String str, Map<String, String> map) {
        JSONObject jSONObject;
        AppMethodBeat.i(132264);
        if (map != null) {
            try {
                if (!map.isEmpty()) {
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
                    Log.i("MicroMsg.SwitchAccountInfo", "put json str %s", jSONObject.toString());
                    this.iFA.edit().putString(str, Base64.encodeToString(jSONObject.toString().getBytes(), 0)).commit();
                    AppMethodBeat.o(132264);
                    return;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.SwitchAccountInfo", "save account info about %s failed, error: %s", str, e2.getMessage());
                AppMethodBeat.o(132264);
                return;
            }
        }
        Log.i("MicroMsg.SwitchAccountInfo", "kv map is null or empty!");
        AppMethodBeat.o(132264);
    }

    public final String getString(String str, String str2) {
        AppMethodBeat.i(132265);
        try {
            Log.i("MicroMsg.SwitchAccountInfo", "get %s, %s", str, str2);
            if (this.iFA.contains(str)) {
                String str3 = new String(Base64.decode(this.iFA.getString(str, ""), 0));
                if (!Util.isNullOrNil(str3)) {
                    Log.i("MicroMsg.SwitchAccountInfo", "get json str %s", str3);
                    JSONObject jSONObject = new JSONObject(str3);
                    if (jSONObject.has(str2)) {
                        String string = jSONObject.getString(str2);
                        AppMethodBeat.o(132265);
                        return string;
                    }
                }
            } else {
                Log.w("MicroMsg.SwitchAccountInfo", "account info about %s is not found!", str);
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.SwitchAccountInfo", "get account info %s about %s failed, error: %s", str2, str, e2.getMessage());
        }
        AppMethodBeat.o(132265);
        return "";
    }

    public final void KH(String str) {
        Set<String> stringSet;
        AppMethodBeat.i(132266);
        if (KI(str) && (stringSet = this.iFP.getStringSet("first_switch_group", null)) != null) {
            stringSet.remove(str);
            SharedPreferences.Editor edit = this.iFP.edit();
            edit.remove("first_switch_group").apply();
            edit.putStringSet("first_switch_group", stringSet).commit();
        }
        if (KJ(str)) {
            KK(str);
        }
        AppMethodBeat.o(132266);
    }

    public final void aR(String str, String str2) {
        HashSet hashSet;
        AppMethodBeat.i(132267);
        if (Util.isNullOrNil(str, str2) || str.equals(str2)) {
            AppMethodBeat.o(132267);
            return;
        }
        Set<String> stringSet = this.iFP.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            hashSet = new HashSet();
        } else {
            hashSet = stringSet;
        }
        if (!hashSet.contains(str) || hashSet.size() >= 2) {
            for (String str3 : hashSet) {
                KK(str3);
            }
            hashSet.clear();
            hashSet.add(str);
            hashSet.add(str2);
        } else {
            hashSet.add(str2);
        }
        SharedPreferences.Editor edit = this.iFP.edit();
        edit.remove("first_switch_group").apply();
        edit.putStringSet("first_switch_group", hashSet).commit();
        AppMethodBeat.o(132267);
    }

    public final boolean KI(String str) {
        AppMethodBeat.i(132268);
        Set<String> stringSet = this.iFP.getStringSet("first_switch_group", null);
        if (stringSet == null) {
            AppMethodBeat.o(132268);
            return false;
        }
        boolean contains = stringSet.contains(str);
        AppMethodBeat.o(132268);
        return contains;
    }

    public final boolean KJ(String str) {
        AppMethodBeat.i(132269);
        boolean contains = this.iFA.contains(str);
        AppMethodBeat.o(132269);
        return contains;
    }

    private void KK(String str) {
        AppMethodBeat.i(132270);
        if (this.iFA.contains(str)) {
            try {
                s.deleteFile(getString(str, "last_avatar_path"));
            } catch (Exception e2) {
                Log.w("MicroMsg.SwitchAccountInfo", "remove avatar file error %s", e2.getMessage());
            }
            this.iFA.edit().remove(str).commit();
        }
        AppMethodBeat.o(132270);
    }

    public final Set<String> aWo() {
        AppMethodBeat.i(132271);
        HashSet hashSet = new HashSet();
        Set<String> stringSet = this.iFP.getStringSet("first_switch_group", null);
        if (stringSet != null && !stringSet.isEmpty()) {
            hashSet.addAll(stringSet);
        }
        AppMethodBeat.o(132271);
        return hashSet;
    }

    public final String aWp() {
        AppMethodBeat.i(132272);
        Set<String> aWo = aWo();
        StringBuilder sb = new StringBuilder();
        for (String str : aWo) {
            sb.append(str);
            sb.append(';');
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        Log.i("MicroMsg.SwitchAccountInfo", "switch users %s", sb.toString());
        String sb2 = sb.toString();
        AppMethodBeat.o(132272);
        return sb2;
    }
}
