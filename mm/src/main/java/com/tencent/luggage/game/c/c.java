package com.tencent.luggage.game.c;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements g {
    private WebView cuY;

    @Override // com.tencent.luggage.game.c.g
    public final void aF(Context context) {
        AppMethodBeat.i(130503);
        this.cuY = new WebView(context);
        AppMethodBeat.o(130503);
    }

    @Override // com.tencent.luggage.game.c.g
    public final View getView() {
        return this.cuY;
    }

    @Override // com.tencent.luggage.game.c.g
    public final g.a Ma() {
        AppMethodBeat.i(130504);
        final WebSettings settings = this.cuY.getSettings();
        AnonymousClass1 r1 = new g.a() {
            /* class com.tencent.luggage.game.c.c.AnonymousClass1 */

            @Override // com.tencent.luggage.game.c.g.a
            public final void Mb() {
                AppMethodBeat.i(130500);
                settings.setJavaScriptEnabled(true);
                AppMethodBeat.o(130500);
            }
        };
        AppMethodBeat.o(130504);
        return r1;
    }

    @Override // com.tencent.luggage.game.c.g
    public final void a(final g.b bVar) {
        AppMethodBeat.i(130505);
        this.cuY.setWebViewClient(new WebViewClient() {
            /* class com.tencent.luggage.game.c.c.AnonymousClass2 */

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(130501);
                if (bVar.dn(webResourceRequest.getUrl().toString())) {
                    g.b.a dr = bVar.dr(g.b.cvx);
                    WebResourceResponse webResourceResponse = new WebResourceResponse(dr.mimeType, dr.charset, dr.aFm);
                    AppMethodBeat.o(130501);
                    return webResourceResponse;
                }
                AppMethodBeat.o(130501);
                return null;
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.i(130502);
                bVar.LZ();
                AppMethodBeat.o(130502);
            }
        });
        AppMethodBeat.o(130505);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void loadUrl(String str) {
        AppMethodBeat.i(130506);
        this.cuY.loadUrl(str);
        AppMethodBeat.o(130506);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void setTranslationY(float f2) {
        AppMethodBeat.i(130507);
        this.cuY.setTranslationY(f2);
        AppMethodBeat.o(130507);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void setVisibility(int i2) {
        AppMethodBeat.i(130508);
        this.cuY.setVisibility(i2);
        AppMethodBeat.o(130508);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void requestLayout() {
        AppMethodBeat.i(130509);
        this.cuY.requestLayout();
        AppMethodBeat.o(130509);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void dp(String str) {
        AppMethodBeat.i(130510);
        this.cuY.evaluateJavascript(str, null);
        AppMethodBeat.o(130510);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void destroy() {
        AppMethodBeat.i(130511);
        this.cuY.destroy();
        AppMethodBeat.o(130511);
    }
}
