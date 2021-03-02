package com.tencent.mm.ui.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SquareImageView extends ImageView {
    public SquareImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(39196);
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i2);
        setMeasuredDimension(defaultSize, defaultSize);
        AppMethodBeat.o(39196);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(39197);
        super.onSizeChanged(i2, i2, i4, i5);
        AppMethodBeat.o(39197);
    }
}
