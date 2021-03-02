package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;

public class bo extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "showOptionMenu";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78637);
        Log.i("MicroMsg.JsApiShowOptionMenu", "invoke");
        m gbC = aVar.cta.gbC();
        if (gbC == null) {
            Log.i("MicroMsg.JsApiShowOptionMenu", "actionBar is null");
            AppMethodBeat.o(78637);
            return;
        }
        gbC.gbY();
        aVar.c("", null);
        AppMethodBeat.o(78637);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
