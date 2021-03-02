package com.bumptech.glide;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum g {
    IMMEDIATE,
    HIGH,
    NORMAL,
    LOW;

    public static g valueOf(String str) {
        AppMethodBeat.i(76788);
        g gVar = (g) Enum.valueOf(g.class, str);
        AppMethodBeat.o(76788);
        return gVar;
    }

    static {
        AppMethodBeat.i(76789);
        AppMethodBeat.o(76789);
    }
}
