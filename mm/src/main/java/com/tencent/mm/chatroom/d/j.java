package com.tencent.mm.chatroom.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.v;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

public final class j extends q implements m {
    private i callback;
    public List<String> dSU;
    private d rr;

    public j(String str, List<String> list, int i2) {
        AppMethodBeat.i(12467);
        d.a aVar = new d.a();
        aVar.iLN = new aff();
        aVar.iLO = new afg();
        aVar.uri = "/cgi-bin/micromsg-bin/delchatroommember";
        aVar.funcId = 179;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        aff aff = (aff) this.rr.iLK.iLR;
        aff.KGO = str;
        LinkedList<afp> linkedList = new LinkedList<>();
        for (String str2 : list) {
            afp afp = new afp();
            afp.Lqp = z.Su(str2);
            linkedList.add(afp);
        }
        aff.KGQ = linkedList;
        aff.gsq = linkedList.size();
        aff.Scene = i2;
        this.dSU = list;
        AppMethodBeat.o(12467);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(12468);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(12468);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 179;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(12469);
        updateDispatchId(i2);
        Log.d("MicroMsg.NetSceneDelChatRoomMember", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        aff aff = (aff) this.rr.iLK.iLR;
        afg afg = (afg) this.rr.iLL.iLR;
        if (this.rr.iLL.getRetCode() != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(12469);
            return;
        }
        v.a(aff.KGO, afg);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(12469);
    }
}
