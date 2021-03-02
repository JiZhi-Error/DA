package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends m {
    public q(String str, String str2) {
        AppMethodBeat.i(69570);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap.put("resetpwd_token", str2);
        hashMap.put("passwd", str);
        setRequestData(hashMap);
        setWXRequestData(hashMap2);
        AppMethodBeat.o(69570);
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69571);
        Log.d("MicroMsg.NetSceneTenpayResetPwdByToken", " json %s", jSONObject.toString());
        AppMethodBeat.o(69571);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1371;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1371;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/resetpwdbytoken";
    }
}
