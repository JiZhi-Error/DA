package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.e.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.af.e;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.platform.window.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.report.j;
import com.tencent.mm.plugin.appbrand.report.model.p;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public final class a extends FrameLayout implements e.c, com.tencent.mm.plugin.appbrand.page.a.e {
    private u cKe = null;
    private final u.c cKk = new u.c() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass1 */
        private int crC = 0;

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final void hF(int i2) {
            this.crC = i2;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final void bQ(boolean z) {
            AppMethodBeat.i(46965);
            a.this.mGP.s(z, this.crC);
            AppMethodBeat.o(46965);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.c
        public final int getHeight() {
            return this.crC;
        }
    };
    private MMFalseProgressBar iGX;
    public MMWebView iGY;
    ag lBN;
    private String mAppId;
    boolean mDestroyed = false;
    private c mGN;
    private f mGO;
    final e.a mGP;
    private String mGQ = "";
    private boolean mGR = true;
    boolean mGS = false;
    private boolean mGT;
    private d mGU;
    private final Set<AbstractC0600a> mGV = new android.support.v4.e.b();
    private final e.b mGW = new e.b() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass7 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.b
        public final void xK(int i2) {
            AppMethodBeat.i(227007);
            h.INSTANCE.dN(1097, i2);
            try {
                q runtime = a.this.lBN.getRuntime();
                i.b(a.this.getAppId(), runtime.bsC().appVersion, runtime.kAq.eix, 1097, i2);
                AppMethodBeat.o(227007);
            } catch (NullPointerException e2) {
                AppMethodBeat.o(227007);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.b
        public final void H(ArrayList<IDKey> arrayList) {
            AppMethodBeat.i(227008);
            h.INSTANCE.b(arrayList, false);
            try {
                q runtime = a.this.lBN.getRuntime();
                Iterator<IDKey> it = arrayList.iterator();
                while (it.hasNext()) {
                    IDKey next = it.next();
                    i.a(a.this.getAppId(), runtime.bsC().appVersion, runtime.kAq.eix, next.GetID(), next.GetKey(), 1);
                }
                AppMethodBeat.o(227008);
            } catch (NullPointerException e2) {
                AppMethodBeat.o(227008);
            }
        }
    };
    private ab mGX = new ab() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass8 */

        @Override // com.tencent.xweb.ab
        public final boolean B(MotionEvent motionEvent) {
            AppMethodBeat.i(227009);
            boolean am = a.this.iGY.am(motionEvent);
            AppMethodBeat.o(227009);
            return am;
        }

        @Override // com.tencent.xweb.ab
        public final boolean b(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
            AppMethodBeat.i(227010);
            boolean c2 = a.this.iGY.c(i2, i3, i4, i5, i6, i7, i8, i9, z);
            AppMethodBeat.o(227010);
            return c2;
        }

        @Override // com.tencent.xweb.ab
        public final void bLv() {
            AppMethodBeat.i(227011);
            a.this.iGY.gYY();
            AppMethodBeat.o(227011);
        }

        @Override // com.tencent.xweb.ab
        @TargetApi(9)
        public final void d(int i2, int i3, boolean z, boolean z2) {
            AppMethodBeat.i(227012);
            a.this.iGY.h(i2, i3, z, z2);
            AppMethodBeat.o(227012);
        }

        @Override // com.tencent.xweb.ab
        public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
            AppMethodBeat.i(227013);
            a.this.iGY.R(i2, i3, i4, i5);
            AppMethodBeat.o(227013);
        }

        @Override // com.tencent.xweb.ab
        public final boolean C(MotionEvent motionEvent) {
            AppMethodBeat.i(227014);
            boolean an = a.this.iGY.an(motionEvent);
            AppMethodBeat.o(227014);
            return an;
        }

        @Override // com.tencent.xweb.ab
        public final boolean D(MotionEvent motionEvent) {
            AppMethodBeat.i(227015);
            boolean ao = a.this.iGY.ao(motionEvent);
            AppMethodBeat.o(227015);
            return ao;
        }
    };
    private com.tencent.xweb.x5.export.external.extension.proxy.a mGY = new com.tencent.xweb.x5.export.external.extension.proxy.a() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass9 */

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean onTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(227016);
            boolean B = a.this.mGX.B(motionEvent);
            AppMethodBeat.o(227016);
            return B;
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(227017);
            boolean D = a.this.mGX.D(motionEvent);
            AppMethodBeat.o(227017);
            return D;
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            AppMethodBeat.i(227018);
            boolean C = a.this.mGX.C(motionEvent);
            AppMethodBeat.o(227018);
            return C;
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
            AppMethodBeat.i(227019);
            boolean b2 = a.this.mGX.b(i2, i3, i4, i5, i6, i7, i8, i9, z);
            AppMethodBeat.o(227019);
            return b2;
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
            AppMethodBeat.i(227020);
            a.this.mGX.onScrollChanged(i2, i3, i4, i5, view);
            AppMethodBeat.o(227020);
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
            AppMethodBeat.i(227021);
            a.this.mGX.d(i2, i3, z, z2);
            AppMethodBeat.o(227021);
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void computeScroll(View view) {
            AppMethodBeat.i(227022);
            a.this.mGX.bLv();
            AppMethodBeat.o(227022);
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final void invalidate() {
        }

        @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.i(227023);
            if (Util.isNullOrNil(str) || bundle == null) {
                AppMethodBeat.o(227023);
                return null;
            }
            Log.i("MicroMsg.AppBrandHTMLWebView", "method = %s", str);
            if ("onJavascriptCloseWindow".equals(str)) {
                Boolean bool = Boolean.TRUE;
                AppMethodBeat.o(227023);
                return bool;
            }
            AppMethodBeat.o(227023);
            return null;
        }
    };
    private int mViewId = 0;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.af.a$a  reason: collision with other inner class name */
    public interface AbstractC0600a {
        void bLw();
    }

    public final void a(AbstractC0600a aVar) {
        AppMethodBeat.i(46986);
        if (!this.mDestroyed) {
            this.mGV.add(aVar);
        }
        AppMethodBeat.o(46986);
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(46987);
        if (i2 != getVisibility()) {
            super.setVisibility(i2);
            for (AbstractC0600a aVar : this.mGV) {
                aVar.bLw();
            }
        }
        AppMethodBeat.o(46987);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.e
    public final void bLp() {
        AppMethodBeat.i(46988);
        Log.i("MicroMsg.AppBrandHTMLWebView", "restoreRendering hash[%d]", Integer.valueOf(hashCode()));
        this.iGY.onShow();
        AppMethodBeat.o(46988);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.a.e
    public final void bLq() {
        AppMethodBeat.i(46989);
        Log.i("MicroMsg.AppBrandHTMLWebView", "pauseRendering hash[%d]", Integer.valueOf(hashCode()));
        this.iGY.onHide();
        AppMethodBeat.o(46989);
    }

    final class d implements i.b, i.d {
        private d() {
        }

        /* synthetic */ d(a aVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
        public final void onBackground() {
            AppMethodBeat.i(46984);
            a.this.mGP.onBackground();
            AppMethodBeat.o(46984);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
        public final void onForeground() {
            AppMethodBeat.i(46985);
            a.this.mGP.onForeground();
            AppMethodBeat.o(46985);
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public a(Context context, AppBrandRuntime appBrandRuntime, ag agVar) {
        super(new MutableContextWrapper(context));
        boolean z;
        AppMethodBeat.i(46990);
        Log.i("MicroMsg.AppBrandHTMLWebView", "<init> start hash[%d]", Integer.valueOf(hashCode()));
        this.mAppId = appBrandRuntime.mAppId;
        this.mGN = new c();
        this.mGN.g(agVar);
        this.lBN = agVar;
        this.iGY = MMWebViewWithJsApi.a.hZ(new MutableContextWrapper(context));
        this.iGY.setBackgroundColor(0);
        this.iGY.getSettings().hsU();
        this.iGY.getSettings().setJavaScriptEnabled(true);
        this.iGY.getSettings().setMediaPlaybackRequiresUserGesture(false);
        this.iGY.getSettings().hsW();
        String userAgentString = this.iGY.getSettings().getUserAgentString();
        this.iGY.getSettings().setUserAgentString((!z.bfF(userAgentString) ? z.cr(getContext(), userAgentString) : userAgentString) + " miniProgram");
        this.iGY.getView().setHorizontalScrollBarEnabled(false);
        this.iGY.getView().setVerticalScrollBarEnabled(false);
        this.iGY.getSettings().setBuiltInZoomControls(true);
        this.iGY.getSettings().setUseWideViewPort(true);
        this.iGY.getSettings().setLoadWithOverviewMode(true);
        this.iGY.getSettings().hsN();
        this.iGY.getSettings().hsM();
        this.iGY.getSettings().setGeolocationEnabled(true);
        this.iGY.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.iGY.getSettings().hsS();
        this.iGY.getSettings().setAppCachePath(getContext().getDir("webviewcache", 0).getAbsolutePath());
        this.iGY.getSettings().hsR();
        this.iGY.getSettings().hsT();
        this.iGY.getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
        this.iGY.getSettings().hsX();
        this.iGY.setWebViewCallbackClient(this.mGX);
        if (this.iGY.getIsX5Kernel()) {
            this.iGY.setWebViewClientExtension(this.mGY);
        }
        this.iGY.getSettings().setUsingForAppBrand(2);
        this.iGY.setDownloadListener(new DownloadListener() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass2 */

            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                AppMethodBeat.i(46966);
                boolean z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_html_webview_outer_link_download, 1) > 0;
                Log.i("MicroMsg.AppBrandHTMLWebView", "onDownloadStart page[%s], downloadUrl[%s], userAgent[%s], contentDisposition[%s], mime[%s], contentLength[%d], allowDownloadByExpt[%b]", a.this.lBN.lBI, str, str2, str3, str4, Long.valueOf(j2), Boolean.valueOf(z));
                a.this.mGW.xK(0);
                if (!z) {
                    AppMethodBeat.o(46966);
                    return;
                }
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                try {
                    Context activity = a.this.lBN.getActivity();
                    if (activity == null) {
                        activity = MMApplicationContext.getContext();
                    }
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView$2", "onDownloadStart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(46966);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandHTMLWebView", "startActivity fail, e = " + e2.getMessage());
                    AppMethodBeat.o(46966);
                }
            }
        });
        Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end WebView construct hash[%d]", Integer.valueOf(hashCode()));
        addView(this.iGY, new ViewGroup.LayoutParams(-1, -1));
        this.iGX = new MMFalseProgressBar(context);
        this.iGX.setProgressDrawable(com.tencent.mm.cb.a.l(context, R.drawable.aik));
        addView(this.iGX, new ViewGroup.LayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(context, 3)));
        this.iGX.start();
        this.mGP = new f(this);
        this.lBN.a(new i.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
            public final void onDestroy() {
                AppMethodBeat.i(46967);
                a.this.destroy();
                AppMethodBeat.o(46967);
            }
        });
        getExitReporter().nKd = true;
        b bVar = b.mHb;
        b.j(this);
        com.tencent.xweb.u videoJsCallback = this.iGY.setVideoJsCallback(new d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass4 */

            @Override // com.tencent.xweb.v
            public final boolean xJ(int i2) {
                AppMethodBeat.i(227005);
                com.tencent.mm.plugin.appbrand.platform.window.d fullscreenImpl = a.this.lBN == null ? null : a.this.lBN.getFullscreenImpl();
                if (fullscreenImpl != null) {
                    fullscreenImpl.vH(d.a.yX(i2));
                    AppMethodBeat.o(227005);
                    return true;
                }
                Log.w("MicroMsg.AppBrandHTMLWebView", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl");
                AppMethodBeat.o(227005);
                return false;
            }
        });
        if (videoJsCallback == null || !videoJsCallback.hsA()) {
            z = false;
        } else {
            z = true;
        }
        this.mGT = z;
        Log.i("MicroMsg.AppBrandHTMLWebView", "<init> end total construct hash[%d], supportOrientationControl[%b]", Integer.valueOf(hashCode()), Boolean.valueOf(this.mGT));
        AppMethodBeat.o(46990);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final ac getPageView() {
        return this.lBN;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final boolean bLr() {
        return !this.mGT;
    }

    public final int getBinderID() {
        AppMethodBeat.i(174921);
        int binderID = this.mGP.getBinderID();
        AppMethodBeat.o(174921);
        return binderID;
    }

    public final void destroy() {
        AppMethodBeat.i(46991);
        AnonymousClass5 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(180277);
                if (!a.this.mDestroyed) {
                    Log.i("MicroMsg.AppBrandHTMLWebView", "destroy hash[%d]", Integer.valueOf(a.this.hashCode()));
                    a.this.mGP.cleanup();
                    a.this.iGY.stopLoading();
                    a.this.iGY.destroy();
                    a.this.mGV.clear();
                    b bVar = b.mHb;
                    b.k(a.this);
                    a.this.mDestroyed = true;
                }
                AppMethodBeat.o(180277);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(46991);
            return;
        }
        new Handler(Looper.getMainLooper()).post(r0);
        AppMethodBeat.o(46991);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(46992);
        if (this.mDestroyed) {
            AppMethodBeat.o(46992);
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (this.mGO != null) {
                    this.mGO.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.mGO != null) {
                    this.mGO.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (!dispatchTouchEvent && this.mGO != null) {
            this.mGO.requestDisallowInterceptTouchEvent(false);
        }
        AppMethodBeat.o(46992);
        return dispatchTouchEvent;
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(46993);
        if (getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            switch (View.MeasureSpec.getMode(i3)) {
                case Integer.MIN_VALUE:
                    i3 = View.MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(viewGroup.getMeasuredHeight(), View.MeasureSpec.getSize(i3))), Integer.MIN_VALUE);
                    break;
                case 0:
                    i3 = View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), Integer.MIN_VALUE);
                    break;
                case 1073741824:
                    if (View.MeasureSpec.getSize(i3) > viewGroup.getMeasuredHeight()) {
                        i3 = View.MeasureSpec.makeMeasureSpec(viewGroup.getMeasuredHeight(), 1073741824);
                        break;
                    }
                    break;
            }
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(46993);
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(46994);
        super.onAttachedToWindow();
        this.cKe = n.cY(this);
        if (this.cKe != null) {
            this.cKe.a(this.cKk);
        }
        this.mGO = (f) this.lBN.S(f.class);
        this.mGU = new d(this, (byte) 0);
        d dVar = this.mGU;
        a.this.lBN.a((i.d) dVar);
        a.this.lBN.a((i.b) dVar);
        this.mGU.onForeground();
        AppMethodBeat.o(46994);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(46995);
        super.onDetachedFromWindow();
        if (!this.lBN.isRunning()) {
            destroy();
        }
        if (this.cKe != null) {
            this.cKe.b(this.cKk);
        }
        if (this.mGU != null) {
            this.mGU.onBackground();
            d dVar = this.mGU;
            a.this.lBN.b((i.b) dVar);
            a.this.lBN.b((i.d) dVar);
            this.mGU = null;
        }
        AppMethodBeat.o(46995);
    }

    public final void setViewId(int i2) {
        this.mViewId = i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final String getAppId() {
        return this.mAppId;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final boolean NA() {
        return this.lBN instanceof com.tencent.mm.plugin.appbrand.game.f.d;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final MMWebView getWebView() {
        return this.iGY;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void runOnUiThread(Runnable runnable) {
        AppMethodBeat.i(46996);
        if (MMHandlerThread.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(46996);
            return;
        }
        post(runnable);
        AppMethodBeat.o(46996);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void ah(JSONObject jSONObject) {
        AppMethodBeat.i(46997);
        this.mGN.b(this.lBN.getRuntime().bsE(), this.lBN.getComponentId()).Zg(jSONObject.toString()).bEo();
        AppMethodBeat.o(46997);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void abB(String str) {
        AppMethodBeat.i(46998);
        if (TextUtils.isEmpty(str) || URLUtil.isValidUrl(str)) {
            AppMethodBeat.o(46998);
            return;
        }
        this.lBN.YO(str);
        AppMethodBeat.o(46998);
    }

    static final class c extends s {
        public static final int CTRL_INDEX = 504;
        public static final String NAME = "onWebviewStartLoad";

        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void abC(String str) {
        AppMethodBeat.i(46999);
        Log.i("MicroMsg.AppBrandHTMLWebView", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", str, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(android.support.v4.view.u.aD(this)));
        if (this.mDestroyed) {
            AppMethodBeat.o(46999);
            return;
        }
        bLt();
        this.iGX.start();
        new c((byte) 0).g(this.lBN).p("src", str).p("htmlId", Integer.valueOf(this.mViewId)).bEo();
        AppMethodBeat.o(46999);
    }

    static final class b extends s {
        public static final int CTRL_INDEX = 505;
        public static final String NAME = "onWebviewFinishLoad";

        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void cW(String str) {
        AppMethodBeat.i(47000);
        Log.i("MicroMsg.AppBrandHTMLWebView", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", str, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed), Boolean.valueOf(android.support.v4.view.u.aD(this)));
        if (this.mDestroyed) {
            AppMethodBeat.o(47000);
            return;
        }
        bLt();
        this.iGX.finish();
        if (!this.mGR && !this.mGS) {
            p exitReporter = getExitReporter();
            ag agVar = this.lBN;
            String str2 = this.mGQ;
            exitReporter.nIU = exitReporter.nKb.peekFirst();
            exitReporter.nIV = 2;
            exitReporter.nIW = str;
            exitReporter.nKb.push(str2);
            exitReporter.y(agVar);
        }
        this.mGR = false;
        this.mGS = false;
        setCurrentURL(str);
        new b((byte) 0).g(this.lBN).p("src", str).p("htmlId", Integer.valueOf(this.mViewId)).bEo();
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.af.a.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(227006);
                new com.tencent.mm.plugin.appbrand.game.e.b.b().a(a.this.lBN.bsE(), b.a.AfterWebViewLoad, a.this.mViewId);
                AppMethodBeat.o(227006);
            }
        }, 1000);
        AppMethodBeat.o(47000);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void abD(String str) {
        AppMethodBeat.i(227024);
        if (this.mDestroyed) {
            Log.i("MicroMsg.AppBrandHTMLWebView", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", str, Integer.valueOf(hashCode()), Boolean.valueOf(this.mDestroyed));
            AppMethodBeat.o(227024);
            return;
        }
        bLt();
        AppMethodBeat.o(227024);
    }

    static final class e extends s {
        public static final int CTRL_INDEX = 506;
        public static final String NAME = "onWebviewError";

        private e() {
        }

        /* synthetic */ e(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void z(String str, int i2, String str2) {
        AppMethodBeat.i(47001);
        new e((byte) 0).g(this.lBN).p("htmlId", Integer.valueOf(this.mViewId)).p(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, Integer.valueOf(i2)).p("description", str2).p("src", str).bEo();
        AppMethodBeat.o(47001);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void bLs() {
        AppMethodBeat.i(47002);
        this.lBN.getRuntime().bsD().adF("scene_other");
        AppMethodBeat.o(47002);
    }

    private void bLt() {
        AppMethodBeat.i(47003);
        this.iGY.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
        AppMethodBeat.o(47003);
    }

    public final p getExitReporter() {
        AppMethodBeat.i(227025);
        p bOB = this.lBN.getRuntime().bsD().getReporter().bOB();
        AppMethodBeat.o(227025);
        return bOB;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final e.b getReporter() {
        return this.mGW;
    }

    private com.tencent.mm.plugin.appbrand.report.model.q getGameResourceReporter() {
        AppMethodBeat.i(180293);
        com.tencent.mm.plugin.appbrand.report.model.q bOC = this.lBN.getRuntime().bsD().getReporter().bOC();
        AppMethodBeat.o(180293);
        return bOC;
    }

    private void setCurrentURL(String str) {
        AppMethodBeat.i(47005);
        this.mGQ = str;
        if (!Util.isNullOrNil(str)) {
            String host = Uri.parse(str).getHost();
            if (!Util.isNullOrNil(host)) {
                setPullDownText$d3a6df8(getContext().getString(R.string.izp, host));
                AppMethodBeat.o(47005);
                return;
            }
        }
        setPullDownText$d3a6df8("");
        AppMethodBeat.o(47005);
    }

    private void setPullDownText$d3a6df8(String str) {
        AppMethodBeat.i(47006);
        if (this.mGO != null) {
            this.mGO.setPullDownText(str);
        }
        AppMethodBeat.o(47006);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final String[] getJsApiReportArgs() {
        String url;
        AppMethodBeat.i(47007);
        if (this.mDestroyed) {
            String[] strArr = new String[0];
            AppMethodBeat.o(47007);
            return strArr;
        }
        ag agVar = this.lBN;
        q runtime = agVar.getRuntime();
        AppBrandStatObject appBrandStatObject = runtime.ON().cyA;
        AppBrandInitConfigWC bsC = runtime.bsC();
        a bRM = agVar.bRM();
        String[] strArr2 = new String[19];
        strArr2[0] = new StringBuilder().append(appBrandStatObject.scene).toString();
        strArr2[1] = appBrandStatObject.dCw;
        strArr2[2] = runtime.mAppId;
        strArr2[3] = new StringBuilder().append(runtime.bsB().leE.pkgVersion).toString();
        strArr2[4] = bsC.cym;
        strArr2[5] = new StringBuilder().append(runtime.bsB().leE.kNW + 1).toString();
        strArr2[6] = new StringBuilder().append(appBrandStatObject.nHt).toString();
        strArr2[7] = agVar.lBI;
        if (bRM == null) {
            url = "";
        } else {
            url = bRM.getWebView().getUrl();
        }
        strArr2[8] = url;
        strArr2[9] = com.tencent.mm.plugin.appbrand.report.i.getNetworkType(agVar.getContext());
        strArr2[10] = "";
        strArr2[11] = "";
        strArr2[12] = "";
        strArr2[13] = "";
        strArr2[14] = "";
        strArr2[15] = "";
        strArr2[16] = new StringBuilder().append(appBrandStatObject.ecU).toString();
        strArr2[17] = appBrandStatObject.ecV;
        strArr2[18] = new StringBuilder().append(runtime.bsC().cyo + 1000).toString();
        AppMethodBeat.o(47007);
        return strArr2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final void a(String str, WebResourceRequest webResourceRequest) {
        AppMethodBeat.i(180294);
        com.tencent.mm.plugin.appbrand.report.model.q gameResourceReporter = getGameResourceReporter();
        ag agVar = this.lBN;
        if (gameResourceReporter.nIR || webResourceRequest == null) {
            AppMethodBeat.o(180294);
            return;
        }
        gameResourceReporter.pageUrl = str;
        gameResourceReporter.url = webResourceRequest.getUrl().toString();
        gameResourceReporter.method = webResourceRequest.getMethod();
        gameResourceReporter.referer = webResourceRequest.getRequestHeaders().get("Referer");
        AppBrandSysConfigWC bsB = agVar.getRuntime().bsB();
        if (bsB != null) {
            gameResourceReporter.appVersion = bsB.leE.pkgVersion;
        }
        gameResourceReporter.networkType = com.tencent.mm.plugin.appbrand.report.i.getNetworkType(MMApplicationContext.getContext());
        q runtime = agVar.getRuntime();
        AppBrandInitConfigWC bsC = runtime == null ? null : runtime.bsC();
        if (bsC != null) {
            gameResourceReporter.appType = bsC.cyo;
        } else {
            gameResourceReporter.appType = j.aeJ(gameResourceReporter.appId);
            Log.i("MicroMsg.AppBrand.Report.kv_19358", "prepareCommonFields null = initConfig! apptype:%s", Integer.valueOf(gameResourceReporter.appType));
        }
        gameResourceReporter.appType += 1000;
        if (!gameResourceReporter.nIR) {
            Log.i("MicroMsg.AppBrand.Report.kv_19358", "report " + gameResourceReporter.toString());
            h.INSTANCE.a(19358, com.tencent.mm.plugin.appbrand.report.s.k(gameResourceReporter.appId, Integer.valueOf(gameResourceReporter.appVersion), Integer.valueOf(gameResourceReporter.dCv), Integer.valueOf(gameResourceReporter.appType), gameResourceReporter.networkType, gameResourceReporter.pageUrl, gameResourceReporter.url, gameResourceReporter.method, Integer.valueOf(gameResourceReporter.nKg), Integer.valueOf(gameResourceReporter.nKh), Integer.valueOf(gameResourceReporter.statusCode), Integer.valueOf(gameResourceReporter.nKi), gameResourceReporter.referer));
        }
        AppMethodBeat.o(180294);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.af.e.c
    public final boolean bLu() {
        AppMethodBeat.i(47008);
        try {
            if (this.lBN.getRuntime().bsB().cyp) {
                boolean z = this.lBN.getRuntime().bsB().cyF;
                AppMethodBeat.o(47008);
                return z;
            }
            boolean z2 = this.lBN.getRuntime().bsB().cyC;
            AppMethodBeat.o(47008);
            return z2;
        } catch (NullPointerException e2) {
            AppMethodBeat.o(47008);
            return false;
        }
    }
}
