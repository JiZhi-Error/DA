package com.tencent.mm.wallet_core.tenpay.model;

import java.util.Map;

public final class b extends g {
    public b(Map<String, String> map) {
        super(map);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/sns_aa_payorderquery";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1652;
    }
}
