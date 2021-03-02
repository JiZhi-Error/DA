package com.tencent.map.tools.net;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AdapterType {
    DEFAULT,
    URL,
    Halley;

    public static AdapterType valueOf(String str) {
        AppMethodBeat.i(172907);
        AdapterType adapterType = (AdapterType) Enum.valueOf(AdapterType.class, str);
        AppMethodBeat.o(172907);
        return adapterType;
    }

    static {
        AppMethodBeat.i(172908);
        AppMethodBeat.o(172908);
    }
}
