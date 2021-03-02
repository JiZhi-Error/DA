package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
final class FinderLikedFeedContract$LikedTimelinePresenter$onAttach$1 extends q implements b<Integer, bo> {
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLikedFeedContract$LikedTimelinePresenter$onAttach$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        super(1);
        this.uXi = likedTimelinePresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ bo invoke(Integer num) {
        bo boVar;
        BaseFinderFeed baseFinderFeed;
        AppMethodBeat.i(249788);
        int intValue = num.intValue();
        if (intValue < 0 || intValue >= FinderLikedFeedContract.LikedTimelinePresenter.m(this.uXi).getDataListJustForAdapter().size()) {
            AppMethodBeat.o(249788);
            return null;
        }
        FinderLikedFeedLoader m = FinderLikedFeedContract.LikedTimelinePresenter.m(this.uXi);
        if (m != null) {
            boVar = (bo) m.get(intValue);
        } else {
            boVar = null;
        }
        if (boVar instanceof BaseFinderFeed) {
            baseFinderFeed = (BaseFinderFeed) boVar;
        } else {
            baseFinderFeed = null;
        }
        BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
        AppMethodBeat.o(249788);
        return baseFinderFeed2;
    }
}
