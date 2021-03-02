package com.github.henryye.nativeiv.bitmap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    JPG,
    PNG,
    BMP,
    GIF,
    WEBP,
    CUSTOM,
    UNKNOWN;

    public static c valueOf(String str) {
        AppMethodBeat.i(127364);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(127364);
        return cVar;
    }

    static {
        AppMethodBeat.i(127365);
        AppMethodBeat.o(127365);
    }
}
