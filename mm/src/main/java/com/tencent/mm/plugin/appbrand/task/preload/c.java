package com.tencent.mm.plugin.appbrand.task.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    LOW_LEVEL,
    MIDDLE_LEVEL,
    HIGH_LEVEL;

    public static c valueOf(String str) {
        AppMethodBeat.i(48504);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(48504);
        return cVar;
    }

    static {
        AppMethodBeat.i(48505);
        AppMethodBeat.o(48505);
    }
}
