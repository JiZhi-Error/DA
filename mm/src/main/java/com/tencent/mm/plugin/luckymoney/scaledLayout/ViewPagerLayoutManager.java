package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public abstract class ViewPagerLayoutManager extends LinearLayoutManager {
    private boolean aqA;
    private boolean aqe = false;
    private boolean aqu = false;
    private boolean aqv = false;
    private boolean aqx = true;
    private int aqy = -1;
    public int mOrientation;
    int yYA = -1;
    private Interpolator yYB;
    int yYC = Integer.MAX_VALUE;
    private View yYD;
    private SparseArray<View> yYo = new SparseArray<>();
    protected int yYp;
    protected int yYq;
    protected int yYr;
    protected int yYs;
    protected float yYt;
    protected b yYu;
    private SavedState yYv = null;
    protected float yYw;
    private boolean yYx;
    private int yYy;
    private int yYz;

    /* access modifiers changed from: protected */
    public abstract float efn();

    /* access modifiers changed from: protected */
    public abstract void v(View view, float f2);

    public ViewPagerLayoutManager(int i2, boolean z) {
        setOrientation(i2);
        ao(z);
        setAutoMeasureEnabled(true);
        setItemPrefetchEnabled(false);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.n nVar) {
        super.onDetachedFromWindow(recyclerView, nVar);
        if (this.aqA) {
            removeAndRecycleAllViews(nVar);
            nVar.clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.yYv != null) {
            return new SavedState(this.yYv);
        }
        SavedState savedState = new SavedState();
        savedState.position = this.aqy;
        savedState.offset = this.yYt;
        savedState.yYE = this.aqv;
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.yYv = new SavedState((SavedState) parcelable);
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final int getOrientation() {
        return this.mOrientation;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void setOrientation(int i2) {
        if (i2 == 0 || i2 == 1) {
            assertNotInLayoutOrScroll(null);
            if (i2 != this.mOrientation) {
                this.mOrientation = i2;
                this.yYu = null;
                this.yYC = Integer.MAX_VALUE;
                removeAllViews();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation:".concat(String.valueOf(i2)));
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void ao(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.aqu) {
            this.aqu = z;
            removeAllViews();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        int AE;
        int i3;
        if (this.aqe) {
            int currentPosition = getCurrentPosition();
            int itemCount = getItemCount();
            if (i2 < currentPosition) {
                int i4 = currentPosition - i2;
                int i5 = (itemCount - currentPosition) + i2;
                i3 = i4 < i5 ? currentPosition - i4 : currentPosition + i5;
            } else {
                int i6 = i2 - currentPosition;
                int i7 = (itemCount + currentPosition) - i2;
                i3 = i6 < i7 ? currentPosition + i6 : currentPosition - i7;
            }
            AE = AE(i3);
        } else {
            AE = AE(i2);
        }
        if (this.mOrientation == 1) {
            recyclerView.a(0, AE, this.yYB);
        } else {
            recyclerView.a(AE, 0, this.yYB);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        ViewPagerLayoutManager viewPagerLayoutManager;
        boolean z;
        if (sVar.getItemCount() == 0) {
            removeAndRecycleAllViews(nVar);
            this.yYt = 0.0f;
            return;
        }
        km();
        if (this.mOrientation == 1 || !jH()) {
            z = this.aqu;
            viewPagerLayoutManager = this;
        } else if (!this.aqu) {
            z = true;
            viewPagerLayoutManager = this;
        } else {
            z = false;
            viewPagerLayoutManager = this;
        }
        viewPagerLayoutManager.aqv = z;
        View d2 = d(nVar, sVar, 0);
        if (d2 == null) {
            removeAndRecycleAllViews(nVar);
            this.yYt = 0.0f;
            return;
        }
        measureChildWithMargins(d2, 0, 0);
        this.yYp = this.yYu.bs(d2);
        this.yYq = this.yYu.bt(d2);
        this.yYr = (this.yYu.kJ() - this.yYp) / 2;
        if (this.yYC == Integer.MAX_VALUE) {
            this.yYs = (this.yYu.efm() - this.yYq) / 2;
        } else {
            this.yYs = (this.yYu.efm() - this.yYq) - this.yYC;
        }
        this.yYw = efn();
        efp();
        if (this.yYw == 0.0f) {
            this.yYy = 1;
            this.yYz = 1;
        } else {
            this.yYy = ((int) Math.abs(efx() / this.yYw)) + 1;
            this.yYz = ((int) Math.abs(efw() / this.yYw)) + 1;
        }
        if (this.yYv != null) {
            this.aqv = this.yYv.yYE;
            this.aqy = this.yYv.position;
            this.yYt = this.yYv.offset;
        }
        if (this.aqy != -1) {
            this.yYt = this.aqv ? ((float) this.aqy) * (-this.yYw) : ((float) this.aqy) * this.yYw;
        }
        b(nVar);
    }

    private static View d(RecyclerView.n nVar, RecyclerView.s sVar, int i2) {
        while (i2 < sVar.getItemCount() && i2 >= 0) {
            try {
                return nVar.cp(i2);
            } catch (Exception e2) {
                i2++;
            }
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutCompleted(RecyclerView.s sVar) {
        super.onLayoutCompleted(sVar);
        this.yYv = null;
        this.aqy = -1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
        boolean z;
        int i4;
        int currentPosition = getCurrentPosition();
        View findViewByPosition = findViewByPosition(currentPosition);
        if (findViewByPosition != null) {
            if (recyclerView.hasFocus()) {
                if (this.mOrientation == 1) {
                    z = i2 == 33 ? !this.aqv : i2 == 130 ? this.aqv : true;
                } else if (i2 == 17) {
                    z = !this.aqv;
                } else {
                    z = i2 == 66 ? this.aqv : true;
                }
                if (!z) {
                    if (z) {
                        i4 = currentPosition - 1;
                    } else {
                        i4 = currentPosition + 1;
                    }
                    int AE = AE(i4);
                    if (this.mOrientation == 1) {
                        recyclerView.a(0, AE, (Interpolator) null);
                    } else {
                        recyclerView.a(AE, 0, (Interpolator) null);
                    }
                }
            } else {
                findViewByPosition.addFocusables(arrayList, i2, i3);
            }
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public View onFocusSearchFailed(View view, int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        return null;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final void km() {
        if (this.yYu == null) {
            this.yYu = b.b(this, this.mOrientation);
        }
    }

    /* access modifiers changed from: protected */
    public void efp() {
    }

    private float PL(int i2) {
        return this.aqv ? ((float) i2) * (-this.yYw) : ((float) i2) * this.yYw;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.a aVar, RecyclerView.a aVar2) {
        removeAllViews();
        this.yYt = 0.0f;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void scrollToPosition(int i2) {
        if (this.aqe || (i2 >= 0 && i2 < getItemCount())) {
            this.aqy = i2;
            this.yYt = this.aqv ? ((float) i2) * (-this.yYw) : ((float) i2) * this.yYw;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.s sVar) {
        return efq();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int computeVerticalScrollOffset(RecyclerView.s sVar) {
        return efq();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.s sVar) {
        return efr();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int computeVerticalScrollExtent(RecyclerView.s sVar) {
        return efr();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int computeHorizontalScrollRange(RecyclerView.s sVar) {
        return efs();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int computeVerticalScrollRange(RecyclerView.s sVar) {
        return efs();
    }

    private int efq() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.aqx) {
            return !this.aqv ? getCurrentPosition() : (getItemCount() - getCurrentPosition()) - 1;
        }
        float efz = efz();
        return !this.aqv ? (int) efz : (int) (efz + (((float) (getItemCount() - 1)) * this.yYw));
    }

    private int efr() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.aqx) {
            return 1;
        }
        return (int) this.yYw;
    }

    private int efs() {
        if (getChildCount() == 0) {
            return 0;
        }
        if (!this.aqx) {
            return getItemCount();
        }
        return (int) (((float) getItemCount()) * this.yYw);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return a(i2, nVar);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return a(i2, nVar);
    }

    private int a(int i2, RecyclerView.n nVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        km();
        float efo = ((float) i2) / efo();
        if (Math.abs(efo) < 1.0E-8f) {
            return 0;
        }
        float f2 = this.yYt + efo;
        if (!this.aqe && f2 < efv()) {
            i2 = (int) (((float) i2) - ((f2 - efv()) * efo()));
        } else if (!this.aqe && f2 > efu()) {
            i2 = (int) ((efu() - this.yYt) * efo());
        }
        this.yYt = (((float) i2) / efo()) + this.yYt;
        b(nVar);
        return i2;
    }

    private void b(RecyclerView.n nVar) {
        float f2;
        int i2;
        boolean z;
        detachAndScrapAttachedViews(nVar);
        this.yYo.clear();
        int itemCount = getItemCount();
        if (itemCount != 0) {
            int efy = this.aqv ? -efy() : efy();
            int i3 = efy - this.yYy;
            int i4 = this.yYz + efy;
            if (eft()) {
                if (this.yYA % 2 == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    int i5 = this.yYA / 2;
                    i3 = (efy - i5) + 1;
                    i4 = i5 + efy + 1;
                } else {
                    int i6 = (this.yYA - 1) / 2;
                    i3 = efy - i6;
                    i4 = i6 + efy + 1;
                }
            }
            if (!this.aqe) {
                if (i3 < 0) {
                    if (eft()) {
                        i4 = this.yYA;
                        i3 = 0;
                    } else {
                        i3 = 0;
                    }
                }
                if (i4 > itemCount) {
                    i4 = itemCount;
                }
            }
            float f3 = Float.MIN_VALUE;
            int i7 = i3;
            while (i7 < i4) {
                if (eft() || !br(PL(i7) - this.yYt)) {
                    if (i7 >= itemCount) {
                        i2 = i7 % itemCount;
                    } else if (i7 < 0) {
                        int i8 = (-i7) % itemCount;
                        if (i8 == 0) {
                            i8 = itemCount;
                        }
                        i2 = itemCount - i8;
                    } else {
                        i2 = i7;
                    }
                    View cp = nVar.cp(i2);
                    measureChildWithMargins(cp, 0, 0);
                    ep(cp);
                    w(cp, PL(i7) - this.yYt);
                    f2 = this.yYx ? 0.0f : (float) i2;
                    if (f2 > f3) {
                        addView(cp);
                    } else {
                        addView(cp, 0);
                    }
                    if (i7 == efy) {
                        this.yYD = cp;
                    }
                    this.yYo.put(i7, cp);
                } else {
                    f2 = f3;
                }
                i7++;
                f3 = f2;
            }
            this.yYD.requestFocus();
        }
    }

    private boolean eft() {
        return this.yYA != -1;
    }

    private boolean br(float f2) {
        return f2 > efw() || f2 < efx();
    }

    private static void ep(View view) {
        view.setRotation(0.0f);
        view.setRotationY(0.0f);
        view.setRotationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
    }

    private float efu() {
        if (!this.aqv) {
            return ((float) (getItemCount() - 1)) * this.yYw;
        }
        return 0.0f;
    }

    private float efv() {
        if (!this.aqv) {
            return 0.0f;
        }
        return ((float) (-(getItemCount() - 1))) * this.yYw;
    }

    private void w(View view, float f2) {
        int bs = bs(f2);
        int bt = bt(f2);
        if (this.mOrientation == 1) {
            layoutDecorated(view, this.yYs + bs, this.yYr + bt, this.yYq + bs + this.yYs, this.yYr + bt + this.yYp);
        } else {
            layoutDecorated(view, this.yYr + bs, this.yYs + bt, this.yYp + bs + this.yYr, this.yYs + bt + this.yYq);
        }
        v(view, f2);
    }

    private int bs(float f2) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return (int) f2;
    }

    private int bt(float f2) {
        if (this.mOrientation == 1) {
            return (int) f2;
        }
        return 0;
    }

    private float efw() {
        return (float) (this.yYu.kJ() - this.yYr);
    }

    private float efx() {
        return (float) (((-this.yYp) - this.yYu.kH()) - this.yYr);
    }

    /* access modifiers changed from: protected */
    public float efo() {
        return 1.0f;
    }

    private int getCurrentPosition() {
        int itemCount;
        if (getItemCount() == 0) {
            return 0;
        }
        int efy = efy();
        if (!this.aqe) {
            return Math.abs(efy);
        }
        if (!this.aqv) {
            if (efy >= 0) {
                itemCount = efy % getItemCount();
            } else {
                itemCount = (efy % getItemCount()) + getItemCount();
            }
        } else if (efy > 0) {
            itemCount = getItemCount() - (efy % getItemCount());
        } else {
            itemCount = (-efy) % getItemCount();
        }
        if (itemCount == getItemCount()) {
            return 0;
        }
        return itemCount;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public View findViewByPosition(int i2) {
        int itemCount = getItemCount();
        if (itemCount == 0) {
            return null;
        }
        for (int i3 = 0; i3 < this.yYo.size(); i3++) {
            int keyAt = this.yYo.keyAt(i3);
            if (keyAt < 0) {
                int i4 = keyAt % itemCount;
                if (i4 == 0) {
                    i4 = -itemCount;
                }
                if (i4 + itemCount == i2) {
                    return this.yYo.valueAt(i3);
                }
            } else if (i2 == keyAt % itemCount) {
                return this.yYo.valueAt(i3);
            }
        }
        return null;
    }

    private int efy() {
        if (this.yYw == 0.0f) {
            return 0;
        }
        return Math.round(this.yYt / this.yYw);
    }

    private float efz() {
        if (this.aqv) {
            if (!this.aqe) {
                return this.yYt;
            }
            if (this.yYt <= 0.0f) {
                return this.yYt % (this.yYw * ((float) getItemCount()));
            }
            return (((float) getItemCount()) * (-this.yYw)) + (this.yYt % (this.yYw * ((float) getItemCount())));
        } else if (!this.aqe) {
            return this.yYt;
        } else {
            if (this.yYt >= 0.0f) {
                return this.yYt % (this.yYw * ((float) getItemCount()));
            }
            return (((float) getItemCount()) * this.yYw) + (this.yYt % (this.yYw * ((float) getItemCount())));
        }
    }

    public final int AE(int i2) {
        if (this.aqe) {
            return (int) (((((float) ((!this.aqv ? i2 - efy() : (-efy()) - i2) + efy())) * this.yYw) - this.yYt) * efo());
        }
        return (int) ((((!this.aqv ? this.yYw : -this.yYw) * ((float) i2)) - this.yYt) * efo());
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.plugin.luckymoney.scaledLayout.ViewPagerLayoutManager.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(65340);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.o(65340);
                return savedState;
            }
        };
        float offset;
        int position;
        boolean yYE;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(65341);
            this.position = parcel.readInt();
            this.offset = parcel.readFloat();
            this.yYE = parcel.readInt() != 1 ? false : z;
            AppMethodBeat.o(65341);
        }

        public SavedState(SavedState savedState) {
            this.position = savedState.position;
            this.offset = savedState.offset;
            this.yYE = savedState.yYE;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(65342);
            parcel.writeInt(this.position);
            parcel.writeFloat(this.offset);
            parcel.writeInt(this.yYE ? 1 : 0);
            AppMethodBeat.o(65342);
        }

        static {
            AppMethodBeat.i(65343);
            AppMethodBeat.o(65343);
        }
    }
}
