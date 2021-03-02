package com.tencent.mm.plugin.box.webview;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;

public final class a extends x {
    @Override // com.tencent.xweb.x
    public final void a(WebView webView, int i2) {
    }

    @Override // com.tencent.xweb.x
    public final boolean b(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(76337);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "onJsConfirm %s %s", str, str2);
        boolean b2 = super.b(webView, str, str2, jsResult);
        AppMethodBeat.o(76337);
        return b2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(76338);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "onJsPrompt %s %s", str, str2);
        boolean a2 = super.a(webView, str, str2, str3, oVar);
        AppMethodBeat.o(76338);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(76339);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "onJsAlert %s %s", str, str2);
        boolean a2 = super.a(webView, str, str2, jsResult);
        AppMethodBeat.o(76339);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(76340);
        Log.i("MicroMsg.Box.BoxWebChromeClient", "onConsoleMessage %d %s %s %s", Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.messageLevel().name(), consoleMessage.message(), consoleMessage.sourceId());
        boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(76340);
        return onConsoleMessage;
    }
}
