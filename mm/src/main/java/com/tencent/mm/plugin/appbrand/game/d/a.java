package com.tencent.mm.plugin.appbrand.game.d;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.game.c.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.z;

public final class a implements g {
    private WebView lsg;

    @Override // com.tencent.luggage.game.c.g
    public final void aF(Context context) {
        AppMethodBeat.i(45120);
        this.lsg = new WebView(context);
        AppMethodBeat.o(45120);
    }

    @Override // com.tencent.luggage.game.c.g
    public final View getView() {
        return this.lsg;
    }

    @Override // com.tencent.luggage.game.c.g
    public final g.a Ma() {
        AppMethodBeat.i(45121);
        final z settings = this.lsg.getSettings();
        AnonymousClass1 r1 = new g.a() {
            /* class com.tencent.mm.plugin.appbrand.game.d.a.AnonymousClass1 */

            @Override // com.tencent.luggage.game.c.g.a
            public final void Mb() {
                AppMethodBeat.i(45114);
                settings.setJavaScriptEnabled(true);
                AppMethodBeat.o(45114);
            }
        };
        AppMethodBeat.o(45121);
        return r1;
    }

    @Override // com.tencent.luggage.game.c.g
    public final void a(final g.b bVar) {
        AppMethodBeat.i(45122);
        this.lsg.setWebViewClient(new ac() {
            /* class com.tencent.mm.plugin.appbrand.game.d.a.AnonymousClass2 */

            @Override // com.tencent.xweb.ac
            public final WebResourceResponse c(WebView webView, String str) {
                AppMethodBeat.i(45115);
                WebResourceResponse YL = YL(str);
                AppMethodBeat.o(45115);
                return YL;
            }

            @Override // com.tencent.xweb.ac
            public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
                AppMethodBeat.i(45116);
                WebResourceResponse YL = YL(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(45116);
                return YL;
            }

            @Override // com.tencent.xweb.ac
            public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(45117);
                WebResourceResponse YL = YL(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(45117);
                return YL;
            }

            private WebResourceResponse YL(String str) {
                AppMethodBeat.i(45118);
                if (bVar.dn(str)) {
                    g.b.a dr = bVar.dr(g.b.cvx);
                    WebResourceResponse webResourceResponse = new WebResourceResponse(dr.mimeType, dr.charset, dr.aFm);
                    AppMethodBeat.o(45118);
                    return webResourceResponse;
                }
                AppMethodBeat.o(45118);
                return null;
            }

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(45119);
                bVar.LZ();
                AppMethodBeat.o(45119);
            }
        });
        AppMethodBeat.o(45122);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void loadUrl(String str) {
        AppMethodBeat.i(45123);
        this.lsg.loadUrl(str);
        AppMethodBeat.o(45123);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void setTranslationY(float f2) {
        AppMethodBeat.i(45124);
        this.lsg.setTranslationY(f2);
        AppMethodBeat.o(45124);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void setVisibility(int i2) {
        AppMethodBeat.i(45125);
        this.lsg.setVisibility(i2);
        AppMethodBeat.o(45125);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void requestLayout() {
        AppMethodBeat.i(45126);
        this.lsg.requestLayout();
        AppMethodBeat.o(45126);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void dp(String str) {
        AppMethodBeat.i(45127);
        this.lsg.evaluateJavascript(str, null);
        AppMethodBeat.o(45127);
    }

    @Override // com.tencent.luggage.game.c.g
    public final void destroy() {
        AppMethodBeat.i(45128);
        this.lsg.destroy();
        AppMethodBeat.o(45128);
    }
}
