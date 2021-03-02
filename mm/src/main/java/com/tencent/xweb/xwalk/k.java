package com.tencent.xweb.xwalk;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ab;
import com.tencent.xweb.ac;
import com.tencent.xweb.ad;
import com.tencent.xweb.ae;
import com.tencent.xweb.extension.video.d;
import com.tencent.xweb.extension.video.e;
import com.tencent.xweb.i;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.g;
import com.tencent.xweb.internal.h;
import com.tencent.xweb.q;
import com.tencent.xweb.sys.c;
import com.tencent.xweb.u;
import com.tencent.xweb.v;
import com.tencent.xweb.x;
import com.tencent.xweb.xwalk.g;
import com.tencent.xweb.xwalk.updater.f;
import com.tencent.xweb.z;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.CustomViewCallback;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;
import org.xwalk.core.XWalkGetImageBitmapToFileFinishedCallback;
import org.xwalk.core.XWalkHitTestResult;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkJavascriptResult;
import org.xwalk.core.XWalkLibraryLoader;
import org.xwalk.core.XWalkLogMessageListener;
import org.xwalk.core.XWalkNavigationHistory;
import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkProxyWebViewClientExtension;
import org.xwalk.core.XWalkUIClient;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;
import org.xwalk.core.resource.XWalkContextWrapper;

public final class k implements IWebView, g {
    static int SHp = 0;
    private final int IJt = 0;
    private final int IJu = 1;
    private final int IJv = 2;
    WebView SEl;
    long SEr = 0;
    private com.tencent.xweb.extension.video.b SEs;
    m SGX;
    o SGY;
    XWalkView SGZ;
    l SHf;
    AbsoluteLayout SHg;
    h SHh;
    boolean SHi = false;
    private String SHj = null;
    private XWalkProxyWebViewClientExtension SHk = new XWalkProxyWebViewClientExtension() {
        /* class com.tencent.xweb.xwalk.k.AnonymousClass1 */

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.i(154296);
            if (k.this.SHl != null) {
                Object onMiscCallBack = k.this.SHl.onMiscCallBack(str, bundle);
                AppMethodBeat.o(154296);
                return onMiscCallBack;
            }
            AppMethodBeat.o(154296);
            return null;
        }
    };
    private com.tencent.xweb.x5.export.external.extension.proxy.a SHl = new com.tencent.xweb.x5.export.external.extension.proxy.a();
    private ae SHm = null;
    private boolean SHn = false;
    private boolean SHo = false;
    private boolean SHq = false;
    private Handler hnq;
    int mApkVersion = XWalkEnvironment.getAvailableVersion();
    ab mGX;
    ac nsm = new ac();
    x nsn = new x();
    private int type = 0;

    static /* synthetic */ void i(k kVar) {
        AppMethodBeat.i(207306);
        kVar.fZn();
        AppMethodBeat.o(207306);
    }

    class a extends XWalkView {
        public a(Context context) {
            super(context);
        }

        @Override // org.xwalk.core.XWalkView
        public final void onScrollChangedDelegate(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(154353);
            super.onScrollChangedDelegate(i2, i3, i4, i5);
            if (k.this.SEl != null) {
                k.this.SEl.onWebViewScrollChanged(i2, i3, i4, i5);
            }
            AppMethodBeat.o(154353);
        }
    }

    public static synchronized boolean in(Context context) {
        boolean isXWalkReady;
        synchronized (k.class) {
            AppMethodBeat.i(154356);
            f.lK(context);
            isXWalkReady = f.isXWalkReady();
            AppMethodBeat.o(154356);
        }
        return isXWalkReady;
    }

    private void huV() {
        AppMethodBeat.i(154357);
        if (this.SGX != null) {
            AppMethodBeat.o(154357);
            return;
        }
        this.SGX = new m(this.SGZ) {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass3 */
            private boolean SBX = false;
            String SHt = null;
            private boolean SHu = false;
            private boolean SHv = false;

            @Override // org.xwalk.core.XWalkUIClient
            public final void onPageLoadStarted(XWalkView xWalkView, String str) {
                AppMethodBeat.i(154297);
                Log.i("XWWebView", "onPageLoadStarted: url = ".concat(String.valueOf(str)));
                k.this.nsm.b(k.this.SEl, str, k.this.SGZ.getFavicon());
                h.htF().htA();
                this.SHt = null;
                if (!(k.this.SHj == null || str == null || str.equals(k.this.SHj) || com.tencent.xweb.util.h.bsI(str) == com.tencent.xweb.util.h.bsI(k.this.SHj))) {
                    if (com.tencent.xweb.util.h.bsI(k.this.SHj) == 1 && com.tencent.xweb.util.h.bsI(str) == 2) {
                        k.this.type = 1;
                    } else if (com.tencent.xweb.util.h.bsI(k.this.SHj) == 2 && com.tencent.xweb.util.h.bsI(str) == 1) {
                        k.this.type = 2;
                    }
                }
                k.this.SHj = str;
                k.this.SEr = System.currentTimeMillis();
                if (str == null) {
                    str = "";
                }
                com.tencent.xweb.util.h.hP(str, k.this.type);
                d.a(k.this.SEl);
                if (k.this.SEs != null) {
                    k.this.SEs.bk(true, k.this.SEl.getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS);
                }
                if (k.this.SHn) {
                    Log.d("XWWebView", "onTranslateStart setTranslateMode true ");
                    k.f(k.this);
                    k.this.SGZ.setTranslateMode(true);
                }
                AppMethodBeat.o(154297);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onPageCommitVisible(XWalkView xWalkView, String str) {
                AppMethodBeat.i(154298);
                k.this.nsm.e(k.this.SEl, str);
                AppMethodBeat.o(154298);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onPageLoadStopped(XWalkView xWalkView, String str, XWalkUIClient.LoadStatus loadStatus) {
                AppMethodBeat.i(154299);
                if (this.SHt == null || !this.SHt.equals(str)) {
                    if (k.this.SEs != null) {
                        k.this.SEs.bk(false, k.this.SEl.getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS);
                    }
                    this.SHt = str;
                    Log.i("XWWebView", "onPageFinished: url = " + str + " status = " + loadStatus);
                    k.this.nsm.b(k.this.SEl, str);
                    if (loadStatus != XWalkUIClient.LoadStatus.FAILED) {
                        h.htF().htB();
                    }
                    com.tencent.xweb.util.h.u(str, System.currentTimeMillis() - k.this.SEr, k.this.type);
                    k.this.SEr = System.currentTimeMillis();
                    AppMethodBeat.o(154299);
                    return;
                }
                Log.i("XWWebView", "abandoned onPageFinished: url = " + str + " status = " + loadStatus);
                AppMethodBeat.o(154299);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onReceivedTitle(XWalkView xWalkView, String str) {
                AppMethodBeat.i(154300);
                Log.i("XWWebView", "onReceivedTitle: ".concat(String.valueOf(str)));
                super.onReceivedTitle(xWalkView, str);
                k.this.nsn.d(null, str);
                if (k.this.SEs != null) {
                    k.this.SEs.bk(true, k.this.SEl.getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS);
                }
                AppMethodBeat.o(154300);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onShowCustomView(View view, CustomViewCallback customViewCallback) {
                AppMethodBeat.i(154301);
                Log.i("XWWebView", "onShowCustomView:".concat(String.valueOf(view)));
                if (!this.SBX) {
                    this.SBX = true;
                    this.SHu = k.this.SGZ.getSettings().getMediaPlaybackRequiresUserGesture();
                    this.SHv = k.this.SGZ.getSettings().getVideoPlaybackRequiresUserGesture();
                    Log.i("XWWebView", "onShowCustomView: mIsMediaPlaybackRequiresUserGesture" + this.SHu + ", mIsVideoPlaybackRequiresUserGesture:" + this.SHv);
                    k.this.SGZ.getSettings().setMediaPlaybackRequiresUserGesture(false);
                    k.this.SGZ.getSettings().setVideoPlaybackRequiresUserGesture(false);
                }
                boolean a2 = k.this.nsn.a(view, new g.a(customViewCallback));
                com.tencent.xweb.util.h.hud();
                if (a2) {
                    Log.i("XWWebView", "onShowCustomView isHandled:true");
                    AppMethodBeat.o(154301);
                    return;
                }
                k.this.SHg.setVisibility(4);
                if (k.this.SEs != null) {
                    k.this.SEs.onShowCustomView(view, new g.a(customViewCallback));
                }
                AppMethodBeat.o(154301);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onHideCustomView() {
                AppMethodBeat.i(154302);
                Log.i("XWWebView", "onHideCustomView");
                if (this.SBX) {
                    this.SBX = false;
                    Log.i("XWWebView", "onHideCustomView: mIsMediaPlaybackRequiresUserGesture" + this.SHu + ", mIsVideoPlaybackRequiresUserGesture:" + this.SHv);
                    k.this.SGZ.getSettings().setMediaPlaybackRequiresUserGesture(this.SHu);
                    k.this.SGZ.getSettings().setVideoPlaybackRequiresUserGesture(this.SHv);
                }
                if (k.this.nsn.bLA()) {
                    Log.i("XWWebView", "onHideCustomView isHandled:true");
                    AppMethodBeat.o(154302);
                    return;
                }
                k.this.SHg.setVisibility(0);
                if (k.this.SEs != null) {
                    k.this.SEs.onHideCustomView();
                }
                AppMethodBeat.o(154302);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onExitFullscreenVideo(Bitmap bitmap) {
                AppMethodBeat.i(154303);
                Log.i("XWWebView", "onExitFullscreenVideo");
                k.this.nsn.onExitFullscreenVideo(bitmap);
                AppMethodBeat.o(154303);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final View getVideoLoadingProgressView() {
                AppMethodBeat.i(154304);
                Log.i("XWWebView", "getVideoLoadingProgressView");
                View inflate = LayoutInflater.from(k.this.SEl.getContext()).inflate(R.layout.c5l, (ViewGroup) null);
                AppMethodBeat.o(154304);
                return inflate;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onSelectInfoChanged(XWalkView xWalkView, long j2, String str, String str2, String str3) {
                AppMethodBeat.i(154305);
                if (!isSearchable()) {
                    AppMethodBeat.o(154305);
                    return false;
                }
                Bundle bundle = new Bundle();
                bundle.putString("PickedWord", str);
                bundle.putString("PrefixText", str2);
                bundle.putString("SuffixText", str3);
                Object onMiscCallBack = k.this.SHl.onMiscCallBack("smartPickWord", bundle);
                if (onMiscCallBack instanceof Bundle) {
                    Bundle bundle2 = (Bundle) onMiscCallBack;
                    if (!(bundle2 == null || bundle2.getString("PickedWord") == null)) {
                        b c2 = b.c(str, bundle2.getString("PickedWord"), bundle2.getInt("PrefixOffset"), bundle2.getInt("SuffixOffset"), str2, str3);
                        Log.d("XWWebView", "onSelectInfoChanged " + c2.toString());
                        xWalkView.adjustSelectPosition(j2, bundle2.getString("PickedWord"), -c2.SHA, c2.SHC);
                    }
                    boolean b2 = k.this.nsn.b(j2, str, str2, str3);
                    AppMethodBeat.o(154305);
                    return b2;
                }
                AppMethodBeat.o(154305);
                return false;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onShowSos() {
                AppMethodBeat.i(154306);
                k.this.SHl.onMiscCallBack("onShowSos", new Bundle());
                AppMethodBeat.o(154306);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean isSearchable() {
                AppMethodBeat.i(154307);
                Object onMiscCallBack = k.this.SHl.onMiscCallBack("supportSmartPickWord", new Bundle());
                if (onMiscCallBack instanceof Boolean) {
                    boolean booleanValue = ((Boolean) onMiscCallBack).booleanValue();
                    AppMethodBeat.o(154307);
                    return booleanValue;
                }
                AppMethodBeat.o(154307);
                return false;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onSearchWord(XWalkView xWalkView, String str, String str2, String str3) {
                AppMethodBeat.i(154308);
                if (isSearchable()) {
                    Bundle bundle = new Bundle();
                    bundle.putString(SearchIntents.EXTRA_QUERY, str);
                    k.this.SHl.onMiscCallBack("jumpToSos", bundle);
                    boolean c2 = k.this.nsn.c(str, str2, str3, k.this.SGZ.getUrl(), k.this.SGZ.getRefererUrl(), k.this.SGZ.getTitle());
                    AppMethodBeat.o(154308);
                    return c2;
                }
                AppMethodBeat.o(154308);
                return false;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onJsAlert(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(154309);
                Log.i("XWWebView", "onJsAlert");
                boolean a2 = k.this.nsn.a(k.this.SEl, str, str2, new g.c(xWalkJavascriptResult));
                AppMethodBeat.o(154309);
                return a2;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onJsConfirm(XWalkView xWalkView, String str, String str2, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(154310);
                Log.i("XWWebView", "onJsConfirm");
                boolean b2 = k.this.nsn.b(k.this.SEl, str, str2, new g.c(xWalkJavascriptResult));
                AppMethodBeat.o(154310);
                return b2;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onJsPrompt(XWalkView xWalkView, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(154311);
                Log.i("XWWebView", "onJsPrompt");
                boolean a2 = k.this.nsn.a(k.this.SEl, str, str2, str3, new g.e(xWalkJavascriptResult));
                AppMethodBeat.o(154311);
                return a2;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onGeolocationPermissionsShowPrompt(String str, XWalkGeolocationPermissionsCallback xWalkGeolocationPermissionsCallback) {
                AppMethodBeat.i(154312);
                k.this.nsn.onGeolocationPermissionsShowPrompt(str, new g.b(xWalkGeolocationPermissionsCallback));
                AppMethodBeat.o(154312);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onGeolocationPermissionsHidePrompt() {
                AppMethodBeat.i(207291);
                k.this.nsn.onGeolocationPermissionsHidePrompt();
                AppMethodBeat.o(207291);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onConsoleMessage(XWalkView xWalkView, String str, int i2, String str2, XWalkUIClient.ConsoleMessageType consoleMessageType) {
                AppMethodBeat.i(154313);
                if (XWalkUIClient.ConsoleMessageType.ERROR == consoleMessageType && k.this.SHm != null && str.split(":").length == 2) {
                    ae unused = k.this.SHm;
                    com.tencent.xweb.util.h.hul();
                }
                x xVar = k.this.nsn;
                ConsoleMessage.MessageLevel messageLevel = ConsoleMessage.MessageLevel.DEBUG;
                switch (g.AnonymousClass1.SGQ[consoleMessageType.ordinal()]) {
                    case 1:
                        messageLevel = ConsoleMessage.MessageLevel.DEBUG;
                        break;
                    case 2:
                        messageLevel = ConsoleMessage.MessageLevel.ERROR;
                        break;
                    case 3:
                        messageLevel = ConsoleMessage.MessageLevel.LOG;
                        break;
                    case 4:
                        messageLevel = ConsoleMessage.MessageLevel.TIP;
                        break;
                    case 5:
                        messageLevel = ConsoleMessage.MessageLevel.WARNING;
                        break;
                }
                boolean onConsoleMessage = xVar.onConsoleMessage(new ConsoleMessage(str, str2, i2, messageLevel));
                AppMethodBeat.o(154313);
                return onConsoleMessage;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void openFileChooser(XWalkView xWalkView, ValueCallback<Uri> valueCallback, String str, String str2) {
                AppMethodBeat.i(154314);
                Log.i("XWWebView", "openFileChooser with three param");
                k.this.nsn.openFileChooser(valueCallback, str, str2);
                AppMethodBeat.o(154314);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onShowFileChooser(XWalkView xWalkView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                AppMethodBeat.i(207292);
                boolean a2 = k.this.nsn.a(k.this.SEl, valueCallback, new c.C2232c(fileChooserParams));
                AppMethodBeat.o(207292);
                return a2;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onCreateWindowRequested(XWalkView xWalkView, XWalkUIClient.InitiateBy initiateBy, ValueCallback<XWalkView> valueCallback) {
                AppMethodBeat.i(154315);
                Handler handler = k.this.hnq;
                WebView webView = k.this.SEl;
                webView.getClass();
                handler.obtainMessage(100, new WebView.d());
                if (k.this.nsn != null) {
                    XWalkUIClient.InitiateBy initiateBy2 = XWalkUIClient.InitiateBy.BY_USER_GESTURE;
                }
                AppMethodBeat.o(154315);
                return false;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onIconAvailable(XWalkView xWalkView, String str, Message message) {
                AppMethodBeat.i(154316);
                super.onIconAvailable(xWalkView, str, message);
                AppMethodBeat.o(154316);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onDidChangeThemeColor(XWalkView xWalkView, int i2) {
                AppMethodBeat.i(207293);
                k.this.nsn.b(k.this.SEl, i2);
                AppMethodBeat.o(207293);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onReceivedIcon(XWalkView xWalkView, String str, Bitmap bitmap) {
                AppMethodBeat.i(154317);
                super.onReceivedIcon(xWalkView, str, bitmap);
                AppMethodBeat.o(154317);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onRequestFocus(XWalkView xWalkView) {
                AppMethodBeat.i(154318);
                super.onRequestFocus(xWalkView);
                AppMethodBeat.o(154318);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onJavascriptCloseWindow(XWalkView xWalkView) {
                AppMethodBeat.i(154319);
                AppMethodBeat.o(154319);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onJavascriptModalDialog(XWalkView xWalkView, XWalkUIClient.JavascriptMessageType javascriptMessageType, String str, String str2, String str3, XWalkJavascriptResult xWalkJavascriptResult) {
                AppMethodBeat.i(154320);
                boolean onJavascriptModalDialog = super.onJavascriptModalDialog(xWalkView, javascriptMessageType, str, str2, str3, xWalkJavascriptResult);
                AppMethodBeat.o(154320);
                return onJavascriptModalDialog;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onFullscreenToggled(XWalkView xWalkView, boolean z) {
                AppMethodBeat.i(154321);
                super.onFullscreenToggled(xWalkView, z);
                AppMethodBeat.o(154321);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onScaleChanged(XWalkView xWalkView, float f2, float f3) {
                AppMethodBeat.i(154322);
                k.this.nsm.a(k.this.SEl, f2, f3);
                AppMethodBeat.o(154322);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean shouldOverrideKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                AppMethodBeat.i(154323);
                boolean shouldOverrideKeyEvent = super.shouldOverrideKeyEvent(xWalkView, keyEvent);
                AppMethodBeat.o(154323);
                return shouldOverrideKeyEvent;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onUnhandledKeyEvent(XWalkView xWalkView, KeyEvent keyEvent) {
                AppMethodBeat.i(154324);
                super.onUnhandledKeyEvent(xWalkView, keyEvent);
                AppMethodBeat.o(154324);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onShowCustomView(View view, int i2, CustomViewCallback customViewCallback) {
                AppMethodBeat.i(154325);
                super.onShowCustomView(view, i2, customViewCallback);
                AppMethodBeat.o(154325);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean shouldDiscardCurrentPage() {
                AppMethodBeat.i(154326);
                if (k.this.SHl != null) {
                    boolean shouldDiscardCurrentPage = k.this.SHl.shouldDiscardCurrentPage();
                    AppMethodBeat.o(154326);
                    return shouldDiscardCurrentPage;
                }
                boolean shouldDiscardCurrentPage2 = super.shouldDiscardCurrentPage();
                AppMethodBeat.o(154326);
                return shouldDiscardCurrentPage2;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final void onClearCurrentPage() {
                AppMethodBeat.i(154327);
                if (k.this.SHl != null) {
                    k.this.SHl.hasDiscardCurrentPage(true);
                }
                AppMethodBeat.o(154327);
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean onGetTranslateString(XWalkView xWalkView, Map<String, String> map) {
                AppMethodBeat.i(154328);
                Bundle bundle = new Bundle();
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                Log.d("XWWebView", "translate: onGetTranslateString orghashmap size = " + map.size() + " resultHashMap size = " + hashMap.size());
                if (hashMap.size() == 0 && k.this.SHn) {
                    Log.d("XWWebView", "translate: onTranslateFinish ");
                    k.i(k.this);
                }
                bundle.putSerializable("translate_hashmap", hashMap);
                Object onMiscCallBack = k.this.SHl.onMiscCallBack("onGetTranslateString", bundle);
                if (onMiscCallBack instanceof Boolean) {
                    boolean booleanValue = ((Boolean) onMiscCallBack).booleanValue();
                    AppMethodBeat.o(154328);
                    return booleanValue;
                }
                AppMethodBeat.o(154328);
                return false;
            }

            @Override // org.xwalk.core.XWalkUIClient
            public final boolean OnGetSampleString(XWalkView xWalkView, Map<String, String> map) {
                AppMethodBeat.i(154329);
                Bundle bundle = new Bundle();
                HashMap hashMap = new HashMap();
                hashMap.putAll(map);
                Log.d("XWWebView", "translate: OnGetSampleString orghashmap size = " + map.size() + " resultHashMap size = " + hashMap.size());
                bundle.putSerializable("sample_hashmap", hashMap);
                Object onMiscCallBack = k.this.SHl.onMiscCallBack("onGetSampleString", bundle);
                if (onMiscCallBack instanceof Boolean) {
                    boolean booleanValue = ((Boolean) onMiscCallBack).booleanValue();
                    AppMethodBeat.o(154329);
                    return booleanValue;
                }
                AppMethodBeat.o(154329);
                return false;
            }
        };
        this.SHh.SGX = this.SGX;
        this.SGZ.setUIClient(this.SGX);
        this.SGY = new o(this.SGZ) {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass4 */
            int SHw = 0;

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onReceivedHttpError(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
                AppMethodBeat.i(154331);
                Log.i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
                k.this.nsm.a(k.this.SEl, new g.i(xWalkWebResourceRequest), g.a(xWalkWebResourceResponse));
                if (xWalkWebResourceRequest.isForMainFrame()) {
                    String uri = xWalkWebResourceRequest.getUrl() != null ? xWalkWebResourceRequest.getUrl().toString() : "";
                    if (k.this.SGX != null) {
                        k.this.SGX.onPageLoadStopped(xWalkView, uri, XWalkUIClient.LoadStatus.FAILED);
                    }
                }
                AppMethodBeat.o(154331);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str) {
                AppMethodBeat.i(154332);
                if (d.bsN(str)) {
                    AppMethodBeat.o(154332);
                    return true;
                }
                boolean a2 = k.this.nsm.a(k.this.SEl, str);
                Log.i("XWWebView", "shouldOverrideUrlLoading ret =  " + a2 + " url = " + str);
                AppMethodBeat.o(154332);
                return a2;
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final boolean shouldOverrideUrlLoading(XWalkView xWalkView, String str, boolean z, boolean z2, boolean z3) {
                AppMethodBeat.i(154333);
                if (d.bsN(str)) {
                    AppMethodBeat.o(154333);
                    return true;
                }
                boolean e2 = k.this.nsm.e(k.this.SEl, new g.i(str, "GET", z, z2, z3));
                AppMethodBeat.o(154333);
                return e2;
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onLoadStarted(XWalkView xWalkView, String str) {
                AppMethodBeat.i(154334);
                k.this.nsm.h(k.this.SEl, str);
                AppMethodBeat.o(154334);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest) {
                Bundle bundle;
                WebResourceResponse webResourceResponse;
                WebResourceResponse webResourceResponse2;
                AppMethodBeat.i(154335);
                g.i iVar = new g.i(xWalkWebResourceRequest);
                if (iVar.SEd == null) {
                    bundle = null;
                } else {
                    bundle = iVar.SEd.getBundle();
                }
                if (bundle != null) {
                    webResourceResponse = k.this.nsm.a(k.this.SEl, iVar, bundle);
                } else {
                    webResourceResponse = null;
                }
                if (webResourceResponse == null) {
                    webResourceResponse = k.this.nsm.a(k.this.SEl, iVar);
                }
                if (webResourceResponse == null) {
                    webResourceResponse2 = k.this.nsm.c(k.this.SEl, xWalkWebResourceRequest.getUrl().toString());
                } else {
                    webResourceResponse2 = webResourceResponse;
                }
                if (webResourceResponse2 != null) {
                    XWalkWebResourceResponse createXWalkWebResourceResponse = createXWalkWebResourceResponse(webResourceResponse2.mMimeType, webResourceResponse2.mEncoding, webResourceResponse2.mInputStream, webResourceResponse2.mStatusCode, webResourceResponse2.mReasonPhrase, webResourceResponse2.mResponseHeaders);
                    AppMethodBeat.o(154335);
                    return createXWalkWebResourceResponse;
                }
                AppMethodBeat.o(154335);
                return null;
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onReceivedLoadError(XWalkView xWalkView, int i2, String str, String str2) {
                AppMethodBeat.i(154336);
                Log.i("XWWebView", "onReceivedError ".concat(String.valueOf(str2)));
                super.onReceivedLoadError(xWalkView, i2, str, str2);
                k.this.SHi = true;
                k.this.nsm.a(k.this.SEl, i2, str, str2);
                h.htF().htG();
                com.tencent.xweb.util.h.d(str2, i2, System.currentTimeMillis() - k.this.SEr, k.this.type);
                if (k.this.nsm.b(k.this.SEl, i2, str, str2)) {
                    AppMethodBeat.o(154336);
                    return;
                }
                StringBuilder sb = new StringBuilder(2000);
                sb.append("<html>\n");
                sb.append("<head>\n");
                sb.append("<script type=\"text/javascript\">\n");
                sb.append("function jumurl(){\n");
                sb.append("　　window.location.href = '");
                sb.append(str2);
                sb.append("';\n");
                sb.append("}\n");
                sb.append("</script>\n");
                sb.append("<title>无法打开页面</title>\n");
                sb.append("<script >\n");
                sb.append("var html = document.documentElement,");
                sb.append("resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize';");
                sb.append("function setHtmlFontSize() {");
                sb.append("var cliWidth = html.clientWidth;");
                sb.append("html.style.fontSize = 100 * (cliWidth / 720) + 'px';}");
                sb.append("window.addEventListener(resizeEvt, setHtmlFontSize, false);");
                sb.append("</script>\n");
                sb.append("<style>.exp{ text-align:center; margin-top:15rem; height=\"10rem\" width=\"10rem\"}</style>\n");
                sb.append("<style>.fcolorfortitle{ color: rgba(0, 0, 0, 0.3); font-size:44px;}</style>\n");
                sb.append("<style>.fcolorforsubtitle{ color: rgba(0, 0, 0, 0.3); font-size:34px;}</style>\n");
                sb.append("</head>\n");
                sb.append("<body bgcolor=\"#F2F2F2\" onclick=\"jumurl()\"'\">\n");
                sb.append("<br></br>");
                sb.append("<p></p>");
                sb.append("<div class=\"exp\" ><img src=\"html/img/webview_404_refresh_icon.svg\" text-align:center /><div>");
                sb.append("<br></br>");
                sb.append("<font size=\"44px\" class=\"fcolorfortitle\">无法打开页面</font>");
                sb.append("<br></br>");
                sb.append("<font size=\"44px\" class=\"fcolorforsubtitle\">轻触屏幕重新加载</font>");
                sb.append("</body>\n");
                sb.append("</html>");
                k.this.SGZ.loadDataWithBaseURL("file:///android_asset/", sb.toString(), "text/html", ProtocolPackage.ServerEncoding, null);
                AppMethodBeat.o(154336);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onReceivedSslError(XWalkView xWalkView, ValueCallback<Boolean> valueCallback, SslError sslError) {
                AppMethodBeat.i(154337);
                Log.i("XWWebView", "onReceivedSslError " + sslError.getPrimaryError());
                k.this.nsm.a(k.this.SEl, new g.h(valueCallback), sslError);
                AppMethodBeat.o(154337);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onProgressChanged(XWalkView xWalkView, int i2) {
                AppMethodBeat.i(154338);
                if (Math.abs(i2 - this.SHw) > 5 || i2 == 100) {
                    this.SHw = i2;
                    Log.i("XWWebView", "onProgressChanged, progress = ".concat(String.valueOf(i2)));
                }
                k.this.nsn.a(k.this.SEl, i2);
                AppMethodBeat.o(154338);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onDocumentLoadedInFrame(XWalkView xWalkView, long j2) {
                AppMethodBeat.i(154339);
                super.onDocumentLoadedInFrame(xWalkView, j2);
                AppMethodBeat.o(154339);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onLoadFinished(XWalkView xWalkView, String str) {
                AppMethodBeat.i(154340);
                super.onLoadFinished(xWalkView, str);
                AppMethodBeat.o(154340);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onReceivedClientCertRequest(XWalkView xWalkView, ClientCertRequest clientCertRequest) {
                AppMethodBeat.i(154341);
                super.onReceivedClientCertRequest(xWalkView, clientCertRequest);
                AppMethodBeat.o(154341);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onReceivedResponseHeaders(XWalkView xWalkView, XWalkWebResourceRequest xWalkWebResourceRequest, XWalkWebResourceResponse xWalkWebResourceResponse) {
                AppMethodBeat.i(154342);
                if (xWalkWebResourceResponse.getStatusCode() == 302) {
                    final String str = xWalkWebResourceResponse.getResponseHeaders().get(FirebaseAnalytics.b.LOCATION);
                    if (str == null || str.isEmpty()) {
                        str = xWalkWebResourceResponse.getResponseHeaders().get("Location");
                    }
                    if (str != null && str.trim().startsWith("weixin://")) {
                        k.this.nsm.b(k.this.SEl, str, (Bitmap) null);
                        k.this.SGZ.postDelayed(new Runnable() {
                            /* class com.tencent.xweb.xwalk.k.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(154330);
                                k.this.nsm.b(k.this.SEl, str, (Bitmap) null);
                                AppMethodBeat.o(154330);
                            }
                        }, 300);
                    }
                } else if (xWalkWebResourceResponse.getStatusCode() >= 400 && !k.this.supportFeature(3)) {
                    Log.i("XWWebView", "onReceivedHttpError code:" + xWalkWebResourceResponse.getStatusCode());
                    k.this.nsm.a(k.this.SEl, new g.i(xWalkWebResourceRequest), g.a(xWalkWebResourceResponse));
                    k.this.nsm.a(k.this.SEl, xWalkWebResourceResponse.getStatusCode(), "", xWalkWebResourceRequest.getUrl() != null ? xWalkWebResourceRequest.getUrl().toString() : "");
                }
                super.onReceivedResponseHeaders(xWalkView, xWalkWebResourceRequest, xWalkWebResourceResponse);
                AppMethodBeat.o(154342);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void doUpdateVisitedHistory(XWalkView xWalkView, String str, boolean z) {
                AppMethodBeat.i(154343);
                if (str == null || !str.startsWith("data:text/html;charset=utf-8")) {
                    k.this.nsm.b(k.this.SEl, str, z);
                    AppMethodBeat.o(154343);
                    return;
                }
                AppMethodBeat.o(154343);
            }

            @Override // org.xwalk.core.XWalkResourceClient
            public final void onReceivedHttpAuthRequest(XWalkView xWalkView, XWalkHttpAuthHandler xWalkHttpAuthHandler, String str, String str2) {
                AppMethodBeat.i(154344);
                Log.i("XWWebView", "onReceivedHttpAuthRequest host:" + str + ", realm:" + str2);
                if (k.this.nsm != null) {
                    k.this.nsm.a(k.this.SEl, new g.j(xWalkHttpAuthHandler), str, str2);
                    AppMethodBeat.o(154344);
                    return;
                }
                super.onReceivedHttpAuthRequest(xWalkView, xWalkHttpAuthHandler, str, str2);
                AppMethodBeat.o(154344);
            }
        };
        this.SHh.SGY = this.SGY;
        this.SGZ.setResourceClient(this.SGY);
        AppMethodBeat.o(154357);
    }

    public static class b {
        public String MYh;
        public String MYi;
        public String MYj;
        public int SHA;
        public int SHB;
        public int SHC;
        public String SHD;
        public String SHE;
        public int SHz;

        public static b c(String str, String str2, int i2, int i3, String str3, String str4) {
            String str5;
            boolean z;
            String str6;
            int i4;
            int i5;
            boolean z2 = true;
            AppMethodBeat.i(154354);
            b bVar = new b();
            bVar.MYh = str;
            bVar.SHE = str2;
            bVar.SHz = i2;
            bVar.SHB = i3;
            bVar.MYi = str3;
            bVar.MYj = str4;
            if (i2 > 0) {
                try {
                    str5 = new StringBuffer(str3).reverse().toString();
                    z = false;
                } catch (Exception e2) {
                    Log.e("XWWebView", "SelectInfo getSelectInfo error:" + e2.getMessage());
                }
            } else {
                i2 *= -1;
                str5 = str + str4;
                z = true;
            }
            if (i3 > 0) {
                str6 = str4;
                z2 = false;
            } else {
                i3 *= -1;
                str6 = new StringBuffer(str).reverse().toString() + new StringBuffer(str3).reverse().toString();
            }
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i6 <= str5.length()) {
                    if (i2 <= str5.substring(0, i6).getBytes().length) {
                        break;
                    }
                    i7 = i6;
                    i6++;
                } else {
                    i6 = i7;
                    break;
                }
            }
            int i8 = 0;
            int i9 = 0;
            while (true) {
                if (i8 <= str6.length()) {
                    if (i3 <= str6.substring(0, i8).getBytes().length) {
                        i4 = i8;
                        break;
                    }
                    i9 = i8;
                    i8++;
                } else {
                    i4 = i9;
                    break;
                }
            }
            if (z) {
                i6 *= -1;
            }
            if (z2) {
                i4 *= -1;
            }
            if (str.length() + i6 + i4 <= 0) {
                Log.e("XWWebView", "getSelectInfo error prefixIndex:" + i6 + ",suffixIndex:" + i4);
                i4 = 0;
                i5 = 0;
            } else {
                i5 = i6;
            }
            bVar.SHA = i5;
            bVar.SHC = i4;
            bVar.SHD = (str3 + str + str4).substring(str3.length() - i5, i4 + str3.length() + str.length());
            AppMethodBeat.o(154354);
            return bVar;
        }

        public final String toString() {
            AppMethodBeat.i(154355);
            try {
                String str = "SelectInfo PickedWord:" + this.MYh + ",PrefixText:" + this.MYi + ",SuffixText:" + this.MYj + ",PrefixOffset:" + this.SHz + ",prefixIndex:" + this.SHA + ",SuffixOffset:" + this.SHB + ",SuffixIndex:" + this.SHC + ",ResultPickedWord:" + this.SHE + ",OffsetedPickedWord:" + this.SHD;
                AppMethodBeat.o(154355);
                return str;
            } catch (Exception e2) {
                AppMethodBeat.o(154355);
                return "SelectInfo toString error";
            }
        }
    }

    public k(WebView webView) {
        AppMethodBeat.i(154358);
        XWalkContextWrapper xWalkContextWrapper = new XWalkContextWrapper(webView.getContext(), this.mApkVersion);
        XWalkLibraryLoader.prepareToInit(xWalkContextWrapper);
        try {
            XWalkPreferences.setValue(XWalkPreferences.XWEB_VERSION, String.valueOf(this.mApkVersion));
            XWalkPreferences.setValue(XWalkPreferences.XWEBSDK_VERSION, "201201");
        } catch (Exception e2) {
            Log.e("XWWebView", e2.getMessage());
        }
        this.SGZ = new a(xWalkContextWrapper);
        this.SHg = new AbsoluteLayout(xWalkContextWrapper);
        this.SGZ.getXWalkContentView().addView(this.SHg);
        this.SGZ.setCustomOnScrollChangedListener(new XWalkView.ScrollChangedListener() {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass5 */

            @Override // org.xwalk.core.XWalkView.ScrollChangedListener
            public final void onScrollChanged(int i2, int i3, int i4, int i5) {
                AppMethodBeat.i(154345);
                k.this.SHg.scrollTo(i2, i3);
                if (k.this.mGX != null) {
                    k.this.mGX.onScrollChanged(i2, i3, i4, i5, k.this.SGZ);
                }
                AppMethodBeat.o(154345);
            }
        });
        this.SGZ.setCustomOnOverScrolledListener(new XWalkView.OverScrolledListener() {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass6 */

            @Override // org.xwalk.core.XWalkView.OverScrolledListener
            public final void onOverScrolled(boolean z) {
                AppMethodBeat.i(154346);
                if (z) {
                    k.this.SHq = true;
                    AppMethodBeat.o(154346);
                    return;
                }
                k.this.SHq = false;
                AppMethodBeat.o(154346);
            }
        });
        this.SHh = new h(this.SGZ);
        this.SEl = webView;
        this.SHf = new l(this.SGZ);
        this.SGZ.getSettings().SetLogCallBack(new XWalkLogMessageListener() {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass9 */

            @Override // org.xwalk.core.XWalkLogMessageListener
            public final void onLogMessage(int i2, String str, int i3, String str2) {
                AppMethodBeat.i(207299);
                Log.i("XWWebView", "[WCWebview] :".concat(String.valueOf(str2)));
                AppMethodBeat.o(207299);
            }
        });
        Context context = this.SGZ.getContext();
        Log.i("XWWebView", "initFullscreenVideo:" + getFullscreenVideoKind());
        this.SEs = e.a(context, this.SEl, this.SGZ, d.htl());
        if (getFullscreenVideoKind() == WebView.a.HOOK_EVALUTE_JS) {
            this.SEs.eJ(this.SGZ);
        }
        this.hnq = new Handler() {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass7 */

            public final void handleMessage(Message message) {
                AppMethodBeat.i(207294);
                switch (message.what) {
                    case 100:
                        WebView webView = ((WebView.d) message.obj).getWebView();
                        if (webView == k.this.SEl) {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parent WebView cannot host its own popup window. Please use WebSettings.setSupportMultipleWindows(false)");
                            AppMethodBeat.o(207294);
                            throw illegalArgumentException;
                        } else if (webView == null || webView.copyBackForwardList().getSize() == 0) {
                            k.a(k.this.SEl, webView);
                            AppMethodBeat.o(207294);
                            return;
                        } else {
                            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("New WebView for popup window must not have been  previously navigated.");
                            AppMethodBeat.o(207294);
                            throw illegalArgumentException2;
                        }
                    default:
                        IllegalStateException illegalStateException = new IllegalStateException();
                        AppMethodBeat.o(207294);
                        throw illegalStateException;
                }
            }
        };
        AppMethodBeat.o(154358);
    }

    static void a(WebView webView, WebView webView2) {
        AppMethodBeat.i(207301);
        Object bridge = ((XWalkView) webView.getWebViewUI()).getBridge();
        Object bridge2 = ((XWalkView) webView2.getWebViewUI()).getBridge();
        try {
            Class<?> cls = XWalkCoreWrapper.getInstance().getClass("org.xwalk.core.internal.XWalkViewInternal");
            if (cls == null) {
                AppMethodBeat.o(207301);
                return;
            }
            new ReflectMethod(cls, "completesWindowCreation", (Class<?>[]) new Class[]{cls, cls}).invoke(bridge, bridge2);
            AppMethodBeat.o(207301);
        } catch (Exception e2) {
            Log.e("XWWebView", "completeWindowCreation reflect failed, e:" + e2.toString());
            AppMethodBeat.o(207301);
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewClient(ac acVar) {
        AppMethodBeat.i(154359);
        if (acVar == null) {
            this.nsm = new ac();
            this.nsm.SzO = this.SHh;
            AppMethodBeat.o(154359);
            return;
        }
        huV();
        this.nsm = acVar;
        AppMethodBeat.o(154359);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebChromeClient(x xVar) {
        AppMethodBeat.i(154360);
        if (xVar == null) {
            this.nsn = new x();
            AppMethodBeat.o(154360);
            return;
        }
        huV();
        this.nsn = xVar;
        AppMethodBeat.o(154360);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(154361);
        this.SGZ.setDownloadListener(new g.f(this.SEl.getContext(), downloadListener));
        AppMethodBeat.o(154361);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setFindListener(WebView.FindListener findListener) {
        AppMethodBeat.i(154362);
        this.SGZ.setFindListener(new g.C2236g(findListener));
        AppMethodBeat.o(154362);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadUrl(String str) {
        AppMethodBeat.i(154363);
        if (str == null || !str.trim().startsWith("javascript:")) {
            this.SHi = false;
            this.SGZ.loadUrl(str);
            AppMethodBeat.o(154363);
            return;
        }
        this.SGZ.evaluateJavascript(str, null);
        AppMethodBeat.o(154363);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean canGoBack() {
        AppMethodBeat.i(154364);
        if (this.SHi) {
            AppMethodBeat.o(154364);
            return false;
        }
        XWalkNavigationHistory navigationHistory = this.SGZ.getNavigationHistory();
        if (navigationHistory == null) {
            AppMethodBeat.o(154364);
            return false;
        }
        boolean canGoBack = navigationHistory.canGoBack();
        AppMethodBeat.o(154364);
        return canGoBack;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void goBack() {
        AppMethodBeat.i(154365);
        if (this.SGZ.getNavigationHistory() == null) {
            AppMethodBeat.o(154365);
            return;
        }
        if (this.SGZ.getNavigationHistory().canGoBack()) {
            this.SGZ.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.BACKWARD, 1);
            if (!(this.SGZ.getNavigationHistory() == null || this.SGZ.getNavigationHistory().getCurrentItem() == null)) {
                this.nsn.d(this.SEl, this.SGZ.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
        AppMethodBeat.o(154365);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean hasEnteredFullscreen() {
        AppMethodBeat.i(154366);
        boolean hasEnteredFullscreen = this.SGZ.hasEnteredFullscreen();
        AppMethodBeat.o(154366);
        return hasEnteredFullscreen;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void leaveFullscreen() {
        AppMethodBeat.i(154367);
        this.SGZ.leaveFullscreen();
        AppMethodBeat.o(154367);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearView() {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void destroy() {
        AppMethodBeat.i(154368);
        this.SGZ.onDestroy();
        AppMethodBeat.o(154368);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void disableVideoJsCallback(boolean z) {
        AppMethodBeat.i(154369);
        if (this.SEs != null) {
            this.SEs.Em(z);
        }
        AppMethodBeat.o(154369);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final u setVideoJsCallback(v vVar) {
        AppMethodBeat.i(154370);
        if (this.SEs == null || !this.SEs.eK(vVar)) {
            Log.i("XWWebView", "setVideoJsCallback not support");
            AppMethodBeat.o(154370);
            return null;
        }
        AnonymousClass8 r0 = new u() {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass8 */

            @Override // com.tencent.xweb.u
            public final void hsz() {
                AppMethodBeat.i(207295);
                if (k.this.SEs != null) {
                    k.this.SEs.hsz();
                }
                AppMethodBeat.o(207295);
            }

            @Override // com.tencent.xweb.u
            public final void fDd() {
                AppMethodBeat.i(207296);
                if (k.this.SEs != null) {
                    k.this.SEs.fDd();
                }
                AppMethodBeat.o(207296);
            }

            @Override // com.tencent.xweb.u
            public final void F(double d2) {
                AppMethodBeat.i(207297);
                if (k.this.SEs != null) {
                    k.this.SEs.F(d2);
                }
                AppMethodBeat.o(207297);
            }

            @Override // com.tencent.xweb.u
            public final boolean hsA() {
                AppMethodBeat.i(207298);
                if (k.this.SEs != null) {
                    boolean hsA = k.this.SEs.hsA();
                    AppMethodBeat.o(207298);
                    return hsA;
                }
                AppMethodBeat.o(207298);
                return false;
            }
        };
        AppMethodBeat.o(154370);
        return r0;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(154371);
        this.SGZ.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(154371);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final com.tencent.xweb.internal.e getDefalutOpProvider() {
        return this.SHh;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void reload() {
        AppMethodBeat.i(154372);
        this.SGZ.reload(0);
        AppMethodBeat.o(154372);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearSslPreferences() {
        AppMethodBeat.i(154373);
        this.SGZ.clearSslPreferences();
        AppMethodBeat.o(154373);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(154374);
        this.SGZ.loadData(str, str2, str3);
        AppMethodBeat.o(154374);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getContentHeight() {
        AppMethodBeat.i(154375);
        int contentHeight = this.SGZ.getContentHeight();
        AppMethodBeat.o(154375);
        return contentHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final float getScale() {
        AppMethodBeat.i(154376);
        float scale = this.SGZ.getScale();
        AppMethodBeat.o(154376);
        return scale;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getVisibleTitleHeight() {
        return 0;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(154377);
        int scrollBarStyle = this.SGZ.getScrollBarStyle();
        if (scrollBarStyle == 0 || scrollBarStyle == 33554432) {
            AppMethodBeat.o(154377);
            return true;
        }
        AppMethodBeat.o(154377);
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(154378);
        this.SGZ.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(154378);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean zoomOut() {
        AppMethodBeat.i(154379);
        boolean zoomOut = this.SGZ.zoomOut();
        AppMethodBeat.o(154379);
        return zoomOut;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean zoomIn() {
        AppMethodBeat.i(154380);
        boolean zoomIn = this.SGZ.zoomIn();
        AppMethodBeat.o(154380);
        return zoomIn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(154381);
        this.SGZ.loadUrl(str, map);
        AppMethodBeat.o(154381);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(154382);
        this.SGZ.addJavascriptInterface(obj, str);
        AppMethodBeat.o(154382);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final View getView() {
        return this.SGZ;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getUrl() {
        AppMethodBeat.i(154383);
        String url = this.SGZ.getUrl();
        AppMethodBeat.o(154383);
        return url;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void removeJavascriptInterface(String str) {
        AppMethodBeat.i(154384);
        this.SGZ.removeJavascriptInterface(str);
        AppMethodBeat.o(154384);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void stopLoading() {
        AppMethodBeat.i(154385);
        this.SGZ.stopLoading();
        AppMethodBeat.o(154385);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewCallbackClient(ab abVar) {
        this.mGX = abVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebView.b getHitTestResult() {
        AppMethodBeat.i(154386);
        WebView.b bVar = new WebView.b();
        XWalkHitTestResult hitTestResult = this.SGZ.getHitTestResult();
        bVar.mType = hitTestResult.getType().ordinal();
        bVar.mExtra = hitTestResult.getExtra();
        AppMethodBeat.o(154386);
        return bVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getTitle() {
        AppMethodBeat.i(154387);
        String title = this.SGZ.getTitle();
        AppMethodBeat.o(154387);
        return title;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final z getSettings() {
        return this.SHf;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final View getWebViewUI() {
        return this.SGZ;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final ViewGroup getTopView() {
        return this.SHg;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearMatches() {
        AppMethodBeat.i(154388);
        this.SGZ.clearMatches();
        AppMethodBeat.o(154388);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void findNext(boolean z) {
        AppMethodBeat.i(154389);
        this.SGZ.findNext(z);
        AppMethodBeat.o(154389);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void findAllAsync(String str) {
        AppMethodBeat.i(154390);
        this.SGZ.findAllAsync(str);
        AppMethodBeat.o(154390);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getVersionInfo() {
        AppMethodBeat.i(154391);
        String str = "webviewType = WV_KIND_CW,V8 type=" + JsRuntime.hsv() + " ,apkversion = " + this.mApkVersion + " , " + XWalkEnvironment.getAvailableVersionDetail() + " sdk = 201201";
        AppMethodBeat.o(154391);
        return str;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String getAbstractInfo() {
        AppMethodBeat.i(154392);
        String str = "webviewtype = xwalk, sdkver = 201201\n apkver = " + XWalkEnvironment.getAvailableVersion();
        AppMethodBeat.o(154392);
        return str;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.i(154393);
        boolean isSupportExtendPluginForAppbrand = this.SGZ.isSupportExtendPluginForAppbrand();
        AppMethodBeat.o(154393);
        return isSupportExtendPluginForAppbrand;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final ac getCurWebviewClient() {
        return this.nsm;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final x getCurWebChromeClient() {
        return this.nsn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getWebScrollY() {
        AppMethodBeat.i(154394);
        int computeVerticalScrollOffset = this.SGZ.computeVerticalScrollOffset();
        AppMethodBeat.o(154394);
        return computeVerticalScrollOffset;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getWebScrollX() {
        AppMethodBeat.i(154395);
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            int computeHorizontalScrollOffset = ((XWalkView) webViewUI).computeHorizontalScrollOffset();
            AppMethodBeat.o(154395);
            return computeHorizontalScrollOffset;
        }
        int scrollX = webViewUI.getScrollX();
        AppMethodBeat.o(154395);
        return scrollX;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Object getX5WebViewExtension() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a aVar) {
        AppMethodBeat.i(154397);
        this.SHl = aVar;
        this.SGZ.setProxyWebViewClientExtension(this.SHk);
        AppMethodBeat.o(154397);
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
        AppMethodBeat.i(154398);
        this.SGZ.onResume();
        AppMethodBeat.o(154398);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onPause() {
        AppMethodBeat.i(154399);
        this.SGZ.onPause();
        AppMethodBeat.o(154399);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebView.a getFullscreenVideoKind() {
        AppMethodBeat.i(154400);
        WebView.a brG = com.tencent.xweb.a.brG(com.tencent.xweb.WebView.getCurStrModule());
        AppMethodBeat.o(154400);
        return brG;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setJSExceptionListener(ae aeVar) {
        this.SHm = aeVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean savePage(String str, String str2, int i2) {
        AppMethodBeat.i(154401);
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            boolean savePage = ((XWalkView) webViewUI).savePage(str, str2, i2);
            AppMethodBeat.o(154401);
            return savePage;
        }
        AppMethodBeat.o(154401);
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Bitmap captureBitmap() {
        AppMethodBeat.i(207302);
        View childAt = ((ViewGroup) ((ViewGroup) this.SGZ.getChildAt(0)).getChildAt(0)).getChildAt(0);
        if (childAt instanceof TextureView) {
            Bitmap bitmap = ((TextureView) childAt).getBitmap();
            Log.d("XWWebView", "captureBitmap with ".concat(String.valueOf(bitmap)));
            AppMethodBeat.o(207302);
            return bitmap;
        }
        AppMethodBeat.o(207302);
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void captureBitmap(final IWebView.a aVar) {
        AppMethodBeat.i(154402);
        final View childAt = ((ViewGroup) ((ViewGroup) this.SGZ.getChildAt(0)).getChildAt(0)).getChildAt(0);
        if (childAt instanceof TextureView) {
            new Thread(new Runnable() {
                /* class com.tencent.xweb.xwalk.k.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(207300);
                    Log.d("XWWebView", "onFinishGetBitmap with ".concat(String.valueOf(((TextureView) childAt).getBitmap())));
                    AppMethodBeat.o(207300);
                }
            }).start();
        }
        AppMethodBeat.o(154402);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void smoothScroll(int i2, int i3, long j2) {
        AppMethodBeat.i(154403);
        this.SGZ.smoothScroll(i2, i3, j2);
        AppMethodBeat.o(154403);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void clearHistory() {
        AppMethodBeat.i(154404);
        if (this.SGZ.getNavigationHistory() != null) {
            this.SGZ.getNavigationHistory().clear();
        }
        AppMethodBeat.o(154404);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean canGoForward() {
        AppMethodBeat.i(154405);
        if (this.SGZ.getNavigationHistory() != null) {
            boolean canGoForward = this.SGZ.getNavigationHistory().canGoForward();
            AppMethodBeat.o(154405);
            return canGoForward;
        }
        AppMethodBeat.o(154405);
        return false;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void goForward() {
        AppMethodBeat.i(154406);
        if (this.SGZ.getNavigationHistory().canGoForward()) {
            this.SGZ.getNavigationHistory().navigate(XWalkNavigationHistory.Direction.FORWARD, 1);
            if (!(this.SGZ.getNavigationHistory() == null || this.SGZ.getNavigationHistory().getCurrentItem() == null)) {
                this.nsn.d(this.SEl, this.SGZ.getNavigationHistory().getCurrentItem().getTitle());
            }
        }
        AppMethodBeat.o(154406);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean supportFeature(int i2) {
        AppMethodBeat.i(154407);
        boolean hasFeature = XWalkCoreWrapper.getInstance().hasFeature(i2);
        AppMethodBeat.o(154407);
        return hasFeature;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(154408);
        this.SGZ.setVerticalScrollBarEnable(z);
        AppMethodBeat.o(154408);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(154409);
        this.SGZ.setHorizontalScrollBarEnable(z);
        AppMethodBeat.o(154409);
    }

    @Override // com.tencent.xweb.internal.g
    public final void a(View view, boolean z, q qVar) {
        AppMethodBeat.i(154410);
        if (XWalkCoreWrapper.getInstance().hasFeature(2)) {
            try {
                Class<?> cls = XWalkCoreWrapper.getInstance().getClass("com.tencent.xweb.screenshot.LongScreenShotManager");
                if (cls == null) {
                    AppMethodBeat.o(154410);
                    return;
                }
                new ReflectMethod(cls, "startLongScreenShot", (Class<?>[]) new Class[]{View.class, Boolean.TYPE, Object.class}).invoke(view, Boolean.valueOf(z), XWalkCoreWrapper.getInstance().getBridgeObject(new g.d(qVar)));
                AppMethodBeat.o(154410);
                return;
            } catch (Exception e2) {
                Log.e("XWWebView", "startLongScreenShot reflect failed");
            }
        }
        AppMethodBeat.o(154410);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final Bundle invokeMiscMethod(String str, Bundle bundle) {
        AppMethodBeat.i(154411);
        if (str == null || str.length() == 0) {
            Log.d("XWWebView", " method string is null or empty");
            AppMethodBeat.o(154411);
            return null;
        }
        Log.d("XWWebView", " method string is ".concat(String.valueOf(str)));
        if (str.equals("supportTranslateWebSite")) {
            boolean isSupportTranslateWebSite = XWalkCoreWrapper.getInstance().isSupportTranslateWebSite();
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("result", isSupportTranslateWebSite);
            Log.i("XWWebView", "translate: xweb is supportTranslateWebSite = ".concat(String.valueOf(isSupportTranslateWebSite)));
            AppMethodBeat.o(154411);
            return bundle2;
        } else if (str.equals("getTranslateSampleString")) {
            Log.i("XWWebView", "translate: xweb is detectTranslateWebSiteIsNeeded ,getTranslateSampleString");
            this.SGZ.getTranslateSampleString(0);
            AppMethodBeat.o(154411);
            return null;
        } else if (str.equals("translateWebSite")) {
            Log.i("XWWebView", "translate: do translateWebSite");
            bundle.getString("url");
            this.SHn = true;
            AppMethodBeat.o(154411);
            return null;
        } else if (str.equals("replaceTranslatedString")) {
            Log.i("XWWebView", "translate: replaceTranslatedString mIsTranslateMode =" + this.SHn);
            if (!this.SHn) {
                AppMethodBeat.o(154411);
                return null;
            }
            HashMap hashMap = (HashMap) bundle.getSerializable("translate_hashmap");
            Boolean valueOf = Boolean.valueOf(bundle.getBoolean("is_mp_url"));
            String string = bundle.getString("translate_tips");
            HashMap hashMap2 = new HashMap();
            for (String str2 : hashMap.keySet()) {
                String str3 = (String) hashMap.get(str2);
                if (str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
                    Log.d("XWWebView", "translate: string is err !!!  key = " + str2 + " value = " + str3);
                } else if (str3.trim().length() == 0 || str3.trim().equals("\n") || str3.trim().equals("\r")) {
                    Log.d("XWWebView", "translate: string is space  or change line  value = ".concat(String.valueOf(str3)));
                } else {
                    hashMap2.put(str2, str3);
                }
            }
            Log.d("XWWebView", "translate: replaceTranslatedString orghashmap size = " + hashMap.size() + " resultHashMap size = " + hashMap2.size());
            this.SGZ.replaceTranslatedString(hashMap2);
            boolean booleanValue = valueOf.booleanValue();
            if (this.SHn && !this.SHo) {
                this.SHo = true;
                Log.i("XWWebView", "getTranslateTipsView");
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, 144);
                layoutParams.gravity = 51;
                TextView textView = new TextView(this.SEl.getContext());
                textView.setGravity(17);
                textView.setText(string);
                textView.setTextColor(Color.argb((int) TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 0, 0, 0));
                textView.setTextSize(0, 42.0f);
                if (booleanValue) {
                    textView.setBackgroundColor(-328966);
                } else {
                    textView.setBackgroundColor(-855310);
                }
                ((ViewGroup) this.SEl.getParent()).addView(textView, layoutParams);
                ((FrameLayout.LayoutParams) this.SEl.getLayoutParams()).topMargin = 144;
                this.SEl.requestLayout();
            }
            Log.d("XWWebView", "translate: onTranslateFinish ");
            fZn();
            AppMethodBeat.o(154411);
            return null;
        } else {
            AppMethodBeat.o(154411);
            return null;
        }
    }

    private void fZn() {
        AppMethodBeat.i(154412);
        this.SHl.onMiscCallBack("onTranslateFinish", new Bundle());
        AppMethodBeat.o(154412);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean getImageBitmapToFile(String str, String str2, String str3, final i iVar) {
        AppMethodBeat.i(154413);
        boolean imageBitmapToFile = this.SGZ.getImageBitmapToFile(str, str2, str3, new XWalkGetImageBitmapToFileFinishedCallback() {
            /* class com.tencent.xweb.xwalk.k.AnonymousClass2 */

            @Override // org.xwalk.core.XWalkGetImageBitmapToFileFinishedCallback
            public final void onFinishImageBitmapToFile(int i2, String str, String str2, int i3, int i4, String str3) {
                AppMethodBeat.i(207290);
                iVar.cV(i2, str2);
                AppMethodBeat.o(207290);
            }
        });
        AppMethodBeat.o(154413);
        return imageBitmapToFile;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setBottomHeight(int i2) {
        AppMethodBeat.i(154415);
        Log.e("XWWebView", "setBottomHeight not implement");
        this.SGZ.setBottomHeight(i2);
        AppMethodBeat.o(154415);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onShow() {
        AppMethodBeat.i(154416);
        this.SGZ.onShow();
        AppMethodBeat.o(154416);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void onHide() {
        AppMethodBeat.i(154417);
        this.SGZ.onHide();
        AppMethodBeat.o(154417);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final int getScrollHeight() {
        AppMethodBeat.i(154418);
        int computeVerticalScrollRange = this.SGZ.computeVerticalScrollRange();
        AppMethodBeat.o(154418);
        return computeVerticalScrollRange;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final WebBackForwardList copyBackForwardList() {
        AppMethodBeat.i(207303);
        q qVar = new q(this.SGZ.getNavigationHistory());
        AppMethodBeat.o(207303);
        return qVar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(207304);
        ad.hta().setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(207304);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(207305);
        String[] httpAuthUsernamePassword = ad.hta().getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(207305);
        return httpAuthUsernamePassword;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public final boolean isOverScrollStart() {
        int scrollY;
        AppMethodBeat.i(154396);
        boolean z = this.SHq;
        View webViewUI = getWebViewUI();
        if (webViewUI instanceof XWalkView) {
            scrollY = ((XWalkView) webViewUI).computeVerticalScrollOffset();
        } else {
            scrollY = webViewUI.getScrollY();
        }
        if (scrollY != 0 || !z) {
            AppMethodBeat.o(154396);
            return false;
        }
        AppMethodBeat.o(154396);
        return true;
    }

    static /* synthetic */ void f(k kVar) {
        AppMethodBeat.i(154419);
        kVar.SHl.onMiscCallBack("onTranslateStart", new Bundle());
        AppMethodBeat.o(154419);
    }
}
