package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class b<S, T> implements Iterator<T> {
    private final a.AbstractC2153a<S, ? extends T> ReQ;
    private final Iterator<? extends S> ReR;
    private Iterator<? extends T> ReS = Collections.emptyList().iterator();
    private T ReT;
    private boolean ReU;

    public b(Iterator<? extends S> it, a.AbstractC2153a<S, ? extends T> aVar) {
        AppMethodBeat.i(187770);
        this.ReR = it;
        this.ReQ = aVar;
        AppMethodBeat.o(187770);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v10, resolved type: com.tencent.mm.vfs.a.a$a<S, ? extends T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean hasNext() {
        AppMethodBeat.i(187771);
        if (this.ReU) {
            AppMethodBeat.o(187771);
            return true;
        } else if (this.ReS == null) {
            AppMethodBeat.o(187771);
            return false;
        } else {
            while (!this.ReS.hasNext()) {
                this.ReT = null;
                this.ReS = null;
                if (this.ReR.hasNext()) {
                    Iterable eq = this.ReQ.eq(this.ReR.next());
                    this.ReS = eq != null ? eq.iterator() : Collections.emptyList().iterator();
                } else {
                    AppMethodBeat.o(187771);
                    return false;
                }
            }
            this.ReT = (T) this.ReS.next();
            this.ReU = true;
            AppMethodBeat.o(187771);
            return true;
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        AppMethodBeat.i(187772);
        if (this.ReU || hasNext()) {
            T t = this.ReT;
            this.ReT = null;
            this.ReU = false;
            AppMethodBeat.o(187772);
            return t;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(187772);
        throw noSuchElementException;
    }
}
