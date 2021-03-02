package com.tencent.luggage.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a implements c {
    private static Map<Class<? extends b>, b> csd = new ConcurrentHashMap();
    private static Map<Class<? extends d>, d> cse = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(140304);
        AppMethodBeat.o(140304);
    }

    @Override // com.tencent.luggage.a.c
    public final String getName() {
        return "luggage-core";
    }

    @Override // com.tencent.luggage.a.c
    public final Map<Class<? extends b>, b> KU() {
        return csd;
    }

    @Override // com.tencent.luggage.a.c
    public final Map<Class<? extends d>, d> KV() {
        return cse;
    }
}
