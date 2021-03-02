package com.tencent.mm.plugin.webview.luggage.webview_impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import com.tencent.luggage.d.p;
import com.tencent.luggage.webview.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.downloader.model.DownloadChecker;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.luggage.LuggageMMLocalResourceProvider;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.h;
import com.tencent.mm.plugin.webview.luggage.i;
import com.tencent.mm.plugin.webview.modeltools.j;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Map;

public class a extends MMWebView implements com.tencent.luggage.webview.a {
    private Handler AFJ = new Handler(Looper.getMainLooper());
    protected c ITv = new c();
    private WeakReference<g> IXd;
    private i IXe = new i() {
        /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass9 */

        @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(78799);
            Log.i(getClass().getSimpleName(), "onPageStarted");
            super.b(webView, str, bitmap);
            AppMethodBeat.o(78799);
        }
    };
    private f IXf = new f() {
        /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass10 */
    };
    private h IXg = new h() {
        /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.i(78771);
            if (a.this.IXd.get() == null) {
                Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "page is null");
                Object onMiscCallBack = super.onMiscCallBack(str, bundle);
                AppMethodBeat.o(78771);
                return onMiscCallBack;
            } else if (str == null) {
                Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "method is null");
                Object onMiscCallBack2 = super.onMiscCallBack(str, bundle);
                AppMethodBeat.o(78771);
                return onMiscCallBack2;
            } else {
                if (str.equals("getDrawable")) {
                    String string = bundle.getString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
                    int i2 = bundle.getInt("resourceId");
                    if (!Util.isNullOrNil(string) && i2 > 0) {
                        try {
                            Drawable g2 = b.g(MMApplicationContext.getContext().getPackageManager().getResourcesForApplication(string), i2);
                            AppMethodBeat.o(78771);
                            return g2;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.LuggageMMWebViewCoreImpl", "get resource for package : %s, fail, : %s", string, e2.getMessage());
                        }
                    }
                }
                if (str.equals("getShareUrl")) {
                    try {
                        String aZj = ((g) a.this.IXd.get()).gbF().aZj(a.this.getUrl());
                        Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "getShareUrl by x5 core, shareurl = %s", aZj);
                        AppMethodBeat.o(78771);
                        return aZj;
                    } catch (Exception e3) {
                        Log.e("MicroMsg.LuggageMMWebViewCoreImpl", "getShare url failed");
                    }
                }
                if (str.equals("supportImagePreview")) {
                    Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "supportImagePreview");
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(78771);
                    return bool;
                } else if (str.equals("imagePreview")) {
                    j.a(bundle, ((g) a.this.IXd.get()).ITd, null, ((g) a.this.IXd.get()).isFullScreen());
                    Boolean bool2 = Boolean.TRUE;
                    AppMethodBeat.o(78771);
                    return bool2;
                } else if (str.equals("closeImagePreview")) {
                    j.gdC();
                    Boolean bool3 = Boolean.TRUE;
                    AppMethodBeat.o(78771);
                    return bool3;
                } else {
                    Object onMiscCallBack3 = super.onMiscCallBack(str, bundle);
                    AppMethodBeat.o(78771);
                    return onMiscCallBack3;
                }
            }
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(78772);
            if (a.this.mGX.B(motionEvent) || super.onTouchEvent(motionEvent, view)) {
                AppMethodBeat.o(78772);
                return true;
            }
            AppMethodBeat.o(78772);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(78773);
            if (a.this.mGX.D(motionEvent) || super.onInterceptTouchEvent(motionEvent, view)) {
                AppMethodBeat.o(78773);
                return true;
            }
            AppMethodBeat.o(78773);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(78774);
            if (a.this.mGX.C(motionEvent) || super.dispatchTouchEvent(motionEvent, view)) {
                AppMethodBeat.o(78774);
                return true;
            }
            AppMethodBeat.o(78774);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
            AppMethodBeat.i(78775);
            if (a.this.mGX.b(i2, i3, i4, i5, i6, i7, i8, i9, z) || super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, view)) {
                AppMethodBeat.o(78775);
                return true;
            }
            AppMethodBeat.o(78775);
            return false;
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
            AppMethodBeat.i(78776);
            a.this.mGX.onScrollChanged(i2, i3, i4, i5, view);
            super.onScrollChanged(i2, i3, i4, i5, view);
            AppMethodBeat.o(78776);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
            AppMethodBeat.i(78777);
            a.this.mGX.d(i2, i3, z, z2);
            super.onOverScrolled(i2, i3, z, z2, view);
            AppMethodBeat.o(78777);
        }

        @Override // com.tencent.mm.plugin.webview.luggage.h, com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void computeScroll(View view) {
            AppMethodBeat.i(78778);
            a.this.mGX.bLv();
            super.computeScroll(view);
            AppMethodBeat.o(78778);
        }
    };
    private p ctS;
    private boolean mDestroyed = false;
    private ab mGX = new ab() {
        /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass2 */

        @Override // com.tencent.xweb.ab
        public final boolean B(MotionEvent motionEvent) {
            AppMethodBeat.i(78779);
            boolean am = a.this.am(motionEvent);
            AppMethodBeat.o(78779);
            return am;
        }

        @Override // com.tencent.xweb.ab
        public final boolean b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
            AppMethodBeat.i(78780);
            boolean c2 = a.this.c(i2, i3, i4, i5, i6, i7, i8, i9, z);
            AppMethodBeat.o(78780);
            return c2;
        }

        @Override // com.tencent.xweb.ab
        public final void bLv() {
            AppMethodBeat.i(78781);
            a.this.gYY();
            AppMethodBeat.o(78781);
        }

        @Override // com.tencent.xweb.ab
        @TargetApi(9)
        public final void d(int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(78782);
            a.this.h(i2, i3, z, z2);
            AppMethodBeat.o(78782);
        }

        @Override // com.tencent.xweb.ab
        public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
            AppMethodBeat.i(78783);
            a.this.R(i2, i3, i4, i5);
            AppMethodBeat.o(78783);
        }

        @Override // com.tencent.xweb.ab
        public final boolean C(MotionEvent motionEvent) {
            AppMethodBeat.i(78784);
            boolean an = a.this.an(motionEvent);
            AppMethodBeat.o(78784);
            return an;
        }

        @Override // com.tencent.xweb.ab
        public final boolean D(MotionEvent motionEvent) {
            AppMethodBeat.i(78785);
            boolean ao = a.this.ao(motionEvent);
            AppMethodBeat.o(78785);
            return ao;
        }
    };
    public String yCr;

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(78827);
        super.loadUrl(str);
        AppMethodBeat.o(78827);
    }

    static /* synthetic */ void a(a aVar, String str, ValueCallback valueCallback) {
        AppMethodBeat.i(78825);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(78825);
    }

    static /* synthetic */ void a(a aVar, String str, String str2, String str3) {
        AppMethodBeat.i(78829);
        super.loadData(str, str2, str3);
        AppMethodBeat.o(78829);
    }

    static /* synthetic */ void a(a aVar, String str, Map map) {
        AppMethodBeat.i(78828);
        super.loadUrl(str, map);
        AppMethodBeat.o(78828);
    }

    public a(Context context) {
        super(context);
        AppMethodBeat.i(78800);
        this.gKM = true;
        this.isX5Kernel = getX5WebViewExtension() != null;
        x.a.iq(getContext());
        if (!getIsX5Kernel() && !d.oD(19)) {
            try {
                Object obj = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
                Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", obj);
                Object obj2 = new com.tencent.mm.compatible.loader.c(obj, "mProvider", null).get();
                Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", obj2);
                Object obj3 = new com.tencent.mm.compatible.loader.c(obj2, "mWebViewCore", null).get();
                Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", obj3);
                Object obj4 = new com.tencent.mm.compatible.loader.c(obj3, "sWebCoreHandler", null).get();
                Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", obj4);
                Object obj5 = new com.tencent.mm.compatible.loader.c(obj4, "mLooper", null).get();
                Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mLooper = %s", obj5);
                Object obj6 = new com.tencent.mm.compatible.loader.c(obj5, "mThread", null).get();
                Log.d("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, mThread = %s", obj6);
                if (obj6 instanceof Thread) {
                    Thread thread = (Thread) obj6;
                    Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", thread.getState());
                    if (thread.getState() == Thread.State.WAITING) {
                        thread.interrupt();
                    }
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.LuggageMMWebViewCoreImpl", "tryInterruptAwaitingWebCoreThread, exception = %s", e2);
            }
        }
        kI(getContext());
        getSettings().setUseWideViewPort(true);
        getSettings().setLoadWithOverviewMode(true);
        getSettings().hsU();
        getSettings().hsN();
        getSettings().hsM();
        getSettings().setGeolocationEnabled(true);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().hsW();
        getSettings().hsS();
        getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        getSettings().hsR();
        getSettings().hsT();
        getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
        com.tencent.xweb.c.hsp().hsq();
        com.tencent.xweb.c.hsp().e(this);
        getSettings().setUserAgentString(z.cr(getContext(), getSettings().getUserAgentString()) + " Luggage");
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        super.setWebViewClient(this.IXe);
        super.setWebChromeClient(this.IXf);
        if (getIsX5Kernel()) {
            super.setWebViewCallbackClient(this.mGX);
        }
        super.setWebViewClientExtension(this.IXg);
        gYX();
        AppMethodBeat.o(78800);
    }

    @Override // com.tencent.luggage.webview.a
    public void setContext(Context context) {
        AppMethodBeat.i(78801);
        if (getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) getContext()).setBaseContext(context);
        }
        AppMethodBeat.o(78801);
    }

    public void setSource(String str) {
        this.yCr = str;
    }

    public void setPage(g gVar) {
        AppMethodBeat.i(182690);
        this.IXd = new WeakReference<>(gVar);
        AppMethodBeat.o(182690);
    }

    /* access modifiers changed from: protected */
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(78802);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.o(78802);
            return;
        }
        this.AFJ.post(runnable);
        AppMethodBeat.o(78802);
    }

    @Override // com.tencent.luggage.bridge.s
    public String getUserAgent() {
        AppMethodBeat.i(210968);
        String userAgentString = getSettings().getUserAgentString();
        AppMethodBeat.o(210968);
        return userAgentString;
    }

    @Override // com.tencent.luggage.bridge.s, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(78803);
        super.addJavascriptInterface(obj, str);
        AppMethodBeat.o(78803);
    }

    @Override // com.tencent.luggage.bridge.s, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView, com.tencent.luggage.webview.a
    public void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(78805);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(78786);
                a.a(a.this, str, valueCallback);
                AppMethodBeat.o(78786);
            }
        });
        AppMethodBeat.o(78805);
    }

    @Override // com.tencent.luggage.webview.a
    public void setWebCore(p pVar) {
        AppMethodBeat.i(78806);
        this.ctS = pVar;
        LE();
        AppMethodBeat.o(78806);
    }

    public p getWebCore() {
        return this.ctS;
    }

    /* access modifiers changed from: protected */
    public void LE() {
        AppMethodBeat.i(78807);
        if (getWebCore().ctM != null) {
            getWebCore().ctM.a(new LuggageMMLocalResourceProvider());
            getWebCore().ctM.a(new e(com.tencent.mm.plugin.appbrand.ac.d.afA("luggage_mm_adapter.js")));
        }
        AppMethodBeat.o(78807);
    }

    @Override // com.tencent.luggage.webview.a
    public void a(final a.AbstractC0187a aVar) {
        AppMethodBeat.i(78808);
        runOnUiThread(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(78787);
                a.a(a.this, aVar);
                AppMethodBeat.o(78787);
            }
        });
        AppMethodBeat.o(78808);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public View getView() {
        return this;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView, com.tencent.luggage.webview.a
    public void loadUrl(final String str) {
        AppMethodBeat.i(78809);
        AnonymousClass5 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(78788);
                a.a(a.this, str);
                AppMethodBeat.o(78788);
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r0.run();
            AppMethodBeat.o(78809);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(78809);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public void loadUrl(final String str, final Map<String, String> map) {
        AppMethodBeat.i(78810);
        AnonymousClass6 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(78789);
                a.a(a.this, str, map);
                AppMethodBeat.o(78789);
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r0.run();
            AppMethodBeat.o(78810);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(78810);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public void loadData(final String str, final String str2, final String str3) {
        AppMethodBeat.i(78811);
        AnonymousClass7 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(78790);
                a.a(a.this, str, str2, str3);
                AppMethodBeat.o(78790);
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            r0.run();
            AppMethodBeat.o(78811);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(78811);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public void stopLoading() {
        AppMethodBeat.i(78812);
        super.stopLoading();
        AppMethodBeat.o(78812);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public String getUrl() {
        AppMethodBeat.i(78813);
        String url = super.getUrl();
        AppMethodBeat.o(78813);
        return url;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public String getTitle() {
        AppMethodBeat.i(78814);
        String title = super.getTitle();
        AppMethodBeat.o(78814);
        return title;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public void goBack() {
        AppMethodBeat.i(78815);
        super.goBack();
        AppMethodBeat.o(78815);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.luggage.webview.a
    public boolean canGoBack() {
        AppMethodBeat.i(78816);
        boolean canGoBack = super.canGoBack();
        AppMethodBeat.o(78816);
        return canGoBack;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView, com.tencent.luggage.webview.a
    public void destroy() {
        AppMethodBeat.i(78817);
        if (this.mDestroyed) {
            AppMethodBeat.o(78817);
            return;
        }
        try {
            super.destroy();
        } catch (NullPointerException e2) {
            Log.printErrStackTrace("MicroMsg.LuggageMMWebViewCoreImpl", e2, "destroy()", new Object[0]);
        } finally {
            this.mDestroyed = true;
            AppMethodBeat.o(78817);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void setWebViewClient(ac acVar) {
        AppMethodBeat.i(78818);
        this.IXe.a(acVar);
        AppMethodBeat.o(78818);
    }

    /* access modifiers changed from: protected */
    public void setWebViewClientProxy(i iVar) {
        AppMethodBeat.i(78819);
        if (iVar != null) {
            this.IXe.a(iVar);
            this.IXe = iVar;
        }
        AppMethodBeat.o(78819);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView
    public void setWebChromeClient(com.tencent.xweb.x xVar) {
        AppMethodBeat.i(78820);
        this.IXf.a(xVar);
        AppMethodBeat.o(78820);
    }

    /* access modifiers changed from: protected */
    public void setWebChromeClientProxy(f fVar) {
        AppMethodBeat.i(78821);
        if (fVar != null) {
            this.IXf.a(fVar);
            this.IXf = fVar;
        }
        AppMethodBeat.o(78821);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a aVar) {
        AppMethodBeat.i(78822);
        this.IXg.a(aVar);
        AppMethodBeat.o(78822);
    }

    /* access modifiers changed from: protected */
    public void setWebViewClientExtensionProxy(h hVar) {
        AppMethodBeat.i(78823);
        if (hVar != null) {
            this.IXg.a(hVar);
            this.IXg = hVar;
        }
        AppMethodBeat.o(78823);
    }

    static /* synthetic */ void a(a aVar, final a.AbstractC0187a aVar2) {
        AppMethodBeat.i(78826);
        aVar.setWebViewClientProxy(new i() {
            /* class com.tencent.mm.plugin.webview.luggage.webview_impl.a.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(78791);
                if (DownloadChecker.a(str, a.this.yCr, webView)) {
                    Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "use the downloader to download");
                    AppMethodBeat.o(78791);
                    return true;
                } else if (aVar2.cU(str) || super.a(webView, str)) {
                    AppMethodBeat.o(78791);
                    return true;
                } else {
                    AppMethodBeat.o(78791);
                    return false;
                }
            }

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(78792);
                aVar2.cV(str);
                super.b(webView, str, bitmap);
                AppMethodBeat.o(78792);
            }

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(78793);
                aVar2.cW(str);
                super.b(webView, str);
                AppMethodBeat.o(78793);
            }

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final void h(WebView webView, String str) {
                AppMethodBeat.i(78794);
                super.h(webView, str);
                AppMethodBeat.o(78794);
            }

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(78795);
                Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", webResourceRequest.getUrl().toString());
                WebResourceResponse a2 = a(webResourceRequest, new Bundle());
                if (a2 != null) {
                    AppMethodBeat.o(78795);
                    return a2;
                }
                WebResourceResponse a3 = super.a(webView, webResourceRequest);
                AppMethodBeat.o(78795);
                return a3;
            }

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final WebResourceResponse c(WebView webView, String str) {
                WebResourceResponse webResourceResponse;
                AppMethodBeat.i(78796);
                Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", str);
                android.webkit.WebResourceResponse cX = aVar2.cX(str);
                if (cX == null) {
                    webResourceResponse = null;
                } else if (Build.VERSION.SDK_INT >= 21) {
                    webResourceResponse = new WebResourceResponse(cX.getMimeType(), cX.getEncoding(), cX.getStatusCode(), cX.getReasonPhrase(), cX.getResponseHeaders(), cX.getData());
                } else {
                    webResourceResponse = new WebResourceResponse(cX.getMimeType(), cX.getEncoding(), cX.getData());
                }
                if (webResourceResponse != null) {
                    AppMethodBeat.o(78796);
                    return webResourceResponse;
                }
                WebResourceResponse c2 = super.c(webView, str);
                AppMethodBeat.o(78796);
                return c2;
            }

            @Override // com.tencent.mm.plugin.webview.luggage.i, com.tencent.xweb.ac
            public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
                AppMethodBeat.i(78797);
                Log.i("MicroMsg.LuggageMMWebViewCoreImpl", "shouldInterceptRequest, url: %s", webResourceRequest.getUrl().toString());
                WebResourceResponse a2 = a(webResourceRequest, bundle);
                if (a2 != null) {
                    AppMethodBeat.o(78797);
                    return a2;
                }
                WebResourceResponse c2 = super.c(webView, webResourceRequest.getUrl().toString());
                AppMethodBeat.o(78797);
                return c2;
            }

            private WebResourceResponse a(WebResourceRequest webResourceRequest, Bundle bundle) {
                AppMethodBeat.i(78798);
                android.webkit.WebResourceResponse a2 = aVar2.a(new b(webResourceRequest.getUrl(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()), bundle);
                if (a2 == null) {
                    AppMethodBeat.o(78798);
                    return null;
                } else if (Build.VERSION.SDK_INT >= 21) {
                    WebResourceResponse webResourceResponse = new WebResourceResponse(a2.getMimeType(), a2.getEncoding(), a2.getStatusCode(), a2.getReasonPhrase(), a2.getResponseHeaders(), a2.getData());
                    AppMethodBeat.o(78798);
                    return webResourceResponse;
                } else {
                    WebResourceResponse webResourceResponse2 = new WebResourceResponse(a2.getMimeType(), a2.getEncoding(), a2.getData());
                    AppMethodBeat.o(78798);
                    return webResourceResponse2;
                }
            }
        });
        AppMethodBeat.o(78826);
    }
}
