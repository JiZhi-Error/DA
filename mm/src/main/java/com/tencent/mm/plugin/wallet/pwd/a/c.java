package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends com.tencent.mm.ak.c<dih> {
    public c() {
        AppMethodBeat.i(69524);
        d.a aVar = new d.a();
        aVar.iLN = new dig();
        aVar.iLO = new dih();
        aVar.funcId = 2904;
        aVar.uri = "/cgi-bin/mmpay-bin/queryunipayorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiQueryUniPayOrder", "query uni pay order");
        AppMethodBeat.o(69524);
    }
}
