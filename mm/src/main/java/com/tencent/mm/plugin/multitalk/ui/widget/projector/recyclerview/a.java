package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/CenterSmoothScroller;", "Landroid/support/v7/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDxToMakeVisible", "", "view", "Landroid/view/View;", "snapPreference", "calculateDyToMakeVisible", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-multitalk_release"})
public final class a extends ae {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(240071);
        AppMethodBeat.o(240071);
    }

    @Override // android.support.v7.widget.ae
    public final int F(View view, int i2) {
        AppMethodBeat.i(240068);
        p.h(view, "view");
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            AppMethodBeat.o(240068);
            return 0;
        }
        int width = (layoutManager.getWidth() / 2) - ((view.getLeft() + view.getRight()) / 2);
        AppMethodBeat.o(240068);
        return width;
    }

    @Override // android.support.v7.widget.ae
    public final int E(View view, int i2) {
        AppMethodBeat.i(240069);
        p.h(view, "view");
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            AppMethodBeat.o(240069);
            return 0;
        }
        int height = (layoutManager.getHeight() / 2) - ((view.getTop() + view.getBottom()) / 2);
        AppMethodBeat.o(240069);
        return height;
    }

    @Override // android.support.v7.widget.ae
    public final float a(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(240070);
        p.h(displayMetrics, "displayMetrics");
        float f2 = 50.0f / ((float) displayMetrics.densityDpi);
        AppMethodBeat.o(240070);
        return f2;
    }
}
