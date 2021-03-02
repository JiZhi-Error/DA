package com.tencent.mm.plugin.webview.luggage;

import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;

public class f extends x {
    private x ITc = new x();

    public f() {
        AppMethodBeat.i(78223);
        AppMethodBeat.o(78223);
    }

    public final void a(x xVar) {
        if (xVar != null) {
            this.ITc = xVar;
        }
    }

    @Override // com.tencent.xweb.x
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(78224);
        boolean onConsoleMessage = this.ITc.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(78224);
        return onConsoleMessage;
    }

    @Override // com.tencent.xweb.x
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        AppMethodBeat.i(78225);
        this.ITc.onGeolocationPermissionsShowPrompt(str, callback);
        AppMethodBeat.o(78225);
    }

    @Override // com.tencent.xweb.x
    public final void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(210872);
        this.ITc.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(210872);
    }

    @Override // com.tencent.xweb.x
    public final void onHideCustomView() {
        AppMethodBeat.i(78226);
        this.ITc.onHideCustomView();
        AppMethodBeat.o(78226);
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(78227);
        boolean a2 = this.ITc.a(webView, str, str2, jsResult);
        AppMethodBeat.o(78227);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final boolean b(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(78228);
        boolean b2 = this.ITc.b(webView, str, str2, jsResult);
        AppMethodBeat.o(78228);
        return b2;
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(78229);
        boolean a2 = this.ITc.a(webView, str, str2, str3, oVar);
        AppMethodBeat.o(78229);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final View getVideoLoadingProgressView() {
        AppMethodBeat.i(78230);
        View videoLoadingProgressView = this.ITc.getVideoLoadingProgressView();
        AppMethodBeat.o(78230);
        return videoLoadingProgressView;
    }

    @Override // com.tencent.xweb.x
    public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(78231);
        this.ITc.openFileChooser(valueCallback, str, str2);
        AppMethodBeat.o(78231);
    }

    @Override // com.tencent.xweb.x
    public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, x.a aVar) {
        AppMethodBeat.i(78232);
        boolean a2 = this.ITc.a(webView, valueCallback, aVar);
        AppMethodBeat.o(78232);
        return a2;
    }

    @Override // com.tencent.xweb.x
    public final void a(WebView webView, int i2) {
        AppMethodBeat.i(78233);
        this.ITc.a(webView, i2);
        AppMethodBeat.o(78233);
    }

    @Override // com.tencent.xweb.x
    public void d(WebView webView, String str) {
        AppMethodBeat.i(78234);
        this.ITc.d(webView, str);
        AppMethodBeat.o(78234);
    }

    @Override // com.tencent.xweb.x
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(78235);
        this.ITc.onShowCustomView(view, customViewCallback);
        AppMethodBeat.o(78235);
    }
}
