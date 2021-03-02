package com.tencent.mm.plugin.game.luggage;

import android.os.Build;
import android.webkit.WebResourceResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.h;
import com.tencent.mm.sdk.platformtools.Log;

public final class c implements com.tencent.luggage.webview.a.c {
    private h xwd;

    public c(h hVar) {
        this.xwd = hVar;
    }

    @Override // com.tencent.luggage.webview.a.c
    public final String Pl() {
        return "weixin://game.js";
    }

    @Override // com.tencent.luggage.webview.a.c
    public final WebResourceResponse cX(String str) {
        boolean z = false;
        AppMethodBeat.i(82986);
        Log.i("MicroMsg.LuggageGameJsResourceProvider", "onResourceRequest, url = %s", str);
        if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(82986);
            return null;
        }
        if (this.xwd.getWePkgPlugin() != null) {
            z = this.xwd.getWePkgPlugin().JLC;
        }
        WebResourceResponse pH = a.pH(z);
        AppMethodBeat.o(82986);
        return pH;
    }
}
