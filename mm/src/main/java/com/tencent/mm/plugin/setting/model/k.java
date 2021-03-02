package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.cqk;

public final class k extends q implements m {
    public final String CXO;
    public final int CXP;
    private i callback;
    private final String dNI;
    private final int scene;

    public k(String str, String str2, int i2, int i3) {
        this.dNI = str;
        this.CXO = str2;
        this.CXP = i2;
        this.scene = i3;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73776);
        cqk cqk = (cqk) ((d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, cqk.Lqs.dIZ, cqk.Lqs.dJa, this);
        AppMethodBeat.o(73776);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1144;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73777);
        this.callback = iVar;
        d.a aVar = new d.a();
        cqj cqj = new cqj();
        cqj.dNI = this.dNI;
        cqj.MvX = this.CXO;
        cqj.MvY = this.CXP;
        aVar.iLN = cqj;
        aVar.uri = "/cgi-bin/mmbiz-bin/moduserauth";
        aVar.iLO = new cqk();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(73777);
        return dispatch;
    }
}
