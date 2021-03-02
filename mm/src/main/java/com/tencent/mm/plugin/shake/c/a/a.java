package com.tencent.mm.plugin.shake.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends q implements m {
    private i callback;
    private final d rr;

    public a(String str, String str2) {
        AppMethodBeat.i(28179);
        d.a aVar = new d.a();
        aVar.iLN = new tp();
        aVar.iLO = new tq();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        aVar.funcId = 1252;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        tp tpVar = (tp) this.rr.iLK.iLR;
        tpVar.pRX = str;
        tpVar.eaP = str2;
        AppMethodBeat.o(28179);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1252;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28180);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28180);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28181);
        Log.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = " + getType() + " errType = " + i3 + " errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28181);
    }
}
