package com.tencent.luggage.bridge.impl;

import com.tencent.luggage.bridge.a.a;
import com.tencent.luggage.bridge.impl.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.g;

public class a implements a.b {
    final com.tencent.mm.plugin.appbrand.f.a csX = new b();

    public a() {
        AppMethodBeat.i(140359);
        AppMethodBeat.o(140359);
    }

    @Override // com.tencent.luggage.bridge.a.a.b
    public void a(a.c cVar) {
        AppMethodBeat.i(140360);
        g.setContext(MMApplicationContext.getContext());
        cVar.a(com.tencent.mm.plugin.appbrand.f.a.class, this.csX);
        AppMethodBeat.o(140360);
    }

    @Override // com.tencent.luggage.bridge.a.a.b
    public void a(a.AbstractC0164a aVar) {
        AppMethodBeat.i(140361);
        aVar.a(com.tencent.mm.plugin.appbrand.f.a.class, this.csX);
        AppMethodBeat.o(140361);
    }
}
