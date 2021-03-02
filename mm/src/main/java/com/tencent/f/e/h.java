package com.tencent.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

public final class h {
    private static ConcurrentHashMap<String, g> cCB = new ConcurrentHashMap<>();

    static {
        AppMethodBeat.i(183313);
        AppMethodBeat.o(183313);
    }

    public static void release() {
        AppMethodBeat.i(183312);
        for (g gVar : cCB.values()) {
            gVar.onShutdown();
        }
        AppMethodBeat.o(183312);
    }
}
