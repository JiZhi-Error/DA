package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v4.view.u;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;

@SuppressLint({"ViewConstructor"})
public final class n extends FrameLayout {
    private static final int VIEW_ID = R.id.ri;
    private View crH;
    private int crI = -1;
    private final int[] crJ = new int[2];
    private WeakHashMap<View, b> crL = new WeakHashMap<>();
    private Runnable crM = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.n.AnonymousClass1 */

        public final void run() {
            AppMethodBeat.i(137943);
            if (n.this.crH == null) {
                AppMethodBeat.o(137943);
                return;
            }
            Log.i("MicroMsg.AppBrandUIdRootFrameLayout", "hideInactivePanelView, mPanel %s", n.this.crH.getClass().getSimpleName());
            for (int i2 = 0; i2 < n.this.getChildCount(); i2++) {
                View childAt = n.this.getChildAt(i2);
                if (!(childAt == null || childAt == n.this.mContent || childAt == n.this.crH)) {
                    n.cZ(childAt);
                }
            }
            AppMethodBeat.o(137943);
        }
    };
    private final Runnable crN = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.n.AnonymousClass2 */

        public final void run() {
            AppMethodBeat.i(137944);
            Log.i("MicroMsg.AppBrandUIdRootFrameLayout", "callOnPanelChanged, size %d", Integer.valueOf(n.this.crO.size()));
            if (n.this.crO.size() <= 0) {
                AppMethodBeat.o(137944);
                return;
            }
            n.this.crO.toArray(new a[n.this.crO.size()]);
            AppMethodBeat.o(137944);
        }
    };
    private final Set<a> crO = new HashSet();
    private View mContent;
    private boolean mInLayout = false;
    private com.tencent.mm.plugin.appbrand.widget.d.a otj;

    public interface a {
    }

    public static n cW(View view) {
        AppMethodBeat.i(137945);
        n nVar = (n) view.getRootView().findViewById(VIEW_ID);
        AppMethodBeat.o(137945);
        return nVar;
    }

    public static n I(Activity activity) {
        AppMethodBeat.i(137946);
        n nVar = (n) activity.findViewById(VIEW_ID);
        AppMethodBeat.o(137946);
        return nVar;
    }

    public static void J(Activity activity) {
        AppMethodBeat.i(137947);
        n I = I(activity);
        if (I != null) {
            I.cbu();
        }
        AppMethodBeat.o(137947);
    }

    public final void cbu() {
        AppMethodBeat.i(193733);
        if (this.crH != null) {
            this.crH.setVisibility(8);
            this.crH = null;
        }
        AppMethodBeat.o(193733);
    }

    public n(Context context, View view) {
        super(context);
        AppMethodBeat.i(137948);
        super.setId(VIEW_ID);
        this.mContent = view;
        AppMethodBeat.o(137948);
    }

    public final void setForceHeight(int i2) {
        AppMethodBeat.i(137949);
        boolean z = i2 != this.crI;
        this.crI = i2;
        if (z) {
            if (!u.az(this)) {
                AppMethodBeat.o(137949);
                return;
            } else if (this.mInLayout) {
                AppMethodBeat.o(137949);
                return;
            } else {
                requestLayout();
            }
        }
        AppMethodBeat.o(137949);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(137950);
        if (this.crI > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.crI, 1073741824);
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(137950);
    }

    public final boolean d(KeyEvent keyEvent) {
        AppMethodBeat.i(183769);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1) {
            if (this.crH != null && this.crH.isShown()) {
                this.crH.setVisibility(8);
                AppMethodBeat.o(183769);
                return true;
            } else if (g.aM(getContext())) {
                AppMethodBeat.o(183769);
                return true;
            }
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(183769);
        return dispatchKeyEvent;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(137952);
        b bVar = this.crL.get(this.crH);
        if (bVar != null && bVar.crQ && this.crH != null && this.crH.isShown() && motionEvent.getAction() == 0) {
            float rawY = motionEvent.getRawY();
            this.crH.getLocationOnScreen(this.crJ);
            float f2 = (float) this.crJ[1];
            float height = ((float) this.crH.getHeight()) + f2;
            if (rawY < f2 || rawY > height) {
                this.crH.setVisibility(8);
                AppMethodBeat.o(137952);
                return true;
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(137952);
        return dispatchTouchEvent;
    }

    public final void setId(int i2) {
    }

    public final void addView(View view) {
        AppMethodBeat.i(137953);
        if (view == this.mContent || view == this.crH) {
            super.addView(view);
        }
        AppMethodBeat.o(137953);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2) {
        AppMethodBeat.i(137954);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, i2);
        }
        AppMethodBeat.o(137954);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, int i3) {
        AppMethodBeat.i(137955);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, i2, i3);
        }
        AppMethodBeat.o(137955);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(137956);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, layoutParams);
        }
        AppMethodBeat.o(137956);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(137957);
        if (view == this.mContent || view == this.crH) {
            super.addView(view, i2, layoutParams);
        }
        AppMethodBeat.o(137957);
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
        AppMethodBeat.i(137958);
        super.onViewRemoved(view);
        this.crL.remove(view);
        AppMethodBeat.o(137958);
    }

    public final View getCurrentBottomPanel() {
        return this.crH;
    }

    public final void n(View view, boolean z) {
        AppMethodBeat.i(137959);
        if (this.crH != null) {
            this.crH.setVisibility(8);
            this.crH = null;
        }
        if (this != view.getParent()) {
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.crH = view;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            super.addView(view, layoutParams);
            b bVar = new b((byte) 0);
            bVar.crQ = z;
            this.crL.put(view, bVar);
        }
        AppMethodBeat.o(137959);
    }

    public final void cX(View view) {
        AppMethodBeat.i(137960);
        n(view, false);
        AppMethodBeat.o(137960);
    }

    public final void setOnLayoutListener(com.tencent.mm.plugin.appbrand.widget.d.a aVar) {
        this.otj = aVar;
    }

    public final com.tencent.mm.plugin.appbrand.widget.d.a getOnLayoutListener() {
        return this.otj;
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        b bVar;
        AppMethodBeat.i(137961);
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
        if (this.otj != null) {
            this.otj.bZ(this);
        }
        this.mInLayout = false;
        AppMethodBeat.o(137961);
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        boolean crQ;
        int crR;

        private b() {
            this.crR = 8;
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public static u cY(View view) {
        AppMethodBeat.i(137962);
        n cW = cW(view);
        if (cW == null) {
            AppMethodBeat.o(137962);
            return null;
        }
        if (cW.getOnLayoutListener() == null || !(cW.getOnLayoutListener() instanceof u)) {
            cW.setOnLayoutListener(new u());
        }
        u uVar = (u) cW.getOnLayoutListener();
        AppMethodBeat.o(137962);
        return uVar;
    }

    static /* synthetic */ void cZ(View view) {
        AppMethodBeat.i(137963);
        if (view == null) {
            AppMethodBeat.o(137963);
            return;
        }
        if (view.getVisibility() != 8) {
            view.setVisibility(8);
        }
        AppMethodBeat.o(137963);
    }
}
