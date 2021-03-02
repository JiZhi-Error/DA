package com.tencent.mm.vfs.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.a.h;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class i<T> implements Iterator<T> {
    private final Iterator<? extends T> ReR;
    private final h.a<T> ReZ;
    private boolean mCalled = false;

    i(Iterator<? extends T> it, h.a<T> aVar) {
        this.ReR = it;
        this.ReZ = aVar;
    }

    public final boolean hasNext() {
        AppMethodBeat.i(187783);
        boolean hasNext = this.ReR.hasNext();
        if (!hasNext && !this.mCalled) {
            this.ReZ.hen();
            this.mCalled = true;
        }
        AppMethodBeat.o(187783);
        return hasNext;
    }

    @Override // java.util.Iterator
    public final T next() {
        AppMethodBeat.i(187784);
        try {
            T t = (T) this.ReR.next();
            AppMethodBeat.o(187784);
            return t;
        } catch (NoSuchElementException e2) {
            if (!this.mCalled) {
                this.ReZ.hen();
                this.mCalled = true;
            }
            AppMethodBeat.o(187784);
            throw e2;
        }
    }
}
