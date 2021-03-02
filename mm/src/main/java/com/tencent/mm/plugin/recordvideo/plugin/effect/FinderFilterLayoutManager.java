package com.tencent.mm.plugin.recordvideo.plugin.effect;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScroller", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager$CenterSmoothScroller;", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "CenterSmoothScroller", "plugin-recordvideo_release"})
public final class FinderFilterLayoutManager extends LinearLayoutManager {
    private final a BTh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFilterLayoutManager(Context context) {
        super(0, false);
        p.h(context, "context");
        AppMethodBeat.i(237395);
        this.BTh = new a(this, context);
        AppMethodBeat.o(237395);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(237394);
        p.h(recyclerView, "recyclerView");
        this.BTh.ct(i2);
        startSmoothScroll(this.BTh);
        AppMethodBeat.o(237394);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-recordvideo_release"})
    public final class a extends ae {
        final /* synthetic */ FinderFilterLayoutManager BTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FinderFilterLayoutManager finderFilterLayoutManager, Context context) {
            super(context);
            p.h(context, "context");
            this.BTi = finderFilterLayoutManager;
            AppMethodBeat.i(237393);
            AppMethodBeat.o(237393);
        }

        @Override // android.support.v7.widget.ae
        public final int f(int i2, int i3, int i4, int i5, int i6) {
            return (((i5 - i4) / 2) + i4) - (((i3 - i2) / 2) + i2);
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(237392);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 100.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(237392);
            return f2;
        }
    }
}
