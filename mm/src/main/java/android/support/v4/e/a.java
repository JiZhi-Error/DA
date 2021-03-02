package android.support.v4.e;

import android.support.v4.e.i;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class a<K, V> extends n<K, V> implements Map<K, V> {
    i<K, V> OD;

    public a() {
    }

    public a(int i2) {
        super(i2);
    }

    public a(n nVar) {
        super(nVar);
    }

    private i<K, V> fr() {
        if (this.OD == null) {
            this.OD = new i<K, V>() {
                /* class android.support.v4.e.a.AnonymousClass1 */

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final int fs() {
                    return a.this.mSize;
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final Object z(int i2, int i3) {
                    return a.this.OO[(i2 << 1) + i3];
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final int E(Object obj) {
                    return a.this.indexOfKey(obj);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final int F(Object obj) {
                    return a.this.indexOfValue(obj);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final Map<K, V> ft() {
                    return a.this;
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final void b(K k, V v) {
                    a.this.put(k, v);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final V a(int i2, V v) {
                    return (V) a.this.setValueAt(i2, v);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final void aG(int i2) {
                    a.this.removeAt(i2);
                }

                /* access modifiers changed from: protected */
                @Override // android.support.v4.e.i
                public final void fu() {
                    a.this.clear();
                }
            };
        }
        return this.OD;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: android.support.v4.e.a<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        i<K, V> fr = fr();
        if (fr.OX == null) {
            fr.OX = new i.b();
        }
        return fr.OX;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return fr().getKeySet();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        i<K, V> fr = fr();
        if (fr.OZ == null) {
            fr.OZ = new i.e();
        }
        return fr.OZ;
    }
}
