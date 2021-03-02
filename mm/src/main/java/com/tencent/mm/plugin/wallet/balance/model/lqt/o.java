package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.protocal.protobuf.dhn;

public final class o extends c<dhn> {
    private dhm Htv = null;
    private d hJu;

    public o() {
        AppMethodBeat.i(68451);
        d.a aVar = new d.a();
        aVar.iLN = new dhm();
        aVar.iLO = new dhn();
        aVar.funcId = 1211;
        aVar.uri = "/cgi-bin/mmpay-bin/qryusrfunddetail";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hJu = aVar.aXF();
        this.Htv = (dhm) this.hJu.iLK.iLR;
        this.Htv.time_stamp = (int) System.currentTimeMillis();
        this.Htv.HuS = ag.fNb();
        c(aVar.aXF());
        AppMethodBeat.o(68451);
    }
}
