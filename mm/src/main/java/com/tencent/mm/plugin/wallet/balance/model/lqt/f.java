package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.abc;

public final class f extends c<abc> {
    public f(String str, int i2) {
        AppMethodBeat.i(68403);
        d.a aVar = new d.a();
        aVar.iLN = new abb();
        aVar.iLO = new abc();
        aVar.funcId = 1386;
        aVar.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        abb abb = (abb) aXF.iLK.iLR;
        abb.Lmm = str;
        abb.yba = i2;
        abb.HuS = ag.fNb();
        c(aXF);
        AppMethodBeat.o(68403);
    }
}
