package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderMsgContract$MsgViewCallback$finishLoadMore$1 extends q implements a<x> {
    final /* synthetic */ boolean tGv;
    final /* synthetic */ z.d uWw;
    final /* synthetic */ FinderMsgContract.MsgViewCallback uYD;
    final /* synthetic */ List uoO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderMsgContract$MsgViewCallback$finishLoadMore$1(FinderMsgContract.MsgViewCallback msgViewCallback, List list, boolean z, z.d dVar) {
        super(0);
        this.uYD = msgViewCallback;
        this.uoO = list;
        this.tGv = z;
        this.uWw = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        boolean z;
        AppMethodBeat.i(166542);
        FinderMsgContract.MsgPresenter.a(FinderMsgContract.MsgViewCallback.b(this.uYD), this.uoO);
        if (FinderMsgContract.MsgViewCallback.b(this.uYD).kgc.isEmpty()) {
            this.uYD.o(c.a.a(this.uYD).getString(R.string.d21), c.a.a(this.uYD).getColor(R.color.BW_0_Alpha_0_3), false);
        } else {
            this.uYD.o(null, 0, false);
        }
        if (this.tGv) {
            FinderMsgContract.MsgViewCallback.h(this.uYD).apS(0);
            RecyclerView.a adapter = FinderMsgContract.MsgViewCallback.g(this.uYD).getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        } else {
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(RefreshLoadMoreLayout.c.Rmn);
            cVar.jLE = false;
            if (!this.uoO.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            cVar.Rmj = z;
            cVar.Rmk = this.uoO.size();
            RecyclerView.a adapter2 = FinderMsgContract.MsgViewCallback.g(this.uYD).getAdapter();
            if (adapter2 != null) {
                adapter2.as(this.uWw.SYE, this.uoO.size());
            }
            FinderMsgContract.MsgViewCallback.h(this.uYD).onPreFinishLoadMoreSmooth(cVar);
        }
        x xVar = x.SXb;
        AppMethodBeat.o(166542);
        return xVar;
    }
}
