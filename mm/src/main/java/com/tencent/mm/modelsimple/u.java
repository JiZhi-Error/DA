package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dht;
import com.tencent.mm.protocal.protobuf.dhu;

public final class u extends q implements m {
    private i callback;
    public int jkg = 1;
    public int jkh;
    private d rr;

    public u(int i2) {
        AppMethodBeat.i(134182);
        d.a aVar = new d.a();
        aVar.iLN = new dht();
        aVar.iLO = new dhu();
        aVar.uri = "/cgi-bin/micromsg-bin/queryhaspasswd";
        aVar.funcId = 255;
        aVar.iLP = 132;
        aVar.respCmdId = 1000000132;
        this.rr = aVar.aXF();
        ((dht) this.rr.iLK.iLR).Scene = i2;
        this.jkh = i2;
        AppMethodBeat.o(134182);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(134183);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(134183);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 255;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(134184);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(134184);
    }
}
