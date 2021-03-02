package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dua;
import com.tencent.mm.protocal.protobuf.dub;
import com.tencent.wxmm.v2helper;

public final class i extends q implements m {
    private com.tencent.mm.ak.i callback = null;
    private final d rr;

    public i(dua dua) {
        AppMethodBeat.i(127835);
        d.a aVar = new d.a();
        aVar.iLN = dua;
        aVar.iLO = new dub();
        aVar.uri = "/cgi-bin/micromsg-bin/sendphoto2fbwall";
        aVar.funcId = v2helper.EMethodSetSendToNetworkOff;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(127835);
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, com.tencent.mm.ak.i iVar) {
        AppMethodBeat.i(127836);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(127836);
        return dispatch;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return v2helper.EMethodSetSendToNetworkOff;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(127837);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(127837);
    }
}
