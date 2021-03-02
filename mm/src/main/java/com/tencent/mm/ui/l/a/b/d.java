package com.tencent.mm.ui.l.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import java.util.Map;

public enum d {
    INSTANCE;

    public static d valueOf(String str) {
        AppMethodBeat.i(234433);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(234433);
        return dVar;
    }

    static {
        AppMethodBeat.i(234435);
        AppMethodBeat.o(234435);
    }

    public static void a(Map<String, p> map, p pVar) {
        AppMethodBeat.i(234434);
        map.put(pVar.getName(), pVar);
        AppMethodBeat.o(234434);
    }
}
