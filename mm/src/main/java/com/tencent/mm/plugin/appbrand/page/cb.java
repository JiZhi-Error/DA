package com.tencent.mm.plugin.appbrand.page;

import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/page/SwipeBackLayoutSettingsAlignmentWC;", "", "()V", "alignSettings", "", "maybeSwipeLayout", "Landroid/view/View;", "plugin-appbrand-integration_release"})
public final class cb {
    public static final cb nuN = new cb();

    static {
        AppMethodBeat.i(50952);
        AppMethodBeat.o(50952);
    }

    private cb() {
    }

    public static final void cE(View view) {
        View view2;
        AppMethodBeat.i(50951);
        if (!(view instanceof SwipeBackLayout)) {
            view2 = null;
        } else {
            view2 = view;
        }
        SwipeBackLayout swipeBackLayout = (SwipeBackLayout) view2;
        if (swipeBackLayout != null) {
            Resources resources = swipeBackLayout.getResources();
            p.g(resources, "page.resources");
            float f2 = resources.getDisplayMetrics().density;
            swipeBackLayout.setMinVelocity(100.0f * f2);
            swipeBackLayout.setMaxVelocity(300.0f * f2);
            swipeBackLayout.setEdgeTrackingEnabled(1);
            swipeBackLayout.setEdgeSize((int) ((f2 * 20.0f) + 0.5f));
            swipeBackLayout.setEdgeTrackingEnabled(1);
            swipeBackLayout.setScrimColor(0);
            AppMethodBeat.o(50951);
            return;
        }
        AppMethodBeat.o(50951);
    }
}
