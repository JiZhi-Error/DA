package com.tencent.mm.graphics.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

enum a {
    Normal,
    Tile;

    public static a valueOf(String str) {
        AppMethodBeat.i(136219);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(136219);
        return aVar;
    }

    static {
        AppMethodBeat.i(136220);
        AppMethodBeat.o(136220);
    }
}
