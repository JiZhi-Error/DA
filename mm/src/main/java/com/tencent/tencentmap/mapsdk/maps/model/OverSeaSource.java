package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OverSeaSource {
    DEFAULT,
    SPARE;

    public static OverSeaSource valueOf(String str) {
        AppMethodBeat.i(193613);
        OverSeaSource overSeaSource = (OverSeaSource) Enum.valueOf(OverSeaSource.class, str);
        AppMethodBeat.o(193613);
        return overSeaSource;
    }

    static {
        AppMethodBeat.i(193614);
        AppMethodBeat.o(193614);
    }
}
