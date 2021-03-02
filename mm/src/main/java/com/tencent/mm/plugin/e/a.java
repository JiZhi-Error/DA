package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;

public final class a extends com.tencent.mm.kernel.a.c.a {
    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(22632);
        if (!com.tencent.mm.kernel.a.azj()) {
            com.tencent.mm.kernel.g.aAf().hpQ = true;
            com.tencent.mm.kernel.g.aAf().initialize();
            com.tencent.mm.kernel.g.aAf().hpQ = false;
        }
        AppMethodBeat.o(22632);
    }
}
