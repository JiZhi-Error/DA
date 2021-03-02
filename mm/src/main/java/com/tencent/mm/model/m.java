package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.g;
import com.tencent.mm.api.c;
import com.tencent.mm.api.p;

public final class m implements p {
    @Override // com.tencent.mm.api.p
    public final boolean a(c cVar) {
        AppMethodBeat.i(123965);
        boolean h2 = ag.bah().h(cVar);
        AppMethodBeat.o(123965);
        return h2;
    }

    @Override // com.tencent.mm.api.p
    public final c fJ(String str) {
        AppMethodBeat.i(123966);
        c fJ = g.fJ(str);
        AppMethodBeat.o(123966);
        return fJ;
    }

    @Override // com.tencent.mm.api.p
    public final void fK(String str) {
        AppMethodBeat.i(123967);
        ag.bah().delete(str);
        AppMethodBeat.o(123967);
    }

    @Override // com.tencent.mm.api.p
    public final boolean b(c cVar) {
        AppMethodBeat.i(123968);
        boolean g2 = ag.bah().g(cVar);
        AppMethodBeat.o(123968);
        return g2;
    }
}
