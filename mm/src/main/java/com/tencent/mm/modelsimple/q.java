package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.protocal.protobuf.bul;

public final class q extends com.tencent.mm.ak.q implements m {
    private i callback;
    public final d iUB;

    public q() {
        AppMethodBeat.i(20635);
        d.a aVar = new d.a();
        aVar.iLN = new buk();
        aVar.iLO = new bul();
        aVar.uri = "/cgi-bin/micromsg-bin/getremind";
        aVar.funcId = 866;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(20635);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(20636);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(20636);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 866;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(20637);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(20637);
    }
}
