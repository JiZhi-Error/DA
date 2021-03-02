package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderLikedFeedContract$LikedTimelineViewCallback$initView$2$onRefreshBegin$1 implements Runnable {
    final /* synthetic */ FinderLikedFeedContract$LikedTimelineViewCallback$initView$2 USz;

    FinderLikedFeedContract$LikedTimelineViewCallback$initView$2$onRefreshBegin$1(FinderLikedFeedContract$LikedTimelineViewCallback$initView$2 finderLikedFeedContract$LikedTimelineViewCallback$initView$2) {
        this.USz = finderLikedFeedContract$LikedTimelineViewCallback$initView$2;
    }

    public final void run() {
        AppMethodBeat.i(261260);
        this.USz.uXm.uXl.uXc.requestRefresh();
        AppMethodBeat.o(261260);
    }
}
