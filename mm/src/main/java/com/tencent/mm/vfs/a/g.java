package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.f;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class g<S, T> implements Iterator<T> {
    private final Iterator<? extends S> ReR;
    private T ReT;
    private boolean ReU;
    private final f.a<S, T> ReY;

    g(Iterator<? extends S> it, f.a<S, T> aVar) {
        this.ReR = it;
        this.ReY = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.vfs.a.f$a<S, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean hasNext() {
        AppMethodBeat.i(187780);
        if (this.ReU) {
            AppMethodBeat.o(187780);
            return true;
        } else if (this.ReR.hasNext()) {
            this.ReT = (T) this.ReY.er(this.ReR.next());
            this.ReU = true;
            AppMethodBeat.o(187780);
            return true;
        } else {
            AppMethodBeat.o(187780);
            return false;
        }
    }

    @Override // java.util.Iterator
    public final T next() {
        AppMethodBeat.i(187781);
        if (this.ReU || hasNext()) {
            T t = this.ReT;
            this.ReT = null;
            this.ReU = false;
            AppMethodBeat.o(187781);
            return t;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(187781);
        throw noSuchElementException;
    }
}
