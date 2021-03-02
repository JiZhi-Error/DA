package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class d extends c<afe> {
    public d(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(12454);
        Log.d("MicroMsg.CgiAddChatRoomAdmin", "roomName:%s,username:%s", str, Util.listToString(linkedList, ";"));
        afd afd = new afd();
        afd.KGO = str;
        afd.KGP = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = afd;
        aVar.iLO = new afe();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroomadmin";
        aVar.funcId = 259;
        c(aVar.aXF());
        AppMethodBeat.o(12454);
    }
}
