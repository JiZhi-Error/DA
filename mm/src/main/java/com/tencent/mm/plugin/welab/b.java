package com.tencent.mm.plugin.welab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.model.cj;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.welab.d.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class b implements cj.a {
    @Override // com.tencent.mm.model.cj.a
    public final void a(h.a aVar) {
        AppMethodBeat.i(146209);
        if (aVar == null || aVar.heO == null || aVar.heO.KHn == null) {
            Log.i("MicroMsg.WelabNewMsgLsn", "recv null msg");
            AppMethodBeat.o(146209);
            return;
        }
        String a2 = z.a(aVar.heO.KHn);
        Log.i("MicroMsg.WelabNewMsgLsn", "recv addMsg ".concat(String.valueOf(a2)));
        a bbB = e.bbB(a2);
        if (bbB != null && bbB.isValid()) {
            if (bbB.field_status == 1) {
                a.gjg().JFR.delete(bbB, "expId");
            } else {
                a.gjg().JFR.c(bbB);
                com.tencent.mm.plugin.welab.e.b.gju().f(bbB);
                bbB.reportIdkey();
                ArrayList arrayList = new ArrayList();
                arrayList.add(bbB);
                a.gjg();
                a.io(arrayList);
            }
            d.y(bbB.field_LabsAppId, 6, false);
        }
        AppMethodBeat.o(146209);
    }

    @Override // com.tencent.mm.model.cj.a
    public final void a(h.c cVar) {
    }
}
