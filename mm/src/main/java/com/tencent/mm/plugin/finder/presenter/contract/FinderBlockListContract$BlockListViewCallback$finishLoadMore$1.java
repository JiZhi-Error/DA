package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.p;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderBlockListContract$BlockListViewCallback$finishLoadMore$1 extends q implements a<x> {
    final /* synthetic */ boolean tGv;
    final /* synthetic */ FinderBlockListContract.BlockListViewCallback uWu;
    final /* synthetic */ List uWv;
    final /* synthetic */ z.d uWw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderBlockListContract$BlockListViewCallback$finishLoadMore$1(FinderBlockListContract.BlockListViewCallback blockListViewCallback, boolean z, List list, z.d dVar) {
        super(0);
        this.uWu = blockListViewCallback;
        this.tGv = z;
        this.uWv = list;
        this.uWw = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        boolean z;
        AppMethodBeat.i(249689);
        if (this.tGv) {
            FinderBlockListContract.BlockListViewCallback.c(this.uWu).kgc.clear();
            FinderBlockListContract.BlockListViewCallback.c(this.uWu).kgc.addAll(this.uWv);
            FinderBlockListContract.BlockListViewCallback.f(this.uWu).apS(0);
            RecyclerView.a adapter = FinderBlockListContract.BlockListViewCallback.e(this.uWu).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            FinderBlockListContract.BlockListViewCallback.c(this.uWu).kgc.addAll(this.uWv);
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(RefreshLoadMoreLayout.c.Rmn);
            cVar.jLE = false;
            if (!this.uWv.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            cVar.Rmj = z;
            cVar.Rmk = this.uWv.size();
            RecyclerView.a adapter2 = FinderBlockListContract.BlockListViewCallback.e(this.uWu).getAdapter();
            if (adapter2 != null) {
                WxRecyclerAdapter<p> wxRecyclerAdapter = this.uWu.tFp;
                Integer valueOf = wxRecyclerAdapter != null ? Integer.valueOf(wxRecyclerAdapter.RqM.size() + this.uWw.SYE) : null;
                if (valueOf == null) {
                    kotlin.g.b.p.hyc();
                }
                adapter2.as(valueOf.intValue(), this.uWv.size());
            }
            FinderBlockListContract.BlockListViewCallback.f(this.uWu).onPreFinishLoadMoreSmooth(cVar);
        }
        this.uWu.bIo();
        x xVar = x.SXb;
        AppMethodBeat.o(249689);
        return xVar;
    }
}
