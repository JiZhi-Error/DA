package com.tencent.mm.cm.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum j {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    public static j valueOf(String str) {
        AppMethodBeat.i(190271);
        j jVar = (j) Enum.valueOf(j.class, str);
        AppMethodBeat.o(190271);
        return jVar;
    }

    static {
        AppMethodBeat.i(190272);
        AppMethodBeat.o(190272);
    }
}
