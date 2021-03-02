package com.tencent.mm.plugin.webview.d;

import android.webkit.JavascriptInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i implements c {
    public c IRQ;

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _sendMessage(String str) {
        AppMethodBeat.i(194244);
        if (this.IRQ != null) {
            this.IRQ._sendMessage(str);
        }
        AppMethodBeat.o(194244);
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getAllHosts(String str) {
        AppMethodBeat.i(194245);
        if (this.IRQ != null) {
            this.IRQ._getAllHosts(str);
        }
        AppMethodBeat.o(194245);
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _getHtmlContent(String str) {
        AppMethodBeat.i(194246);
        if (this.IRQ != null) {
            this.IRQ._getHtmlContent(str);
        }
        AppMethodBeat.o(194246);
    }

    @Override // com.tencent.mm.plugin.webview.d.c
    @JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final void _ready(boolean z) {
        AppMethodBeat.i(194247);
        if (this.IRQ != null) {
            this.IRQ._ready(z);
        }
        AppMethodBeat.o(194247);
    }
}
