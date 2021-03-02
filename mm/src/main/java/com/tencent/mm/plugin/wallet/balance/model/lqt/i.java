package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cuu;
import com.tencent.mm.protocal.protobuf.cuv;

public final class i extends c<cuv> {
    public i(int i2, int i3) {
        AppMethodBeat.i(68406);
        d.a aVar = new d.a();
        aVar.iLN = new cuu();
        aVar.iLO = new cuv();
        aVar.funcId = 2585;
        aVar.uri = "/cgi-bin/mmpay-bin/onclickpurchase";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        cuu cuu = (cuu) aXF.iLK.iLR;
        cuu.yba = i2;
        cuu.HuF = i3;
        cuu.HuS = ag.fNb();
        c(aXF);
        AppMethodBeat.o(68406);
    }
}
