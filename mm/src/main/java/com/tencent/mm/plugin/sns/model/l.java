package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bx;
import com.tencent.mm.protocal.protobuf.by;
import com.tencent.mm.protocal.protobuf.cg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class l extends q implements m {
    private LinkedList<cg> DsY;
    public i callback;
    private d rr;

    public l(LinkedList<cg> linkedList) {
        AppMethodBeat.i(95567);
        d.a aVar = new d.a();
        aVar.iLN = new bx();
        aVar.iLO = new by();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.funcId = 1295;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bx bxVar = (bx) this.rr.iLK.iLR;
        bxVar.KFY = linkedList;
        this.DsY = linkedList;
        Log.i("MicroMsg.NetSceneSnsAdDataReport", "report %d ads", Integer.valueOf(bxVar.KFY.size()));
        AppMethodBeat.o(95567);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1295;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(95568);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(95568);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(95569);
        Log.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + i2 + " errType :" + i3 + " errCode: " + i4 + " errMsg :" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(95569);
    }
}
