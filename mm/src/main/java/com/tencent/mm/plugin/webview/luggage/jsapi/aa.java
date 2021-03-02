package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.Log;

public class aa extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "hideOptionMenu";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78562);
        Log.i("MicroMsg.JsApiHideOptionMenu", "invoke");
        m gbC = aVar.cta.gbC();
        if (gbC == null) {
            Log.e("MicroMsg.JsApiHideOptionMenu", "actionBar is null");
            aVar.c("fail", null);
            AppMethodBeat.o(78562);
            return;
        }
        gbC.gbX();
        aVar.c("", null);
        AppMethodBeat.o(78562);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
