package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.d;
import com.tencent.mm.plugin.webview.h.e;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.xweb.WebResourceResponse;
import org.json.JSONException;
import org.json.JSONObject;

public class az<T extends a> extends br<T> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<T>.a aVar) {
        AppMethodBeat.i(210956);
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.az.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(210955);
                try {
                    String optString = aVar.ctb.csi.optString("url");
                    if (Util.isNullOrNil(optString)) {
                        aVar.c("fail", null);
                        AppMethodBeat.o(210955);
                        return;
                    }
                    JSONObject jSONObject = new JSONObject();
                    e eVar = new e();
                    if (eVar.m(optString, true, false)) {
                        Log.i("MicroMsg.JsApiRequire", "has wepkg");
                        WebResourceResponse p = eVar.p(null, optString);
                        if (p != null) {
                            String convertStreamToString = d.convertStreamToString(p.mInputStream);
                            jSONObject.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, p.mResponseHeaders);
                            jSONObject.put("data", convertStreamToString);
                            aVar.c("", jSONObject);
                            eVar.zE(true);
                            AppMethodBeat.o(210955);
                            return;
                        }
                    }
                    e.a Q = com.tencent.mm.plugin.webview.h.e.Q(optString, null);
                    if (Q != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, Q.njn);
                        jSONObject2.put("data", Q.data);
                        aVar.c("", jSONObject2);
                        AppMethodBeat.o(210955);
                        return;
                    }
                    aVar.c("fail", null);
                    AppMethodBeat.o(210955);
                } catch (JSONException e2) {
                    aVar.c("fail", null);
                    AppMethodBeat.o(210955);
                }
            }
        });
        AppMethodBeat.o(210956);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "require";
    }
}
