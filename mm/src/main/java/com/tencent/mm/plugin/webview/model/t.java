package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.sdk.platformtools.Log;

public final class t extends q implements m, a.b {
    public a.AbstractC1996a IXT;
    public String IXU;
    private final int IXV;
    private i heq;
    private final d rr;
    public String url;

    public t(a.AbstractC1996a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, byte[] bArr, int i2, String str9, int i3) {
        AppMethodBeat.i(210973);
        Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", str3, str4, str5, str6, str7, str8, Integer.valueOf(i2), str9);
        this.IXT = aVar;
        this.IXU = str4;
        this.url = str;
        this.IXV = i3;
        d.a aVar2 = new d.a();
        aVar2.iLN = new cdx();
        aVar2.iLO = new cdy();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        aVar2.funcId = 1095;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        cdx cdx = (cdx) this.rr.iLK.iLR;
        cdx.url = str;
        cdx.Mjy = str2;
        cdx.hik = str3;
        cdx.Mjs = str4;
        cdx.dmc = str5;
        cdx.Mju = str6;
        cdx.signature = str7;
        cdx.Mjv = str8;
        cdx.Mjw = b.cD(bArr);
        cdx.Mjx = i2;
        cdx.scope = str9;
        AppMethodBeat.o(210973);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78898);
        Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78898);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1095;
    }

    public final cdx gcw() {
        if (this.rr == null) {
            return null;
        }
        return (cdx) this.rr.iLK.iLR;
    }

    public final cdy gcx() {
        if (this.rr == null) {
            return null;
        }
        return (cdy) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78899);
        Log.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78899);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b
    public final int fZu() {
        return this.IXV;
    }
}
