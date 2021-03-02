package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.Log;

public final class c extends q implements m {
    private i callback;
    private d rr;

    public c(int i2, String str) {
        AppMethodBeat.i(28277);
        d.a aVar = new d.a();
        aVar.iLN = new cvi();
        aVar.iLO = new cvj();
        aVar.uri = "/cgi-bin/mmoctv/optvhist";
        aVar.funcId = 1740;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cvi cvi = (cvi) this.rr.iLK.iLR;
        cvi.him = i2;
        cvi.MAK = str;
        AppMethodBeat.o(28277);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(28278);
        Log.i("MicroMsg.NetSceneOpTvHist", "onGYNetEnd [%d,%d]", Integer.valueOf(i3), Integer.valueOf(i4));
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(28278);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1740;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(28279);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(28279);
        return dispatch;
    }
}
