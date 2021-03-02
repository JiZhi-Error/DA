package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<bsh> {
    public b(int i2, int i3) {
        AppMethodBeat.i(213539);
        bsg bsg = new bsg();
        bsg.KOr = i2;
        bsg.KOs = 0;
        bsg.LZn = 1;
        bsg.LZo = i3;
        d.a aVar = new d.a();
        aVar.iLN = bsg;
        aVar.iLO = new bsh();
        aVar.funcId = 2680;
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", Integer.valueOf(i2));
        AppMethodBeat.o(213539);
    }
}
