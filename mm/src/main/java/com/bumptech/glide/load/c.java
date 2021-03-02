package com.bumptech.glide.load;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c {
    SOURCE,
    TRANSFORMED,
    NONE;

    public static c valueOf(String str) {
        AppMethodBeat.i(76840);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(76840);
        return cVar;
    }

    static {
        AppMethodBeat.i(76841);
        AppMethodBeat.o(76841);
    }
}
