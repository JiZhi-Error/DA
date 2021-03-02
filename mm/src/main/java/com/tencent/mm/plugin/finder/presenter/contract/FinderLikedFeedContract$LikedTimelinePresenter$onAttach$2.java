package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.q;
import kotlin.k.f;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
final class FinderLikedFeedContract$LikedTimelinePresenter$onAttach$2 extends q implements m<Integer, Integer, LinkedList<bo>> {
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLikedFeedContract$LikedTimelinePresenter$onAttach$2(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        super(2);
        this.uXi = likedTimelinePresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.g.a.m
    public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
        Integer num3;
        FinderLikedFeedLoader m;
        DataBuffer dataListJustForAdapter;
        List a2;
        DataBuffer dataListJustForAdapter2;
        AppMethodBeat.i(249789);
        int intValue = num.intValue();
        int intValue2 = num2.intValue();
        if (intValue >= 0) {
            FinderLikedFeedLoader m2 = FinderLikedFeedContract.LikedTimelinePresenter.m(this.uXi);
            if (m2 == null || (dataListJustForAdapter2 = m2.getDataListJustForAdapter()) == null) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(dataListJustForAdapter2.size());
            }
            if (!(intValue2 >= num3.intValue() || (m = FinderLikedFeedContract.LikedTimelinePresenter.m(this.uXi)) == null || (dataListJustForAdapter = m.getDataListJustForAdapter()) == null || (a2 = j.a((List) dataListJustForAdapter, new f(intValue, intValue2))) == null)) {
                LinkedList linkedList = new LinkedList(a2);
                AppMethodBeat.o(249789);
                return linkedList;
            }
        }
        AppMethodBeat.o(249789);
        return null;
    }
}
