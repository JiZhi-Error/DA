package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum RestrictBoundsFitMode {
    FIT_WIDTH,
    FIT_HEIGHT;

    public static RestrictBoundsFitMode valueOf(String str) {
        AppMethodBeat.i(173368);
        RestrictBoundsFitMode restrictBoundsFitMode = (RestrictBoundsFitMode) Enum.valueOf(RestrictBoundsFitMode.class, str);
        AppMethodBeat.o(173368);
        return restrictBoundsFitMode;
    }

    static {
        AppMethodBeat.i(173369);
        AppMethodBeat.o(173369);
    }
}
