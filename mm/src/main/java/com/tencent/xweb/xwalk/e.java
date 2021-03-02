package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal;
import org.xwalk.core.XWalkCookieManager;

public final class e implements CookieInternal.ICookieManagerInternal {
    XWalkCookieManager SGP = new XWalkCookieManager();

    public e() {
        AppMethodBeat.i(154256);
        AppMethodBeat.o(154256);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void hsq() {
        AppMethodBeat.i(154257);
        this.SGP.setAcceptCookie(true);
        AppMethodBeat.o(154257);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void e(WebView webView) {
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void removeAllCookie() {
        AppMethodBeat.i(154258);
        this.SGP.removeAllCookie();
        AppMethodBeat.o(154258);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final String getCookie(String str) {
        AppMethodBeat.i(154259);
        String cookie = this.SGP.getCookie(str);
        AppMethodBeat.o(154259);
        return cookie;
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void setCookie(String str, String str2) {
        AppMethodBeat.i(154260);
        this.SGP.setCookie(str, str2);
        AppMethodBeat.o(154260);
    }

    @Override // com.tencent.xweb.internal.CookieInternal.ICookieManagerInternal
    public final void removeSessionCookie() {
        AppMethodBeat.i(154261);
        this.SGP.removeSessionCookie();
        AppMethodBeat.o(154261);
    }
}
