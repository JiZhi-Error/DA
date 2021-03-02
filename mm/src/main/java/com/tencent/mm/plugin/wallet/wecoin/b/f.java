package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinBalanceRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinBalanceResponse;", "()V", "plugin-wxpay_release"})
public final class f extends l<byn> {
    public f() {
        AppMethodBeat.i(212692);
        a(new bym(), new byn(), 6401, "/cgi-bin/micromsg-bin/getwecoinbalance");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinBalanceRequest: ");
        AppMethodBeat.o(212692);
    }
}
