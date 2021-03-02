package android.arch.a.b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class b<K, V> implements Iterable<Map.Entry<K, V>> {
    public c<K, V> bQ;
    public c<K, V> bR;
    public WeakHashMap<f<K, V>, Boolean> bS = new WeakHashMap<>();
    public int mSize = 0;

    /* access modifiers changed from: package-private */
    public interface f<K, V> {
        void c(c<K, V> cVar);
    }

    /* access modifiers changed from: protected */
    public c<K, V> d(K k) {
        c<K, V> cVar = this.bQ;
        while (cVar != null && !cVar.bT.equals(k)) {
            cVar = cVar.bU;
        }
        return cVar;
    }

    public V putIfAbsent(K k, V v) {
        c<K, V> d2 = d(k);
        if (d2 != null) {
            return d2.mValue;
        }
        a(k, v);
        return null;
    }

    /* access modifiers changed from: protected */
    public final c<K, V> a(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.mSize++;
        if (this.bR == null) {
            this.bQ = cVar;
            this.bR = this.bQ;
        } else {
            this.bR.bU = cVar;
            cVar.bV = this.bR;
            this.bR = cVar;
        }
        return cVar;
    }

    public V remove(K k) {
        c<K, V> d2 = d(k);
        if (d2 == null) {
            return null;
        }
        this.mSize--;
        if (!this.bS.isEmpty()) {
            for (f<K, V> fVar : this.bS.keySet()) {
                fVar.c(d2);
            }
        }
        if (d2.bV != null) {
            d2.bV.bU = d2.bU;
        } else {
            this.bQ = d2.bU;
        }
        if (d2.bU != null) {
            d2.bU.bV = d2.bV;
        } else {
            this.bR = d2.bV;
        }
        d2.bU = null;
        d2.bV = null;
        return d2.mValue;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.bQ, this.bR);
        this.bS.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public final b<K, V>.d V() {
        b<K, V>.d dVar = new d(this, (byte) 0);
        this.bS.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.mSize != bVar.mSize) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return !it.hasNext() && !it2.hasNext();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {
        c<K, V> bU;
        c<K, V> bZ;

        /* access modifiers changed from: package-private */
        public abstract c<K, V> a(c<K, V> cVar);

        /* access modifiers changed from: package-private */
        public abstract c<K, V> b(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.bZ = cVar2;
            this.bU = cVar;
        }

        public boolean hasNext() {
            return this.bU != null;
        }

        @Override // android.arch.a.b.b.f
        public final void c(c<K, V> cVar) {
            if (this.bZ == cVar && cVar == this.bU) {
                this.bU = null;
                this.bZ = null;
            }
            if (this.bZ == cVar) {
                this.bZ = b(this.bZ);
            }
            if (this.bU == cVar) {
                this.bU = W();
            }
        }

        private c<K, V> W() {
            if (this.bU == this.bZ || this.bZ == null) {
                return null;
            }
            return a(this.bU);
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            c<K, V> cVar = this.bU;
            this.bU = W();
            return cVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.a.b.b.e
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.bU;
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.a.b.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.bV;
        }
    }

    /* renamed from: android.arch.a.b.b$b  reason: collision with other inner class name */
    public static class C0001b<K, V> extends e<K, V> {
        public C0001b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.a.b.b.e
        public final c<K, V> a(c<K, V> cVar) {
            return cVar.bV;
        }

        /* access modifiers changed from: package-private */
        @Override // android.arch.a.b.b.e
        public final c<K, V> b(c<K, V> cVar) {
            return cVar.bU;
        }
    }

    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {
        private c<K, V> bW;
        private boolean bX;

        private d() {
            this.bX = true;
        }

        /* synthetic */ d(b bVar, byte b2) {
            this();
        }

        @Override // android.arch.a.b.b.f
        public final void c(c<K, V> cVar) {
            if (cVar == this.bW) {
                this.bW = this.bW.bV;
                this.bX = this.bW == null;
            }
        }

        public final boolean hasNext() {
            return this.bX ? b.this.bQ != null : (this.bW == null || this.bW.bU == null) ? false : true;
        }

        @Override // java.util.Iterator
        public final /* synthetic */ Object next() {
            c<K, V> cVar;
            d dVar;
            if (this.bX) {
                this.bX = false;
                cVar = b.this.bQ;
                dVar = this;
            } else if (this.bW != null) {
                cVar = this.bW.bU;
                dVar = this;
            } else {
                cVar = null;
                dVar = this;
            }
            dVar.bW = cVar;
            return this.bW;
        }
    }

    public static class c<K, V> implements Map.Entry<K, V> {
        final K bT;
        c<K, V> bU;
        public c<K, V> bV;
        final V mValue;

        c(K k, V v) {
            this.bT = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.bT;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.mValue;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            return ((Object) this.bT) + "=" + ((Object) this.mValue);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.bT.equals(cVar.bT) && this.mValue.equals(cVar.mValue);
        }
    }
}
