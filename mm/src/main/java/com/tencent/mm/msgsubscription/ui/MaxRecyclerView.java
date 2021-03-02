package com.tencent.mm.msgsubscription.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaxRecyclerView extends RecyclerView {
    public MaxRecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public MaxRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(151163);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        AppMethodBeat.o(151163);
    }
}
