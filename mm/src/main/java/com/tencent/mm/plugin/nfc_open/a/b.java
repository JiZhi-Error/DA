package com.tencent.mm.plugin.nfc_open.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.adx;
import com.tencent.mm.protocal.protobuf.ady;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends q implements m {
    private i callback;
    public d rr;

    public b(int i2) {
        AppMethodBeat.i(26686);
        d.a aVar = new d.a();
        aVar.iLN = new adx();
        aVar.iLO = new ady();
        aVar.uri = "/cgi-bin/mmpay-bin/cpucardgetconfig2";
        aVar.funcId = 1561;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((adx) this.rr.iLK.iLR).version = i2;
        AppMethodBeat.o(26686);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1561;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(26687);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(26687);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(26688);
        Log.d("MicroMsg.NetSceneCpuCardGetConfig", "onGYNetEnd errtype:" + i3 + " errcode:" + i4 + " errMsg:" + str);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(26688);
    }
}
