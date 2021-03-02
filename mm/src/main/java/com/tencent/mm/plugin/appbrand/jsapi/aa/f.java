package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.huawei.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class f extends a {
    public static final int CTRL_INDEX = 898;
    public static final String NAME = "rechargeTrafficCard";

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.aa.a
    public final void a(k kVar, int i2, a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(226998);
        if (jSONObject == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(b.muo.errorCode));
            kVar.i(i2, n("fail:" + b.muo.errorMsg, hashMap));
            Log.e("MicroMsg.JsApiRechargeTrafficCard", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", b.muo.errorMsg, kVar.getAppId(), Integer.valueOf(i2));
            AppMethodBeat.o(226998);
            return;
        }
        HashMap hashMap2 = new HashMap();
        String optString = jSONObject.optString("issuerID");
        String optString2 = jSONObject.optString("orderNo");
        String optString3 = jSONObject.optString("cityCode");
        String optString4 = jSONObject.optString("retry");
        hashMap2.put("issuerID", optString);
        hashMap2.put("orderNo", optString2);
        hashMap2.put("appID", "APP-WECHAT");
        hashMap2.put("operation", "1");
        hashMap2.put("cityCode", optString3);
        hashMap2.put("retry", optString4);
        try {
            String g2 = aVar.g(hashMap2);
            Log.d("MicroMsg.JsApiRechargeTrafficCard", "rechargeCardString: [%s]! params: [%s]", g2, new JSONObject(hashMap2).toString());
            jSONObject2 = new JSONObject(g2);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiRechargeTrafficCard", "call huawei remote interface fail: [%s] ! ", e2.getMessage());
            jSONObject2 = null;
        }
        HashMap hashMap3 = new HashMap();
        if (jSONObject2 == null) {
            hashMap3.put("errCode", Integer.valueOf(b.mus.errorCode));
            kVar.i(i2, n("fail:" + b.mus.errorMsg, hashMap3));
            AppMethodBeat.o(226998);
            return;
        }
        int optInt = jSONObject2.optInt("resultCode");
        if (optInt != b.mun.errorCode) {
            b xq = b.xq(optInt);
            if (xq == b.muQ) {
                xq = b.muN;
            }
            hashMap3.put("errCode", Integer.valueOf(xq.errorCode));
            kVar.i(i2, n("fail:" + xq.errorMsg, hashMap3));
            Log.e("MicroMsg.JsApiRechargeTrafficCard", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", Integer.valueOf(optInt));
            AppMethodBeat.o(226998);
            return;
        }
        hashMap3.put("errCode", Integer.valueOf(b.mun.errorCode));
        kVar.i(i2, n(b.mun.errorMsg, hashMap3));
        AppMethodBeat.o(226998);
    }
}
