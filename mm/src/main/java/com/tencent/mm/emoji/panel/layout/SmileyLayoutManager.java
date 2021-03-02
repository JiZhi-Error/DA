package com.tencent.mm.emoji.panel.layout;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J(\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\nH\u0002J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\bR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/emoji/panel/layout/SmileyLayoutManager;", "Landroid/support/v7/widget/GridLayoutManager;", "context", "Landroid/content/Context;", "spanCount", "", "(Landroid/content/Context;I)V", "hideRect", "Landroid/graphics/Rect;", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollVerticallyBy", "dy", "updateChildren", "updateHideArea", "rect", "plugin-emojisdk_release"})
public final class SmileyLayoutManager extends GridLayoutManager {
    public final Rect hao = new Rect();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmileyLayoutManager(Context context, int i2) {
        super(i2);
        p.h(context, "context");
        AppMethodBeat.i(105722);
        AppMethodBeat.o(105722);
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(105718);
        super.onLayoutChildren(nVar, sVar);
        avX();
        AppMethodBeat.o(105718);
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(105719);
        int scrollHorizontallyBy = super.scrollHorizontallyBy(i2, nVar, sVar);
        avX();
        AppMethodBeat.o(105719);
        return scrollHorizontallyBy;
    }

    @Override // android.support.v7.widget.GridLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(105720);
        int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
        avX();
        AppMethodBeat.o(105720);
        return scrollVerticallyBy;
    }

    public final void avX() {
        boolean z;
        AppMethodBeat.i(105721);
        if (this.hao.isEmpty()) {
            AppMethodBeat.o(105721);
            return;
        }
        Rect rect = new Rect();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                p.g(childAt, "getChildAt(i) ?: continue");
                if (getItemViewType(childAt) != 1) {
                    childAt.setAlpha(1.0f);
                    z = true;
                } else {
                    getDecoratedBoundsWithMargins(childAt, rect);
                    int decoratedRight = getDecoratedRight(childAt);
                    int decoratedBottom = getDecoratedBottom(childAt);
                    float decoratedTop = (decoratedRight <= this.hao.left || decoratedBottom <= this.hao.top) ? 1.0f : 1.0f - (((float) (decoratedBottom - this.hao.top)) / (((float) (decoratedBottom - getDecoratedTop(childAt))) * 0.4f));
                    childAt.setAlpha(decoratedTop);
                    z = ((double) decoratedTop) > 0.7d;
                }
                childAt.setEnabled(z);
            }
        }
        AppMethodBeat.o(105721);
    }
}
