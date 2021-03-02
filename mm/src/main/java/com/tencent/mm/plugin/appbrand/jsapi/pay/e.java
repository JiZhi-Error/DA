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

public final class e extends d<c> {
    public static final int CTRL_INDEX = 701;
    public static final String NAME = "openSelectPayment";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46720);
        final c cVar2 = cVar;
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46720);
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            String appId = cVar2.getAppId();
            String optString = jSONObject.optString("sessionid");
            String optString2 = jSONObject.optString("url");
            if (optString == null || appId == null || optString.isEmpty() || appId.isEmpty()) {
                cVar2.i(i2, n("fail", new HashMap<String, Object>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.pay.e.AnonymousClass1 */

                    {
                        AppMethodBeat.i(46717);
                        put("err_desc", "no sessionid,appid");
                        AppMethodBeat.o(46717);
                    }
                }));
                AppMethodBeat.o(46720);
                return;
            }
            hashMap.put("appId", appId);
            hashMap.put("sessionId", optString);
            hashMap.put("JSAPIFunc", getName());
            if (optString2 != null) {
                hashMap.put("webViewUrl", optString2);
            }
            AppBrandJsApiPayService.INSTANCE.startPayComponent(ay, cVar2.getRuntime().ON().cyA, "selectPayment", hashMap, new a.AbstractC0695a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.e.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.AbstractC0695a
                public final void p(String str, Map<String, Object> map) {
                    AppMethodBeat.i(46719);
                    cVar2.i(i2, e.this.n(str, map));
                    AppMethodBeat.o(46719);
                }
            });
            AppMethodBeat.o(46720);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiOpenSelectPayment", e2.getMessage());
            cVar2.i(i2, n("fail", new HashMap<String, Object>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.e.AnonymousClass2 */

                {
                    AppMethodBeat.i(46718);
                    put("err_desc", "no sessionid,appid");
                    AppMethodBeat.o(46718);
                }
            }));
            AppMethodBeat.o(46720);
        }
    }
}
