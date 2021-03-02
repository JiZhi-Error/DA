package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.av;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public class e extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(160421);
        Log.i("MicroMsg.Predownload.WebViewJsApiBatchPreloadMiniProgram", "invokeInOwn");
        JSONObject jSONObject = aVar.ctb.csi;
        if (jSONObject == null) {
            AppMethodBeat.o(160421);
            return;
        }
        String preload = ((IAppBrandBatchPreloadController) com.tencent.mm.kernel.g.af(IAppBrandBatchPreloadController.class)).preload(jSONObject, true);
        if (Util.isNullOrNil(preload)) {
            aVar.c("error", null);
            AppMethodBeat.o(160421);
        } else if ("ok".equalsIgnoreCase(preload)) {
            aVar.c("", null);
            AppMethodBeat.o(160421);
        } else {
            aVar.c(preload, null);
            AppMethodBeat.o(160421);
        }
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return av.NAME;
    }
}
