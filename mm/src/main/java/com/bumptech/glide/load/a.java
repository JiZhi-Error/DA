package com.bumptech.glide.load;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum a {
    LOCAL,
    REMOTE,
    DATA_DISK_CACHE,
    RESOURCE_DISK_CACHE,
    MEMORY_CACHE;

    public static a valueOf(String str) {
        AppMethodBeat.i(76834);
        a aVar = (a) Enum.valueOf(a.class, str);
        AppMethodBeat.o(76834);
        return aVar;
    }

    static {
        AppMethodBeat.i(76835);
        AppMethodBeat.o(76835);
    }
}
