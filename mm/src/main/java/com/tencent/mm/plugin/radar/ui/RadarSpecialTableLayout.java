package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TableLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J.\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\tJ0\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "specialLayoutFlag", "", "layout", "", "l", "", "t", "r", "b", "flag", "onLayout", "changed", "plugin-radar_release"})
public final class RadarSpecialTableLayout extends TableLayout {
    private boolean BAh;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarSpecialTableLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(138661);
        AppMethodBeat.o(138661);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RadarSpecialTableLayout(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(138662);
        AppMethodBeat.o(138662);
    }

    public final void I(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(138659);
        this.BAh = true;
        super.layout(i2, i3, i4, i5);
        AppMethodBeat.o(138659);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i6;
        AppMethodBeat.i(138660);
        if (this.BAh || i3 >= 0) {
            z2 = false;
            i6 = 0;
        } else {
            i6 = i5 - i3;
            z2 = true;
        }
        this.BAh = false;
        if (!z2) {
            super.onLayout(z, i2, i3, i4, i5);
            AppMethodBeat.o(138660);
            return;
        }
        layout(i2, 0, i4, i6);
        AppMethodBeat.o(138660);
    }
}
