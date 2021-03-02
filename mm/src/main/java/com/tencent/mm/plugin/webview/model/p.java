package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.btn;

public final class p extends q implements m {
    private i heq;
    public final d rr;

    public p(String str) {
        AppMethodBeat.i(78885);
        d.a aVar = new d.a();
        aVar.iLN = new btm();
        aVar.iLO = new btn();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_getrandomavatar";
        aVar.funcId = 2785;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((btm) this.rr.iLK.iLR).dNI = str;
        AppMethodBeat.o(78885);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78886);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78886);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 2785;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78887);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78887);
        return dispatch;
    }
}
