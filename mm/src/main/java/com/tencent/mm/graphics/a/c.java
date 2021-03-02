package com.tencent.mm.graphics.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    Normal,
    Tile,
    Auto;

    public static c valueOf(String str) {
        AppMethodBeat.i(136192);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(136192);
        return cVar;
    }

    static {
        AppMethodBeat.i(136193);
        AppMethodBeat.o(136193);
    }
}
