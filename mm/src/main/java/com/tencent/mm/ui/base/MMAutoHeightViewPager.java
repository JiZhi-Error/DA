package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMAutoHeightViewPager extends ViewPager {
    private static final String TAG = "MicoMsg.MMAutoHeightViewPager";

    public MMAutoHeightViewPager(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
    }

    public MMAutoHeightViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMAutoHeightViewPager(Context context) {
        super(context);
    }

    @Override // android.support.v4.view.ViewPager
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141848);
        int i4 = 0;
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            childAt.measure(i2, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            if (measuredHeight > i4) {
                i4 = measuredHeight;
            }
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4, 1073741824));
        AppMethodBeat.o(141848);
    }
}
