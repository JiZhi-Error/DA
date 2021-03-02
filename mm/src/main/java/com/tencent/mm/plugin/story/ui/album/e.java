package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
public abstract class e extends RecyclerView.l {
    public abstract void onLoadMore();

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        super.onScrolled(recyclerView, i2, i3);
        a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        p.h(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i2);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        if (i2 == 0 && linearLayoutManager.kv() == linearLayoutManager.getItemCount() - 1) {
            onLoadMore();
        }
        a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    }
}
