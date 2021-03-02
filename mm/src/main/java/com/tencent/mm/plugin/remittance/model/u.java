package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class u extends m {
    public u(String str, String str2) {
        AppMethodBeat.i(67880);
        HashMap hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        setRequestData(hashMap);
        AppMethodBeat.o(67880);
    }

    public u(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(67881);
        HashMap hashMap = new HashMap();
        hashMap.put("receiver_user_name", str);
        hashMap.put("transfer_qrcode_id", str2);
        hashMap.put("rcvr_ticket", str3);
        hashMap.put("receiver_openid", str4);
        setRequestData(hashMap);
        AppMethodBeat.o(67881);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1535;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/transfersendcancelf2f";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(67882);
        Log.d(m.TAG, "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(67882);
        } else {
            AppMethodBeat.o(67882);
        }
    }
}
