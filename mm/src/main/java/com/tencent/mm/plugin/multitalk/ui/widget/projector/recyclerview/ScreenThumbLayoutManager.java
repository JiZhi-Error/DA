package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007J\u001c\u0010\u0013\u001a\u00020\u00122\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\n\u0010\u0014\u001a\u00060\u0015R\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J \u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "mRecycleView", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/support/v7/widget/RecyclerView;Landroid/content/Context;I)V", "TAG", "", "contentWidth", "itemWidth", "getMRecycleView", "()Landroid/support/v7/widget/RecyclerView;", "setMRecycleView", "(Landroid/support/v7/widget/RecyclerView;)V", "applyWidthSize", "", "onLayoutChildren", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "smoothScrollToPosition", "recyclerView", "updateChildWithIndex", FirebaseAnalytics.b.INDEX, "plugin-multitalk_release"})
public final class ScreenThumbLayoutManager extends LinearLayoutManager {
    private final String TAG = "MicroMsg.ScreenThumbLayoutManager";
    public int qmd;
    private RecyclerView xAX;
    public int zYO;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenThumbLayoutManager(RecyclerView recyclerView, Context context) {
        super(0, false);
        p.h(context, "context");
        AppMethodBeat.i(240087);
        this.xAX = recyclerView;
        AppMethodBeat.o(240087);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(240083);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        super.onLayoutChildren(nVar, sVar);
        AppMethodBeat.o(240083);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(240084);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        AppMethodBeat.o(240084);
        return scrollHorizontallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(240085);
        p.h(recyclerView, "recyclerView");
        p.h(sVar, "state");
        if (i2 == -1) {
            AppMethodBeat.o(240085);
            return;
        }
        Context context = recyclerView.getContext();
        p.g(context, "recyclerView.context");
        a aVar = new a(context);
        aVar.ct(i2);
        startSmoothScroll(aVar);
        AppMethodBeat.o(240085);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(240086);
        ah(i2, (this.zYO - this.qmd) / 2);
        AppMethodBeat.o(240086);
    }
}
