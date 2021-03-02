package com.tencent.mmkv;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    OnErrorDiscard,
    OnErrorRecover;

    public static c valueOf(String str) {
        AppMethodBeat.i(13541);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(13541);
        return cVar;
    }

    static {
        AppMethodBeat.i(13542);
        AppMethodBeat.o(13542);
    }
}
