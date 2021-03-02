package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public class o extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "disableBounceScroll";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        boolean z = false;
        AppMethodBeat.i(78547);
        Log.i("MicroMsg.JsApiDisableBounceScroll", "invoke");
        JSONArray optJSONArray = aVar.ctb.csi.optJSONArray("place");
        if (optJSONArray == null) {
            Log.i("MicroMsg.JsApiDisableBounceScroll", "placeArray is null");
            aVar.c("fail", null);
            AppMethodBeat.o(78547);
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            if ("top".equalsIgnoreCase(optJSONArray.optString(i2))) {
                z = true;
            } else {
                z = z;
            }
        }
        if (!z) {
            aVar.c("", null);
            AppMethodBeat.o(78547);
            return;
        }
        aVar.cta.gbD();
        aVar.c("", null);
        AppMethodBeat.o(78547);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
