package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends m {
    public f(String str, String str2, String str3) {
        AppMethodBeat.i(72307);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        setRequestData(hashMap);
        AppMethodBeat.o(72307);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 62;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
