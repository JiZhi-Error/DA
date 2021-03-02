package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\tH\u0002J\b\u0010\u0018\u001a\u00020\tH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0014J\u0006\u0010\"\u001a\u00020\u001aR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView;", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "mOldChildHeight", "", "mOldChildWidth", "mTable", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "getMTable", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "setMTable", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;)V", "onItemClickListener", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "getOnItemClickListener", "()Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "setOnItemClickListener", "(Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;)V", "computeScrollX", "computeScrollY", "initGridView", "", "onLayout", "changed", "", "l", "t", "r", "b", "reset", "OnItemClickListener", "plugin-radar_release"})
public final class RadarSpecialGridView extends RadarSpecialSmoothScrollView {
    private int BAa;
    private a BzX;
    public RadarSpecialTableLayout BzY;
    private int BzZ;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialGridView$OnItemClickListener;", "", "onItemClick", "", "position", "", "view", "Landroid/view/View;", "plugin-radar_release"})
    public interface a {
        void b(int i2, View view);
    }

    public final a getOnItemClickListener() {
        return this.BzX;
    }

    public final void setOnItemClickListener(a aVar) {
        this.BzX = aVar;
    }

    public final RadarSpecialTableLayout getMTable() {
        AppMethodBeat.i(138650);
        RadarSpecialTableLayout radarSpecialTableLayout = this.BzY;
        if (radarSpecialTableLayout == null) {
            p.btv("mTable");
        }
        AppMethodBeat.o(138650);
        return radarSpecialTableLayout;
    }

    public final void setMTable(RadarSpecialTableLayout radarSpecialTableLayout) {
        AppMethodBeat.i(138651);
        p.h(radarSpecialTableLayout, "<set-?>");
        this.BzY = radarSpecialTableLayout;
        AppMethodBeat.o(138651);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarSpecialGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138653);
        Context context2 = getContext();
        p.g(context2, "context");
        this.BzY = new RadarSpecialTableLayout(context2);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        RadarSpecialTableLayout radarSpecialTableLayout = this.BzY;
        if (radarSpecialTableLayout == null) {
            p.btv("mTable");
        }
        radarSpecialTableLayout.setLayoutParams(layoutParams);
        RadarSpecialTableLayout radarSpecialTableLayout2 = this.BzY;
        if (radarSpecialTableLayout2 == null) {
            p.btv("mTable");
        }
        radarSpecialTableLayout2.setStretchAllColumns(true);
        RadarSpecialTableLayout radarSpecialTableLayout3 = this.BzY;
        if (radarSpecialTableLayout3 == null) {
            p.btv("mTable");
        }
        radarSpecialTableLayout3.setShrinkAllColumns(true);
        RadarSpecialTableLayout radarSpecialTableLayout4 = this.BzY;
        if (radarSpecialTableLayout4 == null) {
            p.btv("mTable");
        }
        radarSpecialTableLayout4.setGravity(80);
        RadarSpecialTableLayout radarSpecialTableLayout5 = this.BzY;
        if (radarSpecialTableLayout5 == null) {
            p.btv("mTable");
        }
        addView(radarSpecialTableLayout5);
        AppMethodBeat.o(138653);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int scrollX;
        int i6 = 0;
        AppMethodBeat.i(138652);
        super.onLayout(z, i2, i3, i4, i5);
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int scrollX2 = getScrollX();
            p.g(childAt, "child");
            scrollX = (scrollX2 + childAt.getWidth()) - this.BAa;
            this.BAa = childAt.getWidth();
            if (scrollX <= 0) {
                scrollX = 0;
            }
        } else {
            scrollX = getScrollX();
        }
        if (getChildCount() > 0) {
            View childAt2 = getChildAt(0);
            int scrollY = getScrollY();
            p.g(childAt2, "child");
            int height = (scrollY + childAt2.getHeight()) - this.BzZ;
            this.BzZ = childAt2.getHeight();
            if (height > 0) {
                i6 = height;
            }
        } else {
            i6 = getScrollY();
        }
        scrollTo(scrollX, i6);
        AppMethodBeat.o(138652);
    }
}
