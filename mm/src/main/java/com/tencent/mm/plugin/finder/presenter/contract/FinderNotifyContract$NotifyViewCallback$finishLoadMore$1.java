package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderNotifyContract$NotifyViewCallback$finishLoadMore$1 extends q implements a<x> {
    final /* synthetic */ boolean tGv;
    final /* synthetic */ z.d uWw;
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;
    final /* synthetic */ List uoO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderNotifyContract$NotifyViewCallback$finishLoadMore$1(FinderNotifyContract.NotifyViewCallback notifyViewCallback, boolean z, List list, z.d dVar) {
        super(0);
        this.uZd = notifyViewCallback;
        this.tGv = z;
        this.uoO = list;
        this.uWw = dVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.g.a.a
    public final /* synthetic */ x invoke() {
        boolean z;
        Integer num = null;
        AppMethodBeat.i(249934);
        if (this.uZd.uZa.JV(this.uZd.uZc).isEmpty()) {
            this.uZd.o(c.a.a(this.uZd).getString(R.string.d21), c.a.a(this.uZd).getColor(R.color.BW_0_Alpha_0_3), false);
        } else {
            this.uZd.o(null, 0, false);
        }
        if (this.tGv) {
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.uZd.tLS;
            if (refreshLoadMoreLayout != null) {
                refreshLoadMoreLayout.apS(0);
            }
            String str = this.uZd.TAG;
            StringBuilder append = new StringBuilder("finishLoadMore: onFinishRefresh notifyDataSetChanged:").append(this.uZd.uZc).append(" size:");
            RecyclerView.a adapter = FinderNotifyContract.NotifyViewCallback.h(this.uZd).getAdapter();
            if (adapter != null) {
                num = Integer.valueOf(adapter.getItemCount());
            }
            Log.i(str, append.append(num).toString());
            RecyclerView.a adapter2 = FinderNotifyContract.NotifyViewCallback.h(this.uZd).getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
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
            RecyclerView.a adapter3 = FinderNotifyContract.NotifyViewCallback.h(this.uZd).getAdapter();
            if (adapter3 != null) {
                adapter3.as(this.uWw.SYE, this.uoO.size());
            }
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.uZd.tLS;
            if (refreshLoadMoreLayout2 != null) {
                refreshLoadMoreLayout2.onPreFinishLoadMoreSmooth(cVar);
            }
        }
        x xVar = x.SXb;
        AppMethodBeat.o(249934);
        return xVar;
    }
}
