package com.tencent.mm.plugin.wallet.wecoin.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dej;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareIncomeEncashRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "requestID", "", "sessionID", "amount", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "plugin-wxpay_release"})
public final class j extends l<dek> {
    public j(String str, String str2, long j2) {
        p.h(str, "requestID");
        p.h(str2, "sessionID");
        AppMethodBeat.i(212696);
        dej dej = new dej();
        dej.request_id = str;
        dej.eht = j2;
        dej.LoB = str2;
        a(dej, new dek(), 5838, "/cgi-bin/micromsg-bin/prepareincomeencash");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareIncomeEncashRequest: requestID: " + str + ", amount: " + j2);
        AppMethodBeat.o(212696);
    }
}
