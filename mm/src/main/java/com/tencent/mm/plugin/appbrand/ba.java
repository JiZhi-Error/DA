package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.vending.e.a;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ba implements p {
    final Set<a> kFT = new CopyOnWriteArraySet();

    public ba() {
        AppMethodBeat.i(176540);
        AppMethodBeat.o(176540);
    }

    @Override // com.tencent.mm.vending.e.b
    public final void keep(a aVar) {
        AppMethodBeat.i(176541);
        if (aVar != null) {
            this.kFT.add(aVar);
        }
        AppMethodBeat.o(176541);
    }

    @Override // com.tencent.mm.plugin.appbrand.utils.p
    public final void a(a aVar) {
        AppMethodBeat.i(176542);
        if (aVar != null) {
            this.kFT.remove(aVar);
        }
        AppMethodBeat.o(176542);
    }
}
