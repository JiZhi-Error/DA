package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.http.SslError;
import android.os.Build;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.m.j;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.net.URL;
import java.util.Map;

@JgClassChecked(author = 10, fComment = "checked", lastDate = "20180817", reviewer = 10, vComment = {EType.HTTPSCHECK})
public final class aw extends WebView implements bc {
    private WebChromeClient csS;
    private String mUserAgent;
    private WebViewClient mWebViewClient;
    private an nsh;
    private Animator nsi;
    private as ntc;
    private ap ntd;
    private d nte;

    static /* synthetic */ void a(aw awVar, String str, ValueCallback valueCallback) {
        AppMethodBeat.i(135276);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(135276);
    }

    public aw(Context context, an anVar) {
        super(context);
        AppMethodBeat.i(135258);
        this.mWebViewClient = new WebViewClient() {
            /* class com.tencent.mm.plugin.appbrand.page.aw.AnonymousClass3 */

            public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(135253);
                an unused = aw.this.nsh;
                AppMethodBeat.o(135253);
            }

            public final void onPageFinished(WebView webView, String str) {
                AppMethodBeat.i(135254);
                aw.this.nsh.cW(str);
                AppMethodBeat.o(135254);
            }

            @Override // android.webkit.WebViewClient
            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return true;
            }

            public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                AppMethodBeat.i(135255);
                if (sslError.getPrimaryError() != 3) {
                    sslErrorHandler.cancel();
                    AppMethodBeat.o(135255);
                } else if (aw.this.nsh.a(sslError.getCertificate())) {
                    sslErrorHandler.proceed();
                    AppMethodBeat.o(135255);
                } else {
                    sslErrorHandler.cancel();
                    AppMethodBeat.o(135255);
                }
            }

            @Override // android.webkit.WebViewClient
            public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                AppMethodBeat.i(135256);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(135256);
                    return null;
                }
                WebResourceResponse adS = aw.this.nsh.adS(str);
                AppMethodBeat.o(135256);
                return adS;
            }

            @Override // android.webkit.WebViewClient
            public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(135257);
                if (Build.VERSION.SDK_INT < 21) {
                    AppMethodBeat.o(135257);
                    return null;
                } else if (webResourceRequest == null || webResourceRequest.getUrl() == null || Util.isNullOrNil(webResourceRequest.getUrl().toString())) {
                    AppMethodBeat.o(135257);
                    return null;
                } else {
                    WebResourceResponse adS = aw.this.nsh.adS(webResourceRequest.getUrl().toString());
                    AppMethodBeat.o(135257);
                    return adS;
                }
            }
        };
        this.csS = new DefaultWebViewImpl$4(this);
        this.nsh = anVar;
        getSettings().setDomStorageEnabled(true);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        if (Build.VERSION.SDK_INT >= 21) {
            getSettings().setMixedContentMode(0);
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + "/ DEMO");
        this.mUserAgent = getSettings().getUserAgentString();
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setWebViewClient(this.mWebViewClient);
        setWebChromeClient(this.csS);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AppMethodBeat.o(135258);
    }

    public aw(Context context) {
        this(context, null);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bc
    public final void setAppBrandWebViewClient(an anVar) {
        this.nsh = anVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void aG(Context context) {
        AppMethodBeat.i(135259);
        if (!(getContext() instanceof MutableContextWrapper)) {
            AppMethodBeat.o(135259);
            return;
        }
        ((MutableContextWrapper) getContext()).setBaseContext(context);
        AppMethodBeat.o(135259);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final View getWrapperView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final View getContentView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(135260);
        draw(canvas);
        AppMethodBeat.o(135260);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void i(Runnable runnable) {
        AppMethodBeat.i(135261);
        if (runnable != null) {
            postOnAnimation(runnable);
        }
        AppMethodBeat.o(135261);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void x(String str, String str2) {
        AppMethodBeat.i(135262);
        super.loadDataWithBaseURL(str, str2, "text/html", MimeTypeUtil.ContentType.DEFAULT_CHARSET, null);
        AppMethodBeat.o(135262);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final String getUserAgentString() {
        return this.mUserAgent;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getWebScrollX() {
        AppMethodBeat.i(135263);
        int scrollX = getScrollX();
        AppMethodBeat.o(135263);
        return scrollX;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final int getWebScrollY() {
        AppMethodBeat.i(135264);
        int scrollY = getScrollY();
        AppMethodBeat.o(135264);
        return scrollY;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setAppBrandInfo(Map<String, String> map) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.o, android.webkit.WebView
    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(135265);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.aw.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(135251);
                aw.a(aw.this, str, valueCallback);
                AppMethodBeat.o(135251);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r0.run();
            AppMethodBeat.o(135265);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(135265);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(135266);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(135266);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, String str2, int i2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(135267);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(135267);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void setJsExceptionHandler(h hVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.plugin.appbrand.page.bb
    public final void destroy() {
        AppMethodBeat.i(135268);
        super.destroy();
        AppMethodBeat.o(135268);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final <T extends j> T R(Class<T> cls) {
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void onForeground() {
        AppMethodBeat.i(135269);
        super.onResume();
        AppMethodBeat.o(135269);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void onBackground() {
        AppMethodBeat.i(135270);
        super.onPause();
        AppMethodBeat.o(135270);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setOnScrollChangedListener(as asVar) {
        this.ntc = asVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setWebViewLayoutListener(ap apVar) {
        this.ntd = apVar;
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(135271);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.ntd != null) {
            this.ntd.c(z, i2, i3, i4, i5);
        }
        AppMethodBeat.o(135271);
    }

    /* access modifiers changed from: protected */
    public final void onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(135272);
        super.onScrollChanged(i2, i3, i4, i5);
        if (this.ntc != null) {
            this.ntc.onScrollChanged(i2, i3, i4, i5, this);
        }
        AppMethodBeat.o(135272);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setOnTrimListener(aq aqVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void MM() {
        AppMethodBeat.i(135273);
        super.scrollTo(getScrollX(), 0);
        AppMethodBeat.o(135273);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void s(int i2, long j2) {
        AppMethodBeat.i(135274);
        if (this.nsi != null) {
            this.nsi.cancel();
            this.nsi = null;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getContentView().getScrollY(), i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.page.aw.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(135252);
                aw.this.getContentView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AppMethodBeat.o(135252);
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.start();
        this.nsi = ofInt;
        AppMethodBeat.o(135274);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setFullscreenImpl(d dVar) {
        this.nte = dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final d getFullscreenImpl() {
        return this.nte;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MN() {
        AppMethodBeat.i(135275);
        if (getWebScrollY() == 0) {
            AppMethodBeat.o(135275);
            return true;
        }
        AppMethodBeat.o(135275);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setXWebKeyboardImpl(au auVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MO() {
        return false;
    }
}
