package com.tencent.mm.plugin.wallet.pay.a.a;

import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;

public final class h extends b {
    public h(Authen authen, Orders orders, boolean z) {
        super(authen, orders, z);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinepayauthen";
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.a.b, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1972;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final boolean isBlock() {
        if (this.HFI == null || this.HFI.BDB.Kxz == 1) {
            return true;
        }
        return false;
    }
}
