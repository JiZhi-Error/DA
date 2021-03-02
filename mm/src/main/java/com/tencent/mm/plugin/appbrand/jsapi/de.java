package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.appbrand.s.k;
import java.util.HashMap;
import java.util.Map;

public final class de {
    static final Map<String, c.a> lCO = new HashMap();

    static {
        AppMethodBeat.i(134878);
        AppMethodBeat.o(134878);
    }

    public static void bEv() {
        AppMethodBeat.i(134877);
        e.a(new k.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.de.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.s.k.a
            public final void a(final f fVar, final String str, final e eVar) {
                AppMethodBeat.i(219309);
                AnonymousClass1 r0 = new c.a() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.de.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.appbrand.a.c.a
                    public final void a(String str, b bVar) {
                        AppMethodBeat.i(134874);
                        e.a(fVar, str, bVar, str, eVar);
                        AppMethodBeat.o(134874);
                    }
                };
                de.lCO.put(str, r0);
                ((k) fVar).getRuntime().kAH.a(r0);
                AppMethodBeat.o(219309);
            }

            @Override // com.tencent.mm.plugin.appbrand.s.k.a
            public final void d(f fVar, String str) {
                AppBrandRuntime runtime;
                AppMethodBeat.i(219310);
                c.a aVar = de.lCO.get(str);
                if (!(aVar == null || (runtime = ((k) fVar).getRuntime()) == null)) {
                    runtime.kAH.b(aVar);
                }
                AppMethodBeat.o(219310);
            }
        });
        AppMethodBeat.o(134877);
    }
}
