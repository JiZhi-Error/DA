package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InScrollGridView extends GridView {
    public InScrollGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InScrollGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(39071);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        AppMethodBeat.o(39071);
    }
}