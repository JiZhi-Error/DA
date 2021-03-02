package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dgs;
import com.tencent.mm.protocal.protobuf.dgt;

public final class z extends q implements m {
    private i heq;
    public final d rr;

    public z(String str) {
        AppMethodBeat.i(78921);
        d.a aVar = new d.a();
        aVar.iLN = new dgs();
        aVar.iLO = new dgt();
        aVar.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize";
        aVar.funcId = 2543;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dgs) this.rr.iLK.iLR).Mzp = str;
        AppMethodBeat.o(78921);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78922);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78922);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2543;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78923);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78923);
        return dispatch;
    }
}
