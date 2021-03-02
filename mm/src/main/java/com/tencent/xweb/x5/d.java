package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal;
import org.xwalk.core.Log;

public final class d implements CookieInternal.ICookieManagerInternal {
    CookieManager SEY = CookieManager.getInstance();

    public d() {
        AppMethodBeat.i(153834);
        AppMethodBeat.o(153834);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void hsq() {
        AppMethodBeat.i(153835);
        this.SEY.setAcceptCookie(true);
        AppMethodBeat.o(153835);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void e(WebView webView) {
        AppMethodBeat.i(153836);
        if (webView == null) {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is null");
            AppMethodBeat.o(153836);
            return;
        }
        View webViewUI = webView.getWebViewUI();
        if (!(webViewUI instanceof com.tencent.smtt.sdk.WebView)) {
            Log.e("X5CookieManagerWrapper", "setAcceptThirdPartyCookies: the webview is not x5 webview");
            AppMethodBeat.o(153836);
            return;
        }
        this.SEY.setAcceptThirdPartyCookies((com.tencent.smtt.sdk.WebView) webViewUI, true);
        AppMethodBeat.o(153836);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void removeAllCookie() {
        AppMethodBeat.i(153837);
        this.SEY.removeAllCookie();
        AppMethodBeat.o(153837);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final String getCookie(String str) {
        AppMethodBeat.i(153838);
        String cookie = this.SEY.getCookie(str);
        AppMethodBeat.o(153838);
        return cookie;
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void setCookie(String str, String str2) {
        AppMethodBeat.i(153839);
        this.SEY.setCookie(str, str2);
        AppMethodBeat.o(153839);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void removeSessionCookie() {
        AppMethodBeat.i(153840);
        this.SEY.removeSessionCookie();
        AppMethodBeat.o(153840);
    }
}
