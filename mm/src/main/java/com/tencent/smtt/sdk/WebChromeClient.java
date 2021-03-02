package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsPromptResult;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.WebStorage;
import com.tencent.smtt.utils.TbsLog;

public class WebChromeClient {
    public void onExceededDatabaseQuota(String str, String str2, long j2, long j3, long j4, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(54044);
        quotaUpdater.updateQuota(j3);
        AppMethodBeat.o(54044);
    }

    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return false;
    }

    public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        return false;
    }

    public void onGeolocationPermissionsHidePrompt() {
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        AppMethodBeat.i(54045);
        geolocationPermissionsCallback.invoke(str, true, true);
        AppMethodBeat.o(54045);
    }

    public void onHideCustomView() {
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public boolean onJsTimeout() {
        return true;
    }

    public void onProgressChanged(WebView webView, int i2) {
    }

    public void onReachedMaxAppCacheSize(long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        AppMethodBeat.i(54046);
        quotaUpdater.updateQuota(j3);
        AppMethodBeat.o(54046);
    }

    public void onReceivedIcon(WebView webView, Bitmap bitmap) {
    }

    public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
    }

    public void onReceivedTitle(WebView webView, String str) {
    }

    public void onRequestFocus(WebView webView) {
    }

    public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public void onShowCustomView(View view, int i2, IX5WebChromeClient.CustomViewCallback customViewCallback) {
    }

    public void onCloseWindow(WebView webView) {
    }

    public View getVideoLoadingProgressView() {
        return null;
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        AppMethodBeat.i(54047);
        valueCallback.onReceiveValue(null);
        AppMethodBeat.o(54047);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, FileChooserParams fileChooserParams) {
        return false;
    }

    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_SAVE = 3;

        public abstract Intent createIntent();

        public abstract String[] getAcceptTypes();

        public abstract String getFilenameHint();

        public abstract int getMode();

        public abstract CharSequence getTitle();

        public abstract boolean isCaptureEnabled();

        public static Uri[] parseResult(int i2, Intent intent) {
            try {
                x a2 = x.a();
                if (a2 != null && a2.b()) {
                    return TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().parseFileChooserResult(i2, intent);
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    return WebChromeClient.FileChooserParams.parseResult(i2, intent);
                }
                return null;
            } catch (Exception e2) {
                TbsLog.i("WebChromeClient", "parseResult:" + e2.toString());
                return null;
            }
        }
    }
}
