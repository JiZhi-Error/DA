package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.dfk;
import com.tencent.mm.sdk.platformtools.Log;

public final class h extends q implements m {
    private i callback = null;
    private d rr = null;
    public dfj yrC = null;
    private dfk yrD = null;

    public h(int i2, long j2, long j3) {
        AppMethodBeat.i(25472);
        d.a aVar = new d.a();
        aVar.iLN = new dfj();
        aVar.iLO = new dfk();
        aVar.funcId = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        long currentTimeMillis = System.currentTimeMillis();
        this.yrC = (dfj) this.rr.iLK.iLR;
        this.yrC.LsZ = i2;
        this.yrC.Lta = j2;
        this.yrC.MKi = j3;
        this.yrC.MKf = currentTimeMillis;
        Log.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(25472);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 824;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25473);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25473);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25474);
        Log.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrD = (dfk) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25474);
    }
}
