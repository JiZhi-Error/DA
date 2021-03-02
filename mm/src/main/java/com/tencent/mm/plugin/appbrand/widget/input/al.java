package com.tencent.mm.plugin.appbrand.widget.input;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.az;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.page.bf;
import com.tencent.mm.plugin.appbrand.widget.base.AppBrandViewMotionCompat;
import com.tencent.mm.plugin.appbrand.widget.base.b;
import com.tencent.mm.plugin.appbrand.widget.base.e;

public final class al implements bf {
    private static View.OnTouchListener ovB = new View.OnTouchListener() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.al.AnonymousClass1 */

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(136599);
            AppMethodBeat.o(136599);
            return false;
        }
    };
    private final ac cwK;
    private final g ovC;

    public static final class a implements bf.a {
    }

    static {
        AppMethodBeat.i(177120);
        AppMethodBeat.o(177120);
    }

    public al(ac acVar) {
        AppMethodBeat.i(136600);
        this.cwK = acVar;
        this.ovC = new g(acVar);
        AppMethodBeat.o(136600);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final void setupWebViewTouchInterceptor(bb bbVar) {
        AppMethodBeat.i(136601);
        final g gVar = this.ovC;
        final ah ahVar = new ah(gVar);
        ((ViewGroup) bbVar.getContentView()).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.input.al.AnonymousClass2 */

            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z;
                aj df;
                boolean z2;
                b it;
                boolean z3;
                boolean z4;
                AppMethodBeat.i(177118);
                if (motionEvent.getAction() != 0) {
                    e.a(gVar, motionEvent);
                }
                ah ahVar = ahVar;
                if (motionEvent != null) {
                    com.tencent.mm.plugin.appbrand.widget.base.e eVar = ahVar.ovi.orW;
                    if (eVar.parent.onFilterTouchEventForSecurity(motionEvent)) {
                        if (motionEvent.getActionMasked() == 0) {
                            it = new b(eVar.parent);
                        } else {
                            it = eVar.omB.iterator();
                        }
                        eVar.omC = motionEvent.getActionMasked() == 0 ? new e.a(motionEvent.getDownTime(), motionEvent.getEventTime(), (byte) 0) : null;
                        z = false;
                        while (it.hasNext()) {
                            View next = it.next();
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = eVar.parent.isMotionEventSplittingEnabled() ? 1 << motionEvent.getPointerId(actionIndex) : -1;
                            float x = motionEvent.getX(actionIndex);
                            float y = motionEvent.getY(actionIndex);
                            if (motionEvent.getActionMasked() != 0) {
                                z3 = AppBrandViewMotionCompat.dispatchTransformedTouchEvent(eVar.parent, motionEvent, false, next, pointerId) | z;
                            } else if (AppBrandViewMotionCompat.cN(next) && AppBrandViewMotionCompat.a(eVar.parent, x, y, next)) {
                                if (AppBrandViewMotionCompat.cM(next)) {
                                    if (AppBrandViewMotionCompat.dispatchTransformedTouchEvent(eVar.parent, motionEvent, false, next, pointerId)) {
                                        eVar.omB.addLast(next);
                                        z4 = z | true;
                                    } else {
                                        z4 = z;
                                    }
                                    z = z4;
                                } else {
                                    z3 = z;
                                }
                            }
                            z = z3;
                        }
                        switch (motionEvent.getActionMasked()) {
                            case 1:
                            case 3:
                                eVar.omB.clear();
                                break;
                        }
                    } else {
                        z = false;
                    }
                    com.tencent.mm.plugin.appbrand.widget.base.a.a("MicroMsg.AppBrand.InputTouchDuplicateDispatcher", "[textscroll] handled | ".concat(String.valueOf(z)), motionEvent);
                    if (2 == motionEvent.getActionMasked()) {
                        if (z && !ahVar.ovj && (df = ahVar.ovn.df(ahVar.ovi)) != null) {
                            if (!df.mDisabled) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            ahVar.ovk = z2;
                            df.setPullDownEnabled(false);
                            df.requestDisallowInterceptTouchEvent(true);
                            ahVar.ovj = true;
                        }
                        if (z) {
                            ahVar.ovl = true;
                        } else if (ahVar.ovl) {
                            ahVar.ovl = false;
                        }
                    }
                    switch (motionEvent.getActionMasked()) {
                        case 1:
                        case 3:
                            if (ahVar.ovj) {
                                aj df2 = ahVar.ovn.df(ahVar.ovi);
                                if (df2 != null) {
                                    df2.setPullDownEnabled(ahVar.ovk);
                                }
                                ahVar.ovj = false;
                            }
                        case 0:
                            z = false;
                            break;
                    }
                } else {
                    z = false;
                }
                if (z) {
                    AppMethodBeat.o(177118);
                    return true;
                }
                AppMethodBeat.o(177118);
                return false;
            }
        });
        AppMethodBeat.o(136601);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final void a(az azVar) {
        AppMethodBeat.i(136602);
        if (azVar == az.MODAL || azVar == az.ACTION_SHEET) {
            o.D(this.cwK);
        }
        AppMethodBeat.o(136602);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.aj.b
    public final void hK(int i2) {
        AppMethodBeat.i(136603);
        this.ovC.setTranslationY((float) i2);
        AppMethodBeat.o(136603);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.as
    public final void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(136604);
        this.ovC.onScrollChanged(i2, i3, i4, i5, view);
        AppMethodBeat.o(136604);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final ViewGroup getContainer() {
        return this.ovC;
    }

    @Override // com.tencent.mm.plugin.appbrand.page.bf
    public final void a(bb bbVar) {
        AppMethodBeat.i(177119);
        if (bbVar.getContentView() == null) {
            AppMethodBeat.o(177119);
            return;
        }
        ((ViewGroup) bbVar.getContentView()).setOnTouchListener(ovB);
        AppMethodBeat.o(177119);
    }

    @Override // com.tencent.mm.plugin.appbrand.page.ap
    public final void c(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(136605);
        this.ovC.c(z, i2, i3, i4, i5);
        AppMethodBeat.o(136605);
    }
}
