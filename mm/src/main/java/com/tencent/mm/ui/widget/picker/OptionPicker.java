package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.NumberPicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.at;

public class OptionPicker extends NumberPicker {
    private Context mContext;
    private int mMaxWidth;
    private int mMinWidth;
    private String[] ozA;
    private int ozB;

    public OptionPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(159581);
        this.mContext = context;
        init();
        AppMethodBeat.o(159581);
    }

    public OptionPicker(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(159582);
        this.mContext = context;
        init();
        AppMethodBeat.o(159582);
    }

    private void init() {
        AppMethodBeat.i(159583);
        this.mMinWidth = at.fromDPToPix(this.mContext, 120);
        this.ozB = at.fromDPToPix(this.mContext, 20);
        f.a(this, getResources().getDrawable(R.drawable.aod));
        setDescendantFocusability(393216);
        f.b(this, this.mContext.getResources().getColor(R.color.a2x));
        AppMethodBeat.o(159583);
    }

    public void setOptionsArray(String[] strArr) {
        AppMethodBeat.i(159584);
        if (strArr == null) {
            AppMethodBeat.o(159584);
            return;
        }
        this.ozA = strArr;
        setDisplayedValues(null);
        setMinValue(0);
        setMaxValue(Math.max(strArr.length - 1, 0));
        setWrapSelectorWheel(false);
        if (strArr.length <= 0) {
            strArr = null;
        }
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(159584);
    }

    public final void setExtraPadding(int i2) {
        AppMethodBeat.i(159586);
        this.ozB = Math.max(i2, 0);
        AppMethodBeat.o(159586);
    }

    public final void setMinWidth(int i2) {
        this.mMinWidth = i2;
    }

    public final void setMaxWidth(int i2) {
        this.mMaxWidth = i2;
    }

    @Deprecated
    public void setDisplayedValues(String[] strArr) {
        AppMethodBeat.i(159587);
        super.setDisplayedValues(strArr);
        AppMethodBeat.o(159587);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(159588);
        if (View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE || View.MeasureSpec.getMode(i2) == 1073741824) {
            this.mMaxWidth = View.MeasureSpec.getSize(i2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 0), i3);
        if (getMeasuredWidth() > this.mMinWidth || (this.mMaxWidth > 0 && this.mMinWidth > this.mMaxWidth)) {
            int measuredWidth = getMeasuredWidth() + (this.ozB * 2);
            if (this.mMaxWidth > 0 && this.mMaxWidth <= measuredWidth) {
                measuredWidth = this.mMaxWidth;
            }
            setMeasuredDimension(measuredWidth, getMeasuredHeight());
            AppMethodBeat.o(159588);
            return;
        }
        setMeasuredDimension(this.mMinWidth, getMeasuredHeight());
        AppMethodBeat.o(159588);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(159589);
        super.onAttachedToWindow();
        AppMethodBeat.o(159589);
    }
}
