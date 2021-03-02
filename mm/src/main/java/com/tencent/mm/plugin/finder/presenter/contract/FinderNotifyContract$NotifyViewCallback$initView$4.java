package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.a;
import com.tencent.mm.plugin.finder.model.bc;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderNotifyContract$NotifyViewCallback$initView$4 implements g.c<h> {
    final /* synthetic */ FinderNotifyContract.NotifyViewCallback uZd;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderNotifyContract$NotifyViewCallback$initView$4(FinderNotifyContract.NotifyViewCallback notifyViewCallback) {
        this.uZd = notifyViewCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249946);
        h hVar2 = hVar;
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar2, "holder");
        int size = i2 - ((g) aVar).RqM.size();
        if (size < 0 || size >= this.uZd.uZa.JV(this.uZd.uZc).size()) {
            AppMethodBeat.o(249946);
            return;
        }
        a aVar2 = this.uZd.uZa.JV(this.uZd.uZc).get(size);
        p.g(aVar2, "presenter.getData(tabIndex)[fixPos]");
        a aVar3 = aVar2;
        if (!(aVar3 instanceof bc)) {
            ao aoVar = aVar3.uNF;
            FinderNotifyContract.NotifyViewCallback.UICallbackListener uICallbackListener = this.uZd.uZb;
            if (uICallbackListener != null) {
                uICallbackListener.a(aoVar);
            }
            Log.i(this.uZd.TAG, "onClick " + size + " id:" + aoVar.field_id + " commentId:" + aoVar.field_commentId);
            FinderNotifyContract.NotifyViewCallback.a(this.uZd, aoVar, size, hVar2, aVar3);
        }
        AppMethodBeat.o(249946);
    }
}
