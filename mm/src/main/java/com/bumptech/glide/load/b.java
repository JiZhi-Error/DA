package com.bumptech.glide.load;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    PREFER_ARGB_8888,
    PREFER_RGB_565;
    
    public static final b aEO = PREFER_ARGB_8888;

    public static b valueOf(String str) {
        AppMethodBeat.i(76837);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(76837);
        return bVar;
    }

    static {
        AppMethodBeat.i(76838);
        AppMethodBeat.o(76838);
    }
}
