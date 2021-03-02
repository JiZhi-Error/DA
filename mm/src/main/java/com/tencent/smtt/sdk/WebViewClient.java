package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;

public class WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;
    public static final int INTERCEPT_BY_ISP = -16;

    /* renamed from: a  reason: collision with root package name */
    k f1939a;

    public void onLoadResource(WebView webView, String str) {
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(54648);
        if (this.f1939a != null) {
            boolean shouldOverrideUrlLoading = this.f1939a.shouldOverrideUrlLoading(webView.c(), webResourceRequest.getUrl().toString());
            AppMethodBeat.o(54648);
            return shouldOverrideUrlLoading;
        }
        boolean shouldOverrideUrlLoading2 = shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        AppMethodBeat.o(54648);
        return shouldOverrideUrlLoading2;
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(54649);
        if (this.f1939a != null) {
            this.f1939a.a(webView, str, bitmap);
        }
        AppMethodBeat.o(54649);
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onReceivedError(WebView webView, int i2, String str, String str2) {
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        AppMethodBeat.i(54650);
        if (this.f1939a != null) {
            if (webResourceRequest.isForMainFrame()) {
                this.f1939a.onReceivedError(webView.c(), webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
                AppMethodBeat.o(54650);
                return;
            }
        } else if (webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
        AppMethodBeat.o(54650);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return null;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(54651);
        if (this.f1939a != null) {
            WebResourceResponse shouldInterceptRequest = this.f1939a.shouldInterceptRequest(webView.c(), webResourceRequest.getUrl().toString());
            AppMethodBeat.o(54651);
            return shouldInterceptRequest;
        }
        WebResourceResponse shouldInterceptRequest2 = shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        AppMethodBeat.o(54651);
        return shouldInterceptRequest2;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(54652);
        if (this.f1939a != null) {
            WebResourceResponse shouldInterceptRequest = this.f1939a.shouldInterceptRequest(webView.c(), webResourceRequest);
            AppMethodBeat.o(54652);
            return shouldInterceptRequest;
        }
        AppMethodBeat.o(54652);
        return null;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        AppMethodBeat.i(54653);
        message.sendToTarget();
        AppMethodBeat.o(54653);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        AppMethodBeat.i(54654);
        httpAuthHandler.cancel();
        AppMethodBeat.o(54654);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        AppMethodBeat.i(54655);
        sslErrorHandler.cancel();
        AppMethodBeat.o(54655);
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        AppMethodBeat.i(54656);
        clientCertRequest.cancel();
        AppMethodBeat.o(54656);
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
    }

    public void onDetectedBlankScreen(String str, int i2) {
    }

    public void onPageCommitVisible(WebView webView, String str) {
    }
}
