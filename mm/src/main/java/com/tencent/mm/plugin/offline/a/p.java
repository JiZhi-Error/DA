package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import org.json.JSONObject;

public final class p extends m {
    public p(String str) {
        AppMethodBeat.i(66314);
        HashMap hashMap = new HashMap();
        hashMap.put(TPDownloadProxyEnum.USER_DEVICE_ID, q.aoG());
        hashMap.put("passwd", str);
        setRequestData(hashMap);
        AppMethodBeat.o(66314);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 51;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }
}
