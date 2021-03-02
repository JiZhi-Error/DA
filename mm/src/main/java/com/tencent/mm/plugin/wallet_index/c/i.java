package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends m {
    public i(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        AppMethodBeat.i(71825);
        HashMap hashMap = new HashMap();
        hashMap.put("toUser", str);
        hashMap.put("receiverTitle", str2);
        hashMap.put("senderTitle", str3);
        hashMap.put("tempId", str4);
        hashMap.put("receiverdes", str6);
        hashMap.put("senderdes", str5);
        hashMap.put("Url", str7);
        hashMap.put("Scene", str8);
        setRequestData(hashMap);
        AppMethodBeat.o(71825);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1962;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(71826);
        Log.d("Micromsg.NetSceneSendC2CMsg", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(71826);
        } else {
            AppMethodBeat.o(71826);
        }
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/h5sendc2cmsg";
    }
}
