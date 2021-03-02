package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.story.e.a;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\n2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R7\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "()V", "onDateClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", FFmpegMetadataRetriever.METADATA_KEY_DATE, "", "getOnDateClick", "()Lkotlin/jvm/functions/Function1;", "setOnDateClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryDateViewHolder", "plugin-story_release"})
public final class c extends d<a> {
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119726);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c07, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(pare…date_view, parent, false)");
        a aVar = new a(this, inflate);
        AppMethodBeat.o(119726);
        return aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(119727);
        a aVar = (a) vVar;
        p.h(aVar, "holder");
        String str = this.kgc.get(i2);
        p.g(str, "dataList[position]");
        String str2 = str;
        if (!p.j(str2, "")) {
            a.C1747a aVar2 = com.tencent.mm.plugin.story.e.a.Flw;
            List<String> a2 = n.a(a.C1747a.aRM(str2), new String[]{":"});
            if (a2.size() == 3) {
                aVar.jUO.setText(a2.get(1) + a2.get(2));
            }
            d.f(aVar.jUO);
            aVar.FxI.setBackground(null);
            aVar.yKM.setVisibility(8);
        }
        AppMethodBeat.o(119727);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;Landroid/view/View;)V", "arrowIv", "Landroid/widget/ImageView;", "getArrowIv", "()Landroid/widget/ImageView;", "bg", "getBg", "()Landroid/view/View;", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "plugin-story_release"})
    public final class a extends RecyclerView.v {
        final View FxI;
        final /* synthetic */ c FxJ;
        final TextView jUO;
        final ImageView yKM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.FxJ = cVar;
            AppMethodBeat.i(119724);
            View findViewById = view.findViewById(R.id.iap);
            p.g(findViewById, "itemView.findViewById(R.…y_gallery_header_date_ll)");
            this.FxI = findViewById;
            View findViewById2 = view.findViewById(R.id.bkp);
            p.g(findViewById2, "itemView.findViewById(R.id.date_tv)");
            this.jUO = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.uk);
            p.g(findViewById3, "itemView.findViewById(R.id.arrow)");
            this.yKM = (ImageView) findViewById3;
            AppMethodBeat.o(119724);
        }
    }

    @Override // com.tencent.mm.plugin.story.ui.a.d, android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119725);
        int size = this.kgc.size();
        AppMethodBeat.o(119725);
        return size;
    }
}
