package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "(Landroid/support/v7/widget/LinearLayoutManager;)V", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "setLayoutManager", "getTotalPageCount", "", "isLastPage", "", "isLoading", "loadMoreItems", "", "onScrolled", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "dy", "plugin-multitalk_release"})
public abstract class c extends RecyclerView.l {
    private LinearLayoutManager vKp;

    public abstract void epH();

    public abstract boolean epI();

    public abstract boolean isLoading();

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
        super.onScrollStateChanged(recyclerView, i2);
        a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
    }

    public c(LinearLayoutManager linearLayoutManager) {
        this.vKp = linearLayoutManager;
    }

    @Override // android.support.v7.widget.RecyclerView.l
    public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        b bVar = new b();
        bVar.bm(recyclerView);
        bVar.pH(i2);
        bVar.pH(i3);
        a.b("com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
        p.h(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        LinearLayoutManager linearLayoutManager = this.vKp;
        if (linearLayoutManager == null) {
            p.hyc();
        }
        int childCount = linearLayoutManager.getChildCount();
        LinearLayoutManager linearLayoutManager2 = this.vKp;
        if (linearLayoutManager2 == null) {
            p.hyc();
        }
        int itemCount = linearLayoutManager2.getItemCount();
        LinearLayoutManager linearLayoutManager3 = this.vKp;
        if (linearLayoutManager3 == null) {
            p.hyc();
        }
        int ks = linearLayoutManager3.ks();
        if (!isLoading() && !epI() && childCount + ks >= itemCount && ks >= 0) {
            epH();
        }
        a.a(this, "com/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenProjectThumbScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
    }
}
