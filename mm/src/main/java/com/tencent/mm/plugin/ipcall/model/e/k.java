package com.tencent.mm.plugin.ipcall.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dfo;
import com.tencent.mm.protocal.protobuf.dfp;
import com.tencent.mm.sdk.platformtools.Log;

public final class k extends q implements m {
    private i callback = null;
    private d rr = null;
    public dfo yrI = null;
    public dfp yrJ = null;

    public k(int i2, long j2, long j3) {
        AppMethodBeat.i(25481);
        d.a aVar = new d.a();
        aVar.iLN = new dfo();
        aVar.iLO = new dfp();
        aVar.funcId = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        this.yrI = (dfo) this.rr.iLK.iLR;
        this.yrI.LsZ = i2;
        this.yrI.Lta = j2;
        this.yrI.MKi = j3;
        AppMethodBeat.o(25481);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 726;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(25482);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(25482);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(25483);
        Log.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.yrJ = (dfp) ((d) sVar).iLL.iLR;
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(25483);
    }
}
