package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.gridviewheaders.c;
import java.util.ArrayList;

public class GridHeadersGridView extends GridView implements AbsListView.OnScrollListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, AdapterView.OnItemSelectedListener {
    private AbsListView.OnScrollListener FcF;
    protected boolean OOC;
    private int OOj;
    private int OOk;
    private Runnable OSV;
    private AdapterView.OnItemLongClickListener OZU;
    private float QkA;
    private boolean QkB;
    private int QkC;
    c QkD;
    d QkE;
    private e QkF;
    private View QkG;
    protected c QkH;
    protected int QkI;
    private boolean QkJ;
    public a Qkr;
    public b Qks;
    private boolean Qkt;
    private final Rect Qku;
    private boolean Qkv;
    private boolean Qkw;
    private int Qkx;
    private long Qky;
    private int Qkz;
    private DataSetObserver Tr;
    private AdapterView.OnItemSelectedListener Yj;
    private AdapterView.OnItemClickListener awr;
    protected int ayc;
    private MMHandler mHandler;
    private int mNumColumns;
    private int mScrollState;
    private int mTouchSlop;

    public interface c {
        void dE(View view);
    }

    public interface d {
        boolean gWu();
    }

    static /* synthetic */ void a(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.i(142834);
        gridHeadersGridView.reset();
        AppMethodBeat.o(142834);
    }

    static /* synthetic */ int b(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.i(142836);
        int windowAttachCount = gridHeadersGridView.getWindowAttachCount();
        AppMethodBeat.o(142836);
        return windowAttachCount;
    }

    static /* synthetic */ int c(GridHeadersGridView gridHeadersGridView) {
        AppMethodBeat.i(142837);
        int windowAttachCount = gridHeadersGridView.getWindowAttachCount();
        AppMethodBeat.o(142837);
        return windowAttachCount;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter adapter) {
        AppMethodBeat.i(142833);
        setAdapter((ListAdapter) adapter);
        AppMethodBeat.o(142833);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842865);
    }

    public GridHeadersGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142806);
        this.mHandler = new MMHandler();
        this.Qkt = true;
        this.Qku = new Rect();
        this.Qky = -1;
        this.Tr = new DataSetObserver() {
            /* class com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.AnonymousClass1 */

            public final void onChanged() {
                AppMethodBeat.i(142793);
                GridHeadersGridView.a(GridHeadersGridView.this);
                AppMethodBeat.o(142793);
            }

            public final void onInvalidated() {
                AppMethodBeat.i(142794);
                GridHeadersGridView.a(GridHeadersGridView.this);
                AppMethodBeat.o(142794);
            }
        };
        this.QkC = 1;
        this.mScrollState = 0;
        this.QkJ = true;
        super.setOnScrollListener(this);
        setVerticalFadingEdgeEnabled(false);
        if (!this.QkB) {
            this.mNumColumns = -1;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(142806);
    }

    public final View aof(int i2) {
        AppMethodBeat.i(142807);
        if (i2 == -2) {
            View view = this.QkG;
            AppMethodBeat.o(142807);
            return view;
        }
        try {
            View view2 = (View) getChildAt(i2).getTag();
            AppMethodBeat.o(142807);
            return view2;
        } catch (Exception e2) {
            AppMethodBeat.o(142807);
            return null;
        }
    }

    public View getStickiedHeader() {
        return this.QkG;
    }

    public boolean getStickyHeaderIsTranscluent() {
        return !this.QkJ;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(142808);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        this.awr.onItemClick(adapterView, view, this.QkH.aoe(i2).mPosition, j2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142808);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(142809);
        boolean onItemLongClick = this.OZU.onItemLongClick(adapterView, view, this.QkH.aoe(i2).mPosition, j2);
        AppMethodBeat.o(142809);
        return onItemLongClick;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
        AppMethodBeat.i(142810);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(adapterView);
        bVar.bm(view);
        bVar.pH(i2);
        bVar.zo(j2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
        this.Yj.onItemSelected(adapterView, view, this.QkH.aoe(i2).mPosition, j2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/gridviewheaders/GridHeadersGridView", "android/widget/AdapterView$OnItemSelectedListener", "onItemSelected", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(142810);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
        AppMethodBeat.i(142811);
        this.Yj.onNothingSelected(adapterView);
        AppMethodBeat.o(142811);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(142812);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.Qkt = savedState.QkO;
        requestLayout();
        AppMethodBeat.o(142812);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(142813);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.QkO = this.Qkt;
        AppMethodBeat.o(142813);
        return savedState;
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(142814);
        if (this.FcF != null) {
            this.FcF.onScroll(absListView, i2, i3, i4);
        }
        if (Build.VERSION.SDK_INT >= 8) {
            aog(i2);
        }
        AppMethodBeat.o(142814);
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(142815);
        if (this.FcF != null) {
            this.FcF.onScrollStateChanged(absListView, i2);
        }
        this.mScrollState = i2;
        AppMethodBeat.o(142815);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        b dVar;
        AppMethodBeat.i(142817);
        if (!(this.QkH == null || this.Tr == null)) {
            this.QkH.unregisterDataSetObserver(this.Tr);
        }
        if (!this.Qkw) {
            this.Qkv = true;
        }
        if (listAdapter instanceof b) {
            dVar = (b) listAdapter;
        } else if (listAdapter instanceof e) {
            dVar = new f((e) listAdapter);
        } else {
            dVar = new d(listAdapter);
        }
        this.QkH = new c(getContext(), this, dVar);
        this.QkH.registerDataSetObserver(this.Tr);
        reset();
        super.setAdapter((ListAdapter) this.QkH);
        AppMethodBeat.o(142817);
    }

    public void setAreHeadersSticky(boolean z) {
        AppMethodBeat.i(142818);
        if (z != this.Qkt) {
            this.Qkt = z;
            requestLayout();
        }
        AppMethodBeat.o(142818);
    }

    public void setClipToPadding(boolean z) {
        AppMethodBeat.i(142819);
        super.setClipToPadding(z);
        this.Qkv = z;
        this.Qkw = true;
        AppMethodBeat.o(142819);
    }

    public void setColumnWidth(int i2) {
        AppMethodBeat.i(142820);
        super.setColumnWidth(i2);
        this.Qkx = i2;
        AppMethodBeat.o(142820);
    }

    public void setHorizontalSpacing(int i2) {
        AppMethodBeat.i(142821);
        super.setHorizontalSpacing(i2);
        this.OOj = i2;
        AppMethodBeat.o(142821);
    }

    public void setNumColumns(int i2) {
        AppMethodBeat.i(142822);
        super.setNumColumns(i2);
        this.QkB = true;
        this.mNumColumns = i2;
        if (!(i2 == -1 || this.QkH == null)) {
            this.QkH.setNumColumns(i2);
        }
        AppMethodBeat.o(142822);
    }

    public void setOnHeaderClickListener(c cVar) {
        this.QkD = cVar;
    }

    public void setOnHeaderLongClickListener(d dVar) {
        AppMethodBeat.i(142823);
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.QkE = dVar;
        AppMethodBeat.o(142823);
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(142824);
        this.awr = onItemClickListener;
        super.setOnItemClickListener(this);
        AppMethodBeat.o(142824);
    }

    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.i(142825);
        this.OZU = onItemLongClickListener;
        super.setOnItemLongClickListener(this);
        AppMethodBeat.o(142825);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        AppMethodBeat.i(142826);
        this.Yj = onItemSelectedListener;
        super.setOnItemSelectedListener(this);
        AppMethodBeat.o(142826);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.FcF = onScrollListener;
    }

    public void setStickyHeaderIsTranscluent(boolean z) {
        this.QkJ = !z;
    }

    public void setVerticalSpacing(int i2) {
        AppMethodBeat.i(142827);
        super.setVerticalSpacing(i2);
        this.OOk = i2;
        AppMethodBeat.o(142827);
    }

    private int getHeaderHeight() {
        AppMethodBeat.i(142828);
        if (this.QkG != null) {
            int measuredHeight = this.QkG.getMeasuredHeight();
            AppMethodBeat.o(142828);
            return measuredHeight;
        }
        AppMethodBeat.o(142828);
        return 0;
    }

    private void gWt() {
        int makeMeasureSpec;
        AppMethodBeat.i(142829);
        if (this.QkG == null) {
            AppMethodBeat.o(142829);
            return;
        }
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        ViewGroup.LayoutParams layoutParams = this.QkG.getLayoutParams();
        if (layoutParams == null || layoutParams.height <= 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        }
        this.QkG.measure(makeMeasureSpec2, makeMeasureSpec);
        this.QkG.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.QkG.getMeasuredHeight());
        AppMethodBeat.o(142829);
    }

    private void reset() {
        this.Qkz = 0;
        this.QkG = null;
        this.Qky = Long.MIN_VALUE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aog(int r10) {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.aog(int):void");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(142831);
        if (Build.VERSION.SDK_INT < 8) {
            aog(getFirstVisiblePosition());
        }
        boolean z = this.QkG != null && this.Qkt && this.QkG.getVisibility() == 0;
        int headerHeight = getHeaderHeight();
        int i2 = this.Qkz - headerHeight;
        if (z && this.QkJ) {
            this.Qku.left = getPaddingLeft();
            this.Qku.right = getWidth() - getPaddingRight();
            this.Qku.top = this.Qkz;
            this.Qku.bottom = getHeight();
            canvas.save();
            canvas.clipRect(this.Qku);
        }
        super.dispatchDraw(canvas);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        while (firstVisiblePosition <= getLastVisiblePosition()) {
            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                arrayList.add(Integer.valueOf(i3));
            }
            firstVisiblePosition += this.QkC;
            i3 += this.QkC;
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            c.d dVar = (c.d) getChildAt(((Integer) arrayList.get(i4)).intValue());
            try {
                View view = (View) dVar.getTag();
                boolean z2 = ((long) ((c.b) dVar.getChildAt(0)).getHeaderId()) == this.Qky && dVar.getTop() < 0 && this.Qkt;
                if (view.getVisibility() == 0 && !z2) {
                    view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
                    view.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), dVar.getHeight());
                    this.Qku.left = getPaddingLeft();
                    this.Qku.right = getWidth() - getPaddingRight();
                    this.Qku.bottom = dVar.getBottom();
                    this.Qku.top = dVar.getTop();
                    canvas.save();
                    canvas.clipRect(this.Qku);
                    canvas.translate((float) getPaddingLeft(), (float) dVar.getTop());
                    view.draw(canvas);
                    canvas.restore();
                }
            } catch (Exception e2) {
                AppMethodBeat.o(142831);
                return;
            }
        }
        if (z && this.QkJ) {
            canvas.restore();
        } else if (!z) {
            AppMethodBeat.o(142831);
            return;
        }
        if (this.QkG.getWidth() != (getWidth() - getPaddingLeft()) - getPaddingRight()) {
            this.QkG.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), (1073741824 - getPaddingLeft()) - getPaddingRight()), View.MeasureSpec.makeMeasureSpec(0, 0));
            this.QkG.layout(getLeft() + getPaddingLeft(), 0, getRight() - getPaddingRight(), this.QkG.getHeight());
        }
        this.Qku.left = getPaddingLeft();
        this.Qku.right = getWidth() - getPaddingRight();
        this.Qku.bottom = i2 + headerHeight;
        if (this.Qkv) {
            this.Qku.top = getPaddingTop();
        } else {
            this.Qku.top = 0;
        }
        canvas.save();
        canvas.clipRect(this.Qku);
        canvas.translate((float) getPaddingLeft(), (float) i2);
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), (int) ((255.0f * ((float) this.Qkz)) / ((float) headerHeight)), 31);
        this.QkG.draw(canvas);
        canvas.restore();
        canvas.restore();
        AppMethodBeat.o(142831);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = 1;
        AppMethodBeat.i(142832);
        if (this.mNumColumns == -1) {
            if (this.Qkx > 0) {
                int max = Math.max((View.MeasureSpec.getSize(i2) - getPaddingLeft()) - getPaddingRight(), 0);
                int i5 = max / this.Qkx;
                if (i5 > 0) {
                    while (i5 != 1 && (this.Qkx * i5) + ((i5 - 1) * this.OOj) > max) {
                        i5--;
                    }
                    i4 = i5;
                }
            } else {
                i4 = 2;
            }
            this.QkC = i4;
        } else {
            this.QkC = this.mNumColumns;
        }
        if (this.QkH != null) {
            this.QkH.setNumColumns(this.QkC);
        }
        gWt();
        super.onMeasure(i2, i3);
        AppMethodBeat.o(142832);
    }

    class a extends f implements Runnable {
        private a() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ a(GridHeadersGridView gridHeadersGridView, byte b2) {
            this();
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(142796);
            View aof = GridHeadersGridView.this.aof(GridHeadersGridView.this.QkI);
            if (aof != null) {
                GridHeadersGridView.a(GridHeadersGridView.this, GridHeadersGridView.this.QkI);
                if (!gWw() || GridHeadersGridView.this.OOC) {
                    z = false;
                } else {
                    GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                    if (gridHeadersGridView.QkE != null) {
                        z = gridHeadersGridView.QkE.gWu();
                    } else {
                        z = false;
                    }
                    if (z) {
                        if (aof != null) {
                            aof.sendAccessibilityEvent(2);
                        }
                        gridHeadersGridView.performHapticFeedback(0);
                    }
                }
                if (z) {
                    GridHeadersGridView.this.ayc = -2;
                    GridHeadersGridView.this.setPressed(false);
                    aof.setPressed(false);
                    AppMethodBeat.o(142796);
                    return;
                }
                GridHeadersGridView.this.ayc = 2;
            }
            AppMethodBeat.o(142796);
        }
    }

    class e extends f implements Runnable {
        int QkN;

        private e() {
            super(GridHeadersGridView.this, (byte) 0);
        }

        /* synthetic */ e(GridHeadersGridView gridHeadersGridView, byte b2) {
            this();
        }

        public final void run() {
            View aof;
            AppMethodBeat.i(142798);
            if (GridHeadersGridView.this.OOC) {
                AppMethodBeat.o(142798);
                return;
            }
            if (GridHeadersGridView.this.QkH != null && GridHeadersGridView.this.QkH.getCount() > 0 && this.QkN != -1 && this.QkN < GridHeadersGridView.this.QkH.getCount() && gWw() && (aof = GridHeadersGridView.this.aof(this.QkN)) != null) {
                GridHeadersGridView gridHeadersGridView = GridHeadersGridView.this;
                GridHeadersGridView.a(GridHeadersGridView.this, this.QkN);
                if (gridHeadersGridView.QkD != null) {
                    gridHeadersGridView.playSoundEffect(0);
                    if (aof != null) {
                        aof.sendAccessibilityEvent(1);
                    }
                    gridHeadersGridView.QkD.dE(aof);
                }
            }
            AppMethodBeat.o(142798);
        }
    }

    class f {
        private int OTb;

        private f() {
        }

        /* synthetic */ f(GridHeadersGridView gridHeadersGridView, byte b2) {
            this();
        }

        public final void gWv() {
            AppMethodBeat.i(142804);
            this.OTb = GridHeadersGridView.b(GridHeadersGridView.this);
            AppMethodBeat.o(142804);
        }

        public final boolean gWw() {
            AppMethodBeat.i(142805);
            if (!GridHeadersGridView.this.hasWindowFocus() || GridHeadersGridView.c(GridHeadersGridView.this) != this.OTb) {
                AppMethodBeat.o(142805);
                return false;
            }
            AppMethodBeat.o(142805);
            return true;
        }
    }

    final class b implements Runnable {
        b() {
        }

        public final void run() {
            AppMethodBeat.i(142797);
            if (GridHeadersGridView.this.ayc == 0) {
                GridHeadersGridView.this.ayc = 1;
                View aof = GridHeadersGridView.this.aof(GridHeadersGridView.this.QkI);
                if (aof != null && !aof.hasFocusable()) {
                    if (!GridHeadersGridView.this.OOC) {
                        aof.setPressed(true);
                        GridHeadersGridView.this.setPressed(true);
                        GridHeadersGridView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        if (GridHeadersGridView.this.isLongClickable()) {
                            if (GridHeadersGridView.this.Qkr == null) {
                                GridHeadersGridView.this.Qkr = new a(GridHeadersGridView.this, (byte) 0);
                            }
                            GridHeadersGridView.this.Qkr.gWv();
                            GridHeadersGridView.this.mHandler.postDelayed(GridHeadersGridView.this.Qkr, (long) longPressTimeout);
                            AppMethodBeat.o(142797);
                            return;
                        }
                        GridHeadersGridView.this.ayc = 2;
                        AppMethodBeat.o(142797);
                        return;
                    }
                    GridHeadersGridView.this.ayc = 2;
                }
            }
            AppMethodBeat.o(142797);
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(142799);
                SavedState savedState = new SavedState(parcel, (byte) 0);
                AppMethodBeat.o(142799);
                return savedState;
            }
        };
        boolean QkO;

        /* synthetic */ SavedState(Parcel parcel, byte b2) {
            this(parcel);
        }

        static {
            AppMethodBeat.i(142803);
            AppMethodBeat.o(142803);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(142800);
            this.QkO = parcel.readByte() != 0;
            AppMethodBeat.o(142800);
        }

        public String toString() {
            AppMethodBeat.i(142801);
            String str = "StickyGridHeadersGridView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " areHeadersSticky=" + this.QkO + "}";
            AppMethodBeat.o(142801);
            return str;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(142802);
            super.writeToParcel(parcel, i2);
            parcel.writeByte((byte) (this.QkO ? 1 : 0));
            AppMethodBeat.o(142802);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z;
        int i2 = -2;
        AppMethodBeat.i(142816);
        switch (motionEvent.getAction() & 255) {
            case 0:
                if (this.Qks == null) {
                    this.Qks = new b();
                }
                this.mHandler.postDelayed(this.Qkr, (long) ViewConfiguration.getTapTimeout());
                int y = (int) motionEvent.getY();
                this.QkA = (float) y;
                float f2 = (float) y;
                if (this.QkG == null || f2 > ((float) this.QkG.getBottom())) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    i2 = 0;
                    while (true) {
                        if (firstVisiblePosition <= getLastVisiblePosition()) {
                            if (getItemIdAtPosition(firstVisiblePosition) == -1) {
                                View childAt = getChildAt(i2);
                                int bottom = childAt.getBottom();
                                int top = childAt.getTop();
                                if (f2 <= ((float) bottom) && f2 >= ((float) top)) {
                                }
                            }
                            firstVisiblePosition += this.QkC;
                            i2 += this.QkC;
                        } else {
                            i2 = -1;
                        }
                    }
                }
                this.QkI = i2;
                if (!(this.QkI == -1 || this.mScrollState == 2)) {
                    this.ayc = 0;
                }
                z = false;
                break;
            case 1:
                if (!(this.ayc == -2 || this.ayc == -1 || this.QkI == -1)) {
                    final View aof = aof(this.QkI);
                    if (aof != null && !aof.hasFocusable()) {
                        if (this.ayc != 0) {
                            aof.setPressed(false);
                        }
                        if (this.QkF == null) {
                            this.QkF = new e(this, (byte) 0);
                        }
                        final e eVar = this.QkF;
                        eVar.QkN = this.QkI;
                        eVar.gWv();
                        if (this.ayc == 0 && this.ayc == 1) {
                            if (!this.OOC) {
                                eVar.run();
                                z = true;
                                break;
                            }
                        } else {
                            this.mHandler.removeCallbacks(this.ayc == 0 ? this.Qks : this.Qkr);
                            if (!this.OOC) {
                                this.ayc = 1;
                                aof.setPressed(true);
                                setPressed(true);
                                if (this.OSV != null) {
                                    removeCallbacks(this.OSV);
                                }
                                this.OSV = new Runnable() {
                                    /* class com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.AnonymousClass2 */

                                    public final void run() {
                                        AppMethodBeat.i(142795);
                                        GridHeadersGridView.this.ayc = -1;
                                        aof.setPressed(false);
                                        GridHeadersGridView.this.setPressed(false);
                                        if (!GridHeadersGridView.this.OOC) {
                                            eVar.run();
                                        }
                                        AppMethodBeat.o(142795);
                                    }
                                };
                                this.mHandler.postDelayed(this.OSV, (long) ViewConfiguration.getPressedStateDuration());
                                z = true;
                                break;
                            } else {
                                this.ayc = -1;
                            }
                        }
                    }
                    this.ayc = -1;
                }
                z = false;
                break;
            case 2:
                if (this.QkI != -1 && Math.abs(motionEvent.getY() - this.QkA) > ((float) this.mTouchSlop)) {
                    this.ayc = -1;
                    View aof2 = aof(this.QkI);
                    if (aof2 != null) {
                        aof2.setPressed(false);
                    }
                    if (this.Qkr != null) {
                        this.mHandler.removeCallbacks(this.Qkr);
                    }
                    this.QkI = -1;
                }
                z = false;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            AppMethodBeat.o(142816);
            return false;
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(142816);
        return dispatchTouchEvent;
    }

    static /* synthetic */ long a(GridHeadersGridView gridHeadersGridView, int i2) {
        AppMethodBeat.i(142835);
        if (i2 == -2) {
            long j2 = gridHeadersGridView.Qky;
            AppMethodBeat.o(142835);
            return j2;
        }
        long EQ = gridHeadersGridView.QkH.EQ(gridHeadersGridView.getFirstVisiblePosition() + i2);
        AppMethodBeat.o(142835);
        return EQ;
    }
}
