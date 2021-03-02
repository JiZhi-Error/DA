package com.tencent.luggage.h;

import android.os.PersistableBundle;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public static JSONArray H(List<?> list) {
        AppMethodBeat.i(221202);
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(221202);
            return jSONArray;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            jSONArray.put(list.get(i2));
        }
        AppMethodBeat.o(221202);
        return jSONArray;
    }

    public static void m(Map map) {
        AppMethodBeat.i(221203);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.o(221203);
    }

    public static Boolean aL(Object obj) {
        AppMethodBeat.i(221204);
        if (obj instanceof Boolean) {
            Boolean bool = (Boolean) obj;
            AppMethodBeat.o(221204);
            return bool;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str)) {
                Boolean bool2 = Boolean.TRUE;
                AppMethodBeat.o(221204);
                return bool2;
            } else if ("false".equalsIgnoreCase(str)) {
                Boolean bool3 = Boolean.FALSE;
                AppMethodBeat.o(221204);
                return bool3;
            }
        }
        AppMethodBeat.o(221204);
        return null;
    }

    public static JSONObject a(PersistableBundle persistableBundle) {
        AppMethodBeat.i(221205);
        if (persistableBundle == null) {
            AppMethodBeat.o(221205);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : persistableBundle.keySet()) {
            Object obj = persistableBundle.get(str);
            if (obj instanceof PersistableBundle) {
                jSONObject.put(str, a((PersistableBundle) obj));
            } else {
                jSONObject.put(str, obj);
            }
        }
        AppMethodBeat.o(221205);
        return jSONObject;
    }
}
