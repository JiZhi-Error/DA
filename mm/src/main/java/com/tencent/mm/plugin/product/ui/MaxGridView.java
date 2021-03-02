package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaxGridView extends GridView {
    public MaxGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(67081);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        AppMethodBeat.o(67081);
    }
}
