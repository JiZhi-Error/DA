package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$4 implements g.d<h> {
    final /* synthetic */ FinderBlockListContract.BlockListViewCallback uWu;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderBlockListContract$BlockListViewCallback$initView$4(FinderBlockListContract.BlockListViewCallback blockListViewCallback) {
        this.uWu = blockListViewCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.d
    public final /* synthetic */ boolean b(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249697);
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar, "holder");
        a aVar2 = new a(this.uWu.gte);
        int size = i2 - ((g) aVar).RqM.size();
        TouchableLayout.a aVar3 = TouchableLayout.Rni;
        int i3 = TouchableLayout.kuv;
        TouchableLayout.a aVar4 = TouchableLayout.Rni;
        aVar2.a(view, size, 0, new FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$1(this), new FinderBlockListContract$BlockListViewCallback$initView$4$onItemLongClick$2(this, size, aVar), i3, TouchableLayout.kuw);
        aVar2.gTx();
        AppMethodBeat.o(249697);
        return true;
    }
}
