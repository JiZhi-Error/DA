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
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class w extends q implements m, a.b {
    private final int IXV;
    public cdw IXW;
    private i heq;
    public final d rr;

    public w(cdw cdw, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, b bVar, int i2, LinkedList<cey> linkedList, int i3) {
        AppMethodBeat.i(210976);
        Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", str, str3, str4, str5, str6, str7, str8, Integer.valueOf(i2));
        this.IXW = cdw;
        this.IXV = i3;
        d.a aVar = new d.a();
        aVar.iLN = new cej();
        aVar.iLO = new cek();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        aVar.funcId = 1096;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        cej cej = (cej) this.rr.iLK.iLR;
        cej.url = str;
        cej.Mjy = str2;
        cej.dNI = str3;
        cej.Mjs = str4;
        cej.dmc = str5;
        cej.Mju = str6;
        cej.signature = str7;
        cej.Mjv = str8;
        cej.Mjx = i2;
        cej.Mjw = bVar;
        cej.MjC = linkedList;
        AppMethodBeat.o(210976);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78907);
        Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78907);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1096;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78908);
        Log.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78908);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b
    public final int fZu() {
        return this.IXV;
    }
}
