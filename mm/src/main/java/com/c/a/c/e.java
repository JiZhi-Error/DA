package com.c.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class e<E> extends n<E> implements Set<E> {
    @Override // java.util.Collection, java.util.Set
    public final boolean add(E e2) {
        boolean z = false;
        int aI = aI(e2);
        if (aI < 0) {
            return false;
        }
        Object obj = this.cqC[aI];
        this.cqC[aI] = e2;
        if (obj == null) {
            z = true;
        }
        bO(z);
        return true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (set.size() == size()) {
            return containsAll(set);
        }
        return false;
    }

    public final int hashCode() {
        a aVar = new a();
        b(aVar);
        return aVar.f109h;
    }

    final class a implements s<E> {

        /* renamed from: h  reason: collision with root package name */
        int f109h;

        a() {
        }

        @Override // com.c.a.c.s
        public final boolean aD(E e2) {
            this.f109h += e.this.cqD.aG(e2);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final void hx(int i2) {
        int length = this.cqC.length;
        Object[] objArr = this.cqC;
        this.cqC = new Object[i2];
        while (true) {
            int i3 = length - 1;
            if (length <= 0) {
                return;
            }
            if (objArr[i3] == null || objArr[i3] == cqE) {
                length = i3;
            } else {
                Object obj = objArr[i3];
                int aI = aI(obj);
                if (aI < 0) {
                    w(this.cqC[(-aI) - 1], obj);
                }
                this.cqC[aI] = obj;
                length = i3;
            }
        }
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[size()];
        b(new t(objArr));
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public final <T> T[] toArray(T[] tArr) {
        int size = size();
        T[] tArr2 = tArr.length < size ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size)) : tArr;
        Iterator<E> it = iterator();
        for (int i2 = 0; i2 < size; i2++) {
            tArr2[i2] = it.next();
        }
        if (tArr2.length > size) {
            tArr2[size] = null;
        }
        return tArr2;
    }

    @Override // com.c.a.c.b
    public final void clear() {
        super.clear();
        Object[] objArr = this.cqC;
        int length = objArr.length;
        while (true) {
            int i2 = length - 1;
            if (length > 0) {
                objArr[i2] = null;
                length = i2;
            } else {
                return;
            }
        }
    }

    public final boolean remove(Object obj) {
        int aH = aH(obj);
        if (aH < 0) {
            return false;
        }
        removeAt(aH);
        return true;
    }

    @Override // java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<E> iterator() {
        return new o(this);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.c.a.c.e<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set
    public final boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        ensureCapacity(size);
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return z;
            }
            if (add(it.next())) {
                z = true;
                size = i2;
            } else {
                size = i2;
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean removeAll(Collection<?> collection) {
        int size = collection.size();
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return z;
            }
            if (remove(it.next())) {
                z = true;
                size = i2;
            } else {
                size = i2;
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean retainAll(Collection<?> collection) {
        int size = size();
        Iterator<E> it = iterator();
        boolean z = false;
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return z;
            }
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
                size = i2;
            } else {
                size = i2;
            }
        }
    }
}
