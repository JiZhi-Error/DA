package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.protocal.protobuf.drk;

public final class ab extends q implements m {
    private i heq;
    public final d rr;

    public ab(String str, String str2, String str3, String str4, String str5, String str6) {
        AppMethodBeat.i(210977);
        d.a aVar = new d.a();
        aVar.iLN = new drj();
        aVar.iLO = new drk();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        aVar.funcId = 1388;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        drj drj = (drj) this.rr.iLK.iLR;
        drj.dNI = str;
        drj.scope = str2;
        drj.state = str3;
        drj.MTR = str6;
        drj.MTY = str4;
        drj.MTZ = str5;
        AppMethodBeat.o(210977);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78928);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78928);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1388;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78929);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78929);
        return dispatch;
    }
}
