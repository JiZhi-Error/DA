package com.tencent.mm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;

public class MaxHeightScrollView extends ScrollView {
    private int mMaxHeight;

    public MaxHeightScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(206171);
        init(context, attributeSet);
        AppMethodBeat.o(206171);
    }

    public MaxHeightScrollView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(206172);
        init(context, attributeSet);
        AppMethodBeat.o(206172);
    }

    private void init(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(206173);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.MaxHeightScrollView, 0, 0);
        try {
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == 0) {
                    setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(index, -1));
                }
            }
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(206173);
        }
    }

    public void setMaxHeight(int i2) {
        AppMethodBeat.i(206174);
        this.mMaxHeight = i2;
        requestLayout();
        AppMethodBeat.o(206174);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(206175);
        super.onMeasure(i2, i3);
        if (this.mMaxHeight > 0 && getMeasuredHeight() > this.mMaxHeight) {
            setMeasuredDimension(i2, View.MeasureSpec.makeMeasureSpec(this.mMaxHeight, Integer.MIN_VALUE));
        }
        AppMethodBeat.o(206175);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }
}
