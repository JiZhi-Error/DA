package com.tencent.mm.plugin.appbrand.ae.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.b.a;
import com.tencent.mm.plugin.appbrand.ae.e.b;

public class c extends b {
    @Override // com.tencent.mm.plugin.appbrand.ae.b.a, com.tencent.mm.plugin.appbrand.ae.b.b
    public final a.b c(com.tencent.mm.plugin.appbrand.ae.e.a aVar) {
        AppMethodBeat.i(156644);
        if (g(aVar) == 13) {
            a.b bVar = a.b.MATCHED;
            AppMethodBeat.o(156644);
            return bVar;
        }
        a.b bVar2 = a.b.NOT_MATCHED;
        AppMethodBeat.o(156644);
        return bVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a, com.tencent.mm.plugin.appbrand.ae.b.b
    public final b a(b bVar) {
        AppMethodBeat.i(156645);
        super.a(bVar);
        bVar.put("Sec-WebSocket-Version", "13");
        AppMethodBeat.o(156645);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.ae.b.a, com.tencent.mm.plugin.appbrand.ae.b.b
    public a bZD() {
        AppMethodBeat.i(156646);
        c cVar = new c();
        AppMethodBeat.o(156646);
        return cVar;
    }
}
