package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.network.s;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import java.util.HashMap;
import org.json.JSONObject;

public final class j extends m {
    public j(String str) {
        AppMethodBeat.i(66298);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put(TPDownloadProxyEnum.USER_DEVICE_ID, q.aoG());
        setRequestData(hashMap);
        AppMethodBeat.o(66298);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getTenpayCgicmd() {
        return 47;
    }

    @Override // com.tencent.mm.wallet_core.c.s
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.wallet_core.c.w, com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        AppMethodBeat.i(66299);
        super.onGYNetEnd(i2, i3, i4, str, sVar, bArr);
        AppMethodBeat.o(66299);
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final int getFuncId() {
        return 566;
    }

    @Override // com.tencent.mm.wallet_core.tenpay.model.m
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlineclose";
    }
}
