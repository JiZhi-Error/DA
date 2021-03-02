package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class u implements com.tencent.mm.plugin.appbrand.widget.d.a {
    private static Integer otI = null;
    private int crS = 0;
    private final int[] crT = new int[2];
    private final Rect crU = new Rect();
    private boolean crV = false;
    private View crW;
    private final LinkedHashSet<c> crY = new LinkedHashSet<>();
    b otH;

    /* access modifiers changed from: package-private */
    public interface a {
        void c(c cVar);
    }

    /* access modifiers changed from: package-private */
    public interface b extends c {
    }

    public interface c {
        void bQ(boolean z);

        int getHeight();

        void hF(int i2);
    }

    public u() {
        AppMethodBeat.i(131506);
        AppMethodBeat.o(131506);
    }

    private void getWindowVisibleDisplayFrame(Rect rect) {
        AppMethodBeat.i(131507);
        if (this.crW != null) {
            this.crW.getWindowVisibleDisplayFrame(rect);
            this.crW.getLocationInWindow(this.crT);
            rect.top = this.crT[1];
        }
        AppMethodBeat.o(131507);
    }

    private Context getContext() {
        AppMethodBeat.i(131508);
        if (this.crW == null) {
            Context context = MMApplicationContext.getContext();
            AppMethodBeat.o(131508);
            return context;
        }
        Context context2 = this.crW.getContext();
        AppMethodBeat.o(131508);
        return context2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.d.a
    public final void bZ(View view) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(131510);
        this.crW = view;
        Rect rect = this.crU;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.crS == 0) {
            this.crS = height;
        }
        final int frameHeight = getFrameHeight() - height;
        if (frameHeight > 0) {
            Context context = getContext();
            if (frameHeight > 0) {
                if (otI == null) {
                    otI = Integer.valueOf(KeyBoardUtil.getValidPanelHeight(context));
                }
                if (otI.intValue() != frameHeight) {
                    otI = Integer.valueOf(frameHeight);
                    z = true;
                    a(new a() {
                        /* class com.tencent.mm.plugin.appbrand.widget.input.u.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.appbrand.widget.input.u.a
                        public final void c(c cVar) {
                            AppMethodBeat.i(131504);
                            if (cVar.getHeight() != frameHeight) {
                                cVar.hF(frameHeight);
                            }
                            AppMethodBeat.o(131504);
                        }
                    });
                    if (this.otH != null && (z || this.otH.getHeight() != frameHeight)) {
                        this.otH.hF(frameHeight);
                    }
                }
            }
            z = false;
            a(new a() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.u.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.widget.input.u.a
                public final void c(c cVar) {
                    AppMethodBeat.i(131504);
                    if (cVar.getHeight() != frameHeight) {
                        cVar.hF(frameHeight);
                    }
                    AppMethodBeat.o(131504);
                }
            });
            this.otH.hF(frameHeight);
        }
        final boolean z3 = getFrameHeight() > height;
        if (this.crV == z3) {
            z2 = false;
        }
        if (z2) {
            if (this.otH != null) {
                this.otH.bQ(z3);
            }
            a(new a() {
                /* class com.tencent.mm.plugin.appbrand.widget.input.u.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.widget.input.u.a
                public final void c(c cVar) {
                    AppMethodBeat.i(131505);
                    cVar.bQ(z3);
                    AppMethodBeat.o(131505);
                }
            });
        }
        this.crV = z3;
        this.crS = height;
        this.crW = null;
        AppMethodBeat.o(131510);
    }

    private void a(a aVar) {
        AppMethodBeat.i(131511);
        Iterator it = ((LinkedHashSet) this.crY.clone()).iterator();
        while (it.hasNext()) {
            aVar.c((c) it.next());
        }
        AppMethodBeat.o(131511);
    }

    public final void a(c cVar) {
        AppMethodBeat.i(131512);
        if (cVar != null && !this.crY.contains(cVar)) {
            this.crY.add(cVar);
        }
        AppMethodBeat.o(131512);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(131513);
        if (cVar != null) {
            this.crY.remove(cVar);
        }
        AppMethodBeat.o(131513);
    }

    private int getFrameHeight() {
        View rootView;
        int i2;
        AppMethodBeat.i(131509);
        if (this.crW == null) {
            rootView = null;
        } else {
            rootView = this.crW.getRootView();
        }
        if (rootView == null) {
            AppMethodBeat.o(131509);
            return 0;
        }
        Rect rect = this.crU;
        getWindowVisibleDisplayFrame(rect);
        if (android.support.v4.view.u.az(this.crW)) {
            i2 = this.crW.getMeasuredHeight();
        } else {
            i2 = getContext().getResources().getDisplayMetrics().heightPixels;
        }
        int i3 = i2 - rect.top;
        AppMethodBeat.o(131509);
        return i3;
    }
}
