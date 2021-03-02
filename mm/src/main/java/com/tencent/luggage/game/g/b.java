package com.tencent.luggage.game.g;

import android.support.v4.e.l;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class b<T> implements l.a<T> {
    public ConcurrentLinkedQueue<T> cxP = new ConcurrentLinkedQueue<>();

    /* access modifiers changed from: protected */
    public abstract T Mc();

    @Override // android.support.v4.e.l.a
    public final T acquire() {
        T poll = this.cxP.poll();
        if (poll == null) {
            return Mc();
        }
        return poll;
    }

    @Override // android.support.v4.e.l.a
    public final boolean release(T t) {
        return this.cxP.offer(t);
    }
}
