package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.c;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class d<T> implements Iterator<T> {
    private final Iterator<? extends T> ReR;
    private T ReT;
    private boolean ReU;
    private final c.a<T> ReV;

    d(Iterator<? extends T> it, c.a<T> aVar) {
        this.ReR = it;
        this.ReV = aVar;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(187774);
        if (this.ReU) {
            AppMethodBeat.o(187774);
            return true;
        }
        while (this.ReR.hasNext()) {
            T t = (T) this.ReR.next();
            if (!this.ReV.dm(t)) {
                this.ReT = t;
                this.ReU = true;
                AppMethodBeat.o(187774);
                return true;
            }
        }
        AppMethodBeat.o(187774);
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        AppMethodBeat.i(187775);
        if (this.ReU || hasNext()) {
            T t = this.ReT;
            this.ReT = null;
            this.ReU = false;
            AppMethodBeat.o(187775);
            return t;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(187775);
        throw noSuchElementException;
    }
}
