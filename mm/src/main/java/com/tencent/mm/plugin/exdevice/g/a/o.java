package com.tencent.mm.plugin.exdevice.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.elz;
import com.tencent.mm.protocal.protobuf.ema;
import com.tencent.mm.sdk.platformtools.Log;

public final class o extends q implements m {
    private i callback = null;
    public int opType;
    public int rCU;
    public int rCV;
    private d rr = null;

    public o(int i2, int i3) {
        AppMethodBeat.i(23540);
        this.opType = i2;
        this.rCU = i3;
        d.a aVar = new d.a();
        aVar.iLN = new elz();
        aVar.iLO = new ema();
        aVar.uri = "/cgi-bin/mmbiz-bin/rank/updateranksetting";
        aVar.funcId = 1044;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        elz elz = (elz) this.rr.iLK.iLR;
        elz.dYx = this.opType;
        elz.cSx = this.rCU;
        AppMethodBeat.o(23540);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1044;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(23541);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(23541);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(23542);
        Log.d("MicroMsg.NetSceneUpdateRankSetting", "hy: scene end. errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        if (i3 == 0 && i4 == 0) {
            this.rCV = ((ema) this.rr.iLL.iLR).cSx;
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(23542);
    }
}
