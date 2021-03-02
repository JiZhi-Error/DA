package com.tencent.mm.plugin.story.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0018\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0002H\u0016J\u0014\u0010&\u001a\u00020\u00182\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0(R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011RL\u0010\u0012\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\f¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "width", "", "height", "(II)V", "flipItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "getHeight", "()I", "isActive", "", "()Z", "setActive", "(Z)V", "onItemLongClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getWidth", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "plugin-story_release"})
public final class g extends RecyclerView.a<i> {
    private final ArrayList<h> Fye = new ArrayList<>();
    private final int height;
    public boolean isActive;
    private final int width;

    public g(int i2, int i3) {
        AppMethodBeat.i(119771);
        this.width = i2;
        this.height = i3;
        AppMethodBeat.o(119771);
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ i a(ViewGroup viewGroup, int i2) {
        AppMethodBeat.i(119768);
        p.h(viewGroup, "parent");
        Log.i(h.TAG, "onCreateViewHolder ".concat(String.valueOf(this)));
        Context context = viewGroup.getContext();
        p.g(context, "parent.context");
        StoryGalleryItemView storyGalleryItemView = new StoryGalleryItemView(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        layoutParams.width = this.width;
        layoutParams.height = this.height;
        storyGalleryItemView.setLayoutParams(layoutParams);
        i iVar = new i(storyGalleryItemView);
        AppMethodBeat.o(119768);
        return iVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0303  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x040d  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0370 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x01cf A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01fe  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02a9  */
    @Override // android.support.v7.widget.RecyclerView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.plugin.story.ui.a.i r11, int r12) {
        /*
        // Method dump skipped, instructions count: 1054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.a.g.a(android.support.v7.widget.RecyclerView$v, int):void");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void k(i iVar) {
        AppMethodBeat.i(119770);
        i iVar2 = iVar;
        p.h(iVar2, "holder");
        Log.i(h.TAG, "onViewAttachedToWindow ".concat(String.valueOf(this)));
        super.k(iVar2);
        iVar2.frU();
        AppMethodBeat.o(119770);
    }

    public final void hw(List<h> list) {
        AppMethodBeat.i(119766);
        p.h(list, "items");
        this.Fye.clear();
        this.Fye.addAll(list);
        AppMethodBeat.o(119766);
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        AppMethodBeat.i(119767);
        int size = this.Fye.size();
        AppMethodBeat.o(119767);
        return size;
    }
}
