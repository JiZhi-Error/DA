package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.cdj;
import com.tencent.mm.protocal.protobuf.cdk;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ca;
import java.util.LinkedList;
import java.util.List;

public final class p extends a implements m {
    private i callback;
    public ca dTX;
    public int gsq;
    private final d rr;

    public p(String str, List<String> list, Object obj) {
        AppMethodBeat.i(194031);
        d.a aVar = new d.a();
        aVar.iLN = new cdj();
        aVar.iLO = new cdk();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        aVar.funcId = 610;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cdj cdj = (cdj) this.rr.iLK.iLR;
        LinkedList<con> linkedList = new LinkedList<>();
        for (String str2 : list) {
            con con = new con();
            con.Lqp = z.Su(str2);
            linkedList.add(con);
        }
        cdj.KGQ = linkedList;
        cdj.gsq = linkedList.size();
        cdj.KGR = z.Su(str);
        cdj.Mjh = 0;
        if (obj instanceof ChatroomInfoUI.LocalHistoryInfo) {
            Log.i("MicroMsg.NetSceneInviteChatRoomMember", "localHistoryInfo:%s", obj.toString());
            cdj.KGU = new cbr();
            cdj.KGU.fileid = ((ChatroomInfoUI.LocalHistoryInfo) obj).fileid;
            cdj.KGU.aeskey = ((ChatroomInfoUI.LocalHistoryInfo) obj).aeskey;
            cdj.KGU.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo) obj).filemd5;
            cdj.KGU.guR = ((ChatroomInfoUI.LocalHistoryInfo) obj).guR;
            cdj.KGU.guS = ((ChatroomInfoUI.LocalHistoryInfo) obj).guS;
        }
        AppMethodBeat.o(194031);
    }

    public p(String str, List<String> list, String str2, ca caVar) {
        AppMethodBeat.i(12486);
        this.dTX = caVar;
        d.a aVar = new d.a();
        aVar.iLN = new cdj();
        aVar.iLO = new cdk();
        aVar.uri = "/cgi-bin/micromsg-bin/invitechatroommember";
        aVar.funcId = 610;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cdj cdj = (cdj) this.rr.iLK.iLR;
        LinkedList<con> linkedList = new LinkedList<>();
        for (String str3 : list) {
            con con = new con();
            con.Lqp = z.Su(str3);
            linkedList.add(con);
        }
        this.gsq = linkedList.size();
        cdj.KGQ = linkedList;
        cdj.gsq = linkedList.size();
        cdj.KGR = z.Su(str);
        cdj.Mjh = 2;
        cdj.Mji = str2;
        AppMethodBeat.o(12486);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12487);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12487);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 610;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12488);
        Log.d("MicroMsg.NetSceneInviteChatRoomMember", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12488);
    }

    @Override // com.tencent.mm.roomsdk.a.a
    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        if (!(aVar instanceof com.tencent.mm.roomsdk.a.b.d)) {
            return aVar;
        }
        com.tencent.mm.roomsdk.a.b.d dVar = (com.tencent.mm.roomsdk.a.b.d) aVar;
        dVar.gsq = this.gsq;
        dVar.NDK = this.dTX;
        return dVar;
    }
}
