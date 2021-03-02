package com.c.a.a.b;

import com.c.a.a.b.j;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public abstract class d<K, V> implements k<K, V> {
    private transient Collection<Map.Entry<K, V>> coh;
    private transient Set<K> coi;
    private transient Collection<V> coj;
    private transient Map<K, Collection<V>> cok;

    /* access modifiers changed from: package-private */
    public abstract Iterator<Map.Entry<K, V>> JK();

    /* access modifiers changed from: package-private */
    public abstract Map<K, Collection<V>> JL();

    d() {
    }

    public boolean containsValue(@Nullable Object obj) {
        for (Collection<V> collection : JF().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.c.a.a.b.k
    public boolean t(@Nullable Object obj, @Nullable Object obj2) {
        Collection<V> collection = JF().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @Override // com.c.a.a.b.k
    public boolean remove(@Nullable Object obj, @Nullable Object obj2) {
        Collection<V> collection = JF().get(obj);
        return collection != null && collection.remove(obj2);
    }

    @Override // com.c.a.a.b.k
    public boolean r(@Nullable K k, @Nullable V v) {
        return az(k).add(v);
    }

    public Collection<Map.Entry<K, V>> JJ() {
        Collection<Map.Entry<K, V>> collection = this.coh;
        if (collection == null) {
            if (this instanceof n) {
                collection = new b(this, (byte) 0);
            } else {
                collection = new a(this, (byte) 0);
            }
            this.coh = collection;
        }
        return collection;
    }

    /* access modifiers changed from: package-private */
    public class a extends l<K, V> {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        @Override // com.c.a.a.b.l
        public final k<K, V> JU() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return d.this.JK();
        }
    }

    /* access modifiers changed from: package-private */
    public class b extends d<K, V>.Entries implements Set<Map.Entry<K, V>> {
        private b(d dVar) {
            super(dVar, (byte) 0);
        }

        /* synthetic */ b(d dVar, byte b2) {
            this(dVar);
        }

        public final int hashCode() {
            int i2 = 0;
            for (Object obj : this) {
                i2 = ((i2 + (obj != null ? obj.hashCode() : 0)) ^ -1) ^ -1;
            }
            return i2;
        }

        public final boolean equals(@Nullable Object obj) {
            return com.c.a.a.a.a.b(this, obj);
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.coi;
        if (set != null) {
            return set;
        }
        Set<K> JH = JH();
        this.coi = JH;
        return JH;
    }

    /* access modifiers changed from: package-private */
    public Set<K> JH() {
        return new j.d(JF());
    }

    @Override // com.c.a.a.b.k
    public Collection<V> values() {
        Collection<V> collection = this.coj;
        if (collection != null) {
            return collection;
        }
        c cVar = new c();
        this.coj = cVar;
        return cVar;
    }

    /* access modifiers changed from: package-private */
    public class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return d.this.JI();
        }

        public final int size() {
            return d.this.size();
        }

        public final boolean contains(@Nullable Object obj) {
            return d.this.containsValue(obj);
        }

        public final void clear() {
            d.this.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> JI() {
        return j.c(JJ().iterator());
    }

    @Override // com.c.a.a.b.k
    public Map<K, Collection<V>> JF() {
        Map<K, Collection<V>> map = this.cok;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> JL = JL();
        this.cok = JL;
        return JL;
    }

    public int hashCode() {
        return JF().hashCode();
    }

    public String toString() {
        return JF().toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            return JF().equals(((k) obj).JF());
        }
        return false;
    }
}
