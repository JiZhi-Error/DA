package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends m {
    public e(String str) {
        AppMethodBeat.i(69526);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        setRequestData(hashMap);
        AppMethodBeat.o(69526);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 0;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 1321;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/closewalletlock";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(69527);
        Log.i("MicroMsg.NetSceneCloseWalletLock", "alvinluo close wallet lock errCode: %d, errMsg: %s, json: %s", Integer.valueOf(i2), str, jSONObject);
        AppMethodBeat.o(69527);
    }
}
