package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter$onAttach$2$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
public final class FinderLiveSubTagConstract$Presenter$onAttach$$inlined$apply$lambda$1 implements g.c<h> {
    final /* synthetic */ FinderLiveSubTagConstract.Presenter uXx;

    FinderLiveSubTagConstract$Presenter$onAttach$$inlined$apply$lambda$1(FinderLiveSubTagConstract.Presenter presenter) {
        this.uXx = presenter;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
    @Override // com.tencent.mm.view.recyclerview.g.c
    public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
        String str;
        LinkedList<axk> linkedList;
        String str2;
        axk axk;
        String str3 = null;
        AppMethodBeat.i(249803);
        h hVar2 = hVar;
        p.h(aVar, "adapter");
        p.h(view, "view");
        p.h(hVar2, "holder");
        if (hVar2.hgv() instanceof al) {
            FinderLiveSubTagConstract.Presenter presenter = this.uXx;
            axk axk2 = new axk();
            axk axk3 = this.uXx.uXt;
            axk2.LHS = axk3 != null ? axk3.LHS : 0;
            axk axk4 = this.uXx.uXt;
            if (axk4 == null || (str = axk4.qHk) == null) {
                str = "";
            }
            axk2.qHk = str;
            axk axk5 = this.uXx.uXt;
            if (axk5 != null) {
                linkedList = axk5.LHT;
            } else {
                linkedList = null;
            }
            axk2.LHT = linkedList;
            axk2.LHU = ((al) hVar2.hgv()).uOy;
            presenter.uXq = axk2;
            FinderLiveSubTagConstract.ViewCallback viewCallback = this.uXx.uXs;
            if (viewCallback != null) {
                viewCallback.dlV();
            }
            FinderLiveSubTagConstract.Presenter.a(this.uXx).tEC = this.uXx.uXq;
            aVar.notifyDataSetChanged();
            StringBuilder sb = new StringBuilder("sub tag item click. selectedTag:[");
            axk axk6 = this.uXx.uXq;
            if (axk6 != null) {
                str2 = axk6.qHk;
            } else {
                str2 = null;
            }
            StringBuilder append = sb.append(str2).append('-');
            axk axk7 = this.uXx.uXq;
            if (!(axk7 == null || (axk = axk7.LHU) == null)) {
                str3 = axk.qHk;
            }
            Log.i("FinderLiveSubTagConstract.Presenter", append.append(str3).append(']').toString());
        }
        AppMethodBeat.o(249803);
    }
}
