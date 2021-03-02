package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.biu;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<biu> {
    public a() {
        AppMethodBeat.i(68391);
        d.a aVar = new d.a();
        aVar.iLN = new bit();
        aVar.iLO = new biu();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbalancemenu";
        aVar.funcId = 2567;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiGetBalanceMenu", "get balance menu");
        AppMethodBeat.o(68391);
    }
}
