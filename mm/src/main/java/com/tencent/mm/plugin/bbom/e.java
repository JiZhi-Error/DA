package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.account.a;
import com.tencent.mm.plugin.fts.a.n;

public final class e extends y implements b {
    public e() {
        super(a.class);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public final void parallelsDependency() {
        AppMethodBeat.i(22354);
        com.tencent.mm.kernel.a.b.a.a(this, c.class).bI(g.ah(n.class));
        AppMethodBeat.o(22354);
    }
}
