package com.c.a.a.b;

import com.c.a.a.a.a;
import java.util.AbstractSet;
import java.util.Collection;

/* access modifiers changed from: package-private */
public abstract class o<E> extends AbstractSet<E> {
    o() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        return a.a(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        return super.retainAll((Collection) a.checkNotNull(collection));
    }
}
