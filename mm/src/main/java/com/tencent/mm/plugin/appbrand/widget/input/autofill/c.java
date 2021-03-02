package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.widget.input.ab;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.AutoFillListPopupWindowBase;
import com.tencent.mm.plugin.appbrand.widget.input.k;

public final class c {
    final ab ovY;
    final e ovZ;
    public final k.a owl = new k.a() {
        /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.widget.input.k.a
        public final void cbs() {
            AppMethodBeat.i(136637);
            c.this.own = Integer.MIN_VALUE;
            c.this.Ao(3);
            AppMethodBeat.o(136637);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.input.k.a
        public final void cbt() {
            AppMethodBeat.i(136638);
            c.this.own = Integer.MIN_VALUE;
            c.this.Ao(3);
            AppMethodBeat.o(136638);
        }
    };
    public ac owm;
    int own = Integer.MIN_VALUE;
    boolean owo = false;

    c(ab abVar, e eVar) {
        AppMethodBeat.i(136641);
        this.ovY = abVar;
        this.ovZ = eVar;
        AppMethodBeat.o(136641);
    }

    /* access modifiers changed from: package-private */
    public final void Ao(final int i2) {
        AppMethodBeat.i(136642);
        final AutoFillListPopupWindowBase.a aVar = this.ovZ.ows;
        if (aVar == null) {
            AppMethodBeat.o(136642);
        } else if (!this.ovZ.arA.isShowing()) {
            AppMethodBeat.o(136642);
        } else {
            if (1 == i2 && this.owo) {
                this.own = Integer.MIN_VALUE;
                this.owo = false;
            }
            aVar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.autofill.c.AnonymousClass3 */

                public final boolean onPreDraw() {
                    View inputPanel;
                    int i2;
                    AppMethodBeat.i(136640);
                    aVar.getViewTreeObserver().removeOnPreDrawListener(this);
                    c cVar = c.this;
                    if (!(!cVar.ovZ.arA.isShowing() || cVar.ovZ.ows == null || cVar.ovZ.ows.getAdapter() == null || cVar.ovZ.ows.getAdapter().getCount() <= 0 || (inputPanel = cVar.ovY.getInputPanel()) == null)) {
                        int fromDPToPix = a.fromDPToPix(cVar.ovY.getContext(), 8);
                        int height = cVar.ovZ.ows.getChildAt(0).getHeight();
                        int count = cVar.ovZ.ows.getAdapter().getCount() * height;
                        int i3 = count + (fromDPToPix * 2);
                        int i4 = (height * 3) + (fromDPToPix * 2);
                        if (i3 > i4) {
                            count = i4 - (fromDPToPix * 2);
                        } else {
                            i4 = i3;
                        }
                        cVar.ovZ.ard = i4;
                        int[] iArr = new int[2];
                        cVar.ovY.getView().getLocationInWindow(iArr);
                        int height2 = cVar.ovY.getView().getHeight() + iArr[1];
                        inputPanel.getLocationInWindow(iArr);
                        int i5 = iArr[1];
                        while (true) {
                            if ((cVar.own == Integer.MIN_VALUE || cVar.own >= 0 - fromDPToPix) && i5 - height2 >= count + fromDPToPix) {
                                cVar.ovZ.arp = cVar.ovY.getView();
                                cVar.ovZ.ard = (fromDPToPix * 2) + count;
                                cVar.ovZ.setVerticalOffset(0 - fromDPToPix);
                                break;
                            } else if (height2 - cVar.ovY.getView().getHeight() >= count) {
                                cVar.ovZ.arp = cVar.ovY.getView();
                                cVar.ovZ.ard = (fromDPToPix * 2) + count;
                                cVar.ovZ.setVerticalOffset((-(count + fromDPToPix)) - cVar.ovY.getView().getHeight());
                                break;
                            } else if (count <= height) {
                                cVar.ovZ.ard = height;
                                cVar.ovZ.arp = cVar.ovY.getView();
                                if (cVar.own < 0 - fromDPToPix) {
                                    cVar.ovZ.setVerticalOffset((-(count + fromDPToPix)) - cVar.ovY.getView().getHeight());
                                } else {
                                    cVar.ovZ.setVerticalOffset(0 - fromDPToPix);
                                }
                            } else {
                                count -= height;
                            }
                        }
                        cVar.ovZ.show();
                        e eVar = cVar.ovZ;
                        if (!eVar.arh) {
                            i2 = 0;
                        } else {
                            i2 = eVar.arf;
                        }
                        cVar.own = i2;
                    }
                    AppMethodBeat.o(136640);
                    return true;
                }
            });
            AppMethodBeat.o(136642);
        }
    }
}
