package com.tencent.xweb.sys;

import android.os.Build;
import android.webkit.CookieManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal;
import org.xwalk.core.Log;

public final class a implements CookieInternal.ICookieManagerInternal {
    CookieManager SDU = CookieManager.getInstance();

    public a() {
        AppMethodBeat.i(153648);
        AppMethodBeat.o(153648);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void hsq() {
        AppMethodBeat.i(153649);
        this.SDU.setAcceptCookie(true);
        AppMethodBeat.o(153649);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void e(WebView webView) {
        AppMethodBeat.i(153650);
        if (Build.VERSION.SDK_INT >= 21) {
            if (webView == null || webView.getWebViewUI() == null || !(webView.getWebViewUI() instanceof android.webkit.WebView)) {
                Log.e("SysCookieManagerWrapper", "webview kind not match");
            } else {
                this.SDU.setAcceptThirdPartyCookies((android.webkit.WebView) webView.getWebViewUI(), true);
                AppMethodBeat.o(153650);
                return;
            }
        }
        AppMethodBeat.o(153650);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void removeAllCookie() {
        AppMethodBeat.i(153651);
        this.SDU.removeAllCookie();
        AppMethodBeat.o(153651);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final String getCookie(String str) {
        AppMethodBeat.i(153652);
        String cookie = this.SDU.getCookie(str);
        AppMethodBeat.o(153652);
        return cookie;
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void setCookie(String str, String str2) {
        AppMethodBeat.i(153653);
        this.SDU.setCookie(str, str2);
        AppMethodBeat.o(153653);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void removeSessionCookie() {
        AppMethodBeat.i(153654);
        this.SDU.removeSessionCookie();
        AppMethodBeat.o(153654);
    }
}
