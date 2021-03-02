package com.tencent.mm.plugin.card.compat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.plugin.card.compat.a.a;
import com.tencent.mm.plugin.card.compat.a.b;

public final class PluginCardCompat extends f implements b {
    @Override // com.tencent.mm.kernel.b.f
    public final void installed() {
        AppMethodBeat.i(22757);
        super.installed();
        alias(b.class);
        AppMethodBeat.o(22757);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
        AppMethodBeat.i(22758);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.a(a.class, new e(new a()));
        }
        AppMethodBeat.o(22758);
    }
}
