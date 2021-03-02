package com.google.firebase.components;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* access modifiers changed from: package-private */
public final class o {
    final a<?> bKU;
    final Set<o> bKV = new HashSet();
    final Set<o> bKW = new HashSet();

    o(a<?> aVar) {
        AppMethodBeat.i(4090);
        this.bKU = aVar;
        AppMethodBeat.o(4090);
    }

    /* access modifiers changed from: package-private */
    public final boolean yb() {
        AppMethodBeat.i(4091);
        boolean isEmpty = this.bKW.isEmpty();
        AppMethodBeat.o(4091);
        return isEmpty;
    }
}
