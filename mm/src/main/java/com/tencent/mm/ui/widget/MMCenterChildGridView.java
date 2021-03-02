package com.tencent.mm.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMCenterChildGridView extends GridView {
    public MMCenterChildGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMCenterChildGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(164208);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
        int size = View.MeasureSpec.getSize(i2);
        super.onMeasure(i2, makeMeasureSpec);
        int min = Math.min(getNumColumns(), getAdapter().getCount());
        int i4 = 0;
        if (min > 0) {
            i4 = (getColumnWidth() * min) + ((min - 1) * getHorizontalSpacing()) + getListPaddingLeft() + getListPaddingRight();
        }
        setPadding((size - i4) / 2, getPaddingTop(), (size - i4) / 2, getPaddingBottom());
        postInvalidate();
        AppMethodBeat.o(164208);
    }
}
