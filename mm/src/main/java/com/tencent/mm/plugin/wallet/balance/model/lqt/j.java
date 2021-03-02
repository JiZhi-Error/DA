package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cux;

public final class j extends c<cux> {
    public j(int i2) {
        AppMethodBeat.i(68407);
        d.a aVar = new d.a();
        aVar.iLN = new cuw();
        aVar.iLO = new cux();
        aVar.funcId = 1830;
        aVar.uri = "/cgi-bin/mmpay-bin/onclickredeem";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        cuw cuw = (cuw) aXF.iLK.iLR;
        cuw.yba = i2;
        cuw.HuS = ag.fNb();
        c(aXF);
        AppMethodBeat.o(68407);
    }
}
