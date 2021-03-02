package com.tencent.xweb.sys;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.HttpAuthHandler;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.ae;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.sys.c;
import com.tencent.xweb.u;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.xwalk.d;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

@JgClassChecked(author = 20001, fComment = "checked", lastDate = "20171020", reviewer = 20001, vComment = {EType.JSEXECUTECHECK})
public final class e implements IWebView {
    private boolean SBX = false;
    WebView SEl;
    a SEm;
    ac SEn;
    x SEo;
    d SEp;
    g SEq;
    long SEr = 0;
    private com.tencent.xweb.extension.video.b SEs;
    b SEt;
    final String SEu = "xwalkTempCallBack";
    private WebChromeClient csS = new SysWebView$2(this);
    private WebViewClient mWebViewClient = new WebViewClient() {
        /* class com.tencent.xweb.sys.e.AnonymousClass2 */

        @Override // android.webkit.WebViewClient
        @TargetApi(21)
        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(153706);
            Log.i("SysWebView", "shouldOverrideUrlLoading " + webResourceRequest.getUrl().toString());
            if (e.this.SEn != null) {
                boolean e2 = e.this.SEn.e(e.this.SEl, new c.f(webResourceRequest));
                AppMethodBeat.o(153706);
                return e2;
            }
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            AppMethodBeat.o(153706);
            return shouldOverrideUrlLoading;
        }

        @TargetApi(23)
        public final void onPageCommitVisible(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(153707);
            Log.i("SysWebView", "onPageCommitVisible s = ".concat(String.valueOf(str)));
            if (e.this.SEn != null) {
                e.this.SEn.e(e.this.SEl, str);
            }
            AppMethodBeat.o(153707);
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(153708);
            if (d.bsN(str)) {
                AppMethodBeat.o(153708);
                return true;
            }
            Log.i("SysWebView", "shouldOverrideUrlLoading ".concat(String.valueOf(str)));
            if (e.this.SEn != null) {
                boolean a2 = e.this.SEn.a(e.this.SEl, str);
                AppMethodBeat.o(153708);
                return a2;
            }
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, str);
            AppMethodBeat.o(153708);
            return shouldOverrideUrlLoading;
        }

        public final void onPageStarted(android.webkit.WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(153709);
            Log.i("SysWebView", "onPageStarted ".concat(String.valueOf(str)));
            if (e.this.SEn != null) {
                e.this.SEn.b(e.this.SEl, str, bitmap);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
            e.this.SEr = System.currentTimeMillis();
            h.bsH(str);
            h.htZ();
            if (e.this.SEs != null) {
                e.this.SEs.bk(true, e.this.SEl.getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS);
            }
            AppMethodBeat.o(153709);
        }

        public final void onPageFinished(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(153710);
            Log.i("SysWebView", "onPageFinished ".concat(String.valueOf(str)));
            if (e.this.SEs != null) {
                e.this.SEs.bk(false, e.this.SEl.getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS);
            }
            if (e.this.SEn != null) {
                e.this.SEn.b(e.this.SEl, str);
            } else {
                super.onPageFinished(webView, str);
            }
            h.OR(System.currentTimeMillis() - e.this.SEr);
            d.a(e.this.SEl);
            h.OS(System.currentTimeMillis() - e.this.SEr);
            com.tencent.xweb.internal.h.htF().htL();
            AppMethodBeat.o(153710);
        }

        public final void onLoadResource(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(153711);
            if (e.this.SEn != null) {
                e.this.SEn.h(e.this.SEl, str);
                AppMethodBeat.o(153711);
                return;
            }
            super.onLoadResource(webView, str);
            AppMethodBeat.o(153711);
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, String str) {
            AppMethodBeat.i(153712);
            if (e.this.SEn != null) {
                WebResourceResponse a2 = c.a(e.this.SEn.c(e.this.SEl, str));
                AppMethodBeat.o(153712);
                return a2;
            }
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, str);
            AppMethodBeat.o(153712);
            return shouldInterceptRequest;
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(android.webkit.WebView webView, WebResourceRequest webResourceRequest) {
            Bundle bundle;
            com.tencent.xweb.WebResourceResponse webResourceResponse = null;
            AppMethodBeat.i(153713);
            if (e.this.SEn != null) {
                c.f fVar = new c.f(webResourceRequest);
                if (fVar.SEd == null) {
                    bundle = null;
                } else {
                    bundle = fVar.SEd.getBundle();
                }
                if (bundle != null) {
                    webResourceResponse = e.this.SEn.a(e.this.SEl, fVar, bundle);
                }
                if (webResourceResponse == null) {
                    webResourceResponse = e.this.SEn.a(e.this.SEl, fVar);
                }
                WebResourceResponse a2 = c.a(webResourceResponse);
                AppMethodBeat.o(153713);
                return a2;
            }
            WebResourceResponse shouldInterceptRequest = super.shouldInterceptRequest(webView, webResourceRequest);
            AppMethodBeat.o(153713);
            return shouldInterceptRequest;
        }

        public final void onScaleChanged(android.webkit.WebView webView, float f2, float f3) {
            AppMethodBeat.i(153714);
            if (e.this.SEn != null) {
                e.this.SEn.a(e.this.SEl, f2, f3);
                AppMethodBeat.o(153714);
                return;
            }
            super.onScaleChanged(webView, f2, f3);
            AppMethodBeat.o(153714);
        }

        public final void doUpdateVisitedHistory(android.webkit.WebView webView, String str, boolean z) {
            AppMethodBeat.i(153715);
            if (e.this.SEn != null) {
                e.this.SEn.b(e.this.SEl, str, z);
                AppMethodBeat.o(153715);
                return;
            }
            super.doUpdateVisitedHistory(webView, str, z);
            AppMethodBeat.o(153715);
        }

        public final void onReceivedError(android.webkit.WebView webView, int i2, String str, String str2) {
            AppMethodBeat.i(153716);
            if (e.this.SEn != null) {
                e.this.SEn.a(e.this.SEl, i2, str, str2);
            } else {
                super.onReceivedError(webView, i2, str, str2);
            }
            h.htY();
            h.hua();
            com.tencent.xweb.internal.h.htF().htM();
            AppMethodBeat.o(153716);
        }

        public final void onReceivedSslError(android.webkit.WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            AppMethodBeat.i(153717);
            Log.i("SysWebView", "onReceivedSslError " + sslError.getPrimaryError());
            if (e.this.SEn != null) {
                e.this.SEn.a(e.this.SEl, new c.a(sslErrorHandler), sslError);
                AppMethodBeat.o(153717);
                return;
            }
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            AppMethodBeat.o(153717);
        }

        public final void onReceivedHttpError(android.webkit.WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            com.tencent.xweb.WebResourceResponse webResourceResponse2;
            AppMethodBeat.i(153718);
            Log.i("SysWebView", "onReceivedHttpError code:".concat(String.valueOf(Build.VERSION.SDK_INT >= 21 ? String.valueOf(webResourceResponse.getStatusCode()) : "Invalid")));
            if (e.this.SEn != null) {
                ac acVar = e.this.SEn;
                WebView webView2 = e.this.SEl;
                c.f fVar = new c.f(webResourceRequest);
                if (webResourceResponse == null) {
                    webResourceResponse2 = null;
                } else if (Build.VERSION.SDK_INT >= 21) {
                    webResourceResponse2 = new com.tencent.xweb.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getStatusCode(), webResourceResponse.getReasonPhrase(), webResourceResponse.getResponseHeaders(), webResourceResponse.getData());
                } else {
                    webResourceResponse2 = new com.tencent.xweb.WebResourceResponse(webResourceResponse.getMimeType(), webResourceResponse.getEncoding(), webResourceResponse.getData());
                }
                acVar.a(webView2, fVar, webResourceResponse2);
                AppMethodBeat.o(153718);
                return;
            }
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            AppMethodBeat.o(153718);
        }

        public final void onReceivedHttpAuthRequest(android.webkit.WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            AppMethodBeat.i(207182);
            Log.i("SysWebView", "onReceivedHttpAuthRequest host:" + str + ", realm:" + str2);
            if (e.this.SEn != null) {
                e.this.SEn.a(e.this.SEl, new c.b(httpAuthHandler), str, str2);
                AppMethodBeat.o(207182);
                return;
            }
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            AppMethodBeat.o(207182);
        }
    };

    /* access modifiers changed from: package-private */
    public class a extends android.webkit.WebView {
        public ab mGX;

        public a(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public final void onScrollChanged(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(153720);
            super.onScrollChanged(i2, i3, i4, i5);
            if (e.this.SEl != null) {
                e.this.SEl.onWebViewScrollChanged(i2, i3, i4, i5);
            }
            if (this.mGX != null) {
                this.mGX.onScrollChanged(i2, i3, i4, i5, this);
            }
            AppMethodBeat.o(153720);
        }

        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            AppMethodBeat.i(153721);
            if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 4 && e.this.hasEnteredFullscreen()) {
                e.this.leaveFullscreen();
                AppMethodBeat.o(153721);
                return true;
            }
            AppMethodBeat.o(153721);
            return false;
        }

        public final int getScrollHeight() {
            AppMethodBeat.i(153722);
            int computeVerticalScrollRange = computeVerticalScrollRange();
            AppMethodBeat.o(153722);
            return computeVerticalScrollRange;
        }
    }

    public e(WebView webView) {
        AppMethodBeat.i(153725);
        this.SEl = webView;
        this.SEm = new a(webView.getContext());
        this.SEm.setBackgroundColor(0);
        getSettings();
        this.SEp = new d(this.SEm);
        this.SEm.setWebChromeClient(this.csS);
        this.SEm.setWebViewClient(this.mWebViewClient);
        if (Build.VERSION.SDK_INT < 19) {
            this.SEt = new b();
            this.SEm.addJavascriptInterface(this.SEt, "xwalkTempCallBack");
        }
        if (webView.getContext() instanceof Activity) {
            bB((Activity) webView.getContext());
            AppMethodBeat.o(153725);
            return;
        }
        bB(null);
        AppMethodBeat.o(153725);
    }

    private void bB(Activity activity) {
        AppMethodBeat.i(153726);
        Log.i("SysWebView", "initFullscreenVideo:" + getFullscreenVideoKind() + ",activity:" + activity);
        if (getFullscreenVideoKind() == WebView.a.NOT_HOOK) {
            AppMethodBeat.o(153726);
            return;
        }
        this.SEs = com.tencent.xweb.extension.video.e.a(activity, this.SEl, this.SEm, com.tencent.xweb.extension.video.d.htl());
        if (getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS) {
            this.SEs.eJ(this.SEm);
        }
        AppMethodBeat.o(153726);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final z getSettings() {
        AppMethodBeat.i(153727);
        if (this.SEq != null) {
            g gVar = this.SEq;
            AppMethodBeat.o(153727);
            return gVar;
        } else if (this.SEm == null) {
            AppMethodBeat.o(153727);
            return null;
        } else {
            this.SEq = new g(this.SEm);
            g gVar2 = this.SEq;
            AppMethodBeat.o(153727);
            return gVar2;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final View getWebViewUI() {
        return this.SEm;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final ViewGroup getTopView() {
        return this.SEm;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewClient(ac acVar) {
        this.SEn = acVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebChromeClient(x xVar) {
        this.SEo = xVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(153728);
        this.SEm.setDownloadListener(downloadListener);
        AppMethodBeat.o(153728);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setFindListener(WebView.FindListener findListener) {
        AppMethodBeat.i(153729);
        this.SEm.setFindListener(findListener);
        AppMethodBeat.o(153729);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadUrl(String str) {
        AppMethodBeat.i(153730);
        this.SEm.loadUrl(str);
        AppMethodBeat.o(153730);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean canGoBack() {
        AppMethodBeat.i(153731);
        boolean canGoBack = this.SEm.canGoBack();
        AppMethodBeat.o(153731);
        return canGoBack;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void goBack() {
        AppMethodBeat.i(153732);
        this.SEm.goBack();
        AppMethodBeat.o(153732);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean hasEnteredFullscreen() {
        return this.SBX;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void leaveFullscreen() {
        AppMethodBeat.i(153733);
        if (this.csS != null) {
            this.csS.onHideCustomView();
        }
        AppMethodBeat.o(153733);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearView() {
        AppMethodBeat.i(153734);
        this.SEm.clearView();
        AppMethodBeat.o(153734);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void destroy() {
        AppMethodBeat.i(153735);
        this.SEm.destroy();
        AppMethodBeat.o(153735);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void disableVideoJsCallback(boolean z) {
        AppMethodBeat.i(153736);
        if (this.SEs != null) {
            this.SEs.Em(z);
        }
        AppMethodBeat.o(153736);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final u setVideoJsCallback(v vVar) {
        AppMethodBeat.i(153737);
        if (this.SEs.eK(vVar)) {
            AnonymousClass1 r0 = new u() {
                /* class com.tencent.xweb.sys.e.AnonymousClass1 */

                @Override // com.tencent.xweb.u
                public final void hsz() {
                    AppMethodBeat.i(153688);
                    if (e.this.SEs != null) {
                        e.this.SEs.hsz();
                    }
                    AppMethodBeat.o(153688);
                }

                @Override // com.tencent.xweb.u
                public final void fDd() {
                    AppMethodBeat.i(153689);
                    if (e.this.SEs != null) {
                        e.this.SEs.fDd();
                    }
                    AppMethodBeat.o(153689);
                }

                @Override // com.tencent.xweb.u
                public final void F(double d2) {
                    AppMethodBeat.i(153690);
                    if (e.this.SEs != null) {
                        e.this.SEs.F(d2);
                    }
                    AppMethodBeat.o(153690);
                }

                @Override // com.tencent.xweb.u
                public final boolean hsA() {
                    AppMethodBeat.i(207181);
                    if (e.this.SEs != null) {
                        boolean hsA = e.this.SEs.hsA();
                        AppMethodBeat.o(207181);
                        return hsA;
                    }
                    AppMethodBeat.o(207181);
                    return false;
                }
            };
            AppMethodBeat.o(153737);
            return r0;
        }
        Log.i("SysWebView", "setVideoJsCallback not support");
        AppMethodBeat.o(153737);
        return null;
    }

    public static class b {
        HashMap<String, ValueCallback<String>> SEx = new HashMap<>();
        int SEy = 0;

        public b() {
            AppMethodBeat.i(153723);
            AppMethodBeat.o(153723);
        }

        @JavascriptInterface
        public final void notifyJava(String str, String str2) {
            AppMethodBeat.i(153724);
            ValueCallback<String> valueCallback = this.SEx.get(str);
            if (valueCallback != null) {
                valueCallback.onReceiveValue(str2);
                this.SEx.remove(str);
            }
            AppMethodBeat.o(153724);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        String str2;
        AppMethodBeat.i(153738);
        if (str == null) {
            AppMethodBeat.o(153738);
        } else if (Build.VERSION.SDK_INT >= 19) {
            this.SEm.evaluateJavascript(str, valueCallback);
            AppMethodBeat.o(153738);
        } else if (valueCallback == null) {
            this.SEm.loadUrl(str);
            AppMethodBeat.o(153738);
        } else {
            if (str.trim().startsWith("javascript:")) {
                str = str.replaceFirst("javascript:", "");
            }
            if (this.SEt == null) {
                this.SEt = new b();
                this.SEm.addJavascriptInterface(this.SEt, "xwalkTempCallBack");
            }
            b bVar = this.SEt;
            if (valueCallback != null) {
                StringBuilder sb = new StringBuilder();
                int i2 = bVar.SEy;
                bVar.SEy = i2 + 1;
                str2 = sb.append(i2).toString();
                bVar.SEx.put(str2, valueCallback);
            } else {
                str2 = "";
            }
            this.SEm.loadUrl("javascript:xwalkTempCallBack.notifyJava(" + str2 + ", " + str + ")");
            AppMethodBeat.o(153738);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final com.tencent.xweb.internal.e getDefalutOpProvider() {
        return this.SEp;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void reload() {
        AppMethodBeat.i(153739);
        this.SEm.reload();
        AppMethodBeat.o(153739);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearSslPreferences() {
        AppMethodBeat.i(153740);
        this.SEm.clearSslPreferences();
        AppMethodBeat.o(153740);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(153741);
        this.SEm.loadData(str, str2, str3);
        AppMethodBeat.o(153741);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getContentHeight() {
        AppMethodBeat.i(153742);
        int contentHeight = this.SEm.getContentHeight();
        AppMethodBeat.o(153742);
        return contentHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final float getScale() {
        AppMethodBeat.i(153743);
        float scale = this.SEm.getScale();
        AppMethodBeat.o(153743);
        return scale;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getVisibleTitleHeight() {
        AppMethodBeat.i(153744);
        Object f2 = g.f(this.SEm, "getVisibleTitleHeight");
        if (f2 == null) {
            AppMethodBeat.o(153744);
            return 0;
        }
        int intValue = ((Integer) f2).intValue();
        AppMethodBeat.o(153744);
        return intValue;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(153745);
        boolean overlayHorizontalScrollbar = this.SEm.overlayHorizontalScrollbar();
        AppMethodBeat.o(153745);
        return overlayHorizontalScrollbar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(153746);
        this.SEm.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(153746);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean zoomOut() {
        AppMethodBeat.i(153747);
        boolean zoomOut = this.SEm.zoomOut();
        AppMethodBeat.o(153747);
        return zoomOut;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean zoomIn() {
        AppMethodBeat.i(153748);
        boolean zoomIn = this.SEm.zoomIn();
        AppMethodBeat.o(153748);
        return zoomIn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(153749);
        this.SEm.loadUrl(str, map);
        AppMethodBeat.o(153749);
    }

    @Override // com.tencent.xweb.internal.IWebView
    @SuppressLint({"JavascriptInterface"})
    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(153750);
        this.SEm.addJavascriptInterface(obj, str);
        AppMethodBeat.o(153750);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final View getView() {
        return this.SEm;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getUrl() {
        AppMethodBeat.i(153751);
        String url = this.SEm.getUrl();
        AppMethodBeat.o(153751);
        return url;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(153752);
        this.SEm.removeJavascriptInterface(str);
        AppMethodBeat.o(153752);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void stopLoading() {
        AppMethodBeat.i(153753);
        this.SEm.stopLoading();
        AppMethodBeat.o(153753);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewCallbackClient(ab abVar) {
        if (this.SEm != null) {
            this.SEm.mGX = abVar;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebView.b getHitTestResult() {
        AppMethodBeat.i(153754);
        WebView.HitTestResult hitTestResult = this.SEm.getHitTestResult();
        WebView.b bVar = new WebView.b();
        bVar.mType = hitTestResult.getType();
        bVar.mExtra = hitTestResult.getExtra();
        AppMethodBeat.o(153754);
        return bVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getTitle() {
        AppMethodBeat.i(153755);
        String title = this.SEm.getTitle();
        AppMethodBeat.o(153755);
        return title;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearMatches() {
        AppMethodBeat.i(153756);
        this.SEm.clearMatches();
        AppMethodBeat.o(153756);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void findNext(boolean z) {
        AppMethodBeat.i(153757);
        this.SEm.findNext(z);
        AppMethodBeat.o(153757);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void findAllAsync(String str) {
        AppMethodBeat.i(153758);
        this.SEm.findAllAsync(str);
        AppMethodBeat.o(153758);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getVersionInfo() {
        AppMethodBeat.i(153759);
        String str = "webviewtype = WV_KIND_SYS, version = " + XWalkEnvironment.getChromiunVersion() + ", V8 type=" + JsRuntime.hsv();
        AppMethodBeat.o(153759);
        return str;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getAbstractInfo() {
        AppMethodBeat.i(153760);
        String versionInfo = getVersionInfo();
        AppMethodBeat.o(153760);
        return versionInfo;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean isSupportExtendPluginForAppbrand() {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final ac getCurWebviewClient() {
        return this.SEn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final x getCurWebChromeClient() {
        return this.SEo;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getWebScrollY() {
        AppMethodBeat.i(153761);
        int scrollY = this.SEm.getScrollY();
        AppMethodBeat.o(153761);
        return scrollY;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getWebScrollX() {
        AppMethodBeat.i(153762);
        int scrollX = getWebViewUI().getScrollX();
        AppMethodBeat.o(153762);
        return scrollX;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean isOverScrollStart() {
        AppMethodBeat.i(153763);
        if (getWebViewUI().getScrollY() == 0) {
            AppMethodBeat.o(153763);
            return true;
        }
        AppMethodBeat.o(153763);
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Object getX5WebViewExtension() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a aVar) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void super_onOverScrolled(int i2, int i3, boolean z, boolean z2) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void super_computeScroll() {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void super_onScrollChanged(int i2, int i3, int i4, int i5) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onResume() {
        AppMethodBeat.i(153764);
        this.SEm.onResume();
        AppMethodBeat.o(153764);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onPause() {
        AppMethodBeat.i(153765);
        this.SEm.onPause();
        AppMethodBeat.o(153765);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebView.a getFullscreenVideoKind() {
        AppMethodBeat.i(153766);
        WebView.a brG = com.tencent.xweb.a.brG(com.tencent.xweb.WebView.getCurStrModule());
        AppMethodBeat.o(153766);
        return brG;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setJSExceptionListener(ae aeVar) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean savePage(String str, String str2, int i2) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearHistory() {
        AppMethodBeat.i(153767);
        this.SEm.clearHistory();
        AppMethodBeat.o(153767);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean canGoForward() {
        AppMethodBeat.i(153768);
        boolean canGoForward = this.SEm.canGoForward();
        AppMethodBeat.o(153768);
        return canGoForward;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void goForward() {
        AppMethodBeat.i(153769);
        this.SEm.goForward();
        AppMethodBeat.o(153769);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean supportFeature(int i2) {
        if (i2 != 2006 || Build.VERSION.SDK_INT < 23) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(153770);
        this.SEm.setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(153770);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(153771);
        this.SEm.setHorizontalScrollBarEnabled(z);
        AppMethodBeat.o(153771);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Bundle invokeMiscMethod(String str, Bundle bundle) {
        AppMethodBeat.i(153772);
        if (str == null || str.length() == 0) {
            Log.d("SysWebView", " method string is null or empty");
            AppMethodBeat.o(153772);
            return null;
        } else if (str.equals("supportTranslateWebSite")) {
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", false);
            Log.i("SysWebView", "sys web is not supportTranslateWebSite");
            AppMethodBeat.o(153772);
            return bundle2;
        } else {
            AppMethodBeat.o(153772);
            return null;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean getImageBitmapToFile(String str, String str2, String str3, i iVar) {
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Bitmap captureBitmap() {
        AppMethodBeat.i(207183);
        Bitmap createBitmap = Bitmap.createBitmap(this.SEm.getWidth(), this.SEm.getHeight(), Bitmap.Config.ARGB_8888);
        this.SEm.draw(new Canvas(createBitmap));
        AppMethodBeat.o(207183);
        return createBitmap;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void captureBitmap(final IWebView.a aVar) {
        AppMethodBeat.i(153773);
        new Thread(new Runnable() {
            /* class com.tencent.xweb.sys.e.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(153719);
                e.this.SEm.draw(new Canvas(Bitmap.createBitmap(e.this.SEm.getWidth(), e.this.SEm.getHeight(), Bitmap.Config.ARGB_8888)));
                Log.d("SysWebView", "bitmapCaptureFinished");
                AppMethodBeat.o(153719);
            }
        }).start();
        AppMethodBeat.o(153773);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void smoothScroll(int i2, int i3, long j2) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setBottomHeight(int i2) {
        AppMethodBeat.i(153774);
        Log.e("SysWebView", "setBottomHeight not implement");
        AppMethodBeat.o(153774);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onShow() {
        AppMethodBeat.i(153775);
        this.SEm.onPause();
        AppMethodBeat.o(153775);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onHide() {
        AppMethodBeat.i(153776);
        this.SEm.onPause();
        AppMethodBeat.o(153776);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getScrollHeight() {
        AppMethodBeat.i(153777);
        int scrollHeight = this.SEm.getScrollHeight();
        AppMethodBeat.o(153777);
        return scrollHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebBackForwardList copyBackForwardList() {
        AppMethodBeat.i(207184);
        WebBackForwardList copyBackForwardList = this.SEm.copyBackForwardList();
        AppMethodBeat.o(207184);
        return copyBackForwardList;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(207185);
        ad.hta().setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(207185);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(207186);
        String[] httpAuthUsernamePassword = ad.hta().getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(207186);
        return httpAuthUsernamePassword;
    }
}
