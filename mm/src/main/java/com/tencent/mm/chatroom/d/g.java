package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.chatroom.ui.ChatroomInfoUI;
import com.tencent.mm.model.v;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.cbr;
import com.tencent.mm.protocal.protobuf.con;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.roomsdk.a.a;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class g extends a implements m {
    private i callback = null;
    private String chatroomName = null;
    private int dRN = 0;
    public final List<String> dSU;
    private final List<String> dSX;
    private final List<String> dSZ;
    private final List<String> dTa;
    private final List<String> grX;
    private final List<String> grY;
    private final List<String> grZ;
    private final d rr;

    public g(String str, List<String> list, String str2, Object obj) {
        AppMethodBeat.i(194023);
        d.a aVar = new d.a();
        aVar.iLN = new cs();
        aVar.iLO = new ct();
        aVar.uri = "/cgi-bin/micromsg-bin/addchatroommember";
        aVar.funcId = 120;
        aVar.iLP = 36;
        aVar.respCmdId = 1000000036;
        this.rr = aVar.aXF();
        cs csVar = (cs) this.rr.iLK.iLR;
        csVar.KGR = z.Su(str);
        this.chatroomName = str;
        LinkedList<con> linkedList = new LinkedList<>();
        for (String str3 : list) {
            con con = new con();
            con.Lqp = z.Su(str3);
            linkedList.add(con);
        }
        csVar.KGQ = linkedList;
        csVar.gsq = linkedList.size();
        this.grX = new ArrayList();
        this.dSX = new LinkedList();
        this.grY = new LinkedList();
        this.dSZ = new LinkedList();
        this.dTa = new LinkedList();
        this.grZ = new ArrayList();
        this.dSU = list;
        csVar.KGT = str2;
        if (obj instanceof ChatroomInfoUI.LocalHistoryInfo) {
            Log.i("MicroMsg.NetSceneAddChatRoomMember", "localHistoryInfo:%s", obj.toString());
            csVar.KGU = new cbr();
            csVar.KGU.fileid = ((ChatroomInfoUI.LocalHistoryInfo) obj).fileid;
            csVar.KGU.aeskey = ((ChatroomInfoUI.LocalHistoryInfo) obj).aeskey;
            csVar.KGU.filemd5 = ((ChatroomInfoUI.LocalHistoryInfo) obj).filemd5;
            csVar.KGU.guR = ((ChatroomInfoUI.LocalHistoryInfo) obj).guR;
            csVar.KGU.guS = ((ChatroomInfoUI.LocalHistoryInfo) obj).guS;
        }
        AppMethodBeat.o(194023);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(12456);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12456);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 120;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12457);
        Log.i("MicroMsg.NetSceneAddChatRoomMember", "onSceneEnd: errType = " + i3 + " errCode = " + i4 + " errMsg = " + str);
        updateDispatchId(i2);
        cs csVar = (cs) this.rr.iLK.iLR;
        ct ctVar = (ct) this.rr.iLL.iLR;
        this.dRN = ctVar.gsq;
        T(ctVar.KGQ);
        this.callback.onSceneEnd(i3, i4, str, this);
        if (i3 == 0 && i4 == 0) {
            v.a(z.a(csVar.KGR), ctVar);
        }
        AppMethodBeat.o(12457);
    }

    private int T(List<coo> list) {
        AppMethodBeat.i(194024);
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int i4 = list.get(i3).MuH;
            if (i4 == 0) {
                this.grX.add(z.a(list.get(i3).Lqp));
            } else if (i4 == 3) {
                Log.d("MicroMsg.NetSceneAddChatRoomMember", " blacklist : " + list.get(i3).Lqp);
                this.grY.add(z.a(list.get(i3).Lqp));
                i2 = -22;
            } else if (i4 == 1) {
                Log.d("MicroMsg.NetSceneAddChatRoomMember", " not user : " + list.get(i3).Lqp);
                this.dSZ.add(z.a(list.get(i3).Lqp));
                i2 = -4;
            } else if (i4 == 2) {
                Log.d("MicroMsg.NetSceneAddChatRoomMember", " invalid username : " + list.get(i3).Lqp);
                i2 = -14;
                this.dSX.add(z.a(list.get(i3).Lqp));
            } else if (i4 == 4) {
                Log.d("MicroMsg.NetSceneAddChatRoomMember", " verify user : " + list.get(i3).Lqp);
                i2 = -44;
                this.dTa.add(z.a(list.get(i3).Lqp));
            } else if (i4 != 5) {
                if (i4 == 6) {
                    this.grZ.add(z.a(list.get(i3).Lqp));
                } else {
                    Log.w("MicroMsg.NetSceneAddChatRoomMember", "unknown member status : status = ".concat(String.valueOf(i4)));
                }
            }
        }
        AppMethodBeat.o(194024);
        return i2;
    }

    @Override // com.tencent.mm.roomsdk.a.a
    public final com.tencent.mm.roomsdk.a.b.a a(com.tencent.mm.roomsdk.a.b.a aVar) {
        if (!(aVar instanceof c)) {
            return aVar;
        }
        c cVar = (c) aVar;
        cVar.chatroomName = this.chatroomName;
        cVar.dSX = this.dSX;
        cVar.dRN = this.dRN;
        cVar.dSU = this.dSU;
        cVar.grY = this.grY;
        cVar.grX = this.grX;
        cVar.dSZ = this.dSZ;
        cVar.grZ = this.grZ;
        cVar.dTa = this.dTa;
        return cVar;
    }
}
