package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.protocal.protobuf.cvq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class e extends q implements m {
    private i callback;
    private final String dOe;
    private final d rr;

    public e(String str) {
        AppMethodBeat.i(151190);
        d.a aVar = new d.a();
        aVar.iLN = new bri();
        aVar.iLO = new brj();
        aVar.uri = "/cgi-bin/micromsg-bin/getopenimchatroomcontact";
        aVar.funcId = 407;
        this.rr = aVar.aXF();
        this.dOe = str;
        ((bri) this.rr.iLK.iLR).jHa = str;
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "get roomname:%s", str);
        AppMethodBeat.o(151190);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151191);
        Log.i("MicroMsg.Openim.NetSceneGetOpenIMChatRoomContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname:%s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe);
        if (i3 == 0 && i4 == 0) {
            brj brj = (brj) ((d) sVar).iLL.iLR;
            if (brj.LYN != null) {
                cvq cvq = brj.LYN;
                a.a(cvq, cvq.MAZ, cvq.MAZ);
                try {
                    boolean Tf = ((l) g.af(l.class)).aST().Tf(cvq.jHa);
                    boolean Ih = ((b) g.af(b.class)).Ih(cvq.jHa);
                    Log.i("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", cvq.jHa, Boolean.valueOf(Tf), Boolean.valueOf(Ih));
                    if (Tf && Ih) {
                        jj jjVar = new jj();
                        jjVar.dOd.dOe = cvq.jHa;
                        EventCenter.instance.publish(jjVar);
                    }
                } catch (Exception e2) {
                    Log.e("OpenIMChatRoomContactLogic", "updateChatroomContactByGetRoomContact chatroom:%s, exception:%s %s", cvq.jHa, e2.getClass().getSimpleName(), e2.getMessage());
                }
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151191);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 407;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151192);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151192);
        return dispatch;
    }
}
