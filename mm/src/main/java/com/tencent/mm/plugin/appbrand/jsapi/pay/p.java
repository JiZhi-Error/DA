package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.pay.a;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class p extends d<c> {
    public static final int CTRL_INDEX = 707;
    public static final String NAME = "requestVerifyUserIdentity";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46739);
        final c cVar2 = cVar;
        Log.i("MicroMsg.JsApiRequestVerifyUserIdentity", "invoke JsApiRequestVerifyUserIdentity!");
        if (cVar2 == null) {
            Log.e("MicroMsg.JsApiRequestVerifyUserIdentity", "fail:component is null");
            AppMethodBeat.o(46739);
            return;
        }
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            Log.e("MicroMsg.JsApiRequestVerifyUserIdentity", "fail:context is null");
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46739);
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            String appId = cVar2.getAppId();
            String optString = jSONObject.optString("sessionid");
            if (optString == null || appId == null || optString.isEmpty() || appId.isEmpty()) {
                cVar2.i(i2, n("fail", new HashMap<String, Object>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.pay.p.AnonymousClass1 */

                    {
                        AppMethodBeat.i(46736);
                        put("err_desc", "no sessionid,appid");
                        AppMethodBeat.o(46736);
                    }
                }));
                AppMethodBeat.o(46739);
                return;
            }
            hashMap.put("appId", appId);
            hashMap.put("sessionId", optString);
            AppBrandJsApiPayService.INSTANCE.startPayComponent(ay, cVar2.getRuntime().ON().cyA, "verifyUserIdentity", hashMap, new a.AbstractC0695a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.p.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.AbstractC0695a
                public final void p(String str, Map<String, Object> map) {
                    AppMethodBeat.i(46738);
                    cVar2.i(i2, p.this.n(str, map));
                    AppMethodBeat.o(46738);
                }
            });
            AppMethodBeat.o(46739);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiRequestVerifyUserIdentity", e2.getMessage());
            cVar2.i(i2, n("fail", new HashMap<String, Object>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.p.AnonymousClass2 */

                {
                    AppMethodBeat.i(46737);
                    put("err_desc", "no sessionid,appid");
                    AppMethodBeat.o(46737);
                }
            }));
            AppMethodBeat.o(46739);
        }
    }
}