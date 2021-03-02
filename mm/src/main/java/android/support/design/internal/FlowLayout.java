package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a;
import android.support.v4.view.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class FlowLayout extends ViewGroup {
    private int kI;
    private int kJ;
    private boolean kK;

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.kK = false;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.C0008a.FlowLayout, 0, 0);
        this.kI = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.kJ = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public int getLineSpacing() {
        return this.kI;
    }

    /* access modifiers changed from: protected */
    public void setLineSpacing(int i2) {
        this.kI = i2;
    }

    /* access modifiers changed from: protected */
    public int getItemSpacing() {
        return this.kJ;
    }

    /* access modifiers changed from: protected */
    public void setItemSpacing(int i2) {
        this.kJ = i2;
    }

    public void setSingleLine(boolean z) {
        this.kK = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int paddingRight = i5 - getPaddingRight();
        int i7 = 0;
        int i8 = paddingTop;
        while (true) {
            int i9 = paddingTop;
            if (i7 < getChildCount()) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    measureChild(childAt, i2, i3);
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int i10 = 0;
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        i4 = marginLayoutParams.rightMargin + 0;
                        i10 = marginLayoutParams.leftMargin + 0;
                    } else {
                        i4 = 0;
                    }
                    if (paddingLeft + i10 + childAt.getMeasuredWidth() > paddingRight && !this.kK) {
                        paddingLeft = getPaddingLeft();
                        i9 = i8 + this.kI;
                    }
                    int measuredWidth = paddingLeft + i10 + childAt.getMeasuredWidth();
                    int measuredHeight = i9 + childAt.getMeasuredHeight();
                    if (measuredWidth > i6) {
                        i6 = measuredWidth;
                    }
                    paddingLeft += i4 + i10 + childAt.getMeasuredWidth() + this.kJ;
                    i8 = measuredHeight;
                }
                paddingTop = i9;
                i7++;
            } else {
                setMeasuredDimension(d(size, mode, i6), d(size2, mode2, i8));
                return;
            }
        }
    }

    private static int d(int i2, int i3, int i4) {
        switch (i3) {
            case Integer.MIN_VALUE:
                return Math.min(i4, i2);
            case 1073741824:
                return i2;
            default:
                return i4;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        if (getChildCount() != 0) {
            boolean z2 = u.Z(this) == 1;
            int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
            int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
            int paddingTop = getPaddingTop();
            int i7 = (i4 - i2) - paddingLeft;
            int i8 = paddingTop;
            int i9 = paddingTop;
            int i10 = paddingRight;
            int i11 = 0;
            while (i11 < getChildCount()) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8) {
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    int i12 = 0;
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        int a2 = g.a(marginLayoutParams);
                        i6 = g.b(marginLayoutParams);
                        i12 = a2;
                    } else {
                        i6 = 0;
                    }
                    int measuredWidth = i10 + i12 + childAt.getMeasuredWidth();
                    if (!this.kK && measuredWidth > i7) {
                        i9 = i8 + this.kI;
                        i10 = paddingRight;
                    }
                    int measuredWidth2 = childAt.getMeasuredWidth() + i10 + i12;
                    i8 = childAt.getMeasuredHeight() + i9;
                    if (z2) {
                        childAt.layout(i7 - measuredWidth2, i9, (i7 - i10) - i12, i8);
                    } else {
                        childAt.layout(i10 + i12, i9, measuredWidth2, i8);
                    }
                    i10 += i6 + i12 + childAt.getMeasuredWidth() + this.kJ;
                }
                i11++;
                i8 = i8;
                i9 = i9;
            }
        }
    }
}
