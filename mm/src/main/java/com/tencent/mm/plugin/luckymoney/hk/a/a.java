package com.tencent.mm.plugin.luckymoney.hk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bfa;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends c<bfb> {
    public a(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(213267);
        bfa bfa = new bfa();
        bfa.egX = str;
        bfa.yQE = str2;
        bfa.limit = 11;
        bfa.offset = i2;
        bfa.msgType = 1;
        bfa.scene = i3;
        d.a aVar = new d.a();
        aVar.iLN = bfa;
        aVar.iLO = new bfb();
        aVar.funcId = 4889;
        aVar.uri = "/cgi-bin/mmpay-bin/foreignhbdetail";
        d aXF = aVar.aXF();
        aXF.setIsUserCmd(true);
        c(aXF);
        Log.i("MicroMsg.CgiHKHbDetail", "nativeurl: %s, sendid: %s, limit: %s, offset: %s, scene: %s", str, str2, 11, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(213267);
    }
}
