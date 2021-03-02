package com.tencent.mm.loader.i;

import java.util.concurrent.LinkedBlockingDeque;

public final class a<E> extends LinkedBlockingDeque<E> {
    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.LinkedBlockingDeque, java.util.concurrent.BlockingQueue, java.util.Queue, java.util.Deque
    public final boolean offer(E e2) {
        return super.offerFirst(e2);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.LinkedBlockingDeque, java.util.AbstractQueue, java.util.Queue, java.util.Deque
    public final E remove() {
        return (E) super.removeFirst();
    }
}
