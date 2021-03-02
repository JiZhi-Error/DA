package com.tencent.mm.plugin.finder.nearby.live.square;

import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.guide.a;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareGuideUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "scrollGuideHelper", "Lcom/tencent/mm/plugin/finder/nearby/guide/TabLayoutScrollGuideHelper;", "getTabLayoutScrollGuideHelper", "plugin-finder_release"})
public final class NearbyLiveSquareGuideUIC extends UIComponent {
    public a uRs = new a();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NearbyLiveSquareGuideUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(249156);
        AppMethodBeat.o(249156);
    }
}
