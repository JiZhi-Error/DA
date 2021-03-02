package com.tencent.mm.wallet_core.tenpay.model;

public final class r extends o {
    public r(String str, int i2, int i3, int i4, int i5, String str2) {
        super(str, i2, i3, i4, i5, str2);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.o, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unipayauthnative";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.o, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2987;
    }
}
