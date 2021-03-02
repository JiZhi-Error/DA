package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.e.a;
import com.tencent.mm.audio.mix.h.c;
import java.util.concurrent.ConcurrentHashMap;

public final class b extends a {
    @Override // com.tencent.mm.audio.mix.e.a
    public final c b(com.tencent.mm.ai.b bVar) {
        AppMethodBeat.i(198134);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (bVar.iJQ != null) {
            concurrentHashMap.put(bVar.dvn, bVar.iJQ);
        }
        c cVar = new c(new com.tencent.mm.plugin.music.g.a.a(concurrentHashMap), bVar);
        AppMethodBeat.o(198134);
        return cVar;
    }
}
