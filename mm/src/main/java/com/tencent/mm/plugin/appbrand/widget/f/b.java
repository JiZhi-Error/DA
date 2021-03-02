package com.tencent.mm.plugin.appbrand.widget.f;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public final class b {
    public final ac nnq;
    a oBx;
    public f oBy;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.f.b$b  reason: collision with other inner class name */
    public static final class C0820b implements n {
        public final LinkedList<ac> oBC = new LinkedList<>();

        private C0820b() {
            AppMethodBeat.i(164055);
            AppMethodBeat.o(164055);
        }

        public static C0820b ao(AppBrandRuntime appBrandRuntime) {
            AppMethodBeat.i(164056);
            C0820b bVar = (C0820b) appBrandRuntime.aw(C0820b.class);
            if (bVar == null) {
                bVar = new C0820b();
                appBrandRuntime.a(bVar);
            }
            AppMethodBeat.o(164056);
            return bVar;
        }
    }

    public b(ac acVar) {
        this.nnq = acVar;
    }

    public final void AB(int i2) {
        AppMethodBeat.i(135499);
        a ccH = ccH();
        if (ccH != null && (ccH.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ccH.getLayoutParams();
            if (i2 != marginLayoutParams.topMargin) {
                marginLayoutParams.topMargin = i2;
                ccH.requestLayout();
            }
        }
        AppMethodBeat.o(135499);
    }

    private a ccH() {
        AppMethodBeat.i(135500);
        if (this.oBx == null || this.oBx.oBB) {
            this.oBx = null;
            ViewGroup bRX = this.nnq.nqN.bRX();
            for (int i2 = 0; i2 < bRX.getChildCount(); i2++) {
                View childAt = bRX.getChildAt(i2);
                if (childAt instanceof a) {
                    a aVar = (a) childAt;
                    AppMethodBeat.o(135500);
                    return aVar;
                }
            }
            AppMethodBeat.o(135500);
            return null;
        }
        a aVar2 = this.oBx;
        AppMethodBeat.o(135500);
        return aVar2;
    }

    public final a ccI() {
        AppMethodBeat.i(135501);
        ViewGroup bRX = this.nnq.nqN.bRX();
        a ccH = ccH();
        if (ccH == null) {
            ccH = new a(this.nnq.getContext());
            ccH.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.f.b.AnonymousClass1 */

                public final void onViewAttachedToWindow(View view) {
                }

                public final void onViewDetachedFromWindow(View view) {
                    if (view == b.this.oBx) {
                        b.this.oBx = null;
                    }
                }
            });
            bRX.addView(ccH, -1, -1);
        }
        ccH.bringToFront();
        this.oBx = ccH;
        AppMethodBeat.o(135501);
        return ccH;
    }

    public final void dk(View view) {
        AppMethodBeat.i(219634);
        if (!this.nnq.isRunning() || this.nnq.getRuntime() == null) {
            AppMethodBeat.o(219634);
            return;
        }
        ccL();
        a ccI = ccI();
        ccJ();
        view.setTag(R.id.rg, Boolean.TRUE);
        ccI.addView(view);
        C0820b.ao(this.nnq.getRuntime()).oBC.add(this.nnq);
        AppMethodBeat.o(219634);
    }

    public final void ccJ() {
        AppMethodBeat.i(135502);
        com.tencent.mm.plugin.appbrand.widget.actionbar.b bRi = this.nnq.bRi();
        if (bRi == null) {
            AppMethodBeat.o(135502);
            return;
        }
        AB(bRi.getMeasuredHeight() + bRi.getTop());
        AppMethodBeat.o(135502);
    }

    public final boolean ccK() {
        boolean z = false;
        AppMethodBeat.i(135503);
        if (!this.nnq.isRunning()) {
            AppMethodBeat.o(135503);
        } else {
            ccL();
            a aVar = this.oBx;
            if (aVar != null && u.aD(aVar)) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < aVar.getChildCount(); i2++) {
                    View childAt = aVar.getChildAt(i2);
                    if (childAt != null && Objects.equals(childAt.getTag(R.id.rg), Boolean.TRUE)) {
                        linkedList.add(childAt);
                    }
                }
                if (!linkedList.isEmpty()) {
                    z = true;
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    View view = (View) it.next();
                    view.setVisibility(8);
                    aVar.removeView(view);
                }
            }
            if (z && this.nnq.getRuntime() != null) {
                C0820b.ao(this.nnq.getRuntime()).oBC.remove(this.nnq);
            }
            AppMethodBeat.o(135503);
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends FrameLayout {
        private final Rect mC = new Rect();
        private final int[] oBA = new int[2];
        private boolean oBB = false;

        public a(Context context) {
            super(context);
            AppMethodBeat.i(135493);
            setWillNotDraw(true);
            AppMethodBeat.o(135493);
        }

        /* access modifiers changed from: protected */
        public final void onAttachedToWindow() {
            AppMethodBeat.i(219632);
            super.onAttachedToWindow();
            this.oBB = false;
            AppMethodBeat.o(219632);
        }

        /* access modifiers changed from: protected */
        public final void onDetachedFromWindow() {
            AppMethodBeat.i(219633);
            super.onDetachedFromWindow();
            this.oBB = true;
            AppMethodBeat.o(219633);
        }

        /* access modifiers changed from: protected */
        @Override // android.widget.FrameLayout, android.view.ViewGroup
        public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
            AppMethodBeat.i(135494);
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) super.generateLayoutParams(layoutParams);
            if (-1 == layoutParams2.gravity) {
                layoutParams2.gravity = 17;
            }
            AppMethodBeat.o(135494);
            return layoutParams2;
        }

        public final void onViewAdded(View view) {
            AppMethodBeat.i(135495);
            super.onViewAdded(view);
            bringToFront();
            bringChildToFront(view);
            AppMethodBeat.o(135495);
        }

        public final void onViewRemoved(View view) {
            AppMethodBeat.i(135496);
            super.onViewRemoved(view);
            if (getChildCount() == 0) {
                setVisibility(8);
                if (getParent() instanceof ViewGroup) {
                    ((ViewGroup) getParent()).removeView(this);
                }
            }
            AppMethodBeat.o(135496);
        }

        /* access modifiers changed from: protected */
        public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(135497);
            super.onLayout(z, i2, i3, i4, i5);
            if (!u.aD(this)) {
                AppMethodBeat.o(135497);
                return;
            }
            getWindowVisibleDisplayFrame(this.mC);
            getLocationInWindow(this.oBA);
            if (Log.getLogLevel() <= 1) {
                Log.d("MicroMsg.PagePromptViewContainerLayout[keyboard]", "onLayout, WindowVisibleDisplayFrame=%s, location=%s", this.mC, org.apache.commons.b.a.toString(this.oBA));
            }
            for (int i6 = 0; i6 < getChildCount(); i6++) {
                View childAt = getChildAt(i6);
                int top = ((this.oBA[1] + childAt.getTop()) + childAt.getHeight()) - this.mC.bottom;
                if (top > 0) {
                    int max = Math.max(0, childAt.getTop() - top);
                    childAt.layout(childAt.getLeft(), max, childAt.getRight(), childAt.getHeight() + max);
                }
            }
            AppMethodBeat.o(135497);
        }
    }

    public static void ccL() {
        AppMethodBeat.i(135504);
        if (!ag.LB()) {
            RuntimeException runtimeException = new RuntimeException("Should be called on main-thread");
            AppMethodBeat.o(135504);
            throw runtimeException;
        }
        AppMethodBeat.o(135504);
    }
}
