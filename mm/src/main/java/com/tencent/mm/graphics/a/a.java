package com.tencent.mm.graphics.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    Start,
    Stop,
    AutoDetect;

    public static a valueOf(String str) {
        AppMethodBeat.i(136189);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(136189);
        return aVar;
    }

    static {
        AppMethodBeat.i(136190);
        AppMethodBeat.o(136190);
    }
}
