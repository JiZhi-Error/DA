package com.tencent.mm.plugin.appbrand.report.quality;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j {
    CreateOnRuntimeInit,
    PreloadOnProcessCreated,
    PreloadBeforeRuntimeInit;

    public static j valueOf(String str) {
        AppMethodBeat.i(48223);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(48223);
        return jVar;
    }

    static {
        AppMethodBeat.i(48224);
        AppMethodBeat.o(48224);
    }
}
