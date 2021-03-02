package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bkb;
import com.tencent.mm.protocal.protobuf.bkc;
import com.tencent.mm.sdk.platformtools.Log;

public final class x extends q implements m {
    private i callback;
    private String pUi = "";
    private final d rr;

    public x() {
        AppMethodBeat.i(112828);
        d.a aVar = new d.a();
        aVar.iLN = new bkb();
        aVar.iLO = new bkc();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardconfiginfo";
        aVar.funcId = 1046;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        AppMethodBeat.o(112828);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1046;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(112829);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112829);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(112830);
        Log.i("MicroMsg.NetSceneGetCardConfigInfo", "onGYNetEnd, errType = " + i3 + " errCode = " + i4);
        if (i3 == 0 && i4 == 0) {
            this.pUi = ((bkc) this.rr.iLL.iLR).pTY;
            com.tencent.mm.kernel.g.aAh().azQ().set(282885, this.pUi);
        }
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(112830);
    }
}
