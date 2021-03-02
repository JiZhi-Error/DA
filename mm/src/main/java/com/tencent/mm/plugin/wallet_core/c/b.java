package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.bev;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<bev> {
    public b(String str, int i2, int i3) {
        AppMethodBeat.i(69888);
        d.a aVar = new d.a();
        beu beu = new beu();
        beu.LjW = str;
        beu.LOB = i2;
        beu.LOC = i3;
        aVar.iLN = beu;
        aVar.iLO = new bev();
        aVar.uri = "/cgi-bin/mmpay-bin/mktfollowcardbdmch";
        aVar.funcId = 2720;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiFollowCardBDMch", "CgiFollowCardBDMch: %s, %s, %s", str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(69888);
    }
}
