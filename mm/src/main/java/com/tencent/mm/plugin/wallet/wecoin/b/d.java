package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiGetMidasSdkInfoRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/GetMidasSdkInfoResponse;", "()V", "plugin-wxpay_release"})
public final class d extends l<bqm> {
    public d() {
        AppMethodBeat.i(212690);
        a(new bql(), new bqm(), 6684, "/cgi-bin/micromsg-bin/getmidassdkinfo");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiGetMidasSdkInfoRequest: ");
        AppMethodBeat.o(212690);
    }
}
