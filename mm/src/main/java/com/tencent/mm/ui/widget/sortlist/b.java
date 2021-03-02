package com.tencent.mm.ui.widget.sortlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b extends ViewGroup {
    private int Ku = 48;

    public b(Context context) {
        super(context);
        AppMethodBeat.i(159747);
        setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        AppMethodBeat.o(159747);
    }

    public int getGravity() {
        return this.Ku;
    }

    public void setGravity(int i2) {
        this.Ku = i2;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(159748);
        View childAt = getChildAt(0);
        if (childAt == null) {
            AppMethodBeat.o(159748);
        } else if (this.Ku == 48) {
            childAt.layout(0, 0, getMeasuredWidth(), childAt.getMeasuredHeight());
            AppMethodBeat.o(159748);
        } else {
            childAt.layout(0, getMeasuredHeight() - childAt.getMeasuredHeight(), getMeasuredWidth(), getMeasuredHeight());
            AppMethodBeat.o(159748);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(159749);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i3);
        View childAt = getChildAt(0);
        if (childAt == null) {
            setMeasuredDimension(0, size2);
            AppMethodBeat.o(159749);
            return;
        }
        if (childAt.isLayoutRequested()) {
            measureChild(childAt, i2, View.MeasureSpec.makeMeasureSpec(0, 0));
        }
        if (mode == 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams.height > 0) {
                size = layoutParams.height;
            } else {
                size = childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size2, size);
        AppMethodBeat.o(159749);
    }
}
