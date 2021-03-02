package com.tencent.luggage.bridge;

import com.tencent.matrix.trace.core.AppMethodBeat;

enum b {
    NONE,
    READY,
    INVOKE,
    CALLBACK,
    EVENT,
    SUBSCRIBE,
    UNSUBSCRIBE;

    public static b valueOf(String str) {
        AppMethodBeat.i(140313);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(140313);
        return bVar;
    }

    static {
        AppMethodBeat.i(140314);
        AppMethodBeat.o(140314);
    }
}
