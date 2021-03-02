package com.c.a.a.b;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public final class j {
    private static com.c.a.a.a.d cor = new com.c.a.a.a.d(f.con, "=", (byte) 0);

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* access modifiers changed from: package-private */
    public static abstract class a extends Enum<a> implements com.c.a.a.a.b<Map.Entry<?, ?>, Object> {
        public static final a cos = new a("KEY") {
            /* class com.c.a.a.b.j.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.c.a.a.a.b
            public final /* synthetic */ Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        };
        public static final a cot = new a("VALUE") {
            /* class com.c.a.a.b.j.a.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.c.a.a.a.b
            public final /* synthetic */ Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        };

        private a(String str, int i2) {
        }

        /* synthetic */ a(String str, int i2, byte b2) {
            this(str, i2);
        }

        static {
            a[] aVarArr = {cos, cot};
        }
    }

    public static <K, V> HashMap<K, V> JX() {
        return new HashMap<>();
    }

    public static int hp(int i2) {
        if (i2 < 3) {
            if (i2 >= 0) {
                return i2 + 1;
            }
            throw new IllegalArgumentException("expectedSize" + " cannot be negative but was: " + i2);
        } else if (i2 < 1073741824) {
            return (i2 / 3) + i2;
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> Map.Entry<K, V> u(@Nullable K k, @Nullable V v) {
        return new g(k, v);
    }

    /* access modifiers changed from: package-private */
    public static abstract class c<K, V> extends AbstractMap<K, V> {
        private transient Set<K> coi;
        private transient Collection<V> coj;
        private transient Set<Map.Entry<K, V>> cou;

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> JM();

        c() {
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.cou;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> JM = JM();
            this.cou = JM;
            return JM;
        }

        @Override // java.util.AbstractMap, java.util.Map
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
            return new d(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.coj;
            if (collection != null) {
                return collection;
            }
            e eVar = new e(this);
            this.coj = eVar;
            return eVar;
        }
    }

    static <V> V a(Map<?, V> map, @Nullable Object obj) {
        com.c.a.a.a.a.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return null;
        }
    }

    static boolean b(Map<?, ?> map, Object obj) {
        com.c.a.a.a.a.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return false;
        }
    }

    static <V> V c(Map<?, V> map, Object obj) {
        com.c.a.a.a.a.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException e2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static class d<K, V> extends o<K> {
        final Map<K, V> map;

        d(Map<K, V> map2) {
            this.map = (Map) com.c.a.a.a.a.checkNotNull(map2);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            this.map.remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<K> iterator() {
            return j.b(this.map.entrySet().iterator());
        }

        public int size() {
            return this.map.size();
        }

        public boolean isEmpty() {
            return this.map.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        public void clear() {
            this.map.clear();
        }
    }

    static class e<K, V> extends AbstractCollection<V> {
        private Map<K, V> map;

        e(Map<K, V> map2) {
            this.map = (Map) com.c.a.a.a.a.checkNotNull(map2);
        }

        public final boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException e2) {
                for (Map.Entry<K, V> entry : this.map.entrySet()) {
                    if (com.c.a.a.a.a.equal(obj, entry.getValue())) {
                        this.map.remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.c.a.a.a.a.checkNotNull(collection));
            } catch (UnsupportedOperationException e2) {
                HashSet hashSet = new HashSet();
                for (Map.Entry<K, V> entry : this.map.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.map.keySet().removeAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.c.a.a.a.a.checkNotNull(collection));
            } catch (UnsupportedOperationException e2) {
                HashSet hashSet = new HashSet();
                for (Map.Entry<K, V> entry : this.map.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return this.map.keySet().retainAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator<V> iterator() {
            return j.c(this.map.entrySet().iterator());
        }

        public final int size() {
            return this.map.size();
        }

        public final boolean isEmpty() {
            return this.map.isEmpty();
        }

        public final boolean contains(@Nullable Object obj) {
            return this.map.containsValue(obj);
        }

        public final void clear() {
            this.map.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public static abstract class b<K, V> extends o<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract Map<K, V> JN();

        b() {
        }

        public int size() {
            return JN().size();
        }

        public void clear() {
            JN().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object a2 = j.a(JN(), key);
            if (!com.c.a.a.a.a.equal(a2, entry.getValue())) {
                return false;
            }
            if (a2 != null || JN().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return JN().isEmpty();
        }

        public boolean remove(Object obj) {
            if (contains(obj)) {
                return JN().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.AbstractSet, java.util.Set, com.c.a.a.b.o
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) com.c.a.a.a.a.checkNotNull(collection));
            } catch (UnsupportedOperationException e2) {
                return com.c.a.a.a.a.a(this, collection.iterator());
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, com.c.a.a.b.o
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) com.c.a.a.a.a.checkNotNull(collection));
            } catch (UnsupportedOperationException e2) {
                HashSet hashSet = new HashSet(j.hp(collection.size()));
                for (Object obj : collection) {
                    if (contains(obj)) {
                        hashSet.add(((Map.Entry) obj).getKey());
                    }
                }
                return JN().keySet().retainAll(hashSet);
            }
        }
    }

    static <K, V> Iterator<K> b(Iterator<Map.Entry<K, V>> it) {
        return h.a(it, a.cos);
    }

    static <K, V> Iterator<V> c(Iterator<Map.Entry<K, V>> it) {
        return h.a(it, a.cot);
    }
}
