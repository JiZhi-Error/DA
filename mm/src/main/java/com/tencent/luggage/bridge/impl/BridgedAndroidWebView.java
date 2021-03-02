package com.tencent.luggage.bridge.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.bridge.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class BridgedAndroidWebView extends BridgedAndroidWebViewBase {
    private o csD;
    private WebChromeClient csS;
    private WebViewClient mWebViewClient;

    public BridgedAndroidWebView(Context context) {
        this(context, null);
    }

    public BridgedAndroidWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BridgedAndroidWebView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(140352);
        this.mWebViewClient = new WebViewClient() {
            /* class com.tencent.luggage.bridge.impl.BridgedAndroidWebView.AnonymousClass1 */

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(140349);
                o unused = BridgedAndroidWebView.this.csD;
                AppMethodBeat.o(140349);
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.i(140350);
                BridgedAndroidWebView.this.csD.csK.onReady();
                AppMethodBeat.o(140350);
            }
        };
        this.csS = new WebChromeClient() {
            /* class com.tencent.luggage.bridge.impl.BridgedAndroidWebView.AnonymousClass2 */

            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                AppMethodBeat.i(140351);
                String cO = BridgedAndroidWebView.this.csD.csK.cO(str2);
                if (cO != null) {
                    jsPromptResult.confirm(cO);
                    AppMethodBeat.o(140351);
                    return true;
                }
                AppMethodBeat.o(140351);
                return false;
            }
        };
        this.csD = new o(this);
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(this.csS);
        AppMethodBeat.o(140352);
    }

    public o getBridge() {
        return this.csD;
    }
}
