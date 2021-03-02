package com.c.a.a.b;

import com.c.a.a.b.j;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public abstract class b<K, V> extends d<K, V> implements Serializable {
    private transient int cnR;
    private transient Map<K, Collection<V>> map;

    /* access modifiers changed from: package-private */
    public abstract Collection<V> JG();

    static /* synthetic */ int a(b bVar, int i2) {
        int i3 = bVar.cnR + i2;
        bVar.cnR = i3;
        return i3;
    }

    static /* synthetic */ int b(b bVar) {
        int i2 = bVar.cnR;
        bVar.cnR = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(b bVar, int i2) {
        int i3 = bVar.cnR - i2;
        bVar.cnR = i3;
        return i3;
    }

    static /* synthetic */ int c(b bVar) {
        int i2 = bVar.cnR;
        bVar.cnR = i2 + 1;
        return i2;
    }

    protected b(Map<K, Collection<V>> map2) {
        if (!map2.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.map = map2;
    }

    @Override // com.c.a.a.b.k
    public int size() {
        return this.cnR;
    }

    @Override // com.c.a.a.b.k, com.c.a.a.b.d
    public boolean r(@Nullable K k, @Nullable V v) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            Collection<V> JG = JG();
            if (JG.add(v)) {
                this.cnR++;
                this.map.put(k, JG);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.cnR++;
            return true;
        }
    }

    @Override // com.c.a.a.b.k
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.cnR = 0;
    }

    @Override // com.c.a.a.b.k
    public Collection<V> az(@Nullable K k) {
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            collection = JG();
        }
        return a((Object) k, (Collection) collection);
    }

    /* access modifiers changed from: package-private */
    public final Collection<V> a(@Nullable K k, Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return new j(k, (SortedSet) collection, null);
        }
        if (collection instanceof Set) {
            return new i(k, (Set) collection);
        }
        if (collection instanceof List) {
            return a(k, (List) collection, null);
        }
        return new g(k, collection, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private List<V> a(@Nullable K k, List<V> list, @Nullable b<K, V>.WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new d(this, k, list, wrappedCollection) : new h(k, list, wrappedCollection);
    }

    /* access modifiers changed from: package-private */
    public class g extends AbstractCollection<V> {
        Collection<V> bXZ;
        final b<K, V>.WrappedCollection coc;
        private Collection<V> cod;
        final K key;

        g(K k, @Nullable Collection<V> collection, b<K, V>.WrappedCollection wrappedCollection) {
            Collection<V> collection2;
            this.key = k;
            this.bXZ = collection;
            this.coc = wrappedCollection;
            if (wrappedCollection == null) {
                collection2 = null;
            } else {
                collection2 = wrappedCollection.bXZ;
            }
            this.cod = collection2;
        }

        /* access modifiers changed from: package-private */
        public final void JP() {
            Collection<V> collection;
            if (this.coc != null) {
                this.coc.JP();
                if (this.coc.bXZ != this.cod) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.bXZ.isEmpty() && (collection = (Collection) b.this.map.get(this.key)) != null) {
                this.bXZ = collection;
            }
        }

        /* access modifiers changed from: package-private */
        public final void JQ() {
            while (this.coc != null) {
                this = this.coc;
            }
            if (this.bXZ.isEmpty()) {
                b.this.map.remove(this.key);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.util.Map */
        /* JADX WARN: Multi-variable type inference failed */
        /* access modifiers changed from: package-private */
        public final void JR() {
            while (this.coc != null) {
                this = this.coc;
            }
            b.this.map.put(this.key, this.bXZ);
        }

        public int size() {
            JP();
            return this.bXZ.size();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            JP();
            return this.bXZ.equals(obj);
        }

        public int hashCode() {
            JP();
            return this.bXZ.hashCode();
        }

        public String toString() {
            JP();
            return this.bXZ.toString();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            JP();
            return new a();
        }

        /* access modifiers changed from: package-private */
        public class a implements Iterator<V> {
            final Iterator<V> cnV;
            private Collection<V> coe = g.this.bXZ;

            a() {
                this.cnV = b.e(g.this.bXZ);
            }

            a(Iterator<V> it) {
                this.cnV = it;
            }

            /* access modifiers changed from: package-private */
            public final void JS() {
                g.this.JP();
                if (g.this.bXZ != this.coe) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                JS();
                return this.cnV.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                JS();
                return this.cnV.next();
            }

            public void remove() {
                this.cnV.remove();
                b.b(b.this);
                g.this.JQ();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v) {
            JP();
            boolean isEmpty = this.bXZ.isEmpty();
            boolean add = this.bXZ.add(v);
            if (add) {
                b.c(b.this);
                if (isEmpty) {
                    JR();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.bXZ.addAll(collection);
            if (!addAll) {
                return addAll;
            }
            b.a(b.this, this.bXZ.size() - size);
            if (size != 0) {
                return addAll;
            }
            JR();
            return addAll;
        }

        public boolean contains(Object obj) {
            JP();
            return this.bXZ.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            JP();
            return this.bXZ.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.bXZ.clear();
                b.b(b.this, size);
                JQ();
            }
        }

        public boolean remove(Object obj) {
            JP();
            boolean remove = this.bXZ.remove(obj);
            if (remove) {
                b.b(b.this);
                JQ();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.bXZ.removeAll(collection);
            if (!removeAll) {
                return removeAll;
            }
            b.a(b.this, this.bXZ.size() - size);
            JQ();
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            com.c.a.a.a.a.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.bXZ.retainAll(collection);
            if (retainAll) {
                b.a(b.this, this.bXZ.size() - size);
                JQ();
            }
            return retainAll;
        }
    }

    /* access modifiers changed from: package-private */
    public class i extends b<K, V>.WrappedCollection implements Set<V> {
        i(K k, @Nullable Set<V> set) {
            super(k, set, null);
        }

        @Override // java.util.Collection, java.util.Set
        public final boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean a2 = com.c.a.a.a.a.a((Set) this.bXZ, collection);
            if (!a2) {
                return a2;
            }
            b.a(b.this, this.bXZ.size() - size);
            JQ();
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public class j extends b<K, V>.WrappedCollection implements SortedSet<V> {
        j(K k, @Nullable SortedSet<V> sortedSet, b<K, V>.WrappedCollection wrappedCollection) {
            super(k, sortedSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        public final V first() {
            JP();
            return (V) ((SortedSet) this.bXZ).first();
        }

        @Override // java.util.SortedSet
        public final V last() {
            JP();
            return (V) ((SortedSet) this.bXZ).last();
        }

        @Override // java.util.SortedSet
        public final SortedSet<V> headSet(V v) {
            JP();
            b bVar = b.this;
            K k = this.key;
            SortedSet headSet = ((SortedSet) this.bXZ).headSet(v);
            if (this.coc != null) {
                this = this.coc;
            }
            return new j(k, headSet, this);
        }

        @Override // java.util.SortedSet
        public final SortedSet<V> subSet(V v, V v2) {
            JP();
            b bVar = b.this;
            K k = this.key;
            SortedSet subSet = ((SortedSet) this.bXZ).subSet(v, v2);
            if (this.coc != null) {
                this = this.coc;
            }
            return new j(k, subSet, this);
        }

        @Override // java.util.SortedSet
        public final SortedSet<V> tailSet(V v) {
            JP();
            b bVar = b.this;
            K k = this.key;
            SortedSet tailSet = ((SortedSet) this.bXZ).tailSet(v);
            if (this.coc != null) {
                this = this.coc;
            }
            return new j(k, tailSet, this);
        }

        @Override // java.util.SortedSet
        public final Comparator<? super V> comparator() {
            return ((SortedSet) this.bXZ).comparator();
        }
    }

    /* access modifiers changed from: package-private */
    public class h extends b<K, V>.WrappedCollection implements List<V> {
        h(K k, @Nullable List<V> list, b<K, V>.WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }

        @Override // java.util.List
        public boolean addAll(int i2, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = ((List) this.bXZ).addAll(i2, collection);
            if (!addAll) {
                return addAll;
            }
            b.a(b.this, this.bXZ.size() - size);
            if (size != 0) {
                return addAll;
            }
            JR();
            return addAll;
        }

        @Override // java.util.List
        public V get(int i2) {
            JP();
            return (V) ((List) this.bXZ).get(i2);
        }

        @Override // java.util.List
        public V set(int i2, V v) {
            JP();
            return (V) ((List) this.bXZ).set(i2, v);
        }

        @Override // java.util.List
        public void add(int i2, V v) {
            JP();
            boolean isEmpty = this.bXZ.isEmpty();
            ((List) this.bXZ).add(i2, v);
            b.c(b.this);
            if (isEmpty) {
                JR();
            }
        }

        @Override // java.util.List
        public V remove(int i2) {
            JP();
            V v = (V) ((List) this.bXZ).remove(i2);
            b.b(b.this);
            JQ();
            return v;
        }

        public int indexOf(Object obj) {
            JP();
            return ((List) this.bXZ).indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            JP();
            return ((List) this.bXZ).lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            JP();
            return new a();
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i2) {
            JP();
            return new a(i2);
        }

        @Override // java.util.List
        public List<V> subList(int i2, int i3) {
            JP();
            b bVar = b.this;
            K k = this.key;
            List subList = ((List) this.bXZ).subList(i2, i3);
            if (this.coc != null) {
                this = this.coc;
            }
            return bVar.a(k, subList, this);
        }

        class a extends b<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
            a() {
                super();
            }

            public a(int i2) {
                super(((List) h.this.bXZ).listIterator(i2));
            }

            public final boolean hasPrevious() {
                return JT().hasPrevious();
            }

            @Override // java.util.ListIterator
            public final V previous() {
                return JT().previous();
            }

            public final int nextIndex() {
                return JT().nextIndex();
            }

            public final int previousIndex() {
                return JT().previousIndex();
            }

            @Override // java.util.ListIterator
            public final void set(V v) {
                JT().set(v);
            }

            @Override // java.util.ListIterator
            public final void add(V v) {
                boolean isEmpty = h.this.isEmpty();
                JT().add(v);
                b.c(b.this);
                if (isEmpty) {
                    h.this.JR();
                }
            }

            private ListIterator<V> JT() {
                JS();
                return (ListIterator) this.cnV;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends b<K, V>.WrappedList implements RandomAccess {
        d(b bVar, @Nullable K k, List<V> list, @Nullable b<K, V>.WrappedCollection wrappedCollection) {
            super(k, list, wrappedCollection);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.c.a.a.b.d
    public final Set<K> JH() {
        return this.map instanceof SortedMap ? new f((SortedMap) this.map) : new c(this.map);
    }

    class c extends j.d<K, Collection<V>> {
        c(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.c.a.a.b.j.d
        public boolean remove(Object obj) {
            int i2;
            V remove = this.map.remove(obj);
            if (remove != null) {
                int size = remove.size();
                remove.clear();
                b.b(b.this, size);
                i2 = size;
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                return true;
            }
            return false;
        }

        @Override // com.c.a.a.b.j.d
        public void clear() {
            h.a(iterator());
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.map.keySet().equals(obj);
        }

        @Override // java.util.AbstractCollection, com.c.a.a.b.j.d, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, V>> it = this.map.entrySet().iterator();
            return new Iterator<K>() {
                /* class com.c.a.a.b.b.c.AnonymousClass1 */
                private Map.Entry<K, Collection<V>> bXF;

                public final boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public final K next() {
                    this.bXF = (Map.Entry) it.next();
                    return this.bXF.getKey();
                }

                public final void remove() {
                    com.c.a.a.a.a.bN(this.bXF != null);
                    Collection<V> value = this.bXF.getValue();
                    it.remove();
                    b.b(b.this, value.size());
                    value.clear();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.map.keySet().containsAll(collection);
        }

        public int hashCode() {
            return this.map.keySet().hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public class f extends b<K, V>.KeySet implements SortedSet<K> {
        f(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public final SortedSet<K> headSet(K k) {
            return new f(((SortedMap) this.map).headMap(k));
        }

        @Override // java.util.SortedSet
        public final SortedSet<K> subSet(K k, K k2) {
            return new f(((SortedMap) this.map).subMap(k, k2));
        }

        @Override // java.util.SortedSet
        public final SortedSet<K> tailSet(K k) {
            return new f(((SortedMap) this.map).tailMap(k));
        }

        @Override // java.util.SortedSet
        public final Comparator<? super K> comparator() {
            return ((SortedMap) this.map).comparator();
        }

        @Override // java.util.SortedSet
        public final K first() {
            return (K) ((SortedMap) this.map).firstKey();
        }

        @Override // java.util.SortedSet
        public final K last() {
            return (K) ((SortedMap) this.map).lastKey();
        }
    }

    /* renamed from: com.c.a.a.b.b$b  reason: collision with other inner class name */
    abstract class AbstractC0079b<T> implements Iterator<T> {
        private Collection<V> cnW = null;
        private Iterator<Map.Entry<K, Collection<V>>> cnX;
        private Iterator<V> cnY = h.JW();
        private K key = null;

        /* access modifiers changed from: package-private */
        public abstract T s(K k, V v);

        AbstractC0079b() {
            this.cnX = b.this.map.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.cnX.hasNext() || this.cnY.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.cnY.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.cnX.next();
                this.key = next.getKey();
                this.cnW = next.getValue();
                this.cnY = this.cnW.iterator();
            }
            return s(this.key, this.cnY.next());
        }

        public void remove() {
            this.cnY.remove();
            if (this.cnW.isEmpty()) {
                this.cnX.remove();
            }
            b.b(b.this);
        }
    }

    @Override // com.c.a.a.b.k, com.c.a.a.b.d
    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    @Override // com.c.a.a.b.d
    public final Iterator<V> JI() {
        return new b<K, V>.Itr(this) {
            /* class com.c.a.a.b.b.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public final V s(K k, V v) {
                return v;
            }
        };
    }

    @Override // com.c.a.a.b.d
    public Collection<Map.Entry<K, V>> JJ() {
        return super.JJ();
    }

    /* access modifiers changed from: package-private */
    @Override // com.c.a.a.b.d
    public final Iterator<Map.Entry<K, V>> JK() {
        return new b<K, V>.Itr(this) {
            /* class com.c.a.a.b.b.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public final /* synthetic */ Object s(Object obj, Object obj2) {
                return j.u(obj, obj2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // com.c.a.a.b.d
    public final Map<K, Collection<V>> JL() {
        return this.map instanceof SortedMap ? new e((SortedMap) this.map) : new a(this.map);
    }

    /* access modifiers changed from: package-private */
    public class a extends j.c<K, Collection<V>> {
        final transient Map<K, Collection<V>> cnS;

        a(Map<K, Collection<V>> map) {
            this.cnS = map;
        }

        /* access modifiers changed from: protected */
        @Override // com.c.a.a.b.j.c
        public final Set<Map.Entry<K, Collection<V>>> JM() {
            return new C0077a();
        }

        public boolean containsKey(Object obj) {
            return j.b(this.cnS, obj);
        }

        @Override // java.util.AbstractMap, com.c.a.a.b.j.c, java.util.Map
        public Set<K> keySet() {
            return b.this.keySet();
        }

        public int size() {
            return this.cnS.size();
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.cnS.equals(obj);
        }

        public int hashCode() {
            return this.cnS.hashCode();
        }

        public String toString() {
            return this.cnS.toString();
        }

        public void clear() {
            if (this.cnS == b.this.map) {
                b.this.clear();
            } else {
                h.a(new C0078b());
            }
        }

        /* renamed from: com.c.a.a.b.b$a$a  reason: collision with other inner class name */
        class C0077a extends j.b<K, Collection<V>> {
            C0077a() {
            }

            /* access modifiers changed from: package-private */
            @Override // com.c.a.a.b.j.b
            public final Map<K, Collection<V>> JN() {
                return a.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
            public final Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new C0078b();
            }

            @Override // com.c.a.a.b.j.b
            public final boolean contains(Object obj) {
                return f.a(a.this.cnS.entrySet(), obj);
            }

            @Override // com.c.a.a.b.j.b
            public final boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                b.a(b.this, ((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* renamed from: com.c.a.a.b.b$a$b  reason: collision with other inner class name */
        class C0078b implements Iterator<Map.Entry<K, Collection<V>>> {
            private Iterator<Map.Entry<K, Collection<V>>> cnV = a.this.cnS.entrySet().iterator();
            private Collection<V> cnW;

            C0078b() {
            }

            public final boolean hasNext() {
                return this.cnV.hasNext();
            }

            public final void remove() {
                this.cnV.remove();
                b.b(b.this, this.cnW.size());
                this.cnW.clear();
            }

            @Override // java.util.Iterator
            public final /* synthetic */ Object next() {
                Map.Entry<K, Collection<V>> next = this.cnV.next();
                this.cnW = next.getValue();
                a aVar = a.this;
                K key = next.getKey();
                return j.u(key, b.this.a((Object) key, (Collection) next.getValue()));
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object remove(Object obj) {
            Collection<V> remove = this.cnS.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> JG = b.this.JG();
            JG.addAll(remove);
            b.b(b.this, remove.size());
            remove.clear();
            return JG;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public /* synthetic */ Object get(Object obj) {
            Collection<V> collection = (Collection) j.a(this.cnS, obj);
            if (collection == null) {
                return null;
            }
            return b.this.a(obj, collection);
        }
    }

    class e extends b<K, V>.AsMap implements SortedMap<K, Collection<V>> {
        private SortedSet<K> cob;

        e(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public final SortedMap<K, Collection<V>> headMap(K k) {
            return new e(((SortedMap) this.cnS).headMap(k));
        }

        @Override // java.util.SortedMap
        public final SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new e(((SortedMap) this.cnS).subMap(k, k2));
        }

        @Override // java.util.SortedMap
        public final SortedMap<K, Collection<V>> tailMap(K k) {
            return new e(((SortedMap) this.cnS).tailMap(k));
        }

        /* access modifiers changed from: private */
        /* renamed from: JO */
        public SortedSet<K> JH() {
            return new f((SortedMap) this.cnS);
        }

        @Override // java.util.SortedMap
        public final Comparator<? super K> comparator() {
            return ((SortedMap) this.cnS).comparator();
        }

        @Override // java.util.SortedMap
        public final K firstKey() {
            return (K) ((SortedMap) this.cnS).firstKey();
        }

        @Override // java.util.SortedMap
        public final K lastKey() {
            return (K) ((SortedMap) this.cnS).lastKey();
        }

        @Override // java.util.Map, java.util.SortedMap
        public final /* synthetic */ Set keySet() {
            SortedSet<K> sortedSet = this.cob;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> JO = JH();
            this.cob = JO;
            return JO;
        }
    }

    static /* synthetic */ Iterator e(Collection collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    static /* synthetic */ int a(b bVar, Object obj) {
        Collection collection = (Collection) j.c(bVar.map, obj);
        int i2 = 0;
        if (collection != null) {
            i2 = collection.size();
            collection.clear();
            bVar.cnR -= i2;
        }
        return i2;
    }
}
