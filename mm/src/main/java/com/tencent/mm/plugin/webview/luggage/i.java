package com.tencent.mm.plugin.webview.luggage;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;

public class i extends ac {
    private ac Ban = new ac();

    public i() {
        AppMethodBeat.i(78342);
        AppMethodBeat.o(78342);
    }

    public final void a(ac acVar) {
        if (acVar != null) {
            this.Ban = acVar;
        }
    }

    @Override // com.tencent.xweb.ac
    public void h(WebView webView, String str) {
        AppMethodBeat.i(78343);
        this.Ban.h(webView, str);
        AppMethodBeat.o(78343);
    }

    @Override // com.tencent.xweb.ac
    public void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(78344);
        this.Ban.b(webView, str, bitmap);
        AppMethodBeat.o(78344);
    }

    @Override // com.tencent.xweb.ac
    public void b(WebView webView, String str) {
        AppMethodBeat.i(78345);
        this.Ban.b(webView, str);
        AppMethodBeat.o(78345);
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, int i2, String str, String str2) {
        AppMethodBeat.i(78346);
        this.Ban.a(webView, i2, str, str2);
        AppMethodBeat.o(78346);
    }

    @Override // com.tencent.xweb.ac
    public boolean a(WebView webView, String str) {
        AppMethodBeat.i(78347);
        boolean a2 = this.Ban.a(webView, str);
        AppMethodBeat.o(78347);
        return a2;
    }

    @Override // com.tencent.xweb.ac
    public final boolean e(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(210916);
        boolean e2 = this.Ban.e(webView, webResourceRequest);
        AppMethodBeat.o(210916);
        return e2;
    }

    @Override // com.tencent.xweb.ac
    public WebResourceResponse c(WebView webView, String str) {
        AppMethodBeat.i(78348);
        WebResourceResponse c2 = this.Ban.c(webView, str);
        AppMethodBeat.o(78348);
        return c2;
    }

    @Override // com.tencent.xweb.ac
    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(78349);
        WebResourceResponse a2 = this.Ban.a(webView, webResourceRequest);
        AppMethodBeat.o(78349);
        return a2;
    }

    @Override // com.tencent.xweb.ac
    public WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(78350);
        WebResourceResponse a2 = this.Ban.a(webView, webResourceRequest, bundle);
        AppMethodBeat.o(78350);
        return a2;
    }

    @Override // com.tencent.xweb.ac
    public final void b(WebView webView, String str, boolean z) {
        AppMethodBeat.i(78351);
        this.Ban.b(webView, str, z);
        AppMethodBeat.o(78351);
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, r rVar, SslError sslError) {
        AppMethodBeat.i(78352);
        this.Ban.a(webView, rVar, sslError);
        AppMethodBeat.o(78352);
    }

    @Override // com.tencent.xweb.ac
    public final void a(WebView webView, float f2, float f3) {
        AppMethodBeat.i(78353);
        this.Ban.a(webView, f2, f3);
        AppMethodBeat.o(78353);
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        AppMethodBeat.i(78354);
        this.Ban.a(webView, webResourceRequest, webResourceResponse);
        AppMethodBeat.o(78354);
    }
}
