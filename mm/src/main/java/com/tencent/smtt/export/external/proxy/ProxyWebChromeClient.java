package com.tencent.smtt.export.external.proxy;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.QuotaUpdater;

public class ProxyWebChromeClient implements IX5WebChromeClient {
    protected IX5WebChromeClient mWebChromeClient;

    public IX5WebChromeClient getmWebChromeClient() {
        return this.mWebChromeClient;
    }

    public void setWebChromeClient(IX5WebChromeClient iX5WebChromeClient) {
        this.mWebChromeClient = iX5WebChromeClient;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(53238);
        if (this.mWebChromeClient != null) {
            boolean onConsoleMessage = this.mWebChromeClient.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(53238);
            return onConsoleMessage;
        }
        AppMethodBeat.o(53238);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onCreateWindow(IX5WebViewBase iX5WebViewBase, boolean z, boolean z2, Message message) {
        AppMethodBeat.i(53239);
        if (this.mWebChromeClient != null) {
            boolean onCreateWindow = this.mWebChromeClient.onCreateWindow(iX5WebViewBase, z, z2, message);
            AppMethodBeat.o(53239);
            return onCreateWindow;
        }
        AppMethodBeat.o(53239);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        AppMethodBeat.i(53240);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
        AppMethodBeat.o(53240);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onHideCustomView() {
        AppMethodBeat.i(53241);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onHideCustomView();
        }
        AppMethodBeat.o(53241);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsAlert(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(53242);
        if (this.mWebChromeClient != null) {
            boolean onJsAlert = this.mWebChromeClient.onJsAlert(iX5WebViewBase, str, str2, jsResult);
            AppMethodBeat.o(53242);
            return onJsAlert;
        }
        AppMethodBeat.o(53242);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsPrompt(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        AppMethodBeat.i(53243);
        if (this.mWebChromeClient != null) {
            boolean onJsPrompt = this.mWebChromeClient.onJsPrompt(iX5WebViewBase, str, str2, str3, jsPromptResult);
            AppMethodBeat.o(53243);
            return onJsPrompt;
        }
        AppMethodBeat.o(53243);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsBeforeUnload(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(53244);
        if (this.mWebChromeClient != null) {
            boolean onJsBeforeUnload = this.mWebChromeClient.onJsBeforeUnload(iX5WebViewBase, str, str2, jsResult);
            AppMethodBeat.o(53244);
            return onJsBeforeUnload;
        }
        AppMethodBeat.o(53244);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsTimeout() {
        AppMethodBeat.i(53245);
        if (this.mWebChromeClient != null) {
            boolean onJsTimeout = this.mWebChromeClient.onJsTimeout();
            AppMethodBeat.o(53245);
            return onJsTimeout;
        }
        AppMethodBeat.o(53245);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onProgressChanged(IX5WebViewBase iX5WebViewBase, int i2) {
        AppMethodBeat.i(53246);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onProgressChanged(iX5WebViewBase, i2);
        }
        AppMethodBeat.o(53246);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReachedMaxAppCacheSize(long j2, long j3, QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(53247);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReachedMaxAppCacheSize(j2, j3, quotaUpdater);
        }
        AppMethodBeat.o(53247);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedIcon(IX5WebViewBase iX5WebViewBase, Bitmap bitmap) {
        AppMethodBeat.i(53248);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReceivedIcon(iX5WebViewBase, bitmap);
        }
        AppMethodBeat.o(53248);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTouchIconUrl(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        AppMethodBeat.i(53249);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReceivedTouchIconUrl(iX5WebViewBase, str, z);
        }
        AppMethodBeat.o(53249);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onReceivedTitle(IX5WebViewBase iX5WebViewBase, String str) {
        AppMethodBeat.i(53250);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onReceivedTitle(iX5WebViewBase, str);
        }
        AppMethodBeat.o(53250);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onRequestFocus(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(53251);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onRequestFocus(iX5WebViewBase);
        }
        AppMethodBeat.o(53251);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(53252);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.o(53252);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onShowCustomView(View view, int i2, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        AppMethodBeat.i(53253);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onShowCustomView(view, customViewCallback);
        }
        AppMethodBeat.o(53253);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(53254);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onExceededDatabaseQuota(str, str2, j2, j3, j4, quotaUpdater);
        }
        AppMethodBeat.o(53254);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onConsoleMessage(String str, int i2, String str2) {
        AppMethodBeat.i(53255);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onConsoleMessage(str, i2, str2);
        }
        AppMethodBeat.o(53255);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        AppMethodBeat.i(53256);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationPermissionsHidePrompt();
        }
        AppMethodBeat.o(53256);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onJsConfirm(IX5WebViewBase iX5WebViewBase, String str, String str2, JsResult jsResult) {
        AppMethodBeat.i(53257);
        if (this.mWebChromeClient != null) {
            boolean onJsConfirm = this.mWebChromeClient.onJsConfirm(iX5WebViewBase, str, str2, jsResult);
            AppMethodBeat.o(53257);
            return onJsConfirm;
        }
        AppMethodBeat.o(53257);
        return false;
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onCloseWindow(IX5WebViewBase iX5WebViewBase) {
        AppMethodBeat.i(53258);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onCloseWindow(iX5WebViewBase);
        }
        AppMethodBeat.o(53258);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
        AppMethodBeat.i(53259);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.getVisitedHistory(valueCallback);
        }
        AppMethodBeat.o(53259);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void openFileChooser(ValueCallback<Uri[]> valueCallback, String str, String str2, boolean z) {
        AppMethodBeat.i(53260);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.openFileChooser(valueCallback, str, str2, z);
        }
        AppMethodBeat.o(53260);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationStartUpdating(ValueCallback<Location> valueCallback, ValueCallback<Bundle> valueCallback2) {
        AppMethodBeat.i(53261);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationStartUpdating(valueCallback, valueCallback2);
        }
        AppMethodBeat.o(53261);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public void onGeolocationStopUpdating() {
        AppMethodBeat.i(53262);
        if (this.mWebChromeClient != null) {
            this.mWebChromeClient.onGeolocationStopUpdating();
        }
        AppMethodBeat.o(53262);
    }

    @Override // com.tencent.smtt.export.external.interfaces.IX5WebChromeClient
    public boolean onShowFileChooser(IX5WebViewBase iX5WebViewBase, ValueCallback<Uri[]> valueCallback, IX5WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }
}
