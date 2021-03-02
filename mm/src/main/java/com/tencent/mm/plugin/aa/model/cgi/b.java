package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.u;
import com.tencent.mm.protocal.protobuf.v;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends c<v> {
    public b(String str, String str2, int i2) {
        AppMethodBeat.i(63371);
        d.a aVar = new d.a();
        u uVar = new u();
        uVar.KBs = str;
        uVar.KBt = str2;
        uVar.scene = i2;
        aVar.iLN = uVar;
        aVar.iLO = new v();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        aVar.funcId = 1644;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiAAPayUrge", "CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", str, str2, Integer.valueOf(i2));
        AppMethodBeat.o(63371);
    }
}
