package com.tencent.mm.plugin.appbrand.u.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.permission.a.a;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.u.a.b;
import com.tencent.mm.plugin.appbrand.u.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class g extends b {
    @Override // com.tencent.mm.plugin.appbrand.u.a.a
    public final int bPT() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.appbrand.u.a.b
    public final void a(i iVar, final c cVar) {
        AppMethodBeat.i(147401);
        final String optString = iVar.optString("apiName");
        s sVar = cVar.cAJ;
        if (a.eG(sVar.getAppId(), optString)) {
            a(cVar, 1);
            AppMethodBeat.o(147401);
            return;
        }
        a.a(new com.tencent.mm.plugin.appbrand.permission.a.c(sVar, optString, (byte) 0), new a.c() {
            /* class com.tencent.mm.plugin.appbrand.u.c.g.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
            public final void bOI() {
                AppMethodBeat.i(147398);
                g.a(cVar, 1);
                AppMethodBeat.o(147398);
            }

            @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
            public final void acx(String str) {
                AppMethodBeat.i(147399);
                Log.e("Luggage.NodeJS.RequireUserAuth", "onDeny apiName[%s], reason[%s]", optString, str);
                g.a(cVar, 2);
                AppMethodBeat.o(147399);
            }

            @Override // com.tencent.mm.plugin.appbrand.permission.a.a.c
            public final void onCancel() {
                AppMethodBeat.i(147400);
                g.a(cVar, 3);
                AppMethodBeat.o(147400);
            }
        });
        AppMethodBeat.o(147401);
    }

    static void a(c cVar, int i2) {
        AppMethodBeat.i(147402);
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(i2));
        cVar.Y(hashMap);
        AppMethodBeat.o(147402);
    }
}
