package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae extends q implements m {
    private i callback;
    private final d rr;

    public ae(int i2) {
        AppMethodBeat.i(150963);
        d.a aVar = new d.a();
        aVar.iLN = new ckd();
        aVar.iLO = new cke();
        aVar.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        aVar.funcId = 281;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((ckd) this.rr.iLK.iLR).OpCode = i2;
        AppMethodBeat.o(150963);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 281;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(150964);
        Log.d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(150964);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(150965);
        if (!(i3 == 0 && i4 == 0)) {
            Log.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.callback != null) {
            this.callback.onSceneEnd(i3, i4, str, this);
        }
        AppMethodBeat.o(150965);
    }
}
