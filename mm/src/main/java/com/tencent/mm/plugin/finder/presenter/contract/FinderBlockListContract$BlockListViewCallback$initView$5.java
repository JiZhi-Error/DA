package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$5 extends RefreshLoadMoreLayout.a {
    final /* synthetic */ FinderBlockListContract.BlockListViewCallback uWu;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderBlockListContract$BlockListViewCallback$initView$5(FinderBlockListContract.BlockListViewCallback blockListViewCallback) {
        this.uWu = blockListViewCallback;
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void ED(int i2) {
        AppMethodBeat.i(249699);
        b bVar = new b();
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
        super.ED(i2);
        this.uWu.uWr.dlQ();
        FinderBlockListContract.BlockListViewCallback.e(this.uWu).setItemAnimator(new e());
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(249699);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249700);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        RefreshLoadMoreLayout.b(FinderBlockListContract.BlockListViewCallback.f(this.uWu));
        FinderBlockListContract.BlockListViewCallback.e(this.uWu).postDelayed(new FinderBlockListContract$BlockListViewCallback$initView$5$onRefreshEnd$1(this), 1000);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249700);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void cxo() {
        AppMethodBeat.i(249701);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.cxo();
        this.uWu.uWr.dlQ();
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(249701);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249702);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.a(cVar);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$5", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249702);
    }
}
