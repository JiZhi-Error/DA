package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class ah extends m {
    public String HPZ;
    public String HQm;

    public ah(v vVar, String str) {
        AppMethodBeat.i(69960);
        HashMap hashMap = new HashMap();
        hashMap.put("verify_code", vVar.IaW);
        hashMap.put("token", vVar.token);
        hashMap.put("passwd", vVar.kdF);
        hashMap.put("relation_key", str);
        setRequestData(hashMap);
        AppMethodBeat.o(69960);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 124;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69961);
        if (jSONObject != null && i2 == 0) {
            this.HPZ = jSONObject.optString("token_type");
            this.HQm = jSONObject.optString("usertoken");
        }
        AppMethodBeat.o(69961);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/webankverifysms";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1604;
    }
}
