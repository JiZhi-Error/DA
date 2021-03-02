package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum h {
    DEFAULT,
    DOODLE,
    TEXT,
    EMOJI,
    MOSAIC,
    CROP_PHOTO,
    CROP_VIDEO,
    FILTER;

    public static h valueOf(String str) {
        AppMethodBeat.i(149426);
        h hVar = (h) Enum.valueOf(h.class, str);
        AppMethodBeat.o(149426);
        return hVar;
    }

    static {
        AppMethodBeat.i(149427);
        AppMethodBeat.o(149427);
    }
}
