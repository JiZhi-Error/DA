package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class m extends n {
    public static final int CTRL_INDEX = 431;
    public static final String NAME = "requestMallPayment";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.pay.n
    public final /* bridge */ /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46731);
        a(kVar, jSONObject, i2);
        AppMethodBeat.o(46731);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.n
    public final void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226962);
        if (jSONObject == null) {
            kVar.i(i2, h("fail", null));
            AppMethodBeat.o(226962);
            return;
        }
        try {
            jSONObject.put("appId", kVar.getAppId());
            jSONObject.put("pay_for_wallet_type", 3);
            super.a(kVar, jSONObject, i2);
            AppMethodBeat.o(226962);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiRequestMallPayment", e2.getMessage());
            kVar.i(i2, h("fail", null));
            AppMethodBeat.o(226962);
        }
    }
}
