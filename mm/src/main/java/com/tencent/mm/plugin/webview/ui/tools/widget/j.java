package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

public final class j extends i {
    private final b Jyx;

    public j(MMWebView mMWebView, b bVar) {
        super((MMWebViewWithJsApi) mMWebView);
        AppMethodBeat.i(82128);
        this.Jyx = bVar;
        AppMethodBeat.o(82128);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.widget.i, com.tencent.xweb.x
    public final void d(WebView webView, String str) {
        AppMethodBeat.i(82129);
        if (this.Jyx != null) {
            this.Jyx.Lc(str);
            AppMethodBeat.o(82129);
            return;
        }
        super.d(webView, str);
        AppMethodBeat.o(82129);
    }
}
