package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.s;
import com.tencent.mm.protocal.protobuf.t;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<t> {
    public a(String str, long j2, int i2, String str2, String str3, String str4) {
        AppMethodBeat.i(63370);
        s sVar = new s();
        sVar.KBs = str;
        sVar.KBK = j2;
        sVar.scene = i2;
        sVar.KBt = str2;
        sVar.KBM = str3;
        sVar.CpP = str4;
        d.a aVar = new d.a();
        aVar.iLN = sVar;
        aVar.iLO = new t();
        aVar.funcId = 1344;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", sVar.KBs, Long.valueOf(sVar.KBK), Integer.valueOf(sVar.scene), sVar.KBt, sVar.KBM, sVar.CpP);
        AppMethodBeat.o(63370);
    }
}
