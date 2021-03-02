package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class u extends m {
    public u(String str) {
        AppMethodBeat.i(69933);
        HashMap hashMap = new HashMap();
        hashMap.put("wallet_tpa_country", str);
        setRequestData(hashMap);
        AppMethodBeat.o(69933);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1663;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1663;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/setuserwallet";
    }

    @Override // com.tencent.mm.ak.q, com.tencent.mm.wallet_core.tenpay.model.m
    public final int getType() {
        AppMethodBeat.i(69934);
        int type = super.getType();
        AppMethodBeat.o(69934);
        return type;
    }
}
