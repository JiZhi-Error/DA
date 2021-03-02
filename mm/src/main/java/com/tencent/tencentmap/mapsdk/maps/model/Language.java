package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum Language implements ILanguage {
    zh,
    en;

    public static Language valueOf(String str) {
        AppMethodBeat.i(173143);
        Language language = (Language) Enum.valueOf(Language.class, str);
        AppMethodBeat.o(173143);
        return language;
    }

    static {
        AppMethodBeat.i(173144);
        AppMethodBeat.o(173144);
    }
}
