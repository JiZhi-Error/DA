package com.tencent.mm.plugin.editor.adapter;

import android.support.v7.widget.RecyclerView;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class a extends RecyclerView.l {
    private int qOk;

    public abstract void cCV();

    public abstract void cCW();

    public abstract void cCX();

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        super.onScrollStateChanged(recyclerView, i2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        if (Math.abs(i3) > this.qOk) {
            if (!recyclerView.canScrollVertically(-1)) {
                cCX();
            } else if (recyclerView.canScrollVertically(1)) {
                if (i3 < 0) {
                    cCV();
                } else if (i3 > 0) {
                    cCW();
                }
            }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/CollectEditorRecyclerViewAbstractScroller", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    }
}
