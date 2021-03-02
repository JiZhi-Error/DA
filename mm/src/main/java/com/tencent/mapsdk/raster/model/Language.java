package com.tencent.mapsdk.raster.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Language {
    zh,
    en;

    public static Language valueOf(String str) {
        AppMethodBeat.i(87532);
        Language language = (Language) Enum.valueOf(Language.class, str);
        AppMethodBeat.o(87532);
        return language;
    }

    static {
        AppMethodBeat.i(87533);
        AppMethodBeat.o(87533);
    }
}
