package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.g.d;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class au implements d.b {
    private final /* synthetic */ b hXF;

    au(b bVar) {
        this.hXF = bVar;
    }

    @Override // com.tencent.mm.vending.g.d.b
    public final /* synthetic */ void bz(Object obj) {
        AppMethodBeat.i(183050);
        p.g(this.hXF.invoke(obj), "invoke(...)");
        AppMethodBeat.o(183050);
    }
}
