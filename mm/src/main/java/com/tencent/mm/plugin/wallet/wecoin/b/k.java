package com.tencent.mm.plugin.wallet.wecoin.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.deo;
import com.tencent.mm.protocal.protobuf.dep;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CgiPrepareWecoinRechargeRequest;", "Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeResponse;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "(Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;)V", "getRequest", "()Lcom/tencent/mm/protocal/protobuf/PrepareWecoinRechargeRequest;", "plugin-wxpay_release"})
public final class k extends l<dep> {
    private final deo HMG;

    public k(deo deo) {
        p.h(deo, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        AppMethodBeat.i(212697);
        this.HMG = deo;
        a(this.HMG, new dep(), 6242, "/cgi-bin/micromsg-bin/preparewecoinrecharge");
        Log.i("MicroMsg.CommonWeCoinCgi", "CgiPrepareWecoinRechargeRequest: requestID: " + this.HMG.request_id + ", productID:  " + this.HMG.MJG);
        AppMethodBeat.o(212697);
    }
}
