package com.tencent.xweb;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.util.IXWebLogClient;
import com.tencent.xweb.util.h;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class aj {
    static boolean SAU = false;
    static boolean SAV = false;

    public static void a(Context context, IXWebLogClient iXWebLogClient) {
        AppMethodBeat.i(156942);
        a(context, iXWebLogClient, null, null, null);
        AppMethodBeat.o(156942);
    }

    public static synchronized void a(Context context, IXWebLogClient iXWebLogClient, ISharedPreferenceProvider iSharedPreferenceProvider, af afVar, WebViewExtensionListener webViewExtensionListener) {
        synchronized (aj.class) {
            AppMethodBeat.i(156943);
            if (iXWebLogClient != null) {
                Log.SetLogCallBack(iXWebLogClient);
            }
            if (afVar != null) {
                h.a(afVar);
            }
            if (iSharedPreferenceProvider != null) {
                ah.setSharedPreferenceProvider(iSharedPreferenceProvider);
            }
            lD(context);
            if (webViewExtensionListener != null) {
                l.g(WebView.c.WV_KIND_CW).initCallback(webViewExtensionListener);
            }
            if (webViewExtensionListener != null) {
                l.g(WebView.c.WV_KIND_X5).initCallback(webViewExtensionListener);
            }
            XWebCoreContentProvider.htb();
            AppMethodBeat.o(156943);
        }
    }

    public static synchronized void initInterface() {
        synchronized (aj.class) {
            AppMethodBeat.i(156944);
            if (SAU) {
                AppMethodBeat.o(156944);
            } else {
                SAU = true;
                l.a g2 = l.g(WebView.c.WV_KIND_CW);
                if (g2 != null) {
                    g2.initInterface();
                }
                l.a g3 = l.g(WebView.c.WV_KIND_X5);
                if (g3 != null) {
                    g3.initInterface();
                }
                AppMethodBeat.o(156944);
            }
        }
    }

    private static synchronized void lD(Context context) {
        synchronized (aj.class) {
            AppMethodBeat.i(156945);
            if (context == null) {
                AppMethodBeat.o(156945);
            } else if (SAV) {
                AppMethodBeat.o(156945);
            } else {
                XWalkEnvironment.init(context);
                l.a g2 = l.g(WebView.c.WV_KIND_CW);
                if (g2 != null) {
                    g2.initEnviroment(context);
                }
                l.a g3 = l.g(WebView.c.WV_KIND_X5);
                if (g3 != null) {
                    g3.initEnviroment(context);
                }
                SAV = true;
                AppMethodBeat.o(156945);
            }
        }
    }
}
