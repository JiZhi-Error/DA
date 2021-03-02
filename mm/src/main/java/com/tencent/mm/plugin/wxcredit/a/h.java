package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class h extends m {
    public h(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(72310);
        HashMap hashMap = new HashMap();
        hashMap.put("verify_code", str);
        hashMap.put("session_key", str2);
        hashMap.put("passwd", str3);
        hashMap.put("bind_serialno", str4);
        hashMap.put("bank_type", str5);
        setRequestData(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("banktype", str5);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(72310);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 66;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72311);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        AppMethodBeat.o(72311);
    }
}
