package com.tencent.mm.plugin.webview.d.b;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;

public final class a {
    public WebView IQP = null;
    public boolean ISC = false;

    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final boolean _customEnterFullscreen(boolean z) {
        AppMethodBeat.i(224453);
        Log.i("MicroMsg.CustomFullscreenApi", "_customEnterFullscreen %b", Boolean.valueOf(z));
        boolean zb = zb(z);
        AppMethodBeat.o(224453);
        return zb;
    }

    public final boolean zb(boolean z) {
        AppMethodBeat.i(224454);
        Log.i("MicroMsg.CustomFullscreenApi", "setCustomEnterFullscreen %b", Boolean.valueOf(z));
        if (this.IQP == null || !this.IQP.isXWalkKernel()) {
            AppMethodBeat.o(224454);
            return false;
        } else if (!((b) g.af(b.class)).isMpUrl(this.IQP.getUrl())) {
            AppMethodBeat.o(224454);
            return false;
        } else {
            this.IQP.disableVideoJsCallback(z);
            this.ISC = z;
            AppMethodBeat.o(224454);
            return true;
        }
    }
}
