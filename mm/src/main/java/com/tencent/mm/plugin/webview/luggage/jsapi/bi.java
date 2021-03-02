package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class bi extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setPageTitle";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78627);
        Log.i("MicroMsg.JsApiSetPageTitle", "invokeInOwn");
        String optString = aVar.ctb.csi.optString("title");
        if (!Util.isNullOrNil(aVar.ctb.csi.optString("color"))) {
            aVar.cta.ec(optString, e.gw(aVar.ctb.csi.optString("color"), aVar.cta.mContext.getResources().getColor(R.color.bk)));
        } else {
            aVar.cta.ec(optString, 0);
        }
        aVar.c("", null);
        AppMethodBeat.o(78627);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
