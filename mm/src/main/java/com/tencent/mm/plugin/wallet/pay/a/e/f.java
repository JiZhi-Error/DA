package com.tencent.mm.plugin.wallet.pay.a.e;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;

public final class f extends j {
    public f(v vVar, Orders orders) {
        super(vVar, orders);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.e.j, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_verifyreg";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.e.j, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1520;
    }
}