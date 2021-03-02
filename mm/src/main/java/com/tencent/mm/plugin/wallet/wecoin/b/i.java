package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byq;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetWecoinPriceListRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetWecoinPriceListResponse;", "()V", "plugin-wxpay_release"})
public final class i extends l<byr> {
    public i() {
        AppMethodBeat.i(212695);
        a(new byq(), new byr(), 6299, "/cgi-bin/micromsg-bin/getwecoinpricelist");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetWecoinPriceListRequest: ");
        AppMethodBeat.o(212695);
    }
}
