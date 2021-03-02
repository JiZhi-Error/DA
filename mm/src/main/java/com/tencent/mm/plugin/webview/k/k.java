package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import java.lang.Thread;
import java.util.List;
import java.util.regex.Pattern;

public final class k {
    private static Pattern JBU = null;
    private static String JBV = null;
    private static Boolean JBW = null;

    public static void j(String str, Context context) {
        AppMethodBeat.i(82384);
        SharedPreferences.Editor edit = context.getSharedPreferences("webview_url_prefs", 4).edit();
        edit.putString("url", str);
        edit.apply();
        AppMethodBeat.o(82384);
    }

    public static String ie(Context context) {
        AppMethodBeat.i(224516);
        String string = context.getSharedPreferences("webview_url_prefs", 4).getString("url", null);
        AppMethodBeat.o(224516);
        return string;
    }

    /* renamed from: if  reason: not valid java name */
    public static void m33if(Context context) {
        AppMethodBeat.i(224517);
        SharedPreferences.Editor edit = context.getSharedPreferences("webview_url_prefs", 4).edit();
        edit.remove("url");
        edit.apply();
        AppMethodBeat.o(224517);
    }

    public static void h(MMWebView mMWebView) {
        AppMethodBeat.i(224518);
        if (mMWebView == null) {
            AppMethodBeat.o(224518);
        } else if (mMWebView.getIsX5Kernel()) {
            AppMethodBeat.o(224518);
        } else if (d.oD(19)) {
            AppMethodBeat.o(224518);
        } else {
            try {
                Object obj = new c(mMWebView, "mSysWebView", null).get();
                Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", obj);
                Object obj2 = new c(obj, "mProvider", null).get();
                Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", obj2);
                Object obj3 = new c(obj2, "mWebViewCore", null).get();
                Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", obj3);
                Object obj4 = new c(obj3, "sWebCoreHandler", null).get();
                Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", obj4);
                Object obj5 = new c(obj4, "mLooper", null).get();
                Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mLooper = %s", obj5);
                Object obj6 = new c(obj5, "mThread", null).get();
                Log.d("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj6);
                if (obj6 instanceof Thread) {
                    Thread thread = (Thread) obj6;
                    Log.i("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == Thread.State.WAITING) {
                        thread.interrupt();
                    }
                }
                AppMethodBeat.o(224518);
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewUIUtil", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
                AppMethodBeat.o(224518);
            }
        }
    }

    public static boolean bbp(String str) {
        AppMethodBeat.i(224519);
        if (!WebView.isX5() || !bbq(str) || ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(a.nS("disable_apk_hook", "tools"))) {
            AppMethodBeat.o(224519);
            return false;
        }
        AppMethodBeat.o(224519);
        return true;
    }

    private static boolean bbq(String str) {
        AppMethodBeat.i(82385);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(82385);
            return false;
        }
        try {
            List<String> pathSegments = Uri.parse(str).getPathSegments();
            if (pathSegments == null || pathSegments.size() <= 0) {
                AppMethodBeat.o(82385);
                return false;
            }
            String str2 = pathSegments.get(pathSegments.size() - 1);
            if (str2 != null && str2.toLowerCase().trim().endsWith(".apk")) {
                AppMethodBeat.o(82385);
                return true;
            }
            AppMethodBeat.o(82385);
            return false;
        } catch (Exception e2) {
        }
    }

    public static boolean bbr(String str) {
        boolean z;
        AppMethodBeat.i(82386);
        if (JBW == null || !Util.isEqual(str, JBV)) {
            JBV = str;
            if (Pattern.compile("^(http|https)://" + WeChatHosts.domainString(R.string.e20) + "/(s|mp/author|mp/appmsg/show)", 2).matcher(str).find()) {
                z = true;
            } else if (Pattern.compile("^(http|https)://(sh.|hk.|sz.)?" + WeChatHosts.domainString(R.string.e22) + "/connect/(confirm|oauth2/(authorize|explorer_authorize))", 2).matcher(str).find()) {
                z = true;
            } else {
                if (JBU == null) {
                    String a2 = ((b) g.af(b.class)).a(b.a.clicfg_webview_mp_host_list, "^(http|https)://" + WeChatHosts.domainString(R.string.e20) + "/mp/(readtemplate\\?t=scanlogin/index_tmpl|scanlogin\\?action=index|relatedarticle\\?action=page|aboutbiz|infringement|qa)");
                    Log.i("MicroMsg.WebViewUIUtil", "mpHosts=:%s", a2);
                    JBU = Pattern.compile(a2);
                }
                if (JBU == null || !JBU.matcher(str).find()) {
                    z = false;
                } else {
                    z = true;
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            JBW = valueOf;
            boolean booleanValue = valueOf.booleanValue();
            AppMethodBeat.o(82386);
            return booleanValue;
        }
        boolean booleanValue2 = JBW.booleanValue();
        AppMethodBeat.o(82386);
        return booleanValue2;
    }
}
