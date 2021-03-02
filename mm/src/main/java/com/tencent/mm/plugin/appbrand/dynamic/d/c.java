package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.b;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c extends a {
    public c(int i2) {
        super(f.NAME, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.dynamic.d.a.a
    public final void a(com.tencent.mm.aa.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        AppMethodBeat.i(121309);
        Context context = aVar.getContext();
        HashMap hashMap = new HashMap();
        if (!NetStatusUtil.isConnected(context)) {
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
        aVar2.bt(a(true, "", (Map<String, ? extends Object>) hashMap));
        AppMethodBeat.o(121309);
    }
}
