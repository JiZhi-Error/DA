package com.tencent.mm.plugin.appbrand.u.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.e;
import java.util.HashMap;

public final class c extends e {
    private c.a nkr;

    public c(e.a aVar, s sVar) {
        super(aVar, sVar);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final void bPV() {
        AppMethodBeat.i(147411);
        this.nkr = new c.a() {
            /* class com.tencent.mm.plugin.appbrand.u.d.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, b bVar) {
                AppMethodBeat.i(147410);
                HashMap hashMap = new HashMap();
                hashMap.put("state", Integer.valueOf(bVar.ordinal()));
                c.this.aa(hashMap);
                AppMethodBeat.o(147410);
            }
        };
        this.cAJ.getRuntime().kAH.a(this.nkr);
        AppMethodBeat.o(147411);
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final void removeListener() {
        AppMethodBeat.i(147412);
        if (this.nkr == null) {
            AppMethodBeat.o(147412);
        } else if (this.cAJ.getRuntime() == null) {
            AppMethodBeat.o(147412);
        } else {
            com.tencent.mm.plugin.appbrand.a.c cVar = this.cAJ.getRuntime().kAH;
            if (cVar == null) {
                AppMethodBeat.o(147412);
                return;
            }
            cVar.b(this.nkr);
            AppMethodBeat.o(147412);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.e
    public final int getType() {
        return 2;
    }
}
