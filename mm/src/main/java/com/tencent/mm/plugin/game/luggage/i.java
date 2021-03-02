package com.tencent.mm.plugin.game.luggage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.tencent.luggage.d.d;
import com.tencent.luggage.d.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.h;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.xweb.WebView;
import org.json.JSONObject;

public class i extends h {
    public i(Context context) {
        super(context);
        AppMethodBeat.i(186846);
        if (this.xyl != null) {
            this.xyl.JLQ = true;
        }
        AppMethodBeat.o(186846);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.h
    public void onAttachedToWindow() {
        AppMethodBeat.i(83026);
        super.onAttachedToWindow();
        getWebCore().a(new d() {
            /* class com.tencent.mm.plugin.game.luggage.i.AnonymousClass1 */

            @Override // com.tencent.luggage.d.d
            public final String name() {
                return "onJsApiReady";
            }

            @Override // com.tencent.luggage.d.d
            public final JSONObject Ld() {
                return null;
            }
        });
        AppMethodBeat.o(83026);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.h
    public void onDetachedFromWindow() {
        AppMethodBeat.i(83027);
        super.onDetachedFromWindow();
        AppMethodBeat.o(83027);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.mm.plugin.game.luggage.g.h
    public final void LE() {
        AppMethodBeat.i(83028);
        getWebCore().ctJ = new q() {
            /* class com.tencent.mm.plugin.game.luggage.i.AnonymousClass2 */

            @Override // com.tencent.luggage.d.q
            public final void cV(String str) {
            }

            @Override // com.tencent.luggage.d.q
            public final void cW(String str) {
            }

            @Override // com.tencent.luggage.d.q
            public final String LJ() {
                AppMethodBeat.i(83025);
                String afA = com.tencent.mm.plugin.appbrand.ac.d.afA("preload_game_adapter.js");
                AppMethodBeat.o(83025);
                return afA;
            }

            @Override // com.tencent.luggage.d.q
            public final WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
                return null;
            }
        };
        if (getWebCore().ctM != null) {
            getWebCore().ctM.a(new LuggageMMLocalResourceProvider());
            getWebCore().ctM.a(new e(com.tencent.mm.plugin.appbrand.ac.d.afA("preload_game_adapter.js")));
        }
        AppMethodBeat.o(83028);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.plugin.game.luggage.g.h, com.tencent.mm.ui.widget.MMWebView, com.tencent.luggage.webview.a
    public void loadUrl(String str) {
        AppMethodBeat.i(186847);
        super.loadUrl(str);
        g.a(getWebCore(), str);
        AppMethodBeat.o(186847);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.h
    public final void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(83029);
        super.b(webView, str, bitmap);
        AppMethodBeat.o(83029);
    }

    @Override // com.tencent.mm.plugin.game.luggage.g.h
    public final void b(WebView webView, String str) {
        AppMethodBeat.i(83030);
        super.b(webView, str);
        AppMethodBeat.o(83030);
    }
}
