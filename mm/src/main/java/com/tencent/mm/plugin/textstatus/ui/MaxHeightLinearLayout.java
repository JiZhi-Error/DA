package com.tencent.mm.plugin.textstatus.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.textstatus.b;

public class MaxHeightLinearLayout extends LinearLayout {
    private int GcG;
    private int GcH = -1;

    public MaxHeightLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(216014);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, b.a.MaxHeightLinearLayout, 0, 0);
        try {
            this.GcG = obtainStyledAttributes.getInteger(0, -1);
            fwj();
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(216014);
        }
    }

    private void fwj() {
        AppMethodBeat.i(216015);
        if (this.GcG != -1) {
            this.GcH = a.fromDPToPix(getContext(), this.GcG);
            AppMethodBeat.o(216015);
            return;
        }
        this.GcH = -1;
        AppMethodBeat.o(216015);
    }

    public MaxHeightLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(216016);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(this.GcH, Integer.MIN_VALUE));
        AppMethodBeat.o(216016);
    }

    public void setMaxHeightDp(int i2) {
        AppMethodBeat.i(216017);
        this.GcG = i2;
        fwj();
        invalidate();
        AppMethodBeat.o(216017);
    }

    public void setMaxHeightPx(int i2) {
        AppMethodBeat.i(216018);
        this.GcH = i2;
        invalidate();
        AppMethodBeat.o(216018);
    }
}
