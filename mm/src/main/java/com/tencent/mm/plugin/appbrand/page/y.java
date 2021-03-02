package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.game.page.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0007¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWCUtils;", "", "()V", "resetWindowAndroidToNil", "", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageContainerWC;", "plugin-appbrand-integration_release"})
public final class y {
    public static final y nqw = new y();

    static {
        AppMethodBeat.i(229240);
        AppMethodBeat.o(229240);
    }

    private y() {
    }

    public static final void c(x xVar) {
        ac currentPageView;
        AppMethodBeat.i(229239);
        p.h(xVar, "$this$resetWindowAndroidToNil");
        Iterator<t> bQQ = xVar.bQQ();
        p.g(bQQ, "this.stackIterator()");
        while (bQQ.hasNext()) {
            t next = bQQ.next();
            if ((next instanceof e) || (next instanceof ak)) {
                ac currentPageView2 = next.getCurrentPageView();
                p.g(currentPageView2, "it.currentPageView");
                currentPageView2.b((c) null);
            } else if (next instanceof m) {
                Iterator<ac> bQJ = ((m) next).bQJ();
                p.g(bQJ, "it.pagesIterator()");
                while (bQJ.hasNext()) {
                    ac next2 = bQJ.next();
                    p.g(next2, "p");
                    next2.b((c) null);
                }
            }
        }
        ac preloadedPageView = xVar.getPreloadedPageView();
        if (preloadedPageView != null) {
            preloadedPageView.b((c) null);
        }
        t currentPage = xVar.getCurrentPage();
        if (currentPage == null || (currentPageView = currentPage.getCurrentPageView()) == null) {
            AppMethodBeat.o(229239);
            return;
        }
        xVar.j(currentPageView);
        AppMethodBeat.o(229239);
    }
}
