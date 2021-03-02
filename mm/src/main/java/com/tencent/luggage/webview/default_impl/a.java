package com.tencent.luggage.webview.default_impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

public class a implements com.tencent.luggage.webview.a {
    private DefaultWebView cDw;
    private p ctS;
    private Context mContext;
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    public a(Context context) {
        AppMethodBeat.i(140543);
        this.mContext = context;
        this.cDw = new DefaultWebView(context);
        AppMethodBeat.o(140543);
    }

    @Override // com.tencent.luggage.webview.a
    public final void a(final a.AbstractC0187a aVar) {
        AppMethodBeat.i(140544);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.luggage.webview.default_impl.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(140532);
                a.a(a.this, aVar);
                AppMethodBeat.o(140532);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
            AppMethodBeat.o(140544);
            return;
        }
        this.mainThreadHandler.post(r0);
        AppMethodBeat.o(140544);
    }

    @Override // com.tencent.luggage.webview.a
    public void setContext(Context context) {
        AppMethodBeat.i(140545);
        if (this.mContext instanceof MutableContextWrapper) {
            ((MutableContextWrapper) this.mContext).setBaseContext(context);
        }
        AppMethodBeat.o(140545);
    }

    @Override // com.tencent.luggage.webview.a
    public void setWebCore(p pVar) {
        this.ctS = pVar;
    }

    @Override // com.tencent.luggage.webview.a
    public View getView() {
        return this.cDw;
    }

    @Override // com.tencent.luggage.webview.a
    public void loadUrl(final String str) {
        AppMethodBeat.i(140546);
        AnonymousClass2 r0 = new Runnable() {
            /* class com.tencent.luggage.webview.default_impl.a.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(140533);
                a.this.cDw.loadUrl(str);
                AppMethodBeat.o(140533);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
            AppMethodBeat.o(140546);
            return;
        }
        this.mainThreadHandler.post(r0);
        AppMethodBeat.o(140546);
    }

    @Override // com.tencent.luggage.webview.a
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(140547);
        this.cDw.loadUrl(str, map);
        AppMethodBeat.o(140547);
    }

    @Override // com.tencent.luggage.webview.a
    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(140548);
        this.cDw.loadData(str, str2, str3);
        AppMethodBeat.o(140548);
    }

    @Override // com.tencent.luggage.webview.a
    public void stopLoading() {
        AppMethodBeat.i(140549);
        this.cDw.stopLoading();
        AppMethodBeat.o(140549);
    }

    @Override // com.tencent.luggage.webview.a
    public void goBack() {
        AppMethodBeat.i(140550);
        this.cDw.goBack();
        AppMethodBeat.o(140550);
    }

    @Override // com.tencent.luggage.webview.a
    public boolean canGoBack() {
        AppMethodBeat.i(140551);
        boolean canGoBack = this.cDw.canGoBack();
        AppMethodBeat.o(140551);
        return canGoBack;
    }

    @Override // com.tencent.luggage.webview.a
    public void destroy() {
        AppMethodBeat.i(140552);
        this.cDw.destroy();
        AppMethodBeat.o(140552);
    }

    @Override // com.tencent.luggage.bridge.s
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.tencent.luggage.bridge.s
    public String getUserAgent() {
        return "";
    }

    @Override // com.tencent.luggage.bridge.s
    public void addJavascriptInterface(final Object obj, final String str) {
        AppMethodBeat.i(140553);
        AnonymousClass3 r0 = new Runnable() {
            /* class com.tencent.luggage.webview.default_impl.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(140534);
                a.this.cDw.addJavascriptInterface(obj, str);
                AppMethodBeat.o(140534);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
            AppMethodBeat.o(140553);
            return;
        }
        this.mainThreadHandler.post(r0);
        AppMethodBeat.o(140553);
    }

    @Override // com.tencent.luggage.webview.a, com.tencent.luggage.bridge.s
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(221211);
        AnonymousClass4 r0 = new Runnable() {
            /* class com.tencent.luggage.webview.default_impl.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(140535);
                a.this.cDw.evaluateJavascript(str, valueCallback);
                AppMethodBeat.o(140535);
            }
        };
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            r0.run();
            AppMethodBeat.o(221211);
            return;
        }
        this.mainThreadHandler.post(r0);
        AppMethodBeat.o(221211);
    }

    static /* synthetic */ void a(a aVar, final a.AbstractC0187a aVar2) {
        AppMethodBeat.i(140555);
        aVar.cDw.setWebViewClient(new WebViewClient() {
            /* class com.tencent.luggage.webview.default_impl.a.AnonymousClass5 */

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                AppMethodBeat.i(140536);
                boolean cU = aVar2.cU(str);
                AppMethodBeat.o(140536);
                return cU;
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(140537);
                boolean cU = aVar2.cU(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(140537);
                return cU;
            }

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(140538);
                aVar2.cV(str);
                AppMethodBeat.o(140538);
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.i(140539);
                aVar2.cW(str);
                AppMethodBeat.o(140539);
            }

            @Override // android.webkit.WebViewClient
            @TargetApi(21)
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(140540);
                WebResourceResponse cX = aVar2.cX(webResourceRequest.getUrl().toString());
                AppMethodBeat.o(140540);
                return cX;
            }

            @Override // android.webkit.WebViewClient
            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                AppMethodBeat.i(140541);
                WebResourceResponse cX = aVar2.cX(str);
                AppMethodBeat.o(140541);
                return cX;
            }
        });
        aVar.cDw.setWebChromeClient(new DefaultWebCore$6(aVar, aVar2));
        AppMethodBeat.o(140555);
    }
}
