package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class am implements ViewTreeObserver.OnGlobalLayoutListener {
    private final View ovG;
    private final a ovH;
    private int ovI;
    private int ovJ;
    private boolean ovK;

    public interface a {
        void caR();
    }

    public static void a(View view, a aVar) {
        AppMethodBeat.i(133758);
        am amVar = new am(view, aVar);
        amVar.ovG.getViewTreeObserver().addOnGlobalLayoutListener(amVar);
        AppMethodBeat.o(133758);
    }

    private am(View view, a aVar) {
        this.ovG = view;
        this.ovH = aVar;
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(133759);
        if (!this.ovK) {
            this.ovK = true;
            this.ovI = this.ovG.getWidth();
            this.ovJ = this.ovG.getHeight();
            AppMethodBeat.o(133759);
            return;
        }
        if (!(this.ovG.getWidth() == this.ovI && this.ovG.getHeight() == this.ovJ)) {
            this.ovH.caR();
            this.ovI = this.ovG.getWidth();
            this.ovJ = this.ovG.getHeight();
        }
        AppMethodBeat.o(133759);
    }
}
