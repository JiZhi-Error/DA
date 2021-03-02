package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class a extends f {
    public a(PayInfo payInfo, int i2) {
        super(payInfo, i2);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.c.f, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1551;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.c.f, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_aa_qrcodeusebindquery";
    }
}
