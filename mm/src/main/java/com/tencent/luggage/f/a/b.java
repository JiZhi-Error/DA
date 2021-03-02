package com.tencent.luggage.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class b implements c {
    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.c
    public com.tencent.mm.plugin.appbrand.jsapi.k.a.b b(f fVar, JSONObject jSONObject) {
        AppMethodBeat.i(146456);
        if (fVar == null || jSONObject == null) {
            AppMethodBeat.o(146456);
            return null;
        }
        Context context = fVar.getContext();
        String optString = jSONObject.optString("theme", "");
        int optInt = jSONObject.optInt("mapType", 1);
        String optString2 = jSONObject.optString("subKey", "");
        String appId = fVar.getAppId();
        String optString3 = jSONObject.optString("pluginId", "");
        if (TextUtils.isEmpty(optString3)) {
            optString3 = appId;
        }
        int optInt2 = jSONObject.optInt("styleId", 0);
        String i2 = com.tencent.mm.plugin.appbrand.jsapi.k.a.f.i(fVar, jSONObject);
        int optInt3 = jSONObject.optInt("enableDarkMode", 0);
        HashMap hashMap = new HashMap(5);
        hashMap.put("theme", optString);
        hashMap.put("mapType", Integer.valueOf(optInt));
        hashMap.put("subKey", optString2);
        hashMap.put("subId", optString3);
        hashMap.put("styleId", Integer.valueOf(optInt2));
        hashMap.put("enableDarkMode", Integer.valueOf(optInt3));
        a aVar = new a(context, i2, hashMap);
        AppMethodBeat.o(146456);
        return aVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.c
    public com.tencent.mm.plugin.appbrand.jsapi.k.a.b a(Context context, String str, Map<String, Object> map) {
        AppMethodBeat.i(146457);
        if (context == null) {
            AppMethodBeat.o(146457);
            return null;
        }
        a aVar = new a(context, str, map);
        AppMethodBeat.o(146457);
        return aVar;
    }
}
