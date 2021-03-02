package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaxHeightRecyclerView extends RecyclerView {
    private int mMaxHeight;

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(147710);
        this.mMaxHeight = i2;
        invalidate();
        requestLayout();
        AppMethodBeat.o(147710);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(147711);
        if (this.mMaxHeight > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(147711);
    }
}
