package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLikedFeedContract;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0016\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onRefreshBegin", "refreshType", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
public final class FinderLikedFeedContract$LikedTimelineViewCallback$initView$2 extends RefreshLoadMoreLayout.a {
    private boolean tMa = true;
    final /* synthetic */ FinderLikedFeedContract.LikedTimelineViewCallback uXm;
    final /* synthetic */ View uXn;

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void a(RefreshLoadMoreLayout.c cVar) {
        AppMethodBeat.i(261265);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        super.a(cVar);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(261265);
    }

    public FinderLikedFeedContract$LikedTimelineViewCallback$initView$2(FinderLikedFeedContract.LikedTimelineViewCallback likedTimelineViewCallback, View view) {
        this.uXm = likedTimelineViewCallback;
        this.uXn = view;
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void ED(int i2) {
        AppMethodBeat.i(261261);
        b bVar = new b();
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
        super.ED(i2);
        Log.i(this.uXm.TAG, "onRequestRefresh");
        h.RTc.aX(new FinderLikedFeedContract$LikedTimelineViewCallback$initView$2$onRefreshBegin$1(this));
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
        AppMethodBeat.o(261261);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        int i2;
        AppMethodBeat.i(261262);
        b bVar = new b();
        bVar.bm(cVar);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
        p.h(cVar, "reason");
        super.onRefreshEnd(cVar);
        View view = this.uXm.GQ;
        if (view == null) {
            p.btv("mEmptyView");
        }
        if (view != null) {
            RecyclerView.a adapter = this.uXm.getRecyclerView().getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                i2 = wxRecyclerAdapter.hgt();
            } else {
                i2 = 0;
            }
            if (i2 <= 0) {
                view.setVisibility(0);
                View view2 = this.uXn;
                if (view2 != null) {
                    view2.setVisibility(8);
                }
            } else {
                view.setVisibility(8);
                View view3 = this.uXn;
                if (view3 != null) {
                    view3.setVisibility(0);
                }
            }
        }
        if (cVar.Rmk > 0) {
            FinderLikedFeedContract finderLikedFeedContract = FinderLikedFeedContract.uXb;
            if (FinderLikedFeedContract.dlU()) {
                FinderLikedFeedContract.LikedTimelineViewCallback.a(this.uXm, FinderLikedFeedContract.LikedTimelineViewCallback.d(this.uXm));
            }
        }
        k kVar = k.vkd;
        k.b(this.uXm.getRecyclerView(), s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD_LIVING_AVATAR, "2", c.EVENT_ON_REFRESH);
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
        AppMethodBeat.o(261262);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void cxo() {
        AppMethodBeat.i(261263);
        a.b("com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
        super.cxo();
        Log.i(this.uXm.TAG, "onRequestLoadMore");
        h.RTc.aX(new FinderLikedFeedContract$LikedTimelineViewCallback$initView$2$onLoadMoreBegin$1(this));
        a.a(this, "com/tencent/mm/plugin/finder/presenter/contract/FinderLikedFeedContract$LikedTimelineViewCallback$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(261263);
    }

    @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
    public final void IF(int i2) {
        AppMethodBeat.i(261264);
        if (this.tMa && i2 > 0) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uXm.gte).get(FinderReporterUIC.class));
            if (d2 != null) {
                d2.dap().onScrollStateChanged(FinderLikedFeedContract.LikedTimelineViewCallback.d(this.uXm), 5);
            }
            this.tMa = false;
        }
        AppMethodBeat.o(261264);
    }
}
