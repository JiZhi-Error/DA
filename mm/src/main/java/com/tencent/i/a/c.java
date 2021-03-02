package com.tencent.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    GESTURETYPE_SINGLE,
    GESTURETYPE_MULTI;

    public static c valueOf(String str) {
        AppMethodBeat.i(214667);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(214667);
        return cVar;
    }

    static {
        AppMethodBeat.i(214668);
        AppMethodBeat.o(214668);
    }
}
