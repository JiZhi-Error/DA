package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.j;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
public final class FinderNotifyContract$NotifyViewCallback$initView$3 implements com.tencent.mm.view.recyclerview.l {
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderNotifyContract$NotifyViewCallback$initView$3(FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        this.uZd = notifyViewCallback;
    }

    @Override // com.tencent.mm.view.recyclerview.l
    public final void a(RecyclerView recyclerView, j jVar) {
        AppMethodBeat.i(249945);
        p.h(recyclerView, "recyclerView");
        p.h(jVar, "data");
        Iterator<T> it = jVar.Rrn.iterator();
        while (it.hasNext()) {
            it.next();
        }
        Log.i(this.uZd.TAG, "index " + this.uZd.uZc + " last firstVisibleItemPosition " + jVar.tIy + "  lastVisibleItemPosition :" + jVar.tIA + ' ' + "   lastFirstVisibleItemPosition   " + jVar.ptb + " lastLastVisibleItemPosition  " + jVar.ptc + "  diffVisibleDataList.size:" + jVar.Rrn.size() + ' ' + "acrossDataList " + jVar.Rrl.size() + "   visibleDataList:" + jVar.Rrk.size());
        AppMethodBeat.o(249945);
    }
}
