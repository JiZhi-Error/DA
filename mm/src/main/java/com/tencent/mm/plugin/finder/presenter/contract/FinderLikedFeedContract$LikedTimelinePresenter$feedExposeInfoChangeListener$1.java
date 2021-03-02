package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.f;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.view.recyclerview.g;
import kotlin.l;
import kotlin.o;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1 extends f {
    private String tag;
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderLikedFeedContract$LikedTimelinePresenter$feedExposeInfoChangeListener$1(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        this.uXi = likedTimelinePresenter;
        AppMethodBeat.i(166487);
        this.tag = FinderLikedFeedContract.LikedTimelinePresenter.k(likedTimelinePresenter);
        AppMethodBeat.o(166487);
    }

    @Override // com.tencent.mm.plugin.finder.view.f
    public final String getTag() {
        return this.tag;
    }

    @Override // com.tencent.mm.plugin.finder.view.f
    public final FinderItem EB(long j2) {
        RecyclerView recyclerView;
        AppMethodBeat.i(166485);
        FinderLikedFeedContract.LikedTimelineViewCallback g2 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (!(g2 == null || (recyclerView = g2.getRecyclerView()) == null)) {
            RecyclerView.a adapter = recyclerView.getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(166485);
                throw tVar;
            }
            RecyclerView.v vVar = ((g) adapter).V(j2, false);
            if (vVar != null) {
                bo boVar = (bo) FinderLikedFeedContract.LikedTimelinePresenter.m(this.uXi).safeGet(vVar.lR());
                if (boVar instanceof BaseFinderFeed) {
                    FinderItem finderItem = ((BaseFinderFeed) boVar).feedObject;
                    AppMethodBeat.o(166485);
                    return finderItem;
                }
            }
        }
        AppMethodBeat.o(166485);
        return null;
    }

    @Override // com.tencent.mm.plugin.finder.view.f
    public final void a(long j2, azt azt) {
        RecyclerView recyclerView;
        AppMethodBeat.i(166486);
        FinderLikedFeedContract.LikedTimelineViewCallback g2 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (g2 == null || (recyclerView = g2.getRecyclerView()) == null) {
            AppMethodBeat.o(166486);
            return;
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(166486);
            throw tVar;
        }
        RecyclerView.v vVar = ((g) adapter).V(j2, false);
        if (vVar != null) {
            int lR = vVar.lR();
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.b(lR, new o(1, azt));
                AppMethodBeat.o(166486);
                return;
            }
            AppMethodBeat.o(166486);
            return;
        }
        AppMethodBeat.o(166486);
    }
}
