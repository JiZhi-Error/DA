package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.djw;
import com.tencent.mm.protocal.protobuf.dkc;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<djw> {
    public b(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(174502);
        dkc dkc = new dkc();
        d.a aVar = new d.a();
        dkc.HQc = str;
        dkc.HVd = str2;
        dkc.MNZ = i2;
        dkc.dNQ = str3;
        aVar.iLN = dkc;
        aVar.iLO = new djw();
        aVar.funcId = 1923;
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnamesendsms";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiRealnameSendSms", "send sms: %s, %s, isRetry: %s", str2, str, Integer.valueOf(i2));
        AppMethodBeat.o(174502);
    }
}
