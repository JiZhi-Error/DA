package com.tencent.mm.plugin.wallet_payu.remittance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.e.a.a;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends a {
    public f(String str, int i2, String str2, String str3, int i3) {
        AppMethodBeat.i(72176);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("total_fee", String.valueOf(i2));
        hashMap.put("fee_type", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("invalid_time", String.valueOf(i3));
        setRequestData(hashMap);
        AppMethodBeat.o(72176);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72177);
        Log.d("MicroMsg.NetScenePayURemitttanceRetry", "errCode " + i2 + " errMsg: " + str);
        AppMethodBeat.o(72177);
    }

    @Override // com.tencent.mm.wallet_core.e.a.a
    public final int fPU() {
        return 26;
    }
}
