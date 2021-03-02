package com.tencent.xweb.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.CookieInternal;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class l {
    static a SDR;
    static a SDS;
    static a SDT;

    public interface a {
        void clearAllWebViewCache(Context context, boolean z);

        IWebView createWebView(WebView webView);

        IWebStorage createWebviewStorage();

        Object excute(String str, Object[] objArr);

        CookieInternal.ICookieManagerInternal getCookieManager();

        CookieInternal.ICookieSyncManagerInternal getCookieSyncManager();

        IWebViewDatabase getWebViewDatabase();

        boolean hasInited();

        void initCallback(WebViewExtensionListener webViewExtensionListener);

        void initEnviroment(Context context);

        void initInterface();

        boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback);
    }

    public static a g(WebView.c cVar) {
        AppMethodBeat.i(156981);
        if (cVar == WebView.c.WV_KIND_CW) {
            if (SDR == null) {
                Object oj = g.oj("com.tencent.xweb.xwalk.XWalkWebFactory", "getInstance");
                if (oj == null || !(oj instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find com.tencent.xweb.XWalkWebFactory failed");
                    AppMethodBeat.o(156981);
                    return null;
                }
                SDR = (a) oj;
            }
            a aVar = SDR;
            AppMethodBeat.o(156981);
            return aVar;
        } else if (cVar == WebView.c.WV_KIND_X5) {
            if (SDS == null) {
                Object oj2 = g.oj("com.tencent.xweb.x5.X5WebFactory", "getInstance");
                if (oj2 == null || !(oj2 instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find X5WebFactory failed");
                    AppMethodBeat.o(156981);
                    return null;
                }
                SDS = (a) oj2;
            }
            a aVar2 = SDS;
            AppMethodBeat.o(156981);
            return aVar2;
        } else if (cVar == WebView.c.WV_KIND_SYS) {
            if (SDT == null) {
                Object oj3 = g.oj("com.tencent.xweb.sys.SysWebFactory", "getInstance");
                if (oj3 == null || !(oj3 instanceof a)) {
                    Log.e("WebViewWrapperFactory", "find SysWebFactory failed");
                    AppMethodBeat.o(156981);
                    return null;
                }
                SDT = (a) oj3;
            }
            a aVar3 = SDT;
            AppMethodBeat.o(156981);
            return aVar3;
        } else {
            AppMethodBeat.o(156981);
            return null;
        }
    }

    public static IWebView a(WebView.c cVar, WebView webView) {
        IWebView iWebView = null;
        AppMethodBeat.i(156982);
        Log.i("WebViewWrapperFactory", "try to create webview  = ".concat(String.valueOf(cVar)));
        b c2 = b.c("CREATE_WEBVIEW", cVar);
        c2.htA();
        try {
            if (g(cVar) == null) {
                Log.e("WebViewWrapperFactory", "the kind of " + cVar + " this provider does not exist!");
                AppMethodBeat.o(156982);
                return iWebView;
            }
            iWebView = g(cVar).createWebView(webView);
            if (iWebView != null) {
                c2.htB();
            } else {
                XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview failed type = ".concat(String.valueOf(cVar)));
            }
            AppMethodBeat.o(156982);
            return iWebView;
        } catch (Exception e2) {
            XWalkEnvironment.addXWalkInitializeLog("WebViewWrapperFactory", "create webview with exception  type = " + cVar + ", error msg:" + e2.getMessage());
            h.l(cVar);
        }
    }
}
