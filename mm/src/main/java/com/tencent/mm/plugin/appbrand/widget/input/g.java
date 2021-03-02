package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.ap;
import com.tencent.mm.plugin.appbrand.page.as;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bv;
import com.tencent.mm.plugin.appbrand.page.bz;
import com.tencent.mm.plugin.appbrand.page.cc;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.d;
import com.tencent.mm.plugin.appbrand.widget.base.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"ViewConstructor"})
public final class g extends AbsoluteLayout implements aj.b, ap, as, bv, bz, d {
    private final ac cxr;
    private final AbsoluteLayout ojW;
    private final List<bv.a> ojX = new LinkedList();
    final e orW;
    private boolean orX;
    private int orY;
    private int orZ;

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(136349);
        super.requestLayout();
        AppMethodBeat.o(136349);
    }

    public g(ac acVar) {
        super(acVar.getContext());
        AppMethodBeat.i(136331);
        super.setId(R.id.pn);
        this.cxr = acVar;
        this.ojW = this;
        this.orW = new e(this.ojW);
        AppMethodBeat.o(136331);
    }

    public final void setId(int i2) {
    }

    public final <Input extends View & ab> boolean a(bb bbVar, Input input, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136332);
        boolean b2 = b(bbVar, input, i2, i3, i4, i5);
        AppMethodBeat.o(136332);
        return b2;
    }

    private <Input extends View & ab> boolean b(bb bbVar, Input input, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136333);
        if (bbVar == null || bbVar.getWrapperView() == null || input == null) {
            AppMethodBeat.o(136333);
            return false;
        }
        b(bbVar);
        this.ojW.addView(input, new AbsoluteLayout.LayoutParams(i2, i3, i4, i5));
        input.G(this.cxr);
        AppMethodBeat.o(136333);
        return true;
    }

    private void b(bb bbVar) {
        AppMethodBeat.i(136334);
        View wrapperView = bbVar.getWrapperView();
        if (!(this.ojW.getWidth() == wrapperView.getWidth() && this.ojW.getHeight() == wrapperView.getHeight())) {
            ViewGroup.LayoutParams layoutParams = this.ojW.getLayoutParams();
            layoutParams.width = wrapperView.getWidth();
            layoutParams.height = wrapperView.getHeight();
            this.ojW.setLayoutParams(layoutParams);
        }
        AppMethodBeat.o(136334);
    }

    public final <Input extends View & ab> boolean c(bb bbVar, Input input, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136335);
        if (bbVar == null || bbVar.getWrapperView() == null || input == null) {
            AppMethodBeat.o(136335);
            return false;
        } else if (!cU(input)) {
            AppMethodBeat.o(136335);
            return false;
        } else {
            b(bbVar);
            if (input.getLayoutParams() == null || !(input.getLayoutParams() instanceof AbsoluteLayout.LayoutParams)) {
                AppMethodBeat.o(136335);
                return false;
            }
            if (!(input.getWidth() == i2 && input.getHeight() == i3 && input.getLeft() == i4 && input.getTop() == i5)) {
                AbsoluteLayout.LayoutParams layoutParams = (AbsoluteLayout.LayoutParams) input.getLayoutParams();
                layoutParams.x = i4;
                layoutParams.y = i5;
                layoutParams.width = i2;
                layoutParams.height = i3;
                input.setLayoutParams(layoutParams);
            }
            AppMethodBeat.o(136335);
            return true;
        }
    }

    private <Input extends View & ab> boolean cU(Input input) {
        AppMethodBeat.i(136336);
        if (input == null) {
            AppMethodBeat.o(136336);
            return false;
        } else if (this.ojW == null) {
            AppMethodBeat.o(136336);
            return false;
        } else {
            for (int i2 = 0; i2 < this.ojW.getChildCount(); i2++) {
                if (input == this.ojW.getChildAt(i2)) {
                    AppMethodBeat.o(136336);
                    return true;
                }
            }
            AppMethodBeat.o(136336);
            return false;
        }
    }

    public final <Input extends View & ab> void cV(Input input) {
        AppMethodBeat.i(136337);
        if (input == null) {
            AppMethodBeat.o(136337);
            return;
        }
        input.setVisibility(8);
        Log.v("MicroMsg.AppBrandInputContainer", "clearWebView imm active = %b", Boolean.valueOf(aj.dg(this).isActive()));
        this.ojW.removeView(input);
        input.H(this.cxr);
        AppMethodBeat.o(136337);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.as
    public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(136338);
        Log.v("MicroMsg.AppBrandInputContainer", "onScrollChanged, left = %d, top = %d, oldLeft = %d, oldTop = %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
        if (this.ojW != null) {
            e(false, view.getWidth(), view.getHeight());
            this.ojW.scrollTo(i2, i3);
        }
        for (bv.a aVar : this.ojX) {
            aVar.eu(i2, i3);
        }
        AppMethodBeat.o(136338);
    }

    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.aj.b
    public final void hK(int i2) {
        AppMethodBeat.i(136339);
        setTranslationY((float) i2);
        AppMethodBeat.o(136339);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.base.c
    public final boolean caj() {
        AppMethodBeat.i(136340);
        if (getChildCount() <= 0) {
            AppMethodBeat.o(136340);
            return false;
        }
        for (int i2 = 0; i2 <= getChildCount(); i2++) {
            if (AppBrandViewMotionCompat.cM(getChildAt(i2))) {
                AppMethodBeat.o(136340);
                return true;
            }
        }
        AppMethodBeat.o(136340);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.base.d
    public final boolean L(MotionEvent motionEvent) {
        AppMethodBeat.i(136341);
        if (motionEvent == null || motionEvent.getActionMasked() != 0) {
            AppMethodBeat.o(136341);
            return false;
        }
        e eVar = this.orW;
        if (motionEvent == null || motionEvent.getActionMasked() != 0 || eVar.omC == null) {
            AppMethodBeat.o(136341);
            return false;
        } else if (motionEvent.getDownTime() == eVar.omC.hET && motionEvent.getEventTime() == eVar.omC.lTl) {
            AppMethodBeat.o(136341);
            return true;
        } else {
            AppMethodBeat.o(136341);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bv
    public final void a(bv.a aVar) {
        AppMethodBeat.i(136342);
        if (aVar == null) {
            AppMethodBeat.o(136342);
        } else if (this.ojX.contains(aVar)) {
            AppMethodBeat.o(136342);
        } else {
            this.ojX.add(aVar);
            AppMethodBeat.o(136342);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bv
    public final void b(bv.a aVar) {
        AppMethodBeat.i(136343);
        if (aVar == null) {
            AppMethodBeat.o(136343);
            return;
        }
        this.ojX.remove(aVar);
        AppMethodBeat.o(136343);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        AppMethodBeat.i(136344);
        this.orX = (!isLayoutRequested() && i2 == this.orY && i3 == this.orZ) ? false : true;
        this.orY = i2;
        this.orZ = i3;
        super.onMeasure(i2, i3);
        this.orX = false;
        AppMethodBeat.o(136344);
    }

    /* access modifiers changed from: protected */
    public final void measureChild(View view, int i2, int i3) {
        AppMethodBeat.i(136345);
        if (this.orX) {
            view.forceLayout();
        }
        super.measureChild(view, i2, i3);
        AppMethodBeat.o(136345);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ap
    public final void c(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136346);
        if (e(z, i4 - i2, i5 - i3)) {
            post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(136330);
                    g.a(g.this);
                    AppMethodBeat.o(136330);
                }
            });
        }
        AppMethodBeat.o(136346);
    }

    private boolean e(boolean z, int i2, int i3) {
        AppMethodBeat.i(136347);
        if (this.ojW == null) {
            AppMethodBeat.o(136347);
            return false;
        }
        ViewGroup.LayoutParams layoutParams = this.ojW.getLayoutParams();
        if (layoutParams == null) {
            this.ojW.setLayoutParams(new ViewGroup.LayoutParams(i2, i3));
            AppMethodBeat.o(136347);
            return true;
        } else if (i2 == layoutParams.width && i3 == layoutParams.height) {
            AppMethodBeat.o(136347);
            return z;
        } else {
            layoutParams.width = i2;
            layoutParams.height = i3;
            this.ojW.setLayoutParams(layoutParams);
            AppMethodBeat.o(136347);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bz
    public final boolean c(Canvas canvas) {
        AppMethodBeat.i(136348);
        canvas.save();
        canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
        if (cc.k(this)) {
            cc.a(canvas, this, 0.0f, 0.0f);
        } else {
            draw(canvas);
        }
        canvas.restore();
        AppMethodBeat.o(136348);
        return true;
    }
}
