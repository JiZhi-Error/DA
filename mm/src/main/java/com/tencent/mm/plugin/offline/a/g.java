package com.tencent.mm.plugin.offline.a;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends h {
    public g(String str, String str2, String str3) {
        String str4;
        AppMethodBeat.i(66295);
        HashMap hashMap = new HashMap();
        hashMap.put("buss_type", str);
        hashMap.put(FirebaseAnalytics.b.METHOD, str2);
        if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            str4 = "wifi";
        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
            str4 = "3g";
        } else if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
            str4 = "2g";
        } else if (NetStatusUtil.isWap(MMApplicationContext.getContext())) {
            str4 = "wap";
        } else if (NetStatusUtil.is4G(MMApplicationContext.getContext())) {
            str4 = "4g";
        } else {
            str4 = "unknown";
        }
        hashMap.put(TencentLocation.NETWORK_PROVIDER, str4);
        hashMap.put("transactionid", str3);
        setRequestData(hashMap);
        AppMethodBeat.o(66295);
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final int getTenpayCgicmd() {
        return 122;
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final void onGYNetEnd(int i2, String str, JSONObject jSONObject) {
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/datareport";
    }

    @Override // com.tencent.mm.plugin.offline.a.h
    public final int getFuncId() {
        return 1602;
    }
}
