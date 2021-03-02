package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dhk;
import com.tencent.mm.protocal.protobuf.dhl;

public final class e extends c<dhl> {
    public e() {
        AppMethodBeat.i(68402);
        dhk dhk = new dhk();
        dhk.time_stamp = (int) System.currentTimeMillis();
        dhk.HuS = ag.fNb();
        d.a aVar = new d.a();
        aVar.iLN = dhk;
        aVar.iLO = new dhl();
        aVar.funcId = 2668;
        aVar.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/qrysetting";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        AppMethodBeat.o(68402);
    }
}
