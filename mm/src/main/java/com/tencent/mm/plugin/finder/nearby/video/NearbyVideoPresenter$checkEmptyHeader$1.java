package com.tencent.mm.plugin.finder.nearby.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.plugin.finder.nearby.video.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class NearbyVideoPresenter$checkEmptyHeader$1 extends q implements a<x> {
    final /* synthetic */ RefreshLoadMoreLayout.c $r;
    final /* synthetic */ NearbyVideoPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NearbyVideoPresenter$checkEmptyHeader$1(NearbyVideoPresenter nearbyVideoPresenter, RefreshLoadMoreLayout.c cVar) {
        super(0);
        this.this$0 = nearbyVideoPresenter;
        this.$r = cVar;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        RefreshLoadMoreLayout.c cVar;
        int i2;
        boolean z;
        RefreshLoadMoreLayout dcQ;
        RefreshLoadMoreLayout dcQ2;
        RecyclerView recyclerView;
        boolean z2 = false;
        AppMethodBeat.i(249397);
        RefreshLoadMoreLayout.c cVar2 = this.$r;
        if (cVar2 == null) {
            RefreshLoadMoreLayout.c cVar3 = new RefreshLoadMoreLayout.c(0);
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            cVar3.Rmi = context.getResources().getString(R.string.d3g);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        a.b<bo> viewCallback = this.this$0.getViewCallback();
        RecyclerView.a adapter = (viewCallback == null || (recyclerView = viewCallback.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
        if (!(adapter instanceof WxRecyclerAdapter)) {
            adapter = null;
        }
        WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
        if (wxRecyclerAdapter != null) {
            i2 = wxRecyclerAdapter.hgt();
        } else {
            i2 = 0;
        }
        boolean z3 = i2 <= 0;
        Log.i(NearbyVideoPresenter.TAG, "[checkEmptyHeader] isEmpty=" + z3 + " reason=" + cVar);
        if (cVar.actionType == 2 || cVar.Rmh != -2) {
            z = false;
        } else {
            z = true;
        }
        if (z3 || z) {
            if (z) {
                this.this$0.getFeedLoader().getDataList().clear();
                if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.notifyDataSetChanged();
                }
                this.this$0.isEmptyLocation = true;
            }
            a.b<bo> viewCallback2 = this.this$0.getViewCallback();
            if (!(viewCallback2 == null || (dcQ = viewCallback2.dcQ()) == null)) {
                dcQ.setEnableLoadMore(false);
            }
            g gVar = this.this$0.emptyData;
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            String string = context2.getResources().getString(R.string.d3g);
            p.g(string, "MMApplicationContext.get…g.finder_no_more_content)");
            gVar.P(string);
            this.this$0.emptyData.type = cVar.Rmh;
            this.this$0.emptyData.dLS = 2;
            if (wxRecyclerAdapter != null && !wxRecyclerAdapter.a(this.this$0.emptyData)) {
                wxRecyclerAdapter.a((g.b) this.this$0.emptyData, false);
            } else if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.Or((long) this.this$0.emptyData.hashCode());
            }
        } else if (wxRecyclerAdapter != null) {
            wxRecyclerAdapter.T((long) this.this$0.emptyData.hashCode(), false);
        }
        a.b<bo> viewCallback3 = this.this$0.getViewCallback();
        if (viewCallback3 == null || (dcQ2 = viewCallback3.dcQ()) == null) {
            AppMethodBeat.o(249397);
            return;
        }
        if (cVar.Rmh != -1 || !z3) {
            z2 = true;
        }
        dcQ2.setEnableNestedScroll(z2);
        AppMethodBeat.o(249397);
    }
}
