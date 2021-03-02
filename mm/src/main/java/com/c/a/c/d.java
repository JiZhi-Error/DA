package com.c.a.c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class d<K, V> extends n<K> implements Map<K, V> {
    protected transient V[] cql;

    /* access modifiers changed from: private */
    /* renamed from: Kt */
    public d<K, V> clone() {
        d<K, V> dVar = (d) super.clone();
        dVar.cql = (V[]) ((Object[]) this.cql.clone());
        return dVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b, com.c.a.c.n
    public final int hw(int i2) {
        int hw = super.hw(i2);
        this.cql = (V[]) new Object[hw];
        return hw;
    }

    @Override // java.util.Map
    public final V put(K k, V v) {
        boolean z;
        if (k == null) {
            throw new NullPointerException("null keys not supported");
        }
        V v2 = null;
        int aI = aI(k);
        boolean z2 = aI < 0;
        if (z2) {
            aI = (-aI) - 1;
            v2 = this.cql[aI];
        }
        Object obj = this.cqC[aI];
        this.cqC[aI] = k;
        this.cql[aI] = v;
        if (!z2) {
            if (obj == null) {
                z = true;
            } else {
                z = false;
            }
            bO(z);
        }
        return v2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() == size()) {
            return a(new c(map));
        }
        return false;
    }

    public final int hashCode() {
        C0080d dVar = new C0080d();
        a(dVar);
        return dVar.f108h;
    }

    /* renamed from: com.c.a.c.d$d  reason: collision with other inner class name */
    final class C0080d implements r<K, V> {

        /* renamed from: h  reason: collision with root package name */
        int f108h;

        C0080d() {
        }

        @Override // com.c.a.c.r
        public final boolean v(K k, V v) {
            this.f108h = ((v == null ? 0 : v.hashCode()) ^ d.this.cqD.aG(k)) + this.f108h;
            return true;
        }
    }

    static final class c<K, V> implements r<K, V> {
        private final Map<K, V> cqo;

        c(Map<K, V> map) {
            this.cqo = map;
        }

        @Override // com.c.a.c.r
        public final boolean v(K k, V v) {
            V v2 = this.cqo.get(k);
            return v2 == v || (v2 != null && v2.equals(v));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: com.c.a.c.r<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private boolean a(r<K, V> rVar) {
        Object[] objArr = this.cqC;
        V[] vArr = this.cql;
        int length = objArr.length;
        while (true) {
            int i2 = length - 1;
            if (length <= 0) {
                return true;
            }
            if (objArr[i2] != null && objArr[i2] != cqE && !rVar.v(objArr[i2], vArr[i2])) {
                return false;
            }
            length = i2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b
    public final void hx(int i2) {
        int length = this.cqC.length;
        Object[] objArr = this.cqC;
        V[] vArr = this.cql;
        this.cqC = new Object[i2];
        this.cql = (V[]) new Object[i2];
        while (true) {
            length--;
            if (length <= 0) {
                return;
            }
            if (objArr[length] != null && objArr[length] != cqE) {
                Object obj = objArr[length];
                int aI = aI(obj);
                if (aI < 0) {
                    w(this.cqC[(-aI) - 1], obj);
                }
                this.cqC[aI] = obj;
                this.cql[aI] = vArr[length];
            }
        }
    }

    @Override // java.util.Map
    public final V get(Object obj) {
        int aH = aH(obj);
        if (aH < 0) {
            return null;
        }
        return this.cql[aH];
    }

    @Override // com.c.a.c.b
    public final void clear() {
        if (size() != 0) {
            super.clear();
            Object[] objArr = this.cqC;
            V[] vArr = this.cql;
            int length = objArr.length;
            while (true) {
                int i2 = length - 1;
                if (length > 0) {
                    objArr[i2] = null;
                    vArr[i2] = null;
                    length = i2;
                } else {
                    return;
                }
            }
        }
    }

    @Override // java.util.Map
    public final V remove(Object obj) {
        int aH = aH(obj);
        if (aH < 0) {
            return null;
        }
        V v = this.cql[aH];
        removeAt(aH);
        return v;
    }

    /* access modifiers changed from: protected */
    @Override // com.c.a.c.b, com.c.a.c.n
    public final void removeAt(int i2) {
        this.cql[i2] = null;
        super.removeAt(i2);
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        return new g();
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        return new e();
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return new b();
    }

    public final boolean containsValue(Object obj) {
        Object[] objArr = this.cqC;
        V[] vArr = this.cql;
        if (obj != null) {
            int length = vArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    break;
                } else if (objArr[i2] != null && objArr[i2] != cqE && (obj == vArr[i2] || obj.equals(vArr[i2]))) {
                    return true;
                } else {
                    length = i2;
                }
            }
        } else {
            int length2 = vArr.length;
            while (true) {
                int i3 = length2 - 1;
                if (length2 <= 0) {
                    break;
                } else if (objArr[i3] != null && objArr[i3] != cqE && obj == vArr[i3]) {
                    return true;
                } else {
                    length2 = i3;
                }
            }
        }
        return false;
    }

    public final boolean containsKey(Object obj) {
        return contains(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.c.a.c.d<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public class g extends d<K, V>.MapBackedView {
        protected g() {
            super();
        }

        public final Iterator<V> iterator() {
            return new c<V>(d.this) {
                /* class com.c.a.c.d.g.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // com.c.a.c.c
                public final V hz(int i2) {
                    return d.this.cql[i2];
                }
            };
        }

        public final boolean aE(V v) {
            return d.this.containsValue(v);
        }

        public final boolean removeElement(V v) {
            V[] vArr = d.this.cql;
            Object[] objArr = d.this.cqC;
            int length = vArr.length;
            boolean z = false;
            while (true) {
                int i2 = length - 1;
                if (length <= 0) {
                    return z;
                }
                if ((objArr[i2] == null || objArr[i2] == n.cqE || v != vArr[i2]) && (vArr[i2] == null || !vArr[i2].equals(v))) {
                    length = i2;
                } else {
                    d.this.removeAt(i2);
                    z = true;
                    length = i2;
                }
            }
        }
    }

    public class b extends d<K, V>.MapBackedView {
        public final /* synthetic */ boolean aE(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = d.this.get(entry.getKey());
            Object value = entry.getValue();
            return value == obj2 || (obj2 != null && obj2.equals(value));
        }

        public final /* synthetic */ boolean removeElement(Object obj) {
            Object value;
            Map.Entry entry = (Map.Entry) obj;
            int aH = d.this.aH(entry.getKey());
            if (aH < 0 || ((value = entry.getValue()) != d.this.cql[aH] && (value == null || !value.equals(d.this.cql[aH])))) {
                return false;
            }
            d.this.removeAt(aH);
            return true;
        }

        b() {
            super();
        }

        final class a extends c<Map.Entry<K, V>> {
            a(d<K, V> dVar) {
                super(dVar);
            }

            @Override // com.c.a.c.c
            public final /* synthetic */ Object hz(int i2) {
                return new a(d.this.cqC[i2], d.this.cql[i2], i2);
            }
        }

        public final Iterator<Map.Entry<K, V>> iterator() {
            return new a(d.this);
        }
    }

    abstract class f<E> implements Set<E> {
        public abstract boolean aE(E e2);

        @Override // java.util.Collection, java.util.Set, java.lang.Iterable
        public abstract Iterator<E> iterator();

        public abstract boolean removeElement(E e2);

        f() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean contains(Object obj) {
            return aE(obj);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public boolean remove(Object obj) {
            return removeElement(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            boolean z = false;
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (remove(it.next())) {
                    z = true;
                }
            }
            return z;
        }

        public void clear() {
            d.this.clear();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean add(E e2) {
            throw new UnsupportedOperationException();
        }

        public int size() {
            return d.this.size();
        }

        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            Iterator<E> it = iterator();
            int i2 = 0;
            while (it.hasNext()) {
                objArr[i2] = it.next();
                i2++;
            }
            return objArr;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v11, resolved type: T[] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
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

        public boolean isEmpty() {
            return d.this.isEmpty();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            boolean z = false;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
    }

    public class e extends d<K, V>.MapBackedView {
        e() {
            super();
        }

        public final Iterator<K> iterator() {
            return new o(d.this);
        }

        public final boolean removeElement(K k) {
            return d.this.remove(k) != null;
        }

        public final boolean aE(K k) {
            return d.this.contains(k);
        }
    }

    final class a implements Map.Entry<K, V> {
        private final int index;
        private final K key;
        private V val;

        a(K k, V v, int i2) {
            this.key = k;
            this.val = v;
            this.index = i2;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.val;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            if (d.this.cql[this.index] != this.val) {
                throw new ConcurrentModificationException();
            }
            d.this.cql[this.index] = v;
            V v2 = this.val;
            this.val = v;
            return v2;
        }
    }
}
