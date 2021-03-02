package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.g.d;
import com.tencent.mm.audio.mix.h.c;

public final class f {
    public static l a(d dVar, c cVar, boolean z) {
        l eVar;
        AppMethodBeat.i(136821);
        if (cVar.ZU().dtU) {
            eVar = new d(dVar, cVar);
        } else {
            eVar = new e(dVar, cVar);
        }
        eVar.init();
        if (z) {
            eVar.YU();
        }
        AppMethodBeat.o(136821);
        return eVar;
    }
}
