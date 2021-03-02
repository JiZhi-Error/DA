package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class u extends q implements m, a.b {
    public a.AbstractC1996a IXT;
    private final int IXV;
    private i heq;
    public String nKc;
    public final d rr;

    public u(a.AbstractC1996a aVar, String str, String str2, String str3, LinkedList<String> linkedList, LinkedList<String> linkedList2, String str4, String str5, String str6, String str7, int i2, String str8, int i3, int i4) {
        AppMethodBeat.i(210974);
        Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", str, str3, str4, str5, str6, str7);
        this.IXT = aVar;
        this.nKc = str;
        this.IXV = i3;
        d.a aVar2 = new d.a();
        aVar2.iLN = new cef();
        aVar2.iLO = new ceg();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        aVar2.funcId = 1093;
        aVar2.iLP = 0;
        aVar2.respCmdId = 0;
        this.rr = aVar2.aXF();
        cef cef = (cef) this.rr.iLK.iLR;
        cef.url = str;
        cef.Mjy = str2;
        cef.dNI = str3;
        cef.MjM = linkedList;
        cef.MjO = linkedList2;
        cef.dmc = str4;
        cef.Mju = str5;
        cef.signature = str6;
        cef.Mjv = str7;
        cef.scene = i2;
        cef.MjN = str8;
        cef.HTO = i4;
        AppMethodBeat.o(210974);
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(78901);
        Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i3), Integer.valueOf(i4), str);
        this.heq.onSceneEnd(i3, i4, str, this);
        AppMethodBeat.o(78901);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return 1093;
    }

    public final ceg gcy() {
        if (this.rr == null) {
            return null;
        }
        return (ceg) this.rr.iLL.iLR;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(g gVar, i iVar) {
        AppMethodBeat.i(78902);
        Log.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.heq = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(78902);
        return dispatch;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.jsapi.a.b
    public final int fZu() {
        return this.IXV;
    }
}
