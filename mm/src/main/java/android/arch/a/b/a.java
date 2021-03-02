package android.arch.a.b;

import android.arch.a.b.b;
import java.util.HashMap;

public final class a<K, V> extends b<K, V> {
    public HashMap<K, b.c<K, V>> bP = new HashMap<>();

    /* access modifiers changed from: protected */
    @Override // android.arch.a.b.b
    public final b.c<K, V> d(K k) {
        return this.bP.get(k);
    }

    @Override // android.arch.a.b.b
    public final V putIfAbsent(K k, V v) {
        b.c<K, V> d2 = d(k);
        if (d2 != null) {
            return d2.mValue;
        }
        this.bP.put(k, a(k, v));
        return null;
    }

    @Override // android.arch.a.b.b
    public final V remove(K k) {
        V v = (V) super.remove(k);
        this.bP.remove(k);
        return v;
    }

    public final boolean contains(K k) {
        return this.bP.containsKey(k);
    }
}
