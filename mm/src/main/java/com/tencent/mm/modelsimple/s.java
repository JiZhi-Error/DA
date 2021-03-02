package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.ckb;
import com.tencent.mm.protocal.protobuf.ckc;
import com.tencent.mm.sdk.platformtools.Log;

public final class s extends q implements m {
    private i callback;
    public final d rr;

    public s() {
        AppMethodBeat.i(150937);
        d.a aVar = new d.a();
        aVar.iLN = new ckb();
        aVar.iLO = new ckc();
        aVar.uri = "/cgi-bin/micromsg-bin/logout";
        aVar.funcId = 282;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ckb) this.rr.iLK.iLR).Scene = 0;
        AppMethodBeat.o(150937);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 282;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150938);
        Log.d("MicroMsg.NetSceneLogout", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150938);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, com.tencent.mm.network.s sVar, byte[] bArr) {
        AppMethodBeat.i(150939);
        if (!(i3 == 0 && i4 == 0)) {
            Log.d("MicroMsg.NetSceneLogout", "logout Error. ");
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(150939);
    }
}
