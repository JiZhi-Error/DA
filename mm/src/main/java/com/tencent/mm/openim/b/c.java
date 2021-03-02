package com.tencent.mm.openim.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.openim.room.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aej;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.cvu;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends a implements m {
    private i callback;
    private final d rr;

    public c(LinkedList<cvt> linkedList) {
        AppMethodBeat.i(151183);
        d.a aVar = new d.a();
        aVar.iLN = new aej();
        aVar.iLO = new aek();
        aVar.uri = "/cgi-bin/micromsg-bin/createopenimchatroom";
        aVar.funcId = 371;
        this.rr = aVar.aXF();
        ((aej) this.rr.iLK.iLR).KHx = linkedList;
        Log.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "create size:%d", Integer.valueOf(linkedList.size()));
        AppMethodBeat.o(151183);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        as a2;
        AppMethodBeat.i(151184);
        Log.i("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (sVar.getRespObj().getRetCode() == 0) {
            aek aek = (aek) ((d) sVar).iLL.iLR;
            if (!Util.isNullOrNil(aek.jHa)) {
                if (!aek.jHa.toLowerCase().endsWith("@im.chatroom")) {
                    Log.e("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "createChatroom: bad room:[" + aek.jHa + "]");
                } else {
                    as asVar = new as();
                    asVar.setUsername(aek.jHa);
                    bv aSN = ((l) g.af(l.class)).aSN();
                    if (!aSN.bjN(asVar.field_username)) {
                        aSN.ap(asVar);
                    }
                    if (!Util.isNullOrNil(asVar.field_username) && !Util.isNullOrNil(aek.LpI)) {
                        com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
                        iVar.username = asVar.field_username;
                        iVar.iKX = aek.LpH;
                        iVar.iKW = aek.LpI;
                        iVar.fuz = 3;
                        iVar.fv(false);
                        iVar.cSx = -1;
                        p.aYB().b(iVar);
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    Iterator<cvu> it = aek.KHx.iterator();
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
                    if (!arrayList.contains(z.aTY())) {
                        arrayList.add(z.aTY());
                        Log.d("MicroMsg.Openim.NetSceneCreateOpenIMChatRoom", "respon has not self add one " + arrayList.contains(z.aTY()));
                    }
                    ((com.tencent.mm.plugin.chatroom.a.b) g.af(com.tencent.mm.plugin.chatroom.a.b.class)).a(asVar.field_username, arrayList, z.aTY());
                }
            }
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(151184);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 371;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(151185);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(151185);
        return dispatch;
    }

    @Override // com.tencent.mm.roomsdk.a.a
    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        aek aek;
        AppMethodBeat.i(151186);
        if (aVar == null || !(aVar instanceof com.tencent.mm.roomsdk.a.b.c) || (aek = (aek) this.rr.iLL.iLR) == null) {
            AppMethodBeat.o(151186);
            return aVar;
        }
        b.C0499b bVar = new b.C0499b();
        bVar.q(aek.KHx);
        com.tencent.mm.roomsdk.a.b.c cVar = (com.tencent.mm.roomsdk.a.b.c) aVar;
        cVar.chatroomName = aek.jHa;
        cVar.dRN = bVar.grX.size();
        cVar.dSU = bVar.grX;
        cVar.grX = bVar.grX;
        cVar.dSX = bVar.dSX;
        cVar.grY = bVar.grY;
        cVar.dSZ = bVar.dSZ;
        cVar.grZ = bVar.grZ;
        cVar.dTa = bVar.dTa;
        AppMethodBeat.o(151186);
        return cVar;
    }
}
