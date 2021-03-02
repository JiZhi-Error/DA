package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONArray;

public class z extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "hideMenuItems";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78561);
        Log.i("MicroMsg.JsApiHideMenuItems", "invokeInOwn");
        JSONArray optJSONArray = aVar.ctb.csi.optJSONArray("menuList");
        if (optJSONArray == null) {
            Log.i("MicroMsg.JsApiHideMenuItems", "data is null");
            aVar.c("invalid_data", null);
            AppMethodBeat.o(78561);
            return;
        }
        m gbC = aVar.cta.gbC();
        if (gbC != null) {
            gbC.T(optJSONArray);
        }
        aVar.c("", null);
        AppMethodBeat.o(78561);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
