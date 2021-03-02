package com.tencent.mm.ui.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ae.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public class MMSingelLinePanel extends MMTagPanel {
    static final /* synthetic */ boolean $assertionsDisabled = (!MMSingelLinePanel.class.desiredAssertionStatus());
    private int OOj;
    private int OOk;
    private LinkedList<Integer> OOl;
    private boolean OSP;
    private TextView OSQ;
    private int OSR;
    private int OSS;

    static {
        AppMethodBeat.i(142126);
        AppMethodBeat.o(142126);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMSingelLinePanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142121);
        this.OOl = new LinkedList<>();
        this.OOj = 0;
        this.OOk = 0;
        this.OSP = true;
        this.OSR = 0;
        this.OSS = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0244a.FlowLayout);
        try {
            this.OOj = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.OOk = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        } finally {
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(142121);
        }
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel
    public final void gKV() {
        AppMethodBeat.i(142122);
        super.gKV();
        this.OSQ = new TextView(getContext());
        this.OSQ.setText("...");
        this.OSQ.setTextColor(getResources().getColor(R.color.afp));
        this.OSQ.setLayoutParams(generateDefaultLayoutParams());
        addView(this.OSQ);
        AppMethodBeat.o(142122);
    }

    public void setSingleLine(boolean z) {
        AppMethodBeat.i(142123);
        this.OSP = z;
        this.OSQ = new TextView(getContext());
        this.OSQ.setText("...");
        this.OSQ.setLayoutParams(generateDefaultLayoutParams());
        addView(this.OSQ);
        AppMethodBeat.o(142123);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.FlowLayout
    public void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        AppMethodBeat.i(142124);
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
            if (this.OSP && this.OSQ != null) {
                this.OSQ.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                this.OSR = this.OSQ.getMeasuredWidth();
                this.OSS = this.OSQ.getMeasuredHeight();
                Log.d("MicroMsg.MMTagContactPanel", "mEllipsisWidth %d", Integer.valueOf(this.OSR));
            }
            if (this.OSP) {
                size -= this.OSR;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i7 = childAt.getMeasuredHeight();
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
            if (this.OSP) {
                getPaddingTop();
                getPaddingBottom();
            } else if (View.MeasureSpec.getMode(i3) == 0) {
                getPaddingTop();
                getPaddingBottom();
            } else if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && i5 + i6 < size2) {
                getPaddingTop();
                getPaddingBottom();
            }
            setMeasuredDimension(View.MeasureSpec.getSize(i2), i7);
            AppMethodBeat.o(142124);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(142124);
        throw assertionError;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.base.FlowLayout
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        AppMethodBeat.i(142125);
        if (this.OSP) {
            int childCount = getChildCount();
            int i9 = (i4 - i2) - this.OSR;
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i13 < childCount) {
                View childAt = getChildAt(i13);
                if (childAt.getVisibility() == 8 || childAt == this.OSQ) {
                    i7 = i12;
                    i8 = paddingTop;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (paddingLeft + measuredWidth + getPaddingRight() > i9) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += this.OOl.get(i12).intValue() + this.OOk;
                        i7 = i12 + 1;
                    } else {
                        i7 = i12;
                    }
                    if (i7 <= 0) {
                        childAt.layout(paddingLeft, paddingTop + 0, paddingLeft + measuredWidth, paddingTop + 0 + measuredHeight);
                        int i14 = this.OOj + measuredWidth + paddingLeft;
                        i11 = paddingTop;
                        i10 = i14;
                        i8 = paddingTop;
                        paddingLeft = i14;
                    } else {
                        i8 = paddingTop;
                    }
                }
                i13++;
                i12 = i7;
                paddingTop = i8;
            }
            if (this.OSQ != null) {
                if (i12 > 0) {
                    this.OSQ.layout(i10, i11, this.OSR + i10, this.OSS + i11);
                    AppMethodBeat.o(142125);
                    return;
                }
                this.OSQ.layout(0, 0, 0, 0);
            }
            AppMethodBeat.o(142125);
            return;
        }
        int childCount2 = getChildCount();
        int i15 = i4 - i2;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop2 = getPaddingTop();
        int i16 = 0;
        for (int i17 = 0; i17 < childCount2; i17++) {
            View childAt2 = getChildAt(i17);
            if (!(childAt2.getVisibility() == 8 || childAt2 == this.OSQ)) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                if (paddingLeft2 + measuredWidth2 + getPaddingRight() > i15) {
                    i6 = getPaddingLeft();
                    paddingTop2 += this.OOl.get(i16).intValue() + this.OOk;
                    i16++;
                } else {
                    i6 = paddingLeft2;
                }
                int intValue = (this.OOl.get(i16).intValue() - measuredHeight2) / 2;
                childAt2.layout(i6, paddingTop2 + intValue, i6 + measuredWidth2, intValue + paddingTop2 + measuredHeight2);
                paddingLeft2 = this.OOj + measuredWidth2 + i6;
            }
        }
        AppMethodBeat.o(142125);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.tencent.mm.ui.base.MMTagPanel
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
