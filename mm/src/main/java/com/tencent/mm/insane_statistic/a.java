package com.tencent.mm.insane_statistic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.l;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelstat.r;
import com.tencent.mm.storage.ca;

public final class a implements r.a {
    @Override // com.tencent.mm.modelstat.r.a
    public final void s(ca caVar) {
        AppMethodBeat.i(20219);
        if (caVar.dOQ()) {
            b.jmd.b(caVar, l.t(caVar));
            AppMethodBeat.o(20219);
            return;
        }
        b.jmd.s(caVar);
        AppMethodBeat.o(20219);
    }
}
