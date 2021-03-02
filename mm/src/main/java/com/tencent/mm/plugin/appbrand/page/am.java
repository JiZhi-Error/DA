package com.tencent.mm.plugin.appbrand.page;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.luggage.sdk.g.c;
import com.tencent.luggage.xweb_ext.extendplugin.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.config.j;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.report.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.r;
import com.tencent.xweb.x;
import com.tencent.xweb.z;
import java.net.URL;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkFeature;
import org.xwalk.core.XWalkPreferences;

@JgClassChecked(author = 10000, fComment = "checked", lastDate = "20180919", reviewer = 10000, vComment = {EType.HTTPSCHECK})
@SuppressLint({"ViewConstructor"})
public final class am extends MMWebView implements c.a, b, e, bc {
    private au cKd;
    private boolean mDestroyed;
    private ab mGX;
    private com.tencent.xweb.x5.export.external.extension.proxy.a mGY;
    private String mUserAgent;
    private d nqS;
    private as nse;
    private ap nsf;
    private aq nsg;
    private an nsh;
    private Animator nsi;
    private boolean nsj;
    private com.tencent.luggage.xweb_ext.extendplugin.b.c nsk;
    private final LinkedList<a> nsl;
    private ac nsm;
    private x nsn;
    private Boolean nso;

    static /* synthetic */ void a(am amVar, String str, ValueCallback valueCallback) {
        AppMethodBeat.i(227348);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(227348);
    }

    static /* synthetic */ z c(am amVar) {
        AppMethodBeat.i(227347);
        z settings = super.getSettings();
        AppMethodBeat.o(227347);
        return settings;
    }

    private am(Context context) {
        super(new MutableContextWrapper(context));
        AppMethodBeat.i(47950);
        this.nsf = null;
        this.nsj = false;
        this.mDestroyed = false;
        this.nsl = new LinkedList<>();
        this.nsm = new ac() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass8 */

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str, Bitmap bitmap) {
                AppMethodBeat.i(227324);
                an unused = am.this.nsh;
                AppMethodBeat.o(227324);
            }

            @Override // com.tencent.xweb.ac
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(227325);
                am.this.nsh.cW(str);
                AppMethodBeat.o(227325);
            }

            @Override // com.tencent.xweb.ac
            public final boolean a(WebView webView, String str) {
                AppMethodBeat.i(227326);
                Log.i("MicroMsg.AppBrandWebView", "shouldOverrideUrlLoading, url = %s", str);
                AppMethodBeat.o(227326);
                return true;
            }

            @Override // com.tencent.xweb.ac
            public final void a(WebView webView, r rVar, SslError sslError) {
                AppMethodBeat.i(227327);
                if (sslError.getPrimaryError() != 3) {
                    rVar.cancel();
                    AppMethodBeat.o(227327);
                } else if (am.this.nsh.a(sslError.getCertificate())) {
                    rVar.proceed();
                    AppMethodBeat.o(227327);
                } else {
                    rVar.cancel();
                    AppMethodBeat.o(227327);
                }
            }

            @Override // com.tencent.xweb.ac
            public final WebResourceResponse c(WebView webView, String str) {
                AppMethodBeat.i(227328);
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(227328);
                    return null;
                }
                WebResourceResponse a2 = am.a(am.this, str);
                AppMethodBeat.o(227328);
                return a2;
            }

            @Override // com.tencent.xweb.ac
            public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
                AppMethodBeat.i(227329);
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || Util.isNullOrNil(webResourceRequest.getUrl().toString())) {
                    AppMethodBeat.o(227329);
                    return null;
                }
                WebResourceResponse a2 = am.a(am.this, webResourceRequest.getUrl().toString());
                AppMethodBeat.o(227329);
                return a2;
            }

            @Override // com.tencent.xweb.ac
            public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
                AppMethodBeat.i(227330);
                if (webResourceRequest == null || webResourceRequest.getUrl() == null || Util.isNullOrNil(webResourceRequest.getUrl().toString())) {
                    AppMethodBeat.o(227330);
                    return null;
                }
                WebResourceResponse a2 = am.a(am.this, webResourceRequest.getUrl().toString());
                AppMethodBeat.o(227330);
                return a2;
            }

            @Override // com.tencent.xweb.ac
            public final void a(WebView webView, int i2, String str, String str2) {
                AppMethodBeat.i(227331);
                Log.e("MicroMsg.AppBrandWebView", "onReceivedError, errCode = %d, description = %s, failingUrl = %s", Integer.valueOf(i2), str, str2);
                AppMethodBeat.o(227331);
            }

            @Override // com.tencent.xweb.ac
            public final void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                AppMethodBeat.i(227332);
                Uri url = webResourceRequest.getUrl();
                Log.e("MicroMsg.AppBrandWebView", "onReceivedHttpError, WebResourceRequest url = %s, ErrWebResourceResponse mimeType = %s, status = %d", url == null ? BuildConfig.COMMAND : url.toString(), webResourceResponse.mMimeType, Integer.valueOf(webResourceResponse.mStatusCode));
                AppMethodBeat.o(227332);
            }
        };
        this.nsn = new x() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass9 */

            @Override // com.tencent.xweb.x
            public final boolean a(View view, final WebChromeClient.CustomViewCallback customViewCallback) {
                AppMethodBeat.i(227334);
                Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onEnterFullscreen");
                if (am.this.isXWalkKernel()) {
                    if (am.this.nqS != null) {
                        am.this.nqS.a(new WebChromeClient.CustomViewCallback() {
                            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass9.AnonymousClass1 */

                            public final void onCustomViewHidden() {
                                AppMethodBeat.i(227333);
                                if (am.this.hasEnteredFullscreen()) {
                                    Log.i("MicroMsg.AppBrandWebView", "WebChromeClient leaveFullscreen");
                                    am.this.leaveFullscreen();
                                }
                                if (customViewCallback != null) {
                                    customViewCallback.onCustomViewHidden();
                                }
                                AppMethodBeat.o(227333);
                            }
                        });
                    }
                    AppMethodBeat.o(227334);
                    return true;
                }
                boolean a2 = super.a(view, customViewCallback);
                AppMethodBeat.o(227334);
                return a2;
            }

            @Override // com.tencent.xweb.x
            public final boolean bLA() {
                AppMethodBeat.i(227335);
                Log.w("MicroMsg.AppBrandWebView", "WebChromeClient onExitFullscreen");
                if (am.this.isXWalkKernel()) {
                    AppMethodBeat.o(227335);
                    return true;
                }
                boolean bLA = super.bLA();
                AppMethodBeat.o(227335);
                return bLA;
            }

            @Override // com.tencent.xweb.x
            public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
                AppMethodBeat.i(227336);
                try {
                    if (am.this.nqS != null) {
                        am.this.nqS.N(view, 90);
                        am.this.nqS.a(customViewCallback);
                    }
                    AppMethodBeat.o(227336);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandWebView", "onShowCustomView error " + e2.getMessage());
                    AppMethodBeat.o(227336);
                }
            }

            @Override // com.tencent.xweb.x
            public final void onHideCustomView() {
                AppMethodBeat.i(227337);
                try {
                    if (am.this.nqS != null) {
                        am.this.nqS.btC();
                    }
                    AppMethodBeat.o(227337);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandWebView", "onHideCustomView error " + e2.getMessage());
                    AppMethodBeat.o(227337);
                }
            }

            @Override // com.tencent.xweb.x
            public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                AppMethodBeat.i(227338);
                if (!(consoleMessage == null || am.this.nsh == null)) {
                    an anVar = am.this.nsh;
                    if (anVar.cwK != null) {
                        com.tencent.luggage.sdk.g.e.a(consoleMessage, "Luggage.AppBrandWebViewClient" + String.format(Locale.ENGLISH, ":page[%s %s]", anVar.cwK.getAppId(), anVar.cwK.lBI));
                    }
                }
                boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
                AppMethodBeat.o(227338);
                return onConsoleMessage;
            }
        };
        this.mGX = new ab() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass10 */

            @Override // com.tencent.xweb.ab
            public final boolean B(MotionEvent motionEvent) {
                AppMethodBeat.i(227339);
                boolean am = am.this.am(motionEvent);
                AppMethodBeat.o(227339);
                return am;
            }

            @Override // com.tencent.xweb.ab
            public final boolean b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
                AppMethodBeat.i(227340);
                boolean c2 = am.this.c(i2, i3, i4, i5, i6, i7, i8, i9, z);
                AppMethodBeat.o(227340);
                return c2;
            }

            @Override // com.tencent.xweb.ab
            public final void bLv() {
                AppMethodBeat.i(227341);
                am.this.gYY();
                AppMethodBeat.o(227341);
            }

            @Override // com.tencent.xweb.ab
            @TargetApi(9)
            public final void d(int i2, int i3, boolean z, boolean z2) {
                AppMethodBeat.i(227342);
                am.this.h(i2, i3, z, z2);
                AppMethodBeat.o(227342);
            }

            @Override // com.tencent.xweb.ab
            public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
                AppMethodBeat.i(47943);
                if (am.this.nse != null) {
                    am.this.nse.onScrollChanged(i2, i3, i4, i5, view);
                }
                an unused = am.this.nsh;
                am.this.R(i2, i3, i4, i5);
                AppMethodBeat.o(47943);
            }

            @Override // com.tencent.xweb.ab
            public final boolean C(MotionEvent motionEvent) {
                AppMethodBeat.i(227343);
                boolean an = am.this.an(motionEvent);
                AppMethodBeat.o(227343);
                return an;
            }

            @Override // com.tencent.xweb.ab
            public final boolean D(MotionEvent motionEvent) {
                AppMethodBeat.i(227344);
                boolean ao = am.this.ao(motionEvent);
                AppMethodBeat.o(227344);
                return ao;
            }
        };
        this.mGY = new com.tencent.xweb.x5.export.external.extension.proxy.a() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass2 */

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(227311);
                boolean B = am.this.mGX.B(motionEvent);
                AppMethodBeat.o(227311);
                return B;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(227312);
                boolean D = am.this.mGX.D(motionEvent);
                AppMethodBeat.o(227312);
                return D;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
                AppMethodBeat.i(227313);
                boolean C = am.this.mGX.C(motionEvent);
                AppMethodBeat.o(227313);
                return C;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
                AppMethodBeat.i(227314);
                boolean b2 = am.this.mGX.b(i2, i3, i4, i5, i6, i7, i8, i9, z);
                AppMethodBeat.o(227314);
                return b2;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
                AppMethodBeat.i(227315);
                am.this.mGX.onScrollChanged(i2, i3, i4, i5, view);
                AppMethodBeat.o(227315);
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
                AppMethodBeat.i(227316);
                am.this.mGX.d(i2, i3, z, z2);
                AppMethodBeat.o(227316);
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final void computeScroll(View view) {
                AppMethodBeat.i(227317);
                am.this.mGX.bLv();
                AppMethodBeat.o(227317);
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final boolean onShowLongClickPopupMenu() {
                AppMethodBeat.i(227318);
                if (WebView.getUsingTbsCoreVersion(am.this.getContext()) >= 43011) {
                    AppMethodBeat.o(227318);
                    return false;
                }
                AppMethodBeat.o(227318);
                return true;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final void invalidate() {
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final Object onMiscCallBack(String str, Bundle bundle) {
                AppMethodBeat.i(227319);
                if (Util.isNullOrNil(str) || bundle == null) {
                    AppMethodBeat.o(227319);
                    return null;
                }
                Log.i("MicroMsg.AppBrandWebView", "onMiscCallBack method = %s", str);
                if ("onJavascriptCloseWindow".equals(str)) {
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(227319);
                    return bool;
                }
                AppMethodBeat.o(227319);
                return null;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final boolean shouldDiscardCurrentPage() {
                boolean z;
                AppMethodBeat.i(227320);
                if (am.this.nsg == null) {
                    AppMethodBeat.o(227320);
                    return false;
                }
                boolean bSa = am.this.nsg.bSa();
                Object[] objArr = new Object[1];
                if (!bSa || am.this.nsj) {
                    z = false;
                } else {
                    z = true;
                }
                objArr[0] = Boolean.valueOf(z);
                Log.i("MicroMsg.AppBrandWebView", "shouldTrimCurrentPage: %b", objArr);
                if (!bSa || am.this.nsj) {
                    AppMethodBeat.o(227320);
                    return false;
                }
                AppMethodBeat.o(227320);
                return true;
            }

            @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
            public final void hasDiscardCurrentPage(boolean z) {
                AppMethodBeat.i(227321);
                am.this.nsj = z;
                if (z && (am.this.nsg instanceof ar)) {
                    aq unused = am.this.nsg;
                }
                AppMethodBeat.o(227321);
            }
        };
        this.nso = null;
        this.gKM = true;
        this.nsh = null;
        j.Xb(getSettings().getUserAgentString());
        getSettings().hsU();
        getSettings().setJavaScriptEnabled(true);
        getSettings().setMediaPlaybackRequiresUserGesture(false);
        getSettings().hsW();
        getSettings().setUserAgentString(s.aa(getContext(), getSettings().getUserAgentString()));
        this.mUserAgent = getSettings().getUserAgentString();
        getSettings().setTextZoom(100);
        getView().setHorizontalScrollBarEnabled(false);
        getView().setVerticalScrollBarEnabled(false);
        setWebViewClient(this.nsm);
        setWebChromeClient(this.nsn);
        setWebViewCallbackClient(this.mGX);
        setWebViewClientExtension(this.mGY);
        getIsX5Kernel();
        getSettings().setUsingForAppBrand(1);
        Log.i("MicroMsg.AppBrandWebView", "<init> hash:%d, type:%s", Integer.valueOf(hashCode()), getCurWebType());
        this.nsk = com.tencent.luggage.xweb_ext.extendplugin.d.a(this, com.tencent.luggage.xweb_ext.extendplugin.b.b.QL(), new com.tencent.mm.plugin.appbrand.xweb_ext.a(), new au() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.appbrand.page.au
            public final h bRH() {
                AppMethodBeat.i(47914);
                if (am.this.cKd != null) {
                    h bRH = am.this.cKd.bRH();
                    AppMethodBeat.o(47914);
                    return bRH;
                }
                AppMethodBeat.o(47914);
                return null;
            }

            @Override // com.tencent.mm.plugin.appbrand.page.au
            public final f bxr() {
                AppMethodBeat.i(47915);
                if (am.this.cKd != null) {
                    f bxr = am.this.cKd.bxr();
                    AppMethodBeat.o(47915);
                    return bxr;
                }
                AppMethodBeat.o(47915);
                return null;
            }
        });
        setBackgroundColor(0);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass1 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(227310);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/appbrand/page/AppBrandWebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(227310);
                return false;
            }
        });
        setDownloadListener(new DownloadListener() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass3 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                AppMethodBeat.i(47913);
                Log.i("MicroMsg.AppBrandWebView", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", str, str4, str2);
                AppMethodBeat.o(47913);
            }
        });
        AppMethodBeat.o(47950);
    }

    public am(Context context, byte b2) {
        this(context);
    }

    @Override // com.tencent.luggage.sdk.g.c.a
    public final String Pb() {
        AppMethodBeat.i(47951);
        String format = String.format(Locale.ENGLISH, "AppBrandWebView(%s)@%d", o.bUx(), Integer.valueOf(hashCode()));
        AppMethodBeat.o(47951);
        return format;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bc
    public final void setAppBrandWebViewClient(an anVar) {
        this.nsh = anVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setXWebKeyboardImpl(au auVar) {
        this.cKd = auVar;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.b
    public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy() {
        return this.nsk;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final View getWrapperView() {
        return this;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final View getContentView() {
        AppMethodBeat.i(47953);
        View view = super.getView();
        AppMethodBeat.o(47953);
        return view;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(47954);
        if (isXWalkKernel()) {
            drawCanvas(canvas);
        } else {
            draw(canvas);
        }
        AppMethodBeat.o(47954);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void i(Runnable runnable) {
        AppMethodBeat.i(47955);
        if (runnable == null) {
            AppMethodBeat.o(47955);
        } else if (this.mDestroyed) {
            Log.w("MicroMsg.AppBrandWebView", "postOnReRendered webview destroyed, stack=%s", android.util.Log.getStackTraceString(new Throwable()));
            AppMethodBeat.o(47955);
        } else {
            a aVar = new a(this, runnable, (byte) 0);
            if (isXWalkKernel()) {
                postDelayed(aVar, 200);
                AppMethodBeat.o(47955);
                return;
            }
            postOnAnimation(aVar);
            AppMethodBeat.o(47955);
        }
    }

    /* access modifiers changed from: package-private */
    public final class a implements Runnable {
        private final Runnable mRunnable;

        /* synthetic */ a(am amVar, Runnable runnable, byte b2) {
            this(runnable);
        }

        private a(Runnable runnable) {
            AppMethodBeat.i(175039);
            this.mRunnable = runnable;
            am.this.nsl.add(this);
            AppMethodBeat.o(175039);
        }

        public final void run() {
            AppMethodBeat.i(175040);
            am.this.nsl.remove(this);
            this.mRunnable.run();
            AppMethodBeat.o(175040);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void x(String str, String str2) {
        AppMethodBeat.i(47956);
        this.nsj = false;
        super.loadDataWithBaseURL(str, str2, "text/html", MimeTypeUtil.ContentType.DEFAULT_CHARSET, null);
        AppMethodBeat.o(47956);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setAppBrandInfo(final Map<String, String> map) {
        AppMethodBeat.i(227345);
        AnonymousClass5 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(47916);
                am.c(am.this).setAppBrandInfo(map);
                AppMethodBeat.o(47916);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r0.run();
            AppMethodBeat.o(227345);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(227345);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.mm.plugin.appbrand.m.o, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView
    public final void evaluateJavascript(final String str, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(47957);
        AnonymousClass6 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(227322);
                am.a(am.this, str, valueCallback);
                AppMethodBeat.o(227322);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            r0.run();
            AppMethodBeat.o(47957);
            return;
        }
        MMHandlerThread.postToMainThread(r0);
        AppMethodBeat.o(47957);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.mm.ui.widget.MMWebView
    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(47958);
        evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(47958);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void a(URL url, String str, String str2, int i2, String str3, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(47959);
        evaluateJavascript(str3, valueCallback);
        AppMethodBeat.o(47959);
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final void setJsExceptionHandler(com.tencent.mm.plugin.appbrand.m.h hVar) {
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i
    public final <T extends com.tencent.mm.plugin.appbrand.m.j> T R(Class<T> cls) {
        AppMethodBeat.i(47960);
        if (cls == e.class) {
            if (!com.tencent.mm.plugin.appbrand.xweb_ext.c.cdA()) {
                AppMethodBeat.o(47960);
                return null;
            } else if (supportFeature(XWalkFeature.INTERFACE_SHOW_HIDE)) {
                T cast = cls.cast(this);
                AppMethodBeat.o(47960);
                return cast;
            } else {
                AppMethodBeat.o(47960);
                return null;
            }
        } else if (cls.isInstance(this)) {
            T cast2 = cls.cast(this);
            AppMethodBeat.o(47960);
            return cast2;
        } else {
            AppMethodBeat.o(47960);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.e
    public final void bLp() {
        AppMethodBeat.i(47961);
        Log.i("MicroMsg.AppBrandWebView", "restoreRendering hash[%d]", Integer.valueOf(hashCode()));
        onShow();
        AppMethodBeat.o(47961);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.e
    public final void bLq() {
        AppMethodBeat.i(47962);
        Log.i("MicroMsg.AppBrandWebView", "pauseRendering hash[%d]", Integer.valueOf(hashCode()));
        onHide();
        AppMethodBeat.o(47962);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final String getUserAgentString() {
        return this.mUserAgent;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(47963);
        try {
            super.onAttachedToWindow();
            AppMethodBeat.o(47963);
        } catch (SecurityException e2) {
            AppMethodBeat.o(47963);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.m.i, com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView, com.tencent.mm.ui.widget.MMWebView, com.tencent.mm.plugin.appbrand.page.bb
    public final void destroy() {
        AppMethodBeat.i(47964);
        if (this.mDestroyed) {
            AppMethodBeat.o(47964);
            return;
        }
        Log.i("MicroMsg.AppBrandWebView", "fireAllPendingReRenderedTasks size=%d", Integer.valueOf(this.nsl.size()));
        while (!this.nsl.isEmpty()) {
            this.nsl.pollFirst().run();
        }
        try {
            super.destroy();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrandWebView", e2, "[CAUGHT CRASH]", new Object[0]);
        }
        if (this.nsi != null) {
            this.nsi.cancel();
            this.nsi = null;
        }
        if (this.nqS != null) {
            this.nqS.a((WebChromeClient.CustomViewCallback) null);
            this.nqS.release();
        }
        this.nqS = null;
        try {
            aG(getContext().getApplicationContext());
        } catch (Exception e3) {
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        this.mDestroyed = true;
        Log.i("MicroMsg.AppBrandWebView", "destroyed hash[%d]", Integer.valueOf(hashCode()));
        AppMethodBeat.o(47964);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void onForeground() {
        AppMethodBeat.i(47965);
        onResume();
        AppMethodBeat.o(47965);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void onBackground() {
        AppMethodBeat.i(47966);
        onPause();
        AppMethodBeat.o(47966);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setOnScrollChangedListener(as asVar) {
        this.nse = asVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setWebViewLayoutListener(ap apVar) {
        this.nsf = apVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setOnTrimListener(aq aqVar) {
        this.nsg = aqVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void MM() {
        AppMethodBeat.i(47967);
        getView().scrollTo(getWebScrollX(), 0);
        AppMethodBeat.o(47967);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void s(int i2, long j2) {
        AppMethodBeat.i(47968);
        if (this.nsi != null) {
            this.nsi.cancel();
            this.nsi = null;
        }
        if (super.supportFeature(2005)) {
            super.smoothScroll(getWebScrollX(), i2, j2);
            AppMethodBeat.o(47968);
            return;
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(getWebScrollY(), i2);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.appbrand.page.am.AnonymousClass7 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(227323);
                am.this.getView().setScrollY(((Integer) valueAnimator.getAnimatedValue()).intValue());
                AppMethodBeat.o(227323);
            }
        });
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(j2);
        ofInt.start();
        this.nsi = ofInt;
        AppMethodBeat.o(47968);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final void setFullscreenImpl(d dVar) {
        this.nqS = dVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final d getFullscreenImpl() {
        return this.nqS;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MN() {
        AppMethodBeat.i(47969);
        if (isXWalkKernel() && XWalkEnvironment.getAvailableVersion() >= 472) {
            boolean isOverScrollStart = isOverScrollStart();
            AppMethodBeat.o(47969);
            return isOverScrollStart;
        } else if (getWebScrollY() == 0) {
            AppMethodBeat.o(47969);
            return true;
        } else {
            AppMethodBeat.o(47969);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(47970);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.nsf != null) {
            this.nsf.c(z, i2, i3, i4, i5);
        }
        AppMethodBeat.o(47970);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bb
    public final boolean MO() {
        AppMethodBeat.i(227346);
        if (this.nso != null) {
            boolean booleanValue = this.nso.booleanValue();
            AppMethodBeat.o(227346);
            return booleanValue;
        }
        try {
            Boolean valueOf = Boolean.valueOf(XWalkPreferences.getBooleanValue(XWalkPreferences.REMOTE_DEBUGGING));
            this.nso = valueOf;
            boolean booleanValue2 = valueOf.booleanValue();
            AppMethodBeat.o(227346);
            return booleanValue2;
        } catch (Throwable th) {
            AppMethodBeat.o(227346);
            return false;
        }
    }

    static /* synthetic */ WebResourceResponse a(am amVar, String str) {
        AppMethodBeat.i(227349);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(227349);
            return null;
        }
        android.webkit.WebResourceResponse adS = amVar.nsh.adS(str);
        if (adS == null) {
            AppMethodBeat.o(227349);
            return null;
        } else if (Build.VERSION.SDK_INT >= 21) {
            WebResourceResponse webResourceResponse = new WebResourceResponse(adS.getMimeType(), adS.getEncoding(), adS.getStatusCode(), adS.getReasonPhrase(), adS.getResponseHeaders(), adS.getData());
            AppMethodBeat.o(227349);
            return webResourceResponse;
        } else {
            WebResourceResponse webResourceResponse2 = new WebResourceResponse(adS.getMimeType(), adS.getEncoding(), adS.getData());
            AppMethodBeat.o(227349);
            return webResourceResponse2;
        }
    }
}
