package com.tencent.mm.plugin.scanner.box;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.scanner.box.BaseBoxDialogView;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.d.o;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019*\u0003(+0\u0018\u0000 q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001qB\u001f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\b\u00106\u001a\u000204H\u0016J\u0010\u00107\u001a\u0002042\u0006\u00108\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0004J\b\u00109\u001a\u00020\u0005H\u0016J\n\u0010:\u001a\u0004\u0018\u00010;H\u0016J\n\u0010<\u001a\u0004\u0018\u00010\u0014H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\tH\u0016J\u0018\u0010@\u001a\u0002042\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010A\u001a\u000204H\u0002J\b\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u000204H\u0002J\b\u0010D\u001a\u000204H\u0002J\b\u0010E\u001a\u00020\u0018H\u0016J\b\u0010F\u001a\u000204H\u0016J\b\u0010G\u001a\u000204H\u0016J\b\u0010H\u001a\u000204H\u0002J\u0012\u0010H\u001a\u0002042\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010K\u001a\u000204H\u0016J\b\u0010L\u001a\u000204H\u0016J\b\u0010M\u001a\u000204H\u0016J\b\u0010N\u001a\u000204H\u0002J\u0006\u0010O\u001a\u000204J\u000e\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020RJ\u000e\u0010S\u001a\u0002042\u0006\u0010\r\u001a\u00020TJ\u000e\u0010U\u001a\u0002042\u0006\u0010V\u001a\u00020WJ\u000e\u0010X\u001a\u0002042\u0006\u0010\r\u001a\u00020YJ\u0010\u0010Z\u001a\u0002042\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010[\u001a\u0002042\u0006\u0010\\\u001a\u00020\u001fJ\u000e\u0010]\u001a\u0002042\u0006\u0010^\u001a\u00020\u0018J\u000e\u0010_\u001a\u0002042\u0006\u0010`\u001a\u00020\u0018J\u000e\u0010a\u001a\u0002042\u0006\u0010\u001a\u001a\u00020\u0018J\u000e\u0010b\u001a\u0002042\u0006\u0010\u001b\u001a\u00020\u0018J\u000e\u0010c\u001a\u0002042\u0006\u0010`\u001a\u00020\u0018J\u000e\u0010d\u001a\u0002042\u0006\u0010e\u001a\u00020\u0007J\u000e\u0010f\u001a\u0002042\u0006\u0010g\u001a\u00020\u001fJ\u000e\u0010h\u001a\u0002042\u0006\u0010i\u001a\u00020\u0018J\u000e\u0010j\u001a\u0002042\u0006\u0010k\u001a\u00020JJ\u000e\u0010l\u001a\u0002042\u0006\u0010&\u001a\u00020\u0018J\b\u0010m\u001a\u000204H\u0016J\b\u0010n\u001a\u000204H\u0016J\b\u0010o\u001a\u000204H\u0002J\b\u0010p\u001a\u000204H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u000e¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u00020+X\u000e¢\u0006\u0004\n\u0002\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u000200X\u000e¢\u0006\u0004\n\u0002\u00101R\u000e\u00102\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog;", "Landroid/support/v7/app/AppCompatDialog;", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogModel;", "context", "Landroid/content/Context;", "theme", "", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "(Landroid/content/Context;ILcom/tencent/mm/protocal/protobuf/BoxHomeContext;)V", "dialogView", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialogViewListener;)V", "boxDialogViewListener", "boxWebData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebData;", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "boxWebViewJSApi", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "enableCancelOutside", "", "enableDialogScroll", "enableFullScreen", "enableScrollRightClose", "enableWebViewScroll", "fixedDialogHeight", "fixedDialogHeightRate", "", "isAttachedToWindow", "isFixedDialogHeight", "mContext", "mDialogView", "mExitType", "pendingShow", "showAfterWebViewReady", "webViewCallback", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1;", "webViewClientListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1;", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "webViewControllerListener", "com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1;", "webViewReady", "configFullScreen", "", "createWebView", "dismiss", "dismissDialog", "exitType", "getActivityContext", "getBoxWebData", "Lcom/tencent/mm/plugin/box/webview/IBoxWebData;", "getBoxWebView", "getBoxWebViewJsApi", "Lcom/tencent/mm/plugin/box/webview/BoxWebViewJSApi;", "getHomeContext", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initContentView", "initJsApi", "initWebView", "initWebViewController", "isShowingDialog", "onAttachedToWindow", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDetachedFromWindow", "onPause", "onResume", "realShow", "release", "setBackgroundOpView", "opView", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundOpViewModel;", "setBackgroundTouchListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundTouchListener;", "setBackgroundViewModel", "viewModel", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogBackgroundViewModel;", "setBoxDialogMoveListener", "Lcom/tencent/mm/plugin/scanner/box/BoxDialogMoveListener;", "setBoxDialogViewListener", "setDimAmount", "amount", "setEnableCancelOutside", "enable", "setEnableDialogScroll", "enableScroll", "setEnableFullScreen", "setEnableScrollRightClose", "setEnableWebViewScroll", "setFixDialogHeight", "fixedHeight", "setFixDialogHeightRate", "rate", "setIsFixDialogHeight", "fixed", "setReportData", "data", "setShowAfterWebViewPageReady", "show", "showDialog", "startLoadUrl", "webviewUIReady", "Companion", "plugin-scan_release"})
public final class i extends android.support.v7.app.e implements com.tencent.mm.plugin.box.c.b, e {
    public static final a CCM = new a((byte) 0);
    boolean CAK = true;
    boolean CAL;
    private boolean CBG;
    int CBH;
    float CBJ;
    private h CCA = new h(this);
    p CCB;
    q CCC;
    private j CCD;
    public BaseBoxDialogView CCE;
    private int CCF;
    private boolean CCG = true;
    boolean CCH = true;
    boolean CCI = true;
    boolean CCJ;
    private boolean CCK;
    private boolean CCL;
    BaseWebViewController CCx;
    private j CCy = new j(this);
    private C1667i CCz = new C1667i(this);
    private boolean isAttachedToWindow;
    private Context mContext;
    private qt plO;
    BoxWebView plR;

    static {
        AppMethodBeat.i(52131);
        AppMethodBeat.o(52131);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "invoke"})
    static final class b extends q implements kotlin.g.a.q<Boolean, Boolean, Boolean, x> {
        final /* synthetic */ i CCN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(i iVar) {
            super(3);
            this.CCN = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Boolean bool, Boolean bool2, Boolean bool3) {
            AppMethodBeat.i(240254);
            boolean booleanValue = bool.booleanValue();
            boolean booleanValue2 = bool2.booleanValue();
            boolean booleanValue3 = bool3.booleanValue();
            j jVar = this.CCN.CCD;
            if (jVar != null) {
                jVar.n(booleanValue, booleanValue2, booleanValue3);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(240254);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxDialog$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ qt a(i iVar) {
        AppMethodBeat.i(240273);
        qt qtVar = iVar.plO;
        if (qtVar == null) {
            p.btv("homeContext");
        }
        AppMethodBeat.o(240273);
        return qtVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onBinded", "", "plugin-scan_release"})
    public static final class j extends com.tencent.mm.plugin.webview.core.j {
        final /* synthetic */ i CCN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(i iVar) {
            this.CCN = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.core.j
        public final void ePr() {
            com.tencent.mm.plugin.webview.stub.e fZs;
            int i2;
            AppMethodBeat.i(240266);
            try {
                BaseWebViewController baseWebViewController = this.CCN.CCx;
                if (baseWebViewController == null || (fZs = baseWebViewController.fZs()) == null) {
                    AppMethodBeat.o(240266);
                    return;
                }
                h hVar = this.CCN.CCA;
                BaseWebViewController baseWebViewController2 = this.CCN.CCx;
                if (baseWebViewController2 != null) {
                    i2 = baseWebViewController2.fZu();
                } else {
                    i2 = 0;
                }
                fZs.a(hVar, i2);
                AppMethodBeat.o(240266);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ScanBoxDialog", th, "alvinluo initWebViewController exception", new Object[0]);
                AppMethodBeat.o(240266);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0003H\u0002¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageStarted", "webViewReady", "plugin-scan_release"})
    /* renamed from: com.tencent.mm.plugin.scanner.box.i$i  reason: collision with other inner class name */
    public static final class C1667i extends com.tencent.mm.plugin.webview.core.f {
        final /* synthetic */ i CCN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1667i(i iVar) {
            this.CCN = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.core.f
        public final void e(WebView webView, String str) {
            AppMethodBeat.i(240263);
            super.e(webView, str);
            ePq();
            AppMethodBeat.o(240263);
        }

        @Override // com.tencent.mm.plugin.webview.core.f
        public final void i(WebView webView, String str) {
            AppMethodBeat.i(240264);
            super.i(webView, str);
            ePq();
            AppMethodBeat.o(240264);
        }

        private final void ePq() {
            AppMethodBeat.i(240265);
            if (this.CCN.CCK) {
                AppMethodBeat.o(240265);
                return;
            }
            this.CCN.CCK = true;
            Log.i("MicroMsg.ScanBoxDialog", "alvinluo webViewReady showAfterWebViewReady: %b, pendingShow: %b", Boolean.valueOf(this.CCN.CCJ), Boolean.valueOf(this.CCN.CCL));
            if (this.CCN.CCJ && this.CCN.CCL) {
                this.CCN.CCL = false;
                this.CCN.show();
            }
            AppMethodBeat.o(240265);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/scanner/box/ScanBoxDialog$webViewCallback$1", "Lcom/tencent/mm/plugin/webview/stub/DefaultWebViewStubCallback;", "getCommitUrl", "", "getCurrentUrl", "plugin-scan_release"})
    public static final class h extends com.tencent.mm.plugin.webview.stub.b {
        final /* synthetic */ i CCN;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(i iVar) {
            this.CCN = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final String ePp() {
            String str;
            AppMethodBeat.i(240261);
            Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCommitUrl");
            try {
                BaseWebViewController baseWebViewController = this.CCN.CCx;
                if (baseWebViewController == null || (str = baseWebViewController.IJP) == null) {
                    str = "";
                }
                AppMethodBeat.o(240261);
                return str;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ScanBoxDialog", th, "getCommitUrl exception", new Object[0]);
                AppMethodBeat.o(240261);
                return "";
            }
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.stub.b
        public final String getCurrentUrl() {
            String str;
            AppMethodBeat.i(240262);
            Log.v("MicroMsg.ScanBoxDialog", "alvinluo getCurrentUrl");
            try {
                BaseWebViewController baseWebViewController = this.CCN.CCx;
                if (baseWebViewController == null || (str = baseWebViewController.getCurrentUrl()) == null) {
                    str = "";
                }
                AppMethodBeat.o(240262);
                return str;
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ScanBoxDialog", th, "getCommitUrl exception", new Object[0]);
                AppMethodBeat.o(240262);
                return "";
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(Context context, qt qtVar, BaseBoxDialogView baseBoxDialogView, j jVar) {
        super(context, R.style.ft);
        p.h(context, "context");
        p.h(qtVar, "homeContext");
        AppMethodBeat.i(240272);
        this.CCE = baseBoxDialogView;
        this.CCD = jVar;
        com.tencent.mm.plugin.webview.d.q qVar = com.tencent.mm.plugin.webview.d.q.ISm;
        com.tencent.mm.plugin.webview.d.q.a(o.ISi);
        this.mContext = context;
        this.plO = qtVar;
        this.CCC = new q(this);
        j jVar2 = this.CCD;
        if (jVar2 != null) {
            jVar2.ePs();
        }
        Context context2 = this.mContext;
        if (context2 == null) {
            p.btv("mContext");
        }
        this.plR = h.a(context2, new b(this));
        this.CCK = false;
        aa aaVar = (aa) com.tencent.mm.kernel.g.af(aa.class);
        BoxWebView boxWebView = this.plR;
        if (boxWebView == null) {
            p.hyc();
        }
        this.CCx = aaVar.a(boxWebView, new BaseWebViewController.c(null, true, false, false, true, 41), o.ISi);
        BaseWebViewController baseWebViewController = this.CCx;
        if (baseWebViewController != null) {
            baseWebViewController.a(this.CCy);
        }
        BaseWebViewController baseWebViewController2 = this.CCx;
        if (baseWebViewController2 != null) {
            baseWebViewController2.a(this.CCz);
        }
        BaseWebViewController baseWebViewController3 = this.CCx;
        if (baseWebViewController3 != null) {
            baseWebViewController3.init();
        }
        j jVar3 = this.CCD;
        if (jVar3 != null) {
            jVar3.ePt();
        }
        Log.i("MicroMsg.ScanBoxDialog", "alvinluo initWebView");
        this.CCB = new p(this);
        com.tencent.f.h.RTc.aZ(new f(this));
        AppMethodBeat.o(240272);
    }

    @Override // android.support.v7.app.e
    public final void onCreate(Bundle bundle) {
        WindowManager.LayoutParams attributes;
        View decorView;
        Resources resources;
        DisplayMetrics displayMetrics;
        AppMethodBeat.i(52124);
        super.onCreate(bundle);
        Log.i("MicroMsg.ScanBoxDialog", "alvinluo onCreate");
        if (this.CAK) {
            Window window = getWindow();
            if (window != null) {
                window.addFlags(100729856);
            }
        } else {
            Window window2 = getWindow();
            if (window2 != null) {
                window2.addFlags(67108864);
            }
        }
        gR();
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -1);
        }
        Window window4 = getWindow();
        if (window4 != null) {
            window4.setDimAmount(0.0f);
        }
        Window window5 = getWindow();
        if (window5 != null) {
            window5.setWindowAnimations(R.style.fu);
        }
        Window window6 = getWindow();
        if (!(window6 == null || (decorView = window6.getDecorView()) == null)) {
            p.g(decorView, "this");
            Context context = decorView.getContext();
            decorView.setMinimumWidth((context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? com.tencent.mm.cb.a.jn(decorView.getContext()) : displayMetrics.widthPixels);
            decorView.setPadding(0, 0, 0, 0);
        }
        Window window7 = getWindow();
        if (!(window7 == null || (attributes = window7.getAttributes()) == null)) {
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 80;
        }
        BaseBoxDialogView baseBoxDialogView = this.CCE;
        if (baseBoxDialogView != null) {
            BoxWebView boxWebView = this.plR;
            if (boxWebView == null) {
                p.hyc();
            }
            BoxWebView boxWebView2 = boxWebView;
            p.h(boxWebView2, "webView");
            baseBoxDialogView.CBn = boxWebView2;
            MMWebView mMWebView = baseBoxDialogView.CBn;
            if (mMWebView == null) {
                p.hyc();
            }
            mMWebView.a(new BaseBoxDialogView.g(baseBoxDialogView));
            BoxWebViewContainer boxWebViewContainer = baseBoxDialogView.CBk;
            if (boxWebViewContainer == null) {
                p.btv("webViewContainer");
            }
            boxWebViewContainer.addView(baseBoxDialogView.CBn, new RelativeLayout.LayoutParams(-1, -2));
        }
        BaseBoxDialogView baseBoxDialogView2 = this.CCE;
        if (baseBoxDialogView2 != null) {
            i iVar = this;
            p.h(iVar, "dialogModel");
            baseBoxDialogView2.CBh = iVar;
        }
        BaseBoxDialogView baseBoxDialogView3 = this.CCE;
        if (baseBoxDialogView3 != null) {
            baseBoxDialogView3.setIsFixDialogHeight(this.CBG);
        }
        BaseBoxDialogView baseBoxDialogView4 = this.CCE;
        if (baseBoxDialogView4 != null) {
            baseBoxDialogView4.setFixDialogHeight(this.CBH);
        }
        BaseBoxDialogView baseBoxDialogView5 = this.CCE;
        if (baseBoxDialogView5 != null) {
            baseBoxDialogView5.setFixDialogHeightRate(this.CBJ);
        }
        BaseBoxDialogView baseBoxDialogView6 = this.CCE;
        if (baseBoxDialogView6 != null) {
            baseBoxDialogView6.setEnableDialogScroll(this.CCH);
        }
        BaseBoxDialogView baseBoxDialogView7 = this.CCE;
        if (baseBoxDialogView7 != null) {
            baseBoxDialogView7.setEnableWebViewScroll(this.CCG);
        }
        BaseBoxDialogView baseBoxDialogView8 = this.CCE;
        if (baseBoxDialogView8 != null) {
            baseBoxDialogView8.setCanceledOnTouchOutside(this.CCI);
        }
        BaseBoxDialogView baseBoxDialogView9 = this.CCE;
        if (baseBoxDialogView9 != null) {
            baseBoxDialogView9.setEnableScrollRightClose(this.CAL);
        }
        BaseBoxDialogView baseBoxDialogView10 = this.CCE;
        if (baseBoxDialogView10 == null) {
            p.hyc();
        }
        setContentView(baseBoxDialogView10, new ViewGroup.LayoutParams(-1, -1));
        setOnShowListener(new c(this));
        setOnDismissListener(new d(this));
        setOnCancelListener(new e(this));
        setCancelable(true);
        AppMethodBeat.o(52124);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class g implements Runnable {
        final /* synthetic */ i CCN;

        g(i iVar) {
            this.CCN = iVar;
        }

        public final void run() {
            AppMethodBeat.i(240260);
            Log.i("MicroMsg.ScanBoxDialog", "alvinluo startLoadUrl %s", i.a(this.CCN).Url);
            BaseWebViewController baseWebViewController = this.CCN.CCx;
            if (baseWebViewController != null) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", i.a(this.CCN).Url);
                intent.putExtra("useJs", true);
                baseWebViewController.aB(intent);
                AppMethodBeat.o(240260);
                return;
            }
            AppMethodBeat.o(240260);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onShow"})
    static final class c implements DialogInterface.OnShowListener {
        final /* synthetic */ i CCN;

        c(i iVar) {
            this.CCN = iVar;
        }

        public final void onShow(DialogInterface dialogInterface) {
            ViewPropertyAnimator translationY;
            ViewPropertyAnimator interpolator;
            ViewPropertyAnimator updateListener;
            ViewPropertyAnimator listener;
            ViewPropertyAnimator duration;
            AppMethodBeat.i(240255);
            BaseBoxDialogView baseBoxDialogView = this.CCN.CCE;
            if (baseBoxDialogView != null) {
                Log.v("MicroMsg.BaseBoxDialogView", "alvinluo showDialog");
                baseBoxDialogView.yPa = false;
                baseBoxDialogView.isAnimating = true;
                baseBoxDialogView.CBW = 0;
                float maxTranslationY = (float) baseBoxDialogView.getMaxTranslationY();
                float f2 = baseBoxDialogView.CBx;
                View view = baseBoxDialogView.CBj;
                if (view == null) {
                    p.btv("dialogContainer");
                }
                view.setTranslationY(maxTranslationY);
                View view2 = baseBoxDialogView.CBj;
                if (view2 == null) {
                    p.btv("dialogContainer");
                }
                ViewPropertyAnimator animate = view2.animate();
                if (!(animate == null || (translationY = animate.translationY(f2)) == null || (interpolator = translationY.setInterpolator(baseBoxDialogView.CBV)) == null || (updateListener = interpolator.setUpdateListener(new BaseBoxDialogView.l(baseBoxDialogView))) == null || (listener = updateListener.setListener(new BaseBoxDialogView.m(baseBoxDialogView, maxTranslationY, f2))) == null || (duration = listener.setDuration(300)) == null)) {
                    duration.start();
                }
                ValueAnimator valueAnimator = baseBoxDialogView.animator;
                valueAnimator.setInterpolator(new DecelerateInterpolator());
                valueAnimator.setDuration(300L);
                valueAnimator.setFloatValues(baseBoxDialogView.CBT.CBY, baseBoxDialogView.CBT.CBZ);
                valueAnimator.addUpdateListener(new BaseBoxDialogView.e(baseBoxDialogView));
                valueAnimator.addListener(new BaseBoxDialogView.f(baseBoxDialogView));
                valueAnimator.setStartDelay(50);
                valueAnimator.start();
            }
            j jVar = this.CCN.CCD;
            if (jVar != null) {
                jVar.onShow(dialogInterface);
                AppMethodBeat.o(240255);
                return;
            }
            AppMethodBeat.o(240255);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class d implements DialogInterface.OnDismissListener {
        final /* synthetic */ i CCN;

        d(i iVar) {
            this.CCN = iVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(240256);
            Log.i("MicroMsg.ScanBoxDialog", "dismiss dialog");
            j jVar = this.CCN.CCD;
            if (jVar != null) {
                jVar.a(dialogInterface, this.CCN.CCF);
            }
            i iVar = this.CCN;
            com.tencent.mm.plugin.webview.d.q qVar = com.tencent.mm.plugin.webview.d.q.ISm;
            com.tencent.mm.plugin.webview.d.q.b(o.ISi);
            p pVar = iVar.CCB;
            if (pVar != null) {
                if (pVar.CDm != null) {
                    com.tencent.mm.kernel.g.azz().a(pVar.CDm);
                }
                com.tencent.mm.kernel.g.azz().b(1532, pVar);
            }
            BoxWebView boxWebView = iVar.plR;
            if (boxWebView != null) {
                boxWebView.destroy();
            }
            iVar.plR = null;
            if (iVar.CCC != null) {
                q.release();
            }
            BaseWebViewController baseWebViewController = iVar.CCx;
            if (baseWebViewController != null) {
                baseWebViewController.onDestroy();
                AppMethodBeat.o(240256);
                return;
            }
            AppMethodBeat.o(240256);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class e implements DialogInterface.OnCancelListener {
        final /* synthetic */ i CCN;

        e(i iVar) {
            this.CCN = iVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(240257);
            j jVar = this.CCN.CCD;
            if (jVar != null) {
                jVar.onCancel(dialogInterface);
                AppMethodBeat.o(240257);
                return;
            }
            AppMethodBeat.o(240257);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class f implements Runnable {
        final /* synthetic */ i CCN;

        f(i iVar) {
            this.CCN = iVar;
        }

        public final void run() {
            AppMethodBeat.i(240259);
            try {
                BoxWebView boxWebView = this.CCN.plR;
                if (boxWebView != null) {
                    boxWebView.a(null, null);
                }
                BoxWebView boxWebView2 = this.CCN.plR;
                if (boxWebView2 != null) {
                    boxWebView2.addJavascriptInterface(this.CCN.CCC, "boxJSApi");
                }
                i.h(this.CCN);
                j jVar = this.CCN.CCD;
                if (jVar != null) {
                    jVar.ePu();
                    AppMethodBeat.o(240259);
                    return;
                }
                AppMethodBeat.o(240259);
            } catch (Throwable th) {
                Log.printErrStackTrace("MicroMsg.ScanBoxDialog", th, "initWebView exception", new Object[0]);
                com.tencent.f.h.RTc.aV(new Runnable(this) {
                    /* class com.tencent.mm.plugin.scanner.box.i.f.AnonymousClass1 */
                    final /* synthetic */ f CCO;

                    {
                        this.CCO = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(240258);
                        BoxWebView boxWebView = this.CCO.CCN.plR;
                        if (boxWebView != null) {
                            boxWebView.a(null, null);
                        }
                        BoxWebView boxWebView2 = this.CCO.CCN.plR;
                        if (boxWebView2 != null) {
                            boxWebView2.addJavascriptInterface(this.CCO.CCN.CCC, "boxJSApi");
                        }
                        i.h(this.CCO.CCN);
                        j jVar = this.CCO.CCN.CCD;
                        if (jVar != null) {
                            jVar.ePu();
                            AppMethodBeat.o(240258);
                            return;
                        }
                        AppMethodBeat.o(240258);
                    }
                });
                AppMethodBeat.o(240259);
            }
        }
    }

    public final void onBackPressed() {
        BaseBoxDialogView baseBoxDialogView;
        AppMethodBeat.i(161054);
        if (!isShowing() || (baseBoxDialogView = this.CCE) == null) {
            super.onBackPressed();
            AppMethodBeat.o(161054);
            return;
        }
        if (!baseBoxDialogView.isAnimating) {
            baseBoxDialogView.Wr(5);
        }
        AppMethodBeat.o(161054);
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final void dismiss() {
        BaseBoxDialogView baseBoxDialogView;
        AppMethodBeat.i(52125);
        this.CCL = false;
        if (!isShowing() || (baseBoxDialogView = this.CCE) == null) {
            AppMethodBeat.o(52125);
            return;
        }
        baseBoxDialogView.Wr(5);
        AppMethodBeat.o(52125);
    }

    private final void ePn() {
        AppMethodBeat.i(240268);
        try {
            if (getContext() instanceof Activity) {
                Context context = getContext();
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(240268);
                    throw tVar;
                } else if (((Activity) context).isFinishing()) {
                    Log.w("MicroMsg.ScanBoxDialog", "realShowDialog ui is finishing and ignore");
                    AppMethodBeat.o(240268);
                    return;
                }
            }
            super.show();
            AppMethodBeat.o(240268);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanBoxDialog", e2, "realShowDialog exception", new Object[0]);
            AppMethodBeat.o(240268);
        }
    }

    @Override // com.tencent.mm.plugin.scanner.box.e
    public final void dismissDialog(int i2) {
        AppMethodBeat.i(52126);
        Log.d("MicroMsg.ScanBoxDialog", "alvinluo dismissDialog isShowing: %b, isAttachedToWindow: %b, exitType: %s", Boolean.valueOf(isShowing()), Boolean.valueOf(this.isAttachedToWindow), Integer.valueOf(i2));
        this.CCF = i2;
        this.CCL = false;
        if (isShowing() && this.isAttachedToWindow) {
            super.dismiss();
        }
        AppMethodBeat.o(52126);
    }

    public final boolean isShowingDialog() {
        AppMethodBeat.i(240269);
        if (isShowing() || this.CCL) {
            AppMethodBeat.o(240269);
            return true;
        }
        AppMethodBeat.o(240269);
        return false;
    }

    public final void onAttachedToWindow() {
        AppMethodBeat.i(52127);
        super.onAttachedToWindow();
        Log.v("MicroMsg.ScanBoxDialog", "alvinluo onAttachedToWindow %b", Boolean.valueOf(this.isAttachedToWindow));
        this.isAttachedToWindow = true;
        AppMethodBeat.o(52127);
    }

    public final void onDetachedFromWindow() {
        AppMethodBeat.i(52128);
        super.onDetachedFromWindow();
        Log.v("MicroMsg.ScanBoxDialog", "alvinluo onDetachedFromWindow %b", Boolean.valueOf(this.isAttachedToWindow));
        this.isAttachedToWindow = false;
        AppMethodBeat.o(52128);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(240270);
        p.h(fVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        BaseBoxDialogView baseBoxDialogView = this.CCE;
        if (baseBoxDialogView != null) {
            baseBoxDialogView.setBackgroundListener(fVar);
            AppMethodBeat.o(240270);
            return;
        }
        AppMethodBeat.o(240270);
    }

    public final void ePo() {
        AppMethodBeat.i(240271);
        this.CBG = true;
        BaseBoxDialogView baseBoxDialogView = this.CCE;
        if (baseBoxDialogView != null) {
            baseBoxDialogView.setIsFixDialogHeight(true);
            AppMethodBeat.o(240271);
            return;
        }
        AppMethodBeat.o(240271);
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final BoxWebView ckY() {
        return this.plR;
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final com.tencent.mm.plugin.box.webview.e ckZ() {
        return this.CCB;
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final com.tencent.mm.plugin.box.webview.d cla() {
        return this.CCC;
    }

    @Override // com.tencent.mm.plugin.box.c.b
    public final Context getActivityContext() {
        AppMethodBeat.i(52129);
        Context context = this.mContext;
        if (context == null) {
            p.btv("mContext");
        }
        AppMethodBeat.o(52129);
        return context;
    }

    public final void show() {
        AppMethodBeat.i(240267);
        Log.i("MicroMsg.ScanBoxDialog", "alvinluo showDialog showAfterWebViewReady: %b, webViewReady: %b", Boolean.valueOf(this.CCJ), Boolean.valueOf(this.CCK));
        if (!this.CCJ) {
            ePn();
            AppMethodBeat.o(240267);
        } else if (!this.CCK) {
            this.CCL = true;
            AppMethodBeat.o(240267);
        } else {
            ePn();
            AppMethodBeat.o(240267);
        }
    }

    public static final /* synthetic */ void h(i iVar) {
        AppMethodBeat.i(240274);
        com.tencent.f.h.RTc.aV(new g(iVar));
        AppMethodBeat.o(240274);
    }
}
