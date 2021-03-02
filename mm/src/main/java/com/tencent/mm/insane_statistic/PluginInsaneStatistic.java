package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.u;
import com.tencent.mm.insane_statistic.a.a;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.modelstat.r;

public class PluginInsaneStatistic extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(20226);
        if (gVar.aBb()) {
            u.jaE = new b();
            r.jpw = new a();
        }
        AppMethodBeat.o(20226);
    }
}
