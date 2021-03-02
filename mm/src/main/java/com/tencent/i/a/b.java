package com.tencent.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    DATA_USAGE_TYPE_IDENTIFY,
    DATA_USAGE_TYPE_TRAIN,
    DATA_USAGE_TYPE_IDENTIFY_TRAIN;

    public static b valueOf(String str) {
        AppMethodBeat.i(214664);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(214664);
        return bVar;
    }

    static {
        AppMethodBeat.i(214665);
        AppMethodBeat.o(214665);
    }
}
