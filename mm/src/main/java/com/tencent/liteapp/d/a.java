package com.tencent.liteapp.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class a extends FrameLayout {
    private static final int VIEW_ID = R.id.ri;
    private View crH;
    private int crI = -1;
    private final int[] crJ = new int[2];
    private c crK;
    private WeakHashMap<View, b> crL = new WeakHashMap<>();
    private Runnable crM = new Runnable() {
        /* class com.tencent.liteapp.d.a.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(197782);
            if (a.this.crH == null) {
                AppMethodBeat.o(197782);
                return;
            }
            com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", a.this.crH.getClass().getSimpleName());
            for (int i2 = 0; i2 < a.this.getChildCount(); i2++) {
                View childAt = a.this.getChildAt(i2);
                if (!(childAt == null || childAt == a.this.mContent || childAt == a.this.crH)) {
                    a.bY(childAt);
                }
            }
            AppMethodBeat.o(197782);
        }
    };
    private final Runnable crN = new Runnable() {
        /* class com.tencent.liteapp.d.a.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(197783);
            com.tencent.liteapp.b.b.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", Integer.valueOf(a.this.crO.size()));
            if (a.this.crO.size() <= 0) {
                AppMethodBeat.o(197783);
                return;
            }
            a.this.crO.toArray(new AbstractC0151a[a.this.crO.size()]);
            AppMethodBeat.o(197783);
        }
    };
    private final Set<AbstractC0151a> crO = new HashSet();
    private View mContent;
    private boolean mInLayout = false;

    /* renamed from: com.tencent.liteapp.d.a$a  reason: collision with other inner class name */
    public interface AbstractC0151a {
    }

    public a(Context context, View view) {
        super(context);
        AppMethodBeat.i(197784);
        super.setId(VIEW_ID);
        this.mContent = view;
        AppMethodBeat.o(197784);
    }

    public final void setForceHeight(int i2) {
        AppMethodBeat.i(197785);
        boolean z = i2 != this.crI;
        this.crI = i2;
        if (z) {
            if (!u.az(this)) {
                AppMethodBeat.o(197785);
                return;
            } else if (this.mInLayout) {
                AppMethodBeat.o(197785);
                return;
            } else {
                requestLayout();
            }
        }
        AppMethodBeat.o(197785);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(197786);
        if (this.crI > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.crI, 1073741824);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(197786);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(197787);
        b bVar = this.crL.get(this.crH);
        if (bVar != null && bVar.crQ && this.crH != null && this.crH.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.crH.getLocationOnScreen(this.crJ);
            float f2 = (float) this.crJ[1];
            float height = ((float) this.crH.getHeight()) + f2;
            if (rawY < f2 || rawY > height) {
                this.crH.setVisibility(8);
                AppMethodBeat.o(197787);
                return true;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(197787);
        return dispatchTouchEvent;
    }

    public final void setId(int i2) {
    }

    public final void addView(View view) {
        AppMethodBeat.i(197788);
        if (view == this.mContent || view == this.crH) {
            super.addView(view);
        }
        AppMethodBeat.o(197788);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        AppMethodBeat.i(197789);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, i2);
        }
        AppMethodBeat.o(197789);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, int i3) {
        AppMethodBeat.i(197790);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, i2, i3);
        }
        AppMethodBeat.o(197790);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(197791);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, layoutParams);
        }
        AppMethodBeat.o(197791);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(197792);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, i2, layoutParams);
        }
        AppMethodBeat.o(197792);
    }

    /* access modifiers changed from: protected */
    public final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean addViewInLayout(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        return false;
    }

    public final void onViewRemoved(View view) {
        AppMethodBeat.i(197793);
        super.onViewRemoved(view);
        this.crL.remove(view);
        AppMethodBeat.o(197793);
    }

    public final View getCurrentBottomPanel() {
        return this.crH;
    }

    public final void setOnLayoutListener(c cVar) {
        this.crK = cVar;
    }

    public final c getOnLayoutListener() {
        return this.crK;
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        AppMethodBeat.i(197794);
        this.mInLayout = true;
        if (u.az(this)) {
            boolean z2 = false;
            boolean z3 = true;
            boolean z4 = false;
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                if (!(childAt == null || childAt == this.mContent || (bVar = this.crL.get(childAt)) == null)) {
                    if (!z2 && bVar.crR != 0 && childAt.getVisibility() == 0) {
                        this.crH = childAt;
                        post(this.crM);
                        z2 = true;
                    }
                    boolean z5 = (bVar.crR == 0) | z4;
                    z3 &= childAt.getVisibility() != 0;
                    bVar.crR = childAt.getVisibility();
                    z4 = z5;
                }
            }
            if (z2 || (z4 && z3)) {
                post(this.crN);
            }
        }
        super.onLayout(z, i2, i3, i4, i5);
        if (this.crK != null) {
            this.crK.bZ(this);
        }
        this.mInLayout = false;
        AppMethodBeat.o(197794);
    }

    static final class b {
        boolean crQ;
        int crR = 8;

        private b() {
        }
    }

    public static b bX(View view) {
        AppMethodBeat.i(197795);
        a aVar = (a) view.getRootView().findViewById(VIEW_ID);
        if (aVar == null) {
            AppMethodBeat.o(197795);
            return null;
        }
        if (aVar.getOnLayoutListener() == null || !(aVar.getOnLayoutListener() instanceof b)) {
            aVar.setOnLayoutListener(new b());
        }
        b bVar = (b) aVar.getOnLayoutListener();
        AppMethodBeat.o(197795);
        return bVar;
    }

    static /* synthetic */ void bY(View view) {
        AppMethodBeat.i(197796);
        if (view == null) {
            AppMethodBeat.o(197796);
            return;
        }
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        AppMethodBeat.o(197796);
    }
}
