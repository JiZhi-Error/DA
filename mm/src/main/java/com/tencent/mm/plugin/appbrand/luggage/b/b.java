package com.tencent.mm.plugin.appbrand.luggage.b;

import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.config.e;

@Deprecated
public final class b implements a {
    @Override // com.tencent.luggage.sdk.customize.a
    public final d NK() {
        AppMethodBeat.i(47479);
        d NK = n.NK();
        AppMethodBeat.o(47479);
        return NK;
    }

    @Override // com.tencent.luggage.sdk.customize.a
    public final h dD(String str) {
        AppMethodBeat.i(47480);
        h.a aVar = h.kSl;
        h AY = h.a.AY(new p(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.af(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).Wp(str)).longValue());
        AppMethodBeat.o(47480);
        return AY;
    }

    @Override // com.tencent.luggage.sdk.customize.a
    public final e NL() {
        AppMethodBeat.i(47481);
        e NL = n.NL();
        AppMethodBeat.o(47481);
        return NL;
    }

    @Override // com.tencent.luggage.sdk.customize.a
    public final void NM() {
        AppMethodBeat.i(47482);
        com.tencent.mm.plugin.appbrand.config.g.bzQ();
        AppMethodBeat.o(47482);
    }
}
