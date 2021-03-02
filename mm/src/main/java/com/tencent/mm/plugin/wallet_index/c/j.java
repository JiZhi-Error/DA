package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.plugin.appbrand.jsapi.ct;

public final class j extends h {
    public j(PayReq payReq, String str, String str2, String str3, String str4) {
        super(payReq, str, str2, str3, str4);
    }

    @Override // com.tencent.mm.plugin.wallet_index.c.h, com.tencent.mm.ak.q
    public final int getType() {
        return ct.CTRL_INDEX;
    }

    @Override // com.tencent.mm.plugin.wallet_index.c.h
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/snspayauthapp";
    }
}
