package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;

public class h extends br<a> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<a>.a aVar) {
        AppMethodBeat.i(186855);
        Log.i("MicroMsg.JsApiCloseJsCore", "invokeInOwn");
        if (com.tencent.mm.plugin.game.luggage.i.a.dTW() != null) {
            com.tencent.mm.plugin.game.luggage.i.a.dTW().dTX();
        }
        AppMethodBeat.o(186855);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "closeJsCore";
    }
}
