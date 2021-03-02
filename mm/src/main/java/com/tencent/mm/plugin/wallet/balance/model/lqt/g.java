package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cmd;
import com.tencent.mm.sdk.platformtools.Log;

public final class g extends c<cmd> {
    public g(int i2, int i3, String str) {
        AppMethodBeat.i(68404);
        d.a aVar = new d.a();
        aVar.iLN = new cmc();
        aVar.iLO = new cmd();
        aVar.funcId = 2507;
        aVar.uri = "/cgi-bin/mmpay-bin/manageplan";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        cmc cmc = (cmc) aXF.iLK.iLR;
        cmc.type = i2;
        cmc.Htr = i3;
        cmc.KHB = str;
        c(aXF);
        Log.i("MicroMsg.CgiLqtManagePlan", "type: %s, planId: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(68404);
    }
}
