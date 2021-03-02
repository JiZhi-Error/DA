package com.tencent.mm.plugin.finder.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001e\u0010\u0012\u001a\u00020\u000b2\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007R\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "()V", "datalist", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "vh", "position", "onCreateViewHolder", "p0", "Landroid/view/ViewGroup;", "p1", "setLikedContactList", "plugin-finder_release"})
public final class h extends RecyclerView.a<com.tencent.mm.view.recyclerview.h> {
    public ArrayList<aul> vNT;

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ com.tencent.mm.view.recyclerview.h a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(252654);
        p.h(viewGroup, "p0");
        com.tencent.mm.view.recyclerview.h hVar = new com.tencent.mm.view.recyclerview.h(aa.jQ(viewGroup.getContext()).inflate(R.layout.ajm, viewGroup, false));
        AppMethodBeat.o(252654);
        return hVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(252656);
        com.tencent.mm.view.recyclerview.h hVar2 = hVar;
        p.h(hVar2, "vh");
        ArrayList<aul> arrayList = this.vNT;
        if (arrayList == null) {
            p.btv("datalist");
        }
        aul aul = arrayList.get(i2);
        p.g(aul, "datalist[position]");
        aul aul2 = aul;
        m mVar = m.uJa;
        d<o> dkb = m.dkb();
        a aVar = new a(aul2.iAR);
        View Mn = hVar2.Mn(R.id.d3b);
        p.g(Mn, "vh.getView(R.id.finder_self_feed_liked_avatar_iv)");
        m mVar2 = m.uJa;
        dkb.a(aVar, (ImageView) Mn, m.a(m.a.WX_AVATAR));
        View Mn2 = hVar2.Mn(R.id.d3c);
        p.g(Mn2, "vh.getView<TextView>(R.i…_self_feed_liked_name_tv)");
        ((TextView) Mn2).setText(com.tencent.mm.pluginsdk.ui.span.l.c(hVar2.getContext(), aul2.nickName));
        AppMethodBeat.o(252656);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(252655);
        ArrayList<aul> arrayList = this.vNT;
        if (arrayList == null) {
            p.btv("datalist");
        }
        if (arrayList == null) {
            AppMethodBeat.o(252655);
            return 0;
        }
        ArrayList<aul> arrayList2 = this.vNT;
        if (arrayList2 == null) {
            p.btv("datalist");
        }
        int size = arrayList2.size();
        AppMethodBeat.o(252655);
        return size;
    }
}
