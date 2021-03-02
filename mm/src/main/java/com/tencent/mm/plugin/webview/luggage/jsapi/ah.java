package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class ah extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return f.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
        int i2 = 1;
        AppMethodBeat.i(78578);
        Log.i("MicroMsg.JsApiLaunchMiniProgram", "invoke");
        JSONObject Zc = com.tencent.mm.plugin.webview.luggage.c.b.Zc(str);
        if (Zc == null) {
            Log.e("MicroMsg.JsApiLaunchMiniProgram", "data is null");
            aVar.i("fail_null_data", null);
            AppMethodBeat.o(78578);
            return;
        }
        String optString = Zc.optString("targetAppId");
        String optString2 = Zc.optString("currentUrl");
        String optString3 = Zc.optString("preVerifyAppId");
        if (Util.isNullOrNil(optString3)) {
            optString3 = Zc.optString("referrerAppId");
        }
        if (Util.isNullOrNil(optString)) {
            aVar.i("invalid_targetAppId", null);
            AppMethodBeat.o(78578);
        } else if (Util.isNullOrNil(optString3)) {
            aVar.i("invalid_referrerAppId", null);
            AppMethodBeat.o(78578);
        } else {
            String nullAsNil = Util.nullAsNil(Zc.optString("envVersion"));
            char c2 = 65535;
            switch (nullAsNil.hashCode()) {
                case 110628630:
                    if (nullAsNil.equals("trial")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1559690845:
                    if (nullAsNil.equals("develop")) {
                        c2 = 0;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    break;
                case 1:
                    i2 = 2;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            ((r) com.tencent.mm.kernel.g.af(r.class)).b(context, optString2, optString3, optString, i2, Zc.optString("path"), 0);
            aVar.i(null, null);
            AppMethodBeat.o(78578);
        }
    }
}
