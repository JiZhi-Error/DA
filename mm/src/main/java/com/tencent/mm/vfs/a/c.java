package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class c<T> implements Iterable<T> {
    private final Iterable<? extends T> ReP;
    private final a<T> ReV;

    public interface a<T> {
        boolean dm(T t);
    }

    public c(Iterable<? extends T> iterable, a<T> aVar) {
        this.ReP = iterable;
        this.ReV = aVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(187773);
        d dVar = new d(this.ReP.iterator(), this.ReV);
        AppMethodBeat.o(187773);
        return dVar;
    }
}
