package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public class at extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "privateOpenWeappFunctionalPage";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78599);
        Log.i("MicroMsg.JsApiPrivateOpenWeappFunctionalPage", "invokeInOwn");
        JSONObject jSONObject = aVar.ctb.csi;
        ((j) com.tencent.mm.kernel.g.af(j.class)).cr(jSONObject.optString("uuid"), jSONObject.optString("req_data"));
        aVar.c("", null);
        aVar.cta.ITD = true;
        AppMethodBeat.o(78599);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
