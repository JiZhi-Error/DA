package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;

public final class h extends q implements m {
    private i heq;
    private final d rr;

    public h(int i2) {
        AppMethodBeat.i(150913);
        d.a aVar = new d.a();
        aVar.iLN = new afa();
        aVar.iLO = new afb();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_delavatar";
        aVar.funcId = 2700;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((afa) this.rr.iLK.iLR).Lqj = i2;
        AppMethodBeat.o(150913);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150914);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(150914);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2700;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150915);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150915);
        return dispatch;
    }
}
