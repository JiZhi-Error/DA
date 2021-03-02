package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.rw.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends com.tencent.mm.roomsdk.a.a implements m {
    private i callback;
    private String dOe;
    private final d rr;

    public a(String str, LinkedList<cvt> linkedList, String str2) {
        AppMethodBeat.i(151176);
        d.a aVar = new d.a();
        aVar.iLN = new di();
        aVar.iLO = new dj();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimchatroommember";
        aVar.funcId = k.CTRL_INDEX;
        this.rr = aVar.aXF();
        this.dOe = str;
        di diVar = (di) this.rr.iLK.iLR;
        diVar.jHa = str;
        diVar.KHx = linkedList;
        diVar.desc = str2;
        Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "roomname: %s, size:%s, desc:%s", str, Integer.valueOf(linkedList.size()), str2);
        AppMethodBeat.o(151176);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        as a2;
        AppMethodBeat.i(151177);
        Log.i("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, roomname = %s", Integer.valueOf(i3), Integer.valueOf(i4), str, this.dOe);
        if (sVar.getRespObj().getRetCode() == 0) {
            dj djVar = (dj) ((d) sVar).iLL.iLR;
            String str2 = this.dOe;
            if (!str2.toLowerCase().endsWith("@im.chatroom") || djVar.KHx.isEmpty()) {
                Log.e("MicroMsg.Openim.NetSceneAddOpenIMChatRoomMember", "AddChatroomMember: bad room:[" + str2 + "] listCnt:" + djVar.KHx.size());
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                bv aSN = ((l) g.af(l.class)).aSN();
                Iterator<cvu> it = djVar.KHx.iterator();
                while (it.hasNext()) {
                    cvu next = it.next();
                    if (next.status == 0) {
                        as Kn = aSN.Kn(next.userName);
                        if (((int) Kn.gMZ) != 0) {
                            Kn.aqP();
                            aSN.c(Kn.field_username, Kn);
                            a2 = Kn;
                        } else {
                            a2 = b.c.a(Kn, next);
                            aSN.ap(a2);
                        }
                        arrayList.add(a2.field_username);
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((com.tencent.mm.plugin.chatroom.a.b) g.af(com.tencent.mm.plugin.chatroom.a.b.class)).a(str2, arrayList, null);
                }
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151177);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return k.CTRL_INDEX;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151178);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151178);
        return dispatch;
    }

    @Override // com.tencent.mm.roomsdk.a.a
    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        dj djVar;
        AppMethodBeat.i(151179);
        if (aVar == null || !(aVar instanceof c) || (djVar = (dj) this.rr.iLL.iLR) == null) {
            AppMethodBeat.o(151179);
            return aVar;
        }
        b.C0499b bVar = new b.C0499b();
        bVar.q(djVar.KHx);
        c cVar = (c) aVar;
        cVar.chatroomName = this.dOe;
        cVar.dRN = bVar.grX.size();
        cVar.dSU = bVar.grX;
        cVar.grX = bVar.grX;
        cVar.dSX = bVar.dSX;
        cVar.grY = bVar.grY;
        cVar.dSZ = bVar.dSZ;
        cVar.grZ = bVar.grZ;
        cVar.dTa = bVar.dTa;
        cVar.KHy = djVar.KHy;
        AppMethodBeat.o(151179);
        return cVar;
    }
}
