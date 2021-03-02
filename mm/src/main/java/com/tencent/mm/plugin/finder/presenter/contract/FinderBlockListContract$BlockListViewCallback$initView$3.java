package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.presenter.contract.FinderBlockListContract;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.storage.as;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderBlockListContract$BlockListViewCallback$initView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderBlockListContract$BlockListViewCallback$initView$3 implements g.c<h> {
    final /* synthetic */ FinderBlockListContract.BlockListViewCallback uWu;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderBlockListContract$BlockListViewCallback$initView$3(FinderBlockListContract.BlockListViewCallback blockListViewCallback) {
        this.uWu = blockListViewCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249693);
        h hVar2 = hVar;
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar2, "holder");
        if (i2 == 0) {
            this.uWu.uWr.uWp.fq(this.uWu.gte);
            AppMethodBeat.o(249693);
            return;
        }
        int size = i2 - ((g) aVar).RqM.size();
        if (size >= 0 && size < this.uWu.uWr.kgc.size()) {
            FinderContact finderContact = this.uWu.uWr.kgc.get(size).contact;
            if (as.bjt(finderContact.username)) {
                Intent intent = new Intent();
                intent.putExtra("finder_username", finderContact.username);
                a aVar2 = a.vUU;
                Context context = hVar2.getContext();
                p.g(context, "holder.context");
                a.enterFinderProfileUI(context, intent);
                AppMethodBeat.o(249693);
                return;
            }
            a aVar3 = a.vUU;
            a.d(finderContact.username, this.uWu.gte);
        }
        AppMethodBeat.o(249693);
    }
}
