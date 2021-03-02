package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mv.ui.view.MusicMvMarqueeTextView;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u001a\u001bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u000eH\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\u0014\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0019R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00070\tj\b\u0012\u0004\u0012\u00020\u0007`\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "itemClickListener", "Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;)V", "TAG", "", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemClickListener", "()Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "update", "list", "", "MusicLyricViewHolder", "OnItemClickListener", "plugin-mv_release"})
public final class a extends RecyclerView.a<C1548a> {
    final b ArD;
    private final String TAG = "MicroMsg.MusicLyricAdapter";
    private final ArrayList<String> kgc = new ArrayList<>();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$OnItemClickListener;", "", "onClick", "", "position", "", "plugin-mv_release"})
    public interface b {
        void cVN();
    }

    public a(b bVar) {
        p.h(bVar, "itemClickListener");
        AppMethodBeat.i(256964);
        this.ArD = bVar;
        AppMethodBeat.o(256964);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C1548a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(256961);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bdz, viewGroup, false);
        p.g(inflate, "itemView");
        C1548a aVar = new C1548a(this, inflate);
        AppMethodBeat.o(256961);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C1548a aVar, int i2) {
        AppMethodBeat.i(256962);
        C1548a aVar2 = aVar;
        p.h(aVar2, "holder");
        aVar2.ArE.setText(this.kgc.get(i2));
        AppMethodBeat.o(256962);
    }

    public final void hw(List<String> list) {
        AppMethodBeat.i(259228);
        p.h(list, "list");
        this.kgc.clear();
        this.kgc.addAll(list);
        notifyDataSetChanged();
        AppMethodBeat.o(259228);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(256963);
        int size = this.kgc.size();
        AppMethodBeat.o(256963);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter;Landroid/view/View;)V", "textView", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "getTextView", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "plugin-mv_release"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.adapter.a$a  reason: collision with other inner class name */
    public final class C1548a extends RecyclerView.v {
        final MusicMvMarqueeTextView ArE;
        final /* synthetic */ a ArF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1548a(a aVar, View view) {
            super(view);
            p.h(view, "itemView");
            this.ArF = aVar;
            AppMethodBeat.i(256960);
            this.ArE = (MusicMvMarqueeTextView) view.findViewById(R.id.f5i);
            this.ArE.setTextSize((float) com.tencent.mm.cb.a.fromDPToPix(view.getContext(), 22));
            MusicMvMarqueeTextView musicMvMarqueeTextView = this.ArE;
            Context context = view.getContext();
            p.g(context, "itemView.context");
            musicMvMarqueeTextView.setTextColor(context.getResources().getColor(R.color.am));
            this.ArE.setTextBold(true);
            MusicMvMarqueeTextView musicMvMarqueeTextView2 = this.ArE;
            musicMvMarqueeTextView2.paint.setShadowLayer(4.0f, 0.0f, 1.0f, musicMvMarqueeTextView2.getResources().getColor(R.color.BW_0_Alpha_0_1_5));
            this.ArE.setEffect(new MusicMvMarqueeTextView.c(this.ArE.getViewProvider()));
            view.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.mv.ui.adapter.a.C1548a.AnonymousClass1 */
                final /* synthetic */ C1548a ArG;

                {
                    this.ArG = r1;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(256959);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    b bVar2 = this.ArG.ArF.ArD;
                    this.ArG.lR();
                    bVar2.cVN();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/adapter/MusicLyricAdapter$MusicLyricViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(256959);
                }
            });
            AppMethodBeat.o(256960);
        }
    }
}
