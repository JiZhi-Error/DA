package com.tencent.mm.plugin.finder.nearby.video;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$feedLoader$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
public final class NearbyVideoPresenter$$special$$inlined$apply$lambda$1 implements h {
    final /* synthetic */ NearbyVideoFeedLoader $this_apply;
    final /* synthetic */ NearbyVideoPresenter this$0;

    NearbyVideoPresenter$$special$$inlined$apply$lambda$1(NearbyVideoFeedLoader nearbyVideoFeedLoader, NearbyVideoPresenter nearbyVideoPresenter) {
        this.$this_apply = nearbyVideoFeedLoader;
        this.this$0 = nearbyVideoPresenter;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
    public final void call(int i2) {
        AppMethodBeat.i(249394);
        Log.i(this.$this_apply.getTAG(), "[initData] canTimelineRefresh=" + this.this$0.canTimelineRefresh + ", incrementCount=" + i2);
        if (this.this$0.canTimelineRefresh) {
            this.this$0.autoFlingToRefresh(0, false);
            this.this$0.getViewCallback().dcQ().post(NearbyVideoPresenter$feedLoader$2$1$call$1.INSTANCE);
        } else {
            FinderHomeTabStateVM.a Mq = this.this$0.tlCache.Mq(2);
            final int i3 = Mq.wuf;
            final int i4 = Mq.wug;
            Log.i(this.$this_apply.getTAG(), "[initData] canTimelineRefresh " + this.this$0.canTimelineRefresh + " lastPos=" + i3 + " fromTopPixel=" + i4);
            final RecyclerView.LayoutManager layoutManager = this.this$0.getViewCallback().getRecyclerView().getLayoutManager();
            this.this$0.totalDy = i4;
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                this.this$0.getViewCallback().getRecyclerView().post(new Runnable() {
                    /* class com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter$$special$$inlined$apply$lambda$1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(249393);
                        ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                        AppMethodBeat.o(249393);
                    }
                });
            }
            if (i2 <= 0) {
                NearbyVideoPresenter.access$checkEmptyHeader(this.this$0, null);
            }
        }
        this.this$0.getViewCallback().dcQ().post(NearbyVideoPresenter$feedLoader$2$1$call$3.INSTANCE);
        AppMethodBeat.o(249394);
    }
}
