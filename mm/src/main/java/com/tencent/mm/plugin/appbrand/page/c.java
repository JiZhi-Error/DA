package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.i;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyleWC;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandActionBarHomeButtonStyle;", "pageView", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "onBackButtonClicked", "", "view", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class c extends b {
    private final ag mri;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(ag agVar) {
        super(agVar);
        p.h(agVar, "pageView");
        AppMethodBeat.i(229232);
        this.mri = agVar;
        AppMethodBeat.o(229232);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.b, com.tencent.mm.plugin.appbrand.widget.actionbar.b.a
    public final boolean cz(View view) {
        AppMethodBeat.i(229231);
        p.h(view, "view");
        boolean cz = super.cz(view);
        if (cz && this.mri.bRk() != null) {
            b bRi = this.mri.bRi();
            p.g(bRi, "pageView.actionBar");
            if (!bRi.cae()) {
                q runtime = this.mri.getRuntime();
                p.g(runtime, "pageView.runtime");
                i.E(runtime.getAppId(), this.mri.getURL(), 3);
            }
        }
        AppMethodBeat.o(229231);
        return cz;
    }
}
