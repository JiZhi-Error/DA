package android.support.design.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout extends ViewGroup {
    private int baseline = -1;

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = -1;
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                int baseline2 = childAt.getBaseline();
                if (baseline2 != -1) {
                    i6 = Math.max(i6, baseline2);
                    i5 = Math.max(i5, childAt.getMeasuredHeight() - baseline2);
                }
                i8 = Math.max(i8, childAt.getMeasuredWidth());
                i7 = Math.max(i7, childAt.getMeasuredHeight());
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        if (i6 != -1) {
            i7 = Math.max(i7, Math.max(i5, getPaddingBottom()) + i6);
            this.baseline = i6;
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i8, getSuggestedMinimumWidth()), i2, i4), View.resolveSizeAndState(Math.max(i7, getSuggestedMinimumHeight()), i3, i4 << 16));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = ((i4 - i2) - getPaddingRight()) - paddingLeft;
        int paddingTop = getPaddingTop();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = paddingLeft + ((paddingRight - measuredWidth) / 2);
                if (this.baseline == -1 || childAt.getBaseline() == -1) {
                    i6 = paddingTop;
                } else {
                    i6 = (this.baseline + paddingTop) - childAt.getBaseline();
                }
                childAt.layout(i8, i6, measuredWidth + i8, measuredHeight + i6);
            }
        }
    }

    public int getBaseline() {
        return this.baseline;
    }
}
