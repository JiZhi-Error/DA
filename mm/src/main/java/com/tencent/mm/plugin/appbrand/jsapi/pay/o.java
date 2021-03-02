package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;
import org.json.JSONObject;

public final class o extends d<c> {
    public static final int CTRL_INDEX = 149;
    public static final String NAME = "requestPaymentToBank";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46735);
        final c cVar2 = cVar;
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46735);
            return;
        }
        try {
            jSONObject.put("appId", cVar2.getAppId());
            AppBrandJsApiPayService.INSTANCE.startPayToBank(ay, cVar2.getRuntime().ON().cyA, jSONObject, new a.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.o.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.b
                public final void a(int i2, String str, Map<String, Object> map) {
                    AppMethodBeat.i(46734);
                    switch (i2) {
                        case 1:
                            cVar2.i(i2, o.this.n("ok", map));
                            AppMethodBeat.o(46734);
                            return;
                        default:
                            cVar2.i(i2, o.this.h("fail:".concat(String.valueOf(str)), null));
                            AppMethodBeat.o(46734);
                            return;
                    }
                }
            });
            AppMethodBeat.o(46735);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiRequestPaymentToBank", e2.getMessage());
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46735);
        }
    }
}
