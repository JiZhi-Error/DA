package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final /* synthetic */ class q implements a {
    private final d bLa;
    private final b bLb;

    q(d dVar, b bVar) {
        this.bLa = dVar;
        this.bLb = bVar;
    }

    @Override // com.google.firebase.a.a
    public final Object get() {
        AppMethodBeat.i(4096);
        Object a2 = p.a(this.bLa, this.bLb);
        AppMethodBeat.o(4096);
        return a2;
    }
}
