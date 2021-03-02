package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.sdk.platformtools.Log;

public final class m extends q implements com.tencent.mm.network.m {
    private i callback;
    public final d hhm;

    public m(String str, String str2) {
        AppMethodBeat.i(78876);
        d.a aVar = new d.a();
        aVar.iLN = new bih();
        aVar.iLO = new bii();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        aVar.funcId = 1097;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.hhm = aVar.aXF();
        bih bih = (bih) this.hhm.iLK.iLR;
        bih.dNI = str;
        bih.signature = str2;
        AppMethodBeat.o(78876);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1097;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78877);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.hhm, this);
        AppMethodBeat.o(78877);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78878);
        Log.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i3 + ", errCode = " + i4);
        this.callback.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78878);
    }
}
