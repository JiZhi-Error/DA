package com.c.a.a.b;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

abstract class a<K, V> extends b<K, V> implements i<K, V> {
    /* access modifiers changed from: package-private */
    /* renamed from: JE */
    public abstract List<V> JG();

    protected a(Map<K, Collection<V>> map) {
        super(map);
    }

    /* renamed from: ay */
    public List<V> az(@Nullable K k) {
        return (List) super.az(k);
    }

    @Override // com.c.a.a.b.k, com.c.a.a.b.d, com.c.a.a.b.b
    public boolean r(@Nullable K k, @Nullable V v) {
        return super.r(k, v);
    }

    @Override // com.c.a.a.b.k, com.c.a.a.b.d
    public Map<K, Collection<V>> JF() {
        return super.JF();
    }

    @Override // com.c.a.a.b.d
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}
