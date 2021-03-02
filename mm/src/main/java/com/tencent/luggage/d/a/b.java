package com.tencent.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum b {
    PENDING,
    PASS,
    REJECT;

    public static b valueOf(String str) {
        AppMethodBeat.i(140464);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(140464);
        return bVar;
    }

    static {
        AppMethodBeat.i(140465);
        AppMethodBeat.o(140465);
    }
}
