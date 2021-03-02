package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class z extends m {
    public z(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(67897);
        HashMap hashMap = new HashMap();
        hashMap.put("trans_id", str);
        hashMap.put("transfer_id", str2);
        hashMap.put("receiver_name", str3);
        hashMap.put("from", String.valueOf(i3));
        hashMap.put("invalid_time", String.valueOf(i2));
        setRequestData(hashMap);
        AppMethodBeat.o(67897);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1545;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transferresendmsg";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67898);
        Log.d("Micromsg.NetSceneTenpayRemittanceResendMsg", "errCode " + i2 + " errMsg: " + str);
        AppMethodBeat.o(67898);
    }
}
