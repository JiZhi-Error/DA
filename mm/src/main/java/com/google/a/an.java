package com.google.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class an<K, V> implements bd {
    volatile boolean bNd = true;
    volatile c bXT;
    b<K, V> bXU;
    List<at> bXV;
    final a<K, V> bXW;

    /* access modifiers changed from: package-private */
    public interface a<K, V> {
        at GZ();

        at Ha();
    }

    /* access modifiers changed from: package-private */
    public enum c {
        MAP,
        LIST,
        BOTH
    }

    an(a<K, V> aVar, c cVar, Map<K, V> map) {
        this.bXW = aVar;
        this.bXT = cVar;
        this.bXU = new b<>(this, map);
        this.bXV = null;
    }

    private List<at> a(b<K, V> bVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : bVar.entrySet()) {
            entry.getKey();
            entry.getValue();
            arrayList.add(this.bXW.GZ());
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final b<K, V> C(List<at> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<at> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        return new b<>(this, linkedHashMap);
    }

    public final Map<K, V> GV() {
        if (this.bXT == c.LIST) {
            synchronized (this) {
                if (this.bXT == c.LIST) {
                    this.bXU = C(this.bXV);
                    this.bXT = c.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.bXU);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof an)) {
            return false;
        }
        return ao.b(GV(), ((an) obj).GV());
    }

    public final int hashCode() {
        return ao.c(GV());
    }

    /* access modifiers changed from: package-private */
    public final List<at> GW() {
        if (this.bXT == c.MAP) {
            synchronized (this) {
                if (this.bXT == c.MAP) {
                    this.bXV = a(this.bXU);
                    this.bXT = c.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.bXV);
    }

    /* access modifiers changed from: package-private */
    public final List<at> GX() {
        if (this.bXT != c.LIST) {
            if (this.bXT == c.MAP) {
                this.bXV = a(this.bXU);
            }
            this.bXU = null;
            this.bXT = c.LIST;
        }
        return this.bXV;
    }

    /* access modifiers changed from: package-private */
    public static class b<K, V> implements Map<K, V> {
        private final bd bXX;
        private final Map<K, V> bXY;

        b(bd bdVar, Map<K, V> map) {
            this.bXX = bdVar;
            this.bXY = map;
        }

        public final int size() {
            return this.bXY.size();
        }

        public final boolean isEmpty() {
            return this.bXY.isEmpty();
        }

        public final boolean containsKey(Object obj) {
            return this.bXY.containsKey(obj);
        }

        public final boolean containsValue(Object obj) {
            return this.bXY.containsValue(obj);
        }

        @Override // java.util.Map
        public final V get(Object obj) {
            return this.bXY.get(obj);
        }

        @Override // java.util.Map
        public final V put(K k, V v) {
            this.bXX.GY();
            ae.checkNotNull(k);
            ae.checkNotNull(v);
            return this.bXY.put(k, v);
        }

        @Override // java.util.Map
        public final V remove(Object obj) {
            this.bXX.GY();
            return this.bXY.remove(obj);
        }

        @Override // java.util.Map
        public final void putAll(Map<? extends K, ? extends V> map) {
            this.bXX.GY();
            for (Object obj : map.keySet()) {
                ae.checkNotNull(obj);
                ae.checkNotNull(map.get(obj));
            }
            this.bXY.putAll(map);
        }

        public final void clear() {
            this.bXX.GY();
            this.bXY.clear();
        }

        @Override // java.util.Map
        public final Set<K> keySet() {
            return new c(this.bXX, this.bXY.keySet());
        }

        @Override // java.util.Map
        public final Collection<V> values() {
            return new a(this.bXX, this.bXY.values());
        }

        @Override // java.util.Map
        public final Set<Map.Entry<K, V>> entrySet() {
            return new c(this.bXX, this.bXY.entrySet());
        }

        public final boolean equals(Object obj) {
            return this.bXY.equals(obj);
        }

        public final int hashCode() {
            return this.bXY.hashCode();
        }

        public final String toString() {
            return this.bXY.toString();
        }

        static class a<E> implements Collection<E> {
            private final bd bXX;
            private final Collection<E> bXZ;

            a(bd bdVar, Collection<E> collection) {
                this.bXX = bdVar;
                this.bXZ = collection;
            }

            public final int size() {
                return this.bXZ.size();
            }

            public final boolean isEmpty() {
                return this.bXZ.isEmpty();
            }

            public final boolean contains(Object obj) {
                return this.bXZ.contains(obj);
            }

            @Override // java.util.Collection, java.lang.Iterable
            public final Iterator<E> iterator() {
                return new C0088b(this.bXX, this.bXZ.iterator());
            }

            public final Object[] toArray() {
                return this.bXZ.toArray();
            }

            @Override // java.util.Collection
            public final <T> T[] toArray(T[] tArr) {
                return (T[]) this.bXZ.toArray(tArr);
            }

            @Override // java.util.Collection
            public final boolean add(E e2) {
                throw new UnsupportedOperationException();
            }

            public final boolean remove(Object obj) {
                this.bXX.GY();
                return this.bXZ.remove(obj);
            }

            @Override // java.util.Collection
            public final boolean containsAll(Collection<?> collection) {
                return this.bXZ.containsAll(collection);
            }

            @Override // java.util.Collection
            public final boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public final boolean removeAll(Collection<?> collection) {
                this.bXX.GY();
                return this.bXZ.removeAll(collection);
            }

            @Override // java.util.Collection
            public final boolean retainAll(Collection<?> collection) {
                this.bXX.GY();
                return this.bXZ.retainAll(collection);
            }

            public final void clear() {
                this.bXX.GY();
                this.bXZ.clear();
            }

            public final boolean equals(Object obj) {
                return this.bXZ.equals(obj);
            }

            public final int hashCode() {
                return this.bXZ.hashCode();
            }

            public final String toString() {
                return this.bXZ.toString();
            }
        }

        /* access modifiers changed from: package-private */
        public static class c<E> implements Set<E> {
            private final bd bXX;
            private final Set<E> bYb;

            c(bd bdVar, Set<E> set) {
                this.bXX = bdVar;
                this.bYb = set;
            }

            public final int size() {
                return this.bYb.size();
            }

            public final boolean isEmpty() {
                return this.bYb.isEmpty();
            }

            public final boolean contains(Object obj) {
                return this.bYb.contains(obj);
            }

            @Override // java.util.Collection, java.util.Set, java.lang.Iterable
            public final Iterator<E> iterator() {
                return new C0088b(this.bXX, this.bYb.iterator());
            }

            public final Object[] toArray() {
                return this.bYb.toArray();
            }

            @Override // java.util.Collection, java.util.Set
            public final <T> T[] toArray(T[] tArr) {
                return (T[]) this.bYb.toArray(tArr);
            }

            @Override // java.util.Collection, java.util.Set
            public final boolean add(E e2) {
                this.bXX.GY();
                return this.bYb.add(e2);
            }

            public final boolean remove(Object obj) {
                this.bXX.GY();
                return this.bYb.remove(obj);
            }

            @Override // java.util.Collection, java.util.Set
            public final boolean containsAll(Collection<?> collection) {
                return this.bYb.containsAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public final boolean addAll(Collection<? extends E> collection) {
                this.bXX.GY();
                return this.bYb.addAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public final boolean retainAll(Collection<?> collection) {
                this.bXX.GY();
                return this.bYb.retainAll(collection);
            }

            @Override // java.util.Collection, java.util.Set
            public final boolean removeAll(Collection<?> collection) {
                this.bXX.GY();
                return this.bYb.removeAll(collection);
            }

            public final void clear() {
                this.bXX.GY();
                this.bYb.clear();
            }

            public final boolean equals(Object obj) {
                return this.bYb.equals(obj);
            }

            public final int hashCode() {
                return this.bYb.hashCode();
            }

            public final String toString() {
                return this.bYb.toString();
            }
        }

        /* renamed from: com.google.a.an$b$b  reason: collision with other inner class name */
        static class C0088b<E> implements Iterator<E> {
            private final bd bXX;
            private final Iterator<E> bYa;

            C0088b(bd bdVar, Iterator<E> it) {
                this.bXX = bdVar;
                this.bYa = it;
            }

            public final boolean hasNext() {
                return this.bYa.hasNext();
            }

            @Override // java.util.Iterator
            public final E next() {
                return this.bYa.next();
            }

            public final void remove() {
                this.bXX.GY();
                this.bYa.remove();
            }

            public final boolean equals(Object obj) {
                return this.bYa.equals(obj);
            }

            public final int hashCode() {
                return this.bYa.hashCode();
            }

            public final String toString() {
                return this.bYa.toString();
            }
        }
    }

    @Override // com.google.a.bd
    public final void GY() {
        if (!this.bNd) {
            throw new UnsupportedOperationException();
        }
    }
}
