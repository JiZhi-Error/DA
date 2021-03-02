package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bk;
import com.tencent.mm.plugin.finder.presenter.contract.FinderFollowTopicListContract;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderFollowTopicListContract$FollowTopicViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderFollowTopicListContract$FollowTopicViewCallback$initView$2 implements g.c<h> {
    final /* synthetic */ FinderFollowTopicListContract.FollowTopicViewCallback uWY;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public FinderFollowTopicListContract$FollowTopicViewCallback$initView$2(FinderFollowTopicListContract.FollowTopicViewCallback followTopicViewCallback) {
        this.uWY = followTopicViewCallback;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        AppMethodBeat.i(249766);
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar, "holder");
        ArrayList<bk> arrayList = this.uWY.uWW.kgc;
        if (i2 < arrayList.size()) {
            bds bds = arrayList.get(i2).dMU;
            w.a aVar2 = new w.a(0, bds.tvC, new WeakReference(this.uWY.activity));
            w wVar = w.vXp;
            String str = bds.dST;
            if (str == null) {
                str = "";
            }
            w.a(str, (Long) null, aVar2);
        }
        AppMethodBeat.o(249766);
    }
}
