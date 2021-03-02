package com.tencent.mm.plugin.wallet_core.c;

public final class aa extends ad {
    public aa(String str) {
        super(str, 4);
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 2687;
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 2687;
    }

    @Override // com.tencent.mm.plugin.wallet_core.c.ad, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/fetchbindquery";
    }
}
