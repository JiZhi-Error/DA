package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<dn> {
    public a(String str, String str2, String str3, String str4, long j2, int i2, int i3) {
        AppMethodBeat.i(68398);
        d.a aVar = new d.a();
        aVar.iLN = new dm();
        aVar.iLO = new dn();
        aVar.funcId = 2780;
        aVar.uri = "/cgi-bin/mmpay-bin/addplan";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dm dmVar = (dm) aXF.iLK.iLR;
        dmVar.KHB = str;
        dmVar.dDj = str2;
        dmVar.AOk = str3;
        dmVar.Htm = str4;
        dmVar.eht = j2;
        dmVar.grV = i2;
        dmVar.Htr = i3;
        c(aXF);
        Log.i("MicroMsg.CgiLqtAddPlan", "card_tail: %s, amount: %s, day: %s, planId: %s", str3, Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(68398);
    }
}
