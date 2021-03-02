package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.video.k;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelinePresenter$initVideoAbout$1 implements k.b {
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderLikedFeedContract$LikedTimelinePresenter$initVideoAbout$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        this.uXi = likedTimelinePresenter;
    }

    @Override // com.tencent.mm.plugin.finder.video.k.b
    public final RecyclerView dch() {
        AppMethodBeat.i(166493);
        FinderLikedFeedContract.LikedTimelineViewCallback g2 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (g2 == null) {
            p.hyc();
        }
        RecyclerView recyclerView = g2.getRecyclerView();
        AppMethodBeat.o(166493);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.finder.video.k.b
    public final DataBuffer<bo> dci() {
        AppMethodBeat.i(249787);
        DataBuffer<bo> dataList = FinderLikedFeedContract.LikedTimelinePresenter.m(this.uXi).getDataList();
        AppMethodBeat.o(249787);
        return dataList;
    }
}
