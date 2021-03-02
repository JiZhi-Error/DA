package com.tencent.mm.aa.b;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class a extends b<JSONObject, Bundle, JSONObject> implements e {
    public a(String str, int i2) {
        super(str, i2);
    }

    public final JSONObject a(boolean z, String str, Map<String, ? extends Object> map) {
        AppMethodBeat.i(144800);
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(":");
        sb.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            sb.append(":");
            sb.append(Util.nullAsNil(str));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", sb.toString());
        if (map != null) {
            hashMap.putAll(map);
        }
        m(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(144800);
        return jSONObject;
    }

    public final JSONObject a(boolean z, String str, Bundle bundle) {
        Set<String> keySet;
        AppMethodBeat.i(144801);
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(":");
        sb.append(z ? "ok" : "fail");
        if (!TextUtils.isEmpty(str)) {
            sb.append(":");
            sb.append(Util.nullAsNil(str));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", sb.toString());
        if (!(bundle == null || (keySet = bundle.keySet()) == null || keySet.isEmpty())) {
            for (String str2 : keySet) {
                hashMap.put(str2, bundle.get(str2));
            }
        }
        m(hashMap);
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(144801);
        return jSONObject;
    }

    private static void m(Map map) {
        AppMethodBeat.i(144802);
        for (Map.Entry entry : map.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if ((key instanceof String) && (value instanceof Map)) {
                m((Map) value);
                map.put(key, new JSONObject((Map) value));
            }
        }
        AppMethodBeat.o(144802);
    }
}
