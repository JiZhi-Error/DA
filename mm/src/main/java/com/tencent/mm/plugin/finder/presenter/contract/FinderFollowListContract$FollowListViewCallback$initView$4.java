package com.tencent.mm.plugin.finder.presenter.contract;

import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowListContract;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
public final class FinderFollowListContract$FollowListViewCallback$initView$4 extends RefreshLoadMoreLayout.a {
    final /* synthetic */ FinderFollowListContract.FollowListViewCallback uWN;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderFollowListContract$FollowListViewCallback$initView$4(FinderFollowListContract.FollowListViewCallback followListViewCallback) {
        this.uWN = followListViewCallback;
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void ED(int i2) {
        AppMethodBeat.i(249731);
        b bVar = new b();
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
        super.ED(i2);
        this.uWN.uWL.tsO = null;
        this.uWN.uWL.nO(false);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(249731);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        View findViewById;
        TextView textView;
        AppMethodBeat.i(249732);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        if (cVar.Rmj && !FinderFollowListContract.FollowListViewCallback.g(this.uWN).RlV) {
            FinderFollowListContract.FollowListViewCallback.g(this.uWN).setHasBottomMore(true);
            View loadMoreFooter = FinderFollowListContract.FollowListViewCallback.g(this.uWN).getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(0);
            }
            View loadMoreFooter2 = FinderFollowListContract.FollowListViewCallback.g(this.uWN).getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (findViewById = loadMoreFooter2.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(8);
            }
        }
        RefreshLoadMoreLayout.b(FinderFollowListContract.FollowListViewCallback.g(this.uWN));
        k kVar = k.vkd;
        k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, "12", c.EVENT_ON_REFRESH);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249732);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void cxo() {
        AppMethodBeat.i(249733);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.cxo();
        this.uWN.uWL.nO(true);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(249733);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249734);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.a(cVar);
        if (!this.uWN.uWL.hasMore) {
            RefreshLoadMoreLayout.e(FinderFollowListContract.FollowListViewCallback.g(this.uWN));
        }
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowListContract$FollowListViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249734);
    }
}
