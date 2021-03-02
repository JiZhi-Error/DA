package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.google.android.flexbox.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.r.b, a {
    static final /* synthetic */ boolean $assertionsDisabled = (!FlexboxLayoutManager.class.desiredAssertionStatus());
    private static final Rect bJN = new Rect();
    private boolean aqA;
    private aj aqs;
    private int aqy = -1;
    private int aqz = Integer.MIN_VALUE;
    private RecyclerView.n arV;
    private RecyclerView.s asR;
    private final c bJF = new c(this);
    private c.a bJG = new c.a();
    private boolean bJO;
    private b bJP;
    private a bJQ = new a(this, (byte) 0);
    private aj bJR;
    private SavedState bJS;
    private int bJT = Integer.MIN_VALUE;
    private int bJU = Integer.MIN_VALUE;
    private SparseArray<View> bJV = new SparseArray<>();
    private View bJW;
    private int bJX = -1;
    private List<b> bJp = new ArrayList();
    private int bJr;
    private int bJs;
    private int bJt;
    private int bJu;
    private int bJw = -1;
    private final Context mContext;
    private boolean mIsRtl;

    static {
        AppMethodBeat.i(62405);
        AppMethodBeat.o(62405);
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        AppMethodBeat.i(62330);
        RecyclerView.LayoutManager.b properties = getProperties(context, attributeSet, i2, i3);
        switch (properties.orientation) {
            case 0:
                if (!properties.atu) {
                    setFlexDirection(0);
                    break;
                } else {
                    setFlexDirection(1);
                    break;
                }
            case 1:
                if (!properties.atu) {
                    setFlexDirection(2);
                    break;
                } else {
                    setFlexDirection(3);
                    break;
                }
        }
        if (this.bJs != 1) {
            if (this.bJs == 0) {
                removeAllViews();
                xO();
            }
            this.bJs = 1;
            this.aqs = null;
            this.bJR = null;
            requestLayout();
        }
        if (this.bJu != 4) {
            removeAllViews();
            xO();
            this.bJu = 4;
            requestLayout();
        }
        setAutoMeasureEnabled(true);
        this.mContext = context;
        AppMethodBeat.o(62330);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.bJr;
    }

    private void setFlexDirection(int i2) {
        AppMethodBeat.i(62331);
        if (this.bJr != i2) {
            removeAllViews();
            this.bJr = i2;
            this.aqs = null;
            this.bJR = null;
            xO();
            requestLayout();
        }
        AppMethodBeat.o(62331);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.bJs;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.bJu;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return 5;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.bJw;
    }

    @Override // com.google.android.flexbox.a
    public final int m(View view, int i2, int i3) {
        AppMethodBeat.i(62332);
        if (xC()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            AppMethodBeat.o(62332);
            return leftDecorationWidth;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        AppMethodBeat.o(62332);
        return topDecorationHeight;
    }

    @Override // com.google.android.flexbox.a
    public final int bV(View view) {
        AppMethodBeat.i(62333);
        if (xC()) {
            int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
            AppMethodBeat.o(62333);
            return topDecorationHeight;
        }
        int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
        AppMethodBeat.o(62333);
        return leftDecorationWidth;
    }

    @Override // com.google.android.flexbox.a
    public final void a(View view, int i2, int i3, b bVar) {
        AppMethodBeat.i(62334);
        calculateItemDecorationsForChild(view, bJN);
        if (xC()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            bVar.bJa += leftDecorationWidth;
            bVar.bJb = leftDecorationWidth + bVar.bJb;
            AppMethodBeat.o(62334);
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        bVar.bJa += topDecorationHeight;
        bVar.bJb = topDecorationHeight + bVar.bJb;
        AppMethodBeat.o(62334);
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        AppMethodBeat.i(62335);
        int itemCount = this.asR.getItemCount();
        AppMethodBeat.o(62335);
        return itemCount;
    }

    @Override // com.google.android.flexbox.a
    public final View fj(int i2) {
        AppMethodBeat.i(62336);
        View view = this.bJV.get(i2);
        if (view != null) {
            AppMethodBeat.o(62336);
            return view;
        }
        View cp = this.arV.cp(i2);
        AppMethodBeat.o(62336);
        return cp;
    }

    @Override // com.google.android.flexbox.a
    public final View fk(int i2) {
        AppMethodBeat.i(62337);
        View fj = fj(i2);
        AppMethodBeat.o(62337);
        return fj;
    }

    @Override // com.google.android.flexbox.a
    public final void a(b bVar) {
    }

    @Override // com.google.android.flexbox.a
    public final int t(int i2, int i3, int i4) {
        AppMethodBeat.i(62338);
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), i3, i4, canScrollHorizontally());
        AppMethodBeat.o(62338);
        return childMeasureSpec;
    }

    @Override // com.google.android.flexbox.a
    public final int u(int i2, int i3, int i4) {
        AppMethodBeat.i(62339);
        int childMeasureSpec = getChildMeasureSpec(getHeight(), getHeightMode(), i3, i4, canScrollVertically());
        AppMethodBeat.o(62339);
        return childMeasureSpec;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        AppMethodBeat.i(62340);
        if (this.bJp.size() == 0) {
            AppMethodBeat.o(62340);
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int size = this.bJp.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, this.bJp.get(i3).bJa);
        }
        AppMethodBeat.o(62340);
        return i2;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        AppMethodBeat.i(62341);
        int size = this.bJp.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.bJp.get(i3).bJc;
        }
        AppMethodBeat.o(62341);
        return i2;
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
        AppMethodBeat.i(62342);
        this.bJV.put(i2, view);
        AppMethodBeat.o(62342);
    }

    @Override // android.support.v7.widget.RecyclerView.r.b
    public final PointF bZ(int i2) {
        AppMethodBeat.i(62343);
        if (getChildCount() == 0) {
            AppMethodBeat.o(62343);
            return null;
        }
        int i3 = i2 < getPosition(getChildAt(0)) ? -1 : 1;
        if (xC()) {
            PointF pointF = new PointF(0.0f, (float) i3);
            AppMethodBeat.o(62343);
            return pointF;
        }
        PointF pointF2 = new PointF((float) i3, 0.0f);
        AppMethodBeat.o(62343);
        return pointF2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(62344);
        LayoutParams layoutParams = new LayoutParams();
        AppMethodBeat.o(62344);
        return layoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        AppMethodBeat.i(62345);
        LayoutParams layoutParams = new LayoutParams(context, attributeSet);
        AppMethodBeat.o(62345);
        return layoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.a aVar, RecyclerView.a aVar2) {
        AppMethodBeat.i(187956);
        removeAllViews();
        AppMethodBeat.o(187956);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(62347);
        if (this.bJS != null) {
            SavedState savedState = new SavedState(this.bJS, (byte) 0);
            AppMethodBeat.o(62347);
            return savedState;
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            savedState2.aqP = getPosition(childAt);
            savedState2.aqQ = this.aqs.bo(childAt) - this.aqs.kH();
        } else {
            savedState2.aqP = -1;
        }
        AppMethodBeat.o(62347);
        return savedState2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(62348);
        if (parcelable instanceof SavedState) {
            this.bJS = (SavedState) parcelable;
            requestLayout();
        }
        AppMethodBeat.o(62348);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(62349);
        super.onItemsAdded(recyclerView, i2, i3);
        fv(i2);
        AppMethodBeat.o(62349);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        AppMethodBeat.i(62350);
        super.onItemsUpdated(recyclerView, i2, i3, obj);
        fv(i2);
        AppMethodBeat.o(62350);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(62351);
        super.onItemsUpdated(recyclerView, i2, i3);
        fv(i2);
        AppMethodBeat.o(62351);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        AppMethodBeat.i(62352);
        super.onItemsRemoved(recyclerView, i2, i3);
        fv(i2);
        AppMethodBeat.o(62352);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        AppMethodBeat.i(62353);
        super.onItemsMoved(recyclerView, i2, i3, i4);
        fv(Math.min(i2, i3));
        AppMethodBeat.o(62353);
    }

    private void fv(int i2) {
        AppMethodBeat.i(62354);
        int ks = ks();
        int ku = ku();
        if (i2 >= ku) {
            AppMethodBeat.o(62354);
            return;
        }
        int childCount = getChildCount();
        this.bJF.fp(childCount);
        this.bJF.fo(childCount);
        this.bJF.fq(childCount);
        if (!$assertionsDisabled && this.bJF.bJm == null) {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62354);
            throw assertionError;
        } else if (i2 >= this.bJF.bJm.length) {
            AppMethodBeat.o(62354);
        } else {
            this.bJX = i2;
            View childAt = getChildAt(0);
            if (childAt == null) {
                AppMethodBeat.o(62354);
            } else if (ks > i2 || i2 > ku) {
                this.aqy = getPosition(childAt);
                if (xC() || !this.mIsRtl) {
                    this.aqz = this.aqs.bo(childAt) - this.aqs.kH();
                    AppMethodBeat.o(62354);
                    return;
                }
                this.aqz = this.aqs.bp(childAt) + this.aqs.getEndPadding();
                AppMethodBeat.o(62354);
            } else {
                AppMethodBeat.o(62354);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a6  */
    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayoutChildren(android.support.v7.widget.RecyclerView.n r18, android.support.v7.widget.RecyclerView.s r19) {
        /*
        // Method dump skipped, instructions count: 1578
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.onLayoutChildren(android.support.v7.widget.RecyclerView$n, android.support.v7.widget.RecyclerView$s):void");
    }

    private int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int i3;
        int kH;
        AppMethodBeat.i(62356);
        if (xC() || !this.mIsRtl) {
            int kH2 = i2 - this.aqs.kH();
            if (kH2 > 0) {
                i3 = -b(kH2, nVar, sVar);
            } else {
                AppMethodBeat.o(62356);
                return 0;
            }
        } else {
            int kI = this.aqs.kI() - i2;
            if (kI > 0) {
                i3 = b(-kI, nVar, sVar);
            } else {
                AppMethodBeat.o(62356);
                return 0;
            }
        }
        int i4 = i2 + i3;
        if (!z || (kH = i4 - this.aqs.kH()) <= 0) {
            AppMethodBeat.o(62356);
            return i3;
        }
        this.aqs.ce(-kH);
        int i5 = i3 - kH;
        AppMethodBeat.o(62356);
        return i5;
    }

    private int a(int i2, RecyclerView.n nVar, RecyclerView.s sVar, boolean z) {
        int i3;
        int kI;
        AppMethodBeat.i(62357);
        if (!xC() && this.mIsRtl) {
            int kH = i2 - this.aqs.kH();
            if (kH > 0) {
                i3 = b(kH, nVar, sVar);
            } else {
                AppMethodBeat.o(62357);
                return 0;
            }
        } else {
            int kI2 = this.aqs.kI() - i2;
            if (kI2 > 0) {
                i3 = -b(-kI2, nVar, sVar);
            } else {
                AppMethodBeat.o(62357);
                return 0;
            }
        }
        int i4 = i2 + i3;
        if (!z || (kI = this.aqs.kI() - i4) <= 0) {
            AppMethodBeat.o(62357);
            return i3;
        }
        this.aqs.ce(kI);
        int i5 = i3 + kI;
        AppMethodBeat.o(62357);
        return i5;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.s sVar) {
        AppMethodBeat.i(62358);
        super.onLayoutCompleted(sVar);
        this.bJS = null;
        this.aqy = -1;
        this.aqz = Integer.MIN_VALUE;
        this.bJX = -1;
        a.b(this.bJQ);
        this.bJV.clear();
        AppMethodBeat.o(62358);
    }

    private View fw(int i2) {
        AppMethodBeat.i(62359);
        if ($assertionsDisabled || this.bJF.bJm != null) {
            View x = x(0, getChildCount(), i2);
            if (x == null) {
                AppMethodBeat.o(62359);
                return null;
            }
            int i3 = this.bJF.bJm[getPosition(x)];
            if (i3 == -1) {
                AppMethodBeat.o(62359);
                return null;
            }
            View a2 = a(x, this.bJp.get(i3));
            AppMethodBeat.o(62359);
            return a2;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(62359);
        throw assertionError;
    }

    private View fx(int i2) {
        AppMethodBeat.i(62360);
        if ($assertionsDisabled || this.bJF.bJm != null) {
            View x = x(getChildCount() - 1, -1, i2);
            if (x == null) {
                AppMethodBeat.o(62360);
                return null;
            }
            View b2 = b(x, this.bJp.get(this.bJF.bJm[getPosition(x)]));
            AppMethodBeat.o(62360);
            return b2;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(62360);
        throw assertionError;
    }

    private View x(int i2, int i3, int i4) {
        View view;
        AppMethodBeat.i(62361);
        xN();
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
                } else if (this.aqs.bo(childAt) >= kH && this.aqs.bp(childAt) <= kI) {
                    AppMethodBeat.o(62361);
                    return childAt;
                } else if (view2 == null) {
                    view = childAt;
                    i2 += i5;
                    view2 = view;
                }
            }
            view = view2;
            i2 += i5;
            view2 = view;
        }
        if (view2 != null) {
            AppMethodBeat.o(62361);
            return view2;
        }
        AppMethodBeat.o(62361);
        return view3;
    }

    private boolean I(View view, int i2) {
        AppMethodBeat.i(62366);
        if (xC() || !this.mIsRtl) {
            if (this.aqs.bp(view) <= i2) {
                AppMethodBeat.o(62366);
                return true;
            }
            AppMethodBeat.o(62366);
            return false;
        } else if (this.aqs.getEnd() - this.aqs.bo(view) <= i2) {
            AppMethodBeat.o(62366);
            return true;
        } else {
            AppMethodBeat.o(62366);
            return false;
        }
    }

    private boolean J(View view, int i2) {
        AppMethodBeat.i(62368);
        if (xC() || !this.mIsRtl) {
            if (this.aqs.bo(view) >= this.aqs.getEnd() - i2) {
                AppMethodBeat.o(62368);
                return true;
            }
            AppMethodBeat.o(62368);
            return false;
        } else if (this.aqs.bp(view) <= i2) {
            AppMethodBeat.o(62368);
            return true;
        } else {
            AppMethodBeat.o(62368);
            return false;
        }
    }

    private void a(RecyclerView.n nVar, int i2, int i3) {
        AppMethodBeat.i(62369);
        while (i3 >= i2) {
            removeAndRecycleViewAt(i3, nVar);
            i3--;
        }
        AppMethodBeat.o(62369);
    }

    private int a(b bVar, b bVar2) {
        int i2;
        int i3;
        float f2;
        float f3;
        int i4;
        float f4;
        float f5;
        AppMethodBeat.i(62370);
        if ($assertionsDisabled || this.bJF.bJn != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int i5 = bVar2.fs;
            int i6 = bVar2.fs;
            if (bVar2.mLayoutDirection == -1) {
                int i7 = i5 - bVar.bJc;
                i2 = i6 + bVar.bJc;
                i3 = i7;
            } else {
                i2 = i6;
                i3 = i5;
            }
            int i8 = bVar2.mPosition;
            float f6 = 0.0f;
            switch (this.bJt) {
                case 0:
                    f2 = (float) paddingTop;
                    f3 = (float) (height - paddingBottom);
                    break;
                case 1:
                    f2 = (float) ((height - bVar.bJa) + paddingBottom);
                    f3 = (float) (bVar.bJa - paddingTop);
                    break;
                case 2:
                    f2 = ((float) paddingTop) + (((float) (height - bVar.bJa)) / 2.0f);
                    f3 = ((float) (height - paddingBottom)) - (((float) (height - bVar.bJa)) / 2.0f);
                    break;
                case 3:
                    f2 = (float) paddingTop;
                    f6 = ((float) (height - bVar.bJa)) / (bVar.auc != 1 ? (float) (bVar.auc - 1) : 1.0f);
                    f3 = (float) (height - paddingBottom);
                    break;
                case 4:
                    if (bVar.auc != 0) {
                        f6 = ((float) (height - bVar.bJa)) / ((float) bVar.auc);
                    }
                    f2 = ((float) paddingTop) + (f6 / 2.0f);
                    f3 = ((float) (height - paddingBottom)) - (f6 / 2.0f);
                    break;
                case 5:
                    if (bVar.auc != 0) {
                        f6 = ((float) (height - bVar.bJa)) / ((float) (bVar.auc + 1));
                    }
                    f2 = ((float) paddingTop) + f6;
                    f3 = ((float) (height - paddingBottom)) - f6;
                    break;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
                    AppMethodBeat.o(62370);
                    throw illegalStateException;
            }
            float f7 = f2 - ((float) this.bJQ.bJZ);
            float f8 = f3 - ((float) this.bJQ.bJZ);
            float max = Math.max(f6, 0.0f);
            int i9 = 0;
            int i10 = bVar.auc;
            int i11 = i8;
            while (i11 < i8 + i10) {
                View fj = fj(i11);
                if (fj != null) {
                    long j2 = this.bJF.bJn[i11];
                    int at = c.at(j2);
                    int au = c.au(j2);
                    LayoutParams layoutParams = (LayoutParams) fj.getLayoutParams();
                    if (shouldMeasureChild(fj, at, au, layoutParams)) {
                        fj.measure(at, au);
                    }
                    float topDecorationHeight = f7 + ((float) (layoutParams.topMargin + getTopDecorationHeight(fj)));
                    float bottomDecorationHeight = f8 - ((float) (layoutParams.rightMargin + getBottomDecorationHeight(fj)));
                    if (bVar2.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(fj, bJN);
                        addView(fj);
                        i4 = i9;
                    } else {
                        calculateItemDecorationsForChild(fj, bJN);
                        addView(fj, i9);
                        i4 = i9 + 1;
                    }
                    int leftDecorationWidth = i3 + getLeftDecorationWidth(fj);
                    int rightDecorationWidth = i2 - getRightDecorationWidth(fj);
                    if (this.mIsRtl) {
                        if (this.bJO) {
                            this.bJF.a(fj, bVar, this.mIsRtl, rightDecorationWidth - fj.getMeasuredWidth(), Math.round(bottomDecorationHeight) - fj.getMeasuredHeight(), rightDecorationWidth, Math.round(bottomDecorationHeight));
                        } else {
                            this.bJF.a(fj, bVar, this.mIsRtl, rightDecorationWidth - fj.getMeasuredWidth(), Math.round(topDecorationHeight), rightDecorationWidth, fj.getMeasuredHeight() + Math.round(topDecorationHeight));
                        }
                    } else if (this.bJO) {
                        this.bJF.a(fj, bVar, this.mIsRtl, leftDecorationWidth, Math.round(bottomDecorationHeight) - fj.getMeasuredHeight(), leftDecorationWidth + fj.getMeasuredWidth(), Math.round(bottomDecorationHeight));
                    } else {
                        this.bJF.a(fj, bVar, this.mIsRtl, leftDecorationWidth, Math.round(topDecorationHeight), leftDecorationWidth + fj.getMeasuredWidth(), fj.getMeasuredHeight() + Math.round(topDecorationHeight));
                    }
                    f4 = ((float) (fj.getMeasuredHeight() + layoutParams.topMargin + getBottomDecorationHeight(fj))) + max + topDecorationHeight;
                    f5 = bottomDecorationHeight - (((float) (getTopDecorationHeight(fj) + (fj.getMeasuredHeight() + layoutParams.bottomMargin))) + max);
                } else {
                    i4 = i9;
                    f4 = f7;
                    f5 = f8;
                }
                i9 = i4;
                f7 = f4;
                i11++;
                f8 = f5;
            }
            bVar2.bJY += this.bJP.mLayoutDirection;
            int i12 = bVar.bJc;
            AppMethodBeat.o(62370);
            return i12;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(62370);
        throw assertionError;
    }

    @Override // com.google.android.flexbox.a
    public final boolean xC() {
        return this.bJr == 0 || this.bJr == 1;
    }

    private void a(a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(62371);
        if (z2) {
            xM();
        } else {
            this.bJP.aqe = false;
        }
        if (xC() || !this.mIsRtl) {
            this.bJP.apY = this.aqs.kI() - aVar.aqF;
        } else {
            this.bJP.apY = aVar.aqF - getPaddingRight();
        }
        this.bJP.mPosition = aVar.mPosition;
        this.bJP.aqa = 1;
        this.bJP.mLayoutDirection = 1;
        this.bJP.fs = aVar.aqF;
        this.bJP.aqK = Integer.MIN_VALUE;
        this.bJP.bJY = aVar.bJY;
        if (z && this.bJp.size() > 1 && aVar.bJY >= 0 && aVar.bJY < this.bJp.size() - 1) {
            b.a(this.bJP);
            b bVar = this.bJP;
            bVar.mPosition = this.bJp.get(aVar.bJY).auc + bVar.mPosition;
        }
        AppMethodBeat.o(62371);
    }

    private void b(a aVar, boolean z, boolean z2) {
        AppMethodBeat.i(62372);
        if (z2) {
            xM();
        } else {
            this.bJP.aqe = false;
        }
        if (xC() || !this.mIsRtl) {
            this.bJP.apY = aVar.aqF - this.aqs.kH();
        } else {
            this.bJP.apY = (this.bJW.getWidth() - aVar.aqF) - this.aqs.kH();
        }
        this.bJP.mPosition = aVar.mPosition;
        this.bJP.aqa = 1;
        this.bJP.mLayoutDirection = -1;
        this.bJP.fs = aVar.aqF;
        this.bJP.aqK = Integer.MIN_VALUE;
        this.bJP.bJY = aVar.bJY;
        if (z && aVar.bJY > 0 && this.bJp.size() > aVar.bJY) {
            b.b(this.bJP);
            this.bJP.mPosition -= this.bJp.get(aVar.bJY).auc;
        }
        AppMethodBeat.o(62372);
    }

    private void xM() {
        int widthMode;
        boolean z;
        AppMethodBeat.i(62373);
        if (xC()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        b bVar = this.bJP;
        if (widthMode == 0 || widthMode == Integer.MIN_VALUE) {
            z = true;
        } else {
            z = false;
        }
        bVar.aqe = z;
        AppMethodBeat.o(62373);
    }

    private void xN() {
        AppMethodBeat.i(62374);
        if (this.aqs != null) {
            AppMethodBeat.o(62374);
            return;
        }
        if (xC()) {
            if (this.bJs != 0) {
                this.aqs = aj.e(this);
                this.bJR = aj.d(this);
                AppMethodBeat.o(62374);
                return;
            }
        } else if (this.bJs == 0) {
            this.aqs = aj.e(this);
            this.bJR = aj.d(this);
            AppMethodBeat.o(62374);
            return;
        }
        this.aqs = aj.d(this);
        this.bJR = aj.e(this);
        AppMethodBeat.o(62374);
    }

    private void km() {
        AppMethodBeat.i(62375);
        if (this.bJP == null) {
            this.bJP = new b((byte) 0);
        }
        AppMethodBeat.o(62375);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        AppMethodBeat.i(62376);
        this.aqy = i2;
        this.aqz = Integer.MIN_VALUE;
        if (this.bJS != null) {
            this.bJS.aqP = -1;
        }
        requestLayout();
        AppMethodBeat.o(62376);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AppMethodBeat.i(62377);
        ae aeVar = new ae(recyclerView.getContext());
        aeVar.atO = i2;
        startSmoothScroll(aeVar);
        AppMethodBeat.o(62377);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        AppMethodBeat.i(62378);
        super.onAttachedToWindow(recyclerView);
        this.bJW = (View) recyclerView.getParent();
        AppMethodBeat.o(62378);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        AppMethodBeat.i(62379);
        super.onDetachedFromWindow(recyclerView, nVar);
        if (this.aqA) {
            removeAndRecycleAllViews(nVar);
            nVar.clear();
        }
        AppMethodBeat.o(62379);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        AppMethodBeat.i(62380);
        if (!xC() || getWidth() > this.bJW.getWidth()) {
            AppMethodBeat.o(62380);
            return true;
        }
        AppMethodBeat.o(62380);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        AppMethodBeat.i(62381);
        if (xC() || getHeight() > this.bJW.getHeight()) {
            AppMethodBeat.o(62381);
            return true;
        }
        AppMethodBeat.o(62381);
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(62382);
        if (!xC()) {
            int b2 = b(i2, nVar, sVar);
            this.bJV.clear();
            AppMethodBeat.o(62382);
            return b2;
        }
        int fy = fy(i2);
        this.bJQ.bJZ += fy;
        this.bJR.ce(-fy);
        AppMethodBeat.o(62382);
        return fy;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(62383);
        if (xC()) {
            int b2 = b(i2, nVar, sVar);
            this.bJV.clear();
            AppMethodBeat.o(62383);
            return b2;
        }
        int fy = fy(i2);
        this.bJQ.bJZ += fy;
        this.bJR.ce(-fy);
        AppMethodBeat.o(62383);
        return fy;
    }

    private int b(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        int i3 = 1;
        AppMethodBeat.i(62384);
        if (getChildCount() == 0 || i2 == 0) {
            AppMethodBeat.o(62384);
            return 0;
        }
        xN();
        this.bJP.bKc = true;
        boolean z = !xC() && this.mIsRtl;
        if (z) {
            if (i2 >= 0) {
                i3 = -1;
            }
        } else if (i2 <= 0) {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        bo(i3, abs);
        int a2 = this.bJP.aqK + a(nVar, sVar, this.bJP);
        if (a2 < 0) {
            AppMethodBeat.o(62384);
            return 0;
        }
        if (z) {
            if (abs > a2) {
                i2 = (-i3) * a2;
            }
        } else if (abs > a2) {
            i2 = i3 * a2;
        }
        this.aqs.ce(-i2);
        this.bJP.aqN = i2;
        AppMethodBeat.o(62384);
        return i2;
    }

    private int fy(int i2) {
        boolean z = false;
        AppMethodBeat.i(62385);
        if (getChildCount() == 0 || i2 == 0) {
            AppMethodBeat.o(62385);
            return 0;
        }
        xN();
        boolean xC = xC();
        int width = xC ? this.bJW.getWidth() : this.bJW.getHeight();
        int width2 = xC ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            z = true;
        }
        if (z) {
            int abs = Math.abs(i2);
            if (i2 < 0) {
                i2 = -Math.min((width2 + this.bJQ.bJZ) - width, abs);
            } else if (this.bJQ.bJZ + i2 > 0) {
                i2 = -this.bJQ.bJZ;
            }
        } else if (i2 > 0) {
            i2 = Math.min((width2 - this.bJQ.bJZ) - width, i2);
        } else if (this.bJQ.bJZ + i2 < 0) {
            i2 = -this.bJQ.bJZ;
        }
        AppMethodBeat.o(62385);
        return i2;
    }

    private void bo(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = 0;
        AppMethodBeat.i(62386);
        if ($assertionsDisabled || this.bJF.bJm != null) {
            this.bJP.mLayoutDirection = i2;
            boolean xC = xC();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
            boolean z = !xC && this.mIsRtl;
            if (i2 == 1) {
                View childAt = getChildAt(getChildCount() - 1);
                this.bJP.fs = this.aqs.bp(childAt);
                int position = getPosition(childAt);
                View b2 = b(childAt, this.bJp.get(this.bJF.bJm[position]));
                this.bJP.aqa = 1;
                b bVar = this.bJP;
                bVar.mPosition = bVar.aqa + position;
                if (this.bJF.bJm.length <= this.bJP.mPosition) {
                    this.bJP.bJY = -1;
                } else {
                    this.bJP.bJY = this.bJF.bJm[this.bJP.mPosition];
                }
                if (z) {
                    this.bJP.fs = this.aqs.bo(b2);
                    this.bJP.aqK = (-this.aqs.bo(b2)) + this.aqs.kH();
                    b bVar2 = this.bJP;
                    if (this.bJP.aqK >= 0) {
                        i6 = this.bJP.aqK;
                    } else {
                        i6 = 0;
                    }
                    bVar2.aqK = i6;
                } else {
                    this.bJP.fs = this.aqs.bp(b2);
                    this.bJP.aqK = this.aqs.bp(b2) - this.aqs.kI();
                }
                if ((this.bJP.bJY == -1 || this.bJP.bJY > this.bJp.size() - 1) && this.bJP.mPosition <= getFlexItemCount()) {
                    int i8 = i3 - this.bJP.aqK;
                    this.bJG.reset();
                    if (i8 > 0) {
                        if (xC) {
                            this.bJF.a(this.bJG, makeMeasureSpec, makeMeasureSpec2, i8, this.bJP.mPosition, this.bJp);
                        } else {
                            this.bJF.c(this.bJG, makeMeasureSpec, makeMeasureSpec2, i8, this.bJP.mPosition, this.bJp);
                        }
                        this.bJF.v(makeMeasureSpec, makeMeasureSpec2, this.bJP.mPosition);
                        this.bJF.fn(this.bJP.mPosition);
                    }
                }
            } else {
                View childAt2 = getChildAt(0);
                this.bJP.fs = this.aqs.bo(childAt2);
                int position2 = getPosition(childAt2);
                View a2 = a(childAt2, this.bJp.get(this.bJF.bJm[position2]));
                this.bJP.aqa = 1;
                int i9 = this.bJF.bJm[position2];
                if (i9 == -1) {
                    i4 = 0;
                } else {
                    i4 = i9;
                }
                if (i4 > 0) {
                    this.bJP.mPosition = position2 - this.bJp.get(i4 - 1).auc;
                } else {
                    this.bJP.mPosition = -1;
                }
                b bVar3 = this.bJP;
                if (i4 > 0) {
                    i5 = i4 - 1;
                } else {
                    i5 = 0;
                }
                bVar3.bJY = i5;
                if (z) {
                    this.bJP.fs = this.aqs.bp(a2);
                    this.bJP.aqK = this.aqs.bp(a2) - this.aqs.kI();
                    b bVar4 = this.bJP;
                    if (this.bJP.aqK >= 0) {
                        i7 = this.bJP.aqK;
                    }
                    bVar4.aqK = i7;
                } else {
                    this.bJP.fs = this.aqs.bo(a2);
                    this.bJP.aqK = (-this.aqs.bo(a2)) + this.aqs.kH();
                }
            }
            b bVar5 = this.bJP;
            bVar5.apY = i3 - bVar5.aqK;
            AppMethodBeat.o(62386);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(62386);
        throw assertionError;
    }

    private View a(View view, b bVar) {
        AppMethodBeat.i(62387);
        boolean xC = xC();
        int i2 = bVar.auc;
        int i3 = 1;
        View view2 = view;
        while (i3 < i2) {
            View childAt = getChildAt(i3);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.mIsRtl || xC) {
                    if (this.aqs.bo(view2) > this.aqs.bo(childAt)) {
                        i3++;
                        view2 = childAt;
                    }
                } else if (this.aqs.bp(view2) < this.aqs.bp(childAt)) {
                    i3++;
                    view2 = childAt;
                }
            }
            childAt = view2;
            i3++;
            view2 = childAt;
        }
        AppMethodBeat.o(62387);
        return view2;
    }

    private View b(View view, b bVar) {
        AppMethodBeat.i(62388);
        boolean xC = xC();
        int childCount = (getChildCount() - bVar.auc) - 1;
        int childCount2 = getChildCount() - 2;
        View view2 = view;
        while (childCount2 > childCount) {
            View childAt = getChildAt(childCount2);
            if (!(childAt == null || childAt.getVisibility() == 8)) {
                if (!this.mIsRtl || xC) {
                    if (this.aqs.bp(view2) < this.aqs.bp(childAt)) {
                        childCount2--;
                        view2 = childAt;
                    }
                } else if (this.aqs.bo(view2) > this.aqs.bo(childAt)) {
                    childCount2--;
                    view2 = childAt;
                }
            }
            childAt = view2;
            childCount2--;
            view2 = childAt;
        }
        AppMethodBeat.o(62388);
        return view2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        AppMethodBeat.i(62389);
        int d2 = d(sVar);
        AppMethodBeat.o(62389);
        return d2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        AppMethodBeat.i(62390);
        int d2 = d(sVar);
        AppMethodBeat.o(62390);
        return d2;
    }

    private int d(RecyclerView.s sVar) {
        AppMethodBeat.i(62391);
        if (getChildCount() == 0) {
            AppMethodBeat.o(62391);
            return 0;
        }
        int itemCount = sVar.getItemCount();
        xN();
        View fw = fw(itemCount);
        View fx = fx(itemCount);
        if (sVar.getItemCount() == 0 || fw == null || fx == null) {
            AppMethodBeat.o(62391);
            return 0;
        }
        int min = Math.min(this.aqs.kJ(), this.aqs.bp(fx) - this.aqs.bo(fw));
        AppMethodBeat.o(62391);
        return min;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        AppMethodBeat.i(62392);
        c(sVar);
        int c2 = c(sVar);
        AppMethodBeat.o(62392);
        return c2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        AppMethodBeat.i(62393);
        int c2 = c(sVar);
        AppMethodBeat.o(62393);
        return c2;
    }

    private int c(RecyclerView.s sVar) {
        AppMethodBeat.i(62394);
        if (getChildCount() == 0) {
            AppMethodBeat.o(62394);
            return 0;
        }
        int itemCount = sVar.getItemCount();
        View fw = fw(itemCount);
        View fx = fx(itemCount);
        if (sVar.getItemCount() == 0 || fw == null || fx == null) {
            AppMethodBeat.o(62394);
            return 0;
        } else if ($assertionsDisabled || this.bJF.bJm != null) {
            int position = getPosition(fw);
            int position2 = getPosition(fx);
            int abs = Math.abs(this.aqs.bp(fx) - this.aqs.bo(fw));
            int i2 = this.bJF.bJm[position];
            if (i2 == 0 || i2 == -1) {
                AppMethodBeat.o(62394);
                return 0;
            }
            int round = Math.round(((((float) abs) / ((float) ((this.bJF.bJm[position2] - i2) + 1))) * ((float) i2)) + ((float) (this.aqs.kH() - this.aqs.bo(fw))));
            AppMethodBeat.o(62394);
            return round;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62394);
            throw assertionError;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        AppMethodBeat.i(62395);
        int e2 = e(sVar);
        AppMethodBeat.o(62395);
        return e2;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        AppMethodBeat.i(62396);
        int e2 = e(sVar);
        AppMethodBeat.o(62396);
        return e2;
    }

    private int e(RecyclerView.s sVar) {
        AppMethodBeat.i(62397);
        if (getChildCount() == 0) {
            AppMethodBeat.o(62397);
            return 0;
        }
        int itemCount = sVar.getItemCount();
        View fw = fw(itemCount);
        View fx = fx(itemCount);
        if (sVar.getItemCount() == 0 || fw == null || fx == null) {
            AppMethodBeat.o(62397);
            return 0;
        } else if ($assertionsDisabled || this.bJF.bJm != null) {
            int ks = ks();
            int abs = (int) ((((float) Math.abs(this.aqs.bp(fx) - this.aqs.bo(fw))) / ((float) ((ku() - ks) + 1))) * ((float) sVar.getItemCount()));
            AppMethodBeat.o(62397);
            return abs;
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62397);
            throw assertionError;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    private boolean shouldMeasureChild(View view, int i2, int i3, RecyclerView.LayoutParams layoutParams) {
        AppMethodBeat.i(62398);
        if (view.isLayoutRequested() || !isMeasurementCacheEnabled() || !isMeasurementUpToDate(view.getWidth(), i2, layoutParams.width) || !isMeasurementUpToDate(view.getHeight(), i3, layoutParams.height)) {
            AppMethodBeat.o(62398);
            return true;
        }
        AppMethodBeat.o(62398);
        return false;
    }

    private static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
        AppMethodBeat.i(62399);
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 <= 0 || i2 == i4) {
            switch (mode) {
                case Integer.MIN_VALUE:
                    if (size >= i2) {
                        AppMethodBeat.o(62399);
                        return true;
                    }
                    AppMethodBeat.o(62399);
                    return false;
                case 0:
                    AppMethodBeat.o(62399);
                    return true;
                case 1073741824:
                    if (size == i2) {
                        AppMethodBeat.o(62399);
                        return true;
                    }
                    AppMethodBeat.o(62399);
                    return false;
                default:
                    AppMethodBeat.o(62399);
                    return false;
            }
        } else {
            AppMethodBeat.o(62399);
            return false;
        }
    }

    private void xO() {
        AppMethodBeat.i(62400);
        this.bJp.clear();
        a.b(this.bJQ);
        this.bJQ.bJZ = 0;
        AppMethodBeat.o(62400);
    }

    private boolean bW(View view) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(62401);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int decoratedLeft = getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
        int decoratedTop = getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
        int decoratedRight = getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
        int decoratedBottom = ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + getDecoratedBottom(view);
        if (decoratedLeft >= width || decoratedRight >= paddingLeft) {
            z = true;
        } else {
            z = false;
        }
        if (decoratedTop >= height || decoratedBottom >= paddingTop) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z || !z2) {
            AppMethodBeat.o(62401);
            return false;
        }
        AppMethodBeat.o(62401);
        return true;
    }

    private int ks() {
        AppMethodBeat.i(62402);
        View bp = bp(0, getChildCount());
        if (bp == null) {
            AppMethodBeat.o(62402);
            return -1;
        }
        int position = getPosition(bp);
        AppMethodBeat.o(62402);
        return position;
    }

    private int ku() {
        AppMethodBeat.i(62403);
        View bp = bp(getChildCount() - 1, -1);
        if (bp == null) {
            AppMethodBeat.o(62403);
            return -1;
        }
        int position = getPosition(bp);
        AppMethodBeat.o(62403);
        return position;
    }

    private View bp(int i2, int i3) {
        AppMethodBeat.i(62404);
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (bW(childAt)) {
                AppMethodBeat.o(62404);
                return childAt;
            }
            i2 += i4;
        }
        AppMethodBeat.o(62404);
        return null;
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            /* class com.google.android.flexbox.FlexboxLayoutManager.LayoutParams.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LayoutParams[] newArray(int i2) {
                return new LayoutParams[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LayoutParams createFromParcel(Parcel parcel) {
                AppMethodBeat.i(62320);
                LayoutParams layoutParams = new LayoutParams(parcel);
                AppMethodBeat.o(62320);
                return layoutParams;
            }
        };
        private float bJI = 0.0f;
        private float bJJ = 1.0f;
        private int bJK = -1;
        private float bJL = -1.0f;
        private boolean bJM;
        private int mMaxHeight = 16777215;
        private int mMaxWidth = 16777215;
        private int mMinHeight;
        private int mMinWidth;

        @Override // com.google.android.flexbox.FlexItem
        public final int getWidth() {
            return this.width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getHeight() {
            return this.height;
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

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams() {
            super(-2, -2);
        }

        @Override // com.google.android.flexbox.FlexItem
        public final int getOrder() {
            return 1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(62321);
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
            AppMethodBeat.o(62321);
        }

        protected LayoutParams(Parcel parcel) {
            super(-2, -2);
            AppMethodBeat.i(62322);
            this.bJI = parcel.readFloat();
            this.bJJ = parcel.readFloat();
            this.bJK = parcel.readInt();
            this.bJL = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.bJM = parcel.readByte() != 0;
            this.bottomMargin = parcel.readInt();
            this.leftMargin = parcel.readInt();
            this.rightMargin = parcel.readInt();
            this.topMargin = parcel.readInt();
            this.height = parcel.readInt();
            this.width = parcel.readInt();
            AppMethodBeat.o(62322);
        }

        static {
            AppMethodBeat.i(62323);
            AppMethodBeat.o(62323);
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        static final /* synthetic */ boolean $assertionsDisabled = (!FlexboxLayoutManager.class.desiredAssertionStatus());
        private int aqF;
        private boolean aqG;
        private boolean aqH;
        private int bJY;
        private int bJZ;
        private boolean bKa;
        private int mPosition;

        static {
            AppMethodBeat.i(62319);
            AppMethodBeat.o(62319);
        }

        private a() {
            this.bJZ = 0;
        }

        /* synthetic */ a(FlexboxLayoutManager flexboxLayoutManager, byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(62315);
            String str = "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.bJY + ", mCoordinate=" + this.aqF + ", mPerpendicularCoordinate=" + this.bJZ + ", mLayoutFromEnd=" + this.aqG + ", mValid=" + this.aqH + ", mAssignedFromSavedState=" + this.bKa + '}';
            AppMethodBeat.o(62315);
            return str;
        }

        static /* synthetic */ void b(a aVar) {
            boolean z = true;
            AppMethodBeat.i(62316);
            aVar.mPosition = -1;
            aVar.bJY = -1;
            aVar.aqF = Integer.MIN_VALUE;
            aVar.aqH = false;
            aVar.bKa = false;
            if (FlexboxLayoutManager.this.xC()) {
                if (FlexboxLayoutManager.this.bJs == 0) {
                    if (FlexboxLayoutManager.this.bJr != 1) {
                        z = false;
                    }
                    aVar.aqG = z;
                    AppMethodBeat.o(62316);
                    return;
                }
                if (FlexboxLayoutManager.this.bJs != 2) {
                    z = false;
                }
                aVar.aqG = z;
                AppMethodBeat.o(62316);
            } else if (FlexboxLayoutManager.this.bJs == 0) {
                if (FlexboxLayoutManager.this.bJr != 3) {
                    z = false;
                }
                aVar.aqG = z;
                AppMethodBeat.o(62316);
            } else {
                if (FlexboxLayoutManager.this.bJs != 2) {
                    z = false;
                }
                aVar.aqG = z;
                AppMethodBeat.o(62316);
            }
        }

        static /* synthetic */ void g(a aVar) {
            int kH;
            int width;
            AppMethodBeat.i(62317);
            if (FlexboxLayoutManager.this.xC() || !FlexboxLayoutManager.this.mIsRtl) {
                if (aVar.aqG) {
                    kH = FlexboxLayoutManager.this.aqs.kI();
                } else {
                    kH = FlexboxLayoutManager.this.aqs.kH();
                }
                aVar.aqF = kH;
                AppMethodBeat.o(62317);
                return;
            }
            if (aVar.aqG) {
                width = FlexboxLayoutManager.this.aqs.kI();
            } else {
                width = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.aqs.kH();
            }
            aVar.aqF = width;
            AppMethodBeat.o(62317);
        }

        static /* synthetic */ void a(a aVar, View view) {
            int i2 = 0;
            AppMethodBeat.i(62318);
            if (FlexboxLayoutManager.this.xC() || !FlexboxLayoutManager.this.mIsRtl) {
                if (aVar.aqG) {
                    aVar.aqF = FlexboxLayoutManager.this.aqs.bp(view) + FlexboxLayoutManager.this.aqs.kG();
                } else {
                    aVar.aqF = FlexboxLayoutManager.this.aqs.bo(view);
                }
            } else if (aVar.aqG) {
                aVar.aqF = FlexboxLayoutManager.this.aqs.bo(view) + FlexboxLayoutManager.this.aqs.kG();
            } else {
                aVar.aqF = FlexboxLayoutManager.this.aqs.bp(view);
            }
            aVar.mPosition = FlexboxLayoutManager.this.getPosition(view);
            aVar.bKa = false;
            if ($assertionsDisabled || FlexboxLayoutManager.this.bJF.bJm != null) {
                int i3 = FlexboxLayoutManager.this.bJF.bJm[aVar.mPosition != -1 ? aVar.mPosition : 0];
                if (i3 != -1) {
                    i2 = i3;
                }
                aVar.bJY = i2;
                if (FlexboxLayoutManager.this.bJp.size() > aVar.bJY) {
                    aVar.mPosition = ((b) FlexboxLayoutManager.this.bJp.get(aVar.bJY)).bJj;
                }
                AppMethodBeat.o(62318);
                return;
            }
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62318);
            throw assertionError;
        }
    }

    /* access modifiers changed from: package-private */
    public static class b {
        int apY;
        int aqK;
        int aqN;
        int aqa;
        boolean aqe;
        int bJY;
        boolean bKc;
        int fs;
        int mLayoutDirection;
        int mPosition;

        private b() {
            this.aqa = 1;
            this.mLayoutDirection = 1;
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        static /* synthetic */ int a(b bVar) {
            int i2 = bVar.bJY;
            bVar.bJY = i2 + 1;
            return i2;
        }

        static /* synthetic */ int b(b bVar) {
            int i2 = bVar.bJY;
            bVar.bJY = i2 - 1;
            return i2;
        }

        public final String toString() {
            AppMethodBeat.i(62324);
            String str = "LayoutState{mAvailable=" + this.apY + ", mFlexLinePosition=" + this.bJY + ", mPosition=" + this.mPosition + ", mOffset=" + this.fs + ", mScrollingOffset=" + this.aqK + ", mLastScrollDelta=" + this.aqN + ", mItemDirection=" + this.aqa + ", mLayoutDirection=" + this.mLayoutDirection + '}';
            AppMethodBeat.o(62324);
            return str;
        }
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.google.android.flexbox.FlexboxLayoutManager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(62325);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(62325);
                return savedState;
            }
        };
        private int aqP;
        private int aqQ;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        /* synthetic */ SavedState(SavedState savedState, byte b2) {
            this(savedState);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(62326);
            parcel.writeInt(this.aqP);
            parcel.writeInt(this.aqQ);
            AppMethodBeat.o(62326);
        }

        SavedState() {
        }

        private SavedState(Parcel parcel) {
            AppMethodBeat.i(62327);
            this.aqP = parcel.readInt();
            this.aqQ = parcel.readInt();
            AppMethodBeat.o(62327);
        }

        private SavedState(SavedState savedState) {
            this.aqP = savedState.aqP;
            this.aqQ = savedState.aqQ;
        }

        static {
            AppMethodBeat.i(62329);
            AppMethodBeat.o(62329);
        }

        public String toString() {
            AppMethodBeat.i(62328);
            String str = "SavedState{mAnchorPosition=" + this.aqP + ", mAnchorOffset=" + this.aqQ + '}';
            AppMethodBeat.o(62328);
            return str;
        }

        static /* synthetic */ boolean c(SavedState savedState, int i2) {
            return savedState.aqP >= 0 && savedState.aqP < i2;
        }
    }

    private int a(RecyclerView.n nVar, RecyclerView.s sVar, b bVar) {
        boolean z;
        int a2;
        int i2;
        float f2;
        float f3;
        int i3;
        float f4;
        AppMethodBeat.i(62363);
        if (bVar.aqK != Integer.MIN_VALUE) {
            if (bVar.apY < 0) {
                bVar.aqK += bVar.apY;
            }
            a(nVar, bVar);
        }
        int i4 = bVar.apY;
        int i5 = bVar.apY;
        boolean xC = xC();
        int i6 = 0;
        int i7 = i5;
        while (true) {
            if (i7 > 0 || this.bJP.aqe) {
                List<b> list = this.bJp;
                if (bVar.mPosition < 0 || bVar.mPosition >= sVar.getItemCount() || bVar.bJY < 0 || bVar.bJY >= list.size()) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    b bVar2 = this.bJp.get(bVar.bJY);
                    bVar.mPosition = bVar2.bJj;
                    if (!xC()) {
                        a2 = a(bVar2, bVar);
                    } else if ($assertionsDisabled || this.bJF.bJn != null) {
                        int paddingLeft = getPaddingLeft();
                        int paddingRight = getPaddingRight();
                        int width = getWidth();
                        int i8 = bVar.fs;
                        if (bVar.mLayoutDirection == -1) {
                            i2 = i8 - bVar2.bJc;
                        } else {
                            i2 = i8;
                        }
                        int i9 = bVar.mPosition;
                        float f5 = 0.0f;
                        switch (this.bJt) {
                            case 0:
                                f2 = (float) paddingLeft;
                                f3 = (float) (width - paddingRight);
                                break;
                            case 1:
                                f2 = (float) ((width - bVar2.bJa) + paddingRight);
                                f3 = (float) (bVar2.bJa - paddingLeft);
                                break;
                            case 2:
                                f2 = ((float) paddingLeft) + (((float) (width - bVar2.bJa)) / 2.0f);
                                f3 = ((float) (width - paddingRight)) - (((float) (width - bVar2.bJa)) / 2.0f);
                                break;
                            case 3:
                                f2 = (float) paddingLeft;
                                f5 = ((float) (width - bVar2.bJa)) / (bVar2.auc != 1 ? (float) (bVar2.auc - 1) : 1.0f);
                                f3 = (float) (width - paddingRight);
                                break;
                            case 4:
                                if (bVar2.auc != 0) {
                                    f5 = ((float) (width - bVar2.bJa)) / ((float) bVar2.auc);
                                }
                                f2 = ((float) paddingLeft) + (f5 / 2.0f);
                                f3 = ((float) (width - paddingRight)) - (f5 / 2.0f);
                                break;
                            case 5:
                                if (bVar2.auc != 0) {
                                    f5 = ((float) (width - bVar2.bJa)) / ((float) (bVar2.auc + 1));
                                }
                                f2 = ((float) paddingLeft) + f5;
                                f3 = ((float) (width - paddingRight)) - f5;
                                break;
                            default:
                                IllegalStateException illegalStateException = new IllegalStateException("Invalid justifyContent is set: " + this.bJt);
                                AppMethodBeat.o(62363);
                                throw illegalStateException;
                        }
                        float f6 = f2 - ((float) this.bJQ.bJZ);
                        float f7 = f3 - ((float) this.bJQ.bJZ);
                        float max = Math.max(f5, 0.0f);
                        int i10 = 0;
                        int i11 = bVar2.auc;
                        float f8 = f6;
                        for (int i12 = i9; i12 < i9 + i11; i12++) {
                            View fj = fj(i12);
                            if (fj != null) {
                                if (bVar.mLayoutDirection == 1) {
                                    calculateItemDecorationsForChild(fj, bJN);
                                    addView(fj);
                                    i3 = i10;
                                } else {
                                    calculateItemDecorationsForChild(fj, bJN);
                                    addView(fj, i10);
                                    i3 = i10 + 1;
                                }
                                long j2 = this.bJF.bJn[i12];
                                int at = c.at(j2);
                                int au = c.au(j2);
                                LayoutParams layoutParams = (LayoutParams) fj.getLayoutParams();
                                if (shouldMeasureChild(fj, at, au, layoutParams)) {
                                    fj.measure(at, au);
                                }
                                float leftDecorationWidth = f8 + ((float) (layoutParams.leftMargin + getLeftDecorationWidth(fj)));
                                float rightDecorationWidth = f7 - ((float) (layoutParams.rightMargin + getRightDecorationWidth(fj)));
                                int topDecorationHeight = i2 + getTopDecorationHeight(fj);
                                if (this.mIsRtl) {
                                    this.bJF.a(fj, bVar2, Math.round(rightDecorationWidth) - fj.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth), fj.getMeasuredHeight() + topDecorationHeight);
                                } else {
                                    this.bJF.a(fj, bVar2, Math.round(leftDecorationWidth), topDecorationHeight, Math.round(leftDecorationWidth) + fj.getMeasuredWidth(), fj.getMeasuredHeight() + topDecorationHeight);
                                }
                                float leftDecorationWidth2 = rightDecorationWidth - (((float) (getLeftDecorationWidth(fj) + (fj.getMeasuredWidth() + layoutParams.leftMargin))) + max);
                                f4 = ((float) (fj.getMeasuredWidth() + layoutParams.rightMargin + getRightDecorationWidth(fj))) + max + leftDecorationWidth;
                                f7 = leftDecorationWidth2;
                            } else {
                                i3 = i10;
                                f4 = f8;
                            }
                            i10 = i3;
                            f8 = f4;
                        }
                        bVar.bJY += this.bJP.mLayoutDirection;
                        a2 = bVar2.bJc;
                    } else {
                        AssertionError assertionError = new AssertionError();
                        AppMethodBeat.o(62363);
                        throw assertionError;
                    }
                    int i13 = a2 + i6;
                    if (xC || !this.mIsRtl) {
                        bVar.fs += bVar2.bJc * bVar.mLayoutDirection;
                    } else {
                        bVar.fs -= bVar2.bJc * bVar.mLayoutDirection;
                    }
                    i6 = i13;
                    i7 -= bVar2.bJc;
                }
            }
        }
        bVar.apY -= i6;
        if (bVar.aqK != Integer.MIN_VALUE) {
            bVar.aqK += i6;
            if (bVar.apY < 0) {
                bVar.aqK += bVar.apY;
            }
            a(nVar, bVar);
        }
        int i14 = i4 - bVar.apY;
        AppMethodBeat.o(62363);
        return i14;
    }

    private void a(RecyclerView.n nVar, b bVar) {
        AppMethodBeat.i(62364);
        if (!bVar.bKc) {
            AppMethodBeat.o(62364);
        } else if (bVar.mLayoutDirection == -1) {
            c(nVar, bVar);
            AppMethodBeat.o(62364);
        } else {
            b(nVar, bVar);
            AppMethodBeat.o(62364);
        }
    }

    private void b(RecyclerView.n nVar, b bVar) {
        int i2 = -1;
        AppMethodBeat.i(62365);
        if (bVar.aqK < 0) {
            AppMethodBeat.o(62365);
        } else if ($assertionsDisabled || this.bJF.bJm != null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                AppMethodBeat.o(62365);
                return;
            }
            int i3 = this.bJF.bJm[getPosition(getChildAt(0))];
            if (i3 == -1) {
                AppMethodBeat.o(62365);
                return;
            }
            b bVar2 = this.bJp.get(i3);
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i4);
                if (!I(childAt, bVar.aqK)) {
                    break;
                }
                if (bVar2.acn == getPosition(childAt)) {
                    if (i3 >= this.bJp.size() - 1) {
                        i2 = i4;
                        break;
                    }
                    i3 += bVar.mLayoutDirection;
                    bVar2 = this.bJp.get(i3);
                    i2 = i4;
                }
                i4++;
            }
            a(nVar, 0, i2);
            AppMethodBeat.o(62365);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62365);
            throw assertionError;
        }
    }

    private void c(RecyclerView.n nVar, b bVar) {
        AppMethodBeat.i(62367);
        if (bVar.aqK < 0) {
            AppMethodBeat.o(62367);
        } else if ($assertionsDisabled || this.bJF.bJm != null) {
            this.aqs.getEnd();
            int childCount = getChildCount();
            if (childCount == 0) {
                AppMethodBeat.o(62367);
                return;
            }
            int i2 = this.bJF.bJm[getPosition(getChildAt(childCount - 1))];
            if (i2 == -1) {
                AppMethodBeat.o(62367);
                return;
            }
            int i3 = childCount - 1;
            b bVar2 = this.bJp.get(i2);
            int i4 = i3;
            while (true) {
                if (i4 < 0) {
                    break;
                }
                View childAt = getChildAt(i4);
                if (!J(childAt, bVar.aqK)) {
                    break;
                }
                if (bVar2.bJj == getPosition(childAt)) {
                    if (i2 <= 0) {
                        childCount = i4;
                        break;
                    }
                    i2 += bVar.mLayoutDirection;
                    bVar2 = this.bJp.get(i2);
                    childCount = i4;
                }
                i4--;
            }
            a(nVar, childCount, i3);
            AppMethodBeat.o(62367);
        } else {
            AssertionError assertionError = new AssertionError();
            AppMethodBeat.o(62367);
            throw assertionError;
        }
    }
}
