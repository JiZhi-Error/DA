package com.tencent.mm.plugin.wallet_payu.balance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.json.JSONObject;

public final class a extends com.tencent.mm.wallet_core.e.a.a {
    public String dDL;
    public double dDO;
    public String dFv;

    public a(double d2, String str) {
        AppMethodBeat.i(71961);
        this.dDO = d2;
        this.dFv = str;
        HashMap hashMap = new HashMap();
        hashMap.put("total_fee", new StringBuilder().append(Math.round(100.0d * d2)).toString());
        hashMap.put("fee_type", str);
        setRequestData(hashMap);
        AppMethodBeat.o(71961);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 20;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(71962);
        this.dDL = jSONObject.optString("prepayid");
        AppMethodBeat.o(71962);
    }
}
