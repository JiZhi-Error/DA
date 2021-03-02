package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.a.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.r.b, a.d {
    private boolean aqA;
    SavedState aqB;
    final a aqC;
    private final b aqD;
    public int aqE;
    private c aqr;
    aj aqs;
    private boolean aqt;
    private boolean aqu;
    boolean aqv;
    private boolean aqw;
    private boolean aqx;
    int aqy;
    int aqz;
    int mOrientation;

    public LinearLayoutManager() {
        this(1, false);
    }

    public LinearLayoutManager(int i2, boolean z) {
        this.mOrientation = 1;
        this.aqu = false;
        this.aqv = false;
        this.aqw = false;
        this.aqx = true;
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.aqB = null;
        this.aqC = new a();
        this.aqD = new b();
        this.aqE = 2;
        setOrientation(i2);
        ao(false);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.aqu = false;
        this.aqv = false;
        this.aqw = false;
        this.aqx = true;
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.aqB = null;
        this.aqC = new a();
        this.aqD = new b();
        this.aqE = 2;
        RecyclerView.LayoutManager.b properties = getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.orientation);
        ao(properties.atu);
        an(properties.atv);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.onDetachedFromWindow(recyclerView, nVar);
        if (this.aqA) {
            removeAndRecycleAllViews(nVar);
            nVar.clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(ks());
            accessibilityEvent.setToIndex(ku());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.aqB != null) {
            return new SavedState(this.aqB);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            km();
            boolean z = this.aqt ^ this.aqv;
            savedState.aqR = z;
            if (z) {
                View kp = kp();
                savedState.aqQ = this.aqs.kI() - this.aqs.bp(kp);
                savedState.aqP = getPosition(kp);
                return savedState;
            }
            View ko = ko();
            savedState.aqP = getPosition(ko);
            savedState.aqQ = this.aqs.bo(ko) - this.aqs.kH();
            return savedState;
        }
        savedState.aqP = -1;
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.aqB = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public void an(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.aqw != z) {
            this.aqw = z;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i2 != this.mOrientation || this.aqs == null) {
                this.aqs = aj.a(this, i2);
                this.aqC.aqs = this.aqs;
                this.mOrientation = i2;
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i2)));
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

    public void ao(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.aqu) {
            this.aqu = z;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    /* access modifiers changed from: protected */
    public int b(RecyclerView.s sVar) {
        boolean z;
        if (sVar.atO != -1) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return this.aqs.kJ();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        ae aeVar = new ae(recyclerView.getContext());
        aeVar.atO = i2;
        startSmoothScroll(aeVar);
    }

    @Override // android.support.v7.widget.RecyclerView.r.b
    public final PointF bZ(int i2) {
        int i3 = 1;
        boolean z = false;
        if (getChildCount() == 0) {
            return null;
        }
        if (i2 < getPosition(getChildAt(0))) {
            z = true;
        }
        if (z != this.aqv) {
            i3 = -1;
        }
        if (this.mOrientation == 0) {
            return new PointF((float) i3, 0.0f);
        }
        return new PointF(0.0f, (float) i3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(android.support.v7.widget.RecyclerView.n r12, android.support.v7.widget.RecyclerView.s r13) {
        /*
        // Method dump skipped, instructions count: 1202
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.LinearLayoutManager.onLayoutChildren(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$s):void");
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.aqB = null;
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.aqC.reset();
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.n nVar, RecyclerView.s sVar, a aVar, int i2) {
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int kI;
        int kI2 = this.aqs.kI() - i2;
        if (kI2 <= 0) {
            return 0;
        }
        int i3 = -a(-kI2, nVar, sVar);
        int i4 = i2 + i3;
        if (!z || (kI = this.aqs.kI() - i4) <= 0) {
            return i3;
        }
        this.aqs.ce(kI);
        return i3 + kI;
    }

    private int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int kH;
        int kH2 = i2 - this.aqs.kH();
        if (kH2 <= 0) {
            return 0;
        }
        int i3 = -a(kH2, nVar, sVar);
        int i4 = i2 + i3;
        if (!z || (kH = i4 - this.aqs.kH()) <= 0) {
            return i3;
        }
        this.aqs.ce(-kH);
        return i3 - kH;
    }

    private void a(a aVar) {
        af(aVar.mPosition, aVar.aqF);
    }

    private void af(int i2, int i3) {
        this.aqr.apY = this.aqs.kI() - i3;
        this.aqr.aqa = this.aqv ? -1 : 1;
        this.aqr.apZ = i2;
        this.aqr.mLayoutDirection = 1;
        this.aqr.fs = i3;
        this.aqr.aqK = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        ag(aVar.mPosition, aVar.aqF);
    }

    private void ag(int i2, int i3) {
        this.aqr.apY = i3 - this.aqs.kH();
        this.aqr.apZ = i2;
        this.aqr.aqa = this.aqv ? 1 : -1;
        this.aqr.mLayoutDirection = -1;
        this.aqr.fs = i3;
        this.aqr.aqK = Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean jH() {
        return getLayoutDirection() == 1;
    }

    /* access modifiers changed from: protected */
    public void km() {
        if (this.aqr == null) {
            this.aqr = new c();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        this.aqy = i2;
        this.aqz = Integer.MIN_VALUE;
        if (this.aqB != null) {
            this.aqB.aqP = -1;
        }
        requestLayout();
    }

    public void ah(int i2, int i3) {
        this.aqy = i2;
        this.aqz = i3;
        if (this.aqB != null) {
            this.aqB.aqP = -1;
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return a(i2, nVar, sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return a(i2, nVar, sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        return c(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        return c(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        return d(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        return d(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        return e(sVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        return e(sVar);
    }

    private int c(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        km();
        aj ajVar = this.aqs;
        View ap = ap(!this.aqx);
        if (this.aqx) {
            z = false;
        }
        return aq.a(sVar, ajVar, ap, aq(z), this, this.aqx, this.aqv);
    }

    private int d(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        km();
        aj ajVar = this.aqs;
        View ap = ap(!this.aqx);
        if (this.aqx) {
            z = false;
        }
        return aq.a(sVar, ajVar, ap, aq(z), this, this.aqx);
    }

    private int e(RecyclerView.s sVar) {
        boolean z = true;
        if (getChildCount() == 0) {
            return 0;
        }
        km();
        aj ajVar = this.aqs;
        View ap = ap(!this.aqx);
        if (this.aqx) {
            z = false;
        }
        return aq.b(sVar, ajVar, ap, aq(z), this, this.aqx);
    }

    private void a(int i2, int i3, boolean z, RecyclerView.s sVar) {
        int kH;
        int i4 = -1;
        int i5 = 1;
        this.aqr.aqe = kn();
        this.aqr.aqL = b(sVar);
        this.aqr.mLayoutDirection = i2;
        if (i2 == 1) {
            this.aqr.aqL += this.aqs.getEndPadding();
            View kp = kp();
            c cVar = this.aqr;
            if (!this.aqv) {
                i4 = 1;
            }
            cVar.aqa = i4;
            this.aqr.apZ = getPosition(kp) + this.aqr.aqa;
            this.aqr.fs = this.aqs.bp(kp);
            kH = this.aqs.bp(kp) - this.aqs.kI();
        } else {
            View ko = ko();
            this.aqr.aqL += this.aqs.kH();
            c cVar2 = this.aqr;
            if (!this.aqv) {
                i5 = -1;
            }
            cVar2.aqa = i5;
            this.aqr.apZ = getPosition(ko) + this.aqr.aqa;
            this.aqr.fs = this.aqs.bo(ko);
            kH = (-this.aqs.bo(ko)) + this.aqs.kH();
        }
        this.aqr.apY = i3;
        if (z) {
            this.aqr.apY -= kH;
        }
        this.aqr.aqK = kH;
    }

    private boolean kn() {
        return this.aqs.getMode() == 0 && this.aqs.getEnd() == 0;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.s sVar, c cVar, RecyclerView.LayoutManager.a aVar) {
        int i2 = cVar.apZ;
        if (i2 >= 0 && i2 < sVar.getItemCount()) {
            aVar.S(i2, Math.max(0, cVar.aqK));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int i2, RecyclerView.LayoutManager.a aVar) {
        boolean z;
        int i3;
        if (this.aqB == null || !this.aqB.ky()) {
            kl();
            z = this.aqv;
            if (this.aqy == -1) {
                i3 = z ? i2 - 1 : 0;
            } else {
                i3 = this.aqy;
            }
        } else {
            boolean z2 = this.aqB.aqR;
            i3 = this.aqB.aqP;
            z = z2;
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.aqE && i3 >= 0 && i3 < i2; i5++) {
            aVar.S(i3, 0);
            i3 += i4;
        }
    }

    public final void ca(int i2) {
        this.aqE = i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.s sVar, RecyclerView.LayoutManager.a aVar) {
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() != 0 && i2 != 0) {
            km();
            a(i2 > 0 ? 1 : -1, Math.abs(i2), true, sVar);
            a(sVar, this.aqr, aVar);
        }
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        this.aqr.apX = true;
        km();
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        a(i3, abs, true, sVar);
        int a2 = this.aqr.aqK + a(nVar, this.aqr, sVar, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i2 = i3 * a2;
        }
        this.aqs.ce(-i2);
        this.aqr.aqN = i2;
        return i2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.aqB == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void a(RecyclerView.n nVar, int i2, int i3) {
        if (i2 != i3) {
            if (i3 > i2) {
                for (int i4 = i3 - 1; i4 >= i2; i4--) {
                    removeAndRecycleViewAt(i4, nVar);
                }
                return;
            }
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, nVar);
                i2--;
            }
        }
    }

    private void a(RecyclerView.n nVar, c cVar) {
        if (cVar.apX && !cVar.aqe) {
            if (cVar.mLayoutDirection == -1) {
                int i2 = cVar.aqK;
                int childCount = getChildCount();
                if (i2 >= 0) {
                    int end = this.aqs.getEnd() - i2;
                    if (this.aqv) {
                        for (int i3 = 0; i3 < childCount; i3++) {
                            View childAt = getChildAt(i3);
                            if (this.aqs.bo(childAt) < end || this.aqs.br(childAt) < end) {
                                a(nVar, 0, i3);
                                return;
                            }
                        }
                        return;
                    }
                    for (int i4 = childCount - 1; i4 >= 0; i4--) {
                        View childAt2 = getChildAt(i4);
                        if (this.aqs.bo(childAt2) < end || this.aqs.br(childAt2) < end) {
                            a(nVar, childCount - 1, i4);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            int i5 = cVar.aqK;
            if (i5 >= 0) {
                int childCount2 = getChildCount();
                if (this.aqv) {
                    for (int i6 = childCount2 - 1; i6 >= 0; i6--) {
                        View childAt3 = getChildAt(i6);
                        if (this.aqs.bp(childAt3) > i5 || this.aqs.bq(childAt3) > i5) {
                            a(nVar, childCount2 - 1, i6);
                            return;
                        }
                    }
                    return;
                }
                for (int i7 = 0; i7 < childCount2; i7++) {
                    View childAt4 = getChildAt(i7);
                    if (this.aqs.bp(childAt4) > i5 || this.aqs.bq(childAt4) > i5) {
                        a(nVar, 0, i7);
                        return;
                    }
                }
            }
        }
    }

    private int a(RecyclerView.n nVar, c cVar, RecyclerView.s sVar, boolean z) {
        int i2 = cVar.apY;
        if (cVar.aqK != Integer.MIN_VALUE) {
            if (cVar.apY < 0) {
                cVar.aqK += cVar.apY;
            }
            a(nVar, cVar);
        }
        int i3 = cVar.apY + cVar.aqL;
        b bVar = this.aqD;
        while (true) {
            if ((!cVar.aqe && i3 <= 0) || !cVar.a(sVar)) {
                break;
            }
            bVar.resetInternal();
            a(nVar, sVar, cVar, bVar);
            if (bVar.mFinished) {
                break;
            }
            cVar.fs += bVar.aqI * cVar.mLayoutDirection;
            if (!bVar.aqJ || this.aqr.aqO != null || !sVar.aue) {
                cVar.apY -= bVar.aqI;
                i3 -= bVar.aqI;
            }
            if (cVar.aqK != Integer.MIN_VALUE) {
                cVar.aqK += bVar.aqI;
                if (cVar.apY < 0) {
                    cVar.aqK += cVar.apY;
                }
                a(nVar, cVar);
            }
            if (z && bVar.adH) {
                break;
            }
        }
        return i2 - cVar.apY;
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.n nVar, RecyclerView.s sVar, c cVar, b bVar) {
        boolean z;
        int paddingTop;
        int bt;
        int i2;
        int i3;
        int paddingLeft;
        View a2 = cVar.a(nVar);
        if (a2 == null) {
            bVar.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (cVar.aqO == null) {
            if (this.aqv == (cVar.mLayoutDirection == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            boolean z2 = this.aqv;
            if (cVar.mLayoutDirection == -1) {
                z = true;
            } else {
                z = false;
            }
            if (z2 == z) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        bVar.aqI = this.aqs.bs(a2);
        if (this.mOrientation == 1) {
            if (jH()) {
                int width = getWidth() - getPaddingRight();
                paddingLeft = width - this.aqs.bt(a2);
                i2 = width;
            } else {
                paddingLeft = getPaddingLeft();
                i2 = this.aqs.bt(a2) + paddingLeft;
            }
            if (cVar.mLayoutDirection == -1) {
                bt = cVar.fs;
                paddingTop = cVar.fs - bVar.aqI;
                i3 = paddingLeft;
            } else {
                paddingTop = cVar.fs;
                bt = bVar.aqI + cVar.fs;
                i3 = paddingLeft;
            }
        } else {
            paddingTop = getPaddingTop();
            bt = paddingTop + this.aqs.bt(a2);
            if (cVar.mLayoutDirection == -1) {
                i2 = cVar.fs;
                i3 = cVar.fs - bVar.aqI;
            } else {
                int i4 = cVar.fs;
                i2 = bVar.aqI + cVar.fs;
                i3 = i4;
            }
        }
        layoutDecoratedWithMargins(a2, i3, paddingTop, i2, bt);
        if (layoutParams.atw.isRemoved() || layoutParams.atw.mh()) {
            bVar.aqJ = true;
        }
        bVar.adH = a2.hasFocusable();
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final int cb(int i2) {
        switch (i2) {
            case 1:
                return (this.mOrientation == 1 || !jH()) ? -1 : 1;
            case 2:
                if (this.mOrientation == 1) {
                    return 1;
                }
                return !jH() ? 1 : -1;
            case 17:
                return this.mOrientation != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.mOrientation != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
            case 130:
                return this.mOrientation == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View ko() {
        return getChildAt(this.aqv ? getChildCount() - 1 : 0);
    }

    private View kp() {
        return getChildAt(this.aqv ? 0 : getChildCount() - 1);
    }

    private View ap(boolean z) {
        if (this.aqv) {
            return c(getChildCount() - 1, -1, z, true);
        }
        return c(0, getChildCount(), z, true);
    }

    private View aq(boolean z) {
        if (this.aqv) {
            return c(0, getChildCount(), z, true);
        }
        return c(getChildCount() - 1, -1, z, true);
    }

    private View a(RecyclerView.n nVar, RecyclerView.s sVar) {
        return a(nVar, sVar, getChildCount() - 1, -1, sVar.getItemCount());
    }

    /* access modifiers changed from: package-private */
    public View a(RecyclerView.n nVar, RecyclerView.s sVar, int i2, int i3, int i4) {
        View view;
        km();
        int kH = this.aqs.kH();
        int kI = this.aqs.kI();
        int i5 = i3 > i2 ? 1 : -1;
        View view2 = null;
        View view3 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
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

    private View kq() {
        return ai(0, getChildCount());
    }

    private View kr() {
        return ai(getChildCount() - 1, -1);
    }

    public final int ks() {
        View c2 = c(0, getChildCount(), false, true);
        if (c2 == null) {
            return -1;
        }
        return getPosition(c2);
    }

    public final int kt() {
        View c2 = c(0, getChildCount(), true, false);
        if (c2 == null) {
            return -1;
        }
        return getPosition(c2);
    }

    public final int ku() {
        View c2 = c(getChildCount() - 1, -1, false, true);
        if (c2 == null) {
            return -1;
        }
        return getPosition(c2);
    }

    public final int kv() {
        View c2 = c(getChildCount() - 1, -1, true, false);
        if (c2 == null) {
            return -1;
        }
        return getPosition(c2);
    }

    private View c(int i2, int i3, boolean z, boolean z2) {
        int i4;
        int i5 = 320;
        km();
        if (z) {
            i4 = 24579;
        } else {
            i4 = 320;
        }
        if (!z2) {
            i5 = 0;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.k(i2, i3, i4, i5);
        }
        return this.mVerticalBoundCheck.k(i2, i3, i4, i5);
    }

    private View ai(int i2, int i3) {
        int i4;
        int i5;
        km();
        if ((i3 > i2 ? 1 : i3 < i2 ? (char) 65535 : 0) == 0) {
            return getChildAt(i2);
        }
        if (this.aqs.bo(getChildAt(i2)) < this.aqs.kH()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.k(i2, i3, i4, i5);
        }
        return this.mVerticalBoundCheck.k(i2, i3, i4, i5);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        View kr;
        View view2;
        View kp;
        View kq;
        kl();
        if (getChildCount() == 0) {
            return null;
        }
        int cb = cb(i2);
        if (cb == Integer.MIN_VALUE) {
            return null;
        }
        km();
        km();
        a(cb, (int) (0.33333334f * ((float) this.aqs.kJ())), false, sVar);
        this.aqr.aqK = Integer.MIN_VALUE;
        this.aqr.apX = false;
        a(nVar, this.aqr, sVar, true);
        if (cb == -1) {
            if (this.aqv) {
                kq = kr();
            } else {
                kq = kq();
            }
            view2 = kq;
        } else {
            if (this.aqv) {
                kr = kq();
            } else {
                kr = kr();
            }
            view2 = kr;
        }
        if (cb == -1) {
            kp = ko();
        } else {
            kp = kp();
        }
        if (!kp.hasFocusable()) {
            return view2;
        }
        if (view2 == null) {
            return null;
        }
        return kp;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.aqB == null && this.aqt == this.aqw;
    }

    @Override // android.support.v7.widget.a.a.d
    public final void e(View view, View view2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        km();
        kl();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        boolean z = position < position2 ? true : true;
        if (this.aqv) {
            if (z) {
                ah(position2, this.aqs.kI() - (this.aqs.bo(view2) + this.aqs.bs(view)));
            } else {
                ah(position2, this.aqs.kI() - this.aqs.bp(view2));
            }
        } else if (z) {
            ah(position2, this.aqs.bo(view2));
        } else {
            ah(position2, this.aqs.bp(view2) - this.aqs.bs(view));
        }
    }

    /* access modifiers changed from: package-private */
    public static class c {
        boolean apX = true;
        int apY;
        int apZ;
        int aqK;
        int aqL = 0;
        boolean aqM = false;
        int aqN;
        List<RecyclerView.v> aqO = null;
        int aqa;
        boolean aqe;
        int fs;
        int mLayoutDirection;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final boolean a(RecyclerView.s sVar) {
            return this.apZ >= 0 && this.apZ < sVar.getItemCount();
        }

        /* access modifiers changed from: package-private */
        public final View a(RecyclerView.n nVar) {
            if (this.aqO != null) {
                return kx();
            }
            View cq = nVar.cq(this.apZ);
            this.apZ += this.aqa;
            return cq;
        }

        private View kx() {
            int size = this.aqO.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.aqO.get(i2).aus;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.atw.isRemoved() && this.apZ == layoutParams.atw.lQ()) {
                    bm(view);
                    return view;
                }
            }
            return null;
        }

        public final void bm(View view) {
            View bn = bn(view);
            if (bn == null) {
                this.apZ = -1;
            } else {
                this.apZ = ((RecyclerView.LayoutParams) bn.getLayoutParams()).atw.lQ();
            }
        }

        private View bn(View view) {
            int i2;
            int size = this.aqO.size();
            View view2 = null;
            int i3 = Integer.MAX_VALUE;
            int i4 = 0;
            while (i4 < size) {
                View view3 = this.aqO.get(i4).aus;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 == view || layoutParams.atw.isRemoved() || (i2 = (layoutParams.atw.lQ() - this.apZ) * this.aqa) < 0 || i2 >= i3) {
                    i2 = i3;
                    view3 = view2;
                } else if (i2 == 0) {
                    return view3;
                }
                i4++;
                i3 = i2;
                view2 = view3;
            }
            return view2;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.v7.widget.LinearLayoutManager.SavedState.AnonymousClass1 */

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
        int aqQ;
        boolean aqR;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.aqP = parcel.readInt();
            this.aqQ = parcel.readInt();
            this.aqR = parcel.readInt() != 1 ? false : z;
        }

        public SavedState(SavedState savedState) {
            this.aqP = savedState.aqP;
            this.aqQ = savedState.aqQ;
            this.aqR = savedState.aqR;
        }

        /* access modifiers changed from: package-private */
        public final boolean ky() {
            return this.aqP >= 0;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.aqP);
            parcel.writeInt(this.aqQ);
            parcel.writeInt(this.aqR ? 1 : 0);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        int aqF;
        boolean aqG;
        boolean aqH;
        aj aqs;
        int mPosition;

        a() {
            reset();
        }

        /* access modifiers changed from: package-private */
        public final void reset() {
            this.mPosition = -1;
            this.aqF = Integer.MIN_VALUE;
            this.aqG = false;
            this.aqH = false;
        }

        /* access modifiers changed from: package-private */
        public final void kw() {
            int kH;
            if (this.aqG) {
                kH = this.aqs.kI();
            } else {
                kH = this.aqs.kH();
            }
            this.aqF = kH;
        }

        public final String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.aqF + ", mLayoutFromEnd=" + this.aqG + ", mValid=" + this.aqH + '}';
        }

        public final void C(View view, int i2) {
            int kG = this.aqs.kG();
            if (kG >= 0) {
                D(view, i2);
                return;
            }
            this.mPosition = i2;
            if (this.aqG) {
                int kI = (this.aqs.kI() - kG) - this.aqs.bp(view);
                this.aqF = this.aqs.kI() - kI;
                if (kI > 0) {
                    int bs = this.aqF - this.aqs.bs(view);
                    int kH = this.aqs.kH();
                    int min = bs - (kH + Math.min(this.aqs.bo(view) - kH, 0));
                    if (min < 0) {
                        this.aqF = Math.min(kI, -min) + this.aqF;
                        return;
                    }
                    return;
                }
                return;
            }
            int bo = this.aqs.bo(view);
            int kH2 = bo - this.aqs.kH();
            this.aqF = bo;
            if (kH2 > 0) {
                int kI2 = (this.aqs.kI() - Math.min(0, (this.aqs.kI() - kG) - this.aqs.bp(view))) - (bo + this.aqs.bs(view));
                if (kI2 < 0) {
                    this.aqF -= Math.min(kH2, -kI2);
                }
            }
        }

        public final void D(View view, int i2) {
            if (this.aqG) {
                this.aqF = this.aqs.bp(view) + this.aqs.kG();
            } else {
                this.aqF = this.aqs.bo(view);
            }
            this.mPosition = i2;
        }
    }

    /* access modifiers changed from: protected */
    public static class b {
        public boolean adH;
        public int aqI;
        public boolean aqJ;
        public boolean mFinished;

        protected b() {
        }

        /* access modifiers changed from: package-private */
        public final void resetInternal() {
            this.aqI = 0;
            this.mFinished = false;
            this.aqJ = false;
            this.adH = false;
        }
    }
}
