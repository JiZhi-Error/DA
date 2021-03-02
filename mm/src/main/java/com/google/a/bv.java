package com.google.a;

import com.google.a.x;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* access modifiers changed from: package-private */
public class bv<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    boolean bUC;
    private final int bZc;
    private List<bv<K, V>.b> bZd;
    private Map<K, V> bZe;
    private volatile bv<K, V>.d bZf;
    private Map<K, V> bZg;

    /* synthetic */ bv(int i2, byte b2) {
        this(i2);
    }

    static <FieldDescriptorType extends x.a<FieldDescriptorType>> bv<FieldDescriptorType, Object> gL(int i2) {
        return new bv<FieldDescriptorType, Object>(i2) {
            /* class com.google.a.bv.AnonymousClass1 */

            @Override // java.util.AbstractMap, com.google.a.bv, java.util.Map
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                return bv.super.put((x.a) obj, obj2);
            }

            @Override // com.google.a.bv
            public final void yK() {
                if (!this.bUC) {
                    for (int i2 = 0; i2 < Hx(); i2++) {
                        Map.Entry<K, V> gM = gM(i2);
                        if (((x.a) gM.getKey()).FJ()) {
                            gM.setValue((V) Collections.unmodifiableList(gM.getValue()));
                        }
                    }
                    for (Map.Entry<K, V> entry : Hy()) {
                        if (((x.a) entry.getKey()).FJ()) {
                            entry.setValue((V) Collections.unmodifiableList(entry.getValue()));
                        }
                    }
                }
                bv.super.yK();
            }
        };
    }

    private bv(int i2) {
        this.bZc = i2;
        this.bZd = Collections.emptyList();
        this.bZe = Collections.emptyMap();
        this.bZg = Collections.emptyMap();
    }

    public void yK() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.bUC) {
            if (this.bZe.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.bZe);
            }
            this.bZe = unmodifiableMap;
            if (this.bZg.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.bZg);
            }
            this.bZg = unmodifiableMap2;
            this.bUC = true;
        }
    }

    public final int Hx() {
        return this.bZd.size();
    }

    public final Map.Entry<K, V> gM(int i2) {
        return this.bZd.get(i2);
    }

    public final Iterable<Map.Entry<K, V>> Hy() {
        if (this.bZe.isEmpty()) {
            return a.HC();
        }
        return this.bZe.entrySet();
    }

    public int size() {
        return this.bZd.size() + this.bZe.size();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.a.bv<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.bZe.containsKey(comparable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.a.bv<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        return a2 >= 0 ? (V) this.bZd.get(a2).getValue() : this.bZe.get(comparable);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object, K] */
    /* renamed from: a */
    public final V put(K k, V v) {
        Hz();
        int a2 = a(k);
        if (a2 >= 0) {
            return (V) this.bZd.get(a2).setValue(v);
        }
        HB();
        int i2 = -(a2 + 1);
        if (i2 >= this.bZc) {
            return HA().put(k, v);
        }
        if (this.bZd.size() == this.bZc) {
            bv<K, V>.b remove = this.bZd.remove(this.bZc - 1);
            HA().put(remove.bZj, (V) remove.getValue());
        }
        this.bZd.add(i2, new b(k, v));
        return null;
    }

    public void clear() {
        Hz();
        if (!this.bZd.isEmpty()) {
            this.bZd.clear();
        }
        if (!this.bZe.isEmpty()) {
            this.bZe.clear();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.a.bv<K extends java.lang.Comparable<K>, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Hz();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return (V) gN(a2);
        }
        if (this.bZe.isEmpty()) {
            return null;
        }
        return this.bZe.remove(comparable);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private V gN(int i2) {
        Hz();
        V v = (V) this.bZd.remove(i2).getValue();
        if (!this.bZe.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = HA().entrySet().iterator();
            this.bZd.add(new b(this, it.next()));
            it.remove();
        }
        return v;
    }

    private int a(K k) {
        int i2 = 0;
        int size = this.bZd.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.bZd.get(size).bZj);
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i3 = size;
        while (i2 <= i3) {
            int i4 = (i2 + i3) / 2;
            int compareTo2 = k.compareTo(this.bZd.get(i4).bZj);
            if (compareTo2 < 0) {
                i3 = i4 - 1;
            } else if (compareTo2 <= 0) {
                return i4;
            } else {
                i2 = i4 + 1;
            }
        }
        return -(i2 + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.bZf == null) {
            this.bZf = new d(this, (byte) 0);
        }
        return this.bZf;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void Hz() {
        if (this.bUC) {
            throw new UnsupportedOperationException();
        }
    }

    private SortedMap<K, V> HA() {
        Hz();
        if (this.bZe.isEmpty() && !(this.bZe instanceof TreeMap)) {
            this.bZe = new TreeMap();
            this.bZg = ((TreeMap) this.bZe).descendingMap();
        }
        return (SortedMap) this.bZe;
    }

    private void HB() {
        Hz();
        if (this.bZd.isEmpty() && !(this.bZd instanceof ArrayList)) {
            this.bZd = new ArrayList(this.bZc);
        }
    }

    /* access modifiers changed from: package-private */
    public class b implements Comparable<bv<K, V>.b>, Map.Entry<K, V> {
        final K bZj;
        private V value;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(bv<K, V>.b bVar) {
            return this.bZj.compareTo(bVar.bZj);
        }

        b(bv bvVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        b(K k, V v) {
            this.bZj = k;
            this.value = v;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            bv.this.Hz();
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return equals(this.bZj, entry.getKey()) && equals(this.value, entry.getValue());
        }

        public final int hashCode() {
            int i2 = 0;
            int hashCode = this.bZj == null ? 0 : this.bZj.hashCode();
            if (this.value != null) {
                i2 = this.value.hashCode();
            }
            return hashCode ^ i2;
        }

        public final String toString() {
            return ((Object) this.bZj) + "=" + ((Object) this.value);
        }

        private static boolean equals(Object obj, Object obj2) {
            if (obj == null) {
                return obj2 == null;
            }
            return obj.equals(obj2);
        }

        @Override // java.util.Map.Entry
        public final /* bridge */ /* synthetic */ Object getKey() {
            return this.bZj;
        }
    }

    /* access modifiers changed from: package-private */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        private d() {
        }

        /* synthetic */ d(bv bvVar, byte b2) {
            this();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.a.bv */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* synthetic */ boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            bv.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c(bv.this, (byte) 0);
        }

        public final int size() {
            return bv.this.size();
        }

        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = bv.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            bv.this.remove(entry.getKey());
            return true;
        }

        public final void clear() {
            bv.this.clear();
        }
    }

    class c implements Iterator<Map.Entry<K, V>> {
        private boolean bZl;
        private Iterator<Map.Entry<K, V>> bZm;
        private int pos;

        private c() {
            this.pos = -1;
        }

        /* synthetic */ c(bv bvVar, byte b2) {
            this();
        }

        public final boolean hasNext() {
            return this.pos + 1 < bv.this.bZd.size() || (!bv.this.bZe.isEmpty() && HE().hasNext());
        }

        public final void remove() {
            if (!this.bZl) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.bZl = false;
            bv.this.Hz();
            if (this.pos < bv.this.bZd.size()) {
                bv bvVar = bv.this;
                int i2 = this.pos;
                this.pos = i2 - 1;
                bvVar.gN(i2);
                return;
            }
            HE().remove();
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.Iterator<java.util.Map$Entry<K, V>>, java.util.Iterator<java.util.Map$Entry<K extends java.lang.Comparable<K>, V>> */
        private Iterator<Map.Entry<K, V>> HE() {
            if (this.bZm == null) {
                this.bZm = bv.this.bZe.entrySet().iterator();
            }
            return (Iterator<Map.Entry<K, V>>) this.bZm;
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            this.bZl = true;
            int i2 = this.pos + 1;
            this.pos = i2;
            if (i2 < bv.this.bZd.size()) {
                return (Map.Entry) bv.this.bZd.get(this.pos);
            }
            return HE().next();
        }
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final Iterator<Object> bZh = new Iterator<Object>() {
            /* class com.google.a.bv.a.AnonymousClass1 */

            public final boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw new NoSuchElementException();
            }

            public final void remove() {
                throw new UnsupportedOperationException();
            }
        };
        private static final Iterable<Object> bZi = new Iterable<Object>() {
            /* class com.google.a.bv.a.AnonymousClass2 */

            @Override // java.lang.Iterable
            public final Iterator<Object> iterator() {
                return a.bZh;
            }
        };

        static <T> Iterable<T> HC() {
            return (Iterable<T>) bZi;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bv)) {
            return super.equals(obj);
        }
        bv bvVar = (bv) obj;
        int size = size();
        if (size != bvVar.size()) {
            return false;
        }
        int Hx = Hx();
        if (Hx != bvVar.Hx()) {
            return entrySet().equals(bvVar.entrySet());
        }
        for (int i2 = 0; i2 < Hx; i2++) {
            if (!gM(i2).equals(bvVar.gM(i2))) {
                return false;
            }
        }
        if (Hx != size) {
            return this.bZe.equals(bvVar.bZe);
        }
        return true;
    }

    public int hashCode() {
        int Hx = Hx();
        int i2 = 0;
        for (int i3 = 0; i3 < Hx; i3++) {
            i2 += this.bZd.get(i3).hashCode();
        }
        if (this.bZe.size() > 0) {
            return this.bZe.hashCode() + i2;
        }
        return i2;
    }
}
