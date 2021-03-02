package com.tencent.mm.plugin.appbrand.jsapi.pay;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class l extends n {
    public static final int CTRL_INDEX = 691;
    public static final String NAME = "requestJointPayment";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d, com.tencent.mm.plugin.appbrand.jsapi.pay.n
    public final /* bridge */ /* synthetic */ void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(46729);
        a(kVar, jSONObject, i2);
        AppMethodBeat.o(46729);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.n
    public final void a(k kVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(226961);
        if (jSONObject == null) {
            kVar.i(i2, h("fail:invalid data", null));
            AppMethodBeat.o(226961);
            return;
        }
        try {
            jSONObject.put("key_joint_pay", true);
            super.a(kVar, jSONObject, i2);
            AppMethodBeat.o(226961);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiRequestJointPayment", e2.getMessage());
            kVar.i(i2, h("fail", null));
            AppMethodBeat.o(226961);
        }
    }
}
