package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.afv;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class d extends q implements m {
    private i callback;
    private String dOe;
    private final com.tencent.mm.ak.d rr;

    public d(String str, LinkedList<cvt> linkedList) {
        AppMethodBeat.i(151187);
        d.a aVar = new d.a();
        aVar.iLN = new afu();
        aVar.iLO = new afv();
        aVar.uri = "/cgi-bin/micromsg-bin/delopenimchatroommember";
        aVar.funcId = 943;
        this.rr = aVar.aXF();
        this.dOe = str;
        afu afu = (afu) this.rr.iLK.iLR;
        afu.jHa = str;
        afu.KHx = linkedList;
        Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "roomname: %s, size:%d", str, Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(151187);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151188);
        Log.i("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname: %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe);
        if (sVar.getRespObj().getRetCode() == 0) {
            afv afv = (afv) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
            String str2 = this.dOe;
            if (!str2.toLowerCase().endsWith("@im.chatroom") || afv.KHx.isEmpty()) {
                Log.e("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember: room:[" + str2 + "] listCnt:" + afv.KHx.size());
            } else {
                ap aSX = ((c) g.af(c.class)).aSX();
                ah Kd = aSX.Kd(str2);
                List<String> bji = ah.bji(Kd.field_memberlist);
                Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember before " + bji.size());
                Iterator<cvu> it = afv.KHx.iterator();
                while (it.hasNext()) {
                    bji.remove(it.next().userName);
                }
                Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "DelChatroomMember after " + bji.size());
                Kd.iE(bji).field_displayname = ((b) g.af(b.class)).ao(bji);
                Log.d("MicroMsg.Openim.NetSceneDelOpenIMChatRoomMember", "delChatroomMember ".concat(String.valueOf(aSX.replace(Kd))));
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151188);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 943;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151189);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151189);
        return dispatch;
    }
}
