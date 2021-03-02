package com.google.b.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    AUTO,
    TEXT,
    BYTE,
    NUMERIC;

    public static c valueOf(String str) {
        AppMethodBeat.i(12296);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(12296);
        return cVar;
    }

    static {
        AppMethodBeat.i(12297);
        AppMethodBeat.o(12297);
    }
}
