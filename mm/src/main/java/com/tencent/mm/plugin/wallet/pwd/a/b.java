package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.cxd;
import com.tencent.mm.protocal.protobuf.cxe;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<cxe> {
    public b() {
        AppMethodBeat.i(69523);
        d.a aVar = new d.a();
        aVar.iLN = new cxd();
        aVar.iLO = new cxe();
        aVar.funcId = 2513;
        aVar.uri = "/cgi-bin/mmpay-bin/openunipayorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiOpenUniPayOrder", "open uni pay order");
        AppMethodBeat.o(69523);
    }
}
