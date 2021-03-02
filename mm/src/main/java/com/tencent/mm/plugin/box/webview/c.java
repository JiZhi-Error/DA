package com.tencent.mm.plugin.box.webview;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;

public final class c extends ac {
    private qt plO;
    private e plW;

    public c(qt qtVar, e eVar) {
        this.plO = qtVar;
        this.plW = eVar;
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(76352);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "onPageStarted %s %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.b(webView, str, bitmap);
        AppMethodBeat.o(76352);
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str) {
        AppMethodBeat.i(76353);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "onPageFinished %s  %d", str, Long.valueOf(Thread.currentThread().getId()));
        super.b(webView, str);
        AppMethodBeat.o(76353);
    }

    @Override // com.tencent.xweb.ac
    public final boolean a(WebView webView, String str) {
        AppMethodBeat.i(76354);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "shouldOverrideUrlLoading %s", str);
        boolean a2 = super.a(webView, str);
        AppMethodBeat.o(76354);
        return a2;
    }
}
