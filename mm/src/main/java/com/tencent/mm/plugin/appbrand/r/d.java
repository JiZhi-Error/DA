package com.tencent.mm.plugin.appbrand.r;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.protocal.protobuf.ceu;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.sdk.platformtools.Log;

public final class d extends e implements m {
    public d(String str, String str2, String str3, int i2, int i3, int i4, int i5, e.a<e> aVar) {
        super(str, str2, str3, i2, i3, i4, i5, aVar);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.r.e
    public final d.a id(boolean z) {
        AppMethodBeat.i(227219);
        Log.d("MicroMsg.webview.NetSceneJSOperateImportantWxData", "getReqRespBuidler");
        d.a aVar = new d.a();
        aVar.iLN = new ceu();
        aVar.iLO = new cev();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata-vip";
        aVar.funcId = 1912;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        AppMethodBeat.o(227219);
        return aVar;
    }
}
