package com.tencent.mm.plugin.appbrand.dynamic.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends c {
    public d() {
        super("onNetworkStatusChange");
    }

    d(int i2) {
        super("onNetworkStatusChange", i2);
    }

    @Override // com.tencent.mm.aa.b.c
    public final JSONObject toJSONObject() {
        AppMethodBeat.i(121394);
        HashMap hashMap = new HashMap();
        Context context = MMApplicationContext.getContext();
        boolean isConnected = NetStatusUtil.isConnected(context);
        hashMap.put("isConnected", Boolean.valueOf(isConnected));
        if (!isConnected) {
            hashMap.put("networkType", "none");
        } else if (NetStatusUtil.is2G(context)) {
            hashMap.put("networkType", "2g");
        } else if (NetStatusUtil.is3G(context)) {
            hashMap.put("networkType", "3g");
        } else if (NetStatusUtil.is4G(context)) {
            hashMap.put("networkType", "4g");
        } else if (NetStatusUtil.isWifi(context)) {
            hashMap.put("networkType", "wifi");
        } else {
            hashMap.put("networkType", "unknown");
        }
        JSONObject jSONObject = new JSONObject(hashMap);
        AppMethodBeat.o(121394);
        return jSONObject;
    }
}
