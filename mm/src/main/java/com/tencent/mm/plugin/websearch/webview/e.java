package com.tencent.mm.plugin.websearch.webview;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.x;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/websearch/webview/WebSearchChromeClient;", "Lcom/tencent/xweb/WebChromeClient;", "()V", "TAG", "", "onConsoleMessage", "", "consoleMessage", "Landroid/webkit/ConsoleMessage;", "ui-websearch_release"})
public final class e extends x {
    private final String TAG = "MicroMsg.WebSearch.WebSearchChromeClient";

    @Override // com.tencent.xweb.x
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        Integer num;
        String str;
        ConsoleMessage.MessageLevel messageLevel;
        String str2 = null;
        AppMethodBeat.i(198058);
        String str3 = this.TAG;
        Object[] objArr = new Object[4];
        if (consoleMessage != null) {
            num = Integer.valueOf(consoleMessage.lineNumber());
        } else {
            num = null;
        }
        objArr[0] = num;
        if (consoleMessage == null || (messageLevel = consoleMessage.messageLevel()) == null || (str = messageLevel.name()) == null) {
            str = "";
        }
        objArr[1] = str;
        objArr[2] = consoleMessage != null ? consoleMessage.message() : null;
        if (consoleMessage != null) {
            str2 = consoleMessage.sourceId();
        }
        objArr[3] = str2;
        Log.i(str3, "onConsoleMessage %d %s %s %s", objArr);
        boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(198058);
        return onConsoleMessage;
    }
}
