package com.tencent.mm.ui.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import org.xwalk.core.XWalkEnvironment;

public class MMWebView extends WebView {
    public static final WebView.c QDR = WebView.c.WV_KIND_X5;
    private static Vector<WeakReference<MMWebView>> QDT = new Vector<>();
    private View.OnTouchListener HeV;
    private r JDX;
    protected boolean QDS;
    private boolean QDU;
    private ViewGroup QDV;
    private View.OnTouchListener QDW;
    public e QDX;
    private LinkedList<e> QDY;
    private boolean QDZ;
    private List<i> QEa;
    public boolean gKM;
    private boolean ltW;
    public boolean mDestroyed;
    private String zpY;

    public interface e {
        void onWebViewScrollChanged(int i2, int i3, int i4, int i5);
    }

    public r getPerformanceHelper() {
        return this.JDX;
    }

    static {
        AppMethodBeat.i(205438);
        AppMethodBeat.o(205438);
    }

    public static class a {
        public static MMWebView kK(Context context) {
            AppMethodBeat.i(143419);
            try {
                Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
                WebView.initWebviewCore(context, MMWebView.QDR, "tools", null);
                MMWebView.kI(context);
                MMWebView mMWebView = new MMWebView(context, null, 0, WebView.c.WV_KIND_SYS);
                mMWebView.gKM = true;
                mMWebView.isX5Kernel = mMWebView.getIsX5Kernel();
                AppMethodBeat.o(143419);
                return mMWebView;
            } catch (Exception e2) {
                AppMethodBeat.o(143419);
                return null;
            }
        }

        public static MMWebView kL(Context context) {
            AppMethodBeat.i(143420);
            Log.i("MMWebView", "TRACE_ORDER:MMWebView.java");
            WebView.initWebviewCore(context, MMWebView.QDR, "tools", null);
            MMWebView.kI(context);
            MMWebView mMWebView = new MMWebView(context);
            mMWebView.gKM = true;
            mMWebView.isX5Kernel = mMWebView.getIsX5Kernel();
            AppMethodBeat.o(143420);
            return mMWebView;
        }

        public static MMWebView r(Activity activity, int i2) {
            boolean z = true;
            AppMethodBeat.i(143421);
            MMWebView.kI(activity);
            MMWebView mMWebView = (MMWebView) activity.findViewById(i2);
            mMWebView.gKM = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.isX5Kernel = z;
            AppMethodBeat.o(143421);
            return mMWebView;
        }

        public static MMWebView a(Context context, View view, int i2) {
            boolean z = true;
            AppMethodBeat.i(143422);
            MMWebView.kI(context);
            MMWebView mMWebView = (MMWebView) view.findViewById(i2);
            mMWebView.gKM = true;
            if (mMWebView.getX5WebViewExtension() == null) {
                z = false;
            }
            mMWebView.isX5Kernel = z;
            AppMethodBeat.o(143422);
            return mMWebView;
        }
    }

    public MMWebView(Context context) {
        this(context, null);
    }

    public MMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, WebView.c.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, WebView.c.WV_KIND_NONE);
    }

    public MMWebView(Context context, AttributeSet attributeSet, int i2, WebView.c cVar) {
        super(context, attributeSet, i2, cVar);
        AppMethodBeat.i(143424);
        this.JDX = new r();
        this.gKM = false;
        this.QDS = false;
        this.QDU = false;
        this.QDX = null;
        this.QDY = new LinkedList<>();
        this.QDZ = false;
        this.QEa = new ArrayList();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            Log.e("MicroMsg.MMWebView", "alvinluo MMWebView create not in main thread, stack: %s", Util.getStack());
            if (BuildInfo.IS_FLAVOR_RED) {
                IllegalStateException illegalStateException = new IllegalStateException("Create MMWebView must be in main thread");
                AppMethodBeat.o(143424);
                throw illegalStateException;
            }
        }
        setBackgroundColor(context.getResources().getColor(R.color.afz));
        gYV();
        QDT.add(new WeakReference<>(this));
        AppMethodBeat.o(143424);
    }

    public final boolean gYU() {
        AppMethodBeat.i(205430);
        if (isSysKernel() || isX5WrappedSysKernel()) {
            AppMethodBeat.o(205430);
            return true;
        }
        AppMethodBeat.o(205430);
        return false;
    }

    public static void CU(boolean z) {
        AppMethodBeat.i(205431);
        Iterator<WeakReference<MMWebView>> it = QDT.iterator();
        while (it.hasNext()) {
            MMWebView mMWebView = it.next().get();
            if (mMWebView != null) {
                if (z) {
                    mMWebView.getSettings().setForceDarkMode(2);
                } else {
                    mMWebView.getSettings().setForceDarkMode(0);
                }
            }
        }
        AppMethodBeat.o(205431);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void destroy() {
        AppMethodBeat.i(143425);
        try {
            super.destroy();
            Iterator<WeakReference<MMWebView>> it = QDT.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<MMWebView> next = it.next();
                if (next.get() == this) {
                    QDT.remove(next);
                    break;
                }
            }
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.MMWebView", th, "catch in destroy()", new Object[0]);
        } finally {
            this.mDestroyed = true;
            AppMethodBeat.o(143425);
        }
    }

    public final boolean isDestroyed() {
        return this.mDestroyed;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void loadUrl(String str) {
        AppMethodBeat.i(143426);
        super.loadUrl(str);
        AppMethodBeat.o(143426);
    }

    /* access modifiers changed from: protected */
    @TargetApi(11)
    public final void gYV() {
        AppMethodBeat.i(143427);
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                super.removeJavascriptInterface("searchBoxJavaBridge_");
            }
            AppMethodBeat.o(143427);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMWebView", "removeConfigJsInterface, ex = %s", e2.getMessage());
            AppMethodBeat.o(143427);
        }
    }

    public final void gYW() {
        AppMethodBeat.i(143428);
        if (Build.VERSION.SDK_INT >= 5) {
            new d(this, (byte) 0);
            d.d(this);
            AppMethodBeat.o(143428);
            return;
        }
        new c(this, (byte) 0);
        setScrollBarStyle(0);
        AppMethodBeat.o(143428);
    }

    class d {
        private d() {
        }

        /* synthetic */ d(MMWebView mMWebView, byte b2) {
            this();
        }

        public static void d(WebView webView) {
            AppMethodBeat.i(143423);
            webView.setScrollbarFadingEnabled(true);
            webView.setScrollBarStyle(0);
            AppMethodBeat.o(143423);
        }
    }

    class c {
        private c() {
        }

        /* synthetic */ c(MMWebView mMWebView, byte b2) {
            this();
        }
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        boolean z;
        AppMethodBeat.i(143429);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(143429);
            return;
        }
        if (com.tencent.mm.compatible.util.d.oD(19) || this.isX5Kernel) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            super.evaluateJavascript(str, valueCallback);
            AppMethodBeat.o(143429);
        } else if (!this.QDS || !b(this, str)) {
            try {
                if (!str.startsWith("javascript:")) {
                    str = "javascript:".concat(String.valueOf(str));
                }
                super.loadUrl(str);
                AppMethodBeat.o(143429);
            } catch (Exception e2) {
                Log.i("MicroMsg.MMWebView", "evaluateJavascript failed : %s", e2.getMessage());
                AppMethodBeat.o(143429);
            }
        } else {
            AppMethodBeat.o(143429);
        }
    }

    public void a(URL url, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(143430);
        super.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(143430);
    }

    private static boolean b(MMWebView mMWebView, String str) {
        AppMethodBeat.i(143431);
        try {
            Object obj = new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(new com.tencent.mm.compatible.loader.c(mMWebView, "mSysWebView", null).get(), "mProvider", null).get(), "mWebViewCore", null).get();
            Method declaredMethod = obj.getClass().getDeclaredMethod("sendMessage", Message.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(obj, Message.obtain(null, 194, str));
            AppMethodBeat.o(143431);
            return true;
        } catch (Exception e2) {
            Log.e("MicroMsg.MMWebView", "reflectJSExec, e = %s", e2);
            AppMethodBeat.o(143431);
            return false;
        }
    }

    public void setCompetitorView(ViewGroup viewGroup) {
        this.QDV = viewGroup;
    }

    public boolean getIsX5Kernel() {
        return this.isX5Kernel;
    }

    public final void gYX() {
        AppMethodBeat.i(143432);
        super.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.widget.MMWebView.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(143418);
                if (MMWebView.this.getIsX5Kernel()) {
                    int action = motionEvent.getAction();
                    if (MMWebView.this.QDV != null) {
                        switch (action & 255) {
                            case 0:
                            case 2:
                                MMWebView.this.QDV.requestDisallowInterceptTouchEvent(true);
                                break;
                            case 1:
                            case 3:
                                MMWebView.this.QDV.requestDisallowInterceptTouchEvent(false);
                                break;
                            default:
                                MMWebView.this.QDV.requestDisallowInterceptTouchEvent(true);
                                break;
                        }
                    }
                }
                if (MMWebView.this.QDW != null && MMWebView.this.QDW.onTouch(view, motionEvent)) {
                    AppMethodBeat.o(143418);
                    return true;
                } else if (MMWebView.this.HeV != null) {
                    boolean onTouch = MMWebView.this.HeV.onTouch(view, motionEvent);
                    AppMethodBeat.o(143418);
                    return onTouch;
                } else {
                    AppMethodBeat.o(143418);
                    return false;
                }
            }
        });
        AppMethodBeat.o(143432);
    }

    @Override // com.tencent.xweb.WebView
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.HeV = onTouchListener;
    }

    public void setOnCustomTouchListener(View.OnTouchListener onTouchListener) {
        this.QDW = onTouchListener;
    }

    @TargetApi(9)
    public final boolean c(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        AppMethodBeat.i(143433);
        boolean super_overScrollBy = super.super_overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
        if (i5 < 0 || (i5 == 0 && i3 < 0)) {
            this.QDU = true;
        }
        AppMethodBeat.o(143433);
        return super_overScrollBy;
    }

    public final boolean am(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(143434);
        int action = motionEvent.getAction();
        boolean super_onTouchEvent = super.super_onTouchEvent(motionEvent);
        switch (action & 255) {
            case 0:
                this.QDU = false;
                break;
            case 2:
                if (this.QDV != null) {
                    if (!this.QDU) {
                        this.QDV.requestDisallowInterceptTouchEvent(true);
                        break;
                    } else {
                        this.QDV.requestDisallowInterceptTouchEvent(false);
                        break;
                    }
                }
                break;
        }
        if (!super_onTouchEvent) {
            z = super_onTouchEvent;
        } else if (this.QDU) {
            z = false;
        }
        AppMethodBeat.o(143434);
        return z;
    }

    @TargetApi(9)
    public final void h(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(143435);
        super.super_onOverScrolled(i2, i3, z, z2);
        AppMethodBeat.o(143435);
    }

    public final boolean an(MotionEvent motionEvent) {
        AppMethodBeat.i(143436);
        boolean super_dispatchTouchEvent = super.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(143436);
        return super_dispatchTouchEvent;
    }

    public final boolean ao(MotionEvent motionEvent) {
        AppMethodBeat.i(143437);
        boolean super_onInterceptTouchEvent = super.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(143437);
        return super_onInterceptTouchEvent;
    }

    @TargetApi(9)
    public final void gYY() {
        AppMethodBeat.i(143438);
        super.super_computeScroll();
        AppMethodBeat.o(143438);
    }

    public final void R(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143439);
        super.super_onScrollChanged(i2, i3, i4, i5);
        Iterator<e> it = this.QDY.iterator();
        while (it.hasNext()) {
            it.next().onWebViewScrollChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(143439);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void kI(android.content.Context r11) {
        /*
        // Method dump skipped, instructions count: 170
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.widget.MMWebView.kI(android.content.Context):void");
    }

    private static void gYZ() {
        AppMethodBeat.i(205432);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_new_dns_host_list, "");
        if (!Util.isNullOrNil(a2)) {
            Log.i("MicroMsg.MMWebView", "setNewDnsHostList %s", a2);
            com.tencent.xweb.x5.sdk.d.setNewDnsHostList(a2);
        }
        AppMethodBeat.o(205432);
    }

    private static void kJ(Context context) {
        AppMethodBeat.i(205433);
        int tbsVersion = com.tencent.xweb.x5.sdk.d.getTbsVersion(context);
        if (Build.VERSION.SDK_INT > 28 && context.getApplicationInfo().targetSdkVersion > 28 && tbsVersion > 0 && tbsVersion < 45114) {
            com.tencent.xweb.x5.sdk.d.forceSysWebView();
        }
        AppMethodBeat.o(205433);
    }

    public final void a(e eVar) {
        AppMethodBeat.i(143441);
        this.QDY.add(eVar);
        AppMethodBeat.o(143441);
    }

    @Override // com.tencent.xweb.WebView
    public void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(143442);
        super.onWebViewScrollChanged(i2, i3, i4, i5);
        if (this.QDX != null) {
            this.QDX.onWebViewScrollChanged(i2, i3, i4, i5);
        }
        Iterator<e> it = this.QDY.iterator();
        while (it.hasNext()) {
            it.next().onWebViewScrollChanged(i2, i3, i4, i5);
        }
        AppMethodBeat.o(143442);
    }

    public String getRandomStr() {
        return this.zpY;
    }

    public Context getActivityContextIfHas() {
        Context context;
        AppMethodBeat.i(205434);
        if (getContext() instanceof MutableContextWrapper) {
            context = ((MutableContextWrapper) getContext()).getBaseContext();
        } else {
            context = getContext();
        }
        AppMethodBeat.o(205434);
        return context;
    }

    public void setRandomStr(String str) {
        this.zpY = str;
    }

    public final boolean gZa() {
        return this.ltW;
    }

    public void setPreload(boolean z) {
        this.ltW = z;
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public final void onShow() {
        AppMethodBeat.i(143443);
        super.onShow();
        this.QDZ = false;
        AppMethodBeat.o(143443);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public final void onHide() {
        AppMethodBeat.i(143444);
        if (this.QDZ) {
            AppMethodBeat.o(143444);
            return;
        }
        super.onHide();
        this.QDZ = true;
        AppMethodBeat.o(143444);
    }

    public final void aG(Context context) {
        AppMethodBeat.i(182573);
        if (!(getContext() instanceof MutableContextWrapper)) {
            AppMethodBeat.o(182573);
            return;
        }
        MutableContextWrapper mutableContextWrapper = (MutableContextWrapper) getContext();
        if (mutableContextWrapper.getBaseContext() == context) {
            AppMethodBeat.o(182573);
            return;
        }
        mutableContextWrapper.setBaseContext(context);
        AppMethodBeat.o(182573);
    }

    public final void a(i iVar) {
        AppMethodBeat.i(205435);
        this.QEa.add(iVar);
        AppMethodBeat.o(205435);
    }

    @Override // com.tencent.xweb.internal.IWebView, com.tencent.xweb.WebView
    public void setWebChromeClient(x xVar) {
        AppMethodBeat.i(205436);
        if (xVar instanceof b) {
            ((b) xVar).QEc = this.QEa;
        }
        if (xVar == null) {
            this.QEa.clear();
        }
        super.setWebChromeClient(xVar);
        AppMethodBeat.o(205436);
    }

    public static class b extends x {
        private x ITc;
        List<i> QEc = new ArrayList();

        public b(x xVar) {
            AppMethodBeat.i(205410);
            this.ITc = xVar;
            AppMethodBeat.o(205410);
        }

        @Override // com.tencent.xweb.x
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(205411);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean onConsoleMessage = this.ITc.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(205411);
            return onConsoleMessage;
        }

        @Override // com.tencent.xweb.x
        public final boolean b(long j2, String str, String str2, String str3) {
            AppMethodBeat.i(205412);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean b2 = this.ITc.b(j2, str, str2, str3);
            AppMethodBeat.o(205412);
            return b2;
        }

        @Override // com.tencent.xweb.x
        public final boolean c(String str, String str2, String str3, String str4, String str5, String str6) {
            AppMethodBeat.i(205413);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean c2 = this.ITc.c(str, str2, str3, str4, str5, str6);
            AppMethodBeat.o(205413);
            return c2;
        }

        @Override // com.tencent.xweb.x
        public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
            AppMethodBeat.i(205414);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.onGeolocationPermissionsShowPrompt(str, callback);
            AppMethodBeat.o(205414);
        }

        @Override // com.tencent.xweb.x
        public final void onGeolocationPermissionsHidePrompt() {
            AppMethodBeat.i(205415);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.onGeolocationPermissionsHidePrompt();
            AppMethodBeat.o(205415);
        }

        @Override // com.tencent.xweb.x
        public final void onHideCustomView() {
            AppMethodBeat.i(205416);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.onHideCustomView();
            AppMethodBeat.o(205416);
        }

        @Override // com.tencent.xweb.x
        public final boolean a(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(205417);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean a2 = this.ITc.a(webView, str, str2, jsResult);
            AppMethodBeat.o(205417);
            return a2;
        }

        @Override // com.tencent.xweb.x
        public final boolean b(WebView webView, String str, String str2, JsResult jsResult) {
            AppMethodBeat.i(205418);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean b2 = this.ITc.b(webView, str, str2, jsResult);
            AppMethodBeat.o(205418);
            return b2;
        }

        @Override // com.tencent.xweb.x
        public final boolean a(WebView webView, String str, String str2, String str3, o oVar) {
            AppMethodBeat.i(205419);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean a2 = this.ITc.a(webView, str, str2, str3, oVar);
            AppMethodBeat.o(205419);
            return a2;
        }

        @Override // com.tencent.xweb.x
        public final View getVideoLoadingProgressView() {
            AppMethodBeat.i(205420);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            View videoLoadingProgressView = this.ITc.getVideoLoadingProgressView();
            AppMethodBeat.o(205420);
            return videoLoadingProgressView;
        }

        @Override // com.tencent.xweb.x
        public final void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            AppMethodBeat.i(205421);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.openFileChooser(valueCallback, str, str2);
            AppMethodBeat.o(205421);
        }

        @Override // com.tencent.xweb.x
        public final void b(WebView webView, int i2) {
            AppMethodBeat.i(205422);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.b(webView, i2);
            AppMethodBeat.o(205422);
        }

        @Override // com.tencent.xweb.x
        public final boolean a(WebView webView, ValueCallback<Uri[]> valueCallback, x.a aVar) {
            AppMethodBeat.i(205423);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean a2 = this.ITc.a(webView, valueCallback, aVar);
            AppMethodBeat.o(205423);
            return a2;
        }

        @Override // com.tencent.xweb.x
        public final void a(WebView webView, int i2) {
            AppMethodBeat.i(205424);
            for (i iVar : this.QEc) {
                iVar.a(webView, i2);
            }
            this.ITc.a(webView, i2);
            AppMethodBeat.o(205424);
        }

        @Override // com.tencent.xweb.x
        public final void d(WebView webView, String str) {
            AppMethodBeat.i(205425);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.d(webView, str);
            AppMethodBeat.o(205425);
        }

        @Override // com.tencent.xweb.x
        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            AppMethodBeat.i(205426);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.onShowCustomView(view, customViewCallback);
            AppMethodBeat.o(205426);
        }

        @Override // com.tencent.xweb.x
        public final boolean a(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            AppMethodBeat.i(205427);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean a2 = this.ITc.a(view, customViewCallback);
            AppMethodBeat.o(205427);
            return a2;
        }

        @Override // com.tencent.xweb.x
        public final boolean bLA() {
            AppMethodBeat.i(205428);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            boolean bLA = this.ITc.bLA();
            AppMethodBeat.o(205428);
            return bLA;
        }

        @Override // com.tencent.xweb.x
        public final void onExitFullscreenVideo(Bitmap bitmap) {
            AppMethodBeat.i(205429);
            Iterator<i> it = this.QEc.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.ITc.onExitFullscreenVideo(bitmap);
            AppMethodBeat.o(205429);
        }
    }

    public float getMMDensity() {
        AppMethodBeat.i(205437);
        float gvp = com.tencent.mm.cc.a.gvp();
        if (getWebCoreType() == WebView.c.WV_KIND_CW && XWalkEnvironment.getUsingCustomContext()) {
            gvp = getResources().getDisplayMetrics().density;
        }
        AppMethodBeat.o(205437);
        return gvp;
    }

    public void setCleanOnDetached(boolean z) {
    }
}
