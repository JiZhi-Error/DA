package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.e;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;

public final class d extends e {
    @Override // com.tencent.mm.model.e
    public final ca a(h.a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(206400);
        de deVar = aVar.heO;
        String a2 = z.a(deVar.KHn);
        if (a2 == null || a2.length() <= 0) {
            Log.e("MicroMsg.CardMsgExtension", "possible friend msg : content is null");
            AppMethodBeat.o(206400);
            return null;
        }
        ca.a bkA = ca.a.bkA(a2);
        if (deVar.xKb == 66) {
            ((a) g.af(a.class)).RY(bkA.OqQ);
        }
        if (Util.nullAsNil(bkA.dkU).length() > 0) {
            i iVar = new i();
            iVar.username = bkA.dkU;
            iVar.fuz = 3;
            iVar.fv(true);
            iVar.iKX = bkA.OqM;
            iVar.iKW = bkA.OqN;
            iVar.cSx = -1;
            Log.d("MicroMsg.CardMsgExtension", "dkhurl user:[%s] big:[%s] sm:[%s]", bkA.dkU, iVar.aYt(), iVar.aYu());
            p.aYB().b(iVar);
        }
        ca a3 = super.a(aVar, str, str2, str3);
        AppMethodBeat.o(206400);
        return a3;
    }
}
