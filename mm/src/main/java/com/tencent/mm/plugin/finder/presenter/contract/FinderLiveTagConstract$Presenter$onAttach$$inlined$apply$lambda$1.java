package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter$onAttach$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderLiveTagConstract$Presenter$onAttach$$inlined$apply$lambda$1 implements g.c<h> {
    final /* synthetic */ FinderLiveTagConstract.Presenter uXH;

    FinderLiveTagConstract$Presenter$onAttach$$inlined$apply$lambda$1(FinderLiveTagConstract.Presenter presenter) {
        this.uXH = presenter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249816);
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar, "holder");
        FinderLiveTagConstract.Presenter.a(this.uXH, i2);
        AppMethodBeat.o(249816);
    }
}