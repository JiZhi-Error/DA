package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.huawei.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a {
    public static final int CTRL_INDEX = 896;
    public static final String NAME = "queryTrafficCardInfo";

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.aa.a
    public final void a(k kVar, int i2, a aVar, JSONObject jSONObject) {
        JSONObject jSONObject2;
        AppMethodBeat.i(226997);
        if (jSONObject == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(b.muo.errorCode));
            kVar.i(i2, n("fail:" + b.muo.errorMsg, hashMap));
            Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "deviceData is null, invoke fail: [%s] ! with appId[%s] callbackId[%d]", b.muo.errorMsg, kVar.getAppId(), Integer.valueOf(i2));
            AppMethodBeat.o(226997);
            return;
        }
        try {
            String n = aVar.n(jSONObject.optString("issuerID"), jSONObject.optInt("dataType"));
            Log.d("MicroMsg.JsApiQueryTrafficCardInfo", "queryTrafficCardInfoString: [%s]! ", n);
            jSONObject2 = new JSONObject(n);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "call huawei remote interface fail: [%s] ! ", e2.getMessage());
            jSONObject2 = null;
        }
        HashMap hashMap2 = new HashMap();
        if (jSONObject2 == null) {
            hashMap2.put("errCode", Integer.valueOf(b.mus.errorCode));
            kVar.i(i2, n("fail:" + b.mus.errorMsg, hashMap2));
            AppMethodBeat.o(226997);
            return;
        }
        int optInt = jSONObject2.optInt("resultCode");
        if (optInt != b.mun.errorCode) {
            b xq = b.xq(optInt);
            if (xq == b.muQ) {
                xq = b.muH;
            }
            hashMap2.put("errCode", Integer.valueOf(xq.errorCode));
            kVar.i(i2, n("fail:" + xq.errorMsg, hashMap2));
            Log.e("MicroMsg.JsApiQueryTrafficCardInfo", "Return code from huawei remote interface! with RetCode rechargeCard[%d] ", Integer.valueOf(optInt));
            AppMethodBeat.o(226997);
            return;
        }
        hashMap2.put("errCode", Integer.valueOf(b.mun.errorCode));
        hashMap2.put("data", jSONObject2.optJSONObject("data"));
        kVar.i(i2, n(b.mun.errorMsg, hashMap2));
        AppMethodBeat.o(226997);
    }
}
