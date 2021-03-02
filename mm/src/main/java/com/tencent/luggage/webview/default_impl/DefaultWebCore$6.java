package com.tencent.luggage.webview.default_impl;

import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public class DefaultWebCore$6 extends WebChromeClient {
    final /* synthetic */ a.AbstractC0187a cDx;
    final /* synthetic */ a cDy;

    DefaultWebCore$6(a aVar, a.AbstractC0187a aVar2) {
        this.cDy = aVar;
        this.cDx = aVar2;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(140542);
        String cY = this.cDx.cY(str2);
        if (cY == null) {
            AppMethodBeat.o(140542);
            return false;
        }
        jsPromptResult.confirm(cY);
        AppMethodBeat.o(140542);
        return true;
    }
}
