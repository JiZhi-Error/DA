package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bmx;
import com.tencent.mm.protocal.protobuf.bmy;
import com.tencent.mm.sdk.platformtools.Log;

public final class j extends q implements m {
    private i heq;
    final d jof;

    public j(b bVar) {
        AppMethodBeat.i(151081);
        d.a aVar = new d.a();
        bmx bmx = new bmx();
        bmx.KCO = 0;
        bmx.LVy = bVar;
        aVar.iLN = bmx;
        aVar.iLO = new bmy();
        aVar.uri = "/cgi-bin/mmbiz-bin/geteventsampleconf";
        aVar.funcId = 1126;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.jof = aVar.aXF();
        AppMethodBeat.o(151081);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1126;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(151082);
        Log.i("MicroMsg.NetSceneUpdateEventConfig", "start update event config");
        setHasCallbackToQueue(true);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.jof, this);
        AppMethodBeat.o(151082);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(151083);
        Log.i("MicroMsg.NetSceneUpdateEventConfig", "onGYNetEnd errType: %d, errCode: %d, errMsg %s, IReqResp %s", Integer.valueOf(i3), Integer.valueOf(i4), str, sVar.toString());
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(151083);
    }
}
