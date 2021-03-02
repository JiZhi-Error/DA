package com.tencent.mm.plugin.appbrand.dynamic.e;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.appbrand.v8.x;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private static boolean loA;

    public static d cC(Object obj) {
        AppMethodBeat.i(121387);
        a aVar = new a(obj);
        AppMethodBeat.o(121387);
        return aVar;
    }

    static {
        AppMethodBeat.i(121388);
        if (!loA) {
            String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_v8_init_flag, "");
            Log.i("MicroMsg.Widget.AppBrandV8JsEngineImpl", "set v8 flag:%s", a2);
            V8.setFlags(a2);
            loA = true;
            x.a(new x.a() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.e.b.AnonymousClass1 */

                @Override // com.tencent.mm.appbrand.v8.x.a
                public final void gz(String str) {
                    AppMethodBeat.i(121386);
                    h.INSTANCE.kvStat(17693, str);
                    AppMethodBeat.o(121386);
                }
            });
        }
        loA = false;
        AppMethodBeat.o(121388);
    }
}
