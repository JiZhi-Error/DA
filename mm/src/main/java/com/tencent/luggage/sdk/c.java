package com.tencent.luggage.sdk;

import com.tencent.luggage.bridge.a.a;
import com.tencent.luggage.bridge.impl.a;
import com.tencent.luggage.sdk.customize.impl.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.e;
import com.tencent.mm.plugin.appbrand.ui.ah;

public class c extends a {
    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.bridge.a.a.b
    public void a(a.c cVar) {
        AppMethodBeat.i(139817);
        super.a(cVar);
        cVar.a(ah.class, new com.tencent.luggage.sdk.customize.impl.a());
        cVar.a(p.a.class, new b());
        cVar.a(com.tencent.luggage.c.a.a.class, new com.tencent.luggage.c.a.a.a());
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.ad.a.c.class, new e());
        cVar.a(com.tencent.mm.plugin.appbrand.jsapi.ad.b.class, new com.tencent.mm.plugin.appbrand.jsapi.ad.a());
        AppMethodBeat.o(139817);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.bridge.a.a.b
    public void a(a.AbstractC0164a aVar) {
        AppMethodBeat.i(139818);
        super.a(aVar);
        AppMethodBeat.o(139818);
    }
}
