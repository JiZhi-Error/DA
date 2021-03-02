package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 +2\u00020\u0001:\u0001+B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\bH\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J \u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J(\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0006H\u0016J(\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\f\u0010\u001a\u001a\b\u0018\u00010\u001bR\u00020\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u000e\u0010&\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\bJ$\u0010)\u001a\u00020\u00192\b\u0010*\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010!\u001a\u00020\u0006H\u0016R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006,"}, hxF = {"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "canScrollHorizontal", "getCanScrollHorizontal", "()Z", "setCanScrollHorizontal", "(Z)V", "extraLayoutSpace", "scrollState", "scroller", "Landroid/support/v7/widget/LinearSmoothScroller;", "canScrollHorizontally", "canScrollVertically", "getExtraLayoutSpace", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "onScrollStateChanged", "scrollHorizontallyBy", "dx", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "setExtraLayoutSpace", "setScrollVerticallyEnable", "enable", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-wxpay_release"})
public final class HorizontalLayoutManager extends LinearLayoutManager {
    public static final a zbr = new a((byte) 0);
    public int qOi;
    private int vp;
    private boolean zbq = true;

    static {
        AppMethodBeat.i(163899);
        AppMethodBeat.o(163899);
    }

    public HorizontalLayoutManager() {
        AppMethodBeat.i(163898);
        setOrientation(0);
        setItemPrefetchEnabled(true);
        ca(4);
        AppMethodBeat.o(163898);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/luckymoney/ui/HorizontalLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(163890);
        super.scrollToPosition(i2);
        AppMethodBeat.o(163890);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void ah(int i2, int i3) {
        AppMethodBeat.i(163891);
        super.ah(i2, i3);
        AppMethodBeat.o(163891);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(163892);
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        AppMethodBeat.o(163892);
        return scrollHorizontallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(163893);
        super.onLayoutChildren(nVar, sVar);
        AppMethodBeat.o(163893);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onScrollStateChanged(int i2) {
        AppMethodBeat.i(163894);
        super.onScrollStateChanged(i2);
        this.vp = i2;
        AppMethodBeat.o(163894);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(163895);
        int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
        AppMethodBeat.o(163895);
        return scrollVerticallyBy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollVertically() {
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        AppMethodBeat.i(163896);
        if (this.zbq) {
            AppMethodBeat.o(163896);
            return true;
        }
        boolean canScrollHorizontally = super.canScrollHorizontally();
        AppMethodBeat.o(163896);
        return canScrollHorizontally;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final int b(RecyclerView.s sVar) {
        AppMethodBeat.i(163897);
        p.h(sVar, "state");
        if (this.qOi > 0) {
            int i2 = this.qOi;
            AppMethodBeat.o(163897);
            return i2;
        }
        int b2 = super.b(sVar);
        AppMethodBeat.o(163897);
        return b2;
    }
}
