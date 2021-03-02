package com.tencent.mm.hellhoundlib.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c {
    private static ThreadLocal<a> hlN = new ThreadLocal<>();

    static {
        AppMethodBeat.i(183796);
        AppMethodBeat.o(183796);
    }

    public static a a(int i2, a aVar) {
        AppMethodBeat.i(183795);
        aVar.bl(Integer.valueOf(i2));
        AppMethodBeat.o(183795);
        return aVar;
    }
}
