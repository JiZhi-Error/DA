package com.tencent.luggage.game.d.c;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.z.k;
import java.util.Map;

public final class a extends k<d> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.d] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.k
    public final /* bridge */ /* synthetic */ Map a(d dVar) {
        AppMethodBeat.i(130623);
        Map<String, Object> a2 = a(dVar);
        AppMethodBeat.o(130623);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.z.k, com.tencent.mm.plugin.appbrand.jsapi.z.i
    public final /* bridge */ /* synthetic */ Map a(f fVar) {
        AppMethodBeat.i(130624);
        Map<String, Object> a2 = a((d) fVar);
        AppMethodBeat.o(130624);
        return a2;
    }

    private Map<String, Object> a(d dVar) {
        AppMethodBeat.i(130622);
        Map<String, Object> a2 = super.a((com.tencent.mm.plugin.appbrand.d) dVar);
        int b2 = com.tencent.luggage.game.g.a.b(dVar);
        if (b2 > 0) {
            a2.put("statusBarHeight", Integer.valueOf(b2));
        }
        AppMethodBeat.o(130622);
        return a2;
    }
}
