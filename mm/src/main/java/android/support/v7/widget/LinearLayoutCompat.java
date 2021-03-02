package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.d;
import android.support.v4.view.u;
import android.support.v7.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tav.core.ExportErrorStatus;

public class LinearLayoutCompat extends ViewGroup {
    private int Ku;
    private Drawable amP;
    private boolean aqf;
    private int aqg;
    private int aqh;
    private int aqi;
    private float aqj;
    private boolean aqk;
    private int[] aql;
    private int[] aqm;
    private int aqn;
    private int aqo;
    private int aqp;
    private int aqq;
    private int mOrientation;

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.aqf = true;
        this.aqg = -1;
        this.aqh = 0;
        this.Ku = 8388659;
        az a2 = az.a(context, attributeSet, a.C0040a.LinearLayoutCompat, i2, 0);
        int i3 = a2.getInt(1, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = a2.getInt(0, -1);
        if (i4 >= 0) {
            setGravity(i4);
        }
        boolean z = a2.getBoolean(2, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.aqj = a2.getFloat(4, -1.0f);
        this.aqg = a2.getInt(3, -1);
        this.aqk = a2.getBoolean(7, false);
        setDividerDrawable(a2.getDrawable(5));
        this.aqp = a2.getInt(8, 0);
        this.aqq = a2.getDimensionPixelSize(6, 0);
        a2.ayy.recycle();
    }

    public void setShowDividers(int i2) {
        if (i2 != this.aqp) {
            requestLayout();
        }
        this.aqp = i2;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.aqp;
    }

    public Drawable getDividerDrawable() {
        return this.amP;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.amP) {
            this.amP = drawable;
            if (drawable != null) {
                this.aqn = drawable.getIntrinsicWidth();
                this.aqo = drawable.getIntrinsicHeight();
            } else {
                this.aqn = 0;
                this.aqo = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i2) {
        this.aqq = i2;
    }

    public int getDividerPadding() {
        return this.aqq;
    }

    public int getDividerWidth() {
        return this.aqn;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int right;
        int left;
        int bottom;
        if (this.amP != null) {
            if (this.mOrientation == 1) {
                int virtualChildCount = getVirtualChildCount();
                for (int i2 = 0; i2 < virtualChildCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (!(childAt == null || childAt.getVisibility() == 8 || !bY(i2))) {
                        a(canvas, (childAt.getTop() - ((LayoutParams) childAt.getLayoutParams()).topMargin) - this.aqo);
                    }
                }
                if (bY(virtualChildCount)) {
                    View childAt2 = getChildAt(virtualChildCount - 1);
                    if (childAt2 == null) {
                        bottom = (getHeight() - getPaddingBottom()) - this.aqo;
                    } else {
                        bottom = ((LayoutParams) childAt2.getLayoutParams()).bottomMargin + childAt2.getBottom();
                    }
                    a(canvas, bottom);
                    return;
                }
                return;
            }
            int virtualChildCount2 = getVirtualChildCount();
            boolean d2 = bh.d(this);
            for (int i3 = 0; i3 < virtualChildCount2; i3++) {
                View childAt3 = getChildAt(i3);
                if (!(childAt3 == null || childAt3.getVisibility() == 8 || !bY(i3))) {
                    LayoutParams layoutParams = (LayoutParams) childAt3.getLayoutParams();
                    if (d2) {
                        left = layoutParams.rightMargin + childAt3.getRight();
                    } else {
                        left = (childAt3.getLeft() - layoutParams.leftMargin) - this.aqn;
                    }
                    b(canvas, left);
                }
            }
            if (bY(virtualChildCount2)) {
                View childAt4 = getChildAt(virtualChildCount2 - 1);
                if (childAt4 != null) {
                    LayoutParams layoutParams2 = (LayoutParams) childAt4.getLayoutParams();
                    if (d2) {
                        right = (childAt4.getLeft() - layoutParams2.leftMargin) - this.aqn;
                    } else {
                        right = layoutParams2.rightMargin + childAt4.getRight();
                    }
                } else if (d2) {
                    right = getPaddingLeft();
                } else {
                    right = (getWidth() - getPaddingRight()) - this.aqn;
                }
                b(canvas, right);
            }
        }
    }

    private void a(Canvas canvas, int i2) {
        this.amP.setBounds(getPaddingLeft() + this.aqq, i2, (getWidth() - getPaddingRight()) - this.aqq, this.aqo + i2);
        this.amP.draw(canvas);
    }

    private void b(Canvas canvas, int i2) {
        this.amP.setBounds(i2, getPaddingTop() + this.aqq, this.aqn + i2, (getHeight() - getPaddingBottom()) - this.aqq);
        this.amP.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.aqf = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.aqk = z;
    }

    public int getBaseline() {
        int i2;
        int i3;
        if (this.aqg < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.aqg) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.aqg);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i4 = this.aqh;
            if (this.mOrientation == 1 && (i3 = this.Ku & 112) != 48) {
                switch (i3) {
                    case 16:
                        i2 = i4 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.aqi) / 2);
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        i2 = ((getBottom() - getTop()) - getPaddingBottom()) - this.aqi;
                        break;
                }
                return ((LayoutParams) childAt.getLayoutParams()).topMargin + i2 + baseline;
            }
            i2 = i4;
            return ((LayoutParams) childAt.getLayoutParams()).topMargin + i2 + baseline;
        } else if (this.aqg == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.aqg;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 < 0 || i2 >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.aqg = i2;
    }

    /* access modifiers changed from: package-private */
    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.aqj;
    }

    public void setWeightSum(float f2) {
        this.aqj = Math.max(0.0f, f2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        float f2;
        boolean z;
        int i6;
        int i7;
        View view;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        boolean z4;
        int i10;
        int i11;
        int i12;
        int i13;
        if (this.mOrientation == 1) {
            this.aqi = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            boolean z5 = true;
            float f3 = 0.0f;
            int virtualChildCount = getVirtualChildCount();
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            boolean z6 = false;
            boolean z7 = false;
            int i18 = this.aqg;
            boolean z8 = this.aqk;
            int i19 = 0;
            int i20 = 0;
            while (i20 < virtualChildCount) {
                View childAt = getChildAt(i20);
                if (childAt == null) {
                    this.aqi += 0;
                    i11 = i20;
                } else {
                    if (childAt.getVisibility() != 8) {
                        if (bY(i20)) {
                            this.aqi += this.aqo;
                        }
                        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                        float f4 = f3 + layoutParams.weight;
                        if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                            int i21 = this.aqi;
                            this.aqi = Math.max(i21, layoutParams.topMargin + i21 + layoutParams.bottomMargin);
                            z7 = true;
                            i12 = i19;
                        } else {
                            int i22 = Integer.MIN_VALUE;
                            if (layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                                i22 = 0;
                                layoutParams.height = -2;
                            }
                            h(childAt, i2, 0, i3, f4 == 0.0f ? this.aqi : 0);
                            if (i22 != Integer.MIN_VALUE) {
                                layoutParams.height = i22;
                            }
                            int measuredHeight = childAt.getMeasuredHeight();
                            int i23 = this.aqi;
                            this.aqi = Math.max(i23, i23 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + 0);
                            if (z8) {
                                i12 = Math.max(measuredHeight, i19);
                            } else {
                                i12 = i19;
                            }
                        }
                        if (i18 >= 0 && i18 == i20 + 1) {
                            this.aqh = this.aqi;
                        }
                        if (i20 >= i18 || layoutParams.weight <= 0.0f) {
                            boolean z9 = false;
                            if (mode == 1073741824 || layoutParams.width != -1) {
                                z3 = z6;
                            } else {
                                z3 = true;
                                z9 = true;
                            }
                            int i24 = layoutParams.leftMargin + layoutParams.rightMargin;
                            int measuredWidth = childAt.getMeasuredWidth() + i24;
                            i14 = Math.max(i14, measuredWidth);
                            int combineMeasuredStates = View.combineMeasuredStates(i15, childAt.getMeasuredState());
                            z4 = z5 && layoutParams.width == -1;
                            if (layoutParams.weight > 0.0f) {
                                if (z9) {
                                    i13 = i24;
                                } else {
                                    i13 = measuredWidth;
                                }
                                i10 = Math.max(i17, i13);
                                i9 = i12;
                                z2 = z7;
                                f3 = f4;
                                i15 = combineMeasuredStates;
                            } else {
                                if (!z9) {
                                    i24 = measuredWidth;
                                }
                                int max = Math.max(i16, i24);
                                i9 = i12;
                                z2 = z7;
                                f3 = f4;
                                i10 = i17;
                                i16 = max;
                                i15 = combineMeasuredStates;
                            }
                        } else {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                    } else {
                        i9 = i19;
                        z2 = z7;
                        z3 = z6;
                        z4 = z5;
                        i10 = i17;
                    }
                    i11 = i20 + 0;
                    i19 = i9;
                    z7 = z2;
                    z6 = z3;
                    z5 = z4;
                    i17 = i10;
                }
                i20 = i11 + 1;
            }
            if (this.aqi > 0 && bY(virtualChildCount)) {
                this.aqi += this.aqo;
            }
            if (z8 && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
                this.aqi = 0;
                int i25 = 0;
                while (i25 < virtualChildCount) {
                    View childAt2 = getChildAt(i25);
                    if (childAt2 == null) {
                        this.aqi += 0;
                        i8 = i25;
                    } else if (childAt2.getVisibility() == 8) {
                        i8 = i25 + 0;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                        int i26 = this.aqi;
                        this.aqi = Math.max(i26, layoutParams2.bottomMargin + i26 + i19 + layoutParams2.topMargin + 0);
                        i8 = i25;
                    }
                    i25 = i8 + 1;
                }
            }
            this.aqi += getPaddingTop() + getPaddingBottom();
            int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.aqi, getSuggestedMinimumHeight()), i3, 0);
            int i27 = (16777215 & resolveSizeAndState) - this.aqi;
            if (z7 || (i27 != 0 && f3 > 0.0f)) {
                if (this.aqj > 0.0f) {
                    f3 = this.aqj;
                }
                this.aqi = 0;
                int i28 = 0;
                float f5 = f3;
                boolean z10 = z5;
                int i29 = i16;
                int i30 = i15;
                int i31 = i14;
                while (i28 < virtualChildCount) {
                    View childAt3 = getChildAt(i28);
                    if (childAt3.getVisibility() != 8) {
                        LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                        float f6 = layoutParams3.weight;
                        if (f6 > 0.0f) {
                            int i32 = (int) ((((float) i27) * f6) / f5);
                            float f7 = f5 - f6;
                            int i33 = i27 - i32;
                            int childMeasureSpec = getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                            if (layoutParams3.height != 0 || mode2 != 1073741824) {
                                i32 += childAt3.getMeasuredHeight();
                                if (i32 < 0) {
                                    i32 = 0;
                                }
                                view = childAt3;
                            } else if (i32 > 0) {
                                view = childAt3;
                            } else {
                                i32 = 0;
                                view = childAt3;
                            }
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i32, 1073741824));
                            f2 = f7;
                            i27 = i33;
                            i30 = View.combineMeasuredStates(i30, childAt3.getMeasuredState() & -256);
                        } else {
                            f2 = f5;
                        }
                        int i34 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                        int measuredWidth2 = childAt3.getMeasuredWidth() + i34;
                        i7 = Math.max(i31, measuredWidth2);
                        if (!(mode != 1073741824 && layoutParams3.width == -1)) {
                            i34 = measuredWidth2;
                        }
                        int max2 = Math.max(i29, i34);
                        boolean z11 = z10 && layoutParams3.width == -1;
                        int i35 = this.aqi;
                        this.aqi = Math.max(i35, layoutParams3.bottomMargin + childAt3.getMeasuredHeight() + i35 + layoutParams3.topMargin + 0);
                        z = z11;
                        i6 = max2;
                    } else {
                        f2 = f5;
                        z = z10;
                        i6 = i29;
                        i7 = i31;
                    }
                    i28++;
                    f5 = f2;
                    z10 = z;
                    i29 = i6;
                    i31 = i7;
                }
                this.aqi += getPaddingTop() + getPaddingBottom();
                z5 = z10;
                i5 = i29;
                i15 = i30;
                i4 = i31;
            } else {
                int max3 = Math.max(i16, i17);
                if (z8 && mode2 != 1073741824) {
                    for (int i36 = 0; i36 < virtualChildCount; i36++) {
                        View childAt4 = getChildAt(i36);
                        if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= 0.0f)) {
                            childAt4.measure(View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i19, 1073741824));
                        }
                    }
                }
                i5 = max3;
                i4 = i14;
            }
            if (z5 || mode == 1073741824) {
                i5 = i4;
            }
            setMeasuredDimension(View.resolveSizeAndState(Math.max(i5 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i2, i15), resolveSizeAndState);
            if (z6) {
                ad(virtualChildCount, i3);
                return;
            }
            return;
        }
        ae(i2, i3);
    }

    /* access modifiers changed from: protected */
    public final boolean bY(int i2) {
        if (i2 == 0) {
            return (this.aqp & 1) != 0;
        }
        if (i2 == getChildCount()) {
            return (this.aqp & 4) != 0;
        }
        if ((this.aqp & 2) == 0) {
            return false;
        }
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (getChildAt(i3).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    private void ad(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                }
            }
        }
    }

    private void ae(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        boolean z;
        int i8;
        int i9;
        float f3;
        int i10;
        int baseline;
        View view;
        int i11;
        int i12;
        boolean z2;
        boolean z3;
        boolean z4;
        int i13;
        int i14;
        int i15;
        int i16;
        int baseline2;
        this.aqi = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        boolean z5 = true;
        float f4 = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        boolean z6 = false;
        boolean z7 = false;
        if (this.aql == null || this.aqm == null) {
            this.aql = new int[4];
            this.aqm = new int[4];
        }
        int[] iArr = this.aql;
        int[] iArr2 = this.aqm;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z8 = this.aqf;
        boolean z9 = this.aqk;
        boolean z10 = mode == 1073741824;
        int i21 = 0;
        int i22 = 0;
        while (i22 < virtualChildCount) {
            View childAt = getChildAt(i22);
            if (childAt == null) {
                this.aqi += 0;
                i14 = i22;
            } else {
                if (childAt.getVisibility() != 8) {
                    if (bY(i22)) {
                        this.aqi += this.aqn;
                    }
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    float f5 = f4 + layoutParams.weight;
                    if (mode == 1073741824 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                        if (z10) {
                            this.aqi += layoutParams.leftMargin + layoutParams.rightMargin;
                        } else {
                            int i23 = this.aqi;
                            this.aqi = Math.max(i23, layoutParams.leftMargin + i23 + layoutParams.rightMargin);
                        }
                        if (z8) {
                            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                            childAt.measure(makeMeasureSpec, makeMeasureSpec);
                            i15 = i21;
                        } else {
                            z7 = true;
                            i15 = i21;
                        }
                    } else {
                        int i24 = Integer.MIN_VALUE;
                        if (layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                            i24 = 0;
                            layoutParams.width = -2;
                        }
                        h(childAt, i2, f5 == 0.0f ? this.aqi : 0, i3, 0);
                        if (i24 != Integer.MIN_VALUE) {
                            layoutParams.width = i24;
                        }
                        int measuredWidth = childAt.getMeasuredWidth();
                        if (z10) {
                            this.aqi += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + 0;
                        } else {
                            int i25 = this.aqi;
                            this.aqi = Math.max(i25, i25 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + 0);
                        }
                        if (z9) {
                            i15 = Math.max(measuredWidth, i21);
                        } else {
                            i15 = i21;
                        }
                    }
                    boolean z11 = false;
                    if (mode2 == 1073741824 || layoutParams.height != -1) {
                        z3 = z6;
                    } else {
                        z3 = true;
                        z11 = true;
                    }
                    int i26 = layoutParams.topMargin + layoutParams.bottomMargin;
                    int measuredHeight = childAt.getMeasuredHeight() + i26;
                    int combineMeasuredStates = View.combineMeasuredStates(i18, childAt.getMeasuredState());
                    if (z8 && (baseline2 = childAt.getBaseline()) != -1) {
                        int i27 = ((((layoutParams.gravity < 0 ? this.Ku : layoutParams.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i27] = Math.max(iArr[i27], baseline2);
                        iArr2[i27] = Math.max(iArr2[i27], measuredHeight - baseline2);
                    }
                    i17 = Math.max(i17, measuredHeight);
                    z4 = z5 && layoutParams.height == -1;
                    if (layoutParams.weight > 0.0f) {
                        if (z11) {
                            i16 = i26;
                        } else {
                            i16 = measuredHeight;
                        }
                        i13 = Math.max(i20, i16);
                        i12 = i15;
                        z2 = z7;
                        f4 = f5;
                        i18 = combineMeasuredStates;
                    } else {
                        if (!z11) {
                            i26 = measuredHeight;
                        }
                        int max = Math.max(i19, i26);
                        i12 = i15;
                        z2 = z7;
                        f4 = f5;
                        i13 = i20;
                        i19 = max;
                        i18 = combineMeasuredStates;
                    }
                } else {
                    i12 = i21;
                    z2 = z7;
                    z3 = z6;
                    z4 = z5;
                    i13 = i20;
                }
                i14 = i22 + 0;
                i21 = i12;
                z7 = z2;
                z6 = z3;
                z5 = z4;
                i20 = i13;
            }
            i22 = i14 + 1;
        }
        if (this.aqi > 0 && bY(virtualChildCount)) {
            this.aqi += this.aqn;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i4 = i17;
        } else {
            i4 = Math.max(i17, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z9 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.aqi = 0;
            int i28 = 0;
            while (i28 < virtualChildCount) {
                View childAt2 = getChildAt(i28);
                if (childAt2 == null) {
                    this.aqi += 0;
                    i11 = i28;
                } else if (childAt2.getVisibility() == 8) {
                    i11 = i28 + 0;
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                    if (z10) {
                        this.aqi = layoutParams2.rightMargin + layoutParams2.leftMargin + i21 + 0 + this.aqi;
                        i11 = i28;
                    } else {
                        int i29 = this.aqi;
                        this.aqi = Math.max(i29, layoutParams2.rightMargin + i29 + i21 + layoutParams2.leftMargin + 0);
                        i11 = i28;
                    }
                }
                i28 = i11 + 1;
            }
        }
        this.aqi += getPaddingLeft() + getPaddingRight();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(this.aqi, getSuggestedMinimumWidth()), i2, 0);
        int i30 = (16777215 & resolveSizeAndState) - this.aqi;
        if (z7 || (i30 != 0 && f4 > 0.0f)) {
            if (this.aqj > 0.0f) {
                f4 = this.aqj;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            int i31 = -1;
            this.aqi = 0;
            int i32 = 0;
            float f6 = f4;
            boolean z12 = z5;
            int i33 = i19;
            int i34 = i18;
            while (i32 < virtualChildCount) {
                View childAt3 = getChildAt(i32);
                if (childAt3 == null || childAt3.getVisibility() == 8) {
                    f2 = f6;
                    i7 = i30;
                    z = z12;
                    i8 = i33;
                    i9 = i31;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) childAt3.getLayoutParams();
                    float f7 = layoutParams3.weight;
                    if (f7 > 0.0f) {
                        int i35 = (int) ((((float) i30) * f7) / f6);
                        f3 = f6 - f7;
                        i30 -= i35;
                        int childMeasureSpec = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width != 0 || mode != 1073741824) {
                            i35 += childAt3.getMeasuredWidth();
                            if (i35 < 0) {
                                i35 = 0;
                            }
                            view = childAt3;
                        } else if (i35 > 0) {
                            view = childAt3;
                        } else {
                            i35 = 0;
                            view = childAt3;
                        }
                        view.measure(View.MeasureSpec.makeMeasureSpec(i35, 1073741824), childMeasureSpec);
                        i34 = View.combineMeasuredStates(i34, childAt3.getMeasuredState() & WebView.NIGHT_MODE_COLOR);
                    } else {
                        f3 = f6;
                    }
                    if (z10) {
                        this.aqi += childAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + 0;
                    } else {
                        int i36 = this.aqi;
                        this.aqi = Math.max(i36, childAt3.getMeasuredWidth() + i36 + layoutParams3.leftMargin + layoutParams3.rightMargin + 0);
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i37 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = childAt3.getMeasuredHeight() + i37;
                    i9 = Math.max(i31, measuredHeight2);
                    if (z13) {
                        i10 = i37;
                    } else {
                        i10 = measuredHeight2;
                    }
                    int max2 = Math.max(i33, i10);
                    boolean z14 = z12 && layoutParams3.height == -1;
                    if (z8 && (baseline = childAt3.getBaseline()) != -1) {
                        int i38 = ((((layoutParams3.gravity < 0 ? this.Ku : layoutParams3.gravity) & 112) >> 4) & -2) >> 1;
                        iArr[i38] = Math.max(iArr[i38], baseline);
                        iArr2[i38] = Math.max(iArr2[i38], measuredHeight2 - baseline);
                    }
                    f2 = f3;
                    i7 = i30;
                    z = z14;
                    i8 = max2;
                }
                i32++;
                f6 = f2;
                i30 = i7;
                z12 = z;
                i33 = i8;
                i31 = i9;
            }
            this.aqi += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i31 = Math.max(i31, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            z5 = z12;
            i6 = i33;
            i18 = i34;
            i5 = i31;
        } else {
            int max3 = Math.max(i19, i20);
            if (z9 && mode != 1073741824) {
                for (int i39 = 0; i39 < virtualChildCount; i39++) {
                    View childAt4 = getChildAt(i39);
                    if (!(childAt4 == null || childAt4.getVisibility() == 8 || ((LayoutParams) childAt4.getLayoutParams()).weight <= 0.0f)) {
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec(i21, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i6 = max3;
            i5 = i4;
        }
        if (z5 || mode2 == 1073741824) {
            i6 = i5;
        }
        setMeasuredDimension((-16777216 & i18) | resolveSizeAndState, View.resolveSizeAndState(Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i3, i18 << 16));
        if (z6) {
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
            for (int i40 = 0; i40 < virtualChildCount; i40++) {
                View childAt5 = getChildAt(i40);
                if (childAt5.getVisibility() != 8) {
                    LayoutParams layoutParams4 = (LayoutParams) childAt5.getLayoutParams();
                    if (layoutParams4.height == -1) {
                        int i41 = layoutParams4.width;
                        layoutParams4.width = childAt5.getMeasuredWidth();
                        measureChildWithMargins(childAt5, i2, 0, makeMeasureSpec2, 0);
                        layoutParams4.width = i41;
                    }
                }
            }
        }
    }

    private static int getChildrenSkipCount$5359dca7() {
        return 0;
    }

    private void h(View view, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    private static int getLocationOffset$3c7ec8d0() {
        return 0;
    }

    private static int getNextLocationOffset$3c7ec8d0() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int paddingTop;
        int i11;
        int i12;
        if (this.mOrientation == 1) {
            int paddingLeft2 = getPaddingLeft();
            int i13 = i4 - i2;
            int paddingRight = i13 - getPaddingRight();
            int paddingRight2 = (i13 - paddingLeft2) - getPaddingRight();
            int virtualChildCount = getVirtualChildCount();
            int i14 = this.Ku & 112;
            int i15 = 8388615 & this.Ku;
            switch (i14) {
                case 16:
                    paddingTop = getPaddingTop() + (((i5 - i3) - this.aqi) / 2);
                    break;
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    paddingTop = ((getPaddingTop() + i5) - i3) - this.aqi;
                    break;
                default:
                    paddingTop = getPaddingTop();
                    break;
            }
            int i16 = 0;
            int i17 = paddingTop;
            while (i16 < virtualChildCount) {
                View childAt = getChildAt(i16);
                if (childAt == null) {
                    i17 += 0;
                    i11 = i16;
                } else if (childAt.getVisibility() != 8) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    int i18 = layoutParams.gravity;
                    if (i18 < 0) {
                        i18 = i15;
                    }
                    switch (d.getAbsoluteGravity(i18, u.Z(this)) & 7) {
                        case 1:
                            i12 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft2) + layoutParams.leftMargin) - layoutParams.rightMargin;
                            break;
                        case 5:
                            i12 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                            break;
                        default:
                            i12 = layoutParams.leftMargin + paddingLeft2;
                            break;
                    }
                    if (bY(i16)) {
                        i17 += this.aqo;
                    }
                    int i19 = i17 + layoutParams.topMargin;
                    i(childAt, i12, i19 + 0, measuredWidth, measuredHeight);
                    i17 = i19 + layoutParams.bottomMargin + measuredHeight + 0;
                    i11 = i16 + 0;
                } else {
                    i11 = i16;
                }
                i16 = i11 + 1;
            }
            return;
        }
        boolean d2 = bh.d(this);
        int paddingTop2 = getPaddingTop();
        int i20 = i5 - i3;
        int paddingBottom = i20 - getPaddingBottom();
        int paddingBottom2 = (i20 - paddingTop2) - getPaddingBottom();
        int virtualChildCount2 = getVirtualChildCount();
        int i21 = this.Ku & 112;
        boolean z2 = this.aqf;
        int[] iArr = this.aql;
        int[] iArr2 = this.aqm;
        switch (d.getAbsoluteGravity(this.Ku & 8388615, u.Z(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i4 - i2) - this.aqi) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i4) - i2) - this.aqi;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        int i22 = 0;
        if (d2) {
            i22 = virtualChildCount2 - 1;
            i6 = -1;
        } else {
            i6 = 1;
        }
        int i23 = 0;
        while (i23 < virtualChildCount2) {
            int i24 = i22 + (i6 * i23);
            View childAt2 = getChildAt(i24);
            if (childAt2 == null) {
                paddingLeft += 0;
                i7 = i23;
            } else if (childAt2.getVisibility() != 8) {
                int measuredWidth2 = childAt2.getMeasuredWidth();
                int measuredHeight2 = childAt2.getMeasuredHeight();
                int i25 = -1;
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (z2 && layoutParams2.height != -1) {
                    i25 = childAt2.getBaseline();
                }
                int i26 = layoutParams2.gravity;
                if (i26 < 0) {
                    i26 = i21;
                }
                switch (i26 & 112) {
                    case 16:
                        i9 = ((((paddingBottom2 - measuredHeight2) / 2) + paddingTop2) + layoutParams2.topMargin) - layoutParams2.bottomMargin;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        i8 = layoutParams2.topMargin + paddingTop2;
                        if (i25 != -1) {
                            i9 = (iArr[1] - i25) + i8;
                            break;
                        }
                        i9 = i8;
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                        i8 = (paddingBottom - measuredHeight2) - layoutParams2.bottomMargin;
                        if (i25 != -1) {
                            i9 = i8 - (iArr2[2] - (childAt2.getMeasuredHeight() - i25));
                            break;
                        }
                        i9 = i8;
                        break;
                    default:
                        i9 = paddingTop2;
                        break;
                }
                if (bY(i24)) {
                    i10 = this.aqn + paddingLeft;
                } else {
                    i10 = paddingLeft;
                }
                int i27 = i10 + layoutParams2.leftMargin;
                i(childAt2, i27 + 0, i9, measuredWidth2, measuredHeight2);
                paddingLeft = i27 + layoutParams2.rightMargin + measuredWidth2 + 0;
                i7 = i23 + 0;
            } else {
                i7 = i23;
            }
            i23 = i7 + 1;
        }
    }

    private static void i(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i2 + i4, i3 + i5);
    }

    public void setOrientation(int i2) {
        if (this.mOrientation != i2) {
            this.mOrientation = i2;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i2) {
        int i3;
        if (this.Ku != i2) {
            if ((8388615 & i2) == 0) {
                i3 = 8388611 | i2;
            } else {
                i3 = i2;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.Ku = i3;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.Ku;
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & 8388615;
        if ((this.Ku & 8388615) != i3) {
            this.Ku = i3 | (this.Ku & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        if ((this.Ku & 112) != i3) {
            this.Ku = i3 | (this.Ku & ExportErrorStatus.APPEND_VIDEO_SAMPLE_SWAP_BUFFERS);
            requestLayout();
        }
    }

    /* renamed from: f */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: iL */
    public LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -2);
        }
        if (this.mOrientation == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C0040a.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(3, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(0, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }
    }
}
