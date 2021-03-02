package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.a.a;
import com.tencent.luggage.bridge.impl.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.jsapi.base.g;
import com.tencent.mm.plugin.appbrand.luggage.b.q;

public final class b extends a {
    private final g mZZ = new q();

    public b() {
        AppMethodBeat.i(121605);
        AppMethodBeat.o(121605);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.bridge.a.a.b
    public final void a(a.c cVar) {
        AppMethodBeat.i(121606);
        super.a(cVar);
        cVar.a(g.class, this.mZZ);
        cVar.a(e.class, com.tencent.mm.plugin.appbrand.dynamic.b.b.bBX());
        AppMethodBeat.o(121606);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.bridge.a.a.b
    public final void a(a.AbstractC0164a aVar) {
        AppMethodBeat.i(121607);
        super.a(aVar);
        aVar.a(g.class, this.mZZ);
        AppMethodBeat.o(121607);
    }
}
