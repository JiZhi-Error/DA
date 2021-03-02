package com.tencent.mm.plugin.wallet.pay.a.b;

public final class e extends a {
    public e(String str, int i2, int i3) {
        super(str, i2, i3);
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.b.a
    public final int getFuncId() {
        return 2533;
    }

    @Override // com.tencent.mm.plugin.wallet.pay.a.b.a
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_aa_cancelpay";
    }
}
