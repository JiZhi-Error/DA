package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cku;
import com.tencent.mm.protocal.protobuf.ckv;
import com.tencent.mm.sdk.platformtools.Log;

public final class l extends q implements m {
    String appId;
    private i heq;
    String laS;
    final d rr;

    public l(String str, String str2) {
        AppMethodBeat.i(78873);
        this.appId = str;
        this.laS = str2;
        d.a aVar = new d.a();
        aVar.iLN = new cku();
        aVar.iLO = new ckv();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        aVar.funcId = 1035;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cku cku = (cku) this.rr.iLK.iLR;
        cku.dNI = str;
        cku.Mqw = str2;
        Log.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", str, str2);
        AppMethodBeat.o(78873);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78874);
        Log.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", Integer.valueOf(i3), Integer.valueOf(i4));
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78874);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1035;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78875);
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78875);
        return dispatch;
    }
}
