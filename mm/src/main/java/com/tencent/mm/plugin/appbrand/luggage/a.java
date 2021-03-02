package com.tencent.mm.plugin.appbrand.luggage;

import com.tencent.luggage.bridge.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.luggage.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends com.tencent.luggage.bridge.impl.a {
    private static e lmN = new c();

    static {
        AppMethodBeat.i(47471);
        AppMethodBeat.o(47471);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.bridge.a.a.b
    public final void a(a.c cVar) {
        AppMethodBeat.i(47469);
        Log.i("MicroMsg.LuggageInitDelegateWxImpl", "onInitialize %s", MMApplicationContext.getProcessName());
        super.a(cVar);
        cVar.a(e.class, lmN);
        AppMethodBeat.o(47469);
    }

    @Override // com.tencent.luggage.bridge.impl.a, com.tencent.luggage.bridge.a.a.b
    public final void a(a.AbstractC0164a aVar) {
        AppMethodBeat.i(47470);
        Log.i("MicroMsg.LuggageInitDelegateWxImpl", "onInitComponent %s", MMApplicationContext.getProcessName());
        super.a(aVar);
        AppMethodBeat.o(47470);
    }
}
