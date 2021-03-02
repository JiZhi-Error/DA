package com.google.firebase.components;

import com.google.firebase.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class s implements b {
    private final Set<Class<?>> bLc;
    private final Set<Class<?>> bLd;
    private final b bLe;

    @Override // com.google.firebase.components.b
    public final <T> a<T> A(Class<T> cls) {
        AppMethodBeat.i(4101);
        if (!this.bLd.contains(cls)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", cls));
            AppMethodBeat.o(4101);
            throw illegalArgumentException;
        }
        a<T> A = this.bLe.A(cls);
        AppMethodBeat.o(4101);
        return A;
    }

    @Override // com.google.firebase.components.b
    public final <T> T y(Class<T> cls) {
        AppMethodBeat.i(4100);
        if (!this.bLc.contains(cls)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Requesting %s is not allowed.", cls));
            AppMethodBeat.o(4100);
            throw illegalArgumentException;
        }
        T t = (T) this.bLe.y(cls);
        AppMethodBeat.o(4100);
        return t;
    }

    public s(Iterable<f> iterable, b bVar) {
        AppMethodBeat.i(4099);
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (f fVar : iterable) {
            if (fVar.ya()) {
                hashSet.add(fVar.bKM);
            } else {
                hashSet2.add(fVar.bKM);
            }
        }
        this.bLc = Collections.unmodifiableSet(hashSet);
        this.bLd = Collections.unmodifiableSet(hashSet2);
        this.bLe = bVar;
        AppMethodBeat.o(4099);
    }
}
