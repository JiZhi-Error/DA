package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum i {
    INSTANCE;

    public static i valueOf(String str) {
        AppMethodBeat.i(28143);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(28143);
        return iVar;
    }

    static {
        AppMethodBeat.i(28144);
        AppMethodBeat.o(28144);
    }
}
