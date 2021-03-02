package com.tencent.mm.av.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingDeque;

public final class a<E> extends LinkedBlockingDeque<E> {
    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Deque
    public final boolean offer(E e2) {
        AppMethodBeat.i(130431);
        boolean offerFirst = super.offerFirst(e2);
        AppMethodBeat.o(130431);
        return offerFirst;
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, java.util.Deque
    public final E remove() {
        AppMethodBeat.i(130432);
        E e2 = (E) super.removeFirst();
        AppMethodBeat.o(130432);
        return e2;
    }
}
