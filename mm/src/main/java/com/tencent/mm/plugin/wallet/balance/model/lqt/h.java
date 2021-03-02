package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cqx;
import com.tencent.mm.protocal.protobuf.cqy;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends c<cqy> {
    public h(int i2, String str, String str2, String str3, long j2, int i3, String str4) {
        AppMethodBeat.i(68405);
        d.a aVar = new d.a();
        aVar.iLN = new cqx();
        aVar.iLO = new cqy();
        aVar.funcId = 2614;
        aVar.uri = "/cgi-bin/mmpay-bin/modifyplan";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        d aXF = aVar.aXF();
        cqx cqx = (cqx) aXF.iLK.iLR;
        cqx.Htr = i2;
        cqx.dDj = str;
        cqx.AOk = str2;
        cqx.Htm = str3;
        cqx.eht = j2;
        cqx.grV = i3;
        cqx.KHB = str4;
        c(aXF);
        Log.i("MicroMsg.CgiLqtModifyPlan", "plan_id: %s, card_tail: %s, amount: %s, day: %s", Integer.valueOf(i2), str2, Long.valueOf(j2), Integer.valueOf(i3));
        AppMethodBeat.o(68405);
    }
}
