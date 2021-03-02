package com.tencent.mm.ui.base;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import java.util.LinkedList;
import java.util.Queue;

public class HorizontalListView extends AdapterView<ListAdapter> {
    protected ListAdapter GO;
    private AdapterView.OnItemSelectedListener OOA;
    private AdapterView.OnItemClickListener OOB;
    private boolean OOC = false;
    private a OOD;
    private DataSetObserver OOE = new DataSetObserver() {
        /* class com.tencent.mm.ui.base.HorizontalListView.AnonymousClass1 */

        public final void onChanged() {
            AppMethodBeat.i(141674);
            synchronized (HorizontalListView.this) {
                try {
                    HorizontalListView.this.OOC = true;
                } catch (Throwable th) {
                    AppMethodBeat.o(141674);
                    throw th;
                }
            }
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
            AppMethodBeat.o(141674);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(141675);
            HorizontalListView.b(HorizontalListView.this);
            HorizontalListView.this.invalidate();
            HorizontalListView.this.requestLayout();
            AppMethodBeat.o(141675);
        }
    };
    private GestureDetector.OnGestureListener OOF = new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.ui.base.HorizontalListView.AnonymousClass3 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(205207);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205207);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(205206);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205206);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(205205);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(205205);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(205204);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/base/HorizontalListView$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205204);
            return onSingleTapUp;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(141677);
            boolean gKr = HorizontalListView.this.gKr();
            AppMethodBeat.o(141677);
            return gKr;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(141678);
            boolean cr = HorizontalListView.this.cr(f2);
            AppMethodBeat.o(141678);
            return cr;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(141679);
            synchronized (HorizontalListView.this) {
                try {
                    HorizontalListView.this.OOv += (int) f2;
                } catch (Throwable th) {
                    AppMethodBeat.o(141679);
                    throw th;
                }
            }
            HorizontalListView.this.requestLayout();
            AppMethodBeat.o(141679);
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(141680);
            Rect rect = new Rect();
            int i2 = 0;
            while (true) {
                if (i2 >= HorizontalListView.this.getChildCount()) {
                    break;
                }
                View childAt = HorizontalListView.this.getChildAt(i2);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (HorizontalListView.this.OOB != null) {
                        HorizontalListView.this.OOB.onItemClick(HorizontalListView.this, childAt, HorizontalListView.this.OOs + 1 + i2, HorizontalListView.this.GO.getItemId(HorizontalListView.this.OOs + 1 + i2));
                    }
                    if (HorizontalListView.this.OOA != null) {
                        HorizontalListView.this.OOA.onItemSelected(HorizontalListView.this, childAt, HorizontalListView.this.OOs + 1 + i2, HorizontalListView.this.GO.getItemId(HorizontalListView.this.OOs + 1 + i2));
                    }
                } else {
                    i2++;
                }
            }
            AppMethodBeat.o(141680);
            return true;
        }
    };
    public boolean OOr = true;
    private int OOs = -1;
    private int OOt = 0;
    protected int OOu;
    protected int OOv;
    private int OOw = Integer.MAX_VALUE;
    private int OOx = 0;
    private GestureDetector OOy;
    private Queue<View> OOz = new LinkedList();
    protected Scroller mScroller;

    public interface a {
    }

    static /* synthetic */ void b(HorizontalListView horizontalListView) {
        AppMethodBeat.i(141692);
        horizontalListView.reset();
        AppMethodBeat.o(141692);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(141690);
        setAdapter(listAdapter);
        AppMethodBeat.o(141690);
    }

    public HorizontalListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(141681);
        initView();
        AppMethodBeat.o(141681);
    }

    private synchronized void initView() {
        AppMethodBeat.i(141682);
        this.OOs = -1;
        this.OOt = 0;
        this.OOx = 0;
        this.OOu = 0;
        this.OOv = 0;
        this.OOw = Integer.MAX_VALUE;
        this.mScroller = new Scroller(getContext());
        this.OOy = new GestureDetector(getContext(), this.OOF);
        AppMethodBeat.o(141682);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.OOA = onItemSelectedListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.OOB = onItemClickListener;
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.GO;
    }

    public View getSelectedView() {
        return null;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(141683);
        if (this.GO != null) {
            this.GO.unregisterDataSetObserver(this.OOE);
        }
        this.GO = listAdapter;
        this.GO.registerDataSetObserver(this.OOE);
        reset();
        AppMethodBeat.o(141683);
    }

    private synchronized void reset() {
        AppMethodBeat.i(141684);
        initView();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.o(141684);
    }

    public void setSelection(int i2) {
    }

    private void aG(View view, int i2) {
        AppMethodBeat.i(141685);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i2, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
        AppMethodBeat.o(141685);
    }

    /* access modifiers changed from: protected */
    public synchronized void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        synchronized (this) {
            AppMethodBeat.i(141686);
            super.onLayout(z, i2, i3, i4, i5);
            if (this.GO == null) {
                AppMethodBeat.o(141686);
            } else {
                if (this.OOC) {
                    int i6 = this.OOu;
                    initView();
                    removeAllViewsInLayout();
                    this.OOv = i6;
                    this.OOC = false;
                }
                if (this.mScroller.computeScrollOffset()) {
                    this.OOv = this.mScroller.getCurrX();
                }
                if (this.OOv <= 0) {
                    this.OOv = 0;
                    this.mScroller.forceFinished(true);
                }
                if (this.OOv >= this.OOw) {
                    this.OOv = this.OOw;
                    this.mScroller.forceFinished(true);
                }
                int i7 = this.OOu - this.OOv;
                View childAt = getChildAt(0);
                while (childAt != null && childAt.getRight() + i7 <= 0) {
                    this.OOx += childAt.getMeasuredWidth();
                    this.OOz.offer(childAt);
                    removeViewInLayout(childAt);
                    this.OOs++;
                    childAt = getChildAt(0);
                }
                while (true) {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (childAt2 == null || childAt2.getLeft() + i7 < getWidth()) {
                        View childAt3 = getChildAt(getChildCount() - 1);
                    } else {
                        this.OOz.offer(childAt2);
                        removeViewInLayout(childAt2);
                        this.OOt--;
                    }
                }
                View childAt32 = getChildAt(getChildCount() - 1);
                int right = childAt32 != null ? childAt32.getRight() : 0;
                while (right + i7 < getWidth() && this.OOt < this.GO.getCount()) {
                    View view = this.GO.getView(this.OOt, this.OOz.poll(), this);
                    aG(view, -1);
                    right = view.getMeasuredWidth() + right;
                    if (this.OOt == this.GO.getCount() - 1) {
                        this.OOw = (this.OOu + right) - getWidth();
                    }
                    if (this.OOw < 0) {
                        this.OOw = 0;
                    }
                    this.OOt++;
                }
                View childAt4 = getChildAt(0);
                int left = childAt4 != null ? childAt4.getLeft() : 0;
                while (left + i7 > 0 && this.OOs >= 0) {
                    View view2 = this.GO.getView(this.OOs, this.OOz.poll(), this);
                    aG(view2, 0);
                    left -= view2.getMeasuredWidth();
                    this.OOs--;
                    this.OOx -= view2.getMeasuredWidth();
                }
                if (getChildCount() > 0) {
                    this.OOx += i7;
                    int i8 = this.OOx;
                    for (int i9 = 0; i9 < getChildCount(); i9++) {
                        View childAt5 = getChildAt(i9);
                        int measuredWidth = childAt5.getMeasuredWidth();
                        childAt5.layout(i8, 0, i8 + measuredWidth, childAt5.getMeasuredHeight());
                        i8 += measuredWidth;
                    }
                }
                this.OOu = this.OOv;
                if (!this.mScroller.isFinished()) {
                    post(new Runnable() {
                        /* class com.tencent.mm.ui.base.HorizontalListView.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(141676);
                            HorizontalListView.this.requestLayout();
                            AppMethodBeat.o(141676);
                        }
                    });
                }
                AppMethodBeat.o(141686);
            }
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(141687);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        GestureDetector gestureDetector = this.OOy;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/base/HorizontalListView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/base/HorizontalListView", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z") | dispatchTouchEvent;
        AppMethodBeat.o(141687);
        return a2;
    }

    /* access modifiers changed from: protected */
    public final boolean cr(float f2) {
        AppMethodBeat.i(141688);
        synchronized (this) {
            try {
                this.mScroller.fling(this.OOv, 0, (int) (-f2), 0, 0, this.OOw, 0, 0);
            } catch (Throwable th) {
                AppMethodBeat.o(141688);
                throw th;
            }
        }
        requestLayout();
        AppMethodBeat.o(141688);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean gKr() {
        AppMethodBeat.i(141689);
        this.mScroller.forceFinished(true);
        AppMethodBeat.o(141689);
        return true;
    }

    public void setDispatchTouchListener(a aVar) {
        this.OOD = aVar;
    }
}
