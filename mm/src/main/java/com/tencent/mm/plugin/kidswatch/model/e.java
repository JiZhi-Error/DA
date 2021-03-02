package com.tencent.mm.plugin.kidswatch.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cgn;
import com.tencent.mm.protocal.protobuf.cgo;

public final class e extends q implements m {
    private i callback;
    private final d iUB;

    public e(String str) {
        AppMethodBeat.i(256398);
        d.a aVar = new d.a();
        cgn cgn = new cgn();
        cgo cgo = new cgo();
        aVar.iLN = cgn;
        aVar.iLO = cgo;
        aVar.uri = "/cgi-bin/micromsg-bin/extdeviceloginconfirmcancel";
        aVar.funcId = 973;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        cgn.LtA = str;
        this.iUB = aVar.aXF();
        AppMethodBeat.o(256398);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 973;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(256399);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.iUB, this);
        AppMethodBeat.o(256399);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(256400);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(256400);
    }
}
