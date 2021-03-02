package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
public final class FinderFollowTopicListContract$FollowTopicViewCallback$initView$4 extends RefreshLoadMoreLayout.a {
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicViewCallback uWY;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderFollowTopicListContract$FollowTopicViewCallback$initView$4(FinderFollowTopicListContract.FollowTopicViewCallback followTopicViewCallback) {
        this.uWY = followTopicViewCallback;
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void ED(int i2) {
        AppMethodBeat.i(249768);
        b bVar = new b();
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
        super.ED(i2);
        this.uWY.uWW.nO(false);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(249768);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249769);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        RefreshLoadMoreLayout.b(FinderFollowTopicListContract.FollowTopicViewCallback.e(this.uWY));
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249769);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void cxo() {
        AppMethodBeat.i(249770);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.cxo();
        this.uWY.uWW.nO(true);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(249770);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249771);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.a(cVar);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249771);
    }
}
