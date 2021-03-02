package com.tencent.mm.plugin.mv.ui.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J(\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0002R\u000e\u0010\t\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "alphaStartOffset", "onLayoutCompleted", "", "state", "Landroid/support/v7/widget/RecyclerView$State;", "scrollVerticallyBy", "dy", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "smoothScrollToPosition", "recyclerView", "position", "updateChild", "plugin-mv_release"})
public final class MusicLyricLayoutManager extends LinearLayoutManager {
    private final int ArH;

    public /* synthetic */ MusicLyricLayoutManager(Context context, byte b2) {
        this(context);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private MusicLyricLayoutManager(Context context) {
        super(1, false);
        p.h(context, "context");
        AppMethodBeat.i(256970);
        this.ArH = com.tencent.mm.cb.a.fromDPToPix(context, 0);
        AppMethodBeat.o(256970);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void onLayoutCompleted(RecyclerView.s sVar) {
        AppMethodBeat.i(256966);
        super.onLayoutCompleted(sVar);
        cKb();
        AppMethodBeat.o(256966);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(256967);
        int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
        cKb();
        AppMethodBeat.o(256967);
        return scrollVerticallyBy;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/adapter/MusicLyricLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-mv_release"})
    public static final class a extends ae {
        final /* synthetic */ RecyclerView tDJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(RecyclerView recyclerView, Context context) {
            super(context);
            this.tDJ = recyclerView;
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(256965);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 600.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(256965);
            return f2;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(256968);
        p.h(recyclerView, "recyclerView");
        a aVar = new a(recyclerView, recyclerView.getContext());
        aVar.ct(i2);
        startSmoothScroll(aVar);
        AppMethodBeat.o(256968);
    }

    private final void cKb() {
        AppMethodBeat.i(256969);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                p.g(childAt, "getChildAt(i) ?: continue");
                int top = (childAt.getTop() + childAt.getBottom()) / 2;
                int height = getHeight() / 2;
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredHeight - Math.abs(top - height) > this.ArH) {
                    childAt.setAlpha(Math.min(1.0f - (((float) Math.abs(top - height)) / ((float) (measuredHeight - this.ArH))), 1.0f));
                } else {
                    childAt.setAlpha(0.0f);
                }
            }
        }
        AppMethodBeat.o(256969);
    }
}
