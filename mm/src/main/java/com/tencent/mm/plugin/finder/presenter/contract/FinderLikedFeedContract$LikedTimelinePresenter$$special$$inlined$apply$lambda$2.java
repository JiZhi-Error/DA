package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelinePresenter$feedLoader$1$2"})
final class FinderLikedFeedContract$LikedTimelinePresenter$$special$$inlined$apply$lambda$2 extends q implements a<x> {
    final /* synthetic */ FinderLikedFeedContract.LikedTimelinePresenter uXi;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLikedFeedContract$LikedTimelinePresenter$$special$$inlined$apply$lambda$2(FinderLikedFeedContract.LikedTimelinePresenter likedTimelinePresenter) {
        super(0);
        this.uXi = likedTimelinePresenter;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        RefreshLoadMoreLayout rlLayout;
        View loadMoreFooter;
        View findViewById;
        RefreshLoadMoreLayout rlLayout2;
        View loadMoreFooter2;
        TextView textView;
        RefreshLoadMoreLayout rlLayout3;
        View loadMoreFooter3;
        TextView textView2;
        RefreshLoadMoreLayout rlLayout4;
        View loadMoreFooter4;
        TextView textView3;
        AppMethodBeat.i(249784);
        FinderLikedFeedContract.LikedTimelineViewCallback g2 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (!(g2 == null || (rlLayout4 = g2.getRlLayout()) == null || (loadMoreFooter4 = rlLayout4.getLoadMoreFooter()) == null || (textView3 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
            textView3.setText(R.string.d0m);
        }
        FinderLikedFeedContract.LikedTimelineViewCallback g3 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (!(g3 == null || (rlLayout3 = g3.getRlLayout()) == null || (loadMoreFooter3 = rlLayout3.getLoadMoreFooter()) == null || (textView2 = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            textView2.setTextColor(context.getResources().getColor(R.color.FG_2));
        }
        FinderLikedFeedContract.LikedTimelineViewCallback g4 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (!(g4 == null || (rlLayout2 = g4.getRlLayout()) == null || (loadMoreFooter2 = rlLayout2.getLoadMoreFooter()) == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
            textView.setVisibility(8);
        }
        FinderLikedFeedContract.LikedTimelineViewCallback g5 = FinderLikedFeedContract.LikedTimelinePresenter.g(this.uXi);
        if (!(g5 == null || (rlLayout = g5.getRlLayout()) == null || (loadMoreFooter = rlLayout.getLoadMoreFooter()) == null || (findViewById = loadMoreFooter.findViewById(R.id.ep0)) == null)) {
            findViewById.setVisibility(0);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249784);
        return xVar;
    }
}
