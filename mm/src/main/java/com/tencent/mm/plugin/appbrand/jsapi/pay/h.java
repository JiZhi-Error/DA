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

public final class h extends d<c> {
    public static final int CTRL_INDEX = 702;
    public static final String NAME = "requestEntrustAuthorization";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, final int i2) {
        AppMethodBeat.i(46725);
        final c cVar2 = cVar;
        Activity ay = cVar2.ay(Activity.class);
        if (ay == null) {
            cVar2.i(i2, h("fail:internal error invalid android context", null));
            AppMethodBeat.o(46725);
            return;
        }
        HashMap hashMap = new HashMap();
        try {
            String appId = cVar2.getAppId();
            String optString = jSONObject.optString("sessionid");
            String optString2 = jSONObject.optString("url");
            if (optString == null || appId == null || optString.isEmpty() || appId.isEmpty()) {
                cVar2.i(i2, n("fail", new HashMap<String, Object>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.pay.h.AnonymousClass1 */

                    {
                        AppMethodBeat.i(46722);
                        put("err_desc", "no sessionid,appid");
                        AppMethodBeat.o(46722);
                    }
                }));
                AppMethodBeat.o(46725);
                return;
            }
            hashMap.put("appId", appId);
            hashMap.put("sessionId", optString);
            hashMap.put("JSAPIFunc", getName());
            if (optString2 != null) {
                hashMap.put("webViewUrl", optString2);
            }
            AppBrandJsApiPayService.INSTANCE.startPayComponent(ay, cVar2.getRuntime().ON().cyA, "entrustAuthorization", hashMap, new a.AbstractC0695a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.h.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.pay.a.AbstractC0695a
                public final void p(String str, Map<String, Object> map) {
                    AppMethodBeat.i(46724);
                    cVar2.i(i2, h.this.n(str, map));
                    AppMethodBeat.o(46724);
                }
            });
            AppMethodBeat.o(46725);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiRequestEntrustAuthorization", e2.getMessage());
            cVar2.i(i2, n("fail", new HashMap<String, Object>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.pay.h.AnonymousClass2 */

                {
                    AppMethodBeat.i(46723);
                    put("err_desc", "no sessionid,appid");
                    AppMethodBeat.o(46723);
                }
            }));
            AppMethodBeat.o(46725);
        }
    }
}
