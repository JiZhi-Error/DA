package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.flexbox.c;
import com.google.android.flexbox.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements a {
    private int bJA;
    private int bJB;
    private int bJC;
    private int[] bJD;
    private SparseIntArray bJE;
    private c bJF;
    private c.a bJG;
    private List<b> bJp;
    private int bJr;
    private int bJs;
    private int bJt;
    private int bJu;
    private int bJv;
    private int bJw;
    private Drawable bJx;
    private Drawable bJy;
    private int bJz;

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(62270);
        this.bJw = -1;
        this.bJF = new c(this);
        this.bJp = new ArrayList();
        this.bJG = new c.a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout, i2, 0);
        this.bJr = obtainStyledAttributes.getInt(5, 0);
        this.bJs = obtainStyledAttributes.getInt(6, 0);
        this.bJt = obtainStyledAttributes.getInt(7, 0);
        this.bJu = obtainStyledAttributes.getInt(1, 4);
        this.bJv = obtainStyledAttributes.getInt(0, 5);
        this.bJw = obtainStyledAttributes.getInt(8, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(2);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(3);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(4);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = obtainStyledAttributes.getInt(9, 0);
        if (i3 != 0) {
            this.bJA = i3;
            this.bJz = i3;
        }
        int i4 = obtainStyledAttributes.getInt(11, 0);
        if (i4 != 0) {
            this.bJA = i4;
        }
        int i5 = obtainStyledAttributes.getInt(10, 0);
        if (i5 != 0) {
            this.bJz = i5;
        }
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(62270);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(62271);
        if (this.bJE == null) {
            this.bJE = new SparseIntArray(getChildCount());
        }
        if (this.bJF.b(this.bJE)) {
            this.bJD = this.bJF.a(this.bJE);
        }
        switch (this.bJr) {
            case 0:
            case 1:
                ae(i2, i3);
                AppMethodBeat.o(62271);
                return;
            case 2:
            case 3:
                this.bJp.clear();
                this.bJG.reset();
                this.bJF.a(this.bJG, i2, i3);
                this.bJp = this.bJG.bJp;
                this.bJF.bk(i2, i3);
                this.bJF.w(i2, i3, getPaddingLeft() + getPaddingRight());
                this.bJF.xK();
                o(this.bJr, i2, i3, this.bJG.bJq);
                AppMethodBeat.o(62271);
                return;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid value for the flex direction is set: " + this.bJr);
                AppMethodBeat.o(62271);
                throw illegalStateException;
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        AppMethodBeat.i(62272);
        int childCount = getChildCount();
        AppMethodBeat.o(62272);
        return childCount;
    }

    @Override // com.google.android.flexbox.a
    public final View fj(int i2) {
        AppMethodBeat.i(62273);
        View childAt = getChildAt(i2);
        AppMethodBeat.o(62273);
        return childAt;
    }

    private View fr(int i2) {
        AppMethodBeat.i(62274);
        if (i2 < 0 || i2 >= this.bJD.length) {
            AppMethodBeat.o(62274);
            return null;
        }
        View childAt = getChildAt(this.bJD[i2]);
        AppMethodBeat.o(62274);
        return childAt;
    }

    @Override // com.google.android.flexbox.a
    public final View fk(int i2) {
        AppMethodBeat.i(62275);
        View fr = fr(i2);
        AppMethodBeat.o(62275);
        return fr;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(62276);
        if (this.bJE == null) {
            this.bJE = new SparseIntArray(getChildCount());
        }
        this.bJD = this.bJF.a(view, i2, layoutParams, this.bJE);
        super.addView(view, i2, layoutParams);
        AppMethodBeat.o(62276);
    }

    private void ae(int i2, int i3) {
        AppMethodBeat.i(62277);
        this.bJp.clear();
        this.bJG.reset();
        this.bJF.a(this.bJG, i2, i3, Integer.MAX_VALUE, 0, -1, (List<b>) null);
        this.bJp = this.bJG.bJp;
        this.bJF.v(i2, i3, 0);
        if (this.bJu == 3) {
            for (b bVar : this.bJp) {
                int i4 = Integer.MIN_VALUE;
                int i5 = 0;
                while (i5 < bVar.auc) {
                    View fr = fr(bVar.bJj + i5);
                    if (!(fr == null || fr.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) fr.getLayoutParams();
                        if (this.bJs != 2) {
                            i4 = Math.max(i4, layoutParams.bottomMargin + fr.getMeasuredHeight() + Math.max(bVar.bJg - fr.getBaseline(), layoutParams.topMargin));
                        } else {
                            i4 = Math.max(i4, layoutParams.topMargin + fr.getMeasuredHeight() + Math.max((bVar.bJg - fr.getMeasuredHeight()) + fr.getBaseline(), layoutParams.bottomMargin));
                        }
                    }
                    i5++;
                    i4 = i4;
                }
                bVar.bJc = i4;
            }
        }
        this.bJF.w(i2, i3, getPaddingTop() + getPaddingBottom());
        this.bJF.fn(0);
        o(this.bJr, i2, i3, this.bJG.bJq);
        AppMethodBeat.o(62277);
    }

    private void o(int i2, int i3, int i4, int i5) {
        int largestMainSize;
        int sumOfCrossSize;
        int i6;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int i7;
        AppMethodBeat.i(62278);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        switch (i2) {
            case 0:
            case 1:
                largestMainSize = getPaddingBottom() + getSumOfCrossSize() + getPaddingTop();
                sumOfCrossSize = getLargestMainSize();
                break;
            case 2:
            case 3:
                largestMainSize = getLargestMainSize();
                sumOfCrossSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid flex direction: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(62278);
                throw illegalArgumentException;
        }
        switch (mode) {
            case Integer.MIN_VALUE:
                if (size < sumOfCrossSize) {
                    i5 = View.combineMeasuredStates(i5, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                } else {
                    size = sumOfCrossSize;
                }
                int resolveSizeAndState3 = View.resolveSizeAndState(size, i3, i5);
                i6 = i5;
                resolveSizeAndState = resolveSizeAndState3;
                break;
            case 0:
                i6 = i5;
                resolveSizeAndState = View.resolveSizeAndState(sumOfCrossSize, i3, i5);
                break;
            case 1073741824:
                if (size < sumOfCrossSize) {
                    i5 = View.combineMeasuredStates(i5, TPMediaCodecProfileLevel.HEVCMainTierLevel62);
                }
                int resolveSizeAndState4 = View.resolveSizeAndState(size, i3, i5);
                i6 = i5;
                resolveSizeAndState = resolveSizeAndState4;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Unknown width mode is set: ".concat(String.valueOf(mode)));
                AppMethodBeat.o(62278);
                throw illegalStateException;
        }
        switch (mode2) {
            case Integer.MIN_VALUE:
                if (size2 < largestMainSize) {
                    i6 = View.combineMeasuredStates(i6, 256);
                    i7 = size2;
                } else {
                    i7 = largestMainSize;
                }
                resolveSizeAndState2 = View.resolveSizeAndState(i7, i4, i6);
                break;
            case 0:
                resolveSizeAndState2 = View.resolveSizeAndState(largestMainSize, i4, i6);
                break;
            case 1073741824:
                if (size2 < largestMainSize) {
                    i6 = View.combineMeasuredStates(i6, 256);
                }
                resolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i6);
                break;
            default:
                IllegalStateException illegalStateException2 = new IllegalStateException("Unknown height mode is set: ".concat(String.valueOf(mode2)));
                AppMethodBeat.o(62278);
                throw illegalStateException2;
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
        AppMethodBeat.o(62278);
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        AppMethodBeat.i(62279);
        int i2 = Integer.MIN_VALUE;
        for (b bVar : this.bJp) {
            i2 = Math.max(i2, bVar.bJa);
        }
        AppMethodBeat.o(62279);
        return i2;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        AppMethodBeat.i(62280);
        int size = this.bJp.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.bJp.get(i3);
            if (fs(i3)) {
                if (xC()) {
                    i2 += this.bJB;
                } else {
                    i2 += this.bJC;
                }
            }
            if (fu(i3)) {
                if (xC()) {
                    i2 += this.bJB;
                } else {
                    i2 += this.bJC;
                }
            }
            i2 += bVar.bJc;
        }
        AppMethodBeat.o(62280);
        return i2;
    }

    @Override // com.google.android.flexbox.a
    public final boolean xC() {
        return this.bJr == 0 || this.bJr == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        boolean z6 = true;
        AppMethodBeat.i(62281);
        int Z = u.Z(this);
        switch (this.bJr) {
            case 0:
                b(Z == 1, i2, i3, i4, i5);
                AppMethodBeat.o(62281);
                return;
            case 1:
                if (Z != 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                b(z4, i2, i3, i4, i5);
                AppMethodBeat.o(62281);
                return;
            case 2:
                boolean z7 = Z == 1;
                if (this.bJs == 2) {
                    if (z7) {
                        z6 = false;
                    }
                    z3 = z6;
                } else {
                    z3 = z7;
                }
                a(z3, false, i2, i3, i4, i5);
                AppMethodBeat.o(62281);
                return;
            case 3:
                boolean z8 = Z == 1;
                if (this.bJs == 2) {
                    if (!z8) {
                        z5 = true;
                    }
                    z2 = z5;
                } else {
                    z2 = z8;
                }
                a(z2, true, i2, i3, i4, i5);
                AppMethodBeat.o(62281);
                return;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("Invalid flex direction is set: " + this.bJr);
                AppMethodBeat.o(62281);
                throw illegalStateException;
        }
    }

    private void b(boolean z, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(62282);
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i6 = i4 - i2;
        int paddingBottom = (i5 - i3) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.bJp.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.bJp.get(i7);
            if (fs(i7)) {
                paddingBottom -= this.bJB;
                paddingTop += this.bJB;
            }
            float f6 = 0.0f;
            switch (this.bJt) {
                case 0:
                    f2 = (float) paddingLeft;
                    f3 = (float) (i6 - paddingRight);
                    break;
                case 1:
                    f2 = (float) ((i6 - bVar.bJa) + paddingRight);
                    f3 = (float) (bVar.bJa - paddingLeft);
                    break;
                case 2:
                    f2 = (((float) (i6 - bVar.bJa)) / 2.0f) + ((float) paddingLeft);
                    f3 = ((float) (i6 - paddingRight)) - (((float) (i6 - bVar.bJa)) / 2.0f);
                    break;
                case 3:
                    f2 = (float) paddingLeft;
                    int xJ = bVar.xJ();
                    f6 = ((float) (i6 - bVar.bJa)) / (xJ != 1 ? (float) (xJ - 1) : 1.0f);
                    f3 = (float) (i6 - paddingRight);
                    break;
                case 4:
                    int xJ2 = bVar.xJ();
                    if (xJ2 != 0) {
                        f6 = ((float) (i6 - bVar.bJa)) / ((float) xJ2);
                    }
                    f2 = (f6 / 2.0f) + ((float) paddingLeft);
                    f3 = ((float) (i6 - paddingRight)) - (f6 / 2.0f);
                    break;
                case 5:
                    int xJ3 = bVar.xJ();
                    if (xJ3 != 0) {
                        f6 = ((float) (i6 - bVar.bJa)) / ((float) (xJ3 + 1));
                    }
                    f2 = ((float) paddingLeft) + f6;
                    f3 = ((float) (i6 - paddingRight)) - f6;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
                    AppMethodBeat.o(62282);
                    throw illegalStateException;
            }
            float max = Math.max(f6, 0.0f);
            int i8 = 0;
            float f7 = f3;
            while (i8 < bVar.auc) {
                int i9 = bVar.bJj + i8;
                View fr = fr(i9);
                if (!(fr == null || fr.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fr.getLayoutParams();
                    float f8 = f2 + ((float) layoutParams.leftMargin);
                    float f9 = f7 - ((float) layoutParams.rightMargin);
                    int i10 = 0;
                    int i11 = 0;
                    if (bm(i9, i8)) {
                        i10 = this.bJC;
                        f4 = f9 - ((float) i10);
                        f5 = f8 + ((float) i10);
                    } else {
                        f4 = f9;
                        f5 = f8;
                    }
                    if (i8 == bVar.auc - 1 && (this.bJA & 4) > 0) {
                        i11 = this.bJC;
                    }
                    if (this.bJs == 2) {
                        if (z) {
                            this.bJF.a(fr, bVar, Math.round(f4) - fr.getMeasuredWidth(), paddingBottom - fr.getMeasuredHeight(), Math.round(f4), paddingBottom);
                        } else {
                            this.bJF.a(fr, bVar, Math.round(f5), paddingBottom - fr.getMeasuredHeight(), Math.round(f5) + fr.getMeasuredWidth(), paddingBottom);
                        }
                    } else if (z) {
                        this.bJF.a(fr, bVar, Math.round(f4) - fr.getMeasuredWidth(), paddingTop, Math.round(f4), paddingTop + fr.getMeasuredHeight());
                    } else {
                        this.bJF.a(fr, bVar, Math.round(f5), paddingTop, Math.round(f5) + fr.getMeasuredWidth(), paddingTop + fr.getMeasuredHeight());
                    }
                    f2 = f5 + ((float) fr.getMeasuredWidth()) + max + ((float) layoutParams.rightMargin);
                    f7 = f4 - ((((float) fr.getMeasuredWidth()) + max) + ((float) layoutParams.leftMargin));
                    if (z) {
                        bVar.k(fr, i11, 0, i10, 0);
                    } else {
                        bVar.k(fr, i10, 0, i11, 0);
                    }
                }
                i8++;
                f7 = f7;
            }
            paddingTop += bVar.bJc;
            paddingBottom -= bVar.bJc;
        }
        AppMethodBeat.o(62282);
    }

    private void a(boolean z, boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        AppMethodBeat.i(62283);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i6 = i5 - i3;
        int i7 = (i4 - i2) - paddingRight;
        int size = this.bJp.size();
        for (int i8 = 0; i8 < size; i8++) {
            b bVar = this.bJp.get(i8);
            if (fs(i8)) {
                paddingLeft += this.bJC;
                i7 -= this.bJC;
            }
            float f6 = 0.0f;
            switch (this.bJt) {
                case 0:
                    f2 = (float) paddingTop;
                    f3 = (float) (i6 - paddingBottom);
                    break;
                case 1:
                    f2 = (float) ((i6 - bVar.bJa) + paddingBottom);
                    f3 = (float) (bVar.bJa - paddingTop);
                    break;
                case 2:
                    f2 = (((float) (i6 - bVar.bJa)) / 2.0f) + ((float) paddingTop);
                    f3 = ((float) (i6 - paddingBottom)) - (((float) (i6 - bVar.bJa)) / 2.0f);
                    break;
                case 3:
                    f2 = (float) paddingTop;
                    int xJ = bVar.xJ();
                    f6 = ((float) (i6 - bVar.bJa)) / (xJ != 1 ? (float) (xJ - 1) : 1.0f);
                    f3 = (float) (i6 - paddingBottom);
                    break;
                case 4:
                    int xJ2 = bVar.xJ();
                    if (xJ2 != 0) {
                        f6 = ((float) (i6 - bVar.bJa)) / ((float) xJ2);
                    }
                    f2 = (f6 / 2.0f) + ((float) paddingTop);
                    f3 = ((float) (i6 - paddingBottom)) - (f6 / 2.0f);
                    break;
                case 5:
                    int xJ3 = bVar.xJ();
                    if (xJ3 != 0) {
                        f6 = ((float) (i6 - bVar.bJa)) / ((float) (xJ3 + 1));
                    }
                    f2 = ((float) paddingTop) + f6;
                    f3 = ((float) (i6 - paddingBottom)) - f6;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
                    AppMethodBeat.o(62283);
                    throw illegalStateException;
            }
            float max = Math.max(f6, 0.0f);
            int i9 = 0;
            while (true) {
                float f7 = f3;
                if (i9 < bVar.auc) {
                    int i10 = bVar.bJj + i9;
                    View fr = fr(i10);
                    if (!(fr == null || fr.getVisibility() == 8)) {
                        LayoutParams layoutParams = (LayoutParams) fr.getLayoutParams();
                        float f8 = f2 + ((float) layoutParams.topMargin);
                        float f9 = f7 - ((float) layoutParams.bottomMargin);
                        int i11 = 0;
                        int i12 = 0;
                        if (bm(i10, i9)) {
                            i11 = this.bJB;
                            f4 = f9 - ((float) i11);
                            f5 = f8 + ((float) i11);
                        } else {
                            f4 = f9;
                            f5 = f8;
                        }
                        if (i9 == bVar.auc - 1 && (this.bJz & 4) > 0) {
                            i12 = this.bJB;
                        }
                        if (z) {
                            if (z2) {
                                this.bJF.a(fr, bVar, true, i7 - fr.getMeasuredWidth(), Math.round(f4) - fr.getMeasuredHeight(), i7, Math.round(f4));
                            } else {
                                this.bJF.a(fr, bVar, true, i7 - fr.getMeasuredWidth(), Math.round(f5), i7, Math.round(f5) + fr.getMeasuredHeight());
                            }
                        } else if (z2) {
                            this.bJF.a(fr, bVar, false, paddingLeft, Math.round(f4) - fr.getMeasuredHeight(), paddingLeft + fr.getMeasuredWidth(), Math.round(f4));
                        } else {
                            this.bJF.a(fr, bVar, false, paddingLeft, Math.round(f5), paddingLeft + fr.getMeasuredWidth(), Math.round(f5) + fr.getMeasuredHeight());
                        }
                        f2 = f5 + ((float) fr.getMeasuredHeight()) + max + ((float) layoutParams.bottomMargin);
                        f7 = f4 - ((((float) fr.getMeasuredHeight()) + max) + ((float) layoutParams.topMargin));
                        if (z2) {
                            bVar.k(fr, 0, i12, 0, i11);
                        } else {
                            bVar.k(fr, 0, i11, 0, i12);
                        }
                    }
                    f3 = f7;
                    i9++;
                } else {
                    paddingLeft += bVar.bJc;
                    i7 -= bVar.bJc;
                }
            }
        }
        AppMethodBeat.o(62283);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z;
        boolean z2 = false;
        boolean z3 = true;
        AppMethodBeat.i(62284);
        if (this.bJy == null && this.bJx == null) {
            AppMethodBeat.o(62284);
        } else if (this.bJz == 0 && this.bJA == 0) {
            AppMethodBeat.o(62284);
        } else {
            int Z = u.Z(this);
            switch (this.bJr) {
                case 0:
                    boolean z4 = Z == 1;
                    if (this.bJs != 2) {
                        z3 = false;
                    }
                    a(canvas, z4, z3);
                    AppMethodBeat.o(62284);
                    return;
                case 1:
                    boolean z5 = Z != 1;
                    if (this.bJs != 2) {
                        z3 = false;
                    }
                    a(canvas, z5, z3);
                    AppMethodBeat.o(62284);
                    return;
                case 2:
                    boolean z6 = Z == 1;
                    if (this.bJs != 2) {
                        z3 = z6;
                    } else if (z6) {
                        z3 = false;
                    }
                    b(canvas, z3, false);
                    AppMethodBeat.o(62284);
                    return;
                case 3:
                    if (Z == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.bJs != 2) {
                        z2 = z;
                    } else if (!z) {
                        z2 = true;
                    }
                    b(canvas, z2, true);
                    break;
            }
            AppMethodBeat.o(62284);
        }
    }

    private void a(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int right;
        int left;
        AppMethodBeat.i(62285);
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.bJp.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.bJp.get(i4);
            for (int i5 = 0; i5 < bVar.auc; i5++) {
                int i6 = bVar.bJj + i5;
                View fr = fr(i6);
                if (!(fr == null || fr.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fr.getLayoutParams();
                    if (bm(i6, i5)) {
                        if (z) {
                            left = fr.getRight() + layoutParams.rightMargin;
                        } else {
                            left = (fr.getLeft() - layoutParams.leftMargin) - this.bJC;
                        }
                        a(canvas, left, bVar.Am, bVar.bJc);
                    }
                    if (i5 == bVar.auc - 1 && (this.bJA & 4) > 0) {
                        if (z) {
                            right = (fr.getLeft() - layoutParams.leftMargin) - this.bJC;
                        } else {
                            right = layoutParams.rightMargin + fr.getRight();
                        }
                        a(canvas, right, bVar.Am, bVar.bJc);
                    }
                }
            }
            if (fs(i4)) {
                if (z2) {
                    i3 = bVar.Ao;
                } else {
                    i3 = bVar.Am - this.bJB;
                }
                b(canvas, paddingLeft, i3, max);
            }
            if (fu(i4) && (this.bJz & 4) > 0) {
                if (z2) {
                    i2 = bVar.Am - this.bJB;
                } else {
                    i2 = bVar.Ao;
                }
                b(canvas, paddingLeft, i2, max);
            }
        }
        AppMethodBeat.o(62285);
    }

    private void b(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int bottom;
        int top;
        AppMethodBeat.i(62286);
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.bJp.size();
        for (int i4 = 0; i4 < size; i4++) {
            b bVar = this.bJp.get(i4);
            for (int i5 = 0; i5 < bVar.auc; i5++) {
                int i6 = bVar.bJj + i5;
                View fr = fr(i6);
                if (!(fr == null || fr.getVisibility() == 8)) {
                    LayoutParams layoutParams = (LayoutParams) fr.getLayoutParams();
                    if (bm(i6, i5)) {
                        if (z2) {
                            top = fr.getBottom() + layoutParams.bottomMargin;
                        } else {
                            top = (fr.getTop() - layoutParams.topMargin) - this.bJB;
                        }
                        b(canvas, bVar.Al, top, bVar.bJc);
                    }
                    if (i5 == bVar.auc - 1 && (this.bJz & 4) > 0) {
                        if (z2) {
                            bottom = (fr.getTop() - layoutParams.topMargin) - this.bJB;
                        } else {
                            bottom = layoutParams.bottomMargin + fr.getBottom();
                        }
                        b(canvas, bVar.Al, bottom, bVar.bJc);
                    }
                }
            }
            if (fs(i4)) {
                if (z) {
                    i3 = bVar.An;
                } else {
                    i3 = bVar.Al - this.bJC;
                }
                a(canvas, i3, paddingTop, max);
            }
            if (fu(i4) && (this.bJA & 4) > 0) {
                if (z) {
                    i2 = bVar.Al - this.bJC;
                } else {
                    i2 = bVar.An;
                }
                a(canvas, i2, paddingTop, max);
            }
        }
        AppMethodBeat.o(62286);
    }

    private void a(Canvas canvas, int i2, int i3, int i4) {
        AppMethodBeat.i(62287);
        if (this.bJy == null) {
            AppMethodBeat.o(62287);
            return;
        }
        this.bJy.setBounds(i2, i3, this.bJC + i2, i3 + i4);
        this.bJy.draw(canvas);
        AppMethodBeat.o(62287);
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        AppMethodBeat.i(62288);
        if (this.bJx == null) {
            AppMethodBeat.o(62288);
            return;
        }
        this.bJx.setBounds(i2, i3, i2 + i4, this.bJB + i3);
        this.bJx.draw(canvas);
        AppMethodBeat.o(62288);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(62289);
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = new LayoutParams((LayoutParams) layoutParams);
            AppMethodBeat.o(62289);
            return layoutParams2;
        } else if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams layoutParams3 = new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
            AppMethodBeat.o(62289);
            return layoutParams3;
        } else {
            LayoutParams layoutParams4 = new LayoutParams(layoutParams);
            AppMethodBeat.o(62289);
            return layoutParams4;
        }
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.bJr;
    }

    public void setFlexDirection(int i2) {
        AppMethodBeat.i(62290);
        if (this.bJr != i2) {
            this.bJr = i2;
            requestLayout();
        }
        AppMethodBeat.o(62290);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.bJs;
    }

    public void setFlexWrap(int i2) {
        AppMethodBeat.i(62291);
        if (this.bJs != i2) {
            this.bJs = i2;
            requestLayout();
        }
        AppMethodBeat.o(62291);
    }

    public int getJustifyContent() {
        return this.bJt;
    }

    public void setJustifyContent(int i2) {
        AppMethodBeat.i(62292);
        if (this.bJt != i2) {
            this.bJt = i2;
            requestLayout();
        }
        AppMethodBeat.o(62292);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.bJu;
    }

    public void setAlignItems(int i2) {
        AppMethodBeat.i(62293);
        if (this.bJu != i2) {
            this.bJu = i2;
            requestLayout();
        }
        AppMethodBeat.o(62293);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.bJv;
    }

    public void setAlignContent(int i2) {
        AppMethodBeat.i(62294);
        if (this.bJv != i2) {
            this.bJv = i2;
            requestLayout();
        }
        AppMethodBeat.o(62294);
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.bJw;
    }

    public void setMaxLine(int i2) {
        AppMethodBeat.i(62295);
        if (this.bJw != i2) {
            this.bJw = i2;
            requestLayout();
        }
        AppMethodBeat.o(62295);
    }

    public List<b> getFlexLines() {
        AppMethodBeat.i(62296);
        ArrayList arrayList = new ArrayList(this.bJp.size());
        for (b bVar : this.bJp) {
            if (bVar.xJ() != 0) {
                arrayList.add(bVar);
            }
        }
        AppMethodBeat.o(62296);
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public final int m(View view, int i2, int i3) {
        AppMethodBeat.i(62297);
        int i4 = 0;
        if (xC()) {
            if (bm(i2, i3)) {
                i4 = this.bJC + 0;
            }
            if ((this.bJA & 4) > 0) {
                i4 += this.bJC;
            }
        } else {
            if (bm(i2, i3)) {
                i4 = this.bJB + 0;
            }
            if ((this.bJz & 4) > 0) {
                i4 += this.bJB;
            }
        }
        AppMethodBeat.o(62297);
        return i4;
    }

    @Override // com.google.android.flexbox.a
    public final int bV(View view) {
        return 0;
    }

    @Override // com.google.android.flexbox.a
    public final void a(b bVar) {
        AppMethodBeat.i(62298);
        if (xC()) {
            if ((this.bJA & 4) > 0) {
                bVar.bJa += this.bJC;
                bVar.bJb += this.bJC;
                AppMethodBeat.o(62298);
                return;
            }
        } else if ((this.bJz & 4) > 0) {
            bVar.bJa += this.bJB;
            bVar.bJb += this.bJB;
        }
        AppMethodBeat.o(62298);
    }

    @Override // com.google.android.flexbox.a
    public final int t(int i2, int i3, int i4) {
        AppMethodBeat.i(62299);
        int childMeasureSpec = getChildMeasureSpec(i2, i3, i4);
        AppMethodBeat.o(62299);
        return childMeasureSpec;
    }

    @Override // com.google.android.flexbox.a
    public final int u(int i2, int i3, int i4) {
        AppMethodBeat.i(62300);
        int childMeasureSpec = getChildMeasureSpec(i2, i3, i4);
        AppMethodBeat.o(62300);
        return childMeasureSpec;
    }

    @Override // com.google.android.flexbox.a
    public final void a(View view, int i2, int i3, b bVar) {
        AppMethodBeat.i(62301);
        if (bm(i2, i3)) {
            if (xC()) {
                bVar.bJa += this.bJC;
                bVar.bJb += this.bJC;
                AppMethodBeat.o(62301);
                return;
            }
            bVar.bJa += this.bJB;
            bVar.bJb += this.bJB;
        }
        AppMethodBeat.o(62301);
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<b> list) {
        this.bJp = list;
    }

    @Override // com.google.android.flexbox.a
    public List<b> getFlexLinesInternal() {
        return this.bJp;
    }

    @Override // com.google.android.flexbox.a
    public final void a(int i2, View view) {
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.bJx;
    }

    public Drawable getDividerDrawableVertical() {
        return this.bJy;
    }

    public void setDividerDrawable(Drawable drawable) {
        AppMethodBeat.i(62302);
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
        AppMethodBeat.o(62302);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        AppMethodBeat.i(62303);
        if (drawable == this.bJx) {
            AppMethodBeat.o(62303);
            return;
        }
        this.bJx = drawable;
        if (drawable != null) {
            this.bJB = drawable.getIntrinsicHeight();
        } else {
            this.bJB = 0;
        }
        xL();
        requestLayout();
        AppMethodBeat.o(62303);
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        AppMethodBeat.i(62304);
        if (drawable == this.bJy) {
            AppMethodBeat.o(62304);
            return;
        }
        this.bJy = drawable;
        if (drawable != null) {
            this.bJC = drawable.getIntrinsicWidth();
        } else {
            this.bJC = 0;
        }
        xL();
        requestLayout();
        AppMethodBeat.o(62304);
    }

    public int getShowDividerVertical() {
        return this.bJA;
    }

    public int getShowDividerHorizontal() {
        return this.bJz;
    }

    public void setShowDivider(int i2) {
        AppMethodBeat.i(62305);
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
        AppMethodBeat.o(62305);
    }

    public void setShowDividerVertical(int i2) {
        AppMethodBeat.i(62306);
        if (i2 != this.bJA) {
            this.bJA = i2;
            requestLayout();
        }
        AppMethodBeat.o(62306);
    }

    public void setShowDividerHorizontal(int i2) {
        AppMethodBeat.i(62307);
        if (i2 != this.bJz) {
            this.bJz = i2;
            requestLayout();
        }
        AppMethodBeat.o(62307);
    }

    private void xL() {
        AppMethodBeat.i(62308);
        if (this.bJx == null && this.bJy == null) {
            setWillNotDraw(true);
            AppMethodBeat.o(62308);
            return;
        }
        setWillNotDraw(false);
        AppMethodBeat.o(62308);
    }

    private boolean bm(int i2, int i3) {
        AppMethodBeat.i(62309);
        if (bn(i2, i3)) {
            if (xC()) {
                if ((this.bJA & 1) != 0) {
                    AppMethodBeat.o(62309);
                    return true;
                }
                AppMethodBeat.o(62309);
                return false;
            } else if ((this.bJz & 1) != 0) {
                AppMethodBeat.o(62309);
                return true;
            } else {
                AppMethodBeat.o(62309);
                return false;
            }
        } else if (xC()) {
            if ((this.bJA & 2) != 0) {
                AppMethodBeat.o(62309);
                return true;
            }
            AppMethodBeat.o(62309);
            return false;
        } else if ((this.bJz & 2) != 0) {
            AppMethodBeat.o(62309);
            return true;
        } else {
            AppMethodBeat.o(62309);
            return false;
        }
    }

    private boolean bn(int i2, int i3) {
        AppMethodBeat.i(62310);
        for (int i4 = 1; i4 <= i3; i4++) {
            View fr = fr(i2 - i4);
            if (fr != null && fr.getVisibility() != 8) {
                AppMethodBeat.o(62310);
                return false;
            }
        }
        AppMethodBeat.o(62310);
        return true;
    }

    private boolean fs(int i2) {
        AppMethodBeat.i(62311);
        if (i2 < 0 || i2 >= this.bJp.size()) {
            AppMethodBeat.o(62311);
            return false;
        } else if (ft(i2)) {
            if (xC()) {
                if ((this.bJz & 1) != 0) {
                    AppMethodBeat.o(62311);
                    return true;
                }
                AppMethodBeat.o(62311);
                return false;
            } else if ((this.bJA & 1) != 0) {
                AppMethodBeat.o(62311);
                return true;
            } else {
                AppMethodBeat.o(62311);
                return false;
            }
        } else if (xC()) {
            if ((this.bJz & 2) != 0) {
                AppMethodBeat.o(62311);
                return true;
            }
            AppMethodBeat.o(62311);
            return false;
        } else if ((this.bJA & 2) != 0) {
            AppMethodBeat.o(62311);
            return true;
        } else {
            AppMethodBeat.o(62311);
            return false;
        }
    }

    private boolean ft(int i2) {
        AppMethodBeat.i(62312);
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.bJp.get(i3).xJ() > 0) {
                AppMethodBeat.o(62312);
                return false;
            }
        }
        AppMethodBeat.o(62312);
        return true;
    }

    private boolean fu(int i2) {
        AppMethodBeat.i(62313);
        if (i2 < 0 || i2 >= this.bJp.size()) {
            AppMethodBeat.o(62313);
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.bJp.size(); i3++) {
            if (this.bJp.get(i3).xJ() > 0) {
                AppMethodBeat.o(62313);
                return false;
            }
        }
        if (xC()) {
            if ((this.bJz & 4) != 0) {
                AppMethodBeat.o(62313);
                return true;
            }
            AppMethodBeat.o(62313);
            return false;
        } else if ((this.bJA & 4) != 0) {
            AppMethodBeat.o(62313);
            return true;
        } else {
            AppMethodBeat.o(62313);
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            /* class com.google.android.flexbox.FlexboxLayout.LayoutParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LayoutParams[] newArray(int i2) {
                return new LayoutParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LayoutParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(62265);
                LayoutParams layoutParams = new LayoutParams(parcel);
                AppMethodBeat.o(62265);
                return layoutParams;
            }
        };
        private int bJH = 1;
        private float bJI = 0.0f;
        private float bJJ = 1.0f;
        private int bJK = -1;
        private float bJL = -1.0f;
        private boolean bJM;
        private int mMaxHeight = 16777215;
        private int mMaxWidth = 16777215;
        private int mMinHeight;
        private int mMinWidth;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            AppMethodBeat.i(62266);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.FlexboxLayout_Layout);
            this.bJH = obtainStyledAttributes.getInt(8, 1);
            this.bJI = obtainStyledAttributes.getFloat(2, 0.0f);
            this.bJJ = obtainStyledAttributes.getFloat(3, 1.0f);
            this.bJK = obtainStyledAttributes.getInt(0, -1);
            this.bJL = obtainStyledAttributes.getFraction(1, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(7, 0);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(6, 0);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(5, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(4, 16777215);
            this.bJM = obtainStyledAttributes.getBoolean(9, false);
            obtainStyledAttributes.recycle();
            AppMethodBeat.o(62266);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.bJH = layoutParams.bJH;
            this.bJI = layoutParams.bJI;
            this.bJJ = layoutParams.bJJ;
            this.bJK = layoutParams.bJK;
            this.bJL = layoutParams.bJL;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.bJM = layoutParams.bJM;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getHeight() {
            return this.height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getOrder() {
            return this.bJH;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float getFlexGrow() {
            return this.bJI;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float getFlexShrink() {
            return this.bJJ;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int xD() {
            return this.bJK;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final boolean xE() {
            return this.bJM;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final float xF() {
            return this.bJL;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int xG() {
            return this.leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int xH() {
            return this.topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int xI() {
            return this.rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getMarginBottom() {
            return this.bottomMargin;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(62267);
            parcel.writeInt(this.bJH);
            parcel.writeFloat(this.bJI);
            parcel.writeFloat(this.bJJ);
            parcel.writeInt(this.bJK);
            parcel.writeFloat(this.bJL);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.bJM ? (byte) 1 : 0);
            parcel.writeInt(this.bottomMargin);
            parcel.writeInt(this.leftMargin);
            parcel.writeInt(this.rightMargin);
            parcel.writeInt(this.topMargin);
            parcel.writeInt(this.height);
            parcel.writeInt(this.width);
            AppMethodBeat.o(62267);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected LayoutParams(Parcel parcel) {
            super(0, 0);
            boolean z = true;
            AppMethodBeat.i(62268);
            this.bJH = parcel.readInt();
            this.bJI = parcel.readFloat();
            this.bJJ = parcel.readFloat();
            this.bJK = parcel.readInt();
            this.bJL = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.bJM = parcel.readByte() == 0 ? false : z;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
            AppMethodBeat.o(62268);
        }

        static {
            AppMethodBeat.i(62269);
            AppMethodBeat.o(62269);
        }
    }

    @Override // android.view.ViewGroup
    public /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        AppMethodBeat.i(62314);
        LayoutParams layoutParams = new LayoutParams(getContext(), attributeSet);
        AppMethodBeat.o(62314);
        return layoutParams;
    }
}
