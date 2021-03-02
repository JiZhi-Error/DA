package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.protocal.protobuf.bcl;

public final class b implements j {
    public bcl jld = new bcl();

    public b() {
        AppMethodBeat.i(192722);
        AppMethodBeat.o(192722);
    }

    @Override // com.tencent.mm.modelsns.j
    public final String bfF() {
        AppMethodBeat.i(192723);
        String bf = l.bf(((aj) g.ah(aj.class)).getFinderSwitchApi().dCw(), l.b(this.jld));
        AppMethodBeat.o(192723);
        return bf;
    }
}
