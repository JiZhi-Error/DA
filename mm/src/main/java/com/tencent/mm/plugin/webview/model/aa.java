package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.k.b;
import com.tencent.mm.protocal.protobuf.dgq;
import com.tencent.mm.protocal.protobuf.dgr;
import java.util.LinkedList;

public final class aa extends q implements m {
    private i heq;
    private final d rr;
    private long startTime = 0;

    public aa(int i2, String str, LinkedList<String> linkedList, int i3) {
        AppMethodBeat.i(78924);
        d.a aVar = new d.a();
        aVar.iLN = new dgq();
        aVar.iLO = new dgr();
        aVar.uri = "/cgi-bin/mmbiz-bin/qrconnect_authorize_confirm";
        aVar.funcId = 1137;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        dgq dgq = (dgq) this.rr.iLK.iLR;
        dgq.Mzq = i2;
        dgq.Mzp = str;
        dgq.Mzr = linkedList;
        dgq.Lqj = i3;
        AppMethodBeat.o(78924);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78925);
        this.heq.onSceneEnd(i3, i4, str, this);
        b.INSTANCE.aO(4, (int) (System.currentTimeMillis() - this.startTime), i4);
        AppMethodBeat.o(78925);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1137;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78926);
        this.startTime = System.currentTimeMillis();
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78926);
        return dispatch;
    }
}
