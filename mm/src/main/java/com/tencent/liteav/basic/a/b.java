package com.tencent.liteav.basic.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    UNKNOWN,
    I420,
    TEXTURE_2D,
    TEXTURE_EXTERNAL_OES,
    NV21;

    public static b valueOf(String str) {
        AppMethodBeat.i(222184);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(222184);
        return bVar;
    }

    static {
        AppMethodBeat.i(222185);
        AppMethodBeat.o(222185);
    }
}
