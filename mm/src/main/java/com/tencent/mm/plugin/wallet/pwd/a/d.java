package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.eli;
import com.tencent.mm.protocal.protobuf.emi;
import com.tencent.mm.protocal.protobuf.emj;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class d extends c<emj> {
    public d(LinkedList<eli> linkedList) {
        AppMethodBeat.i(69525);
        emi emi = new emi();
        emi.KDk = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = emi;
        aVar.iLO = new emj();
        aVar.funcId = 2638;
        aVar.uri = "/cgi-bin/mmpay-bin/updateunipayorder";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiUpdateUniPayOrder", "update uni pay order");
        AppMethodBeat.o(69525);
    }
}
