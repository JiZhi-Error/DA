package org.b.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public final class b {
    public static <K, V> String M(Map<K, V> map) {
        AppMethodBeat.i(40574);
        if (map == null) {
            AppMethodBeat.o(40574);
            return "";
        } else if (map.isEmpty()) {
            AppMethodBeat.o(40574);
            return "{}";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<K, V> entry : map.entrySet()) {
                sb.append(String.format(", %s -> %s ", entry.getKey().toString(), entry.getValue().toString()));
            }
            String str = "{" + sb.substring(1) + "}";
            AppMethodBeat.o(40574);
            return str;
        }
    }
}
