package com.tencent.mm.plugin.wallet.pay.a.b;

public final class k extends a {
    public k(String str, int i2, int i3) {
        super(str, i2, i3);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.b.a
    public final int getFuncId() {
        return 2705;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.b.a
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unicancelpay";
    }
}
