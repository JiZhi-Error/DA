package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.as;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.story.ui.a.g;
import com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "plugin-story_release"})
public final class p extends RecyclerView.v {
    private final GalleryLayoutManager FFa;
    final g FIr;
    final GalleryHorizontalControlView FIs;
    final RecyclerView hak;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public p(View view, int i2, int i3) {
        super(view);
        kotlin.g.b.p.h(view, "itemView");
        AppMethodBeat.i(120669);
        View findViewById = view.findViewById(R.id.iaw);
        kotlin.g.b.p.g(findViewById, "itemView.findViewById(R.…lery_horizontal_recycler)");
        this.hak = (RecyclerView) findViewById;
        this.FIr = new g(i2, i3);
        Context context = view.getContext();
        kotlin.g.b.p.g(context, "itemView.context");
        this.FFa = new GalleryLayoutManager(context, 0, (byte) 0);
        View findViewById2 = view.findViewById(R.id.ib0);
        kotlin.g.b.p.g(findViewById2, "itemView.findViewById(R.…ory_gallery_page_control)");
        this.FIs = (GalleryHorizontalControlView) findViewById2;
        this.hak.setAdapter(this.FIr);
        this.hak.setLayoutManager(this.FFa);
        this.hak.setFocusable(false);
        this.hak.b(new b(0));
        RecyclerView.f itemAnimator = this.hak.getItemAnimator();
        as asVar = (as) (!(itemAnimator instanceof as) ? null : itemAnimator);
        if (asVar != null) {
            asVar.my();
        }
        this.hak.setItemViewCacheSize(0);
        AppMethodBeat.o(120669);
    }
}
