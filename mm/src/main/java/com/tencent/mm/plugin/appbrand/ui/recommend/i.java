package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\f\u001a\u00020\r*\u00020\u0003\u001a\u0018\u0010\u000e\u001a\u00020\r*\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010\u001a\u0012\u0010\u0011\u001a\u00020\r*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\t\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00018F@FX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0005\"\u0004\b\u000b\u0010\u0007¨\u0006\u0015"}, hxF = {"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class i {
    public static final void a(AppBrandRecommendUILogic appBrandRecommendUILogic, boolean z) {
        AppMethodBeat.i(51379);
        p.h(appBrandRecommendUILogic, "$this$showFooter");
        appBrandRecommendUILogic.bZc().showLoading(z);
        AppMethodBeat.o(51379);
    }

    public static final void b(AppBrandRecommendUILogic appBrandRecommendUILogic, boolean z) {
        AppMethodBeat.i(51380);
        p.h(appBrandRecommendUILogic, "$this$showThreeDots");
        if (!z) {
            h(appBrandRecommendUILogic);
        }
        appBrandRecommendUILogic.bZe().iT(z);
        AppMethodBeat.o(51380);
    }

    private static void a(g gVar, String str) {
        AppMethodBeat.i(51382);
        p.h(gVar, "$this$setWordingText");
        p.h(str, "wording");
        View findViewById = gVar.aus.findViewById(R.id.iwk);
        p.g(findViewById, "this.itemView.findViewBy…ents_list_footer_wording)");
        ((TextView) findViewById).setText(str);
        AppMethodBeat.o(51382);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class a implements Runnable {
        final /* synthetic */ kotlin.g.a.a kXn;

        a(kotlin.g.a.a aVar) {
            this.kXn = aVar;
        }

        public final void run() {
            AppMethodBeat.i(51378);
            this.kXn.invoke();
            AppMethodBeat.o(51378);
        }
    }

    public static final void h(AppBrandRecommendUILogic appBrandRecommendUILogic) {
        AppMethodBeat.i(51381);
        p.h(appBrandRecommendUILogic, "$this$configFooterWording");
        if (appBrandRecommendUILogic.ofu.bYP().isEmpty()) {
            g bZe = appBrandRecommendUILogic.bZe();
            String aI = com.tencent.mm.cb.a.aI(appBrandRecommendUILogic.context, R.string.qm);
            p.g(aI, "ResourceHelper.getString…ommend_null_list_wording)");
            a(bZe, aI);
            AppMethodBeat.o(51381);
            return;
        }
        g bZe2 = appBrandRecommendUILogic.bZe();
        String aI2 = com.tencent.mm.cb.a.aI(appBrandRecommendUILogic.context, R.string.n9);
        p.g(aI2, "ResourceHelper.getString…ents_list_footer_no_more)");
        a(bZe2, aI2);
        AppMethodBeat.o(51381);
    }

    public static final void a(AppBrandRecommendUILogic appBrandRecommendUILogic, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(51383);
        p.h(appBrandRecommendUILogic, "$this$runOnUiThread");
        p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
        appBrandRecommendUILogic.ofI.runOnUiThread(new a(aVar));
        AppMethodBeat.o(51383);
    }
}
