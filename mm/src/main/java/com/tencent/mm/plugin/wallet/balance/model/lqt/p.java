package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dlu;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.wallet_core.c.j;

public final class p extends c<dlv> implements j {
    public p(int i2, String str, String str2, int i3, String str3) {
        AppMethodBeat.i(68452);
        d.a aVar = new d.a();
        aVar.iLN = new dlu();
        aVar.iLO = new dlv();
        aVar.funcId = 1338;
        aVar.uri = "/cgi-bin/mmpay-bin/redeemfund";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dlu dlu = (dlu) aXF.iLK.iLR;
        dlu.MJd = i2;
        dlu.Lmm = str;
        dlu.MJi = str2;
        dlu.yba = i3;
        dlu.MJh = str3;
        dlu.HuS = ag.fNb();
        c(aXF);
        AppMethodBeat.o(68452);
    }
}
