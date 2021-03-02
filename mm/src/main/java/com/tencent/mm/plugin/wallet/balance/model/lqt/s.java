package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dfz;
import com.tencent.mm.protocal.protobuf.dga;

public final class s extends c<dga> {
    public s(int i2, int i3) {
        AppMethodBeat.i(213848);
        d.a aVar = new d.a();
        aVar.iLN = new dfz();
        aVar.iLO = new dga();
        aVar.funcId = 4981;
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefrombankguidestat";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dfz dfz = (dfz) aXF.iLK.iLR;
        dfz.MKK = i2;
        dfz.MKL = i3;
        dfz.HuS = ag.fNb();
        c(aXF);
        AppMethodBeat.o(213848);
    }
}
