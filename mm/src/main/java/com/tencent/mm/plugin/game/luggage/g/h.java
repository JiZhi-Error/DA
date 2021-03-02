package com.tencent.mm.plugin.game.luggage.g;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.game.luggage.c;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends com.tencent.mm.plugin.webview.luggage.webview_impl.a {
    private static final Object lock = new Object();
    private String mTitle;
    String xwe;
    private Runnable xyA = new Runnable() {
        /* class com.tencent.mm.plugin.game.luggage.g.h.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(83134);
            synchronized (h.lock) {
                try {
                    if (h.this.getSettings().getBlockNetworkImage()) {
                        Log.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage time out");
                        h.this.getSettings().setBlockNetworkImage(false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(949, 0, 1);
                    }
                } finally {
                    AppMethodBeat.o(83134);
                }
            }
        }
    };
    protected e xyl;
    private boolean xym = false;
    Map<String, String> xyn;
    private String xyo;
    private boolean xyp = false;
    private boolean xyq = false;
    private boolean xyr = false;
    private boolean xyt = false;
    private boolean xyu = false;
    private GameWebPerformanceInfo xyv;
    private boolean xyw = false;
    private Object xyx = new Object();
    private boolean xyy = false;
    private boolean xyz = false;

    static {
        AppMethodBeat.i(83171);
        AppMethodBeat.o(83171);
    }

    public h(Context context) {
        super(context);
        AppMethodBeat.i(83155);
        getSettings().setForceDarkBehavior(1);
        this.xyl = new e();
        Log.i("MicroMsg.GameWebCoreImpl", "create, hashCode: %d", Integer.valueOf(hashCode()));
        AppMethodBeat.o(83155);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(83156);
        super.onAttachedToWindow();
        Log.i("MicroMsg.GameWebCoreImpl", "onAttachedToWindow, hashCode: %d", Integer.valueOf(hashCode()));
        this.xyt = true;
        dTK();
        AppMethodBeat.o(83156);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(83157);
        super.onDetachedFromWindow();
        Log.i("MicroMsg.GameWebCoreImpl", "onDetachedFromWindow, hashCode: %d", Integer.valueOf(hashCode()));
        removeCallbacks(this.xyA);
        AppMethodBeat.o(83157);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.luggage.webview.a
    public final void a(a.AbstractC0187a aVar) {
        AppMethodBeat.i(83158);
        super.a(aVar);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.g.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(186954);
                h.this.init();
                AppMethodBeat.o(186954);
            }
        });
        AppMethodBeat.o(83158);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a
    public void LE() {
        AppMethodBeat.i(83159);
        super.LE();
        getWebCore().ctM.a(new c(this));
        AppMethodBeat.o(83159);
    }

    /* access modifiers changed from: protected */
    public final void init() {
        AppMethodBeat.i(83160);
        getSettings().setBlockNetworkImage(true);
        setWebViewClientProxy(new b());
        setWebChromeClientProxy(new a());
        AppMethodBeat.o(83160);
    }

    private void dTK() {
        AppMethodBeat.i(83161);
        if (this.xyr && this.xyt) {
            postDelayed(this.xyA, 3000);
        }
        AppMethodBeat.o(83161);
    }

    /* access modifiers changed from: protected */
    public void b(WebView webView, String str, Bitmap bitmap) {
        AppMethodBeat.i(83162);
        this.xyr = true;
        dTK();
        if (this.xyv.hhQ == 0) {
            this.xyv.hhQ = System.currentTimeMillis();
            Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, url: %s, time: %d", str, Long.valueOf(this.xyv.hhQ));
        }
        if (g.baK(this.xyo).JqW == 0) {
            g.baK(this.xyo).JqW = System.currentTimeMillis();
        }
        AppMethodBeat.o(83162);
    }

    /* access modifiers changed from: protected */
    public void b(WebView webView, String str) {
        AppMethodBeat.i(83163);
        Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, blockImg: %b", Boolean.valueOf(this.xyq));
        if (this.xyv.hhR == 0) {
            this.xyv.hhR = System.currentTimeMillis();
            Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, url: %s, time: %d", str, Long.valueOf(this.xyv.hhR));
        }
        if (g.baK(this.xyo).JqX == 0) {
            g.baK(this.xyo).JqX = System.currentTimeMillis();
        }
        synchronized (lock) {
            try {
                getSettings().setBlockNetworkImage(this.xyq);
            } finally {
                AppMethodBeat.o(83163);
            }
        }
        this.xyp = true;
        if (this.xyv.hhO == 0) {
            this.xyv.hhO = System.currentTimeMillis();
        }
    }

    public void setBlockNetworkImage(boolean z) {
        AppMethodBeat.i(83164);
        Log.i("MicroMsg.GameWebCoreImpl", "setBlockNetworkImage, blockImg: %b", Boolean.valueOf(z));
        this.xyq = z;
        if (this.xyp) {
            synchronized (lock) {
                try {
                    getSettings().setBlockNetworkImage(z);
                } finally {
                    AppMethodBeat.o(83164);
                }
            }
            return;
        }
        AppMethodBeat.o(83164);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView, com.tencent.luggage.webview.a
    public void destroy() {
        AppMethodBeat.i(83165);
        this.xyl.zE(this.xyu);
        super.destroy();
        AppMethodBeat.o(83165);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView, com.tencent.luggage.webview.a
    public void loadUrl(String str) {
        AppMethodBeat.i(83166);
        Log.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time : %d, hashCode: %d", Long.valueOf(System.currentTimeMillis()), Integer.valueOf(hashCode()));
        if (this.xyv == null) {
            this.xyv = GameWebPerformanceInfo.Fd(this.xyo);
            this.xyv.hhP = System.currentTimeMillis();
        }
        Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", Boolean.valueOf(this.xym));
        if (!this.xym) {
            this.xyl.m(str, true, false);
            this.xym = true;
        }
        String gkv = this.xyl.gkv();
        Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", str);
        if (Util.isNullOrNil(gkv)) {
            try {
                com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(str), AppEventsConstants.EVENT_PARAM_VALUE_NO, 0);
            } catch (Exception e2) {
            }
            super.loadUrl(str);
            AppMethodBeat.o(83166);
            return;
        }
        Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", gkv);
        try {
            com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(str), "1", 0);
        } catch (Exception e3) {
        }
        super.loadDataWithBaseURL(str, gkv, "text/html", ProtocolPackage.ServerEncoding, null);
        AppMethodBeat.o(83166);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(83167);
        Log.i("MicroMsg.GameWebCoreImpl", "loadUrl, __Time__, time: %d， HEADER", Long.valueOf(System.currentTimeMillis()));
        if (this.xyv == null) {
            this.xyv = GameWebPerformanceInfo.Fd(this.xyo);
            this.xyv.hhP = System.currentTimeMillis();
        }
        Log.d("MicroMsg.GameWebCoreImpl", "loadUrl, hasLoadWePkg: %b", Boolean.valueOf(this.xym));
        if (!this.xym) {
            this.xyl.m(str, true, false);
            this.xym = true;
        }
        String gkv = this.xyl.gkv();
        Log.i("MicroMsg.GameWebCoreImpl", "loadUrl:%s", str);
        if (Util.isNullOrNil(gkv)) {
            com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(str), AppEventsConstants.EVENT_PARAM_VALUE_NO, 0);
            super.loadUrl(str, map);
            AppMethodBeat.o(83167);
            return;
        }
        Log.d("MicroMsg.GameWebCoreImpl", "use PageCache:%s", gkv);
        com.tencent.mm.game.report.api.a.hhr.a(5, URLEncoder.encode(str), "1", 0);
        super.loadDataWithBaseURL(str, gkv, "text/html", ProtocolPackage.ServerEncoding, null);
        AppMethodBeat.o(83167);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(186956);
        if (this.xyv == null) {
            this.xyv = GameWebPerformanceInfo.Fd(str);
            this.xyv.hhP = System.currentTimeMillis();
        }
        Log.d("MicroMsg.GameWebCoreImpl", "loadDataWithBaseURL, hasLoadWePkg: %b", Boolean.valueOf(this.xym));
        if (!this.xym) {
            this.xyl.m(str, true, true);
            this.xym = true;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(186956);
    }

    public final boolean azJ(String str) {
        AppMethodBeat.i(83168);
        Log.d("MicroMsg.GameWebCoreImpl", "isWebCacheUrl, hasLoadWePkg: %b", Boolean.valueOf(this.xym));
        if (!this.xym) {
            this.xyl.m(str, true, false);
            this.xym = true;
        }
        boolean bci = this.xyl.bci(str);
        AppMethodBeat.o(83168);
        return bci;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.webview_impl.a, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public String getTitle() {
        return this.mTitle;
    }

    public void setShouldCleanPkgWhenDestroy(boolean z) {
        this.xyu = z;
    }

    public class b extends i {
        public b() {
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(83145);
            Log.i("MicroMsg.GameWebCoreImpl", "onPageStarted, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            h.this.xyl.bcg(str);
            super.b(webView, str, bitmap);
            h.this.b(webView, str, bitmap);
            AppMethodBeat.o(83145);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void b(WebView webView, String str) {
            AppMethodBeat.i(83146);
            Log.i("MicroMsg.GameWebCoreImpl", "onPageFinished, __Time__, time: %d", Long.valueOf(System.currentTimeMillis()));
            h.this.xyl.bch(str);
            super.b(webView, str);
            h.this.b(webView, str);
            h.this.xyz = true;
            AppMethodBeat.o(83146);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void h(WebView webView, String str) {
            AppMethodBeat.i(83147);
            super.h(webView, str);
            Log.i("MicroMsg.GameWebCoreImpl", "onLoadResource, url: %s", str);
            AppMethodBeat.o(83147);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final boolean a(WebView webView, String str) {
            AppMethodBeat.i(83148);
            Log.i("MicroMsg.GameWebCoreImpl", "shouldOverrideUrlLoading, url: %s", str);
            if (DownloadChecker.a(str, h.this.yCr, webView)) {
                Log.i("MicroMsg.GameWebCoreImpl", "use the downloader to download");
                AppMethodBeat.o(83148);
                return true;
            }
            boolean a2 = super.a(webView, str);
            AppMethodBeat.o(83148);
            return a2;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final WebResourceResponse c(WebView webView, String str) {
            AppMethodBeat.i(83149);
            Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", str);
            if (str.equals(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/favicon.ico")) {
                WebResourceResponse webResourceResponse = new WebResourceResponse("img/png", null, null);
                AppMethodBeat.o(83149);
                return webResourceResponse;
            }
            WebResourceResponse p = h.this.xyl.p(webView, str);
            if (p != null) {
                Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.o(83149);
                return p;
            }
            WebResourceResponse c2 = super.c(webView, str);
            AppMethodBeat.o(83149);
            return c2;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(83150);
            Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", webResourceRequest.getUrl().toString());
            if (webResourceRequest.getUrl().toString().equals(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/favicon.ico")) {
                WebResourceResponse webResourceResponse = new WebResourceResponse("img/png", null, null);
                AppMethodBeat.o(83150);
                return webResourceResponse;
            }
            WebResourceResponse p = h.this.xyl.p(webView, webResourceRequest.getUrl().toString());
            if (p != null) {
                Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.o(83150);
                return p;
            }
            WebResourceResponse a2 = super.a(webView, webResourceRequest);
            AppMethodBeat.o(83150);
            return a2;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            AppMethodBeat.i(83151);
            Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest, url: %s", webResourceRequest.getUrl().toString());
            if (webResourceRequest.getUrl().toString().equals(HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e1h) + "/favicon.ico")) {
                WebResourceResponse webResourceResponse = new WebResourceResponse("img/png", null, null);
                AppMethodBeat.o(83151);
                return webResourceResponse;
            }
            WebResourceResponse p = h.this.xyl.p(webView, webResourceRequest.getUrl().toString());
            if (p != null) {
                Log.i("MicroMsg.GameWebCoreImpl", "shouldInterceptRequest response != null");
                AppMethodBeat.o(83151);
                return p;
            }
            WebResourceResponse a2 = super.a(webView, webResourceRequest, bundle);
            AppMethodBeat.o(83151);
            return a2;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void a(WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(83152);
            super.a(webView, i2, str, str2);
            Log.e("MicroMsg.GameWebCoreImpl", "onReceivedError, desc: %s, url: %s", str, str2);
            h.this.xyy = true;
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(949, 1, 1);
            AppMethodBeat.o(83152);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void a(WebView webView, r rVar, SslError sslError) {
            AppMethodBeat.i(83153);
            super.a(webView, rVar, sslError);
            Log.e("MicroMsg.GameWebCoreImpl", "onReceivedSslError， error: ".concat(String.valueOf(sslError)));
            h.this.xyy = true;
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(949, 2, 1);
            AppMethodBeat.o(83153);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            AppMethodBeat.i(83154);
            super.a(webView, webResourceRequest, webResourceResponse);
            Log.e("MicroMsg.GameWebCoreImpl", "onReceivedHttpError， errorCode: %d", Integer.valueOf(webResourceResponse.mStatusCode));
            h.this.xyy = true;
            com.tencent.mm.plugin.report.service.h.INSTANCE.n(949, 3, 1);
            AppMethodBeat.o(83154);
        }
    }

    public class a extends f {
        public a() {
        }

        @Override // com.tencent.xweb.x, com.tencent.mm.plugin.webview.luggage.f
        public final void d(WebView webView, String str) {
            AppMethodBeat.i(83143);
            Log.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", str);
            if (!com.tencent.mm.plugin.webview.luggage.c.b.afC(str)) {
                h.this.mTitle = str;
            }
            super.d(webView, str);
            AppMethodBeat.o(83143);
        }

        @Override // com.tencent.xweb.x, com.tencent.mm.plugin.webview.luggage.f
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            g baL;
            AppMethodBeat.i(83144);
            if (h.this.xyl != null) {
                h.this.xyl.a(consoleMessage);
            }
            final String message = consoleMessage != null ? consoleMessage.message() : "";
            if (message.contains("luggage_err") || message.contains("luggageBridge is not defined")) {
                Log.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
                h.this.xyv.hia = message;
            } else if (message.startsWith("WXGAMEPERF:")) {
                if (message.contains("first-contentful-paint")) {
                    try {
                        g.bL(h.this.xyo, (long) new JSONObject(message.replaceFirst("WXGAMEPERF:", "").trim()).optDouble("startTime", 0.0d));
                    } catch (JSONException e2) {
                    }
                } else if (message.contains("timing")) {
                    try {
                        JSONObject optJSONObject = new JSONObject(message.replaceFirst("WXGAMEPERF:", "").trim()).optJSONObject("timing");
                        if (!(optJSONObject == null || (baL = g.baL(h.this.xyo)) == null)) {
                            baL.Jre = optJSONObject.optLong("domainLookupEnd") - optJSONObject.optLong("domainLookupStart");
                            baL.Jrf = optJSONObject.optLong("connectEnd") - optJSONObject.optLong("connectStart");
                            baL.nOC = optJSONObject.optLong("responseEnd") - optJSONObject.optLong("requestStart");
                            baL.Jrg = optJSONObject.optLong("domInteractive") - optJSONObject.optLong("domLoading");
                            baL.Jri = optJSONObject.optLong("domContentLoadedEventEnd") - optJSONObject.optLong("responseEnd");
                            baL.Jrj = optJSONObject.optLong("domComplete") - optJSONObject.optLong("responseEnd");
                            baL.Jrk = optJSONObject.optLong("navigationStart");
                        }
                    } catch (Exception e3) {
                    }
                }
                com.tencent.f.h.RTc.aX(new Runnable() {
                    /* class com.tencent.mm.plugin.game.luggage.g.h.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(186955);
                        Log.i("MicroMsg.GameWebCoreImpl", message);
                        AppMethodBeat.o(186955);
                    }
                });
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(83144);
            return onConsoleMessage;
        }
    }

    public e getWePkgPlugin() {
        return this.xyl;
    }

    public void setRawUrl(String str) {
        this.xyo = str;
    }

    public final boolean dTL() {
        return this.xyp && !this.xyy;
    }
}
