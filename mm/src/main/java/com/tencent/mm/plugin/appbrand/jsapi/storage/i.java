package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import org.json.JSONObject;

public final class i extends ab<k> {
    public static final int CTRL_INDEX = 17;
    public static final String NAME = "getStorageSync";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(k kVar, JSONObject jSONObject) {
        int i2;
        String str;
        String str2;
        String str3;
        String str4;
        AppMethodBeat.i(147259);
        k kVar2 = kVar;
        String optString = jSONObject.optString("key");
        int optInt = jSONObject.optInt("storageId", 0);
        if (Util.isNullOrNil(optString)) {
            String h2 = h("fail:key is empty", null);
            AppMethodBeat.o(147259);
            return h2;
        } else if (t.vU(optInt)) {
            String h3 = h("fail:nonexistent storage space", null);
            AppMethodBeat.o(147259);
            return h3;
        } else {
            String appId = kVar2.getAppId();
            if (Util.isNullOrNil(appId)) {
                String h4 = h("fail:appID is empty", null);
                AppMethodBeat.o(147259);
                return h4;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (kVar2.getRuntime().OT().leF != 1) {
                Object[] l = ((a) e.M(a.class)).dD(kVar2.getAppId()).l(optInt, appId, optString);
                if (((p.a) l[0]) == p.a.NONE) {
                    str3 = (String) l[2];
                    str4 = (String) l[1];
                } else {
                    str3 = null;
                    str4 = null;
                }
                i2 = 2;
                str = str3;
                str2 = str4;
            } else {
                JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
                jsApiGetStorageTask.appId = appId;
                jsApiGetStorageTask.mtl = optInt;
                jsApiGetStorageTask.key = optString;
                AppBrandMainProcessService.b(jsApiGetStorageTask);
                String str5 = jsApiGetStorageTask.value;
                String str6 = jsApiGetStorageTask.type;
                i2 = 1;
                str = str6;
                str2 = str5;
            }
            s.a(i2, 2, t.cF(optString, str2), 1, System.currentTimeMillis() - currentTimeMillis, kVar2);
            String str7 = str2 == null ? "fail:data not found" : "ok";
            HashMap hashMap = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("data", str2);
            if (str == null) {
                str = "";
            }
            hashMap.put("dataType", str);
            String n = n(str7, hashMap);
            AppMethodBeat.o(147259);
            return n;
        }
    }
}
