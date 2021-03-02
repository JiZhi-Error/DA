package com.tencent.xweb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal;

public final class c {
    private static c SyM;
    public CookieInternal.ICookieManagerInternal SyN;

    private c() {
    }

    public static synchronized c hsp() {
        c cVar;
        synchronized (c.class) {
            AppMethodBeat.i(156717);
            if (SyM == null) {
                SyM = new c();
            }
            cVar = SyM;
            AppMethodBeat.o(156717);
        }
        return cVar;
    }

    public final void removeAllCookie() {
        AppMethodBeat.i(156718);
        this.SyN.removeAllCookie();
        AppMethodBeat.o(156718);
    }

    public final String getCookie(String str) {
        AppMethodBeat.i(156719);
        String cookie = this.SyN.getCookie(str);
        AppMethodBeat.o(156719);
        return cookie;
    }

    public final synchronized void setCookie(String str, String str2) {
        AppMethodBeat.i(156720);
        this.SyN.setCookie(str, str2);
        AppMethodBeat.o(156720);
    }

    public final synchronized void hsq() {
        AppMethodBeat.i(156721);
        if (this.SyN != null) {
            this.SyN.hsq();
        }
        AppMethodBeat.o(156721);
    }

    public final synchronized void e(WebView webView) {
        AppMethodBeat.i(156722);
        if (this.SyN != null) {
            this.SyN.e(webView);
        }
        AppMethodBeat.o(156722);
    }
}
