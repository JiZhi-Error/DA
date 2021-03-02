package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bxk;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends q implements m {
    String GQM = "";
    int GQN = 0;
    String GQO = "";
    private i callback;
    private final com.tencent.mm.ak.d rr;

    public d(int i2, String str) {
        AppMethodBeat.i(29759);
        d.a aVar = new d.a();
        aVar.iLN = new bxk();
        aVar.iLO = new bxl();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoiceprintresource";
        aVar.funcId = 611;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        bxk bxk = (bxk) this.rr.iLK.iLR;
        Log.i("MicroMsg.NetSceneGetVoicePrintResource", "sceneType %d %s", Integer.valueOf(i2), str);
        bxk.Mdl = i2;
        bxk.Mdm = str;
        AppMethodBeat.o(29759);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(29760);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(29760);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 611;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(29761);
        Log.d("MicroMsg.NetSceneGetVoicePrintResource", "onGYNetEnd  errType:" + i3 + " errCode:" + i4);
        bxl bxl = (bxl) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        if (i3 == 0 || i4 == 0) {
            if (bxl.Mdn != null) {
                this.GQM = new String(bxl.Mdn.MSr.getBufferToBytes());
                this.GQN = bxl.Mdn.MPS;
                Log.d("MicroMsg.NetSceneGetVoicePrintResource", "vertify resid %d mtext %s", Integer.valueOf(this.GQN), this.GQM);
            } else {
                Log.e("MicroMsg.NetSceneGetVoicePrintResource", "resp ResourceData null ");
            }
            this.callback.onSceneEnd(i3, i4, str, this);
            AppMethodBeat.o(29761);
            return;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(29761);
    }
}
