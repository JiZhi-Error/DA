package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.abk;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<abk> {
    public a() {
        AppMethodBeat.i(69522);
        d.a aVar = new d.a();
        aVar.iLN = new abj();
        aVar.iLO = new abk();
        aVar.funcId = 2913;
        aVar.uri = "/cgi-bin/mmpay-bin/closeunipayorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiCloseUniPayOrder", "close uni pay order");
        AppMethodBeat.o(69522);
    }
}
