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

public class MMHorList extends AdapterView<ListAdapter> {
    private boolean AmY = false;
    protected Scroller Ays;
    private a OQX;
    private int OQY;
    private int OQZ;
    private int ORa;
    private int ORb = 536870912;
    private Queue<View> ORc = new LinkedList();
    private boolean ORd = false;
    private boolean ORe = false;
    private GestureDetector ORf;
    private AdapterView.OnItemSelectedListener ORg;
    private AdapterView.OnItemClickListener ORh;
    private ListAdapter ORi;
    private Runnable ORj = new Runnable() {
        /* class com.tencent.mm.ui.base.MMHorList.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(142002);
            MMHorList.this.requestLayout();
            AppMethodBeat.o(142002);
        }
    };
    private boolean ORk = false;
    private boolean ORl = false;
    private int ORm = 0;
    private int ORn = 0;
    private boolean ORo = false;
    private DataSetObserver ORp = new DataSetObserver() {
        /* class com.tencent.mm.ui.base.MMHorList.AnonymousClass2 */

        public final void onChanged() {
            AppMethodBeat.i(142003);
            MMHorList.this.ORd = true;
            MMHorList.this.invalidate();
            MMHorList.this.requestLayout();
            AppMethodBeat.o(142003);
        }

        public final void onInvalidated() {
            AppMethodBeat.i(142004);
            MMHorList.b(MMHorList.this);
            MMHorList.this.invalidate();
            MMHorList.this.requestLayout();
            AppMethodBeat.o(142004);
        }
    };
    private GestureDetector.OnGestureListener ORq = new GestureDetector.SimpleOnGestureListener() {
        /* class com.tencent.mm.ui.base.MMHorList.AnonymousClass3 */

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(205236);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205236);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(205235);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205235);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(205234);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(205234);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(205233);
            b bVar = new b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/ui/base/MMHorList$3", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(205233);
            return onSingleTapUp;
        }

        public final boolean onDown(MotionEvent motionEvent) {
            AppMethodBeat.i(142005);
            boolean gKr = MMHorList.this.gKr();
            AppMethodBeat.o(142005);
            return gKr;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(142006);
            boolean cr = MMHorList.this.cr(f2);
            AppMethodBeat.o(142006);
            return cr;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            AppMethodBeat.i(142007);
            MMHorList.this.ORa += (int) f2;
            MMHorList.this.requestLayout();
            AppMethodBeat.o(142007);
            return true;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(142008);
            Rect rect = new Rect();
            int i2 = 0;
            while (true) {
                if (i2 >= MMHorList.this.getChildCount()) {
                    break;
                }
                View childAt = MMHorList.this.getChildAt(i2);
                rect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
                if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    if (MMHorList.this.ORh != null) {
                        MMHorList.this.ORh.onItemClick(MMHorList.this, childAt, MMHorList.this.OQY + 1 + i2, MMHorList.this.ORi.getItemId(MMHorList.this.OQY + 1 + i2));
                    }
                    if (MMHorList.this.ORg != null) {
                        MMHorList.this.ORg.onItemSelected(MMHorList.this, childAt, MMHorList.this.OQY + 1 + i2, MMHorList.this.ORi.getItemId(MMHorList.this.OQY + 1 + i2));
                    }
                } else {
                    i2++;
                }
            }
            AppMethodBeat.o(142008);
            return true;
        }
    };
    private int offset;
    private int pKP;

    public interface a {
        void efW();

        void fdM();

        void fuk();
    }

    static /* synthetic */ void b(MMHorList mMHorList) {
        AppMethodBeat.i(142024);
        mMHorList.reset();
        AppMethodBeat.o(142024);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.widget.Adapter] */
    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(142022);
        setAdapter(listAdapter);
        AppMethodBeat.o(142022);
    }

    public void setHorListLitener(a aVar) {
        this.OQX = aVar;
    }

    public void setCenterInParent(boolean z) {
        this.ORk = z;
    }

    public void setOverScrollEnabled(boolean z) {
        this.ORl = z;
    }

    public void setItemWidth(int i2) {
        this.ORm = i2;
    }

    private void init() {
        AppMethodBeat.i(142009);
        this.Ays = new Scroller(getContext());
        this.OQY = -1;
        this.OQZ = 0;
        this.offset = 0;
        this.pKP = 0;
        this.ORa = 0;
        this.ORd = false;
        this.ORb = 536870912;
        this.ORf = new GestureDetector(getContext(), this.ORq);
        AppMethodBeat.o(142009);
    }

    public MMHorList(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(142010);
        init();
        AppMethodBeat.o(142010);
    }

    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.ORg = onItemSelectedListener;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.ORh = onItemClickListener;
    }

    public MMHorList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(142011);
        init();
        AppMethodBeat.o(142011);
    }

    @Override // android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.ORi;
    }

    public void setAdapter(ListAdapter listAdapter) {
        AppMethodBeat.i(142012);
        if (this.ORi == null) {
            listAdapter.registerDataSetObserver(this.ORp);
        }
        this.ORi = listAdapter;
        reset();
        AppMethodBeat.o(142012);
    }

    private int getChildViewTotalWidth() {
        AppMethodBeat.i(142013);
        int count = this.ORi.getCount() * this.ORm;
        AppMethodBeat.o(142013);
        return count;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(142014);
        super.onLayout(z, i2, i3, i4, i5);
        if (this.ORi == null) {
            AppMethodBeat.o(142014);
            return;
        }
        this.ORe = true;
        if (this.ORd) {
            int i6 = this.pKP;
            init();
            removeAllViewsInLayout();
            this.ORa = i6;
            if (this.ORk) {
                this.ORn = Math.max(0, (getWidth() - getChildViewTotalWidth()) / 2);
                this.offset = this.ORn;
            }
            this.ORd = false;
        }
        if (this.Ays.computeScrollOffset()) {
            this.ORa = this.Ays.getCurrX();
        }
        if (!this.ORl) {
            if (this.ORa < 0) {
                this.ORa = 0;
                this.Ays.forceFinished(true);
            }
            if (this.ORa > this.ORb) {
                this.ORa = this.ORb;
                this.Ays.forceFinished(true);
            }
        } else if (getChildViewTotalWidth() > getWidth()) {
            if (this.ORa < getWidth() * -1) {
                this.ORa = (getWidth() * -1) + 1;
                this.Ays.forceFinished(true);
            }
            if (this.ORa > this.ORb + getWidth()) {
                this.ORa = (this.ORb + getWidth()) - 1;
                this.Ays.forceFinished(true);
            }
        } else {
            if (this.ORa < (getWidth() * -1) + this.ORn) {
                this.ORa = (getWidth() * -1) + this.ORn + 1;
                this.Ays.forceFinished(true);
            }
            if (this.ORa > getWidth() - this.ORn) {
                this.ORa = (getWidth() - this.ORn) - 1;
                this.Ays.forceFinished(true);
            }
        }
        int i7 = this.pKP - this.ORa;
        View childAt = getChildAt(0);
        while (childAt != null && childAt.getRight() + i7 <= 0) {
            this.offset += childAt.getMeasuredWidth();
            this.ORc.offer(childAt);
            removeViewInLayout(childAt);
            this.OQY++;
            childAt = getChildAt(0);
            this.ORe = true;
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        while (childAt2 != null && childAt2.getLeft() + i7 >= getWidth()) {
            this.ORc.offer(childAt2);
            removeViewInLayout(childAt2);
            this.OQZ--;
            childAt2 = getChildAt(getChildCount() - 1);
            this.ORe = true;
        }
        View childAt3 = getChildAt(getChildCount() - 1);
        int right = childAt3 != null ? childAt3.getRight() : 0;
        while (right + i7 < getWidth() && this.OQZ < this.ORi.getCount()) {
            View view = this.ORi.getView(this.OQZ, this.ORc.poll(), this);
            aG(view, -1);
            right = view.getMeasuredWidth() + right;
            if (this.OQZ == this.ORi.getCount() - 1) {
                this.ORb = (this.pKP + right) - getWidth();
            }
            this.OQZ++;
        }
        View childAt4 = getChildAt(0);
        int left = childAt4 != null ? childAt4.getLeft() : 0;
        while (left + i7 > 0 && this.OQY >= 0) {
            View view2 = this.ORi.getView(this.OQY, this.ORc.poll(), this);
            aG(view2, 0);
            left -= view2.getMeasuredWidth();
            this.OQY--;
            this.offset -= view2.getMeasuredWidth();
        }
        if (getChildCount() > 0 && this.ORe) {
            this.offset += i7;
            int i8 = this.offset;
            for (int i9 = 0; i9 < getChildCount(); i9++) {
                View childAt5 = getChildAt(i9);
                int measuredWidth = childAt5.getMeasuredWidth();
                childAt5.layout(i8, 0, i8 + measuredWidth, childAt5.getMeasuredHeight());
                i8 += measuredWidth;
            }
        }
        this.pKP = this.ORa;
        if (!this.Ays.isFinished()) {
            post(this.ORj);
            AppMethodBeat.o(142014);
            return;
        }
        if (this.OQX != null && this.ORo) {
            this.OQX.efW();
            this.ORo = false;
        }
        AppMethodBeat.o(142014);
    }

    private void aG(View view, int i2) {
        AppMethodBeat.i(142015);
        this.ORe = true;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -1);
        }
        addViewInLayout(view, i2, layoutParams, true);
        view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getHeight(), Integer.MIN_VALUE));
        AppMethodBeat.o(142015);
    }

    public View getSelectedView() {
        return null;
    }

    public void setSelection(int i2) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        View childAt;
        AppMethodBeat.i(142016);
        if (this.ORi == null || this.ORi.getCount() <= 0 || (childAt = getChildAt(0)) == null) {
            super.onMeasure(i2, i3);
            AppMethodBeat.o(142016);
            return;
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), Integer.MIN_VALUE));
        AppMethodBeat.o(142016);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(142017);
        GestureDetector gestureDetector = this.ORf;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/ui/base/MMHorList", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        if (motionEvent.getAction() == 0) {
            this.AmY = true;
            if (this.OQX != null) {
                this.OQX.fuk();
            }
        } else if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            if (this.ORl) {
                if (getChildViewTotalWidth() > getWidth()) {
                    if (this.pKP < 0) {
                        this.Ays.forceFinished(true);
                        this.Ays.startScroll(this.pKP, 0, 0 - this.pKP, 0);
                        requestLayout();
                    } else if (this.pKP > this.ORb) {
                        this.Ays.forceFinished(true);
                        this.Ays.startScroll(this.pKP, 0, this.ORb - this.pKP, 0);
                        requestLayout();
                    }
                } else if (this.pKP != this.ORn * -1) {
                    this.Ays.forceFinished(true);
                    this.Ays.startScroll(this.pKP, 0, 0 - this.pKP, 0);
                    requestLayout();
                }
            }
            this.AmY = false;
            if (this.OQX != null) {
                this.OQX.fdM();
            }
        }
        AppMethodBeat.o(142017);
        return a2;
    }

    /* access modifiers changed from: protected */
    public final boolean gKr() {
        AppMethodBeat.i(142018);
        this.Ays.forceFinished(true);
        AppMethodBeat.o(142018);
        return true;
    }

    public final void alA(int i2) {
        AppMethodBeat.i(142019);
        this.Ays.forceFinished(true);
        this.Ays.startScroll(this.pKP, 0, i2 - this.pKP, 0);
        this.ORo = true;
        requestLayout();
        AppMethodBeat.o(142019);
    }

    public int getCurrentPosition() {
        return this.pKP;
    }

    public boolean getIsTouching() {
        return this.AmY;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean cr(float f2) {
        AppMethodBeat.i(142020);
        this.Ays.fling(this.ORa, 0, (int) (-f2), 0, 0, this.ORb, 0, 0);
        requestLayout();
        AppMethodBeat.o(142020);
        return true;
    }

    private void reset() {
        AppMethodBeat.i(142021);
        init();
        removeAllViewsInLayout();
        requestLayout();
        AppMethodBeat.o(142021);
    }
}
