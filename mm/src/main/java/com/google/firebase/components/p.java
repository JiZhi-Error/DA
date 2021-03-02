package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class p<T> implements a<T> {
    private static final Object bKX = new Object();
    private volatile Object bKY = bKX;
    private volatile a<T> bKZ;

    static {
        AppMethodBeat.i(4095);
        AppMethodBeat.o(4095);
    }

    p(d<T> dVar, b bVar) {
        AppMethodBeat.i(4092);
        this.bKZ = new q(dVar, bVar);
        AppMethodBeat.o(4092);
    }

    static final /* synthetic */ Object a(d dVar, b bVar) {
        AppMethodBeat.i(4094);
        Object a2 = dVar.a(bVar);
        AppMethodBeat.o(4094);
        return a2;
    }

    @Override // com.google.firebase.a.a
    public final T get() {
        AppMethodBeat.i(4093);
        T t = (T) this.bKY;
        if (t == bKX) {
            synchronized (this) {
                try {
                    t = this.bKY;
                    if (t == bKX) {
                        t = this.bKZ.get();
                        this.bKY = t;
                        this.bKZ = null;
                    }
                } finally {
                    AppMethodBeat.o(4093);
                }
            }
        }
        return t;
    }
}
