package com.bumptech.glide.load.b.a;

import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.m;
import java.util.Queue;

/* access modifiers changed from: package-private */
public abstract class d<T extends m> {
    private final Queue<T> aIn = k.ds(20);

    /* access modifiers changed from: package-private */
    public abstract T pc();

    d() {
    }

    /* access modifiers changed from: package-private */
    public final T pd() {
        T poll = this.aIn.poll();
        if (poll == null) {
            return pc();
        }
        return poll;
    }

    public final void a(T t) {
        if (this.aIn.size() < 20) {
            this.aIn.offer(t);
        }
    }
}
