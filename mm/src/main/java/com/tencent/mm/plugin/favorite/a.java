package com.tencent.mm.plugin.favorite;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fts.a.n;

public final class a extends y implements b {
    public a() {
        super(com.tencent.mm.br.b.bfR("favorite"));
        AppMethodBeat.i(24569);
        AppMethodBeat.o(24569);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
        AppMethodBeat.i(24570);
        com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(n.class));
        com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(af.class));
        AppMethodBeat.o(24570);
    }
}
