package com.tencent.xweb.xwalk;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.JsRuntime;
import com.tencent.xweb.WebView;
import com.tencent.xweb.a;
import com.tencent.xweb.ah;
import com.tencent.xweb.internal.CookieInternal;
import com.tencent.xweb.internal.IJsRuntime;
import com.tencent.xweb.internal.IWebStorage;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.IWebViewDatabase;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.s;
import com.tencent.xweb.t;
import com.tencent.xweb.util.h;
import com.tencent.xweb.xwalk.a.k;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.a;
import com.tencent.xweb.xwalk.updater.f;
import org.xwalk.core.Log;
import org.xwalk.core.WebViewExtension;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkCoreWrapper;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkViewDatabase;
import org.xwalk.core.resource.XWalkContextWrapper;

public class XWalkWebFactory implements l.a {
    private static final String TAG = "XWalkWebFactory";
    static XWalkWebFactory sInstance;
    private boolean mIsDebugMode = false;
    private boolean mIsDebugModeReplase = false;

    public static XWalkWebFactory getInstance() {
        AppMethodBeat.i(154485);
        if (sInstance == null) {
            ah.htf();
            sInstance = new XWalkWebFactory();
        }
        XWalkWebFactory xWalkWebFactory = sInstance;
        AppMethodBeat.o(154485);
        return xWalkWebFactory;
    }

    private XWalkWebFactory() {
        AppMethodBeat.i(185205);
        s.a(new a((byte) 0));
        AppMethodBeat.o(185205);
    }

    static class a implements s.a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.xweb.s.a
        public final void cdG() {
        }

        @Override // com.tencent.xweb.s.a
        public final void AN(int i2) {
            AppMethodBeat.i(185202);
            if (i2 == 0) {
                if (!ah.hth()) {
                    AppMethodBeat.o(185202);
                    return;
                }
                int availableVersion = XWalkEnvironment.getAvailableVersion();
                int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
                if (availableVersion <= 0 && installedNewstVersionForCurAbi > 0 && !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.brJ("dis_reinit_web_core"))) {
                    WebView.reinitToXWeb();
                }
            }
            AppMethodBeat.o(185202);
        }

        @Override // com.tencent.xweb.s.a
        public final void AO(int i2) {
        }

        @Override // com.tencent.xweb.s.a
        public final void cdH() {
            AppMethodBeat.i(185203);
            if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("dis_refresh_main_cmd", "tools"))) {
                com.tencent.xweb.a.hsc();
                t.refresh();
                AppMethodBeat.o(185203);
                return;
            }
            Log.i(XWalkWebFactory.TAG, "dis_refresh_main_cmd");
            AppMethodBeat.o(185203);
        }

        @Override // com.tencent.xweb.s.a
        public final void cdI() {
            AppMethodBeat.i(185204);
            if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(com.tencent.xweb.a.nS("dis_refresh_plugin_cmd", "tools"))) {
                com.tencent.xweb.b.hsk();
                AppMethodBeat.o(185204);
                return;
            }
            Log.i(XWalkWebFactory.TAG, "dis_refresh_plugin_cmd");
            AppMethodBeat.o(185204);
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public Object excute(String str, Object[] objArr) {
        k kVar;
        Object bridge;
        AppMethodBeat.i(154486);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(154486);
            return null;
        }
        if (str.equals("STR_CMD_INVOKE_TO_RUNTIME")) {
            if (objArr == null || objArr.length < 2) {
                AppMethodBeat.o(154486);
                return null;
            }
            try {
                if (XWalkCoreWrapper.getInstance() != null) {
                    Object invokeRuntimeChannel = XWalkCoreWrapper.invokeRuntimeChannel(((Integer) objArr[0]).intValue(), (Object[]) objArr[1]);
                    AppMethodBeat.o(154486);
                    return invokeRuntimeChannel;
                }
            } catch (Exception e2) {
                Log.e(TAG, "STR_CMD_INVOKE_TO_RUNTIME failed , err = " + e2.getMessage());
            }
        } else if (str.equals("STR_CMD_EXXCUTE_CMD_FROM_CONFIG")) {
            if (objArr == null || objArr.length <= 0) {
                AppMethodBeat.o(154486);
                return null;
            }
            a.C2230a eM = a.eM(objArr[0]);
            AppMethodBeat.o(154486);
            return eM;
        } else if (str.equals("STR_CMD_GET_DEBUG_VIEW")) {
            d dVar = new d((WebView) objArr[0]);
            AppMethodBeat.o(154486);
            return dVar;
        } else if (str.equals("STR_CMD_GET_UPDATER")) {
            p.a aVar = new p.a();
            AppMethodBeat.o(154486);
            return aVar;
        } else if (str.equals("STR_CMD_GET_PLUGIN_UPDATER")) {
            k kVar2 = new k();
            AppMethodBeat.o(154486);
            return kVar2;
        } else if (str.equals("STR_CMD_CLEAR_SCHEDULER")) {
            Scheduler.Ev(false).hvw();
            Scheduler.Ev(true).hvw();
            AppMethodBeat.o(154486);
            return null;
        } else if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE")) {
            this.mIsDebugMode = true;
            this.mIsDebugModeReplase = true;
        } else if (str.equals("STR_CMD_SET_DEBUG_MODE_NO_REPLACE")) {
            this.mIsDebugMode = true;
            this.mIsDebugModeReplase = false;
        } else if (str.equals("STR_CMD_SET_RECHECK_COMMAND")) {
            try {
                a.b bsS = com.tencent.xweb.xwalk.updater.a.bsS(XWalkEnvironment.getUpdateConfigFullPath());
                if (bsS == null) {
                    XWalkEnvironment.addXWalkInitializeLog("recheck cmds ConfigParser failed ");
                    AppMethodBeat.o(154486);
                    return null;
                }
                com.tencent.xweb.a.a(bsS.SIL, bsS.SIJ, true);
                h.OQ(68);
            } catch (Exception e3) {
                XWalkEnvironment.addXWalkInitializeLog("recheck cmds failed , " + e3.getMessage());
            }
        } else if (str.equals("STR_CMD_SET_DEBUG_MODE_REPLACE_NOW")) {
            tryLoadLocalAssetRuntime((Context) objArr[0], true);
            d.iH((Context) objArr[0]);
        } else if (str.equals("BASE_CONTEXT_CHANGED")) {
            if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof k)) {
                kVar = null;
            } else {
                kVar = (k) objArr[0];
            }
            if (!(kVar == null || XWalkCoreWrapper.getInstance() == null)) {
                if (kVar.SGZ == null) {
                    Log.e("XWWebView", "getXWalkBridge mwebview == null");
                    bridge = null;
                } else {
                    bridge = kVar.SGZ.getBridge();
                }
                XWalkCoreWrapper.getInstance();
                XWalkCoreWrapper.invokeRuntimeChannel(80001, new Object[]{bridge});
            }
        } else if (str.equals("STR_CMD_FEATURE_SUPPORT")) {
            Boolean valueOf = Boolean.valueOf(XWalkCoreWrapper.hasFeatureStatic(((Integer) objArr[0]).intValue()));
            AppMethodBeat.o(154486);
            return valueOf;
        } else if (str.equals("STR_CMD_NATIVE_TRANS_INIT")) {
            if (objArr.length != 1) {
                AppMethodBeat.o(154486);
                return null;
            }
            XWalkCoreWrapper.bindNativeTrans(((Long) objArr[0]).longValue());
        } else if (str.equals("STR_CMD_FORCE_DARK_MODE_COMMAND")) {
            try {
                if (XWalkCoreWrapper.getInstance() != null) {
                    XWalkCoreWrapper.getInstance().getBridgeClass("XWalkSettingsInternal").getDeclaredMethod("setWeChatDefaultForceDarkMode", Boolean.TYPE).invoke(null, Boolean.valueOf(((Boolean) objArr[0]).booleanValue()));
                }
            } catch (Exception e4) {
                Log.e(TAG, "XWalkSettingsInternal setWeChatDefaultForceDarkMode error:" + e4.getMessage());
            }
        } else if (str.equals("STR_CMD_FORCE_DARK_MODE_BEHAVIOR_COMMAND")) {
            try {
                if (XWalkCoreWrapper.getInstance() != null) {
                    XWalkCoreWrapper.getInstance().getBridgeClass("XWalkSettingsInternal").getDeclaredMethod("setWeChatDefaultForceDarkBehavior", Integer.TYPE).invoke(null, Integer.valueOf(((Integer) objArr[0]).intValue()));
                }
            } catch (Exception e5) {
                Log.e(TAG, "XWalkSettingsInternal setWeChatDefaultForceDarkBehavior error:" + e5.getMessage());
            }
        }
        AppMethodBeat.o(154486);
        return null;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebView createWebView(WebView webView) {
        AppMethodBeat.i(154487);
        try {
            if (k.in(webView.getContext())) {
                WebViewExtension.updateExtension(false);
                k kVar = new k(webView);
                AppMethodBeat.o(154487);
                return kVar;
            }
        } catch (Exception e2) {
            String str = "init xwalk crashed:" + e2.getMessage() + ",stacktrace:" + android.util.Log.getStackTraceString(e2);
            Log.e(TAG, str);
            XWalkInitializer.addXWalkInitializeLog(str);
        }
        AppMethodBeat.o(154487);
        return null;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initInterface() {
        AppMethodBeat.i(183744);
        com.tencent.xweb.internal.k.a(WebView.c.WV_KIND_CW, new n());
        AppMethodBeat.o(183744);
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initEnviroment(Context context) {
        AppMethodBeat.i(154488);
        if (this.mIsDebugMode) {
            tryLoadLocalAssetRuntime(context, this.mIsDebugModeReplase);
        }
        AppMethodBeat.o(154488);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x005f A[SYNTHETIC, Splitter:B:27:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0064 A[SYNTHETIC, Splitter:B:30:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0093 A[SYNTHETIC, Splitter:B:48:0x0093] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0098 A[SYNTHETIC, Splitter:B:51:0x0098] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean tryLoadLocalAssetRuntime(android.content.Context r8, boolean r9) {
        /*
        // Method dump skipped, instructions count: 186
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.XWalkWebFactory.tryLoadLocalAssetRuntime(android.content.Context, boolean):boolean");
    }

    public IJsRuntime getJsCore(JsRuntime.JsRuntimeType jsRuntimeType, Context context) {
        i iVar = null;
        AppMethodBeat.i(154490);
        initWebviewCore(context, null);
        switch (jsRuntimeType) {
            case RT_TYPE_J2V8:
            case RT_TYPE_NATIVE_SCRIPT:
                if (f.isXWalkReady()) {
                    if (jsRuntimeType != JsRuntime.JsRuntimeType.RT_TYPE_J2V8) {
                        if (jsRuntimeType == JsRuntime.JsRuntimeType.RT_TYPE_NATIVE_SCRIPT) {
                            iVar = new i();
                            iVar.init(1);
                            break;
                        }
                    } else {
                        iVar = new i();
                        iVar.init(0);
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(154490);
        return iVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public boolean initWebviewCore(Context context, WebView.PreInitCallback preInitCallback) {
        AppMethodBeat.i(154491);
        boolean lH = b.lH(context);
        if (preInitCallback != null) {
            if (lH) {
                preInitCallback.onCoreInitFinished();
            } else {
                preInitCallback.btl();
            }
        }
        AppMethodBeat.o(154491);
        return lH;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void initCallback(WebViewExtensionListener webViewExtensionListener) {
        AppMethodBeat.i(154492);
        b.initCallback(webViewExtensionListener);
        AppMethodBeat.o(154492);
    }

    @Override // com.tencent.xweb.internal.l.a
    public boolean hasInited() {
        AppMethodBeat.i(154493);
        boolean hasInited = b.hasInited();
        AppMethodBeat.o(154493);
        return hasInited;
    }

    public boolean hasInitedCallback() {
        AppMethodBeat.i(154494);
        boolean hasInitedCallback = b.hasInitedCallback();
        AppMethodBeat.o(154494);
        return hasInitedCallback;
    }

    public boolean isCoreReady() {
        AppMethodBeat.i(154495);
        boolean isCoreReady = b.isCoreReady();
        AppMethodBeat.o(154495);
        return isCoreReady;
    }

    @Override // com.tencent.xweb.internal.l.a
    public void clearAllWebViewCache(Context context, boolean z) {
        CookieInternal.ICookieManagerInternal cookieManager;
        AppMethodBeat.i(154496);
        if (WebView.getCurWebType() != WebView.c.WV_KIND_CW) {
            AppMethodBeat.o(154496);
            return;
        }
        try {
            if (XWalkEnvironment.getAvailableVersion() <= 0) {
                AppMethodBeat.o(154496);
                return;
            }
            XWalkView xWalkView = new XWalkView(new XWalkContextWrapper(XWalkEnvironment.getApplicationContext(), XWalkEnvironment.getAvailableVersion()));
            xWalkView.removeJavascriptInterface("searchBoxJavaBridge_");
            xWalkView.removeJavascriptInterface("accessibility");
            xWalkView.removeJavascriptInterface("accessibilityTraversal");
            xWalkView.clearCache(true);
            XWalkViewDatabase.clearFormData();
            if (z && (cookieManager = getCookieManager()) != null) {
                cookieManager.removeAllCookie();
            }
            AppMethodBeat.o(154496);
        } catch (Throwable th) {
            Log.e(TAG, "clearAllWebViewCache exception 1 -- " + th.getMessage());
            AppMethodBeat.o(154496);
        }
    }

    @Override // com.tencent.xweb.internal.l.a
    public CookieInternal.ICookieManagerInternal getCookieManager() {
        AppMethodBeat.i(154497);
        e eVar = new e();
        AppMethodBeat.o(154497);
        return eVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager() {
        AppMethodBeat.i(154498);
        f fVar = new f();
        AppMethodBeat.o(154498);
        return fVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebStorage createWebviewStorage() {
        AppMethodBeat.i(154499);
        j jVar = new j();
        AppMethodBeat.o(154499);
        return jVar;
    }

    @Override // com.tencent.xweb.internal.l.a
    public IWebViewDatabase getWebViewDatabase() {
        AppMethodBeat.i(207321);
        t tVar = new t();
        AppMethodBeat.o(207321);
        return tVar;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        private static boolean SEh = false;
        private static boolean SEi = false;
        private static boolean SFu = false;

        public static boolean hasInited() {
            return SEh;
        }

        public static boolean hasInitedCallback() {
            return SEi;
        }

        public static boolean isCoreReady() {
            return SFu;
        }

        public static boolean lH(Context context) {
            AppMethodBeat.i(154483);
            if (SEh) {
                boolean z = SEh;
                AppMethodBeat.o(154483);
                return z;
            }
            Log.i("XWebViewHelper", "preInit");
            if (k.in(context)) {
                Log.i("XWebViewHelper", "preInit finished");
                SEh = true;
                SFu = true;
                String processName = XWalkEnvironment.getProcessName();
                if (TextUtils.isEmpty(processName)) {
                    processName = XWalkEnvironment.getApplicationContext().getPackageName();
                }
                XWalkCoreWrapper.invokeRuntimeChannel(90002, new Object[]{processName.replace(":", ".") + "." + XWalkEnvironment.getGrayValue()});
            } else {
                Log.i("XWebViewHelper", "preInit xwalk is not available");
            }
            boolean z2 = SEh;
            AppMethodBeat.o(154483);
            return z2;
        }

        public static void initCallback(WebViewExtensionListener webViewExtensionListener) {
            AppMethodBeat.i(154484);
            if (SEi) {
                AppMethodBeat.o(154484);
                return;
            }
            Log.i("XWebViewHelper", "initCallback");
            WebViewExtension.SetExtension(webViewExtensionListener);
            SEi = true;
            AppMethodBeat.o(154484);
        }
    }
}
