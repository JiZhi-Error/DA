package com.tencent.mm.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ListViewInScrollView extends ListView {
    public ListViewInScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListViewInScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141314);
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        AppMethodBeat.o(141314);
    }
}
