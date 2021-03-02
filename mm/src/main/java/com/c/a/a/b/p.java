package com.c.a.a.b;

import com.c.a.a.a.a;
import java.util.Iterator;

/* access modifiers changed from: package-private */
public abstract class p<F, T> implements Iterator<T> {
    final Iterator<? extends F> cov;

    /* access modifiers changed from: package-private */
    public abstract T aA(F f2);

    p(Iterator<? extends F> it) {
        this.cov = (Iterator) a.checkNotNull(it);
    }

    public final boolean hasNext() {
        return this.cov.hasNext();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.c.a.a.b.p<F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Iterator
    public final T next() {
        return (T) aA(this.cov.next());
    }

    public final void remove() {
        this.cov.remove();
    }
}
