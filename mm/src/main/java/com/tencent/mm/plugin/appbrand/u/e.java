package com.tencent.mm.plugin.appbrand.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class e {
    private final Map<Integer, com.tencent.mm.plugin.appbrand.u.a.e> nka = new HashMap();

    public e() {
        AppMethodBeat.i(147379);
        AppMethodBeat.o(147379);
    }

    /* access modifiers changed from: package-private */
    public final com.tencent.mm.plugin.appbrand.u.a.e yG(int i2) {
        AppMethodBeat.i(147380);
        com.tencent.mm.plugin.appbrand.u.a.e eVar = this.nka.get(Integer.valueOf(i2));
        AppMethodBeat.o(147380);
        return eVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(com.tencent.mm.plugin.appbrand.u.a.e eVar) {
        AppMethodBeat.i(147381);
        this.nka.put(Integer.valueOf(eVar.getType()), eVar);
        AppMethodBeat.o(147381);
    }
}
