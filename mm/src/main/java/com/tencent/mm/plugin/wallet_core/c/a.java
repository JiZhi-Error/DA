package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.yv;
import com.tencent.mm.protocal.protobuf.yw;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<yw> {
    public a(String str) {
        AppMethodBeat.i(69887);
        d.a aVar = new d.a();
        yv yvVar = new yv();
        yvVar.LjW = str;
        yvVar.timestamp = System.currentTimeMillis();
        aVar.iLN = yvVar;
        aVar.iLO = new yw();
        aVar.uri = "/cgi-bin/mmpay-bin/mktcheckmchservicepos";
        aVar.funcId = 2553;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiCheckMchServicePos", "CgiCheckMchServicePos: %s", str);
        AppMethodBeat.o(69887);
    }
}
