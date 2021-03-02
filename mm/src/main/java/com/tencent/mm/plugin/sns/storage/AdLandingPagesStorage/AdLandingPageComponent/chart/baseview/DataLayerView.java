package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

public abstract class DataLayerView extends View {
    /* access modifiers changed from: protected */
    public abstract int fcO();

    /* access modifiers changed from: protected */
    public abstract int fcP();

    public DataLayerView(Context context) {
        super(context);
    }

    public DataLayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DataLayerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View.MeasureSpec.getMode(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                size = getSuggestedMinimumWidth();
                break;
            case 0:
                size = fcP();
                break;
        }
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        switch (mode2) {
            case Integer.MIN_VALUE:
                size2 = getSuggestedMinimumHeight();
                break;
            case 0:
                size2 = fcO();
                break;
        }
        setMeasuredDimension(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }
}
