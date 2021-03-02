package com.tencent.xweb.x5;

import android.content.Context;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.X5JsCore;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.CookieInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.e;
import com.tencent.xweb.x5.sdk.f;
import com.tencent.xweb.x5.sdk.g;
import com.tencent.xweb.x5.sdk.i;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtensionListener;

public class X5WebFactory implements l.a {
    private static final String TAG = "MicroMsg.X5WebFactory";
    static X5WebFactory sInstance;
    WebViewExtensionListener mWebViewExtensionListener;

    public static X5WebFactory getInstance() {
        AppMethodBeat.i(153884);
        if (sInstance == null) {
            ah.htf();
            sInstance = new X5WebFactory();
        }
        X5WebFactory x5WebFactory = sInstance;
        AppMethodBeat.o(153884);
        return x5WebFactory;
    }

    private X5WebFactory() {
    }

    @Override // com.tencent.xweb.internal.l.a
    public Object excute(String str, Object[] objArr) {
        AppMethodBeat.i(153885);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(153885);
            return null;
        } else if (str.equals("STR_CMD_GET_TBS_QBSDK_IMP")) {
            e eVar = new e();
            AppMethodBeat.o(153885);
            return eVar;
        } else if (str.equals("STR_CMD_GET_TBS_DOWNLOADER_IMP")) {
            g gVar = new g();
            AppMethodBeat.o(153885);
            return gVar;
        } else {
            AppMethodBeat.o(153885);
            return null;
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebView createWebView(WebView webView) {
        AppMethodBeat.i(153886);
        m mVar = new m(webView);
        AppMethodBeat.o(153886);
        return mVar;
    }

    class a extends TbsLogClient {
        public a(Context context) {
            super(context);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void writeLog(String str) {
            AppMethodBeat.i(153872);
            super.writeLog(str);
            AppMethodBeat.o(153872);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void writeLogToDisk() {
            AppMethodBeat.i(153873);
            super.writeLogToDisk();
            AppMethodBeat.o(153873);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void showLog(String str) {
            AppMethodBeat.i(153874);
            super.showLog(str);
            AppMethodBeat.o(153874);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void setLogView(TextView textView) {
            AppMethodBeat.i(153875);
            super.setLogView(textView);
            AppMethodBeat.o(153875);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void i(String str, String str2) {
            AppMethodBeat.i(153876);
            super.i(str, str2);
            Log.i(str, str2);
            AppMethodBeat.o(153876);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void e(String str, String str2) {
            AppMethodBeat.i(153877);
            super.e(str, str2);
            Log.e(str, str2);
            AppMethodBeat.o(153877);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void w(String str, String str2) {
            AppMethodBeat.i(153878);
            super.w(str, str2);
            Log.w(str, str2);
            AppMethodBeat.o(153878);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void d(String str, String str2) {
            AppMethodBeat.i(153879);
            super.d(str, str2);
            Log.d(str, str2);
            AppMethodBeat.o(153879);
        }

        @Override // com.tencent.smtt.utils.TbsLogClient
        public final void v(String str, String str2) {
            AppMethodBeat.i(153880);
            super.v(str, str2);
            Log.v(str, str2);
            AppMethodBeat.o(153880);
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initInterface() {
        AppMethodBeat.i(153887);
        d.a(new e());
        f.a(new g());
        WebView.setX5Interface(new i());
        AppMethodBeat.o(153887);
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initEnviroment(Context context) {
        AppMethodBeat.i(153888);
        TbsLog.setTbsLogClient(new a(context));
        AppMethodBeat.o(153888);
    }

    public IJsRuntime getJsCore(JsRuntime.JsRuntimeType jsRuntimeType, Context context) {
        AppMethodBeat.i(153889);
        IJsRuntime iJsRuntime = null;
        switch (jsRuntimeType) {
            case RT_TYPE_X5:
                boolean canUseX5JsCore = X5JsCore.canUseX5JsCore(context);
                Log.i(TAG, "canUseX5JsCore : ".concat(String.valueOf(canUseX5JsCore)));
                if (canUseX5JsCore) {
                    if (X5JsCore.canUseX5JsCoreNewAPI(context)) {
                        iJsRuntime = new h(context);
                    } else {
                        iJsRuntime = new f(context);
                    }
                    iJsRuntime.init(0);
                    break;
                }
                break;
        }
        AppMethodBeat.o(153889);
        return iJsRuntime;
    }

    @Override // com.tencent.xweb.internal.l.a
    public boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(153890);
        ah.htf();
        d.disableAutoCreateX5Webview();
        b.a(context, preInitCallback);
        AppMethodBeat.o(153890);
        return true;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        this.mWebViewExtensionListener = webViewExtensionListener;
    }

    public WebViewExtensionListener getExtensionCallback() {
        return this.mWebViewExtensionListener;
    }

    @Override // com.tencent.xweb.internal.l.a
    public boolean hasInited() {
        AppMethodBeat.i(153891);
        boolean hasInited = b.hasInited();
        AppMethodBeat.o(153891);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        return true;
    }

    public boolean isCoreReady() {
        AppMethodBeat.i(153892);
        boolean isCoreReady = b.isCoreReady();
        AppMethodBeat.o(153892);
        return isCoreReady;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void clearAllWebViewCache(Context context, boolean z) {
        AppMethodBeat.i(153893);
        QbSdk.clearAllWebViewCache(context, z);
        AppMethodBeat.o(153893);
    }

    @Override // com.tencent.xweb.internal.l.a
    public CookieInternal.ICookieManagerInternal getCookieManager() {
        AppMethodBeat.i(153894);
        d dVar = new d();
        AppMethodBeat.o(153894);
        return dVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager() {
        AppMethodBeat.i(153895);
        e eVar = new e();
        AppMethodBeat.o(153895);
        return eVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebStorage createWebviewStorage() {
        AppMethodBeat.i(153896);
        l lVar = new l();
        AppMethodBeat.o(153896);
        return lVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebViewDatabase getWebViewDatabase() {
        AppMethodBeat.i(207196);
        n nVar = new n();
        AppMethodBeat.o(207196);
        return nVar;
    }

    static class b {
        private static boolean SEh = false;
        private static boolean SFu = false;

        public static boolean hasInited() {
            return SEh;
        }

        public static boolean isCoreReady() {
            return SFu;
        }

        public static void a(Context context, final WebView.PreInitCallback preInitCallback) {
            AppMethodBeat.i(153883);
            if (SEh) {
                AppMethodBeat.o(153883);
                return;
            }
            Log.i("X5WebFactory.preIniter", "preInit");
            SEh = true;
            QbSdk.preInit(context, new QbSdk.PreInitCallback() {
                /* class com.tencent.xweb.x5.X5WebFactory.b.AnonymousClass1 */
                private boolean SFv = false;
                private boolean SFw = false;

                @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
                public final void onCoreInitFinished() {
                    AppMethodBeat.i(153881);
                    this.SFv = true;
                    if (this.SFv && this.SFw && preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                        boolean unused = b.SFu = true;
                    }
                    AppMethodBeat.o(153881);
                }

                @Override // com.tencent.smtt.sdk.QbSdk.PreInitCallback
                public final void onViewInitFinished(boolean z) {
                    AppMethodBeat.i(153882);
                    this.SFw = true;
                    if (this.SFv && this.SFw && preInitCallback != null) {
                        preInitCallback.onCoreInitFinished();
                        boolean unused = b.SFu = true;
                    }
                    AppMethodBeat.o(153882);
                }
            });
            AppMethodBeat.o(153883);
        }
    }
}
