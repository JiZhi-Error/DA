package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.s;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.protocal.protobuf.eic;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.g.b.y;
import kotlin.l;
import kotlin.l.k;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0019\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\bH\u0014J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\bH\u0014J\n\u0010!\u001a\u0004\u0018\u00010\u0012H\u0004J\b\u0010\"\u001a\u00020\bH\u0004J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\bH\u0014J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0014J\b\u0010)\u001a\u00020$H\u0014J\b\u0010*\u001a\u00020$H\u0014J\b\u0010+\u001a\u00020$H\u0014J\b\u0010,\u001a\u00020$H\u0014J\b\u0010-\u001a\u00020\bH\u0016J\b\u0010.\u001a\u00020$H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "SHOW_PROGRESS_TIME", "", "TAG", "", "destroyed", "", "isForceUrl", "()Z", "isForceUrl$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "lazyMgr", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getLazyMgr", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "mpController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/MpWebViewController;", "tmplParams", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/protocal/protobuf/TmplParams;", "tmplParams$delegate", "webViewControllerListener", "com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1;", "canTryPreloadNextWebView", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewController", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "enableMinimize", "getMPController", "isPageCache", "loadForceUrl", "", "forceUrl", "fullScreen", "modifyForceUrl", "url", "onDestroy", "onPageReady", "onReset", "onResetAfterCreate", "shouldInterceptProgressShow", "tryPreloadNextWebView", "plugin-brandservice_release"})
public class TmplWebViewToolUI extends WebViewUI {
    static final /* synthetic */ k[] cLI = {aa.a(new y(aa.bp(TmplWebViewToolUI.class), "tmplParams", "getTmplParams()Lcom/tencent/mm/protocal/protobuf/TmplParams;")), aa.a(new y(aa.bp(TmplWebViewToolUI.class), "isForceUrl", "isForceUrl()Z"))};
    private final String TAG = "MicroMsg.TmplWebViewToolUI";
    private HashMap _$_findViewCache;
    private final long pGX = 500;
    private boolean pGY;
    protected final r pGZ = new r();
    private final q pHa = s.a(this.pGZ, new b(this));
    private final q pHb = s.a(this.pGZ, new a(this));
    protected MpWebViewController pHc;
    private final c pHd = new c(this);

    static {
        AppMethodBeat.i(6987);
        AppMethodBeat.o(6987);
    }

    private final eic cpM() {
        AppMethodBeat.i(195881);
        eic eic = (eic) this.pHa.a(cLI[0]);
        AppMethodBeat.o(195881);
        return eic;
    }

    private final boolean cpN() {
        AppMethodBeat.i(195882);
        boolean booleanValue = ((Boolean) this.pHb.a(cLI[1])).booleanValue();
        AppMethodBeat.o(195882);
        return booleanValue;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(195886);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(195886);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(195885);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(195885);
        return view;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/protocal/protobuf/TmplParams;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<eic> {
        final /* synthetic */ TmplWebViewToolUI pHe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TmplWebViewToolUI tmplWebViewToolUI) {
            super(0);
            this.pHe = tmplWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ eic invoke() {
            AppMethodBeat.i(6984);
            eic cpQ = cpQ();
            AppMethodBeat.o(6984);
            return cpQ;
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private com.tencent.mm.protocal.protobuf.eic cpQ() {
            /*
            // Method dump skipped, instructions count: 195
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.b.cpQ():com.tencent.mm.protocal.protobuf.eic");
        }
    }

    public TmplWebViewToolUI() {
        AppMethodBeat.i(7019);
        AppMethodBeat.o(7019);
    }

    public static final /* synthetic */ String a(TmplWebViewToolUI tmplWebViewToolUI) {
        AppMethodBeat.i(7021);
        String str = tmplWebViewToolUI.TAG;
        AppMethodBeat.o(7021);
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.tencent.mm.plugin.webview.core.i] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cpA() {
        /*
        // Method dump skipped, instructions count: 197
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.cpA():void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$webViewControllerListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "onJsReady", "", "plugin-brandservice_release"})
    public static final class c extends j {
        final /* synthetic */ TmplWebViewToolUI pHe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(TmplWebViewToolUI tmplWebViewToolUI) {
            this.pHe = tmplWebViewToolUI;
        }

        @Override // com.tencent.mm.plugin.webview.core.j
        public final void cpR() {
            AppMethodBeat.i(195880);
            super.cpR();
            com.tencent.mm.plugin.webview.ui.tools.k kVar = this.pHe.JjI;
            MpWebViewController mpWebViewController = this.pHe.pHc;
            kVar.setCurrentURL(mpWebViewController != null ? mpWebViewController.getCurrentUrl() : null);
            AppMethodBeat.o(195880);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public void onReset() {
        AppMethodBeat.i(6998);
        r rVar = this.pGZ;
        synchronized (rVar.pDt) {
            try {
                Iterator<T> it = rVar.pDt.iterator();
                while (it.hasNext()) {
                    it.next().reset();
                }
                rVar.pDt.clear();
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(6998);
                throw th;
            }
        }
        this.pHc = null;
        super.onReset();
        AppMethodBeat.o(6998);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public MMWebView cpy() {
        MMWebView mMWebView;
        AppMethodBeat.i(7002);
        if (this.JiL) {
            MMWebView cpy = super.cpy();
            AppMethodBeat.o(7002);
            return cpy;
        }
        MpWebViewController mpWebViewController = this.pHc;
        if (mpWebViewController == null || (mMWebView = mpWebViewController.pGj) == null) {
            mMWebView = super.cpy();
        }
        AppMethodBeat.o(7002);
        return mMWebView;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final i cpO() {
        AppMethodBeat.i(195883);
        MpWebViewController mpWebViewController = this.pHc;
        if (mpWebViewController != null) {
            MpWebViewController mpWebViewController2 = mpWebViewController;
            AppMethodBeat.o(195883);
            return mpWebViewController2;
        }
        i cpO = super.cpO();
        p.g(cpO, "super.createWebViewController()");
        AppMethodBeat.o(195883);
        return cpO;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(7003);
        MpWebViewController mpWebViewController = this.pHc;
        if (mpWebViewController != null) {
            mpWebViewController.b(this.pHd);
        }
        this.pGY = true;
        super.onDestroy();
        AppMethodBeat.o(7003);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean cpP() {
        AppMethodBeat.i(195884);
        if (!cpN()) {
            AppMethodBeat.o(195884);
            return true;
        }
        AppMethodBeat.o(195884);
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public boolean cpz() {
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ TmplWebViewToolUI pHe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TmplWebViewToolUI tmplWebViewToolUI) {
            super(0);
            this.pHe = tmplWebViewToolUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(6972);
            Boolean valueOf = Boolean.valueOf(this.pHe.getIntent().getBooleanExtra(e.p.OzD, false));
            AppMethodBeat.o(6972);
            return valueOf;
        }
    }
}
