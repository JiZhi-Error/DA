package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.a;
import java.util.LinkedList;

public class FlowLayout extends ViewGroup {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlowLayout.class.desiredAssertionStatus());
    private int OOj = 0;
    int OOk = 0;
    LinkedList<Integer> OOl = new LinkedList<>();

    static {
        AppMethodBeat.i(141639);
        AppMethodBeat.o(141639);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141630);
        d(context, attributeSet);
        AppMethodBeat.o(141630);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(141631);
        d(context, attributeSet);
        AppMethodBeat.o(141631);
    }

    private void d(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(141632);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.FlowLayout);
        try {
            this.OOj = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.OOk = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(141632);
        }
    }

    public int getLineCount() {
        AppMethodBeat.i(141633);
        int size = this.OOl.size();
        AppMethodBeat.o(141633);
        return size;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        int paddingTop;
        AppMethodBeat.i(141634);
        if ($assertionsDisabled || View.MeasureSpec.getMode(i2) != 0) {
            int size = (View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight();
            int size2 = (View.MeasureSpec.getSize(i3) - getPaddingTop()) - getPaddingBottom();
            int childCount = getChildCount();
            this.OOl.clear();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (i4 + measuredWidth > size) {
                        i4 = 0;
                        i5 += this.OOk + i6;
                        this.OOl.add(Integer.valueOf(i6));
                        i6 = 0;
                    }
                    i6 = Math.max(i6, childAt.getMeasuredHeight());
                    i4 += this.OOj + measuredWidth;
                }
            }
            this.OOl.add(Integer.valueOf(i6));
            if (View.MeasureSpec.getMode(i3) == 0) {
                paddingTop = i5 + i6 + getPaddingTop() + getPaddingBottom();
            } else {
                paddingTop = (View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE || i5 + i6 >= size2) ? size2 : i5 + i6 + getPaddingTop() + getPaddingBottom();
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i2), paddingTop);
            AppMethodBeat.o(141634);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(141634);
        throw assertionError;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        AppMethodBeat.i(141635);
        int childCount = getChildCount();
        int i7 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (paddingLeft + measuredWidth + getPaddingRight() > i7) {
                    i6 = getPaddingLeft();
                    paddingTop += this.OOl.get(i8).intValue() + this.OOk;
                    i8++;
                } else {
                    i6 = paddingLeft;
                }
                int intValue = (this.OOl.get(i8).intValue() - measuredHeight) / 2;
                childAt.layout(i6, paddingTop + intValue, i6 + measuredWidth, intValue + paddingTop + measuredHeight);
                paddingLeft = this.OOj + measuredWidth + i6;
            }
        }
        AppMethodBeat.o(141635);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.LayoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(141636);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -2);
        AppMethodBeat.o(141636);
        return layoutParams;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(141637);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(141637);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(141638);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height);
        AppMethodBeat.o(141638);
        return layoutParams2;
    }
}
