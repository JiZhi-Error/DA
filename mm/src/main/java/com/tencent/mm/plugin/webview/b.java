package com.tencent.mm.plugin.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.e;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.modeltools.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashSet;

public final class b implements aa {
    private static final HashSet<String> IJs;

    static {
        AppMethodBeat.i(210815);
        HashSet<String> hashSet = new HashSet<>();
        IJs = hashSet;
        hashSet.add("preVerifyJSAPI");
        IJs.add("openUrlWithExtraWebview");
        IJs.add(JsApiGetInstallState.NAME);
        IJs.add("launchApplication");
        IJs.add("getBrandWCPayRequest");
        IJs.add("geoLocation");
        IJs.add(Scopes.PROFILE);
        IJs.add(JsApiInstallDownloadTask.NAME);
        IJs.add(JsApiPauseDownloadTask.NAME);
        IJs.add(JsApiAddDownloadTask.NAME);
        IJs.add(JsApiAddDownloadTaskStraight.NAME);
        IJs.add(JsApiResumeDownloadTask.NAME);
        IJs.add(JsApiQueryDownloadTask.NAME);
        IJs.add("addContact");
        IJs.add("quicklyAddBrandContact");
        IJs.add("requestBindPhoneNumber");
        IJs.add("openWeApp");
        IJs.add("checkJsApi");
        IJs.add(f.NAME);
        AppMethodBeat.o(210815);
    }

    @Override // com.tencent.mm.api.aa
    public final BaseWebViewController a(MMWebView mMWebView) {
        AppMethodBeat.i(210809);
        BaseWebViewController.c cVar = new BaseWebViewController.c();
        cVar.IKX = 69;
        i iVar = new i(mMWebView, new az(), cVar, IJs, null);
        AppMethodBeat.o(210809);
        return iVar;
    }

    @Override // com.tencent.mm.api.aa
    public final BaseWebViewController a(MMWebView mMWebView, BaseWebViewController.c cVar, e eVar) {
        AppMethodBeat.i(210810);
        i iVar = new i(mMWebView, new az(), cVar, null, eVar);
        AppMethodBeat.o(210810);
        return iVar;
    }

    @Override // com.tencent.mm.api.aa
    public final h b(MMWebView mMWebView) {
        AppMethodBeat.i(210811);
        try {
            if (mMWebView instanceof MMWebViewWithJsApi) {
                h jsapi = ((MMWebViewWithJsApi) mMWebView).getJsapi();
                AppMethodBeat.o(210811);
                return jsapi;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(210811);
        return null;
    }

    @Override // com.tencent.mm.api.aa
    public final void c(Activity activity, String str) {
        AppMethodBeat.i(210812);
        new a().c(activity, str);
        AppMethodBeat.o(210812);
    }

    @Override // com.tencent.mm.api.aa
    public final boolean a(Activity activity, int i2, int i3, Intent intent) {
        AppMethodBeat.i(210813);
        boolean d2 = new a().d(activity, i2, i3, intent);
        AppMethodBeat.o(210813);
        return d2;
    }

    @Override // com.tencent.mm.api.aa
    public final String fM(String str) {
        AppMethodBeat.i(210814);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(210814);
            return null;
        }
        String domainString = WeChatHosts.domainString(R.string.e20);
        Uri parse = Uri.parse(str);
        if (parse == null) {
            AppMethodBeat.o(210814);
            return null;
        } else if (!Util.isEqual(parse.getHost(), domainString)) {
            AppMethodBeat.o(210814);
            return null;
        } else {
            String nullAs = Util.nullAs(parse.getQueryParameter("__biz"), "");
            String nullAs2 = Util.nullAs(parse.getQueryParameter("mid"), "");
            String nullAs3 = Util.nullAs(parse.getQueryParameter("idx"), "");
            if (nullAs.length() <= 0 || nullAs2.length() <= 0 || nullAs3.length() <= 0) {
                AppMethodBeat.o(210814);
                return null;
            }
            String safeFormatString = Util.safeFormatString("id://local/i.html?__biz=%s&mid=%s&idx=%s", nullAs, nullAs2, nullAs3);
            AppMethodBeat.o(210814);
            return safeFormatString;
        }
    }
}
