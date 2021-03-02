package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.abh;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<abi> {
    public b(String str) {
        AppMethodBeat.i(68399);
        abh abh = new abh();
        abh.Lmm = str;
        abh.time_stamp = (int) System.currentTimeMillis();
        abh.HuS = ag.fNb();
        d.a aVar = new d.a();
        aVar.iLN = abh;
        aVar.iLO = new abi();
        aVar.funcId = 2512;
        aVar.uri = "/cgi-bin/mmpay-bin/lqtlqautoin/closeautolqtolqt";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.d("MicroMsg.CgiLqtAutoChargeClose", "close ");
        AppMethodBeat.o(68399);
    }
}
