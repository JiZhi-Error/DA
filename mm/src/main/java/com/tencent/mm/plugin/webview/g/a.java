package com.tencent.mm.plugin.webview.g;

import android.net.Uri;
import android.webkit.ValueCallback;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.IOException;
import java.util.HashMap;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0006H\u0016J\u001a\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0006H\u0016J \u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0006H\u0016J\u0010\u00105\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u0006H\u0016J(\u00106\u001a\u00020\u00172\u0006\u00100\u001a\u00020&2\u0006\u00107\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0018\u0010\"\u001a\u00020\u0017*\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00069"}, hxF = {"Lcom/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor;", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "()V", "DELAY_PROGRESSBAR_TIME", "", "TAG", "", "WebPrefetcher", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "getWebPrefetcher", "()Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "WebPrefetcher$delegate", "Lkotlin/Lazy;", "clientListener", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "controllerListener", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListener", "()Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "isPageCached", "", "()Z", "isPrefetchInfoWritten", "preauth", "predns", "prefetch", "prefetchResp", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService$PrefetchResponse;", "rawUrl", "getRawUrl", "()Ljava/lang/String;", "shouldIntercepted", "getShouldIntercepted", "(Ljava/lang/String;)Z", "getA8KeyReason", "", "url", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", "Lcom/tencent/xweb/WebView;", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "overrideNeedSyncGetA8Key", "overrideProcessResult", "reason", "reqUrl", "resp", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "overrideReload", "overrideStartLoad", "overrideUrlRedirect", "forceRedirect", "fullUrl", "webview-sdk_release"})
public final class a extends k {
    private final f IMY = new b(this);
    private final j IMZ = new c(this);
    e.b Jcs;
    boolean Jct;
    boolean Jcu;
    boolean Jcv;
    private final kotlin.f Jcw = g.ah(C1957a.Jcz);
    private final long Jcx = 500;
    boolean Jcy;
    final String TAG = "MicroMsg.WebPrefetcherInterceptor";

    /* access modifiers changed from: package-private */
    public final e gdJ() {
        AppMethodBeat.i(225148);
        e eVar = (e) this.Jcw.getValue();
        AppMethodBeat.o(225148);
        return eVar;
    }

    public a() {
        AppMethodBeat.i(225157);
        AppMethodBeat.o(225157);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0002¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$clientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "writePrefetchInfo", "webview-sdk_release"})
    public static final class b extends f {
        final /* synthetic */ a JcA;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "value", "", "kotlin.jvm.PlatformType", "onReceiveValue"})
        /* renamed from: com.tencent.mm.plugin.webview.g.a$b$a  reason: collision with other inner class name */
        static final class C1958a<T> implements ValueCallback<String> {
            final /* synthetic */ b JcB;

            C1958a(b bVar) {
                this.JcB = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // android.webkit.ValueCallback
            public final /* synthetic */ void onReceiveValue(String str) {
                AppMethodBeat.i(225144);
                Log.v(this.JcB.JcA.TAG, "write performance:".concat(String.valueOf(str)));
                AppMethodBeat.o(225144);
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(a aVar) {
            this.JcA = aVar;
        }

        @Override // com.tencent.mm.plugin.webview.core.f
        public final void e(WebView webView, String str) {
            Integer num;
            String str2;
            Integer num2 = null;
            AppMethodBeat.i(225145);
            Log.i(this.JcA.TAG, "onPageCommitVisible, url = %s", str);
            if (!this.JcA.Jcy) {
                this.JcA.getController().pGj.evaluateJavascript(n.buv("(function(p){\n                p.wx=p.wx||{};\n                p.wx.timeOrigin=" + this.JcA.getController().IKa.JBP + ";\n                p.wx.info=Object.assign(p.wx.info||{}, {\n                    preauth:" + this.JcA.Jcu + ",\n                    prefetch:" + this.JcA.Jct + ",\n                    predns:" + this.JcA.Jcv + "\n                })\n                return p.wx.info;\n            })(window.performance);"), new C1958a(this));
                this.JcA.Jcy = true;
                if (this.JcA.Jcs != null) {
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[5];
                    e.b bVar = this.JcA.Jcs;
                    if (bVar != null) {
                        num = Integer.valueOf(bVar.hDa);
                    } else {
                        num = null;
                    }
                    objArr[0] = num;
                    objArr[1] = str;
                    e.b bVar2 = this.JcA.Jcs;
                    if (bVar2 == null || (str2 = bVar2.url) == null) {
                        str2 = "";
                    }
                    objArr[2] = str2;
                    objArr[3] = 6;
                    e.b bVar3 = this.JcA.Jcs;
                    if (bVar3 != null) {
                        num2 = Integer.valueOf(bVar3.hDa);
                    }
                    objArr[4] = num2;
                    hVar.a(21075, objArr);
                }
            }
            AppMethodBeat.o(225145);
        }
    }

    private final boolean aZL(String str) {
        e gdJ;
        AppMethodBeat.i(225149);
        e gdJ2 = gdJ();
        if (gdJ2 == null || !gdJ2.fd(getController().coX(), str) || (gdJ = gdJ()) == null || !gdJ.ahB(str)) {
            AppMethodBeat.o(225149);
            return false;
        }
        AppMethodBeat.o(225149);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final f gai() {
        return this.IMY;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/webview/prefecher/WebPrefetcherInterceptor$controllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onPerformanceCollect", "", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "onPerformanceFetch", "webview-sdk_release"})
    public static final class c extends j {
        final /* synthetic */ a JcA;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.JcA = aVar;
        }

        @Override // com.tencent.mm.plugin.webview.core.j
        public final void a(com.tencent.mm.plugin.webview.k.j jVar) {
            String str;
            AppMethodBeat.i(225146);
            p.h(jVar, "performanceHelper");
            a aVar = this.JcA;
            String str2 = aVar.getController().IJM;
            e.b bVar = aVar.Jcs;
            if (bVar != null) {
                str = bVar.url;
            } else {
                str = null;
            }
            jVar.Jct = p.j(str2, str);
            AppMethodBeat.o(225146);
        }

        @Override // com.tencent.mm.plugin.webview.core.j
        public final void b(com.tencent.mm.plugin.webview.k.j jVar) {
            AppMethodBeat.i(225147);
            p.h(jVar, "performanceHelper");
            e gdJ = this.JcA.gdJ();
            BaseWebViewController baseWebViewController = this.controller;
            if (baseWebViewController == null) {
                p.btv("controller");
            }
            com.tencent.mm.plugin.webview.i.b.a(jVar, gdJ.ahE(baseWebViewController.coX()));
            AppMethodBeat.o(225147);
        }
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final j gaj() {
        return this.IMZ;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean aiD(String str) {
        AppMethodBeat.i(225150);
        p.h(str, "url");
        e.b bVar = this.Jcs;
        if (!p.j(str, bVar != null ? bVar.url : null) || !getController().fZF()) {
            AppMethodBeat.o(225150);
            return false;
        }
        this.Jcs = null;
        BaseWebViewController controller = getController();
        p.h(str, "url");
        Log.i(controller.fZo(), "reload for:".concat(String.valueOf(str)));
        controller.pGj.loadUrl(str);
        controller.IKf = true;
        AppMethodBeat.o(225150);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean aXQ(String str) {
        boolean z = false;
        AppMethodBeat.i(225151);
        p.h(str, "url");
        if (!aZL(str)) {
            Log.i(this.TAG, "not match ".concat(String.valueOf(str)));
            AppMethodBeat.o(225151);
            return false;
        }
        e gdJ = gdJ();
        e.b ahF = gdJ != null ? gdJ.ahF(str) : null;
        if (ahF != null) {
            Log.i(this.TAG, "url has been cached:%s", ahF.url);
            Log.i(this.TAG, "url has been cached, bizScene:" + ahF.hDa + ", subBizScene:" + ahF.pmN + " ,url:" + ahF.url);
            this.Jcs = ahF;
            h.INSTANCE.a(21075, Integer.valueOf(ahF.hDa), str, ahF.url, 4, Integer.valueOf(ahF.hDa));
            BaseWebViewController controller = getController();
            String str2 = ahF.url;
            p.g(str2, "resp.url");
            WebResourceResponse webResourceResponse = ahF.pmQ;
            p.g(webResourceResponse, "resp.response");
            controller.L(str2, webResourceResponse.getResponseHeaders());
            BaseWebViewController controller2 = getController();
            String str3 = ahF.url;
            p.g(str3, "resp.url");
            BaseWebViewController.a(controller2, str3, false, 10, 2);
            this.Jct = true;
            getController().IKa.Jct = this.Jct;
            HashMap<String, String> hashMap = getController().IKa.JBO;
            WebResourceResponse webResourceResponse2 = ahF.pmQ;
            p.g(webResourceResponse2, "resp.response");
            hashMap.putAll(webResourceResponse2.getResponseHeaders());
            com.tencent.mm.plugin.webview.i.b.gdN();
            e gdJ2 = gdJ();
            com.tencent.mm.plugin.webview.i.b.agq(gdJ2 != null ? gdJ2.ahE(getController().coX()) : 0);
        } else {
            Log.i(this.TAG, "async geta8key:".concat(String.valueOf(str)));
            String ahC = gdJ().ahC(str);
            if (ahC == null) {
                ahC = str;
            }
            Log.i(this.TAG, "async geta8key respUrl:".concat(String.valueOf(ahC)));
            if (!com.tencent.luggage.h.c.A(ahC, "http")) {
                ahC = HttpWrapperBase.PROTOCAL_HTTP.concat(String.valueOf(str));
            }
            h.INSTANCE.a(21075, 0, str, ahC, 5);
            getController().pGj.loadUrl(ahC);
            BaseWebViewController.a(getController(), ahC, false, 10, 2);
        }
        this.Jcu = true;
        getController().IKa.Jcu = this.Jcu;
        e gdJ3 = gdJ();
        if (gdJ3 != null) {
            z = gdJ3.ahD(str);
        }
        this.Jcv = z;
        getController().IKa.Jcv = this.Jcv;
        AppMethodBeat.o(225151);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean aXR(String str) {
        AppMethodBeat.i(225152);
        p.h(str, "url");
        if (!aZL(str)) {
            AppMethodBeat.o(225152);
            return true;
        }
        AppMethodBeat.o(225152);
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean a(int i2, boolean z, String str, String str2) {
        AppMethodBeat.i(225153);
        p.h(str, "reqUrl");
        p.h(str2, "fullUrl");
        if (z || i2 != 10) {
            AppMethodBeat.o(225153);
            return false;
        }
        AppMethodBeat.o(225153);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final int aXA(String str) {
        AppMethodBeat.i(225154);
        p.h(str, "url");
        if (!aZL(str)) {
            e.b bVar = this.Jcs;
            if (!p.j(str, bVar != null ? bVar.url : null)) {
                int aXA = super.aXA(str);
                AppMethodBeat.o(225154);
                return aXA;
            }
        }
        AppMethodBeat.o(225154);
        return 10;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final boolean a(int i2, String str, bhj bhj) {
        long j2;
        long j3 = 0;
        AppMethodBeat.i(225155);
        p.h(str, "reqUrl");
        p.h(bhj, "resp");
        if (bhj.KCD == 38) {
            if (aZL(str)) {
                SKBuiltinBuffer_t sKBuiltinBuffer_t = bhj.LRS;
                byte[] a2 = sKBuiltinBuffer_t != null ? z.a(sKBuiltinBuffer_t) : null;
                try {
                    bhk bhk = new bhk();
                    bhk.parseFrom(a2);
                    String str2 = this.TAG;
                    StringBuilder sb = new StringBuilder("overrideProcessResultL, prefetchVersion: ");
                    e.b bVar = this.Jcs;
                    if (bVar != null) {
                        j2 = bVar.pmO;
                    } else {
                        j2 = 0;
                    }
                    Log.i(str2, sb.append(j2).append(", verifyInfo.Version: ").append(bhk.LRV).toString());
                    e.b bVar2 = this.Jcs;
                    if (bVar2 != null) {
                        j3 = bVar2.pmO;
                    }
                    if (j3 < bhk.LRV) {
                        e gdJ = gdJ();
                        if (gdJ != null) {
                            gdJ.ahG(str);
                        }
                        getController().pGj.loadUrl(bhk.LRU);
                        getController().IKf = true;
                    }
                } catch (IOException e2) {
                    Log.printErrStackTrace(this.TAG, e2, "parse GetA8KeyRespVerifyPrefetchInfo", new Object[0]);
                }
            }
            AppMethodBeat.o(225155);
            return true;
        }
        if (this.Jct && i2 == 9) {
            getController().IKf = true;
        }
        AppMethodBeat.o(225155);
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.core.k
    public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
        e.b bVar;
        String str;
        WebResourceResponse webResourceResponse;
        AppMethodBeat.i(225156);
        p.h(webView, "webview");
        p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (this.Jcs != null) {
            String uri = webResourceRequest.getUrl().toString();
            p.g(uri, "request.url.toString()");
            if (webResourceRequest.isForMainFrame()) {
                e.b bVar2 = this.Jcs;
                if (p.j(uri, bVar2 != null ? bVar2.url : null)) {
                    e.b bVar3 = this.Jcs;
                    if (bVar3 == null || (webResourceResponse = bVar3.pmQ) == null) {
                        AppMethodBeat.o(225156);
                        return null;
                    }
                    Log.v(this.TAG, "intercepted: " + uri + ", " + webResourceResponse.getMimeType());
                    AppMethodBeat.o(225156);
                    return webResourceResponse;
                }
            } else {
                try {
                    String currentUrl = getController().getCurrentUrl();
                    if (currentUrl != null) {
                        Uri parse = Uri.parse(currentUrl);
                        p.g(parse, "Uri.parse(url)");
                        String host = parse.getHost();
                        if (host != null) {
                            e gdJ = gdJ();
                            if (gdJ != null) {
                                e.b bVar4 = this.Jcs;
                                if (bVar4 != null) {
                                    str = bVar4.appId;
                                } else {
                                    str = null;
                                }
                                bVar = gdJ.R(host, uri, str);
                            } else {
                                bVar = null;
                            }
                            if (bVar != null) {
                                String str2 = bVar.pmP;
                                if (str2 != null) {
                                    switch (str2.hashCode()) {
                                        case 2377:
                                            if (str2.equals("JS")) {
                                                getController().IKa.JBM.add(webResourceRequest.getUrl().toString());
                                                com.tencent.mm.plugin.webview.i.b.gdO();
                                                com.tencent.mm.plugin.webview.i.b.agq(gdJ().ahE(getController().coX()));
                                                break;
                                            }
                                            break;
                                        case 67043:
                                            if (str2.equals("CSS")) {
                                                getController().IKa.JBN.add(webResourceRequest.getUrl().toString());
                                                com.tencent.mm.plugin.webview.i.b.gdP();
                                                com.tencent.mm.plugin.webview.i.b.agq(gdJ().ahE(getController().coX()));
                                                break;
                                            }
                                            break;
                                    }
                                }
                                if (bVar != null) {
                                    WebResourceResponse webResourceResponse2 = bVar.pmQ;
                                    AppMethodBeat.o(225156);
                                    return webResourceResponse2;
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(225156);
                    return null;
                } catch (Exception e2) {
                    Log.printErrStackTrace(this.TAG, e2, "interceptRequest getCurrentUrl host", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(225156);
        return null;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/api/IWebPrefetchService;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.webview.g.a$a  reason: collision with other inner class name */
    static final class C1957a extends q implements kotlin.g.a.a<e> {
        public static final C1957a Jcz = new C1957a();

        static {
            AppMethodBeat.i(225143);
            AppMethodBeat.o(225143);
        }

        C1957a() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ e invoke() {
            AppMethodBeat.i(225142);
            e eVar = (e) com.tencent.mm.kernel.g.af(e.class);
            AppMethodBeat.o(225142);
            return eVar;
        }
    }
}
