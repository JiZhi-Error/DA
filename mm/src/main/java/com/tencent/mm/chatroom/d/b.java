package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.f;
import com.tencent.mm.protocal.protobuf.cq;
import com.tencent.mm.protocal.protobuf.cr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b extends c<cr> {
    public b(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(12452);
        Log.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", str, Util.listToString(linkedList, ";"));
        cq cqVar = new cq();
        cqVar.KGO = str;
        cqVar.KGP = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = cqVar;
        aVar.iLO = new cr();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroomadmin";
        aVar.funcId = f.CTRL_INDEX;
        c(aVar.aXF());
        AppMethodBeat.o(12452);
    }
}
