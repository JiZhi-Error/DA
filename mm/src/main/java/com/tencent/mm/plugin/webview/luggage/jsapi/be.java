package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.y;
import com.tencent.mm.sdk.platformtools.Util;

public class be extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "setDesktopInfo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78624);
        String optString = aVar.ctb.csi.optString("title");
        String optString2 = aVar.ctb.csi.optString("icon_url");
        String optString3 = aVar.ctb.csi.optString("jump_url");
        y yVar = new y();
        if (!Util.isNullOrNil(optString)) {
            yVar.title = optString;
        }
        if (!Util.isNullOrNil(optString2)) {
            yVar.iconUrl = optString2;
        }
        if (!Util.isNullOrNil(optString3)) {
            yVar.jumpUrl = optString3;
        }
        aVar.c("", null);
        AppMethodBeat.o(78624);
    }
}
