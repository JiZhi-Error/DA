package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends m {
    public d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(69067);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("passwd", str3);
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        setRequestData(hashMap);
        AppMethodBeat.o(69067);
    }

    public d(String str, String str2, boolean z) {
        AppMethodBeat.i(69068);
        HashMap hashMap = new HashMap();
        hashMap.put("bank_type", str);
        hashMap.put("bind_serial", str2);
        hashMap.put("expired_flag", "1");
        if (z) {
            hashMap.put("unbind_scene", "1");
        }
        setRequestData(hashMap);
        AppMethodBeat.o(69068);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 14;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 473;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/unbind";
    }
}
