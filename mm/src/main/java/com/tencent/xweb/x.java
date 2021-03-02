package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.e;

public class x {
    e SzO;

    public static abstract class a {
        public abstract String[] getAcceptTypes();

        public abstract int getMode();

        public abstract boolean isCaptureEnabled();
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean b(long j2, String str, String str2, String str3) {
        return true;
    }

    public boolean c(String str, String str2, String str3, String str4, String str5, String str6) {
        return true;
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        AppMethodBeat.i(156774);
        callback.invoke(str, true, true);
        AppMethodBeat.o(156774);
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onHideCustomView() {
        AppMethodBeat.i(156775);
        if (this.SzO != null) {
            this.SzO.onHideCustomView();
        }
        AppMethodBeat.o(156775);
    }

    public boolean a(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(156776);
        if (this.SzO != null) {
            boolean a2 = this.SzO.a(str, str2, jsResult);
            AppMethodBeat.o(156776);
            return a2;
        }
        AppMethodBeat.o(156776);
        return false;
    }

    public boolean b(WebView webView, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(156777);
        if (this.SzO != null) {
            boolean b2 = this.SzO.b(str, str2, jsResult);
            AppMethodBeat.o(156777);
            return b2;
        }
        AppMethodBeat.o(156777);
        return false;
    }

    public boolean a(WebView webView, String str, String str2, String str3, o oVar) {
        AppMethodBeat.i(156778);
        if (this.SzO != null) {
            boolean a2 = this.SzO.a(str, str2, str3, oVar);
            AppMethodBeat.o(156778);
            return a2;
        }
        AppMethodBeat.o(156778);
        return false;
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(156779);
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(156779);
    }

    public void b(WebView webView, int i2) {
    }

    public boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, a aVar) {
        return false;
    }

    public void a(WebView webView, int i2) {
    }

    public void d(WebView webView, String str) {
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(156780);
        if (this.SzO != null) {
            this.SzO.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.o(156780);
    }

    public boolean a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (this.SzO != null) {
        }
        return false;
    }

    public boolean bLA() {
        if (this.SzO != null) {
        }
        return false;
    }

    public void onExitFullscreenVideo(Bitmap bitmap) {
    }
}
