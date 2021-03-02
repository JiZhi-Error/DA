package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fba;
import com.tencent.mm.protocal.protobuf.fbb;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetRealNameAuthRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/WecoinRealNameAuthResponse;", "token", "", "requestID", "(Ljava/lang/String;Ljava/lang/String;)V", "plugin-wxpay_release"})
public final class e extends l<fbb> {
    public e(String str, String str2) {
        p.h(str, "token");
        p.h(str2, "requestID");
        AppMethodBeat.i(212691);
        fba fba = new fba();
        fba.token = str;
        fba.request_id = str2;
        a(fba, new fbb(), 6280, "/cgi-bin/micromsg-bin/wecoinrealnameauth");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetRealNameAuthRequest: ");
        AppMethodBeat.o(212691);
    }
}
