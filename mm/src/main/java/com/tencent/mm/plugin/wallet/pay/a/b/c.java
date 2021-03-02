package com.tencent.mm.plugin.wallet.pay.a.b;

public final class c extends a {
    public c(String str, int i2, int i3) {
        super(str, i2, i3);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.b.a
    public final int getFuncId() {
        return 2849;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.b.a
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/dc_cancelpay";
    }
}
