package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.f.h;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class ai extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "log";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
        AppMethodBeat.i(78579);
        final JSONObject jSONObject = aVar.ctb.csi;
        h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.ai.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(210947);
                Log.i("MicroMsg.JsApiLog", "jslog : " + jSONObject.optString("msg"));
                AppMethodBeat.o(210947);
            }
        });
        AppMethodBeat.o(78579);
    }
}
