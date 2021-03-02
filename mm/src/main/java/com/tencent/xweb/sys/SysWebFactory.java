package com.tencent.xweb.sys;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.CookieInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public class SysWebFactory implements l.a {
    private static final String TAG = "XWEB.SysWebFactory";
    static SysWebFactory sInstance;

    public static SysWebFactory getInstance() {
        AppMethodBeat.i(153677);
        if (sInstance == null) {
            ah.htf();
            sInstance = new SysWebFactory();
        }
        SysWebFactory sysWebFactory = sInstance;
        AppMethodBeat.o(153677);
        return sysWebFactory;
    }

    private SysWebFactory() {
    }

    @Override // com.tencent.xweb.internal.l.a
    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.i(153678);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(153678);
        } else if (str.equals("STR_CMD_GET_DEBUG_VIEW") || !str.equals("STR_CMD_GET_UPDATER")) {
            AppMethodBeat.o(153678);
        } else {
            AppMethodBeat.o(153678);
        }
        return null;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebView createWebView(WebView webView) {
        AppMethodBeat.i(153679);
        try {
            e eVar = new e(webView);
            AppMethodBeat.o(153679);
            return eVar;
        } catch (Throwable th) {
            String message = th.getMessage();
            if (message != null && message.contains("Calling View methods on another thread than the UI thread.")) {
                Log.e(TAG, "setNeedEnforceMainLooper=true", th);
                a.htO();
            }
            AppMethodBeat.o(153679);
            throw th;
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initInterface() {
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initEnviroment(Context context) {
    }

    public IJsRuntime getJsCore(JsRuntime.JsRuntimeType jsRuntimeType, Context context) {
        return null;
    }

    @Override // com.tencent.xweb.internal.l.a
    public boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(153680);
        ah.htf();
        a.b(preInitCallback);
        AppMethodBeat.o(153680);
        return true;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.i(153681);
        a.htQ();
        AppMethodBeat.o(153681);
    }

    @Override // com.tencent.xweb.internal.l.a
    public boolean hasInited() {
        AppMethodBeat.i(153682);
        boolean hasInited = a.hasInited();
        AppMethodBeat.o(153682);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        AppMethodBeat.i(153683);
        boolean hasInitedCallback = a.hasInitedCallback();
        AppMethodBeat.o(153683);
        return hasInitedCallback;
    }

    public boolean isCoreReady() {
        return true;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(153684);
        try {
            android.webkit.WebView webView = new android.webkit.WebView(context);
            if (Build.VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
            AppMethodBeat.o(153684);
        } catch (Exception e2) {
            Log.e("SysWebFactory", "clearAllWebViewCache failed " + e2.getMessage());
            AppMethodBeat.o(153684);
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public CookieInternal.ICookieManagerInternal getCookieManager() {
        AppMethodBeat.i(153685);
        if (a.htP()) {
            a aVar = new a();
            AppMethodBeat.o(153685);
            return aVar;
        }
        try {
            CookieInternal.ICookieManagerInternal iCookieManagerInternal = (CookieInternal.ICookieManagerInternal) runOnUiThreadBlocking(new Callable<CookieInternal.ICookieManagerInternal>() {
                /* class com.tencent.xweb.sys.SysWebFactory.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ CookieInternal.ICookieManagerInternal call() {
                    AppMethodBeat.i(153670);
                    CookieManager.getInstance();
                    a aVar = new a();
                    AppMethodBeat.o(153670);
                    return aVar;
                }
            });
            AppMethodBeat.o(153685);
            return iCookieManagerInternal;
        } catch (Exception e2) {
            Log.e(TAG, "getCookieManager", e2);
            a aVar2 = new a();
            AppMethodBeat.o(153685);
            return aVar2;
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager() {
        AppMethodBeat.i(153686);
        if (a.htP()) {
            b bVar = new b();
            AppMethodBeat.o(153686);
            return bVar;
        }
        try {
            CookieInternal.ICookieSyncManagerInternal iCookieSyncManagerInternal = (CookieInternal.ICookieSyncManagerInternal) runOnUiThreadBlocking(new Callable<CookieInternal.ICookieSyncManagerInternal>() {
                /* class com.tencent.xweb.sys.SysWebFactory.AnonymousClass2 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // java.util.concurrent.Callable
                public final /* synthetic */ CookieInternal.ICookieSyncManagerInternal call() {
                    AppMethodBeat.i(153671);
                    CookieSyncManager.createInstance(XWalkEnvironment.getApplicationContext());
                    b bVar = new b();
                    AppMethodBeat.o(153671);
                    return bVar;
                }
            });
            AppMethodBeat.o(153686);
            return iCookieSyncManagerInternal;
        } catch (Exception e2) {
            Log.e(TAG, "getCookieSyncManager", e2);
            b bVar2 = new b();
            AppMethodBeat.o(153686);
            return bVar2;
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebStorage createWebviewStorage() {
        return null;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebViewDatabase getWebViewDatabase() {
        AppMethodBeat.i(207180);
        f fVar = new f();
        AppMethodBeat.o(207180);
        return fVar;
    }

    static class a {
        private static boolean SEh = false;
        private static boolean SEi = false;
        private static Boolean SEj = null;
        private static final AtomicBoolean SEk = new AtomicBoolean(false);

        static {
            AppMethodBeat.i(153676);
            AppMethodBeat.o(153676);
        }

        private static boolean htN() {
            AppMethodBeat.i(183736);
            if (SEj == null) {
                SEj = Boolean.valueOf(XWalkEnvironment.getMMKVSharedPreferences("SysWebFactory.preIniter").getBoolean("isEnforceMainLooper", false));
            }
            boolean booleanValue = SEj.booleanValue();
            AppMethodBeat.o(183736);
            return booleanValue;
        }

        public static void htO() {
            AppMethodBeat.i(183737);
            XWalkEnvironment.getMMKVSharedPreferences("SysWebFactory.preIniter").edit().putBoolean("isEnforceMainLooper", true).apply();
            AppMethodBeat.o(183737);
        }

        public static boolean hasInited() {
            return SEh;
        }

        public static boolean hasInitedCallback() {
            return SEi;
        }

        public static boolean htP() {
            AppMethodBeat.i(153673);
            if (!htN()) {
                AppMethodBeat.o(153673);
                return true;
            }
            boolean z = SEk.get();
            AppMethodBeat.o(153673);
            return z;
        }

        public static synchronized void b(final WebView.PreInitCallback preInitCallback) {
            synchronized (a.class) {
                AppMethodBeat.i(153674);
                if (SEh) {
                    AppMethodBeat.o(153674);
                } else if (!htN()) {
                    SEh = true;
                    if (preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                    }
                    AppMethodBeat.o(153674);
                } else {
                    if (!SEk.get()) {
                        AnonymousClass1 r0 = new Runnable() {
                            /* class com.tencent.xweb.sys.SysWebFactory.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(153672);
                                try {
                                    a.access$000();
                                    boolean unused = a.SEh = true;
                                    if (preInitCallback != null) {
                                        preInitCallback.onCoreInitFinished();
                                    }
                                    AppMethodBeat.o(153672);
                                } catch (UnsatisfiedLinkError e2) {
                                    Log.e("SysWebFactory.preIniter", "link error, may be abi not match, try xweb core");
                                    WebView._initWebviewCore(XWalkEnvironment.getApplicationContext(), WebView.c.WV_KIND_CW, preInitCallback, true);
                                    AppMethodBeat.o(153672);
                                } catch (Exception e3) {
                                    try {
                                        Log.e("SysWebFactory.preIniter", "PathUtils.getDataDirectory = ".concat(String.valueOf(g.oj("org.chromium.base.PathUtils", "getDataDirectory").toString())));
                                    } catch (Exception e4) {
                                        Log.e("SysWebFactory.preIniter", "try reflect to PathUtils failed " + e4.getMessage());
                                    }
                                    Log.e("SysWebFactory.preIniter", "ensureSystemWebViewGlobalLooper failed " + e3.getMessage());
                                    h.s(577, 233, 1);
                                    AppMethodBeat.o(153672);
                                }
                            }
                        };
                        if (Looper.getMainLooper() == Looper.myLooper()) {
                            r0.run();
                            AppMethodBeat.o(153674);
                        } else {
                            new Handler(Looper.getMainLooper()).post(r0);
                        }
                    } else if (preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                        AppMethodBeat.o(153674);
                    }
                    AppMethodBeat.o(153674);
                }
            }
        }

        public static void htQ() {
            SEi = true;
        }

        static /* synthetic */ void access$000() {
            AppMethodBeat.i(153675);
            if (Looper.getMainLooper() != Looper.myLooper()) {
                IllegalStateException illegalStateException = new IllegalStateException("Calling WebView methods on another thread than the UI thread.");
                AppMethodBeat.o(153675);
                throw illegalStateException;
            }
            if (!SEk.getAndSet(true)) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                CookieManager.getInstance();
                CookieSyncManager.createInstance(XWalkEnvironment.getApplicationContext());
                new android.webkit.WebView(XWalkEnvironment.getApplicationContext()).destroy();
                Log.i("SysWebFactory.preIniter", "ensureSystemWebViewGlobalLooper cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + LocaleUtil.MALAY);
            }
            AppMethodBeat.o(153675);
        }
    }

    private static <T> T runOnUiThreadBlocking(Callable<T> callable) {
        AppMethodBeat.i(153687);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            T call = callable.call();
            AppMethodBeat.o(153687);
            return call;
        }
        FutureTask futureTask = new FutureTask(callable);
        new Handler(Looper.getMainLooper()).post(futureTask);
        T t = (T) futureTask.get();
        AppMethodBeat.o(153687);
        return t;
    }
}
