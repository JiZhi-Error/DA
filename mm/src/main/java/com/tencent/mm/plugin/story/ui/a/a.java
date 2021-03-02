package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.f.d.h;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\r\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bJ\u0014\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "()V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelected", "update", "items", "", "ControlViewHolder", "plugin-story_release"})
public final class a extends RecyclerView.a<C1773a> {
    public final ArrayList<h> Fsh = new ArrayList<>();
    public int va;

    public a() {
        AppMethodBeat.i(119718);
        AppMethodBeat.o(119718);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ C1773a a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119715);
        p.h(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c0q, viewGroup, false);
        p.g(inflate, "LayoutInflater.from(pare…tor_image, parent, false)");
        C1773a aVar = new C1773a(this, inflate);
        AppMethodBeat.o(119715);
        return aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(C1773a aVar, int i2) {
        AppMethodBeat.i(119717);
        C1773a aVar2 = aVar;
        p.h(aVar2, "holder");
        aVar2.view.setSelected(i2 == this.va);
        if (e.Fln.fng()) {
            aVar2.view.setActivated(this.Fsh.get(i2).FoV.frF());
            AppMethodBeat.o(119717);
            return;
        }
        aVar2.view.setActivated(this.Fsh.get(i2).FoU.FnW);
        AppMethodBeat.o(119717);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119716);
        int size = this.Fsh.size();
        AppMethodBeat.o(119716);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;Landroid/view/View;)V", "view", "getView", "()Landroid/view/View;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.a$a  reason: collision with other inner class name */
    public final class C1773a extends RecyclerView.v {
        final /* synthetic */ a FxE;
        final View view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1773a(a aVar, View view2) {
            super(view2);
            p.h(view2, "itemView");
            this.FxE = aVar;
            AppMethodBeat.i(119714);
            View findViewById = view2.findViewById(R.id.i98);
            p.g(findViewById, "itemView.findViewById(R.…y_control_page_indicator)");
            this.view = findViewById;
            AppMethodBeat.o(119714);
        }
    }
}
