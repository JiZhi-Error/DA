package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public final class e extends q implements m {
    private i callback;
    final d rr;

    public e(String str) {
        AppMethodBeat.i(89773);
        d.a aVar = new d.a();
        aVar.iLN = new chp();
        aVar.iLO = new chq();
        aVar.uri = "/cgi-bin/micromsg-bin/getroommember";
        aVar.funcId = 377;
        aVar.iLP = 184;
        aVar.respCmdId = 1000000184;
        this.rr = aVar.aXF();
        ((chp) this.rr.iLK.iLR).jfM = str;
        Log.d("MicroMsg.NetSceneLbsRoomGetMember", "Req: roomName:".concat(String.valueOf(str)));
        AppMethodBeat.o(89773);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(89774);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(89774);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 377;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(89775);
        Log.d("MicroMsg.NetSceneLbsRoomGetMember", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        chq chq = (chq) this.rr.iLL.iLR;
        if (i3 != 0) {
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(89775);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < chq.KGQ.size(); i5++) {
            com.tencent.mm.aj.i iVar = new com.tencent.mm.aj.i();
            iVar.username = chq.KGQ.get(i5).UserName;
            iVar.iKX = chq.KGQ.get(i5).Lir;
            iVar.iKW = chq.KGQ.get(i5).Lis;
            iVar.fv(true);
            arrayList.add(iVar);
        }
        p.aYB().av(arrayList);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(89775);
    }
}
