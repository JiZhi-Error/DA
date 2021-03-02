package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.facebook.appevents.AppEventsConstants;
import com.huawei.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 899;
    public static final String NAME = "setDefaultTrafficCard";

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.aa.a
    public final void a(k kVar, int i2, a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(226999);
        if (jSONObject == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(b.muo.errorCode));
            kVar.i(i2, n("fail:" + b.muo.errorMsg, hashMap));
            Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", b.muo.errorMsg, kVar.getAppId(), Integer.valueOf(i2));
            AppMethodBeat.o(226999);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("issuerID", jSONObject.optString("issuerID"));
        hashMap2.put("appID", "APP-WECHAT");
        hashMap2.put("mode", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        try {
            String j2 = aVar.j(hashMap2);
            Log.d("MicroMsg.JsApiSetDefaultTrafficCard", "setDefaultCardString: [%s]! params: [%s]", j2, new JSONObject(hashMap2).toString());
            jSONObject2 = new JSONObject(j2);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "call huawei remote interface fail: [%s] ! ", e2.getMessage());
            jSONObject2 = null;
        }
        HashMap hashMap3 = new HashMap();
        if (jSONObject2 == null) {
            hashMap3.put("errCode", Integer.valueOf(b.mus.errorCode));
            kVar.i(i2, n("fail:" + b.mus.errorMsg, hashMap3));
            AppMethodBeat.o(226999);
            return;
        }
        int optInt = jSONObject2.optInt("resultCode");
        if (optInt != b.mun.errorCode) {
            b xq = b.xq(optInt);
            if (xq == b.muQ) {
                xq = b.muO;
            }
            hashMap3.put("errCode", Integer.valueOf(xq.errorCode));
            kVar.i(i2, n("fail:" + xq.errorMsg, hashMap3));
            Log.e("MicroMsg.JsApiSetDefaultTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", Integer.valueOf(optInt));
            AppMethodBeat.o(226999);
            return;
        }
        hashMap3.put("errCode", Integer.valueOf(b.mun.errorCode));
        kVar.i(i2, n(b.mun.errorMsg, hashMap3));
        AppMethodBeat.o(226999);
    }
}
