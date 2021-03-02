package com.tencent.mm.pluginsdk.j.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Map;

public enum b {
    ;

    public static b valueOf(String str) {
        AppMethodBeat.i(152091);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(152091);
        return bVar;
    }

    public static String bR(Map<String, List<String>> map) {
        AppMethodBeat.i(152092);
        if (map == null) {
            AppMethodBeat.o(152092);
            return BuildConfig.COMMAND;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            sb.append(Util.nullAs(entry.getKey(), BuildConfig.COMMAND));
            sb.append(" : ");
            List<String> value = entry.getValue();
            if (value != null && value.size() > 0) {
                for (String str : value) {
                    sb.append(Util.nullAsNil(str)).append("|");
                }
            }
            sb.append("\n");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(152092);
        return sb2;
    }
}
