package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e extends c<dh> {
    public e(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(194021);
        Log.d("MicroMsg.CgiOpenImAddChatRoomAdmin", "roomName:%s,username:%s", str, Util.listToString(linkedList, ";"));
        dg dgVar = new dg();
        dgVar.dOe = str;
        dgVar.ybk = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = dgVar;
        aVar.iLO = new dh();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimchatroomadmin";
        aVar.funcId = 776;
        c(aVar.aXF());
        AppMethodBeat.o(194021);
    }
}
