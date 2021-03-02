package com.tencent.liteav.basic.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum k {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    public static k valueOf(String str) {
        AppMethodBeat.i(222296);
        k kVar = (k) Enum.valueOf(k.class, str);
        AppMethodBeat.o(222296);
        return kVar;
    }

    static {
        AppMethodBeat.i(222297);
        AppMethodBeat.o(222297);
    }
}
