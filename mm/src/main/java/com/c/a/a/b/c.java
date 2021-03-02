package com.c.a.a.b;

import com.c.a.a.a.a;
import java.util.Map;
import javax.annotation.Nullable;

abstract class c<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    c() {
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!a.equal(getKey(), entry.getKey()) || !a.equal(getValue(), entry.getValue())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i2 = 0;
        K key = getKey();
        V value = getValue();
        int hashCode = key == null ? 0 : key.hashCode();
        if (value != null) {
            i2 = value.hashCode();
        }
        return i2 ^ hashCode;
    }

    public String toString() {
        return ((Object) getKey()) + "=" + ((Object) getValue());
    }
}
