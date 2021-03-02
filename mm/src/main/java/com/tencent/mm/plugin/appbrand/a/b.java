package com.tencent.mm.plugin.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    kQH,
    BACKGROUND,
    SUSPEND,
    DESTROYED;

    public static b valueOf(String str) {
        AppMethodBeat.i(140584);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(140584);
        return bVar;
    }

    static {
        AppMethodBeat.i(140585);
        AppMethodBeat.o(140585);
    }
}
