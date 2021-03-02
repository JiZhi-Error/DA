package com.tencent.mm.plugin.webview.core;

import android.content.Intent;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J(\u0010\"\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001bH\u0016J \u0010&\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u0012H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010*\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010/\u001a\u00020\u0018H\u0016J\u0010\u00100\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u00101\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J(\u00107\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00122\u0006\u00108\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u001bH\u0016J\b\u0010:\u001a\u00020\u0018H\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012XD¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "", "()V", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "screenOrientation", "", "getScreenOrientation", "()I", "attach", "", "enableMinimize", "", "getA8KeyReason", "url", "", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "interceptLoadError", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "description", "failingUrl", "overrideGetA8Key", "force", "reason", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideRequestAuthCurrentUrl", "overrideStartLoad", "overrideStartLoadBefore", "intent", "Landroid/content/Intent;", "overrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "webView", "overrideUrlRedirect", "forceRedirect", "fullUrl", "shouldBeFinished", "OverrideUrlResult", "webview-sdk_release"})
public class k {
    private final f IMY;
    private final j IMZ;
    public BaseWebViewController controller;
    private final int screenOrientation = -1;

    public final BaseWebViewController getController() {
        AppMethodBeat.i(225062);
        BaseWebViewController baseWebViewController = this.controller;
        if (baseWebViewController == null) {
            p.btv("controller");
        }
        AppMethodBeat.o(225062);
        return baseWebViewController;
    }

    public final void k(BaseWebViewController baseWebViewController) {
        AppMethodBeat.i(225063);
        p.h(baseWebViewController, "controller");
        this.controller = baseWebViewController;
        AppMethodBeat.o(225063);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "", "override", "", "result", "(ZZ)V", "getOverride", "()Z", "getResult", "component1", "component2", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "webview-sdk_release"})
    public static final class a {
        final boolean INa;
        final boolean result;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.INa == aVar.INa && this.result == aVar.result)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            boolean z = this.INa;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            boolean z2 = this.result;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i6 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(225061);
            String str = "OverrideUrlResult(override=" + this.INa + ", result=" + this.result + ")";
            AppMethodBeat.o(225061);
            return str;
        }

        public a(boolean z, boolean z2) {
            this.INa = z;
            this.result = z2;
        }
    }

    public a o(WebView webView, String str) {
        AppMethodBeat.i(225064);
        p.h(webView, "webView");
        p.h(str, "url");
        a aVar = new a(false, false);
        AppMethodBeat.o(225064);
        return aVar;
    }

    public a c(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(225065);
        p.h(webView, "webView");
        p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        a aVar = new a(false, false);
        AppMethodBeat.o(225065);
        return aVar;
    }

    public boolean a(int i2, boolean z, String str, String str2) {
        AppMethodBeat.i(225066);
        p.h(str, "reqUrl");
        p.h(str2, "fullUrl");
        AppMethodBeat.o(225066);
        return false;
    }

    public boolean aXP(String str) {
        AppMethodBeat.i(225067);
        p.h(str, "url");
        AppMethodBeat.o(225067);
        return false;
    }

    public boolean e(String str, Intent intent) {
        AppMethodBeat.i(225068);
        p.h(str, "url");
        AppMethodBeat.o(225068);
        return false;
    }

    public boolean aXQ(String str) {
        AppMethodBeat.i(225069);
        p.h(str, "url");
        AppMethodBeat.o(225069);
        return false;
    }

    public boolean aXR(String str) {
        AppMethodBeat.i(225070);
        p.h(str, "url");
        AppMethodBeat.o(225070);
        return true;
    }

    public boolean a(int i2, String str, bhj bhj) {
        AppMethodBeat.i(225071);
        p.h(str, "reqUrl");
        p.h(bhj, "resp");
        AppMethodBeat.o(225071);
        return false;
    }

    public boolean gag() {
        return false;
    }

    public boolean aiD(String str) {
        AppMethodBeat.i(225072);
        p.h(str, "url");
        AppMethodBeat.o(225072);
        return false;
    }

    public WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(225073);
        p.h(webView, "webview");
        p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        AppMethodBeat.o(225073);
        return null;
    }

    public boolean c(WebView webView, int i2, String str, String str2) {
        AppMethodBeat.i(225074);
        p.h(webView, "webview");
        p.h(str, "description");
        p.h(str2, "failingUrl");
        AppMethodBeat.o(225074);
        return false;
    }

    public int aXA(String str) {
        AppMethodBeat.i(225075);
        p.h(str, "url");
        AppMethodBeat.o(225075);
        return -1;
    }

    public int getScreenOrientation() {
        return this.screenOrientation;
    }

    public boolean gah() {
        return false;
    }

    public f gai() {
        return this.IMY;
    }

    public j gaj() {
        return this.IMZ;
    }
}
