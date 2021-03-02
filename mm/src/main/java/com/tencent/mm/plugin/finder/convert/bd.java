package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.x;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016J \u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderMoreLikeDividerConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/feed/FinderMoreLikeDivider;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public final class bd extends e<x> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    @Override // com.tencent.mm.view.recyclerview.e
    public final /* synthetic */ void a(h hVar, x xVar, int i2, int i3, boolean z, List list) {
        AppMethodBeat.i(243184);
        x xVar2 = xVar;
        p.h(hVar, "holder");
        p.h(xVar2, "item");
        hVar.e(R.id.dov, xVar2.tOO);
        View Mn = hVar.Mn(R.id.dow);
        p.g(Mn, "tipsLayout");
        ViewGroup.LayoutParams layoutParams = Mn.getLayoutParams();
        if (xVar2.tOP.LLE == 0) {
            Context context = hVar.getContext();
            p.g(context, "holder.context");
            layoutParams.height = (int) context.getResources().getDimension(R.dimen.a4p);
            AppMethodBeat.o(243184);
            return;
        }
        Context context2 = hVar.getContext();
        p.g(context2, "holder.context");
        layoutParams.height = (int) context2.getResources().getDimension(R.dimen.ci);
        AppMethodBeat.o(243184);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.a_w;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243183);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        TextView textView = (TextView) hVar.Mn(R.id.dov);
        if (textView != null) {
            textView.setText("");
            AppMethodBeat.o(243183);
            return;
        }
        AppMethodBeat.o(243183);
    }
}
