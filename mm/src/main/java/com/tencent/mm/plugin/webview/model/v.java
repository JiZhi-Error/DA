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
import com.tencent.mm.protocal.protobuf.ceh;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.sdk.platformtools.Log;

public final class v extends q implements m, a.b {
    public a.AbstractC1996a IXT;
    private final int IXV;
    private i heq;
    private final d rr;

    public v(a.AbstractC1996a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, byte[] bArr, int i2) {
        AppMethodBeat.i(210975);
        Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", str, str3, str4, str5, str6, str7, str8);
        this.IXT = aVar;
        this.IXV = i2;
        d.a aVar2 = new d.a();
        aVar2.iLN = new ceh();
        aVar2.iLO = new cei();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        aVar2.funcId = 1094;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        ceh ceh = (ceh) this.rr.iLK.iLR;
        ceh.url = str;
        ceh.Mjy = str2;
        ceh.dNI = str3;
        ceh.Mjs = str4;
        ceh.dmc = str5;
        ceh.Mju = str6;
        ceh.signature = str7;
        ceh.Mjv = str8;
        ceh.Mjw = b.cD(bArr);
        AppMethodBeat.o(210975);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78904);
        Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78904);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1094;
    }

    public final cei gcz() {
        if (this.rr == null) {
            return null;
        }
        return (cei) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78905);
        Log.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78905);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b
    public final int fZu() {
        return this.IXV;
    }
}
