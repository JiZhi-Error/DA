package com.c.a.c;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

abstract class c<V> extends i implements Iterator<V> {
    private n cqk;

    /* access modifiers changed from: protected */
    public abstract V hz(int i2);

    public c(n nVar) {
        super(nVar);
        this.cqk = nVar;
    }

    @Override // java.util.Iterator
    public V next() {
        Kw();
        return hz(this.cqx);
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.i
    public final int nextIndex() {
        int i2;
        if (this.cqw != this.cqk.size()) {
            throw new ConcurrentModificationException();
        }
        Object[] objArr = this.cqk.cqC;
        int i3 = this.cqx;
        while (true) {
            i2 = i3 - 1;
            if (i3 <= 0 || (objArr[i2] != null && objArr[i2] != n.cqE)) {
                return i2;
            }
            i3 = i2;
        }
        return i2;
    }
}
