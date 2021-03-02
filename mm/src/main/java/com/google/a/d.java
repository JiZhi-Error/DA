package com.google.a;

import com.google.a.ae;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* access modifiers changed from: package-private */
public abstract class d<E> extends AbstractList<E> implements ae.e<E> {
    boolean bNd = true;

    d() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!get(i2).equals(list.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = (i2 * 31) + get(i3).hashCode();
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e2) {
        yL();
        return super.add(e2);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i2, E e2) {
        yL();
        super.add(i2, e2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        yL();
        return super.addAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i2, Collection<? extends E> collection) {
        yL();
        return super.addAll(i2, collection);
    }

    public void clear() {
        yL();
        super.clear();
    }

    @Override // com.google.a.ae.e
    public boolean yJ() {
        return this.bNd;
    }

    @Override // com.google.a.ae.e
    public final void yK() {
        this.bNd = false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i2) {
        yL();
        return (E) super.remove(i2);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        yL();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        yL();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        yL();
        return super.retainAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i2, E e2) {
        yL();
        return (E) super.set(i2, e2);
    }

    /* access modifiers changed from: protected */
    public final void yL() {
        if (!this.bNd) {
            throw new UnsupportedOperationException();
        }
    }
}
