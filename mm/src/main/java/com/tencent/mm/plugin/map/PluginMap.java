package com.tencent.mm.plugin.map;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.location.model.n;
import com.tencent.mm.plugin.map.a.a;

public class PluginMap extends f implements a {
    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.b.f
    public String name() {
        return "plugin-map";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(56241);
        alias(a.class);
        AppMethodBeat.o(56241);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(g gVar) {
        AppMethodBeat.i(56242);
        if (gVar.aBb()) {
            pin(new y(n.class));
        }
        AppMethodBeat.o(56242);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(56243);
        if (gVar.aBb()) {
            b.bfQ(FirebaseAnalytics.b.LOCATION);
        }
        AppMethodBeat.o(56243);
    }
}
