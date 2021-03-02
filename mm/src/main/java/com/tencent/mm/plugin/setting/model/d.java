package com.tencent.mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.agd;
import com.tencent.mm.protocal.protobuf.age;

public final class d extends q implements m {
    public final String appId;
    private i callback;
    private final int scene;

    public d(String str, int i2) {
        this.appId = str;
        this.scene = i2;
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1127;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(73764);
        this.callback = iVar;
        d.a aVar = new d.a();
        agd agd = new agd();
        agd.dNI = this.appId;
        agd.eaQ = this.scene;
        aVar.iLN = agd;
        aVar.uri = "/cgi-bin/mmbiz-bin/deluserauth";
        aVar.iLO = new age();
        aVar.funcId = getType();
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        int dispatch = dispatch(gVar, aVar.aXF(), this);
        AppMethodBeat.o(73764);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(73765);
        age age = (age) ((com.tencent.mm.ak.d) sVar).iLL.iLR;
        this.callback.onSceneEnd(i3, age.Lqs.dIZ, age.Lqs.dJa, this);
        AppMethodBeat.o(73765);
    }
}
