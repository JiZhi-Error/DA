package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c extends com.tencent.mm.ak.c<hb> {
    public c(long j2, String str, String str2, String str3, LinkedList<String> linkedList) {
        AppMethodBeat.i(12453);
        Log.d("MicroMsg.CgiApproveAddChatRoomMember", "inviterusername%s,roomname:%s,ticket:%s,username:%s approvenewmsgid:%s", str, str2, Util.secPrint(str3), linkedList, Long.valueOf(j2));
        ha haVar = new ha();
        haVar.jfS = str;
        haVar.dOe = str2;
        haVar.dHx = str3;
        haVar.KKJ = linkedList;
        haVar.KKK = j2;
        d.a aVar = new d.a();
        aVar.iLN = haVar;
        aVar.iLO = new hb();
        aVar.uri = "/cgi-bin/micromsg-bin/approveaddchatroommember";
        aVar.funcId = 774;
        c(aVar.aXF());
        AppMethodBeat.o(12453);
    }
}
