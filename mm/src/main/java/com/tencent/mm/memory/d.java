package com.tencent.mm.memory;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class d<T, S> {
    protected Queue<T> its = new ConcurrentLinkedQueue();
    protected S itt;

    public d(S s) {
        this.itt = s;
    }

    public final T pop() {
        return this.its.poll();
    }

    public final void put(T t) {
        this.its.add(t);
    }

    public final int size() {
        return this.its.size();
    }

    public final S aRS() {
        return this.itt;
    }
}
