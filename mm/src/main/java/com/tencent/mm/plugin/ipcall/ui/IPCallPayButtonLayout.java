package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCallPayButtonLayout extends RelativeLayout {
    public IPCallPayButtonLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public IPCallPayButtonLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(25856);
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec((int) (((double) getMeasuredWidth()) * 0.62d), 1073741824));
        AppMethodBeat.o(25856);
    }
}