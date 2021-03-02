package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.m.i;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.service.c;

public class e extends c implements p {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d
    public final i Oo() {
        AppMethodBeat.i(47501);
        com.tencent.mm.plugin.appbrand.m.c cVar = new com.tencent.mm.plugin.appbrand.m.c();
        AppMethodBeat.o(47501);
        return cVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.s, com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.service.c
    public final void MC() {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g
    public final void a(bc bcVar, o oVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.f, com.tencent.mm.plugin.appbrand.jsapi.g, com.tencent.luggage.sdk.b.a.c.d
    public final void i(int i2, String str) {
        AppMethodBeat.i(47502);
        ((l) super.getRuntime()).naC.a(this, i2, str);
        AppMethodBeat.o(47502);
    }

    @Override // com.tencent.luggage.sdk.b.a.c.d, com.tencent.mm.plugin.appbrand.service.c
    public final /* synthetic */ d NP() {
        AppMethodBeat.i(47504);
        l lVar = (l) super.getRuntime();
        AppMethodBeat.o(47504);
        return lVar;
    }
}
