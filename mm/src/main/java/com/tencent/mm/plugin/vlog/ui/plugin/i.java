package com.tencent.mm.plugin.vlog.ui.plugin;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.vlog.model.effect.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\tH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0014\u0010\u001b\u001a\u00020\u000e2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000RL\u0010\u0007\u001a4\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MagicPanelViewHolder;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/model/effect/MagicListItem;", "onItemClickListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "items", "", "plugin-vlog_release"})
public final class i extends RecyclerView.a<j> {
    private final LinkedList<e> gTV = new LinkedList<>();
    m<? super Integer, ? super e, x> uAj;

    public i() {
        AppMethodBeat.i(191288);
        AppMethodBeat.o(191288);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ j a(ViewGroup viewGroup, int i2) {
        g gVar;
        AppMethodBeat.i(191285);
        p.h(viewGroup, "parent");
        switch (i2) {
            case 1:
                View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.axa, viewGroup, false);
                p.g(inflate, "LayoutInflater.from(pare…nel_title, parent, false)");
                gVar = new l(inflate);
                break;
            case 2:
                View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ax_, viewGroup, false);
                p.g(inflate2, "LayoutInflater.from(pare…nel_added, parent, false)");
                gVar = new g(inflate2);
                break;
            default:
                View inflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ax9, viewGroup, false);
                p.g(inflate3, "LayoutInflater.from(pare…gic_panel, parent, false)");
                gVar = new h(inflate3);
                break;
        }
        RecyclerView.v vVar = gVar;
        AppMethodBeat.o(191285);
        return vVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(j jVar, int i2) {
        AppMethodBeat.i(191287);
        j jVar2 = jVar;
        p.h(jVar2, "viewHolder");
        e eVar = this.gTV.get(i2);
        p.g(eVar, "itemList[position]");
        e eVar2 = eVar;
        jVar2.a(eVar2);
        jVar2.aus.setOnClickListener(new a(this, i2, eVar2));
        AppMethodBeat.o(191287);
    }

    public final void ad(List<? extends e> list) {
        AppMethodBeat.i(191283);
        p.h(list, "items");
        this.gTV.clear();
        this.gTV.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(191283);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        AppMethodBeat.i(191284);
        int i3 = this.gTV.get(i2).type;
        AppMethodBeat.o(191284);
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(191286);
        int size = this.gTV.size();
        AppMethodBeat.o(191286);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ i GHl;
        final /* synthetic */ e GHm;
        final /* synthetic */ int gUj;

        a(i iVar, int i2, e eVar) {
            this.GHl = iVar;
            this.gUj = i2;
            this.GHm = eVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(191282);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            m<? super Integer, ? super e, x> mVar = this.GHl.uAj;
            if (mVar != null) {
                mVar.invoke(Integer.valueOf(this.gUj), this.GHm);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/MagicPanelAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(191282);
        }
    }
}
