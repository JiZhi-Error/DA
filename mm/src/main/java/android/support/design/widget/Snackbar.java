package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.BaseTransientBottomBar;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.R;

public final class Snackbar extends BaseTransientBottomBar<Snackbar> {
    private static final int[] tE = {R.attr.zi};

    public static final class SnackbarLayout extends BaseTransientBottomBar.d {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public final void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }
    }
}
