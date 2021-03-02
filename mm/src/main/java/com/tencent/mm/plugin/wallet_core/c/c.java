package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.elg;
import com.tencent.mm.protocal.protobuf.elh;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends com.tencent.mm.ak.c<elh> {
    public c(String str) {
        AppMethodBeat.i(69889);
        d.a aVar = new d.a();
        elg elg = new elg();
        elg.LjW = str;
        elg.timestamp = System.currentTimeMillis();
        aVar.iLN = elg;
        aVar.iLO = new elh();
        aVar.uri = "/cgi-bin/mmpay-bin/mktuncheckmchservicepos";
        aVar.funcId = 2595;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiUnCheckMchServicePos", "CgiUnCheckMchServicePos: %s", str);
        AppMethodBeat.o(69889);
    }
}
