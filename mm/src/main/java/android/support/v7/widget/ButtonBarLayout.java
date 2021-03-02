package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.smtt.sdk.WebView;

public class ButtonBarLayout extends LinearLayout {
    private boolean alG;
    private int alH = -1;
    private int alI = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.ButtonBarLayout);
        this.alG = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    public void setAllowStacking(boolean z) {
        if (this.alG != z) {
            this.alG = z;
            if (!this.alG && getOrientation() == 1) {
                setStacked(false);
            }
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z;
        int i4;
        int i5;
        boolean z2;
        int size = View.MeasureSpec.getSize(i2);
        if (this.alG) {
            if (size > this.alH && jx()) {
                setStacked(false);
            }
            this.alH = size;
        }
        if (jx() || View.MeasureSpec.getMode(i2) != 1073741824) {
            z = false;
            i4 = i2;
        } else {
            i4 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z = true;
        }
        super.onMeasure(i4, i3);
        if (this.alG && !jx()) {
            if ((getMeasuredWidthAndState() & WebView.NIGHT_MODE_COLOR) == 16777216) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                setStacked(true);
                z = true;
            }
        }
        if (z) {
            super.onMeasure(i2, i3);
        }
        int bK = bK(0);
        if (bK >= 0) {
            View childAt = getChildAt(bK);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            i5 = layoutParams.bottomMargin + childAt.getMeasuredHeight() + getPaddingTop() + layoutParams.topMargin + 0;
            if (jx()) {
                int bK2 = bK(bK + 1);
                if (bK2 >= 0) {
                    i5 += getChildAt(bK2).getPaddingTop() + ((int) (16.0f * getResources().getDisplayMetrics().density));
                }
            } else {
                i5 += getPaddingBottom();
            }
        } else {
            i5 = 0;
        }
        if (u.ag(this) != i5) {
            setMinimumHeight(i5);
        }
    }

    private int bK(int i2) {
        int childCount = getChildCount();
        for (int i3 = i2; i3 < childCount; i3++) {
            if (getChildAt(i3).getVisibility() == 0) {
                return i3;
            }
        }
        return -1;
    }

    public int getMinimumHeight() {
        return Math.max(this.alI, super.getMinimumHeight());
    }

    private void setStacked(boolean z) {
        setOrientation(z ? 1 : 0);
        setGravity(z ? 5 : 80);
        View findViewById = findViewById(R.id.i3_);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 8 : 4);
        }
        for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
            bringChildToFront(getChildAt(childCount));
        }
    }

    private boolean jx() {
        return getOrientation() == 1;
    }
}
