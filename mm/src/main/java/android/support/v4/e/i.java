package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class i<K, V> {
    i<K, V>.b OX;
    i<K, V>.c OY;
    i<K, V>.e OZ;

    /* access modifiers changed from: protected */
    public abstract int E(Object obj);

    /* access modifiers changed from: protected */
    public abstract int F(Object obj);

    /* access modifiers changed from: protected */
    public abstract V a(int i2, V v);

    /* access modifiers changed from: protected */
    public abstract void aG(int i2);

    /* access modifiers changed from: protected */
    public abstract void b(K k, V v);

    /* access modifiers changed from: protected */
    public abstract int fs();

    /* access modifiers changed from: protected */
    public abstract Map<K, V> ft();

    /* access modifiers changed from: protected */
    public abstract void fu();

    /* access modifiers changed from: protected */
    public abstract Object z(int i2, int i3);

    i() {
    }

    final class a<T> implements Iterator<T> {
        boolean Pa = false;
        final int fs;
        int mIndex;
        int mSize;

        a(int i2) {
            this.fs = i2;
            this.mSize = i.this.fs();
        }

        public final boolean hasNext() {
            return this.mIndex < this.mSize;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) i.this.z(this.mIndex, this.fs);
            this.mIndex++;
            this.Pa = true;
            return t;
        }

        public final void remove() {
            if (!this.Pa) {
                throw new IllegalStateException();
            }
            this.mIndex--;
            this.mSize--;
            this.Pa = false;
            i.this.aG(this.mIndex);
        }
    }

    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        int Pc;
        boolean Pd = false;
        int mIndex;

        d() {
            this.Pc = i.this.fs() - 1;
            this.mIndex = -1;
        }

        public final boolean hasNext() {
            return this.mIndex < this.Pc;
        }

        public final void remove() {
            if (!this.Pd) {
                throw new IllegalStateException();
            }
            i.this.aG(this.mIndex);
            this.mIndex--;
            this.Pc--;
            this.Pd = false;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            if (this.Pd) {
                return (K) i.this.z(this.mIndex, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            if (this.Pd) {
                return (V) i.this.z(this.mIndex, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (this.Pd) {
                return (V) i.this.a(this.mIndex, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.Pd) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Map.Entry)) {
                return false;
            } else {
                Map.Entry entry = (Map.Entry) obj;
                return d.equal(entry.getKey(), i.this.z(this.mIndex, 0)) && d.equal(entry.getValue(), i.this.z(this.mIndex, 1));
            }
        }

        public final int hashCode() {
            int i2 = 0;
            if (!this.Pd) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object z = i.this.z(this.mIndex, 0);
            Object z2 = i.this.z(this.mIndex, 1);
            int hashCode = z == null ? 0 : z.hashCode();
            if (z2 != null) {
                i2 = z2.hashCode();
            }
            return i2 ^ hashCode;
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.mIndex++;
            this.Pd = true;
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: android.support.v4.e.i */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int fs = i.this.fs();
            Iterator<? extends Map.Entry<K, V>> it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                i.this.b(entry.getKey(), entry.getValue());
            }
            return fs != i.this.fs();
        }

        public final void clear() {
            i.this.fu();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int E = i.this.E(entry.getKey());
            if (E >= 0) {
                return d.equal(i.this.z(E, 1), entry.getValue());
            }
            return false;
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

        public final boolean isEmpty() {
            return i.this.fs() == 0;
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return i.this.fs();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return i.a(this, obj);
        }

        public final int hashCode() {
            int hashCode;
            int fs = i.this.fs() - 1;
            int i2 = 0;
            while (fs >= 0) {
                Object z = i.this.z(fs, 0);
                Object z2 = i.this.z(fs, 1);
                int hashCode2 = z == null ? 0 : z.hashCode();
                if (z2 == null) {
                    hashCode = 0;
                } else {
                    hashCode = z2.hashCode();
                }
                fs--;
                i2 += hashCode ^ hashCode2;
            }
            return i2;
        }

        @Override // java.util.Collection, java.util.Set
        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: package-private */
    public final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            i.this.fu();
        }

        public final boolean contains(Object obj) {
            return i.this.E(obj) >= 0;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean containsAll(Collection<?> collection) {
            Map<K, V> ft = i.this.ft();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!ft.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return i.this.fs() == 0;
        }

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public final Iterator<K> iterator() {
            return new a(0);
        }

        public final boolean remove(Object obj) {
            int E = i.this.E(obj);
            if (E < 0) {
                return false;
            }
            i.this.aG(E);
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> collection) {
            Map<K, V> ft = i.this.ft();
            int size = ft.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                ft.remove(it.next());
            }
            return size != ft.size();
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean retainAll(Collection<?> collection) {
            return i.a(i.this.ft(), collection);
        }

        public final int size() {
            return i.this.fs();
        }

        public final Object[] toArray() {
            return i.this.aK(0);
        }

        @Override // java.util.Collection, java.util.Set
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) i.this.a(tArr, 0);
        }

        public final boolean equals(Object obj) {
            return i.a(this, obj);
        }

        public final int hashCode() {
            int i2 = 0;
            for (int fs = i.this.fs() - 1; fs >= 0; fs--) {
                Object z = i.this.z(fs, 0);
                i2 += z == null ? 0 : z.hashCode();
            }
            return i2;
        }
    }

    /* access modifiers changed from: package-private */
    public final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            i.this.fu();
        }

        public final boolean contains(Object obj) {
            return i.this.F(obj) >= 0;
        }

        @Override // java.util.Collection
        public final boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return i.this.fs() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return new a(1);
        }

        public final boolean remove(Object obj) {
            int F = i.this.F(obj);
            if (F < 0) {
                return false;
            }
            i.this.aG(F);
            return true;
        }

        @Override // java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            int fs = i.this.fs();
            int i2 = 0;
            boolean z = false;
            while (i2 < fs) {
                if (collection.contains(i.this.z(i2, 1))) {
                    i.this.aG(i2);
                    i2--;
                    fs--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            int fs = i.this.fs();
            int i2 = 0;
            boolean z = false;
            while (i2 < fs) {
                if (!collection.contains(i.this.z(i2, 1))) {
                    i.this.aG(i2);
                    i2--;
                    fs--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        public final int size() {
            return i.this.fs();
        }

        public final Object[] toArray() {
            return i.this.aK(1);
        }

        @Override // java.util.Collection
        public final <T> T[] toArray(T[] tArr) {
            return (T[]) i.this.a(tArr, 1);
        }
    }

    public static <K, V> boolean a(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public final Object[] aK(int i2) {
        int fs = fs();
        Object[] objArr = new Object[fs];
        for (int i3 = 0; i3 < fs; i3++) {
            objArr[i3] = z(i3, i2);
        }
        return objArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v12, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] a(T[] tArr, int i2) {
        int fs = fs();
        T[] tArr2 = tArr.length < fs ? (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), fs)) : tArr;
        for (int i3 = 0; i3 < fs; i3++) {
            tArr2[i3] = z(i3, i2);
        }
        if (tArr2.length > fs) {
            tArr2[fs] = null;
        }
        return tArr2;
    }

    public static <T> boolean a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            return set.size() == set2.size() && set.containsAll(set2);
        } catch (NullPointerException e2) {
            return false;
        } catch (ClassCastException e3) {
            return false;
        }
    }

    public final Set<K> getKeySet() {
        if (this.OY == null) {
            this.OY = new c();
        }
        return this.OY;
    }
}
