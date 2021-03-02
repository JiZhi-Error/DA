package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelinePresenter$$special$$inlined$apply$lambda$1 implements h {
    final /* synthetic */ FinderLikedFeedLoader uXh;
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    FinderLikedFeedContract$LikedTimelinePresenter$$special$$inlined$apply$lambda$1(FinderLikedFeedLoader finderLikedFeedLoader, FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        this.uXh = finderLikedFeedLoader;
        this.uXi = likedTimelinePresenter;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
    public final void call(int i2) {
        RecyclerView recyclerView;
        RecyclerView.LayoutManager layoutManager;
        AppMethodBeat.i(249783);
        FinderLikedFeedContract.LikedTimelineViewCallback g2 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (g2 == null || (recyclerView = g2.getRecyclerView()) == null || (layoutManager = recyclerView.getLayoutManager()) == null) {
            AppMethodBeat.o(249783);
        } else if (layoutManager == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
            AppMethodBeat.o(249783);
            throw tVar;
        } else {
            ((FinderLinearLayoutManager) layoutManager).ah(this.uXh.getInitPos(), 0);
            AppMethodBeat.o(249783);
        }
    }
}
