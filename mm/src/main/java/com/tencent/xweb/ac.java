package com.tencent.xweb;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.e;

public class ac {
    public e SzO;

    public void h(WebView webView, String str) {
    }

    public void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(156919);
        if (this.SzO == null) {
            AppMethodBeat.o(156919);
            return;
        }
        this.SzO.y(str, bitmap);
        AppMethodBeat.o(156919);
    }

    public void b(WebView webView, String str) {
    }

    public void a(WebView webView, int i2, String str, String str2) {
    }

    public boolean b(WebView webView, int i2, String str, String str2) {
        return false;
    }

    public boolean a(WebView webView, String str) {
        return false;
    }

    public boolean e(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(156920);
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            AppMethodBeat.o(156920);
            return false;
        }
        boolean a2 = a(webView, webResourceRequest.getUrl().toString());
        AppMethodBeat.o(156920);
        return a2;
    }

    public WebResourceResponse c(WebView webView, String str) {
        return null;
    }

    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        return null;
    }

    public void b(WebView webView, String str, boolean z) {
    }

    public void a(WebView webView, r rVar, SslError sslError) {
        AppMethodBeat.i(156921);
        if (rVar != null) {
            rVar.cancel();
        }
        AppMethodBeat.o(156921);
    }

    public void a(WebView webView, float f2, float f3) {
    }

    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        return null;
    }

    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public void a(WebView webView, j jVar, String str, String str2) {
        AppMethodBeat.i(219053);
        jVar.cancel();
        AppMethodBeat.o(219053);
    }

    public void e(WebView webView, String str) {
    }
}
