package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.protocal.protobuf.dhj;

public final class n extends c<dhj> {
    public n(String str, String str2, int i2, int i3, String str3, int i4, int i5) {
        AppMethodBeat.i(213847);
        d.a aVar = new d.a();
        aVar.iLN = new dhi();
        aVar.iLO = new dhj();
        aVar.funcId = 1283;
        aVar.uri = "/cgi-bin/mmpay-bin/qrypurchaseresult";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dhi dhi = (dhi) aXF.iLK.iLR;
        dhi.MLF = str;
        dhi.CpP = str2;
        dhi.MKM = i2;
        dhi.yba = i3;
        dhi.MJh = str3;
        dhi.HuF = i4;
        dhi.HuS = ag.fNb();
        dhi.MLG = i5;
        c(aXF);
        AppMethodBeat.o(213847);
    }
}
