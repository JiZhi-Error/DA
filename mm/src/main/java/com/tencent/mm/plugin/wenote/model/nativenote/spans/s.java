package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum s {
    EXACT,
    SPAN_FLAGS;

    public static s valueOf(String str) {
        AppMethodBeat.i(30665);
        s sVar = (s) Enum.valueOf(s.class, str);
        AppMethodBeat.o(30665);
        return sVar;
    }

    static {
        AppMethodBeat.i(30666);
        AppMethodBeat.o(30666);
    }
}
