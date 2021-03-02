package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.CustomViewPager;

public class IPCallShareViewPager extends CustomViewPager {
    public IPCallShareViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.tencent.mm.ui.mogic.WxViewPager
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(25980);
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
        AppMethodBeat.o(25980);
    }
}
