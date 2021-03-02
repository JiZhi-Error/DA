package com.tencent.mm.plugin.finder.nearby.live;

import com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback$initRecyclerView$1", "Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "supportsPredictiveItemAnimations", "", "plugin-finder_release"})
public final class NearbyLiveViewCallback$initRecyclerView$1 extends FinderStaggeredGridLayoutManager {
    NearbyLiveViewCallback$initRecyclerView$1() {
        super(2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.StaggeredGridLayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
