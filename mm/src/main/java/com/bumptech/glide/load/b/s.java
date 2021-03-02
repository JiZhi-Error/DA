package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class s {
    private final Map<g, l<?>> aHT = new HashMap();
    private final Map<g, l<?>> aHU = new HashMap();

    s() {
        AppMethodBeat.i(77031);
        AppMethodBeat.o(77031);
    }

    /* access modifiers changed from: package-private */
    public final Map<g, l<?>> aG(boolean z) {
        return z ? this.aHU : this.aHT;
    }

    /* access modifiers changed from: package-private */
    public final void a(g gVar, l<?> lVar) {
        AppMethodBeat.i(77032);
        Map<g, l<?>> aG = aG(lVar.aGr);
        if (lVar.equals(aG.get(gVar))) {
            aG.remove(gVar);
        }
        AppMethodBeat.o(77032);
    }
}
