package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.s;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class o extends ab<k> {
    public static final int CTRL_INDEX = 16;
    public static final String NAME = "setStorageSync";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.ab
    public final /* synthetic */ String a(k kVar, JSONObject jSONObject) {
        String a2;
        AppMethodBeat.i(147289);
        k kVar2 = kVar;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString("data");
        String optString3 = jSONObject.optString("dataType");
        int optInt = jSONObject.optInt("storageId", 0);
        if (Util.isNullOrNil(optString)) {
            String h2 = h("fail:key is empty", null);
            AppMethodBeat.o(147289);
            return h2;
        } else if (t.vU(optInt)) {
            String h3 = h("fail:nonexistent storage space", null);
            AppMethodBeat.o(147289);
            return h3;
        } else if (Util.isNullOrNil(kVar2.getAppId())) {
            String h4 = h("fail:appID is empty", null);
            AppMethodBeat.o(147289);
            return h4;
        } else {
            if ((optString2 == null ? 0 : optString2.length()) + optString.length() > ((d) kVar2.getRuntime()).OM().czd.lcN) {
                String h5 = h("fail:entry size limit reached", null);
                AppMethodBeat.o(147289);
                return h5;
            }
            int i2 = kVar2.getRuntime().OT().leF;
            if (i2 == 2) {
                a2 = b(kVar2, optString, optString2, optString3, optInt);
            } else if (i2 == 3) {
                a2 = b(kVar2, optString, optString2, optString3, optInt);
                a(kVar2, optString, optString2, optString3, optInt);
            } else {
                a2 = a(kVar2, optString, optString2, optString3, optInt);
            }
            String h6 = h(a2, null);
            AppMethodBeat.o(147289);
            return h6;
        }
    }

    private static String a(k kVar, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(147287);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.appId = kVar.getAppId();
            jsApiSetStorageTask.mtl = i2;
            jsApiSetStorageTask.E(str, str2, str3);
            if (AppBrandMainProcessService.b(jsApiSetStorageTask)) {
                return jsApiSetStorageTask.result;
            }
            Log.e("Luggage.FULL.JsApiSetStorageSync", "invokeWithDB appId[%s] key[%s] execSync failed", kVar.getAppId(), str);
            s.a(1, 1, t.cF(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, kVar);
            AppMethodBeat.o(147287);
            return "fail";
        } finally {
            s.a(1, 1, t.cF(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, kVar);
            AppMethodBeat.o(147287);
        }
    }

    private static String b(k kVar, String str, String str2, String str3, int i2) {
        AppMethodBeat.i(147288);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            return p.a(((a) e.M(a.class)).dD(kVar.getAppId()).c(i2, kVar.getAppId(), str, str2, str3));
        } finally {
            s.a(2, 1, t.cF(str, str2), 1, System.currentTimeMillis() - currentTimeMillis, kVar);
            AppMethodBeat.o(147288);
        }
    }
}
