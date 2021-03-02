package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiCancelWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/CancelWecoinRechargeResponse;", "billNo", "", "(Ljava/lang/String;)V", "plugin-wxpay_release"})
public final class a extends l<ts> {
    public a(String str) {
        p.h(str, "billNo");
        AppMethodBeat.i(212687);
        tr trVar = new tr();
        trVar.KBs = str;
        a(trVar, new ts(), 6233, "/cgi-bin/micromsg-bin/cancelwecoinrecharge");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiCancelWecoinRechargeRequest: billNo: ".concat(String.valueOf(str)));
        AppMethodBeat.o(212687);
    }
}
