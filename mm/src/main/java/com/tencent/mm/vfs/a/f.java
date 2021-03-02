package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class f<S, T> implements Iterable<T> {
    private final Iterable<? extends S> ReP;
    private final a<S, T> ReY;

    public interface a<S, T> {
        T er(S s);
    }

    public f(Iterable<? extends S> iterable, a<S, T> aVar) {
        this.ReP = iterable;
        this.ReY = aVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(187779);
        g gVar = new g(this.ReP.iterator(), this.ReY);
        AppMethodBeat.o(187779);
        return gVar;
    }
}
