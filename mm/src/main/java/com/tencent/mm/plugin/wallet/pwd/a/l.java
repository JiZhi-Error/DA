package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.l.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class l extends m {
    public l(String str, String str2) {
        AppMethodBeat.i(69557);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("new_passwd", str2);
        hashMap.put("new_rpasswd", str2);
        setRequestData(hashMap);
        AppMethodBeat.o(69557);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 9;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69558);
        Log.d("Micromsg.NetSceneTenpayChangePwd", "errCode " + i2 + " errMsg: " + str);
        AppMethodBeat.o(69558);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/changepwd";
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return a.C0672a.CTRL_INDEX;
    }
}
