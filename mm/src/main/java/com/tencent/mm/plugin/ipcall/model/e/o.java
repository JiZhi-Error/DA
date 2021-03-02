package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfu;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback;
    private d rr = null;
    public dfu yrQ = null;
    public dfv yrR = null;

    public o(int i2, long j2, int i3, long j3, boolean z) {
        AppMethodBeat.i(25493);
        d.a aVar = new d.a();
        aVar.iLN = new dfu();
        aVar.iLO = new dfv();
        aVar.funcId = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        long currentTimeMillis = System.currentTimeMillis();
        this.yrQ = (dfu) this.rr.iLK.iLR;
        this.yrQ.MKC = z.aTY();
        this.yrQ.LsZ = i2;
        this.yrQ.Lta = j2;
        this.yrQ.MKf = currentTimeMillis;
        this.yrQ.MKD = i3;
        this.yrQ.MKi = j3;
        if (!z) {
            this.yrQ.MKE = 0;
        } else {
            this.yrQ.MKE = 1;
        }
        Log.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(this.yrQ.MKE), Long.valueOf(currentTimeMillis));
        AppMethodBeat.o(25493);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 819;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25494);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25494);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25495);
        Log.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrR = (dfv) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(25495);
    }
}
