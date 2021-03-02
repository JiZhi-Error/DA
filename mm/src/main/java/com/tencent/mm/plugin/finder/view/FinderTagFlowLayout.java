package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinderTagFlowLayout extends ViewGroup {
    private int Ku;
    public List<List<View>> woZ;
    protected List<Integer> wpa;
    protected List<Integer> wpb;
    private List<View> wpc;

    public FinderTagFlowLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(168643);
        this.woZ = new ArrayList();
        this.wpa = new ArrayList();
        this.wpb = new ArrayList();
        this.wpc = new ArrayList();
        this.Ku = -1;
        AppMethodBeat.o(168643);
    }

    public FinderTagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int paddingLeft;
        int paddingTop;
        int measuredHeight;
        int i4;
        AppMethodBeat.i(168644);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i2, i3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                measuredHeight = marginLayoutParams.bottomMargin + childAt.getMeasuredHeight() + marginLayoutParams.topMargin;
                if (i7 + measuredWidth > (size - getPaddingLeft()) - getPaddingRight()) {
                    i5 = Math.max(i5, i7);
                    i6 += i8;
                    i4 = measuredWidth;
                } else {
                    measuredHeight = Math.max(i8, measuredHeight);
                    i4 = i7 + measuredWidth;
                }
                if (i9 == childCount - 1) {
                    i5 = Math.max(i4, i5);
                    i6 += measuredHeight;
                    i7 = i4;
                } else {
                    i7 = i4;
                }
            } else if (i9 == childCount - 1) {
                i5 = Math.max(i7, i5);
                i6 += i8;
                measuredHeight = i8;
            } else {
                measuredHeight = i8;
            }
            i9++;
            i8 = measuredHeight;
        }
        if (mode == 1073741824) {
            paddingLeft = size;
        } else {
            paddingLeft = getPaddingLeft() + i5 + getPaddingRight();
        }
        if (mode2 == 1073741824) {
            paddingTop = size2;
        } else {
            paddingTop = getPaddingTop() + i6 + getPaddingBottom();
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        AppMethodBeat.o(168644);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        AppMethodBeat.i(168645);
        this.woZ.clear();
        this.wpa.clear();
        this.wpb.clear();
        this.wpc.clear();
        int width = getWidth();
        int i7 = 0;
        int i8 = 0;
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                if (measuredWidth + i7 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin > (width - getPaddingLeft()) - getPaddingRight()) {
                    this.wpa.add(Integer.valueOf(i8));
                    this.woZ.add(this.wpc);
                    this.wpb.add(Integer.valueOf(i7));
                    i7 = 0;
                    i8 = marginLayoutParams.topMargin + measuredHeight + marginLayoutParams.bottomMargin;
                    this.wpc = new ArrayList();
                }
                i7 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i8 = Math.max(i8, marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight);
                this.wpc.add(childAt);
            }
        }
        this.wpa.add(Integer.valueOf(i8));
        this.wpb.add(Integer.valueOf(i7));
        this.woZ.add(this.wpc);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.woZ.size();
        int i10 = 0;
        int i11 = paddingTop;
        while (i10 < size) {
            this.wpc = this.woZ.get(i10);
            int intValue = this.wpa.get(i10).intValue();
            int intValue2 = this.wpb.get(i10).intValue();
            switch (this.Ku) {
                case -1:
                    paddingLeft = getPaddingLeft();
                    break;
                case 0:
                    paddingLeft = ((width - intValue2) / 2) + getPaddingLeft();
                    break;
                case 1:
                    paddingLeft = (width - (intValue2 + getPaddingLeft())) - getPaddingRight();
                    Collections.reverse(this.wpc);
                    break;
            }
            for (int i12 = 0; i12 < this.wpc.size(); i12++) {
                View view = this.wpc.get(i12);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i13 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i14 = marginLayoutParams2.topMargin + i11;
                    view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                    i6 = view.getMeasuredWidth() + marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin + paddingLeft;
                } else {
                    i6 = paddingLeft;
                }
                paddingLeft = i6;
            }
            i10++;
            i11 += intValue;
        }
        AppMethodBeat.o(168645);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(168646);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(168646);
        return marginLayoutParams;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(168647);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        AppMethodBeat.o(168647);
        return marginLayoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(168648);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(layoutParams);
        AppMethodBeat.o(168648);
        return marginLayoutParams;
    }
}
