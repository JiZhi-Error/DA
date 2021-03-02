package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.ja;

public final class l extends c<dec> {
    public l(int i2, ja jaVar, int i3, int i4, String str) {
        AppMethodBeat.i(68448);
        d.a aVar = new d.a();
        aVar.iLN = new deb();
        aVar.iLO = new dec();
        aVar.funcId = 1324;
        aVar.uri = "/cgi-bin/mmpay-bin/preredeemfund";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        deb deb = (deb) aXF.iLK.iLR;
        deb.MJd = i2;
        if (jaVar != null) {
            deb.MJe = 1;
            deb.MJf = jaVar;
        } else {
            deb.MJe = 0;
            deb.MJf = null;
        }
        deb.yba = i3;
        deb.MJg = i4;
        deb.MJh = str;
        deb.HuS = ag.fNb();
        c(aXF);
        AppMethodBeat.o(68448);
    }
}
