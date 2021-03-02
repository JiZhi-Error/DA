package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.protocal.protobuf.efs;
import com.tencent.mm.sdk.platformtools.Log;

public final class i extends q implements m {
    public int GQZ;
    private com.tencent.mm.ak.i callback;
    public int mStatus;
    private final d rr;

    public i(int i2) {
        AppMethodBeat.i(29782);
        d.a aVar = new d.a();
        aVar.iLN = new efr();
        aVar.iLO = new efs();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopvoiceprint";
        aVar.funcId = 615;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((efr) this.rr.iLK.iLR).dKy = i2;
        AppMethodBeat.o(29782);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(29783);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29783);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 615;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29784);
        Log.d("MicroMsg.NetSceneSwitchOpVoicePrint", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        efs efs = (efs) ((d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            this.mStatus = efs.MKH;
            this.GQZ = efs.NfK;
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29784);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29784);
    }
}
