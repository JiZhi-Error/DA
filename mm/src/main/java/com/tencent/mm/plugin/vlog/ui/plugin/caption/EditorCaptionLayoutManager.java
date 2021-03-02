package com.tencent.mm.plugin.vlog.ui.plugin.caption;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "CenterSmoothScroller", "plugin-vlog_release"})
public final class EditorCaptionLayoutManager extends LinearLayoutManager {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorCaptionLayoutManager(Context context) {
        super(1, false);
        p.h(context, "context");
        AppMethodBeat.i(191611);
        AppMethodBeat.o(191611);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(191610);
        p.h(recyclerView, "recyclerView");
        Context context = recyclerView.getContext();
        p.g(context, "recyclerView.context");
        a aVar = new a(this, context);
        aVar.ct(i2);
        startSmoothScroll(aVar);
        AppMethodBeat.o(191610);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager$CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/caption/EditorCaptionLayoutManager;Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-vlog_release"})
    public final class a extends ae {
        final /* synthetic */ EditorCaptionLayoutManager GJY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(EditorCaptionLayoutManager editorCaptionLayoutManager, Context context) {
            super(context);
            p.h(context, "context");
            this.GJY = editorCaptionLayoutManager;
            AppMethodBeat.i(191609);
            AppMethodBeat.o(191609);
        }

        @Override // android.support.v7.widget.ae
        public final int f(int i2, int i3, int i4, int i5, int i6) {
            return (((i5 - i4) / 2) + i4) - (((i3 - i2) / 2) + i2);
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(191608);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 200.0f / ((float) displayMetrics.densityDpi);
            AppMethodBeat.o(191608);
            return f2;
        }
    }
}
