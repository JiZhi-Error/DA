package com.tencent.mm.plugin.wxcredit.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends m {
    public String dVu = null;

    public g(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(72308);
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
        AppMethodBeat.o(72308);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 65;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(72309);
        Log.d("Micromsg.NetSceneTenpayCheckPwd", "errCode " + i2 + " errMsg: " + str);
        if (i2 != 0) {
            AppMethodBeat.o(72309);
            return;
        }
        this.dVu = jSONObject.optString("app_username");
        AppMethodBeat.o(72309);
    }
}
