package com.c.a.a.b;

import java.io.Serializable;
import javax.annotation.Nullable;

/* access modifiers changed from: package-private */
public final class g<K, V> extends c<K, V> implements Serializable {
    private K key;
    private V value;

    g(@Nullable K k, @Nullable V v) {
        this.key = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry, com.c.a.a.b.c
    @Nullable
    public final K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry, com.c.a.a.b.c
    @Nullable
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry, com.c.a.a.b.c
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
