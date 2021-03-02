package com.tencent.mm.plugin.aa.model.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends c<com.tencent.mm.protocal.protobuf.c> {
    public d(String str, String str2) {
        AppMethodBeat.i(63374);
        d.a aVar = new d.a();
        b bVar = new b();
        bVar.KBs = str;
        bVar.KBt = str2;
        aVar.iLN = bVar;
        aVar.iLO = new com.tencent.mm.protocal.protobuf.c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        aVar.funcId = 1672;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        c(aVar.aXF());
        Log.i("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", str, str2);
        AppMethodBeat.o(63374);
    }
}
