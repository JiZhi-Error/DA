package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.c.c;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.o;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class WebView extends FrameLayout implements View.OnLongClickListener {
    public static final int GETPVERROR = -1;
    public static int NIGHT_MODE_ALPHA = 153;
    public static final int NIGHT_MODE_COLOR = -16777216;
    public static final int NORMAL_MODE_ALPHA = 255;
    public static final String SCHEME_GEO = "geo:0,0?q=";
    public static final String SCHEME_MAILTO = "mailto:";
    public static final String SCHEME_TEL = "tel:";

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f1911c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static OutputStream f1912d = null;

    /* renamed from: j  reason: collision with root package name */
    private static Context f1913j = null;
    public static boolean mSysWebviewCreated = false;
    public static boolean mWebViewCreated = false;
    private static BroadcastReceiver n = null;
    private static o o = null;
    private static Method p = null;
    private static String s = null;
    private static Paint y = null;
    private static boolean z = true;
    private Object A;
    private View.OnLongClickListener B;

    /* renamed from: a  reason: collision with root package name */
    int f1914a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1915b;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1916e;

    /* renamed from: f  reason: collision with root package name */
    private IX5WebViewBase f1917f;

    /* renamed from: g  reason: collision with root package name */
    private b f1918g;

    /* renamed from: h  reason: collision with root package name */
    private WebSettings f1919h;

    /* renamed from: i  reason: collision with root package name */
    private Context f1920i;
    private boolean k;
    private p l;
    private boolean m;
    public WebViewCallbackClient mWebViewCallbackClient;
    private WebViewClient q;
    private WebChromeClient r;
    private final int t;
    private final int u;
    private final int v;
    private final String w;
    private final String x;

    public interface PictureListener {
        void onNewPicture(WebView webView, Picture picture);
    }

    static /* synthetic */ void a(WebView webView, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(54315);
        webView.onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(54315);
    }

    static /* synthetic */ void b(WebView webView, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(54316);
        webView.onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(54316);
    }

    public class WebViewTransport {

        /* renamed from: b  reason: collision with root package name */
        private WebView f1937b;

        public WebViewTransport() {
        }

        public synchronized void setWebView(WebView webView) {
            this.f1937b = webView;
        }

        public synchronized WebView getWebView() {
            return this.f1937b;
        }
    }

    static {
        AppMethodBeat.i(54317);
        AppMethodBeat.o(54317);
    }

    public static class HitTestResult {
        @Deprecated
        public static final int ANCHOR_TYPE = 1;
        public static final int EDIT_TEXT_TYPE = 9;
        public static final int EMAIL_TYPE = 4;
        public static final int GEO_TYPE = 3;
        @Deprecated
        public static final int IMAGE_ANCHOR_TYPE = 6;
        public static final int IMAGE_TYPE = 5;
        public static final int PHONE_TYPE = 2;
        public static final int SRC_ANCHOR_TYPE = 7;
        public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
        public static final int UNKNOWN_TYPE = 0;

        /* renamed from: a  reason: collision with root package name */
        private IX5WebViewBase.HitTestResult f1934a;

        /* renamed from: b  reason: collision with root package name */
        private WebView.HitTestResult f1935b;

        public HitTestResult() {
            this.f1935b = null;
            this.f1934a = null;
            this.f1935b = null;
        }

        public HitTestResult(IX5WebViewBase.HitTestResult hitTestResult) {
            this.f1935b = null;
            this.f1934a = hitTestResult;
            this.f1935b = null;
        }

        public HitTestResult(WebView.HitTestResult hitTestResult) {
            this.f1935b = null;
            this.f1934a = null;
            this.f1935b = hitTestResult;
        }

        public int getType() {
            AppMethodBeat.i(54564);
            int i2 = 0;
            if (this.f1934a != null) {
                i2 = this.f1934a.getType();
            } else if (this.f1935b != null) {
                i2 = this.f1935b.getType();
            }
            AppMethodBeat.o(54564);
            return i2;
        }

        public String getExtra() {
            AppMethodBeat.i(54565);
            String str = "";
            if (this.f1934a != null) {
                str = this.f1934a.getExtra();
            } else if (this.f1935b != null) {
                str = this.f1935b.getExtra();
            }
            AppMethodBeat.o(54565);
            return str;
        }
    }

    public WebView(Context context, boolean z2) {
        super(context);
        this.f1915b = "WebView";
        this.f1916e = false;
        this.f1919h = null;
        this.f1920i = null;
        this.f1914a = 0;
        this.k = false;
        this.l = null;
        this.m = false;
        this.q = null;
        this.r = null;
        this.t = 1;
        this.u = 2;
        this.v = 3;
        this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.A = null;
        this.B = null;
    }

    public WebView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, false);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2, boolean z2) {
        this(context, attributeSet, i2, null, z2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @TargetApi(11)
    public WebView(Context context, AttributeSet attributeSet, int i2, Map<String, Object> map, boolean z2) {
        super(context, attributeSet, i2);
        boolean z3 = false;
        AppMethodBeat.i(54156);
        this.f1915b = "WebView";
        this.f1916e = false;
        this.f1919h = null;
        this.f1920i = null;
        this.f1914a = 0;
        this.k = false;
        this.l = null;
        this.m = false;
        this.q = null;
        this.r = null;
        this.t = 1;
        this.u = 2;
        this.v = 3;
        this.w = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
        this.x = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
        this.A = null;
        this.B = null;
        mWebViewCreated = true;
        this.l = new p();
        this.l.a("init_all", (byte) 1);
        if (!QbSdk.getIsSysWebViewForcedByOuter() || !TbsShareManager.isThirdPartyApp(context)) {
            if (TbsShareManager.isThirdPartyApp(context)) {
                TbsLog.setWriteLogJIT(true);
            } else {
                TbsLog.setWriteLogJIT(false);
            }
            this.l.a("tbslog_init", (byte) 1);
            TbsLog.initIfNeed(context);
            this.l.a("tbslog_init", (byte) 2);
            if (context == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid context argument");
                AppMethodBeat.o(54156);
                throw illegalArgumentException;
            }
            if (o == null) {
                o = o.a(context);
            }
            if (o.f2283a) {
                TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
                QbSdk.a(context, "debug.conf force syswebview!");
            }
            a(context, this.l);
            this.f1920i = context;
            if (context != null) {
                f1913j = context.getApplicationContext();
            }
            if (!this.f1916e || QbSdk.f1702a) {
                this.f1917f = null;
                if (TbsShareManager.isThirdPartyApp(this.f1920i)) {
                    this.f1918g = new b(context, attributeSet);
                } else {
                    this.f1918g = new b(this, context);
                }
                TbsLog.i("WebView", "SystemWebView Created Success! #2");
                CookieManager.getInstance().a(context, true, false);
                CookieManager.getInstance().a();
                this.f1918g.setFocusableInTouchMode(true);
                addView(this.f1918g, new FrameLayout.LayoutParams(-1, -1));
                setDownloadListener(null);
                b(context);
                TbsLog.writeLogToDisk();
                q.a(context);
            } else {
                this.l.a("init_x5_webview", (byte) 1);
                this.f1917f = TbsOneGreyInfoHelper.getCoreEntry().createX5WebView(context, false);
                this.l.a("init_x5_webview", (byte) 2);
                if (this.f1917f == null || this.f1917f.getView() == null) {
                    TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
                    this.f1917f = null;
                    this.f1916e = false;
                    QbSdk.a(context, "failed to createTBSWebview!");
                    a(context, this.l);
                    if (TbsShareManager.isThirdPartyApp(this.f1920i)) {
                        this.f1918g = new b(context, attributeSet);
                    } else {
                        this.f1918g = new b(this, context);
                    }
                    TbsLog.i("WebView", "SystemWebView Created Success! #1");
                    CookieManager.getInstance().a(context, true, false);
                    CookieManager.getInstance().a();
                    this.f1918g.setFocusableInTouchMode(true);
                    addView(this.f1918g, new FrameLayout.LayoutParams(-1, -1));
                    try {
                        if (Build.VERSION.SDK_INT >= 11) {
                            removeJavascriptInterface("searchBoxJavaBridge_");
                            removeJavascriptInterface("accessibility");
                            removeJavascriptInterface("accessibilityTraversal");
                        }
                    } catch (Throwable th) {
                    }
                    b(context);
                    TbsLog.writeLogToDisk();
                    q.a(context);
                    d.a(context, this);
                    AppMethodBeat.o(54156);
                    return;
                }
                TbsLog.i("WebView", "X5 WebView Created Success!!");
                this.f1917f.getView().setFocusableInTouchMode(true);
                a(attributeSet);
                addView(this.f1917f.getView(), new FrameLayout.LayoutParams(-1, -1));
                this.f1917f.setDownloadListener(new b(this, null, this.f1916e));
                this.f1917f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebChromeClientExtension()) {
                    /* class com.tencent.smtt.sdk.WebView.AnonymousClass1 */

                    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                    public void invalidate() {
                    }

                    @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
                    public void onScrollChanged(int i2, int i3, int i4, int i5) {
                        AppMethodBeat.i(55116);
                        super.onScrollChanged(i2, i3, i4, i5);
                        WebView.a(WebView.this, i4, i5, i2, i3);
                        AppMethodBeat.o(55116);
                    }
                });
            }
            try {
                if (Build.VERSION.SDK_INT >= 11) {
                    removeJavascriptInterface("searchBoxJavaBridge_");
                    removeJavascriptInterface("accessibility");
                    removeJavascriptInterface("accessibilityTraversal");
                }
            } catch (Throwable th2) {
            }
            if (this.f1917f != null) {
                TbsLog.writeLogToDisk();
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i3 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i3 <= 0 || i3 == q.a().i(context) || i3 != q.a().j(context)) {
                        TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + i3 + " getTbsCoreShareDecoupleCoreVersion is " + q.a().i(context) + " getTbsCoreInstalledVerInNolock is " + q.a().j(context));
                    } else {
                        q.a().o(context);
                    }
                }
            }
            d.a(context, this);
            new StringBuilder("loadX5 -> isX5webview:").append(this.f1917f != null ? true : z3).append(",X5CoreVersion:").append(QbSdk.getTbsCoreVersionString());
            if (this.l != null) {
                this.l.a("load_url_gap", (byte) 1);
                this.l.a("init_all", (byte) 2);
            }
            AppMethodBeat.o(54156);
            return;
        }
        this.f1920i = context;
        this.f1917f = null;
        this.f1916e = false;
        QbSdk.a(context, "failed to createTBSWebview!");
        this.f1918g = new b(context, attributeSet);
        CookieManager.getInstance().a(context, true, false);
        CookieSyncManager.createInstance(this.f1920i).startSync();
        try {
            Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
            declaredMethod.setAccessible(true);
            ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
            mSysWebviewCreated = true;
        } catch (Exception e2) {
        }
        CookieManager.getInstance().a();
        this.f1918g.setFocusableInTouchMode(true);
        addView(this.f1918g, new FrameLayout.LayoutParams(-1, -1));
        TbsLog.i("WebView", "SystemWebView Created Success! #3");
        TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 402, new Throwable());
        d.a(context, this);
        AppMethodBeat.o(54156);
    }

    /* access modifiers changed from: package-private */
    public static class a extends BroadcastReceiver {
        private a() {
        }

        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(55494);
            if (intent != null) {
                try {
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                        int apnType = Apn.getApnType(context);
                        long currentTimeMillis = System.currentTimeMillis();
                        synchronized (QbSdk.f1708g) {
                            try {
                                if (QbSdk.f1705d) {
                                    QbSdk.f1707f += currentTimeMillis - QbSdk.f1706e;
                                }
                                QbSdk.f1706e = currentTimeMillis;
                            } catch (Throwable th) {
                                AppMethodBeat.o(55494);
                                throw th;
                            }
                        }
                        TbsLog.d("sdkreport", "pv report, SdkEngine.registerConnectivityChangedReceiver QbSdk.sWifiConnectTime=" + QbSdk.f1707f + " apnType=" + apnType);
                        QbSdk.f1705d = apnType == 3;
                    }
                } catch (Throwable th2) {
                    AppMethodBeat.o(55494);
                    return;
                }
            }
            AppMethodBeat.o(55494);
        }
    }

    private void b(final Context context) {
        AppMethodBeat.i(54157);
        if (n != null) {
            AppMethodBeat.o(54157);
            return;
        }
        n = new a();
        new Thread() {
            /* class com.tencent.smtt.sdk.WebView.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(55020);
                try {
                    QbSdk.f1705d = Apn.getApnType(context) == 3;
                    QbSdk.f1706e = System.currentTimeMillis();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    context.getApplicationContext().registerReceiver(WebView.n, intentFilter);
                    AppMethodBeat.o(55020);
                } catch (Throwable th) {
                    AppMethodBeat.o(55020);
                }
            }
        }.start();
        AppMethodBeat.o(54157);
    }

    public Object createPrintDocumentAdapter(String str) {
        AppMethodBeat.i(54158);
        if (this.f1916e) {
            try {
                Object createPrintDocumentAdapter = this.f1917f.createPrintDocumentAdapter(str);
                AppMethodBeat.o(54158);
                return createPrintDocumentAdapter;
            } catch (Throwable th) {
                AppMethodBeat.o(54158);
                return null;
            }
        } else if (Build.VERSION.SDK_INT < 21) {
            AppMethodBeat.o(54158);
            return null;
        } else {
            Object a2 = k.a(this.f1918g, "createPrintDocumentAdapter", new Class[]{String.class}, str);
            AppMethodBeat.o(54158);
            return a2;
        }
    }

    public int computeHorizontalScrollOffset() {
        AppMethodBeat.i(54159);
        try {
            if (this.f1916e) {
                Method a2 = k.a(this.f1917f.getView(), "computeHorizontalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                int intValue = ((Integer) a2.invoke(this.f1917f.getView(), new Object[0])).intValue();
                AppMethodBeat.o(54159);
                return intValue;
            }
            Method a3 = k.a(this.f1918g, "computeHorizontalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            int intValue2 = ((Integer) a3.invoke(this.f1918g, new Object[0])).intValue();
            AppMethodBeat.o(54159);
            return intValue2;
        } catch (Exception e2) {
            AppMethodBeat.o(54159);
            return -1;
        }
    }

    public int computeVerticalScrollOffset() {
        AppMethodBeat.i(54160);
        try {
            if (this.f1916e) {
                Method a2 = k.a(this.f1917f.getView(), "computeVerticalScrollOffset", new Class[0]);
                a2.setAccessible(true);
                int intValue = ((Integer) a2.invoke(this.f1917f.getView(), new Object[0])).intValue();
                AppMethodBeat.o(54160);
                return intValue;
            }
            Method a3 = k.a(this.f1918g, "computeVerticalScrollOffset", new Class[0]);
            a3.setAccessible(true);
            int intValue2 = ((Integer) a3.invoke(this.f1918g, new Object[0])).intValue();
            AppMethodBeat.o(54160);
            return intValue2;
        } catch (Exception e2) {
            AppMethodBeat.o(54160);
            return -1;
        }
    }

    public int computeVerticalScrollExtent() {
        AppMethodBeat.i(54161);
        try {
            if (this.f1916e) {
                Method a2 = k.a(this.f1917f.getView(), "computeVerticalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                int intValue = ((Integer) a2.invoke(this.f1917f.getView(), new Object[0])).intValue();
                AppMethodBeat.o(54161);
                return intValue;
            }
            Method a3 = k.a(this.f1918g, "computeVerticalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            int intValue2 = ((Integer) a3.invoke(this.f1918g, new Object[0])).intValue();
            AppMethodBeat.o(54161);
            return intValue2;
        } catch (Exception e2) {
            AppMethodBeat.o(54161);
            return -1;
        }
    }

    public int computeHorizontalScrollRange() {
        AppMethodBeat.i(54162);
        try {
            if (this.f1916e) {
                int intValue = ((Integer) k.a(this.f1917f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
                AppMethodBeat.o(54162);
                return intValue;
            }
            Method a2 = k.a(this.f1918g, "computeHorizontalScrollRange", new Class[0]);
            a2.setAccessible(true);
            int intValue2 = ((Integer) a2.invoke(this.f1918g, new Object[0])).intValue();
            AppMethodBeat.o(54162);
            return intValue2;
        } catch (Exception e2) {
            AppMethodBeat.o(54162);
            return -1;
        }
    }

    public int computeHorizontalScrollExtent() {
        AppMethodBeat.i(54163);
        try {
            if (this.f1916e) {
                Method a2 = k.a(this.f1917f.getView(), "computeHorizontalScrollExtent", new Class[0]);
                a2.setAccessible(true);
                int intValue = ((Integer) a2.invoke(this.f1917f.getView(), new Object[0])).intValue();
                AppMethodBeat.o(54163);
                return intValue;
            }
            Method a3 = k.a(this.f1918g, "computeHorizontalScrollExtent", new Class[0]);
            a3.setAccessible(true);
            int intValue2 = ((Integer) a3.invoke(this.f1918g, new Object[0])).intValue();
            AppMethodBeat.o(54163);
            return intValue2;
        } catch (Exception e2) {
            AppMethodBeat.o(54163);
            return -1;
        }
    }

    public int computeVerticalScrollRange() {
        AppMethodBeat.i(54164);
        try {
            if (this.f1916e) {
                int intValue = ((Integer) k.a(this.f1917f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
                AppMethodBeat.o(54164);
                return intValue;
            }
            Method a2 = k.a(this.f1918g, "computeVerticalScrollRange", new Class[0]);
            a2.setAccessible(true);
            int intValue2 = ((Integer) a2.invoke(this.f1918g, new Object[0])).intValue();
            AppMethodBeat.o(54164);
            return intValue2;
        } catch (Exception e2) {
            AppMethodBeat.o(54164);
            return -1;
        }
    }

    private boolean c(Context context) {
        AppMethodBeat.i(54165);
        try {
            if (context.getPackageName().indexOf(TbsConfig.APP_QQ) >= 0) {
                AppMethodBeat.o(54165);
                return true;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(54165);
        return false;
    }

    /* access modifiers changed from: protected */
    @TargetApi(11)
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(54166);
        super.onSizeChanged(i2, i3, i4, i5);
        if (Build.VERSION.SDK_INT >= 21 && c(this.f1920i) && isHardwareAccelerated() && i2 > 0 && i3 > 0) {
            getLayerType();
        }
        AppMethodBeat.o(54166);
    }

    private void a(Context context, p pVar) {
        AppMethodBeat.i(188247);
        if (QbSdk.f1709h && TbsShareManager.isThirdPartyApp(context)) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
        }
        if (pVar != null) {
            pVar.a("x5_core_engine_init_sync", (byte) 1);
        }
        x a2 = x.a();
        a2.a(context, pVar);
        this.f1916e = a2.b();
        AppMethodBeat.o(188247);
    }

    public void setScrollBarStyle(int i2) {
        AppMethodBeat.i(54168);
        if (this.f1916e) {
            this.f1917f.getView().setScrollBarStyle(i2);
            AppMethodBeat.o(54168);
            return;
        }
        this.f1918g.setScrollBarStyle(i2);
        AppMethodBeat.o(54168);
    }

    public void setHorizontalScrollbarOverlay(boolean z2) {
        AppMethodBeat.i(54169);
        if (!this.f1916e) {
            this.f1918g.setHorizontalScrollbarOverlay(z2);
            AppMethodBeat.o(54169);
            return;
        }
        this.f1917f.setHorizontalScrollbarOverlay(z2);
        AppMethodBeat.o(54169);
    }

    public void setVerticalScrollbarOverlay(boolean z2) {
        AppMethodBeat.i(54170);
        if (!this.f1916e) {
            this.f1918g.setVerticalScrollbarOverlay(z2);
            AppMethodBeat.o(54170);
            return;
        }
        this.f1917f.setVerticalScrollbarOverlay(z2);
        AppMethodBeat.o(54170);
    }

    public boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(54171);
        if (!this.f1916e) {
            boolean overlayHorizontalScrollbar = this.f1918g.overlayHorizontalScrollbar();
            AppMethodBeat.o(54171);
            return overlayHorizontalScrollbar;
        }
        boolean overlayHorizontalScrollbar2 = this.f1917f.overlayHorizontalScrollbar();
        AppMethodBeat.o(54171);
        return overlayHorizontalScrollbar2;
    }

    public boolean overlayVerticalScrollbar() {
        AppMethodBeat.i(54172);
        if (this.f1916e) {
            boolean overlayVerticalScrollbar = this.f1917f.overlayVerticalScrollbar();
            AppMethodBeat.o(54172);
            return overlayVerticalScrollbar;
        }
        boolean overlayVerticalScrollbar2 = this.f1918g.overlayVerticalScrollbar();
        AppMethodBeat.o(54172);
        return overlayVerticalScrollbar2;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        AppMethodBeat.i(54173);
        if (this.f1916e) {
            View view2 = this.f1917f.getView();
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                if (view != this) {
                    view2 = view;
                }
                boolean requestChildRectangleOnScreen = viewGroup.requestChildRectangleOnScreen(view2, rect, z2);
                AppMethodBeat.o(54173);
                return requestChildRectangleOnScreen;
            }
            AppMethodBeat.o(54173);
            return false;
        }
        b bVar = this.f1918g;
        if (view == this) {
            view = this.f1918g;
        }
        boolean requestChildRectangleOnScreen2 = bVar.requestChildRectangleOnScreen(view, rect, z2);
        AppMethodBeat.o(54173);
        return requestChildRectangleOnScreen2;
    }

    public int getWebScrollX() {
        AppMethodBeat.i(54174);
        if (this.f1916e) {
            int scrollX = this.f1917f.getView().getScrollX();
            AppMethodBeat.o(54174);
            return scrollX;
        }
        int scrollX2 = this.f1918g.getScrollX();
        AppMethodBeat.o(54174);
        return scrollX2;
    }

    public int getWebScrollY() {
        AppMethodBeat.i(54175);
        if (this.f1916e) {
            int scrollY = this.f1917f.getView().getScrollY();
            AppMethodBeat.o(54175);
            return scrollY;
        }
        int scrollY2 = this.f1918g.getScrollY();
        AppMethodBeat.o(54175);
        return scrollY2;
    }

    public int getVisibleTitleHeight() {
        AppMethodBeat.i(54176);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "getVisibleTitleHeight");
            if (a2 == null) {
                AppMethodBeat.o(54176);
                return 0;
            }
            int intValue = ((Integer) a2).intValue();
            AppMethodBeat.o(54176);
            return intValue;
        }
        int visibleTitleHeight = this.f1917f.getVisibleTitleHeight();
        AppMethodBeat.o(54176);
        return visibleTitleHeight;
    }

    public SslCertificate getCertificate() {
        AppMethodBeat.i(54177);
        if (!this.f1916e) {
            SslCertificate certificate = this.f1918g.getCertificate();
            AppMethodBeat.o(54177);
            return certificate;
        }
        SslCertificate certificate2 = this.f1917f.getCertificate();
        AppMethodBeat.o(54177);
        return certificate2;
    }

    @Deprecated
    public void setCertificate(SslCertificate sslCertificate) {
        AppMethodBeat.i(54178);
        if (!this.f1916e) {
            this.f1918g.setCertificate(sslCertificate);
            AppMethodBeat.o(54178);
            return;
        }
        this.f1917f.setCertificate(sslCertificate);
        AppMethodBeat.o(54178);
    }

    @Deprecated
    public void savePassword(String str, String str2, String str3) {
        AppMethodBeat.i(54179);
        if (!this.f1916e) {
            k.a(this.f1918g, "savePassword", new Class[]{String.class, String.class, String.class}, str, str2, str3);
            AppMethodBeat.o(54179);
            return;
        }
        this.f1917f.savePassword(str, str2, str3);
        AppMethodBeat.o(54179);
    }

    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(54180);
        if (!this.f1916e) {
            this.f1918g.setHttpAuthUsernamePassword(str, str2, str3, str4);
            AppMethodBeat.o(54180);
            return;
        }
        this.f1917f.setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(54180);
    }

    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(54181);
        if (!this.f1916e) {
            String[] httpAuthUsernamePassword = this.f1918g.getHttpAuthUsernamePassword(str, str2);
            AppMethodBeat.o(54181);
            return httpAuthUsernamePassword;
        }
        String[] httpAuthUsernamePassword2 = this.f1917f.getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(54181);
        return httpAuthUsernamePassword2;
    }

    public void tbsWebviewDestroy(boolean z2) {
        boolean z3;
        Bundle sdkQBStatisticsInfo;
        AppMethodBeat.i(54182);
        if (!this.k && this.f1914a != 0) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.f1916e && (sdkQBStatisticsInfo = this.f1917f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                str = sdkQBStatisticsInfo.getString(TPDownloadProxyEnum.USER_GUID);
                str2 = sdkQBStatisticsInfo.getString("qua2");
                str3 = sdkQBStatisticsInfo.getString("lc");
            }
            if (TbsConfig.APP_QZONE.equals(this.f1920i.getApplicationInfo().packageName)) {
                int d2 = d(this.f1920i);
                if (d2 == -1) {
                    d2 = this.f1914a;
                }
                this.f1914a = d2;
                e(this.f1920i);
            }
            TbsLog.d("sdkreport", "webview.destroy--Pv=" + this.f1914a);
            try {
                z3 = this.f1917f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsWebviewDestroy", "exception: ".concat(String.valueOf(th)));
                z3 = false;
            }
            com.tencent.smtt.sdk.c.b.a(this.f1920i, str, str2, str3, this.f1914a, this.f1916e, i(), z3);
            this.f1914a = 0;
            this.k = false;
        }
        if (!this.f1916e) {
            try {
                Class<?> cls = Class.forName("android.webkit.WebViewClassic");
                Method method = cls.getMethod("fromWebView", android.webkit.WebView.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, this.f1918g);
                if (invoke != null) {
                    Field declaredField = cls.getDeclaredField("mListBoxDialog");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(invoke);
                    if (obj != null) {
                        Dialog dialog = (Dialog) obj;
                        dialog.setOnCancelListener(null);
                        Class<?> cls2 = Class.forName("android.app.Dialog");
                        Field declaredField2 = cls2.getDeclaredField("CANCEL");
                        declaredField2.setAccessible(true);
                        int intValue = ((Integer) declaredField2.get(dialog)).intValue();
                        Field declaredField3 = cls2.getDeclaredField("mListenersHandler");
                        declaredField3.setAccessible(true);
                        ((Handler) declaredField3.get(dialog)).removeMessages(intValue);
                    }
                }
            } catch (Exception e2) {
            }
            if (z2) {
                this.f1918g.destroy();
            }
            try {
                Field declaredField4 = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
                declaredField4.setAccessible(true);
                ComponentCallbacks componentCallbacks = (ComponentCallbacks) declaredField4.get(null);
                if (componentCallbacks != null) {
                    declaredField4.set(null, null);
                    Field declaredField5 = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
                    declaredField5.setAccessible(true);
                    Object obj2 = declaredField5.get(null);
                    if (obj2 != null) {
                        List list = (List) obj2;
                        synchronized (list) {
                            try {
                                list.remove(componentCallbacks);
                            } catch (Throwable th2) {
                                AppMethodBeat.o(54182);
                                throw th2;
                            }
                        }
                    }
                }
            } catch (Exception e3) {
            }
        } else if (z2) {
            this.f1917f.destroy();
        }
        TbsLog.i("WebView", "X5 GUID = " + QbSdk.a());
        AppMethodBeat.o(54182);
    }

    public void destroy() {
        AppMethodBeat.i(54183);
        try {
            if ("com.xunmeng.pinduoduo".equals(this.f1920i.getApplicationInfo().packageName)) {
                new Thread("WebviewDestroy") {
                    /* class com.tencent.smtt.sdk.WebView.AnonymousClass3 */

                    public void run() {
                        AppMethodBeat.i(54959);
                        WebView.this.tbsWebviewDestroy(false);
                        AppMethodBeat.o(54959);
                    }
                }.start();
                if (this.f1916e) {
                    this.f1917f.destroy();
                    AppMethodBeat.o(54183);
                    return;
                }
                this.f1918g.destroy();
                AppMethodBeat.o(54183);
                return;
            }
            tbsWebviewDestroy(true);
            AppMethodBeat.o(54183);
        } catch (Throwable th) {
            tbsWebviewDestroy(true);
            AppMethodBeat.o(54183);
        }
    }

    private long i() {
        long j2;
        AppMethodBeat.i(54184);
        synchronized (QbSdk.f1708g) {
            try {
                if (QbSdk.f1705d) {
                    QbSdk.f1707f += System.currentTimeMillis() - QbSdk.f1706e;
                    TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.f1707f);
                }
                j2 = QbSdk.f1707f / 1000;
                QbSdk.f1707f = 0;
                QbSdk.f1706e = System.currentTimeMillis();
            } catch (Throwable th) {
                AppMethodBeat.o(54184);
                throw th;
            }
        }
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime wifiConnectedTime=".concat(String.valueOf(j2)));
        AppMethodBeat.o(54184);
        return j2;
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        AppMethodBeat.i(54185);
        if (!x.a().b()) {
            k.a("android.webkit.WebView", "enablePlatformNotifications");
        }
        AppMethodBeat.o(54185);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        AppMethodBeat.i(54186);
        if (!x.a().b()) {
            k.a("android.webkit.WebView", "disablePlatformNotifications");
        }
        AppMethodBeat.o(54186);
    }

    public void setNetworkAvailable(boolean z2) {
        AppMethodBeat.i(54187);
        if (this.f1916e) {
            this.f1917f.setNetworkAvailable(z2);
        } else if (Build.VERSION.SDK_INT >= 3) {
            this.f1918g.setNetworkAvailable(z2);
            AppMethodBeat.o(54187);
            return;
        }
        AppMethodBeat.o(54187);
    }

    public WebBackForwardList saveState(Bundle bundle) {
        AppMethodBeat.i(54188);
        if (!this.f1916e) {
            WebBackForwardList a2 = WebBackForwardList.a(this.f1918g.saveState(bundle));
            AppMethodBeat.o(54188);
            return a2;
        }
        WebBackForwardList a3 = WebBackForwardList.a(this.f1917f.saveState(bundle));
        AppMethodBeat.o(54188);
        return a3;
    }

    @Deprecated
    public boolean savePicture(Bundle bundle, File file) {
        AppMethodBeat.i(54189);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "savePicture", new Class[]{Bundle.class, File.class}, bundle, file);
            if (a2 == null) {
                AppMethodBeat.o(54189);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54189);
            return booleanValue;
        }
        boolean savePicture = this.f1917f.savePicture(bundle, file);
        AppMethodBeat.o(54189);
        return savePicture;
    }

    @Deprecated
    public boolean restorePicture(Bundle bundle, File file) {
        AppMethodBeat.i(54190);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "restorePicture", new Class[]{Bundle.class, File.class}, bundle, file);
            if (a2 == null) {
                AppMethodBeat.o(54190);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54190);
            return booleanValue;
        }
        boolean restorePicture = this.f1917f.restorePicture(bundle, file);
        AppMethodBeat.o(54190);
        return restorePicture;
    }

    public WebBackForwardList restoreState(Bundle bundle) {
        AppMethodBeat.i(54191);
        if (!this.f1916e) {
            WebBackForwardList a2 = WebBackForwardList.a(this.f1918g.restoreState(bundle));
            AppMethodBeat.o(54191);
            return a2;
        }
        WebBackForwardList a3 = WebBackForwardList.a(this.f1917f.restoreState(bundle));
        AppMethodBeat.o(54191);
        return a3;
    }

    public JSONObject reportInitPerformance(long j2, int i2, long j3, long j4) {
        AppMethodBeat.i(54192);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("IS_X5", this.f1916e);
        } catch (JSONException e2) {
        }
        TbsLog.i("sdkreport", "reportInitPerformance initType is " + j2 + " isX5Core is " + this.f1916e + " isPerformanceDataRecorded" + this.m);
        if (this.f1916e && this.l != null && !this.m) {
            this.l.a("init_type", j2);
            this.l.a("time_oncreate", j3);
            this.l.a("webview_type", (long) i2);
            this.l.a("time_webaccelerator", j4);
            if (this.l.a(this.f1917f.hashCode(), getUrl())) {
                this.m = true;
            }
            try {
                jSONObject.put("DETAIL", this.l.a());
            } catch (JSONException e3) {
            }
        }
        AppMethodBeat.o(54192);
        return jSONObject;
    }

    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(54193);
        if (this.f1916e && this.l != null && !this.m) {
            this.l.a("load_url_gap", (byte) 2);
        }
        if (str == null || showDebugView(str)) {
            AppMethodBeat.o(54193);
            return;
        }
        if (this.f1916e) {
            this.f1917f.loadUrl(str, map);
        } else if (Build.VERSION.SDK_INT >= 8) {
            this.f1918g.loadUrl(str, map);
            AppMethodBeat.o(54193);
            return;
        }
        AppMethodBeat.o(54193);
    }

    public void loadUrl(String str) {
        AppMethodBeat.i(54194);
        if (this.f1916e && this.l != null && !this.m) {
            this.l.a("load_url_gap", (byte) 2);
        }
        if (str == null || showDebugView(str)) {
            AppMethodBeat.o(54194);
        } else if (!this.f1916e) {
            this.f1918g.loadUrl(str);
            AppMethodBeat.o(54194);
        } else {
            this.f1917f.loadUrl(str);
            AppMethodBeat.o(54194);
        }
    }

    @SuppressLint({"NewApi"})
    public boolean showDebugView(String str) {
        AppMethodBeat.i(54195);
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("http://debugtbs.qq.com")) {
            getView().setVisibility(4);
            d.a(this.f1920i).a(lowerCase, this, this.f1920i, o.a().getLooper());
            AppMethodBeat.o(54195);
            return true;
        } else if (!lowerCase.startsWith("http://debugx5.qq.com")) {
            AppMethodBeat.o(54195);
            return false;
        } else if (!this.f1916e) {
            loadDataWithBaseURL(null, "<!DOCTYPE html><html><body>" + "<head>" + "<title>无法打开debugx5</title>" + "<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />" + "</head>" + "<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />" + "尝试<a href=\"http://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>" + "</body></html>", "text/html", ProtocolPackage.ServerEncoding, null);
            AppMethodBeat.o(54195);
            return true;
        } else {
            AppMethodBeat.o(54195);
            return false;
        }
    }

    @TargetApi(5)
    public void postUrl(String str, byte[] bArr) {
        AppMethodBeat.i(54196);
        if (!this.f1916e) {
            this.f1918g.postUrl(str, bArr);
            AppMethodBeat.o(54196);
            return;
        }
        this.f1917f.postUrl(str, bArr);
        AppMethodBeat.o(54196);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(54197);
        if (!this.f1916e) {
            this.f1918g.loadData(str, str2, str3);
            AppMethodBeat.o(54197);
            return;
        }
        this.f1917f.loadData(str, str2, str3);
        AppMethodBeat.o(54197);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(54198);
        if (!this.f1916e) {
            this.f1918g.loadDataWithBaseURL(str, str2, str3, str4, str5);
            AppMethodBeat.o(54198);
            return;
        }
        this.f1917f.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(54198);
    }

    @TargetApi(11)
    public void saveWebArchive(String str) {
        AppMethodBeat.i(54199);
        if (this.f1916e) {
            this.f1917f.saveWebArchive(str);
        } else if (Build.VERSION.SDK_INT >= 11) {
            k.a(this.f1918g, "saveWebArchive", new Class[]{String.class}, str);
            AppMethodBeat.o(54199);
            return;
        }
        AppMethodBeat.o(54199);
    }

    @TargetApi(11)
    public void saveWebArchive(String str, boolean z2, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(54200);
        if (this.f1916e) {
            this.f1917f.saveWebArchive(str, z2, valueCallback);
        } else if (Build.VERSION.SDK_INT >= 11) {
            k.a(this.f1918g, "saveWebArchive", new Class[]{String.class, Boolean.TYPE, ValueCallback.class}, str, Boolean.valueOf(z2), valueCallback);
            AppMethodBeat.o(54200);
            return;
        }
        AppMethodBeat.o(54200);
    }

    public void stopLoading() {
        AppMethodBeat.i(54201);
        if (!this.f1916e) {
            this.f1918g.stopLoading();
            AppMethodBeat.o(54201);
            return;
        }
        this.f1917f.stopLoading();
        AppMethodBeat.o(54201);
    }

    public static void setWebContentsDebuggingEnabled(boolean z2) {
        AppMethodBeat.i(54202);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", Boolean.TYPE);
                    p = declaredMethod;
                    if (declaredMethod != null) {
                        p.setAccessible(true);
                        p.invoke(null, Boolean.valueOf(z2));
                    }
                    AppMethodBeat.o(54202);
                    return;
                } catch (Exception e2) {
                    TbsLog.e("QbSdk", "Exception:" + e2.getStackTrace());
                }
            }
            AppMethodBeat.o(54202);
            return;
        }
        TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().setWebContentsDebuggingEnabled(z2);
        AppMethodBeat.o(54202);
    }

    public void reload() {
        AppMethodBeat.i(54203);
        if (!this.f1916e) {
            this.f1918g.reload();
            AppMethodBeat.o(54203);
            return;
        }
        this.f1917f.reload();
        AppMethodBeat.o(54203);
    }

    public boolean canGoBack() {
        AppMethodBeat.i(54204);
        if (!this.f1916e) {
            boolean canGoBack = this.f1918g.canGoBack();
            AppMethodBeat.o(54204);
            return canGoBack;
        }
        boolean canGoBack2 = this.f1917f.canGoBack();
        AppMethodBeat.o(54204);
        return canGoBack2;
    }

    public void goBack() {
        AppMethodBeat.i(54205);
        if (!this.f1916e) {
            this.f1918g.goBack();
            AppMethodBeat.o(54205);
            return;
        }
        this.f1917f.goBack();
        AppMethodBeat.o(54205);
    }

    public boolean canGoForward() {
        AppMethodBeat.i(54206);
        if (!this.f1916e) {
            boolean canGoForward = this.f1918g.canGoForward();
            AppMethodBeat.o(54206);
            return canGoForward;
        }
        boolean canGoForward2 = this.f1917f.canGoForward();
        AppMethodBeat.o(54206);
        return canGoForward2;
    }

    public void goForward() {
        AppMethodBeat.i(54207);
        if (!this.f1916e) {
            this.f1918g.goForward();
            AppMethodBeat.o(54207);
            return;
        }
        this.f1917f.goForward();
        AppMethodBeat.o(54207);
    }

    public boolean canGoBackOrForward(int i2) {
        AppMethodBeat.i(54208);
        if (!this.f1916e) {
            boolean canGoBackOrForward = this.f1918g.canGoBackOrForward(i2);
            AppMethodBeat.o(54208);
            return canGoBackOrForward;
        }
        boolean canGoBackOrForward2 = this.f1917f.canGoBackOrForward(i2);
        AppMethodBeat.o(54208);
        return canGoBackOrForward2;
    }

    public void goBackOrForward(int i2) {
        AppMethodBeat.i(54209);
        if (!this.f1916e) {
            this.f1918g.goBackOrForward(i2);
            AppMethodBeat.o(54209);
            return;
        }
        this.f1917f.goBackOrForward(i2);
        AppMethodBeat.o(54209);
    }

    public boolean pageUp(boolean z2) {
        AppMethodBeat.i(54210);
        if (!this.f1916e) {
            boolean pageUp = this.f1918g.pageUp(z2);
            AppMethodBeat.o(54210);
            return pageUp;
        }
        boolean pageUp2 = this.f1917f.pageUp(z2, -1);
        AppMethodBeat.o(54210);
        return pageUp2;
    }

    public boolean pageDown(boolean z2) {
        AppMethodBeat.i(54211);
        if (!this.f1916e) {
            boolean pageDown = this.f1918g.pageDown(z2);
            AppMethodBeat.o(54211);
            return pageDown;
        }
        boolean pageDown2 = this.f1917f.pageDown(z2, -1);
        AppMethodBeat.o(54211);
        return pageDown2;
    }

    @Deprecated
    public void clearView() {
        AppMethodBeat.i(54212);
        if (!this.f1916e) {
            k.a(this.f1918g, "clearView");
            AppMethodBeat.o(54212);
            return;
        }
        this.f1917f.clearView();
        AppMethodBeat.o(54212);
    }

    @Deprecated
    public Picture capturePicture() {
        AppMethodBeat.i(54213);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "capturePicture");
            if (a2 == null) {
                AppMethodBeat.o(54213);
                return null;
            }
            Picture picture = (Picture) a2;
            AppMethodBeat.o(54213);
            return picture;
        }
        Picture capturePicture = this.f1917f.capturePicture();
        AppMethodBeat.o(54213);
        return capturePicture;
    }

    @Deprecated
    public float getScale() {
        AppMethodBeat.i(54214);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "getScale");
            if (a2 == null) {
                AppMethodBeat.o(54214);
                return 0.0f;
            }
            float floatValue = ((Float) a2).floatValue();
            AppMethodBeat.o(54214);
            return floatValue;
        }
        float scale = this.f1917f.getScale();
        AppMethodBeat.o(54214);
        return scale;
    }

    public void setInitialScale(int i2) {
        AppMethodBeat.i(54215);
        if (!this.f1916e) {
            this.f1918g.setInitialScale(i2);
            AppMethodBeat.o(54215);
            return;
        }
        this.f1917f.setInitialScale(i2);
        AppMethodBeat.o(54215);
    }

    public void invokeZoomPicker() {
        AppMethodBeat.i(54216);
        if (!this.f1916e) {
            this.f1918g.invokeZoomPicker();
            AppMethodBeat.o(54216);
            return;
        }
        this.f1917f.invokeZoomPicker();
        AppMethodBeat.o(54216);
    }

    public HitTestResult getHitTestResult() {
        AppMethodBeat.i(54217);
        if (!this.f1916e) {
            HitTestResult hitTestResult = new HitTestResult(this.f1918g.getHitTestResult());
            AppMethodBeat.o(54217);
            return hitTestResult;
        }
        HitTestResult hitTestResult2 = new HitTestResult(this.f1917f.getHitTestResult());
        AppMethodBeat.o(54217);
        return hitTestResult2;
    }

    public IX5WebViewBase.HitTestResult getX5HitTestResult() {
        AppMethodBeat.i(54218);
        if (!this.f1916e) {
            AppMethodBeat.o(54218);
            return null;
        }
        IX5WebViewBase.HitTestResult hitTestResult = this.f1917f.getHitTestResult();
        AppMethodBeat.o(54218);
        return hitTestResult;
    }

    public void requestFocusNodeHref(Message message) {
        AppMethodBeat.i(54219);
        if (!this.f1916e) {
            this.f1918g.requestFocusNodeHref(message);
            AppMethodBeat.o(54219);
            return;
        }
        this.f1917f.requestFocusNodeHref(message);
        AppMethodBeat.o(54219);
    }

    public void requestImageRef(Message message) {
        AppMethodBeat.i(54220);
        if (!this.f1916e) {
            this.f1918g.requestImageRef(message);
            AppMethodBeat.o(54220);
            return;
        }
        this.f1917f.requestImageRef(message);
        AppMethodBeat.o(54220);
    }

    public String getUrl() {
        AppMethodBeat.i(54221);
        if (!this.f1916e) {
            String url = this.f1918g.getUrl();
            AppMethodBeat.o(54221);
            return url;
        }
        String url2 = this.f1917f.getUrl();
        AppMethodBeat.o(54221);
        return url2;
    }

    @TargetApi(3)
    public String getOriginalUrl() {
        AppMethodBeat.i(54222);
        if (!this.f1916e) {
            String originalUrl = this.f1918g.getOriginalUrl();
            AppMethodBeat.o(54222);
            return originalUrl;
        }
        String originalUrl2 = this.f1917f.getOriginalUrl();
        AppMethodBeat.o(54222);
        return originalUrl2;
    }

    public String getTitle() {
        AppMethodBeat.i(54223);
        if (!this.f1916e) {
            String title = this.f1918g.getTitle();
            AppMethodBeat.o(54223);
            return title;
        }
        String title2 = this.f1917f.getTitle();
        AppMethodBeat.o(54223);
        return title2;
    }

    public Bitmap getFavicon() {
        AppMethodBeat.i(54224);
        if (!this.f1916e) {
            Bitmap favicon = this.f1918g.getFavicon();
            AppMethodBeat.o(54224);
            return favicon;
        }
        Bitmap favicon2 = this.f1917f.getFavicon();
        AppMethodBeat.o(54224);
        return favicon2;
    }

    public static PackageInfo getCurrentWebViewPackage() {
        AppMethodBeat.i(54225);
        if (x.a().b()) {
            AppMethodBeat.o(54225);
            return null;
        } else if (Build.VERSION.SDK_INT < 26) {
            AppMethodBeat.o(54225);
            return null;
        } else {
            try {
                PackageInfo packageInfo = (PackageInfo) k.a("android.webkit.WebView", "getCurrentWebViewPackage");
                AppMethodBeat.o(54225);
                return packageInfo;
            } catch (Exception e2) {
                AppMethodBeat.o(54225);
                return null;
            }
        }
    }

    public void setRendererPriorityPolicy(int i2, boolean z2) {
        AppMethodBeat.i(54226);
        try {
            if (this.f1916e) {
                AppMethodBeat.o(54226);
            } else if (Build.VERSION.SDK_INT < 26) {
                AppMethodBeat.o(54226);
            } else {
                k.a(this.f1918g, "setRendererPriorityPolicy", new Class[]{Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Boolean.valueOf(z2));
                AppMethodBeat.o(54226);
            }
        } catch (Exception e2) {
            AppMethodBeat.o(54226);
        }
    }

    public int getRendererRequestedPriority() {
        AppMethodBeat.i(54227);
        try {
            if (this.f1916e) {
                AppMethodBeat.o(54227);
                return 0;
            } else if (Build.VERSION.SDK_INT < 26) {
                AppMethodBeat.o(54227);
                return 0;
            } else {
                Object a2 = k.a(this.f1918g, "getRendererRequestedPriority");
                if (a2 == null) {
                    AppMethodBeat.o(54227);
                    return 0;
                }
                int intValue = ((Integer) a2).intValue();
                AppMethodBeat.o(54227);
                return intValue;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(54227);
            return 0;
        }
    }

    public boolean getRendererPriorityWaivedWhenNotVisible() {
        AppMethodBeat.i(54228);
        try {
            if (this.f1916e) {
                AppMethodBeat.o(54228);
                return false;
            } else if (Build.VERSION.SDK_INT < 26) {
                AppMethodBeat.o(54228);
                return false;
            } else {
                Object a2 = k.a(this.f1918g, "getRendererPriorityWaivedWhenNotVisible");
                if (a2 == null) {
                    AppMethodBeat.o(54228);
                    return false;
                }
                boolean booleanValue = ((Boolean) a2).booleanValue();
                AppMethodBeat.o(54228);
                return booleanValue;
            }
        } catch (Exception e2) {
            AppMethodBeat.o(54228);
            return false;
        }
    }

    public WebChromeClient getWebChromeClient() {
        return this.r;
    }

    public WebViewClient getWebViewClient() {
        return this.q;
    }

    public int getProgress() {
        AppMethodBeat.i(54229);
        if (!this.f1916e) {
            int progress = this.f1918g.getProgress();
            AppMethodBeat.o(54229);
            return progress;
        }
        int progress2 = this.f1917f.getProgress();
        AppMethodBeat.o(54229);
        return progress2;
    }

    public int getContentHeight() {
        AppMethodBeat.i(54230);
        if (!this.f1916e) {
            int contentHeight = this.f1918g.getContentHeight();
            AppMethodBeat.o(54230);
            return contentHeight;
        }
        int contentHeight2 = this.f1917f.getContentHeight();
        AppMethodBeat.o(54230);
        return contentHeight2;
    }

    public int getContentWidth() {
        AppMethodBeat.i(54231);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "getContentWidth");
            if (a2 == null) {
                AppMethodBeat.o(54231);
                return 0;
            }
            int intValue = ((Integer) a2).intValue();
            AppMethodBeat.o(54231);
            return intValue;
        }
        int contentWidth = this.f1917f.getContentWidth();
        AppMethodBeat.o(54231);
        return contentWidth;
    }

    public void pauseTimers() {
        AppMethodBeat.i(54232);
        if (!this.f1916e) {
            this.f1918g.pauseTimers();
            AppMethodBeat.o(54232);
            return;
        }
        this.f1917f.pauseTimers();
        AppMethodBeat.o(54232);
    }

    public void resumeTimers() {
        AppMethodBeat.i(54233);
        if (!this.f1916e) {
            this.f1918g.resumeTimers();
            AppMethodBeat.o(54233);
            return;
        }
        this.f1917f.resumeTimers();
        AppMethodBeat.o(54233);
    }

    public void onPause() {
        AppMethodBeat.i(54234);
        if (!this.f1916e) {
            k.a(this.f1918g, "onPause");
            AppMethodBeat.o(54234);
            return;
        }
        this.f1917f.onPause();
        AppMethodBeat.o(54234);
    }

    public void onResume() {
        AppMethodBeat.i(54235);
        if (!this.f1916e) {
            k.a(this.f1918g, "onResume");
            AppMethodBeat.o(54235);
            return;
        }
        this.f1917f.onResume();
        AppMethodBeat.o(54235);
    }

    @Deprecated
    public void freeMemory() {
        AppMethodBeat.i(54236);
        if (!this.f1916e) {
            k.a(this.f1918g, "freeMemory");
            AppMethodBeat.o(54236);
            return;
        }
        this.f1917f.freeMemory();
        AppMethodBeat.o(54236);
    }

    public void clearCache(boolean z2) {
        AppMethodBeat.i(54237);
        if (!this.f1916e) {
            this.f1918g.clearCache(z2);
            AppMethodBeat.o(54237);
            return;
        }
        this.f1917f.clearCache(z2);
        AppMethodBeat.o(54237);
    }

    public void clearFormData() {
        AppMethodBeat.i(54238);
        if (!this.f1916e) {
            this.f1918g.clearFormData();
            AppMethodBeat.o(54238);
            return;
        }
        this.f1917f.clearFormData();
        AppMethodBeat.o(54238);
    }

    public void clearHistory() {
        AppMethodBeat.i(54239);
        if (!this.f1916e) {
            this.f1918g.clearHistory();
            AppMethodBeat.o(54239);
            return;
        }
        this.f1917f.clearHistory();
        AppMethodBeat.o(54239);
    }

    public void clearSslPreferences() {
        AppMethodBeat.i(54240);
        if (!this.f1916e) {
            this.f1918g.clearSslPreferences();
            AppMethodBeat.o(54240);
            return;
        }
        this.f1917f.clearSslPreferences();
        AppMethodBeat.o(54240);
    }

    public WebBackForwardList copyBackForwardList() {
        AppMethodBeat.i(54241);
        if (this.f1916e) {
            WebBackForwardList a2 = WebBackForwardList.a(this.f1917f.copyBackForwardList());
            AppMethodBeat.o(54241);
            return a2;
        }
        WebBackForwardList a3 = WebBackForwardList.a(this.f1918g.copyBackForwardList());
        AppMethodBeat.o(54241);
        return a3;
    }

    @TargetApi(16)
    public void setFindListener(final IX5WebViewBase.FindListener findListener) {
        AppMethodBeat.i(54242);
        if (this.f1916e) {
            this.f1917f.setFindListener(findListener);
        } else if (Build.VERSION.SDK_INT >= 16) {
            this.f1918g.setFindListener(new WebView.FindListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass4 */

                public void onFindResultReceived(int i2, int i3, boolean z) {
                    AppMethodBeat.i(54690);
                    findListener.onFindResultReceived(i2, i3, z);
                    AppMethodBeat.o(54690);
                }
            });
            AppMethodBeat.o(54242);
            return;
        }
        AppMethodBeat.o(54242);
    }

    @TargetApi(3)
    public void findNext(boolean z2) {
        AppMethodBeat.i(54243);
        if (!this.f1916e) {
            this.f1918g.findNext(z2);
            AppMethodBeat.o(54243);
            return;
        }
        this.f1917f.findNext(z2);
        AppMethodBeat.o(54243);
    }

    @Deprecated
    public int findAll(String str) {
        AppMethodBeat.i(54244);
        if (!this.f1916e) {
            Object a2 = k.a(this.f1918g, "findAll", new Class[]{String.class}, str);
            if (a2 == null) {
                AppMethodBeat.o(54244);
                return 0;
            }
            int intValue = ((Integer) a2).intValue();
            AppMethodBeat.o(54244);
            return intValue;
        }
        int findAll = this.f1917f.findAll(str);
        AppMethodBeat.o(54244);
        return findAll;
    }

    public static String findAddress(String str) {
        AppMethodBeat.i(54245);
        if (!x.a().b()) {
            String findAddress = android.webkit.WebView.findAddress(str);
            AppMethodBeat.o(54245);
            return findAddress;
        }
        AppMethodBeat.o(54245);
        return null;
    }

    @TargetApi(16)
    public void findAllAsync(String str) {
        AppMethodBeat.i(54246);
        if (this.f1916e) {
            this.f1917f.findAllAsync(str);
        } else if (Build.VERSION.SDK_INT >= 16) {
            k.a(this.f1918g, "findAllAsync", new Class[]{String.class}, str);
            AppMethodBeat.o(54246);
            return;
        }
        AppMethodBeat.o(54246);
    }

    public boolean showFindDialog(String str, boolean z2) {
        return false;
    }

    @TargetApi(3)
    public void clearMatches() {
        AppMethodBeat.i(54247);
        if (!this.f1916e) {
            this.f1918g.clearMatches();
            AppMethodBeat.o(54247);
            return;
        }
        this.f1917f.clearMatches();
        AppMethodBeat.o(54247);
    }

    public void documentHasImages(Message message) {
        AppMethodBeat.i(54248);
        if (!this.f1916e) {
            this.f1918g.documentHasImages(message);
            AppMethodBeat.o(54248);
            return;
        }
        this.f1917f.documentHasImages(message);
        AppMethodBeat.o(54248);
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        SystemWebViewClient systemWebViewClient = null;
        k kVar = null;
        AppMethodBeat.i(54249);
        if (this.f1916e) {
            IX5WebViewBase iX5WebViewBase = this.f1917f;
            if (webViewClient != null) {
                kVar = new k(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebViewClient(), this, webViewClient);
            }
            iX5WebViewBase.setWebViewClient(kVar);
        } else {
            b bVar = this.f1918g;
            if (webViewClient != null) {
                systemWebViewClient = new SystemWebViewClient(this, webViewClient);
            }
            bVar.setWebViewClient(systemWebViewClient);
        }
        this.q = webViewClient;
        AppMethodBeat.o(54249);
    }

    public void setWebViewCallbackClient(WebViewCallbackClient webViewCallbackClient) {
        AppMethodBeat.i(54250);
        this.mWebViewCallbackClient = webViewCallbackClient;
        if (this.f1916e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("flag", true);
            getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", bundle);
        }
        AppMethodBeat.o(54250);
    }

    public void customDiskCachePathEnabled(boolean z2, String str) {
        AppMethodBeat.i(54251);
        if (this.f1916e && getX5WebViewExtension() != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("enabled", z2);
            bundle.putString("path", str);
            getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", bundle);
        }
        AppMethodBeat.o(54251);
    }

    public void setDownloadListener(final DownloadListener downloadListener) {
        AppMethodBeat.i(54252);
        if (!this.f1916e) {
            this.f1918g.setDownloadListener(new DownloadListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass5 */

                public void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                    AppMethodBeat.i(54352);
                    if (downloadListener == null) {
                        ApplicationInfo applicationInfo = WebView.this.f1920i == null ? null : WebView.this.f1920i.getApplicationInfo();
                        if (applicationInfo == null || !"com.tencent.mm".equals(applicationInfo.packageName)) {
                            c.a(WebView.this.f1920i, str, null, null);
                        }
                        AppMethodBeat.o(54352);
                        return;
                    }
                    downloadListener.onDownloadStart(str, str2, str3, str4, j2);
                    AppMethodBeat.o(54352);
                }
            });
            AppMethodBeat.o(54252);
            return;
        }
        this.f1917f.setDownloadListener(new b(this, downloadListener, this.f1916e));
        AppMethodBeat.o(54252);
    }

    public void setWebChromeClient(WebChromeClient webChromeClient) {
        SystemWebChromeClient systemWebChromeClient = null;
        j jVar = null;
        AppMethodBeat.i(54253);
        if (this.f1916e) {
            IX5WebViewBase iX5WebViewBase = this.f1917f;
            if (webChromeClient != null) {
                jVar = new j(TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().createDefaultX5WebChromeClient(), this, webChromeClient);
            }
            iX5WebViewBase.setWebChromeClient(jVar);
        } else {
            b bVar = this.f1918g;
            if (webChromeClient != null) {
                systemWebChromeClient = new SystemWebChromeClient(this, webChromeClient);
            }
            bVar.setWebChromeClient(systemWebChromeClient);
        }
        this.r = webChromeClient;
        AppMethodBeat.o(54253);
    }

    public void setPictureListener(final PictureListener pictureListener) {
        AppMethodBeat.i(54254);
        if (!this.f1916e) {
            if (pictureListener == null) {
                this.f1918g.setPictureListener(null);
                AppMethodBeat.o(54254);
                return;
            }
            this.f1918g.setPictureListener(new WebView.PictureListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass6 */

                public void onNewPicture(android.webkit.WebView webView, Picture picture) {
                    AppMethodBeat.i(54318);
                    WebView.this.a(webView);
                    pictureListener.onNewPicture(WebView.this, picture);
                    AppMethodBeat.o(54318);
                }
            });
            AppMethodBeat.o(54254);
        } else if (pictureListener == null) {
            this.f1917f.setPictureListener(null);
            AppMethodBeat.o(54254);
        } else {
            this.f1917f.setPictureListener(new IX5WebViewBase.PictureListener() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass7 */

                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
                }

                @Override // com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener
                public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
                    AppMethodBeat.i(54841);
                    WebView.this.a(iX5WebViewBase);
                    pictureListener.onNewPicture(WebView.this, picture);
                    AppMethodBeat.o(54841);
                }
            });
            AppMethodBeat.o(54254);
        }
    }

    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(54255);
        if (!this.f1916e) {
            this.f1918g.addJavascriptInterface(obj, str);
            AppMethodBeat.o(54255);
            return;
        }
        this.f1917f.addJavascriptInterface(obj, str);
        AppMethodBeat.o(54255);
    }

    @TargetApi(11)
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(54256);
        if (!this.f1916e) {
            if (Build.VERSION.SDK_INT >= 11) {
                k.a(this.f1918g, "removeJavascriptInterface", new Class[]{String.class}, str);
                AppMethodBeat.o(54256);
                return;
            }
            this.f1917f.removeJavascriptInterface(str);
        }
        AppMethodBeat.o(54256);
    }

    public WebSettings getSettings() {
        AppMethodBeat.i(54257);
        if (this.f1919h != null) {
            WebSettings webSettings = this.f1919h;
            AppMethodBeat.o(54257);
            return webSettings;
        } else if (this.f1916e) {
            WebSettings webSettings2 = new WebSettings(this.f1917f.getSettings());
            this.f1919h = webSettings2;
            AppMethodBeat.o(54257);
            return webSettings2;
        } else {
            WebSettings webSettings3 = new WebSettings(this.f1918g.getSettings());
            this.f1919h = webSettings3;
            AppMethodBeat.o(54257);
            return webSettings3;
        }
    }

    @Deprecated
    public static synchronized Object getPluginList() {
        Object obj;
        synchronized (WebView.class) {
            AppMethodBeat.i(54258);
            if (!x.a().b()) {
                obj = k.a("android.webkit.WebView", "getPluginList");
                AppMethodBeat.o(54258);
            } else {
                obj = null;
                AppMethodBeat.o(54258);
            }
        }
        return obj;
    }

    @Deprecated
    public void refreshPlugins(boolean z2) {
        AppMethodBeat.i(54259);
        if (!this.f1916e) {
            k.a(this.f1918g, "refreshPlugins", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
            AppMethodBeat.o(54259);
            return;
        }
        this.f1917f.refreshPlugins(z2);
        AppMethodBeat.o(54259);
    }

    @Deprecated
    public void setMapTrackballToArrowKeys(boolean z2) {
        AppMethodBeat.i(54260);
        if (!this.f1916e) {
            k.a(this.f1918g, "setMapTrackballToArrowKeys", new Class[]{Boolean.TYPE}, Boolean.valueOf(z2));
            AppMethodBeat.o(54260);
            return;
        }
        this.f1917f.setMapTrackballToArrowKeys(z2);
        AppMethodBeat.o(54260);
    }

    public void flingScroll(int i2, int i3) {
        AppMethodBeat.i(54261);
        if (!this.f1916e) {
            this.f1918g.flingScroll(i2, i3);
            AppMethodBeat.o(54261);
            return;
        }
        this.f1917f.flingScroll(i2, i3);
        AppMethodBeat.o(54261);
    }

    @Deprecated
    public View getZoomControls() {
        AppMethodBeat.i(54262);
        if (!this.f1916e) {
            View view = (View) k.a(this.f1918g, "getZoomControls");
            AppMethodBeat.o(54262);
            return view;
        }
        View zoomControls = this.f1917f.getZoomControls();
        AppMethodBeat.o(54262);
        return zoomControls;
    }

    @Deprecated
    public boolean canZoomIn() {
        AppMethodBeat.i(54263);
        if (this.f1916e) {
            boolean canZoomIn = this.f1917f.canZoomIn();
            AppMethodBeat.o(54263);
            return canZoomIn;
        } else if (Build.VERSION.SDK_INT >= 11) {
            Object a2 = k.a(this.f1918g, "canZoomIn");
            if (a2 == null) {
                AppMethodBeat.o(54263);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54263);
            return booleanValue;
        } else {
            AppMethodBeat.o(54263);
            return false;
        }
    }

    public boolean isPrivateBrowsingEnabled() {
        AppMethodBeat.i(54264);
        if (this.f1916e) {
            boolean isPrivateBrowsingEnable = this.f1917f.isPrivateBrowsingEnable();
            AppMethodBeat.o(54264);
            return isPrivateBrowsingEnable;
        } else if (Build.VERSION.SDK_INT >= 11) {
            Object a2 = k.a(this.f1918g, "isPrivateBrowsingEnabled");
            if (a2 == null) {
                AppMethodBeat.o(54264);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54264);
            return booleanValue;
        } else {
            AppMethodBeat.o(54264);
            return false;
        }
    }

    @Deprecated
    public boolean canZoomOut() {
        AppMethodBeat.i(54265);
        if (this.f1916e) {
            boolean canZoomOut = this.f1917f.canZoomOut();
            AppMethodBeat.o(54265);
            return canZoomOut;
        } else if (Build.VERSION.SDK_INT >= 11) {
            Object a2 = k.a(this.f1918g, "canZoomOut");
            if (a2 == null) {
                AppMethodBeat.o(54265);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54265);
            return booleanValue;
        } else {
            AppMethodBeat.o(54265);
            return false;
        }
    }

    public boolean zoomIn() {
        AppMethodBeat.i(54266);
        if (!this.f1916e) {
            boolean zoomIn = this.f1918g.zoomIn();
            AppMethodBeat.o(54266);
            return zoomIn;
        }
        boolean zoomIn2 = this.f1917f.zoomIn();
        AppMethodBeat.o(54266);
        return zoomIn2;
    }

    public boolean zoomOut() {
        AppMethodBeat.i(54267);
        if (!this.f1916e) {
            boolean zoomOut = this.f1918g.zoomOut();
            AppMethodBeat.o(54267);
            return zoomOut;
        }
        boolean zoomOut2 = this.f1917f.zoomOut();
        AppMethodBeat.o(54267);
        return zoomOut2;
    }

    public void dumpViewHierarchyWithProperties(BufferedWriter bufferedWriter, int i2) {
        AppMethodBeat.i(54268);
        if (!this.f1916e) {
            k.a(this.f1918g, "dumpViewHierarchyWithProperties", new Class[]{BufferedWriter.class, Integer.TYPE}, bufferedWriter, Integer.valueOf(i2));
            AppMethodBeat.o(54268);
            return;
        }
        this.f1917f.dumpViewHierarchyWithProperties(bufferedWriter, i2);
        AppMethodBeat.o(54268);
    }

    public View findHierarchyView(String str, int i2) {
        AppMethodBeat.i(54269);
        if (!this.f1916e) {
            View view = (View) k.a(this.f1918g, "findHierarchyView", new Class[]{String.class, Integer.TYPE}, str, Integer.valueOf(i2));
            AppMethodBeat.o(54269);
            return view;
        }
        View findHierarchyView = this.f1917f.findHierarchyView(str, i2);
        AppMethodBeat.o(54269);
        return findHierarchyView;
    }

    public void computeScroll() {
        AppMethodBeat.i(54270);
        if (!this.f1916e) {
            this.f1918g.computeScroll();
            AppMethodBeat.o(54270);
            return;
        }
        this.f1917f.computeScroll();
        AppMethodBeat.o(54270);
    }

    public void setBackgroundColor(int i2) {
        AppMethodBeat.i(54271);
        if (!this.f1916e) {
            this.f1918g.setBackgroundColor(i2);
        } else {
            this.f1917f.setBackgroundColor(i2);
        }
        super.setBackgroundColor(i2);
        AppMethodBeat.o(54271);
    }

    public View getView() {
        AppMethodBeat.i(54272);
        if (!this.f1916e) {
            b bVar = this.f1918g;
            AppMethodBeat.o(54272);
            return bVar;
        }
        View view = this.f1917f.getView();
        AppMethodBeat.o(54272);
        return view;
    }

    /* access modifiers changed from: protected */
    public void a() {
        boolean z2;
        Bundle sdkQBStatisticsInfo;
        AppMethodBeat.i(54273);
        if (!this.k && this.f1914a != 0) {
            this.k = true;
            String str = "";
            String str2 = "";
            String str3 = "";
            if (this.f1916e && (sdkQBStatisticsInfo = this.f1917f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                str = sdkQBStatisticsInfo.getString(TPDownloadProxyEnum.USER_GUID);
                str2 = sdkQBStatisticsInfo.getString("qua2");
                str3 = sdkQBStatisticsInfo.getString("lc");
            }
            if (TbsConfig.APP_QZONE.equals(this.f1920i.getApplicationInfo().packageName)) {
                int d2 = d(this.f1920i);
                if (d2 == -1) {
                    d2 = this.f1914a;
                }
                this.f1914a = d2;
                e(this.f1920i);
            }
            TbsLog.d("sdkreport", "webview.onDetachedFromWindow--Pv=" + this.f1914a);
            try {
                z2 = this.f1917f.getX5WebViewExtension().isX5CoreSandboxMode();
            } catch (Throwable th) {
                TbsLog.w("tbsOnDetachedFromWindow", "exception: ".concat(String.valueOf(th)));
                z2 = false;
            }
            com.tencent.smtt.sdk.c.b.a(this.f1920i, str, str2, str3, this.f1914a, this.f1916e, i(), z2);
            this.f1914a = 0;
            this.k = false;
        }
        super.onDetachedFromWindow();
        AppMethodBeat.o(54273);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(54274);
        try {
            if ("com.xunmeng.pinduoduo".equals(this.f1920i.getApplicationInfo().packageName)) {
                new Thread("onDetachedFromWindow") {
                    /* class com.tencent.smtt.sdk.WebView.AnonymousClass8 */

                    public void run() {
                        AppMethodBeat.i(54938);
                        try {
                            WebView.this.a();
                            AppMethodBeat.o(54938);
                        } catch (Exception e2) {
                            AppMethodBeat.o(54938);
                        }
                    }
                }.start();
                AppMethodBeat.o(54274);
                return;
            }
            a();
            AppMethodBeat.o(54274);
        } catch (Throwable th) {
            a();
            AppMethodBeat.o(54274);
        }
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        boolean z2;
        Bundle sdkQBStatisticsInfo;
        AppMethodBeat.i(54275);
        if (this.f1920i == null) {
            super.onVisibilityChanged(view, i2);
            AppMethodBeat.o(54275);
            return;
        }
        if (s == null) {
            s = this.f1920i.getApplicationInfo().packageName;
        }
        if (s == null || (!s.equals("com.tencent.mm") && !s.equals(TbsConfig.APP_QQ))) {
            if (!(i2 == 0 || this.k || this.f1914a == 0)) {
                this.k = true;
                String str = "";
                String str2 = "";
                String str3 = "";
                if (this.f1916e && (sdkQBStatisticsInfo = this.f1917f.getX5WebViewExtension().getSdkQBStatisticsInfo()) != null) {
                    str = sdkQBStatisticsInfo.getString(TPDownloadProxyEnum.USER_GUID);
                    str2 = sdkQBStatisticsInfo.getString("qua2");
                    str3 = sdkQBStatisticsInfo.getString("lc");
                }
                if (TbsConfig.APP_QZONE.equals(this.f1920i.getApplicationInfo().packageName)) {
                    int d2 = d(this.f1920i);
                    if (d2 == -1) {
                        d2 = this.f1914a;
                    }
                    this.f1914a = d2;
                    e(this.f1920i);
                }
                TbsLog.d("sdkreport", "webview.onVisibilityChanged--Pv=" + this.f1914a);
                try {
                    z2 = this.f1917f.getX5WebViewExtension().isX5CoreSandboxMode();
                } catch (Throwable th) {
                    TbsLog.w("onVisibilityChanged", "exception: ".concat(String.valueOf(th)));
                    z2 = false;
                }
                com.tencent.smtt.sdk.c.b.a(this.f1920i, str, str2, str3, this.f1914a, this.f1916e, i(), z2);
                this.f1914a = 0;
                this.k = false;
            }
            super.onVisibilityChanged(view, i2);
            AppMethodBeat.o(54275);
            return;
        }
        super.onVisibilityChanged(view, i2);
        AppMethodBeat.o(54275);
    }

    public IX5WebViewExtension getX5WebViewExtension() {
        AppMethodBeat.i(54276);
        if (!this.f1916e) {
            AppMethodBeat.o(54276);
            return null;
        }
        IX5WebViewExtension x5WebViewExtension = this.f1917f.getX5WebViewExtension();
        AppMethodBeat.o(54276);
        return x5WebViewExtension;
    }

    public IX5WebSettingsExtension getSettingsExtension() {
        AppMethodBeat.i(54277);
        if (!this.f1916e) {
            AppMethodBeat.o(54277);
            return null;
        }
        IX5WebSettingsExtension settingsExtension = this.f1917f.getX5WebViewExtension().getSettingsExtension();
        AppMethodBeat.o(54277);
        return settingsExtension;
    }

    public void setWebViewClientExtension(IX5WebViewClientExtension iX5WebViewClientExtension) {
        AppMethodBeat.i(54278);
        if (!this.f1916e) {
            AppMethodBeat.o(54278);
            return;
        }
        this.f1917f.getX5WebViewExtension().setWebViewClientExtension(iX5WebViewClientExtension);
        AppMethodBeat.o(54278);
    }

    public void setWebChromeClientExtension(IX5WebChromeClientExtension iX5WebChromeClientExtension) {
        AppMethodBeat.i(54279);
        if (!this.f1916e) {
            AppMethodBeat.o(54279);
            return;
        }
        this.f1917f.getX5WebViewExtension().setWebChromeClientExtension(iX5WebChromeClientExtension);
        AppMethodBeat.o(54279);
    }

    public IX5WebChromeClientExtension getWebChromeClientExtension() {
        AppMethodBeat.i(54280);
        if (!this.f1916e) {
            AppMethodBeat.o(54280);
            return null;
        }
        IX5WebChromeClientExtension webChromeClientExtension = this.f1917f.getX5WebViewExtension().getWebChromeClientExtension();
        AppMethodBeat.o(54280);
        return webChromeClientExtension;
    }

    public IX5WebViewClientExtension getWebViewClientExtension() {
        AppMethodBeat.i(54281);
        if (!this.f1916e) {
            AppMethodBeat.o(54281);
            return null;
        }
        IX5WebViewClientExtension webViewClientExtension = this.f1917f.getX5WebViewExtension().getWebViewClientExtension();
        AppMethodBeat.o(54281);
        return webViewClientExtension;
    }

    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(54282);
        if (this.f1916e) {
            try {
                Method a2 = k.a(this.f1917f.getView(), "evaluateJavascript", String.class, ValueCallback.class);
                a2.setAccessible(true);
                a2.invoke(this.f1917f.getView(), str, valueCallback);
                AppMethodBeat.o(54282);
            } catch (Exception e2) {
                loadUrl(str);
                AppMethodBeat.o(54282);
            }
        } else {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", String.class, ValueCallback.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f1918g, str, valueCallback);
                    AppMethodBeat.o(54282);
                    return;
                } catch (Exception e3) {
                }
            }
            AppMethodBeat.o(54282);
        }
    }

    public static int getTbsCoreVersion(Context context) {
        AppMethodBeat.i(54283);
        int tbsVersion = QbSdk.getTbsVersion(context);
        AppMethodBeat.o(54283);
        return tbsVersion;
    }

    public static int getTbsSDKVersion(Context context) {
        return TbsConfig.TBS_SDK_VERSIONCODE;
    }

    public boolean setVideoFullScreen(Context context, boolean z2) {
        AppMethodBeat.i(54284);
        if (!context.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader") || this.f1917f == null) {
            AppMethodBeat.o(54284);
            return false;
        }
        Bundle bundle = new Bundle();
        if (z2) {
            bundle.putInt("DefaultVideoScreen", 2);
        } else {
            bundle.putInt("DefaultVideoScreen", 1);
        }
        this.f1917f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", bundle);
        AppMethodBeat.o(54284);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a(android.webkit.WebView webView) {
    }

    /* access modifiers changed from: package-private */
    public android.webkit.WebView b() {
        if (!this.f1916e) {
            return this.f1918g;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(IX5WebViewBase iX5WebViewBase) {
        this.f1917f = iX5WebViewBase;
    }

    /* access modifiers changed from: package-private */
    public IX5WebViewBase c() {
        return this.f1917f;
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(54285);
        getView().setOnTouchListener(onTouchListener);
        AppMethodBeat.o(54285);
    }

    private void a(AttributeSet attributeSet) {
        AppMethodBeat.i(54286);
        if (attributeSet != null) {
            try {
                int attributeCount = attributeSet.getAttributeCount();
                for (int i2 = 0; i2 < attributeCount; i2++) {
                    if (attributeSet.getAttributeName(i2).equalsIgnoreCase("scrollbars")) {
                        int[] intArray = getResources().getIntArray(16842974);
                        int attributeIntValue = attributeSet.getAttributeIntValue(i2, -1);
                        if (attributeIntValue == intArray[1]) {
                            this.f1917f.getView().setVerticalScrollBarEnabled(false);
                            this.f1917f.getView().setHorizontalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[2]) {
                            this.f1917f.getView().setVerticalScrollBarEnabled(false);
                        } else if (attributeIntValue == intArray[3]) {
                            this.f1917f.getView().setHorizontalScrollBarEnabled(false);
                        }
                    }
                }
            } catch (Exception e2) {
                AppMethodBeat.o(54286);
                return;
            }
        }
        AppMethodBeat.o(54286);
    }

    /* access modifiers changed from: package-private */
    public class b extends android.webkit.WebView {
        public b(WebView webView, Context context) {
            this(context, null);
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(54510);
            if (!QbSdk.getIsSysWebViewForcedByOuter() || !TbsShareManager.isThirdPartyApp(context)) {
                CookieSyncManager.createInstance(WebView.this.f1920i).startSync();
                try {
                    Method declaredMethod = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
                    declaredMethod.setAccessible(true);
                    ((Handler) declaredMethod.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
                    WebView.mSysWebviewCreated = true;
                    AppMethodBeat.o(54510);
                    return;
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(54510);
        }

        public void invalidate() {
            AppMethodBeat.i(54511);
            super.invalidate();
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.invalidate();
            }
            AppMethodBeat.o(54511);
        }

        public WebSettings getSettings() {
            AppMethodBeat.i(54512);
            try {
                WebSettings settings = super.getSettings();
                AppMethodBeat.o(54512);
                return settings;
            } catch (Exception e2) {
                AppMethodBeat.o(54512);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onScrollChanged(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(54513);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onScrollChanged(i2, i3, i4, i5, this);
                AppMethodBeat.o(54513);
                return;
            }
            super.onScrollChanged(i2, i3, i4, i5);
            WebView.b(WebView.this, i2, i3, i4, i5);
            AppMethodBeat.o(54513);
        }

        public void a(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(54514);
            super.onScrollChanged(i2, i3, i4, i5);
            AppMethodBeat.o(54514);
        }

        public void computeScroll() {
            AppMethodBeat.i(54515);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.computeScroll(this);
                AppMethodBeat.o(54515);
                return;
            }
            super.computeScroll();
            AppMethodBeat.o(54515);
        }

        public void a() {
            AppMethodBeat.i(54516);
            super.computeScroll();
            AppMethodBeat.o(54516);
        }

        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(54517);
            if (!hasFocus()) {
                requestFocus();
            }
            new StringBuilder("SystemWebView - onTouchEvent:").append(motionEvent);
            if (WebView.this.mWebViewCallbackClient != null) {
                boolean onTouchEvent = WebView.this.mWebViewCallbackClient.onTouchEvent(motionEvent, this);
                AppMethodBeat.o(54517);
                return onTouchEvent;
            }
            try {
                boolean onTouchEvent2 = super.onTouchEvent(motionEvent);
                AppMethodBeat.o(54517);
                return onTouchEvent2;
            } catch (Exception e2) {
                AppMethodBeat.o(54517);
                return false;
            }
        }

        public boolean a(MotionEvent motionEvent) {
            AppMethodBeat.i(54518);
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(54518);
            return onTouchEvent;
        }

        /* access modifiers changed from: protected */
        public void dispatchDraw(Canvas canvas) {
            AppMethodBeat.i(54519);
            try {
                super.dispatchDraw(canvas);
                if (!WebView.z && WebView.y != null) {
                    canvas.save();
                    canvas.drawPaint(WebView.y);
                    canvas.restore();
                }
                AppMethodBeat.o(54519);
            } catch (Throwable th) {
                AppMethodBeat.o(54519);
            }
        }

        @TargetApi(9)
        public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
            AppMethodBeat.i(54520);
            if (WebView.this.mWebViewCallbackClient != null) {
                boolean overScrollBy = WebView.this.mWebViewCallbackClient.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, this);
                AppMethodBeat.o(54520);
                return overScrollBy;
            } else if (Build.VERSION.SDK_INT >= 9) {
                boolean overScrollBy2 = super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
                AppMethodBeat.o(54520);
                return overScrollBy2;
            } else {
                AppMethodBeat.o(54520);
                return false;
            }
        }

        @TargetApi(9)
        public boolean a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
            AppMethodBeat.i(54521);
            if (Build.VERSION.SDK_INT >= 9) {
                boolean overScrollBy = super.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
                AppMethodBeat.o(54521);
                return overScrollBy;
            }
            AppMethodBeat.o(54521);
            return false;
        }

        @TargetApi(9)
        public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(54522);
            if (WebView.this.mWebViewCallbackClient != null) {
                WebView.this.mWebViewCallbackClient.onOverScrolled(i2, i3, z, z2, this);
                AppMethodBeat.o(54522);
                return;
            }
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i2, i3, z, z2);
            }
            AppMethodBeat.o(54522);
        }

        @TargetApi(9)
        public void a(int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(54523);
            if (Build.VERSION.SDK_INT >= 9) {
                super.onOverScrolled(i2, i3, z, z2);
            }
            AppMethodBeat.o(54523);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(54524);
            if (WebView.this.mWebViewCallbackClient != null) {
                boolean dispatchTouchEvent = WebView.this.mWebViewCallbackClient.dispatchTouchEvent(motionEvent, this);
                AppMethodBeat.o(54524);
                return dispatchTouchEvent;
            }
            boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(54524);
            return dispatchTouchEvent2;
        }

        public boolean b(MotionEvent motionEvent) {
            AppMethodBeat.i(54525);
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            AppMethodBeat.o(54525);
            return dispatchTouchEvent;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            AppMethodBeat.i(54526);
            if (WebView.this.mWebViewCallbackClient != null) {
                boolean onInterceptTouchEvent = WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(motionEvent, this);
                AppMethodBeat.o(54526);
                return onInterceptTouchEvent;
            }
            boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(54526);
            return onInterceptTouchEvent2;
        }

        public boolean c(MotionEvent motionEvent) {
            AppMethodBeat.i(54527);
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(54527);
            return onInterceptTouchEvent;
        }

        public void setOverScrollMode(int i2) {
            AppMethodBeat.i(54528);
            try {
                super.setOverScrollMode(i2);
                AppMethodBeat.o(54528);
            } catch (Exception e2) {
                AppMethodBeat.o(54528);
            }
        }
    }

    public void switchNightMode(boolean z2) {
        AppMethodBeat.i(54287);
        if (z2 == z) {
            AppMethodBeat.o(54287);
            return;
        }
        z = z2;
        if (z2) {
            TbsLog.e("QB_SDK", "deleteNightMode");
            loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
            AppMethodBeat.o(54287);
            return;
        }
        TbsLog.e("QB_SDK", "nightMode");
        loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        AppMethodBeat.o(54287);
    }

    public void switchToNightMode() {
        AppMethodBeat.i(54288);
        TbsLog.e("QB_SDK", "switchToNightMode 01");
        if (!z) {
            TbsLog.e("QB_SDK", "switchToNightMode");
            loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
        }
        AppMethodBeat.o(54288);
    }

    public static synchronized void setSysDayOrNight(boolean z2) {
        synchronized (WebView.class) {
            AppMethodBeat.i(54289);
            if (z2 == z) {
                AppMethodBeat.o(54289);
            } else {
                z = z2;
                if (y == null) {
                    Paint paint = new Paint();
                    y = paint;
                    paint.setColor(NIGHT_MODE_COLOR);
                }
                if (!z2) {
                    if (y.getAlpha() != NIGHT_MODE_ALPHA) {
                        y.setAlpha(NIGHT_MODE_ALPHA);
                        AppMethodBeat.o(54289);
                    }
                } else if (y.getAlpha() != 255) {
                    y.setAlpha(255);
                }
                AppMethodBeat.o(54289);
            }
        }
    }

    public void setDayOrNight(boolean z2) {
        AppMethodBeat.i(54290);
        try {
            if (this.f1916e) {
                getSettingsExtension().setDayOrNight(z2);
            }
            setSysDayOrNight(z2);
            getView().postInvalidate();
            AppMethodBeat.o(54290);
        } catch (Throwable th) {
            AppMethodBeat.o(54290);
        }
    }

    public void setARModeEnable(boolean z2) {
        AppMethodBeat.i(54291);
        try {
            if (this.f1916e) {
                getSettingsExtension().setARModeEnable(z2);
            }
            AppMethodBeat.o(54291);
        } catch (Throwable th) {
            AppMethodBeat.o(54291);
        }
    }

    public boolean isDayMode() {
        return z;
    }

    public int getSysNightModeAlpha() {
        return NIGHT_MODE_ALPHA;
    }

    public void setSysNightModeAlpha(int i2) {
        NIGHT_MODE_ALPHA = i2;
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(54292);
        if (this.B == null) {
            boolean a2 = a(view);
            AppMethodBeat.o(54292);
            return a2;
        } else if (!this.B.onLongClick(view)) {
            boolean a3 = a(view);
            AppMethodBeat.o(54292);
            return a3;
        } else {
            AppMethodBeat.o(54292);
            return true;
        }
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        AppMethodBeat.i(54293);
        if (!this.f1916e) {
            this.f1918g.setOnLongClickListener(onLongClickListener);
            AppMethodBeat.o(54293);
            return;
        }
        View view = this.f1917f.getView();
        try {
            if (this.A == null) {
                Method a2 = k.a(view, "getListenerInfo", new Class[0]);
                a2.setAccessible(true);
                Object invoke = a2.invoke(view, null);
                Field declaredField = invoke.getClass().getDeclaredField("mOnLongClickListener");
                declaredField.setAccessible(true);
                this.A = declaredField.get(invoke);
            }
            this.B = onLongClickListener;
            getView().setOnLongClickListener(this);
            AppMethodBeat.o(54293);
        } catch (Throwable th) {
            AppMethodBeat.o(54293);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0104 A[SYNTHETIC, Splitter:B:34:0x0104] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0134 A[SYNTHETIC, Splitter:B:42:0x0134] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int d(android.content.Context r10) {
        /*
        // Method dump skipped, instructions count: 364
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.WebView.d(android.content.Context):int");
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        String str;
        AppMethodBeat.i(54295);
        int d2 = d(context);
        if (d2 != -1) {
            str = "PV=" + String.valueOf(d2 + 1);
        } else {
            str = "PV=1";
        }
        File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
        try {
            file.getParentFile().mkdirs();
            if (!file.isFile() || !file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            f1912d = fileOutputStream;
            fileOutputStream.write(str.getBytes());
            try {
                TbsLog.d("writetbscorepvfile", "writepvfile finish ");
                if (f1912d != null) {
                    f1912d.flush();
                    AppMethodBeat.o(54295);
                    return;
                }
                AppMethodBeat.o(54295);
            } catch (Throwable th) {
                TbsLog.d("writetbscorepvfile", "file.getAbsolutePath=" + file.getAbsolutePath() + " Throwable=" + th);
                AppMethodBeat.o(54295);
            }
        } catch (Throwable th2) {
            TbsLog.d("writetbscorepvfile", "writepvfile finish ");
            if (f1912d != null) {
                f1912d.flush();
            }
            AppMethodBeat.o(54295);
            throw th2;
        }
    }

    private void e(Context context) {
        AppMethodBeat.i(54296);
        try {
            File file = new File(QbSdk.getTbsFolderDir(context) + File.separator + "core_private", "pv.db");
            if (!file.exists()) {
                AppMethodBeat.o(54296);
                return;
            }
            file.delete();
            AppMethodBeat.o(54296);
        } catch (Exception e2) {
            TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + e2.toString());
            AppMethodBeat.o(54296);
        }
    }

    private boolean a(View view) {
        AppMethodBeat.i(54297);
        if (this.f1920i == null || getTbsCoreVersion(this.f1920i) <= 36200) {
            Object a2 = k.a(this.A, "onLongClick", new Class[]{View.class}, view);
            if (a2 != null) {
                boolean booleanValue = ((Boolean) a2).booleanValue();
                AppMethodBeat.o(54297);
                return booleanValue;
            }
            AppMethodBeat.o(54297);
            return false;
        }
        AppMethodBeat.o(54297);
        return false;
    }

    public void addView(View view) {
        AppMethodBeat.i(54298);
        if (!this.f1916e) {
            this.f1918g.addView(view);
            AppMethodBeat.o(54298);
            return;
        }
        View view2 = this.f1917f.getView();
        try {
            Method a2 = k.a(view2, "addView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
            AppMethodBeat.o(54298);
        } catch (Throwable th) {
            AppMethodBeat.o(54298);
        }
    }

    public void removeView(View view) {
        AppMethodBeat.i(54299);
        if (!this.f1916e) {
            this.f1918g.removeView(view);
            AppMethodBeat.o(54299);
            return;
        }
        View view2 = this.f1917f.getView();
        try {
            Method a2 = k.a(view2, "removeView", View.class);
            a2.setAccessible(true);
            a2.invoke(view2, view);
            AppMethodBeat.o(54299);
        } catch (Throwable th) {
            AppMethodBeat.o(54299);
        }
    }

    public static String getCrashExtraMessage(Context context) {
        boolean z2 = false;
        AppMethodBeat.i(54300);
        if (context == null) {
            AppMethodBeat.o(54300);
            return "";
        }
        String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(context) + ";tbs_sdk_version:43809;";
        if ("com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
            try {
                Class.forName("de.robv.android.xposed.XposedBridge");
                z2 = true;
            } catch (Throwable th) {
            }
        }
        if (z2) {
            String str2 = str + "isXposed=true;";
            AppMethodBeat.o(54300);
            return str2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(g.a(true).e());
        sb.append("\n");
        sb.append(str);
        if (!TbsShareManager.isThirdPartyApp(context) && QbSdk.mSettings != null && QbSdk.mSettings.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) && QbSdk.mSettings.containsKey(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY)) {
            sb.append("\n");
            sb.append("weapp_id:" + QbSdk.mSettings.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_ID_KEY) + ";weapp_name:" + QbSdk.mSettings.get(TbsCoreSettings.TBS_SETTINGS_WEAPP_NAME_KEY) + ";");
        }
        if (sb.length() > 8192) {
            String substring = sb.substring(sb.length() - 8192);
            AppMethodBeat.o(54300);
            return substring;
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(54300);
        return sb2;
    }

    public static boolean getTbsNeedReboot() {
        AppMethodBeat.i(54301);
        d();
        boolean f2 = g.a(true).f();
        TbsLog.d("TbsNeedReboot", "WebView.getTbsNeedReboot--ret = ".concat(String.valueOf(f2)));
        AppMethodBeat.o(54301);
        return f2;
    }

    static void d() {
        AppMethodBeat.i(54302);
        try {
            new Thread(new Runnable() {
                /* class com.tencent.smtt.sdk.WebView.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(54930);
                    if (WebView.f1913j == null) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
                        AppMethodBeat.o(54930);
                        return;
                    }
                    g a2 = g.a(true);
                    if (g.f2051b) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
                        AppMethodBeat.o(54930);
                        return;
                    }
                    n a3 = n.a(WebView.f1913j);
                    int c2 = a3.c();
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = ".concat(String.valueOf(c2)));
                    if (c2 == 2) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
                        a2.a(String.valueOf(a3.b()));
                        a2.b(true);
                        AppMethodBeat.o(54930);
                        return;
                    }
                    int b2 = a3.b("copy_status");
                    TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = ".concat(String.valueOf(b2)));
                    if (b2 == 1) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
                        a2.a(String.valueOf(a3.c("copy_core_ver")));
                        a2.b(true);
                        AppMethodBeat.o(54930);
                        return;
                    }
                    if (!x.a().b() && (c2 == 3 || b2 == 3)) {
                        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
                        a2.a(String.valueOf(g.d()));
                        a2.b(true);
                    }
                    AppMethodBeat.o(54930);
                }
            }).start();
            AppMethodBeat.o(54302);
        } catch (Throwable th) {
            TbsLog.e("webview", "updateRebootStatus excpetion: ".concat(String.valueOf(th)));
            AppMethodBeat.o(54302);
        }
    }

    public void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(54303);
        if (!this.f1916e) {
            this.f1918g.a(i2, i3, i4, i5);
            AppMethodBeat.o(54303);
            return;
        }
        View view = this.f1917f.getView();
        try {
            k.a(view, "super_onScrollChanged", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
            AppMethodBeat.o(54303);
        } catch (Throwable th) {
            AppMethodBeat.o(54303);
        }
    }

    public boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z2) {
        AppMethodBeat.i(54304);
        if (!this.f1916e) {
            boolean a2 = this.f1918g.a(i2, i3, i4, i5, i6, i7, i8, i9, z2);
            AppMethodBeat.o(54304);
            return a2;
        }
        View view = this.f1917f.getView();
        try {
            Object a3 = k.a(view, "super_overScrollBy", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z2));
            if (a3 == null) {
                AppMethodBeat.o(54304);
                return false;
            }
            boolean booleanValue = ((Boolean) a3).booleanValue();
            AppMethodBeat.o(54304);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(54304);
            return false;
        }
    }

    public void super_onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        AppMethodBeat.i(54305);
        if (!this.f1916e) {
            this.f1918g.a(i2, i3, z2, z3);
            AppMethodBeat.o(54305);
            return;
        }
        View view = this.f1917f.getView();
        try {
            k.a(view, "super_onOverScrolled", new Class[]{Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE}, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2), Boolean.valueOf(z3));
            AppMethodBeat.o(54305);
        } catch (Throwable th) {
            AppMethodBeat.o(54305);
        }
    }

    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(54306);
        if (!this.f1916e) {
            boolean b2 = this.f1918g.b(motionEvent);
            AppMethodBeat.o(54306);
            return b2;
        }
        try {
            Object a2 = k.a(this.f1917f.getView(), "super_dispatchTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                AppMethodBeat.o(54306);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54306);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(54306);
            return false;
        }
    }

    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(54307);
        if (!this.f1916e) {
            boolean c2 = this.f1918g.c(motionEvent);
            AppMethodBeat.o(54307);
            return c2;
        }
        try {
            Object a2 = k.a(this.f1917f.getView(), "super_onInterceptTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (a2 == null) {
                AppMethodBeat.o(54307);
                return false;
            }
            boolean booleanValue = ((Boolean) a2).booleanValue();
            AppMethodBeat.o(54307);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(54307);
            return false;
        }
    }

    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(54308);
        if (!this.f1916e) {
            boolean a2 = this.f1918g.a(motionEvent);
            AppMethodBeat.o(54308);
            return a2;
        }
        try {
            Object a3 = k.a(this.f1917f.getView(), "super_onTouchEvent", new Class[]{MotionEvent.class}, motionEvent);
            if (a3 == null) {
                AppMethodBeat.o(54308);
                return false;
            }
            boolean booleanValue = ((Boolean) a3).booleanValue();
            AppMethodBeat.o(54308);
            return booleanValue;
        } catch (Throwable th) {
            AppMethodBeat.o(54308);
            return false;
        }
    }

    public void super_computeScroll() {
        AppMethodBeat.i(54309);
        if (!this.f1916e) {
            this.f1918g.a();
            AppMethodBeat.o(54309);
            return;
        }
        try {
            k.a(this.f1917f.getView(), "super_computeScroll");
            AppMethodBeat.o(54309);
        } catch (Throwable th) {
            AppMethodBeat.o(54309);
        }
    }

    public int getScrollBarDefaultDelayBeforeFade() {
        AppMethodBeat.i(54310);
        if (getView() == null) {
            AppMethodBeat.o(54310);
            return 0;
        }
        int scrollBarDefaultDelayBeforeFade = getView().getScrollBarDefaultDelayBeforeFade();
        AppMethodBeat.o(54310);
        return scrollBarDefaultDelayBeforeFade;
    }

    public int getScrollBarFadeDuration() {
        AppMethodBeat.i(54311);
        if (getView() == null) {
            AppMethodBeat.o(54311);
            return 0;
        }
        int scrollBarFadeDuration = getView().getScrollBarFadeDuration();
        AppMethodBeat.o(54311);
        return scrollBarFadeDuration;
    }

    public int getScrollBarSize() {
        AppMethodBeat.i(54312);
        if (getView() == null) {
            AppMethodBeat.o(54312);
            return 0;
        }
        int scrollBarSize = getView().getScrollBarSize();
        AppMethodBeat.o(54312);
        return scrollBarSize;
    }

    public int getScrollBarStyle() {
        AppMethodBeat.i(54313);
        if (getView() == null) {
            AppMethodBeat.o(54313);
            return 0;
        }
        int scrollBarStyle = getView().getScrollBarStyle();
        AppMethodBeat.o(54313);
        return scrollBarStyle;
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(54314);
        super.setVisibility(i2);
        if (getView() == null) {
            AppMethodBeat.o(54314);
            return;
        }
        getView().setVisibility(i2);
        AppMethodBeat.o(54314);
    }
}
