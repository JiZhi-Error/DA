package com.tencent.mm.plugin.fts.ui.e;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;

public final class b extends x {
    @Override // com.tencent.xweb.x
    public final void a(WebView webView, int i2) {
    }

    @Override // com.tencent.xweb.x
    public final boolean b(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(176915);
        Log.i("MicroMsg.FTS.PardusWebChromeClient", "onJsConfirm %s %s", str, str2);
        boolean b2 = super.b(webView, str, str2, jsResult);
        AppMethodBeat.o(176915);
        return b2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(176916);
        Log.i("MicroMsg.FTS.PardusWebChromeClient", "onJsPrompt %s %s", str, str2);
        boolean a2 = super.a(webView, str, str2, str3, oVar);
        AppMethodBeat.o(176916);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(176917);
        Log.i("MicroMsg.FTS.PardusWebChromeClient", "onJsAlert %s %s", str, str2);
        boolean a2 = super.a(webView, str, str2, jsResult);
        AppMethodBeat.o(176917);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(176918);
        Log.i("MicroMsg.FTS.PardusWebChromeClient", "onConsoleMessage %d %s %s %s", Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.messageLevel().name(), consoleMessage.message(), consoleMessage.sourceId());
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR && !Util.isNullOrNil(consoleMessage.message())) {
            e.INSTANCE.a(19153, Integer.valueOf(ai.aft(5)), consoleMessage.messageLevel(), 2);
            if (!consoleMessage.message().contains("SyntaxError")) {
                consoleMessage.message().contains("Maximum call stack size exceeded");
            }
        }
        boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(176918);
        return onConsoleMessage;
    }
}
