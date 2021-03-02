package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

public final class s extends d<c> {
    public static final int CTRL_INDEX = 85;
    public static final String NAME = "verifyPaymentPassword";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46745);
        final c cVar2 = cVar;
        if (jSONObject == null) {
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46745);
            return;
        }
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46745);
            return;
        }
        try {
            jSONObject.put("appId", cVar2.getAppId());
            AppBrandJsApiPayService.INSTANCE.verifyPassword(ay, cVar2.getRuntime().ON().cyA, jSONObject, new a.d() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.s.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.d
                public final void p(boolean z, String str) {
                    AppMethodBeat.i(46744);
                    if (z) {
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("token", str);
                        cVar2.i(i2, s.this.n("ok", hashMap));
                        AppMethodBeat.o(46744);
                        return;
                    }
                    cVar2.i(i2, s.this.h("fail", null));
                    AppMethodBeat.o(46744);
                }
            });
            AppMethodBeat.o(46745);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiVerifyPaymentPassword", e2.getMessage());
            cVar2.i(i2, h("fail", null));
            AppMethodBeat.o(46745);
        }
    }
}
