package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class d extends RecyclerView.l {
    public abstract void onLoadMore();

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        super.onScrollStateChanged(recyclerView, i2);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (i2 == 0 && linearLayoutManager.kv() == linearLayoutManager.getItemCount() - 1) {
            onLoadMore();
        }
        a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        super.onScrolled(recyclerView, i2, i3);
        a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    }
}
