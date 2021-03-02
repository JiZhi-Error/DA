package com.c.a.c;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

abstract class i {
    private b cqv;
    protected int cqw = this.cqv.size();
    protected int cqx = this.cqv.capacity();

    /* access modifiers changed from: protected */
    public abstract int nextIndex();

    public i(b bVar) {
        this.cqv = bVar;
    }

    public boolean hasNext() {
        return nextIndex() >= 0;
    }

    /* JADX INFO: finally extract failed */
    public void remove() {
        if (this.cqw != this.cqv.size()) {
            throw new ConcurrentModificationException();
        }
        this.cqv.Kr();
        try {
            this.cqv.removeAt(this.cqx);
            this.cqv.Ks();
            this.cqw--;
        } catch (Throwable th) {
            this.cqv.Ks();
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void Kw() {
        int nextIndex = nextIndex();
        this.cqx = nextIndex;
        if (nextIndex < 0) {
            throw new NoSuchElementException();
        }
    }
}
