package com.tencent.mm.wallet_core.tenpay.model;

import java.util.Map;

public final class f extends g {
    public f(Map<String, String> map) {
        super(map);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinequeryorder";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.g, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1318;
    }
}