package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class l extends b {
    public l(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/tax_authen";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2862;
    }
}
