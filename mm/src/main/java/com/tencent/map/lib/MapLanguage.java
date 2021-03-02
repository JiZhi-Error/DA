package com.tencent.map.lib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.ILanguage;

public enum MapLanguage implements ILanguage {
    LAN_CHINESE,
    LAN_ENGLISH;

    public static MapLanguage valueOf(String str) {
        AppMethodBeat.i(83342);
        MapLanguage mapLanguage = (MapLanguage) Enum.valueOf(MapLanguage.class, str);
        AppMethodBeat.o(83342);
        return mapLanguage;
    }

    static {
        AppMethodBeat.i(83343);
        AppMethodBeat.o(83343);
    }
}
