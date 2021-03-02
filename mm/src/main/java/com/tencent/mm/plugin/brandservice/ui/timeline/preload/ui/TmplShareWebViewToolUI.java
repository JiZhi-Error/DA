package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.x;
import com.tencent.mm.plugin.appbrand.jsapi.share.o;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.UrlExKt;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.p;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.y;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(*\u0001 \b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010b\u001a\u00020AH\u0014J\u0012\u0010c\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0012\u0010d\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0010\u0010e\u001a\u00020\u00152\u0006\u0010f\u001a\u00020\u0015H\u0002J\u0012\u0010g\u001a\u00020A2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\n\u0010h\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010i\u001a\u00020_H\u0016J\u0012\u0010j\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010k\u001a\u00020AH\u0014J\u0012\u0010l\u001a\u00020a2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0006\u0010m\u001a\u00020\u0015J\u0012\u0010n\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\b\u0010o\u001a\u00020AH\u0016J\u0018\u0010p\u001a\u00020_2\u0006\u0010q\u001a\u00020\u00052\u0006\u0010r\u001a\u00020AH\u0014J\u0010\u0010s\u001a\u00020\u00052\u0006\u0010t\u001a\u00020\u0005H\u0014J\b\u0010u\u001a\u00020AH\u0014J\b\u0010v\u001a\u00020_H\u0014J\b\u0010w\u001a\u00020_H\u0014J\b\u0010x\u001a\u00020_H\u0014J\b\u0010y\u001a\u00020_H\u0014J\b\u0010z\u001a\u00020_H\u0014J\u0010\u0010{\u001a\u00020_2\u0006\u0010|\u001a\u00020\u0015H\u0016J\u0012\u0010}\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u000e\u0010~\u001a\u00020_2\u0006\u0010\u001a\u00020\u0005J\u0013\u0010\u0001\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0013\u0010\u0001\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0011\u0010\u0001\u001a\u00020_2\u0006\u0010f\u001a\u00020\u0015H\u0014J\t\u0010\u0001\u001a\u00020_H\u0014J\t\u0010\u0001\u001a\u00020_H\u0016J\u0013\u0010\u0001\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0013\u0010\u0001\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\t\u0010\u0001\u001a\u00020_H\u0014J\t\u0010\u0001\u001a\u00020_H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8DX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158DX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0004\n\u0002\u0010!R\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u00020)8DX\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b*\u0010+R#\u0010-\u001a\n /*\u0004\u0018\u00010.0.8DX\u0002¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b0\u00101R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001c\"\u0004\b;\u0010\u001eR#\u0010<\u001a\n /*\u0004\u0018\u00010\u00050\u00058DX\u0002¢\u0006\f\n\u0004\b?\u0010\u0011\u001a\u0004\b=\u0010>R\u001a\u0010@\u001a\u00020AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010\u001eR\u001b\u0010I\u001a\u00020\u00158DX\u0002¢\u0006\f\n\u0004\bK\u0010\u0011\u001a\u0004\bJ\u0010\u0017R\u001b\u0010L\u001a\u00020M8FX\u0002¢\u0006\f\n\u0004\bP\u0010\u0011\u001a\u0004\bN\u0010OR\u001b\u0010Q\u001a\u00020\u00158DX\u0002¢\u0006\f\n\u0004\bS\u0010\u0011\u001a\u0004\bR\u0010\u0017R\u001b\u0010T\u001a\u00020\u00158DX\u0002¢\u0006\f\n\u0004\bV\u0010\u0011\u001a\u0004\bU\u0010\u0017R\u001c\u0010W\u001a\u00020\u00158DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0017\"\u0004\bY\u0010ZR\u001b\u0010[\u001a\u00020\u00078DX\u0002¢\u0006\f\n\u0004\b]\u0010\u0011\u001a\u0004\b\\\u0010\t¨\u0006\u0001"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/preload/api/ITmplShareWebView;", "()V", "TAG", "", "_webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "get_webView", "()Lcom/tencent/mm/ui/widget/MMWebView;", "set_webView", "(Lcom/tencent/mm/ui/widget/MMWebView;)V", "contentRoot", "Landroid/view/ViewGroup;", "getContentRoot", "()Landroid/view/ViewGroup;", "contentRoot$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", Constants.PARAM_DENSITY, "", "enterId", "", "getEnterId", "()I", "enterId$delegate", "enterPageTime", "", "getEnterPageTime", "()J", "setEnterPageTime", "(J)V", "mOnForegroundListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1;", "mpMenuHelper", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "getMpMenuHelper", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;", "setMpMenuHelper", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/MpMenuHelper;)V", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo", "()Lcom/tencent/mm/message/MPMsgInfo;", "msgInfo$delegate", "nativePageRootLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getNativePageRootLayout", "()Landroid/view/View;", "nativePageRootLayout$delegate", "pageController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "getPageController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;", "setPageController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizNativePageController;)V", "pageStayTime", "getPageStayTime", "setPageStayTime", "publishId", "getPublishId", "()Ljava/lang/String;", "publishId$delegate", "redirectedFullScreenH5", "", "getRedirectedFullScreenH5", "()Z", "setRedirectedFullScreenH5", "(Z)V", "resumePageTime", "getResumePageTime", "setResumePageTime", "scene", "getScene", "scene$delegate", "shareLayout", "Landroid/widget/RelativeLayout;", "getShareLayout", "()Landroid/widget/RelativeLayout;", "shareLayout$delegate", "subScene", "getSubScene", "subScene$delegate", "timeLineSessionId", "getTimeLineSessionId", "timeLineSessionId$delegate", "videoEnterId", "getVideoEnterId", "setVideoEnterId", "(I)V", "webView", "getWebView", "webView$delegate", "adWebviewReady", "", "bundle", "Landroid/os/Bundle;", "canTryPreloadNextWebView", "closeAdWebview", "closeDotWebview", "convertFuncFlag", "flag", "createAdWebview", "createWebView", "doOnDestroy", "dotWebviewReady", "enableMinimize", "getMPVideoState", "getNaitivePageLayoutID", "hideDotWebview", "isNativePage", "loadForceUrl", "forceUrl", "fullScreen", "modifyForceUrl", "url", "needShowBottom", "onDestroy", "onPause", "onReset", "onResetAfterCreate", "onResume", "onWebViewScrollChanged", "scrollY", "opPlayer", "redirectFullScreenH5", "redirectUrl", "sendMPPageData", "setDotScriptData", "setFuncFlag", "setShareFuncFlag", "showReaderModeMenu", o.NAME, "switchVideo", "updateMenu", "updateShareContentHeight", "plugin-brandservice_release"})
public abstract class TmplShareWebViewToolUI extends TmplWebViewToolUI implements com.tencent.mm.plugin.webview.h.a.c {
    protected static final /* synthetic */ kotlin.l.k[] cLI = {aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "contentRoot", "getContentRoot()Landroid/view/ViewGroup;")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "webView", "getWebView()Lcom/tencent/mm/ui/widget/MMWebView;")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "nativePageRootLayout", "getNativePageRootLayout()Landroid/view/View;")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "msgInfo", "getMsgInfo()Lcom/tencent/mm/message/MPMsgInfo;")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "scene", "getScene()I")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "subScene", "getSubScene()I")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "enterId", "getEnterId()I")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "publishId", "getPublishId()Ljava/lang/String;")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "timeLineSessionId", "getTimeLineSessionId()I")), aa.a(new y(aa.bp(TmplShareWebViewToolUI.class), "shareLayout", "getShareLayout()Landroid/widget/RelativeLayout;"))};
    protected final String TAG = "MicroMsg.TmplShareWebViewToolUI";
    private HashMap _$_findViewCache;
    private float density = 3.0f;
    protected long nqe;
    protected long pGA;
    private final q pGB = s.a(this.pGZ, new j(this));
    private final q pGC = s.a(this.pGZ, new l(this));
    private final q pGD = s.a(this.pGZ, new c(this));
    private final q pGE = s.a(this.pGZ, new h(this));
    protected final q pGF = s.a(this.pGZ, new m(this));
    private final q pGG = s.a(this.pGZ, new k(this));
    private int pGH;
    private boolean pGI;
    private final d pGJ = new d(this);
    private final q pGs = s.a(this.pGZ, new a(this));
    MMWebView pGt;
    private final q pGu = s.a(this.pGZ, new n(this));
    private final q pGv = s.a(this.pGZ, new f(this));
    private final q pGw = s.a(this.pGZ, new e(this));
    public com.tencent.mm.plugin.brandservice.ui.timeline.video.b pGx = new com.tencent.mm.plugin.brandservice.ui.timeline.video.b();
    protected p pGy = new p();
    protected long pGz;

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    @Override // com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final ViewGroup cps() {
        return (ViewGroup) this.pGs.a(cLI[0]);
    }

    public final View cpt() {
        return (View) this.pGv.a(cLI[2]);
    }

    /* access modifiers changed from: protected */
    public final x cpu() {
        return (x) this.pGw.a(cLI[3]);
    }

    /* access modifiers changed from: protected */
    public final String cpv() {
        return (String) this.pGE.a(cLI[7]);
    }

    public final RelativeLayout cpw() {
        return (RelativeLayout) this.pGG.a(cLI[9]);
    }

    /* access modifiers changed from: protected */
    public final int getScene() {
        return ((Number) this.pGB.a(cLI[4])).intValue();
    }

    /* access modifiers changed from: protected */
    public final int getSubScene() {
        return ((Number) this.pGC.a(cLI[5])).intValue();
    }

    /* access modifiers changed from: protected */
    public final MMWebView getWebView() {
        return (MMWebView) this.pGu.a(cLI[1]);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    /* access modifiers changed from: protected */
    public final int cpx() {
        this.pGH = this.pGH == 0 ? ((Number) this.pGD.a(cLI[6])).intValue() : this.pGH;
        return this.pGH;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public final MMWebView cpy() {
        MMWebView cpy = super.cpy();
        if (cpy == null) {
            return null;
        }
        this.pGt = cpy;
        cpy.a(new b(this));
        return cpy;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "scrollY", "<anonymous parameter 2>", "<anonymous parameter 3>", "onWebViewScrollChanged", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$createWebView$1$1"})
    static final class b implements MMWebView.e {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        b(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            this.pGK = tmplShareWebViewToolUI;
        }

        @Override // com.tencent.mm.ui.widget.MMWebView.e
        public final void onWebViewScrollChanged(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(6869);
            this.pGK.DG(i3);
            AppMethodBeat.o(6869);
        }
    }

    public void DG(int i2) {
    }

    public final void aiE(String str) {
        kotlin.g.b.p.h(str, "redirectUrl");
        if (!this.pGI) {
            this.pGI = true;
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(context, cpu(), str);
            MMHandlerThread.postToMainThreadDelayed(new i(this), 300);
            com.tencent.mm.plugin.webview.i.a.agn(5);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class i implements Runnable {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        i(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            this.pGK = tmplShareWebViewToolUI;
        }

        public final void run() {
            AppMethodBeat.i(6876);
            this.pGK.finish();
            AppMethodBeat.o(6876);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public boolean cpz() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public void onReset() {
        this.pGt = null;
        View cpt = cpt();
        kotlin.g.b.p.g(cpt, "nativePageRootLayout");
        ViewParent parent = cpt.getParent();
        if (parent == null) {
            throw new t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup) parent).removeView(cpt());
        ViewParent parent2 = cpw().getParent();
        if (parent2 == null) {
            throw new t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup) parent2).removeView(cpw());
        super.onReset();
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
    public void cpA() {
        super.cpA();
        this.pGz = System.currentTimeMillis();
        EventCenter.instance.addListener(this.pGJ);
        MMWebView mMWebView = this.pGj;
        if (mMWebView != null) {
            mMWebView.setOnLongClickListener(g.pGL);
        }
        this.density = getWebView().getMMDensity();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class g implements View.OnLongClickListener {
        public static final g pGL = new g();

        static {
            AppMethodBeat.i(6874);
            AppMethodBeat.o(6874);
        }

        g() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(195867);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$onResetAfterCreate$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(195867);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        super.onResume();
        this.pGA = System.currentTimeMillis();
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        super.onPause();
        long currentTimeMillis = System.currentTimeMillis();
        this.nqe += currentTimeMillis - this.pGA;
        this.pGA = currentTimeMillis;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        cpB();
        super.onDestroy();
        EventCenter.instance.removeListener(this.pGJ);
    }

    public void cpB() {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean cpC() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void cpD() {
        this.pGy.ks(false);
        this.pGx.pHC.er(20, 0);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.h.a.c
    public final void X(Bundle bundle) {
        String str;
        p pVar = this.pGy;
        if (bundle != null) {
            str = bundle.getString(IssueStorage.COLUMN_EXT_INFO);
        } else {
            str = null;
        }
        pVar.pMf = str;
        this.pGy.ks(true);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void cpE() {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void ani() {
        this.pGy.ani();
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void Y(Bundle bundle) {
        x xVar = new x();
        xVar.A(bundle);
        xVar.t(getIntent());
        String str = xVar.iAi.url;
        kotlin.g.b.p.g(str, "msgInfo.item.url");
        String appendUrlParam = UrlExKt.appendUrlParam(UrlExKt.appendUrlParam(str, "isNativePage", "2"), "enterid", String.valueOf(cpx()));
        b.a aVar = new b.a();
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.brandservice.ui.timeline.preload.m.a(context, appendUrlParam, getIntent().getIntExtra(e.p.OzA, -1), getIntent().getIntExtra(e.p.Ozw, -1), getIntent().getIntExtra(e.p.Ozx, -1), getIntent(), -1, aVar, false);
        onReset();
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public boolean Z(Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void cpF() {
    }

    public void cpG() {
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public Bundle cpH() {
        return new Bundle();
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void aa(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void ab(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void ac(Bundle bundle) {
    }

    public void ad(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void ae(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.webview.h.a.c
    public void af(Bundle bundle) {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean cpI() {
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplShareWebViewToolUI$mOnForegroundListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/AppActiveEvent;", "callback", "", "event", "plugin-brandservice_release"})
    public static final class d extends IListener<com.tencent.mm.g.a.l> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            this.pGK = tmplShareWebViewToolUI;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(com.tencent.mm.g.a.l lVar) {
            com.tencent.mm.g.a.l lVar2 = lVar;
            if ((lVar2 != null ? lVar2.dCi : null) == null || lVar2.dCi.isActive) {
                return false;
            }
            this.pGK.pGz = 0;
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(6868);
            View bodyView = this.pGK.getBodyView();
            kotlin.g.b.p.g(bodyView, "bodyView");
            ViewParent parent = bodyView.getParent();
            if (parent == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(6868);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            AppMethodBeat.o(6868);
            return viewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMWebView;", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<MMWebView> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMWebView invoke() {
            AppMethodBeat.i(6883);
            MMWebView mMWebView = this.pGK.pGt;
            if (mMWebView == null) {
                kotlin.g.b.p.hyc();
            }
            AppMethodBeat.o(6883);
            return mMWebView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(6873);
            View inflate = this.pGK.getLayoutInflater().inflate(R.layout.jk, (ViewGroup) null);
            this.pGK.cps().addView(inflate);
            AppMethodBeat.o(6873);
            return inflate;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/message/MPMsgInfo;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(6872);
            x xVar = new x();
            xVar.u(this.pGK.getIntent());
            AppMethodBeat.o(6872);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(6877);
            Integer valueOf = Integer.valueOf(this.pGK.getIntent().getIntExtra(e.b.OyQ, 0));
            AppMethodBeat.o(6877);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(6879);
            Integer valueOf = Integer.valueOf(this.pGK.getIntent().getIntExtra(e.b.OyR, 10000));
            AppMethodBeat.o(6879);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(6871);
            Integer valueOf = Integer.valueOf(this.pGK.getIntent().getIntExtra("bizEnterId", 0));
            AppMethodBeat.o(6871);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(6875);
            String stringExtra = this.pGK.getIntent().getStringExtra("KPublisherId");
            AppMethodBeat.o(6875);
            return stringExtra;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(6880);
            Integer valueOf = Integer.valueOf(this.pGK.getIntent().getIntExtra("biz_video_session_id", 0));
            AppMethodBeat.o(6880);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/widget/RelativeLayout;", "invoke"})
    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ TmplShareWebViewToolUI pGK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(TmplShareWebViewToolUI tmplShareWebViewToolUI) {
            super(0);
            this.pGK = tmplShareWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(6878);
            RelativeLayout relativeLayout = new RelativeLayout(this.pGK.getContext());
            this.pGK.cps().addView(relativeLayout, new ViewGroup.MarginLayoutParams(-1, (int) (this.pGK.density * 200.0f)));
            AppMethodBeat.o(6878);
            return relativeLayout;
        }
    }
}
