package com.tencent.mm.plugin.wallet.pay.a.c;

import com.tencent.mm.pluginsdk.wallet.PayInfo;

public final class i extends f {
    public i(PayInfo payInfo, int i2) {
        super(payInfo, i2);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.c.f, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2867;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.c.f, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/tax_qrcodeusebindquery";
    }
}
