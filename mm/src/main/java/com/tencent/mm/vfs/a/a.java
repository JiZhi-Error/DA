package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

public final class a<S, T> implements Iterable<T> {
    private final Iterable<? extends S> ReP;
    private final AbstractC2153a<S, ? extends T> ReQ;

    /* renamed from: com.tencent.mm.vfs.a.a$a  reason: collision with other inner class name */
    public interface AbstractC2153a<S, T> {
        Iterable<? extends T> eq(S s);
    }

    public a(Iterable<? extends S> iterable, AbstractC2153a<S, ? extends T> aVar) {
        this.ReP = iterable;
        this.ReQ = aVar;
    }

    @Override // java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(187769);
        b bVar = new b(this.ReP.iterator(), this.ReQ);
        AppMethodBeat.o(187769);
        return bVar;
    }
}
