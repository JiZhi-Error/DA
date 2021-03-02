package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.j;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\f\u0010\t\u001a\u00020\n*\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/AppBrandEntryPageFastLoadHelper;", "", "()V", "TAG", "", "createFastLoadPrompt", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "tryFastLoadEntryPage", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "plugin-appbrand-integration_release"})
public final class e {
    public static final e kzv = new e();

    static {
        AppMethodBeat.i(227883);
        AppMethodBeat.o(227883);
    }

    private e() {
    }

    public static final void a(ag agVar) {
        boolean z;
        AppMethodBeat.i(227882);
        p.h(agVar, "$this$tryFastLoadEntryPage");
        if (agVar.getRuntime() == null) {
            AppMethodBeat.o(227882);
            return;
        }
        q runtime = agVar.getRuntime();
        p.g(runtime, "this.runtime");
        if (runtime.isDestroyed()) {
            AppMethodBeat.o(227882);
            return;
        }
        q runtime2 = agVar.getRuntime();
        p.g(runtime2, "this.runtime");
        if (runtime2.NA()) {
            AppMethodBeat.o(227882);
        } else if (AppBrandRuntimeWCAccessible.E(agVar.getRuntime())) {
            AppMethodBeat.o(227882);
        } else if (!agVar.bRC()) {
            AppMethodBeat.o(227882);
        } else {
            q runtime3 = agVar.getRuntime();
            p.g(runtime3, "this.runtime");
            if (runtime3.brK() instanceof aa) {
                AppMethodBeat.o(227882);
                return;
            }
            q runtime4 = agVar.getRuntime();
            p.g(runtime4, "this.runtime");
            if (!runtime4.bsr()) {
                com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = agVar.bRi();
                p.g(bRi, "this.actionBar");
                if (!bRi.isFullscreenMode() || (agVar.bRc() instanceof m)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    QualitySessionRuntime aeU = com.tencent.mm.plugin.appbrand.report.quality.b.aeU(agVar.getAppId());
                    if ((aeU != null ? aeU.nLA : null) != j.PreloadOnProcessCreated) {
                        AppMethodBeat.o(227882);
                        return;
                    }
                }
            }
            Boolean[] boolArr = {Boolean.FALSE};
            View[] viewArr = new View[1];
            Long[] lArr = {0L};
            agVar.a(new a(agVar, boolArr, lArr, viewArr));
            View contentView = agVar.getContentView();
            if (contentView != null) {
                contentView.post(new b(agVar, boolArr, viewArr, lArr));
                AppMethodBeat.o(227882);
                return;
            }
            AppMethodBeat.o(227882);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onReady"})
    static final class a implements i.f {
        final /* synthetic */ ag kzw;
        final /* synthetic */ Boolean[] kzx;
        final /* synthetic */ Long[] kzy;
        final /* synthetic */ View[] kzz;

        a(ag agVar, Boolean[] boolArr, Long[] lArr, View[] viewArr) {
            this.kzw = agVar;
            this.kzx = boolArr;
            this.kzy = lArr;
            this.kzz = viewArr;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.f
        public final void onReady() {
            AppMethodBeat.i(227880);
            this.kzx[0] = Boolean.TRUE;
            if (this.kzy[0].longValue() > 0) {
                long longValue = this.kzy[0].longValue();
                StringBuilder sb = new StringBuilder("tryFastLoadEntryPage, onReady called with promptView shown, appId[");
                q runtime = this.kzw.getRuntime();
                p.g(runtime, "this.runtime");
                Log.i("MicroMsg.AppBrandEntryPageFastLoadHelper", sb.append(runtime.getAppId()).append("], time diff: ").append(Util.currentTicks() - longValue).toString());
            }
            View view = this.kzz[0];
            if (view != null) {
                com.tencent.mm.plugin.appbrand.ui.l.cG(view);
                if (!(view instanceof ThreeDotsLoadingView)) {
                    view = null;
                }
                ThreeDotsLoadingView threeDotsLoadingView = (ThreeDotsLoadingView) view;
                if (threeDotsLoadingView != null) {
                    threeDotsLoadingView.gZi();
                    AppMethodBeat.o(227880);
                    return;
                }
                AppMethodBeat.o(227880);
                return;
            }
            AppMethodBeat.o(227880);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b implements Runnable {
        final /* synthetic */ ag kzw;
        final /* synthetic */ Boolean[] kzx;
        final /* synthetic */ Long[] kzy;
        final /* synthetic */ View[] kzz;

        b(ag agVar, Boolean[] boolArr, View[] viewArr, Long[] lArr) {
            this.kzw = agVar;
            this.kzx = boolArr;
            this.kzz = viewArr;
            this.kzy = lArr;
        }

        public final /* synthetic */ void run() {
            AppMethodBeat.i(227881);
            if (!this.kzx[0].booleanValue()) {
                View contentView = this.kzw.getContentView();
                if (!(contentView instanceof ViewGroup)) {
                    contentView = null;
                }
                ViewGroup viewGroup = (ViewGroup) contentView;
                if (viewGroup == null) {
                    AppMethodBeat.o(227881);
                    return;
                }
                e eVar = e.kzv;
                View f2 = e.f(viewGroup);
                StringBuilder sb = new StringBuilder("tryFastLoadEntryPage, show promptView, appId[");
                q runtime = this.kzw.getRuntime();
                p.g(runtime, "this.runtime");
                Log.i("MicroMsg.AppBrandEntryPageFastLoadHelper", sb.append(runtime.getAppId()).append(']').toString());
                this.kzz[0] = f2;
                this.kzy[0] = Long.valueOf(Util.currentTicks());
                this.kzw.bRd().dk(f2);
                this.kzw.getRuntime().brr();
            }
            AppMethodBeat.o(227881);
        }
    }

    public static final /* synthetic */ View f(ViewGroup viewGroup) {
        AppMethodBeat.i(227884);
        Context context = viewGroup.getContext();
        p.g(context, "parent.context");
        ProgressBar progressBar = new ProgressBar(new u(context, R.style.a61));
        progressBar.setIndeterminateDrawable(android.support.v4.content.b.l(progressBar.getContext(), R.drawable.apa));
        Context context2 = progressBar.getContext();
        p.g(context2, "context");
        Resources resources = context2.getResources();
        p.g(resources, "context.resources");
        int cR = kotlin.h.a.cR(resources.getDisplayMetrics().density * 36.0f);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(cR, cR));
        ProgressBar progressBar2 = progressBar;
        AppMethodBeat.o(227884);
        return progressBar2;
    }
}
