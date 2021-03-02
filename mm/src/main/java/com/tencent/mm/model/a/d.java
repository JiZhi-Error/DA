package com.tencent.mm.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class d implements h {
    @Override // com.tencent.mm.ak.h
    public final h.b b(h.a aVar) {
        AppMethodBeat.i(153093);
        de deVar = aVar.heO;
        if (deVar == null || deVar.KHn == null) {
            Log.f("MicroMsg.abtest.AbTestMsgExtension", "[Abtest] AbTestMsgExtension failed, invalid cmdAM");
            AppMethodBeat.o(153093);
        } else {
            String a2 = z.a(deVar.KHn);
            g.aAh().azQ().set(328193, a2);
            c aWT = g.aWT();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                aWT.KS(a2);
                String str = (String) g.aAh().azQ().get(328197, (Object) null);
                if (Util.isNullOrNil(str) || (aWT.iGz != null && !str.equals(aWT.iGz.iGw))) {
                    g.aAh().azQ().set(328197, aWT.iGz.iGw);
                    g.aAh().azQ().set(328195, Boolean.FALSE);
                    g.aAh().azQ().set(328194, Boolean.FALSE);
                    g.aAh().azQ().set(328196, Boolean.FALSE);
                    Log.i("MicroMsg.abtest.AbTestManager", "[cpan] new case id or new case id , reset click value.");
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.abtest.AbTestManager", "[Abtest] updateAbTestCase exception:%s", e2.toString());
            }
            Log.i("MicroMsg.abtest.AbTestManager", "[Abtest] update use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            if (g.aWT().aWR()) {
                f.KU(g.aWT().iGz.iGw);
            }
            AppMethodBeat.o(153093);
        }
        return null;
    }

    @Override // com.tencent.mm.ak.h
    public final void b(h.c cVar) {
    }
}
