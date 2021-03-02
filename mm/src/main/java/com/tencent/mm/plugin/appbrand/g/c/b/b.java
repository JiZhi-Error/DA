package com.tencent.mm.plugin.appbrand.g.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b {
    protected Map<String, String> map = new HashMap();

    public b() {
        AppMethodBeat.i(159025);
        AppMethodBeat.o(159025);
    }

    public final String get(String str) {
        AppMethodBeat.i(159026);
        String str2 = this.map.get(str);
        AppMethodBeat.o(159026);
        return str2;
    }

    public final void put(String str, String str2) {
        AppMethodBeat.i(159027);
        this.map.put(str, str2);
        AppMethodBeat.o(159027);
    }

    public final String toString() {
        AppMethodBeat.i(159028);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : this.map.entrySet()) {
            sb.append((Object) entry.getKey());
            sb.append(":");
            sb.append((Object) entry.getValue());
            sb.append("\n");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(159028);
        return sb2;
    }
}
