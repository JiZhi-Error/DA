package com.tencent.mm.plugin.topstory.ui.a;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ar;
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
        AppMethodBeat.i(126549);
        Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsConfirm %s %s", str, str2);
        boolean b2 = super.b(webView, str, str2, jsResult);
        AppMethodBeat.o(126549);
        return b2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(126550);
        Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsPrompt %s %s", str, str2);
        boolean a2 = super.a(webView, str, str2, str3, oVar);
        AppMethodBeat.o(126550);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(126551);
        Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onJsAlert %s %s", str, str2);
        boolean a2 = super.a(webView, str, str2, jsResult);
        AppMethodBeat.o(126551);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(126552);
        Log.i("MicroMsg.TopStory.TopStoryWebChromeClient", "onConsoleMessage %d %s %s %s", Integer.valueOf(consoleMessage.lineNumber()), consoleMessage.messageLevel().name(), consoleMessage.message(), consoleMessage.sourceId());
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR && !Util.isNullOrNil(consoleMessage.message())) {
            e.INSTANCE.a(19153, Integer.valueOf(ai.aft(1)), consoleMessage.messageLevel(), 1);
            if (consoleMessage.message().contains("SyntaxError")) {
                ar.afB(22);
            } else if (consoleMessage.message().contains("Maximum call stack size exceeded")) {
                ar.afB(33);
            }
        }
        boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(126552);
        return onConsoleMessage;
    }
}
