package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.a.c;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    boolean apL = false;
    public int apM = -1;
    int[] apN;
    View[] apO;
    final SparseIntArray apP = new SparseIntArray();
    final SparseIntArray apQ = new SparseIntArray();
    public b apR = new a();
    final Rect apS = new Rect();

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        bW(getProperties(context, attributeSet, i2, i3).att);
    }

    public GridLayoutManager(int i2) {
        bW(i2);
    }

    public GridLayoutManager(int i2, int i3) {
        super(i3, false);
        bW(i2);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void an(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.an(false);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return this.apM;
        }
        if (sVar.getItemCount() <= 0) {
            return 0;
        }
        return a(nVar, sVar, sVar.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return this.apM;
        }
        if (sVar.getItemCount() <= 0) {
            return 0;
        }
        return a(nVar, sVar, sVar.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.n nVar, RecyclerView.s sVar, View view, c cVar) {
        boolean z;
        boolean z2 = false;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a2 = a(nVar, sVar, layoutParams2.atw.lQ());
        if (this.mOrientation == 0) {
            int i2 = layoutParams2.apT;
            int i3 = layoutParams2.apU;
            if (this.apM <= 1 || layoutParams2.apU != this.apM) {
                z = false;
            } else {
                z = true;
            }
            cVar.H(c.C0036c.a(i2, i3, a2, 1, z));
            return;
        }
        int i4 = layoutParams2.apT;
        int i5 = layoutParams2.apU;
        if (this.apM > 1 && layoutParams2.apU == this.apM) {
            z2 = true;
        }
        cVar.H(c.C0036c.a(a2, 1, i4, i5, z2));
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.apL = false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        this.apR.apV.clear();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.apR.apV.clear();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        this.apR.apV.clear();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.apR.apV.clear();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.apR.apV.clear();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
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

    public final void a(b bVar) {
        this.apR = bVar;
    }

    public final b kf() {
        return this.apR;
    }

    private void kg() {
        int height;
        if (getOrientation() == 1) {
            height = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        bV(height);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int chooseSize;
        int chooseSize2;
        if (this.apN == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = chooseSize(i3, paddingTop + rect.height(), getMinimumHeight());
            chooseSize = chooseSize(i2, paddingRight + this.apN[this.apN.length - 1], getMinimumWidth());
        } else {
            chooseSize = chooseSize(i2, paddingRight + rect.width(), getMinimumWidth());
            chooseSize2 = chooseSize(i3, paddingTop + this.apN[this.apN.length - 1], getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    private void bV(int i2) {
        this.apN = d(this.apN, this.apM, i2);
    }

    private static int[] d(int[] iArr, int i2, int i3) {
        int i4;
        if (!(iArr != null && iArr.length == i2 + 1 && iArr[iArr.length - 1] == i3)) {
            iArr = new int[(i2 + 1)];
        }
        iArr[0] = 0;
        int i5 = i3 / i2;
        int i6 = i3 % i2;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i7 <= i2) {
            i8 += i6;
            if (i8 <= 0 || i2 - i8 >= i6) {
                i4 = i5;
            } else {
                i4 = i5 + 1;
                i8 -= i2;
            }
            int i10 = i9 + i4;
            iArr[i7] = i10;
            i7++;
            i9 = i10;
        }
        return iArr;
    }

    private int Y(int i2, int i3) {
        if (this.mOrientation != 1 || !jH()) {
            return this.apN[i2 + i3] - this.apN[i2];
        }
        return this.apN[this.apM - i2] - this.apN[(this.apM - i2) - i3];
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.LinearLayoutManager
    public final void a(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.a aVar, int i2) {
        boolean z = true;
        super.a(nVar, sVar, aVar, i2);
        kg();
        if (sVar.getItemCount() > 0 && !sVar.aue) {
            if (i2 != 1) {
                z = false;
            }
            int b2 = b(nVar, sVar, aVar.mPosition);
            if (z) {
                while (b2 > 0 && aVar.mPosition > 0) {
                    aVar.mPosition--;
                    b2 = b(nVar, sVar, aVar.mPosition);
                }
            } else {
                int itemCount = sVar.getItemCount() - 1;
                int i3 = aVar.mPosition;
                while (i3 < itemCount) {
                    int b3 = b(nVar, sVar, i3 + 1);
                    if (b3 <= b2) {
                        break;
                    }
                    i3++;
                    b2 = b3;
                }
                aVar.mPosition = i3;
            }
        }
        kh();
    }

    private void kh() {
        if (this.apO == null || this.apO.length != this.apM) {
            this.apO = new View[this.apM];
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        kg();
        kh();
        return super.scrollHorizontallyBy(i2, nVar, sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        kg();
        kh();
        return super.scrollVerticallyBy(i2, nVar, sVar);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.LinearLayoutManager
    public final View a(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3, int i4) {
        int i5;
        View view;
        km();
        int kH = this.aqs.kH();
        int kI = this.aqs.kI();
        if (i3 > i2) {
            i5 = 1;
        } else {
            i5 = -1;
        }
        View view2 = null;
        View view3 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4 && b(nVar, sVar, position) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).atw.isRemoved()) {
                    if (view3 == null) {
                        view = view2;
                        view3 = childAt;
                        i2 += i5;
                        view2 = view;
                    }
                } else if (this.aqs.bo(childAt) < kI && this.aqs.bp(childAt) >= kH) {
                    return childAt;
                } else {
                    if (view2 == null) {
                        view = childAt;
                        i2 += i5;
                        view2 = view;
                    }
                }
            }
            view = view2;
            i2 += i5;
            view2 = view;
        }
        return view2 != null ? view2 : view3;
    }

    private int b(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.aue) {
            return this.apR.ab(i2, this.apM);
        }
        int i3 = this.apQ.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int co = nVar.co(i2);
        if (co == -1) {
            return 0;
        }
        return this.apR.ab(co, this.apM);
    }

    private int c(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.aue) {
            return this.apR.bX(i2);
        }
        int i3 = this.apP.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int co = nVar.co(i2);
        if (co == -1) {
            return 1;
        }
        return this.apR.bX(co);
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.LinearLayoutManager
    public final void a(RecyclerView.s sVar, LinearLayoutManager.c cVar, RecyclerView.LayoutManager.a aVar) {
        int i2 = this.apM;
        for (int i3 = 0; i3 < this.apM && cVar.a(sVar) && i2 > 0; i3++) {
            int i4 = cVar.apZ;
            aVar.S(i4, Math.max(0, cVar.aqK));
            i2 -= this.apR.bX(i4);
            cVar.apZ += cVar.aqa;
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.LinearLayoutManager
    public final void a(RecyclerView.n nVar, RecyclerView.s sVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int i3;
        int childMeasureSpec;
        int i4;
        View a2;
        int kK = this.aqs.kK();
        boolean z = kK != 1073741824;
        int i5 = getChildCount() > 0 ? this.apN[this.apM] : 0;
        if (z) {
            kg();
        }
        boolean z2 = cVar.aqa == 1;
        int i6 = 0;
        int i7 = this.apM;
        if (!z2) {
            i7 = b(nVar, sVar, cVar.apZ) + c(nVar, sVar, cVar.apZ);
        }
        while (i6 < this.apM && cVar.a(sVar) && i7 > 0) {
            int i8 = cVar.apZ;
            int c2 = c(nVar, sVar, i8);
            if (c2 <= this.apM) {
                i7 -= c2;
                if (i7 < 0 || (a2 = cVar.a(nVar)) == null) {
                    break;
                }
                this.apO[i6] = a2;
                i6++;
            } else {
                throw new IllegalArgumentException("Item at position " + i8 + " requires " + c2 + " spans but GridLayoutManager has only " + this.apM + " spans.");
            }
        }
        if (i6 == 0) {
            bVar.mFinished = true;
            return;
        }
        int i9 = 0;
        float f2 = 0.0f;
        a(nVar, sVar, i6, z2);
        int i10 = 0;
        while (i10 < i6) {
            View view = this.apO[i10];
            if (cVar.aqO == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.apS);
            b(view, kK, false);
            int bs = this.aqs.bs(view);
            if (bs > i9) {
                i9 = bs;
            }
            float bt = (((float) this.aqs.bt(view)) * 1.0f) / ((float) ((LayoutParams) view.getLayoutParams()).apU);
            if (bt <= f2) {
                bt = f2;
            }
            i10++;
            f2 = bt;
        }
        if (z) {
            bV(Math.max(Math.round(((float) this.apM) * f2), i5));
            i2 = 0;
            int i11 = 0;
            while (i11 < i6) {
                View view2 = this.apO[i11];
                b(view2, 1073741824, true);
                int bs2 = this.aqs.bs(view2);
                if (bs2 <= i2) {
                    bs2 = i2;
                }
                i11++;
                i2 = bs2;
            }
        } else {
            i2 = i9;
        }
        for (int i12 = 0; i12 < i6; i12++) {
            View view3 = this.apO[i12];
            if (this.aqs.bs(view3) != i2) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.apS;
                int i13 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i14 = rect.right + rect.left + layoutParams.leftMargin + layoutParams.rightMargin;
                int Y = Y(layoutParams.apT, layoutParams.apU);
                if (this.mOrientation == 1) {
                    i4 = getChildMeasureSpec(Y, 1073741824, i14, layoutParams.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2 - i13, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2 - i14, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(Y, 1073741824, i13, layoutParams.height, false);
                    i4 = makeMeasureSpec;
                }
                a(view3, i4, childMeasureSpec, true);
            }
        }
        bVar.aqI = i2;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        if (this.mOrientation == 1) {
            if (cVar.mLayoutDirection == -1) {
                int i18 = cVar.fs;
                i17 = i18 - i2;
                i3 = i18;
            } else {
                int i19 = cVar.fs;
                i3 = i2 + i19;
                i17 = i19;
            }
        } else if (cVar.mLayoutDirection == -1) {
            i16 = cVar.fs;
            i15 = i16 - i2;
            i3 = 0;
        } else {
            i15 = cVar.fs;
            i16 = i15 + i2;
            i3 = 0;
        }
        int i20 = i15;
        int i21 = i3;
        for (int i22 = 0; i22 < i6; i22++) {
            View view4 = this.apO[i22];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.mOrientation != 1) {
                i17 = this.apN[layoutParams2.apT] + getPaddingTop();
                i21 = i17 + this.aqs.bt(view4);
            } else if (jH()) {
                i16 = getPaddingLeft() + this.apN[this.apM - layoutParams2.apT];
                i20 = i16 - this.aqs.bt(view4);
            } else {
                i20 = this.apN[layoutParams2.apT] + getPaddingLeft();
                i16 = i20 + this.aqs.bt(view4);
            }
            layoutDecoratedWithMargins(view4, i20, i17, i16, i21);
            if (layoutParams2.atw.isRemoved() || layoutParams2.atw.mh()) {
                bVar.aqJ = true;
            }
            bVar.adH |= view4.hasFocusable();
        }
        Arrays.fill(this.apO, (Object) null);
    }

    private void b(View view, int i2, boolean z) {
        int childMeasureSpec;
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.apS;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = layoutParams.rightMargin + rect.right + rect.left + layoutParams.leftMargin;
        int Y = Y(layoutParams.apT, layoutParams.apU);
        if (this.mOrientation == 1) {
            int childMeasureSpec2 = getChildMeasureSpec(Y, i2, i5, layoutParams.width, false);
            i3 = getChildMeasureSpec(this.aqs.kJ(), getHeightMode(), i4, layoutParams.height, true);
            childMeasureSpec = childMeasureSpec2;
        } else {
            int childMeasureSpec3 = getChildMeasureSpec(Y, i2, i4, layoutParams.height, false);
            childMeasureSpec = getChildMeasureSpec(this.aqs.kJ(), getWidthMode(), i5, layoutParams.width, true);
            i3 = childMeasureSpec3;
        }
        a(view, childMeasureSpec, i3, z);
    }

    private void a(View view, int i2, int i3, boolean z) {
        boolean shouldMeasureChild;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, i2, i3, layoutParams);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i2, i3, layoutParams);
        }
        if (shouldMeasureChild) {
            view.measure(i2, i3);
        }
    }

    private void a(RecyclerView.n nVar, RecyclerView.s sVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        if (z) {
            i4 = 1;
            i3 = 0;
        } else {
            i3 = i2 - 1;
            i4 = -1;
            i2 = -1;
        }
        while (i3 != i2) {
            View view = this.apO[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.apU = c(nVar, sVar, getPosition(view));
            layoutParams.apT = i5;
            i5 += layoutParams.apU;
            i3 += i4;
        }
    }

    public final int ki() {
        return this.apM;
    }

    public final void bW(int i2) {
        if (i2 != this.apM) {
            this.apL = true;
            if (i2 <= 0) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided ".concat(String.valueOf(i2)));
            }
            this.apM = i2;
            this.apR.apV.clear();
            requestLayout();
        }
    }

    public static abstract class b {
        final SparseIntArray apV = new SparseIntArray();
        private boolean apW = false;

        public abstract int bX(int i2);

        /* access modifiers changed from: package-private */
        public final int ab(int i2, int i3) {
            if (!this.apW) {
                return Z(i2, i3);
            }
            int i4 = this.apV.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int Z = Z(i2, i3);
            this.apV.put(i2, Z);
            return Z;
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0055  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x006b  */
        /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int Z(int r7, int r8) {
            /*
            // Method dump skipped, instructions count: 112
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.b.Z(int, int):int");
        }

        public final int ac(int i2, int i3) {
            int bX = bX(i2);
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (i4 < i2) {
                int bX2 = bX(i4);
                int i7 = i6 + bX2;
                if (i7 == i3) {
                    i5++;
                    bX2 = 0;
                } else if (i7 > i3) {
                    i5++;
                } else {
                    bX2 = i7;
                }
                i4++;
                i6 = bX2;
            }
            if (i6 + bX > i3) {
                return i5 + 1;
            }
            return i5;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public View onFocusSearchFailed(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        int i3;
        int i4;
        int childCount;
        int i5;
        int i6;
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i7 = layoutParams.apT;
        int i8 = layoutParams.apT + layoutParams.apU;
        if (super.onFocusSearchFailed(view, i2, nVar, sVar) == null) {
            return null;
        }
        if ((cb(i2) == 1) != this.aqv) {
            i3 = getChildCount() - 1;
            i4 = -1;
            childCount = -1;
        } else {
            i3 = 0;
            i4 = 1;
            childCount = getChildCount();
        }
        boolean z = this.mOrientation == 1 && jH();
        View view2 = null;
        int i9 = -1;
        int i10 = 0;
        View view3 = null;
        int i11 = -1;
        int i12 = 0;
        int a2 = a(nVar, sVar, i3);
        for (int i13 = i3; i13 != childCount; i13 += i4) {
            int a3 = a(nVar, sVar, i13);
            View childAt = getChildAt(i13);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || a3 == a2) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i14 = layoutParams2.apT;
                int i15 = layoutParams2.apT + layoutParams2.apU;
                if (childAt.hasFocusable() && i14 == i7 && i15 == i8) {
                    return childAt;
                }
                boolean z2 = false;
                if ((!childAt.hasFocusable() || view2 != null) && (childAt.hasFocusable() || view3 != null)) {
                    int min = Math.min(i15, i8) - Math.max(i14, i7);
                    if (childAt.hasFocusable()) {
                        if (min > i10) {
                            z2 = true;
                        } else if (min == i10) {
                            if (z == (i14 > i9)) {
                                z2 = true;
                            }
                        }
                    } else if (view2 == null && isViewPartiallyVisible(childAt, false, true)) {
                        if (min > i12) {
                            z2 = true;
                        } else if (min == i12) {
                            if (z == (i14 > i11)) {
                                z2 = true;
                            }
                        }
                    }
                } else {
                    z2 = true;
                }
                if (z2) {
                    if (childAt.hasFocusable()) {
                        i9 = layoutParams2.apT;
                        i10 = Math.min(i15, i8) - Math.max(i14, i7);
                        i5 = i12;
                        i6 = i11;
                        view2 = childAt;
                    } else {
                        i6 = layoutParams2.apT;
                        i5 = Math.min(i15, i8) - Math.max(i14, i7);
                        view3 = childAt;
                    }
                }
                i5 = i12;
                i6 = i11;
            } else {
                if (view2 != null) {
                    break;
                }
                i5 = i12;
                i6 = i11;
            }
            i12 = i5;
            i11 = i6;
        }
        return view2 != null ? view2 : view3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.aqB == null && !this.apL;
    }

    public static final class a extends b {
        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int bX(int i2) {
            return 1;
        }

        @Override // android.support.v7.widget.GridLayoutManager.b
        public final int Z(int i2, int i3) {
            return i2 % i3;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public int apT = -1;
        public int apU = 0;

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

        public final int kj() {
            return this.apT;
        }

        public final int kk() {
            return this.apU;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        if (sVar.aue) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i2).getLayoutParams();
                int lQ = layoutParams.atw.lQ();
                this.apP.put(lQ, layoutParams.apU);
                this.apQ.put(lQ, layoutParams.apT);
            }
        }
        super.onLayoutChildren(nVar, sVar);
        this.apP.clear();
        this.apQ.clear();
    }

    private int a(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        if (!sVar.aue) {
            return this.apR.ac(i2, this.apM);
        }
        int co = nVar.co(i2);
        if (co == -1) {
            return 0;
        }
        return this.apR.ac(co, this.apM);
    }
}
