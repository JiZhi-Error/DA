package com.tencent.mm.plugin.account.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ela;
import com.tencent.mm.protocal.protobuf.elb;

public final class d extends q implements m {
    private i callback;
    private com.tencent.mm.ak.d rr;

    public d(String str) {
        AppMethodBeat.i(109752);
        d.a aVar = new d.a();
        aVar.iLN = new ela();
        aVar.iLO = new elb();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        aVar.funcId = 253;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ela) this.rr.iLK.iLR).Bri = str;
        AppMethodBeat.o(109752);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(109753);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(109753);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 253;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(109754);
        updateDispatchId(i2);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(109754);
    }
}
