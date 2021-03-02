package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ejj;
import com.tencent.mm.protocal.protobuf.ejk;
import com.tencent.mm.sdk.platformtools.Log;

public final class ad extends q implements m {
    private i heq;
    public final d rr;

    public ad(String str, String str2) {
        AppMethodBeat.i(78934);
        d.a aVar = new d.a();
        aVar.iLN = new ejj();
        aVar.iLO = new ejk();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        aVar.funcId = 1142;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ejj ejj = (ejj) this.rr.iLK.iLR;
        ejj.dNI = str;
        ejj.openid = str2;
        AppMethodBeat.o(78934);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78935);
        Log.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78935);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1142;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78936);
        Log.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78936);
        return dispatch;
    }
}
