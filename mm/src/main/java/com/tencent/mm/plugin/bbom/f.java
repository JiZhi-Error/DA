package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.fts.a.n;

public final class f extends y implements b {
    public f() {
        super(com.tencent.mm.br.b.bfR("search"));
        AppMethodBeat.i(22355);
        AppMethodBeat.o(22355);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
        AppMethodBeat.i(22356);
        a.a(this, c.class).bI(g.ah(n.class));
        AppMethodBeat.o(22356);
    }
}
