package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.i;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HorizontalListViewV2 extends AdapterView<ListAdapter> {
    protected ListAdapter GO;
    private boolean OOC = false;
    protected Scroller OOH = new Scroller(getContext());
    private final a OOI = new a(this, (byte) 0);
    private List<Queue<View>> OOJ = new ArrayList();
    private View OOK = null;
    private Integer OOL = null;
    private int OOM;
    private int OON;
    private int OOO;
    private e OOP = null;
    private int OOQ = 0;
    private boolean OOR = false;
    private d OOS = null;
    private d.a OOT = d.a.SCROLL_STATE_IDLE;
    private i OOU;
    private i OOV;
    private int OOW;
    private boolean OOX = false;
    private boolean OOY = false;
    private DataSetObserver OOZ = new DataSetObserver() {
        /* class com.tencent.mm.ui.base.HorizontalListViewV2.AnonymousClass2 */

        public final void onChanged() {
            AppMethodBeat.i(141695);
            HorizontalListViewV2.this.OOC = true;
            HorizontalListViewV2.this.OOR = false;
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(141695);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(141696);
            HorizontalListViewV2.this.OOR = false;
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            HorizontalListViewV2.e(HorizontalListViewV2.this);
            HorizontalListViewV2.this.invalidate();
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(141696);
        }
    };
    protected int OOu;
    protected int OOv;
    private int OOw = Integer.MAX_VALUE;
    private int OOx;
    private Runnable OPa = new Runnable() {
        /* class com.tencent.mm.ui.base.HorizontalListViewV2.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(141697);
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(141697);
        }
    };
    private Drawable amP = null;
    private int aqn = 0;
    private GestureDetector mDJ;
    private View.OnClickListener mOnClickListener;
    private Rect mRect = new Rect();

    public interface e {
    }

    static /* synthetic */ int a(HorizontalListViewV2 horizontalListViewV2, int i2, int i3) {
        AppMethodBeat.i(141753);
        int kS = horizontalListViewV2.kS(i2, i3);
        AppMethodBeat.o(141753);
        return kS;
    }

    static /* synthetic */ void a(HorizontalListViewV2 horizontalListViewV2, d.a aVar) {
        AppMethodBeat.i(141751);
        horizontalListViewV2.setCurrentScrollState(aVar);
        AppMethodBeat.o(141751);
    }

    static /* synthetic */ void a(HorizontalListViewV2 horizontalListViewV2, Boolean bool) {
        AppMethodBeat.i(141750);
        horizontalListViewV2.r(bool);
        AppMethodBeat.o(141750);
    }

    static /* synthetic */ void d(HorizontalListViewV2 horizontalListViewV2) {
        AppMethodBeat.i(141748);
        horizontalListViewV2.gKu();
        AppMethodBeat.o(141748);
    }

    static /* synthetic */ void e(HorizontalListViewV2 horizontalListViewV2) {
        AppMethodBeat.i(141749);
        horizontalListViewV2.reset();
        AppMethodBeat.o(141749);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(141746);
        setAdapter(listAdapter);
        AppMethodBeat.o(141746);
    }

    public HorizontalListViewV2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141710);
        this.OOU = new i(context);
        this.OOV = new i(context);
        this.mDJ = new GestureDetector(context, this.OOI);
        setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.ui.base.HorizontalListViewV2.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(141694);
                GestureDetector gestureDetector = HorizontalListViewV2.this.mDJ;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/base/HorizontalListViewV2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/base/HorizontalListViewV2$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(141694);
                return a2;
            }
        });
        initView();
        setWillNotDraw(false);
        if (Build.VERSION.SDK_INT >= 11) {
            b.a(this.OOH);
        }
        AppMethodBeat.o(141710);
    }

    private void r(Boolean bool) {
        AppMethodBeat.i(141711);
        if (this.OOY != bool.booleanValue()) {
            for (View view = this; view.getParent() instanceof View; view = (View) view.getParent()) {
                if ((view.getParent() instanceof ListView) || (view.getParent() instanceof ScrollView)) {
                    view.getParent().requestDisallowInterceptTouchEvent(bool.booleanValue());
                    this.OOY = bool.booleanValue();
                    AppMethodBeat.o(141711);
                    return;
                }
            }
        }
        AppMethodBeat.o(141711);
    }

    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(141712);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_ID_PARENT_STATE", super.onSaveInstanceState());
        bundle.putInt("BUNDLE_ID_CURRENT_X", this.OOu);
        AppMethodBeat.o(141712);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(141713);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.OOL = Integer.valueOf(bundle.getInt("BUNDLE_ID_CURRENT_X"));
            super.onRestoreInstanceState(bundle.getParcelable("BUNDLE_ID_PARENT_STATE"));
        }
        AppMethodBeat.o(141713);
    }

    public void setDivider(Drawable drawable) {
        AppMethodBeat.i(141714);
        this.amP = drawable;
        if (drawable != null) {
            setDividerWidth(drawable.getIntrinsicWidth());
            AppMethodBeat.o(141714);
            return;
        }
        setDividerWidth(0);
        AppMethodBeat.o(141714);
    }

    public void setDividerWidth(int i2) {
        AppMethodBeat.i(141715);
        this.aqn = i2;
        requestLayout();
        invalidate();
        AppMethodBeat.o(141715);
    }

    private void initView() {
        AppMethodBeat.i(141716);
        this.OOM = -1;
        this.OON = -1;
        this.OOx = 0;
        this.OOu = 0;
        this.OOv = 0;
        this.OOw = Integer.MAX_VALUE;
        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
        AppMethodBeat.o(141716);
    }

    private void reset() {
        AppMethodBeat.i(141717);
        initView();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.o(141717);
    }

    public void setSelection(int i2) {
        this.OOO = i2;
    }

    public View getSelectedView() {
        AppMethodBeat.i(141718);
        int i2 = this.OOO;
        if (i2 < this.OOM || i2 > this.OON) {
            AppMethodBeat.o(141718);
            return null;
        }
        View childAt = getChildAt(i2 - this.OOM);
        AppMethodBeat.o(141718);
        return childAt;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(141719);
        if (this.GO != null) {
            this.GO.unregisterDataSetObserver(this.OOZ);
        }
        if (listAdapter != null) {
            this.OOR = false;
            this.GO = listAdapter;
            this.GO.registerDataSetObserver(this.OOZ);
        }
        if (this.GO != null) {
            int viewTypeCount = this.GO.getViewTypeCount();
            this.OOJ.clear();
            for (int i2 = 0; i2 < viewTypeCount; i2++) {
                this.OOJ.add(new LinkedList());
            }
        }
        reset();
        AppMethodBeat.o(141719);
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.GO;
    }

    private View alq(int i2) {
        AppMethodBeat.i(141720);
        int itemViewType = this.GO.getItemViewType(i2);
        if (alr(itemViewType)) {
            View poll = this.OOJ.get(itemViewType).poll();
            AppMethodBeat.o(141720);
            return poll;
        }
        AppMethodBeat.o(141720);
        return null;
    }

    private void p(int i2, View view) {
        AppMethodBeat.i(141721);
        int itemViewType = this.GO.getItemViewType(i2);
        if (alr(itemViewType)) {
            this.OOJ.get(itemViewType).offer(view);
        }
        AppMethodBeat.o(141721);
    }

    private boolean alr(int i2) {
        AppMethodBeat.i(141722);
        if (i2 < this.OOJ.size()) {
            AppMethodBeat.o(141722);
            return true;
        }
        AppMethodBeat.o(141722);
        return false;
    }

    private void aG(View view, int i2) {
        int makeMeasureSpec;
        AppMethodBeat.i(141723);
        addViewInLayout(view, i2, gw(view), true);
        ViewGroup.LayoutParams gw = gw(view);
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.OOW, getPaddingTop() + getPaddingBottom(), gw.height);
        if (gw.width > 0) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(gw.width, 1073741824);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(makeMeasureSpec, childMeasureSpec);
        AppMethodBeat.o(141723);
    }

    private static ViewGroup.LayoutParams gw(View view) {
        AppMethodBeat.i(141724);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -1);
        }
        AppMethodBeat.o(141724);
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0234  */
    @android.annotation.SuppressLint({"WrongCall"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r9, int r10, int r11, int r12, int r13) {
        /*
        // Method dump skipped, instructions count: 604
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.HorizontalListViewV2.onLayout(boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        AppMethodBeat.i(141726);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.OOu == 0) {
            AppMethodBeat.o(141726);
            return 0.0f;
        } else if (this.OOu < horizontalFadingEdgeLength) {
            float f2 = ((float) this.OOu) / ((float) horizontalFadingEdgeLength);
            AppMethodBeat.o(141726);
            return f2;
        } else {
            AppMethodBeat.o(141726);
            return 1.0f;
        }
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        AppMethodBeat.i(141727);
        int horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
        if (this.OOu == this.OOw) {
            AppMethodBeat.o(141727);
            return 0.0f;
        } else if (this.OOw - this.OOu < horizontalFadingEdgeLength) {
            float f2 = ((float) (this.OOw - this.OOu)) / ((float) horizontalFadingEdgeLength);
            AppMethodBeat.o(141727);
            return f2;
        } else {
            AppMethodBeat.o(141727);
            return 1.0f;
        }
    }

    private float gKs() {
        AppMethodBeat.i(141728);
        if (Build.VERSION.SDK_INT >= 14) {
            float b2 = c.b(this.OOH);
            AppMethodBeat.o(141728);
            return b2;
        }
        AppMethodBeat.o(141728);
        return 30.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(141729);
        super.onMeasure(i2, i3);
        this.OOW = i3;
        AppMethodBeat.o(141729);
    }

    private View getLeftmostChild() {
        AppMethodBeat.i(141730);
        View childAt = getChildAt(0);
        AppMethodBeat.o(141730);
        return childAt;
    }

    private View getRightmostChild() {
        AppMethodBeat.i(141731);
        View childAt = getChildAt(getChildCount() - 1);
        AppMethodBeat.o(141731);
        return childAt;
    }

    private int kS(int i2, int i3) {
        AppMethodBeat.i(141732);
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            getChildAt(i4).getHitRect(this.mRect);
            if (this.mRect.contains(i2, i3)) {
                AppMethodBeat.o(141732);
                return i4;
            }
        }
        AppMethodBeat.o(141732);
        return -1;
    }

    private boolean als(int i2) {
        AppMethodBeat.i(141733);
        if (i2 == this.GO.getCount() - 1) {
            AppMethodBeat.o(141733);
            return true;
        }
        AppMethodBeat.o(141733);
        return false;
    }

    private int getRenderHeight() {
        AppMethodBeat.i(141734);
        int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
        AppMethodBeat.o(141734);
        return height;
    }

    private int getRenderWidth() {
        AppMethodBeat.i(141735);
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        AppMethodBeat.o(141735);
        return width;
    }

    public final void gKt() {
        AppMethodBeat.i(141736);
        this.OOH.startScroll(this.OOv, 0, 0 - this.OOv, 0);
        setCurrentScrollState(d.a.SCROLL_STATE_FLING);
        requestLayout();
        AppMethodBeat.o(141736);
    }

    public int getFirstVisiblePosition() {
        return this.OOM;
    }

    public int getLastVisiblePosition() {
        return this.OON;
    }

    private void a(Canvas canvas, Rect rect) {
        AppMethodBeat.i(141737);
        if (this.amP != null) {
            this.amP.setBounds(rect);
            this.amP.draw(canvas);
        }
        AppMethodBeat.o(141737);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(141738);
        super.onDraw(canvas);
        int childCount = getChildCount();
        Rect rect = this.mRect;
        this.mRect.top = getPaddingTop();
        this.mRect.bottom = this.mRect.top + getRenderHeight();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (i2 != childCount - 1 || !als(this.OON)) {
                View childAt = getChildAt(i2);
                rect.left = childAt.getRight();
                rect.right = childAt.getRight() + this.aqn;
                if (rect.left < getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                }
                if (rect.right > getWidth() - getPaddingRight()) {
                    rect.right = getWidth() - getPaddingRight();
                }
                a(canvas, rect);
                if (i2 == 0 && childAt.getLeft() > getPaddingLeft()) {
                    rect.left = getPaddingLeft();
                    rect.right = childAt.getLeft();
                    a(canvas, rect);
                }
            }
        }
        AppMethodBeat.o(141738);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        AppMethodBeat.i(141739);
        super.dispatchDraw(canvas);
        AppMethodBeat.o(141739);
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* access modifiers changed from: protected */
    public final boolean cr(float f2) {
        AppMethodBeat.i(141740);
        this.OOH.fling(this.OOv, 0, (int) (-f2), 0, 0, this.OOw, 0, 0);
        setCurrentScrollState(d.a.SCROLL_STATE_FLING);
        requestLayout();
        AppMethodBeat.o(141740);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean onDown(MotionEvent motionEvent) {
        int kS;
        AppMethodBeat.i(141741);
        this.OOX = !this.OOH.isFinished();
        this.OOH.forceFinished(true);
        setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
        gKu();
        if (!this.OOX && (kS = kS((int) motionEvent.getX(), (int) motionEvent.getY())) >= 0) {
            this.OOK = getChildAt(kS);
            if (this.OOK != null) {
                this.OOK.setPressed(true);
                refreshDrawableState();
            }
        }
        AppMethodBeat.o(141741);
        return true;
    }

    private void gKu() {
        AppMethodBeat.i(141742);
        if (this.OOK != null) {
            this.OOK.setPressed(false);
            refreshDrawableState();
            this.OOK = null;
        }
        AppMethodBeat.o(141742);
    }

    class a extends GestureDetector.SimpleOnGestureListener {
        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(205210);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205210);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(205209);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205209);
            return onDoubleTap;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(205208);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205208);
            return onSingleTapUp;
        }

        private a() {
        }

        /* synthetic */ a(HorizontalListViewV2 horizontalListViewV2, byte b2) {
            this();
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(141698);
            boolean onDown = HorizontalListViewV2.this.onDown(motionEvent);
            AppMethodBeat.o(141698);
            return onDown;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(141699);
            boolean cr = HorizontalListViewV2.this.cr(f2);
            AppMethodBeat.o(141699);
            return cr;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(141700);
            HorizontalListViewV2.a(HorizontalListViewV2.this, Boolean.TRUE);
            HorizontalListViewV2.a(HorizontalListViewV2.this, d.a.SCROLL_STATE_TOUCH_SCROLL);
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            HorizontalListViewV2.this.OOv += (int) f2;
            HorizontalListViewV2.a(HorizontalListViewV2.this, Math.round(f2));
            HorizontalListViewV2.this.requestLayout();
            AppMethodBeat.o(141700);
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(141701);
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            AdapterView.OnItemClickListener onItemClickListener = HorizontalListViewV2.this.getOnItemClickListener();
            int a2 = HorizontalListViewV2.a(HorizontalListViewV2.this, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a2 >= 0 && !HorizontalListViewV2.this.OOX) {
                View childAt = HorizontalListViewV2.this.getChildAt(a2);
                int i2 = HorizontalListViewV2.this.OOM + a2;
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(HorizontalListViewV2.this, childAt, i2, HorizontalListViewV2.this.GO.getItemId(i2));
                    AppMethodBeat.o(141701);
                    return true;
                }
            }
            if (HorizontalListViewV2.this.mOnClickListener != null && !HorizontalListViewV2.this.OOX) {
                HorizontalListViewV2.this.mOnClickListener.onClick(HorizontalListViewV2.this);
            }
            AppMethodBeat.o(141701);
            return false;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(141702);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            HorizontalListViewV2.d(HorizontalListViewV2.this);
            int a2 = HorizontalListViewV2.a(HorizontalListViewV2.this, (int) motionEvent.getX(), (int) motionEvent.getY());
            if (a2 >= 0 && !HorizontalListViewV2.this.OOX) {
                View childAt = HorizontalListViewV2.this.getChildAt(a2);
                AdapterView.OnItemLongClickListener onItemLongClickListener = HorizontalListViewV2.this.getOnItemLongClickListener();
                if (onItemLongClickListener != null) {
                    int i2 = HorizontalListViewV2.this.OOM + a2;
                    if (onItemLongClickListener.onItemLongClick(HorizontalListViewV2.this, childAt, i2, HorizontalListViewV2.this.GO.getItemId(i2))) {
                        HorizontalListViewV2.this.performHapticFeedback(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/HorizontalListViewV2$GestureListener", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(141702);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141743);
        if (motionEvent.getAction() == 1) {
            if (this.OOH == null || this.OOH.isFinished()) {
                setCurrentScrollState(d.a.SCROLL_STATE_IDLE);
            }
            r(Boolean.FALSE);
            gKv();
        } else if (motionEvent.getAction() == 3) {
            gKu();
            gKv();
            r(Boolean.FALSE);
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(141743);
        return onTouchEvent;
    }

    private void gKv() {
        AppMethodBeat.i(141744);
        if (this.OOU != null) {
            this.OOU.ga();
        }
        if (this.OOV != null) {
            this.OOV.ga();
        }
        AppMethodBeat.o(141744);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    public interface d {
        void a(a aVar);

        public enum a {
            SCROLL_STATE_IDLE,
            SCROLL_STATE_TOUCH_SCROLL,
            SCROLL_STATE_FLING;

            public static a valueOf(String str) {
                AppMethodBeat.i(141708);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(141708);
                return aVar;
            }

            static {
                AppMethodBeat.i(141709);
                AppMethodBeat.o(141709);
            }
        }
    }

    public void setOnScrollStateChangedListener(d dVar) {
        this.OOS = dVar;
    }

    private void setCurrentScrollState(d.a aVar) {
        AppMethodBeat.i(141745);
        if (!(this.OOT == aVar || this.OOS == null)) {
            this.OOS.a(aVar);
        }
        this.OOT = aVar;
        AppMethodBeat.o(141745);
    }

    @TargetApi(11)
    static final class b {
        static {
            AppMethodBeat.i(141704);
            if (Build.VERSION.SDK_INT < 11) {
                RuntimeException runtimeException = new RuntimeException("sdk is >= 11!");
                AppMethodBeat.o(141704);
                throw runtimeException;
            }
            AppMethodBeat.o(141704);
        }

        public static void a(Scroller scroller) {
            AppMethodBeat.i(141703);
            if (scroller != null) {
                scroller.setFriction(0.009f);
            }
            AppMethodBeat.o(141703);
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public static final class c {
        static {
            AppMethodBeat.i(141706);
            if (Build.VERSION.SDK_INT < 14) {
                RuntimeException runtimeException = new RuntimeException("sdk is >= 14!");
                AppMethodBeat.o(141706);
                throw runtimeException;
            }
            AppMethodBeat.o(141706);
        }

        public static float b(Scroller scroller) {
            AppMethodBeat.i(141705);
            float currVelocity = scroller.getCurrVelocity();
            AppMethodBeat.o(141705);
            return currVelocity;
        }
    }

    static /* synthetic */ void a(HorizontalListViewV2 horizontalListViewV2, int i2) {
        AppMethodBeat.i(141752);
        if (horizontalListViewV2.OOU == null || horizontalListViewV2.OOV == null) {
            AppMethodBeat.o(141752);
            return;
        }
        int i3 = horizontalListViewV2.OOu + i2;
        if (horizontalListViewV2.OOH == null || horizontalListViewV2.OOH.isFinished()) {
            if (i3 < 0) {
                horizontalListViewV2.OOU.G(((float) Math.abs(i2)) / ((float) horizontalListViewV2.getRenderWidth()));
                if (!horizontalListViewV2.OOV.Uv.isFinished()) {
                    horizontalListViewV2.OOV.ga();
                }
                AppMethodBeat.o(141752);
                return;
            } else if (i3 > horizontalListViewV2.OOw) {
                horizontalListViewV2.OOV.G(((float) Math.abs(i2)) / ((float) horizontalListViewV2.getRenderWidth()));
                if (!horizontalListViewV2.OOU.Uv.isFinished()) {
                    horizontalListViewV2.OOU.ga();
                }
            }
        }
        AppMethodBeat.o(141752);
    }
}
