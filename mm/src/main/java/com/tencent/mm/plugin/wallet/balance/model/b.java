package com.tencent.mm.plugin.wallet.balance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<vz> {
    public b(long j2, String str, String str2) {
        AppMethodBeat.i(68392);
        d.a aVar = new d.a();
        vy vyVar = new vy();
        vyVar.Lhf = j2;
        vyVar.Lhg = str;
        vyVar.Lhh = str2;
        aVar.iLN = vyVar;
        aVar.iLO = new vz();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getfreefeedetail";
        aVar.funcId = 1236;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiGetFreeFeeDetail", "get free fee detail: %s, %s, %s", Long.valueOf(j2), str, str2);
        AppMethodBeat.o(68392);
    }
}
