package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class f extends c<aft> {
    public f(String str, LinkedList<String> linkedList) {
        AppMethodBeat.i(194022);
        Log.d("MicroMsg.CgiOpenImDelChatRoomAdmin", "roomName:%s,username:%s", str, Util.listToString(linkedList, ";"));
        afs afs = new afs();
        afs.dOe = str;
        afs.ybk = linkedList;
        d.a aVar = new d.a();
        aVar.iLN = afs;
        aVar.iLO = new aft();
        aVar.uri = "/cgi-bin/micromsg-bin/delopenimchatroomadmin";
        aVar.funcId = 3677;
        c(aVar.aXF());
        AppMethodBeat.o(194022);
    }
}
