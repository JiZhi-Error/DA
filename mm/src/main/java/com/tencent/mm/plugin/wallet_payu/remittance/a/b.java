package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class b extends a {
    public b(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(72168);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("total_fee", String.valueOf(i2));
        hashMap.put("fee_type", str2);
        hashMap.put("to_customer_name", str3);
        setRequestData(hashMap);
        AppMethodBeat.o(72168);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72169);
        Log.d("MicroMsg", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72169);
        } else {
            AppMethodBeat.o(72169);
        }
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 16;
    }
}
