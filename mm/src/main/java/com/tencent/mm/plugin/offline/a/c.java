package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class c extends m {
    public c(String str, int i2, int i3) {
        AppMethodBeat.i(66284);
        HashMap hashMap = new HashMap();
        hashMap.put("req_key", str);
        hashMap.put("pay_scene", String.valueOf(i2));
        hashMap.put("pay_channel", String.valueOf(i3));
        setRequestData(hashMap);
        AppMethodBeat.o(66284);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 1385;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecancelpay";
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
        AppMethodBeat.i(66285);
        Log.i("NetSceneOfflineCancelPay", "onGYNetEnd errCode:%d, errMsg:%s", Integer.valueOf(i2), str);
        AppMethodBeat.o(66285);
    }
}
