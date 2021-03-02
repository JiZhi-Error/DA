package com.google.b.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum l {
    FORCE_NONE,
    FORCE_SQUARE,
    FORCE_RECTANGLE;

    public static l valueOf(String str) {
        AppMethodBeat.i(12212);
        l lVar = (l) Enum.valueOf(l.class, str);
        AppMethodBeat.o(12212);
        return lVar;
    }

    static {
        AppMethodBeat.i(12213);
        AppMethodBeat.o(12213);
    }
}
