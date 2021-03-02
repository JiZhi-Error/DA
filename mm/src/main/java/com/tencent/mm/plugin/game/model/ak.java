package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bgh;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class ak extends q implements m {
    private i callback;
    public final d hhm;

    public ak(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i2) {
        AppMethodBeat.i(41592);
        d.a aVar = new d.a();
        aVar.iLN = new bgh();
        aVar.iLO = new bgi();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bgh bgh = (bgh) this.hhm.iLK.iLR;
        bgh.xLl = str;
        bgh.LQa = linkedList;
        bgh.LPU = linkedList2;
        bgh.LQb = i2;
        AppMethodBeat.o(41592);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(41593);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(41593);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(41594);
        Log.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(41594);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1328;
    }
}
