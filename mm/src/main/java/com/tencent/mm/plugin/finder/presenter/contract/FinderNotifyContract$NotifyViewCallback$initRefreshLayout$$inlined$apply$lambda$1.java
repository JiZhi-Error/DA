package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.plugin.finder.view.animation.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0016\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$2$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-finder_release"})
public final class FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1 extends RefreshLoadMoreLayout.a {
    final /* synthetic */ RefreshLoadMoreLayout tQK;
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;

    public FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1(RefreshLoadMoreLayout refreshLoadMoreLayout, FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        this.tQK = refreshLoadMoreLayout;
        this.uZd = notifyViewCallback;
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void ED(int i2) {
        AppMethodBeat.i(249939);
        b bVar = new b();
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
        super.ED(i2);
        this.tQK.getRecyclerView().setItemAnimator(new e());
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(249939);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249940);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        RefreshLoadMoreLayout.b(this.tQK);
        this.tQK.getRecyclerView().postDelayed(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1.AnonymousClass1 */
            final /* synthetic */ FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1 uZf;

            {
                this.uZf = r1;
            }

            public final void run() {
                AppMethodBeat.i(249938);
                this.uZf.tQK.getRecyclerView().setItemAnimator(new v());
                AppMethodBeat.o(249938);
            }
        }, 1000);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249940);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void cxo() {
        AppMethodBeat.i(249941);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.cxo();
        FinderNotifyContract.NotifyPresenter notifyPresenter = this.uZd.uZa;
        long j2 = ((com.tencent.mm.plugin.finder.model.a) j.ku(this.uZd.uZa.JV(this.uZd.uZc))).uNF.field_id;
        FinderNotifyContract finderNotifyContract = FinderNotifyContract.uYK;
        notifyPresenter.a(j2, FinderNotifyContract.dlX(), this.uZd.uZc, true, false);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(249941);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249942);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.a(cVar);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initRefreshLayout$$inlined$apply$lambda$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(249942);
    }
}
