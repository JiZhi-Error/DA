package com.tencent.xweb;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.internal.CookieInternal;
import com.tencent.xweb.internal.IWebView;
import com.tencent.xweb.internal.f;
import com.tencent.xweb.internal.k;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.util.g;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWebCoreInfo;

public class WebView extends FrameLayout implements IWebView {
    static c SAf = c.WV_KIND_NONE;
    static String SAg = "";
    static boolean SAh = false;
    static com.tencent.xweb.x5.sdk.c SAl;
    View.OnLongClickListener QCV;
    IWebView SAi;
    c SAj;
    com.tencent.xweb.internal.d SAk;
    private int SAm;
    public boolean isX5Kernel;

    public interface PreInitCallback {
        void btl();

        void onCoreInitFinished();
    }

    public static class b {
        public String mExtra;
        public int mType = 0;
    }

    static {
        AppMethodBeat.i(156917);
        aj.initInterface();
        AppMethodBeat.o(156917);
    }

    public class d {
        private WebView SAx;

        public d() {
        }

        public final synchronized WebView getWebView() {
            return this.SAx;
        }
    }

    public static c getPreferedWebviewType(Context context, String str) {
        AppMethodBeat.i(156808);
        c preferedWebviewType = getPreferedWebviewType(context, c.WV_KIND_X5, str);
        AppMethodBeat.o(156808);
        return preferedWebviewType;
    }

    public static c getPreferedWebviewType(Context context, c cVar, String str) {
        AppMethodBeat.i(156809);
        if (SAf != c.WV_KIND_NONE) {
            c cVar2 = SAf;
            AppMethodBeat.o(156809);
            return cVar2;
        }
        XWalkEnvironment.init(context);
        if (XWalkEnvironment.isIaDevice()) {
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "x86 device use WV_KIND_SYS");
            h.OQ(69);
            c cVar3 = c.WV_KIND_SYS;
            AppMethodBeat.o(156809);
            return cVar3;
        }
        if (y.hsF().bsk(str) != c.WV_KIND_NONE) {
            cVar = y.hsF().bsk(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "use hard code web type = ".concat(String.valueOf(cVar)));
        } else if (a.brE(str) != c.WV_KIND_NONE) {
            cVar = a.brE(str);
            XWalkEnvironment.addXWalkInitializeLog("XWeb.getPreferedWebviewType", "module " + str + "use cmd web type = " + cVar);
        }
        h.h(cVar);
        if (cVar == c.WV_KIND_CW && !XWalkEnvironment.hasAvailableVersion()) {
            cVar = c.WV_KIND_SYS;
            SAh = true;
            XWalkEnvironment.addXWalkInitializeLog("xwalk is not available , use sys");
        }
        com.tencent.xweb.internal.h.d(cVar);
        if (com.tencent.xweb.internal.h.htF().htK()) {
            XWalkEnvironment.addXWalkInitializeLog("kind is match loadurlwatchdog switch to syskernal");
            cVar = c.WV_KIND_SYS;
        }
        if (cVar == c.WV_KIND_X5) {
            com.tencent.xweb.x5.sdk.d.huK();
        }
        AppMethodBeat.o(156809);
        return cVar;
    }

    public static void reinitToXWeb() {
        AppMethodBeat.i(185175);
        XWalkEnvironment.addXWalkInitializeLog("reinitToXWeb");
        SAf = c.WV_KIND_NONE;
        XWalkEnvironment.refreshVerInfo();
        initWebviewCore(XWalkEnvironment.getApplicationContext(), c.WV_KIND_CW, SAg, null);
        AppMethodBeat.o(185175);
    }

    public static void initWebviewCore(Context context, c cVar, String str, PreInitCallback preInitCallback) {
        AppMethodBeat.i(156810);
        if (str == null || str.isEmpty()) {
            str = "tools";
        }
        if (SAf != c.WV_KIND_NONE) {
            if (SAf != cVar) {
                Log.e("xweb.WebView", "invalid set webview kind to diffrent type");
            }
            AppMethodBeat.o(156810);
            return;
        }
        SAg = str;
        h.bsG(str);
        if (str == null) {
            str = "";
        }
        XWalkEnvironment.init(context);
        s.init();
        y.lC(context);
        if (XWalkEnvironment.getAvailableVersion() <= 0) {
            XWalkEnvironment.addXWalkInitializeLog("initWebviewCore with no xweb, tryEmbedInstall");
            w.hsD();
        }
        _initWebviewCore(context, getPreferedWebviewType(context, cVar, str), preInitCallback, true);
        AppMethodBeat.o(156810);
    }

    public static synchronized boolean _initWebviewCore(Context context, c cVar, PreInitCallback preInitCallback, boolean z) {
        boolean a2;
        synchronized (WebView.class) {
            AppMethodBeat.i(156811);
            a2 = a(context, cVar, preInitCallback, true, false);
            AppMethodBeat.o(156811);
        }
        return a2;
    }

    private static synchronized boolean a(Context context, c cVar, PreInitCallback preInitCallback, boolean z, boolean z2) {
        boolean z3 = false;
        synchronized (WebView.class) {
            AppMethodBeat.i(156812);
            if (!a(cVar, context, preInitCallback, z2) && z) {
                cVar = c.WV_KIND_NONE;
                c[] cVarArr = {c.WV_KIND_CW, c.WV_KIND_SYS, c.WV_KIND_X5};
                int i2 = 0;
                while (true) {
                    if (i2 < 3) {
                        if (cVarArr[i2] != cVar && a(cVarArr[i2], context, preInitCallback, z2)) {
                            cVar = cVarArr[i2];
                            break;
                        }
                        i2++;
                    } else {
                        break;
                    }
                }
            }
            SAf = cVar;
            if (c.WV_KIND_NONE == cVar) {
                h.huv();
                Log.e("xweb.WebView", "_initWebviewCore finally failed type = ".concat(String.valueOf(cVar)));
                AppMethodBeat.o(156812);
            } else {
                XWalkEnvironment.addXWalkInitializeLog("init webview core type = " + cVar + ", sdk:201201,xweb apk ver:" + XWalkEnvironment.getAvailableVersion());
                AppMethodBeat.o(156812);
                z3 = true;
            }
        }
        return z3;
    }

    private static boolean a(c cVar, Context context, PreInitCallback preInitCallback, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(156813);
        if (cVar == c.WV_KIND_X5) {
            com.tencent.xweb.x5.sdk.d.huK();
        }
        Log.i("xweb.WebView", "try to init webview core = ".concat(String.valueOf(cVar)));
        if (z || !com.tencent.xweb.internal.b.c(cVar)) {
            com.tencent.xweb.internal.b c2 = com.tencent.xweb.internal.b.c("LOAD_CORE", cVar);
            c2.htA();
            try {
                l.a g2 = l.g(cVar);
                z2 = g2.initWebviewCore(context, preInitCallback);
                if (z2) {
                    c.hsp().SyN = g2.getCookieManager();
                    d.SyP = g2.getCookieSyncManager();
                    h.i(cVar);
                    c2.htB();
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview failed type = ".concat(String.valueOf(cVar)));
                }
            } catch (Exception e2) {
                XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "init webview got exception  type = " + cVar + ", err = " + e2.getMessage());
                try {
                    XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "crash stack : " + android.util.Log.getStackTraceString(e2));
                } catch (Exception e3) {
                }
                h.k(cVar);
            }
            AppMethodBeat.o(156813);
        } else {
            h.j(cVar);
            AppMethodBeat.o(156813);
        }
        return z2;
    }

    public static boolean hasInited() {
        AppMethodBeat.i(156814);
        if (getCurWebType() == c.WV_KIND_NONE) {
            AppMethodBeat.o(156814);
            return false;
        } else if (l.g(getCurWebType()) == null) {
            AppMethodBeat.o(156814);
            return false;
        } else {
            boolean hasInited = l.g(getCurWebType()).hasInited();
            AppMethodBeat.o(156814);
            return hasInited;
        }
    }

    public static c getCurWebType() {
        return SAf;
    }

    public c getWebCoreType() {
        return this.SAj;
    }

    public static String getCurStrModule() {
        return SAg;
    }

    public WebView(Context context) {
        this(context, null);
    }

    public WebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WebView(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, 0, c.WV_KIND_NONE);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WebView(Context context, AttributeSet attributeSet, int i2, c cVar) {
        super(context instanceof MutableContextWrapper ? new e(((MutableContextWrapper) context).getBaseContext()) : context, attributeSet, i2);
        AppMethodBeat.i(156815);
        this.SAj = c.WV_KIND_NONE;
        this.isX5Kernel = false;
        this.SAm = -1;
        b(cVar);
        AppMethodBeat.o(156815);
    }

    /* access modifiers changed from: package-private */
    public static class e extends MutableContextWrapper {
        IWebView SAy;

        public e(Context context) {
            super(context);
        }

        public final void setBaseContext(Context context) {
            AppMethodBeat.i(156806);
            super.setBaseContext(context);
            if (!y.hsF().SzV) {
                ah.H("BASE_CONTEXT_CHANGED", this.SAy);
            }
            AppMethodBeat.o(156806);
        }

        public final void unbindService(ServiceConnection serviceConnection) {
            AppMethodBeat.i(156807);
            try {
                super.unbindService(serviceConnection);
                AppMethodBeat.o(156807);
            } catch (IllegalArgumentException e2) {
                Log.e("xweb.WebView", "ContextWrapper unbindService IllegalArgumentException", e2);
                AppMethodBeat.o(156807);
            }
        }
    }

    public enum c {
        WV_KIND_NONE,
        WV_KIND_CW,
        WV_KIND_X5,
        WV_KIND_SYS;

        public static c valueOf(String str) {
            AppMethodBeat.i(156804);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(156804);
            return cVar;
        }

        static {
            AppMethodBeat.i(156805);
            AppMethodBeat.o(156805);
        }
    }

    public enum a {
        NOT_HOOK,
        HOOK_NOT_EVALUTE_JS,
        HOOK_EVALUTE_JS;

        public static a valueOf(String str) {
            AppMethodBeat.i(156801);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(156801);
            return aVar;
        }

        static {
            AppMethodBeat.i(156802);
            AppMethodBeat.o(156802);
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        AppMethodBeat.i(156816);
        boolean drawChild = super.drawChild(canvas, view, j2);
        AppMethodBeat.o(156816);
        return drawChild;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void captureBitmap(IWebView.a aVar) {
        AppMethodBeat.i(156817);
        Log.d("xweb.WebView", "captureBitmap");
        this.SAi.captureBitmap(aVar);
        AppMethodBeat.o(156817);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bitmap captureBitmap() {
        AppMethodBeat.i(219048);
        Bitmap captureBitmap = this.SAi.captureBitmap();
        AppMethodBeat.o(219048);
        return captureBitmap;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(156818);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(156818);
    }

    private void b(c cVar) {
        AppMethodBeat.i(156819);
        Log.i("xweb.WebView", "start to init, prefer type = " + getCurWebType() + " , forcetype = " + cVar);
        if (XWalkEnvironment.getApplicationContext() == null) {
            XWalkEnvironment.init(getContext());
        }
        if (this.SAj != c.WV_KIND_NONE) {
            AppMethodBeat.o(156819);
            return;
        }
        if (getCurWebType() == c.WV_KIND_NONE) {
            _initWebviewCore(getContext(), c.WV_KIND_SYS, null, true);
            Log.e("xweb.Webview", "use xweb without init, force to use sys web");
        }
        if (com.tencent.xweb.internal.h.htF().htI()) {
            this.SAj = c.WV_KIND_SYS;
            XWalkEnvironment.addXWalkInitializeLog("xweb.WebView", "isTestingSys, force to use sys web");
        } else if (cVar == c.WV_KIND_SYS) {
            this.SAj = cVar;
            l.a g2 = l.g(c.WV_KIND_SYS);
            if (g2 != null) {
                g2.initWebviewCore(getContext(), null);
            }
        } else {
            this.SAj = getCurWebType();
        }
        this.SAi = l.a(this.SAj, this);
        if (this.SAi == null) {
            c[] cVarArr = {c.WV_KIND_CW, c.WV_KIND_SYS, c.WV_KIND_X5};
            int i2 = 0;
            while (true) {
                if (i2 >= 3) {
                    break;
                }
                if (cVarArr[i2] != this.SAj && _initWebviewCore(getContext(), cVarArr[i2], null, false)) {
                    this.SAi = l.a(cVarArr[i2], this);
                    if (this.SAi != null) {
                        this.SAj = getCurWebType();
                        break;
                    }
                }
                i2++;
            }
        }
        if (this.SAi == null) {
            a(getContext(), c.WV_KIND_SYS, null, false, true);
            this.SAi = l.a(c.WV_KIND_SYS, this);
            this.SAj = getCurWebType();
        }
        if (this.SAi == null) {
            Log.e("xweb.WebView", "init finally failed type = " + this.SAj);
            h.huw();
            AppMethodBeat.o(156819);
            return;
        }
        addView(this.SAi.getWebViewUI());
        if (this.SAj != c.WV_KIND_X5) {
            Log.i("xweb.WebView", "this webview instance is using :" + this.SAj);
        } else if (this.SAi.getX5WebViewExtension() != null) {
            this.isX5Kernel = true;
            Log.i("xweb.WebView", "this webview instance is using x5-x5kernal");
        } else {
            Log.i("xweb.WebView", "this webview instance is using x5-syskernal ");
        }
        if (this.SAi.getCurWebviewClient() != null) {
            this.SAi.getCurWebviewClient().SzO = this.SAi.getDefalutOpProvider();
        }
        if (this.SAi.getCurWebChromeClient() != null) {
            this.SAi.getCurWebChromeClient().SzO = this.SAi.getDefalutOpProvider();
        }
        this.SAi.getView().setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.xweb.WebView.AnonymousClass1 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(156799);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/xweb/WebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                if (WebView.this.QCV != null) {
                    boolean onLongClick = WebView.this.QCV.onLongClick(WebView.this);
                    com.tencent.mm.hellhoundlib.a.a.a(onLongClick, this, "com/tencent/xweb/WebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(156799);
                    return onLongClick;
                }
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/xweb/WebView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(156799);
                return false;
            }
        });
        try {
            this.SAk = (com.tencent.xweb.internal.d) l.g(c.WV_KIND_CW).excute("STR_CMD_GET_DEBUG_VIEW", new Object[]{this});
            this.SAk.hsZ();
        } catch (Exception e2) {
            Log.e("xweb.WebView", "create IDebugView failed, use dummy one ");
            this.SAk = new com.tencent.xweb.internal.d() {
                /* class com.tencent.xweb.WebView.AnonymousClass2 */

                @Override // com.tencent.xweb.internal.d
                public final boolean bsn(String str) {
                    return false;
                }

                @Override // com.tencent.xweb.internal.d
                public final void hsZ() {
                }
            };
        }
        if (getWebCoreType() == c.WV_KIND_CW) {
            Context context = getContext();
            if (context instanceof e) {
                ((e) context).SAy = this.SAi;
            }
            k.f(c.WV_KIND_CW).htE();
        }
        getSettings().setUserAgentString(getSettings().getUserAgentString() + " MMWEBID/" + XWalkEnvironment.getGrayValue());
        AppMethodBeat.o(156819);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.QCV = onLongClickListener;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Object getX5WebViewExtension() {
        AppMethodBeat.i(156820);
        Object x5WebViewExtension = this.SAi.getX5WebViewExtension();
        AppMethodBeat.o(156820);
        return x5WebViewExtension;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClientExtension(com.tencent.xweb.x5.export.external.extension.proxy.a aVar) {
        AppMethodBeat.i(156821);
        this.SAi.setWebViewClientExtension(aVar);
        AppMethodBeat.o(156821);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean super_onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(156822);
        boolean super_onTouchEvent = this.SAi.super_onTouchEvent(motionEvent);
        AppMethodBeat.o(156822);
        return super_onTouchEvent;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean super_onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(156823);
        boolean super_onInterceptTouchEvent = this.SAi.super_onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(156823);
        return super_onInterceptTouchEvent;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void super_onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        AppMethodBeat.i(156824);
        this.SAi.super_onOverScrolled(i2, i3, z, z2);
        AppMethodBeat.o(156824);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean super_dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(156825);
        boolean super_dispatchTouchEvent = this.SAi.super_dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(156825);
        return super_dispatchTouchEvent;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void super_computeScroll() {
        AppMethodBeat.i(156826);
        this.SAi.super_computeScroll();
        AppMethodBeat.o(156826);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void super_onScrollChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(156827);
        this.SAi.super_onScrollChanged(i2, i3, i4, i5);
        AppMethodBeat.o(156827);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean super_overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        AppMethodBeat.i(156828);
        boolean super_overScrollBy = this.SAi.super_overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z);
        AppMethodBeat.o(156828);
        return super_overScrollBy;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onResume() {
        AppMethodBeat.i(156829);
        this.SAi.onResume();
        AppMethodBeat.o(156829);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onPause() {
        AppMethodBeat.i(156830);
        this.SAi.onPause();
        AppMethodBeat.o(156830);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        AppMethodBeat.i(156831);
        this.SAi.getWebViewUI().setOnTouchListener(onTouchListener);
        AppMethodBeat.o(156831);
    }

    public boolean isXWalkKernel() {
        return this.SAj == c.WV_KIND_CW;
    }

    public boolean isSysKernel() {
        return this.SAj == c.WV_KIND_SYS;
    }

    public void setBackgroundColor(int i2) {
        AppMethodBeat.i(156832);
        Log.i("xweb.WebView", "setBackgroundColor color:" + Integer.toHexString(i2));
        super.setBackgroundColor(i2);
        if (this.SAi != null) {
            this.SAi.getWebViewUI().setBackgroundColor(i2);
        }
        AppMethodBeat.o(156832);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        AppMethodBeat.i(156833);
        super.onVisibilityChanged(view, i2);
        if (this.SAi != null) {
            this.SAi.getView().setVisibility(i2);
        }
        AppMethodBeat.o(156833);
    }

    public void drawCanvas(Canvas canvas) {
        AppMethodBeat.i(156834);
        if (isXWalkKernel()) {
            canvas.drawBitmap(getBitmap(), 0.0f, 0.0f, (Paint) null);
            AppMethodBeat.o(156834);
            return;
        }
        draw(canvas);
        AppMethodBeat.o(156834);
    }

    public Bitmap getBitmap() {
        AppMethodBeat.i(156835);
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        if (createBitmap != null) {
            createBitmap.eraseColor(-1);
            Canvas canvas = new Canvas(createBitmap);
            if (isXWalkKernel()) {
                try {
                    Paint paint = new Paint();
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
                    for (TextureView textureView : hP(this)) {
                        Bitmap bitmap = textureView.getBitmap();
                        if (bitmap != null) {
                            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                        } else {
                            Log.e("xweb.WebView", "getBitmap textureViewBitmap = null");
                        }
                    }
                    Bitmap createBitmap2 = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
                    getTopView().draw(new Canvas(createBitmap2));
                    canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, paint);
                } catch (Exception e2) {
                }
            } else {
                draw(canvas);
            }
        }
        AppMethodBeat.o(156835);
        return createBitmap;
    }

    private List<TextureView> hP(View view) {
        AppMethodBeat.i(156836);
        ArrayList arrayList = new ArrayList();
        if (view instanceof TextureView) {
            arrayList.add((TextureView) view);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                arrayList.addAll(hP(viewGroup.getChildAt(i2)));
            }
        }
        AppMethodBeat.o(156836);
        return arrayList;
    }

    @Override // android.view.View
    public void setFocusable(boolean z) {
        AppMethodBeat.i(156837);
        if (!z) {
            setDescendantFocusability(393216);
            super.setFocusable(false);
            AppMethodBeat.o(156837);
            return;
        }
        setDescendantFocusability(131072);
        super.setFocusable(false);
        AppMethodBeat.o(156837);
    }

    public void setFocusableInTouchMode(boolean z) {
        AppMethodBeat.i(156838);
        if (!z) {
            setDescendantFocusability(393216);
            super.setFocusableInTouchMode(false);
            AppMethodBeat.o(156838);
            return;
        }
        setDescendantFocusability(131072);
        super.setFocusableInTouchMode(false);
        AppMethodBeat.o(156838);
    }

    public void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getView() {
        AppMethodBeat.i(156839);
        View view = this.SAi.getView();
        AppMethodBeat.o(156839);
        return view;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public ViewGroup getTopView() {
        AppMethodBeat.i(156840);
        ViewGroup topView = this.SAi.getTopView();
        AppMethodBeat.o(156840);
        return topView;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getUrl() {
        AppMethodBeat.i(156841);
        String url = this.SAi.getUrl();
        AppMethodBeat.o(156841);
        return url;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void removeJavascriptInterface(String str) {
        AppMethodBeat.i(156842);
        this.SAi.removeJavascriptInterface(str);
        AppMethodBeat.o(156842);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void stopLoading() {
        AppMethodBeat.i(156843);
        this.SAi.stopLoading();
        AppMethodBeat.o(156843);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewCallbackClient(ab abVar) {
        AppMethodBeat.i(156844);
        this.SAi.setWebViewCallbackClient(abVar);
        AppMethodBeat.o(156844);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public b getHitTestResult() {
        AppMethodBeat.i(156845);
        b hitTestResult = this.SAi.getHitTestResult();
        AppMethodBeat.o(156845);
        return hitTestResult;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getTitle() {
        AppMethodBeat.i(156846);
        String title = this.SAi.getTitle();
        AppMethodBeat.o(156846);
        return title;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearMatches() {
        AppMethodBeat.i(156847);
        this.SAi.clearMatches();
        AppMethodBeat.o(156847);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findNext(boolean z) {
        AppMethodBeat.i(156848);
        this.SAi.findNext(z);
        AppMethodBeat.o(156848);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void findAllAsync(String str) {
        AppMethodBeat.i(156849);
        this.SAi.findAllAsync(str);
        AppMethodBeat.o(156849);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getVersionInfo() {
        AppMethodBeat.i(156850);
        String versionInfo = this.SAi.getVersionInfo();
        AppMethodBeat.o(156850);
        return versionInfo;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String getAbstractInfo() {
        AppMethodBeat.i(156851);
        String abstractInfo = this.SAi.getAbstractInfo();
        AppMethodBeat.o(156851);
        return abstractInfo;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public ac getCurWebviewClient() {
        AppMethodBeat.i(156852);
        ac curWebviewClient = this.SAi.getCurWebviewClient();
        AppMethodBeat.o(156852);
        return curWebviewClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public x getCurWebChromeClient() {
        AppMethodBeat.i(156853);
        x curWebChromeClient = this.SAi.getCurWebChromeClient();
        AppMethodBeat.o(156853);
        return curWebChromeClient;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean isSupportExtendPluginForAppbrand() {
        AppMethodBeat.i(156854);
        if (isXWalkKernel()) {
            boolean isSupportExtendPluginForAppbrand = this.SAi.isSupportExtendPluginForAppbrand();
            AppMethodBeat.o(156854);
            return isSupportExtendPluginForAppbrand;
        }
        AppMethodBeat.o(156854);
        return false;
    }

    public static void setX5Interface(com.tencent.xweb.x5.sdk.c cVar) {
        SAl = cVar;
    }

    public static int getUsingTbsCoreVersion(Context context) {
        AppMethodBeat.i(156855);
        if (SAf == c.WV_KIND_X5) {
            if (SAl != null) {
                int tbsCoreVersion = SAl.getTbsCoreVersion(context);
                AppMethodBeat.o(156855);
                return tbsCoreVersion;
            }
            Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        }
        AppMethodBeat.o(156855);
        return 0;
    }

    public static int getInstalledTbsCoreVersion(Context context) {
        AppMethodBeat.i(156856);
        if (SAl != null) {
            int tbsCoreVersion = SAl.getTbsCoreVersion(context);
            AppMethodBeat.o(156856);
            return tbsCoreVersion;
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        AppMethodBeat.o(156856);
        return 0;
    }

    @Deprecated
    public static int getTbsCoreVersion(Context context) {
        AppMethodBeat.i(156857);
        if (SAl != null) {
            int tbsCoreVersion = SAl.getTbsCoreVersion(context);
            AppMethodBeat.o(156857);
            return tbsCoreVersion;
        }
        Log.e("xweb.WebView", "getTbsCoreVersion: sImp is null");
        AppMethodBeat.o(156857);
        return 0;
    }

    public static int getTbsSDKVersion(Context context) {
        AppMethodBeat.i(156858);
        if (SAl != null) {
            int tbsSDKVersion = SAl.getTbsSDKVersion(context);
            AppMethodBeat.o(156858);
            return tbsSDKVersion;
        }
        Log.e("xweb.WebView", "getTbsSDKVersion: sImp is null");
        AppMethodBeat.o(156858);
        return 0;
    }

    public static String getCrashExtraMessage(Context context) {
        AppMethodBeat.i(156859);
        if (SAl != null) {
            String crashExtraMessage = SAl.getCrashExtraMessage(context);
            AppMethodBeat.o(156859);
            return crashExtraMessage;
        }
        Log.e("xweb.WebView", "getCrashExtraMessage: sImp is null");
        AppMethodBeat.o(156859);
        return "";
    }

    public static boolean getCanReboot() {
        AppMethodBeat.i(156860);
        if (SAh && XWebCoreInfo.getCurAbiInstalledNewestVersion(XWalkEnvironment.getApplicationContext()) > 0) {
            Log.i("xweb.WebView", "need rebot because of has installed xweb core ");
            AppMethodBeat.o(156860);
            return true;
        } else if (getCurWebType() != c.WV_KIND_CW || XWalkEnvironment.getAvailableVersion() <= 0 || XWalkEnvironment.getInstalledNewstVersionForCurAbi() <= XWalkEnvironment.getAvailableVersion()) {
            if (getCurWebType() == c.WV_KIND_X5) {
                if (SAl != null) {
                    boolean canReboot = SAl.getCanReboot();
                    AppMethodBeat.o(156860);
                    return canReboot;
                }
                Log.e("xweb.WebView", "getCanReboot: sImp is null");
            }
            if (com.tencent.xweb.internal.h.htF().htJ()) {
                AppMethodBeat.o(156860);
                return true;
            }
            AppMethodBeat.o(156860);
            return false;
        } else {
            Log.i("xweb.WebView", "need rebot because of has newer xweb version ");
            AppMethodBeat.o(156860);
            return true;
        }
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void reload() {
        AppMethodBeat.i(156861);
        this.SAi.reload();
        AppMethodBeat.o(156861);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearSslPreferences() {
        AppMethodBeat.i(156862);
        this.SAi.clearSslPreferences();
        AppMethodBeat.o(156862);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(156863);
        this.SAi.loadData(str, str2, str3);
        h.a(str, this);
        reportLoadByReason();
        AppMethodBeat.o(156863);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getContentHeight() {
        AppMethodBeat.i(156864);
        int contentHeight = this.SAi.getContentHeight();
        AppMethodBeat.o(156864);
        return contentHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public float getScale() {
        AppMethodBeat.i(156865);
        float scale = this.SAi.getScale();
        AppMethodBeat.o(156865);
        return scale;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollY() {
        AppMethodBeat.i(156866);
        int webScrollY = this.SAi.getWebScrollY();
        AppMethodBeat.o(156866);
        return webScrollY;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getWebScrollX() {
        AppMethodBeat.i(156867);
        int webScrollX = this.SAi.getWebScrollX();
        AppMethodBeat.o(156867);
        return webScrollX;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean isOverScrollStart() {
        AppMethodBeat.i(156868);
        boolean isOverScrollStart = this.SAi.isOverScrollStart();
        AppMethodBeat.o(156868);
        return isOverScrollStart;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getVisibleTitleHeight() {
        AppMethodBeat.i(156869);
        int visibleTitleHeight = this.SAi.getVisibleTitleHeight();
        AppMethodBeat.o(156869);
        return visibleTitleHeight;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean overlayHorizontalScrollbar() {
        AppMethodBeat.i(156870);
        boolean overlayHorizontalScrollbar = this.SAi.overlayHorizontalScrollbar();
        AppMethodBeat.o(156870);
        return overlayHorizontalScrollbar;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(156871);
        this.SAi.loadDataWithBaseURL(str, str2, str3, str4, str5);
        h.a(str, this);
        AppMethodBeat.o(156871);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomOut() {
        AppMethodBeat.i(156872);
        boolean zoomOut = this.SAi.zoomOut();
        AppMethodBeat.o(156872);
        return zoomOut;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean zoomIn() {
        AppMethodBeat.i(156873);
        boolean zoomIn = this.SAi.zoomIn();
        AppMethodBeat.o(156873);
        return zoomIn;
    }

    @Override // com.tencent.xweb.internal.IWebView
    @TargetApi(8)
    public void loadUrl(String str, Map<String, String> map) {
        AppMethodBeat.i(156874);
        if (this.SAk.bsn(str)) {
            this.SAi.loadUrl("http://weixin.qq.com/");
            AppMethodBeat.o(156874);
            return;
        }
        this.SAi.loadUrl(str, map);
        h.a(str, this);
        reportLoadByReason();
        AppMethodBeat.o(156874);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void addJavascriptInterface(Object obj, String str) {
        AppMethodBeat.i(156875);
        this.SAi.addJavascriptInterface(obj, str);
        AppMethodBeat.o(156875);
    }

    public void _enablePlatformNotifications() {
    }

    public void _disablePlatformNotifications() {
    }

    @Deprecated
    public static void enablePlatformNotifications() {
        AppMethodBeat.i(156876);
        if (getCurWebType() == c.WV_KIND_SYS) {
            g.oj("android.webkit.WebView", "enablePlatformNotifications");
        }
        AppMethodBeat.o(156876);
    }

    @Deprecated
    public static void disablePlatformNotifications() {
        AppMethodBeat.i(156877);
        if (getCurWebType() == c.WV_KIND_SYS) {
            g.oj("android.webkit.WebView", "disablePlatformNotifications");
        }
        AppMethodBeat.o(156877);
    }

    public boolean isX5WrappedSysKernel() {
        AppMethodBeat.i(175639);
        if (getCurWebType() != c.WV_KIND_X5 || this.isX5Kernel) {
            AppMethodBeat.o(175639);
            return false;
        }
        AppMethodBeat.o(175639);
        return true;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public z getSettings() {
        AppMethodBeat.i(156878);
        z settings = this.SAi.getSettings();
        AppMethodBeat.o(156878);
        return settings;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public View getWebViewUI() {
        AppMethodBeat.i(156879);
        View webViewUI = this.SAi.getWebViewUI();
        AppMethodBeat.o(156879);
        return webViewUI;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebViewClient(ac acVar) {
        AppMethodBeat.i(156880);
        if (acVar != null) {
            acVar.SzO = this.SAi.getDefalutOpProvider();
        }
        this.SAi.setWebViewClient(acVar);
        AppMethodBeat.o(156880);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setWebChromeClient(x xVar) {
        AppMethodBeat.i(156881);
        if (xVar != null) {
            xVar.SzO = this.SAi.getDefalutOpProvider();
        }
        this.SAi.setWebChromeClient(xVar);
        AppMethodBeat.o(156881);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setDownloadListener(DownloadListener downloadListener) {
        AppMethodBeat.i(156882);
        this.SAi.setDownloadListener(downloadListener);
        AppMethodBeat.o(156882);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setFindListener(WebView.FindListener findListener) {
        AppMethodBeat.i(156883);
        this.SAi.setFindListener(findListener);
        AppMethodBeat.o(156883);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void loadUrl(String str) {
        AppMethodBeat.i(156884);
        if (this.SAk.bsn(str)) {
            this.SAi.loadUrl("http://weixin.qq.com/");
            AppMethodBeat.o(156884);
            return;
        }
        this.SAi.loadUrl(str);
        h.a(str, this);
        reportLoadByReason();
        AppMethodBeat.o(156884);
    }

    public void startLongScreenshot(q qVar, boolean z) {
        AppMethodBeat.i(156885);
        if ((this.SAi instanceof com.tencent.xweb.internal.g) && this.SAj == c.WV_KIND_CW) {
            ((com.tencent.xweb.internal.g) this.SAi).a(((ViewGroup) getWebViewUI()).getChildAt(0), z, qVar);
        }
        AppMethodBeat.o(156885);
    }

    @Deprecated
    public void manualStartFrameCostProfiler() {
        AppMethodBeat.i(156886);
        f f2 = k.f(getCurWebType());
        if (f2 != null) {
            f2.htD().bsg("xprofile.frameCost");
        }
        AppMethodBeat.o(156886);
    }

    @Deprecated
    public void manualStopFrameCostProfiler(l lVar) {
        AppMethodBeat.i(156887);
        f f2 = k.f(getCurWebType());
        if (f2 != null) {
            f2.htD().a(lVar);
        }
        AppMethodBeat.o(156887);
    }

    public static boolean setProfileResultCallback(String str, k kVar) {
        AppMethodBeat.i(183498);
        f f2 = k.f(getCurWebType());
        if (f2 != null) {
            boolean profileResultCallback = f2.htD().setProfileResultCallback(str, kVar);
            AppMethodBeat.o(183498);
            return profileResultCallback;
        }
        AppMethodBeat.o(183498);
        return false;
    }

    public static void forceEnableFrameCostProfile() {
        AppMethodBeat.i(219049);
        f f2 = k.f(getCurWebType());
        if (f2 != null) {
            f2.htD().forceEnableFrameCostProfile();
        }
        AppMethodBeat.o(219049);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoBack() {
        AppMethodBeat.i(156888);
        boolean canGoBack = this.SAi.canGoBack();
        AppMethodBeat.o(156888);
        return canGoBack;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goBack() {
        AppMethodBeat.i(156889);
        this.SAi.goBack();
        AppMethodBeat.o(156889);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearView() {
        AppMethodBeat.i(156890);
        this.SAi.clearView();
        AppMethodBeat.o(156890);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void destroy() {
        AppMethodBeat.i(156891);
        this.SAi.destroy();
        AppMethodBeat.o(156891);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean hasEnteredFullscreen() {
        AppMethodBeat.i(156892);
        boolean hasEnteredFullscreen = this.SAi.hasEnteredFullscreen();
        AppMethodBeat.o(156892);
        return hasEnteredFullscreen;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void leaveFullscreen() {
        AppMethodBeat.i(156893);
        this.SAi.leaveFullscreen();
        AppMethodBeat.o(156893);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(156894);
        this.SAi.evaluateJavascript(str, valueCallback);
        AppMethodBeat.o(156894);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public a getFullscreenVideoKind() {
        AppMethodBeat.i(156895);
        a fullscreenVideoKind = this.SAi.getFullscreenVideoKind();
        AppMethodBeat.o(156895);
        return fullscreenVideoKind;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setJSExceptionListener(ae aeVar) {
        AppMethodBeat.i(156896);
        this.SAi.setJSExceptionListener(aeVar);
        AppMethodBeat.o(156896);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public Bundle invokeMiscMethod(String str, Bundle bundle) {
        AppMethodBeat.i(156897);
        Bundle invokeMiscMethod = this.SAi.invokeMiscMethod(str, bundle);
        AppMethodBeat.o(156897);
        return invokeMiscMethod;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean savePage(String str, String str2, int i2) {
        AppMethodBeat.i(156898);
        boolean savePage = this.SAi.savePage(str, str2, i2);
        AppMethodBeat.o(156898);
        return savePage;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void clearHistory() {
        AppMethodBeat.i(156899);
        this.SAi.clearHistory();
        AppMethodBeat.o(156899);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean canGoForward() {
        AppMethodBeat.i(156900);
        boolean canGoForward = this.SAi.canGoForward();
        AppMethodBeat.o(156900);
        return canGoForward;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void goForward() {
        AppMethodBeat.i(156901);
        this.SAi.goForward();
        AppMethodBeat.o(156901);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean supportFeature(int i2) {
        AppMethodBeat.i(156902);
        boolean supportFeature = this.SAi.supportFeature(i2);
        AppMethodBeat.o(156902);
        return supportFeature;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void smoothScroll(int i2, int i3, long j2) {
        AppMethodBeat.i(156903);
        this.SAi.smoothScroll(i2, i3, j2);
        AppMethodBeat.o(156903);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setBottomHeight(int i2) {
        AppMethodBeat.i(156904);
        this.SAi.setBottomHeight(i2);
        AppMethodBeat.o(156904);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onShow() {
        AppMethodBeat.i(156905);
        this.SAi.onShow();
        AppMethodBeat.o(156905);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void onHide() {
        AppMethodBeat.i(156906);
        this.SAi.onHide();
        AppMethodBeat.o(156906);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public int getScrollHeight() {
        AppMethodBeat.i(156907);
        int scrollHeight = this.SAi.getScrollHeight();
        AppMethodBeat.o(156907);
        return scrollHeight;
    }

    public CookieInternal.ICookieManagerInternal getCookieManager() {
        return null;
    }

    public CookieInternal.ICookieSyncManagerInternal getCookieSyncManager() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public com.tencent.xweb.internal.e getDefalutOpProvider() {
        return null;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setVerticalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(156908);
        this.SAi.setVerticalScrollBarEnabled(z);
        AppMethodBeat.o(156908);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHorizontalScrollBarEnabled(boolean z) {
        AppMethodBeat.i(156909);
        this.SAi.setHorizontalScrollBarEnabled(z);
        AppMethodBeat.o(156909);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void disableVideoJsCallback(boolean z) {
        AppMethodBeat.i(156910);
        this.SAi.disableVideoJsCallback(z);
        AppMethodBeat.o(156910);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public u setVideoJsCallback(v vVar) {
        AppMethodBeat.i(156911);
        u videoJsCallback = this.SAi.setVideoJsCallback(vVar);
        AppMethodBeat.o(156911);
        return videoJsCallback;
    }

    public static boolean isXWalk() {
        AppMethodBeat.i(156912);
        if (getCurWebType() == c.WV_KIND_CW) {
            AppMethodBeat.o(156912);
            return true;
        }
        AppMethodBeat.o(156912);
        return false;
    }

    public static boolean isX5() {
        AppMethodBeat.i(156913);
        if (getCurWebType() == c.WV_KIND_X5) {
            AppMethodBeat.o(156913);
            return true;
        }
        AppMethodBeat.o(156913);
        return false;
    }

    public static boolean isSys() {
        AppMethodBeat.i(156914);
        if (getCurWebType() == c.WV_KIND_SYS) {
            AppMethodBeat.o(156914);
            return true;
        }
        AppMethodBeat.o(156914);
        return false;
    }

    public void setA8keyReason(int i2) {
        this.SAm = i2;
    }

    public void reportLoadByReason() {
        AppMethodBeat.i(156915);
        h.asV(this.SAm);
        this.SAm = -1;
        AppMethodBeat.o(156915);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public boolean getImageBitmapToFile(String str, String str2, String str3, i iVar) {
        AppMethodBeat.i(156916);
        boolean imageBitmapToFile = this.SAi.getImageBitmapToFile(str, str2, str3, iVar);
        AppMethodBeat.o(156916);
        return imageBitmapToFile;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public WebBackForwardList copyBackForwardList() {
        AppMethodBeat.i(219050);
        WebBackForwardList copyBackForwardList = this.SAi.copyBackForwardList();
        AppMethodBeat.o(219050);
        return copyBackForwardList;
    }

    @Override // com.tencent.xweb.internal.IWebView
    public void setHttpAuthUsernamePassword(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(219051);
        this.SAi.setHttpAuthUsernamePassword(str, str2, str3, str4);
        AppMethodBeat.o(219051);
    }

    @Override // com.tencent.xweb.internal.IWebView
    public String[] getHttpAuthUsernamePassword(String str, String str2) {
        AppMethodBeat.i(219052);
        String[] httpAuthUsernamePassword = this.SAi.getHttpAuthUsernamePassword(str, str2);
        AppMethodBeat.o(219052);
        return httpAuthUsernamePassword;
    }
}
