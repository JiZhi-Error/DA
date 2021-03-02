package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import java.lang.ref.WeakReference;

public final class l implements i.b, i.c {
    final WeakReference<ac> orG;

    public l(ac acVar) {
        AppMethodBeat.i(136408);
        this.orG = new WeakReference<>(acVar);
        acVar.a((i.b) this);
        acVar.a((i.c) this);
        AppMethodBeat.o(136408);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
    public final void onBackground() {
        AppMethodBeat.i(136409);
        ac acVar = this.orG.get();
        if (acVar != null) {
            o.D(acVar);
        }
        AppMethodBeat.o(136409);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
    public final void onDestroy() {
        AppMethodBeat.i(136410);
        ac acVar = this.orG.get();
        if (acVar != null) {
            if (acVar.getContext() instanceof ad) {
                ((ad) acVar.getContext()).hideVKB();
            }
            o.D(acVar);
            o.E(acVar);
            e.B(acVar);
            acVar.b((i.b) this);
            acVar.b((i.c) this);
            if (acVar.nmX != null) {
                h.cbe().c(acVar.nmX);
            }
        }
        AppMethodBeat.o(136410);
    }
}
