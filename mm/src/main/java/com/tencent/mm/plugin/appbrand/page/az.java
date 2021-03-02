package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum az {
    MODAL,
    ACTION_SHEET,
    TOAST;

    public static az valueOf(String str) {
        AppMethodBeat.i(135278);
        az azVar = (az) Enum.valueOf(az.class, str);
        AppMethodBeat.o(135278);
        return azVar;
    }

    static {
        AppMethodBeat.i(135279);
        AppMethodBeat.o(135279);
    }
}
