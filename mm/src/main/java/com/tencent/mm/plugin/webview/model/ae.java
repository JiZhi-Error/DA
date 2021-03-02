package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckt;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;

public final class ae extends q implements m {
    String appId;
    String dJX;
    private i heq;
    final d rr;

    public ae(String str, String str2, ckt ckt) {
        AppMethodBeat.i(78937);
        this.appId = str;
        this.dJX = str2;
        d.a aVar = new d.a();
        aVar.iLN = new cky();
        aVar.iLO = new ckz();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        aVar.funcId = 1034;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cky cky = (cky) this.rr.iLK.iLR;
        cky.dNI = str;
        cky.Mqx = ckt;
        AppMethodBeat.o(78937);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78938);
        Log.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78938);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1034;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78939);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78939);
        return dispatch;
    }
}
