package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfs;
import com.tencent.mm.protocal.protobuf.dft;
import com.tencent.mm.sdk.platformtools.Log;

public final class n extends q implements m {
    private i callback = null;
    private d rr = null;
    public dfs yrO = null;
    private dft yrP = null;

    public n(int i2, long j2, long j3, int i3) {
        AppMethodBeat.i(25490);
        d.a aVar = new d.a();
        aVar.iLN = new dfs();
        aVar.iLO = new dft();
        aVar.funcId = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        long currentTimeMillis = System.currentTimeMillis();
        this.yrO = (dfs) this.rr.iLK.iLR;
        this.yrO.xNH = z.aTY();
        this.yrO.LsZ = i2;
        this.yrO.Lta = j2;
        this.yrO.MKi = j3;
        this.yrO.oTW = i3;
        this.yrO.MKf = currentTimeMillis;
        Log.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(25490);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 723;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25491);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25491);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25492);
        Log.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrP = (dft) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25492);
    }
}
