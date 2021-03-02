package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static <K, V> K getKeyFromMap(Map<K, V> map, K k) {
        AppMethodBeat.i(5272);
        if (map.containsKey(k)) {
            for (K k2 : map.keySet()) {
                if (k2.equals(k)) {
                    AppMethodBeat.o(5272);
                    return k2;
                }
            }
        }
        AppMethodBeat.o(5272);
        return null;
    }

    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        boolean z;
        AppMethodBeat.i(5271);
        sb.append("{");
        boolean z2 = true;
        for (String str : hashMap.keySet()) {
            if (!z2) {
                sb.append(",");
                z = z2;
            } else {
                z = false;
            }
            String str2 = hashMap.get(str);
            sb.append("\"").append(str).append("\":");
            if (str2 == null) {
                sb.append(BuildConfig.COMMAND);
                z2 = z;
            } else {
                sb.append("\"").append(str2).append("\"");
                z2 = z;
            }
        }
        sb.append("}");
        AppMethodBeat.o(5271);
    }
}
