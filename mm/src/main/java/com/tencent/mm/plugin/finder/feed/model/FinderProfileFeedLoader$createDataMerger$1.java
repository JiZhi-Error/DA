package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002J2\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u001a\u0010\b\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
public final class FinderProfileFeedLoader$createDataMerger$1 extends BaseFeedLoader<bo>.a {
    final /* synthetic */ FinderProfileFeedLoader this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderProfileFeedLoader$createDataMerger$1(FinderProfileFeedLoader finderProfileFeedLoader) {
        super();
        this.this$0 = finderProfileFeedLoader;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.b, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a
    public final void mergeRefresh(IResponse<bo> iResponse, b<? super IResponse<bo>, x> bVar) {
        AppMethodBeat.i(244802);
        p.h(iResponse, "response");
        RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
        d.h(new FinderProfileFeedLoader$createDataMerger$1$mergeRefresh$1(this, new n(7, iResponse.getIncrementList(), false, 12), new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.Rmm), bVar, iResponse));
        AppMethodBeat.o(244802);
    }
}
