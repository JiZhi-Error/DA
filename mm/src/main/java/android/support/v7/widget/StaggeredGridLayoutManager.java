package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.a.c;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.r.b {
    private final Rect Ui;
    public int apM;
    boolean aqu;
    boolean aqv;
    private boolean aqx;
    int aqy;
    int aqz;
    b[] awM;
    aj awN;
    aj awO;
    private int awP;
    private final ad awQ;
    private BitSet awR;
    LazySpanLookup awS;
    private int awT;
    private boolean awU;
    private boolean awV;
    private SavedState awW;
    private int awX;
    private final a awY;
    private boolean awZ;
    private int[] axa;
    private final Runnable axb;
    public int mOrientation;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.apM = -1;
        this.aqu = false;
        this.aqv = false;
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.awS = new LazySpanLookup();
        this.awT = 2;
        this.Ui = new Rect();
        this.awY = new a();
        this.awZ = false;
        this.aqx = true;
        this.axb = new Runnable() {
            /* class android.support.v7.widget.StaggeredGridLayoutManager.AnonymousClass1 */

            public final void run() {
                StaggeredGridLayoutManager.this.mB();
            }
        };
        RecyclerView.LayoutManager.b properties = getProperties(context, attributeSet, i2, i3);
        int i4 = properties.orientation;
        if (i4 == 0 || i4 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i4 != this.mOrientation) {
                this.mOrientation = i4;
                aj ajVar = this.awN;
                this.awN = this.awO;
                this.awO = ajVar;
                requestLayout();
            }
            bW(properties.att);
            ao(properties.atu);
            this.awQ = new ad();
            mA();
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public StaggeredGridLayoutManager(int i2, int i3) {
        this.apM = -1;
        this.aqu = false;
        this.aqv = false;
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.awS = new LazySpanLookup();
        this.awT = 2;
        this.Ui = new Rect();
        this.awY = new a();
        this.awZ = false;
        this.aqx = true;
        this.axb = new Runnable() {
            /* class android.support.v7.widget.StaggeredGridLayoutManager.AnonymousClass1 */

            public final void run() {
                StaggeredGridLayoutManager.this.mB();
            }
        };
        this.mOrientation = 1;
        bW(i2);
        this.awQ = new ad();
        mA();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.awT != 0;
    }

    private void mA() {
        this.awN = aj.a(this, this.mOrientation);
        this.awO = aj.a(this, 1 - this.mOrientation);
    }

    /* access modifiers changed from: package-private */
    public final boolean mB() {
        int mI;
        int mH;
        if (getChildCount() == 0 || this.awT == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.aqv) {
            mI = mH();
            mH = mI();
        } else {
            mI = mI();
            mH = mH();
        }
        if (mI == 0 && mC() != null) {
            this.awS.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.awZ) {
            return false;
        } else {
            int i2 = this.aqv ? -1 : 1;
            LazySpanLookup.FullSpanItem o = this.awS.o(mI, mH + 1, i2);
            if (o == null) {
                this.awZ = false;
                this.awS.cI(mH + 1);
                return false;
            }
            LazySpanLookup.FullSpanItem o2 = this.awS.o(mI, o.mPosition, i2 * -1);
            if (o2 == null) {
                this.awS.cI(o.mPosition);
            } else {
                this.awS.cI(o2.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i2) {
        if (i2 == 0) {
            mB();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.onDetachedFromWindow(recyclerView, nVar);
        removeCallbacks(this.axb);
        for (int i2 = 0; i2 < this.apM; i2++) {
            this.awM[i2].clear();
        }
        recyclerView.requestLayout();
    }

    private View mC() {
        int i2;
        boolean z;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.apM);
        bitSet.set(0, this.apM, true);
        char c2 = (this.mOrientation != 1 || !jH()) ? (char) 65535 : 1;
        if (this.aqv) {
            i2 = -1;
        } else {
            int i3 = childCount + 1;
            childCount = 0;
            i2 = i3;
        }
        int i4 = childCount < i2 ? 1 : -1;
        for (int i5 = childCount; i5 != i2; i5 += i4) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.axf.mIndex)) {
                if (a(layoutParams.axf)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.axf.mIndex);
            }
            if (!layoutParams.axg && i5 + i4 != i2) {
                View childAt2 = getChildAt(i5 + i4);
                if (this.aqv) {
                    int bp = this.awN.bp(childAt);
                    int bp2 = this.awN.bp(childAt2);
                    if (bp < bp2) {
                        return childAt;
                    }
                    if (bp == bp2) {
                        z = true;
                    }
                    z = false;
                } else {
                    int bo = this.awN.bo(childAt);
                    int bo2 = this.awN.bo(childAt2);
                    if (bo > bo2) {
                        return childAt;
                    }
                    if (bo == bo2) {
                        z = true;
                    }
                    z = false;
                }
                if (!z) {
                    continue;
                } else {
                    if ((layoutParams.axf.mIndex - ((LayoutParams) childAt2.getLayoutParams()).axf.mIndex < 0) != (c2 < 0)) {
                        return childAt;
                    }
                }
            }
        }
        return null;
    }

    private boolean a(b bVar) {
        if (this.aqv) {
            if (bVar.mO() < this.awN.kI()) {
                return !((LayoutParams) bVar.axq.get(bVar.axq.size() + -1).getLayoutParams()).axg;
            }
        } else if (bVar.mM() > this.awN.kH()) {
            return !((LayoutParams) bVar.axq.get(0).getLayoutParams()).axg;
        }
        return false;
    }

    private void bW(int i2) {
        assertNotInLayoutOrScroll(null);
        if (i2 != this.apM) {
            this.awS.clear();
            requestLayout();
            this.apM = i2;
            this.awR = new BitSet(this.apM);
            this.awM = new b[this.apM];
            for (int i3 = 0; i3 < this.apM; i3++) {
                this.awM[i3] = new b(i3);
            }
            requestLayout();
        }
    }

    private void ao(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (!(this.awW == null || this.awW.aqu == z)) {
            this.awW.aqu = z;
        }
        this.aqu = z;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.awW == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public final int ki() {
        return this.apM;
    }

    private void kl() {
        boolean z = true;
        if (this.mOrientation == 1 || !jH()) {
            z = this.aqu;
        } else if (this.aqu) {
            z = false;
        }
        this.aqv = z;
    }

    private boolean jH() {
        return getLayoutDirection() == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = chooseSize(i3, paddingTop + rect.height(), getMinimumHeight());
            chooseSize = chooseSize(i2, paddingRight + (this.awP * this.apM), getMinimumWidth());
        } else {
            chooseSize = chooseSize(i2, paddingRight + rect.width(), getMinimumWidth());
            chooseSize2 = chooseSize(i3, paddingTop + (this.awP * this.apM), getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        float f2;
        float f3;
        int cQ;
        boolean z;
        int i2;
        boolean z2;
        int kH;
        int mI;
        int kH2;
        boolean z3 = true;
        while (true) {
            a aVar = this.awY;
            if (!(this.awW == null && this.aqy == -1) && sVar.getItemCount() == 0) {
                removeAndRecycleAllViews(nVar);
                aVar.reset();
                return;
            }
            boolean z4 = !aVar.aqH || this.aqy != -1 || this.awW != null;
            if (z4) {
                aVar.reset();
                if (this.awW != null) {
                    if (this.awW.axm > 0) {
                        if (this.awW.axm == this.apM) {
                            for (int i3 = 0; i3 < this.apM; i3++) {
                                this.awM[i3].clear();
                                int i4 = this.awW.axn[i3];
                                if (i4 != Integer.MIN_VALUE) {
                                    if (this.awW.aqR) {
                                        i4 += this.awN.kI();
                                    } else {
                                        i4 += this.awN.kH();
                                    }
                                }
                                this.awM[i3].cS(i4);
                            }
                        } else {
                            SavedState savedState = this.awW;
                            savedState.axn = null;
                            savedState.axm = 0;
                            savedState.axo = 0;
                            savedState.axp = null;
                            savedState.axh = null;
                            this.awW.aqP = this.awW.axl;
                        }
                    }
                    this.awV = this.awW.awV;
                    ao(this.awW.aqu);
                    kl();
                    if (this.awW.aqP != -1) {
                        this.aqy = this.awW.aqP;
                        aVar.aqG = this.awW.aqR;
                    } else {
                        aVar.aqG = this.aqv;
                    }
                    if (this.awW.axo > 1) {
                        this.awS.mData = this.awW.axp;
                        this.awS.axh = this.awW.axh;
                    }
                } else {
                    kl();
                    aVar.aqG = this.aqv;
                }
                if (sVar.aue || this.aqy == -1) {
                    z = false;
                } else if (this.aqy < 0 || this.aqy >= sVar.getItemCount()) {
                    this.aqy = -1;
                    this.aqz = Integer.MIN_VALUE;
                    z = false;
                } else {
                    if (this.awW == null || this.awW.aqP == -1 || this.awW.axm <= 0) {
                        View findViewByPosition = findViewByPosition(this.aqy);
                        if (findViewByPosition != null) {
                            if (this.aqv) {
                                mI = mH();
                            } else {
                                mI = mI();
                            }
                            aVar.mPosition = mI;
                            if (this.aqz != Integer.MIN_VALUE) {
                                if (aVar.aqG) {
                                    aVar.fs = (this.awN.kI() - this.aqz) - this.awN.bp(findViewByPosition);
                                } else {
                                    aVar.fs = (this.awN.kH() + this.aqz) - this.awN.bo(findViewByPosition);
                                }
                                z = true;
                            } else if (this.awN.bs(findViewByPosition) > this.awN.kJ()) {
                                if (aVar.aqG) {
                                    kH2 = this.awN.kI();
                                } else {
                                    kH2 = this.awN.kH();
                                }
                                aVar.fs = kH2;
                            } else {
                                int bo = this.awN.bo(findViewByPosition) - this.awN.kH();
                                if (bo < 0) {
                                    aVar.fs = -bo;
                                } else {
                                    int kI = this.awN.kI() - this.awN.bp(findViewByPosition);
                                    if (kI < 0) {
                                        aVar.fs = kI;
                                    } else {
                                        aVar.fs = Integer.MIN_VALUE;
                                    }
                                }
                            }
                        } else {
                            aVar.mPosition = this.aqy;
                            if (this.aqz == Integer.MIN_VALUE) {
                                if (cH(aVar.mPosition) == 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                aVar.aqG = z2;
                                if (aVar.aqG) {
                                    kH = StaggeredGridLayoutManager.this.awN.kI();
                                } else {
                                    kH = StaggeredGridLayoutManager.this.awN.kH();
                                }
                                aVar.fs = kH;
                            } else {
                                int i5 = this.aqz;
                                if (aVar.aqG) {
                                    aVar.fs = StaggeredGridLayoutManager.this.awN.kI() - i5;
                                } else {
                                    aVar.fs = i5 + StaggeredGridLayoutManager.this.awN.kH();
                                }
                            }
                            aVar.axd = true;
                        }
                    } else {
                        aVar.fs = Integer.MIN_VALUE;
                        aVar.mPosition = this.aqy;
                    }
                    z = true;
                }
                if (!z) {
                    if (this.awU) {
                        int itemCount = sVar.getItemCount();
                        int childCount = getChildCount() - 1;
                        while (true) {
                            if (childCount < 0) {
                                i2 = 0;
                                break;
                            }
                            i2 = getPosition(getChildAt(childCount));
                            if (i2 >= 0 && i2 < itemCount) {
                                break;
                            }
                            childCount--;
                        }
                    } else {
                        int itemCount2 = sVar.getItemCount();
                        int childCount2 = getChildCount();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= childCount2) {
                                i2 = 0;
                                break;
                            }
                            i2 = getPosition(getChildAt(i6));
                            if (i2 >= 0 && i2 < itemCount2) {
                                break;
                            }
                            i6++;
                        }
                    }
                    aVar.mPosition = i2;
                    aVar.fs = Integer.MIN_VALUE;
                }
                aVar.aqH = true;
            }
            if (this.awW == null && this.aqy == -1 && !(aVar.aqG == this.awU && jH() == this.awV)) {
                this.awS.clear();
                aVar.axd = true;
            }
            if (getChildCount() > 0 && (this.awW == null || this.awW.axm <= 0)) {
                if (aVar.axd) {
                    for (int i7 = 0; i7 < this.apM; i7++) {
                        this.awM[i7].clear();
                        if (aVar.fs != Integer.MIN_VALUE) {
                            this.awM[i7].cS(aVar.fs);
                        }
                    }
                } else if (z4 || this.awY.axe == null) {
                    for (int i8 = 0; i8 < this.apM; i8++) {
                        b bVar = this.awM[i8];
                        boolean z5 = this.aqv;
                        int i9 = aVar.fs;
                        if (z5) {
                            cQ = bVar.cR(Integer.MIN_VALUE);
                        } else {
                            cQ = bVar.cQ(Integer.MIN_VALUE);
                        }
                        bVar.clear();
                        if (cQ != Integer.MIN_VALUE && ((!z5 || cQ >= StaggeredGridLayoutManager.this.awN.kI()) && (z5 || cQ <= StaggeredGridLayoutManager.this.awN.kH()))) {
                            if (i9 != Integer.MIN_VALUE) {
                                cQ += i9;
                            }
                            bVar.axs = cQ;
                            bVar.axr = cQ;
                        }
                    }
                    a aVar2 = this.awY;
                    b[] bVarArr = this.awM;
                    int length = bVarArr.length;
                    if (aVar2.axe == null || aVar2.axe.length < length) {
                        aVar2.axe = new int[StaggeredGridLayoutManager.this.awM.length];
                    }
                    for (int i10 = 0; i10 < length; i10++) {
                        aVar2.axe[i10] = bVarArr[i10].cQ(Integer.MIN_VALUE);
                    }
                } else {
                    for (int i11 = 0; i11 < this.apM; i11++) {
                        b bVar2 = this.awM[i11];
                        bVar2.clear();
                        bVar2.cS(this.awY.axe[i11]);
                    }
                }
            }
            detachAndScrapAttachedViews(nVar);
            this.awQ.apX = false;
            this.awZ = false;
            cy(this.awO.kJ());
            a(aVar.mPosition, sVar);
            if (aVar.aqG) {
                cz(-1);
                a(nVar, this.awQ, sVar);
                cz(1);
                this.awQ.apZ = aVar.mPosition + this.awQ.aqa;
                a(nVar, this.awQ, sVar);
            } else {
                cz(1);
                a(nVar, this.awQ, sVar);
                cz(-1);
                this.awQ.apZ = aVar.mPosition + this.awQ.aqa;
                a(nVar, this.awQ, sVar);
            }
            if (this.awO.getMode() != 1073741824) {
                float f4 = 0.0f;
                int childCount3 = getChildCount();
                int i12 = 0;
                while (i12 < childCount3) {
                    View childAt = getChildAt(i12);
                    float bs = (float) this.awO.bs(childAt);
                    if (bs >= f4) {
                        if (((LayoutParams) childAt.getLayoutParams()).axg) {
                            f3 = (1.0f * bs) / ((float) this.apM);
                        } else {
                            f3 = bs;
                        }
                        f2 = Math.max(f4, f3);
                    } else {
                        f2 = f4;
                    }
                    i12++;
                    f4 = f2;
                }
                int i13 = this.awP;
                int round = Math.round(((float) this.apM) * f4);
                if (this.awO.getMode() == Integer.MIN_VALUE) {
                    round = Math.min(round, this.awO.kJ());
                }
                cy(round);
                if (this.awP != i13) {
                    for (int i14 = 0; i14 < childCount3; i14++) {
                        View childAt2 = getChildAt(i14);
                        LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                        if (!layoutParams.axg) {
                            if (!jH() || this.mOrientation != 1) {
                                int i15 = layoutParams.axf.mIndex * this.awP;
                                int i16 = layoutParams.axf.mIndex * i13;
                                if (this.mOrientation == 1) {
                                    childAt2.offsetLeftAndRight(i15 - i16);
                                } else {
                                    childAt2.offsetTopAndBottom(i15 - i16);
                                }
                            } else {
                                childAt2.offsetLeftAndRight(((-((this.apM - 1) - layoutParams.axf.mIndex)) * this.awP) - ((-((this.apM - 1) - layoutParams.axf.mIndex)) * i13));
                            }
                        }
                    }
                }
            }
            if (getChildCount() > 0) {
                if (this.aqv) {
                    a(nVar, sVar, true);
                    b(nVar, sVar, false);
                } else {
                    b(nVar, sVar, true);
                    a(nVar, sVar, false);
                }
            }
            boolean z6 = false;
            if (z3 && !sVar.aue) {
                if (this.awT != 0 && getChildCount() > 0 && (this.awZ || mC() != null)) {
                    removeCallbacks(this.axb);
                    if (mB()) {
                        z6 = true;
                    }
                }
            }
            if (sVar.aue) {
                this.awY.reset();
            }
            this.awU = aVar.aqG;
            this.awV = jH();
            if (z6) {
                this.awY.reset();
                z3 = false;
            } else {
                return;
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.awW = null;
        this.awY.reset();
    }

    private void cy(int i2) {
        this.awP = i2 / this.apM;
        this.awX = View.MeasureSpec.makeMeasureSpec(i2, this.awO.getMode());
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.awW == null;
    }

    public final int[] n(int[] iArr) {
        int f2;
        if (iArr == null) {
            iArr = new int[this.apM];
        } else if (iArr.length < this.apM) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.apM + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.apM; i2++) {
            b bVar = this.awM[i2];
            if (StaggeredGridLayoutManager.this.aqu) {
                f2 = bVar.f(bVar.axq.size() - 1, -1, false);
            } else {
                f2 = bVar.f(0, bVar.axq.size(), false);
            }
            iArr[i2] = f2;
        }
        return iArr;
    }

    public final int[] mD() {
        int f2;
        int[] iArr = new int[this.apM];
        for (int i2 = 0; i2 < this.apM; i2++) {
            b bVar = this.awM[i2];
            if (StaggeredGridLayoutManager.this.aqu) {
                f2 = bVar.f(bVar.axq.size() - 1, -1, true);
            } else {
                f2 = bVar.f(0, bVar.axq.size(), true);
            }
            iArr[i2] = f2;
        }
        return iArr;
    }

    public final int[] o(int[] iArr) {
        int f2;
        if (iArr == null) {
            iArr = new int[this.apM];
        } else if (iArr.length < this.apM) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.apM + ", array size:" + iArr.length);
        }
        for (int i2 = 0; i2 < this.apM; i2++) {
            b bVar = this.awM[i2];
            if (StaggeredGridLayoutManager.this.aqu) {
                f2 = bVar.f(0, bVar.axq.size(), false);
            } else {
                f2 = bVar.f(bVar.axq.size() - 1, -1, false);
            }
            iArr[i2] = f2;
        }
        return iArr;
    }

    public final int[] mE() {
        int f2;
        int[] iArr = new int[this.apM];
        for (int i2 = 0; i2 < this.apM; i2++) {
            b bVar = this.awM[i2];
            if (StaggeredGridLayoutManager.this.aqu) {
                f2 = bVar.f(0, bVar.axq.size(), true);
            } else {
                f2 = bVar.f(bVar.axq.size() - 1, -1, true);
            }
            iArr[i2] = f2;
        }
        return iArr;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        return c(sVar);
    }

    private int c(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        aj ajVar = this.awN;
        View aA = aA(!this.aqx);
        if (this.aqx) {
            z = false;
        }
        return aq.a(sVar, ajVar, aA, aB(z), this, this.aqx, this.aqv);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        return c(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        return d(sVar);
    }

    private int d(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        aj ajVar = this.awN;
        View aA = aA(!this.aqx);
        if (this.aqx) {
            z = false;
        }
        return aq.a(sVar, ajVar, aA, aB(z), this, this.aqx);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        return d(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        return e(sVar);
    }

    private int e(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        aj ajVar = this.awN;
        View aA = aA(!this.aqx);
        if (this.aqx) {
            z = false;
        }
        return aq.b(sVar, ajVar, aA, aB(z), this, this.aqx);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        return e(sVar);
    }

    private void a(View view, LayoutParams layoutParams) {
        if (layoutParams.axg) {
            if (this.mOrientation == 1) {
                l(view, this.awX, getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
            } else {
                l(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), this.awX);
            }
        } else if (this.mOrientation == 1) {
            l(view, getChildMeasureSpec(this.awP, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), layoutParams.height, true));
        } else {
            l(view, getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), layoutParams.width, true), getChildMeasureSpec(this.awP, getHeightMode(), 0, layoutParams.height, false));
        }
    }

    private void l(View view, int i2, int i3) {
        calculateItemDecorationsForChild(view, this.Ui);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int m = m(i2, layoutParams.leftMargin + this.Ui.left, layoutParams.rightMargin + this.Ui.right);
        int m2 = m(i3, layoutParams.topMargin + this.Ui.top, layoutParams.bottomMargin + this.Ui.bottom);
        if (shouldMeasureChild(view, m, m2, layoutParams)) {
            view.measure(m, m2);
        }
    }

    private static int m(int i2, int i3, int i4) {
        if (i3 == 0 && i4 == 0) {
            return i2;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i2) - i3) - i4), mode);
        }
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.awW = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int mI;
        View aA;
        int cQ;
        if (this.awW != null) {
            return new SavedState(this.awW);
        }
        SavedState savedState = new SavedState();
        savedState.aqu = this.aqu;
        savedState.aqR = this.awU;
        savedState.awV = this.awV;
        if (this.awS == null || this.awS.mData == null) {
            savedState.axo = 0;
        } else {
            savedState.axp = this.awS.mData;
            savedState.axo = savedState.axp.length;
            savedState.axh = this.awS.axh;
        }
        if (getChildCount() > 0) {
            if (this.awU) {
                mI = mH();
            } else {
                mI = mI();
            }
            savedState.aqP = mI;
            if (this.aqv) {
                aA = aB(true);
            } else {
                aA = aA(true);
            }
            savedState.axl = aA == null ? -1 : getPosition(aA);
            savedState.axm = this.apM;
            savedState.axn = new int[this.apM];
            for (int i2 = 0; i2 < this.apM; i2++) {
                if (this.awU) {
                    cQ = this.awM[i2].cR(Integer.MIN_VALUE);
                    if (cQ != Integer.MIN_VALUE) {
                        cQ -= this.awN.kI();
                    }
                } else {
                    cQ = this.awM[i2].cQ(Integer.MIN_VALUE);
                    if (cQ != Integer.MIN_VALUE) {
                        cQ -= this.awN.kH();
                    }
                }
                savedState.axn[i2] = cQ;
            }
        } else {
            savedState.aqP = -1;
            savedState.axl = -1;
            savedState.axm = 0;
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n nVar, RecyclerView.s sVar, View view, c cVar) {
        int kj;
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.mOrientation == 0) {
            i4 = layoutParams2.kj();
            if (layoutParams2.axg) {
                i5 = this.apM;
            }
            i2 = -1;
            kj = -1;
            i3 = i5;
        } else {
            kj = layoutParams2.kj();
            if (layoutParams2.axg) {
                i2 = this.apM;
                i3 = -1;
                i4 = -1;
            } else {
                i2 = 1;
                i3 = -1;
                i4 = -1;
            }
        }
        cVar.H(c.C0036c.a(i4, i3, kj, i2, layoutParams2.axg));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View aA = aA(false);
            View aB = aB(false);
            if (aA != null && aB != null) {
                int position = getPosition(aA);
                int position2 = getPosition(aB);
                if (position < position2) {
                    accessibilityEvent.setFromIndex(position);
                    accessibilityEvent.setToIndex(position2);
                    return;
                }
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return this.apM;
        }
        return super.getRowCountForAccessibility(nVar, sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return this.apM;
        }
        return super.getColumnCountForAccessibility(nVar, sVar);
    }

    private View aA(boolean z) {
        int kH = this.awN.kH();
        int kI = this.awN.kI();
        int childCount = getChildCount();
        View view = null;
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            int bo = this.awN.bo(childAt);
            if (this.awN.bp(childAt) > kH && bo < kI) {
                if (bo >= kH || !z) {
                    return childAt;
                }
                if (view == null) {
                    i2++;
                    view = childAt;
                }
            }
            childAt = view;
            i2++;
            view = childAt;
        }
        return view;
    }

    private View aB(boolean z) {
        int kH = this.awN.kH();
        int kI = this.awN.kI();
        View view = null;
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            int bo = this.awN.bo(childAt);
            int bp = this.awN.bp(childAt);
            if (bp > kH && bo < kI) {
                if (bp <= kI || !z) {
                    return childAt;
                }
                if (view == null) {
                    childCount--;
                    view = childAt;
                }
            }
            childAt = view;
            childCount--;
            view = childAt;
        }
        return view;
    }

    private void a(RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int kI;
        int cE = cE(Integer.MIN_VALUE);
        if (cE != Integer.MIN_VALUE && (kI = this.awN.kI() - cE) > 0) {
            int i2 = kI - (-a(-kI, nVar, sVar));
            if (z && i2 > 0) {
                this.awN.ce(i2);
            }
        }
    }

    private void b(RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int kH;
        int cD = cD(Integer.MAX_VALUE);
        if (cD != Integer.MAX_VALUE && (kH = cD - this.awN.kH()) > 0) {
            int a2 = kH - a(kH, nVar, sVar);
            if (z && a2 > 0) {
                this.awN.ce(-a2);
            }
        }
    }

    private void a(int i2, RecyclerView.s sVar) {
        int i3;
        int i4;
        int i5;
        boolean z = false;
        this.awQ.apY = 0;
        this.awQ.apZ = i2;
        if (!isSmoothScrolling() || (i5 = sVar.atO) == -1) {
            i3 = 0;
            i4 = 0;
        } else {
            if (this.aqv == (i5 < i2)) {
                i3 = this.awN.kJ();
                i4 = 0;
            } else {
                i4 = this.awN.kJ();
                i3 = 0;
            }
        }
        if (getClipToPadding()) {
            this.awQ.aqb = this.awN.kH() - i4;
            this.awQ.aqc = i3 + this.awN.kI();
        } else {
            this.awQ.aqc = i3 + this.awN.getEnd();
            this.awQ.aqb = -i4;
        }
        this.awQ.aqd = false;
        this.awQ.apX = true;
        ad adVar = this.awQ;
        if (this.awN.getMode() == 0 && this.awN.getEnd() == 0) {
            z = true;
        }
        adVar.aqe = z;
    }

    private void cz(int i2) {
        int i3 = 1;
        this.awQ.mLayoutDirection = i2;
        ad adVar = this.awQ;
        if (this.aqv != (i2 == -1)) {
            i3 = -1;
        }
        adVar.aqa = i3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i2) {
        super.offsetChildrenHorizontal(i2);
        for (int i3 = 0; i3 < this.apM; i3++) {
            this.awM[i3].cT(i2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i2) {
        super.offsetChildrenVertical(i2);
        for (int i3 = 0; i3 < this.apM; i3++) {
            this.awM[i3].cT(i2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        n(i2, i3, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        n(i2, i3, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.awS.clear();
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        n(i2, i3, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        n(i2, i3, 4);
    }

    private void n(int i2, int i3, int i4) {
        int i5;
        int i6;
        int mH = this.aqv ? mH() : mI();
        if (i4 != 8) {
            i5 = i2 + i3;
            i6 = i2;
        } else if (i2 < i3) {
            i5 = i3 + 1;
            i6 = i2;
        } else {
            i5 = i2 + 1;
            i6 = i3;
        }
        this.awS.cJ(i6);
        switch (i4) {
            case 1:
                this.awS.aG(i2, i3);
                break;
            case 2:
                this.awS.aE(i2, i3);
                break;
            case 8:
                this.awS.aE(i2, 1);
                this.awS.aG(i3, 1);
                break;
        }
        if (i5 > mH) {
            if (i6 <= (this.aqv ? mI() : mH())) {
                requestLayout();
            }
        }
    }

    private int a(RecyclerView.n nVar, ad adVar, RecyclerView.s sVar) {
        int i2;
        int kH;
        int cE;
        b bVar;
        int cQ;
        int bs;
        int i3;
        int kH2;
        int bs2;
        int i4;
        int kI;
        boolean z;
        int cR;
        this.awR.set(0, this.apM, true);
        if (this.awQ.aqe) {
            if (adVar.mLayoutDirection == 1) {
                i2 = Integer.MAX_VALUE;
            } else {
                i2 = Integer.MIN_VALUE;
            }
        } else if (adVar.mLayoutDirection == 1) {
            i2 = adVar.aqc + adVar.apY;
        } else {
            i2 = adVar.aqb - adVar.apY;
        }
        aD(adVar.mLayoutDirection, i2);
        if (this.aqv) {
            kH = this.awN.kI();
        } else {
            kH = this.awN.kH();
        }
        boolean z2 = false;
        while (adVar.a(sVar) && (this.awQ.aqe || !this.awR.isEmpty())) {
            View a2 = adVar.a(nVar);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int lQ = layoutParams.atw.lQ();
            int cK = this.awS.cK(lQ);
            boolean z3 = cK == -1;
            if (z3) {
                b a3 = layoutParams.axg ? this.awM[0] : a(adVar);
                this.awS.a(lQ, a3);
                bVar = a3;
            } else {
                bVar = this.awM[cK];
            }
            layoutParams.axf = bVar;
            if (adVar.mLayoutDirection == 1) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
            a(a2, layoutParams);
            if (adVar.mLayoutDirection == 1) {
                if (layoutParams.axg) {
                    cR = cE(kH);
                } else {
                    cR = bVar.cR(kH);
                }
                i3 = cR + this.awN.bs(a2);
                if (!z3 || !layoutParams.axg) {
                    bs = cR;
                } else {
                    LazySpanLookup.FullSpanItem cA = cA(cR);
                    cA.axi = -1;
                    cA.mPosition = lQ;
                    this.awS.a(cA);
                    bs = cR;
                }
            } else {
                if (layoutParams.axg) {
                    cQ = cD(kH);
                } else {
                    cQ = bVar.cQ(kH);
                }
                bs = cQ - this.awN.bs(a2);
                if (z3 && layoutParams.axg) {
                    LazySpanLookup.FullSpanItem cB = cB(cQ);
                    cB.axi = 1;
                    cB.mPosition = lQ;
                    this.awS.a(cB);
                }
                i3 = cQ;
            }
            if (layoutParams.axg && adVar.aqa == -1) {
                if (!z3) {
                    if (adVar.mLayoutDirection == 1) {
                        z = !mF();
                    } else {
                        z = !mG();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem cO = this.awS.cO(lQ);
                        if (cO != null) {
                            cO.axk = true;
                        }
                    }
                }
                this.awZ = true;
            }
            a(a2, layoutParams, adVar);
            if (!jH() || this.mOrientation != 1) {
                if (layoutParams.axg) {
                    kH2 = this.awO.kH();
                } else {
                    kH2 = (bVar.mIndex * this.awP) + this.awO.kH();
                }
                bs2 = kH2 + this.awO.bs(a2);
                i4 = kH2;
            } else {
                if (layoutParams.axg) {
                    kI = this.awO.kI();
                } else {
                    kI = this.awO.kI() - (((this.apM - 1) - bVar.mIndex) * this.awP);
                }
                i4 = kI - this.awO.bs(a2);
                bs2 = kI;
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(a2, i4, bs, bs2, i3);
            } else {
                layoutDecoratedWithMargins(a2, bs, i4, i3, bs2);
            }
            if (layoutParams.axg) {
                aD(this.awQ.mLayoutDirection, i2);
            } else {
                a(bVar, this.awQ.mLayoutDirection, i2);
            }
            a(nVar, this.awQ);
            if (this.awQ.aqd && a2.hasFocusable()) {
                if (layoutParams.axg) {
                    this.awR.clear();
                } else {
                    this.awR.set(bVar.mIndex, false);
                }
            }
            z2 = true;
        }
        if (!z2) {
            a(nVar, this.awQ);
        }
        if (this.awQ.mLayoutDirection == -1) {
            cE = this.awN.kH() - cD(this.awN.kH());
        } else {
            cE = cE(this.awN.kI()) - this.awN.kI();
        }
        if (cE > 0) {
            return Math.min(adVar.apY, cE);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem cA(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.axj = new int[this.apM];
        for (int i3 = 0; i3 < this.apM; i3++) {
            fullSpanItem.axj[i3] = i2 - this.awM[i3].cR(i2);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem cB(int i2) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.axj = new int[this.apM];
        for (int i3 = 0; i3 < this.apM; i3++) {
            fullSpanItem.axj[i3] = this.awM[i3].cQ(i2) - i2;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, ad adVar) {
        if (adVar.mLayoutDirection == 1) {
            if (layoutParams.axg) {
                bI(view);
            } else {
                layoutParams.axf.bL(view);
            }
        } else if (layoutParams.axg) {
            bJ(view);
        } else {
            layoutParams.axf.bK(view);
        }
    }

    private void a(RecyclerView.n nVar, ad adVar) {
        int min;
        int min2;
        if (adVar.apX && !adVar.aqe) {
            if (adVar.apY == 0) {
                if (adVar.mLayoutDirection == -1) {
                    b(nVar, adVar.aqc);
                } else {
                    a(nVar, adVar.aqb);
                }
            } else if (adVar.mLayoutDirection == -1) {
                int cC = adVar.aqb - cC(adVar.aqb);
                if (cC < 0) {
                    min2 = adVar.aqc;
                } else {
                    min2 = adVar.aqc - Math.min(cC, adVar.apY);
                }
                b(nVar, min2);
            } else {
                int cF = cF(adVar.aqc) - adVar.aqc;
                if (cF < 0) {
                    min = adVar.aqb;
                } else {
                    min = Math.min(cF, adVar.apY) + adVar.aqb;
                }
                a(nVar, min);
            }
        }
    }

    private void bI(View view) {
        for (int i2 = this.apM - 1; i2 >= 0; i2--) {
            this.awM[i2].bL(view);
        }
    }

    private void bJ(View view) {
        for (int i2 = this.apM - 1; i2 >= 0; i2--) {
            this.awM[i2].bK(view);
        }
    }

    private void aD(int i2, int i3) {
        for (int i4 = 0; i4 < this.apM; i4++) {
            if (!this.awM[i4].axq.isEmpty()) {
                a(this.awM[i4], i2, i3);
            }
        }
    }

    private void a(b bVar, int i2, int i3) {
        int i4 = bVar.axt;
        if (i2 == -1) {
            if (i4 + bVar.mM() <= i3) {
                this.awR.set(bVar.mIndex, false);
            }
        } else if (bVar.mO() - i4 >= i3) {
            this.awR.set(bVar.mIndex, false);
        }
    }

    private int cC(int i2) {
        int cQ = this.awM[0].cQ(i2);
        for (int i3 = 1; i3 < this.apM; i3++) {
            int cQ2 = this.awM[i3].cQ(i2);
            if (cQ2 > cQ) {
                cQ = cQ2;
            }
        }
        return cQ;
    }

    private int cD(int i2) {
        int cQ = this.awM[0].cQ(i2);
        for (int i3 = 1; i3 < this.apM; i3++) {
            int cQ2 = this.awM[i3].cQ(i2);
            if (cQ2 < cQ) {
                cQ = cQ2;
            }
        }
        return cQ;
    }

    private boolean mF() {
        int cR = this.awM[0].cR(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.apM; i2++) {
            if (this.awM[i2].cR(Integer.MIN_VALUE) != cR) {
                return false;
            }
        }
        return true;
    }

    private boolean mG() {
        int cQ = this.awM[0].cQ(Integer.MIN_VALUE);
        for (int i2 = 1; i2 < this.apM; i2++) {
            if (this.awM[i2].cQ(Integer.MIN_VALUE) != cQ) {
                return false;
            }
        }
        return true;
    }

    private int cE(int i2) {
        int cR = this.awM[0].cR(i2);
        for (int i3 = 1; i3 < this.apM; i3++) {
            int cR2 = this.awM[i3].cR(i2);
            if (cR2 > cR) {
                cR = cR2;
            }
        }
        return cR;
    }

    private int cF(int i2) {
        int cR = this.awM[0].cR(i2);
        for (int i3 = 1; i3 < this.apM; i3++) {
            int cR2 = this.awM[i3].cR(i2);
            if (cR2 < cR) {
                cR = cR2;
            }
        }
        return cR;
    }

    private void a(RecyclerView.n nVar, int i2) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.awN.bp(childAt) <= i2 && this.awN.bq(childAt) <= i2) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.axg) {
                    for (int i3 = 0; i3 < this.apM; i3++) {
                        if (this.awM[i3].axq.size() == 1) {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.apM; i4++) {
                        this.awM[i4].mQ();
                    }
                } else if (layoutParams.axf.axq.size() != 1) {
                    layoutParams.axf.mQ();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, nVar);
            } else {
                return;
            }
        }
    }

    private void b(RecyclerView.n nVar, int i2) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.awN.bo(childAt) >= i2 && this.awN.br(childAt) >= i2) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.axg) {
                    for (int i3 = 0; i3 < this.apM; i3++) {
                        if (this.awM[i3].axq.size() == 1) {
                            return;
                        }
                    }
                    for (int i4 = 0; i4 < this.apM; i4++) {
                        this.awM[i4].mP();
                    }
                } else if (layoutParams.axf.axq.size() != 1) {
                    layoutParams.axf.mP();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, nVar);
            } else {
                return;
            }
        }
    }

    private boolean cG(int i2) {
        boolean z;
        if (this.mOrientation == 0) {
            if (i2 == -1) {
                z = true;
            } else {
                z = false;
            }
            return z != this.aqv;
        }
        return ((i2 == -1) == this.aqv) == jH();
    }

    private b a(ad adVar) {
        int i2;
        int i3;
        int i4;
        b bVar = null;
        if (cG(adVar.mLayoutDirection)) {
            i2 = this.apM - 1;
            i3 = -1;
            i4 = -1;
        } else {
            i2 = 0;
            i3 = 1;
            i4 = this.apM;
        }
        if (adVar.mLayoutDirection == 1) {
            int i5 = Integer.MAX_VALUE;
            int kH = this.awN.kH();
            int i6 = i2;
            while (i6 != i4) {
                b bVar2 = this.awM[i6];
                int cR = bVar2.cR(kH);
                if (cR >= i5) {
                    cR = i5;
                    bVar2 = bVar;
                }
                i6 += i3;
                i5 = cR;
                bVar = bVar2;
            }
        } else {
            int i7 = Integer.MIN_VALUE;
            int kI = this.awN.kI();
            int i8 = i2;
            while (i8 != i4) {
                b bVar3 = this.awM[i8];
                int cQ = bVar3.cQ(kI);
                if (cQ <= i7) {
                    cQ = i7;
                    bVar3 = bVar;
                }
                i8 += i3;
                i7 = cQ;
                bVar = bVar3;
            }
        }
        return bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return a(i2, nVar, sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return a(i2, nVar, sVar);
    }

    private int cH(int i2) {
        if (getChildCount() == 0) {
            return this.aqv ? 1 : -1;
        }
        return (i2 < mI()) != this.aqv ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.r.b
    public final PointF bZ(int i2) {
        int cH = cH(i2);
        PointF pointF = new PointF();
        if (cH == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = (float) cH;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = (float) cH;
        return pointF;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        ae aeVar = new ae(recyclerView.getContext());
        aeVar.atO = i2;
        startSmoothScroll(aeVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        if (!(this.awW == null || this.awW.aqP == i2)) {
            this.awW.mK();
        }
        this.aqy = i2;
        this.aqz = Integer.MIN_VALUE;
        requestLayout();
    }

    public void ah(int i2, int i3) {
        if (this.awW != null) {
            this.awW.mK();
        }
        this.aqy = i2;
        this.aqz = i3;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.s sVar, RecyclerView.LayoutManager.a aVar) {
        int cR;
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (!(getChildCount() == 0 || i2 == 0)) {
            b(i2, sVar);
            if (this.axa == null || this.axa.length < this.apM) {
                this.axa = new int[this.apM];
            }
            int i4 = 0;
            for (int i5 = 0; i5 < this.apM; i5++) {
                if (this.awQ.aqa == -1) {
                    cR = this.awQ.aqb - this.awM[i5].cQ(this.awQ.aqb);
                } else {
                    cR = this.awM[i5].cR(this.awQ.aqc) - this.awQ.aqc;
                }
                if (cR >= 0) {
                    this.axa[i4] = cR;
                    i4++;
                }
            }
            Arrays.sort(this.axa, 0, i4);
            for (int i6 = 0; i6 < i4 && this.awQ.a(sVar); i6++) {
                aVar.S(this.awQ.apZ, this.axa[i6]);
                this.awQ.apZ += this.awQ.aqa;
            }
        }
    }

    private void b(int i2, RecyclerView.s sVar) {
        int i3;
        int mI;
        if (i2 > 0) {
            mI = mH();
            i3 = 1;
        } else {
            i3 = -1;
            mI = mI();
        }
        this.awQ.apX = true;
        a(mI, sVar);
        cz(i3);
        ad adVar = this.awQ;
        adVar.apZ = mI + adVar.aqa;
        this.awQ.apY = Math.abs(i2);
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        b(i2, sVar);
        int a2 = a(nVar, this.awQ, sVar);
        if (this.awQ.apY >= a2) {
            if (i2 < 0) {
                i2 = -a2;
            } else {
                i2 = a2;
            }
        }
        this.awN.ce(-i2);
        this.awU = this.aqv;
        this.awQ.apY = 0;
        a(nVar, this.awQ);
        return i2;
    }

    private int mH() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int mI() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final int getOrientation() {
        return this.mOrientation;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        View findContainingItemView;
        int i3;
        int mI;
        int mS;
        int mS2;
        int mS3;
        View aJ;
        if (getChildCount() == 0 || (findContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        kl();
        switch (i2) {
            case 1:
                if (this.mOrientation != 1) {
                    if (jH()) {
                        i3 = 1;
                        break;
                    } else {
                        i3 = -1;
                        break;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            case 2:
                if (this.mOrientation != 1) {
                    if (jH()) {
                        i3 = -1;
                        break;
                    } else {
                        i3 = 1;
                        break;
                    }
                } else {
                    i3 = 1;
                    break;
                }
            case 17:
                if (this.mOrientation == 0) {
                    i3 = -1;
                    break;
                } else {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
            case 33:
                if (this.mOrientation == 1) {
                    i3 = -1;
                    break;
                } else {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
            case 66:
                if (this.mOrientation == 0) {
                    i3 = 1;
                    break;
                } else {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
            case 130:
                if (this.mOrientation == 1) {
                    i3 = 1;
                    break;
                } else {
                    i3 = Integer.MIN_VALUE;
                    break;
                }
            default:
                i3 = Integer.MIN_VALUE;
                break;
        }
        if (i3 == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        boolean z = layoutParams.axg;
        b bVar = layoutParams.axf;
        if (i3 == 1) {
            mI = mH();
        } else {
            mI = mI();
        }
        a(mI, sVar);
        cz(i3);
        ad adVar = this.awQ;
        adVar.apZ = adVar.aqa + mI;
        this.awQ.apY = (int) (0.33333334f * ((float) this.awN.kJ()));
        this.awQ.aqd = true;
        this.awQ.apX = false;
        a(nVar, this.awQ, sVar);
        this.awU = this.aqv;
        if (!(z || (aJ = bVar.aJ(mI, i3)) == null || aJ == findContainingItemView)) {
            return aJ;
        }
        if (cG(i3)) {
            for (int i4 = this.apM - 1; i4 >= 0; i4--) {
                View aJ2 = this.awM[i4].aJ(mI, i3);
                if (!(aJ2 == null || aJ2 == findContainingItemView)) {
                    return aJ2;
                }
            }
        } else {
            for (int i5 = 0; i5 < this.apM; i5++) {
                View aJ3 = this.awM[i5].aJ(mI, i3);
                if (!(aJ3 == null || aJ3 == findContainingItemView)) {
                    return aJ3;
                }
            }
        }
        boolean z2 = (!this.aqu) == (i3 == -1);
        if (!z) {
            if (z2) {
                mS3 = bVar.mR();
            } else {
                mS3 = bVar.mS();
            }
            View findViewByPosition = findViewByPosition(mS3);
            if (!(findViewByPosition == null || findViewByPosition == findContainingItemView)) {
                return findViewByPosition;
            }
        }
        if (cG(i3)) {
            for (int i6 = this.apM - 1; i6 >= 0; i6--) {
                if (i6 != bVar.mIndex) {
                    if (z2) {
                        mS2 = this.awM[i6].mR();
                    } else {
                        mS2 = this.awM[i6].mS();
                    }
                    View findViewByPosition2 = findViewByPosition(mS2);
                    if (!(findViewByPosition2 == null || findViewByPosition2 == findContainingItemView)) {
                        return findViewByPosition2;
                    }
                }
            }
        } else {
            for (int i7 = 0; i7 < this.apM; i7++) {
                if (z2) {
                    mS = this.awM[i7].mR();
                } else {
                    mS = this.awM[i7].mS();
                }
                View findViewByPosition3 = findViewByPosition(mS);
                if (!(findViewByPosition3 == null || findViewByPosition3 == findContainingItemView)) {
                    return findViewByPosition3;
                }
            }
        }
        return null;
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        b axf;
        boolean axg;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public final void aC(boolean z) {
            this.axg = z;
        }

        public final boolean mJ() {
            return this.axg;
        }

        public final int kj() {
            if (this.axf == null) {
                return -1;
            }
            return this.axf.mIndex;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        ArrayList<View> axq = new ArrayList<>();
        int axr = Integer.MIN_VALUE;
        int axs = Integer.MIN_VALUE;
        int axt = 0;
        final int mIndex;

        b(int i2) {
            this.mIndex = i2;
        }

        /* access modifiers changed from: package-private */
        public final int cQ(int i2) {
            if (this.axr != Integer.MIN_VALUE) {
                return this.axr;
            }
            if (this.axq.size() == 0) {
                return i2;
            }
            mL();
            return this.axr;
        }

        private void mL() {
            LazySpanLookup.FullSpanItem cO;
            View view = this.axq.get(0);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.axr = StaggeredGridLayoutManager.this.awN.bo(view);
            if (layoutParams.axg && (cO = StaggeredGridLayoutManager.this.awS.cO(layoutParams.atw.lQ())) != null && cO.axi == -1) {
                this.axr -= cO.cP(this.mIndex);
            }
        }

        /* access modifiers changed from: package-private */
        public final int mM() {
            if (this.axr != Integer.MIN_VALUE) {
                return this.axr;
            }
            mL();
            return this.axr;
        }

        /* access modifiers changed from: package-private */
        public final int cR(int i2) {
            if (this.axs != Integer.MIN_VALUE) {
                return this.axs;
            }
            if (this.axq.size() == 0) {
                return i2;
            }
            mN();
            return this.axs;
        }

        private void mN() {
            LazySpanLookup.FullSpanItem cO;
            View view = this.axq.get(this.axq.size() - 1);
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            this.axs = StaggeredGridLayoutManager.this.awN.bp(view);
            if (layoutParams.axg && (cO = StaggeredGridLayoutManager.this.awS.cO(layoutParams.atw.lQ())) != null && cO.axi == 1) {
                this.axs = cO.cP(this.mIndex) + this.axs;
            }
        }

        /* access modifiers changed from: package-private */
        public final int mO() {
            if (this.axs != Integer.MIN_VALUE) {
                return this.axs;
            }
            mN();
            return this.axs;
        }

        /* access modifiers changed from: package-private */
        public final void bK(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.axf = this;
            this.axq.add(0, view);
            this.axr = Integer.MIN_VALUE;
            if (this.axq.size() == 1) {
                this.axs = Integer.MIN_VALUE;
            }
            if (layoutParams.atw.isRemoved() || layoutParams.atw.mh()) {
                this.axt += StaggeredGridLayoutManager.this.awN.bs(view);
            }
        }

        /* access modifiers changed from: package-private */
        public final void bL(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.axf = this;
            this.axq.add(view);
            this.axs = Integer.MIN_VALUE;
            if (this.axq.size() == 1) {
                this.axr = Integer.MIN_VALUE;
            }
            if (layoutParams.atw.isRemoved() || layoutParams.atw.mh()) {
                this.axt += StaggeredGridLayoutManager.this.awN.bs(view);
            }
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            this.axq.clear();
            hw();
            this.axt = 0;
        }

        private void hw() {
            this.axr = Integer.MIN_VALUE;
            this.axs = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void cS(int i2) {
            this.axr = i2;
            this.axs = i2;
        }

        /* access modifiers changed from: package-private */
        public final void mP() {
            int size = this.axq.size();
            View remove = this.axq.remove(size - 1);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.axf = null;
            if (layoutParams.atw.isRemoved() || layoutParams.atw.mh()) {
                this.axt -= StaggeredGridLayoutManager.this.awN.bs(remove);
            }
            if (size == 1) {
                this.axr = Integer.MIN_VALUE;
            }
            this.axs = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void mQ() {
            View remove = this.axq.remove(0);
            LayoutParams layoutParams = (LayoutParams) remove.getLayoutParams();
            layoutParams.axf = null;
            if (this.axq.size() == 0) {
                this.axs = Integer.MIN_VALUE;
            }
            if (layoutParams.atw.isRemoved() || layoutParams.atw.mh()) {
                this.axt -= StaggeredGridLayoutManager.this.awN.bs(remove);
            }
            this.axr = Integer.MIN_VALUE;
        }

        /* access modifiers changed from: package-private */
        public final void cT(int i2) {
            if (this.axr != Integer.MIN_VALUE) {
                this.axr += i2;
            }
            if (this.axs != Integer.MIN_VALUE) {
                this.axs += i2;
            }
        }

        public final int mR() {
            if (StaggeredGridLayoutManager.this.aqu) {
                return aI(this.axq.size() - 1, -1);
            }
            return aI(0, this.axq.size());
        }

        public final int mS() {
            if (StaggeredGridLayoutManager.this.aqu) {
                return aI(0, this.axq.size());
            }
            return aI(this.axq.size() - 1, -1);
        }

        private int a(int i2, int i3, boolean z, boolean z2, boolean z3) {
            int kH = StaggeredGridLayoutManager.this.awN.kH();
            int kI = StaggeredGridLayoutManager.this.awN.kI();
            int i4 = i3 > i2 ? 1 : -1;
            while (i2 != i3) {
                View view = this.axq.get(i2);
                int bo = StaggeredGridLayoutManager.this.awN.bo(view);
                int bp = StaggeredGridLayoutManager.this.awN.bp(view);
                boolean z4 = z3 ? bo <= kI : bo < kI;
                boolean z5 = z3 ? bp >= kH : bp > kH;
                if (z4 && z5) {
                    if (!z || !z2) {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                        if (bo < kH || bp > kI) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else if (bo >= kH && bp <= kI) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i2 += i4;
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public final int f(int i2, int i3, boolean z) {
            return a(i2, i3, z, true, false);
        }

        private int aI(int i2, int i3) {
            return a(i2, i3, false, false, true);
        }

        public final View aJ(int i2, int i3) {
            View view = null;
            if (i3 == -1) {
                int size = this.axq.size();
                int i4 = 0;
                while (i4 < size) {
                    View view2 = this.axq.get(i4);
                    if ((StaggeredGridLayoutManager.this.aqu && StaggeredGridLayoutManager.this.getPosition(view2) <= i2) || ((!StaggeredGridLayoutManager.this.aqu && StaggeredGridLayoutManager.this.getPosition(view2) >= i2) || !view2.hasFocusable())) {
                        break;
                    }
                    i4++;
                    view = view2;
                }
                return view;
            }
            int size2 = this.axq.size() - 1;
            while (size2 >= 0) {
                View view3 = this.axq.get(size2);
                if ((StaggeredGridLayoutManager.this.aqu && StaggeredGridLayoutManager.this.getPosition(view3) >= i2) || ((!StaggeredGridLayoutManager.this.aqu && StaggeredGridLayoutManager.this.getPosition(view3) <= i2) || !view3.hasFocusable())) {
                    break;
                }
                size2--;
                view = view3;
            }
            return view;
        }
    }

    /* access modifiers changed from: package-private */
    public static class LazySpanLookup {
        List<FullSpanItem> axh;
        int[] mData;

        LazySpanLookup() {
        }

        /* access modifiers changed from: package-private */
        public final int cI(int i2) {
            if (this.axh != null) {
                for (int size = this.axh.size() - 1; size >= 0; size--) {
                    if (this.axh.get(size).mPosition >= i2) {
                        this.axh.remove(size);
                    }
                }
            }
            return cJ(i2);
        }

        /* access modifiers changed from: package-private */
        public final int cJ(int i2) {
            if (this.mData == null || i2 >= this.mData.length) {
                return -1;
            }
            int cN = cN(i2);
            if (cN == -1) {
                int[] iArr = this.mData;
                Arrays.fill(iArr, i2, iArr.length, -1);
                return this.mData.length;
            }
            Arrays.fill(this.mData, i2, cN + 1, -1);
            return cN + 1;
        }

        /* access modifiers changed from: package-private */
        public final int cK(int i2) {
            if (this.mData == null || i2 >= this.mData.length) {
                return -1;
            }
            return this.mData[i2];
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, b bVar) {
            cM(i2);
            this.mData[i2] = bVar.mIndex;
        }

        private int cL(int i2) {
            int length = this.mData.length;
            while (length <= i2) {
                length *= 2;
            }
            return length;
        }

        private void cM(int i2) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i2, 10) + 1)];
                Arrays.fill(this.mData, -1);
            } else if (i2 >= this.mData.length) {
                int[] iArr = this.mData;
                this.mData = new int[cL(i2)];
                System.arraycopy(iArr, 0, this.mData, 0, iArr.length);
                Arrays.fill(this.mData, iArr.length, this.mData.length, -1);
            }
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.axh = null;
        }

        /* access modifiers changed from: package-private */
        public final void aE(int i2, int i3) {
            if (this.mData != null && i2 < this.mData.length) {
                cM(i2 + i3);
                int[] iArr = this.mData;
                System.arraycopy(this.mData, i2 + i3, iArr, i2, (iArr.length - i2) - i3);
                Arrays.fill(this.mData, this.mData.length - i3, this.mData.length, -1);
                aF(i2, i3);
            }
        }

        private void aF(int i2, int i3) {
            if (this.axh != null) {
                int i4 = i2 + i3;
                for (int size = this.axh.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.axh.get(size);
                    if (fullSpanItem.mPosition >= i2) {
                        if (fullSpanItem.mPosition < i4) {
                            this.axh.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i3;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void aG(int i2, int i3) {
            if (this.mData != null && i2 < this.mData.length) {
                cM(i2 + i3);
                int[] iArr = this.mData;
                System.arraycopy(iArr, i2, iArr, i2 + i3, (this.mData.length - i2) - i3);
                Arrays.fill(this.mData, i2, i2 + i3, -1);
                aH(i2, i3);
            }
        }

        private void aH(int i2, int i3) {
            if (this.axh != null) {
                for (int size = this.axh.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.axh.get(size);
                    if (fullSpanItem.mPosition >= i2) {
                        fullSpanItem.mPosition += i3;
                    }
                }
            }
        }

        private int cN(int i2) {
            if (this.axh == null) {
                return -1;
            }
            FullSpanItem cO = cO(i2);
            if (cO != null) {
                this.axh.remove(cO);
            }
            int size = this.axh.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    i3 = -1;
                    break;
                } else if (this.axh.get(i3).mPosition >= i2) {
                    break;
                } else {
                    i3++;
                }
            }
            if (i3 == -1) {
                return -1;
            }
            this.axh.remove(i3);
            return this.axh.get(i3).mPosition;
        }

        public final void a(FullSpanItem fullSpanItem) {
            if (this.axh == null) {
                this.axh = new ArrayList();
            }
            int size = this.axh.size();
            for (int i2 = 0; i2 < size; i2++) {
                FullSpanItem fullSpanItem2 = this.axh.get(i2);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.axh.remove(i2);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.axh.add(i2, fullSpanItem);
                    return;
                }
            }
            this.axh.add(fullSpanItem);
        }

        public final FullSpanItem cO(int i2) {
            if (this.axh == null) {
                return null;
            }
            for (int size = this.axh.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.axh.get(size);
                if (fullSpanItem.mPosition == i2) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public final FullSpanItem o(int i2, int i3, int i4) {
            if (this.axh == null) {
                return null;
            }
            int size = this.axh.size();
            for (int i5 = 0; i5 < size; i5++) {
                FullSpanItem fullSpanItem = this.axh.get(i5);
                if (fullSpanItem.mPosition >= i3) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i2 && (i4 == 0 || fullSpanItem.axi == i4 || fullSpanItem.axk)) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() {
                /* class android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ FullSpanItem[] newArray(int i2) {
                    return new FullSpanItem[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }
            };
            int axi;
            int[] axj;
            boolean axk;
            int mPosition;

            FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.mPosition = parcel.readInt();
                this.axi = parcel.readInt();
                this.axk = parcel.readInt() != 1 ? false : z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.axj = new int[readInt];
                    parcel.readIntArray(this.axj);
                }
            }

            FullSpanItem() {
            }

            /* access modifiers changed from: package-private */
            public final int cP(int i2) {
                if (this.axj == null) {
                    return 0;
                }
                return this.axj[i2];
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.axi);
                parcel.writeInt(this.axk ? 1 : 0);
                if (this.axj == null || this.axj.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.axj.length);
                parcel.writeIntArray(this.axj);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.axi + ", mHasUnwantedGapAfter=" + this.axk + ", mGapPerSpan=" + Arrays.toString(this.axj) + '}';
            }
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.v7.widget.StaggeredGridLayoutManager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        int aqP;
        boolean aqR;
        boolean aqu;
        boolean awV;
        List<LazySpanLookup.FullSpanItem> axh;
        int axl;
        int axm;
        int[] axn;
        int axo;
        int[] axp;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            this.aqP = parcel.readInt();
            this.axl = parcel.readInt();
            this.axm = parcel.readInt();
            if (this.axm > 0) {
                this.axn = new int[this.axm];
                parcel.readIntArray(this.axn);
            }
            this.axo = parcel.readInt();
            if (this.axo > 0) {
                this.axp = new int[this.axo];
                parcel.readIntArray(this.axp);
            }
            this.aqu = parcel.readInt() == 1;
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.aqR = z;
            this.awV = parcel.readInt() != 1 ? false : z2;
            this.axh = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.axm = savedState.axm;
            this.aqP = savedState.aqP;
            this.axl = savedState.axl;
            this.axn = savedState.axn;
            this.axo = savedState.axo;
            this.axp = savedState.axp;
            this.aqu = savedState.aqu;
            this.aqR = savedState.aqR;
            this.awV = savedState.awV;
            this.axh = savedState.axh;
        }

        /* access modifiers changed from: package-private */
        public final void mK() {
            this.axn = null;
            this.axm = 0;
            this.aqP = -1;
            this.axl = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4;
            int i5 = 1;
            parcel.writeInt(this.aqP);
            parcel.writeInt(this.axl);
            parcel.writeInt(this.axm);
            if (this.axm > 0) {
                parcel.writeIntArray(this.axn);
            }
            parcel.writeInt(this.axo);
            if (this.axo > 0) {
                parcel.writeIntArray(this.axp);
            }
            if (this.aqu) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            if (this.aqR) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            parcel.writeInt(i4);
            if (!this.awV) {
                i5 = 0;
            }
            parcel.writeInt(i5);
            parcel.writeList(this.axh);
        }
    }

    class a {
        boolean aqG;
        boolean aqH;
        boolean axd;
        int[] axe;
        int fs;
        int mPosition;

        a() {
            reset();
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.mPosition = -1;
            this.fs = Integer.MIN_VALUE;
            this.aqG = false;
            this.axd = false;
            this.aqH = false;
            if (this.axe != null) {
                Arrays.fill(this.axe, -1);
            }
        }
    }
}
