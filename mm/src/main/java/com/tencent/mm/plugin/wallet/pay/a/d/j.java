package com.tencent.mm.plugin.wallet.pay.a.d;

import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.v;

public final class j extends g {
    public j(v vVar, Orders orders) {
        super(vVar, orders);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_verify";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.d.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1617;
    }
}