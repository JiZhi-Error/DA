package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.djx;
import com.tencent.mm.protocal.protobuf.djy;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends com.tencent.mm.ak.c<djy> {
    public c(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(174503);
        djx djx = new djx();
        d.a aVar = new d.a();
        djx.HQc = str2;
        djx.HVd = str3;
        djx.dNQ = str;
        djx.IaW = str4;
        aVar.iLN = djx;
        aVar.iLO = new djy();
        aVar.funcId = 2752;
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameverifysms";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiRealnameVerifySms", "verify sms: %s, %s, reqkey: %s", str3, str2, str);
        AppMethodBeat.o(174503);
    }
}
