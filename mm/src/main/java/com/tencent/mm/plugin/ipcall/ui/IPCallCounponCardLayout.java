package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCallCounponCardLayout extends RelativeLayout {
    public IPCallCounponCardLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public IPCallCounponCardLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(25713);
        setMeasuredDimension(getDefaultSize(0, i2), getDefaultSize(0, i3));
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() * 3) / 5, 1073741824));
        AppMethodBeat.o(25713);
    }
}
