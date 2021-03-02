package com.tencent.mm.plugin.wallet.wecoin.b;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.d;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.dpc;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\n\b\u0000\u0010\u0001*\u0004\u0018\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/cgi/CommonWeCoinCgi;", "_Resp", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/modelbase/Cgi;", "()V", "setRR", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/RequestProtoBuf;", "response", "funcId", "", ShareConstants.MEDIA_URI, "", "plugin-wxpay_release"})
public abstract class l<_Resp extends dpc> extends c<_Resp> {
    public final void a(dop dop, dpc dpc, int i2, String str) {
        p.h(dop, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        p.h(dpc, "response");
        p.h(str, ShareConstants.MEDIA_URI);
        d.a aVar = new d.a();
        aVar.c(dop);
        aVar.d(dpc);
        aVar.sG(i2);
        aVar.MB(str);
        aVar.sI(0);
        aVar.sJ(0);
        c(aVar.aXF());
    }
}
