package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.wallet_core.c.j;

public final class m extends c<dgc> implements j {
    public m(String str, String str2, int i2, int i3, String str3, int i4, String str4, String str5) {
        AppMethodBeat.i(213846);
        d.a aVar = new d.a();
        aVar.iLN = new dgb();
        aVar.iLO = new dgc();
        aVar.funcId = 1276;
        aVar.uri = "/cgi-bin/mmpay-bin/purchasefund";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        dgb dgb = (dgb) aXF.iLK.iLR;
        dgb.Mnl = str;
        dgb.MKM = i2;
        dgb.yba = i3;
        dgb.Mnk = str2;
        dgb.MJh = str3;
        dgb.HuF = i4;
        dgb.dDj = str4;
        dgb.HWx = str5;
        dgb.MKN = 1;
        dgb.MKO = 1;
        dgb.HuS = ag.fNb();
        dgb.MKO = 1;
        dgb.MKN = 1;
        c(aXF);
        AppMethodBeat.o(213846);
    }
}
