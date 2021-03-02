package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends c<cwy> {
    public d(String str) {
        AppMethodBeat.i(68401);
        cwx cwx = new cwx();
        cwx.time_stamp = (int) System.currentTimeMillis();
        cwx.Lmm = str;
        cwx.HuS = ag.fNb();
        d.a aVar = new d.a();
        aVar.iLN = cwx;
        aVar.iLO = new cwy();
        aVar.funcId = 2896;
        aVar.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/openlqautotrans";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.d("MicroMsg.CgiLqtAutoChargeOpen", "pwd: %s", str);
        AppMethodBeat.o(68401);
    }
}
