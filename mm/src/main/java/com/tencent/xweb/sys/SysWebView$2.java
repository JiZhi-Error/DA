package com.tencent.xweb.sys;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.xweb.WebView;
import com.tencent.xweb.sys.c;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;

/* access modifiers changed from: package-private */
public class SysWebView$2 extends WebChromeClient {
    final /* synthetic */ e SEv;

    SysWebView$2(e eVar) {
        this.SEv = eVar;
    }

    public void onProgressChanged(WebView webView, int i2) {
        AppMethodBeat.i(153691);
        if (this.SEv.SEo != null) {
            this.SEv.SEo.a(this.SEv.SEl, i2);
            AppMethodBeat.o(153691);
            return;
        }
        super.onProgressChanged(webView, i2);
        AppMethodBeat.o(153691);
    }

    public void onReceivedTitle(WebView webView, String str) {
        AppMethodBeat.i(153692);
        Log.i("SysWebView", "onReceivedTitle: ".concat(String.valueOf(str)));
        if (this.SEv.SEs != null) {
            this.SEv.SEs.bk(true, this.SEv.SEl.getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS);
        }
        if (this.SEv.SEo != null) {
            this.SEv.SEo.d(this.SEv.SEl, str);
            AppMethodBeat.o(153692);
            return;
        }
        super.onReceivedTitle(webView, str);
        AppMethodBeat.o(153692);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(153693);
        Log.i("SysWebView", "onShowCustomView");
        this.SEv.SBX = true;
        boolean z = false;
        if (this.SEv.SEo != null) {
            z = this.SEv.SEo.a(view, customViewCallback);
        }
        h.huh();
        if (z) {
            Log.i("SysWebView", "onShowCustomView isHandled:true");
            AppMethodBeat.o(153693);
        } else if (this.SEv.SEs != null) {
            this.SEv.SEs.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(153693);
        } else if (this.SEv.SEo != null) {
            this.SEv.SEo.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(153693);
        } else {
            super.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(153693);
        }
    }

    public void onHideCustomView() {
        boolean z = false;
        AppMethodBeat.i(153694);
        Log.i("SysWebView", "onHideCustomView");
        this.SEv.SBX = false;
        if (this.SEv.SEo != null) {
            z = this.SEv.SEo.bLA();
        }
        if (z) {
            Log.i("SysWebView", "onHideCustomView isHandled:true");
            AppMethodBeat.o(153694);
        } else if (this.SEv.SEs != null) {
            this.SEv.SEs.onHideCustomView();
            AppMethodBeat.o(153694);
        } else if (this.SEv.SEo != null) {
            this.SEv.SEo.onHideCustomView();
            AppMethodBeat.o(153694);
        } else {
            super.onHideCustomView();
            AppMethodBeat.o(153694);
        }
    }

    public boolean onJsAlert(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(153695);
        Log.i("SysWebView", "onJsAlert");
        if (this.SEv.SEo != null) {
            boolean a2 = this.SEv.SEo.a(this.SEv.SEl, str, str2, new c.e(jsResult));
            AppMethodBeat.o(153695);
            return a2;
        }
        boolean onJsAlert = super.onJsAlert(webView, str, str2, jsResult);
        AppMethodBeat.o(153695);
        return onJsAlert;
    }

    public boolean onJsConfirm(android.webkit.WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(153696);
        Log.i("SysWebView", "onJsConfirm");
        if (this.SEv.SEo != null) {
            boolean b2 = this.SEv.SEo.b(this.SEv.SEl, str, str2, new c.e(jsResult));
            AppMethodBeat.o(153696);
            return b2;
        }
        boolean onJsConfirm = super.onJsConfirm(webView, str, str2, jsResult);
        AppMethodBeat.o(153696);
        return onJsConfirm;
    }

    public boolean onJsPrompt(android.webkit.WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(153697);
        Log.i("SysWebView", "onJsPrompt");
        if (this.SEv.SEo != null) {
            boolean a2 = this.SEv.SEo.a(this.SEv.SEl, str, str2, str3, new c.d(jsPromptResult));
            AppMethodBeat.o(153697);
            return a2;
        }
        boolean onJsPrompt = super.onJsPrompt(webView, str, str2, str3, jsPromptResult);
        AppMethodBeat.o(153697);
        return onJsPrompt;
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        AppMethodBeat.i(153698);
        Log.i("SysWebView", "onGeolocationPermissionsShowPrompt");
        if (this.SEv.SEo != null) {
            this.SEv.SEo.onGeolocationPermissionsShowPrompt(str, callback);
            AppMethodBeat.o(153698);
            return;
        }
        super.onGeolocationPermissionsShowPrompt(str, callback);
        AppMethodBeat.o(153698);
    }

    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(153699);
        Log.i("SysWebView", "onGeolocationPermissionsHidePrompt");
        if (this.SEv.SEo != null) {
            this.SEv.SEo.onGeolocationPermissionsHidePrompt();
            AppMethodBeat.o(153699);
            return;
        }
        super.onGeolocationPermissionsHidePrompt();
        AppMethodBeat.o(153699);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(153700);
        Log.i("SysWebView", "onConsoleMessage " + consoleMessage.message());
        if (this.SEv.SEo != null) {
            boolean onConsoleMessage = this.SEv.SEo.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(153700);
            return onConsoleMessage;
        }
        boolean onConsoleMessage2 = super.onConsoleMessage(consoleMessage);
        AppMethodBeat.o(153700);
        return onConsoleMessage2;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        AppMethodBeat.i(153701);
        Log.i("SysWebView", "openFileChooser with one param");
        if (this.SEv.SEo != null) {
            this.SEv.SEo.openFileChooser(valueCallback, null, null);
            AppMethodBeat.o(153701);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(153701);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        AppMethodBeat.i(153702);
        Log.i("SysWebView", "openFileChooser with two param");
        if (this.SEv.SEo != null) {
            this.SEv.SEo.openFileChooser(valueCallback, str, null);
            AppMethodBeat.o(153702);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(153702);
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(153703);
        Log.i("SysWebView", "openFileChooser with three param");
        if (this.SEv.SEo != null) {
            this.SEv.SEo.openFileChooser(valueCallback, str, str2);
            AppMethodBeat.o(153703);
            return;
        }
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(153703);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(android.webkit.WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        AppMethodBeat.i(153704);
        Log.i("SysWebView", "onShowFileChooser last method");
        if (this.SEv.SEo != null) {
            boolean a2 = this.SEv.SEo.a(this.SEv.SEl, valueCallback, new c.C2232c(fileChooserParams));
            AppMethodBeat.o(153704);
            return a2;
        }
        boolean onShowFileChooser = super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        AppMethodBeat.o(153704);
        return onShowFileChooser;
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(153705);
        if (this.SEv.SEo != null) {
            View videoLoadingProgressView = this.SEv.SEo.getVideoLoadingProgressView();
            AppMethodBeat.o(153705);
            return videoLoadingProgressView;
        }
        View inflate = LayoutInflater.from(this.SEv.SEl.getContext()).inflate(R.layout.c5l, (ViewGroup) null);
        AppMethodBeat.o(153705);
        return inflate;
    }
}
