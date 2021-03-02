package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.aed;
import com.tencent.mm.protocal.protobuf.aee;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class i extends a implements m {
    private com.tencent.mm.ak.i callback;
    public int dSV;
    public String dSW;
    public final List<String> dSX;
    public final List<String> dSZ;
    public List<String> dTa;
    public List<String> dTb;
    public final List<String> grY;
    private final d rr;

    public i(String str, List<String> list) {
        this(str, list, null, null);
        AppMethodBeat.i(12461);
        AppMethodBeat.o(12461);
    }

    public i(String str, List<String> list, String str2, String str3) {
        AppMethodBeat.i(194025);
        this.dSV = 0;
        String str4 = "";
        if (list != null && list.size() > 0) {
            str4 = list.get(0);
        }
        Log.d("MicroMsg.NetSceneCreateChatRoom", "topic : " + str + " size : " + list.size() + " username : " + str4);
        d.a aVar = new d.a();
        aVar.iLN = new aed();
        aVar.iLO = new aee();
        aVar.uri = "/cgi-bin/micromsg-bin/createchatroom";
        aVar.funcId = 119;
        aVar.iLP = 37;
        aVar.respCmdId = 1000000037;
        this.rr = aVar.aXF();
        aed aed = (aed) this.rr.iLK.iLR;
        aed.Lpx = z.Su(str);
        LinkedList<con> linkedList = new LinkedList<>();
        for (String str5 : list) {
            con con = new con();
            con.Lqp = z.Su(str5);
            linkedList.add(con);
        }
        aed.KGQ = linkedList;
        aed.gsq = linkedList.size();
        aed.jfi = str2;
        aed.Lpz = str3;
        this.dSX = new LinkedList();
        this.grY = new LinkedList();
        this.dSZ = new LinkedList();
        this.dTa = new LinkedList();
        this.dTb = new LinkedList();
        this.dSW = "";
        AppMethodBeat.o(194025);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(12462);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12462);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 119;
    }

    private static boolean a(aee aee) {
        as a2;
        AppMethodBeat.i(12463);
        if (!z.a(aee.KGR).toLowerCase().endsWith("@chatroom") || aee.gsq == 0) {
            Log.e("MicroMsg.NetSceneCreateChatRoom", "CreateChatroom: room:[" + aee.KGR + "] listCnt:" + aee.gsq);
            AppMethodBeat.o(12463);
            return false;
        }
        as asVar = new as();
        asVar.setNickname(z.a(aee.Lpx));
        asVar.BF(z.a(aee.LpA));
        asVar.BG(z.a(aee.LpB));
        asVar.setUsername(z.a(aee.KGR));
        bv aSN = ((l) com.tencent.mm.kernel.g.af(l.class)).aSN();
        if (!aSN.bjN(asVar.field_username)) {
            aSN.ap(asVar);
        }
        com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
        iVar.username = asVar.field_username;
        iVar.iKX = aee.Lir;
        iVar.iKW = aee.Lis;
        iVar.fuz = 3;
        iVar.fv(false);
        iVar.cSx = -1;
        p.aYB().b(iVar);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aee.KGQ.size(); i2++) {
            if (aee.KGQ.get(i2).MuH == 0) {
                as Kn = aSN.Kn(z.a(aee.KGQ.get(i2).Lqp));
                if (((int) Kn.gMZ) != 0) {
                    Kn.aqP();
                    aSN.c(Kn.field_username, Kn);
                    a2 = Kn;
                } else {
                    a2 = v.a(Kn, aee.KGQ.get(i2));
                    aSN.ap(a2);
                }
                arrayList.add(a2.field_username);
            }
        }
        if (!arrayList.contains(com.tencent.mm.model.z.aTY())) {
            arrayList.add(com.tencent.mm.model.z.aTY());
            Log.d("MicroMsg.NetSceneCreateChatRoom", "respon has not self add one " + arrayList.contains(com.tencent.mm.model.z.aTY()));
        }
        boolean a3 = v.a(asVar.field_username, arrayList, com.tencent.mm.model.z.aTY());
        AppMethodBeat.o(12463);
        return a3;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12464);
        Log.d("MicroMsg.NetSceneCreateChatRoom", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        aee aee = (aee) this.rr.iLL.iLR;
        this.dSW = z.a(aee.KGR);
        int retCode = this.rr.iLL.getRetCode();
        this.dSV = aee.gsq;
        U(aee.KGQ);
        if (!Util.isNullOrNil(this.dSW) && retCode == 0) {
            a(aee);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12464);
    }

    private void U(List<coo> list) {
        AppMethodBeat.i(12465);
        for (int i2 = 0; i2 < list.size(); i2++) {
            int i3 = list.get(i2).MuH;
            if (i3 == 0) {
                this.dTb.add(z.a(list.get(i2).Lqp));
            } else if (i3 == 3) {
                Log.d("MicroMsg.NetSceneCreateChatRoom", " blacklist : " + list.get(i2).Lqp);
                this.grY.add(z.a(list.get(i2).Lqp));
            } else if (i3 == 1) {
                Log.d("MicroMsg.NetSceneCreateChatRoom", " not user : " + list.get(i2).Lqp);
                this.dSZ.add(z.a(list.get(i2).Lqp));
            } else if (i3 == 2) {
                Log.d("MicroMsg.NetSceneCreateChatRoom", " invalid username : " + list.get(i2).Lqp);
                this.dSX.add(z.a(list.get(i2).Lqp));
            } else if (i3 == 4) {
                Log.d("MicroMsg.NetSceneCreateChatRoom", " verify user : " + list.get(i2).Lqp);
                this.dTa.add(z.a(list.get(i2).Lqp));
            } else if (!(i3 == 5 || i3 == 6)) {
                Log.w("MicroMsg.NetSceneCreateChatRoom", "unknown member status : status = ".concat(String.valueOf(i3)));
            }
        }
        AppMethodBeat.o(12465);
    }

    @Override // com.tencent.mm.roomsdk.a.a
    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        AppMethodBeat.i(12466);
        if (aVar instanceof c) {
            c cVar = (c) aVar;
            cVar.chatroomName = this.dSW;
            cVar.dSX = this.dSX;
            cVar.dRN = this.dSV;
            cVar.dSU = this.dTb;
            cVar.grX = this.dTb;
            cVar.grY = this.grY;
            cVar.dSZ = this.dSZ;
            cVar.grZ = new LinkedList();
            cVar.dTa = this.dTa;
            AppMethodBeat.o(12466);
            return cVar;
        }
        AppMethodBeat.o(12466);
        return aVar;
    }
}
